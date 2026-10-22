package com.google.crypto.tink.hybrid.internal;

import com.google.crypto.tink.aead.internal.InsecureNonceAesGcmJce;
import com.google.errorprone.annotations.Immutable;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;

/* JADX INFO: loaded from: classes4.dex */
@Immutable
final class AesGcmHpkeAead implements HpkeAead {
    private final int keyLength;

    @Override // com.google.crypto.tink.hybrid.internal.HpkeAead
    public int getNonceLength() {
        return 12;
    }

    AesGcmHpkeAead(int keyLength) throws InvalidAlgorithmParameterException {
        if (keyLength != 16) goto L5;
    L9:
        this.keyLength = keyLength;
        return;
    L5:
        if (keyLength == 32) goto L9;
        throw new InvalidAlgorithmParameterException("Unsupported key length: " + keyLength);
    }

    @Override // com.google.crypto.tink.hybrid.internal.HpkeAead
    public byte[] seal(byte[] key, byte[] nonce, byte[] plaintext, byte[] associatedData) throws GeneralSecurityException {
        if (key.length != this.keyLength) goto L7;
        return new InsecureNonceAesGcmJce(key).encrypt(nonce, plaintext, associatedData);
    L7:
        throw new InvalidAlgorithmParameterException("Unexpected key length: " + key.length);
    }

    @Override // com.google.crypto.tink.hybrid.internal.HpkeAead
    public byte[] open(byte[] key, byte[] nonce, byte[] ciphertext, byte[] associatedData) throws GeneralSecurityException {
        if (key.length != this.keyLength) goto L7;
        return new InsecureNonceAesGcmJce(key).decrypt(nonce, ciphertext, associatedData);
    L7:
        throw new InvalidAlgorithmParameterException("Unexpected key length: " + key.length);
    }

    @Override // com.google.crypto.tink.hybrid.internal.HpkeAead
    public byte[] getAeadId() throws GeneralSecurityException {
        int r1 = this.keyLength;
        if (r1 == 16) goto L11;
        if (r1 != 32) goto L9;
        return HpkeUtil.AES_256_GCM_AEAD_ID;
    L9:
        throw new GeneralSecurityException("Could not determine HPKE AEAD ID");
    L11:
        return HpkeUtil.AES_128_GCM_AEAD_ID;
    }

    @Override // com.google.crypto.tink.hybrid.internal.HpkeAead
    public int getKeyLength() {
        return this.keyLength;
    }
}
