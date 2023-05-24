package com.github.thomasandre84.apihub.gw.persistence.model;

import com.github.thomasandre84.apihub.gw.persistence.cryption.CryptionConverter;
import lombok.Data;

import jakarta.persistence.*;
import java.time.OffsetDateTime;

@Data
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
