package com.github.thomasandre84.apihub.gw.resource.v1.mapper;

import com.github.thomasandre84.apihub.gw.model.Consent;
import com.github.thomasandre84.apihub.gw.resource.v1.dto.ConsentResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "cdi")
public interface ConsentMapper {

    @Mapping(target = "consentId", source = "id")
    @Mapping(target = "providerId", source = "provider.id")
    @Mapping(target = "clientAppId", source = "clientApp.id")
    ConsentResponseDto fromConsent(Consent consent);
}
