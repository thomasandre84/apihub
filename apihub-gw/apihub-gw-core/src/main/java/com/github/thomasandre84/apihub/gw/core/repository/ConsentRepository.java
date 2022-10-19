package com.github.thomasandre84.apihub.gw.core.repository;


import com.github.thomasandre84.apihub.gw.core.domain.ConsentDomain;
import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;

import javax.enterprise.context.ApplicationScoped;
import java.util.UUID;

public interface ConsentRepository {
    Multi<ConsentDomain> findByProviderIdAndUserId(String providerId, UUID userId);

    Uni<ConsentDomain> findById(UUID id);

    Uni<Void> save(ConsentDomain consentDomain);
}
