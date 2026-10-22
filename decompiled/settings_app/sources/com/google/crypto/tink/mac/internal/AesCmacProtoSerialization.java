package com.google.crypto.tink.mac.internal;

import com.google.crypto.tink.SecretKeyAccess;
import com.google.crypto.tink.internal.KeyParser;
import com.google.crypto.tink.internal.KeySerializer;
import com.google.crypto.tink.internal.MutableSerializationRegistry;
import com.google.crypto.tink.internal.ParametersParser;
import com.google.crypto.tink.internal.ParametersSerializer;
import com.google.crypto.tink.internal.ProtoKeySerialization;
import com.google.crypto.tink.internal.ProtoParametersSerialization;
import com.google.crypto.tink.internal.Util;
import com.google.crypto.tink.mac.AesCmacKey;
import com.google.crypto.tink.mac.AesCmacParameters;
import com.google.crypto.tink.proto.AesCmacKeyFormat;
import com.google.crypto.tink.proto.AesCmacParams;
import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.proto.KeyTemplate;
import com.google.crypto.tink.proto.OutputPrefixType;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.util.Bytes;
import com.google.crypto.tink.util.SecretBytes;
import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class AesCmacProtoSerialization {
    private static final KeyParser<ProtoKeySerialization> KEY_PARSER = null;
    private static final KeySerializer<AesCmacKey, ProtoKeySerialization> KEY_SERIALIZER = null;
    private static final ParametersParser<ProtoParametersSerialization> PARAMETERS_PARSER = null;
    private static final ParametersSerializer<AesCmacParameters, ProtoParametersSerialization> PARAMETERS_SERIALIZER = null;
    private static final String TYPE_URL = "type.googleapis.com/google.crypto.tink.AesCmacKey";
    private static final Bytes TYPE_URL_BYTES = null;

    /* JADX INFO: renamed from: com.google.crypto.tink.mac.internal.AesCmacProtoSerialization$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$crypto$tink$proto$OutputPrefixType = null;

        static {
            int[] r0 = new int[OutputPrefixType.values().length];
            $SwitchMap$com$google$crypto$tink$proto$OutputPrefixType = r0;
            r0[OutputPrefixType.TINK.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L12:
            $SwitchMap$com$google$crypto$tink$proto$OutputPrefixType[OutputPrefixType.CRUNCHY.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L14:
            $SwitchMap$com$google$crypto$tink$proto$OutputPrefixType[OutputPrefixType.LEGACY.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L18:
            $SwitchMap$com$google$crypto$tink$proto$OutputPrefixType[OutputPrefixType.RAW.ordinal()] = 4;     // Catch: NoSuchFieldError -> L11
            return;
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$03CG-yJ3Y9lg26emcyENCSELplQ, reason: not valid java name */
    public static /* synthetic */ AesCmacKey m942$r8$lambda$03CGyJ3Y9lg26emcyENCSELplQ(ProtoKeySerialization r0, SecretKeyAccess r1) {
        return parseKey(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$7fxOxWBGLoaPGfH5TzsDPkgT-XE, reason: not valid java name */
    public static /* synthetic */ ProtoParametersSerialization m943$r8$lambda$7fxOxWBGLoaPGfH5TzsDPkgTXE(AesCmacParameters r0) {
        return serializeParameters(r0);
    }

    /* JADX INFO: renamed from: $r8$lambda$EVLzPX02H_a9a-d83nty9w_QB6c, reason: not valid java name */
    public static /* synthetic */ ProtoKeySerialization m944$r8$lambda$EVLzPX02H_a9ad83nty9w_QB6c(AesCmacKey r0, SecretKeyAccess r1) {
        return serializeKey(r0, r1);
    }

    public static /* synthetic */ AesCmacParameters $r8$lambda$eZOBa9pv2oVrh0btPej8wFXbfXU(ProtoParametersSerialization r0) {
        return parseParameters(r0);
    }

    static {
        Bytes r0 = Util.toBytesFromPrintableAscii(TYPE_URL);
        TYPE_URL_BYTES = r0;
        PARAMETERS_SERIALIZER = ParametersSerializer.create(new AesCmacProtoSerialization$$ExternalSyntheticLambda0(), AesCmacParameters.class, ProtoParametersSerialization.class);
        PARAMETERS_PARSER = ParametersParser.create(new AesCmacProtoSerialization$$ExternalSyntheticLambda1(), r0, ProtoParametersSerialization.class);
        KEY_SERIALIZER = KeySerializer.create(new AesCmacProtoSerialization$$ExternalSyntheticLambda2(), AesCmacKey.class, ProtoKeySerialization.class);
        KEY_PARSER = KeyParser.create(new AesCmacProtoSerialization$$ExternalSyntheticLambda3(), r0, ProtoKeySerialization.class);
    }

    private static OutputPrefixType toOutputPrefixType(AesCmacParameters.Variant variant) throws GeneralSecurityException {
        if (AesCmacParameters.Variant.TINK.equals(variant) == false) goto L7;
        return OutputPrefixType.TINK;
    L7:
        if (AesCmacParameters.Variant.CRUNCHY.equals(variant) == false) goto L11;
        return OutputPrefixType.CRUNCHY;
    L11:
        if (AesCmacParameters.Variant.NO_PREFIX.equals(variant) == false) goto L15;
        return OutputPrefixType.RAW;
    L15:
        if (AesCmacParameters.Variant.LEGACY.equals(variant) == false) goto L19;
        return OutputPrefixType.LEGACY;
    L19:
        throw new GeneralSecurityException("Unable to serialize variant: " + variant);
    }

    private static AesCmacParameters.Variant toVariant(OutputPrefixType outputPrefixType) throws GeneralSecurityException {
        int r0 = AnonymousClass1.$SwitchMap$com$google$crypto$tink$proto$OutputPrefixType[outputPrefixType.ordinal()];
        if (r0 == 1) goto L19;
        if (r0 == 2) goto L17;
        if (r0 == 3) goto L15;
        if (r0 != 4) goto L13;
        return AesCmacParameters.Variant.NO_PREFIX;
    L13:
        throw new GeneralSecurityException("Unable to parse OutputPrefixType: " + outputPrefixType.getNumber());
    L15:
        return AesCmacParameters.Variant.LEGACY;
    L17:
        return AesCmacParameters.Variant.CRUNCHY;
    L19:
        return AesCmacParameters.Variant.TINK;
    }

    private static AesCmacParams getProtoParams(AesCmacParameters parameters) {
        return (AesCmacParams) AesCmacParams.newBuilder().setTagSize(parameters.getCryptographicTagSizeBytes()).build();
    }

    private static ProtoParametersSerialization serializeParameters(AesCmacParameters parameters) throws GeneralSecurityException {
        return ProtoParametersSerialization.create((KeyTemplate) KeyTemplate.newBuilder().setTypeUrl(TYPE_URL).setValue(((AesCmacKeyFormat) AesCmacKeyFormat.newBuilder().setParams(getProtoParams(parameters)).setKeySize(parameters.getKeySizeBytes()).build()).toByteString()).setOutputPrefixType(toOutputPrefixType(parameters.getVariant())).build());
    }

    private static ProtoKeySerialization serializeKey(AesCmacKey key, @Nullable SecretKeyAccess access) throws GeneralSecurityException {
        return ProtoKeySerialization.create(TYPE_URL, ((com.google.crypto.tink.proto.AesCmacKey) com.google.crypto.tink.proto.AesCmacKey.newBuilder().setParams(getProtoParams(key.getParameters())).setKeyValue(ByteString.copyFrom(key.getAesKey().toByteArray(SecretKeyAccess.requireAccess(access)))).build()).toByteString(), KeyData.KeyMaterialType.SYMMETRIC, toOutputPrefixType(key.getParameters().getVariant()), key.getIdRequirementOrNull());
    }

    private static AesCmacParameters parseParameters(ProtoParametersSerialization serialization) throws GeneralSecurityException {
        if (serialization.getKeyTemplate().getTypeUrl().equals(TYPE_URL) == false) goto L11;
        AesCmacKeyFormat r0 = AesCmacKeyFormat.parseFrom(serialization.getKeyTemplate().getValue(), ExtensionRegistryLite.getEmptyRegistry());     // Catch: InvalidProtocolBufferException -> L7
        return AesCmacParameters.builder().setKeySizeBytes(r0.getKeySize()).setTagSizeBytes(r0.getParams().getTagSize()).setVariant(toVariant(serialization.getKeyTemplate().getOutputPrefixType())).build();
    L7:
        e = move-exception;
        throw new GeneralSecurityException("Parsing AesCmacParameters failed: ", e);
    L11:
        throw new IllegalArgumentException("Wrong type URL in call to AesCmacProtoSerialization.parseParameters: " + serialization.getKeyTemplate().getTypeUrl());
    }

    private static AesCmacKey parseKey(ProtoKeySerialization serialization, @Nullable SecretKeyAccess access) throws GeneralSecurityException {
        if (serialization.getTypeUrl().equals(TYPE_URL) == false) goto L13;
        com.google.crypto.tink.proto.AesCmacKey r0 = com.google.crypto.tink.proto.AesCmacKey.parseFrom(serialization.getValue(), ExtensionRegistryLite.getEmptyRegistry());     // Catch: Throwable -> L10
        if (r0.getVersion() != 0) goto L9;
        AesCmacParameters r1 = AesCmacParameters.builder().setKeySizeBytes(r0.getKeyValue().size()).setTagSizeBytes(r0.getParams().getTagSize()).setVariant(toVariant(serialization.getOutputPrefixType())).build();     // Catch: Throwable -> L10
        return AesCmacKey.builder().setParameters(r1).setAesKeyBytes(SecretBytes.copyFrom(r0.getKeyValue().toByteArray(), SecretKeyAccess.requireAccess(access))).setIdRequirement(serialization.getIdRequirementOrNull()).build();
    L9:
        throw new GeneralSecurityException("Only version 0 keys are accepted");     // Catch: Throwable -> L10
    L11:
        throw new GeneralSecurityException("Parsing AesCmacKey failed");
    L13:
        throw new IllegalArgumentException("Wrong type URL in call to AesCmacProtoSerialization.parseKey");
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

    private AesCmacProtoSerialization() {
    }
}
