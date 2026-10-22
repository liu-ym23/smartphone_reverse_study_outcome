package com.google.crypto.tink.keyderivation.internal;

import com.google.crypto.tink.Key;
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
import com.google.crypto.tink.keyderivation.PrfBasedKeyDerivationKey;
import com.google.crypto.tink.keyderivation.PrfBasedKeyDerivationParameters;
import com.google.crypto.tink.prf.PrfKey;
import com.google.crypto.tink.prf.PrfParameters;
import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.proto.KeyTemplate;
import com.google.crypto.tink.proto.OutputPrefixType;
import com.google.crypto.tink.proto.PrfBasedDeriverKey;
import com.google.crypto.tink.proto.PrfBasedDeriverKeyFormat;
import com.google.crypto.tink.proto.PrfBasedDeriverParams;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.util.Bytes;
import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
final class PrfBasedKeyDerivationKeyProtoSerialization {
    private static final KeyParser<ProtoKeySerialization> KEY_PARSER = null;
    private static final KeySerializer<PrfBasedKeyDerivationKey, ProtoKeySerialization> KEY_SERIALIZER = null;
    private static final ParametersParser<ProtoParametersSerialization> PARAMETERS_PARSER = null;
    private static final ParametersSerializer<PrfBasedKeyDerivationParameters, ProtoParametersSerialization> PARAMETERS_SERIALIZER = null;
    private static final String TYPE_URL = "type.googleapis.com/google.crypto.tink.PrfBasedDeriverKey";
    private static final Bytes TYPE_URL_BYTES = null;

    public static /* synthetic */ PrfBasedKeyDerivationKey $r8$lambda$FnDpOecZ8cE_HaBXmhetw9cuf18(ProtoKeySerialization r0, SecretKeyAccess r1) {
        return parseKey(r0, r1);
    }

    public static /* synthetic */ ProtoParametersSerialization $r8$lambda$GY6Vr0a2g79exfJMssYZMDcKgOg(PrfBasedKeyDerivationParameters r0) {
        return serializeParameters(r0);
    }

    public static /* synthetic */ PrfBasedKeyDerivationParameters $r8$lambda$K_mqnY596tTHbkDhFH2BP6y6PfY(ProtoParametersSerialization r0) {
        return parseParameters(r0);
    }

    /* JADX INFO: renamed from: $r8$lambda$oFMOrAAuQPbiVcYzJF-PuO3c8sA, reason: not valid java name */
    public static /* synthetic */ ProtoKeySerialization m940$r8$lambda$oFMOrAAuQPbiVcYzJFPuO3c8sA(PrfBasedKeyDerivationKey r0, SecretKeyAccess r1) {
        return serializeKey(r0, r1);
    }

    static {
        Bytes r0 = Util.toBytesFromPrintableAscii(TYPE_URL);
        TYPE_URL_BYTES = r0;
        PARAMETERS_SERIALIZER = ParametersSerializer.create(new PrfBasedKeyDerivationKeyProtoSerialization$$ExternalSyntheticLambda0(), PrfBasedKeyDerivationParameters.class, ProtoParametersSerialization.class);
        PARAMETERS_PARSER = ParametersParser.create(new PrfBasedKeyDerivationKeyProtoSerialization$$ExternalSyntheticLambda1(), r0, ProtoParametersSerialization.class);
        KEY_SERIALIZER = KeySerializer.create(new PrfBasedKeyDerivationKeyProtoSerialization$$ExternalSyntheticLambda2(), PrfBasedKeyDerivationKey.class, ProtoKeySerialization.class);
        KEY_PARSER = KeyParser.create(new PrfBasedKeyDerivationKeyProtoSerialization$$ExternalSyntheticLambda3(), r0, ProtoKeySerialization.class);
    }

    private static PrfBasedKeyDerivationParameters parseParameters(ProtoParametersSerialization serialization) throws GeneralSecurityException {
        if (serialization.getKeyTemplate().getTypeUrl().equals(TYPE_URL) == false) goto L19;
        PrfBasedDeriverKeyFormat r0 = PrfBasedDeriverKeyFormat.parseFrom(serialization.getKeyTemplate().getValue(), ExtensionRegistryLite.getEmptyRegistry());     // Catch: InvalidProtocolBufferException -> L15
        Parameters r1 = TinkProtoParametersFormat.parse(r0.getParams().getDerivedKeyTemplate().toByteArray());
        Parameters r2 = TinkProtoParametersFormat.parse(r0.getPrfKeyTemplate().toByteArray());
        if ((r2 instanceof PrfParameters) == false) goto L14;
        if (serialization.getKeyTemplate().getOutputPrefixType() != r0.getParams().getDerivedKeyTemplate().getOutputPrefixType()) goto L12;
        return PrfBasedKeyDerivationParameters.builder().setPrfParameters((PrfParameters) r2).setDerivedKeyParameters(r1).build();
    L12:
        throw new GeneralSecurityException("Output-Prefix mismatch in parameters while parsing " + r0);
    L14:
        throw new GeneralSecurityException("Non-PRF parameters stored in the field prf_key_template");
    L15:
        e = move-exception;
        throw new GeneralSecurityException("Parsing PrfBasedDeriverKeyFormat failed: ", e);
    L19:
        throw new IllegalArgumentException("Wrong type URL in call to PrfBasedKeyDerivationKeyProtoSerialization.parseParameters: " + serialization.getKeyTemplate().getTypeUrl());
    }

    private static ProtoParametersSerialization serializeParameters(PrfBasedKeyDerivationParameters parameters) throws GeneralSecurityException {
        KeyTemplate r0 = KeyTemplate.parseFrom(TinkProtoParametersFormat.serialize(parameters.getPrfParameters()), ExtensionRegistryLite.getEmptyRegistry());     // Catch: InvalidProtocolBufferException -> L4
        KeyTemplate r3 = KeyTemplate.parseFrom(TinkProtoParametersFormat.serialize(parameters.getDerivedKeyParameters()), ExtensionRegistryLite.getEmptyRegistry());     // Catch: InvalidProtocolBufferException -> L4
        PrfBasedDeriverKeyFormat r1 = (PrfBasedDeriverKeyFormat) PrfBasedDeriverKeyFormat.newBuilder().setPrfKeyTemplate(r0).setParams(PrfBasedDeriverParams.newBuilder().setDerivedKeyTemplate(r3)).build();     // Catch: InvalidProtocolBufferException -> L4
        return ProtoParametersSerialization.create((KeyTemplate) KeyTemplate.newBuilder().setTypeUrl(TYPE_URL).setValue(r1.toByteString()).setOutputPrefixType(r3.getOutputPrefixType()).build());
    L4:
        e = move-exception;
        throw new GeneralSecurityException("Serializing PrfBasedKeyDerivationParameters failed: ", e);
    }

    private static ProtoKeySerialization serializeKey(PrfBasedKeyDerivationKey key, @Nullable SecretKeyAccess access) throws GeneralSecurityException {
        ProtoKeySerialization r5 = (ProtoKeySerialization) MutableSerializationRegistry.globalInstance().serializeKey(key.getPrfKey(), ProtoKeySerialization.class, access);
        ProtoParametersSerialization r0 = (ProtoParametersSerialization) MutableSerializationRegistry.globalInstance().serializeParameters(key.getParameters().getDerivedKeyParameters(), ProtoParametersSerialization.class);
        return ProtoKeySerialization.create(TYPE_URL, ((PrfBasedDeriverKey) PrfBasedDeriverKey.newBuilder().setPrfKey(KeyData.newBuilder().setValue(r5.getValue()).setTypeUrl(r5.getTypeUrl()).setKeyMaterialType(r5.getKeyMaterialType())).setParams(PrfBasedDeriverParams.newBuilder().setDerivedKeyTemplate(r0.getKeyTemplate())).build()).toByteString(), KeyData.KeyMaterialType.SYMMETRIC, r0.getKeyTemplate().getOutputPrefixType(), key.getIdRequirementOrNull());
    }

    private static PrfBasedKeyDerivationKey parseKey(ProtoKeySerialization serialization, @Nullable SecretKeyAccess access) throws GeneralSecurityException {
        if (serialization.getTypeUrl().equals(TYPE_URL) == false) goto L17;
        PrfBasedDeriverKey r1 = PrfBasedDeriverKey.parseFrom(serialization.getValue(), ExtensionRegistryLite.getEmptyRegistry());     // Catch: InvalidProtocolBufferException -> L14
        Key r8 = MutableSerializationRegistry.globalInstance().parseKey(ProtoKeySerialization.create(r1.getPrfKey().getTypeUrl(), r1.getPrfKey().getValue(), r1.getPrfKey().getKeyMaterialType(), OutputPrefixType.RAW, null), access);     // Catch: InvalidProtocolBufferException -> L14
        if ((r8 instanceof PrfKey) == false) goto L13;
        PrfKey r9 = (PrfKey) r8;     // Catch: InvalidProtocolBufferException -> L14
        ProtoParametersSerialization r2 = ProtoParametersSerialization.checkedCreate(r1.getParams().getDerivedKeyTemplate());     // Catch: InvalidProtocolBufferException -> L14
        PrfBasedKeyDerivationParameters r3 = PrfBasedKeyDerivationParameters.builder().setDerivedKeyParameters(MutableSerializationRegistry.globalInstance().parseParameters(r2)).setPrfParameters(r9.getParameters()).build();     // Catch: InvalidProtocolBufferException -> L14
        if (serialization.getOutputPrefixType() != r2.getKeyTemplate().getOutputPrefixType()) goto L11;
        return PrfBasedKeyDerivationKey.create(r3, r9, serialization.getIdRequirementOrNull());
    L11:
        throw new GeneralSecurityException("Output-Prefix mismatch in parameters while parsing PrfBasedKeyDerivationKey with parameters " + r3);     // Catch: InvalidProtocolBufferException -> L14
    L13:
        throw new GeneralSecurityException("Non-PRF key stored in the field prf_key");     // Catch: InvalidProtocolBufferException -> L14
    L15:
        throw new GeneralSecurityException("Parsing HmacKey failed");
    L17:
        throw new IllegalArgumentException("Wrong type URL in call to PrfBasedKeyDerivationKey.parseKey");
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

    private PrfBasedKeyDerivationKeyProtoSerialization() {
    }
}
