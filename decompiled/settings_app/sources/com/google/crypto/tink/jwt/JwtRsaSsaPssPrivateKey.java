package com.google.crypto.tink.jwt;

import com.google.crypto.tink.InsecureSecretKeyAccess;
import com.google.crypto.tink.Key;
import com.google.crypto.tink.Parameters;
import com.google.crypto.tink.util.SecretBigInteger;
import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.util.Optional;

/* JADX INFO: loaded from: classes4.dex */
public final class JwtRsaSsaPssPrivateKey extends JwtSignaturePrivateKey {
    private final SecretBigInteger d;
    private final SecretBigInteger dP;
    private final SecretBigInteger dQ;
    private final SecretBigInteger p;
    private final JwtRsaSsaPssPublicKey publicKey;
    private final SecretBigInteger q;
    private final SecretBigInteger qInv;

    /* JADX INFO: renamed from: com.google.crypto.tink.jwt.JwtRsaSsaPssPrivateKey$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public static class Builder {
        private static final int PRIME_CERTAINTY = 10;
        private Optional<SecretBigInteger> d;
        private Optional<SecretBigInteger> dP;
        private Optional<SecretBigInteger> dQ;
        private Optional<SecretBigInteger> p;
        private Optional<JwtRsaSsaPssPublicKey> publicKey;
        private Optional<SecretBigInteger> q;
        private Optional<SecretBigInteger> qInv;

        /* synthetic */ Builder(AnonymousClass1 r1) {
            this();
        }

        private Builder() {
            this.publicKey = Optional.empty();
            this.d = Optional.empty();
            this.p = Optional.empty();
            this.q = Optional.empty();
            this.dP = Optional.empty();
            this.dQ = Optional.empty();
            this.qInv = Optional.empty();
        }

        public Builder setPublicKey(JwtRsaSsaPssPublicKey publicKey) {
            this.publicKey = Optional.of(publicKey);
            return this;
        }

        public Builder setPrimes(SecretBigInteger p, SecretBigInteger q) {
            this.p = Optional.of(p);
            this.q = Optional.of(q);
            return this;
        }

        public Builder setPrivateExponent(SecretBigInteger d) {
            this.d = Optional.of(d);
            return this;
        }

        public Builder setPrimeExponents(SecretBigInteger dP, SecretBigInteger dQ) {
            this.dP = Optional.of(dP);
            this.dQ = Optional.of(dQ);
            return this;
        }

        public Builder setCrtCoefficient(SecretBigInteger qInv) {
            this.qInv = Optional.of(qInv);
            return this;
        }

        public JwtRsaSsaPssPrivateKey build() throws GeneralSecurityException {
            if (this.publicKey.isPresent() == false) goto L55;
            if (this.p.isPresent() == false) goto L53;
            if (this.q.isPresent() == false) goto L53;
            if (this.d.isPresent() == false) goto L51;
            if (this.dP.isPresent() == false) goto L49;
            if (this.dQ.isPresent() == false) goto L49;
            if (this.qInv.isPresent() == false) goto L47;
            BigInteger r0 = this.publicKey.get().getParameters().getPublicExponent();
            BigInteger r1 = this.publicKey.get().getModulus();
            BigInteger r2 = this.p.get().getBigInteger(InsecureSecretKeyAccess.get());
            BigInteger r3 = this.q.get().getBigInteger(InsecureSecretKeyAccess.get());
            BigInteger r4 = this.d.get().getBigInteger(InsecureSecretKeyAccess.get());
            BigInteger r5 = this.dP.get().getBigInteger(InsecureSecretKeyAccess.get());
            BigInteger r6 = this.dQ.get().getBigInteger(InsecureSecretKeyAccess.get());
            BigInteger r7 = this.qInv.get().getBigInteger(InsecureSecretKeyAccess.get());
            if (r2.isProbablePrime(10) == false) goto L45;
            if (r3.isProbablePrime(10) == false) goto L43;
            if (r2.multiply(r3).equals(r1) == false) goto L41;
            BigInteger r8 = r2.subtract(BigInteger.ONE);
            BigInteger r9 = r3.subtract(BigInteger.ONE);
            BigInteger r10 = r8.divide(r8.gcd(r9)).multiply(r9);
            if (r0.multiply(r4).mod(r10).equals(BigInteger.ONE) == false) goto L39;
            if (r0.multiply(r5).mod(r8).equals(BigInteger.ONE) == false) goto L37;
            if (r0.multiply(r6).mod(r9).equals(BigInteger.ONE) == false) goto L35;
            if (r3.multiply(r7).mod(r2).equals(BigInteger.ONE) == false) goto L33;
            return new JwtRsaSsaPssPrivateKey(this.publicKey.get(), this.p.get(), this.q.get(), this.d.get(), this.dP.get(), this.dQ.get(), this.qInv.get(), null);
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
            throw new GeneralSecurityException("Cannot build without a RSA SSA PSS public key");
        }
    }

    /* synthetic */ JwtRsaSsaPssPrivateKey(JwtRsaSsaPssPublicKey r1, SecretBigInteger r2, SecretBigInteger r3, SecretBigInteger r4, SecretBigInteger r5, SecretBigInteger r6, SecretBigInteger r7, AnonymousClass1 r8) {
        this(r1, r2, r3, r4, r5, r6, r7);
    }

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

    private JwtRsaSsaPssPrivateKey(JwtRsaSsaPssPublicKey publicKey, SecretBigInteger p, SecretBigInteger q, SecretBigInteger d, SecretBigInteger dP, SecretBigInteger dQ, SecretBigInteger qInv) {
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

    @Override // com.google.crypto.tink.jwt.JwtSignaturePrivateKey, com.google.crypto.tink.Key
    public JwtRsaSsaPssParameters getParameters() {
        return this.publicKey.getParameters();
    }

    @Override // com.google.crypto.tink.jwt.JwtSignaturePrivateKey, com.google.crypto.tink.PrivateKey
    public JwtRsaSsaPssPublicKey getPublicKey() {
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
        if ((o instanceof JwtRsaSsaPssPrivateKey) == true) goto L5;
        return false;
    L5:
        JwtRsaSsaPssPrivateKey r4 = (JwtRsaSsaPssPrivateKey) o;
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
