package com.github.thomasandre84.apihub.gw.persistence.repository;

import com.github.thomasandre84.apihub.gw.persistence.model.ClientApp;
import io.quarkus.hibernate.reactive.panache.PanacheRepositoryBase;

import jakarta.enterprise.context.ApplicationScoped;
import java.util.UUID;

@ApplicationScoped
public class ClientAppPanacheRepository implements PanacheRepositoryBase<ClientApp, UUID> {
}
