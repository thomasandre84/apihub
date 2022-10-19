package com.github.thomasandre84.apihub.gw.core.domain;

import lombok.Data;

import java.net.URI;
import java.util.UUID;

@Data
public class ClientCallbackUrlDomain {

    private UUID id;

    private URI url;
}
