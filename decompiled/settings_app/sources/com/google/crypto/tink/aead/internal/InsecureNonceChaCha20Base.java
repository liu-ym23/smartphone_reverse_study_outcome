package com.google.crypto.tink.aead.internal;

import com.google.crypto.tink.subtle.Bytes;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;

/* JADX INFO: loaded from: classes4.dex */
abstract class InsecureNonceChaCha20Base {
    private final int initialCounter;
    int[] key;

    abstract int[] createInitialState(final int[] nonce, int counter);

    abstract int nonceSizeInBytes();

    public InsecureNonceChaCha20Base(final byte[] key, int initialCounter) throws InvalidKeyException {
        if (key.length != 32) goto L7;
        this.key = ChaCha20Util.toIntArray(key);
        this.initialCounter = initialCounter;
        return;
    L7:
        throw new InvalidKeyException("The key length in bytes must be 32.");
    }

    public byte[] encrypt(final byte[] nonce, final byte[] plaintext) throws GeneralSecurityException {
        ByteBuffer r0 = ByteBuffer.allocate(plaintext.length);
        encrypt(r0, nonce, plaintext);
        return r0.array();
    }

    public void encrypt(ByteBuffer output, final byte[] nonce, final byte[] plaintext) throws GeneralSecurityException {
        if (output.remaining() < plaintext.length) goto L7;
        process(nonce, output, ByteBuffer.wrap(plaintext));
        return;
    L7:
        throw new IllegalArgumentException("Given ByteBuffer output is too small");
    }

    public byte[] decrypt(final byte[] nonce, final byte[] ciphertext) throws GeneralSecurityException {
        return decrypt(nonce, ByteBuffer.wrap(ciphertext));
    }

    public byte[] decrypt(final byte[] nonce, ByteBuffer ciphertext) throws GeneralSecurityException {
        ByteBuffer r0 = ByteBuffer.allocate(ciphertext.remaining());
        process(nonce, r0, ciphertext);
        return r0.array();
    }

    private void process(final byte[] nonce, ByteBuffer output, ByteBuffer input) throws GeneralSecurityException {
        if (nonce.length != nonceSizeInBytes()) goto L13;
        int r0 = input.remaining();
        int r1 = (r0 / 64) + 1;
        int r2 = 0;
    L5:
        if (r2 >= r1) goto L11;
        ByteBuffer r3 = chacha20Block(nonce, this.initialCounter + r2);
        if (r2 != (r1 - 1)) goto L9;
        Bytes.xor(output, input, r3, r0 % 64);
    L10:
        r2 = r2 + 1;
        goto L5
    L9:
        Bytes.xor(output, input, r3, 64);
        goto L10
    L11:
        return;
    L13:
        throw new GeneralSecurityException("The nonce length (in bytes) must be " + nonceSizeInBytes());
    }

    ByteBuffer chacha20Block(final byte[] nonce, int counter) {
        int[] r3 = createInitialState(ChaCha20Util.toIntArray(nonce), counter);
        int[] r4 = (int[]) r3.clone();
        ChaCha20Util.shuffleState(r4);
        int r0 = 0;
    L4:
        if (r0 >= r3.length) goto L6;
        r3[r0] = r3[r0] + r4[r0];
        r0 = r0 + 1;
        goto L4
    L6:
        ByteBuffer r5 = ByteBuffer.allocate(64).order(ByteOrder.LITTLE_ENDIAN);
        r5.asIntBuffer().put(r3, 0, 16);
        return r5;
    }
}
