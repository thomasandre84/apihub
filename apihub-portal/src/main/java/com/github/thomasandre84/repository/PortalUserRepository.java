package com.github.thomasandre84.repository;

import com.github.thomasandre84.model.PortalUser;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.UUID;

@ApplicationScoped
public class PortalUserRepository implements PanacheRepositoryBase<PortalUser, UUID> {
}
