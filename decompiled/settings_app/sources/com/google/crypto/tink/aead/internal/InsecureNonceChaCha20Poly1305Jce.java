package com.google.crypto.tink.aead.internal;

import com.google.crypto.tink.config.internal.TinkFipsUtil;
import com.google.errorprone.annotations.Immutable;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes4.dex */
@Immutable
public final class InsecureNonceChaCha20Poly1305Jce {
    private static final String CIPHER_NAME = "ChaCha20-Poly1305";
    private static final TinkFipsUtil.AlgorithmFipsCompatibility FIPS = null;
    private static final String KEY_NAME = "ChaCha20";
    private static final int KEY_SIZE_IN_BYTES = 32;
    private static final int NONCE_SIZE_IN_BYTES = 12;
    private static final int TAG_SIZE_IN_BYTES = 16;
    private final SecretKey keySpec;

    static {
        FIPS = TinkFipsUtil.AlgorithmFipsCompatibility.ALGORITHM_NOT_FIPS;
    }

    private InsecureNonceChaCha20Poly1305Jce(final byte[] key) throws GeneralSecurityException {
        if (FIPS.isCompatible() == false) goto L15;
        if (isSupported() == false) goto L13;
        if (key.length != 32) goto L11;
        this.keySpec = new SecretKeySpec(key, "ChaCha20");
        return;
    L11:
        throw new InvalidKeyException("The key length in bytes must be 32.");
    L13:
        throw new GeneralSecurityException("JCE does not support algorithm: ChaCha20-Poly1305");
    L15:
        throw new GeneralSecurityException("Can not use ChaCha20Poly1305 in FIPS-mode.");
    }

    public static InsecureNonceChaCha20Poly1305Jce create(final byte[] key) throws GeneralSecurityException {
        return new InsecureNonceChaCha20Poly1305Jce(key);
    }

    public static boolean isSupported() {
        if (ChaCha20Poly1305Jce.getThreadLocalCipherOrNull() == null) goto L5;
        return true;
    L5:
        return false;
    }

    public byte[] encrypt(final byte[] nonce, final byte[] plaintext, final byte[] associatedData) throws GeneralSecurityException {
        if (plaintext == null) goto L15;
        if (nonce.length != 12) goto L13;
        IvParameterSpec r0 = new IvParameterSpec(nonce);
        Cipher r3 = ChaCha20Poly1305Jce.getThreadLocalCipherOrNull();
        r3.init(1, this.keySpec, r0);
        if (associatedData == null) goto L11;
        if (associatedData.length == 0) goto L11;
        r3.updateAAD(associatedData);
    L11:
        return r3.doFinal(plaintext);
    L13:
        throw new GeneralSecurityException("nonce length must be 12 bytes.");
    L15:
        throw new NullPointerException("plaintext is null");
    }

    public byte[] decrypt(final byte[] nonce, final byte[] ciphertext, final byte[] associatedData) throws GeneralSecurityException {
        if (ciphertext == null) goto L19;
        if (nonce.length != 12) goto L17;
        if (ciphertext.length < 16) goto L15;
        IvParameterSpec r0 = new IvParameterSpec(nonce);
        Cipher r3 = ChaCha20Poly1305Jce.getThreadLocalCipherOrNull();
        r3.init(2, this.keySpec, r0);
        if (associatedData == null) goto L13;
        if (associatedData.length == 0) goto L13;
        r3.updateAAD(associatedData);
    L13:
        return r3.doFinal(ciphertext);
    L15:
        throw new GeneralSecurityException("ciphertext too short");
    L17:
        throw new GeneralSecurityException("nonce length must be 12 bytes.");
    L19:
        throw new NullPointerException("ciphertext is null");
    }
}
