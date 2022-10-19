package com.github.thomasandre84.apihub.gw.core.repository;


import com.github.thomasandre84.apihub.gw.core.domain.ProviderDomain;
import io.smallrye.mutiny.Uni;

import javax.enterprise.context.ApplicationScoped;

public interface ProviderRepository {
    Uni<ProviderDomain> findById(String id);
}
