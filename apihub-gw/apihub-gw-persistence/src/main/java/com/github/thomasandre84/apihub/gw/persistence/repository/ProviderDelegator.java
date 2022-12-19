package com.github.thomasandre84.apihub.gw.persistence.repository;

import com.github.thomasandre84.apihub.gw.core.domain.ProviderDomain;
import com.github.thomasandre84.apihub.gw.core.repository.ProviderRepository;
import com.github.thomasandre84.apihub.gw.persistence.mapper.ProviderEntityMapper;
import io.smallrye.mutiny.Uni;
import lombok.RequiredArgsConstructor;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
@RequiredArgsConstructor
public class ProviderDelegator implements ProviderRepository {

    private final ProviderPanacheRepository delegate;
    private final ProviderEntityMapper mapper;

    @Override
    public Uni<ProviderDomain> findByProviderId(String providerId){
        return delegate.findByProviderId(providerId)
                .onItem().transform(mapper::mapToDomain);
    }
}
