package com.github.thomasandre84.apihub.gw.persistence.mapper;

import com.github.thomasandre84.apihub.gw.core.domain.ConsentDomain;
import com.github.thomasandre84.apihub.gw.persistence.model.Consent;
import org.mapstruct.Mapper;

@Mapper(componentModel = "cdi")
public interface ConsentEntityMapper {

    ConsentDomain consentToDomain(Consent consent);
}
