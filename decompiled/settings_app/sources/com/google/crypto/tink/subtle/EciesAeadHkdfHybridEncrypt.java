package com.google.crypto.tink.subtle;

import com.google.crypto.tink.HybridEncrypt;
import com.google.crypto.tink.Parameters;
import com.google.crypto.tink.aead.AesCtrHmacAeadParameters;
import com.google.crypto.tink.aead.AesGcmParameters;
import com.google.crypto.tink.daead.AesSivParameters;
import com.google.crypto.tink.hybrid.EciesParameters;
import com.google.crypto.tink.hybrid.EciesPublicKey;
import com.google.crypto.tink.internal.EnumTypeProtoConverter;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.security.interfaces.ECPublicKey;

/* JADX INFO: loaded from: classes4.dex */
public final class EciesAeadHkdfHybridEncrypt implements HybridEncrypt {
    static final EnumTypeProtoConverter<EllipticCurves.CurveType, EciesParameters.CurveType> CURVE_TYPE_CONVERTER = null;
    private static final byte[] EMPTY_AAD = null;
    static final EnumTypeProtoConverter<EllipticCurves.PointFormatType, EciesParameters.PointFormat> POINT_FORMAT_TYPE_CONVERTER = null;
    private final EciesAeadHkdfDemHelper demHelper;
    private final EllipticCurves.PointFormatType ecPointFormat;
    private final String hkdfHmacAlgo;
    private final byte[] hkdfSalt;
    private final byte[] outputPrefix;
    private final EciesHkdfSenderKem senderKem;

    static {
        EMPTY_AAD = new byte[0];
        CURVE_TYPE_CONVERTER = EnumTypeProtoConverter.builder().add(EllipticCurves.CurveType.NIST_P256, EciesParameters.CurveType.NIST_P256).add(EllipticCurves.CurveType.NIST_P384, EciesParameters.CurveType.NIST_P384).add(EllipticCurves.CurveType.NIST_P521, EciesParameters.CurveType.NIST_P521).build();
        POINT_FORMAT_TYPE_CONVERTER = EnumTypeProtoConverter.builder().add(EllipticCurves.PointFormatType.UNCOMPRESSED, EciesParameters.PointFormat.UNCOMPRESSED).add(EllipticCurves.PointFormatType.COMPRESSED, EciesParameters.PointFormat.COMPRESSED).add(EllipticCurves.PointFormatType.DO_NOT_USE_CRUNCHY_UNCOMPRESSED, EciesParameters.PointFormat.LEGACY_UNCOMPRESSED).build();
    }

    private static EciesAeadHkdfDemHelper createHelperAesGcm(final AesGcmParameters parameters) {
        return new AnonymousClass1(parameters);
    }

    private static EciesAeadHkdfDemHelper createHelperAesCtrHmac(final AesCtrHmacAeadParameters parameters) {
        return new AnonymousClass2(parameters);
    }

    private static EciesAeadHkdfDemHelper createHelperAesSiv(final AesSivParameters parameters) {
        return new AnonymousClass3(parameters);
    }

    static EciesAeadHkdfDemHelper createHelper(Parameters parameters) throws GeneralSecurityException {
        if ((parameters instanceof AesGcmParameters) == false) goto L7;
        return createHelperAesGcm((AesGcmParameters) parameters);
    L7:
        if ((parameters instanceof AesCtrHmacAeadParameters) == false) goto L11;
        return createHelperAesCtrHmac((AesCtrHmacAeadParameters) parameters);
    L11:
        if ((parameters instanceof AesSivParameters) == false) goto L15;
        return createHelperAesSiv((AesSivParameters) parameters);
    L15:
        throw new GeneralSecurityException("Unsupported parameters for Ecies: " + parameters);
    }

    static final String toHmacAlgo(EciesParameters.HashType hash) throws GeneralSecurityException {
        if (hash.equals(EciesParameters.HashType.SHA1) == false) goto L7;
        return "HmacSha1";
    L7:
        if (hash.equals(EciesParameters.HashType.SHA224) == false) goto L11;
        return "HmacSha224";
    L11:
        if (hash.equals(EciesParameters.HashType.SHA256) == false) goto L15;
        return "HmacSha256";
    L15:
        if (hash.equals(EciesParameters.HashType.SHA384) == false) goto L19;
        return "HmacSha384";
    L19:
        if (hash.equals(EciesParameters.HashType.SHA512) == false) goto L23;
        return "HmacSha512";
    L23:
        throw new GeneralSecurityException("hash unsupported for EciesAeadHkdf: " + hash);
    }

    private EciesAeadHkdfHybridEncrypt(final ECPublicKey recipientPublicKey, final byte[] hkdfSalt, String hkdfHmacAlgo, EllipticCurves.PointFormatType ecPointFormat, EciesAeadHkdfDemHelper demHelper, byte[] outputPrefix) throws GeneralSecurityException {
        EllipticCurves.checkPublicKey(recipientPublicKey);
        this.senderKem = new EciesHkdfSenderKem(recipientPublicKey);
        this.hkdfSalt = hkdfSalt;
        this.hkdfHmacAlgo = hkdfHmacAlgo;
        this.ecPointFormat = ecPointFormat;
        this.demHelper = demHelper;
        this.outputPrefix = outputPrefix;
    }

    public static HybridEncrypt create(EciesPublicKey key) throws GeneralSecurityException {
        ECPublicKey r4 = EllipticCurves.getEcPublicKey((EllipticCurves.CurveType) CURVE_TYPE_CONVERTER.toProtoEnum(key.getParameters().getCurveType()), key.getNistCurvePoint().getAffineX().toByteArray(), key.getNistCurvePoint().getAffineY().toByteArray());
        byte[] r0 = new byte[0];
        if (key.getParameters().getSalt() == null) goto L6;
        r0 = key.getParameters().getSalt().toByteArray();
    L6:
        return new EciesAeadHkdfHybridEncrypt(r4, r0, toHmacAlgo(key.getParameters().getHashType()), (EllipticCurves.PointFormatType) POINT_FORMAT_TYPE_CONVERTER.toProtoEnum(key.getParameters().getNistCurvePointFormat()), createHelper(key.getParameters().getDemParameters()), key.getOutputPrefix().toByteArray());
    }

    public byte[] noPrefixEncrypt(final byte[] plaintext, final byte[] contextInfo) throws GeneralSecurityException {
        EciesHkdfSenderKem.KemKey r8 = this.senderKem.generateKey(this.hkdfHmacAlgo, this.hkdfSalt, contextInfo, this.demHelper.getSymmetricKeySizeInBytes(), this.ecPointFormat);
        byte[] r6 = this.demHelper.getAeadOrDaead(r8.getSymmetricKey()).encrypt(plaintext, EMPTY_AAD);
        byte[] r7 = r8.getKemBytes();
        return ByteBuffer.allocate(r7.length + r6.length).put(r7).put(r6).array();
    }

    @Override // com.google.crypto.tink.HybridEncrypt
    public byte[] encrypt(final byte[] plaintext, final byte[] contextInfo) throws GeneralSecurityException {
        byte[] r2 = noPrefixEncrypt(plaintext, contextInfo);
        byte[] r1 = this.outputPrefix;
        if (r1.length != 0) goto L6;
        return r2;
    L6:
        return Bytes.concat(new byte[][]{r1, r2});
    }
}
