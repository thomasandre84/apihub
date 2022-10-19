package com.github.thomasandre84.apihub.gw.core.domain;

import lombok.Data;

import java.net.URL;

@Data
public class ProviderDomain {

    private String id;

    private URL baseUrl;

    private URL authUrl;
}
