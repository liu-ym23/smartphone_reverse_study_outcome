package com.google.crypto.tink.jwt;

import com.google.crypto.tink.InsecureSecretKeyAccess;
import com.google.crypto.tink.Key;
import com.google.crypto.tink.Parameters;
import com.google.crypto.tink.internal.EllipticCurvesUtil;
import com.google.crypto.tink.util.SecretBigInteger;
import com.google.errorprone.annotations.Immutable;
import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.spec.ECPoint;

/* JADX INFO: loaded from: classes4.dex */
@Immutable
public final class JwtEcdsaPrivateKey extends JwtSignaturePrivateKey {
    public final SecretBigInteger privateKeyValue;
    public final JwtEcdsaPublicKey publicKey;

    @Override // com.google.crypto.tink.jwt.JwtSignaturePrivateKey, com.google.crypto.tink.Key
    public /* bridge */ /* synthetic */ Parameters getParameters() {
        return getParameters();
    }

    @Override // com.google.crypto.tink.jwt.JwtSignaturePrivateKey, com.google.crypto.tink.Key
    public /* bridge */ /* synthetic */ JwtSignatureParameters getParameters() {
        return getParameters();
    }

    @Override // com.google.crypto.tink.jwt.JwtSignaturePrivateKey, com.google.crypto.tink.PrivateKey
    public /* bridge */ /* synthetic */ Key getPublicKey() {
        return getPublicKey();
    }

    @Override // com.google.crypto.tink.jwt.JwtSignaturePrivateKey, com.google.crypto.tink.PrivateKey
    public /* bridge */ /* synthetic */ JwtSignaturePublicKey getPublicKey() {
        return getPublicKey();
    }

    private static void validatePrivateValue(BigInteger privateValue, ECPoint publicPoint, JwtEcdsaParameters.Algorithm algorithm) throws GeneralSecurityException {
        BigInteger r0 = algorithm.getECParameterSpec().getOrder();
        if (privateValue.signum() <= 0) goto L12;
        if (privateValue.compareTo(r0) >= 0) goto L12;
        if (EllipticCurvesUtil.multiplyByGenerator(privateValue, algorithm.getECParameterSpec()).equals(publicPoint) == false) goto L10;
        return;
    L10:
        throw new GeneralSecurityException("Invalid private value");
    L12:
        throw new GeneralSecurityException("Invalid private value");
    }

    public static JwtEcdsaPrivateKey create(JwtEcdsaPublicKey publicKey, SecretBigInteger privateValue) throws GeneralSecurityException {
        validatePrivateValue(privateValue.getBigInteger(InsecureSecretKeyAccess.get()), publicKey.getPublicPoint(), publicKey.getParameters().getAlgorithm());
        return new JwtEcdsaPrivateKey(publicKey, privateValue);
    }

    private JwtEcdsaPrivateKey(JwtEcdsaPublicKey publicKey, SecretBigInteger privateKeyValue) {
        this.publicKey = publicKey;
        this.privateKeyValue = privateKeyValue;
    }

    public SecretBigInteger getPrivateValue() {
        return this.privateKeyValue;
    }

    @Override // com.google.crypto.tink.jwt.JwtSignaturePrivateKey, com.google.crypto.tink.Key
    public JwtEcdsaParameters getParameters() {
        return this.publicKey.getParameters();
    }

    @Override // com.google.crypto.tink.jwt.JwtSignaturePrivateKey, com.google.crypto.tink.PrivateKey
    public JwtEcdsaPublicKey getPublicKey() {
        return this.publicKey;
    }

    @Override // com.google.crypto.tink.Key
    public boolean equalsKey(Key o) {
        if ((o instanceof JwtEcdsaPrivateKey) == true) goto L5;
        return false;
    L5:
        JwtEcdsaPrivateKey r4 = (JwtEcdsaPrivateKey) o;
        if (r4.publicKey.equalsKey(this.publicKey) == true) goto L8;
        return false;
    L8:
        if (this.privateKeyValue.equalsSecretBigInteger(r4.privateKeyValue) == false) goto L12;
        return true;
    L12:
        return false;
    }
}
