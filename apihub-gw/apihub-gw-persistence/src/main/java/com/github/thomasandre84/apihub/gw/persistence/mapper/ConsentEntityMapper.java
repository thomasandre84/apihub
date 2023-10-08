package com.github.thomasandre84.apihub.gw.persistence.mapper;

import com.github.thomasandre84.apihub.gw.core.domain.ConsentDomain;
import com.github.thomasandre84.apihub.gw.persistence.model.Consent;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.CDI,
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        uses = {ClientAppEntityMapper.class, ClientEntityMapper.class}
)
public interface ConsentEntityMapper {

    ConsentDomain consentToDomain(Consent consent);
}
