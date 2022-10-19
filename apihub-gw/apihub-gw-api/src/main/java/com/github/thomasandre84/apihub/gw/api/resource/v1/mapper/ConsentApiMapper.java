package com.github.thomasandre84.apihub.gw.api.resource.v1.mapper;

import com.github.thomasandre84.apihub.gw.api.resource.v1.dto.ConsentResponseDto;
import com.github.thomasandre84.apihub.gw.core.domain.ConsentDomain;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "cdi")
public interface ConsentApiMapper {

    @Mapping(target = "consentId", source = "id")
    @Mapping(target = "providerId", source = "provider.id")
    ConsentResponseDto fromConsent(ConsentDomain consentDomain);
}
