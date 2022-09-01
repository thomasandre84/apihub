package com.github.thomasandre84.apihub.gw.service;

import com.github.thomasandre84.apihub.gw.model.Consent;
import com.github.thomasandre84.apihub.gw.repository.ConsentRepository;
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
        return consentRepository.findById(id);

    }
}
