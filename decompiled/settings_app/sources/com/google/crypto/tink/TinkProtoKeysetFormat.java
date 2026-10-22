package com.google.crypto.tink;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes4.dex */
public final class TinkProtoKeysetFormat {
    public static KeysetHandle parseKeyset(byte[] serializedKeyset, SecretKeyAccess access) throws GeneralSecurityException {
        if (access == null) goto L8;
        return CleartextKeysetHandle.read(BinaryKeysetReader.withBytes(serializedKeyset));
    L6:
        throw new GeneralSecurityException("Parse keyset failed");
    L8:
        throw new NullPointerException("SecretKeyAccess cannot be null");
    }

    public static byte[] serializeKeyset(KeysetHandle keysetHandle, SecretKeyAccess access) throws GeneralSecurityException {
        if (access == null) goto L8;
        ByteArrayOutputStream r2 = new ByteArrayOutputStream();     // Catch: IOException -> L5
        CleartextKeysetHandle.write(keysetHandle, BinaryKeysetWriter.withOutputStream(r2));     // Catch: IOException -> L5
        return r2.toByteArray();
    L6:
        throw new GeneralSecurityException("Serialize keyset failed");
    L8:
        throw new NullPointerException("SecretKeyAccess cannot be null");
    }

    public static KeysetHandle parseKeysetWithoutSecret(byte[] serializedKeyset) throws GeneralSecurityException {
        return KeysetHandle.readNoSecret(serializedKeyset);
    }

    public static byte[] serializeKeysetWithoutSecret(KeysetHandle keysetHandle) throws GeneralSecurityException {
        ByteArrayOutputStream r0 = new ByteArrayOutputStream();     // Catch: IOException -> L4
        keysetHandle.writeNoSecret(BinaryKeysetWriter.withOutputStream(r0));     // Catch: IOException -> L4
        return r0.toByteArray();
    L5:
        throw new GeneralSecurityException("Serialize keyset failed");
    }

    public static KeysetHandle parseEncryptedKeyset(byte[] serializedEncryptedKeyset, Aead keysetEncryptionAead, byte[] associatedData) throws GeneralSecurityException {
        return KeysetHandle.readWithAssociatedData(BinaryKeysetReader.withBytes(serializedEncryptedKeyset), keysetEncryptionAead, associatedData);
    L5:
        throw new GeneralSecurityException("Parse keyset failed");
    }

    public static byte[] serializeEncryptedKeyset(KeysetHandle keysetHandle, Aead keysetEncryptionAead, byte[] associatedData) throws GeneralSecurityException {
        ByteArrayOutputStream r0 = new ByteArrayOutputStream();     // Catch: IOException -> L4
        keysetHandle.writeWithAssociatedData(BinaryKeysetWriter.withOutputStream(r0), keysetEncryptionAead, associatedData);     // Catch: IOException -> L4
        return r0.toByteArray();
    L5:
        throw new GeneralSecurityException("Serialize keyset failed");
    }

    private TinkProtoKeysetFormat() {
    }
}
