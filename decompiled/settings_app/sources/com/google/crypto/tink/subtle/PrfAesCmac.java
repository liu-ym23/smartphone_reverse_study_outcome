package com.google.crypto.tink.subtle;

import com.google.crypto.tink.InsecureSecretKeyAccess;
import com.google.crypto.tink.config.internal.TinkFipsUtil;
import com.google.crypto.tink.mac.internal.AesUtil;
import com.google.crypto.tink.prf.AesCmacPrfKey;
import com.google.crypto.tink.prf.Prf;
import com.google.errorprone.annotations.Immutable;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes4.dex */
@Immutable
public final class PrfAesCmac implements Prf {
    public static final TinkFipsUtil.AlgorithmFipsCompatibility FIPS = null;
    private final SecretKey keySpec;
    private byte[] subKey1;
    private byte[] subKey2;

    static {
        FIPS = TinkFipsUtil.AlgorithmFipsCompatibility.ALGORITHM_NOT_FIPS;
    }

    private static Cipher instance() throws GeneralSecurityException {
        if (FIPS.isCompatible() == false) goto L7;
        return EngineFactory.CIPHER.getInstance("AES/ECB/NoPadding");
    L7:
        throw new GeneralSecurityException("Can not use AES-CMAC in FIPS-mode.");
    }

    public PrfAesCmac(final byte[] key) throws GeneralSecurityException {
        Validators.validateAesKeySize(key.length);
        this.keySpec = new SecretKeySpec(key, "AES");
        generateSubKeys();
    }

    public static Prf create(AesCmacPrfKey key) throws GeneralSecurityException {
        return new PrfAesCmac(key.getKeyBytes().toByteArray(InsecureSecretKeyAccess.get()));
    }

    @Override // com.google.crypto.tink.prf.Prf
    public byte[] compute(final byte[] data, int outputLength) throws GeneralSecurityException {
        if (outputLength > 16) goto L18;
        Cipher r1 = instance();
        r1.init(1, this.keySpec);
        int r2 = Math.max(1, (int) Math.ceil(((double) data.length) / 16.0d));
        if ((r2 * 16) != data.length) goto L7;
        boolean r4 = true;
    L8:
        if (r4 == false) goto L10;
        byte[] r8 = Bytes.xor(data, (r2 - 1) * 16, this.subKey1, 0, 16);
    L11:
        byte[] r5 = new byte[16];
        int r6 = 0;
    L13:
        if (r6 >= (r2 - 1)) goto L16;
        r5 = r1.doFinal(Bytes.xor(r5, 0, data, r6 * 16, 16));
        r6 = r6 + 1;
        goto L13
    L16:
        return Arrays.copyOf(r1.doFinal(Bytes.xor(r8, r5)), outputLength);
    L10:
        r8 = Bytes.xor(AesUtil.cmacPad(Arrays.copyOfRange(data, (r2 - 1) * 16, data.length)), this.subKey2);
        goto L11
    L7:
        r4 = false;
        goto L8
    L18:
        throw new InvalidAlgorithmParameterException("outputLength too large, max is 16 bytes");
    }

    private void generateSubKeys() throws GeneralSecurityException {
        Cipher r0 = instance();
        r0.init(1, this.keySpec);
        byte[] r1 = AesUtil.dbl(r0.doFinal(new byte[16]));
        this.subKey1 = r1;
        this.subKey2 = AesUtil.dbl(r1);
    }
}
