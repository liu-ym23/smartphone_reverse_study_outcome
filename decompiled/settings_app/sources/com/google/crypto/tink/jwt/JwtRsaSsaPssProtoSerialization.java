package com.google.crypto.tink.jwt;

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
import com.google.crypto.tink.proto.JwtRsaSsaPssAlgorithm;
import com.google.crypto.tink.proto.JwtRsaSsaPssKeyFormat;
import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.proto.KeyTemplate;
import com.google.crypto.tink.proto.OutputPrefixType;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.util.Bytes;
import com.google.crypto.tink.util.SecretBigInteger;
import java.math.BigInteger;
import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
final class JwtRsaSsaPssProtoSerialization {
    private static final EnumTypeProtoConverter<JwtRsaSsaPssAlgorithm, JwtRsaSsaPssParameters.Algorithm> ALGORITHM_CONVERTER = null;
    private static final ParametersParser<ProtoParametersSerialization> PARAMETERS_PARSER = null;
    private static final ParametersSerializer<JwtRsaSsaPssParameters, ProtoParametersSerialization> PARAMETERS_SERIALIZER = null;
    private static final KeyParser<ProtoKeySerialization> PRIVATE_KEY_PARSER = null;
    private static final KeySerializer<JwtRsaSsaPssPrivateKey, ProtoKeySerialization> PRIVATE_KEY_SERIALIZER = null;
    private static final String PRIVATE_TYPE_URL = "type.googleapis.com/google.crypto.tink.JwtRsaSsaPssPrivateKey";
    private static final Bytes PRIVATE_TYPE_URL_BYTES = null;
    private static final KeyParser<ProtoKeySerialization> PUBLIC_KEY_PARSER = null;
    private static final KeySerializer<JwtRsaSsaPssPublicKey, ProtoKeySerialization> PUBLIC_KEY_SERIALIZER = null;
    private static final String PUBLIC_TYPE_URL = "type.googleapis.com/google.crypto.tink.JwtRsaSsaPssPublicKey";
    private static final Bytes PUBLIC_TYPE_URL_BYTES = null;

    public static /* synthetic */ ProtoKeySerialization $r8$lambda$75u48BVdQ7rCwNrgg8U_H1KEf98(JwtRsaSsaPssPrivateKey r0, SecretKeyAccess r1) {
        return serializePrivateKey(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$G3lGQN9aXbzlOWSXyu0eOV-acyY, reason: not valid java name */
    public static /* synthetic */ JwtRsaSsaPssPrivateKey m935$r8$lambda$G3lGQN9aXbzlOWSXyu0eOVacyY(ProtoKeySerialization r0, SecretKeyAccess r1) {
        return parsePrivateKey(r0, r1);
    }

    public static /* synthetic */ ProtoParametersSerialization $r8$lambda$OqHkwZvrzboLHJsLjPhzC_9DLdI(JwtRsaSsaPssParameters r0) {
        return serializeParameters(r0);
    }

    /* JADX INFO: renamed from: $r8$lambda$_DCdAhdDkSV6wYAgTF-iGGvpfvI, reason: not valid java name */
    public static /* synthetic */ JwtRsaSsaPssPublicKey m936$r8$lambda$_DCdAhdDkSV6wYAgTFiGGvpfvI(ProtoKeySerialization r0, SecretKeyAccess r1) {
        return parsePublicKey(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$cmOVl-wTx--WXqyNMYYY2J20Tdg, reason: not valid java name */
    public static /* synthetic */ JwtRsaSsaPssParameters m937$r8$lambda$cmOVlwTxWXqyNMYYY2J20Tdg(ProtoParametersSerialization r0) {
        return parseParameters(r0);
    }

    /* JADX INFO: renamed from: $r8$lambda$dwmoewNLMbmIvY-xh2no-kY2wQk, reason: not valid java name */
    public static /* synthetic */ ProtoKeySerialization m938$r8$lambda$dwmoewNLMbmIvYxh2nokY2wQk(JwtRsaSsaPssPublicKey r0, SecretKeyAccess r1) {
        return serializePublicKey(r0, r1);
    }

    static {
        Bytes r0 = Util.toBytesFromPrintableAscii(PRIVATE_TYPE_URL);
        PRIVATE_TYPE_URL_BYTES = r0;
        Bytes r1 = Util.toBytesFromPrintableAscii(PUBLIC_TYPE_URL);
        PUBLIC_TYPE_URL_BYTES = r1;
        PARAMETERS_SERIALIZER = ParametersSerializer.create(new JwtRsaSsaPssProtoSerialization$$ExternalSyntheticLambda0(), JwtRsaSsaPssParameters.class, ProtoParametersSerialization.class);
        PARAMETERS_PARSER = ParametersParser.create(new JwtRsaSsaPssProtoSerialization$$ExternalSyntheticLambda1(), r0, ProtoParametersSerialization.class);
        PUBLIC_KEY_SERIALIZER = KeySerializer.create(new JwtRsaSsaPssProtoSerialization$$ExternalSyntheticLambda2(), JwtRsaSsaPssPublicKey.class, ProtoKeySerialization.class);
        PUBLIC_KEY_PARSER = KeyParser.create(new JwtRsaSsaPssProtoSerialization$$ExternalSyntheticLambda3(), r1, ProtoKeySerialization.class);
        PRIVATE_KEY_SERIALIZER = KeySerializer.create(new JwtRsaSsaPssProtoSerialization$$ExternalSyntheticLambda4(), JwtRsaSsaPssPrivateKey.class, ProtoKeySerialization.class);
        PRIVATE_KEY_PARSER = KeyParser.create(new JwtRsaSsaPssProtoSerialization$$ExternalSyntheticLambda5(), r0, ProtoKeySerialization.class);
        ALGORITHM_CONVERTER = EnumTypeProtoConverter.builder().add(JwtRsaSsaPssAlgorithm.PS256, JwtRsaSsaPssParameters.Algorithm.PS256).add(JwtRsaSsaPssAlgorithm.PS384, JwtRsaSsaPssParameters.Algorithm.PS384).add(JwtRsaSsaPssAlgorithm.PS512, JwtRsaSsaPssParameters.Algorithm.PS512).build();
    }

    private static OutputPrefixType toProtoOutputPrefixType(JwtRsaSsaPssParameters parameters) {
        if (parameters.getKidStrategy().equals(JwtRsaSsaPssParameters.KidStrategy.BASE64_ENCODED_KEY_ID) == false) goto L7;
        return OutputPrefixType.TINK;
    L7:
        return OutputPrefixType.RAW;
    }

    private static ByteString encodeBigInteger(BigInteger i) {
        return ByteString.copyFrom(BigIntegerEncoding.toBigEndianBytes(i));
    }

    private static JwtRsaSsaPssKeyFormat getProtoKeyFormat(JwtRsaSsaPssParameters parameters) throws GeneralSecurityException {
        if (parameters.getKidStrategy().equals(JwtRsaSsaPssParameters.KidStrategy.IGNORED) == true) goto L10;
        if (parameters.getKidStrategy().equals(JwtRsaSsaPssParameters.KidStrategy.BASE64_ENCODED_KEY_ID) == true) goto L10;
        throw new GeneralSecurityException("Unable to serialize Parameters object with KidStrategy " + parameters.getKidStrategy());
    L10:
        return (JwtRsaSsaPssKeyFormat) JwtRsaSsaPssKeyFormat.newBuilder().setVersion(0).setAlgorithm((JwtRsaSsaPssAlgorithm) ALGORITHM_CONVERTER.toProtoEnum(parameters.getAlgorithm())).setModulusSizeInBits(parameters.getModulusSizeBits()).setPublicExponent(encodeBigInteger(parameters.getPublicExponent())).build();
    }

    private static ProtoParametersSerialization serializeParameters(JwtRsaSsaPssParameters parameters) throws GeneralSecurityException {
        OutputPrefixType r0 = toProtoOutputPrefixType(parameters);
        return ProtoParametersSerialization.create((KeyTemplate) KeyTemplate.newBuilder().setTypeUrl(PRIVATE_TYPE_URL).setValue(getProtoKeyFormat(parameters).toByteString()).setOutputPrefixType(r0).build());
    }

    private static com.google.crypto.tink.proto.JwtRsaSsaPssPublicKey getProtoPublicKey(JwtRsaSsaPssPublicKey key) throws GeneralSecurityException {
        com.google.crypto.tink.proto.JwtRsaSsaPssPublicKey.Builder r0 = com.google.crypto.tink.proto.JwtRsaSsaPssPublicKey.newBuilder().setVersion(0).setAlgorithm((JwtRsaSsaPssAlgorithm) ALGORITHM_CONVERTER.toProtoEnum(key.getParameters().getAlgorithm())).setN(encodeBigInteger(key.getModulus())).setE(encodeBigInteger(key.getParameters().getPublicExponent()));
        if (key.getParameters().getKidStrategy().equals(JwtRsaSsaPssParameters.KidStrategy.CUSTOM) == false) goto L6;
        r0.setCustomKid((com.google.crypto.tink.proto.JwtRsaSsaPssPublicKey.CustomKid) com.google.crypto.tink.proto.JwtRsaSsaPssPublicKey.CustomKid.newBuilder().setValue(key.getKid().get()).build());
    L6:
        return (com.google.crypto.tink.proto.JwtRsaSsaPssPublicKey) r0.build();
    }

    private static ProtoKeySerialization serializePublicKey(JwtRsaSsaPssPublicKey key, @Nullable SecretKeyAccess access) throws GeneralSecurityException {
        return ProtoKeySerialization.create(PUBLIC_TYPE_URL, getProtoPublicKey(key).toByteString(), KeyData.KeyMaterialType.ASYMMETRIC_PUBLIC, toProtoOutputPrefixType(key.getParameters()), key.getIdRequirementOrNull());
    }

    private static ByteString encodeSecretBigInteger(SecretBigInteger i, SecretKeyAccess access) {
        return encodeBigInteger(i.getBigInteger(access));
    }

    private static ProtoKeySerialization serializePrivateKey(JwtRsaSsaPssPrivateKey key, @Nullable SecretKeyAccess access) throws GeneralSecurityException {
        SecretKeyAccess r4 = SecretKeyAccess.requireAccess(access);
        return ProtoKeySerialization.create(PRIVATE_TYPE_URL, ((com.google.crypto.tink.proto.JwtRsaSsaPssPrivateKey) com.google.crypto.tink.proto.JwtRsaSsaPssPrivateKey.newBuilder().setVersion(0).setPublicKey(getProtoPublicKey(key.getPublicKey())).setD(encodeSecretBigInteger(key.getPrivateExponent(), r4)).setP(encodeSecretBigInteger(key.getPrimeP(), r4)).setQ(encodeSecretBigInteger(key.getPrimeQ(), r4)).setDp(encodeSecretBigInteger(key.getPrimeExponentP(), r4)).setDq(encodeSecretBigInteger(key.getPrimeExponentQ(), r4)).setCrt(encodeSecretBigInteger(key.getCrtCoefficient(), r4)).build()).toByteString(), KeyData.KeyMaterialType.ASYMMETRIC_PRIVATE, toProtoOutputPrefixType(key.getParameters()), key.getIdRequirementOrNull());
    }

    private static BigInteger decodeBigInteger(ByteString data) {
        return BigIntegerEncoding.fromUnsignedBigEndianBytes(data.toByteArray());
    }

    private static void validateVersion(int version) throws GeneralSecurityException {
        if (version != 0) goto L5;
        return;
    L5:
        throw new GeneralSecurityException("Parsing failed: unknown version " + version);
    }

    private static JwtRsaSsaPssParameters parseParameters(ProtoParametersSerialization serialization) throws GeneralSecurityException {
        if (serialization.getKeyTemplate().getTypeUrl().equals(PRIVATE_TYPE_URL) == false) goto L21;
        JwtRsaSsaPssKeyFormat r0 = JwtRsaSsaPssKeyFormat.parseFrom(serialization.getKeyTemplate().getValue(), ExtensionRegistryLite.getEmptyRegistry());     // Catch: InvalidProtocolBufferException -> L17
        validateVersion(r0.getVersion());
        if (serialization.getKeyTemplate().getOutputPrefixType().equals(OutputPrefixType.TINK) == false) goto L8;
        JwtRsaSsaPssParameters.KidStrategy r1 = JwtRsaSsaPssParameters.KidStrategy.BASE64_ENCODED_KEY_ID;
    L10:
        if (serialization.getKeyTemplate().getOutputPrefixType().equals(OutputPrefixType.RAW) == false) goto L12;
        r1 = JwtRsaSsaPssParameters.KidStrategy.IGNORED;
    L12:
        if (r1 == null) goto L16;
        return JwtRsaSsaPssParameters.builder().setKidStrategy(r1).setAlgorithm(ALGORITHM_CONVERTER.fromProtoEnum(r0.getAlgorithm())).setPublicExponent(decodeBigInteger(r0.getPublicExponent())).setModulusSizeBits(r0.getModulusSizeInBits()).build();
    L16:
        throw new GeneralSecurityException("Invalid OutputPrefixType for JwtHmacKeyFormat");
    L8:
        r1 = null;
    L17:
        e = move-exception;
        throw new GeneralSecurityException("Parsing JwtRsaSsaPssParameters failed: ", e);
    L21:
        throw new IllegalArgumentException("Wrong type URL in call to JwtRsaSsaPssProtoSerialization.parseParameters: " + serialization.getKeyTemplate().getTypeUrl());
    }

    private static JwtRsaSsaPssPublicKey getPublicKeyFromProto(com.google.crypto.tink.proto.JwtRsaSsaPssPublicKey protoKey, OutputPrefixType outputPrefixType, @Nullable Integer idRequirement) throws GeneralSecurityException {
        validateVersion(protoKey.getVersion());
        JwtRsaSsaPssParameters.Builder r0 = JwtRsaSsaPssParameters.builder();
        JwtRsaSsaPssPublicKey.Builder r1 = JwtRsaSsaPssPublicKey.builder();
        if (outputPrefixType.equals(OutputPrefixType.TINK) == false) goto L13;
        if (protoKey.hasCustomKid() == true) goto L11;
        if (idRequirement == null) goto L9;
        r0.setKidStrategy(JwtRsaSsaPssParameters.KidStrategy.BASE64_ENCODED_KEY_ID);
        r1.setIdRequirement(idRequirement);
    L18:
        BigInteger r5 = decodeBigInteger(protoKey.getN());
        int r6 = r5.bitLength();
        r0.setAlgorithm(ALGORITHM_CONVERTER.fromProtoEnum(protoKey.getAlgorithm())).setPublicExponent(decodeBigInteger(protoKey.getE())).setModulusSizeBits(r6);
        r1.setModulus(r5).setParameters(r0.build());
        return r1.build();
    L9:
        throw new GeneralSecurityException("Keys serialized with OutputPrefixType TINK need an ID Requirement");
    L11:
        throw new GeneralSecurityException("Keys serialized with OutputPrefixType TINK should not have a custom kid");
    L13:
        if (outputPrefixType.equals(OutputPrefixType.RAW) == false) goto L18;
        if (protoKey.hasCustomKid() == false) goto L17;
        r0.setKidStrategy(JwtRsaSsaPssParameters.KidStrategy.CUSTOM);
        r1.setCustomKid(protoKey.getCustomKid().getValue());
        goto L18
    L17:
        r0.setKidStrategy(JwtRsaSsaPssParameters.KidStrategy.IGNORED);
        goto L18
    }

    private static JwtRsaSsaPssPublicKey parsePublicKey(ProtoKeySerialization serialization, @Nullable SecretKeyAccess access) throws GeneralSecurityException {
        if (serialization.getTypeUrl().equals(PUBLIC_TYPE_URL) == false) goto L9;
        return getPublicKeyFromProto(com.google.crypto.tink.proto.JwtRsaSsaPssPublicKey.parseFrom(serialization.getValue(), ExtensionRegistryLite.getEmptyRegistry()), serialization.getOutputPrefixType(), serialization.getIdRequirementOrNull());
    L7:
        throw new GeneralSecurityException("Parsing JwtRsaSsaPssPublicKey failed");
    L9:
        throw new IllegalArgumentException("Wrong type URL in call to JwtRsaSsaPssProtoSerialization.parsePublicKey: " + serialization.getTypeUrl());
    }

    private static SecretBigInteger decodeSecretBigInteger(ByteString data, SecretKeyAccess access) {
        return SecretBigInteger.fromBigInteger(BigIntegerEncoding.fromUnsignedBigEndianBytes(data.toByteArray()), access);
    }

    private static JwtRsaSsaPssPrivateKey parsePrivateKey(ProtoKeySerialization serialization, @Nullable SecretKeyAccess access) throws GeneralSecurityException {
        if (serialization.getTypeUrl().equals(PRIVATE_TYPE_URL) == false) goto L9;
        com.google.crypto.tink.proto.JwtRsaSsaPssPrivateKey r0 = com.google.crypto.tink.proto.JwtRsaSsaPssPrivateKey.parseFrom(serialization.getValue(), ExtensionRegistryLite.getEmptyRegistry());     // Catch: InvalidProtocolBufferException -> L6
        validateVersion(r0.getVersion());     // Catch: InvalidProtocolBufferException -> L6
        JwtRsaSsaPssPublicKey r3 = getPublicKeyFromProto(r0.getPublicKey(), serialization.getOutputPrefixType(), serialization.getIdRequirementOrNull());     // Catch: InvalidProtocolBufferException -> L6
        SecretKeyAccess r4 = SecretKeyAccess.requireAccess(access);     // Catch: InvalidProtocolBufferException -> L6
        return JwtRsaSsaPssPrivateKey.builder().setPublicKey(r3).setPrimes(decodeSecretBigInteger(r0.getP(), r4), decodeSecretBigInteger(r0.getQ(), r4)).setPrivateExponent(decodeSecretBigInteger(r0.getD(), r4)).setPrimeExponents(decodeSecretBigInteger(r0.getDp(), r4), decodeSecretBigInteger(r0.getDq(), r4)).setCrtCoefficient(decodeSecretBigInteger(r0.getCrt(), r4)).build();
    L7:
        throw new GeneralSecurityException("Parsing JwtRsaSsaPssPrivateKey failed");
    L9:
        throw new IllegalArgumentException("Wrong type URL in call to JwtRsaSsaPssProtoSerialization.parsePrivateKey: " + serialization.getTypeUrl());
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

    private JwtRsaSsaPssProtoSerialization() {
    }
}
