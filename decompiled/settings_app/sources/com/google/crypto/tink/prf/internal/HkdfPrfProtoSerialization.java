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
import com.google.crypto.tink.prf.HkdfPrfKey;
import com.google.crypto.tink.prf.HkdfPrfParameters;
import com.google.crypto.tink.proto.HashType;
import com.google.crypto.tink.proto.HkdfPrfKeyFormat;
import com.google.crypto.tink.proto.HkdfPrfParams;
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
public final class HkdfPrfProtoSerialization {
    private static final KeyParser<ProtoKeySerialization> KEY_PARSER = null;
    private static final KeySerializer<HkdfPrfKey, ProtoKeySerialization> KEY_SERIALIZER = null;
    private static final ParametersParser<ProtoParametersSerialization> PARAMETERS_PARSER = null;
    private static final ParametersSerializer<HkdfPrfParameters, ProtoParametersSerialization> PARAMETERS_SERIALIZER = null;
    private static final String TYPE_URL = "type.googleapis.com/google.crypto.tink.HkdfPrfKey";
    private static final Bytes TYPE_URL_BYTES = null;

    /* JADX INFO: renamed from: com.google.crypto.tink.prf.internal.HkdfPrfProtoSerialization$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$crypto$tink$proto$HashType = null;

        static {
            int[] r0 = new int[HashType.values().length];
            $SwitchMap$com$google$crypto$tink$proto$HashType = r0;
            r0[HashType.SHA1.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L14:
            $SwitchMap$com$google$crypto$tink$proto$HashType[HashType.SHA224.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L18:
            $SwitchMap$com$google$crypto$tink$proto$HashType[HashType.SHA256.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L22:
            $SwitchMap$com$google$crypto$tink$proto$HashType[HashType.SHA384.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L16:
            $SwitchMap$com$google$crypto$tink$proto$HashType[HashType.SHA512.ordinal()] = 5;     // Catch: NoSuchFieldError -> L13
            return;
        }
    }

    public static /* synthetic */ ProtoParametersSerialization $r8$lambda$6yTkh_M1Ji6Hq79lMUauMzcbzAk(HkdfPrfParameters r0) {
        return serializeParameters(r0);
    }

    public static /* synthetic */ HkdfPrfParameters $r8$lambda$Dn6iJSzgXFxej1rNXH3McsnGRxI(ProtoParametersSerialization r0) {
        return parseParameters(r0);
    }

    public static /* synthetic */ ProtoKeySerialization $r8$lambda$Kokan0IQWEWGwqYNH1LnDVClNg4(HkdfPrfKey r0, SecretKeyAccess r1) {
        return serializeKey(r0, r1);
    }

    public static /* synthetic */ HkdfPrfKey $r8$lambda$n5EsrhI_BdJioLLU8vMpeFhw6UM(ProtoKeySerialization r0, SecretKeyAccess r1) {
        return parseKey(r0, r1);
    }

    static {
        Bytes r0 = Util.toBytesFromPrintableAscii(TYPE_URL);
        TYPE_URL_BYTES = r0;
        PARAMETERS_SERIALIZER = ParametersSerializer.create(new HkdfPrfProtoSerialization$$ExternalSyntheticLambda0(), HkdfPrfParameters.class, ProtoParametersSerialization.class);
        PARAMETERS_PARSER = ParametersParser.create(new HkdfPrfProtoSerialization$$ExternalSyntheticLambda1(), r0, ProtoParametersSerialization.class);
        KEY_SERIALIZER = KeySerializer.create(new HkdfPrfProtoSerialization$$ExternalSyntheticLambda2(), HkdfPrfKey.class, ProtoKeySerialization.class);
        KEY_PARSER = KeyParser.create(new HkdfPrfProtoSerialization$$ExternalSyntheticLambda3(), r0, ProtoKeySerialization.class);
    }

    private static HashType toProtoHashType(HkdfPrfParameters.HashType hashType) throws GeneralSecurityException {
        if (HkdfPrfParameters.HashType.SHA1.equals(hashType) == false) goto L7;
        return HashType.SHA1;
    L7:
        if (HkdfPrfParameters.HashType.SHA224.equals(hashType) == false) goto L11;
        return HashType.SHA224;
    L11:
        if (HkdfPrfParameters.HashType.SHA256.equals(hashType) == false) goto L15;
        return HashType.SHA256;
    L15:
        if (HkdfPrfParameters.HashType.SHA384.equals(hashType) == false) goto L19;
        return HashType.SHA384;
    L19:
        if (HkdfPrfParameters.HashType.SHA512.equals(hashType) == false) goto L23;
        return HashType.SHA512;
    L23:
        throw new GeneralSecurityException("Unable to serialize HashType " + hashType);
    }

    private static HkdfPrfParameters.HashType toHashType(HashType hashType) throws GeneralSecurityException {
        int r0 = AnonymousClass1.$SwitchMap$com$google$crypto$tink$proto$HashType[hashType.ordinal()];
        if (r0 == 1) goto L23;
        if (r0 == 2) goto L21;
        if (r0 == 3) goto L19;
        if (r0 == 4) goto L17;
        if (r0 != 5) goto L15;
        return HkdfPrfParameters.HashType.SHA512;
    L15:
        throw new GeneralSecurityException("Unable to parse HashType: " + hashType.getNumber());
    L17:
        return HkdfPrfParameters.HashType.SHA384;
    L19:
        return HkdfPrfParameters.HashType.SHA256;
    L21:
        return HkdfPrfParameters.HashType.SHA224;
    L23:
        return HkdfPrfParameters.HashType.SHA1;
    }

    private static HkdfPrfParams getProtoParams(HkdfPrfParameters parameters) throws GeneralSecurityException {
        HkdfPrfParams.Builder r0 = HkdfPrfParams.newBuilder().setHash(toProtoHashType(parameters.getHashType()));
        if (parameters.getSalt() == null) goto L8;
        if (parameters.getSalt().size() <= 0) goto L8;
        r0.setSalt(ByteString.copyFrom(parameters.getSalt().toByteArray()));
    L8:
        return (HkdfPrfParams) r0.build();
    }

    private static ProtoParametersSerialization serializeParameters(HkdfPrfParameters parameters) throws GeneralSecurityException {
        return ProtoParametersSerialization.create((KeyTemplate) KeyTemplate.newBuilder().setTypeUrl(TYPE_URL).setValue(((HkdfPrfKeyFormat) HkdfPrfKeyFormat.newBuilder().setParams(getProtoParams(parameters)).setKeySize(parameters.getKeySizeBytes()).build()).toByteString()).setOutputPrefixType(OutputPrefixType.RAW).build());
    }

    private static ProtoKeySerialization serializeKey(HkdfPrfKey key, @Nullable SecretKeyAccess access) throws GeneralSecurityException {
        return ProtoKeySerialization.create(TYPE_URL, ((com.google.crypto.tink.proto.HkdfPrfKey) com.google.crypto.tink.proto.HkdfPrfKey.newBuilder().setParams(getProtoParams(key.getParameters())).setKeyValue(ByteString.copyFrom(key.getKeyBytes().toByteArray(SecretKeyAccess.requireAccess(access)))).build()).toByteString(), KeyData.KeyMaterialType.SYMMETRIC, OutputPrefixType.RAW, key.getIdRequirementOrNull());
    }

    private static HkdfPrfParameters parseParameters(ProtoParametersSerialization serialization) throws GeneralSecurityException {
        if (serialization.getKeyTemplate().getTypeUrl().equals(TYPE_URL) == false) goto L19;
        HkdfPrfKeyFormat r0 = HkdfPrfKeyFormat.parseFrom(serialization.getKeyTemplate().getValue(), ExtensionRegistryLite.getEmptyRegistry());     // Catch: InvalidProtocolBufferException -> L15
        if (r0.getVersion() != 0) goto L14;
        if (serialization.getKeyTemplate().getOutputPrefixType() != OutputPrefixType.RAW) goto L12;
        return HkdfPrfParameters.builder().setKeySizeBytes(r0.getKeySize()).setHashType(toHashType(r0.getParams().getHash())).setSalt(Bytes.copyFrom(r0.getParams().getSalt().toByteArray())).build();
    L12:
        throw new GeneralSecurityException("Parsing HkdfPrfParameters failed: only RAW output prefix type is accepted");
    L14:
        throw new GeneralSecurityException("Parsing HkdfPrfParameters failed: unknown Version " + r0.getVersion());
    L15:
        e = move-exception;
        throw new GeneralSecurityException("Parsing HkdfPrfParameters failed: ", e);
    L19:
        throw new IllegalArgumentException("Wrong type URL in call to HkdfPrfProtoSerialization.parseParameters: " + serialization.getKeyTemplate().getTypeUrl());
    }

    private static HkdfPrfKey parseKey(ProtoKeySerialization serialization, @Nullable SecretKeyAccess access) throws GeneralSecurityException {
        if (serialization.getTypeUrl().equals(TYPE_URL) == false) goto L17;
        com.google.crypto.tink.proto.HkdfPrfKey r0 = com.google.crypto.tink.proto.HkdfPrfKey.parseFrom(serialization.getValue(), ExtensionRegistryLite.getEmptyRegistry());     // Catch: Throwable -> L14
        if (r0.getVersion() != 0) goto L13;
        if (serialization.getIdRequirementOrNull() != null) goto L11;
        HkdfPrfParameters r2 = HkdfPrfParameters.builder().setKeySizeBytes(r0.getKeyValue().size()).setHashType(toHashType(r0.getParams().getHash())).setSalt(Bytes.copyFrom(r0.getParams().getSalt().toByteArray())).build();     // Catch: Throwable -> L14
        return HkdfPrfKey.builder().setParameters(r2).setKeyBytes(SecretBytes.copyFrom(r0.getKeyValue().toByteArray(), SecretKeyAccess.requireAccess(access))).build();
    L11:
        throw new GeneralSecurityException("ID requirement must be null.");     // Catch: Throwable -> L14
    L13:
        throw new GeneralSecurityException("Only version 0 keys are accepted");     // Catch: Throwable -> L14
    L15:
        throw new GeneralSecurityException("Parsing HkdfPrfKey failed");
    L17:
        throw new IllegalArgumentException("Wrong type URL in call to HkdfPrfProtoSerialization.parseKey");
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

    private HkdfPrfProtoSerialization() {
    }
}
