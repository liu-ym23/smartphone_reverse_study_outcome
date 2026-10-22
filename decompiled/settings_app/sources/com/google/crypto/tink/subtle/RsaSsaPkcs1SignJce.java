package com.google.crypto.tink.subtle;

import com.google.crypto.tink.InsecureSecretKeyAccess;
import com.google.crypto.tink.PublicKeySign;
import com.google.crypto.tink.PublicKeyVerify;
import com.google.crypto.tink.config.internal.TinkFipsUtil;
import com.google.crypto.tink.signature.RsaSsaPkcs1Parameters;
import com.google.crypto.tink.signature.RsaSsaPkcs1PrivateKey;
import com.google.errorprone.annotations.Immutable;
import java.security.GeneralSecurityException;
import java.security.Signature;
import java.security.interfaces.RSAPrivateCrtKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.RSAPrivateCrtKeySpec;
import java.security.spec.RSAPublicKeySpec;

/* JADX INFO: loaded from: classes4.dex */
@Immutable
public final class RsaSsaPkcs1SignJce implements PublicKeySign {
    public static final TinkFipsUtil.AlgorithmFipsCompatibility FIPS = null;
    private final byte[] messageSuffix;
    private final byte[] outputPrefix;
    private final RSAPrivateCrtKey privateKey;
    private final RSAPublicKey publicKey;
    private final String signatureAlgorithm;

    static {
        FIPS = TinkFipsUtil.AlgorithmFipsCompatibility.ALGORITHM_REQUIRES_BORINGCRYPTO;
    }

    private RsaSsaPkcs1SignJce(final RSAPrivateCrtKey priv, Enums.HashType hash, byte[] outputPrefix, byte[] messageSuffix) throws GeneralSecurityException {
        if (FIPS.isCompatible() == false) goto L7;
        Validators.validateSignatureHash(hash);
        Validators.validateRsaModulusSize(priv.getModulus().bitLength());
        Validators.validateRsaPublicExponent(priv.getPublicExponent());
        this.privateKey = priv;
        this.signatureAlgorithm = SubtleUtil.toRsaSsaPkcs1Algo(hash);
        this.publicKey = (RSAPublicKey) EngineFactory.KEY_FACTORY.getInstance("RSA").generatePublic(new RSAPublicKeySpec(priv.getModulus(), priv.getPublicExponent()));
        this.outputPrefix = outputPrefix;
        this.messageSuffix = messageSuffix;
        return;
    L7:
        throw new GeneralSecurityException("Can not use RSA PKCS1.5 in FIPS-mode, as BoringCrypto module is not available.");
    }

    public RsaSsaPkcs1SignJce(final RSAPrivateCrtKey priv, Enums.HashType hash) throws GeneralSecurityException {
        this(priv, hash, new byte[0], new byte[0]);
    }

    public static PublicKeySign create(RsaSsaPkcs1PrivateKey key) throws GeneralSecurityException {
        RSAPrivateCrtKey r0 = (RSAPrivateCrtKey) EngineFactory.KEY_FACTORY.getInstance("RSA").generatePrivate(new RSAPrivateCrtKeySpec(key.getPublicKey().getModulus(), key.getParameters().getPublicExponent(), key.getPrivateExponent().getBigInteger(InsecureSecretKeyAccess.get()), key.getPrimeP().getBigInteger(InsecureSecretKeyAccess.get()), key.getPrimeQ().getBigInteger(InsecureSecretKeyAccess.get()), key.getPrimeExponentP().getBigInteger(InsecureSecretKeyAccess.get()), key.getPrimeExponentQ().getBigInteger(InsecureSecretKeyAccess.get()), key.getCrtCoefficient().getBigInteger(InsecureSecretKeyAccess.get())));
        Enums.HashType r2 = (Enums.HashType) RsaSsaPkcs1VerifyJce.HASH_TYPE_CONVERTER.toProtoEnum(key.getParameters().getHashType());
        byte[] r3 = key.getOutputPrefix().toByteArray();
        if (key.getParameters().getVariant().equals(RsaSsaPkcs1Parameters.Variant.LEGACY) == false) goto L5;
        byte[] r4 = {0};
    L6:
        RsaSsaPkcs1SignJce r1 = new RsaSsaPkcs1SignJce(r0, r2, r3, r4);
        PublicKeyVerify r11 = RsaSsaPkcs1VerifyJce.create(key.getPublicKey());
        r11.verify(r1.sign(new byte[]{1, 2, 3}), new byte[]{1, 2, 3});     // Catch: GeneralSecurityException -> L9
        return r1;
    L9:
        e = move-exception;
        throw new GeneralSecurityException("RsaSsaPkcs1 signing with private key followed by verifying with public key failed. The key may be corrupted.", e);
    L5:
        r4 = new byte[0];
        goto L6
    }

    private byte[] noPrefixSign(final byte[] data) throws GeneralSecurityException {
        Signature r0 = EngineFactory.SIGNATURE.getInstance(this.signatureAlgorithm);
        r0.initSign(this.privateKey);
        r0.update(data);
        byte[] r1 = r0.sign();
        Signature r2 = EngineFactory.SIGNATURE.getInstance(this.signatureAlgorithm);
        r2.initVerify(this.publicKey);
        r2.update(data);
        if (r2.verify(r1) == false) goto L6;
        return r1;
    L6:
        throw new RuntimeException("Security bug: RSA signature computation error");
    }

    @Override // com.google.crypto.tink.PublicKeySign
    public byte[] sign(final byte[] data) throws GeneralSecurityException {
        byte[] r0 = this.messageSuffix;
        if (r0.length != 0) goto L5;
        byte[] r6 = noPrefixSign(data);
    L6:
        byte[] r5 = this.outputPrefix;
        if (r5.length != 0) goto L10;
        return r6;
    L10:
        return Bytes.concat(new byte[][]{r5, r6});
    L5:
        r6 = noPrefixSign(Bytes.concat(new byte[][]{data, r0}));
        goto L6
    }
}
