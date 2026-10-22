package com.google.crypto.tink.subtle;

import com.google.crypto.tink.PublicKeyVerify;
import com.google.crypto.tink.config.internal.TinkFipsUtil;
import com.google.crypto.tink.internal.EnumTypeProtoConverter;
import com.google.crypto.tink.internal.Util;
import com.google.crypto.tink.signature.EcdsaParameters;
import com.google.crypto.tink.signature.EcdsaPublicKey;
import com.google.errorprone.annotations.Immutable;
import java.security.GeneralSecurityException;
import java.security.Provider;
import java.security.Signature;
import java.security.interfaces.ECPublicKey;
import java.security.spec.EllipticCurve;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
@Immutable
public final class EcdsaVerifyJce implements PublicKeyVerify {
    static final EnumTypeProtoConverter<EllipticCurves.CurveType, EcdsaParameters.CurveType> CURVE_TYPE_CONVERTER = null;
    static final EnumTypeProtoConverter<EllipticCurves.EcdsaEncoding, EcdsaParameters.SignatureEncoding> ENCODING_CONVERTER = null;
    public static final TinkFipsUtil.AlgorithmFipsCompatibility FIPS = null;
    static final EnumTypeProtoConverter<Enums.HashType, EcdsaParameters.HashType> HASH_TYPE_CONVERTER = null;
    private final EllipticCurves.EcdsaEncoding encoding;
    private final byte[] messageSuffix;
    private final byte[] outputPrefix;
    private final ECPublicKey publicKey;
    private final String signatureAlgorithm;

    static {
        FIPS = TinkFipsUtil.AlgorithmFipsCompatibility.ALGORITHM_REQUIRES_BORINGCRYPTO;
        HASH_TYPE_CONVERTER = EnumTypeProtoConverter.builder().add(Enums.HashType.SHA256, EcdsaParameters.HashType.SHA256).add(Enums.HashType.SHA384, EcdsaParameters.HashType.SHA384).add(Enums.HashType.SHA512, EcdsaParameters.HashType.SHA512).build();
        ENCODING_CONVERTER = EnumTypeProtoConverter.builder().add(EllipticCurves.EcdsaEncoding.IEEE_P1363, EcdsaParameters.SignatureEncoding.IEEE_P1363).add(EllipticCurves.EcdsaEncoding.DER, EcdsaParameters.SignatureEncoding.DER).build();
        CURVE_TYPE_CONVERTER = EnumTypeProtoConverter.builder().add(EllipticCurves.CurveType.NIST_P256, EcdsaParameters.CurveType.NIST_P256).add(EllipticCurves.CurveType.NIST_P384, EcdsaParameters.CurveType.NIST_P384).add(EllipticCurves.CurveType.NIST_P521, EcdsaParameters.CurveType.NIST_P521).build();
    }

    public static PublicKeyVerify create(EcdsaPublicKey key) throws GeneralSecurityException {
        ECPublicKey r4 = EllipticCurves.getEcPublicKey((EllipticCurves.CurveType) CURVE_TYPE_CONVERTER.toProtoEnum(key.getParameters().getCurveType()), key.getPublicPoint().getAffineX().toByteArray(), key.getPublicPoint().getAffineY().toByteArray());
        Enums.HashType r5 = (Enums.HashType) HASH_TYPE_CONVERTER.toProtoEnum(key.getParameters().getHashType());
        EllipticCurves.EcdsaEncoding r6 = (EllipticCurves.EcdsaEncoding) ENCODING_CONVERTER.toProtoEnum(key.getParameters().getSignatureEncoding());
        byte[] r7 = key.getOutputPrefix().toByteArray();
        if (key.getParameters().getVariant().equals(EcdsaParameters.Variant.LEGACY) == false) goto L5;
        byte[] r9 = {0};
    L7:
        return new EcdsaVerifyJce(r4, r5, r6, r7, r9);
    L5:
        r9 = new byte[0];
        goto L7
    }

    private EcdsaVerifyJce(final ECPublicKey pubKey, Enums.HashType hash, EllipticCurves.EcdsaEncoding encoding, byte[] outputPrefix, byte[] messageSuffix) throws GeneralSecurityException {
        if (FIPS.isCompatible() == false) goto L7;
        EllipticCurves.checkPublicKey(pubKey);
        this.signatureAlgorithm = SubtleUtil.toEcdsaAlgo(hash);
        this.publicKey = pubKey;
        this.encoding = encoding;
        this.outputPrefix = outputPrefix;
        this.messageSuffix = messageSuffix;
        return;
    L7:
        throw new GeneralSecurityException("Can not use ECDSA in FIPS-mode, as BoringCrypto is not available.");
    }

    public EcdsaVerifyJce(final ECPublicKey pubKey, Enums.HashType hash, EllipticCurves.EcdsaEncoding encoding) throws GeneralSecurityException {
        this(pubKey, hash, encoding, new byte[0], new byte[0]);
    }

    private void noPrefixVerify(final byte[] signature, final byte[] data) throws GeneralSecurityException {
        if (this.encoding != EllipticCurves.EcdsaEncoding.IEEE_P1363) goto L10;
        EllipticCurve r0 = this.publicKey.getParams().getCurve();
        if (signature.length != (EllipticCurves.fieldSizeInBytes(r0) * 2)) goto L8;
        signature = EllipticCurves.ecdsaIeee2Der(signature);
        goto L10
    L8:
        throw new GeneralSecurityException("Invalid signature");
    L10:
        if (EllipticCurves.isValidDerEncoding(signature) == false) goto L20;
        List<Provider> r1 = EngineFactory.toProviderList(new String[]{"GmsCore_OpenSSL", "AndroidOpenSSL", "Conscrypt"});
        Signature r2 = EngineFactory.SIGNATURE.getInstance(this.signatureAlgorithm, r1);
        r2.initVerify(this.publicKey);
        r2.update(data);
        boolean r4 = r2.verify(signature);     // Catch: RuntimeException -> L14
    L15:
        if (r4 == false) goto L18;
        return;
    L18:
        throw new GeneralSecurityException("Invalid signature");
    L14:
        r4 = false;
        goto L15
    L20:
        throw new GeneralSecurityException("Invalid signature");
    }

    @Override // com.google.crypto.tink.PublicKeyVerify
    public void verify(final byte[] signature, final byte[] data) throws GeneralSecurityException {
        byte[] r0 = this.outputPrefix;
        if (r0.length != 0) goto L9;
        if (this.messageSuffix.length != 0) goto L9;
        noPrefixVerify(signature, data);
        return;
    L9:
        if (Util.isPrefix(r0, signature) == false) goto L16;
        byte[] r1 = this.messageSuffix;
        if (r1.length == 0) goto L13;
        data = Bytes.concat(new byte[][]{data, r1});
    L13:
        noPrefixVerify(Arrays.copyOfRange(signature, this.outputPrefix.length, signature.length), data);
        return;
    L16:
        throw new GeneralSecurityException("Invalid signature (output prefix mismatch)");
    }
}
