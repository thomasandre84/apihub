package com.github.thomasandre84.apihub.gw.api.resource.v1;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
class ConsentResourceTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void getConsents() {
        var provider = "test";
        var userId = UUID.randomUUID().toString();
        given()
                .when().get(ConsentResource.BASE_URL+ "/" + provider + "/" + userId)
                .then()
                .statusCode(200)
                .body(is("[]"));
    }

    @Test
    void getConsent() {
    }

    @Test
    void createConsent() {
    }

    @Test
    void deleteConsent() {
    }
}