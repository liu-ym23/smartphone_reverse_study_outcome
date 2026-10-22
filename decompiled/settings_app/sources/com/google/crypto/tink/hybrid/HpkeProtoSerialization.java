package com.google.crypto.tink.hybrid;

import com.google.crypto.tink.SecretKeyAccess;
import com.google.crypto.tink.hybrid.internal.HpkeUtil;
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
import com.google.crypto.tink.proto.HpkeAead;
import com.google.crypto.tink.proto.HpkeKdf;
import com.google.crypto.tink.proto.HpkeKem;
import com.google.crypto.tink.proto.HpkeKeyFormat;
import com.google.crypto.tink.proto.HpkeParams;
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
public final class HpkeProtoSerialization {
    private static final EnumTypeProtoConverter<HpkeAead, HpkeParameters.AeadId> AEAD_TYPE_CONVERTER = null;
    private static final EnumTypeProtoConverter<HpkeKdf, HpkeParameters.KdfId> KDF_TYPE_CONVERTER = null;
    private static final EnumTypeProtoConverter<HpkeKem, HpkeParameters.KemId> KEM_TYPE_CONVERTER = null;
    private static final ParametersParser<ProtoParametersSerialization> PARAMETERS_PARSER = null;
    private static final ParametersSerializer<HpkeParameters, ProtoParametersSerialization> PARAMETERS_SERIALIZER = null;
    private static final KeyParser<ProtoKeySerialization> PRIVATE_KEY_PARSER = null;
    private static final KeySerializer<HpkePrivateKey, ProtoKeySerialization> PRIVATE_KEY_SERIALIZER = null;
    private static final String PRIVATE_TYPE_URL = "type.googleapis.com/google.crypto.tink.HpkePrivateKey";
    private static final Bytes PRIVATE_TYPE_URL_BYTES = null;
    private static final KeyParser<ProtoKeySerialization> PUBLIC_KEY_PARSER = null;
    private static final KeySerializer<HpkePublicKey, ProtoKeySerialization> PUBLIC_KEY_SERIALIZER = null;
    private static final String PUBLIC_TYPE_URL = "type.googleapis.com/google.crypto.tink.HpkePublicKey";
    private static final Bytes PUBLIC_TYPE_URL_BYTES = null;
    private static final EnumTypeProtoConverter<OutputPrefixType, HpkeParameters.Variant> VARIANT_TYPE_CONVERTER = null;
    private static final int VERSION = 0;

    /* JADX INFO: renamed from: $r8$lambda$-vSF1Jf8Afyj8p19DFyYkmuciNE, reason: not valid java name */
    public static /* synthetic */ ProtoKeySerialization m926$r8$lambda$vSF1Jf8Afyj8p19DFyYkmuciNE(HpkePublicKey r0, SecretKeyAccess r1) {
        return serializePublicKey(r0, r1);
    }

    public static /* synthetic */ ProtoParametersSerialization $r8$lambda$4wDgDurFSjPdwbj5FUD9GP7tMP8(HpkeParameters r0) {
        return serializeParameters(r0);
    }

    public static /* synthetic */ HpkeParameters $r8$lambda$DjKf_BM4O8lN0dKU8pyfi8IubRI(ProtoParametersSerialization r0) {
        return parseParameters(r0);
    }

    public static /* synthetic */ HpkePublicKey $r8$lambda$g4yCG4g1n9UZAeI5dqSq5AJeKZ8(ProtoKeySerialization r0, SecretKeyAccess r1) {
        return parsePublicKey(r0, r1);
    }

    public static /* synthetic */ HpkePrivateKey $r8$lambda$soq7qOigiPG_YwpkfyQwpyrdjOY(ProtoKeySerialization r0, SecretKeyAccess r1) {
        return parsePrivateKey(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$ygwJBCG2jnKvCXYA-tLilKxPcAU, reason: not valid java name */
    public static /* synthetic */ ProtoKeySerialization m927$r8$lambda$ygwJBCG2jnKvCXYAtLilKxPcAU(HpkePrivateKey r0, SecretKeyAccess r1) {
        return serializePrivateKey(r0, r1);
    }

    static {
        Bytes r0 = Util.toBytesFromPrintableAscii(PRIVATE_TYPE_URL);
        PRIVATE_TYPE_URL_BYTES = r0;
        Bytes r1 = Util.toBytesFromPrintableAscii(PUBLIC_TYPE_URL);
        PUBLIC_TYPE_URL_BYTES = r1;
        PARAMETERS_SERIALIZER = ParametersSerializer.create(new HpkeProtoSerialization$$ExternalSyntheticLambda0(), HpkeParameters.class, ProtoParametersSerialization.class);
        PARAMETERS_PARSER = ParametersParser.create(new HpkeProtoSerialization$$ExternalSyntheticLambda1(), r0, ProtoParametersSerialization.class);
        PUBLIC_KEY_SERIALIZER = KeySerializer.create(new HpkeProtoSerialization$$ExternalSyntheticLambda2(), HpkePublicKey.class, ProtoKeySerialization.class);
        PUBLIC_KEY_PARSER = KeyParser.create(new HpkeProtoSerialization$$ExternalSyntheticLambda3(), r1, ProtoKeySerialization.class);
        PRIVATE_KEY_SERIALIZER = KeySerializer.create(new HpkeProtoSerialization$$ExternalSyntheticLambda4(), HpkePrivateKey.class, ProtoKeySerialization.class);
        PRIVATE_KEY_PARSER = KeyParser.create(new HpkeProtoSerialization$$ExternalSyntheticLambda5(), r0, ProtoKeySerialization.class);
        VARIANT_TYPE_CONVERTER = EnumTypeProtoConverter.builder().add(OutputPrefixType.RAW, HpkeParameters.Variant.NO_PREFIX).add(OutputPrefixType.TINK, HpkeParameters.Variant.TINK).add(OutputPrefixType.LEGACY, HpkeParameters.Variant.CRUNCHY).add(OutputPrefixType.CRUNCHY, HpkeParameters.Variant.CRUNCHY).build();
        KEM_TYPE_CONVERTER = EnumTypeProtoConverter.builder().add(HpkeKem.DHKEM_P256_HKDF_SHA256, HpkeParameters.KemId.DHKEM_P256_HKDF_SHA256).add(HpkeKem.DHKEM_P384_HKDF_SHA384, HpkeParameters.KemId.DHKEM_P384_HKDF_SHA384).add(HpkeKem.DHKEM_P521_HKDF_SHA512, HpkeParameters.KemId.DHKEM_P521_HKDF_SHA512).add(HpkeKem.DHKEM_X25519_HKDF_SHA256, HpkeParameters.KemId.DHKEM_X25519_HKDF_SHA256).build();
        KDF_TYPE_CONVERTER = EnumTypeProtoConverter.builder().add(HpkeKdf.HKDF_SHA256, HpkeParameters.KdfId.HKDF_SHA256).add(HpkeKdf.HKDF_SHA384, HpkeParameters.KdfId.HKDF_SHA384).add(HpkeKdf.HKDF_SHA512, HpkeParameters.KdfId.HKDF_SHA512).build();
        AEAD_TYPE_CONVERTER = EnumTypeProtoConverter.builder().add(HpkeAead.AES_128_GCM, HpkeParameters.AeadId.AES_128_GCM).add(HpkeAead.AES_256_GCM, HpkeParameters.AeadId.AES_256_GCM).add(HpkeAead.CHACHA20_POLY1305, HpkeParameters.AeadId.CHACHA20_POLY1305).build();
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

    private static HpkeParams toProtoParameters(HpkeParameters params) throws GeneralSecurityException {
        return (HpkeParams) HpkeParams.newBuilder().setKem((HpkeKem) KEM_TYPE_CONVERTER.toProtoEnum(params.getKemId())).setKdf((HpkeKdf) KDF_TYPE_CONVERTER.toProtoEnum(params.getKdfId())).setAead((HpkeAead) AEAD_TYPE_CONVERTER.toProtoEnum(params.getAeadId())).build();
    }

    private static com.google.crypto.tink.proto.HpkePublicKey toProtoPublicKey(HpkePublicKey key) throws GeneralSecurityException {
        return (com.google.crypto.tink.proto.HpkePublicKey) com.google.crypto.tink.proto.HpkePublicKey.newBuilder().setVersion(0).setParams(toProtoParameters(key.getParameters())).setPublicKey(ByteString.copyFrom(key.getPublicKeyBytes().toByteArray())).build();
    }

    private static com.google.crypto.tink.proto.HpkePrivateKey toProtoPrivateKey(HpkePrivateKey key, @Nullable SecretKeyAccess access) throws GeneralSecurityException {
        return (com.google.crypto.tink.proto.HpkePrivateKey) com.google.crypto.tink.proto.HpkePrivateKey.newBuilder().setVersion(0).setPublicKey(toProtoPublicKey(key.getPublicKey())).setPrivateKey(ByteString.copyFrom(key.getPrivateKeyBytes().toByteArray(SecretKeyAccess.requireAccess(access)))).build();
    }

    private static HpkeParameters fromProtoParameters(OutputPrefixType outputPrefixType, HpkeParams protoParams) throws GeneralSecurityException {
        return HpkeParameters.builder().setVariant(VARIANT_TYPE_CONVERTER.fromProtoEnum(outputPrefixType)).setKemId(KEM_TYPE_CONVERTER.fromProtoEnum(protoParams.getKem())).setKdfId(KDF_TYPE_CONVERTER.fromProtoEnum(protoParams.getKdf())).setAeadId(AEAD_TYPE_CONVERTER.fromProtoEnum(protoParams.getAead())).build();
    }

    private static ProtoParametersSerialization serializeParameters(HpkeParameters parameters) throws GeneralSecurityException {
        return ProtoParametersSerialization.create((KeyTemplate) KeyTemplate.newBuilder().setTypeUrl(PRIVATE_TYPE_URL).setValue(((HpkeKeyFormat) HpkeKeyFormat.newBuilder().setParams(toProtoParameters(parameters)).build()).toByteString()).setOutputPrefixType((OutputPrefixType) VARIANT_TYPE_CONVERTER.toProtoEnum(parameters.getVariant())).build());
    }

    private static ProtoKeySerialization serializePublicKey(HpkePublicKey key, @Nullable SecretKeyAccess access) throws GeneralSecurityException {
        return ProtoKeySerialization.create(PUBLIC_TYPE_URL, toProtoPublicKey(key).toByteString(), KeyData.KeyMaterialType.ASYMMETRIC_PUBLIC, (OutputPrefixType) VARIANT_TYPE_CONVERTER.toProtoEnum(key.getParameters().getVariant()), key.getIdRequirementOrNull());
    }

    private static ProtoKeySerialization serializePrivateKey(HpkePrivateKey key, @Nullable SecretKeyAccess access) throws GeneralSecurityException {
        return ProtoKeySerialization.create(PRIVATE_TYPE_URL, toProtoPrivateKey(key, access).toByteString(), KeyData.KeyMaterialType.ASYMMETRIC_PRIVATE, (OutputPrefixType) VARIANT_TYPE_CONVERTER.toProtoEnum(key.getParameters().getVariant()), key.getIdRequirementOrNull());
    }

    private static HpkeParameters parseParameters(ProtoParametersSerialization serialization) throws GeneralSecurityException {
        if (serialization.getKeyTemplate().getTypeUrl().equals(PRIVATE_TYPE_URL) == false) goto L11;
        return fromProtoParameters(serialization.getKeyTemplate().getOutputPrefixType(), HpkeKeyFormat.parseFrom(serialization.getKeyTemplate().getValue(), ExtensionRegistryLite.getEmptyRegistry()).getParams());
    L7:
        e = move-exception;
        throw new GeneralSecurityException("Parsing HpkeParameters failed: ", e);
    L11:
        throw new IllegalArgumentException("Wrong type URL in call to HpkeProtoSerialization.parseParameters: " + serialization.getKeyTemplate().getTypeUrl());
    }

    private static Bytes encodePublicKeyBytes(HpkeParameters.KemId kemId, byte[] publicKeyBytes) throws GeneralSecurityException {
        return Bytes.copyFrom(BigIntegerEncoding.toBigEndianBytesOfFixedLength(BigIntegerEncoding.fromUnsignedBigEndianBytes(publicKeyBytes), HpkeUtil.getEncodedPublicKeyLength(kemId)));
    }

    private static HpkePublicKey parsePublicKey(ProtoKeySerialization serialization, @Nullable SecretKeyAccess access) throws GeneralSecurityException {
        if (serialization.getTypeUrl().equals(PUBLIC_TYPE_URL) == false) goto L13;
        com.google.crypto.tink.proto.HpkePublicKey r3 = com.google.crypto.tink.proto.HpkePublicKey.parseFrom(serialization.getValue(), ExtensionRegistryLite.getEmptyRegistry());     // Catch: InvalidProtocolBufferException -> L10
        if (r3.getVersion() != 0) goto L9;
        HpkeParameters r0 = fromProtoParameters(serialization.getOutputPrefixType(), r3.getParams());     // Catch: InvalidProtocolBufferException -> L10
        return HpkePublicKey.create(r0, encodePublicKeyBytes(r0.getKemId(), r3.getPublicKey().toByteArray()), serialization.getIdRequirementOrNull());
    L9:
        throw new GeneralSecurityException("Only version 0 keys are accepted");     // Catch: InvalidProtocolBufferException -> L10
    L11:
        throw new GeneralSecurityException("Parsing HpkePublicKey failed");
    L13:
        throw new IllegalArgumentException("Wrong type URL in call to HpkeProtoSerialization.parsePublicKey: " + serialization.getTypeUrl());
    }

    private static SecretBytes encodePrivateKeyBytes(HpkeParameters.KemId kemId, byte[] privateKeyBytes, @Nullable SecretKeyAccess access) throws GeneralSecurityException {
        return SecretBytes.copyFrom(BigIntegerEncoding.toBigEndianBytesOfFixedLength(BigIntegerEncoding.fromUnsignedBigEndianBytes(privateKeyBytes), HpkeUtil.getEncodedPrivateKeyLength(kemId)), SecretKeyAccess.requireAccess(access));
    }

    private static HpkePrivateKey parsePrivateKey(ProtoKeySerialization serialization, @Nullable SecretKeyAccess access) throws GeneralSecurityException {
        if (serialization.getTypeUrl().equals(PRIVATE_TYPE_URL) == false) goto L13;
        com.google.crypto.tink.proto.HpkePrivateKey r0 = com.google.crypto.tink.proto.HpkePrivateKey.parseFrom(serialization.getValue(), ExtensionRegistryLite.getEmptyRegistry());     // Catch: InvalidProtocolBufferException -> L10
        if (r0.getVersion() != 0) goto L9;
        com.google.crypto.tink.proto.HpkePublicKey r1 = r0.getPublicKey();     // Catch: InvalidProtocolBufferException -> L10
        HpkeParameters r2 = fromProtoParameters(serialization.getOutputPrefixType(), r1.getParams());     // Catch: InvalidProtocolBufferException -> L10
        return HpkePrivateKey.create(HpkePublicKey.create(r2, encodePublicKeyBytes(r2.getKemId(), r1.getPublicKey().toByteArray()), serialization.getIdRequirementOrNull()), encodePrivateKeyBytes(r2.getKemId(), r0.getPrivateKey().toByteArray(), access));
    L9:
        throw new GeneralSecurityException("Only version 0 keys are accepted");     // Catch: InvalidProtocolBufferException -> L10
    L11:
        throw new GeneralSecurityException("Parsing HpkePrivateKey failed");
    L13:
        throw new IllegalArgumentException("Wrong type URL in call to HpkeProtoSerialization.parsePrivateKey: " + serialization.getTypeUrl());
    }

    private HpkeProtoSerialization() {
    }
}
