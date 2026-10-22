package com.google.crypto.tink.signature;

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
public final class EcdsaPrivateKey extends SignaturePrivateKey {
    private final SecretBigInteger privateValue;
    private final EcdsaPublicKey publicKey;

    /* JADX INFO: renamed from: com.google.crypto.tink.signature.EcdsaPrivateKey$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public static class Builder {
        private SecretBigInteger privateValue;
        private EcdsaPublicKey publicKey;

        /* synthetic */ Builder(AnonymousClass1 r1) {
            this();
        }

        private Builder() {
            this.publicKey = null;
            this.privateValue = null;
        }

        public Builder setPublicKey(EcdsaPublicKey publicKey) {
            this.publicKey = publicKey;
            return this;
        }

        public Builder setPrivateValue(SecretBigInteger privateValue) {
            this.privateValue = privateValue;
            return this;
        }

        private static void validatePrivateValue(BigInteger privateValue, ECPoint publicPoint, EcdsaParameters.CurveType curveType) throws GeneralSecurityException {
            BigInteger r0 = curveType.toParameterSpec().getOrder();
            if (privateValue.signum() <= 0) goto L12;
            if (privateValue.compareTo(r0) >= 0) goto L12;
            if (EllipticCurvesUtil.multiplyByGenerator(privateValue, curveType.toParameterSpec()).equals(publicPoint) == false) goto L10;
            return;
        L10:
            throw new GeneralSecurityException("Invalid private value");
        L12:
            throw new GeneralSecurityException("Invalid private value");
        }

        public EcdsaPrivateKey build() throws GeneralSecurityException {
            if (this.publicKey == null) goto L11;
            SecretBigInteger r0 = this.privateValue;
            if (r0 == null) goto L9;
            validatePrivateValue(r0.getBigInteger(InsecureSecretKeyAccess.get()), this.publicKey.getPublicPoint(), this.publicKey.getParameters().getCurveType());
            return new EcdsaPrivateKey(this.publicKey, this.privateValue, null);
        L9:
            throw new GeneralSecurityException("Cannot build without a private value");
        L11:
            throw new GeneralSecurityException("Cannot build without a ecdsa public key");
        }
    }

    @Override // com.google.crypto.tink.signature.SignaturePrivateKey, com.google.crypto.tink.Key
    public /* bridge */ /* synthetic */ Parameters getParameters() {
        return getParameters();
    }

    @Override // com.google.crypto.tink.signature.SignaturePrivateKey, com.google.crypto.tink.Key
    public /* bridge */ /* synthetic */ SignatureParameters getParameters() {
        return getParameters();
    }

    @Override // com.google.crypto.tink.signature.SignaturePrivateKey, com.google.crypto.tink.PrivateKey
    public /* bridge */ /* synthetic */ Key getPublicKey() {
        return getPublicKey();
    }

    @Override // com.google.crypto.tink.signature.SignaturePrivateKey, com.google.crypto.tink.PrivateKey
    public /* bridge */ /* synthetic */ SignaturePublicKey getPublicKey() {
        return getPublicKey();
    }

    /* synthetic */ EcdsaPrivateKey(EcdsaPublicKey r1, SecretBigInteger r2, AnonymousClass1 r3) {
        this(r1, r2);
    }

    private EcdsaPrivateKey(EcdsaPublicKey publicKey, SecretBigInteger privateValue) {
        this.publicKey = publicKey;
        this.privateValue = privateValue;
    }

    public static Builder builder() {
        return new Builder(null);
    }

    @Override // com.google.crypto.tink.signature.SignaturePrivateKey, com.google.crypto.tink.Key
    public EcdsaParameters getParameters() {
        return this.publicKey.getParameters();
    }

    @Override // com.google.crypto.tink.signature.SignaturePrivateKey, com.google.crypto.tink.PrivateKey
    public EcdsaPublicKey getPublicKey() {
        return this.publicKey;
    }

    public SecretBigInteger getPrivateValue() {
        return this.privateValue;
    }

    @Override // com.google.crypto.tink.Key
    public boolean equalsKey(Key o) {
        if ((o instanceof EcdsaPrivateKey) == true) goto L5;
        return false;
    L5:
        EcdsaPrivateKey r4 = (EcdsaPrivateKey) o;
        if (r4.publicKey.equalsKey(this.publicKey) == true) goto L8;
        return false;
    L8:
        if (this.privateValue.equalsSecretBigInteger(r4.privateValue) == false) goto L12;
        return true;
    L12:
        return false;
    }
}
