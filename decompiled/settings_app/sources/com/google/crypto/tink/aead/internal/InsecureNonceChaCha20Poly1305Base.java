package com.google.crypto.tink.aead.internal;

import com.google.crypto.tink.config.internal.TinkFipsUtil;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import javax.crypto.AEADBadTagException;

/* JADX INFO: loaded from: classes4.dex */
abstract class InsecureNonceChaCha20Poly1305Base {
    public static final TinkFipsUtil.AlgorithmFipsCompatibility FIPS = null;
    private final InsecureNonceChaCha20Base chacha20;
    private final InsecureNonceChaCha20Base macKeyChaCha20;

    abstract InsecureNonceChaCha20Base newChaCha20Instance(final byte[] key, int initialCounter) throws InvalidKeyException;

    static {
        FIPS = TinkFipsUtil.AlgorithmFipsCompatibility.ALGORITHM_NOT_FIPS;
    }

    public InsecureNonceChaCha20Poly1305Base(final byte[] key) throws GeneralSecurityException {
        if (FIPS.isCompatible() == false) goto L7;
        this.chacha20 = newChaCha20Instance(key, 1);
        this.macKeyChaCha20 = newChaCha20Instance(key, 0);
        return;
    L7:
        throw new GeneralSecurityException("Can not use ChaCha20Poly1305 in FIPS-mode.");
    }

    public byte[] encrypt(final byte[] nonce, final byte[] plaintext, final byte[] associatedData) throws GeneralSecurityException {
        if (plaintext.length > 2147483631) goto L7;
        ByteBuffer r0 = ByteBuffer.allocate(plaintext.length + 16);
        encrypt(r0, nonce, plaintext, associatedData);
        return r0.array();
    L7:
        throw new GeneralSecurityException("plaintext too long");
    }

    public void encrypt(ByteBuffer output, final byte[] nonce, final byte[] plaintext, final byte[] associatedData) throws GeneralSecurityException {
        if (output.remaining() < (plaintext.length + 16)) goto L10;
        int r0 = output.position();
        this.chacha20.encrypt(output, nonce, plaintext);
        output.position(r0);
        output.limit(output.limit() - 16);
        if (associatedData != null) goto L7;
        associatedData = new byte[0];
    L7:
        byte[] r2 = Poly1305.computeMac(getMacKey(nonce), macDataRfc8439(associatedData, output));
        output.limit(output.limit() + 16);
        output.put(r2);
        return;
    L10:
        throw new IllegalArgumentException("Given ByteBuffer output is too small");
    }

    public byte[] decrypt(final byte[] nonce, final byte[] ciphertext, final byte[] associatedData) throws GeneralSecurityException {
        return decrypt(ByteBuffer.wrap(ciphertext), nonce, associatedData);
    }

    public byte[] decrypt(ByteBuffer ciphertext, final byte[] nonce, final byte[] associatedData) throws GeneralSecurityException {
        if (ciphertext.remaining() < 16) goto L14;
        int r0 = ciphertext.position();
        byte[] r2 = new byte[16];
        ciphertext.position(ciphertext.limit() - 16);
        ciphertext.get(r2);
        ciphertext.position(r0);
        ciphertext.limit(ciphertext.limit() - 16);
        if (associatedData != null) goto L15;
        associatedData = new byte[0];
    L15:
        Poly1305.verifyMac(getMacKey(nonce), macDataRfc8439(associatedData, ciphertext), r2);     // Catch: GeneralSecurityException -> L10
        ciphertext.position(r0);
        return this.chacha20.decrypt(nonce, ciphertext);
    L10:
        e = move-exception;
        throw new AEADBadTagException(e.toString());
    L14:
        throw new GeneralSecurityException("ciphertext too short");
    }

    private byte[] getMacKey(final byte[] nonce) throws GeneralSecurityException {
        ByteBuffer r1 = this.macKeyChaCha20.chacha20Block(nonce, 0);
        byte[] r2 = new byte[32];
        r1.get(r2);
        return r2;
    }

    private static byte[] macDataRfc8439(final byte[] aad, ByteBuffer ciphertext) {
        if ((aad.length % 16) != 0) goto L5;
        int r0 = aad.length;
    L6:
        int r1 = ciphertext.remaining();
        int r2 = r1 % 16;
        if (r2 != 0) goto L9;
        int r3 = r1;
    L10:
        int r4 = r3 + r0;
        ByteBuffer r5 = ByteBuffer.allocate(r4 + 16).order(ByteOrder.LITTLE_ENDIAN);
        r5.put(aad);
        r5.position(r0);
        r5.put(ciphertext);
        r5.position(r4);
        r5.putLong(aad.length);
        r5.putLong(r1);
        return r5.array();
    L9:
        r3 = (r1 + 16) - r2;
        goto L10
    L5:
        r0 = (aad.length + 16) - (aad.length % 16);
        goto L6
    }
}
