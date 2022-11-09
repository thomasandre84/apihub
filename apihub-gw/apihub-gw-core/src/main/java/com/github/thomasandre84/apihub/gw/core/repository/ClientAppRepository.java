package com.github.thomasandre84.apihub.gw.core.repository;


import com.github.thomasandre84.apihub.gw.core.domain.ClientAppDomain;
import io.smallrye.mutiny.Uni;

import javax.enterprise.context.ApplicationScoped;
import java.util.UUID;

public interface ClientAppRepository {
    Uni<ClientAppDomain> findById(UUID id);
}
