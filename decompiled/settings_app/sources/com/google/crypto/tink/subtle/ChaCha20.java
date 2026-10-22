package com.google.crypto.tink.subtle;

import com.google.crypto.tink.aead.internal.InsecureNonceChaCha20;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
class ChaCha20 implements IndCpaCipher {
    static final int NONCE_LENGTH_IN_BYTES = 12;
    private final InsecureNonceChaCha20 cipher;

    ChaCha20(final byte[] key, int initialCounter) throws InvalidKeyException {
        this.cipher = new InsecureNonceChaCha20(key, initialCounter);
    }

    @Override // com.google.crypto.tink.subtle.IndCpaCipher
    public byte[] encrypt(final byte[] plaintext) throws GeneralSecurityException {
        ByteBuffer r0 = ByteBuffer.allocate(plaintext.length + 12);
        byte[] r1 = Random.randBytes(12);
        r0.put(r1);
        this.cipher.encrypt(r0, r1, plaintext);
        return r0.array();
    }

    @Override // com.google.crypto.tink.subtle.IndCpaCipher
    public byte[] decrypt(final byte[] ciphertext) throws GeneralSecurityException {
        if (ciphertext.length < 12) goto L7;
        byte[] r0 = Arrays.copyOf(ciphertext, 12);
        ByteBuffer r4 = ByteBuffer.wrap(ciphertext, 12, ciphertext.length - 12);
        return this.cipher.decrypt(r0, r4);
    L7:
        throw new GeneralSecurityException("ciphertext too short");
    }
}
