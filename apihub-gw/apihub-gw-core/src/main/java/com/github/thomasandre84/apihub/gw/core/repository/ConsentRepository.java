package com.github.thomasandre84.apihub.gw.core.repository;

import com.github.thomasandre84.apihub.gw.core.domain.ConsentDomain;
import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;
import java.util.UUID;

@ApplicationScoped
public interface ConsentRepository {
    Uni<List<ConsentDomain>> findByProviderIdAndUserId(String providerId, UUID userId);

    Uni<ConsentDomain> findById(UUID id);

    Uni<Void> save(ConsentDomain consentDomain);
}
