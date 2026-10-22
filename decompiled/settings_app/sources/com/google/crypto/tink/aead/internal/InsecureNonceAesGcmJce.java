package com.google.crypto.tink.aead.internal;

import com.google.crypto.tink.config.internal.TinkFipsUtil;
import com.google.crypto.tink.internal.Util;
import com.google.crypto.tink.subtle.Validators;
import java.security.GeneralSecurityException;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes4.dex */
public final class InsecureNonceAesGcmJce {
    public static final TinkFipsUtil.AlgorithmFipsCompatibility FIPS = null;
    public static final int IV_SIZE_IN_BYTES = 12;
    public static final int TAG_SIZE_IN_BYTES = 16;
    private static final ThreadLocal<Cipher> localCipher = null;
    private final SecretKey keySpec;

    static {
        FIPS = TinkFipsUtil.AlgorithmFipsCompatibility.ALGORITHM_REQUIRES_BORINGCRYPTO;
        localCipher = new AnonymousClass1();
    }

    public static Cipher getThreadLocalCipher() {
        return localCipher.get();
    }

    public InsecureNonceAesGcmJce(final byte[] key) throws GeneralSecurityException {
        if (FIPS.isCompatible() == false) goto L7;
        Validators.validateAesKeySize(key.length);
        this.keySpec = new SecretKeySpec(key, "AES");
        return;
    L7:
        throw new GeneralSecurityException("Can not use AES-GCM in FIPS-mode, as BoringCrypto module is not available.");
    }

    public byte[] encrypt(final byte[] iv, final byte[] plaintext, final byte[] associatedData) throws GeneralSecurityException {
        if (iv.length != 12) goto L16;
        if (plaintext.length > 2147483619) goto L14;
        AlgorithmParameterSpec r4 = getParams(iv);
        ThreadLocal<Cipher> r0 = localCipher;
        r0.get().init(1, this.keySpec, r4);
        if (associatedData == null) goto L12;
        if (associatedData.length == 0) goto L12;
        r0.get().updateAAD(associatedData);
    L12:
        return r0.get().doFinal(plaintext);
    L14:
        throw new GeneralSecurityException("plaintext too long");
    L16:
        throw new GeneralSecurityException("iv is wrong size");
    }

    public byte[] decrypt(final byte[] iv, final byte[] ciphertext, final byte[] associatedData) throws GeneralSecurityException {
        if (iv.length != 12) goto L16;
        if (ciphertext.length < 16) goto L14;
        AlgorithmParameterSpec r4 = getParams(iv);
        ThreadLocal<Cipher> r0 = localCipher;
        r0.get().init(2, this.keySpec, r4);
        if (associatedData == null) goto L12;
        if (associatedData.length == 0) goto L12;
        r0.get().updateAAD(associatedData);
    L12:
        return r0.get().doFinal(ciphertext);
    L14:
        throw new GeneralSecurityException("ciphertext too short");
    L16:
        throw new GeneralSecurityException("iv is wrong size");
    }

    public static AlgorithmParameterSpec getParams(final byte[] iv) throws GeneralSecurityException {
        return getParams(iv, 0, iv.length);
    }

    private static AlgorithmParameterSpec getParams(final byte[] buf, int offset, int len) throws GeneralSecurityException {
        Integer r0 = Util.getAndroidApiLevel();
        if (r0 == null) goto L9;
        if (r0.intValue() > 19) goto L9;
        return new IvParameterSpec(buf, offset, len);
    L9:
        return new GCMParameterSpec(128, buf, offset, len);
    }
}
