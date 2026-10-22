package com.google.crypto.tink.signature;

import com.google.errorprone.annotations.Immutable;
import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.util.Objects;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class RsaSsaPssParameters extends SignatureParameters {
    public static final BigInteger F4 = null;
    private final HashType mgf1HashType;
    private final int modulusSizeBits;
    private final BigInteger publicExponent;
    private final int saltLengthBytes;
    private final HashType sigHashType;
    private final Variant variant;

    /* JADX INFO: renamed from: com.google.crypto.tink.signature.RsaSsaPssParameters$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public static final class Builder {
        private static final int MIN_RSA_MODULUS_SIZE = 2048;
        private static final BigInteger PUBLIC_EXPONENT_UPPER_BOUND = null;
        private static final BigInteger TWO = null;

        @Nullable
        private HashType mgf1HashType;

        @Nullable
        private Integer modulusSizeBits;

        @Nullable
        private BigInteger publicExponent;

        @Nullable
        private Integer saltLengthBytes;

        @Nullable
        private HashType sigHashType;
        private Variant variant;

        /* synthetic */ Builder(AnonymousClass1 r1) {
            this();
        }

        private Builder() {
            this.modulusSizeBits = null;
            this.publicExponent = RsaSsaPssParameters.F4;
            this.sigHashType = null;
            this.mgf1HashType = null;
            this.saltLengthBytes = null;
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

        public Builder setSigHashType(HashType sigHashType) {
            this.sigHashType = sigHashType;
            return this;
        }

        public Builder setMgf1HashType(HashType mgf1HashType) {
            this.mgf1HashType = mgf1HashType;
            return this;
        }

        public Builder setSaltLengthBytes(int saltLengthBytes) throws GeneralSecurityException {
            if (saltLengthBytes < 0) goto L6;
            this.saltLengthBytes = Integer.valueOf(saltLengthBytes);
            return this;
        L6:
            throw new GeneralSecurityException(String.format("Invalid salt length in bytes %d; salt length must be positive", new Object[]{Integer.valueOf(saltLengthBytes)}));
        }

        static {
            BigInteger r0 = BigInteger.valueOf(2);
            TWO = r0;
            PUBLIC_EXPONENT_UPPER_BOUND = r0.pow(256);
        }

        private void validatePublicExponent(BigInteger publicExponent) throws InvalidAlgorithmParameterException {
            int r1 = publicExponent.compareTo(RsaSsaPssParameters.F4);
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

        public RsaSsaPssParameters build() throws GeneralSecurityException {
            Integer r0 = this.modulusSizeBits;
            if (r0 == null) goto L35;
            if (this.publicExponent == null) goto L33;
            if (this.sigHashType == null) goto L31;
            if (this.mgf1HashType == null) goto L29;
            if (this.variant == null) goto L27;
            if (this.saltLengthBytes == null) goto L25;
            if (r0.intValue() < 2048) goto L23;
            if (this.sigHashType != this.mgf1HashType) goto L21;
            validatePublicExponent(this.publicExponent);
            return new RsaSsaPssParameters(this.modulusSizeBits.intValue(), this.publicExponent, this.variant, this.sigHashType, this.mgf1HashType, this.saltLengthBytes.intValue(), null);
        L21:
            throw new GeneralSecurityException("MGF1 hash is different from signature hash");
        L23:
            throw new InvalidAlgorithmParameterException(String.format("Invalid key size in bytes %d; must be at least %d bits", new Object[]{this.modulusSizeBits, 2048}));
        L25:
            throw new GeneralSecurityException("salt length is not set");
        L27:
            throw new GeneralSecurityException("variant is not set");
        L29:
            throw new GeneralSecurityException("mgf1 hash type is not set");
        L31:
            throw new GeneralSecurityException("signature hash type is not set");
        L33:
            throw new GeneralSecurityException("publicExponent is not set");
        L35:
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

    /* synthetic */ RsaSsaPssParameters(int r1, BigInteger r2, Variant r3, HashType r4, HashType r5, int r6, AnonymousClass1 r7) {
        this(r1, r2, r3, r4, r5, r6);
    }

    static {
        F4 = BigInteger.valueOf(65537);
    }

    private RsaSsaPssParameters(int modulusSizeBits, BigInteger publicExponent, Variant variant, HashType sigHashType, HashType mgf1HashType, int saltLengthBytes) {
        this.modulusSizeBits = modulusSizeBits;
        this.publicExponent = publicExponent;
        this.variant = variant;
        this.sigHashType = sigHashType;
        this.mgf1HashType = mgf1HashType;
        this.saltLengthBytes = saltLengthBytes;
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

    public HashType getSigHashType() {
        return this.sigHashType;
    }

    public HashType getMgf1HashType() {
        return this.mgf1HashType;
    }

    public int getSaltLengthBytes() {
        return this.saltLengthBytes;
    }

    public boolean equals(Object o) {
        if ((o instanceof RsaSsaPssParameters) == true) goto L5;
        return false;
    L5:
        RsaSsaPssParameters r4 = (RsaSsaPssParameters) o;
        if (r4.getModulusSizeBits() == getModulusSizeBits()) goto L8;
        return false;
    L8:
        if (Objects.equals(r4.getPublicExponent(), getPublicExponent()) == true) goto L10;
        return false;
    L10:
        if (Objects.equals(r4.getVariant(), getVariant()) == true) goto L12;
        return false;
    L12:
        if (Objects.equals(r4.getSigHashType(), getSigHashType()) == true) goto L14;
        return false;
    L14:
        if (Objects.equals(r4.getMgf1HashType(), getMgf1HashType()) == true) goto L16;
        return false;
    L16:
        if (r4.getSaltLengthBytes() != getSaltLengthBytes()) goto L24;
        return true;
    L24:
        return false;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{RsaSsaPssParameters.class, Integer.valueOf(this.modulusSizeBits), this.publicExponent, this.variant, this.sigHashType, this.mgf1HashType, Integer.valueOf(this.saltLengthBytes)});
    }

    @Override // com.google.crypto.tink.Parameters
    public boolean hasIdRequirement() {
        if (this.variant == Variant.NO_PREFIX) goto L5;
        return true;
    L5:
        return false;
    }

    public String toString() {
        return "RSA SSA PSS Parameters (variant: " + this.variant + ", signature hashType: " + this.sigHashType + ", mgf1 hashType: " + this.mgf1HashType + ", saltLengthBytes: " + this.saltLengthBytes + ", publicExponent: " + this.publicExponent + ", and " + this.modulusSizeBits + "-bit modulus)";
    }
}
