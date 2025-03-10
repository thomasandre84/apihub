package com.github.thomasandre84.apihub.gw.persistence.repository;

import com.github.thomasandre84.apihub.gw.persistence.cryption.CryptionService;
import com.github.thomasandre84.apihub.gw.persistence.model.ProviderToken;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.vertx.RunOnVertxContext;
import io.quarkus.test.vertx.UniAsserter;

import io.smallrye.mutiny.Uni;
import org.hibernate.reactive.mutiny.Mutiny;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import jakarta.inject.Inject;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

@QuarkusTest
public class ProviderTokenPanacheRepositoryTest {

    final String accessToken = UUID.randomUUID().toString();
    final String refreshToken = UUID.randomUUID().toString();

    @Inject
    CryptionService cryptionService;

    @Inject
    ProviderTokenPanacheRepository providerTokenPanacheRepository;

    @Inject
    Mutiny.SessionFactory sessionFactory;

    @Inject
    io.vertx.mutiny.pgclient.PgPool client;

    @BeforeEach
    void setup() {

    }

    @Disabled
    @Test
    @RunOnVertxContext
    void testStoreAndReceiveCryptedData(UniAsserter asserter) {
        // arrange
        String accessToken = "access";
        OffsetDateTime accessTokenExpiration = OffsetDateTime.of(LocalDateTime.now(), ZoneOffset.MAX);
        String refreshToken = "refresh";
        OffsetDateTime refreshTokenExpiration = OffsetDateTime.of(LocalDateTime.now(), ZoneOffset.MAX);
        String scope = "test";

        ProviderToken token = new ProviderToken(accessToken,
                accessTokenExpiration, refreshToken, refreshTokenExpiration, scope);

        // act
        Uni<ProviderToken> saved = providerTokenPanacheRepository.persist(token);

        // assert
        assertEquals(token, saved.await());
    }


}
