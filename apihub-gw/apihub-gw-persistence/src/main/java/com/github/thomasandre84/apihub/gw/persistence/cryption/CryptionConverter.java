package com.github.thomasandre84.apihub.gw.persistence.cryption;

import jakarta.enterprise.inject.spi.Bean;
import jakarta.enterprise.inject.spi.BeanManager;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import java.security.GeneralSecurityException;

@Converter
public class CryptionConverter implements AttributeConverter<String, String> {

    private static final String AAD = null;
    @Override
    public String convertToDatabaseColumn(String s) {
        try {
            return getCrypticService().encrypt(s, AAD);
        } catch (GeneralSecurityException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String convertToEntityAttribute(String s) {
        try {
            return getCrypticService().decrypt(s, AAD);
        } catch (GeneralSecurityException e) {
            throw new RuntimeException(e);
        }
    }

    private static CryptionService getCrypticService() {
        final BeanManager bm = ContextHelper.getBeanManager();
        final Bean<?> bean = bm.resolve(bm.getBeans(CryptionService.class ));
        return (CryptionService) bm.getReference(
                bean, CryptionService.class, bm.createCreationalContext(bean)
            );
    }

}
