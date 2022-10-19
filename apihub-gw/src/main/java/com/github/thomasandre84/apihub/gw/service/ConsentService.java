package com.github.thomasandre84.apihub.gw.service;

import com.github.thomasandre84.apihub.gw.model.ClientApp;
import com.github.thomasandre84.apihub.gw.model.Consent;
import com.github.thomasandre84.apihub.gw.model.ConsentStatus;
import com.github.thomasandre84.apihub.gw.repository.ClientAppRepository;
import com.github.thomasandre84.apihub.gw.repository.ClientRepository;
import com.github.thomasandre84.apihub.gw.repository.ConsentRepository;
import com.github.thomasandre84.apihub.gw.repository.ProviderRepository;
import io.quarkus.hibernate.reactive.panache.common.runtime.ReactiveTransactional;
import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.enterprise.context.ApplicationScoped;
import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@ApplicationScoped
public class ConsentService {

    private final ConsentRepository consentRepository;

    //private final ClientRepository clientRepository;

    private final ClientAppRepository clientAppRepository;

    private final ProviderRepository providerRepository;

    public Multi<Consent> getConsents(String providerId, UUID userId) {
        return consentRepository.findByProviderIdAndUserId(providerId, userId);
    }

    public Uni<Consent> getConsent(UUID id, String providerId, UUID userId) {
        return consentRepository.findById(id)
                .onItem().ifNotNull()
                    .transform(v -> v.getProvider().getId().equals(providerId) ? v : null)
                .onItem().ifNotNull()
                    .transform(v -> v.getClient().getId().equals(userId) ? v : null);
    }

    @ReactiveTransactional
    public Uni<Consent> createConsent(String providerId, String userId, UUID clientApp, String scope) {
        var uniClientApp = clientAppRepository.findById(clientApp);
        var uniProvider = providerRepository.findById(providerId);

        var consent = new Consent();
        consent.setStatus(ConsentStatus.CREATED);
        consent.setScope(scope);
        consent.setUserId(userId);

        return null; //TODO
    }

    @ReactiveTransactional
    public Uni<Void> deleteConsent(UUID id,String providerId, UUID userId) {
        return getConsent(id, providerId, userId)
                .onItem().ifNotNull().invoke(v -> v.setStatus(ConsentStatus.REVOKED))
                .replaceWithVoid();
    }
}
