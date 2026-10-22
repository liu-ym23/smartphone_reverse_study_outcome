package com.google.crypto.tink.subtle;

import com.google.crypto.tink.InsecureSecretKeyAccess;
import com.google.crypto.tink.config.internal.TinkFipsUtil;
import com.google.crypto.tink.prf.HmacPrfKey;
import com.google.crypto.tink.prf.Prf;
import com.google.errorprone.annotations.Immutable;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes4.dex */
@Immutable
public final class PrfHmacJce implements Prf {
    public static final TinkFipsUtil.AlgorithmFipsCompatibility FIPS = null;
    static final int MIN_KEY_SIZE_IN_BYTES = 16;
    private final String algorithm;
    private final Key key;
    private final ThreadLocal<Mac> localMac;
    private final int maxOutputLength;

    static /* synthetic */ String access$000(PrfHmacJce r0) {
        return r0.algorithm;
    }

    static /* synthetic */ Key access$100(PrfHmacJce r0) {
        return r0.key;
    }

    static {
        FIPS = TinkFipsUtil.AlgorithmFipsCompatibility.ALGORITHM_REQUIRES_BORINGCRYPTO;
    }

    public PrfHmacJce(String algorithm, Key key) throws GeneralSecurityException {
        ThreadLocal<Mac> r0 = new AnonymousClass1(this);
        this.localMac = r0;
        if (FIPS.isCompatible() == false) goto L42;
        this.algorithm = algorithm;
        this.key = key;
        if (key.getEncoded().length < 16) goto L40;
        algorithm.hashCode();
        byte r1 = -1;
        switch(algorithm.hashCode()) {
            case -1823053428: goto L26;
            case 392315023: goto L22;
            case 392315118: goto L18;
            case 392316170: goto L14;
            case 392317873: goto L10;
            default: goto L29;
        };
    L29:
        switch(r1) {
            case 0: goto L36;
            case 1: goto L35;
            case 2: goto L34;
            case 3: goto L33;
            case 4: goto L32;
            default: goto L31;
        };
    L32:
        this.maxOutputLength = 64;
    L37:
        r0.get();
        return;
    L33:
        this.maxOutputLength = 48;
        goto L37
    L34:
        this.maxOutputLength = 32;
        goto L37
    L35:
        this.maxOutputLength = 28;
        goto L37
    L36:
        this.maxOutputLength = 20;
        goto L37
    L31:
        throw new NoSuchAlgorithmException("unknown Hmac algorithm: " + algorithm);
    L10:
        if (algorithm.equals("HMACSHA512") == false) goto L29;
        r1 = 4;
        goto L29
    L14:
        if (algorithm.equals("HMACSHA384") == false) goto L29;
        r1 = 3;
        goto L29
    L18:
        if (algorithm.equals("HMACSHA256") == false) goto L29;
        r1 = 2;
        goto L29
    L22:
        if (algorithm.equals("HMACSHA224") == false) goto L29;
        r1 = 1;
        goto L29
    L26:
        if (algorithm.equals("HMACSHA1") == false) goto L29;
        r1 = 0;
        goto L29
    L40:
        throw new InvalidAlgorithmParameterException("key size too small, need at least 16 bytes");
    L42:
        throw new GeneralSecurityException("Can not use HMAC in FIPS-mode, as BoringCrypto module is not available.");
    }

    public static Prf create(HmacPrfKey key) throws GeneralSecurityException {
        return new PrfHmacJce("HMAC" + key.getParameters().getHashType(), new SecretKeySpec(key.getKeyBytes().toByteArray(InsecureSecretKeyAccess.get()), "HMAC"));
    }

    @Override // com.google.crypto.tink.prf.Prf
    public byte[] compute(byte[] data, int outputLength) throws GeneralSecurityException {
        if (outputLength > this.maxOutputLength) goto L7;
        this.localMac.get().update(data);
        return Arrays.copyOf(this.localMac.get().doFinal(), outputLength);
    L7:
        throw new InvalidAlgorithmParameterException("tag size too big");
    }

    public int getMaxOutputLength() {
        return this.maxOutputLength;
    }
}
