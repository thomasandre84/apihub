package com.github.thomasandre84.apihub.gw.persistence.cryption;

import com.google.crypto.tink.Aead;
import com.google.crypto.tink.KeyTemplates;
import com.google.crypto.tink.KeysetHandle;
import com.google.crypto.tink.aead.AeadConfig;

import lombok.extern.slf4j.Slf4j;

import jakarta.enterprise.context.ApplicationScoped;
import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
import java.util.Arrays;

@ApplicationScoped
@Slf4j
public class CryptionService {

    private final Aead aead;

    public CryptionService() throws GeneralSecurityException {
        AeadConfig.register();
        KeysetHandle keysetHandle = KeysetHandle.generateNew(
                KeyTemplates.get("AES256_GCM")
        );
        this.aead = keysetHandle.getPrimitive(Aead.class);

    }

    public String encrypt(String plaintext, String aad) throws GeneralSecurityException {
        return Arrays.toString(aead.encrypt(plaintext.getBytes(StandardCharsets.UTF_8),
                aad.getBytes(StandardCharsets.UTF_8)));
    }

    public String decrypt(String encryptedtext, String aad) throws GeneralSecurityException {
        return Arrays.toString(aead.decrypt(encryptedtext.getBytes(StandardCharsets.UTF_8),
                aad.getBytes(StandardCharsets.UTF_8)));
    }

}
