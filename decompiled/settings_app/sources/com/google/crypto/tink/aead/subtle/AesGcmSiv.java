package com.google.crypto.tink.aead.subtle;

import com.google.crypto.tink.Aead;
import com.google.crypto.tink.InsecureSecretKeyAccess;
import com.google.crypto.tink.aead.AesGcmSivKey;
import com.google.crypto.tink.internal.Util;
import com.google.crypto.tink.subtle.Bytes;
import com.google.crypto.tink.subtle.Hex;
import com.google.crypto.tink.subtle.Random;
import com.google.crypto.tink.subtle.Validators;
import java.security.GeneralSecurityException;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes4.dex */
public final class AesGcmSiv implements Aead {
    private static final int IV_SIZE_IN_BYTES = 12;
    private static final int TAG_SIZE_IN_BYTES = 16;
    private static final byte[] TEST_AAD = null;
    private static final byte[] TEST_KEY = null;
    private static final byte[] TEST_NOUNCE = null;
    private static final byte[] TEST_PLAINTEXT = null;
    private static final byte[] TEST_RESULT = null;
    private static final ThreadLocal<Cipher> localAesGcmSivCipher = null;
    private final SecretKey keySpec;
    private final byte[] outputPrefix;

    static /* synthetic */ boolean access$000(Cipher r0) {
        return isAesGcmSivCipher(r0);
    }

    static {
        TEST_PLAINTEXT = Hex.decode("7a806c");
        TEST_AAD = Hex.decode("46bb91c3c5");
        TEST_KEY = Hex.decode("36864200e0eaf5284d884a0e77d31646");
        TEST_NOUNCE = Hex.decode("bae8e37fc83441b16034566b");
        TEST_RESULT = Hex.decode("af60eb711bd85bc1e4d3e0a462e074eea428a8");
        localAesGcmSivCipher = new AnonymousClass1();
    }

    private static boolean isAesGcmSivCipher(Cipher cipher) {
        AlgorithmParameterSpec r1 = getParams(TEST_NOUNCE);     // Catch: GeneralSecurityException -> L5
        cipher.init(2, new SecretKeySpec(TEST_KEY, "AES"), r1);     // Catch: GeneralSecurityException -> L5
        cipher.updateAAD(TEST_AAD);     // Catch: GeneralSecurityException -> L5
        byte[] r2 = TEST_RESULT;     // Catch: GeneralSecurityException -> L5
        return Bytes.equal(cipher.doFinal(r2, 0, r2.length), TEST_PLAINTEXT);
    L5:
        return false;
    }

    public static Aead create(AesGcmSivKey key) throws GeneralSecurityException {
        return new AesGcmSiv(key.getKeyBytes().toByteArray(InsecureSecretKeyAccess.get()), key.getOutputPrefix().toByteArray());
    }

    private AesGcmSiv(byte[] key, byte[] outputPrefix) throws GeneralSecurityException {
        this.outputPrefix = outputPrefix;
        Validators.validateAesKeySize(key.length);
        this.keySpec = new SecretKeySpec(key, "AES");
    }

    public AesGcmSiv(final byte[] key) throws GeneralSecurityException {
        this(key, new byte[0]);
    }

    private Cipher getAesGcmSivCipher() throws GeneralSecurityException {
        Cipher r1 = localAesGcmSivCipher.get();
        if (r1 == null) goto L6;
        return r1;
    L6:
        throw new GeneralSecurityException("AES GCM SIV cipher is not available or is invalid.");
    }

    private byte[] rawEncrypt(final byte[] plaintext, final byte[] associatedData) throws GeneralSecurityException {
        Cipher r0 = getAesGcmSivCipher();
        if (plaintext.length > 2147483619) goto L15;
        byte[] r7 = new byte[(plaintext.length + 12) + 16];
        byte[] r1 = Random.randBytes(12);
        System.arraycopy(r1, 0, r7, 0, 12);
        r0.init(1, this.keySpec, getParams(r1));
        if (associatedData != null) goto L7;
    L9:
        int r10 = r0.doFinal(plaintext, 0, plaintext.length, r7, 12);
        if (r10 != (plaintext.length + 16)) goto L13;
        return r7;
    L13:
        throw new GeneralSecurityException(String.format("encryption failed; GCM tag must be %s bytes, but got only %s bytes", new Object[]{16, Integer.valueOf(r10 - plaintext.length)}));
    L7:
        if (associatedData.length == 0) goto L9;
        r0.updateAAD(associatedData);
        goto L9
    L15:
        throw new GeneralSecurityException("plaintext too long");
    }

    @Override // com.google.crypto.tink.Aead
    public byte[] encrypt(final byte[] plaintext, final byte[] associatedData) throws GeneralSecurityException {
        byte[] r2 = rawEncrypt(plaintext, associatedData);
        byte[] r1 = this.outputPrefix;
        if (r1.length != 0) goto L6;
        return r2;
    L6:
        return Bytes.concat(new byte[][]{r1, r2});
    }

    private byte[] rawDecrypt(final byte[] ciphertext, final byte[] associatedData) throws GeneralSecurityException {
        Cipher r0 = getAesGcmSivCipher();
        if (ciphertext.length < 28) goto L12;
        AlgorithmParameterSpec r1 = getParams(ciphertext, 0, 12);
        r0.init(2, this.keySpec, r1);
        if (associatedData == null) goto L10;
        if (associatedData.length == 0) goto L10;
        r0.updateAAD(associatedData);
    L10:
        return r0.doFinal(ciphertext, 12, ciphertext.length - 12);
    L12:
        throw new GeneralSecurityException("ciphertext too short");
    }

    @Override // com.google.crypto.tink.Aead
    public byte[] decrypt(final byte[] ciphertext, final byte[] associatedData) throws GeneralSecurityException {
        byte[] r0 = this.outputPrefix;
        if (r0.length != 0) goto L7;
        return rawDecrypt(ciphertext, associatedData);
    L7:
        if (Util.isPrefix(r0, ciphertext) == false) goto L11;
        return rawDecrypt(Arrays.copyOfRange(ciphertext, this.outputPrefix.length, ciphertext.length), associatedData);
    L11:
        throw new GeneralSecurityException("Decryption failed (OutputPrefix mismatch).");
    }

    private static AlgorithmParameterSpec getParams(final byte[] iv) throws GeneralSecurityException {
        return getParams(iv, 0, iv.length);
    }

    private static AlgorithmParameterSpec getParams(final byte[] buf, int offset, int len) throws GeneralSecurityException {
        return new GCMParameterSpec(128, buf, offset, len);
    }
}
