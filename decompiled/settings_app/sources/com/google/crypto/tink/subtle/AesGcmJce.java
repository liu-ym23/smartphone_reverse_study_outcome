package com.google.crypto.tink.subtle;

import com.google.crypto.tink.Aead;
import com.google.crypto.tink.InsecureSecretKeyAccess;
import com.google.crypto.tink.aead.AesGcmKey;
import com.google.crypto.tink.aead.internal.InsecureNonceAesGcmJce;
import com.google.crypto.tink.config.internal.TinkFipsUtil;
import com.google.crypto.tink.internal.Util;
import com.google.errorprone.annotations.Immutable;
import java.security.GeneralSecurityException;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes4.dex */
@Immutable
public final class AesGcmJce implements Aead {
    public static final TinkFipsUtil.AlgorithmFipsCompatibility FIPS = null;
    private static final int IV_SIZE_IN_BYTES = 12;
    private static final int TAG_SIZE_IN_BYTES = 16;
    private final SecretKey keySpec;
    private final byte[] outputPrefix;

    static {
        FIPS = TinkFipsUtil.AlgorithmFipsCompatibility.ALGORITHM_REQUIRES_BORINGCRYPTO;
    }

    private AesGcmJce(final byte[] key, com.google.crypto.tink.util.Bytes outputPrefix) throws GeneralSecurityException {
        if (FIPS.isCompatible() == false) goto L7;
        Validators.validateAesKeySize(key.length);
        this.keySpec = new SecretKeySpec(key, "AES");
        this.outputPrefix = outputPrefix.toByteArray();
        return;
    L7:
        throw new GeneralSecurityException("Can not use AES-GCM in FIPS-mode, as BoringCrypto module is not available.");
    }

    public AesGcmJce(final byte[] key) throws GeneralSecurityException {
        this(key, com.google.crypto.tink.util.Bytes.copyFrom(new byte[0]));
    }

    public static Aead create(AesGcmKey key) throws GeneralSecurityException {
        if (key.getParameters().getIvSizeBytes() != 12) goto L11;
        if (key.getParameters().getTagSizeBytes() != 16) goto L9;
        return new AesGcmJce(key.getKeyBytes().toByteArray(InsecureSecretKeyAccess.get()), key.getOutputPrefix());
    L9:
        throw new GeneralSecurityException("Expected tag Size 16, got " + key.getParameters().getTagSizeBytes());
    L11:
        throw new GeneralSecurityException("Expected IV Size 12, got " + key.getParameters().getIvSizeBytes());
    }

    @Override // com.google.crypto.tink.Aead
    public byte[] encrypt(final byte[] plaintext, final byte[] associatedData) throws GeneralSecurityException {
        if (plaintext == null) goto L18;
        byte[] r1 = Random.randBytes(12);
        AlgorithmParameterSpec r2 = InsecureNonceAesGcmJce.getParams(r1);
        Cipher r3 = InsecureNonceAesGcmJce.getThreadLocalCipher();
        r3.init(1, this.keySpec, r2);
        if (associatedData != null) goto L6;
    L8:
        int r11 = r3.getOutputSize(plaintext.length);
        byte[] r4 = this.outputPrefix;
        if (r11 > ((Integer.MAX_VALUE - r4.length) - 12)) goto L16;
        byte[] r5 = Arrays.copyOf(r4, (r4.length + 12) + r11);
        System.arraycopy(r1, 0, r5, this.outputPrefix.length, 12);
        if (r3.doFinal(plaintext, 0, plaintext.length, r5, this.outputPrefix.length + 12) != r11) goto L14;
        return r5;
    L14:
        throw new GeneralSecurityException("not enough data written");
    L16:
        throw new GeneralSecurityException("plaintext too long");
    L6:
        if (associatedData.length == 0) goto L8;
        r3.updateAAD(associatedData);
        goto L8
    L18:
        throw new NullPointerException("plaintext is null");
    }

    @Override // com.google.crypto.tink.Aead
    public byte[] decrypt(final byte[] ciphertext, final byte[] associatedData) throws GeneralSecurityException {
        if (ciphertext == null) goto L19;
        int r0 = ciphertext.length;
        byte[] r1 = this.outputPrefix;
        if (r0 < ((r1.length + 12) + 16)) goto L17;
        if (Util.isPrefix(r1, ciphertext) == false) goto L15;
        byte[] r2 = new byte[12];
        System.arraycopy(ciphertext, this.outputPrefix.length, r2, 0, 12);
        AlgorithmParameterSpec r3 = InsecureNonceAesGcmJce.getParams(r2);
        Cipher r4 = InsecureNonceAesGcmJce.getThreadLocalCipher();
        r4.init(2, this.keySpec, r3);
        if (associatedData != null) goto L10;
    L12:
        byte[] r5 = this.outputPrefix;
        return r4.doFinal(ciphertext, r5.length + 12, (ciphertext.length - r5.length) - 12);
    L10:
        if (associatedData.length == 0) goto L12;
        r4.updateAAD(associatedData);
        goto L12
    L15:
        throw new GeneralSecurityException("Decryption failed (OutputPrefix mismatch).");
    L17:
        throw new GeneralSecurityException("ciphertext too short");
    L19:
        throw new NullPointerException("ciphertext is null");
    }
}
