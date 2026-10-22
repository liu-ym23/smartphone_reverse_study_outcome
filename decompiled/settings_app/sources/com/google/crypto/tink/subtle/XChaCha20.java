package com.google.crypto.tink.subtle;

import com.google.crypto.tink.aead.internal.InsecureNonceXChaCha20;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
class XChaCha20 implements IndCpaCipher {
    static final int NONCE_LENGTH_IN_BYTES = 24;
    private final InsecureNonceXChaCha20 cipher;

    XChaCha20(byte[] key, int initialCounter) throws InvalidKeyException {
        this.cipher = new InsecureNonceXChaCha20(key, initialCounter);
    }

    @Override // com.google.crypto.tink.subtle.IndCpaCipher
    public byte[] encrypt(final byte[] plaintext) throws GeneralSecurityException {
        ByteBuffer r0 = ByteBuffer.allocate(plaintext.length + 24);
        byte[] r1 = Random.randBytes(24);
        r0.put(r1);
        this.cipher.encrypt(r0, r1, plaintext);
        return r0.array();
    }

    @Override // com.google.crypto.tink.subtle.IndCpaCipher
    public byte[] decrypt(final byte[] ciphertext) throws GeneralSecurityException {
        if (ciphertext.length < 24) goto L7;
        byte[] r0 = Arrays.copyOf(ciphertext, 24);
        ByteBuffer r4 = ByteBuffer.wrap(ciphertext, 24, ciphertext.length - 24);
        return this.cipher.decrypt(r0, r4);
    L7:
        throw new GeneralSecurityException("ciphertext too short");
    }
}
