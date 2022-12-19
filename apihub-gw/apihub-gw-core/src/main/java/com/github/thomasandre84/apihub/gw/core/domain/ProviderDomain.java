package com.github.thomasandre84.apihub.gw.core.domain;

import lombok.Data;

import java.net.URL;
import java.util.UUID;

@Data
public class ProviderDomain {

    private UUID id;

    private String providerId;

    private URL baseUrl;

    private URL authUrl;
}
