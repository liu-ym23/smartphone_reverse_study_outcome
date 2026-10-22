package com.google.crypto.tink.jwt;

import com.google.crypto.tink.PublicKeyVerify;
import com.google.crypto.tink.internal.PrimitiveConstructor;
import com.google.crypto.tink.signature.RsaSsaPssParameters;
import com.google.crypto.tink.signature.RsaSsaPssPublicKey;
import com.google.crypto.tink.subtle.RsaSsaPssVerifyJce;
import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes4.dex */
final class JwtRsaSsaPssVerifyKeyManager {
    static final PrimitiveConstructor<JwtRsaSsaPssPublicKey, JwtPublicKeyVerify> PRIMITIVE_CONSTRUCTOR = null;

    static String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.JwtRsaSsaPssPublicKey";
    }

    private static RsaSsaPssParameters.HashType hashTypeForAlgorithm(JwtRsaSsaPssParameters.Algorithm algorithm) throws GeneralSecurityException {
        if (algorithm.equals(JwtRsaSsaPssParameters.Algorithm.PS256) == false) goto L7;
        return RsaSsaPssParameters.HashType.SHA256;
    L7:
        if (algorithm.equals(JwtRsaSsaPssParameters.Algorithm.PS384) == false) goto L11;
        return RsaSsaPssParameters.HashType.SHA384;
    L11:
        if (algorithm.equals(JwtRsaSsaPssParameters.Algorithm.PS512) == false) goto L15;
        return RsaSsaPssParameters.HashType.SHA512;
    L15:
        throw new GeneralSecurityException("unknown algorithm " + algorithm);
    }

    static final int saltLengthForPssAlgorithm(JwtRsaSsaPssParameters.Algorithm algorithm) throws GeneralSecurityException {
        if (algorithm.equals(JwtRsaSsaPssParameters.Algorithm.PS256) == false) goto L7;
        return 32;
    L7:
        if (algorithm.equals(JwtRsaSsaPssParameters.Algorithm.PS384) == false) goto L11;
        return 48;
    L11:
        if (algorithm.equals(JwtRsaSsaPssParameters.Algorithm.PS512) == false) goto L15;
        return 64;
    L15:
        throw new GeneralSecurityException("unknown algorithm " + algorithm);
    }

    static RsaSsaPssPublicKey toRsaSsaPssPublicKey(JwtRsaSsaPssPublicKey publicKey) throws GeneralSecurityException {
        RsaSsaPssParameters r0 = RsaSsaPssParameters.builder().setModulusSizeBits(publicKey.getParameters().getModulusSizeBits()).setPublicExponent(publicKey.getParameters().getPublicExponent()).setSigHashType(hashTypeForAlgorithm(publicKey.getParameters().getAlgorithm())).setMgf1HashType(hashTypeForAlgorithm(publicKey.getParameters().getAlgorithm())).setSaltLengthBytes(saltLengthForPssAlgorithm(publicKey.getParameters().getAlgorithm())).setVariant(RsaSsaPssParameters.Variant.NO_PREFIX).build();
        return RsaSsaPssPublicKey.builder().setParameters(r0).setModulus(publicKey.getModulus()).build();
    }

    static JwtPublicKeyVerify createFullPrimitive(final JwtRsaSsaPssPublicKey publicKey) throws GeneralSecurityException {
        final PublicKeyVerify r0 = RsaSsaPssVerifyJce.create(toRsaSsaPssPublicKey(publicKey));
        return new AnonymousClass1(r0, publicKey);
    }

    static {
        PRIMITIVE_CONSTRUCTOR = PrimitiveConstructor.create(new JwtRsaSsaPssVerifyKeyManager$$ExternalSyntheticLambda0(), JwtRsaSsaPssPublicKey.class, JwtPublicKeyVerify.class);
    }

    private JwtRsaSsaPssVerifyKeyManager() {
    }
}
