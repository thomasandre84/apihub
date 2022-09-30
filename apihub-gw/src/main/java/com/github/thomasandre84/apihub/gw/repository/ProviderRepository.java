package com.github.thomasandre84.apihub.gw.repository;


import com.github.thomasandre84.apihub.gw.model.ClientApp;
import com.github.thomasandre84.apihub.gw.model.Provider;
import io.quarkus.hibernate.reactive.panache.PanacheRepositoryBase;

import javax.enterprise.context.ApplicationScoped;
import java.util.UUID;

@ApplicationScoped
public class ProviderRepository implements PanacheRepositoryBase<Provider, String> {
}
