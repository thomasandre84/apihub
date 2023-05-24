package com.github.thomasandre84.apihub.gw.persistence.repository;

import com.github.thomasandre84.apihub.gw.persistence.model.Consent;
import io.quarkus.hibernate.reactive.panache.PanacheRepositoryBase;
import io.quarkus.panache.common.Parameters;
import io.smallrye.mutiny.Multi;

import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class ConsentPanacheRepository implements PanacheRepositoryBase<Consent, UUID> {


    public Uni<List<Consent>> findByProviderIdAndUserId(String providerId, UUID userId) {
        return find("provider.providerId = :providerId and userId = :userId",
                Parameters.with("providerId", providerId).and("userId", userId.toString()))
                .list();
    }
}
