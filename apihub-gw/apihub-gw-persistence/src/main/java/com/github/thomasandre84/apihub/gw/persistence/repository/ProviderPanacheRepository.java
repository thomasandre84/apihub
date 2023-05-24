package com.github.thomasandre84.apihub.gw.persistence.repository;

import com.github.thomasandre84.apihub.gw.persistence.model.Provider;
import io.quarkus.hibernate.reactive.panache.PanacheRepositoryBase;
import io.smallrye.mutiny.Uni;

import jakarta.enterprise.context.ApplicationScoped;
import java.util.UUID;

@ApplicationScoped
public class ProviderPanacheRepository implements PanacheRepositoryBase<Provider, UUID> {
    Uni<Provider> findByProviderId(String providerId) {
        return find("providerId = ?", providerId)
                .firstResult();
    }
}
