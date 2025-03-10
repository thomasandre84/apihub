package com.github.thomasandre84.apihub.cryption;

import com.google.crypto.tink.*;
import com.google.crypto.tink.aead.AeadConfig;
import com.google.crypto.tink.aead.PredefinedAeadParameters;
import lombok.extern.slf4j.Slf4j;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.GeneralSecurityException;
import java.util.Base64;

@Slf4j
public final class CryptionUtil {

    private static CryptionUtil INSTANCE;

    static CryptionUtil getInstance() throws GeneralSecurityException {
        if (INSTANCE == null) {
            INSTANCE = new CryptionUtil();
        }
        return INSTANCE;
    }

    private final Path keyFile = Path.of("/tmp/keyset.json");

    private final Aead aead;


    private CryptionUtil() throws GeneralSecurityException {
        AeadConfig.register();
        KeysetHandle keysetHandle = getOrGenKeysetHandle();
        this.aead = keysetHandle.getPrimitive(RegistryConfiguration.get(), Aead.class);
    }

    public String encrypt(String plaintext, String aad) throws GeneralSecurityException {
        byte[] plainBytes = plaintext.getBytes(StandardCharsets.UTF_8);
        byte[] encryptedBytes = aead.encrypt(plainBytes, aad.getBytes(StandardCharsets.UTF_8));
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }

    public String decrypt(String encryptedText, String aad) throws GeneralSecurityException {
        byte[] encryptedBytes = Base64.getDecoder().decode(encryptedText);
        byte[] plainBytes = aead.decrypt(encryptedBytes, aad.getBytes(StandardCharsets.UTF_8));
        return new String(plainBytes, StandardCharsets.UTF_8);
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
