package com.google.crypto.tink.jwt;

import com.google.crypto.tink.PublicKeyVerify;
import com.google.crypto.tink.internal.PrimitiveConstructor;
import com.google.crypto.tink.signature.RsaSsaPkcs1Parameters;
import com.google.crypto.tink.signature.RsaSsaPkcs1PublicKey;
import com.google.crypto.tink.subtle.RsaSsaPkcs1VerifyJce;
import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes4.dex */
final class JwtRsaSsaPkcs1VerifyKeyManager {
    static final PrimitiveConstructor<JwtRsaSsaPkcs1PublicKey, JwtPublicKeyVerify> PRIMITIVE_CONSTRUCTOR = null;

    static String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.JwtRsaSsaPkcs1PublicKey";
    }

    private static RsaSsaPkcs1Parameters.HashType hashTypeForAlgorithm(JwtRsaSsaPkcs1Parameters.Algorithm algorithm) throws GeneralSecurityException {
        if (algorithm.equals(JwtRsaSsaPkcs1Parameters.Algorithm.RS256) == false) goto L7;
        return RsaSsaPkcs1Parameters.HashType.SHA256;
    L7:
        if (algorithm.equals(JwtRsaSsaPkcs1Parameters.Algorithm.RS384) == false) goto L11;
        return RsaSsaPkcs1Parameters.HashType.SHA384;
    L11:
        if (algorithm.equals(JwtRsaSsaPkcs1Parameters.Algorithm.RS512) == false) goto L15;
        return RsaSsaPkcs1Parameters.HashType.SHA512;
    L15:
        throw new GeneralSecurityException("unknown algorithm " + algorithm);
    }

    static RsaSsaPkcs1PublicKey toRsaSsaPkcs1PublicKey(JwtRsaSsaPkcs1PublicKey publicKey) throws GeneralSecurityException {
        RsaSsaPkcs1Parameters r0 = RsaSsaPkcs1Parameters.builder().setModulusSizeBits(publicKey.getParameters().getModulusSizeBits()).setPublicExponent(publicKey.getParameters().getPublicExponent()).setHashType(hashTypeForAlgorithm(publicKey.getParameters().getAlgorithm())).setVariant(RsaSsaPkcs1Parameters.Variant.NO_PREFIX).build();
        return RsaSsaPkcs1PublicKey.builder().setParameters(r0).setModulus(publicKey.getModulus()).build();
    }

    static JwtPublicKeyVerify createFullPrimitive(final JwtRsaSsaPkcs1PublicKey publicKey) throws GeneralSecurityException {
        final PublicKeyVerify r0 = RsaSsaPkcs1VerifyJce.create(toRsaSsaPkcs1PublicKey(publicKey));
        return new AnonymousClass1(r0, publicKey);
    }

    static {
        PRIMITIVE_CONSTRUCTOR = PrimitiveConstructor.create(new JwtRsaSsaPkcs1VerifyKeyManager$$ExternalSyntheticLambda0(), JwtRsaSsaPkcs1PublicKey.class, JwtPublicKeyVerify.class);
    }

    private JwtRsaSsaPkcs1VerifyKeyManager() {
    }
}
