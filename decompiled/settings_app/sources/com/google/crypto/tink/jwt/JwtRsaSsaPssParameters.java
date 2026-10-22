package com.google.crypto.tink.jwt;

import com.google.errorprone.annotations.Immutable;
import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.util.Objects;
import java.util.Optional;

/* JADX INFO: loaded from: classes4.dex */
public final class JwtRsaSsaPssParameters extends JwtSignatureParameters {
    public static final BigInteger F4 = null;
    private final Algorithm algorithm;
    private final KidStrategy kidStrategy;
    private final int modulusSizeBits;
    private final BigInteger publicExponent;

    /* JADX INFO: renamed from: com.google.crypto.tink.jwt.JwtRsaSsaPssParameters$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    @Immutable
    public static final class Algorithm {
        public static final Algorithm PS256 = null;
        public static final Algorithm PS384 = null;
        public static final Algorithm PS512 = null;
        private final String name;

        static {
            PS256 = new Algorithm("PS256");
            PS384 = new Algorithm("PS384");
            PS512 = new Algorithm("PS512");
        }

        private Algorithm(String name) {
            this.name = name;
        }

        public String toString() {
            return this.name;
        }

        public String getStandardName() {
            return this.name;
        }
    }

    public static final class Builder {
        private static final BigInteger PUBLIC_EXPONENT_UPPER_BOUND = null;
        private static final BigInteger TWO = null;
        Optional<Algorithm> algorithm;
        Optional<KidStrategy> kidStrategy;
        Optional<Integer> modulusSizeBits;
        Optional<BigInteger> publicExponent;

        /* synthetic */ Builder(AnonymousClass1 r1) {
            this();
        }

        private Builder() {
            this.modulusSizeBits = Optional.empty();
            this.publicExponent = Optional.of(JwtRsaSsaPssParameters.F4);
            this.kidStrategy = Optional.empty();
            this.algorithm = Optional.empty();
        }

        public Builder setModulusSizeBits(int modulusSizeBits) {
            this.modulusSizeBits = Optional.of(Integer.valueOf(modulusSizeBits));
            return this;
        }

        public Builder setPublicExponent(BigInteger e) {
            this.publicExponent = Optional.of(e);
            return this;
        }

        public Builder setKidStrategy(KidStrategy kidStrategy) {
            this.kidStrategy = Optional.of(kidStrategy);
            return this;
        }

        public Builder setAlgorithm(Algorithm algorithm) {
            this.algorithm = Optional.of(algorithm);
            return this;
        }

        static {
            BigInteger r0 = BigInteger.valueOf(2);
            TWO = r0;
            PUBLIC_EXPONENT_UPPER_BOUND = r0.pow(256);
        }

        private void validatePublicExponent(BigInteger publicExponent) throws InvalidAlgorithmParameterException {
            int r1 = publicExponent.compareTo(JwtRsaSsaPssParameters.F4);
            if (r1 != 0) goto L5;
            return;
        L5:
            if (r1 < 0) goto L16;
            if (publicExponent.mod(TWO).equals(BigInteger.ZERO) == true) goto L14;
            if (publicExponent.compareTo(PUBLIC_EXPONENT_UPPER_BOUND) > 0) goto L12;
            return;
        L12:
            throw new InvalidAlgorithmParameterException("Public exponent cannot be larger than 2^256.");
        L14:
            throw new InvalidAlgorithmParameterException("Invalid public exponent");
        L16:
            throw new InvalidAlgorithmParameterException("Public exponent must be at least 65537.");
        }

        public JwtRsaSsaPssParameters build() throws GeneralSecurityException {
            if (this.modulusSizeBits.isPresent() == false) goto L23;
            if (this.publicExponent.isPresent() == false) goto L21;
            if (this.algorithm.isPresent() == false) goto L19;
            if (this.kidStrategy.isPresent() == false) goto L17;
            if (this.modulusSizeBits.get().intValue() < 2048) goto L15;
            validatePublicExponent(this.publicExponent.get());
            return new JwtRsaSsaPssParameters(this.modulusSizeBits.get().intValue(), this.publicExponent.get(), this.kidStrategy.get(), this.algorithm.get(), null);
        L15:
            throw new InvalidAlgorithmParameterException(String.format("Invalid modulus size in bits %d; must be at least 2048 bits", new Object[]{this.modulusSizeBits.get()}));
        L17:
            throw new GeneralSecurityException("KidStrategy must be set");
        L19:
            throw new GeneralSecurityException("Algorithm must be set");
        L21:
            throw new GeneralSecurityException("publicExponent is not set");
        L23:
            throw new GeneralSecurityException("key size is not set");
        }
    }

    @Immutable
    public static final class KidStrategy {
        public static final KidStrategy BASE64_ENCODED_KEY_ID = null;
        public static final KidStrategy CUSTOM = null;
        public static final KidStrategy IGNORED = null;
        private final String name;

        static {
            BASE64_ENCODED_KEY_ID = new KidStrategy("BASE64_ENCODED_KEY_ID");
            IGNORED = new KidStrategy("IGNORED");
            CUSTOM = new KidStrategy("CUSTOM");
        }

        private KidStrategy(String name) {
            this.name = name;
        }

        public String toString() {
            return this.name;
        }
    }

    /* synthetic */ JwtRsaSsaPssParameters(int r1, BigInteger r2, KidStrategy r3, Algorithm r4, AnonymousClass1 r5) {
        this(r1, r2, r3, r4);
    }

    static {
        F4 = BigInteger.valueOf(65537);
    }

    private JwtRsaSsaPssParameters(int modulusSizeBits, BigInteger publicExponent, KidStrategy kidStrategy, Algorithm algorithm) {
        this.modulusSizeBits = modulusSizeBits;
        this.publicExponent = publicExponent;
        this.kidStrategy = kidStrategy;
        this.algorithm = algorithm;
    }

    public static Builder builder() {
        return new Builder(null);
    }

    public int getModulusSizeBits() {
        return this.modulusSizeBits;
    }

    public BigInteger getPublicExponent() {
        return this.publicExponent;
    }

    public KidStrategy getKidStrategy() {
        return this.kidStrategy;
    }

    public Algorithm getAlgorithm() {
        return this.algorithm;
    }

    @Override // com.google.crypto.tink.jwt.JwtSignatureParameters
    public boolean allowKidAbsent() {
        if (this.kidStrategy.equals(KidStrategy.CUSTOM) == false) goto L5;
    L8:
        return true;
    L5:
        if (this.kidStrategy.equals(KidStrategy.IGNORED) == true) goto L8;
        return false;
    }

    public boolean equals(Object o) {
        if ((o instanceof JwtRsaSsaPssParameters) == true) goto L5;
        return false;
    L5:
        JwtRsaSsaPssParameters r4 = (JwtRsaSsaPssParameters) o;
        if (r4.getModulusSizeBits() == getModulusSizeBits()) goto L8;
        return false;
    L8:
        if (Objects.equals(r4.getPublicExponent(), getPublicExponent()) == true) goto L10;
        return false;
    L10:
        if (r4.kidStrategy.equals(this.kidStrategy) == true) goto L12;
        return false;
    L12:
        if (r4.algorithm.equals(this.algorithm) == false) goto L18;
        return true;
    L18:
        return false;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{JwtRsaSsaPssParameters.class, Integer.valueOf(this.modulusSizeBits), this.publicExponent, this.kidStrategy, this.algorithm});
    }

    @Override // com.google.crypto.tink.Parameters
    public boolean hasIdRequirement() {
        return this.kidStrategy.equals(KidStrategy.BASE64_ENCODED_KEY_ID);
    }

    public String toString() {
        return "JWT RSA SSA PSS Parameters (kidStrategy: " + this.kidStrategy + ", algorithm " + this.algorithm + ", publicExponent: " + this.publicExponent + ", and " + this.modulusSizeBits + "-bit modulus)";
    }
}
