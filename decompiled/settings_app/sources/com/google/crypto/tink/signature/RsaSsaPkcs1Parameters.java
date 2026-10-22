package com.google.crypto.tink.signature;

import com.google.errorprone.annotations.Immutable;
import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.util.Objects;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class RsaSsaPkcs1Parameters extends SignatureParameters {
    public static final BigInteger F4 = null;
    private final HashType hashType;
    private final int modulusSizeBits;
    private final BigInteger publicExponent;
    private final Variant variant;

    /* JADX INFO: renamed from: com.google.crypto.tink.signature.RsaSsaPkcs1Parameters$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public static final class Builder {
        private static final BigInteger PUBLIC_EXPONENT_UPPER_BOUND = null;
        private static final BigInteger TWO = null;

        @Nullable
        private HashType hashType;

        @Nullable
        private Integer modulusSizeBits;

        @Nullable
        private BigInteger publicExponent;
        private Variant variant;

        /* synthetic */ Builder(AnonymousClass1 r1) {
            this();
        }

        private Builder() {
            this.modulusSizeBits = null;
            this.publicExponent = RsaSsaPkcs1Parameters.F4;
            this.hashType = null;
            this.variant = Variant.NO_PREFIX;
        }

        public Builder setModulusSizeBits(int modulusSizeBits) {
            this.modulusSizeBits = Integer.valueOf(modulusSizeBits);
            return this;
        }

        public Builder setPublicExponent(BigInteger e) {
            this.publicExponent = e;
            return this;
        }

        public Builder setVariant(Variant variant) {
            this.variant = variant;
            return this;
        }

        public Builder setHashType(HashType hashType) {
            this.hashType = hashType;
            return this;
        }

        static {
            BigInteger r0 = BigInteger.valueOf(2);
            TWO = r0;
            PUBLIC_EXPONENT_UPPER_BOUND = r0.pow(256);
        }

        private void validatePublicExponent(BigInteger publicExponent) throws InvalidAlgorithmParameterException {
            int r1 = publicExponent.compareTo(RsaSsaPkcs1Parameters.F4);
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

        public RsaSsaPkcs1Parameters build() throws GeneralSecurityException {
            Integer r0 = this.modulusSizeBits;
            if (r0 == null) goto L23;
            if (this.publicExponent == null) goto L21;
            if (this.hashType == null) goto L19;
            if (this.variant == null) goto L17;
            if (r0.intValue() < 2048) goto L15;
            validatePublicExponent(this.publicExponent);
            return new RsaSsaPkcs1Parameters(this.modulusSizeBits.intValue(), this.publicExponent, this.variant, this.hashType, null);
        L15:
            throw new InvalidAlgorithmParameterException(String.format("Invalid key size in bytes %d; must be at least 2048 bits", new Object[]{this.modulusSizeBits}));
        L17:
            throw new GeneralSecurityException("variant is not set");
        L19:
            throw new GeneralSecurityException("hash type is not set");
        L21:
            throw new GeneralSecurityException("publicExponent is not set");
        L23:
            throw new GeneralSecurityException("key size is not set");
        }
    }

    @Immutable
    public static final class HashType {
        public static final HashType SHA256 = null;
        public static final HashType SHA384 = null;
        public static final HashType SHA512 = null;
        private final String name;

        static {
            SHA256 = new HashType("SHA256");
            SHA384 = new HashType("SHA384");
            SHA512 = new HashType("SHA512");
        }

        private HashType(String name) {
            this.name = name;
        }

        public String toString() {
            return this.name;
        }
    }

    @Immutable
    public static final class Variant {
        public static final Variant CRUNCHY = null;
        public static final Variant LEGACY = null;
        public static final Variant NO_PREFIX = null;
        public static final Variant TINK = null;
        private final String name;

        static {
            TINK = new Variant("TINK");
            CRUNCHY = new Variant("CRUNCHY");
            LEGACY = new Variant("LEGACY");
            NO_PREFIX = new Variant("NO_PREFIX");
        }

        private Variant(String name) {
            this.name = name;
        }

        public String toString() {
            return this.name;
        }
    }

    /* synthetic */ RsaSsaPkcs1Parameters(int r1, BigInteger r2, Variant r3, HashType r4, AnonymousClass1 r5) {
        this(r1, r2, r3, r4);
    }

    static {
        F4 = BigInteger.valueOf(65537);
    }

    private RsaSsaPkcs1Parameters(int modulusSizeBits, BigInteger publicExponent, Variant variant, HashType hashType) {
        this.modulusSizeBits = modulusSizeBits;
        this.publicExponent = publicExponent;
        this.variant = variant;
        this.hashType = hashType;
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

    public Variant getVariant() {
        return this.variant;
    }

    public HashType getHashType() {
        return this.hashType;
    }

    public boolean equals(Object o) {
        if ((o instanceof RsaSsaPkcs1Parameters) == true) goto L5;
        return false;
    L5:
        RsaSsaPkcs1Parameters r4 = (RsaSsaPkcs1Parameters) o;
        if (r4.getModulusSizeBits() == getModulusSizeBits()) goto L8;
        return false;
    L8:
        if (Objects.equals(r4.getPublicExponent(), getPublicExponent()) == true) goto L10;
        return false;
    L10:
        if (r4.getVariant() == getVariant()) goto L12;
        return false;
    L12:
        if (r4.getHashType() != getHashType()) goto L18;
        return true;
    L18:
        return false;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{RsaSsaPkcs1Parameters.class, Integer.valueOf(this.modulusSizeBits), this.publicExponent, this.variant, this.hashType});
    }

    @Override // com.google.crypto.tink.Parameters
    public boolean hasIdRequirement() {
        if (this.variant == Variant.NO_PREFIX) goto L5;
        return true;
    L5:
        return false;
    }

    public String toString() {
        return "RSA SSA PKCS1 Parameters (variant: " + this.variant + ", hashType: " + this.hashType + ", publicExponent: " + this.publicExponent + ", and " + this.modulusSizeBits + "-bit modulus)";
    }
}
