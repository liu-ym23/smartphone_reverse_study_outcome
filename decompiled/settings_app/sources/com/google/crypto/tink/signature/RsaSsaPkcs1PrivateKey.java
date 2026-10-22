package com.google.crypto.tink.signature;

import com.google.crypto.tink.InsecureSecretKeyAccess;
import com.google.crypto.tink.Key;
import com.google.crypto.tink.Parameters;
import com.google.crypto.tink.util.SecretBigInteger;
import java.math.BigInteger;
import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class RsaSsaPkcs1PrivateKey extends SignaturePrivateKey {
    private final SecretBigInteger d;
    private final SecretBigInteger dP;
    private final SecretBigInteger dQ;
    private final SecretBigInteger p;
    private final RsaSsaPkcs1PublicKey publicKey;
    private final SecretBigInteger q;
    private final SecretBigInteger qInv;

    /* JADX INFO: renamed from: com.google.crypto.tink.signature.RsaSsaPkcs1PrivateKey$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public static class Builder {
        private static final int PRIME_CERTAINTY = 10;

        @Nullable
        private SecretBigInteger d;

        @Nullable
        private SecretBigInteger dP;

        @Nullable
        private SecretBigInteger dQ;

        @Nullable
        private SecretBigInteger p;

        @Nullable
        private RsaSsaPkcs1PublicKey publicKey;

        @Nullable
        private SecretBigInteger q;

        @Nullable
        private SecretBigInteger qInv;

        /* synthetic */ Builder(AnonymousClass1 r1) {
            this();
        }

        private Builder() {
            this.publicKey = null;
            this.d = null;
            this.p = null;
            this.q = null;
            this.dP = null;
            this.dQ = null;
            this.qInv = null;
        }

        public Builder setPublicKey(RsaSsaPkcs1PublicKey publicKey) {
            this.publicKey = publicKey;
            return this;
        }

        public Builder setPrimes(SecretBigInteger p, SecretBigInteger q) {
            this.p = p;
            this.q = q;
            return this;
        }

        public Builder setPrivateExponent(SecretBigInteger d) {
            this.d = d;
            return this;
        }

        public Builder setPrimeExponents(SecretBigInteger dP, SecretBigInteger dQ) {
            this.dP = dP;
            this.dQ = dQ;
            return this;
        }

        public Builder setCrtCoefficient(SecretBigInteger qInv) {
            this.qInv = qInv;
            return this;
        }

        public RsaSsaPkcs1PrivateKey build() throws GeneralSecurityException {
            RsaSsaPkcs1PublicKey r0 = this.publicKey;
            if (r0 == null) goto L55;
            if (this.p == null) goto L53;
            if (this.q == null) goto L53;
            if (this.d == null) goto L51;
            if (this.dP == null) goto L49;
            if (this.dQ == null) goto L49;
            if (this.qInv == null) goto L47;
            BigInteger r1 = r0.getParameters().getPublicExponent();
            BigInteger r2 = this.publicKey.getModulus();
            BigInteger r3 = this.p.getBigInteger(InsecureSecretKeyAccess.get());
            BigInteger r4 = this.q.getBigInteger(InsecureSecretKeyAccess.get());
            BigInteger r5 = this.d.getBigInteger(InsecureSecretKeyAccess.get());
            BigInteger r6 = this.dP.getBigInteger(InsecureSecretKeyAccess.get());
            BigInteger r7 = this.dQ.getBigInteger(InsecureSecretKeyAccess.get());
            BigInteger r8 = this.qInv.getBigInteger(InsecureSecretKeyAccess.get());
            if (r3.isProbablePrime(10) == false) goto L45;
            if (r4.isProbablePrime(10) == false) goto L43;
            if (r3.multiply(r4).equals(r2) == false) goto L41;
            BigInteger r9 = r3.subtract(BigInteger.ONE);
            BigInteger r10 = r4.subtract(BigInteger.ONE);
            BigInteger r11 = r9.divide(r9.gcd(r10)).multiply(r10);
            if (r1.multiply(r5).mod(r11).equals(BigInteger.ONE) == false) goto L39;
            if (r1.multiply(r6).mod(r9).equals(BigInteger.ONE) == false) goto L37;
            if (r1.multiply(r7).mod(r10).equals(BigInteger.ONE) == false) goto L35;
            if (r4.multiply(r8).mod(r3).equals(BigInteger.ONE) == false) goto L33;
            return new RsaSsaPkcs1PrivateKey(this.publicKey, this.p, this.q, this.d, this.dP, this.dQ, this.qInv, null);
        L33:
            throw new GeneralSecurityException("qInv is invalid.");
        L35:
            throw new GeneralSecurityException("dQ is invalid.");
        L37:
            throw new GeneralSecurityException("dP is invalid.");
        L39:
            throw new GeneralSecurityException("D is invalid.");
        L41:
            throw new GeneralSecurityException("Prime p times prime q is not equal to the public key's modulus");
        L43:
            throw new GeneralSecurityException("q is not a prime");
        L45:
            throw new GeneralSecurityException("p is not a prime");
        L47:
            throw new GeneralSecurityException("Cannot build without CRT coefficient");
        L49:
            throw new GeneralSecurityException("Cannot build without prime exponents");
        L51:
            throw new GeneralSecurityException("Cannot build without private exponent");
        L53:
            throw new GeneralSecurityException("Cannot build without prime factors");
        L55:
            throw new GeneralSecurityException("Cannot build without a RSA SSA PKCS1 public key");
        }
    }

    /* synthetic */ RsaSsaPkcs1PrivateKey(RsaSsaPkcs1PublicKey r1, SecretBigInteger r2, SecretBigInteger r3, SecretBigInteger r4, SecretBigInteger r5, SecretBigInteger r6, SecretBigInteger r7, AnonymousClass1 r8) {
        this(r1, r2, r3, r4, r5, r6, r7);
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

    private RsaSsaPkcs1PrivateKey(RsaSsaPkcs1PublicKey publicKey, SecretBigInteger p, SecretBigInteger q, SecretBigInteger d, SecretBigInteger dP, SecretBigInteger dQ, SecretBigInteger qInv) {
        this.publicKey = publicKey;
        this.p = p;
        this.q = q;
        this.d = d;
        this.dP = dP;
        this.dQ = dQ;
        this.qInv = qInv;
    }

    public static Builder builder() {
        return new Builder(null);
    }

    @Override // com.google.crypto.tink.signature.SignaturePrivateKey, com.google.crypto.tink.Key
    public RsaSsaPkcs1Parameters getParameters() {
        return this.publicKey.getParameters();
    }

    @Override // com.google.crypto.tink.signature.SignaturePrivateKey, com.google.crypto.tink.PrivateKey
    public RsaSsaPkcs1PublicKey getPublicKey() {
        return this.publicKey;
    }

    public SecretBigInteger getPrimeP() {
        return this.p;
    }

    public SecretBigInteger getPrimeQ() {
        return this.q;
    }

    public SecretBigInteger getPrivateExponent() {
        return this.d;
    }

    public SecretBigInteger getPrimeExponentP() {
        return this.dP;
    }

    public SecretBigInteger getPrimeExponentQ() {
        return this.dQ;
    }

    public SecretBigInteger getCrtCoefficient() {
        return this.qInv;
    }

    @Override // com.google.crypto.tink.Key
    public boolean equalsKey(Key o) {
        if ((o instanceof RsaSsaPkcs1PrivateKey) == true) goto L5;
        return false;
    L5:
        RsaSsaPkcs1PrivateKey r4 = (RsaSsaPkcs1PrivateKey) o;
        if (r4.publicKey.equalsKey(this.publicKey) == true) goto L8;
        return false;
    L8:
        if (this.p.equalsSecretBigInteger(r4.p) == true) goto L10;
        return false;
    L10:
        if (this.q.equalsSecretBigInteger(r4.q) == true) goto L12;
        return false;
    L12:
        if (this.d.equalsSecretBigInteger(r4.d) == true) goto L14;
        return false;
    L14:
        if (this.dP.equalsSecretBigInteger(r4.dP) == true) goto L16;
        return false;
    L16:
        if (this.dQ.equalsSecretBigInteger(r4.dQ) == true) goto L18;
        return false;
    L18:
        if (this.qInv.equalsSecretBigInteger(r4.qInv) == false) goto L27;
        return true;
    L27:
        return false;
    }
}
