package com.google.crypto.tink.subtle;

import com.google.crypto.tink.DeterministicAead;
import com.google.crypto.tink.InsecureSecretKeyAccess;
import com.google.crypto.tink.config.internal.TinkFipsUtil;
import com.google.crypto.tink.daead.AesSivKey;
import com.google.crypto.tink.internal.Util;
import com.google.crypto.tink.mac.internal.AesUtil;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.util.Arrays;
import java.util.Collection;
import javax.crypto.AEADBadTagException;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes4.dex */
public final class AesSiv implements DeterministicAead {
    private static final byte[] BLOCK_ONE = null;
    private static final byte[] BLOCK_ZERO = null;
    public static final TinkFipsUtil.AlgorithmFipsCompatibility FIPS = null;
    private static final Collection<Integer> KEY_SIZES = null;
    private final byte[] aesCtrKey;
    private final PrfAesCmac cmacForS2V;
    private final byte[] outputPrefix;

    static {
        FIPS = TinkFipsUtil.AlgorithmFipsCompatibility.ALGORITHM_NOT_FIPS;
        KEY_SIZES = Arrays.asList(new Integer[]{64});
        BLOCK_ZERO = new byte[16];
        BLOCK_ONE = new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1};
    }

    public static DeterministicAead create(AesSivKey key) throws GeneralSecurityException {
        return new AesSiv(key.getKeyBytes().toByteArray(InsecureSecretKeyAccess.get()), key.getOutputPrefix());
    }

    private AesSiv(final byte[] key, com.google.crypto.tink.util.Bytes outputPrefix) throws GeneralSecurityException {
        if (FIPS.isCompatible() == false) goto L11;
        if (KEY_SIZES.contains(Integer.valueOf(key.length)) == false) goto L9;
        byte[] r0 = Arrays.copyOfRange(key, 0, key.length / 2);
        this.aesCtrKey = Arrays.copyOfRange(key, key.length / 2, key.length);
        this.cmacForS2V = new PrfAesCmac(r0);
        this.outputPrefix = outputPrefix.toByteArray();
        return;
    L9:
        throw new InvalidKeyException("invalid key size: " + key.length + " bytes; key must have 64 bytes");
    L11:
        throw new GeneralSecurityException("Can not use AES-SIV in FIPS-mode.");
    }

    public AesSiv(final byte[] key) throws GeneralSecurityException {
        this(key, com.google.crypto.tink.util.Bytes.copyFrom(new byte[0]));
    }

    private byte[] s2v(final byte[]... s) throws GeneralSecurityException {
        if (s.length == 0) goto L5;
        byte[] r0 = this.cmacForS2V.compute(BLOCK_ZERO, 16);
        int r3 = 0;
    L8:
        if (r3 >= (s.length - 1)) goto L13;
        byte[] r4 = s[r3];
        if (r4 != null) goto L12;
        r4 = new byte[0];
    L12:
        r0 = Bytes.xor(AesUtil.dbl(r0), this.cmacForS2V.compute(r4, 16));
        r3 = r3 + 1;
        goto L8
    L13:
        byte[] r7 = s[s.length - 1];
        if (r7.length < 16) goto L16;
        byte[] r8 = Bytes.xorEnd(r7, r0);
    L18:
        return this.cmacForS2V.compute(r8, 16);
    L16:
        r8 = Bytes.xor(AesUtil.cmacPad(r7), AesUtil.dbl(r0));
        goto L18
    L5:
        return this.cmacForS2V.compute(BLOCK_ONE, 16);
    }

    @Override // com.google.crypto.tink.DeterministicAead
    public byte[] encryptDeterministically(final byte[] plaintext, final byte[] associatedData) throws GeneralSecurityException {
        if (plaintext.length > 2147483631) goto L7;
        Cipher r0 = EngineFactory.CIPHER.getInstance("AES/CTR/NoPadding");
        byte[] r2 = s2v(new byte[][]{associatedData, plaintext});
        byte[] r4 = (byte[]) r2.clone();
        r4[8] = (byte) (r4[8] & 127);
        r4[12] = (byte) (r4[12] & 127);
        r0.init(1, new SecretKeySpec(this.aesCtrKey, "AES"), new IvParameterSpec(r4));
        return Bytes.concat(new byte[][]{this.outputPrefix, r2, r0.doFinal(plaintext)});
    L7:
        throw new GeneralSecurityException("plaintext too long");
    }

    @Override // com.google.crypto.tink.DeterministicAead
    public byte[] decryptDeterministically(final byte[] ciphertext, final byte[] associatedData) throws GeneralSecurityException {
        int r0 = ciphertext.length;
        byte[] r1 = this.outputPrefix;
        if (r0 < (r1.length + 16)) goto L20;
        if (Util.isPrefix(r1, ciphertext) == false) goto L18;
        Cipher r2 = EngineFactory.CIPHER.getInstance("AES/CTR/NoPadding");
        byte[] r3 = this.outputPrefix;
        byte[] r4 = Arrays.copyOfRange(ciphertext, r3.length, r3.length + 16);
        byte[] r5 = (byte[]) r4.clone();
        r5[8] = (byte) (r5[8] & 127);
        r5[12] = (byte) (r5[12] & 127);
        r2.init(2, new SecretKeySpec(this.aesCtrKey, "AES"), new IvParameterSpec(r5));
        byte[] r7 = Arrays.copyOfRange(ciphertext, this.outputPrefix.length + 16, ciphertext.length);
        byte[] r6 = r2.doFinal(r7);
        if (r7.length != 0) goto L13;
        if (r6 != null) goto L13;
        if (SubtleUtil.isAndroid() == false) goto L13;
        r6 = new byte[0];
    L13:
        if (Bytes.equal(r4, s2v(new byte[][]{associatedData, r6})) == false) goto L16;
        return r6;
    L16:
        throw new AEADBadTagException("Integrity check failed.");
    L18:
        throw new GeneralSecurityException("Decryption failed (OutputPrefix mismatch).");
    L20:
        throw new GeneralSecurityException("Ciphertext too short.");
    }
}
