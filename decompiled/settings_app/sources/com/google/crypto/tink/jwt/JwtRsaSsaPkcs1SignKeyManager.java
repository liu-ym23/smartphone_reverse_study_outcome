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
import com.google.crypto.tink.signature.RsaSsaPkcs1PrivateKey;
import com.google.crypto.tink.signature.RsaSsaPkcs1PublicKey;
import com.google.crypto.tink.subtle.EngineFactory;
import com.google.crypto.tink.subtle.RsaSsaPkcs1SignJce;
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
public final class JwtRsaSsaPkcs1SignKeyManager {
    private static final TinkFipsUtil.AlgorithmFipsCompatibility FIPS = null;
    private static final MutableKeyCreationRegistry.KeyCreator<JwtRsaSsaPkcs1Parameters> KEY_CREATOR = null;
    private static final PrimitiveConstructor<JwtRsaSsaPkcs1PrivateKey, JwtPublicKeySign> PRIMITIVE_CONSTRUCTOR = null;
    private static final PrivateKeyManager<Void> legacyPrivateKeyManager = null;
    private static final KeyManager<Void> legacyPublicKeyManager = null;

    public static /* synthetic */ JwtRsaSsaPkcs1PrivateKey $r8$lambda$jKvL6VpxcnoW62H54lu_cZaX5AE(JwtRsaSsaPkcs1Parameters r0, Integer r1) {
        return createKey(r0, r1);
    }

    static String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.JwtRsaSsaPkcs1PrivateKey";
    }

    static {
        legacyPrivateKeyManager = LegacyKeyManagerImpl.createPrivateKeyManager(getKeyType(), Void.class, com.google.crypto.tink.proto.JwtRsaSsaPkcs1PrivateKey.parser());
        legacyPublicKeyManager = LegacyKeyManagerImpl.create(JwtRsaSsaPkcs1VerifyKeyManager.getKeyType(), Void.class, KeyData.KeyMaterialType.ASYMMETRIC_PUBLIC, com.google.crypto.tink.proto.JwtRsaSsaPkcs1PublicKey.parser());
        PRIMITIVE_CONSTRUCTOR = PrimitiveConstructor.create(new JwtRsaSsaPkcs1SignKeyManager$$ExternalSyntheticLambda0(), JwtRsaSsaPkcs1PrivateKey.class, JwtPublicKeySign.class);
        KEY_CREATOR = new JwtRsaSsaPkcs1SignKeyManager$$ExternalSyntheticLambda1();
        FIPS = TinkFipsUtil.AlgorithmFipsCompatibility.ALGORITHM_REQUIRES_BORINGCRYPTO;
    }

    static RsaSsaPkcs1PrivateKey toRsaSsaPkcs1PrivateKey(JwtRsaSsaPkcs1PrivateKey privateKey) throws GeneralSecurityException {
        RsaSsaPkcs1PublicKey r0 = JwtRsaSsaPkcs1VerifyKeyManager.toRsaSsaPkcs1PublicKey(privateKey.getPublicKey());
        return RsaSsaPkcs1PrivateKey.builder().setPublicKey(r0).setPrimes(privateKey.getPrimeP(), privateKey.getPrimeQ()).setPrivateExponent(privateKey.getPrivateExponent()).setPrimeExponents(privateKey.getPrimeExponentP(), privateKey.getPrimeExponentQ()).setCrtCoefficient(privateKey.getCrtCoefficient()).build();
    }

    static JwtPublicKeySign createFullPrimitive(final JwtRsaSsaPkcs1PrivateKey privateKey) throws GeneralSecurityException {
        final PublicKeySign r0 = RsaSsaPkcs1SignJce.create(toRsaSsaPkcs1PrivateKey(privateKey));
        final String r1 = privateKey.getParameters().getAlgorithm().getStandardName();
        return new AnonymousClass1(r1, privateKey, r0);
    }

    private static JwtRsaSsaPkcs1PrivateKey createKey(JwtRsaSsaPkcs1Parameters parameters, @Nullable Integer idRequirement) throws GeneralSecurityException {
        KeyPairGenerator r0 = EngineFactory.KEY_PAIR_GENERATOR.getInstance("RSA");
        r0.initialize(new RSAKeyGenParameterSpec(parameters.getModulusSizeBits(), new BigInteger(1, parameters.getPublicExponent().toByteArray())));
        KeyPair r1 = r0.generateKeyPair();
        RSAPublicKey r2 = (RSAPublicKey) r1.getPublic();
        RSAPrivateCrtKey r3 = (RSAPrivateCrtKey) r1.getPrivate();
        JwtRsaSsaPkcs1PublicKey.Builder r6 = JwtRsaSsaPkcs1PublicKey.builder().setParameters(parameters).setModulus(r2.getModulus());
        if (idRequirement == null) goto L5;
        r6.setIdRequirement(idRequirement);
    L5:
        JwtRsaSsaPkcs1PublicKey r7 = r6.build();
        return JwtRsaSsaPkcs1PrivateKey.builder().setPublicKey(r7).setPrimes(SecretBigInteger.fromBigInteger(r3.getPrimeP(), InsecureSecretKeyAccess.get()), SecretBigInteger.fromBigInteger(r3.getPrimeQ(), InsecureSecretKeyAccess.get())).setPrivateExponent(SecretBigInteger.fromBigInteger(r3.getPrivateExponent(), InsecureSecretKeyAccess.get())).setPrimeExponents(SecretBigInteger.fromBigInteger(r3.getPrimeExponentP(), InsecureSecretKeyAccess.get()), SecretBigInteger.fromBigInteger(r3.getPrimeExponentQ(), InsecureSecretKeyAccess.get())).setCrtCoefficient(SecretBigInteger.fromBigInteger(r3.getCrtCoefficient(), InsecureSecretKeyAccess.get())).build();
    }

    private static Map<String, Parameters> namedParameters() throws GeneralSecurityException {
        HashMap r0 = new HashMap();
        r0.put("JWT_RS256_2048_F4_RAW", JwtRsaSsaPkcs1Parameters.builder().setModulusSizeBits(2048).setPublicExponent(JwtRsaSsaPkcs1Parameters.F4).setAlgorithm(JwtRsaSsaPkcs1Parameters.Algorithm.RS256).setKidStrategy(JwtRsaSsaPkcs1Parameters.KidStrategy.IGNORED).build());
        r0.put("JWT_RS256_2048_F4", JwtRsaSsaPkcs1Parameters.builder().setModulusSizeBits(2048).setPublicExponent(JwtRsaSsaPkcs1Parameters.F4).setAlgorithm(JwtRsaSsaPkcs1Parameters.Algorithm.RS256).setKidStrategy(JwtRsaSsaPkcs1Parameters.KidStrategy.BASE64_ENCODED_KEY_ID).build());
        r0.put("JWT_RS256_3072_F4_RAW", JwtRsaSsaPkcs1Parameters.builder().setModulusSizeBits(3072).setPublicExponent(JwtRsaSsaPkcs1Parameters.F4).setAlgorithm(JwtRsaSsaPkcs1Parameters.Algorithm.RS256).setKidStrategy(JwtRsaSsaPkcs1Parameters.KidStrategy.IGNORED).build());
        r0.put("JWT_RS256_3072_F4", JwtRsaSsaPkcs1Parameters.builder().setModulusSizeBits(3072).setPublicExponent(JwtRsaSsaPkcs1Parameters.F4).setAlgorithm(JwtRsaSsaPkcs1Parameters.Algorithm.RS256).setKidStrategy(JwtRsaSsaPkcs1Parameters.KidStrategy.BASE64_ENCODED_KEY_ID).build());
        r0.put("JWT_RS384_3072_F4_RAW", JwtRsaSsaPkcs1Parameters.builder().setModulusSizeBits(3072).setPublicExponent(JwtRsaSsaPkcs1Parameters.F4).setAlgorithm(JwtRsaSsaPkcs1Parameters.Algorithm.RS384).setKidStrategy(JwtRsaSsaPkcs1Parameters.KidStrategy.IGNORED).build());
        r0.put("JWT_RS384_3072_F4", JwtRsaSsaPkcs1Parameters.builder().setModulusSizeBits(3072).setPublicExponent(JwtRsaSsaPkcs1Parameters.F4).setAlgorithm(JwtRsaSsaPkcs1Parameters.Algorithm.RS384).setKidStrategy(JwtRsaSsaPkcs1Parameters.KidStrategy.BASE64_ENCODED_KEY_ID).build());
        r0.put("JWT_RS512_4096_F4_RAW", JwtRsaSsaPkcs1Parameters.builder().setModulusSizeBits(4096).setPublicExponent(JwtRsaSsaPkcs1Parameters.F4).setAlgorithm(JwtRsaSsaPkcs1Parameters.Algorithm.RS512).setKidStrategy(JwtRsaSsaPkcs1Parameters.KidStrategy.IGNORED).build());
        r0.put("JWT_RS512_4096_F4", JwtRsaSsaPkcs1Parameters.builder().setModulusSizeBits(4096).setPublicExponent(JwtRsaSsaPkcs1Parameters.F4).setAlgorithm(JwtRsaSsaPkcs1Parameters.Algorithm.RS512).setKidStrategy(JwtRsaSsaPkcs1Parameters.KidStrategy.BASE64_ENCODED_KEY_ID).build());
        return Collections.unmodifiableMap(r0);
    }

    public static void registerPair(boolean newKeyAllowed) throws GeneralSecurityException {
        TinkFipsUtil.AlgorithmFipsCompatibility r0 = FIPS;
        if (r0.isCompatible() == false) goto L7;
        JwtRsaSsaPkcs1ProtoSerialization.register();
        MutablePrimitiveRegistry.globalInstance().registerPrimitiveConstructor(JwtRsaSsaPkcs1VerifyKeyManager.PRIMITIVE_CONSTRUCTOR);
        MutablePrimitiveRegistry.globalInstance().registerPrimitiveConstructor(PRIMITIVE_CONSTRUCTOR);
        MutableParametersRegistry.globalInstance().putAll(namedParameters());
        MutableKeyCreationRegistry.globalInstance().add(KEY_CREATOR, JwtRsaSsaPkcs1Parameters.class);
        KeyManagerRegistry.globalInstance().registerKeyManagerWithFipsCompatibility(legacyPrivateKeyManager, r0, newKeyAllowed);
        KeyManagerRegistry.globalInstance().registerKeyManagerWithFipsCompatibility(legacyPublicKeyManager, r0, false);
        return;
    L7:
        throw new GeneralSecurityException("Can not use RSA SSA PKCS1 in FIPS-mode, as BoringCrypto module is not available.");
    }

    private JwtRsaSsaPkcs1SignKeyManager() {
    }
}
