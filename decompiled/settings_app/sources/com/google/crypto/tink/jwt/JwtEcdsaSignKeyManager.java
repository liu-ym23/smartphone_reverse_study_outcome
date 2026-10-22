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
import com.google.crypto.tink.signature.EcdsaPrivateKey;
import com.google.crypto.tink.subtle.EcdsaSignJce;
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
public final class JwtEcdsaSignKeyManager {
    private static final TinkFipsUtil.AlgorithmFipsCompatibility FIPS = null;
    private static final MutableKeyCreationRegistry.KeyCreator<JwtEcdsaParameters> KEY_CREATOR = null;
    private static final PrimitiveConstructor<JwtEcdsaPrivateKey, JwtPublicKeySign> PRIMITIVE_CONSTRUCTOR = null;
    private static final PrivateKeyManager<Void> legacyPrivateKeyManager = null;
    private static final KeyManager<Void> legacyPublicKeyManager = null;

    public static /* synthetic */ JwtEcdsaPrivateKey $r8$lambda$sMGsMLOsrZ8phHAv5RfT1obBp8E(JwtEcdsaParameters r0, Integer r1) {
        return createKey(r0, r1);
    }

    static String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.JwtEcdsaPrivateKey";
    }

    static {
        legacyPrivateKeyManager = LegacyKeyManagerImpl.createPrivateKeyManager(getKeyType(), Void.class, com.google.crypto.tink.proto.JwtEcdsaPrivateKey.parser());
        legacyPublicKeyManager = LegacyKeyManagerImpl.create(JwtEcdsaVerifyKeyManager.getKeyType(), Void.class, KeyData.KeyMaterialType.ASYMMETRIC_PUBLIC, com.google.crypto.tink.proto.JwtEcdsaPublicKey.parser());
        PRIMITIVE_CONSTRUCTOR = PrimitiveConstructor.create(new JwtEcdsaSignKeyManager$$ExternalSyntheticLambda0(), JwtEcdsaPrivateKey.class, JwtPublicKeySign.class);
        KEY_CREATOR = new JwtEcdsaSignKeyManager$$ExternalSyntheticLambda1();
        FIPS = TinkFipsUtil.AlgorithmFipsCompatibility.ALGORITHM_REQUIRES_BORINGCRYPTO;
    }

    private static EcdsaPrivateKey toEcdsaPrivateKey(JwtEcdsaPrivateKey privateKey) throws GeneralSecurityException {
        return EcdsaPrivateKey.builder().setPublicKey(JwtEcdsaVerifyKeyManager.toEcdsaPublicKey(privateKey.getPublicKey())).setPrivateValue(privateKey.getPrivateValue()).build();
    }

    static JwtPublicKeySign createFullPrimitive(final JwtEcdsaPrivateKey privateKey) throws GeneralSecurityException {
        final PublicKeySign r0 = EcdsaSignJce.create(toEcdsaPrivateKey(privateKey));
        final String r1 = privateKey.getParameters().getAlgorithm().getStandardName();
        return new AnonymousClass1(r1, privateKey, r0);
    }

    private static JwtEcdsaPrivateKey createKey(JwtEcdsaParameters parameters, @Nullable Integer idRequirement) throws GeneralSecurityException {
        KeyPair r0 = EllipticCurves.generateKeyPair(parameters.getAlgorithm().getECParameterSpec());
        ECPublicKey r1 = (ECPublicKey) r0.getPublic();
        ECPrivateKey r2 = (ECPrivateKey) r0.getPrivate();
        JwtEcdsaPublicKey.Builder r3 = JwtEcdsaPublicKey.builder().setParameters(parameters).setPublicPoint(r1.getW());
        if (idRequirement == null) goto L6;
        r3.setIdRequirement(idRequirement);
    L6:
        return JwtEcdsaPrivateKey.create(r3.build(), SecretBigInteger.fromBigInteger(r2.getS(), InsecureSecretKeyAccess.get()));
    }

    private JwtEcdsaSignKeyManager() {
    }

    private static Map<String, Parameters> namedParameters() throws GeneralSecurityException {
        HashMap r0 = new HashMap();
        r0.put("JWT_ES256_RAW", JwtEcdsaParameters.builder().setAlgorithm(JwtEcdsaParameters.Algorithm.ES256).setKidStrategy(JwtEcdsaParameters.KidStrategy.IGNORED).build());
        r0.put("JWT_ES256", JwtEcdsaParameters.builder().setAlgorithm(JwtEcdsaParameters.Algorithm.ES256).setKidStrategy(JwtEcdsaParameters.KidStrategy.BASE64_ENCODED_KEY_ID).build());
        r0.put("JWT_ES384_RAW", JwtEcdsaParameters.builder().setAlgorithm(JwtEcdsaParameters.Algorithm.ES384).setKidStrategy(JwtEcdsaParameters.KidStrategy.IGNORED).build());
        r0.put("JWT_ES384", JwtEcdsaParameters.builder().setAlgorithm(JwtEcdsaParameters.Algorithm.ES384).setKidStrategy(JwtEcdsaParameters.KidStrategy.BASE64_ENCODED_KEY_ID).build());
        r0.put("JWT_ES512_RAW", JwtEcdsaParameters.builder().setAlgorithm(JwtEcdsaParameters.Algorithm.ES512).setKidStrategy(JwtEcdsaParameters.KidStrategy.IGNORED).build());
        r0.put("JWT_ES512", JwtEcdsaParameters.builder().setAlgorithm(JwtEcdsaParameters.Algorithm.ES512).setKidStrategy(JwtEcdsaParameters.KidStrategy.BASE64_ENCODED_KEY_ID).build());
        return Collections.unmodifiableMap(r0);
    }

    public static void registerPair(boolean newKeyAllowed) throws GeneralSecurityException {
        TinkFipsUtil.AlgorithmFipsCompatibility r0 = FIPS;
        if (r0.isCompatible() == false) goto L7;
        KeyManagerRegistry.globalInstance().registerKeyManagerWithFipsCompatibility(legacyPrivateKeyManager, r0, newKeyAllowed);
        KeyManagerRegistry.globalInstance().registerKeyManagerWithFipsCompatibility(legacyPublicKeyManager, r0, false);
        MutableKeyCreationRegistry.globalInstance().add(KEY_CREATOR, JwtEcdsaParameters.class);
        JwtEcdsaProtoSerialization.register();
        MutablePrimitiveRegistry.globalInstance().registerPrimitiveConstructor(JwtEcdsaVerifyKeyManager.PRIMITIVE_CONSTRUCTOR);
        MutablePrimitiveRegistry.globalInstance().registerPrimitiveConstructor(PRIMITIVE_CONSTRUCTOR);
        MutableParametersRegistry.globalInstance().putAll(namedParameters());
        return;
    L7:
        throw new GeneralSecurityException("Can not use ECDSA in FIPS-mode, as BoringCrypto module is not available.");
    }
}
