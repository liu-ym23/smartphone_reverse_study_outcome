package com.google.crypto.tink.signature.internal;

import com.google.crypto.tink.SecretKeyAccess;
import com.google.crypto.tink.internal.BigIntegerEncoding;
import com.google.crypto.tink.internal.KeyParser;
import com.google.crypto.tink.internal.KeySerializer;
import com.google.crypto.tink.internal.MutableSerializationRegistry;
import com.google.crypto.tink.internal.ParametersParser;
import com.google.crypto.tink.internal.ParametersSerializer;
import com.google.crypto.tink.internal.ProtoKeySerialization;
import com.google.crypto.tink.internal.ProtoParametersSerialization;
import com.google.crypto.tink.internal.Util;
import com.google.crypto.tink.proto.EcdsaKeyFormat;
import com.google.crypto.tink.proto.EcdsaParams;
import com.google.crypto.tink.proto.EcdsaSignatureEncoding;
import com.google.crypto.tink.proto.EllipticCurveType;
import com.google.crypto.tink.proto.HashType;
import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.proto.KeyTemplate;
import com.google.crypto.tink.proto.OutputPrefixType;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.signature.EcdsaParameters;
import com.google.crypto.tink.signature.EcdsaPrivateKey;
import com.google.crypto.tink.signature.EcdsaPublicKey;
import com.google.crypto.tink.util.Bytes;
import com.google.crypto.tink.util.SecretBigInteger;
import java.security.GeneralSecurityException;
import java.security.spec.ECPoint;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class EcdsaProtoSerialization {
    private static final ParametersParser<ProtoParametersSerialization> PARAMETERS_PARSER = null;
    private static final ParametersSerializer<EcdsaParameters, ProtoParametersSerialization> PARAMETERS_SERIALIZER = null;
    private static final KeyParser<ProtoKeySerialization> PRIVATE_KEY_PARSER = null;
    private static final KeySerializer<EcdsaPrivateKey, ProtoKeySerialization> PRIVATE_KEY_SERIALIZER = null;
    private static final String PRIVATE_TYPE_URL = "type.googleapis.com/google.crypto.tink.EcdsaPrivateKey";
    private static final Bytes PRIVATE_TYPE_URL_BYTES = null;
    private static final KeyParser<ProtoKeySerialization> PUBLIC_KEY_PARSER = null;
    private static final KeySerializer<EcdsaPublicKey, ProtoKeySerialization> PUBLIC_KEY_SERIALIZER = null;
    private static final String PUBLIC_TYPE_URL = "type.googleapis.com/google.crypto.tink.EcdsaPublicKey";
    private static final Bytes PUBLIC_TYPE_URL_BYTES = null;

    /* JADX INFO: renamed from: com.google.crypto.tink.signature.internal.EcdsaProtoSerialization$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$crypto$tink$proto$EcdsaSignatureEncoding = null;
        static final /* synthetic */ int[] $SwitchMap$com$google$crypto$tink$proto$EllipticCurveType = null;
        static final /* synthetic */ int[] $SwitchMap$com$google$crypto$tink$proto$HashType = null;
        static final /* synthetic */ int[] $SwitchMap$com$google$crypto$tink$proto$OutputPrefixType = null;

        static {
            int[] r0 = new int[EcdsaSignatureEncoding.values().length];
            $SwitchMap$com$google$crypto$tink$proto$EcdsaSignatureEncoding = r0;
            r0[EcdsaSignatureEncoding.IEEE_P1363.ordinal()] = 1;     // Catch: NoSuchFieldError -> L21
        L33:
            $SwitchMap$com$google$crypto$tink$proto$EcdsaSignatureEncoding[EcdsaSignatureEncoding.DER.ordinal()] = 2;     // Catch: NoSuchFieldError -> L22
        L6:
            int[] r2 = new int[EllipticCurveType.values().length];
            $SwitchMap$com$google$crypto$tink$proto$EllipticCurveType = r2;
            r2[EllipticCurveType.NIST_P256.ordinal()] = 1;     // Catch: NoSuchFieldError -> L23
        L45:
            $SwitchMap$com$google$crypto$tink$proto$EllipticCurveType[EllipticCurveType.NIST_P384.ordinal()] = 2;     // Catch: NoSuchFieldError -> L24
        L55:
            $SwitchMap$com$google$crypto$tink$proto$EllipticCurveType[EllipticCurveType.NIST_P521.ordinal()] = 3;     // Catch: NoSuchFieldError -> L25
        L11:
            int[] r3 = new int[OutputPrefixType.values().length];
            $SwitchMap$com$google$crypto$tink$proto$OutputPrefixType = r3;
            r3[OutputPrefixType.TINK.ordinal()] = 1;     // Catch: NoSuchFieldError -> L26
        L37:
            $SwitchMap$com$google$crypto$tink$proto$OutputPrefixType[OutputPrefixType.CRUNCHY.ordinal()] = 2;     // Catch: NoSuchFieldError -> L27
        L43:
            $SwitchMap$com$google$crypto$tink$proto$OutputPrefixType[OutputPrefixType.LEGACY.ordinal()] = 3;     // Catch: NoSuchFieldError -> L28
        L53:
            $SwitchMap$com$google$crypto$tink$proto$OutputPrefixType[OutputPrefixType.RAW.ordinal()] = 4;     // Catch: NoSuchFieldError -> L29
        L16:
            int[] r4 = new int[HashType.values().length];
            $SwitchMap$com$google$crypto$tink$proto$HashType = r4;
            r4[HashType.SHA256.ordinal()] = 1;     // Catch: NoSuchFieldError -> L30
        L35:
            $SwitchMap$com$google$crypto$tink$proto$HashType[HashType.SHA384.ordinal()] = 2;     // Catch: NoSuchFieldError -> L31
        L41:
            $SwitchMap$com$google$crypto$tink$proto$HashType[HashType.SHA512.ordinal()] = 3;     // Catch: NoSuchFieldError -> L32
            return;
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$CSmY-MeBrR8d7tny0si46eKGdDw, reason: not valid java name */
    public static /* synthetic */ ProtoKeySerialization m955$r8$lambda$CSmYMeBrR8d7tny0si46eKGdDw(EcdsaPublicKey r0, SecretKeyAccess r1) {
        return serializePublicKey(r0, r1);
    }

    public static /* synthetic */ EcdsaParameters $r8$lambda$GHf0Sjd60kLErJQTQfYd_i6pkww(ProtoParametersSerialization r0) {
        return parseParameters(r0);
    }

    public static /* synthetic */ ProtoParametersSerialization $r8$lambda$WttWPIzjTnFMXiTcxamTefsbDSk(EcdsaParameters r0) {
        return serializeParameters(r0);
    }

    public static /* synthetic */ EcdsaPublicKey $r8$lambda$pCjOABXlwF7qfslGzsil46irI74(ProtoKeySerialization r0, SecretKeyAccess r1) {
        return parsePublicKey(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$ru85RIIlUnIpkTQ_2d_nCoGg-ks, reason: not valid java name */
    public static /* synthetic */ EcdsaPrivateKey m956$r8$lambda$ru85RIIlUnIpkTQ_2d_nCoGgks(ProtoKeySerialization r0, SecretKeyAccess r1) {
        return parsePrivateKey(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$wbezeZKX-Ntj5XRkT6KnfVGG4PY, reason: not valid java name */
    public static /* synthetic */ ProtoKeySerialization m957$r8$lambda$wbezeZKXNtj5XRkT6KnfVGG4PY(EcdsaPrivateKey r0, SecretKeyAccess r1) {
        return serializePrivateKey(r0, r1);
    }

    static {
        Bytes r0 = Util.toBytesFromPrintableAscii(PRIVATE_TYPE_URL);
        PRIVATE_TYPE_URL_BYTES = r0;
        Bytes r1 = Util.toBytesFromPrintableAscii(PUBLIC_TYPE_URL);
        PUBLIC_TYPE_URL_BYTES = r1;
        PARAMETERS_SERIALIZER = ParametersSerializer.create(new EcdsaProtoSerialization$$ExternalSyntheticLambda0(), EcdsaParameters.class, ProtoParametersSerialization.class);
        PARAMETERS_PARSER = ParametersParser.create(new EcdsaProtoSerialization$$ExternalSyntheticLambda1(), r0, ProtoParametersSerialization.class);
        PUBLIC_KEY_SERIALIZER = KeySerializer.create(new EcdsaProtoSerialization$$ExternalSyntheticLambda2(), EcdsaPublicKey.class, ProtoKeySerialization.class);
        PUBLIC_KEY_PARSER = KeyParser.create(new EcdsaProtoSerialization$$ExternalSyntheticLambda3(), r1, ProtoKeySerialization.class);
        PRIVATE_KEY_SERIALIZER = KeySerializer.create(new EcdsaProtoSerialization$$ExternalSyntheticLambda4(), EcdsaPrivateKey.class, ProtoKeySerialization.class);
        PRIVATE_KEY_PARSER = KeyParser.create(new EcdsaProtoSerialization$$ExternalSyntheticLambda5(), r0, ProtoKeySerialization.class);
    }

    private static OutputPrefixType toProtoOutputPrefixType(EcdsaParameters.Variant variant) throws GeneralSecurityException {
        if (EcdsaParameters.Variant.TINK.equals(variant) == false) goto L7;
        return OutputPrefixType.TINK;
    L7:
        if (EcdsaParameters.Variant.CRUNCHY.equals(variant) == false) goto L11;
        return OutputPrefixType.CRUNCHY;
    L11:
        if (EcdsaParameters.Variant.NO_PREFIX.equals(variant) == false) goto L15;
        return OutputPrefixType.RAW;
    L15:
        if (EcdsaParameters.Variant.LEGACY.equals(variant) == false) goto L19;
        return OutputPrefixType.LEGACY;
    L19:
        throw new GeneralSecurityException("Unable to serialize variant: " + variant);
    }

    private static HashType toProtoHashType(EcdsaParameters.HashType hashType) throws GeneralSecurityException {
        if (EcdsaParameters.HashType.SHA256.equals(hashType) == false) goto L7;
        return HashType.SHA256;
    L7:
        if (EcdsaParameters.HashType.SHA384.equals(hashType) == false) goto L11;
        return HashType.SHA384;
    L11:
        if (EcdsaParameters.HashType.SHA512.equals(hashType) == false) goto L15;
        return HashType.SHA512;
    L15:
        throw new GeneralSecurityException("Unable to serialize HashType " + hashType);
    }

    private static EcdsaParameters.HashType toHashType(HashType hashType) throws GeneralSecurityException {
        int r0 = AnonymousClass1.$SwitchMap$com$google$crypto$tink$proto$HashType[hashType.ordinal()];
        if (r0 == 1) goto L15;
        if (r0 == 2) goto L13;
        if (r0 != 3) goto L11;
        return EcdsaParameters.HashType.SHA512;
    L11:
        throw new GeneralSecurityException("Unable to parse HashType: " + hashType.getNumber());
    L13:
        return EcdsaParameters.HashType.SHA384;
    L15:
        return EcdsaParameters.HashType.SHA256;
    }

    private static EcdsaParameters.Variant toVariant(OutputPrefixType outputPrefixType) throws GeneralSecurityException {
        int r0 = AnonymousClass1.$SwitchMap$com$google$crypto$tink$proto$OutputPrefixType[outputPrefixType.ordinal()];
        if (r0 == 1) goto L19;
        if (r0 == 2) goto L17;
        if (r0 == 3) goto L15;
        if (r0 != 4) goto L13;
        return EcdsaParameters.Variant.NO_PREFIX;
    L13:
        throw new GeneralSecurityException("Unable to parse OutputPrefixType: " + outputPrefixType.getNumber());
    L15:
        return EcdsaParameters.Variant.LEGACY;
    L17:
        return EcdsaParameters.Variant.CRUNCHY;
    L19:
        return EcdsaParameters.Variant.TINK;
    }

    private static EllipticCurveType toProtoCurveType(EcdsaParameters.CurveType curveType) throws GeneralSecurityException {
        if (EcdsaParameters.CurveType.NIST_P256.equals(curveType) == false) goto L7;
        return EllipticCurveType.NIST_P256;
    L7:
        if (EcdsaParameters.CurveType.NIST_P384.equals(curveType) == false) goto L11;
        return EllipticCurveType.NIST_P384;
    L11:
        if (EcdsaParameters.CurveType.NIST_P521.equals(curveType) == false) goto L15;
        return EllipticCurveType.NIST_P521;
    L15:
        throw new GeneralSecurityException("Unable to serialize CurveType " + curveType);
    }

    private static int getEncodingLength(EcdsaParameters.CurveType curveType) throws GeneralSecurityException {
        if (EcdsaParameters.CurveType.NIST_P256.equals(curveType) == false) goto L7;
        return 33;
    L7:
        if (EcdsaParameters.CurveType.NIST_P384.equals(curveType) == false) goto L11;
        return 49;
    L11:
        if (EcdsaParameters.CurveType.NIST_P521.equals(curveType) == false) goto L15;
        return 67;
    L15:
        throw new GeneralSecurityException("Unable to serialize CurveType " + curveType);
    }

    private static EcdsaParameters.CurveType toCurveType(EllipticCurveType protoCurveType) throws GeneralSecurityException {
        int r0 = AnonymousClass1.$SwitchMap$com$google$crypto$tink$proto$EllipticCurveType[protoCurveType.ordinal()];
        if (r0 == 1) goto L15;
        if (r0 == 2) goto L13;
        if (r0 != 3) goto L11;
        return EcdsaParameters.CurveType.NIST_P521;
    L11:
        throw new GeneralSecurityException("Unable to parse EllipticCurveType: " + protoCurveType.getNumber());
    L13:
        return EcdsaParameters.CurveType.NIST_P384;
    L15:
        return EcdsaParameters.CurveType.NIST_P256;
    }

    private static EcdsaSignatureEncoding toProtoSignatureEncoding(EcdsaParameters.SignatureEncoding encoding) throws GeneralSecurityException {
        if (EcdsaParameters.SignatureEncoding.IEEE_P1363.equals(encoding) == false) goto L7;
        return EcdsaSignatureEncoding.IEEE_P1363;
    L7:
        if (EcdsaParameters.SignatureEncoding.DER.equals(encoding) == false) goto L11;
        return EcdsaSignatureEncoding.DER;
    L11:
        throw new GeneralSecurityException("Unable to serialize SignatureEncoding " + encoding);
    }

    private static EcdsaParameters.SignatureEncoding toSignatureEncoding(EcdsaSignatureEncoding encoding) throws GeneralSecurityException {
        int r0 = AnonymousClass1.$SwitchMap$com$google$crypto$tink$proto$EcdsaSignatureEncoding[encoding.ordinal()];
        if (r0 == 1) goto L11;
        if (r0 != 2) goto L9;
        return EcdsaParameters.SignatureEncoding.DER;
    L9:
        throw new GeneralSecurityException("Unable to parse EcdsaSignatureEncoding: " + encoding.getNumber());
    L11:
        return EcdsaParameters.SignatureEncoding.IEEE_P1363;
    }

    private static EcdsaParams getProtoParams(EcdsaParameters parameters) throws GeneralSecurityException {
        return (EcdsaParams) EcdsaParams.newBuilder().setHashType(toProtoHashType(parameters.getHashType())).setCurve(toProtoCurveType(parameters.getCurveType())).setEncoding(toProtoSignatureEncoding(parameters.getSignatureEncoding())).build();
    }

    private static com.google.crypto.tink.proto.EcdsaPublicKey getProtoPublicKey(EcdsaPublicKey key) throws GeneralSecurityException {
        int r0 = getEncodingLength(key.getParameters().getCurveType());
        ECPoint r1 = key.getPublicPoint();
        return (com.google.crypto.tink.proto.EcdsaPublicKey) com.google.crypto.tink.proto.EcdsaPublicKey.newBuilder().setParams(getProtoParams(key.getParameters())).setX(ByteString.copyFrom(BigIntegerEncoding.toBigEndianBytesOfFixedLength(r1.getAffineX(), r0))).setY(ByteString.copyFrom(BigIntegerEncoding.toBigEndianBytesOfFixedLength(r1.getAffineY(), r0))).build();
    }

    private static ProtoParametersSerialization serializeParameters(EcdsaParameters parameters) throws GeneralSecurityException {
        return ProtoParametersSerialization.create((KeyTemplate) KeyTemplate.newBuilder().setTypeUrl(PRIVATE_TYPE_URL).setValue(((EcdsaKeyFormat) EcdsaKeyFormat.newBuilder().setParams(getProtoParams(parameters)).build()).toByteString()).setOutputPrefixType(toProtoOutputPrefixType(parameters.getVariant())).build());
    }

    private static ProtoKeySerialization serializePublicKey(EcdsaPublicKey key, @Nullable SecretKeyAccess access) throws GeneralSecurityException {
        return ProtoKeySerialization.create(PUBLIC_TYPE_URL, getProtoPublicKey(key).toByteString(), KeyData.KeyMaterialType.ASYMMETRIC_PUBLIC, toProtoOutputPrefixType(key.getParameters().getVariant()), key.getIdRequirementOrNull());
    }

    private static ProtoKeySerialization serializePrivateKey(EcdsaPrivateKey key, @Nullable SecretKeyAccess access) throws GeneralSecurityException {
        int r0 = getEncodingLength(key.getParameters().getCurveType());
        return ProtoKeySerialization.create(PRIVATE_TYPE_URL, ((com.google.crypto.tink.proto.EcdsaPrivateKey) com.google.crypto.tink.proto.EcdsaPrivateKey.newBuilder().setPublicKey(getProtoPublicKey(key.getPublicKey())).setKeyValue(ByteString.copyFrom(BigIntegerEncoding.toBigEndianBytesOfFixedLength(key.getPrivateValue().getBigInteger(SecretKeyAccess.requireAccess(access)), r0))).build()).toByteString(), KeyData.KeyMaterialType.ASYMMETRIC_PRIVATE, toProtoOutputPrefixType(key.getParameters().getVariant()), key.getIdRequirementOrNull());
    }

    private static EcdsaParameters parseParameters(ProtoParametersSerialization serialization) throws GeneralSecurityException {
        if (serialization.getKeyTemplate().getTypeUrl().equals(PRIVATE_TYPE_URL) == false) goto L11;
        EcdsaKeyFormat r0 = EcdsaKeyFormat.parseFrom(serialization.getKeyTemplate().getValue(), ExtensionRegistryLite.getEmptyRegistry());     // Catch: InvalidProtocolBufferException -> L7
        return EcdsaParameters.builder().setHashType(toHashType(r0.getParams().getHashType())).setSignatureEncoding(toSignatureEncoding(r0.getParams().getEncoding())).setCurveType(toCurveType(r0.getParams().getCurve())).setVariant(toVariant(serialization.getKeyTemplate().getOutputPrefixType())).build();
    L7:
        e = move-exception;
        throw new GeneralSecurityException("Parsing EcdsaParameters failed: ", e);
    L11:
        throw new IllegalArgumentException("Wrong type URL in call to EcdsaProtoSerialization.parseParameters: " + serialization.getKeyTemplate().getTypeUrl());
    }

    private static EcdsaPublicKey parsePublicKey(ProtoKeySerialization serialization, @Nullable SecretKeyAccess access) throws GeneralSecurityException {
        if (serialization.getTypeUrl().equals(PUBLIC_TYPE_URL) == false) goto L13;
        com.google.crypto.tink.proto.EcdsaPublicKey r4 = com.google.crypto.tink.proto.EcdsaPublicKey.parseFrom(serialization.getValue(), ExtensionRegistryLite.getEmptyRegistry());     // Catch: Throwable -> L10
        if (r4.getVersion() != 0) goto L9;
        return EcdsaPublicKey.builder().setParameters(EcdsaParameters.builder().setHashType(toHashType(r4.getParams().getHashType())).setSignatureEncoding(toSignatureEncoding(r4.getParams().getEncoding())).setCurveType(toCurveType(r4.getParams().getCurve())).setVariant(toVariant(serialization.getOutputPrefixType())).build()).setPublicPoint(new ECPoint(BigIntegerEncoding.fromUnsignedBigEndianBytes(r4.getX().toByteArray()), BigIntegerEncoding.fromUnsignedBigEndianBytes(r4.getY().toByteArray()))).setIdRequirement(serialization.getIdRequirementOrNull()).build();
    L9:
        throw new GeneralSecurityException("Only version 0 keys are accepted");     // Catch: Throwable -> L10
    L11:
        throw new GeneralSecurityException("Parsing EcdsaPublicKey failed");
    L13:
        throw new IllegalArgumentException("Wrong type URL in call to EcdsaProtoSerialization.parsePublicKey: " + serialization.getTypeUrl());
    }

    private static EcdsaPrivateKey parsePrivateKey(ProtoKeySerialization serialization, @Nullable SecretKeyAccess access) throws GeneralSecurityException {
        if (serialization.getTypeUrl().equals(PRIVATE_TYPE_URL) == false) goto L13;
        com.google.crypto.tink.proto.EcdsaPrivateKey r0 = com.google.crypto.tink.proto.EcdsaPrivateKey.parseFrom(serialization.getValue(), ExtensionRegistryLite.getEmptyRegistry());     // Catch: Throwable -> L10
        if (r0.getVersion() != 0) goto L9;
        com.google.crypto.tink.proto.EcdsaPublicKey r1 = r0.getPublicKey();     // Catch: Throwable -> L10
        return EcdsaPrivateKey.builder().setPublicKey(EcdsaPublicKey.builder().setParameters(EcdsaParameters.builder().setHashType(toHashType(r1.getParams().getHashType())).setSignatureEncoding(toSignatureEncoding(r1.getParams().getEncoding())).setCurveType(toCurveType(r1.getParams().getCurve())).setVariant(toVariant(serialization.getOutputPrefixType())).build()).setPublicPoint(new ECPoint(BigIntegerEncoding.fromUnsignedBigEndianBytes(r1.getX().toByteArray()), BigIntegerEncoding.fromUnsignedBigEndianBytes(r1.getY().toByteArray()))).setIdRequirement(serialization.getIdRequirementOrNull()).build()).setPrivateValue(SecretBigInteger.fromBigInteger(BigIntegerEncoding.fromUnsignedBigEndianBytes(r0.getKeyValue().toByteArray()), SecretKeyAccess.requireAccess(access))).build();
    L9:
        throw new GeneralSecurityException("Only version 0 keys are accepted");     // Catch: Throwable -> L10
    L11:
        throw new GeneralSecurityException("Parsing EcdsaPrivateKey failed");
    L13:
        throw new IllegalArgumentException("Wrong type URL in call to EcdsaProtoSerialization.parsePrivateKey: " + serialization.getTypeUrl());
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

    private EcdsaProtoSerialization() {
    }
}
