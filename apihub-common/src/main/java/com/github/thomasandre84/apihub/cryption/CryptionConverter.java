package com.github.thomasandre84.apihub.cryption;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.security.GeneralSecurityException;

@Converter
public class CryptionConverter implements AttributeConverter<String, String> {

    private static final String AAD = "";

    @Override
    public String convertToDatabaseColumn(String s) {
        try {
            return CryptionUtil.getInstance().encrypt(s, AAD);
        } catch (GeneralSecurityException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String convertToEntityAttribute(String s) {
        try {
            return CryptionUtil.getInstance().decrypt(s, AAD);
        } catch (GeneralSecurityException e) {
            throw new RuntimeException(e);
        }
    }

}
