package com.github.thomasandre84.apihub.cryption;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.security.GeneralSecurityException;

import static org.junit.jupiter.api.Assertions.*;

class CryptionUtilTest {

    private static final String AAD = "";
    private CryptionUtil cryptionUtil;


    @BeforeEach
    void setUp() throws GeneralSecurityException {
        cryptionUtil = CryptionUtil.getInstance();
    }


    @Test
    void compare() throws GeneralSecurityException {
        // arrange
        String test = "test";

        // act
        String encrypted = cryptionUtil.encrypt(test, AAD);
        String decrypted = cryptionUtil.decrypt(encrypted, AAD);

        // assert
        assertNotEquals(test, encrypted);
        assertEquals(test, decrypted);

    }
}