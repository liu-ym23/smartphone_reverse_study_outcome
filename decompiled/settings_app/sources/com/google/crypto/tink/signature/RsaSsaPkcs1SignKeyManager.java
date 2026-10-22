package com.google.crypto.tink.signature;

import com.google.crypto.tink.ConfigurationV0$$ExternalSyntheticLambda3;
import com.google.crypto.tink.ConfigurationV0$$ExternalSyntheticLambda4;
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
import com.google.crypto.tink.signature.internal.RsaSsaPkcs1ProtoSerialization;
import com.google.crypto.tink.subtle.EngineFactory;
import com.google.crypto.tink.util.SecretBigInteger;
import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.interfaces.RSAPrivateCrtKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.RSAKeyGenParameterSpec;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class RsaSsaPkcs1SignKeyManager {
    private static final TinkFipsUtil.AlgorithmFipsCompatibility FIPS = null;
    private static final MutableKeyCreationRegistry.KeyCreator<RsaSsaPkcs1Parameters> KEY_CREATOR = null;
    private static final PrimitiveConstructor<RsaSsaPkcs1PrivateKey, PublicKeySign> PUBLIC_KEY_SIGN_PRIMITIVE_CONSTRUCTOR = null;
    private static final PrimitiveConstructor<RsaSsaPkcs1PublicKey, PublicKeyVerify> PUBLIC_KEY_VERIFY_PRIMITIVE_CONSTRUCTOR = null;
    private static final PrivateKeyManager<PublicKeySign> legacyPrivateKeyManager = null;
    private static final KeyManager<PublicKeyVerify> legacyPublicKeyManager = null;

    public static /* synthetic */ RsaSsaPkcs1PrivateKey $r8$lambda$bMBM0oUjA9333FQSnFJ5PzFFcMc(RsaSsaPkcs1Parameters r0, Integer r1) {
        return createKey(r0, r1);
    }

    static String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.RsaSsaPkcs1PrivateKey";
    }

    static {
        PUBLIC_KEY_SIGN_PRIMITIVE_CONSTRUCTOR = PrimitiveConstructor.create(new ConfigurationV0$$ExternalSyntheticLambda3(), RsaSsaPkcs1PrivateKey.class, PublicKeySign.class);
        PUBLIC_KEY_VERIFY_PRIMITIVE_CONSTRUCTOR = PrimitiveConstructor.create(new ConfigurationV0$$ExternalSyntheticLambda4(), RsaSsaPkcs1PublicKey.class, PublicKeyVerify.class);
        legacyPrivateKeyManager = LegacyKeyManagerImpl.createPrivateKeyManager(getKeyType(), PublicKeySign.class, com.google.crypto.tink.proto.RsaSsaPkcs1PrivateKey.parser());
        legacyPublicKeyManager = LegacyKeyManagerImpl.create(RsaSsaPkcs1VerifyKeyManager.getKeyType(), PublicKeyVerify.class, KeyData.KeyMaterialType.ASYMMETRIC_PUBLIC, com.google.crypto.tink.proto.RsaSsaPkcs1PublicKey.parser());
        KEY_CREATOR = new RsaSsaPkcs1SignKeyManager$$ExternalSyntheticLambda3();
        FIPS = TinkFipsUtil.AlgorithmFipsCompatibility.ALGORITHM_REQUIRES_BORINGCRYPTO;
    }

    private static RsaSsaPkcs1PrivateKey createKey(RsaSsaPkcs1Parameters parameters, @Nullable Integer idRequirement) throws GeneralSecurityException {
        KeyPairGenerator r0 = EngineFactory.KEY_PAIR_GENERATOR.getInstance("RSA");
        r0.initialize(new RSAKeyGenParameterSpec(parameters.getModulusSizeBits(), new BigInteger(1, parameters.getPublicExponent().toByteArray())));
        KeyPair r1 = r0.generateKeyPair();
        RSAPublicKey r2 = (RSAPublicKey) r1.getPublic();
        RSAPrivateCrtKey r3 = (RSAPrivateCrtKey) r1.getPrivate();
        RsaSsaPkcs1PublicKey r6 = RsaSsaPkcs1PublicKey.builder().setParameters(parameters).setModulus(r2.getModulus()).setIdRequirement(idRequirement).build();
        return RsaSsaPkcs1PrivateKey.builder().setPublicKey(r6).setPrimes(SecretBigInteger.fromBigInteger(r3.getPrimeP(), InsecureSecretKeyAccess.get()), SecretBigInteger.fromBigInteger(r3.getPrimeQ(), InsecureSecretKeyAccess.get())).setPrivateExponent(SecretBigInteger.fromBigInteger(r3.getPrivateExponent(), InsecureSecretKeyAccess.get())).setPrimeExponents(SecretBigInteger.fromBigInteger(r3.getPrimeExponentP(), InsecureSecretKeyAccess.get()), SecretBigInteger.fromBigInteger(r3.getPrimeExponentQ(), InsecureSecretKeyAccess.get())).setCrtCoefficient(SecretBigInteger.fromBigInteger(r3.getCrtCoefficient(), InsecureSecretKeyAccess.get())).build();
    }

    private static Map<String, Parameters> namedParameters() throws GeneralSecurityException {
        HashMap r0 = new HashMap();
        r0.put("RSA_SSA_PKCS1_3072_SHA256_F4", PredefinedSignatureParameters.RSA_SSA_PKCS1_3072_SHA256_F4);
        r0.put("RSA_SSA_PKCS1_3072_SHA256_F4_RAW", RsaSsaPkcs1Parameters.builder().setHashType(RsaSsaPkcs1Parameters.HashType.SHA256).setModulusSizeBits(3072).setPublicExponent(RsaSsaPkcs1Parameters.F4).setVariant(RsaSsaPkcs1Parameters.Variant.NO_PREFIX).build());
        r0.put("RSA_SSA_PKCS1_3072_SHA256_F4_WITHOUT_PREFIX", PredefinedSignatureParameters.RSA_SSA_PKCS1_3072_SHA256_F4_WITHOUT_PREFIX);
        r0.put("RSA_SSA_PKCS1_4096_SHA512_F4", PredefinedSignatureParameters.RSA_SSA_PKCS1_4096_SHA512_F4);
        r0.put("RSA_SSA_PKCS1_4096_SHA512_F4_RAW", RsaSsaPkcs1Parameters.builder().setHashType(RsaSsaPkcs1Parameters.HashType.SHA512).setModulusSizeBits(4096).setPublicExponent(RsaSsaPkcs1Parameters.F4).setVariant(RsaSsaPkcs1Parameters.Variant.NO_PREFIX).build());
        return r0;
    }

    public static void registerPair(boolean newKeyAllowed) throws GeneralSecurityException {
        TinkFipsUtil.AlgorithmFipsCompatibility r0 = FIPS;
        if (r0.isCompatible() == false) goto L7;
        RsaSsaPkcs1ProtoSerialization.register();
        MutableParametersRegistry.globalInstance().putAll(namedParameters());
        MutablePrimitiveRegistry.globalInstance().registerPrimitiveConstructor(PUBLIC_KEY_SIGN_PRIMITIVE_CONSTRUCTOR);
        MutablePrimitiveRegistry.globalInstance().registerPrimitiveConstructor(PUBLIC_KEY_VERIFY_PRIMITIVE_CONSTRUCTOR);
        MutableKeyCreationRegistry.globalInstance().add(KEY_CREATOR, RsaSsaPkcs1Parameters.class);
        KeyManagerRegistry.globalInstance().registerKeyManagerWithFipsCompatibility(legacyPrivateKeyManager, r0, newKeyAllowed);
        KeyManagerRegistry.globalInstance().registerKeyManagerWithFipsCompatibility(legacyPublicKeyManager, r0, false);
        return;
    L7:
        throw new GeneralSecurityException("Can not use RSA SSA PKCS1 in FIPS-mode, as BoringCrypto module is not available.");
    }

    public static final KeyTemplate rsa3072SsaPkcs1Sha256F4Template() {
        return (KeyTemplate) TinkBugException.exceptionIsBug(new RsaSsaPkcs1SignKeyManager$$ExternalSyntheticLambda2());
    }

    static /* synthetic */ KeyTemplate lambda$rsa3072SsaPkcs1Sha256F4Template$0() throws Exception {
        return KeyTemplate.createFrom(RsaSsaPkcs1Parameters.builder().setModulusSizeBits(3072).setPublicExponent(RsaSsaPkcs1Parameters.F4).setHashType(RsaSsaPkcs1Parameters.HashType.SHA256).setVariant(RsaSsaPkcs1Parameters.Variant.TINK).build());
    }

    public static final KeyTemplate rawRsa3072SsaPkcs1Sha256F4Template() {
        return (KeyTemplate) TinkBugException.exceptionIsBug(new RsaSsaPkcs1SignKeyManager$$ExternalSyntheticLambda0());
    }

    static /* synthetic */ KeyTemplate lambda$rawRsa3072SsaPkcs1Sha256F4Template$1() throws Exception {
        return KeyTemplate.createFrom(RsaSsaPkcs1Parameters.builder().setModulusSizeBits(3072).setPublicExponent(RsaSsaPkcs1Parameters.F4).setHashType(RsaSsaPkcs1Parameters.HashType.SHA256).setVariant(RsaSsaPkcs1Parameters.Variant.NO_PREFIX).build());
    }

    public static final KeyTemplate rsa4096SsaPkcs1Sha512F4Template() {
        return (KeyTemplate) TinkBugException.exceptionIsBug(new RsaSsaPkcs1SignKeyManager$$ExternalSyntheticLambda4());
    }

    static /* synthetic */ KeyTemplate lambda$rsa4096SsaPkcs1Sha512F4Template$2() throws Exception {
        return KeyTemplate.createFrom(RsaSsaPkcs1Parameters.builder().setModulusSizeBits(4096).setPublicExponent(RsaSsaPkcs1Parameters.F4).setHashType(RsaSsaPkcs1Parameters.HashType.SHA512).setVariant(RsaSsaPkcs1Parameters.Variant.TINK).build());
    }

    public static final KeyTemplate rawRsa4096SsaPkcs1Sha512F4Template() {
        return (KeyTemplate) TinkBugException.exceptionIsBug(new RsaSsaPkcs1SignKeyManager$$ExternalSyntheticLambda1());
    }

    static /* synthetic */ KeyTemplate lambda$rawRsa4096SsaPkcs1Sha512F4Template$3() throws Exception {
        return KeyTemplate.createFrom(RsaSsaPkcs1Parameters.builder().setModulusSizeBits(4096).setPublicExponent(RsaSsaPkcs1Parameters.F4).setHashType(RsaSsaPkcs1Parameters.HashType.SHA512).setVariant(RsaSsaPkcs1Parameters.Variant.NO_PREFIX).build());
    }

    private RsaSsaPkcs1SignKeyManager() {
    }
}
