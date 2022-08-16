package com.github.thomasandre84.apihub.gw.resource;

import io.smallrye.mutiny.Multi;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path(ConsentResource.BASE_URL)
public class ConsentResource {
    static final String BASE_URL = "/consents";

    @GET
    public Multi<String> getConsents() {
        return Multi.createFrom().items("test", "test2");
    }
}
