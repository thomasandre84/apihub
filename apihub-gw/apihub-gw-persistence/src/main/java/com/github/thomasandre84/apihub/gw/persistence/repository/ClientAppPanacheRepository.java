package com.github.thomasandre84.apihub.gw.persistence.repository;


import com.github.thomasandre84.apihub.gw.core.domain.ClientAppDomain;
import io.quarkus.hibernate.reactive.panache.PanacheRepositoryBase;

import javax.enterprise.context.ApplicationScoped;
import java.util.UUID;

@ApplicationScoped
public class ClientAppPanacheRepository implements PanacheRepositoryBase<ClientAppDomain, UUID> {
}
