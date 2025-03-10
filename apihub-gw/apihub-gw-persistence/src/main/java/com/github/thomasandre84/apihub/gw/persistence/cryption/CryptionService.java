package com.github.thomasandre84.apihub.gw.persistence.cryption;

import com.google.crypto.tink.*;
import com.google.crypto.tink.aead.AeadConfig;

import com.google.crypto.tink.aead.PredefinedAeadParameters;
import jakarta.inject.Inject;
import lombok.extern.slf4j.Slf4j;

import jakarta.enterprise.context.ApplicationScoped;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.GeneralSecurityException;
import java.util.Arrays;

@ApplicationScoped
@Slf4j
public class CryptionService {

    private final Path keyFile = Path.of("keyset.json");

    private final Aead aead;

    @Inject
    public CryptionService() throws GeneralSecurityException {
        AeadConfig.register();
        KeysetHandle keysetHandle = getOrGenKeysetHandle();
        this.aead = keysetHandle.getPrimitive(RegistryConfiguration.get(), Aead.class);
    }

    public String encrypt(String plaintext, String aad) throws GeneralSecurityException {
        return Arrays.toString(aead.encrypt(plaintext.getBytes(StandardCharsets.UTF_8),
                aad.getBytes(StandardCharsets.UTF_8)));
    }

    public String decrypt(String encryptedtext, String aad) throws GeneralSecurityException {
        return Arrays.toString(aead.decrypt(encryptedtext.getBytes(StandardCharsets.UTF_8),
                aad.getBytes(StandardCharsets.UTF_8)));
    }

    private KeysetHandle getOrGenKeysetHandle() {
        try {
            if (keyFile.toFile().exists()) {
                KeysetHandle handle = TinkJsonProtoKeysetFormat.parseKeyset(
                    new String(Files.readAllBytes(keyFile), StandardCharsets.UTF_8), InsecureSecretKeyAccess.get());
                return handle;
            } else {
                KeysetHandle handle = KeysetHandle.generateNew(PredefinedAeadParameters.AES128_GCM);
                String serialized = TinkJsonProtoKeysetFormat.serializeKeyset(handle, InsecureSecretKeyAccess.get());
                Files.write(keyFile, serialized.getBytes(StandardCharsets.UTF_8));
                return handle;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
