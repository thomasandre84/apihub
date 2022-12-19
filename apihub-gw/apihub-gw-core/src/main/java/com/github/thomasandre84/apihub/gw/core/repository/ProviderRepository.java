package com.github.thomasandre84.apihub.gw.core.repository;


import com.github.thomasandre84.apihub.gw.core.domain.ProviderDomain;
import io.smallrye.mutiny.Uni;

public interface ProviderRepository {
    Uni<ProviderDomain> findByProviderId(String providerId);
}
