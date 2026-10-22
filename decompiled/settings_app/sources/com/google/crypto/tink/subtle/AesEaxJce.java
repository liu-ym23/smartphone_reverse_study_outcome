package com.google.crypto.tink.subtle;

import com.google.crypto.tink.Aead;
import com.google.crypto.tink.InsecureSecretKeyAccess;
import com.google.crypto.tink.aead.AesEaxKey;
import com.google.crypto.tink.config.internal.TinkFipsUtil;
import com.google.crypto.tink.internal.Util;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import javax.crypto.AEADBadTagException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes4.dex */
public final class AesEaxJce implements Aead {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    static final int BLOCK_SIZE_IN_BYTES = 16;
    public static final TinkFipsUtil.AlgorithmFipsCompatibility FIPS = null;
    static final int TAG_SIZE_IN_BYTES = 16;
    private static final ThreadLocal<Cipher> localCtrCipher = null;
    private static final ThreadLocal<Cipher> localEcbCipher = null;
    private final byte[] b;
    private final int ivSizeInBytes;
    private final SecretKeySpec keySpec;
    private final byte[] outputPrefix;
    private final byte[] p;

    static {
        FIPS = TinkFipsUtil.AlgorithmFipsCompatibility.ALGORITHM_NOT_FIPS;
        localEcbCipher = new AnonymousClass1();
        localCtrCipher = new AnonymousClass2();
    }

    public static Aead create(AesEaxKey key) throws GeneralSecurityException {
        if (FIPS.isCompatible() == false) goto L11;
        if (key.getParameters().getTagSizeBytes() != 16) goto L9;
        return new AesEaxJce(key.getKeyBytes().toByteArray(InsecureSecretKeyAccess.get()), key.getParameters().getIvSizeBytes(), key.getOutputPrefix().toByteArray());
    L9:
        throw new GeneralSecurityException("AesEaxJce only supports 16 byte tag size, not " + key.getParameters().getTagSizeBytes());
    L11:
        throw new GeneralSecurityException("Can not use AES-EAX in FIPS-mode.");
    }

    private AesEaxJce(final byte[] key, int ivSizeInBytes, byte[] outputPrefix) throws GeneralSecurityException {
        if (FIPS.isCompatible() == false) goto L13;
        if (ivSizeInBytes == 12) goto L10;
        if (ivSizeInBytes == 16) goto L10;
        throw new IllegalArgumentException("IV size should be either 12 or 16 bytes");
    L10:
        this.ivSizeInBytes = ivSizeInBytes;
        Validators.validateAesKeySize(key.length);
        SecretKeySpec r4 = new SecretKeySpec(key, "AES");
        this.keySpec = r4;
        Cipher r3 = localEcbCipher.get();
        r3.init(1, r4);
        byte[] r5 = multiplyByX(r3.doFinal(new byte[16]));
        this.b = r5;
        this.p = multiplyByX(r5);
        this.outputPrefix = outputPrefix;
        return;
    L13:
        throw new GeneralSecurityException("Can not use AES-EAX in FIPS-mode.");
    }

    public AesEaxJce(final byte[] key, int ivSizeInBytes) throws GeneralSecurityException {
        this(key, ivSizeInBytes, new byte[0]);
    }

    private static byte[] xor(final byte[] x, final byte[] y) {
        int r0 = x.length;
        byte[] r1 = new byte[r0];
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L5;
        r1[r2] = (byte) (x[r2] ^ y[r2]);
        r2 = r2 + 1;
        goto L3
    L5:
        return r1;
    }

    private static byte[] multiplyByX(final byte[] block) {
        byte[] r0 = new byte[16];
        int r2 = 0;
    L4:
        if (r2 >= 15) goto L6;
        int r4 = r2 + 1;
        r0[r2] = (byte) (((block[r2] << 1) ^ ((block[r4] & 255) >>> 7)) & 255);
        r2 = r4;
        goto L4
    L6:
        r0[15] = (byte) (((block[0] >> 7) & 135) ^ (block[15] << 1));
        return r0;
    }

    private byte[] pad(final byte[] data) {
        if (data.length == 16) goto L5;
        byte[] r3 = Arrays.copyOf(this.p, 16);
        int r0 = 0;
    L8:
        if (r0 >= data.length) goto L10;
        r3[r0] = (byte) (r3[r0] ^ data[r0]);
        r0 = r0 + 1;
        goto L8
    L10:
        r3[data.length] = (byte) (r3[data.length] ^ 128);
        return r3;
    L5:
        return xor(data, this.b);
    }

    private byte[] omac(Cipher ecb, int tag, final byte[] data, int offset, int length) throws IllegalBlockSizeException, BadPaddingException {
        byte[] r1 = new byte[16];
        r1[15] = (byte) tag;
        if (length == 0) goto L5;
        byte[] r8 = ecb.doFinal(r1);
        int r2 = 0;
    L8:
        if ((length - r2) <= 16) goto L14;
        int r3 = 0;
    L10:
        if (r3 >= 16) goto L12;
        r8[r3] = (byte) (r8[r3] ^ data[(offset + r2) + r3]);
        r3 = r3 + 1;
        goto L10
    L12:
        r8 = ecb.doFinal(r8);
        r2 = r2 + 16;
        goto L8
    L14:
        return ecb.doFinal(xor(r8, pad(Arrays.copyOfRange(data, r2 + offset, offset + length))));
    L5:
        return ecb.doFinal(xor(r1, this.b));
    }

    private byte[] rawEncrypt(final byte[] plaintext, final byte[] associatedData) throws GeneralSecurityException {
        int r0 = plaintext.length;
        int r1 = this.ivSizeInBytes;
        if (r0 > ((Integer.MAX_VALUE - r1) - 16)) goto L13;
        byte[] r9 = new byte[(plaintext.length + r1) + 16];
        byte[] r3 = Random.randBytes(r1);
        int r10 = 0;
        System.arraycopy(r3, 0, r9, 0, this.ivSizeInBytes);
        Cipher r11 = localEcbCipher.get();
        r11.init(1, this.keySpec);
        byte[] r13 = omac(r11, 0, r3, 0, r3.length);
        if (associatedData != null) goto L7;
        byte[] r4 = new byte[0];
    L8:
        byte[] r14 = omac(r11, 1, r4, 0, r4.length);
        Cipher r2 = localCtrCipher.get();
        r2.init(1, this.keySpec, new IvParameterSpec(r13));
        r2.doFinal(plaintext, 0, plaintext.length, r9, this.ivSizeInBytes);
        byte[] r5 = omac(r11, 2, r9, this.ivSizeInBytes, plaintext.length);
        int r6 = plaintext.length + this.ivSizeInBytes;
    L9:
        if (r10 >= 16) goto L11;
        r9[r6 + r10] = (byte) ((r14[r10] ^ r13[r10]) ^ r5[r10]);
        r10 = r10 + 1;
        goto L9
    L11:
        return r9;
    L7:
        r4 = associatedData;
        goto L8
    L13:
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
        int r0 = (ciphertext.length - this.ivSizeInBytes) - 16;
        if (r0 < 0) goto L16;
        Cipher r9 = localEcbCipher.get();
        r9.init(1, this.keySpec);
        byte[] r11 = omac(r9, 0, ciphertext, 0, this.ivSizeInBytes);
        int r12 = 0;
        if (associatedData != null) goto L7;
        associatedData = new byte[0];
    L7:
        byte[] r6 = associatedData;
        byte[] r15 = omac(r9, 1, r6, 0, r6.length);
        byte[] r2 = omac(r9, 2, ciphertext, this.ivSizeInBytes, r0);
        int r3 = ciphertext.length - 16;
        byte r4 = 0;
    L8:
        if (r12 >= 16) goto L10;
        r4 = (byte) (r4 | (((ciphertext[r3 + r12] ^ r15[r12]) ^ r11[r12]) ^ r2[r12]));
        r12 = r12 + 1;
        goto L8
    L10:
        if (r4 != 0) goto L14;
        Cipher r16 = localCtrCipher.get();
        r16.init(1, this.keySpec, new IvParameterSpec(r11));
        return r16.doFinal(ciphertext, this.ivSizeInBytes, r0);
    L14:
        throw new AEADBadTagException("tag mismatch");
    L16:
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
}
