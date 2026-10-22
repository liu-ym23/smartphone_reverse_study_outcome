package com.google.crypto.tink.jwt;

import com.google.crypto.tink.SecretKeyAccess;
import com.google.crypto.tink.internal.BigIntegerEncoding;
import com.google.crypto.tink.internal.KeyParser;
import com.google.crypto.tink.internal.KeySerializer;
import com.google.crypto.tink.internal.MutableSerializationRegistry;
import com.google.crypto.tink.internal.ParametersParser;
import com.google.crypto.tink.internal.ParametersSerializer;
import com.google.crypto.tink.internal.ProtoKeySerialization;
import com.google.crypto.tink.internal.ProtoParametersSerialization;
import com.google.crypto.tink.internal.Util;
import com.google.crypto.tink.proto.JwtEcdsaAlgorithm;
import com.google.crypto.tink.proto.JwtEcdsaKeyFormat;
import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.proto.KeyTemplate;
import com.google.crypto.tink.proto.OutputPrefixType;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.util.Bytes;
import com.google.crypto.tink.util.SecretBigInteger;
import java.security.GeneralSecurityException;
import java.security.spec.ECPoint;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
final class JwtEcdsaProtoSerialization {
    private static final ParametersParser<ProtoParametersSerialization> PARAMETERS_PARSER = null;
    private static final ParametersSerializer<JwtEcdsaParameters, ProtoParametersSerialization> PARAMETERS_SERIALIZER = null;
    private static final KeyParser<ProtoKeySerialization> PRIVATE_KEY_PARSER = null;
    private static final KeySerializer<JwtEcdsaPrivateKey, ProtoKeySerialization> PRIVATE_KEY_SERIALIZER = null;
    private static final KeyParser<ProtoKeySerialization> PUBLIC_KEY_PARSER = null;
    private static final KeySerializer<JwtEcdsaPublicKey, ProtoKeySerialization> PUBLIC_KEY_SERIALIZER = null;
    private static final String PUBLIC_TYPE_URL = "type.googleapis.com/google.crypto.tink.JwtEcdsaPublicKey";
    private static final Bytes PUBLIC_TYPE_URL_BYTES = null;
    private static final String TYPE_URL = "type.googleapis.com/google.crypto.tink.JwtEcdsaPrivateKey";
    private static final Bytes TYPE_URL_BYTES = null;

    /* JADX INFO: renamed from: com.google.crypto.tink.jwt.JwtEcdsaProtoSerialization$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$crypto$tink$proto$JwtEcdsaAlgorithm = null;

        static {
            int[] r0 = new int[JwtEcdsaAlgorithm.values().length];
            $SwitchMap$com$google$crypto$tink$proto$JwtEcdsaAlgorithm = r0;
            r0[JwtEcdsaAlgorithm.ES256.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            $SwitchMap$com$google$crypto$tink$proto$JwtEcdsaAlgorithm[JwtEcdsaAlgorithm.ES384.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            $SwitchMap$com$google$crypto$tink$proto$JwtEcdsaAlgorithm[JwtEcdsaAlgorithm.ES512.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    public static /* synthetic */ ProtoKeySerialization $r8$lambda$9gGprFQ5JMZwdkWc0PMARXOwKeQ(JwtEcdsaPublicKey r0, SecretKeyAccess r1) {
        return serializePublicKey(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$Ckfp-yWC63aKbhYBtkyuLmbniXQ, reason: not valid java name */
    public static /* synthetic */ JwtEcdsaParameters m930$r8$lambda$CkfpyWC63aKbhYBtkyuLmbniXQ(ProtoParametersSerialization r0) {
        return parseParameters(r0);
    }

    public static /* synthetic */ JwtEcdsaPrivateKey $r8$lambda$HkBXlQQNQuXMVSRQXxPcOmgR9sQ(ProtoKeySerialization r0, SecretKeyAccess r1) {
        return parsePrivateKey(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$NrKARNM9-dIa1YyE8m93Q4ZUmvs, reason: not valid java name */
    public static /* synthetic */ ProtoParametersSerialization m931$r8$lambda$NrKARNM9dIa1YyE8m93Q4ZUmvs(JwtEcdsaParameters r0) {
        return serializeParameters(r0);
    }

    public static /* synthetic */ JwtEcdsaPublicKey $r8$lambda$THhpMk6ACxaRw8FYElJuozeWWMs(ProtoKeySerialization r0, SecretKeyAccess r1) {
        return parsePublicKey(r0, r1);
    }

    public static /* synthetic */ ProtoKeySerialization $r8$lambda$gYWHT8r2aN7d5_OzFvXeCd1By2E(JwtEcdsaPrivateKey r0, SecretKeyAccess r1) {
        return serializePrivateKey(r0, r1);
    }

    static {
        Bytes r0 = Util.toBytesFromPrintableAscii(TYPE_URL);
        TYPE_URL_BYTES = r0;
        Bytes r1 = Util.toBytesFromPrintableAscii(PUBLIC_TYPE_URL);
        PUBLIC_TYPE_URL_BYTES = r1;
        PARAMETERS_SERIALIZER = ParametersSerializer.create(new JwtEcdsaProtoSerialization$$ExternalSyntheticLambda0(), JwtEcdsaParameters.class, ProtoParametersSerialization.class);
        PARAMETERS_PARSER = ParametersParser.create(new JwtEcdsaProtoSerialization$$ExternalSyntheticLambda1(), r0, ProtoParametersSerialization.class);
        PUBLIC_KEY_SERIALIZER = KeySerializer.create(new JwtEcdsaProtoSerialization$$ExternalSyntheticLambda2(), JwtEcdsaPublicKey.class, ProtoKeySerialization.class);
        PUBLIC_KEY_PARSER = KeyParser.create(new JwtEcdsaProtoSerialization$$ExternalSyntheticLambda3(), r1, ProtoKeySerialization.class);
        PRIVATE_KEY_SERIALIZER = KeySerializer.create(new JwtEcdsaProtoSerialization$$ExternalSyntheticLambda4(), JwtEcdsaPrivateKey.class, ProtoKeySerialization.class);
        PRIVATE_KEY_PARSER = KeyParser.create(new JwtEcdsaProtoSerialization$$ExternalSyntheticLambda5(), r0, ProtoKeySerialization.class);
    }

    private static JwtEcdsaAlgorithm toProtoAlgorithm(JwtEcdsaParameters.Algorithm algorithm) throws GeneralSecurityException {
        if (JwtEcdsaParameters.Algorithm.ES256.equals(algorithm) == false) goto L7;
        return JwtEcdsaAlgorithm.ES256;
    L7:
        if (JwtEcdsaParameters.Algorithm.ES384.equals(algorithm) == false) goto L11;
        return JwtEcdsaAlgorithm.ES384;
    L11:
        if (JwtEcdsaParameters.Algorithm.ES512.equals(algorithm) == false) goto L15;
        return JwtEcdsaAlgorithm.ES512;
    L15:
        throw new GeneralSecurityException("Unable to serialize algorithm: " + algorithm);
    }

    private static JwtEcdsaParameters.Algorithm toAlgorithm(JwtEcdsaAlgorithm algorithm) throws GeneralSecurityException {
        int r0 = AnonymousClass1.$SwitchMap$com$google$crypto$tink$proto$JwtEcdsaAlgorithm[algorithm.ordinal()];
        if (r0 == 1) goto L15;
        if (r0 == 2) goto L13;
        if (r0 != 3) goto L11;
        return JwtEcdsaParameters.Algorithm.ES512;
    L11:
        throw new GeneralSecurityException("Unable to parse algorithm: " + algorithm.getNumber());
    L13:
        return JwtEcdsaParameters.Algorithm.ES384;
    L15:
        return JwtEcdsaParameters.Algorithm.ES256;
    }

    private static JwtEcdsaKeyFormat serializeToJwtEcdsaKeyFormat(JwtEcdsaParameters parameters) throws GeneralSecurityException {
        if (parameters.getKidStrategy().equals(JwtEcdsaParameters.KidStrategy.IGNORED) == true) goto L10;
        if (parameters.getKidStrategy().equals(JwtEcdsaParameters.KidStrategy.BASE64_ENCODED_KEY_ID) == true) goto L10;
        throw new GeneralSecurityException("Unable to serialize Parameters object with KidStrategy " + parameters.getKidStrategy());
    L10:
        return (JwtEcdsaKeyFormat) JwtEcdsaKeyFormat.newBuilder().setVersion(0).setAlgorithm(toProtoAlgorithm(parameters.getAlgorithm())).build();
    }

    private static ProtoParametersSerialization serializeParameters(JwtEcdsaParameters parameters) throws GeneralSecurityException {
        OutputPrefixType r0 = OutputPrefixType.TINK;
        if (parameters.getKidStrategy().equals(JwtEcdsaParameters.KidStrategy.IGNORED) == false) goto L6;
        r0 = OutputPrefixType.RAW;
    L6:
        return ProtoParametersSerialization.create((KeyTemplate) KeyTemplate.newBuilder().setTypeUrl(TYPE_URL).setValue(serializeToJwtEcdsaKeyFormat(parameters).toByteString()).setOutputPrefixType(r0).build());
    }

    private static JwtEcdsaParameters parseParameters(ProtoParametersSerialization serialization) throws GeneralSecurityException {
        if (serialization.getKeyTemplate().getTypeUrl().equals(TYPE_URL) == false) goto L25;
        JwtEcdsaKeyFormat r0 = JwtEcdsaKeyFormat.parseFrom(serialization.getKeyTemplate().getValue(), ExtensionRegistryLite.getEmptyRegistry());     // Catch: InvalidProtocolBufferException -> L21
        if (r0.getVersion() != 0) goto L20;
        if (serialization.getKeyTemplate().getOutputPrefixType().equals(OutputPrefixType.TINK) == false) goto L10;
        JwtEcdsaParameters.KidStrategy r1 = JwtEcdsaParameters.KidStrategy.BASE64_ENCODED_KEY_ID;
    L12:
        if (serialization.getKeyTemplate().getOutputPrefixType().equals(OutputPrefixType.RAW) == false) goto L14;
        r1 = JwtEcdsaParameters.KidStrategy.IGNORED;
    L14:
        if (r1 == null) goto L18;
        return JwtEcdsaParameters.builder().setAlgorithm(toAlgorithm(r0.getAlgorithm())).setKidStrategy(r1).build();
    L18:
        throw new GeneralSecurityException("Invalid OutputPrefixType for JwtHmacKeyFormat");
    L10:
        r1 = null;
        goto L12
    L20:
        throw new GeneralSecurityException("Parsing HmacParameters failed: unknown Version " + r0.getVersion());
    L21:
        e = move-exception;
        throw new GeneralSecurityException("Parsing JwtEcdsaKeyFormat failed: ", e);
    L25:
        throw new IllegalArgumentException("Wrong type URL in call to JwtEcdsaParameters.parseParameters: " + serialization.getKeyTemplate().getTypeUrl());
    }

    private static int getEncodingLength(JwtEcdsaParameters.Algorithm algorithm) throws GeneralSecurityException {
        if (algorithm.equals(JwtEcdsaParameters.Algorithm.ES256) == false) goto L7;
        return 33;
    L7:
        if (algorithm.equals(JwtEcdsaParameters.Algorithm.ES384) == false) goto L11;
        return 49;
    L11:
        if (algorithm.equals(JwtEcdsaParameters.Algorithm.ES512) == false) goto L15;
        return 67;
    L15:
        throw new GeneralSecurityException("Unknown algorithm: " + algorithm);
    }

    private static OutputPrefixType toProtoOutputPrefixType(JwtEcdsaParameters parameters) {
        if (parameters.getKidStrategy().equals(JwtEcdsaParameters.KidStrategy.BASE64_ENCODED_KEY_ID) == false) goto L7;
        return OutputPrefixType.TINK;
    L7:
        return OutputPrefixType.RAW;
    }

    private static com.google.crypto.tink.proto.JwtEcdsaPublicKey serializePublicKey(JwtEcdsaPublicKey key) throws GeneralSecurityException {
        int r0 = getEncodingLength(key.getParameters().getAlgorithm());
        ECPoint r1 = key.getPublicPoint();
        com.google.crypto.tink.proto.JwtEcdsaPublicKey.Builder r2 = com.google.crypto.tink.proto.JwtEcdsaPublicKey.newBuilder().setVersion(0).setAlgorithm(toProtoAlgorithm(key.getParameters().getAlgorithm())).setX(ByteString.copyFrom(BigIntegerEncoding.toBigEndianBytesOfFixedLength(r1.getAffineX(), r0))).setY(ByteString.copyFrom(BigIntegerEncoding.toBigEndianBytesOfFixedLength(r1.getAffineY(), r0)));
        if (key.getParameters().getKidStrategy().equals(JwtEcdsaParameters.KidStrategy.CUSTOM) == false) goto L6;
        r2.setCustomKid((com.google.crypto.tink.proto.JwtEcdsaPublicKey.CustomKid) com.google.crypto.tink.proto.JwtEcdsaPublicKey.CustomKid.newBuilder().setValue(key.getKid().get()).build());
    L6:
        return (com.google.crypto.tink.proto.JwtEcdsaPublicKey) r2.build();
    }

    private static ProtoKeySerialization serializePublicKey(JwtEcdsaPublicKey key, @Nullable SecretKeyAccess access) throws GeneralSecurityException {
        return ProtoKeySerialization.create(PUBLIC_TYPE_URL, serializePublicKey(key).toByteString(), KeyData.KeyMaterialType.ASYMMETRIC_PUBLIC, toProtoOutputPrefixType(key.getParameters()), key.getIdRequirementOrNull());
    }

    private static JwtEcdsaPublicKey parsePublicKeyFromProto(com.google.crypto.tink.proto.JwtEcdsaPublicKey protoKey, OutputPrefixType outputPrefixType, @Nullable Integer idRequirement) throws GeneralSecurityException {
        if (protoKey.getVersion() != 0) goto L23;
        JwtEcdsaParameters.Builder r0 = JwtEcdsaParameters.builder();
        JwtEcdsaPublicKey.Builder r1 = JwtEcdsaPublicKey.builder();
        if (outputPrefixType.equals(OutputPrefixType.TINK) == false) goto L15;
        if (protoKey.hasCustomKid() == true) goto L13;
        if (idRequirement == null) goto L11;
        r0.setKidStrategy(JwtEcdsaParameters.KidStrategy.BASE64_ENCODED_KEY_ID);
        r1.setIdRequirement(idRequirement);
    L20:
        r0.setAlgorithm(toAlgorithm(protoKey.getAlgorithm()));
        r1.setPublicPoint(new ECPoint(BigIntegerEncoding.fromUnsignedBigEndianBytes(protoKey.getX().toByteArray()), BigIntegerEncoding.fromUnsignedBigEndianBytes(protoKey.getY().toByteArray())));
        return r1.setParameters(r0.build()).build();
    L11:
        throw new GeneralSecurityException("Keys serialized with OutputPrefixType TINK need an ID Requirement");
    L13:
        throw new GeneralSecurityException("Keys serialized with OutputPrefixType TINK should not have a custom kid");
    L15:
        if (outputPrefixType.equals(OutputPrefixType.RAW) == false) goto L20;
        if (protoKey.hasCustomKid() == false) goto L19;
        r0.setKidStrategy(JwtEcdsaParameters.KidStrategy.CUSTOM);
        r1.setCustomKid(protoKey.getCustomKid().getValue());
        goto L20
    L19:
        r0.setKidStrategy(JwtEcdsaParameters.KidStrategy.IGNORED);
        goto L20
    L23:
        throw new GeneralSecurityException("Only version 0 keys are accepted");
    }

    private static JwtEcdsaPublicKey parsePublicKey(ProtoKeySerialization serialization, @Nullable SecretKeyAccess access) throws GeneralSecurityException {
        if (serialization.getTypeUrl().equals(PUBLIC_TYPE_URL) == false) goto L9;
        return parsePublicKeyFromProto(com.google.crypto.tink.proto.JwtEcdsaPublicKey.parseFrom(serialization.getValue(), ExtensionRegistryLite.getEmptyRegistry()), serialization.getOutputPrefixType(), serialization.getIdRequirementOrNull());
    L7:
        throw new GeneralSecurityException("Parsing EcdsaPublicKey failed");
    L9:
        throw new IllegalArgumentException("Wrong type URL in call to EcdsaProtoSerialization.parsePublicKey: " + serialization.getTypeUrl());
    }

    private static com.google.crypto.tink.proto.JwtEcdsaPrivateKey serializePrivateKeyToProto(JwtEcdsaPrivateKey key, SecretKeyAccess access) throws GeneralSecurityException {
        int r0 = getEncodingLength(key.getParameters().getAlgorithm());
        return (com.google.crypto.tink.proto.JwtEcdsaPrivateKey) com.google.crypto.tink.proto.JwtEcdsaPrivateKey.newBuilder().setPublicKey(serializePublicKey(key.getPublicKey())).setKeyValue(ByteString.copyFrom(BigIntegerEncoding.toBigEndianBytesOfFixedLength(key.getPrivateValue().getBigInteger(access), r0))).build();
    }

    private static ProtoKeySerialization serializePrivateKey(JwtEcdsaPrivateKey key, @Nullable SecretKeyAccess access) throws GeneralSecurityException {
        return ProtoKeySerialization.create(TYPE_URL, serializePrivateKeyToProto(key, SecretKeyAccess.requireAccess(access)).toByteString(), KeyData.KeyMaterialType.ASYMMETRIC_PRIVATE, toProtoOutputPrefixType(key.getParameters()), key.getIdRequirementOrNull());
    }

    private static JwtEcdsaPrivateKey parsePrivateKey(ProtoKeySerialization serialization, @Nullable SecretKeyAccess access) throws GeneralSecurityException {
        if (serialization.getTypeUrl().equals(TYPE_URL) == false) goto L13;
        com.google.crypto.tink.proto.JwtEcdsaPrivateKey r0 = com.google.crypto.tink.proto.JwtEcdsaPrivateKey.parseFrom(serialization.getValue(), ExtensionRegistryLite.getEmptyRegistry());     // Catch: InvalidProtocolBufferException -> L10
        if (r0.getVersion() != 0) goto L9;
        return JwtEcdsaPrivateKey.create(parsePublicKeyFromProto(r0.getPublicKey(), serialization.getOutputPrefixType(), serialization.getIdRequirementOrNull()), SecretBigInteger.fromBigInteger(BigIntegerEncoding.fromUnsignedBigEndianBytes(r0.getKeyValue().toByteArray()), SecretKeyAccess.requireAccess(access)));
    L9:
        throw new GeneralSecurityException("Only version 0 keys are accepted");     // Catch: InvalidProtocolBufferException -> L10
    L11:
        throw new GeneralSecurityException("Parsing EcdsaPrivateKey failed");
    L13:
        throw new IllegalArgumentException("Wrong type URL in call to EcdsaProtoSerialization.parsePublicKey: " + serialization.getTypeUrl());
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

    private JwtEcdsaProtoSerialization() {
    }
}
