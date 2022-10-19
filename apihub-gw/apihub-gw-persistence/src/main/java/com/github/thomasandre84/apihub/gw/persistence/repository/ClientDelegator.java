package com.github.thomasandre84.apihub.gw.persistence.repository;

import com.github.thomasandre84.apihub.gw.core.domain.ClientDomain;
import com.github.thomasandre84.apihub.gw.core.repository.ClientRepository;
import io.smallrye.mutiny.Uni;

import javax.enterprise.context.ApplicationScoped;
import java.util.UUID;

@ApplicationScoped
public class ClientDelegator implements ClientRepository {
    @Override
    public Uni<ClientDomain> findById(UUID id) {
        return null;
    }
}
