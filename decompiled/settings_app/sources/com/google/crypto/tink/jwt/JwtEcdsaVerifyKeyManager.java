package com.google.crypto.tink.jwt;

import com.google.crypto.tink.PublicKeyVerify;
import com.google.crypto.tink.internal.PrimitiveConstructor;
import com.google.crypto.tink.proto.JwtEcdsaAlgorithm;
import com.google.crypto.tink.signature.EcdsaParameters;
import com.google.crypto.tink.signature.EcdsaPublicKey;
import com.google.crypto.tink.subtle.EcdsaVerifyJce;
import com.google.crypto.tink.subtle.EllipticCurves;
import com.google.crypto.tink.subtle.Enums;
import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes4.dex */
class JwtEcdsaVerifyKeyManager {
    static final PrimitiveConstructor<JwtEcdsaPublicKey, JwtPublicKeyVerify> PRIMITIVE_CONSTRUCTOR = null;

    /* JADX INFO: renamed from: com.google.crypto.tink.jwt.JwtEcdsaVerifyKeyManager$2, reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$google$crypto$tink$proto$JwtEcdsaAlgorithm = null;

        static {
            int[] r0 = new int[JwtEcdsaAlgorithm.values().length];
            $SwitchMap$com$google$crypto$tink$proto$JwtEcdsaAlgorithm = r0;
            r0[JwtEcdsaAlgorithm.ES256.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            $SwitchMap$com$google$crypto$tink$proto$JwtEcdsaAlgorithm[JwtEcdsaAlgorithm.ES384.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            $SwitchMap$com$google$crypto$tink$proto$JwtEcdsaAlgorithm[JwtEcdsaAlgorithm.ES512.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    static String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.JwtEcdsaPublicKey";
    }

    static EcdsaParameters.CurveType getCurveType(JwtEcdsaParameters parameters) throws GeneralSecurityException {
        if (parameters.getAlgorithm().equals(JwtEcdsaParameters.Algorithm.ES256) == false) goto L7;
        return EcdsaParameters.CurveType.NIST_P256;
    L7:
        if (parameters.getAlgorithm().equals(JwtEcdsaParameters.Algorithm.ES384) == false) goto L11;
        return EcdsaParameters.CurveType.NIST_P384;
    L11:
        if (parameters.getAlgorithm().equals(JwtEcdsaParameters.Algorithm.ES512) == false) goto L15;
        return EcdsaParameters.CurveType.NIST_P521;
    L15:
        throw new GeneralSecurityException("unknown algorithm in parameters: " + parameters);
    }

    static EcdsaParameters.HashType getHash(JwtEcdsaParameters parameters) throws GeneralSecurityException {
        if (parameters.getAlgorithm().equals(JwtEcdsaParameters.Algorithm.ES256) == false) goto L7;
        return EcdsaParameters.HashType.SHA256;
    L7:
        if (parameters.getAlgorithm().equals(JwtEcdsaParameters.Algorithm.ES384) == false) goto L11;
        return EcdsaParameters.HashType.SHA384;
    L11:
        if (parameters.getAlgorithm().equals(JwtEcdsaParameters.Algorithm.ES512) == false) goto L15;
        return EcdsaParameters.HashType.SHA512;
    L15:
        throw new GeneralSecurityException("unknown algorithm in parameters: " + parameters);
    }

    static EcdsaPublicKey toEcdsaPublicKey(JwtEcdsaPublicKey publicKey) throws GeneralSecurityException {
        EcdsaParameters r0 = EcdsaParameters.builder().setSignatureEncoding(EcdsaParameters.SignatureEncoding.IEEE_P1363).setCurveType(getCurveType(publicKey.getParameters())).setHashType(getHash(publicKey.getParameters())).build();
        return EcdsaPublicKey.builder().setParameters(r0).setPublicPoint(publicKey.getPublicPoint()).build();
    }

    static JwtPublicKeyVerify createFullPrimitive(final JwtEcdsaPublicKey publicKey) throws GeneralSecurityException {
        final PublicKeyVerify r0 = EcdsaVerifyJce.create(toEcdsaPublicKey(publicKey));
        return new AnonymousClass1(r0, publicKey);
    }

    static {
        PRIMITIVE_CONSTRUCTOR = PrimitiveConstructor.create(new JwtEcdsaVerifyKeyManager$$ExternalSyntheticLambda0(), JwtEcdsaPublicKey.class, JwtPublicKeyVerify.class);
    }

    static final EllipticCurves.CurveType getCurve(JwtEcdsaAlgorithm algorithm) throws GeneralSecurityException {
        int r0 = AnonymousClass2.$SwitchMap$com$google$crypto$tink$proto$JwtEcdsaAlgorithm[algorithm.ordinal()];
        if (r0 == 1) goto L15;
        if (r0 == 2) goto L13;
        if (r0 != 3) goto L11;
        return EllipticCurves.CurveType.NIST_P521;
    L11:
        throw new GeneralSecurityException("unknown algorithm " + algorithm.name());
    L13:
        return EllipticCurves.CurveType.NIST_P384;
    L15:
        return EllipticCurves.CurveType.NIST_P256;
    }

    public static Enums.HashType hashForEcdsaAlgorithm(JwtEcdsaAlgorithm algorithm) throws GeneralSecurityException {
        int r0 = AnonymousClass2.$SwitchMap$com$google$crypto$tink$proto$JwtEcdsaAlgorithm[algorithm.ordinal()];
        if (r0 == 1) goto L15;
        if (r0 == 2) goto L13;
        if (r0 != 3) goto L11;
        return Enums.HashType.SHA512;
    L11:
        throw new GeneralSecurityException("unknown algorithm " + algorithm.name());
    L13:
        return Enums.HashType.SHA384;
    L15:
        return Enums.HashType.SHA256;
    }

    static final void validateEcdsaAlgorithm(JwtEcdsaAlgorithm algorithm) throws GeneralSecurityException {
        hashForEcdsaAlgorithm(algorithm);
    }

    private JwtEcdsaVerifyKeyManager() {
    }
}
