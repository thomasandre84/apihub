package com.github.thomasandre84.apihub.gw.resource.v1.mapper;

import com.github.thomasandre84.apihub.gw.model.Consent;
import com.github.thomasandre84.apihub.gw.resource.v1.dto.ConsentResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "cdi")
public interface ConsentMapper {

    @Mappings({
        @Mapping(target = "referenceID", source = "id"),
        @Mapping(target = "providerId", source = "providerId.id"),
        @Mapping(target = "userId", source = "userId.id")
    })
    ConsentResponseDto fromConsent(Consent consent);
}
