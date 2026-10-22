package com.google.crypto.tink.aead.internal;

import com.google.crypto.tink.SecretKeyAccess;
import com.google.crypto.tink.aead.AesCtrHmacAeadKey;
import com.google.crypto.tink.aead.AesCtrHmacAeadParameters;
import com.google.crypto.tink.internal.KeyParser;
import com.google.crypto.tink.internal.KeySerializer;
import com.google.crypto.tink.internal.MutableSerializationRegistry;
import com.google.crypto.tink.internal.ParametersParser;
import com.google.crypto.tink.internal.ParametersSerializer;
import com.google.crypto.tink.internal.ProtoKeySerialization;
import com.google.crypto.tink.internal.ProtoParametersSerialization;
import com.google.crypto.tink.internal.Util;
import com.google.crypto.tink.proto.AesCtrHmacAeadKeyFormat;
import com.google.crypto.tink.proto.AesCtrKey;
import com.google.crypto.tink.proto.AesCtrKeyFormat;
import com.google.crypto.tink.proto.AesCtrParams;
import com.google.crypto.tink.proto.HashType;
import com.google.crypto.tink.proto.HmacKey;
import com.google.crypto.tink.proto.HmacKeyFormat;
import com.google.crypto.tink.proto.HmacParams;
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
public final class AesCtrHmacAeadProtoSerialization {
    private static final KeyParser<ProtoKeySerialization> KEY_PARSER = null;
    private static final KeySerializer<AesCtrHmacAeadKey, ProtoKeySerialization> KEY_SERIALIZER = null;
    private static final ParametersParser<ProtoParametersSerialization> PARAMETERS_PARSER = null;
    private static final ParametersSerializer<AesCtrHmacAeadParameters, ProtoParametersSerialization> PARAMETERS_SERIALIZER = null;
    private static final String TYPE_URL = "type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey";
    private static final Bytes TYPE_URL_BYTES = null;

    /* JADX INFO: renamed from: com.google.crypto.tink.aead.internal.AesCtrHmacAeadProtoSerialization$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$crypto$tink$proto$HashType = null;
        static final /* synthetic */ int[] $SwitchMap$com$google$crypto$tink$proto$OutputPrefixType = null;

        static {
            int[] r0 = new int[HashType.values().length];
            $SwitchMap$com$google$crypto$tink$proto$HashType = r0;
            r0[HashType.SHA1.ordinal()] = 1;     // Catch: NoSuchFieldError -> L17
        L28:
            $SwitchMap$com$google$crypto$tink$proto$HashType[HashType.SHA224.ordinal()] = 2;     // Catch: NoSuchFieldError -> L18
        L34:
            $SwitchMap$com$google$crypto$tink$proto$HashType[HashType.SHA256.ordinal()] = 3;     // Catch: NoSuchFieldError -> L19
        L42:
            $SwitchMap$com$google$crypto$tink$proto$HashType[HashType.SHA384.ordinal()] = 4;     // Catch: NoSuchFieldError -> L20
        L30:
            $SwitchMap$com$google$crypto$tink$proto$HashType[HashType.SHA512.ordinal()] = 5;     // Catch: NoSuchFieldError -> L21
        L11:
            int[] r4 = new int[OutputPrefixType.values().length];
            $SwitchMap$com$google$crypto$tink$proto$OutputPrefixType = r4;
            r4[OutputPrefixType.TINK.ordinal()] = 1;     // Catch: NoSuchFieldError -> L22
        L36:
            $SwitchMap$com$google$crypto$tink$proto$OutputPrefixType[OutputPrefixType.CRUNCHY.ordinal()] = 2;     // Catch: NoSuchFieldError -> L23
        L40:
            $SwitchMap$com$google$crypto$tink$proto$OutputPrefixType[OutputPrefixType.LEGACY.ordinal()] = 3;     // Catch: NoSuchFieldError -> L24
        L26:
            $SwitchMap$com$google$crypto$tink$proto$OutputPrefixType[OutputPrefixType.RAW.ordinal()] = 4;     // Catch: NoSuchFieldError -> L25
            return;
        }
    }

    public static /* synthetic */ AesCtrHmacAeadParameters $r8$lambda$6H2HqSWWIKux0joSTMFa0QS0G2s(ProtoParametersSerialization r0) {
        return parseParameters(r0);
    }

    public static /* synthetic */ ProtoParametersSerialization $r8$lambda$bLmQwnJ92pDoEPjR1YTXaAa_ZMI(AesCtrHmacAeadParameters r0) {
        return serializeParameters(r0);
    }

    public static /* synthetic */ AesCtrHmacAeadKey $r8$lambda$hZaVRAruBh1dDEvIZfwj5d20sKw(ProtoKeySerialization r0, SecretKeyAccess r1) {
        return parseKey(r0, r1);
    }

    public static /* synthetic */ ProtoKeySerialization $r8$lambda$pyDPLMHraPL4gF3XrMolpmiCVAw(AesCtrHmacAeadKey r0, SecretKeyAccess r1) {
        return serializeKey(r0, r1);
    }

    static {
        Bytes r0 = Util.toBytesFromPrintableAscii(TYPE_URL);
        TYPE_URL_BYTES = r0;
        PARAMETERS_SERIALIZER = ParametersSerializer.create(new AesCtrHmacAeadProtoSerialization$$ExternalSyntheticLambda0(), AesCtrHmacAeadParameters.class, ProtoParametersSerialization.class);
        PARAMETERS_PARSER = ParametersParser.create(new AesCtrHmacAeadProtoSerialization$$ExternalSyntheticLambda1(), r0, ProtoParametersSerialization.class);
        KEY_SERIALIZER = KeySerializer.create(new AesCtrHmacAeadProtoSerialization$$ExternalSyntheticLambda2(), AesCtrHmacAeadKey.class, ProtoKeySerialization.class);
        KEY_PARSER = KeyParser.create(new AesCtrHmacAeadProtoSerialization$$ExternalSyntheticLambda3(), r0, ProtoKeySerialization.class);
    }

    private static OutputPrefixType toProtoOutputPrefixType(AesCtrHmacAeadParameters.Variant variant) throws GeneralSecurityException {
        if (AesCtrHmacAeadParameters.Variant.TINK.equals(variant) == false) goto L7;
        return OutputPrefixType.TINK;
    L7:
        if (AesCtrHmacAeadParameters.Variant.CRUNCHY.equals(variant) == false) goto L11;
        return OutputPrefixType.CRUNCHY;
    L11:
        if (AesCtrHmacAeadParameters.Variant.NO_PREFIX.equals(variant) == false) goto L15;
        return OutputPrefixType.RAW;
    L15:
        throw new GeneralSecurityException("Unable to serialize variant: " + variant);
    }

    private static AesCtrHmacAeadParameters.Variant toVariant(OutputPrefixType outputPrefixType) throws GeneralSecurityException {
        int r0 = AnonymousClass1.$SwitchMap$com$google$crypto$tink$proto$OutputPrefixType[outputPrefixType.ordinal()];
        if (r0 == 1) goto L17;
        if (r0 == 2) goto L15;
        if (r0 == 3) goto L15;
        if (r0 != 4) goto L13;
        return AesCtrHmacAeadParameters.Variant.NO_PREFIX;
    L13:
        throw new GeneralSecurityException("Unable to parse OutputPrefixType: " + outputPrefixType.getNumber());
    L15:
        return AesCtrHmacAeadParameters.Variant.CRUNCHY;
    L17:
        return AesCtrHmacAeadParameters.Variant.TINK;
    }

    private static HashType toProtoHashType(AesCtrHmacAeadParameters.HashType hashType) throws GeneralSecurityException {
        if (AesCtrHmacAeadParameters.HashType.SHA1.equals(hashType) == false) goto L7;
        return HashType.SHA1;
    L7:
        if (AesCtrHmacAeadParameters.HashType.SHA224.equals(hashType) == false) goto L11;
        return HashType.SHA224;
    L11:
        if (AesCtrHmacAeadParameters.HashType.SHA256.equals(hashType) == false) goto L15;
        return HashType.SHA256;
    L15:
        if (AesCtrHmacAeadParameters.HashType.SHA384.equals(hashType) == false) goto L19;
        return HashType.SHA384;
    L19:
        if (AesCtrHmacAeadParameters.HashType.SHA512.equals(hashType) == false) goto L23;
        return HashType.SHA512;
    L23:
        throw new GeneralSecurityException("Unable to serialize HashType " + hashType);
    }

    private static AesCtrHmacAeadParameters.HashType toHashType(HashType hashType) throws GeneralSecurityException {
        int r0 = AnonymousClass1.$SwitchMap$com$google$crypto$tink$proto$HashType[hashType.ordinal()];
        if (r0 == 1) goto L23;
        if (r0 == 2) goto L21;
        if (r0 == 3) goto L19;
        if (r0 == 4) goto L17;
        if (r0 != 5) goto L15;
        return AesCtrHmacAeadParameters.HashType.SHA512;
    L15:
        throw new GeneralSecurityException("Unable to parse HashType: " + hashType.getNumber());
    L17:
        return AesCtrHmacAeadParameters.HashType.SHA384;
    L19:
        return AesCtrHmacAeadParameters.HashType.SHA256;
    L21:
        return AesCtrHmacAeadParameters.HashType.SHA224;
    L23:
        return AesCtrHmacAeadParameters.HashType.SHA1;
    }

    private static HmacParams getHmacProtoParams(AesCtrHmacAeadParameters parameters) throws GeneralSecurityException {
        return (HmacParams) HmacParams.newBuilder().setTagSize(parameters.getTagSizeBytes()).setHash(toProtoHashType(parameters.getHashType())).build();
    }

    private static ProtoParametersSerialization serializeParameters(AesCtrHmacAeadParameters parameters) throws GeneralSecurityException {
        return ProtoParametersSerialization.create((KeyTemplate) KeyTemplate.newBuilder().setTypeUrl(TYPE_URL).setValue(((AesCtrHmacAeadKeyFormat) AesCtrHmacAeadKeyFormat.newBuilder().setAesCtrKeyFormat((AesCtrKeyFormat) AesCtrKeyFormat.newBuilder().setParams((AesCtrParams) AesCtrParams.newBuilder().setIvSize(parameters.getIvSizeBytes()).build()).setKeySize(parameters.getAesKeySizeBytes()).build()).setHmacKeyFormat((HmacKeyFormat) HmacKeyFormat.newBuilder().setParams(getHmacProtoParams(parameters)).setKeySize(parameters.getHmacKeySizeBytes()).build()).build()).toByteString()).setOutputPrefixType(toProtoOutputPrefixType(parameters.getVariant())).build());
    }

    private static ProtoKeySerialization serializeKey(AesCtrHmacAeadKey key, @Nullable SecretKeyAccess access) throws GeneralSecurityException {
        return ProtoKeySerialization.create(TYPE_URL, ((com.google.crypto.tink.proto.AesCtrHmacAeadKey) com.google.crypto.tink.proto.AesCtrHmacAeadKey.newBuilder().setAesCtrKey((AesCtrKey) AesCtrKey.newBuilder().setParams((AesCtrParams) AesCtrParams.newBuilder().setIvSize(key.getParameters().getIvSizeBytes()).build()).setKeyValue(ByteString.copyFrom(key.getAesKeyBytes().toByteArray(SecretKeyAccess.requireAccess(access)))).build()).setHmacKey((HmacKey) HmacKey.newBuilder().setParams(getHmacProtoParams(key.getParameters())).setKeyValue(ByteString.copyFrom(key.getHmacKeyBytes().toByteArray(SecretKeyAccess.requireAccess(access)))).build()).build()).toByteString(), KeyData.KeyMaterialType.SYMMETRIC, toProtoOutputPrefixType(key.getParameters().getVariant()), key.getIdRequirementOrNull());
    }

    private static AesCtrHmacAeadParameters parseParameters(ProtoParametersSerialization serialization) throws GeneralSecurityException {
        if (serialization.getKeyTemplate().getTypeUrl().equals(TYPE_URL) == false) goto L15;
        AesCtrHmacAeadKeyFormat r0 = AesCtrHmacAeadKeyFormat.parseFrom(serialization.getKeyTemplate().getValue(), ExtensionRegistryLite.getEmptyRegistry());     // Catch: InvalidProtocolBufferException -> L11
        if (r0.getHmacKeyFormat().getVersion() != 0) goto L10;
        return AesCtrHmacAeadParameters.builder().setAesKeySizeBytes(r0.getAesCtrKeyFormat().getKeySize()).setHmacKeySizeBytes(r0.getHmacKeyFormat().getKeySize()).setIvSizeBytes(r0.getAesCtrKeyFormat().getParams().getIvSize()).setTagSizeBytes(r0.getHmacKeyFormat().getParams().getTagSize()).setHashType(toHashType(r0.getHmacKeyFormat().getParams().getHash())).setVariant(toVariant(serialization.getKeyTemplate().getOutputPrefixType())).build();
    L10:
        throw new GeneralSecurityException("Only version 0 keys are accepted");
    L11:
        e = move-exception;
        throw new GeneralSecurityException("Parsing AesCtrHmacAeadParameters failed: ", e);
    L15:
        throw new IllegalArgumentException("Wrong type URL in call to AesCtrHmacAeadProtoSerialization.parseParameters: " + serialization.getKeyTemplate().getTypeUrl());
    }

    private static AesCtrHmacAeadKey parseKey(ProtoKeySerialization serialization, @Nullable SecretKeyAccess access) throws GeneralSecurityException {
        if (serialization.getTypeUrl().equals(TYPE_URL) == false) goto L21;
        com.google.crypto.tink.proto.AesCtrHmacAeadKey r0 = com.google.crypto.tink.proto.AesCtrHmacAeadKey.parseFrom(serialization.getValue(), ExtensionRegistryLite.getEmptyRegistry());     // Catch: InvalidProtocolBufferException -> L18
        if (r0.getVersion() != 0) goto L17;
        if (r0.getAesCtrKey().getVersion() != 0) goto L15;
        if (r0.getHmacKey().getVersion() != 0) goto L13;
        AesCtrHmacAeadParameters r1 = AesCtrHmacAeadParameters.builder().setAesKeySizeBytes(r0.getAesCtrKey().getKeyValue().size()).setHmacKeySizeBytes(r0.getHmacKey().getKeyValue().size()).setIvSizeBytes(r0.getAesCtrKey().getParams().getIvSize()).setTagSizeBytes(r0.getHmacKey().getParams().getTagSize()).setHashType(toHashType(r0.getHmacKey().getParams().getHash())).setVariant(toVariant(serialization.getOutputPrefixType())).build();     // Catch: InvalidProtocolBufferException -> L18
        return AesCtrHmacAeadKey.builder().setParameters(r1).setAesKeyBytes(SecretBytes.copyFrom(r0.getAesCtrKey().getKeyValue().toByteArray(), SecretKeyAccess.requireAccess(access))).setHmacKeyBytes(SecretBytes.copyFrom(r0.getHmacKey().getKeyValue().toByteArray(), SecretKeyAccess.requireAccess(access))).setIdRequirement(serialization.getIdRequirementOrNull()).build();
    L13:
        throw new GeneralSecurityException("Only version 0 keys inner HMAC keys are accepted");     // Catch: InvalidProtocolBufferException -> L18
    L15:
        throw new GeneralSecurityException("Only version 0 keys inner AES CTR keys are accepted");     // Catch: InvalidProtocolBufferException -> L18
    L17:
        throw new GeneralSecurityException("Only version 0 keys are accepted");     // Catch: InvalidProtocolBufferException -> L18
    L19:
        throw new GeneralSecurityException("Parsing AesCtrHmacAeadKey failed");
    L21:
        throw new IllegalArgumentException("Wrong type URL in call to AesCtrHmacAeadProtoSerialization.parseKey");
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

    private AesCtrHmacAeadProtoSerialization() {
    }
}
