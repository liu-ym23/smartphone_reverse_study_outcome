package com.google.crypto.tink.signature.internal;

import com.google.crypto.tink.SecretKeyAccess;
import com.google.crypto.tink.internal.EnumTypeProtoConverter;
import com.google.crypto.tink.internal.KeyParser;
import com.google.crypto.tink.internal.KeySerializer;
import com.google.crypto.tink.internal.MutableSerializationRegistry;
import com.google.crypto.tink.internal.ParametersParser;
import com.google.crypto.tink.internal.ParametersSerializer;
import com.google.crypto.tink.internal.ProtoKeySerialization;
import com.google.crypto.tink.internal.ProtoParametersSerialization;
import com.google.crypto.tink.internal.Util;
import com.google.crypto.tink.proto.Ed25519KeyFormat;
import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.proto.KeyTemplate;
import com.google.crypto.tink.proto.OutputPrefixType;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.signature.Ed25519Parameters;
import com.google.crypto.tink.signature.Ed25519PrivateKey;
import com.google.crypto.tink.signature.Ed25519PublicKey;
import com.google.crypto.tink.util.Bytes;
import com.google.crypto.tink.util.SecretBytes;
import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class Ed25519ProtoSerialization {
    private static final ParametersParser<ProtoParametersSerialization> PARAMETERS_PARSER = null;
    private static final ParametersSerializer<Ed25519Parameters, ProtoParametersSerialization> PARAMETERS_SERIALIZER = null;
    private static final KeyParser<ProtoKeySerialization> PRIVATE_KEY_PARSER = null;
    private static final KeySerializer<Ed25519PrivateKey, ProtoKeySerialization> PRIVATE_KEY_SERIALIZER = null;
    private static final String PRIVATE_TYPE_URL = "type.googleapis.com/google.crypto.tink.Ed25519PrivateKey";
    private static final Bytes PRIVATE_TYPE_URL_BYTES = null;
    private static final KeyParser<ProtoKeySerialization> PUBLIC_KEY_PARSER = null;
    private static final KeySerializer<Ed25519PublicKey, ProtoKeySerialization> PUBLIC_KEY_SERIALIZER = null;
    private static final String PUBLIC_TYPE_URL = "type.googleapis.com/google.crypto.tink.Ed25519PublicKey";
    private static final Bytes PUBLIC_TYPE_URL_BYTES = null;
    private static final EnumTypeProtoConverter<OutputPrefixType, Ed25519Parameters.Variant> VARIANT_CONVERTER = null;

    /* JADX INFO: renamed from: $r8$lambda$0jCry96_x3aygvmND-ud13Gd0GU, reason: not valid java name */
    public static /* synthetic */ ProtoKeySerialization m958$r8$lambda$0jCry96_x3aygvmNDud13Gd0GU(Ed25519PublicKey r0, SecretKeyAccess r1) {
        return serializePublicKey(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$F-TDG7FcG9yhcTmGD6n8jffmBac, reason: not valid java name */
    public static /* synthetic */ Ed25519PublicKey m959$r8$lambda$FTDG7FcG9yhcTmGD6n8jffmBac(ProtoKeySerialization r0, SecretKeyAccess r1) {
        return parsePublicKey(r0, r1);
    }

    public static /* synthetic */ Ed25519Parameters $r8$lambda$H6CpxNxZyQvgO7yoP2IdCQACMUo(ProtoParametersSerialization r0) {
        return parseParameters(r0);
    }

    public static /* synthetic */ Ed25519PrivateKey $r8$lambda$K5SlYgVSV7h2Di3ZMp9Ce_P48DI(ProtoKeySerialization r0, SecretKeyAccess r1) {
        return parsePrivateKey(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$qDi9ycrCC8T-XTRStsTF7MmzuWE, reason: not valid java name */
    public static /* synthetic */ ProtoKeySerialization m960$r8$lambda$qDi9ycrCC8TXTRStsTF7MmzuWE(Ed25519PrivateKey r0, SecretKeyAccess r1) {
        return serializePrivateKey(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$zogOJgFi8-eFYeZL4KUpbGr0_Wk, reason: not valid java name */
    public static /* synthetic */ ProtoParametersSerialization m961$r8$lambda$zogOJgFi8eFYeZL4KUpbGr0_Wk(Ed25519Parameters r0) {
        return serializeParameters(r0);
    }

    static {
        Bytes r0 = Util.toBytesFromPrintableAscii(PRIVATE_TYPE_URL);
        PRIVATE_TYPE_URL_BYTES = r0;
        Bytes r1 = Util.toBytesFromPrintableAscii(PUBLIC_TYPE_URL);
        PUBLIC_TYPE_URL_BYTES = r1;
        PARAMETERS_SERIALIZER = ParametersSerializer.create(new Ed25519ProtoSerialization$$ExternalSyntheticLambda0(), Ed25519Parameters.class, ProtoParametersSerialization.class);
        PARAMETERS_PARSER = ParametersParser.create(new Ed25519ProtoSerialization$$ExternalSyntheticLambda1(), r0, ProtoParametersSerialization.class);
        PUBLIC_KEY_SERIALIZER = KeySerializer.create(new Ed25519ProtoSerialization$$ExternalSyntheticLambda2(), Ed25519PublicKey.class, ProtoKeySerialization.class);
        PUBLIC_KEY_PARSER = KeyParser.create(new Ed25519ProtoSerialization$$ExternalSyntheticLambda3(), r1, ProtoKeySerialization.class);
        PRIVATE_KEY_SERIALIZER = KeySerializer.create(new Ed25519ProtoSerialization$$ExternalSyntheticLambda4(), Ed25519PrivateKey.class, ProtoKeySerialization.class);
        PRIVATE_KEY_PARSER = KeyParser.create(new Ed25519ProtoSerialization$$ExternalSyntheticLambda5(), r0, ProtoKeySerialization.class);
        VARIANT_CONVERTER = EnumTypeProtoConverter.builder().add(OutputPrefixType.RAW, Ed25519Parameters.Variant.NO_PREFIX).add(OutputPrefixType.TINK, Ed25519Parameters.Variant.TINK).add(OutputPrefixType.CRUNCHY, Ed25519Parameters.Variant.CRUNCHY).add(OutputPrefixType.LEGACY, Ed25519Parameters.Variant.LEGACY).build();
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

    private static com.google.crypto.tink.proto.Ed25519PublicKey getProtoPublicKey(Ed25519PublicKey key) {
        return (com.google.crypto.tink.proto.Ed25519PublicKey) com.google.crypto.tink.proto.Ed25519PublicKey.newBuilder().setKeyValue(ByteString.copyFrom(key.getPublicKeyBytes().toByteArray())).build();
    }

    private static ProtoParametersSerialization serializeParameters(Ed25519Parameters parameters) throws GeneralSecurityException {
        return ProtoParametersSerialization.create((KeyTemplate) KeyTemplate.newBuilder().setTypeUrl(PRIVATE_TYPE_URL).setValue(Ed25519KeyFormat.getDefaultInstance().toByteString()).setOutputPrefixType((OutputPrefixType) VARIANT_CONVERTER.toProtoEnum(parameters.getVariant())).build());
    }

    private static ProtoKeySerialization serializePublicKey(Ed25519PublicKey key, @Nullable SecretKeyAccess access) throws GeneralSecurityException {
        return ProtoKeySerialization.create(PUBLIC_TYPE_URL, getProtoPublicKey(key).toByteString(), KeyData.KeyMaterialType.ASYMMETRIC_PUBLIC, (OutputPrefixType) VARIANT_CONVERTER.toProtoEnum(key.getParameters().getVariant()), key.getIdRequirementOrNull());
    }

    private static ProtoKeySerialization serializePrivateKey(Ed25519PrivateKey key, @Nullable SecretKeyAccess access) throws GeneralSecurityException {
        return ProtoKeySerialization.create(PRIVATE_TYPE_URL, ((com.google.crypto.tink.proto.Ed25519PrivateKey) com.google.crypto.tink.proto.Ed25519PrivateKey.newBuilder().setPublicKey(getProtoPublicKey(key.getPublicKey())).setKeyValue(ByteString.copyFrom(key.getPrivateKeyBytes().toByteArray(SecretKeyAccess.requireAccess(access)))).build()).toByteString(), KeyData.KeyMaterialType.ASYMMETRIC_PRIVATE, (OutputPrefixType) VARIANT_CONVERTER.toProtoEnum(key.getParameters().getVariant()), key.getIdRequirementOrNull());
    }

    private static Ed25519Parameters parseParameters(ProtoParametersSerialization serialization) throws GeneralSecurityException {
        if (serialization.getKeyTemplate().getTypeUrl().equals(PRIVATE_TYPE_URL) == false) goto L14;
    L10:
        e = move-exception;
        throw new GeneralSecurityException("Parsing Ed25519Parameters failed: ", e);
    L5:
        if (Ed25519KeyFormat.parseFrom(serialization.getKeyTemplate().getValue(), ExtensionRegistryLite.getEmptyRegistry()).getVersion() != 0) goto L9;
        return Ed25519Parameters.create(VARIANT_CONVERTER.fromProtoEnum(serialization.getKeyTemplate().getOutputPrefixType()));
    L9:
        throw new GeneralSecurityException("Only version 0 keys are accepted");     // Catch: InvalidProtocolBufferException -> L10
    L14:
        throw new IllegalArgumentException("Wrong type URL in call to Ed25519ProtoSerialization.parseParameters: " + serialization.getKeyTemplate().getTypeUrl());
    }

    private static Ed25519PublicKey parsePublicKey(ProtoKeySerialization serialization, @Nullable SecretKeyAccess access) throws GeneralSecurityException {
        if (serialization.getTypeUrl().equals(PUBLIC_TYPE_URL) == false) goto L13;
        com.google.crypto.tink.proto.Ed25519PublicKey r3 = com.google.crypto.tink.proto.Ed25519PublicKey.parseFrom(serialization.getValue(), ExtensionRegistryLite.getEmptyRegistry());     // Catch: InvalidProtocolBufferException -> L10
        if (r3.getVersion() != 0) goto L9;
        return Ed25519PublicKey.create(VARIANT_CONVERTER.fromProtoEnum(serialization.getOutputPrefixType()), Bytes.copyFrom(r3.getKeyValue().toByteArray()), serialization.getIdRequirementOrNull());
    L9:
        throw new GeneralSecurityException("Only version 0 keys are accepted");     // Catch: InvalidProtocolBufferException -> L10
    L11:
        throw new GeneralSecurityException("Parsing Ed25519PublicKey failed");
    L13:
        throw new IllegalArgumentException("Wrong type URL in call to Ed25519ProtoSerialization.parsePublicKey: " + serialization.getTypeUrl());
    }

    private static Ed25519PrivateKey parsePrivateKey(ProtoKeySerialization serialization, @Nullable SecretKeyAccess access) throws GeneralSecurityException {
        if (serialization.getTypeUrl().equals(PRIVATE_TYPE_URL) == false) goto L13;
        com.google.crypto.tink.proto.Ed25519PrivateKey r0 = com.google.crypto.tink.proto.Ed25519PrivateKey.parseFrom(serialization.getValue(), ExtensionRegistryLite.getEmptyRegistry());     // Catch: InvalidProtocolBufferException -> L10
        if (r0.getVersion() != 0) goto L9;
        return Ed25519PrivateKey.create(Ed25519PublicKey.create(VARIANT_CONVERTER.fromProtoEnum(serialization.getOutputPrefixType()), Bytes.copyFrom(r0.getPublicKey().getKeyValue().toByteArray()), serialization.getIdRequirementOrNull()), SecretBytes.copyFrom(r0.getKeyValue().toByteArray(), SecretKeyAccess.requireAccess(access)));
    L9:
        throw new GeneralSecurityException("Only version 0 keys are accepted");     // Catch: InvalidProtocolBufferException -> L10
    L11:
        throw new GeneralSecurityException("Parsing Ed25519PrivateKey failed");
    L13:
        throw new IllegalArgumentException("Wrong type URL in call to Ed25519ProtoSerialization.parsePrivateKey: " + serialization.getTypeUrl());
    }

    private Ed25519ProtoSerialization() {
    }
}
