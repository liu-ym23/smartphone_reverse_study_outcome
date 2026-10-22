package com.google.crypto.tink;

import java.io.IOException;
import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes4.dex */
public final class LegacyKeysetSerialization {
    public static KeysetHandle parseKeysetWithoutSecret(KeysetReader reader) throws GeneralSecurityException, IOException {
        return KeysetHandle.readNoSecret(reader);
    }

    public static KeysetHandle parseKeyset(KeysetReader reader, SecretKeyAccess access) throws GeneralSecurityException, IOException {
        if (access == null) goto L6;
        return CleartextKeysetHandle.read(reader);
    L6:
        throw new NullPointerException("SecretKeyAccess cannot be null");
    }

    public static KeysetHandle parseEncryptedKeyset(KeysetReader reader, Aead aead, byte[] associatedData) throws GeneralSecurityException, IOException {
        return KeysetHandle.readWithAssociatedData(reader, aead, associatedData);
    }

    public static void serializeKeysetWithoutSecret(KeysetHandle keysetHandle, KeysetWriter writer) throws GeneralSecurityException, IOException {
        keysetHandle.writeNoSecret(writer);
    }

    public static void serializeKeyset(KeysetHandle keysetHandle, KeysetWriter writer, SecretKeyAccess access) throws IOException {
        if (access == null) goto L6;
        CleartextKeysetHandle.write(keysetHandle, writer);
        return;
    L6:
        throw new NullPointerException("SecretKeyAccess cannot be null");
    }

    public static void serializeEncryptedKeyset(KeysetHandle keysetHandle, KeysetWriter writer, Aead aead, byte[] associatedData) throws GeneralSecurityException, IOException {
        keysetHandle.writeWithAssociatedData(writer, aead, associatedData);
    }

    private LegacyKeysetSerialization() {
    }
}
