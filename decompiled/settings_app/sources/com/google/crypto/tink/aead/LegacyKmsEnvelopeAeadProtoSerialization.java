package com.google.crypto.tink.aead;

import com.google.crypto.tink.Parameters;
import com.google.crypto.tink.SecretKeyAccess;
import com.google.crypto.tink.TinkProtoParametersFormat;
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
import com.google.crypto.tink.proto.KmsEnvelopeAeadKey;
import com.google.crypto.tink.proto.KmsEnvelopeAeadKeyFormat;
import com.google.crypto.tink.proto.OutputPrefixType;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.util.Bytes;
import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class LegacyKmsEnvelopeAeadProtoSerialization {
    private static final KeyParser<ProtoKeySerialization> KEY_PARSER = null;
    private static final KeySerializer<LegacyKmsEnvelopeAeadKey, ProtoKeySerialization> KEY_SERIALIZER = null;
    private static final ParametersParser<ProtoParametersSerialization> PARAMETERS_PARSER = null;
    private static final ParametersSerializer<LegacyKmsEnvelopeAeadParameters, ProtoParametersSerialization> PARAMETERS_SERIALIZER = null;
    private static final String TYPE_URL = "type.googleapis.com/google.crypto.tink.KmsEnvelopeAeadKey";
    private static final Bytes TYPE_URL_BYTES = null;

    /* JADX INFO: renamed from: com.google.crypto.tink.aead.LegacyKmsEnvelopeAeadProtoSerialization$1, reason: invalid class name */
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

    /* JADX INFO: renamed from: $r8$lambda$OXdW37-RHk7iHGsADYfA2shlCMk, reason: not valid java name */
    public static /* synthetic */ ProtoParametersSerialization m920$r8$lambda$OXdW37RHk7iHGsADYfA2shlCMk(LegacyKmsEnvelopeAeadParameters r0) {
        return serializeParameters(r0);
    }

    public static /* synthetic */ ProtoKeySerialization $r8$lambda$cSHvnfHqlqrutjhswmVlkyC947E(LegacyKmsEnvelopeAeadKey r0, SecretKeyAccess r1) {
        return serializeKey(r0, r1);
    }

    public static /* synthetic */ LegacyKmsEnvelopeAeadParameters $r8$lambda$wZ7D9Fv2F39_SEu_HqQcsiiHju4(ProtoParametersSerialization r0) {
        return parseParameters(r0);
    }

    public static /* synthetic */ LegacyKmsEnvelopeAeadKey $r8$lambda$yC3OWmrcpIzHmEebJhJMIsum3us(ProtoKeySerialization r0, SecretKeyAccess r1) {
        return parseKey(r0, r1);
    }

    static {
        Bytes r0 = Util.toBytesFromPrintableAscii(TYPE_URL);
        TYPE_URL_BYTES = r0;
        PARAMETERS_SERIALIZER = ParametersSerializer.create(new LegacyKmsEnvelopeAeadProtoSerialization$$ExternalSyntheticLambda0(), LegacyKmsEnvelopeAeadParameters.class, ProtoParametersSerialization.class);
        PARAMETERS_PARSER = ParametersParser.create(new LegacyKmsEnvelopeAeadProtoSerialization$$ExternalSyntheticLambda1(), r0, ProtoParametersSerialization.class);
        KEY_SERIALIZER = KeySerializer.create(new LegacyKmsEnvelopeAeadProtoSerialization$$ExternalSyntheticLambda2(), LegacyKmsEnvelopeAeadKey.class, ProtoKeySerialization.class);
        KEY_PARSER = KeyParser.create(new LegacyKmsEnvelopeAeadProtoSerialization$$ExternalSyntheticLambda3(), r0, ProtoKeySerialization.class);
    }

    private static OutputPrefixType toProtoOutputPrefixType(LegacyKmsEnvelopeAeadParameters.Variant variant) throws GeneralSecurityException {
        if (LegacyKmsEnvelopeAeadParameters.Variant.TINK.equals(variant) == false) goto L7;
        return OutputPrefixType.TINK;
    L7:
        if (LegacyKmsEnvelopeAeadParameters.Variant.NO_PREFIX.equals(variant) == false) goto L11;
        return OutputPrefixType.RAW;
    L11:
        throw new GeneralSecurityException("Unable to serialize variant: " + variant);
    }

    private static LegacyKmsEnvelopeAeadParameters.Variant toVariant(OutputPrefixType outputPrefixType) throws GeneralSecurityException {
        int r0 = AnonymousClass1.$SwitchMap$com$google$crypto$tink$proto$OutputPrefixType[outputPrefixType.ordinal()];
        if (r0 == 1) goto L11;
        if (r0 != 2) goto L9;
        return LegacyKmsEnvelopeAeadParameters.Variant.NO_PREFIX;
    L9:
        throw new GeneralSecurityException("Unable to parse OutputPrefixType: " + outputPrefixType.getNumber());
    L11:
        return LegacyKmsEnvelopeAeadParameters.Variant.TINK;
    }

    private static ProtoParametersSerialization serializeParameters(LegacyKmsEnvelopeAeadParameters parameters) throws GeneralSecurityException {
        return ProtoParametersSerialization.create((KeyTemplate) KeyTemplate.newBuilder().setTypeUrl(TYPE_URL).setValue(serializeParametersToKmsEnvelopeAeadKeyFormat(parameters).toByteString()).setOutputPrefixType(toProtoOutputPrefixType(parameters.getVariant())).build());
    }

    private static KmsEnvelopeAeadKeyFormat serializeParametersToKmsEnvelopeAeadKeyFormat(LegacyKmsEnvelopeAeadParameters parameters) throws GeneralSecurityException {
        byte[] r0 = TinkProtoParametersFormat.serialize(parameters.getDekParametersForNewKeys());
        KeyTemplate r1 = KeyTemplate.parseFrom(r0, ExtensionRegistryLite.getEmptyRegistry());     // Catch: InvalidProtocolBufferException -> L5
        return (KmsEnvelopeAeadKeyFormat) KmsEnvelopeAeadKeyFormat.newBuilder().setKekUri(parameters.getKekUri()).setDekTemplate(r1).build();
    L5:
        e = move-exception;
        throw new GeneralSecurityException("Parsing KmsEnvelopeAeadKeyFormat failed: ", e);
    }

    private static ProtoKeySerialization serializeKey(LegacyKmsEnvelopeAeadKey key, @Nullable SecretKeyAccess access) throws GeneralSecurityException {
        return ProtoKeySerialization.create(TYPE_URL, ((KmsEnvelopeAeadKey) KmsEnvelopeAeadKey.newBuilder().setParams(serializeParametersToKmsEnvelopeAeadKeyFormat(key.getParameters())).build()).toByteString(), KeyData.KeyMaterialType.REMOTE, toProtoOutputPrefixType(key.getParameters().getVariant()), key.getIdRequirementOrNull());
    }

    private static LegacyKmsEnvelopeAeadParameters parseParameters(ProtoParametersSerialization serialization) throws GeneralSecurityException {
        if (serialization.getKeyTemplate().getTypeUrl().equals(TYPE_URL) == false) goto L11;
        return parseParameters(KmsEnvelopeAeadKeyFormat.parseFrom(serialization.getKeyTemplate().getValue(), ExtensionRegistryLite.getEmptyRegistry()), serialization.getKeyTemplate().getOutputPrefixType());
    L7:
        e = move-exception;
        throw new GeneralSecurityException("Parsing KmsEnvelopeAeadKeyFormat failed: ", e);
    L11:
        throw new IllegalArgumentException("Wrong type URL in call to LegacyKmsEnvelopeAeadProtoSerialization.parseParameters: " + serialization.getKeyTemplate().getTypeUrl());
    }

    private static LegacyKmsEnvelopeAeadParameters parseParameters(KmsEnvelopeAeadKeyFormat format, OutputPrefixType outputPrefixType) throws GeneralSecurityException {
        Parameters r0 = TinkProtoParametersFormat.parse(((KeyTemplate) KeyTemplate.newBuilder().setTypeUrl(format.getDekTemplate().getTypeUrl()).setValue(format.getDekTemplate().getValue()).setOutputPrefixType(OutputPrefixType.RAW).build()).toByteArray());
        if ((r0 instanceof AesGcmParameters) == false) goto L6;
        LegacyKmsEnvelopeAeadParameters.DekParsingStrategy r1 = LegacyKmsEnvelopeAeadParameters.DekParsingStrategy.ASSUME_AES_GCM;
    L21:
        return LegacyKmsEnvelopeAeadParameters.builder().setVariant(toVariant(outputPrefixType)).setKekUri(format.getKekUri()).setDekParametersForNewKeys((AeadParameters) r0).setDekParsingStrategy(r1).build();
    L6:
        if ((r0 instanceof ChaCha20Poly1305Parameters) == false) goto L9;
        r1 = LegacyKmsEnvelopeAeadParameters.DekParsingStrategy.ASSUME_CHACHA20POLY1305;
        goto L21
    L9:
        if ((r0 instanceof XChaCha20Poly1305Parameters) == false) goto L12;
        r1 = LegacyKmsEnvelopeAeadParameters.DekParsingStrategy.ASSUME_XCHACHA20POLY1305;
        goto L21
    L12:
        if ((r0 instanceof AesCtrHmacAeadParameters) == false) goto L15;
        r1 = LegacyKmsEnvelopeAeadParameters.DekParsingStrategy.ASSUME_AES_CTR_HMAC;
        goto L21
    L15:
        if ((r0 instanceof AesEaxParameters) == false) goto L18;
        r1 = LegacyKmsEnvelopeAeadParameters.DekParsingStrategy.ASSUME_AES_EAX;
        goto L21
    L18:
        if ((r0 instanceof AesGcmSivParameters) == false) goto L23;
        r1 = LegacyKmsEnvelopeAeadParameters.DekParsingStrategy.ASSUME_AES_GCM_SIV;
        goto L21
    L23:
        throw new GeneralSecurityException("Unsupported DEK parameters when parsing " + r0);
    }

    private static LegacyKmsEnvelopeAeadKey parseKey(ProtoKeySerialization serialization, @Nullable SecretKeyAccess access) throws GeneralSecurityException {
        if (serialization.getTypeUrl().equals(TYPE_URL) == false) goto L14;
        KmsEnvelopeAeadKey r0 = KmsEnvelopeAeadKey.parseFrom(serialization.getValue(), ExtensionRegistryLite.getEmptyRegistry());     // Catch: InvalidProtocolBufferException -> L10
        if (r0.getVersion() != 0) goto L9;
        return LegacyKmsEnvelopeAeadKey.create(parseParameters(r0.getParams(), serialization.getOutputPrefixType()), serialization.getIdRequirementOrNull());
    L9:
        throw new GeneralSecurityException("KmsEnvelopeAeadKeys are only accepted with version 0, got " + r0);     // Catch: InvalidProtocolBufferException -> L10
    L10:
        e = move-exception;
        throw new GeneralSecurityException("Parsing KmsEnvelopeAeadKey failed: ", e);
    L14:
        throw new IllegalArgumentException("Wrong type URL in call to LegacyKmsEnvelopeAeadProtoSerialization.parseKey");
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

    private LegacyKmsEnvelopeAeadProtoSerialization() {
    }
}
