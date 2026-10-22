package com.google.crypto.tink.signature;

import com.google.crypto.tink.ConfigurationV0$$ExternalSyntheticLambda5;
import com.google.crypto.tink.ConfigurationV0$$ExternalSyntheticLambda6;
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
import com.google.crypto.tink.signature.internal.RsaSsaPssProtoSerialization;
import com.google.crypto.tink.subtle.EngineFactory;
import com.google.crypto.tink.util.SecretBigInteger;
import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.interfaces.RSAPrivateCrtKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.RSAKeyGenParameterSpec;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class RsaSsaPssSignKeyManager {
    private static final MutableKeyCreationRegistry.KeyCreator<RsaSsaPssParameters> KEY_CREATOR = null;
    private static final PrimitiveConstructor<RsaSsaPssPrivateKey, PublicKeySign> PUBLIC_KEY_SIGN_PRIMITIVE_CONSTRUCTOR = null;
    private static final PrimitiveConstructor<RsaSsaPssPublicKey, PublicKeyVerify> PUBLIC_KEY_VERIFY_PRIMITIVE_CONSTRUCTOR = null;
    private static final PrivateKeyManager<PublicKeySign> legacyPrivateKeyManager = null;
    private static final KeyManager<PublicKeyVerify> legacyPublicKeyManager = null;

    /* JADX INFO: renamed from: $r8$lambda$BN1jMlh5koF_gu-F5OtLmg6fm8s, reason: not valid java name */
    public static /* synthetic */ RsaSsaPssPrivateKey m954$r8$lambda$BN1jMlh5koF_guF5OtLmg6fm8s(RsaSsaPssParameters r0, Integer r1) {
        return createKey(r0, r1);
    }

    static String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.RsaSsaPssPrivateKey";
    }

    static {
        PUBLIC_KEY_SIGN_PRIMITIVE_CONSTRUCTOR = PrimitiveConstructor.create(new ConfigurationV0$$ExternalSyntheticLambda5(), RsaSsaPssPrivateKey.class, PublicKeySign.class);
        PUBLIC_KEY_VERIFY_PRIMITIVE_CONSTRUCTOR = PrimitiveConstructor.create(new ConfigurationV0$$ExternalSyntheticLambda6(), RsaSsaPssPublicKey.class, PublicKeyVerify.class);
        legacyPrivateKeyManager = LegacyKeyManagerImpl.createPrivateKeyManager(getKeyType(), PublicKeySign.class, com.google.crypto.tink.proto.RsaSsaPssPrivateKey.parser());
        legacyPublicKeyManager = LegacyKeyManagerImpl.create(RsaSsaPssVerifyKeyManager.getKeyType(), PublicKeyVerify.class, KeyData.KeyMaterialType.ASYMMETRIC_PUBLIC, com.google.crypto.tink.proto.RsaSsaPssPublicKey.parser());
        KEY_CREATOR = new RsaSsaPssSignKeyManager$$ExternalSyntheticLambda2();
    }

    private static RsaSsaPssPrivateKey createKey(RsaSsaPssParameters parameters, @Nullable Integer idRequirement) throws GeneralSecurityException {
        KeyPairGenerator r0 = EngineFactory.KEY_PAIR_GENERATOR.getInstance("RSA");
        r0.initialize(new RSAKeyGenParameterSpec(parameters.getModulusSizeBits(), new BigInteger(1, parameters.getPublicExponent().toByteArray())));
        KeyPair r1 = r0.generateKeyPair();
        RSAPublicKey r2 = (RSAPublicKey) r1.getPublic();
        RSAPrivateCrtKey r3 = (RSAPrivateCrtKey) r1.getPrivate();
        RsaSsaPssPublicKey r6 = RsaSsaPssPublicKey.builder().setParameters(parameters).setModulus(r2.getModulus()).setIdRequirement(idRequirement).build();
        return RsaSsaPssPrivateKey.builder().setPublicKey(r6).setPrimes(SecretBigInteger.fromBigInteger(r3.getPrimeP(), InsecureSecretKeyAccess.get()), SecretBigInteger.fromBigInteger(r3.getPrimeQ(), InsecureSecretKeyAccess.get())).setPrivateExponent(SecretBigInteger.fromBigInteger(r3.getPrivateExponent(), InsecureSecretKeyAccess.get())).setPrimeExponents(SecretBigInteger.fromBigInteger(r3.getPrimeExponentP(), InsecureSecretKeyAccess.get()), SecretBigInteger.fromBigInteger(r3.getPrimeExponentQ(), InsecureSecretKeyAccess.get())).setCrtCoefficient(SecretBigInteger.fromBigInteger(r3.getCrtCoefficient(), InsecureSecretKeyAccess.get())).build();
    }

    private static Map<String, Parameters> namedParameters() throws GeneralSecurityException {
        HashMap r0 = new HashMap();
        r0.put("RSA_SSA_PSS_3072_SHA256_F4", RsaSsaPssParameters.builder().setSigHashType(RsaSsaPssParameters.HashType.SHA256).setMgf1HashType(RsaSsaPssParameters.HashType.SHA256).setSaltLengthBytes(32).setModulusSizeBits(3072).setPublicExponent(RsaSsaPssParameters.F4).setVariant(RsaSsaPssParameters.Variant.TINK).build());
        r0.put("RSA_SSA_PSS_3072_SHA256_F4_RAW", RsaSsaPssParameters.builder().setSigHashType(RsaSsaPssParameters.HashType.SHA256).setMgf1HashType(RsaSsaPssParameters.HashType.SHA256).setSaltLengthBytes(32).setModulusSizeBits(3072).setPublicExponent(RsaSsaPssParameters.F4).setVariant(RsaSsaPssParameters.Variant.NO_PREFIX).build());
        r0.put("RSA_SSA_PSS_3072_SHA256_SHA256_32_F4", PredefinedSignatureParameters.RSA_SSA_PSS_3072_SHA256_SHA256_32_F4);
        r0.put("RSA_SSA_PSS_4096_SHA512_F4", RsaSsaPssParameters.builder().setSigHashType(RsaSsaPssParameters.HashType.SHA512).setMgf1HashType(RsaSsaPssParameters.HashType.SHA512).setSaltLengthBytes(64).setModulusSizeBits(4096).setPublicExponent(RsaSsaPssParameters.F4).setVariant(RsaSsaPssParameters.Variant.TINK).build());
        r0.put("RSA_SSA_PSS_4096_SHA512_F4_RAW", RsaSsaPssParameters.builder().setSigHashType(RsaSsaPssParameters.HashType.SHA512).setMgf1HashType(RsaSsaPssParameters.HashType.SHA512).setSaltLengthBytes(64).setModulusSizeBits(4096).setPublicExponent(RsaSsaPssParameters.F4).setVariant(RsaSsaPssParameters.Variant.NO_PREFIX).build());
        r0.put("RSA_SSA_PSS_4096_SHA512_SHA512_64_F4", PredefinedSignatureParameters.RSA_SSA_PSS_4096_SHA512_SHA512_64_F4);
        return Collections.unmodifiableMap(r0);
    }

    public static void registerPair(boolean newKeyAllowed) throws GeneralSecurityException {
        if (TinkFipsUtil.AlgorithmFipsCompatibility.ALGORITHM_NOT_FIPS.isCompatible() == false) goto L7;
        RsaSsaPssProtoSerialization.register();
        MutableParametersRegistry.globalInstance().putAll(namedParameters());
        MutablePrimitiveRegistry.globalInstance().registerPrimitiveConstructor(PUBLIC_KEY_SIGN_PRIMITIVE_CONSTRUCTOR);
        MutablePrimitiveRegistry.globalInstance().registerPrimitiveConstructor(PUBLIC_KEY_VERIFY_PRIMITIVE_CONSTRUCTOR);
        MutableKeyCreationRegistry.globalInstance().add(KEY_CREATOR, RsaSsaPssParameters.class);
        KeyManagerRegistry.globalInstance().registerKeyManager(legacyPrivateKeyManager, newKeyAllowed);
        KeyManagerRegistry.globalInstance().registerKeyManager(legacyPublicKeyManager, false);
        return;
    L7:
        throw new GeneralSecurityException("Registering RSA SSA PSS is not supported in FIPS mode");
    }

    public static final KeyTemplate rsa3072PssSha256F4Template() {
        return (KeyTemplate) TinkBugException.exceptionIsBug(new RsaSsaPssSignKeyManager$$ExternalSyntheticLambda1());
    }

    static /* synthetic */ KeyTemplate lambda$rsa3072PssSha256F4Template$0() throws Exception {
        return KeyTemplate.createFrom(RsaSsaPssParameters.builder().setSigHashType(RsaSsaPssParameters.HashType.SHA256).setMgf1HashType(RsaSsaPssParameters.HashType.SHA256).setSaltLengthBytes(32).setModulusSizeBits(3072).setPublicExponent(RsaSsaPssParameters.F4).setVariant(RsaSsaPssParameters.Variant.TINK).build());
    }

    public static final KeyTemplate rawRsa3072PssSha256F4Template() {
        return (KeyTemplate) TinkBugException.exceptionIsBug(new RsaSsaPssSignKeyManager$$ExternalSyntheticLambda4());
    }

    static /* synthetic */ KeyTemplate lambda$rawRsa3072PssSha256F4Template$1() throws Exception {
        return KeyTemplate.createFrom(RsaSsaPssParameters.builder().setSigHashType(RsaSsaPssParameters.HashType.SHA256).setMgf1HashType(RsaSsaPssParameters.HashType.SHA256).setSaltLengthBytes(32).setModulusSizeBits(3072).setPublicExponent(RsaSsaPssParameters.F4).setVariant(RsaSsaPssParameters.Variant.NO_PREFIX).build());
    }

    public static final KeyTemplate rsa4096PssSha512F4Template() {
        return (KeyTemplate) TinkBugException.exceptionIsBug(new RsaSsaPssSignKeyManager$$ExternalSyntheticLambda3());
    }

    static /* synthetic */ KeyTemplate lambda$rsa4096PssSha512F4Template$2() throws Exception {
        return KeyTemplate.createFrom(RsaSsaPssParameters.builder().setSigHashType(RsaSsaPssParameters.HashType.SHA512).setMgf1HashType(RsaSsaPssParameters.HashType.SHA512).setSaltLengthBytes(64).setModulusSizeBits(4096).setPublicExponent(RsaSsaPssParameters.F4).setVariant(RsaSsaPssParameters.Variant.TINK).build());
    }

    public static final KeyTemplate rawRsa4096PssSha512F4Template() {
        return (KeyTemplate) TinkBugException.exceptionIsBug(new RsaSsaPssSignKeyManager$$ExternalSyntheticLambda0());
    }

    static /* synthetic */ KeyTemplate lambda$rawRsa4096PssSha512F4Template$3() throws Exception {
        return KeyTemplate.createFrom(RsaSsaPssParameters.builder().setSigHashType(RsaSsaPssParameters.HashType.SHA512).setMgf1HashType(RsaSsaPssParameters.HashType.SHA512).setSaltLengthBytes(64).setModulusSizeBits(4096).setPublicExponent(RsaSsaPssParameters.F4).setVariant(RsaSsaPssParameters.Variant.NO_PREFIX).build());
    }

    private RsaSsaPssSignKeyManager() {
    }
}
