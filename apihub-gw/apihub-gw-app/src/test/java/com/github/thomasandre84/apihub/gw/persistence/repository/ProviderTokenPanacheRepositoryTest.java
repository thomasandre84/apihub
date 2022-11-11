package com.github.thomasandre84.apihub.gw.persistence.repository;

import com.github.thomasandre84.apihub.gw.persistence.cryption.CryptionService;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import java.util.UUID;

@QuarkusTest
public class ProviderTokenPanacheRepositoryTest {

    final String accessToken = UUID.randomUUID().toString();
    final String refreshToken = UUID.randomUUID().toString();

    @Inject
    CryptionService cryptionService;

    @Inject
    ProviderTokenPanacheRepository providerTokenPanacheRepository;

    @Inject
    io.vertx.mutiny.pgclient.PgPool client;

    @BeforeEach
    void setuo() {

    }

    @Test
    void testStoreAndReceiveCryptedData() {

    }


}
