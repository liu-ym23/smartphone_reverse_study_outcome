package com.google.crypto.tink.jwt;

import com.google.crypto.tink.SecretKeyAccess;
import com.google.crypto.tink.internal.KeyParser;
import com.google.crypto.tink.internal.KeySerializer;
import com.google.crypto.tink.internal.MutableSerializationRegistry;
import com.google.crypto.tink.internal.ParametersParser;
import com.google.crypto.tink.internal.ParametersSerializer;
import com.google.crypto.tink.internal.ProtoKeySerialization;
import com.google.crypto.tink.internal.ProtoParametersSerialization;
import com.google.crypto.tink.internal.Util;
import com.google.crypto.tink.proto.JwtHmacAlgorithm;
import com.google.crypto.tink.proto.JwtHmacKeyFormat;
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
final class JwtHmacProtoSerialization {
    private static final KeyParser<ProtoKeySerialization> KEY_PARSER = null;
    private static final KeySerializer<JwtHmacKey, ProtoKeySerialization> KEY_SERIALIZER = null;
    private static final ParametersParser<ProtoParametersSerialization> PARAMETERS_PARSER = null;
    private static final ParametersSerializer<JwtHmacParameters, ProtoParametersSerialization> PARAMETERS_SERIALIZER = null;
    private static final String TYPE_URL = "type.googleapis.com/google.crypto.tink.JwtHmacKey";
    private static final Bytes TYPE_URL_BYTES = null;

    /* JADX INFO: renamed from: com.google.crypto.tink.jwt.JwtHmacProtoSerialization$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$crypto$tink$proto$JwtHmacAlgorithm = null;

        static {
            int[] r0 = new int[JwtHmacAlgorithm.values().length];
            $SwitchMap$com$google$crypto$tink$proto$JwtHmacAlgorithm = r0;
            r0[JwtHmacAlgorithm.HS256.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            $SwitchMap$com$google$crypto$tink$proto$JwtHmacAlgorithm[JwtHmacAlgorithm.HS384.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            $SwitchMap$com$google$crypto$tink$proto$JwtHmacAlgorithm[JwtHmacAlgorithm.HS512.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    public static /* synthetic */ ProtoKeySerialization $r8$lambda$25fYPlk_aM2pzPE8gmOSxwnSDOM(JwtHmacKey r0, SecretKeyAccess r1) {
        return serializeKey(r0, r1);
    }

    public static /* synthetic */ JwtHmacParameters $r8$lambda$4UqdZ_3mMKucT0qr1WIDYyojpb0(ProtoParametersSerialization r0) {
        return parseParameters(r0);
    }

    public static /* synthetic */ ProtoParametersSerialization $r8$lambda$QEo0NREsRQn97JD34PE061c4A_I(JwtHmacParameters r0) {
        return serializeParameters(r0);
    }

    public static /* synthetic */ JwtHmacKey $r8$lambda$cbPc6BUWCurGfbnqtYd_UXjZOJs(ProtoKeySerialization r0, SecretKeyAccess r1) {
        return parseKey(r0, r1);
    }

    static {
        Bytes r0 = Util.toBytesFromPrintableAscii(TYPE_URL);
        TYPE_URL_BYTES = r0;
        PARAMETERS_SERIALIZER = ParametersSerializer.create(new JwtHmacProtoSerialization$$ExternalSyntheticLambda0(), JwtHmacParameters.class, ProtoParametersSerialization.class);
        PARAMETERS_PARSER = ParametersParser.create(new JwtHmacProtoSerialization$$ExternalSyntheticLambda1(), r0, ProtoParametersSerialization.class);
        KEY_SERIALIZER = KeySerializer.create(new JwtHmacProtoSerialization$$ExternalSyntheticLambda2(), JwtHmacKey.class, ProtoKeySerialization.class);
        KEY_PARSER = KeyParser.create(new JwtHmacProtoSerialization$$ExternalSyntheticLambda3(), r0, ProtoKeySerialization.class);
    }

    private static JwtHmacAlgorithm toProtoAlgorithm(JwtHmacParameters.Algorithm hashType) throws GeneralSecurityException {
        if (JwtHmacParameters.Algorithm.HS256.equals(hashType) == false) goto L7;
        return JwtHmacAlgorithm.HS256;
    L7:
        if (JwtHmacParameters.Algorithm.HS384.equals(hashType) == false) goto L11;
        return JwtHmacAlgorithm.HS384;
    L11:
        if (JwtHmacParameters.Algorithm.HS512.equals(hashType) == false) goto L15;
        return JwtHmacAlgorithm.HS512;
    L15:
        throw new GeneralSecurityException("Unable to serialize HashType " + hashType);
    }

    private static JwtHmacParameters.Algorithm toAlgorithm(JwtHmacAlgorithm hashType) throws GeneralSecurityException {
        int r0 = AnonymousClass1.$SwitchMap$com$google$crypto$tink$proto$JwtHmacAlgorithm[hashType.ordinal()];
        if (r0 == 1) goto L15;
        if (r0 == 2) goto L13;
        if (r0 != 3) goto L11;
        return JwtHmacParameters.Algorithm.HS512;
    L11:
        throw new GeneralSecurityException("Unable to parse HashType: " + hashType.getNumber());
    L13:
        return JwtHmacParameters.Algorithm.HS384;
    L15:
        return JwtHmacParameters.Algorithm.HS256;
    }

    private static JwtHmacKeyFormat serializeToJwtHmacKeyFormat(JwtHmacParameters parameters) throws GeneralSecurityException {
        if (parameters.getKidStrategy().equals(JwtHmacParameters.KidStrategy.CUSTOM) == true) goto L7;
        return (JwtHmacKeyFormat) JwtHmacKeyFormat.newBuilder().setVersion(0).setAlgorithm(toProtoAlgorithm(parameters.getAlgorithm())).setKeySize(parameters.getKeySizeBytes()).build();
    L7:
        throw new GeneralSecurityException("Unable to serialize Parameters object with KidStrategy CUSTOM");
    }

    private static ProtoParametersSerialization serializeParameters(JwtHmacParameters parameters) throws GeneralSecurityException {
        OutputPrefixType r0 = OutputPrefixType.TINK;
        if (parameters.getKidStrategy().equals(JwtHmacParameters.KidStrategy.IGNORED) == false) goto L6;
        r0 = OutputPrefixType.RAW;
    L6:
        return ProtoParametersSerialization.create((KeyTemplate) KeyTemplate.newBuilder().setTypeUrl(TYPE_URL).setValue(serializeToJwtHmacKeyFormat(parameters).toByteString()).setOutputPrefixType(r0).build());
    }

    private static ProtoKeySerialization serializeKey(JwtHmacKey key, @Nullable SecretKeyAccess access) throws GeneralSecurityException {
        com.google.crypto.tink.proto.JwtHmacKey.Builder r0 = com.google.crypto.tink.proto.JwtHmacKey.newBuilder();
        r0.setVersion(0).setAlgorithm(toProtoAlgorithm(key.getParameters().getAlgorithm())).setKeyValue(ByteString.copyFrom(key.getKeyBytes().toByteArray(SecretKeyAccess.requireAccess(access))));
        if (key.getParameters().getKidStrategy().equals(JwtHmacParameters.KidStrategy.CUSTOM) == false) goto L5;
        r0.setCustomKid(com.google.crypto.tink.proto.JwtHmacKey.CustomKid.newBuilder().setValue(key.getKid().get()));
        OutputPrefixType r4 = OutputPrefixType.RAW;
    L7:
        if (key.getParameters().getKidStrategy().equals(JwtHmacParameters.KidStrategy.IGNORED) == false) goto L10;
        r4 = OutputPrefixType.RAW;
    L10:
        if (key.getParameters().getKidStrategy().equals(JwtHmacParameters.KidStrategy.BASE64_ENCODED_KEY_ID) == false) goto L12;
        r4 = OutputPrefixType.TINK;
    L12:
        if (r4 == null) goto L16;
        return ProtoKeySerialization.create(TYPE_URL, ((com.google.crypto.tink.proto.JwtHmacKey) r0.build()).toByteString(), KeyData.KeyMaterialType.SYMMETRIC, r4, key.getIdRequirementOrNull());
    L16:
        throw new GeneralSecurityException("Unknown KID Strategy in " + key.getParameters().getKidStrategy());
    L5:
        r4 = null;
        goto L7
    }

    private static JwtHmacParameters parseParameters(ProtoParametersSerialization serialization) throws GeneralSecurityException {
        if (serialization.getKeyTemplate().getTypeUrl().equals(TYPE_URL) == false) goto L25;
        JwtHmacKeyFormat r0 = JwtHmacKeyFormat.parseFrom(serialization.getKeyTemplate().getValue(), ExtensionRegistryLite.getEmptyRegistry());     // Catch: InvalidProtocolBufferException -> L21
        if (r0.getVersion() != 0) goto L20;
        if (serialization.getKeyTemplate().getOutputPrefixType().equals(OutputPrefixType.TINK) == false) goto L10;
        JwtHmacParameters.KidStrategy r1 = JwtHmacParameters.KidStrategy.BASE64_ENCODED_KEY_ID;
    L12:
        if (serialization.getKeyTemplate().getOutputPrefixType().equals(OutputPrefixType.RAW) == false) goto L14;
        r1 = JwtHmacParameters.KidStrategy.IGNORED;
    L14:
        if (r1 == null) goto L18;
        return JwtHmacParameters.builder().setAlgorithm(toAlgorithm(r0.getAlgorithm())).setKeySizeBytes(r0.getKeySize()).setKidStrategy(r1).build();
    L18:
        throw new GeneralSecurityException("Invalid OutputPrefixType for JwtHmacKeyFormat");
    L10:
        r1 = null;
        goto L12
    L20:
        throw new GeneralSecurityException("Parsing HmacParameters failed: unknown Version " + r0.getVersion());
    L21:
        e = move-exception;
        throw new GeneralSecurityException("Parsing HmacParameters failed: ", e);
    L25:
        throw new IllegalArgumentException("Wrong type URL in call to JwtHmacProtoSerialization.parseParameters: " + serialization.getKeyTemplate().getTypeUrl());
    }

    private static JwtHmacKey parseKey(ProtoKeySerialization serialization, @Nullable SecretKeyAccess access) throws GeneralSecurityException {
        if (serialization.getTypeUrl().equals(TYPE_URL) == false) goto L30;
        com.google.crypto.tink.proto.JwtHmacKey r0 = com.google.crypto.tink.proto.JwtHmacKey.parseFrom(serialization.getValue(), ExtensionRegistryLite.getEmptyRegistry());     // Catch: Throwable -> L27
        if (r0.getVersion() != 0) goto L26;
        JwtHmacParameters.Builder r1 = JwtHmacParameters.builder();     // Catch: Throwable -> L27
        JwtHmacKey.Builder r2 = JwtHmacKey.builder();     // Catch: Throwable -> L27
        if (serialization.getOutputPrefixType().equals(OutputPrefixType.TINK) == false) goto L18;
        if (r0.hasCustomKid() == true) goto L16;
        Integer r5 = serialization.getIdRequirementOrNull();     // Catch: Throwable -> L27
        if (r5 == null) goto L14;
        r1.setKidStrategy(JwtHmacParameters.KidStrategy.BASE64_ENCODED_KEY_ID);     // Catch: Throwable -> L27
        r2.setIdRequirement(r5.intValue());     // Catch: Throwable -> L27
    L23:
        r1.setAlgorithm(toAlgorithm(r0.getAlgorithm()));     // Catch: Throwable -> L27
        r1.setKeySizeBytes(r0.getKeyValue().size());     // Catch: Throwable -> L27
        return r2.setKeyBytes(SecretBytes.copyFrom(r0.getKeyValue().toByteArray(), SecretKeyAccess.requireAccess(access))).setParameters(r1.build()).build();
    L14:
        throw new GeneralSecurityException("Keys serialized with OutputPrefixType TINK need an ID Requirement");     // Catch: Throwable -> L27
    L16:
        throw new GeneralSecurityException("Keys serialized with OutputPrefixType TINK should not have a custom kid");     // Catch: Throwable -> L27
    L18:
        if (serialization.getOutputPrefixType().equals(OutputPrefixType.RAW) == false) goto L23;
        if (r0.hasCustomKid() == false) goto L22;
        r1.setKidStrategy(JwtHmacParameters.KidStrategy.CUSTOM);     // Catch: Throwable -> L27
        r2.setCustomKid(r0.getCustomKid().getValue());     // Catch: Throwable -> L27
        goto L23
    L22:
        r1.setKidStrategy(JwtHmacParameters.KidStrategy.IGNORED);     // Catch: Throwable -> L27
        goto L23
    L26:
        throw new GeneralSecurityException("Only version 0 keys are accepted");     // Catch: Throwable -> L27
    L28:
        throw new GeneralSecurityException("Parsing HmacKey failed");
    L30:
        throw new IllegalArgumentException("Wrong type URL in call to HmacProtoSerialization.parseKey");
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

    private JwtHmacProtoSerialization() {
    }
}
