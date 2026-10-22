package com.google.crypto.tink.subtle;

import com.google.crypto.tink.config.internal.TinkFipsUtil;
import java.security.GeneralSecurityException;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes4.dex */
public final class AesCtrJceCipher implements IndCpaCipher {
    private static final String CIPHER_ALGORITHM = "AES/CTR/NoPadding";
    public static final TinkFipsUtil.AlgorithmFipsCompatibility FIPS = null;
    private static final String KEY_ALGORITHM = "AES";
    private static final int MIN_IV_SIZE_IN_BYTES = 12;
    private static final ThreadLocal<Cipher> localCipher = null;
    private final int blockSize;
    private final int ivSize;
    private final SecretKeySpec keySpec;

    static {
        FIPS = TinkFipsUtil.AlgorithmFipsCompatibility.ALGORITHM_REQUIRES_BORINGCRYPTO;
        localCipher = new AnonymousClass1();
    }

    public AesCtrJceCipher(final byte[] key, int ivSize) throws GeneralSecurityException {
        if (FIPS.isCompatible() == false) goto L12;
        Validators.validateAesKeySize(key.length);
        this.keySpec = new SecretKeySpec(key, KEY_ALGORITHM);
        int r3 = localCipher.get().getBlockSize();
        this.blockSize = r3;
        if (ivSize < 12) goto L10;
        if (ivSize > r3) goto L10;
        this.ivSize = ivSize;
        return;
    L10:
        throw new GeneralSecurityException("invalid IV size");
    L12:
        throw new GeneralSecurityException("Can not use AES-CTR in FIPS-mode, as BoringCrypto module is not available.");
    }

    @Override // com.google.crypto.tink.subtle.IndCpaCipher
    public byte[] encrypt(final byte[] plaintext) throws GeneralSecurityException {
        int r0 = plaintext.length;
        int r1 = this.ivSize;
        if (r0 > (Integer.MAX_VALUE - r1)) goto L7;
        byte[] r2 = new byte[plaintext.length + r1];
        byte[] r8 = Random.randBytes(r1);
        System.arraycopy(r8, 0, r2, 0, this.ivSize);
        doCtr(plaintext, 0, plaintext.length, r2, this.ivSize, r8, true);
        return r2;
    L7:
        throw new GeneralSecurityException("plaintext length can not exceed " + (Integer.MAX_VALUE - this.ivSize));
    }

    @Override // com.google.crypto.tink.subtle.IndCpaCipher
    public byte[] decrypt(final byte[] ciphertext) throws GeneralSecurityException {
        int r0 = ciphertext.length;
        int r1 = this.ivSize;
        if (r0 < r1) goto L7;
        byte[] r8 = new byte[r1];
        System.arraycopy(ciphertext, 0, r8, 0, r1);
        int r2 = ciphertext.length;
        int r4 = this.ivSize;
        byte[] r3 = new byte[r2 - r4];
        doCtr(ciphertext, r4, ciphertext.length - r4, r3, 0, r8, false);
        return r3;
    L7:
        throw new GeneralSecurityException("ciphertext too short");
    }

    private void doCtr(final byte[] input, int inputOffset, int inputLen, byte[] output, int outputOffset, final byte[] iv, boolean encrypt) throws GeneralSecurityException {
        Cipher r1 = localCipher.get();
        byte[] r0 = new byte[this.blockSize];
        System.arraycopy(iv, 0, r0, 0, this.ivSize);
        IvParameterSpec r13 = new IvParameterSpec(r0);
        if (encrypt == false) goto L5;
        r1.init(1, this.keySpec, r13);
    L7:
        if (r1.doFinal(input, inputOffset, inputLen, output, outputOffset) != inputLen) goto L10;
        return;
    L10:
        throw new GeneralSecurityException("stored output's length does not match input's length");
    L5:
        r1.init(2, this.keySpec, r13);
        goto L7
    }
}
