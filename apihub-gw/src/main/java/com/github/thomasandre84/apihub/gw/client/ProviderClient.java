package com.github.thomasandre84.apihub.gw.client;

import org.eclipse.microprofile.rest.client.RestClientBuilder;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.net.URI;

public class ProviderClient {
    public void request() {
        RestClientBuilder.newBuilder()
                .baseUri(URI.create("https://stage.code.quarkus.io/api"))
                .build(RestClient.class);
    }
}
