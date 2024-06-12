package com.github.thomasandre84.apihub.gw.persistence.mapper;

import com.github.thomasandre84.apihub.gw.core.domain.ClientDomain;
import com.github.thomasandre84.apihub.gw.persistence.model.Client;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.CDI,
        injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface ClientEntityMapper {
    ClientDomain clientToDomain(Client client);
}
