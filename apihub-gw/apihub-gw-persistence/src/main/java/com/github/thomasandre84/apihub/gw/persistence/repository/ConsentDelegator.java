package com.github.thomasandre84.apihub.gw.persistence.repository;

import com.github.thomasandre84.apihub.gw.core.domain.ConsentDomain;
import com.github.thomasandre84.apihub.gw.core.repository.ConsentRepository;
import com.github.thomasandre84.apihub.gw.persistence.mapper.ConsentEntityMapper;
import com.github.thomasandre84.apihub.gw.persistence.model.Consent;
import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;
import lombok.RequiredArgsConstructor;

import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;
import java.util.UUID;

import static io.quarkus.hibernate.reactive.panache.PanacheEntity_.id;

@ApplicationScoped
@RequiredArgsConstructor
public class ConsentDelegator implements ConsentRepository {

    private final ConsentPanacheRepository delegate;
    private final ConsentEntityMapper mapper;

    @Override
    public Uni<List<ConsentDomain>> findByProviderIdAndUserId(String providerId, UUID userId) {
        return delegate.findByProviderIdAndUserId(providerId, userId)
                .onItem().transform(this::mapList);
    }

    @Override
    public Uni<ConsentDomain> findById(UUID id){
        return delegate.findById(id)
                .onItem().transform(mapper::consentToDomain);
    }

    @Override
    public Uni<Void> save(ConsentDomain consentDomain) {
        return null;
    }

    private List<ConsentDomain> mapList(List<Consent> consents){
        return consents.stream()
                .map(mapper::consentToDomain)
                .toList();
    }
}
