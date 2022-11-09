package com.github.thomasandre84.apihub.gw.core.service;

import com.github.thomasandre84.apihub.gw.core.domain.ConsentDomain;
import com.github.thomasandre84.apihub.gw.core.domain.ConsentStatus;
//import io.quarkus.hibernate.reactive.panache.common.runtime.ReactiveTransactional;
import com.github.thomasandre84.apihub.gw.core.repository.ClientAppRepository;
import com.github.thomasandre84.apihub.gw.core.repository.ClientRepository;
import com.github.thomasandre84.apihub.gw.core.repository.ConsentRepository;
import com.github.thomasandre84.apihub.gw.core.repository.ProviderRepository;
import io.quarkus.hibernate.reactive.panache.common.runtime.ReactiveTransactional;
import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityNotFoundException;
import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@ApplicationScoped
public class ConsentService {

    private final ConsentRepository consentRepository;

    private final ClientRepository clientRepository;

    private final ClientAppRepository clientAppRepository;

    private final ProviderRepository providerRepository;

    public Multi<ConsentDomain> getConsents(String providerId, UUID userId) {
        return consentRepository.findByProviderIdAndUserId(providerId, userId);
    }

    public Uni<ConsentDomain> getConsent(UUID id, String providerId, UUID userId) {
        return consentRepository.findById(id)
                .onItem().ifNotNull()
                    .transform(v -> v.getProvider().getId().equals(providerId) ? v : null)
                .onItem().ifNotNull()
                    .transform(v -> v.getClient().getId().equals(userId) ? v : null)
                .onItem().ifNull().failWith(EntityNotFoundException::new);
    }

    @ReactiveTransactional
    public Uni<ConsentDomain> createConsent(String providerId, String userId, UUID clientApp, String scope) {
        var uniClientApp = clientAppRepository.findById(clientApp);
        var uniProvider = providerRepository.findById(providerId);

        var consent = new ConsentDomain();
        consent.setStatus(ConsentStatus.CREATED);
        consent.setScope(scope);
        consent.setUserId(userId);

        return null; //TODO
    }

    @ReactiveTransactional
    public Uni<Void> deleteConsent(UUID id,String providerId, UUID userId) {
        return getConsent(id, providerId, userId)
                .onItem().ifNotNull().invoke(v -> v.setStatus(ConsentStatus.REVOKED))
                .onItem().ifNotNull().invoke(consentRepository::save)
                .replaceWithVoid();
    }

}
