package com.github.thomasandre84.apihub.gw.core.domain;

import lombok.Data;

import java.util.UUID;

@Data
public class ClientDomain {

    private UUID id;

    private ClientAppDomain clientAppDomain;
}
