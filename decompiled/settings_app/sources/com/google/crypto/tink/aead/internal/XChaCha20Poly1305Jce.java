package com.google.crypto.tink.aead.internal;

import com.google.crypto.tink.Aead;
import com.google.crypto.tink.InsecureSecretKeyAccess;
import com.google.crypto.tink.aead.XChaCha20Poly1305Key;
import com.google.crypto.tink.config.internal.TinkFipsUtil;
import com.google.crypto.tink.internal.Util;
import com.google.crypto.tink.subtle.Random;
import com.google.errorprone.annotations.Immutable;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes4.dex */
@Immutable
public final class XChaCha20Poly1305Jce implements Aead {
    private static final String CIPHER_NAME = "ChaCha20-Poly1305";
    private static final TinkFipsUtil.AlgorithmFipsCompatibility FIPS = null;
    private static final String KEY_NAME = "ChaCha20";
    private static final int KEY_SIZE_IN_BYTES = 32;
    private static final int NONCE_SIZE_IN_BYTES = 24;
    private static final int TAG_SIZE_IN_BYTES = 16;
    private final byte[] key;
    private final byte[] outputPrefix;

    static {
        FIPS = TinkFipsUtil.AlgorithmFipsCompatibility.ALGORITHM_NOT_FIPS;
    }

    private XChaCha20Poly1305Jce(final byte[] key, final byte[] outputPrefix) throws GeneralSecurityException {
        if (FIPS.isCompatible() == false) goto L15;
        if (isSupported() == false) goto L13;
        if (key.length != 32) goto L11;
        this.key = key;
        this.outputPrefix = outputPrefix;
        return;
    L11:
        throw new InvalidKeyException("The key length in bytes must be 32.");
    L13:
        throw new GeneralSecurityException("JCE does not support algorithm: ChaCha20-Poly1305");
    L15:
        throw new GeneralSecurityException("Can not use ChaCha20Poly1305 in FIPS-mode.");
    }

    public static Aead create(XChaCha20Poly1305Key key) throws GeneralSecurityException {
        return new XChaCha20Poly1305Jce(key.getKeyBytes().toByteArray(InsecureSecretKeyAccess.get()), key.getOutputPrefix().toByteArray());
    }

    public static boolean isSupported() {
        if (ChaCha20Poly1305Jce.getThreadLocalCipherOrNull() == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.google.crypto.tink.Aead
    public byte[] encrypt(final byte[] plaintext, final byte[] associatedData) throws GeneralSecurityException {
        if (plaintext == null) goto L18;
        byte[] r1 = Random.randBytes(24);
        SecretKeySpec r3 = new SecretKeySpec(ChaCha20Util.hChaCha20(this.key, r1), "ChaCha20");
        IvParameterSpec r2 = new IvParameterSpec(getChaCha20Nonce(r1));
        Cipher r5 = ChaCha20Poly1305Jce.getThreadLocalCipherOrNull();
        r5.init(1, r3, r2);
        if (associatedData != null) goto L6;
    L8:
        int r13 = r5.getOutputSize(plaintext.length);
        byte[] r4 = this.outputPrefix;
        if (r13 > ((Integer.MAX_VALUE - r4.length) - 24)) goto L16;
        byte[] r6 = Arrays.copyOf(r4, (r4.length + 24) + r13);
        System.arraycopy(r1, 0, r6, this.outputPrefix.length, 24);
        if (r5.doFinal(plaintext, 0, plaintext.length, r6, this.outputPrefix.length + 24) != r13) goto L14;
        return r6;
    L14:
        throw new GeneralSecurityException("not enough data written");
    L16:
        throw new GeneralSecurityException("plaintext too long");
    L6:
        if (associatedData.length == 0) goto L8;
        r5.updateAAD(associatedData);
        goto L8
    L18:
        throw new NullPointerException("plaintext is null");
    }

    @Override // com.google.crypto.tink.Aead
    public byte[] decrypt(final byte[] ciphertext, final byte[] associatedData) throws GeneralSecurityException {
        if (ciphertext == null) goto L19;
        int r0 = ciphertext.length;
        byte[] r1 = this.outputPrefix;
        if (r0 < ((r1.length + 24) + 16)) goto L17;
        if (Util.isPrefix(r1, ciphertext) == false) goto L15;
        byte[] r2 = new byte[24];
        System.arraycopy(ciphertext, this.outputPrefix.length, r2, 0, 24);
        SecretKeySpec r3 = new SecretKeySpec(ChaCha20Util.hChaCha20(this.key, r2), "ChaCha20");
        IvParameterSpec r4 = new IvParameterSpec(getChaCha20Nonce(r2));
        Cipher r5 = ChaCha20Poly1305Jce.getThreadLocalCipherOrNull();
        r5.init(2, r3, r4);
        if (associatedData != null) goto L10;
    L12:
        byte[] r6 = this.outputPrefix;
        return r5.doFinal(ciphertext, r6.length + 24, (ciphertext.length - r6.length) - 24);
    L10:
        if (associatedData.length == 0) goto L12;
        r5.updateAAD(associatedData);
        goto L12
    L15:
        throw new GeneralSecurityException("Decryption failed (OutputPrefix mismatch).");
    L17:
        throw new GeneralSecurityException("ciphertext too short");
    L19:
        throw new NullPointerException("ciphertext is null");
    }

    static byte[] getChaCha20Nonce(byte[] nonce) {
        byte[] r0 = new byte[12];
        System.arraycopy(nonce, 16, r0, 4, 8);
        return r0;
    }
}
