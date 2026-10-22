package com.google.crypto.tink.jwt;

import com.google.crypto.tink.internal.EllipticCurvesUtil;
import com.google.errorprone.annotations.Immutable;
import java.security.GeneralSecurityException;
import java.security.spec.ECParameterSpec;
import java.util.Objects;
import java.util.Optional;

/* JADX INFO: loaded from: classes4.dex */
public final class JwtEcdsaParameters extends JwtSignatureParameters {
    private final Algorithm algorithm;
    private final KidStrategy kidStrategy;

    /* JADX INFO: renamed from: com.google.crypto.tink.jwt.JwtEcdsaParameters$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    @Immutable
    public static final class Algorithm {
        public static final Algorithm ES256 = null;
        public static final Algorithm ES384 = null;
        public static final Algorithm ES512 = null;
        private final ECParameterSpec ecParameterSpec;
        private final String name;

        static {
            ES256 = new Algorithm("ES256", EllipticCurvesUtil.NIST_P256_PARAMS);
            ES384 = new Algorithm("ES384", EllipticCurvesUtil.NIST_P384_PARAMS);
            ES512 = new Algorithm("ES512", EllipticCurvesUtil.NIST_P521_PARAMS);
        }

        private Algorithm(String name, ECParameterSpec ecParameterSpec) {
            this.name = name;
            this.ecParameterSpec = ecParameterSpec;
        }

        public String toString() {
            return this.name;
        }

        public String getStandardName() {
            return this.name;
        }

        ECParameterSpec getECParameterSpec() {
            return this.ecParameterSpec;
        }
    }

    public static final class Builder {
        Optional<Algorithm> algorithm;
        Optional<KidStrategy> kidStrategy;

        /* synthetic */ Builder(AnonymousClass1 r1) {
            this();
        }

        public Builder setKidStrategy(KidStrategy kidStrategy) {
            this.kidStrategy = Optional.of(kidStrategy);
            return this;
        }

        public Builder setAlgorithm(Algorithm algorithm) {
            this.algorithm = Optional.of(algorithm);
            return this;
        }

        public JwtEcdsaParameters build() throws GeneralSecurityException {
            if (this.algorithm.isPresent() == false) goto L11;
            if (this.kidStrategy.isPresent() == false) goto L9;
            return new JwtEcdsaParameters(this.kidStrategy.get(), this.algorithm.get(), null);
        L9:
            throw new GeneralSecurityException("KidStrategy must be set");
        L11:
            throw new GeneralSecurityException("Algorithm must be set");
        }

        private Builder() {
            this.kidStrategy = Optional.empty();
            this.algorithm = Optional.empty();
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

    /* synthetic */ JwtEcdsaParameters(KidStrategy r1, Algorithm r2, AnonymousClass1 r3) {
        this(r1, r2);
    }

    public static Builder builder() {
        return new Builder(null);
    }

    private JwtEcdsaParameters(KidStrategy kidStrategy, Algorithm algorithm) {
        this.kidStrategy = kidStrategy;
        this.algorithm = algorithm;
    }

    public KidStrategy getKidStrategy() {
        return this.kidStrategy;
    }

    public Algorithm getAlgorithm() {
        return this.algorithm;
    }

    @Override // com.google.crypto.tink.Parameters
    public boolean hasIdRequirement() {
        return this.kidStrategy.equals(KidStrategy.BASE64_ENCODED_KEY_ID);
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
        if ((o instanceof JwtEcdsaParameters) == true) goto L5;
        return false;
    L5:
        JwtEcdsaParameters r4 = (JwtEcdsaParameters) o;
        if (r4.kidStrategy.equals(this.kidStrategy) == true) goto L8;
        return false;
    L8:
        if (r4.algorithm.equals(this.algorithm) == false) goto L12;
        return true;
    L12:
        return false;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{JwtEcdsaParameters.class, this.kidStrategy, this.algorithm});
    }

    public String toString() {
        return "JWT ECDSA Parameters (kidStrategy: " + this.kidStrategy + ", Algorithm " + this.algorithm + ")";
    }
}
