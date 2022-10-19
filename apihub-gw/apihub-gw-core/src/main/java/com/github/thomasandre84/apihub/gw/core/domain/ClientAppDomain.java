package com.github.thomasandre84.apihub.gw.core.domain;

import lombok.Data;

import java.util.UUID;

@Data
public class ClientAppDomain {

    private UUID id;

    private ClientCallbackUrlDomain callbackUrl;
}
