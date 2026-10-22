package com.google.crypto.tink.aead.subtle;

import com.google.crypto.tink.Aead;
import com.google.crypto.tink.subtle.AesGcmJce;
import com.google.errorprone.annotations.Immutable;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;

/* JADX INFO: loaded from: classes4.dex */
@Immutable
public final class AesGcmFactory implements AeadFactory {
    private final int keySizeInBytes;

    public AesGcmFactory(int keySizeInBytes) throws GeneralSecurityException {
        this.keySizeInBytes = validateAesKeySize(keySizeInBytes);
    }

    @Override // com.google.crypto.tink.aead.subtle.AeadFactory
    public int getKeySizeInBytes() {
        return this.keySizeInBytes;
    }

    @Override // com.google.crypto.tink.aead.subtle.AeadFactory
    public Aead createAead(final byte[] symmetricKey) throws GeneralSecurityException {
        if (symmetricKey.length != getKeySizeInBytes()) goto L7;
        return new AesGcmJce(symmetricKey);
    L7:
        throw new GeneralSecurityException(String.format("Symmetric key has incorrect length; expected %s, but got %s", new Object[]{Integer.valueOf(getKeySizeInBytes()), Integer.valueOf(symmetricKey.length)}));
    }

    private static int validateAesKeySize(int sizeInBytes) throws InvalidAlgorithmParameterException {
        if (sizeInBytes != 16) goto L5;
    L9:
        return sizeInBytes;
    L5:
        if (sizeInBytes == 32) goto L9;
        throw new InvalidAlgorithmParameterException(String.format("Invalid AES key size, expected 16 or 32, but got %d", new Object[]{Integer.valueOf(sizeInBytes)}));
    }
}
