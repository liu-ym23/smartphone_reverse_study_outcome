package com.google.crypto.tink;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes4.dex */
public final class TinkJsonProtoKeysetFormat {
    public static KeysetHandle parseKeyset(String serializedKeyset, SecretKeyAccess access) throws GeneralSecurityException {
        if (access == null) goto L8;
        return CleartextKeysetHandle.read(JsonKeysetReader.withString(serializedKeyset));
    L6:
        throw new GeneralSecurityException("Parse keyset failed");
    L8:
        throw new NullPointerException("SecretKeyAccess cannot be null");
    }

    public static String serializeKeyset(KeysetHandle keysetHandle, SecretKeyAccess access) throws GeneralSecurityException {
        if (access == null) goto L8;
        ByteArrayOutputStream r2 = new ByteArrayOutputStream();     // Catch: IOException -> L5
        CleartextKeysetHandle.write(keysetHandle, JsonKeysetWriter.withOutputStream(r2));     // Catch: IOException -> L5
        return new String(r2.toByteArray(), com.google.crypto.tink.internal.Util.UTF_8);
    L6:
        throw new GeneralSecurityException("Serialize keyset failed");
    L8:
        throw new NullPointerException("SecretKeyAccess cannot be null");
    }

    public static KeysetHandle parseKeysetWithoutSecret(String serializedKeyset) throws GeneralSecurityException {
        return KeysetHandle.readNoSecret(JsonKeysetReader.withString(serializedKeyset));
    L5:
        throw new GeneralSecurityException("Parse keyset failed");
    }

    public static String serializeKeysetWithoutSecret(KeysetHandle keysetHandle) throws GeneralSecurityException {
        ByteArrayOutputStream r0 = new ByteArrayOutputStream();     // Catch: IOException -> L4
        keysetHandle.writeNoSecret(JsonKeysetWriter.withOutputStream(r0));     // Catch: IOException -> L4
        return new String(r0.toByteArray(), com.google.crypto.tink.internal.Util.UTF_8);
    L5:
        throw new GeneralSecurityException("Serialize keyset failed");
    }

    public static KeysetHandle parseEncryptedKeyset(String serializedEncryptedKeyset, Aead keysetEncryptionAead, byte[] associatedData) throws GeneralSecurityException {
        return KeysetHandle.readWithAssociatedData(JsonKeysetReader.withString(serializedEncryptedKeyset), keysetEncryptionAead, associatedData);
    L5:
        throw new GeneralSecurityException("Parse keyset failed");
    }

    public static String serializeEncryptedKeyset(KeysetHandle keysetHandle, Aead keysetEncryptionAead, byte[] associatedData) throws GeneralSecurityException {
        ByteArrayOutputStream r0 = new ByteArrayOutputStream();     // Catch: IOException -> L4
        keysetHandle.writeWithAssociatedData(JsonKeysetWriter.withOutputStream(r0), keysetEncryptionAead, associatedData);     // Catch: IOException -> L4
        return new String(r0.toByteArray(), com.google.crypto.tink.internal.Util.UTF_8);
    L5:
        throw new GeneralSecurityException("Serialize keyset failed");
    }

    private TinkJsonProtoKeysetFormat() {
    }
}
