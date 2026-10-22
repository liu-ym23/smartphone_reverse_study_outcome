package com.google.crypto.tink.hybrid.internal;

import com.google.crypto.tink.aead.internal.InsecureNonceChaCha20Poly1305;
import com.google.crypto.tink.aead.internal.InsecureNonceChaCha20Poly1305Jce;
import com.google.errorprone.annotations.Immutable;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;

/* JADX INFO: loaded from: classes4.dex */
@Immutable
final class ChaCha20Poly1305HpkeAead implements HpkeAead {
    @Override // com.google.crypto.tink.hybrid.internal.HpkeAead
    public int getKeyLength() {
        return 32;
    }

    @Override // com.google.crypto.tink.hybrid.internal.HpkeAead
    public int getNonceLength() {
        return 12;
    }

    ChaCha20Poly1305HpkeAead() {
    }

    @Override // com.google.crypto.tink.hybrid.internal.HpkeAead
    public byte[] seal(byte[] key, byte[] nonce, byte[] plaintext, byte[] associatedData) throws GeneralSecurityException {
        if (key.length != getKeyLength()) goto L11;
        if (InsecureNonceChaCha20Poly1305Jce.isSupported() == false) goto L9;
        return InsecureNonceChaCha20Poly1305Jce.create(key).encrypt(nonce, plaintext, associatedData);
    L9:
        return new InsecureNonceChaCha20Poly1305(key).encrypt(nonce, plaintext, associatedData);
    L11:
        throw new InvalidAlgorithmParameterException("Unexpected key length: " + getKeyLength());
    }

    @Override // com.google.crypto.tink.hybrid.internal.HpkeAead
    public byte[] open(byte[] key, byte[] nonce, byte[] ciphertext, byte[] associatedData) throws GeneralSecurityException {
        if (key.length != getKeyLength()) goto L11;
        if (InsecureNonceChaCha20Poly1305Jce.isSupported() == false) goto L9;
        return InsecureNonceChaCha20Poly1305Jce.create(key).decrypt(nonce, ciphertext, associatedData);
    L9:
        return new InsecureNonceChaCha20Poly1305(key).decrypt(nonce, ciphertext, associatedData);
    L11:
        throw new InvalidAlgorithmParameterException("Unexpected key length: " + getKeyLength());
    }

    @Override // com.google.crypto.tink.hybrid.internal.HpkeAead
    public byte[] getAeadId() {
        return HpkeUtil.CHACHA20_POLY1305_AEAD_ID;
    }
}
