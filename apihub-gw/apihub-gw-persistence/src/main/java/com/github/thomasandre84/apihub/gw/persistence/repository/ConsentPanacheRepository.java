package com.github.thomasandre84.apihub.gw.persistence.repository;

import com.github.thomasandre84.apihub.gw.persistence.model.Consent;
import io.quarkus.hibernate.reactive.panache.PanacheRepositoryBase;
import io.smallrye.mutiny.Multi;

import javax.enterprise.context.ApplicationScoped;
import java.util.UUID;

@ApplicationScoped
public class ConsentPanacheRepository implements PanacheRepositoryBase<Consent, UUID> {


    public Multi<Consent> findByProviderIdAndUserId(String providerId, UUID userId) {
        return find("provider.providerId = ?1 and userId = ?2", providerId, userId.toString())
                .stream();
    }
}
