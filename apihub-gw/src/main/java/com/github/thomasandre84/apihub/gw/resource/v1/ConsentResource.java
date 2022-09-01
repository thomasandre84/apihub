package com.github.thomasandre84.apihub.gw.resource.v1;

import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;

import javax.ws.rs.*;
import java.util.UUID;

@Path(ConsentResource.BASE_URL)
public class ConsentResource {
    static final String BASE_URL = "/api/v1/consents";

    @GET
    @Path("/{providerId}/{userId}")
    public Multi<String> getConsents(
            @PathParam("providerId") String providerId,
            @PathParam("userId") UUID userId
            ) {
        return Multi.createFrom().items("test", "test2");
    }

    @GET
    @Path("/{providerId}/{userId}/{consentId}")
    public Uni<String> getConsent(
            @PathParam("providerId") String providerId,
            @PathParam("userId") UUID userId,
            @PathParam("consentId") UUID consentId
    ) {
        return Uni.createFrom().item("Test");
    }

    @POST
    public Uni<String> createConsent() {
        return Uni.createFrom().item("test");
    }

    @DELETE
    public Uni<Void> deleteConsent(
            @PathParam("providerId") String providerId,
            @PathParam("userId") UUID userId,
            @PathParam("consentId") UUID consentId
    ) {
        return Uni.createFrom().voidItem();
    }
}
