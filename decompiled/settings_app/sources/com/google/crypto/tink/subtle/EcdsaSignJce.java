package com.google.crypto.tink.subtle;

import com.google.crypto.tink.InsecureSecretKeyAccess;
import com.google.crypto.tink.PublicKeySign;
import com.google.crypto.tink.PublicKeyVerify;
import com.google.crypto.tink.config.internal.TinkFipsUtil;
import com.google.crypto.tink.signature.EcdsaParameters;
import com.google.crypto.tink.signature.EcdsaPrivateKey;
import com.google.errorprone.annotations.Immutable;
import java.security.GeneralSecurityException;
import java.security.Provider;
import java.security.Signature;
import java.security.interfaces.ECPrivateKey;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
@Immutable
public final class EcdsaSignJce implements PublicKeySign {
    public static final TinkFipsUtil.AlgorithmFipsCompatibility FIPS = null;
    private final EllipticCurves.EcdsaEncoding encoding;
    private final byte[] messageSuffix;
    private final byte[] outputPrefix;
    private final ECPrivateKey privateKey;
    private final String signatureAlgorithm;

    static {
        FIPS = TinkFipsUtil.AlgorithmFipsCompatibility.ALGORITHM_REQUIRES_BORINGCRYPTO;
    }

    private EcdsaSignJce(final ECPrivateKey priv, Enums.HashType hash, EllipticCurves.EcdsaEncoding encoding, byte[] outputPrefix, byte[] messageSuffix) throws GeneralSecurityException {
        if (FIPS.isCompatible() == false) goto L7;
        this.privateKey = priv;
        this.signatureAlgorithm = SubtleUtil.toEcdsaAlgo(hash);
        this.encoding = encoding;
        this.outputPrefix = outputPrefix;
        this.messageSuffix = messageSuffix;
        return;
    L7:
        throw new GeneralSecurityException("Can not use ECDSA in FIPS-mode, as BoringCrypto is not available.");
    }

    public EcdsaSignJce(final ECPrivateKey priv, Enums.HashType hash, EllipticCurves.EcdsaEncoding encoding) throws GeneralSecurityException {
        this(priv, hash, encoding, new byte[0], new byte[0]);
    }

    public static PublicKeySign create(EcdsaPrivateKey key) throws GeneralSecurityException {
        Enums.HashType r3 = (Enums.HashType) EcdsaVerifyJce.HASH_TYPE_CONVERTER.toProtoEnum(key.getParameters().getHashType());
        EllipticCurves.EcdsaEncoding r4 = (EllipticCurves.EcdsaEncoding) EcdsaVerifyJce.ENCODING_CONVERTER.toProtoEnum(key.getParameters().getSignatureEncoding());
        ECPrivateKey r2 = EllipticCurves.getEcPrivateKey((EllipticCurves.CurveType) EcdsaVerifyJce.CURVE_TYPE_CONVERTER.toProtoEnum(key.getParameters().getCurveType()), key.getPrivateValue().getBigInteger(InsecureSecretKeyAccess.get()).toByteArray());
        byte[] r5 = key.getOutputPrefix().toByteArray();
        if (key.getParameters().getVariant().equals(EcdsaParameters.Variant.LEGACY) == false) goto L5;
        byte[] r1 = {0};
    L6:
        EcdsaSignJce r0 = new EcdsaSignJce(r2, r3, r4, r5, r1);
        PublicKeyVerify r9 = EcdsaVerifyJce.create(key.getPublicKey());
        r9.verify(r0.sign(new byte[]{1, 2, 3}), new byte[]{1, 2, 3});     // Catch: GeneralSecurityException -> L9
        return r0;
    L9:
        e = move-exception;
        throw new GeneralSecurityException("ECDSA signing with private key followed by verifying with public key failed. The key may be corrupted.", e);
    L5:
        r1 = new byte[0];
        goto L6
    }

    private byte[] noPrefixSign(final byte[] data) throws GeneralSecurityException {
        List<Provider> r0 = EngineFactory.toProviderList(new String[]{"GmsCore_OpenSSL", "AndroidOpenSSL", "Conscrypt"});
        Signature r1 = EngineFactory.SIGNATURE.getInstance(this.signatureAlgorithm, r0);
        r1.initSign(this.privateKey);
        r1.update(data);
        byte[] r4 = r1.sign();
        if (this.encoding == EllipticCurves.EcdsaEncoding.IEEE_P1363) goto L5;
        return r4;
    L5:
        return EllipticCurves.ecdsaDer2Ieee(r4, EllipticCurves.fieldSizeInBytes(this.privateKey.getParams().getCurve()) * 2);
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
