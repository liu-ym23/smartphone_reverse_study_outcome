package com.google.crypto.tink.aead.internal;

import com.google.crypto.tink.Aead;
import com.google.crypto.tink.InsecureSecretKeyAccess;
import com.google.crypto.tink.aead.ChaCha20Poly1305Key;
import com.google.crypto.tink.config.internal.TinkFipsUtil;
import com.google.crypto.tink.internal.Util;
import com.google.crypto.tink.subtle.Hex;
import com.google.crypto.tink.subtle.Random;
import com.google.errorprone.annotations.Immutable;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.util.Arrays;
import javax.annotation.Nullable;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes4.dex */
@Immutable
public final class ChaCha20Poly1305Jce implements Aead {
    private static final String CIPHER_NAME = "ChaCha20-Poly1305";
    private static final TinkFipsUtil.AlgorithmFipsCompatibility FIPS = null;
    private static final String KEY_NAME = "ChaCha20";
    private static final int KEY_SIZE_IN_BYTES = 32;
    private static final int NONCE_SIZE_IN_BYTES = 12;
    private static final int TAG_SIZE_IN_BYTES = 16;
    private static final byte[] TEST_CIPHERTEXT_OF_EMPTY = null;
    private static final byte[] TEST_KEY = null;
    private static final byte[] TEST_NONCE = null;
    private static final ThreadLocal<Cipher> localCipher = null;
    private final SecretKey keySpec;
    private final byte[] outputPrefix;

    static /* synthetic */ boolean access$000(Cipher r0) {
        return isValid(r0);
    }

    static {
        FIPS = TinkFipsUtil.AlgorithmFipsCompatibility.ALGORITHM_NOT_FIPS;
        TEST_KEY = Hex.decode("808182838485868788898a8b8c8d8e8f909192939495969798999a9b9c9d9e9f");
        TEST_NONCE = Hex.decode("070000004041424344454647");
        TEST_CIPHERTEXT_OF_EMPTY = Hex.decode("a0784d7a4716f3feb4f64e7f4b39bf04");
        localCipher = new AnonymousClass1();
    }

    private static boolean isValid(Cipher cipher) {
        IvParameterSpec r2 = new IvParameterSpec(TEST_NONCE);     // Catch: GeneralSecurityException -> L11
        byte[] r4 = TEST_KEY;     // Catch: GeneralSecurityException -> L11
        cipher.init(2, new SecretKeySpec(r4, "ChaCha20"), r2);     // Catch: GeneralSecurityException -> L11
        byte[] r3 = TEST_CIPHERTEXT_OF_EMPTY;     // Catch: GeneralSecurityException -> L11
        if (cipher.doFinal(r3).length == 0) goto L6;
        return false;
    L6:
        cipher.init(2, new SecretKeySpec(r4, "ChaCha20"), r2);     // Catch: GeneralSecurityException -> L11
        if (cipher.doFinal(r3).length == 0) goto L9;
        return false;
    L9:
        return true;
    L11:
        return false;
    }

    private ChaCha20Poly1305Jce(final byte[] key, final byte[] outputPrefix) throws GeneralSecurityException {
        if (FIPS.isCompatible() == false) goto L15;
        if (isSupported() == false) goto L13;
        if (key.length != 32) goto L11;
        this.keySpec = new SecretKeySpec(key, "ChaCha20");
        this.outputPrefix = outputPrefix;
        return;
    L11:
        throw new InvalidKeyException("The key length in bytes must be 32.");
    L13:
        throw new GeneralSecurityException("JCE does not support algorithm: ChaCha20-Poly1305");
    L15:
        throw new GeneralSecurityException("Can not use ChaCha20Poly1305 in FIPS-mode.");
    }

    public static Aead create(ChaCha20Poly1305Key key) throws GeneralSecurityException {
        return new ChaCha20Poly1305Jce(key.getKeyBytes().toByteArray(InsecureSecretKeyAccess.get()), key.getOutputPrefix().toByteArray());
    }

    @Nullable
    static Cipher getThreadLocalCipherOrNull() {
        return localCipher.get();
    }

    public static boolean isSupported() {
        if (localCipher.get() == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.google.crypto.tink.Aead
    public byte[] encrypt(final byte[] plaintext, final byte[] associatedData) throws GeneralSecurityException {
        if (plaintext == null) goto L18;
        byte[] r1 = Random.randBytes(12);
        IvParameterSpec r2 = new IvParameterSpec(r1);
        Cipher r4 = localCipher.get();
        r4.init(1, this.keySpec, r2);
        if (associatedData != null) goto L6;
    L8:
        int r12 = r4.getOutputSize(plaintext.length);
        byte[] r3 = this.outputPrefix;
        if (r12 > ((Integer.MAX_VALUE - r3.length) - 12)) goto L16;
        byte[] r5 = Arrays.copyOf(r3, (r3.length + 12) + r12);
        System.arraycopy(r1, 0, r5, this.outputPrefix.length, 12);
        if (r4.doFinal(plaintext, 0, plaintext.length, r5, this.outputPrefix.length + 12) != r12) goto L14;
        return r5;
    L14:
        throw new GeneralSecurityException("not enough data written");
    L16:
        throw new GeneralSecurityException("plaintext too long");
    L6:
        if (associatedData.length == 0) goto L8;
        r4.updateAAD(associatedData);
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
        IvParameterSpec r3 = new IvParameterSpec(r2);
        Cipher r4 = localCipher.get();
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
