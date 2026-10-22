package com.google.crypto.tink.signature;

import com.google.crypto.tink.ConfigurationFips140v2$$ExternalSyntheticLambda5;
import com.google.crypto.tink.ConfigurationFips140v2$$ExternalSyntheticLambda6;
import com.google.crypto.tink.InsecureSecretKeyAccess;
import com.google.crypto.tink.KeyManager;
import com.google.crypto.tink.KeyTemplate;
import com.google.crypto.tink.Parameters;
import com.google.crypto.tink.PrivateKeyManager;
import com.google.crypto.tink.PublicKeySign;
import com.google.crypto.tink.PublicKeyVerify;
import com.google.crypto.tink.config.internal.TinkFipsUtil;
import com.google.crypto.tink.internal.KeyManagerRegistry;
import com.google.crypto.tink.internal.LegacyKeyManagerImpl;
import com.google.crypto.tink.internal.MutableKeyCreationRegistry;
import com.google.crypto.tink.internal.MutableParametersRegistry;
import com.google.crypto.tink.internal.MutablePrimitiveRegistry;
import com.google.crypto.tink.internal.PrimitiveConstructor;
import com.google.crypto.tink.internal.TinkBugException;
import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.signature.internal.EcdsaProtoSerialization;
import com.google.crypto.tink.subtle.EllipticCurves;
import com.google.crypto.tink.util.SecretBigInteger;
import java.security.GeneralSecurityException;
import java.security.KeyPair;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class EcdsaSignKeyManager {
    private static final TinkFipsUtil.AlgorithmFipsCompatibility FIPS = null;
    private static final MutableKeyCreationRegistry.KeyCreator<EcdsaParameters> KEY_CREATOR = null;
    private static final PrimitiveConstructor<EcdsaPrivateKey, PublicKeySign> PUBLIC_KEY_SIGN_PRIMITIVE_CONSTRUCTOR = null;
    private static final PrimitiveConstructor<EcdsaPublicKey, PublicKeyVerify> PUBLIC_KEY_VERIFY_PRIMITIVE_CONSTRUCTOR = null;
    private static final PrivateKeyManager<PublicKeySign> legacyPrivateKeyManager = null;
    private static final KeyManager<PublicKeyVerify> legacyPublicKeyManager = null;

    public static /* synthetic */ EcdsaPrivateKey $r8$lambda$TpeGTN_kgJ4lFbq8FxEzyLHIcjc(EcdsaParameters r0, Integer r1) {
        return createKey(r0, r1);
    }

    static String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.EcdsaPrivateKey";
    }

    static {
        PUBLIC_KEY_SIGN_PRIMITIVE_CONSTRUCTOR = PrimitiveConstructor.create(new ConfigurationFips140v2$$ExternalSyntheticLambda5(), EcdsaPrivateKey.class, PublicKeySign.class);
        PUBLIC_KEY_VERIFY_PRIMITIVE_CONSTRUCTOR = PrimitiveConstructor.create(new ConfigurationFips140v2$$ExternalSyntheticLambda6(), EcdsaPublicKey.class, PublicKeyVerify.class);
        legacyPrivateKeyManager = LegacyKeyManagerImpl.createPrivateKeyManager(getKeyType(), PublicKeySign.class, com.google.crypto.tink.proto.EcdsaPrivateKey.parser());
        legacyPublicKeyManager = LegacyKeyManagerImpl.create(EcdsaVerifyKeyManager.getKeyType(), PublicKeyVerify.class, KeyData.KeyMaterialType.ASYMMETRIC_PUBLIC, com.google.crypto.tink.proto.EcdsaPublicKey.parser());
        KEY_CREATOR = new EcdsaSignKeyManager$$ExternalSyntheticLambda1();
        FIPS = TinkFipsUtil.AlgorithmFipsCompatibility.ALGORITHM_REQUIRES_BORINGCRYPTO;
    }

    private static EcdsaPrivateKey createKey(EcdsaParameters parameters, @Nullable Integer idRequirement) throws GeneralSecurityException {
        KeyPair r0 = EllipticCurves.generateKeyPair(parameters.getCurveType().toParameterSpec());
        ECPublicKey r1 = (ECPublicKey) r0.getPublic();
        ECPrivateKey r2 = (ECPrivateKey) r0.getPrivate();
        EcdsaPublicKey r3 = EcdsaPublicKey.builder().setParameters(parameters).setIdRequirement(idRequirement).setPublicPoint(r1.getW()).build();
        return EcdsaPrivateKey.builder().setPublicKey(r3).setPrivateValue(SecretBigInteger.fromBigInteger(r2.getS(), InsecureSecretKeyAccess.get())).build();
    }

    private static Map<String, Parameters> namedParameters() throws GeneralSecurityException {
        HashMap r0 = new HashMap();
        r0.put("ECDSA_P256", PredefinedSignatureParameters.ECDSA_P256);
        r0.put("ECDSA_P256_IEEE_P1363", PredefinedSignatureParameters.ECDSA_P256_IEEE_P1363);
        r0.put("ECDSA_P256_RAW", EcdsaParameters.builder().setHashType(EcdsaParameters.HashType.SHA256).setCurveType(EcdsaParameters.CurveType.NIST_P256).setSignatureEncoding(EcdsaParameters.SignatureEncoding.IEEE_P1363).setVariant(EcdsaParameters.Variant.NO_PREFIX).build());
        r0.put("ECDSA_P256_IEEE_P1363_WITHOUT_PREFIX", PredefinedSignatureParameters.ECDSA_P256_IEEE_P1363_WITHOUT_PREFIX);
        r0.put("ECDSA_P384", PredefinedSignatureParameters.ECDSA_P384);
        r0.put("ECDSA_P384_IEEE_P1363", PredefinedSignatureParameters.ECDSA_P384_IEEE_P1363);
        r0.put("ECDSA_P384_SHA512", EcdsaParameters.builder().setHashType(EcdsaParameters.HashType.SHA512).setCurveType(EcdsaParameters.CurveType.NIST_P384).setSignatureEncoding(EcdsaParameters.SignatureEncoding.DER).setVariant(EcdsaParameters.Variant.TINK).build());
        r0.put("ECDSA_P384_SHA384", EcdsaParameters.builder().setHashType(EcdsaParameters.HashType.SHA384).setCurveType(EcdsaParameters.CurveType.NIST_P384).setSignatureEncoding(EcdsaParameters.SignatureEncoding.DER).setVariant(EcdsaParameters.Variant.TINK).build());
        r0.put("ECDSA_P521", PredefinedSignatureParameters.ECDSA_P521);
        r0.put("ECDSA_P521_IEEE_P1363", PredefinedSignatureParameters.ECDSA_P521_IEEE_P1363);
        return Collections.unmodifiableMap(r0);
    }

    public static void registerPair(boolean newKeyAllowed) throws GeneralSecurityException {
        TinkFipsUtil.AlgorithmFipsCompatibility r0 = FIPS;
        if (r0.isCompatible() == false) goto L7;
        EcdsaProtoSerialization.register();
        MutableParametersRegistry.globalInstance().putAll(namedParameters());
        MutablePrimitiveRegistry.globalInstance().registerPrimitiveConstructor(PUBLIC_KEY_SIGN_PRIMITIVE_CONSTRUCTOR);
        MutablePrimitiveRegistry.globalInstance().registerPrimitiveConstructor(PUBLIC_KEY_VERIFY_PRIMITIVE_CONSTRUCTOR);
        MutableKeyCreationRegistry.globalInstance().add(KEY_CREATOR, EcdsaParameters.class);
        KeyManagerRegistry.globalInstance().registerKeyManagerWithFipsCompatibility(legacyPrivateKeyManager, r0, newKeyAllowed);
        KeyManagerRegistry.globalInstance().registerKeyManagerWithFipsCompatibility(legacyPublicKeyManager, r0, false);
        return;
    L7:
        throw new GeneralSecurityException("Can not use ECDSA in FIPS-mode, as BoringCrypto module is not available.");
    }

    public static final KeyTemplate ecdsaP256Template() {
        return (KeyTemplate) TinkBugException.exceptionIsBug(new EcdsaSignKeyManager$$ExternalSyntheticLambda2());
    }

    static /* synthetic */ KeyTemplate lambda$ecdsaP256Template$0() throws Exception {
        return KeyTemplate.createFrom(EcdsaParameters.builder().setSignatureEncoding(EcdsaParameters.SignatureEncoding.DER).setCurveType(EcdsaParameters.CurveType.NIST_P256).setHashType(EcdsaParameters.HashType.SHA256).setVariant(EcdsaParameters.Variant.TINK).build());
    }

    public static final KeyTemplate rawEcdsaP256Template() {
        return (KeyTemplate) TinkBugException.exceptionIsBug(new EcdsaSignKeyManager$$ExternalSyntheticLambda0());
    }

    static /* synthetic */ KeyTemplate lambda$rawEcdsaP256Template$1() throws Exception {
        return KeyTemplate.createFrom(EcdsaParameters.builder().setSignatureEncoding(EcdsaParameters.SignatureEncoding.IEEE_P1363).setCurveType(EcdsaParameters.CurveType.NIST_P256).setHashType(EcdsaParameters.HashType.SHA256).setVariant(EcdsaParameters.Variant.NO_PREFIX).build());
    }

    private EcdsaSignKeyManager() {
    }
}
