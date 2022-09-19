package com.github.thomasandre84.apihub.gw.service;

import com.github.thomasandre84.apihub.gw.model.Consent;
import com.github.thomasandre84.apihub.gw.model.ConsentStatus;
import com.github.thomasandre84.apihub.gw.repository.ConsentRepository;
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

    public Multi<Consent> getConsents(String providerId, UUID userId) {
        return consentRepository.findByProviderIdAndUserId(providerId, userId);
    }

    public Uni<Consent> getConsent(UUID id, String providerId, UUID userId) {
        return consentRepository.findById(id)
                .onItem().ifNotNull()
                    .transform(v -> v.getProviderId().getId().equals(providerId) ? v : null)
                .onItem().ifNotNull()
                    .transform(v -> v.getUserId().getId().equals(userId) ? v : null);
    }

    @ReactiveTransactional
    public Uni<Consent> createConsent() {
        return null; //TODO
    }

    @ReactiveTransactional
    public Uni<Consent> deleteConsent(UUID id,String providerId, UUID userId) {
        Uni<Consent> consentUni = getConsent(id, providerId, userId);
        return consentUni
                .onItem().ifNotNull().invoke(v -> v.setStatus(ConsentStatus.DELETED));
        //TODO verify if object is saved implicitely
    }
}
