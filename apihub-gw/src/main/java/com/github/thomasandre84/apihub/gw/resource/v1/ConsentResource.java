package com.github.thomasandre84.apihub.gw.resource.v1;

import com.github.thomasandre84.apihub.gw.resource.v1.dto.ConsentResponseDto;
import com.github.thomasandre84.apihub.gw.resource.v1.mapper.ConsentMapper;
import com.github.thomasandre84.apihub.gw.service.ConsentService;
import io.smallrye.mutiny.Uni;
import lombok.RequiredArgsConstructor;
import org.jboss.resteasy.reactive.RestResponse;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.UUID;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@RequiredArgsConstructor
@Path(ConsentResource.BASE_URL)
public class ConsentResource {
    static final String BASE_URL = "/api/v1/consents";
    private final ConsentService service;
    private final ConsentMapper mapper;

    @GET
    @Path("/{providerId}/{clientAppId}")
    public Uni<RestResponse<List<ConsentResponseDto>>> getConsents(
            @PathParam("providerId") String providerId,
            @PathParam("clientAppId") UUID clientAppId
            ) {
        return service.getConsents(providerId, clientAppId)
                .onItem().transform(mapper::fromConsent)
                .collect().asList()
                .onItem().transform(RestResponse::ok);
    }

    @GET
    @Path("/{providerId}/{clientAppId}/{consentId}")
    public Uni<RestResponse<ConsentResponseDto>> getConsent(
            @PathParam("providerId") String providerId,
            @PathParam("clientAppId") UUID clientAppId,
            @PathParam("consentId") UUID consentId
    ) {
        return service.getConsent(consentId, providerId, clientAppId)
                .onItem().transform(mapper::fromConsent)
                .onItem().transform(RestResponse::ok);
    }

    @POST
    public Uni<RestResponse<ConsentResponseDto>> createConsent() {
        //TODO
        return service.createConsent(null, null, null, null)
                .onItem().transform(mapper::fromConsent)
                .onItem().transform(RestResponse::ok);
    }

    @DELETE
    @Path("/{providerId}/{clientAppId}/{consentId}")
    public Uni<RestResponse<Void>> deleteConsent(
            @PathParam("providerId") String providerId,
            @PathParam("clientAppId") UUID clientAppId,
            @PathParam("consentId") UUID consentId
    ) {
        return service.deleteConsent(consentId, providerId, clientAppId)
                .onItem().transform(v -> RestResponse.noContent());
    }
}
