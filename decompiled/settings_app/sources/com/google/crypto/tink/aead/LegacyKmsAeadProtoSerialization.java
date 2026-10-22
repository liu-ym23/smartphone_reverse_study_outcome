package com.google.crypto.tink.aead;

import com.google.crypto.tink.SecretKeyAccess;
import com.google.crypto.tink.internal.KeyParser;
import com.google.crypto.tink.internal.KeySerializer;
import com.google.crypto.tink.internal.MutableSerializationRegistry;
import com.google.crypto.tink.internal.ParametersParser;
import com.google.crypto.tink.internal.ParametersSerializer;
import com.google.crypto.tink.internal.ProtoKeySerialization;
import com.google.crypto.tink.internal.ProtoParametersSerialization;
import com.google.crypto.tink.internal.Util;
import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.proto.KeyTemplate;
import com.google.crypto.tink.proto.KmsAeadKey;
import com.google.crypto.tink.proto.KmsAeadKeyFormat;
import com.google.crypto.tink.proto.OutputPrefixType;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.util.Bytes;
import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
final class LegacyKmsAeadProtoSerialization {
    private static final KeyParser<ProtoKeySerialization> KEY_PARSER = null;
    private static final KeySerializer<LegacyKmsAeadKey, ProtoKeySerialization> KEY_SERIALIZER = null;
    private static final ParametersParser<ProtoParametersSerialization> PARAMETERS_PARSER = null;
    private static final ParametersSerializer<LegacyKmsAeadParameters, ProtoParametersSerialization> PARAMETERS_SERIALIZER = null;
    private static final String TYPE_URL = "type.googleapis.com/google.crypto.tink.KmsAeadKey";
    private static final Bytes TYPE_URL_BYTES = null;

    /* JADX INFO: renamed from: com.google.crypto.tink.aead.LegacyKmsAeadProtoSerialization$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$crypto$tink$proto$OutputPrefixType = null;

        static {
            int[] r0 = new int[OutputPrefixType.values().length];
            $SwitchMap$com$google$crypto$tink$proto$OutputPrefixType = r0;
            r0[OutputPrefixType.TINK.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            $SwitchMap$com$google$crypto$tink$proto$OutputPrefixType[OutputPrefixType.RAW.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
            return;
        }
    }

    public static /* synthetic */ ProtoParametersSerialization $r8$lambda$3sE5k4pIUfv8YWZWSKttL7gjBFs(LegacyKmsAeadParameters r0) {
        return serializeParameters(r0);
    }

    /* JADX INFO: renamed from: $r8$lambda$bTrMBDwTja1IoYZyN-EB2CYENpU, reason: not valid java name */
    public static /* synthetic */ LegacyKmsAeadKey m919$r8$lambda$bTrMBDwTja1IoYZyNEB2CYENpU(ProtoKeySerialization r0, SecretKeyAccess r1) {
        return parseKey(r0, r1);
    }

    public static /* synthetic */ ProtoKeySerialization $r8$lambda$fCLQEBIrhuiK3ZNnST9cbtT9D4E(LegacyKmsAeadKey r0, SecretKeyAccess r1) {
        return serializeKey(r0, r1);
    }

    public static /* synthetic */ LegacyKmsAeadParameters $r8$lambda$x4voL_yQC4i73k9HRFp2B5z7XlA(ProtoParametersSerialization r0) {
        return parseParameters(r0);
    }

    static {
        Bytes r0 = Util.toBytesFromPrintableAscii(TYPE_URL);
        TYPE_URL_BYTES = r0;
        PARAMETERS_SERIALIZER = ParametersSerializer.create(new LegacyKmsAeadProtoSerialization$$ExternalSyntheticLambda0(), LegacyKmsAeadParameters.class, ProtoParametersSerialization.class);
        PARAMETERS_PARSER = ParametersParser.create(new LegacyKmsAeadProtoSerialization$$ExternalSyntheticLambda1(), r0, ProtoParametersSerialization.class);
        KEY_SERIALIZER = KeySerializer.create(new LegacyKmsAeadProtoSerialization$$ExternalSyntheticLambda2(), LegacyKmsAeadKey.class, ProtoKeySerialization.class);
        KEY_PARSER = KeyParser.create(new LegacyKmsAeadProtoSerialization$$ExternalSyntheticLambda3(), r0, ProtoKeySerialization.class);
    }

    private static OutputPrefixType toProtoOutputPrefixType(LegacyKmsAeadParameters.Variant variant) throws GeneralSecurityException {
        if (LegacyKmsAeadParameters.Variant.TINK.equals(variant) == false) goto L7;
        return OutputPrefixType.TINK;
    L7:
        if (LegacyKmsAeadParameters.Variant.NO_PREFIX.equals(variant) == false) goto L11;
        return OutputPrefixType.RAW;
    L11:
        throw new GeneralSecurityException("Unable to serialize variant: " + variant);
    }

    private static LegacyKmsAeadParameters.Variant toVariant(OutputPrefixType outputPrefixType) throws GeneralSecurityException {
        int r0 = AnonymousClass1.$SwitchMap$com$google$crypto$tink$proto$OutputPrefixType[outputPrefixType.ordinal()];
        if (r0 == 1) goto L11;
        if (r0 != 2) goto L9;
        return LegacyKmsAeadParameters.Variant.NO_PREFIX;
    L9:
        throw new GeneralSecurityException("Unable to parse OutputPrefixType: " + outputPrefixType.getNumber());
    L11:
        return LegacyKmsAeadParameters.Variant.TINK;
    }

    private static ProtoParametersSerialization serializeParameters(LegacyKmsAeadParameters parameters) throws GeneralSecurityException {
        return ProtoParametersSerialization.create((KeyTemplate) KeyTemplate.newBuilder().setTypeUrl(TYPE_URL).setValue(((KmsAeadKeyFormat) KmsAeadKeyFormat.newBuilder().setKeyUri(parameters.keyUri()).build()).toByteString()).setOutputPrefixType(toProtoOutputPrefixType(parameters.variant())).build());
    }

    private static LegacyKmsAeadParameters parseParameters(ProtoParametersSerialization serialization) throws GeneralSecurityException {
        if (serialization.getKeyTemplate().getTypeUrl().equals(TYPE_URL) == false) goto L11;
        return LegacyKmsAeadParameters.create(KmsAeadKeyFormat.parseFrom(serialization.getKeyTemplate().getValue(), ExtensionRegistryLite.getEmptyRegistry()).getKeyUri(), toVariant(serialization.getKeyTemplate().getOutputPrefixType()));
    L7:
        e = move-exception;
        throw new GeneralSecurityException("Parsing KmsAeadKeyFormat failed: ", e);
    L11:
        throw new IllegalArgumentException("Wrong type URL in call to LegacyKmsAeadProtoSerialization.parseParameters: " + serialization.getKeyTemplate().getTypeUrl());
    }

    private static ProtoKeySerialization serializeKey(LegacyKmsAeadKey key, @Nullable SecretKeyAccess access) throws GeneralSecurityException {
        return ProtoKeySerialization.create(TYPE_URL, ((KmsAeadKey) KmsAeadKey.newBuilder().setParams((KmsAeadKeyFormat) KmsAeadKeyFormat.newBuilder().setKeyUri(key.getParameters().keyUri()).build()).build()).toByteString(), KeyData.KeyMaterialType.REMOTE, toProtoOutputPrefixType(key.getParameters().variant()), key.getIdRequirementOrNull());
    }

    private static LegacyKmsAeadKey parseKey(ProtoKeySerialization serialization, @Nullable SecretKeyAccess access) throws GeneralSecurityException {
        if (serialization.getTypeUrl().equals(TYPE_URL) == false) goto L14;
        KmsAeadKey r0 = KmsAeadKey.parseFrom(serialization.getValue(), ExtensionRegistryLite.getEmptyRegistry());     // Catch: InvalidProtocolBufferException -> L10
        if (r0.getVersion() != 0) goto L9;
        return LegacyKmsAeadKey.create(LegacyKmsAeadParameters.create(r0.getParams().getKeyUri(), toVariant(serialization.getOutputPrefixType())), serialization.getIdRequirementOrNull());
    L9:
        throw new GeneralSecurityException("KmsAeadKey are only accepted with version 0, got " + r0);     // Catch: InvalidProtocolBufferException -> L10
    L10:
        e = move-exception;
        throw new GeneralSecurityException("Parsing KmsAeadKey failed: ", e);
    L14:
        throw new IllegalArgumentException("Wrong type URL in call to LegacyKmsAeadProtoSerialization.parseKey");
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

    private LegacyKmsAeadProtoSerialization() {
    }
}
