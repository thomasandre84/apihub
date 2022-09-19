package com.github.thomasandre84.apihub.gw.resource.v1;

import com.github.thomasandre84.apihub.gw.resource.v1.dto.ConsentResponseDto;
import com.github.thomasandre84.apihub.gw.resource.v1.mapper.ConsentMapper;
import com.github.thomasandre84.apihub.gw.service.ConsentService;
import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;
import lombok.RequiredArgsConstructor;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.UUID;

@RequiredArgsConstructor
@Path(ConsentResource.BASE_URL)
public class ConsentResource {
    static final String BASE_URL = "/api/v1/consents";
    private final ConsentService service;
    private final ConsentMapper mapper;

    @GET
    @Path("/{providerId}/{userId}")
    public Multi<ConsentResponseDto> getConsents(
            @PathParam("providerId") String providerId,
            @PathParam("userId") UUID userId
            ) {
        return service.getConsents(providerId, userId)
                .onItem().transform(mapper::fromConsent);
    }

    @GET
    @Path("/{providerId}/{userId}/{consentId}")
    public Uni<Response> getConsent(
            @PathParam("providerId") String providerId,
            @PathParam("userId") UUID userId,
            @PathParam("consentId") UUID consentId
    ) {
        return service.getConsent(consentId, providerId, userId)
                .onItem().ifNotNull().transform(mapper::fromConsent)
                .onItem().ifNotNull().transform(v -> Response.ok(v).build())
                .onItem().ifNull().continueWith(Response.status(Response.Status.NOT_FOUND).build()); //TODO handle failure
    }

    @POST
    public Uni<String> createConsent() {
        return Uni.createFrom().item("test"); //TODO
    }

    @DELETE
    @Path("/{providerId}/{userId}/{consentId}")
    public Uni<Void> deleteConsent(
            @PathParam("providerId") String providerId,
            @PathParam("userId") UUID userId,
            @PathParam("consentId") UUID consentId
    ) {
        return service.deleteConsent(consentId, providerId, userId)
                .onItem().ifNotNull().transformToUni(v -> Uni.createFrom().voidItem())
                .onItem().ifNull().failWith(Throwable::new); //TODO
    }
}
