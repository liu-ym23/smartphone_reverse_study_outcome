package com.google.crypto.tink.jwt;

import com.google.crypto.tink.InsecureSecretKeyAccess;
import com.google.crypto.tink.KeyManager;
import com.google.crypto.tink.Parameters;
import com.google.crypto.tink.PrivateKeyManager;
import com.google.crypto.tink.PublicKeySign;
import com.google.crypto.tink.config.internal.TinkFipsUtil;
import com.google.crypto.tink.internal.KeyManagerRegistry;
import com.google.crypto.tink.internal.LegacyKeyManagerImpl;
import com.google.crypto.tink.internal.MutableKeyCreationRegistry;
import com.google.crypto.tink.internal.MutableParametersRegistry;
import com.google.crypto.tink.internal.MutablePrimitiveRegistry;
import com.google.crypto.tink.internal.PrimitiveConstructor;
import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.signature.RsaSsaPssPrivateKey;
import com.google.crypto.tink.subtle.EngineFactory;
import com.google.crypto.tink.subtle.RsaSsaPssSignJce;
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
public final class JwtRsaSsaPssSignKeyManager {
    private static final MutableKeyCreationRegistry.KeyCreator<JwtRsaSsaPssParameters> KEY_CREATOR = null;
    private static final PrimitiveConstructor<JwtRsaSsaPssPrivateKey, JwtPublicKeySign> PRIMITIVE_CONSTRUCTOR = null;
    private static final PrivateKeyManager<Void> legacyPrivateKeyManager = null;
    private static final KeyManager<Void> legacyPublicKeyManager = null;

    public static /* synthetic */ JwtRsaSsaPssPrivateKey $r8$lambda$FJwuJPvDv3FGD39gcVyKEqLyhKs(JwtRsaSsaPssParameters r0, Integer r1) {
        return createKey(r0, r1);
    }

    static String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.JwtRsaSsaPssPrivateKey";
    }

    static {
        legacyPrivateKeyManager = LegacyKeyManagerImpl.createPrivateKeyManager(getKeyType(), Void.class, com.google.crypto.tink.proto.JwtRsaSsaPssPrivateKey.parser());
        legacyPublicKeyManager = LegacyKeyManagerImpl.create(JwtRsaSsaPssVerifyKeyManager.getKeyType(), Void.class, KeyData.KeyMaterialType.ASYMMETRIC_PUBLIC, com.google.crypto.tink.proto.JwtRsaSsaPssPublicKey.parser());
        KEY_CREATOR = new JwtRsaSsaPssSignKeyManager$$ExternalSyntheticLambda0();
        PRIMITIVE_CONSTRUCTOR = PrimitiveConstructor.create(new JwtRsaSsaPssSignKeyManager$$ExternalSyntheticLambda1(), JwtRsaSsaPssPrivateKey.class, JwtPublicKeySign.class);
    }

    private static JwtRsaSsaPssPrivateKey createKey(JwtRsaSsaPssParameters parameters, @Nullable Integer idRequirement) throws GeneralSecurityException {
        KeyPairGenerator r0 = EngineFactory.KEY_PAIR_GENERATOR.getInstance("RSA");
        r0.initialize(new RSAKeyGenParameterSpec(parameters.getModulusSizeBits(), new BigInteger(1, parameters.getPublicExponent().toByteArray())));
        KeyPair r1 = r0.generateKeyPair();
        RSAPublicKey r2 = (RSAPublicKey) r1.getPublic();
        RSAPrivateCrtKey r3 = (RSAPrivateCrtKey) r1.getPrivate();
        JwtRsaSsaPssPublicKey.Builder r6 = JwtRsaSsaPssPublicKey.builder().setParameters(parameters).setModulus(r2.getModulus());
        if (idRequirement == null) goto L5;
        r6.setIdRequirement(idRequirement);
    L5:
        JwtRsaSsaPssPublicKey r7 = r6.build();
        return JwtRsaSsaPssPrivateKey.builder().setPublicKey(r7).setPrimes(SecretBigInteger.fromBigInteger(r3.getPrimeP(), InsecureSecretKeyAccess.get()), SecretBigInteger.fromBigInteger(r3.getPrimeQ(), InsecureSecretKeyAccess.get())).setPrivateExponent(SecretBigInteger.fromBigInteger(r3.getPrivateExponent(), InsecureSecretKeyAccess.get())).setPrimeExponents(SecretBigInteger.fromBigInteger(r3.getPrimeExponentP(), InsecureSecretKeyAccess.get()), SecretBigInteger.fromBigInteger(r3.getPrimeExponentQ(), InsecureSecretKeyAccess.get())).setCrtCoefficient(SecretBigInteger.fromBigInteger(r3.getCrtCoefficient(), InsecureSecretKeyAccess.get())).build();
    }

    private static RsaSsaPssPrivateKey toRsaSsaPssPrivateKey(JwtRsaSsaPssPrivateKey privateKey) throws GeneralSecurityException {
        return RsaSsaPssPrivateKey.builder().setPublicKey(JwtRsaSsaPssVerifyKeyManager.toRsaSsaPssPublicKey(privateKey.getPublicKey())).setPrimes(privateKey.getPrimeP(), privateKey.getPrimeQ()).setPrivateExponent(privateKey.getPrivateExponent()).setPrimeExponents(privateKey.getPrimeExponentP(), privateKey.getPrimeExponentQ()).setCrtCoefficient(privateKey.getCrtCoefficient()).build();
    }

    static JwtPublicKeySign createFullPrimitive(final JwtRsaSsaPssPrivateKey privateKey) throws GeneralSecurityException {
        final PublicKeySign r0 = RsaSsaPssSignJce.create(toRsaSsaPssPrivateKey(privateKey));
        final String r1 = privateKey.getParameters().getAlgorithm().getStandardName();
        return new AnonymousClass1(r1, privateKey, r0);
    }

    private static Map<String, Parameters> namedParameters() throws GeneralSecurityException {
        HashMap r0 = new HashMap();
        r0.put("JWT_PS256_2048_F4_RAW", JwtRsaSsaPssParameters.builder().setModulusSizeBits(2048).setPublicExponent(JwtRsaSsaPssParameters.F4).setAlgorithm(JwtRsaSsaPssParameters.Algorithm.PS256).setKidStrategy(JwtRsaSsaPssParameters.KidStrategy.IGNORED).build());
        r0.put("JWT_PS256_2048_F4", JwtRsaSsaPssParameters.builder().setModulusSizeBits(2048).setPublicExponent(JwtRsaSsaPssParameters.F4).setAlgorithm(JwtRsaSsaPssParameters.Algorithm.PS256).setKidStrategy(JwtRsaSsaPssParameters.KidStrategy.BASE64_ENCODED_KEY_ID).build());
        r0.put("JWT_PS256_3072_F4_RAW", JwtRsaSsaPssParameters.builder().setModulusSizeBits(3072).setPublicExponent(JwtRsaSsaPssParameters.F4).setAlgorithm(JwtRsaSsaPssParameters.Algorithm.PS256).setKidStrategy(JwtRsaSsaPssParameters.KidStrategy.IGNORED).build());
        r0.put("JWT_PS256_3072_F4", JwtRsaSsaPssParameters.builder().setModulusSizeBits(3072).setPublicExponent(JwtRsaSsaPssParameters.F4).setAlgorithm(JwtRsaSsaPssParameters.Algorithm.PS256).setKidStrategy(JwtRsaSsaPssParameters.KidStrategy.BASE64_ENCODED_KEY_ID).build());
        r0.put("JWT_PS384_3072_F4_RAW", JwtRsaSsaPssParameters.builder().setModulusSizeBits(3072).setPublicExponent(JwtRsaSsaPssParameters.F4).setAlgorithm(JwtRsaSsaPssParameters.Algorithm.PS384).setKidStrategy(JwtRsaSsaPssParameters.KidStrategy.IGNORED).build());
        r0.put("JWT_PS384_3072_F4", JwtRsaSsaPssParameters.builder().setModulusSizeBits(3072).setPublicExponent(JwtRsaSsaPssParameters.F4).setAlgorithm(JwtRsaSsaPssParameters.Algorithm.PS384).setKidStrategy(JwtRsaSsaPssParameters.KidStrategy.BASE64_ENCODED_KEY_ID).build());
        r0.put("JWT_PS512_4096_F4_RAW", JwtRsaSsaPssParameters.builder().setModulusSizeBits(4096).setPublicExponent(JwtRsaSsaPssParameters.F4).setAlgorithm(JwtRsaSsaPssParameters.Algorithm.PS512).setKidStrategy(JwtRsaSsaPssParameters.KidStrategy.IGNORED).build());
        r0.put("JWT_PS512_4096_F4", JwtRsaSsaPssParameters.builder().setModulusSizeBits(4096).setPublicExponent(JwtRsaSsaPssParameters.F4).setAlgorithm(JwtRsaSsaPssParameters.Algorithm.PS512).setKidStrategy(JwtRsaSsaPssParameters.KidStrategy.BASE64_ENCODED_KEY_ID).build());
        return Collections.unmodifiableMap(r0);
    }

    public static void registerPair(boolean newKeyAllowed) throws GeneralSecurityException {
        if (TinkFipsUtil.AlgorithmFipsCompatibility.ALGORITHM_NOT_FIPS.isCompatible() == false) goto L7;
        JwtRsaSsaPssProtoSerialization.register();
        MutablePrimitiveRegistry.globalInstance().registerPrimitiveConstructor(JwtRsaSsaPssVerifyKeyManager.PRIMITIVE_CONSTRUCTOR);
        MutablePrimitiveRegistry.globalInstance().registerPrimitiveConstructor(PRIMITIVE_CONSTRUCTOR);
        MutableParametersRegistry.globalInstance().putAll(namedParameters());
        MutableKeyCreationRegistry.globalInstance().add(KEY_CREATOR, JwtRsaSsaPssParameters.class);
        KeyManagerRegistry.globalInstance().registerKeyManager(legacyPrivateKeyManager, newKeyAllowed);
        KeyManagerRegistry.globalInstance().registerKeyManager(legacyPublicKeyManager, false);
        return;
    L7:
        throw new GeneralSecurityException("Registering RSA SSA PSS is not supported in FIPS mode");
    }

    private JwtRsaSsaPssSignKeyManager() {
    }
}
