package com.google.crypto.tink.streamingaead.internal;

import com.google.crypto.tink.SecretKeyAccess;
import com.google.crypto.tink.internal.KeyParser;
import com.google.crypto.tink.internal.KeySerializer;
import com.google.crypto.tink.internal.MutableSerializationRegistry;
import com.google.crypto.tink.internal.ParametersParser;
import com.google.crypto.tink.internal.ParametersSerializer;
import com.google.crypto.tink.internal.ProtoKeySerialization;
import com.google.crypto.tink.internal.ProtoParametersSerialization;
import com.google.crypto.tink.internal.Util;
import com.google.crypto.tink.proto.AesGcmHkdfStreamingKeyFormat;
import com.google.crypto.tink.proto.AesGcmHkdfStreamingParams;
import com.google.crypto.tink.proto.HashType;
import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.proto.KeyTemplate;
import com.google.crypto.tink.proto.OutputPrefixType;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.streamingaead.AesGcmHkdfStreamingKey;
import com.google.crypto.tink.streamingaead.AesGcmHkdfStreamingParameters;
import com.google.crypto.tink.util.Bytes;
import com.google.crypto.tink.util.SecretBytes;
import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class AesGcmHkdfStreamingProtoSerialization {
    private static final KeyParser<ProtoKeySerialization> KEY_PARSER = null;
    private static final KeySerializer<AesGcmHkdfStreamingKey, ProtoKeySerialization> KEY_SERIALIZER = null;
    private static final ParametersParser<ProtoParametersSerialization> PARAMETERS_PARSER = null;
    private static final ParametersSerializer<AesGcmHkdfStreamingParameters, ProtoParametersSerialization> PARAMETERS_SERIALIZER = null;
    private static final String TYPE_URL = "type.googleapis.com/google.crypto.tink.AesGcmHkdfStreamingKey";
    private static final Bytes TYPE_URL_BYTES = null;

    /* JADX INFO: renamed from: com.google.crypto.tink.streamingaead.internal.AesGcmHkdfStreamingProtoSerialization$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$crypto$tink$proto$HashType = null;

        static {
            int[] r0 = new int[HashType.values().length];
            $SwitchMap$com$google$crypto$tink$proto$HashType = r0;
            r0[HashType.SHA1.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            $SwitchMap$com$google$crypto$tink$proto$HashType[HashType.SHA256.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            $SwitchMap$com$google$crypto$tink$proto$HashType[HashType.SHA512.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$HScDgJ3uGYoEVxH15c-8l5sJPBY, reason: not valid java name */
    public static /* synthetic */ AesGcmHkdfStreamingParameters m966$r8$lambda$HScDgJ3uGYoEVxH15c8l5sJPBY(ProtoParametersSerialization r0) {
        return parseParameters(r0);
    }

    public static /* synthetic */ ProtoKeySerialization $r8$lambda$cgiXyUcNbHniW92T0PNmMQaEdNY(AesGcmHkdfStreamingKey r0, SecretKeyAccess r1) {
        return serializeKey(r0, r1);
    }

    public static /* synthetic */ ProtoParametersSerialization $r8$lambda$xnHqVABZAiZdCPy00aPKmE9sOFk(AesGcmHkdfStreamingParameters r0) {
        return serializeParameters(r0);
    }

    public static /* synthetic */ AesGcmHkdfStreamingKey $r8$lambda$y6et_rU15hNpRt2ZURitt2o9Ty0(ProtoKeySerialization r0, SecretKeyAccess r1) {
        return parseKey(r0, r1);
    }

    static {
        Bytes r0 = Util.toBytesFromPrintableAscii(TYPE_URL);
        TYPE_URL_BYTES = r0;
        PARAMETERS_SERIALIZER = ParametersSerializer.create(new AesGcmHkdfStreamingProtoSerialization$$ExternalSyntheticLambda0(), AesGcmHkdfStreamingParameters.class, ProtoParametersSerialization.class);
        PARAMETERS_PARSER = ParametersParser.create(new AesGcmHkdfStreamingProtoSerialization$$ExternalSyntheticLambda1(), r0, ProtoParametersSerialization.class);
        KEY_SERIALIZER = KeySerializer.create(new AesGcmHkdfStreamingProtoSerialization$$ExternalSyntheticLambda2(), AesGcmHkdfStreamingKey.class, ProtoKeySerialization.class);
        KEY_PARSER = KeyParser.create(new AesGcmHkdfStreamingProtoSerialization$$ExternalSyntheticLambda3(), r0, ProtoKeySerialization.class);
    }

    private static HashType toProtoHashType(AesGcmHkdfStreamingParameters.HashType hashType) throws GeneralSecurityException {
        if (AesGcmHkdfStreamingParameters.HashType.SHA1.equals(hashType) == false) goto L7;
        return HashType.SHA1;
    L7:
        if (AesGcmHkdfStreamingParameters.HashType.SHA256.equals(hashType) == false) goto L11;
        return HashType.SHA256;
    L11:
        if (AesGcmHkdfStreamingParameters.HashType.SHA512.equals(hashType) == false) goto L15;
        return HashType.SHA512;
    L15:
        throw new GeneralSecurityException("Unable to serialize HashType " + hashType);
    }

    private static AesGcmHkdfStreamingParameters.HashType toHashType(HashType hashType) throws GeneralSecurityException {
        int r0 = AnonymousClass1.$SwitchMap$com$google$crypto$tink$proto$HashType[hashType.ordinal()];
        if (r0 == 1) goto L15;
        if (r0 == 2) goto L13;
        if (r0 != 3) goto L11;
        return AesGcmHkdfStreamingParameters.HashType.SHA512;
    L11:
        throw new GeneralSecurityException("Unable to parse HashType: " + hashType.getNumber());
    L13:
        return AesGcmHkdfStreamingParameters.HashType.SHA256;
    L15:
        return AesGcmHkdfStreamingParameters.HashType.SHA1;
    }

    private static AesGcmHkdfStreamingParams toProtoParams(AesGcmHkdfStreamingParameters parameters) throws GeneralSecurityException {
        return (AesGcmHkdfStreamingParams) AesGcmHkdfStreamingParams.newBuilder().setCiphertextSegmentSize(parameters.getCiphertextSegmentSizeBytes()).setDerivedKeySize(parameters.getDerivedAesGcmKeySizeBytes()).setHkdfHashType(toProtoHashType(parameters.getHkdfHashType())).build();
    }

    private static ProtoParametersSerialization serializeParameters(AesGcmHkdfStreamingParameters parameters) throws GeneralSecurityException {
        return ProtoParametersSerialization.create((KeyTemplate) KeyTemplate.newBuilder().setTypeUrl(TYPE_URL).setValue(((AesGcmHkdfStreamingKeyFormat) AesGcmHkdfStreamingKeyFormat.newBuilder().setKeySize(parameters.getKeySizeBytes()).setParams(toProtoParams(parameters)).build()).toByteString()).setOutputPrefixType(OutputPrefixType.RAW).build());
    }

    private static ProtoKeySerialization serializeKey(AesGcmHkdfStreamingKey key, @Nullable SecretKeyAccess access) throws GeneralSecurityException {
        return ProtoKeySerialization.create(TYPE_URL, ((com.google.crypto.tink.proto.AesGcmHkdfStreamingKey) com.google.crypto.tink.proto.AesGcmHkdfStreamingKey.newBuilder().setKeyValue(ByteString.copyFrom(key.getInitialKeyMaterial().toByteArray(SecretKeyAccess.requireAccess(access)))).setParams(toProtoParams(key.getParameters())).build()).toByteString(), KeyData.KeyMaterialType.SYMMETRIC, OutputPrefixType.RAW, key.getIdRequirementOrNull());
    }

    private static AesGcmHkdfStreamingParameters toParametersObject(AesGcmHkdfStreamingParams params, int keySize) throws GeneralSecurityException {
        return AesGcmHkdfStreamingParameters.builder().setKeySizeBytes(keySize).setDerivedAesGcmKeySizeBytes(params.getDerivedKeySize()).setCiphertextSegmentSizeBytes(params.getCiphertextSegmentSize()).setHkdfHashType(toHashType(params.getHkdfHashType())).build();
    }

    private static AesGcmHkdfStreamingParameters parseParameters(ProtoParametersSerialization serialization) throws GeneralSecurityException {
        if (serialization.getKeyTemplate().getTypeUrl().equals(TYPE_URL) == false) goto L15;
        AesGcmHkdfStreamingKeyFormat r3 = AesGcmHkdfStreamingKeyFormat.parseFrom(serialization.getKeyTemplate().getValue(), ExtensionRegistryLite.getEmptyRegistry());     // Catch: InvalidProtocolBufferException -> L11
        if (r3.getVersion() != 0) goto L10;
        return toParametersObject(r3.getParams(), r3.getKeySize());
    L10:
        throw new GeneralSecurityException("Only version 0 parameters are accepted");
    L11:
        e = move-exception;
        throw new GeneralSecurityException("Parsing AesGcmHkdfStreamingParameters failed: ", e);
    L15:
        throw new IllegalArgumentException("Wrong type URL in call to AesGcmHkdfStreamingParameters.parseParameters: " + serialization.getKeyTemplate().getTypeUrl());
    }

    private static AesGcmHkdfStreamingKey parseKey(ProtoKeySerialization serialization, @Nullable SecretKeyAccess access) throws GeneralSecurityException {
        if (serialization.getTypeUrl().equals(TYPE_URL) == false) goto L13;
        com.google.crypto.tink.proto.AesGcmHkdfStreamingKey r2 = com.google.crypto.tink.proto.AesGcmHkdfStreamingKey.parseFrom(serialization.getValue(), ExtensionRegistryLite.getEmptyRegistry());     // Catch: InvalidProtocolBufferException -> L10
        if (r2.getVersion() != 0) goto L9;
        return AesGcmHkdfStreamingKey.create(toParametersObject(r2.getParams(), r2.getKeyValue().size()), SecretBytes.copyFrom(r2.getKeyValue().toByteArray(), SecretKeyAccess.requireAccess(access)));
    L9:
        throw new GeneralSecurityException("Only version 0 keys are accepted");     // Catch: InvalidProtocolBufferException -> L10
    L11:
        throw new GeneralSecurityException("Parsing AesGcmHkdfStreamingKey failed");
    L13:
        throw new IllegalArgumentException("Wrong type URL in call to AesGcmHkdfStreamingParameters.parseParameters");
    }

    public static void register() throws GeneralSecurityException {
        register(MutableSerializationRegistry.globalInstance());
    }

    public static void register(MutableSerializationRegistry registry) throws GeneralSecurityException {
        registry.registerParametersSerializer(PARAMETERS_SERIALIZER);
        registry.registerParametersParser(PARAMETERS_PARSER);
        registry.registerKeySerializer(KEY_SERIALIZER);
        registry.registerKeyParser(KEY_PARSER);
    }

    private AesGcmHkdfStreamingProtoSerialization() {
    }
}
