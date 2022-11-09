package com.github.thomasandre84.apihub.gw.core.domain;

import lombok.Data;

import java.time.OffsetDateTime;
import java.util.UUID;

@Data
public class ProviderTokenDomain {

    private UUID id;

    private String accessToken;

    private OffsetDateTime accessTokenExpiration;

    private String refreshToken;

    private OffsetDateTime refreshTokenExpiration;

    private String scope;
}
