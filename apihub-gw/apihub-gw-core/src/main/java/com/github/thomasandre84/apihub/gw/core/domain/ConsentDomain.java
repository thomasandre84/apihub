package com.github.thomasandre84.apihub.gw.core.domain;

import lombok.Data;

import java.time.OffsetDateTime;
import java.util.UUID;

@Data
public class ConsentDomain {

    private UUID id;

    private String scope;

    private ClientDomain client;

    private ProviderDomain provider;

    private ClientAppDomain clientApp;

    private String userId;

    private OffsetDateTime created;

    private OffsetDateTime updated;

    private ConsentStatus status;

    private ProviderTokenDomain providerToken;

}
