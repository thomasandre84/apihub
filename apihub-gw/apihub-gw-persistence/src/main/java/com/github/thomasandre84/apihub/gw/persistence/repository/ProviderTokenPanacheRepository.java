package com.github.thomasandre84.apihub.gw.persistence.repository;

import com.github.thomasandre84.apihub.gw.persistence.model.ProviderToken;
import io.quarkus.hibernate.reactive.panache.PanacheRepositoryBase;

import jakarta.enterprise.context.ApplicationScoped;
import java.util.UUID;

@ApplicationScoped
public class ProviderTokenPanacheRepository implements PanacheRepositoryBase<ProviderToken, UUID> {
}
