package com.google.crypto.tink.prf.internal;

import com.google.crypto.tink.SecretKeyAccess;
import com.google.crypto.tink.internal.KeyParser;
import com.google.crypto.tink.internal.KeySerializer;
import com.google.crypto.tink.internal.MutableSerializationRegistry;
import com.google.crypto.tink.internal.ParametersParser;
import com.google.crypto.tink.internal.ParametersSerializer;
import com.google.crypto.tink.internal.ProtoKeySerialization;
import com.google.crypto.tink.internal.ProtoParametersSerialization;
import com.google.crypto.tink.internal.Util;
import com.google.crypto.tink.prf.AesCmacPrfKey;
import com.google.crypto.tink.prf.AesCmacPrfParameters;
import com.google.crypto.tink.proto.AesCmacPrfKeyFormat;
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
public final class AesCmacPrfProtoSerialization {
    private static final KeyParser<ProtoKeySerialization> KEY_PARSER = null;
    private static final KeySerializer<AesCmacPrfKey, ProtoKeySerialization> KEY_SERIALIZER = null;
    private static final ParametersParser<ProtoParametersSerialization> PARAMETERS_PARSER = null;
    private static final ParametersSerializer<AesCmacPrfParameters, ProtoParametersSerialization> PARAMETERS_SERIALIZER = null;
    private static final String TYPE_URL = "type.googleapis.com/google.crypto.tink.AesCmacPrfKey";
    private static final Bytes TYPE_URL_BYTES = null;

    /* JADX INFO: renamed from: $r8$lambda$-OLcwtXx19sSQcvu1nIbjfte6cs, reason: not valid java name */
    public static /* synthetic */ AesCmacPrfKey m947$r8$lambda$OLcwtXx19sSQcvu1nIbjfte6cs(ProtoKeySerialization r0, SecretKeyAccess r1) {
        return parseKey(r0, r1);
    }

    public static /* synthetic */ ProtoKeySerialization $r8$lambda$DJF1YYTSKOOmNDgLZHsbJljxjIg(AesCmacPrfKey r0, SecretKeyAccess r1) {
        return serializeKey(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$PjAmkjERrX8DXhgbsq-zC_5PXVQ, reason: not valid java name */
    public static /* synthetic */ ProtoParametersSerialization m948$r8$lambda$PjAmkjERrX8DXhgbsqzC_5PXVQ(AesCmacPrfParameters r0) {
        return serializeParameters(r0);
    }

    /* JADX INFO: renamed from: $r8$lambda$n10zNu-XthEItEnuPjHy1lBzvRc, reason: not valid java name */
    public static /* synthetic */ AesCmacPrfParameters m949$r8$lambda$n10zNuXthEItEnuPjHy1lBzvRc(ProtoParametersSerialization r0) {
        return parseParameters(r0);
    }

    static {
        Bytes r0 = Util.toBytesFromPrintableAscii(TYPE_URL);
        TYPE_URL_BYTES = r0;
        PARAMETERS_SERIALIZER = ParametersSerializer.create(new AesCmacPrfProtoSerialization$$ExternalSyntheticLambda0(), AesCmacPrfParameters.class, ProtoParametersSerialization.class);
        PARAMETERS_PARSER = ParametersParser.create(new AesCmacPrfProtoSerialization$$ExternalSyntheticLambda1(), r0, ProtoParametersSerialization.class);
        KEY_SERIALIZER = KeySerializer.create(new AesCmacPrfProtoSerialization$$ExternalSyntheticLambda2(), AesCmacPrfKey.class, ProtoKeySerialization.class);
        KEY_PARSER = KeyParser.create(new AesCmacPrfProtoSerialization$$ExternalSyntheticLambda3(), r0, ProtoKeySerialization.class);
    }

    private static ProtoParametersSerialization serializeParameters(AesCmacPrfParameters parameters) {
        return ProtoParametersSerialization.create((KeyTemplate) KeyTemplate.newBuilder().setTypeUrl(TYPE_URL).setValue(((AesCmacPrfKeyFormat) AesCmacPrfKeyFormat.newBuilder().setKeySize(parameters.getKeySizeBytes()).build()).toByteString()).setOutputPrefixType(OutputPrefixType.RAW).build());
    }

    private static ProtoKeySerialization serializeKey(AesCmacPrfKey key, @Nullable SecretKeyAccess access) throws GeneralSecurityException {
        return ProtoKeySerialization.create(TYPE_URL, ((com.google.crypto.tink.proto.AesCmacPrfKey) com.google.crypto.tink.proto.AesCmacPrfKey.newBuilder().setKeyValue(ByteString.copyFrom(key.getKeyBytes().toByteArray(SecretKeyAccess.requireAccess(access)))).build()).toByteString(), KeyData.KeyMaterialType.SYMMETRIC, OutputPrefixType.RAW, key.getIdRequirementOrNull());
    }

    private static AesCmacPrfParameters parseParameters(ProtoParametersSerialization serialization) throws GeneralSecurityException {
        if (serialization.getKeyTemplate().getTypeUrl().equals(TYPE_URL) == false) goto L19;
        AesCmacPrfKeyFormat r0 = AesCmacPrfKeyFormat.parseFrom(serialization.getKeyTemplate().getValue(), ExtensionRegistryLite.getEmptyRegistry());     // Catch: InvalidProtocolBufferException -> L15
        if (r0.getVersion() != 0) goto L14;
        if (serialization.getKeyTemplate().getOutputPrefixType() != OutputPrefixType.RAW) goto L12;
        return AesCmacPrfParameters.create(r0.getKeySize());
    L12:
        throw new GeneralSecurityException("Parsing AesCmacPrfParameters failed: only RAW output prefix type is accepted");
    L14:
        throw new GeneralSecurityException("Parsing AesCmacPrfParameters failed: unknown Version " + r0.getVersion());
    L15:
        e = move-exception;
        throw new GeneralSecurityException("Parsing AesCmacPrfParameters failed: ", e);
    L19:
        throw new IllegalArgumentException("Wrong type URL in call to AesCmacPrfProtoSerialization.parseParameters: " + serialization.getKeyTemplate().getTypeUrl());
    }

    private static AesCmacPrfKey parseKey(ProtoKeySerialization serialization, @Nullable SecretKeyAccess access) throws GeneralSecurityException {
        if (serialization.getTypeUrl().equals(TYPE_URL) == false) goto L17;
        com.google.crypto.tink.proto.AesCmacPrfKey r0 = com.google.crypto.tink.proto.AesCmacPrfKey.parseFrom(serialization.getValue(), ExtensionRegistryLite.getEmptyRegistry());     // Catch: InvalidProtocolBufferException -> L14
        if (r0.getVersion() != 0) goto L13;
        if (serialization.getIdRequirementOrNull() != null) goto L11;
        return AesCmacPrfKey.create(AesCmacPrfParameters.create(r0.getKeyValue().size()), SecretBytes.copyFrom(r0.getKeyValue().toByteArray(), SecretKeyAccess.requireAccess(access)));
    L11:
        throw new GeneralSecurityException("ID requirement must be null.");     // Catch: InvalidProtocolBufferException -> L14
    L13:
        throw new GeneralSecurityException("Only version 0 keys are accepted");     // Catch: InvalidProtocolBufferException -> L14
    L15:
        throw new GeneralSecurityException("Parsing AesCmacPrfKey failed");
    L17:
        throw new IllegalArgumentException("Wrong type URL in call to AesCmacPrfProtoSerialization.parseKey");
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

    private AesCmacPrfProtoSerialization() {
    }
}
