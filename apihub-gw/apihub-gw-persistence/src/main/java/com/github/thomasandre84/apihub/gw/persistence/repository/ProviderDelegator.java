package com.github.thomasandre84.apihub.gw.persistence.repository;

import com.github.thomasandre84.apihub.gw.core.domain.ProviderDomain;
import com.github.thomasandre84.apihub.gw.core.repository.ProviderRepository;
import io.smallrye.mutiny.Uni;
import lombok.RequiredArgsConstructor;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
@RequiredArgsConstructor
public class ProviderDelegator implements ProviderRepository {

    private final ProviderPanacheRepository delegate;

    @Override
    public Uni<ProviderDomain> findById(String providerId){
        return delegate.findById(providerId);
    }
}
