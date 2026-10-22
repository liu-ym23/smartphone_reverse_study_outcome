package com.google.crypto.tink.aead.internal;

import com.google.crypto.tink.SecretKeyAccess;
import com.google.crypto.tink.aead.XChaCha20Poly1305Key;
import com.google.crypto.tink.aead.XChaCha20Poly1305Parameters;
import com.google.crypto.tink.internal.KeyParser;
import com.google.crypto.tink.internal.KeySerializer;
import com.google.crypto.tink.internal.MutableSerializationRegistry;
import com.google.crypto.tink.internal.ParametersParser;
import com.google.crypto.tink.internal.ParametersSerializer;
import com.google.crypto.tink.internal.ProtoKeySerialization;
import com.google.crypto.tink.internal.ProtoParametersSerialization;
import com.google.crypto.tink.internal.SerializationRegistry;
import com.google.crypto.tink.internal.Util;
import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.proto.KeyTemplate;
import com.google.crypto.tink.proto.OutputPrefixType;
import com.google.crypto.tink.proto.XChaCha20Poly1305KeyFormat;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.util.Bytes;
import com.google.crypto.tink.util.SecretBytes;
import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class XChaCha20Poly1305ProtoSerialization {
    private static final KeyParser<ProtoKeySerialization> KEY_PARSER = null;
    private static final KeySerializer<XChaCha20Poly1305Key, ProtoKeySerialization> KEY_SERIALIZER = null;
    private static final ParametersParser<ProtoParametersSerialization> PARAMETERS_PARSER = null;
    private static final ParametersSerializer<XChaCha20Poly1305Parameters, ProtoParametersSerialization> PARAMETERS_SERIALIZER = null;
    private static final String TYPE_URL = "type.googleapis.com/google.crypto.tink.XChaCha20Poly1305Key";
    private static final Bytes TYPE_URL_BYTES = null;

    /* JADX INFO: renamed from: com.google.crypto.tink.aead.internal.XChaCha20Poly1305ProtoSerialization$1, reason: invalid class name */
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

    /* JADX INFO: renamed from: $r8$lambda$Y-WC6Onmd9D9SvzwYQ4QUA_bF4c, reason: not valid java name */
    public static /* synthetic */ ProtoParametersSerialization m924$r8$lambda$YWC6Onmd9D9SvzwYQ4QUA_bF4c(XChaCha20Poly1305Parameters r0) {
        return serializeParameters(r0);
    }

    /* JADX INFO: renamed from: $r8$lambda$bFlaM4uA4SKXUynQ20dxs1-pCAs, reason: not valid java name */
    public static /* synthetic */ ProtoKeySerialization m925$r8$lambda$bFlaM4uA4SKXUynQ20dxs1pCAs(XChaCha20Poly1305Key r0, SecretKeyAccess r1) {
        return serializeKey(r0, r1);
    }

    public static /* synthetic */ XChaCha20Poly1305Parameters $r8$lambda$czA1J91AFSU7YUTa6DlzF8uRlU8(ProtoParametersSerialization r0) {
        return parseParameters(r0);
    }

    public static /* synthetic */ XChaCha20Poly1305Key $r8$lambda$oaINi89hx54mdeMxFWilMED00C0(ProtoKeySerialization r0, SecretKeyAccess r1) {
        return parseKey(r0, r1);
    }

    static {
        Bytes r0 = Util.toBytesFromPrintableAscii(TYPE_URL);
        TYPE_URL_BYTES = r0;
        PARAMETERS_SERIALIZER = ParametersSerializer.create(new XChaCha20Poly1305ProtoSerialization$$ExternalSyntheticLambda0(), XChaCha20Poly1305Parameters.class, ProtoParametersSerialization.class);
        PARAMETERS_PARSER = ParametersParser.create(new XChaCha20Poly1305ProtoSerialization$$ExternalSyntheticLambda1(), r0, ProtoParametersSerialization.class);
        KEY_SERIALIZER = KeySerializer.create(new XChaCha20Poly1305ProtoSerialization$$ExternalSyntheticLambda2(), XChaCha20Poly1305Key.class, ProtoKeySerialization.class);
        KEY_PARSER = KeyParser.create(new XChaCha20Poly1305ProtoSerialization$$ExternalSyntheticLambda3(), r0, ProtoKeySerialization.class);
    }

    private static OutputPrefixType toProtoOutputPrefixType(XChaCha20Poly1305Parameters.Variant variant) throws GeneralSecurityException {
        if (XChaCha20Poly1305Parameters.Variant.TINK.equals(variant) == false) goto L7;
        return OutputPrefixType.TINK;
    L7:
        if (XChaCha20Poly1305Parameters.Variant.CRUNCHY.equals(variant) == false) goto L11;
        return OutputPrefixType.CRUNCHY;
    L11:
        if (XChaCha20Poly1305Parameters.Variant.NO_PREFIX.equals(variant) == false) goto L15;
        return OutputPrefixType.RAW;
    L15:
        throw new GeneralSecurityException("Unable to serialize variant: " + variant);
    }

    private static XChaCha20Poly1305Parameters.Variant toVariant(OutputPrefixType outputPrefixType) throws GeneralSecurityException {
        int r0 = AnonymousClass1.$SwitchMap$com$google$crypto$tink$proto$OutputPrefixType[outputPrefixType.ordinal()];
        if (r0 == 1) goto L17;
        if (r0 == 2) goto L15;
        if (r0 == 3) goto L15;
        if (r0 != 4) goto L13;
        return XChaCha20Poly1305Parameters.Variant.NO_PREFIX;
    L13:
        throw new GeneralSecurityException("Unable to parse OutputPrefixType: " + outputPrefixType.getNumber());
    L15:
        return XChaCha20Poly1305Parameters.Variant.CRUNCHY;
    L17:
        return XChaCha20Poly1305Parameters.Variant.TINK;
    }

    private static ProtoParametersSerialization serializeParameters(XChaCha20Poly1305Parameters parameters) throws GeneralSecurityException {
        return ProtoParametersSerialization.create((KeyTemplate) KeyTemplate.newBuilder().setTypeUrl(TYPE_URL).setValue(XChaCha20Poly1305KeyFormat.getDefaultInstance().toByteString()).setOutputPrefixType(toProtoOutputPrefixType(parameters.getVariant())).build());
    }

    private static ProtoKeySerialization serializeKey(XChaCha20Poly1305Key key, @Nullable SecretKeyAccess access) throws GeneralSecurityException {
        return ProtoKeySerialization.create(TYPE_URL, ((com.google.crypto.tink.proto.XChaCha20Poly1305Key) com.google.crypto.tink.proto.XChaCha20Poly1305Key.newBuilder().setKeyValue(ByteString.copyFrom(key.getKeyBytes().toByteArray(SecretKeyAccess.requireAccess(access)))).build()).toByteString(), KeyData.KeyMaterialType.SYMMETRIC, toProtoOutputPrefixType(key.getParameters().getVariant()), key.getIdRequirementOrNull());
    }

    private static XChaCha20Poly1305Parameters parseParameters(ProtoParametersSerialization serialization) throws GeneralSecurityException {
        if (serialization.getKeyTemplate().getTypeUrl().equals(TYPE_URL) == false) goto L15;
        if (XChaCha20Poly1305KeyFormat.parseFrom(serialization.getKeyTemplate().getValue(), ExtensionRegistryLite.getEmptyRegistry()).getVersion() != 0) goto L10;
        return XChaCha20Poly1305Parameters.create(toVariant(serialization.getKeyTemplate().getOutputPrefixType()));
    L10:
        throw new GeneralSecurityException("Only version 0 parameters are accepted");
    L11:
        e = move-exception;
        throw new GeneralSecurityException("Parsing XChaCha20Poly1305Parameters failed: ", e);
    L15:
        throw new IllegalArgumentException("Wrong type URL in call to XChaCha20Poly1305ProtoSerialization.parseParameters: " + serialization.getKeyTemplate().getTypeUrl());
    }

    private static XChaCha20Poly1305Key parseKey(ProtoKeySerialization serialization, @Nullable SecretKeyAccess access) throws GeneralSecurityException {
        if (serialization.getTypeUrl().equals(TYPE_URL) == false) goto L13;
        com.google.crypto.tink.proto.XChaCha20Poly1305Key r0 = com.google.crypto.tink.proto.XChaCha20Poly1305Key.parseFrom(serialization.getValue(), ExtensionRegistryLite.getEmptyRegistry());     // Catch: InvalidProtocolBufferException -> L10
        if (r0.getVersion() != 0) goto L9;
        return XChaCha20Poly1305Key.create(toVariant(serialization.getOutputPrefixType()), SecretBytes.copyFrom(r0.getKeyValue().toByteArray(), SecretKeyAccess.requireAccess(access)), serialization.getIdRequirementOrNull());
    L9:
        throw new GeneralSecurityException("Only version 0 keys are accepted");     // Catch: InvalidProtocolBufferException -> L10
    L11:
        throw new GeneralSecurityException("Parsing XChaCha20Poly1305Key failed");
    L13:
        throw new IllegalArgumentException("Wrong type URL in call to XChaCha20Poly1305ProtoSerialization.parseKey");
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

    public static void register(SerializationRegistry.Builder registryBuilder) throws GeneralSecurityException {
        registryBuilder.registerParametersSerializer(PARAMETERS_SERIALIZER);
        registryBuilder.registerParametersParser(PARAMETERS_PARSER);
        registryBuilder.registerKeySerializer(KEY_SERIALIZER);
        registryBuilder.registerKeyParser(KEY_PARSER);
    }

    private XChaCha20Poly1305ProtoSerialization() {
    }
}
