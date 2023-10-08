package com.github.thomasandre84.apihub.gw.persistence.repository;

import com.github.thomasandre84.apihub.gw.core.domain.ClientAppDomain;
import com.github.thomasandre84.apihub.gw.core.repository.ClientAppRepository;
import io.smallrye.mutiny.Uni;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Default;

import java.util.UUID;

@ApplicationScoped
@Default
public class ClientAppDelegator implements ClientAppRepository {
    @Override
    public Uni<ClientAppDomain> findById(UUID id) {
        return null;
    }
}
