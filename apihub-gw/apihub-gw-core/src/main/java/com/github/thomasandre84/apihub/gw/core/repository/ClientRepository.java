package com.github.thomasandre84.apihub.gw.core.repository;


import com.github.thomasandre84.apihub.gw.core.domain.ClientDomain;
import io.smallrye.mutiny.Uni;

import java.util.UUID;


public interface ClientRepository {
    Uni<ClientDomain> findById(UUID id);
}
