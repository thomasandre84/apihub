package com.github.thomasandre84.apihub.gw.persistence.model;

import com.github.thomasandre84.apihub.gw.persistence.cryption.CryptionConverter;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;

@Getter
@Setter
@Entity
public class ProviderToken extends BaseEntity {

    @Convert(converter = CryptionConverter.class)
    @Column(length = 8000)
    private String accessToken;

    private OffsetDateTime accessTokenExpiration;

    @Convert(converter = CryptionConverter.class)
    @Column(length = 8000)
    private String refreshToken;

    private OffsetDateTime refreshTokenExpiration;

    private String scope;
}
