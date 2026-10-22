package com.google.crypto.tink.hybrid.internal;

import com.google.crypto.tink.SecretKeyAccess;
import com.google.crypto.tink.TinkProtoParametersFormat;
import com.google.crypto.tink.hybrid.EciesParameters;
import com.google.crypto.tink.hybrid.EciesPrivateKey;
import com.google.crypto.tink.hybrid.EciesPublicKey;
import com.google.crypto.tink.internal.BigIntegerEncoding;
import com.google.crypto.tink.internal.EnumTypeProtoConverter;
import com.google.crypto.tink.internal.KeyParser;
import com.google.crypto.tink.internal.KeySerializer;
import com.google.crypto.tink.internal.MutableSerializationRegistry;
import com.google.crypto.tink.internal.ParametersParser;
import com.google.crypto.tink.internal.ParametersSerializer;
import com.google.crypto.tink.internal.ProtoKeySerialization;
import com.google.crypto.tink.internal.ProtoParametersSerialization;
import com.google.crypto.tink.internal.Util;
import com.google.crypto.tink.proto.EcPointFormat;
import com.google.crypto.tink.proto.EciesAeadDemParams;
import com.google.crypto.tink.proto.EciesAeadHkdfKeyFormat;
import com.google.crypto.tink.proto.EciesAeadHkdfParams;
import com.google.crypto.tink.proto.EciesAeadHkdfPrivateKey;
import com.google.crypto.tink.proto.EciesAeadHkdfPublicKey;
import com.google.crypto.tink.proto.EciesHkdfKemParams;
import com.google.crypto.tink.proto.EllipticCurveType;
import com.google.crypto.tink.proto.HashType;
import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.proto.KeyTemplate;
import com.google.crypto.tink.proto.OutputPrefixType;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.util.Bytes;
import com.google.crypto.tink.util.SecretBigInteger;
import com.google.crypto.tink.util.SecretBytes;
import java.security.GeneralSecurityException;
import java.security.spec.ECPoint;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class EciesProtoSerialization {
    private static final EnumTypeProtoConverter<EllipticCurveType, EciesParameters.CurveType> CURVE_TYPE_CONVERTER = null;
    private static final EnumTypeProtoConverter<HashType, EciesParameters.HashType> HASH_TYPE_CONVERTER = null;
    private static final ParametersParser<ProtoParametersSerialization> PARAMETERS_PARSER = null;
    private static final ParametersSerializer<EciesParameters, ProtoParametersSerialization> PARAMETERS_SERIALIZER = null;
    private static final EnumTypeProtoConverter<EcPointFormat, EciesParameters.PointFormat> POINT_FORMAT_CONVERTER = null;
    private static final KeyParser<ProtoKeySerialization> PRIVATE_KEY_PARSER = null;
    private static final KeySerializer<EciesPrivateKey, ProtoKeySerialization> PRIVATE_KEY_SERIALIZER = null;
    private static final String PRIVATE_TYPE_URL = "type.googleapis.com/google.crypto.tink.EciesAeadHkdfPrivateKey";
    private static final Bytes PRIVATE_TYPE_URL_BYTES = null;
    private static final KeyParser<ProtoKeySerialization> PUBLIC_KEY_PARSER = null;
    private static final KeySerializer<EciesPublicKey, ProtoKeySerialization> PUBLIC_KEY_SERIALIZER = null;
    private static final String PUBLIC_TYPE_URL = "type.googleapis.com/google.crypto.tink.EciesAeadHkdfPublicKey";
    private static final Bytes PUBLIC_TYPE_URL_BYTES = null;
    private static final EnumTypeProtoConverter<OutputPrefixType, EciesParameters.Variant> VARIANT_CONVERTER = null;

    public static /* synthetic */ ProtoKeySerialization $r8$lambda$0Z80GoABvRMzD__VOGSVSueQCi0(EciesPublicKey r0, SecretKeyAccess r1) {
        return serializePublicKey(r0, r1);
    }

    public static /* synthetic */ EciesPrivateKey $r8$lambda$2FdSZNQPVxA3YWeKP5rGkKJH2OY(ProtoKeySerialization r0, SecretKeyAccess r1) {
        return parsePrivateKey(r0, r1);
    }

    public static /* synthetic */ EciesParameters $r8$lambda$VBl4kvYkjDvkwAloVEOVfskt3qU(ProtoParametersSerialization r0) {
        return parseParameters(r0);
    }

    /* JADX INFO: renamed from: $r8$lambda$aYITg9DAc0jtMcMvuN-vXKc5ozM, reason: not valid java name */
    public static /* synthetic */ ProtoKeySerialization m928$r8$lambda$aYITg9DAc0jtMcMvuNvXKc5ozM(EciesPrivateKey r0, SecretKeyAccess r1) {
        return serializePrivateKey(r0, r1);
    }

    public static /* synthetic */ EciesPublicKey $r8$lambda$pbwddghZw56fjr1K9OmX7cmcryY(ProtoKeySerialization r0, SecretKeyAccess r1) {
        return parsePublicKey(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$qyg-_a5cwec_Usaf9ZXcbcvmOwU, reason: not valid java name */
    public static /* synthetic */ ProtoParametersSerialization m929$r8$lambda$qyg_a5cwec_Usaf9ZXcbcvmOwU(EciesParameters r0) {
        return serializeParameters(r0);
    }

    static {
        Bytes r0 = Util.toBytesFromPrintableAscii(PRIVATE_TYPE_URL);
        PRIVATE_TYPE_URL_BYTES = r0;
        Bytes r1 = Util.toBytesFromPrintableAscii(PUBLIC_TYPE_URL);
        PUBLIC_TYPE_URL_BYTES = r1;
        PARAMETERS_SERIALIZER = ParametersSerializer.create(new EciesProtoSerialization$$ExternalSyntheticLambda0(), EciesParameters.class, ProtoParametersSerialization.class);
        PARAMETERS_PARSER = ParametersParser.create(new EciesProtoSerialization$$ExternalSyntheticLambda1(), r0, ProtoParametersSerialization.class);
        PUBLIC_KEY_SERIALIZER = KeySerializer.create(new EciesProtoSerialization$$ExternalSyntheticLambda2(), EciesPublicKey.class, ProtoKeySerialization.class);
        PUBLIC_KEY_PARSER = KeyParser.create(new EciesProtoSerialization$$ExternalSyntheticLambda3(), r1, ProtoKeySerialization.class);
        PRIVATE_KEY_SERIALIZER = KeySerializer.create(new EciesProtoSerialization$$ExternalSyntheticLambda4(), EciesPrivateKey.class, ProtoKeySerialization.class);
        PRIVATE_KEY_PARSER = KeyParser.create(new EciesProtoSerialization$$ExternalSyntheticLambda5(), r0, ProtoKeySerialization.class);
        VARIANT_CONVERTER = EnumTypeProtoConverter.builder().add(OutputPrefixType.RAW, EciesParameters.Variant.NO_PREFIX).add(OutputPrefixType.TINK, EciesParameters.Variant.TINK).add(OutputPrefixType.LEGACY, EciesParameters.Variant.CRUNCHY).add(OutputPrefixType.CRUNCHY, EciesParameters.Variant.CRUNCHY).build();
        HASH_TYPE_CONVERTER = EnumTypeProtoConverter.builder().add(HashType.SHA1, EciesParameters.HashType.SHA1).add(HashType.SHA224, EciesParameters.HashType.SHA224).add(HashType.SHA256, EciesParameters.HashType.SHA256).add(HashType.SHA384, EciesParameters.HashType.SHA384).add(HashType.SHA512, EciesParameters.HashType.SHA512).build();
        CURVE_TYPE_CONVERTER = EnumTypeProtoConverter.builder().add(EllipticCurveType.NIST_P256, EciesParameters.CurveType.NIST_P256).add(EllipticCurveType.NIST_P384, EciesParameters.CurveType.NIST_P384).add(EllipticCurveType.NIST_P521, EciesParameters.CurveType.NIST_P521).add(EllipticCurveType.CURVE25519, EciesParameters.CurveType.X25519).build();
        POINT_FORMAT_CONVERTER = EnumTypeProtoConverter.builder().add(EcPointFormat.UNCOMPRESSED, EciesParameters.PointFormat.UNCOMPRESSED).add(EcPointFormat.COMPRESSED, EciesParameters.PointFormat.COMPRESSED).add(EcPointFormat.DO_NOT_USE_CRUNCHY_UNCOMPRESSED, EciesParameters.PointFormat.LEGACY_UNCOMPRESSED).build();
    }

    public static void register() throws GeneralSecurityException {
        register(MutableSerializationRegistry.globalInstance());
    }

    public static void register(MutableSerializationRegistry registry) throws GeneralSecurityException {
        registry.registerParametersSerializer(PARAMETERS_SERIALIZER);
        registry.registerParametersParser(PARAMETERS_PARSER);
        registry.registerKeySerializer(PUBLIC_KEY_SERIALIZER);
        registry.registerKeyParser(PUBLIC_KEY_PARSER);
        registry.registerKeySerializer(PRIVATE_KEY_SERIALIZER);
        registry.registerKeyParser(PRIVATE_KEY_PARSER);
    }

    private static EciesAeadHkdfParams toProtoParameters(EciesParameters parameters) throws GeneralSecurityException {
        EciesHkdfKemParams.Builder r0 = EciesHkdfKemParams.newBuilder().setCurveType((EllipticCurveType) CURVE_TYPE_CONVERTER.toProtoEnum(parameters.getCurveType())).setHkdfHashType((HashType) HASH_TYPE_CONVERTER.toProtoEnum(parameters.getHashType()));
        if (parameters.getSalt() != null) goto L5;
    L7:
        EciesHkdfKemParams r1 = (EciesHkdfKemParams) r0.build();
        KeyTemplate r2 = KeyTemplate.parseFrom(TinkProtoParametersFormat.serialize(parameters.getDemParameters()), ExtensionRegistryLite.getEmptyRegistry());     // Catch: InvalidProtocolBufferException -> L14
        EciesAeadDemParams r3 = (EciesAeadDemParams) EciesAeadDemParams.newBuilder().setAeadDem((KeyTemplate) KeyTemplate.newBuilder().setTypeUrl(r2.getTypeUrl()).setOutputPrefixType(OutputPrefixType.TINK).setValue(r2.getValue()).build()).build();     // Catch: InvalidProtocolBufferException -> L14
        EciesParameters.PointFormat r5 = parameters.getNistCurvePointFormat();
        if (r5 != null) goto L13;
        r5 = EciesParameters.PointFormat.COMPRESSED;
    L13:
        return (EciesAeadHkdfParams) EciesAeadHkdfParams.newBuilder().setKemParams(r1).setDemParams(r3).setEcPointFormat((EcPointFormat) POINT_FORMAT_CONVERTER.toProtoEnum(r5)).build();
    L14:
        e = move-exception;
        throw new GeneralSecurityException("Parsing EciesParameters failed: ", e);
    L5:
        if (parameters.getSalt().size() <= 0) goto L7;
        r0.setHkdfSalt(ByteString.copyFrom(parameters.getSalt().toByteArray()));
        goto L7
    }

    private static EciesParameters fromProtoParameters(OutputPrefixType outputPrefixType, EciesAeadHkdfParams protoParams) throws GeneralSecurityException {
        KeyTemplate r0 = (KeyTemplate) KeyTemplate.newBuilder().setTypeUrl(protoParams.getDemParams().getAeadDem().getTypeUrl()).setOutputPrefixType(OutputPrefixType.RAW).setValue(protoParams.getDemParams().getAeadDem().getValue()).build();
        EciesParameters.Builder r3 = EciesParameters.builder().setVariant(VARIANT_CONVERTER.fromProtoEnum(outputPrefixType)).setCurveType(CURVE_TYPE_CONVERTER.fromProtoEnum(protoParams.getKemParams().getCurveType())).setHashType(HASH_TYPE_CONVERTER.fromProtoEnum(protoParams.getKemParams().getHkdfHashType())).setDemParameters(TinkProtoParametersFormat.parse(r0.toByteArray())).setSalt(Bytes.copyFrom(protoParams.getKemParams().getHkdfSalt().toByteArray()));
        if (protoParams.getKemParams().getCurveType().equals(EllipticCurveType.CURVE25519) == true) goto L6;
        r3.setNistCurvePointFormat(POINT_FORMAT_CONVERTER.fromProtoEnum(protoParams.getEcPointFormat()));
    L8:
        return r3.build();
    L6:
        if (protoParams.getEcPointFormat().equals(EcPointFormat.COMPRESSED) == true) goto L8;
        throw new GeneralSecurityException("For CURVE25519 EcPointFormat must be compressed");
    }

    private static int getEncodingLength(EciesParameters.CurveType curveType) throws GeneralSecurityException {
        if (EciesParameters.CurveType.NIST_P256.equals(curveType) == false) goto L7;
        return 33;
    L7:
        if (EciesParameters.CurveType.NIST_P384.equals(curveType) == false) goto L11;
        return 49;
    L11:
        if (EciesParameters.CurveType.NIST_P521.equals(curveType) == false) goto L15;
        return 67;
    L15:
        throw new GeneralSecurityException("Unable to serialize CurveType " + curveType);
    }

    private static EciesAeadHkdfPublicKey toProtoPublicKey(EciesPublicKey key) throws GeneralSecurityException {
        if (key.getParameters().getCurveType().equals(EciesParameters.CurveType.X25519) == true) goto L5;
        int r0 = getEncodingLength(key.getParameters().getCurveType());
        ECPoint r2 = key.getNistCurvePoint();
        if (r2 == null) goto L11;
        return (EciesAeadHkdfPublicKey) EciesAeadHkdfPublicKey.newBuilder().setVersion(0).setParams(toProtoParameters(key.getParameters())).setX(ByteString.copyFrom(BigIntegerEncoding.toBigEndianBytesOfFixedLength(r2.getAffineX(), r0))).setY(ByteString.copyFrom(BigIntegerEncoding.toBigEndianBytesOfFixedLength(r2.getAffineY(), r0))).build();
    L11:
        throw new GeneralSecurityException("NistCurvePoint was null for NIST curve");
    L5:
        return (EciesAeadHkdfPublicKey) EciesAeadHkdfPublicKey.newBuilder().setVersion(0).setParams(toProtoParameters(key.getParameters())).setX(ByteString.copyFrom(key.getX25519CurvePointBytes().toByteArray())).setY(ByteString.EMPTY).build();
    }

    private static EciesAeadHkdfPrivateKey toProtoPrivateKey(EciesPrivateKey key, @Nullable SecretKeyAccess access) throws GeneralSecurityException {
        EciesAeadHkdfPrivateKey.Builder r0 = EciesAeadHkdfPrivateKey.newBuilder().setVersion(0).setPublicKey(toProtoPublicKey(key.getPublicKey()));
        if (key.getParameters().getCurveType().equals(EciesParameters.CurveType.X25519) == false) goto L5;
        r0.setKeyValue(ByteString.copyFrom(key.getX25519PrivateKeyBytes().toByteArray(SecretKeyAccess.requireAccess(access))));
    L7:
        return (EciesAeadHkdfPrivateKey) r0.build();
    L5:
        int r1 = getEncodingLength(key.getParameters().getCurveType());
        r0.setKeyValue(ByteString.copyFrom(BigIntegerEncoding.toBigEndianBytesOfFixedLength(key.getNistPrivateKeyValue().getBigInteger(SecretKeyAccess.requireAccess(access)), r1)));
        goto L7
    }

    private static ProtoParametersSerialization serializeParameters(EciesParameters parameters) throws GeneralSecurityException {
        return ProtoParametersSerialization.create((KeyTemplate) KeyTemplate.newBuilder().setTypeUrl(PRIVATE_TYPE_URL).setValue(((EciesAeadHkdfKeyFormat) EciesAeadHkdfKeyFormat.newBuilder().setParams(toProtoParameters(parameters)).build()).toByteString()).setOutputPrefixType((OutputPrefixType) VARIANT_CONVERTER.toProtoEnum(parameters.getVariant())).build());
    }

    private static ProtoKeySerialization serializePublicKey(EciesPublicKey key, @Nullable SecretKeyAccess access) throws GeneralSecurityException {
        return ProtoKeySerialization.create(PUBLIC_TYPE_URL, toProtoPublicKey(key).toByteString(), KeyData.KeyMaterialType.ASYMMETRIC_PUBLIC, (OutputPrefixType) VARIANT_CONVERTER.toProtoEnum(key.getParameters().getVariant()), key.getIdRequirementOrNull());
    }

    private static ProtoKeySerialization serializePrivateKey(EciesPrivateKey key, @Nullable SecretKeyAccess access) throws GeneralSecurityException {
        return ProtoKeySerialization.create(PRIVATE_TYPE_URL, toProtoPrivateKey(key, access).toByteString(), KeyData.KeyMaterialType.ASYMMETRIC_PRIVATE, (OutputPrefixType) VARIANT_CONVERTER.toProtoEnum(key.getParameters().getVariant()), key.getIdRequirementOrNull());
    }

    private static EciesParameters parseParameters(ProtoParametersSerialization serialization) throws GeneralSecurityException {
        if (serialization.getKeyTemplate().getTypeUrl().equals(PRIVATE_TYPE_URL) == false) goto L11;
        return fromProtoParameters(serialization.getKeyTemplate().getOutputPrefixType(), EciesAeadHkdfKeyFormat.parseFrom(serialization.getKeyTemplate().getValue(), ExtensionRegistryLite.getEmptyRegistry()).getParams());
    L7:
        e = move-exception;
        throw new GeneralSecurityException("Parsing EciesParameters failed: ", e);
    L11:
        throw new IllegalArgumentException("Wrong type URL in call to EciesProtoSerialization.parseParameters: " + serialization.getKeyTemplate().getTypeUrl());
    }

    private static EciesPublicKey parsePublicKey(ProtoKeySerialization serialization, @Nullable SecretKeyAccess access) throws GeneralSecurityException {
        if (serialization.getTypeUrl().equals(PUBLIC_TYPE_URL) == false) goto L21;
        EciesAeadHkdfPublicKey r4 = EciesAeadHkdfPublicKey.parseFrom(serialization.getValue(), ExtensionRegistryLite.getEmptyRegistry());     // Catch: Throwable -> L18
        if (r4.getVersion() != 0) goto L17;
        EciesParameters r0 = fromProtoParameters(serialization.getOutputPrefixType(), r4.getParams());     // Catch: Throwable -> L18
        if (r0.getCurveType().equals(EciesParameters.CurveType.X25519) == false) goto L15;
        if (r4.getY().isEmpty() == false) goto L13;
        return EciesPublicKey.createForCurveX25519(r0, Bytes.copyFrom(r4.getX().toByteArray()), serialization.getIdRequirementOrNull());
    L13:
        throw new GeneralSecurityException("Y must be empty for X25519 points");     // Catch: Throwable -> L18
    L15:
        return EciesPublicKey.createForNistCurve(r0, new ECPoint(BigIntegerEncoding.fromUnsignedBigEndianBytes(r4.getX().toByteArray()), BigIntegerEncoding.fromUnsignedBigEndianBytes(r4.getY().toByteArray())), serialization.getIdRequirementOrNull());
    L17:
        throw new GeneralSecurityException("Only version 0 keys are accepted");     // Catch: Throwable -> L18
    L19:
        throw new GeneralSecurityException("Parsing EcdsaPublicKey failed");
    L21:
        throw new IllegalArgumentException("Wrong type URL in call to EciesProtoSerialization.parsePublicKey: " + serialization.getTypeUrl());
    }

    private static EciesPrivateKey parsePrivateKey(ProtoKeySerialization serialization, @Nullable SecretKeyAccess access) throws GeneralSecurityException {
        if (serialization.getTypeUrl().equals(PRIVATE_TYPE_URL) == false) goto L17;
        EciesAeadHkdfPrivateKey r0 = EciesAeadHkdfPrivateKey.parseFrom(serialization.getValue(), ExtensionRegistryLite.getEmptyRegistry());     // Catch: Throwable -> L14
        if (r0.getVersion() != 0) goto L13;
        EciesAeadHkdfPublicKey r1 = r0.getPublicKey();     // Catch: Throwable -> L14
        EciesParameters r2 = fromProtoParameters(serialization.getOutputPrefixType(), r1.getParams());     // Catch: Throwable -> L14
        if (r2.getCurveType().equals(EciesParameters.CurveType.X25519) == false) goto L11;
        return EciesPrivateKey.createForCurveX25519(EciesPublicKey.createForCurveX25519(r2, Bytes.copyFrom(r1.getX().toByteArray()), serialization.getIdRequirementOrNull()), SecretBytes.copyFrom(r0.getKeyValue().toByteArray(), SecretKeyAccess.requireAccess(access)));
    L11:
        return EciesPrivateKey.createForNistCurve(EciesPublicKey.createForNistCurve(r2, new ECPoint(BigIntegerEncoding.fromUnsignedBigEndianBytes(r1.getX().toByteArray()), BigIntegerEncoding.fromUnsignedBigEndianBytes(r1.getY().toByteArray())), serialization.getIdRequirementOrNull()), SecretBigInteger.fromBigInteger(BigIntegerEncoding.fromUnsignedBigEndianBytes(r0.getKeyValue().toByteArray()), SecretKeyAccess.requireAccess(access)));
    L13:
        throw new GeneralSecurityException("Only version 0 keys are accepted");     // Catch: Throwable -> L14
    L15:
        throw new GeneralSecurityException("Parsing EcdsaPrivateKey failed");
    L17:
        throw new IllegalArgumentException("Wrong type URL in call to EciesProtoSerialization.parsePrivateKey: " + serialization.getTypeUrl());
    }

    private EciesProtoSerialization() {
    }
}
