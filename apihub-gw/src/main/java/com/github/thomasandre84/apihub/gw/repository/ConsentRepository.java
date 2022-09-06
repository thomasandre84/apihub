package com.github.thomasandre84.apihub.gw.repository;


import com.github.thomasandre84.apihub.gw.model.Consent;
import io.quarkus.hibernate.reactive.panache.PanacheRepositoryBase;
import io.smallrye.mutiny.Multi;

import javax.enterprise.context.ApplicationScoped;
import java.util.UUID;

@ApplicationScoped
public class ConsentRepository implements PanacheRepositoryBase<Consent, UUID> {


    public Multi<Consent> findByProviderIdAndUserId(String providerId, UUID userId) {
        return find("providerId.id = ?1 and userId.id = ?2", providerId, userId)
                .stream();
    }
}
