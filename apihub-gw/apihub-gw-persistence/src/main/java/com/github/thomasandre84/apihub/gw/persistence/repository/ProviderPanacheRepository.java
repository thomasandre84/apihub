package com.github.thomasandre84.apihub.gw.persistence.repository;


import com.github.thomasandre84.apihub.gw.core.domain.ProviderDomain;
import io.quarkus.hibernate.reactive.panache.PanacheRepositoryBase;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ProviderPanacheRepository implements PanacheRepositoryBase<ProviderDomain, String> {
}
