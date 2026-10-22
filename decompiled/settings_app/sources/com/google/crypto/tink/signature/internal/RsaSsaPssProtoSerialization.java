package com.google.crypto.tink.signature.internal;

import com.google.crypto.tink.SecretKeyAccess;
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
import com.google.crypto.tink.proto.HashType;
import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.proto.KeyTemplate;
import com.google.crypto.tink.proto.OutputPrefixType;
import com.google.crypto.tink.proto.RsaSsaPssKeyFormat;
import com.google.crypto.tink.proto.RsaSsaPssParams;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.signature.RsaSsaPssParameters;
import com.google.crypto.tink.signature.RsaSsaPssPrivateKey;
import com.google.crypto.tink.signature.RsaSsaPssPublicKey;
import com.google.crypto.tink.util.Bytes;
import com.google.crypto.tink.util.SecretBigInteger;
import java.math.BigInteger;
import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class RsaSsaPssProtoSerialization {
    private static final EnumTypeProtoConverter<HashType, RsaSsaPssParameters.HashType> HASH_TYPE_CONVERTER = null;
    private static final ParametersParser<ProtoParametersSerialization> PARAMETERS_PARSER = null;
    private static final ParametersSerializer<RsaSsaPssParameters, ProtoParametersSerialization> PARAMETERS_SERIALIZER = null;
    private static final KeyParser<ProtoKeySerialization> PRIVATE_KEY_PARSER = null;
    private static final KeySerializer<RsaSsaPssPrivateKey, ProtoKeySerialization> PRIVATE_KEY_SERIALIZER = null;
    private static final String PRIVATE_TYPE_URL = "type.googleapis.com/google.crypto.tink.RsaSsaPssPrivateKey";
    private static final Bytes PRIVATE_TYPE_URL_BYTES = null;
    private static final KeyParser<ProtoKeySerialization> PUBLIC_KEY_PARSER = null;
    private static final KeySerializer<RsaSsaPssPublicKey, ProtoKeySerialization> PUBLIC_KEY_SERIALIZER = null;
    private static final String PUBLIC_TYPE_URL = "type.googleapis.com/google.crypto.tink.RsaSsaPssPublicKey";
    private static final Bytes PUBLIC_TYPE_URL_BYTES = null;
    private static final EnumTypeProtoConverter<OutputPrefixType, RsaSsaPssParameters.Variant> VARIANT_CONVERTER = null;

    /* JADX INFO: renamed from: $r8$lambda$-wT4Ceep-mRntLK0hogv9AK2i50, reason: not valid java name */
    public static /* synthetic */ ProtoKeySerialization m963$r8$lambda$wT4CeepmRntLK0hogv9AK2i50(RsaSsaPssPublicKey r0, SecretKeyAccess r1) {
        return serializePublicKey(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$CT0Mq-uJD99zevydW0Q5BJjjfeA, reason: not valid java name */
    public static /* synthetic */ RsaSsaPssParameters m964$r8$lambda$CT0MquJD99zevydW0Q5BJjjfeA(ProtoParametersSerialization r0) {
        return parseParameters(r0);
    }

    public static /* synthetic */ ProtoKeySerialization $r8$lambda$Ffourxb4T_6BP3IPusf4negYn5g(RsaSsaPssPrivateKey r0, SecretKeyAccess r1) {
        return serializePrivateKey(r0, r1);
    }

    public static /* synthetic */ RsaSsaPssPrivateKey $r8$lambda$QPl28yvsCtkh5zJJYDxoSNXmp00(ProtoKeySerialization r0, SecretKeyAccess r1) {
        return parsePrivateKey(r0, r1);
    }

    public static /* synthetic */ RsaSsaPssPublicKey $r8$lambda$WUHS2a8ige8Nk9MXwUS9XDQRvAc(ProtoKeySerialization r0, SecretKeyAccess r1) {
        return parsePublicKey(r0, r1);
    }

    public static /* synthetic */ ProtoParametersSerialization $r8$lambda$ntun5_gLGaEDoSuNri6VMR_ZN6M(RsaSsaPssParameters r0) {
        return serializeParameters(r0);
    }

    static {
        Bytes r0 = Util.toBytesFromPrintableAscii(PRIVATE_TYPE_URL);
        PRIVATE_TYPE_URL_BYTES = r0;
        Bytes r1 = Util.toBytesFromPrintableAscii(PUBLIC_TYPE_URL);
        PUBLIC_TYPE_URL_BYTES = r1;
        PARAMETERS_SERIALIZER = ParametersSerializer.create(new RsaSsaPssProtoSerialization$$ExternalSyntheticLambda0(), RsaSsaPssParameters.class, ProtoParametersSerialization.class);
        PARAMETERS_PARSER = ParametersParser.create(new RsaSsaPssProtoSerialization$$ExternalSyntheticLambda1(), r0, ProtoParametersSerialization.class);
        PUBLIC_KEY_SERIALIZER = KeySerializer.create(new RsaSsaPssProtoSerialization$$ExternalSyntheticLambda2(), RsaSsaPssPublicKey.class, ProtoKeySerialization.class);
        PUBLIC_KEY_PARSER = KeyParser.create(new RsaSsaPssProtoSerialization$$ExternalSyntheticLambda3(), r1, ProtoKeySerialization.class);
        PRIVATE_KEY_SERIALIZER = KeySerializer.create(new RsaSsaPssProtoSerialization$$ExternalSyntheticLambda4(), RsaSsaPssPrivateKey.class, ProtoKeySerialization.class);
        PRIVATE_KEY_PARSER = KeyParser.create(new RsaSsaPssProtoSerialization$$ExternalSyntheticLambda5(), r0, ProtoKeySerialization.class);
        VARIANT_CONVERTER = EnumTypeProtoConverter.builder().add(OutputPrefixType.RAW, RsaSsaPssParameters.Variant.NO_PREFIX).add(OutputPrefixType.TINK, RsaSsaPssParameters.Variant.TINK).add(OutputPrefixType.CRUNCHY, RsaSsaPssParameters.Variant.CRUNCHY).add(OutputPrefixType.LEGACY, RsaSsaPssParameters.Variant.LEGACY).build();
        HASH_TYPE_CONVERTER = EnumTypeProtoConverter.builder().add(HashType.SHA256, RsaSsaPssParameters.HashType.SHA256).add(HashType.SHA384, RsaSsaPssParameters.HashType.SHA384).add(HashType.SHA512, RsaSsaPssParameters.HashType.SHA512).build();
    }

    private static RsaSsaPssParams getProtoParams(RsaSsaPssParameters parameters) throws GeneralSecurityException {
        RsaSsaPssParams.Builder r0 = RsaSsaPssParams.newBuilder();
        EnumTypeProtoConverter<HashType, RsaSsaPssParameters.HashType> r1 = HASH_TYPE_CONVERTER;
        return (RsaSsaPssParams) r0.setSigHash((HashType) r1.toProtoEnum(parameters.getSigHashType())).setMgf1Hash((HashType) r1.toProtoEnum(parameters.getMgf1HashType())).setSaltLength(parameters.getSaltLengthBytes()).build();
    }

    private static ByteString encodeBigInteger(BigInteger i) {
        return ByteString.copyFrom(BigIntegerEncoding.toBigEndianBytes(i));
    }

    private static com.google.crypto.tink.proto.RsaSsaPssPublicKey getProtoPublicKey(RsaSsaPssPublicKey key) throws GeneralSecurityException {
        return (com.google.crypto.tink.proto.RsaSsaPssPublicKey) com.google.crypto.tink.proto.RsaSsaPssPublicKey.newBuilder().setParams(getProtoParams(key.getParameters())).setN(encodeBigInteger(key.getModulus())).setE(encodeBigInteger(key.getParameters().getPublicExponent())).setVersion(0).build();
    }

    private static ProtoParametersSerialization serializeParameters(RsaSsaPssParameters parameters) throws GeneralSecurityException {
        return ProtoParametersSerialization.create((KeyTemplate) KeyTemplate.newBuilder().setTypeUrl(PRIVATE_TYPE_URL).setValue(((RsaSsaPssKeyFormat) RsaSsaPssKeyFormat.newBuilder().setParams(getProtoParams(parameters)).setModulusSizeInBits(parameters.getModulusSizeBits()).setPublicExponent(encodeBigInteger(parameters.getPublicExponent())).build()).toByteString()).setOutputPrefixType((OutputPrefixType) VARIANT_CONVERTER.toProtoEnum(parameters.getVariant())).build());
    }

    private static ProtoKeySerialization serializePublicKey(RsaSsaPssPublicKey key, @Nullable SecretKeyAccess access) throws GeneralSecurityException {
        return ProtoKeySerialization.create(PUBLIC_TYPE_URL, getProtoPublicKey(key).toByteString(), KeyData.KeyMaterialType.ASYMMETRIC_PUBLIC, (OutputPrefixType) VARIANT_CONVERTER.toProtoEnum(key.getParameters().getVariant()), key.getIdRequirementOrNull());
    }

    private static ByteString encodeSecretBigInteger(SecretBigInteger i, SecretKeyAccess access) {
        return encodeBigInteger(i.getBigInteger(access));
    }

    private static ProtoKeySerialization serializePrivateKey(RsaSsaPssPrivateKey key, @Nullable SecretKeyAccess access) throws GeneralSecurityException {
        SecretKeyAccess r4 = SecretKeyAccess.requireAccess(access);
        return ProtoKeySerialization.create(PRIVATE_TYPE_URL, ((com.google.crypto.tink.proto.RsaSsaPssPrivateKey) com.google.crypto.tink.proto.RsaSsaPssPrivateKey.newBuilder().setVersion(0).setPublicKey(getProtoPublicKey(key.getPublicKey())).setD(encodeSecretBigInteger(key.getPrivateExponent(), r4)).setP(encodeSecretBigInteger(key.getPrimeP(), r4)).setQ(encodeSecretBigInteger(key.getPrimeQ(), r4)).setDp(encodeSecretBigInteger(key.getPrimeExponentP(), r4)).setDq(encodeSecretBigInteger(key.getPrimeExponentQ(), r4)).setCrt(encodeSecretBigInteger(key.getCrtCoefficient(), r4)).build()).toByteString(), KeyData.KeyMaterialType.ASYMMETRIC_PRIVATE, (OutputPrefixType) VARIANT_CONVERTER.toProtoEnum(key.getParameters().getVariant()), key.getIdRequirementOrNull());
    }

    private static BigInteger decodeBigInteger(ByteString data) {
        return BigIntegerEncoding.fromUnsignedBigEndianBytes(data.toByteArray());
    }

    private static RsaSsaPssParameters parseParameters(ProtoParametersSerialization serialization) throws GeneralSecurityException {
        if (serialization.getKeyTemplate().getTypeUrl().equals(PRIVATE_TYPE_URL) == false) goto L11;
        RsaSsaPssKeyFormat r0 = RsaSsaPssKeyFormat.parseFrom(serialization.getKeyTemplate().getValue(), ExtensionRegistryLite.getEmptyRegistry());     // Catch: InvalidProtocolBufferException -> L7
        RsaSsaPssParameters.Builder r1 = RsaSsaPssParameters.builder();
        EnumTypeProtoConverter<HashType, RsaSsaPssParameters.HashType> r2 = HASH_TYPE_CONVERTER;
        return r1.setSigHashType(r2.fromProtoEnum(r0.getParams().getSigHash())).setMgf1HashType(r2.fromProtoEnum(r0.getParams().getMgf1Hash())).setPublicExponent(decodeBigInteger(r0.getPublicExponent())).setModulusSizeBits(r0.getModulusSizeInBits()).setSaltLengthBytes(r0.getParams().getSaltLength()).setVariant(VARIANT_CONVERTER.fromProtoEnum(serialization.getKeyTemplate().getOutputPrefixType())).build();
    L7:
        e = move-exception;
        throw new GeneralSecurityException("Parsing RsaSsaPssParameters failed: ", e);
    L11:
        throw new IllegalArgumentException("Wrong type URL in call to RsaSsaPssProtoSerialization.parseParameters: " + serialization.getKeyTemplate().getTypeUrl());
    }

    private static RsaSsaPssPublicKey parsePublicKey(ProtoKeySerialization serialization, @Nullable SecretKeyAccess access) throws GeneralSecurityException {
        if (serialization.getTypeUrl().equals(PUBLIC_TYPE_URL) == false) goto L13;
        com.google.crypto.tink.proto.RsaSsaPssPublicKey r6 = com.google.crypto.tink.proto.RsaSsaPssPublicKey.parseFrom(serialization.getValue(), ExtensionRegistryLite.getEmptyRegistry());     // Catch: Throwable -> L10
        if (r6.getVersion() != 0) goto L9;
        BigInteger r0 = decodeBigInteger(r6.getN());     // Catch: Throwable -> L10
        int r1 = r0.bitLength();     // Catch: Throwable -> L10
        RsaSsaPssParameters.Builder r2 = RsaSsaPssParameters.builder();     // Catch: Throwable -> L10
        EnumTypeProtoConverter<HashType, RsaSsaPssParameters.HashType> r3 = HASH_TYPE_CONVERTER;     // Catch: Throwable -> L10
        return RsaSsaPssPublicKey.builder().setParameters(r2.setSigHashType(r3.fromProtoEnum(r6.getParams().getSigHash())).setMgf1HashType(r3.fromProtoEnum(r6.getParams().getMgf1Hash())).setPublicExponent(decodeBigInteger(r6.getE())).setModulusSizeBits(r1).setSaltLengthBytes(r6.getParams().getSaltLength()).setVariant(VARIANT_CONVERTER.fromProtoEnum(serialization.getOutputPrefixType())).build()).setModulus(r0).setIdRequirement(serialization.getIdRequirementOrNull()).build();
    L9:
        throw new GeneralSecurityException("Only version 0 keys are accepted");     // Catch: Throwable -> L10
    L11:
        throw new GeneralSecurityException("Parsing RsaSsaPssPublicKey failed");
    L13:
        throw new IllegalArgumentException("Wrong type URL in call to RsaSsaPssProtoSerialization.parsePublicKey: " + serialization.getTypeUrl());
    }

    private static SecretBigInteger decodeSecretBigInteger(ByteString data, SecretKeyAccess access) {
        return SecretBigInteger.fromBigInteger(BigIntegerEncoding.fromUnsignedBigEndianBytes(data.toByteArray()), access);
    }

    private static RsaSsaPssPrivateKey parsePrivateKey(ProtoKeySerialization serialization, @Nullable SecretKeyAccess access) throws GeneralSecurityException {
        if (serialization.getTypeUrl().equals(PRIVATE_TYPE_URL) == false) goto L13;
        com.google.crypto.tink.proto.RsaSsaPssPrivateKey r0 = com.google.crypto.tink.proto.RsaSsaPssPrivateKey.parseFrom(serialization.getValue(), ExtensionRegistryLite.getEmptyRegistry());     // Catch: Throwable -> L10
        if (r0.getVersion() != 0) goto L9;
        com.google.crypto.tink.proto.RsaSsaPssPublicKey r1 = r0.getPublicKey();     // Catch: Throwable -> L10
        BigInteger r2 = decodeBigInteger(r1.getN());     // Catch: Throwable -> L10
        int r3 = r2.bitLength();     // Catch: Throwable -> L10
        BigInteger r4 = decodeBigInteger(r1.getE());     // Catch: Throwable -> L10
        RsaSsaPssParameters.Builder r5 = RsaSsaPssParameters.builder();     // Catch: Throwable -> L10
        EnumTypeProtoConverter<HashType, RsaSsaPssParameters.HashType> r6 = HASH_TYPE_CONVERTER;     // Catch: Throwable -> L10
        RsaSsaPssPublicKey r8 = RsaSsaPssPublicKey.builder().setParameters(r5.setSigHashType(r6.fromProtoEnum(r1.getParams().getSigHash())).setMgf1HashType(r6.fromProtoEnum(r1.getParams().getMgf1Hash())).setPublicExponent(r4).setModulusSizeBits(r3).setSaltLengthBytes(r1.getParams().getSaltLength()).setVariant(VARIANT_CONVERTER.fromProtoEnum(serialization.getOutputPrefixType())).build()).setModulus(r2).setIdRequirement(serialization.getIdRequirementOrNull()).build();     // Catch: Throwable -> L10
        SecretKeyAccess r9 = SecretKeyAccess.requireAccess(access);     // Catch: Throwable -> L10
        return RsaSsaPssPrivateKey.builder().setPublicKey(r8).setPrimes(decodeSecretBigInteger(r0.getP(), r9), decodeSecretBigInteger(r0.getQ(), r9)).setPrivateExponent(decodeSecretBigInteger(r0.getD(), r9)).setPrimeExponents(decodeSecretBigInteger(r0.getDp(), r9), decodeSecretBigInteger(r0.getDq(), r9)).setCrtCoefficient(decodeSecretBigInteger(r0.getCrt(), r9)).build();
    L9:
        throw new GeneralSecurityException("Only version 0 keys are accepted");     // Catch: Throwable -> L10
    L11:
        throw new GeneralSecurityException("Parsing RsaSsaPssPrivateKey failed");
    L13:
        throw new IllegalArgumentException("Wrong type URL in call to RsaSsaPssProtoSerialization.parsePrivateKey: " + serialization.getTypeUrl());
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

    private RsaSsaPssProtoSerialization() {
    }
}
