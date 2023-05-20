package com.github.thomasandre84.apihub.gw.api.resource.v1;

import com.github.thomasandre84.apihub.gw.api.resource.v1.dto.ConsentResponseDto;
import com.github.thomasandre84.apihub.gw.api.resource.v1.mapper.ConsentApiMapper;
import com.github.thomasandre84.apihub.gw.core.domain.ConsentDomain;
import com.github.thomasandre84.apihub.gw.core.service.ConsentService;
import io.smallrye.mutiny.Uni;
import lombok.RequiredArgsConstructor;
import org.jboss.resteasy.reactive.RestResponse;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import java.util.List;
import java.util.UUID;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@RequiredArgsConstructor
@Path(ConsentResource.BASE_URL)
public class ConsentResource {
    static final String BASE_URL = "/api/v1/consents";
    private final ConsentService service;
    private final ConsentApiMapper mapper;

    @GET
    @Path("/{providerId}/{userId}")
    public Uni<RestResponse<List<ConsentResponseDto>>> getConsents(
            @PathParam("providerId") String providerId,
            @PathParam("userId") UUID userId
            ) {
        return service.getConsents(providerId, userId)
                .onItem().transform(this::mapList)
                .onItem().transform(RestResponse::ok);
    }

    @GET
    @Path("/{providerId}/{userId}/{consentId}")
    public Uni<RestResponse<ConsentResponseDto>> getConsent(
            @PathParam("providerId") String providerId,
            @PathParam("userId") UUID userId,
            @PathParam("consentId") UUID consentId
    ) {
        return service.getConsent(consentId, providerId, userId)
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
    @Path("/{providerId}/{userId}/{consentId}")
    public Uni<RestResponse<Void>> deleteConsent(
            @PathParam("providerId") String providerId,
            @PathParam("userId") UUID userId,
            @PathParam("consentId") UUID consentId
    ) {
        return service.deleteConsent(consentId, providerId, userId)
                .onItem().transform(v -> RestResponse.noContent());
    }

    private List<ConsentResponseDto> mapList(List<ConsentDomain> consents) {
        return consents.stream()
                .map(mapper::fromConsent)
                .toList();
    }
}
