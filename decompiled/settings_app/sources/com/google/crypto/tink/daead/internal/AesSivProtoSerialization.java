package com.google.crypto.tink.daead.internal;

import com.google.crypto.tink.SecretKeyAccess;
import com.google.crypto.tink.daead.AesSivKey;
import com.google.crypto.tink.daead.AesSivParameters;
import com.google.crypto.tink.internal.KeyParser;
import com.google.crypto.tink.internal.KeySerializer;
import com.google.crypto.tink.internal.MutableSerializationRegistry;
import com.google.crypto.tink.internal.ParametersParser;
import com.google.crypto.tink.internal.ParametersSerializer;
import com.google.crypto.tink.internal.ProtoKeySerialization;
import com.google.crypto.tink.internal.ProtoParametersSerialization;
import com.google.crypto.tink.internal.Util;
import com.google.crypto.tink.proto.AesSivKeyFormat;
import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.proto.KeyTemplate;
import com.google.crypto.tink.proto.OutputPrefixType;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.util.Bytes;
import com.google.crypto.tink.util.SecretBytes;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class AesSivProtoSerialization {
    private static final KeyParser<ProtoKeySerialization> KEY_PARSER = null;
    private static final KeySerializer<AesSivKey, ProtoKeySerialization> KEY_SERIALIZER = null;
    private static final ParametersParser<ProtoParametersSerialization> PARAMETERS_PARSER = null;
    private static final ParametersSerializer<AesSivParameters, ProtoParametersSerialization> PARAMETERS_SERIALIZER = null;
    private static final String TYPE_URL = "type.googleapis.com/google.crypto.tink.AesSivKey";
    private static final Bytes TYPE_URL_BYTES = null;
    private static final Map<OutputPrefixType, AesSivParameters.Variant> outputPrefixToVariantMap = null;
    private static final Map<AesSivParameters.Variant, OutputPrefixType> variantsToOutputPrefixMap = null;

    public static /* synthetic */ AesSivKey $r8$lambda$MoQxf_1ROP0LS8qMMBncLssCtWI(ProtoKeySerialization r0, SecretKeyAccess r1) {
        return parseKey(r0, r1);
    }

    public static /* synthetic */ AesSivParameters $r8$lambda$PIS_SG5LJtePpdI_G0gpuemBOA4(ProtoParametersSerialization r0) {
        return parseParameters(r0);
    }

    public static /* synthetic */ ProtoKeySerialization $r8$lambda$YZmyXxxCj6Iq5AlPY77ddRzhVTE(AesSivKey r0, SecretKeyAccess r1) {
        return serializeKey(r0, r1);
    }

    public static /* synthetic */ ProtoParametersSerialization $r8$lambda$ZpV4zu86iKDCM1Q_OZMhZbK2bzw(AesSivParameters r0) {
        return serializeParameters(r0);
    }

    static {
        Bytes r0 = Util.toBytesFromPrintableAscii(TYPE_URL);
        TYPE_URL_BYTES = r0;
        PARAMETERS_SERIALIZER = ParametersSerializer.create(new AesSivProtoSerialization$$ExternalSyntheticLambda0(), AesSivParameters.class, ProtoParametersSerialization.class);
        PARAMETERS_PARSER = ParametersParser.create(new AesSivProtoSerialization$$ExternalSyntheticLambda1(), r0, ProtoParametersSerialization.class);
        KEY_SERIALIZER = KeySerializer.create(new AesSivProtoSerialization$$ExternalSyntheticLambda2(), AesSivKey.class, ProtoKeySerialization.class);
        KEY_PARSER = KeyParser.create(new AesSivProtoSerialization$$ExternalSyntheticLambda3(), r0, ProtoKeySerialization.class);
        variantsToOutputPrefixMap = createVariantToOutputPrefixMap();
        outputPrefixToVariantMap = createOutputPrefixToVariantMap();
    }

    private static Map<AesSivParameters.Variant, OutputPrefixType> createVariantToOutputPrefixMap() {
        HashMap r0 = new HashMap();
        r0.put(AesSivParameters.Variant.NO_PREFIX, OutputPrefixType.RAW);
        r0.put(AesSivParameters.Variant.TINK, OutputPrefixType.TINK);
        r0.put(AesSivParameters.Variant.CRUNCHY, OutputPrefixType.CRUNCHY);
        return Collections.unmodifiableMap(r0);
    }

    private static Map<OutputPrefixType, AesSivParameters.Variant> createOutputPrefixToVariantMap() {
        EnumMap r0 = new EnumMap(OutputPrefixType.class);
        r0.put(OutputPrefixType.RAW, AesSivParameters.Variant.NO_PREFIX);
        r0.put(OutputPrefixType.TINK, AesSivParameters.Variant.TINK);
        r0.put(OutputPrefixType.CRUNCHY, AesSivParameters.Variant.CRUNCHY);
        r0.put(OutputPrefixType.LEGACY, AesSivParameters.Variant.CRUNCHY);
        return Collections.unmodifiableMap(r0);
    }

    private static OutputPrefixType toProtoOutputPrefixType(AesSivParameters.Variant variant) throws GeneralSecurityException {
        Map<AesSivParameters.Variant, OutputPrefixType> r0 = variantsToOutputPrefixMap;
        if (r0.containsKey(variant) == false) goto L7;
        return r0.get(variant);
    L7:
        throw new GeneralSecurityException("Unable to serialize variant: " + variant);
    }

    private static AesSivParameters.Variant toVariant(OutputPrefixType outputPrefixType) throws GeneralSecurityException {
        Map<OutputPrefixType, AesSivParameters.Variant> r0 = outputPrefixToVariantMap;
        if (r0.containsKey(outputPrefixType) == false) goto L7;
        return r0.get(outputPrefixType);
    L7:
        throw new GeneralSecurityException("Unable to parse OutputPrefixType: " + outputPrefixType.getNumber());
    }

    private static ProtoParametersSerialization serializeParameters(AesSivParameters parameters) throws GeneralSecurityException {
        return ProtoParametersSerialization.create((KeyTemplate) KeyTemplate.newBuilder().setTypeUrl(TYPE_URL).setValue(((AesSivKeyFormat) AesSivKeyFormat.newBuilder().setKeySize(parameters.getKeySizeBytes()).build()).toByteString()).setOutputPrefixType(toProtoOutputPrefixType(parameters.getVariant())).build());
    }

    private static ProtoKeySerialization serializeKey(AesSivKey key, @Nullable SecretKeyAccess access) throws GeneralSecurityException {
        return ProtoKeySerialization.create(TYPE_URL, ((com.google.crypto.tink.proto.AesSivKey) com.google.crypto.tink.proto.AesSivKey.newBuilder().setKeyValue(ByteString.copyFrom(key.getKeyBytes().toByteArray(SecretKeyAccess.requireAccess(access)))).build()).toByteString(), KeyData.KeyMaterialType.SYMMETRIC, toProtoOutputPrefixType(key.getParameters().getVariant()), key.getIdRequirementOrNull());
    }

    private static AesSivParameters parseParameters(ProtoParametersSerialization serialization) throws GeneralSecurityException {
        if (serialization.getKeyTemplate().getTypeUrl().equals(TYPE_URL) == false) goto L14;
        AesSivKeyFormat r0 = AesSivKeyFormat.parseFrom(serialization.getKeyTemplate().getValue(), ExtensionRegistryLite.getEmptyRegistry());     // Catch: InvalidProtocolBufferException -> L10
        if (r0.getVersion() != 0) goto L9;
        return AesSivParameters.builder().setKeySizeBytes(r0.getKeySize()).setVariant(toVariant(serialization.getKeyTemplate().getOutputPrefixType())).build();
    L9:
        throw new GeneralSecurityException("Only version 0 keys are accepted");     // Catch: InvalidProtocolBufferException -> L10
    L10:
        e = move-exception;
        throw new GeneralSecurityException("Parsing AesSivParameters failed: ", e);
    L14:
        throw new IllegalArgumentException("Wrong type URL in call to AesSivParameters.parseParameters: " + serialization.getKeyTemplate().getTypeUrl());
    }

    private static AesSivKey parseKey(ProtoKeySerialization serialization, @Nullable SecretKeyAccess access) throws GeneralSecurityException {
        if (serialization.getTypeUrl().equals(TYPE_URL) == false) goto L13;
        com.google.crypto.tink.proto.AesSivKey r0 = com.google.crypto.tink.proto.AesSivKey.parseFrom(serialization.getValue(), ExtensionRegistryLite.getEmptyRegistry());     // Catch: InvalidProtocolBufferException -> L10
        if (r0.getVersion() != 0) goto L9;
        AesSivParameters r1 = AesSivParameters.builder().setKeySizeBytes(r0.getKeyValue().size()).setVariant(toVariant(serialization.getOutputPrefixType())).build();     // Catch: InvalidProtocolBufferException -> L10
        return AesSivKey.builder().setParameters(r1).setKeyBytes(SecretBytes.copyFrom(r0.getKeyValue().toByteArray(), SecretKeyAccess.requireAccess(access))).setIdRequirement(serialization.getIdRequirementOrNull()).build();
    L9:
        throw new GeneralSecurityException("Only version 0 keys are accepted");     // Catch: InvalidProtocolBufferException -> L10
    L11:
        throw new GeneralSecurityException("Parsing AesSivKey failed");
    L13:
        throw new IllegalArgumentException("Wrong type URL in call to AesSivParameters.parseParameters");
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

    private AesSivProtoSerialization() {
    }
}
