package com.google.crypto.tink.signature;

import com.google.crypto.tink.internal.EllipticCurvesUtil;
import com.google.errorprone.annotations.Immutable;
import java.security.GeneralSecurityException;
import java.security.spec.ECParameterSpec;
import java.util.Objects;

/* JADX INFO: loaded from: classes4.dex */
public final class EcdsaParameters extends SignatureParameters {
    private final CurveType curveType;
    private final HashType hashType;
    private final SignatureEncoding signatureEncoding;
    private final Variant variant;

    /* JADX INFO: renamed from: com.google.crypto.tink.signature.EcdsaParameters$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public static final class Builder {
        private CurveType curveType;
        private HashType hashType;
        private SignatureEncoding signatureEncoding;
        private Variant variant;

        /* synthetic */ Builder(AnonymousClass1 r1) {
            this();
        }

        private Builder() {
            this.signatureEncoding = null;
            this.curveType = null;
            this.hashType = null;
            this.variant = Variant.NO_PREFIX;
        }

        public Builder setSignatureEncoding(SignatureEncoding signatureEncoding) {
            this.signatureEncoding = signatureEncoding;
            return this;
        }

        public Builder setCurveType(CurveType curveType) {
            this.curveType = curveType;
            return this;
        }

        public Builder setHashType(HashType hashType) {
            this.hashType = hashType;
            return this;
        }

        public Builder setVariant(Variant variant) {
            this.variant = variant;
            return this;
        }

        public EcdsaParameters build() throws GeneralSecurityException {
            if (this.signatureEncoding == null) goto L42;
            CurveType r0 = this.curveType;
            if (r0 == null) goto L40;
            if (this.hashType == null) goto L38;
            if (this.variant == null) goto L36;
            if (r0 != CurveType.NIST_P256) goto L18;
            if (this.hashType == HashType.SHA256) goto L18;
            throw new GeneralSecurityException("NIST_P256 requires SHA256");
        L18:
            if (this.curveType != CurveType.NIST_P384) goto L27;
            if (this.hashType == HashType.SHA384) goto L27;
            if (this.hashType == HashType.SHA512) goto L27;
            throw new GeneralSecurityException("NIST_P384 requires SHA384 or SHA512");
        L27:
            if (this.curveType != CurveType.NIST_P521) goto L34;
            if (this.hashType == HashType.SHA512) goto L34;
            throw new GeneralSecurityException("NIST_P521 requires SHA512");
        L34:
            return new EcdsaParameters(this.signatureEncoding, this.curveType, this.hashType, this.variant, null);
        L36:
            throw new GeneralSecurityException("variant is not set");
        L38:
            throw new GeneralSecurityException("hash type is not set");
        L40:
            throw new GeneralSecurityException("EC curve type is not set");
        L42:
            throw new GeneralSecurityException("signature encoding is not set");
        }
    }

    @Immutable
    public static final class CurveType {
        public static final CurveType NIST_P256 = null;
        public static final CurveType NIST_P384 = null;
        public static final CurveType NIST_P521 = null;
        private final String name;
        private final ECParameterSpec spec;

        static {
            NIST_P256 = new CurveType("NIST_P256", EllipticCurvesUtil.NIST_P256_PARAMS);
            NIST_P384 = new CurveType("NIST_P384", EllipticCurvesUtil.NIST_P384_PARAMS);
            NIST_P521 = new CurveType("NIST_P521", EllipticCurvesUtil.NIST_P521_PARAMS);
        }

        private CurveType(String name, ECParameterSpec spec) {
            this.name = name;
            this.spec = spec;
        }

        public String toString() {
            return this.name;
        }

        public ECParameterSpec toParameterSpec() {
            return this.spec;
        }

        public static CurveType fromParameterSpec(ECParameterSpec spec) throws GeneralSecurityException {
            CurveType r0 = NIST_P256;
            if (EllipticCurvesUtil.isSameEcParameterSpec(spec, r0.toParameterSpec()) == false) goto L5;
            return r0;
        L5:
            CurveType r1 = NIST_P384;
            if (EllipticCurvesUtil.isSameEcParameterSpec(spec, r1.toParameterSpec()) == false) goto L8;
            return r1;
        L8:
            CurveType r2 = NIST_P521;
            if (EllipticCurvesUtil.isSameEcParameterSpec(spec, r2.toParameterSpec()) == false) goto L12;
            return r2;
        L12:
            throw new GeneralSecurityException("unknown ECParameterSpec");
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
    public static final class SignatureEncoding {
        public static final SignatureEncoding DER = null;
        public static final SignatureEncoding IEEE_P1363 = null;
        private final String name;

        static {
            IEEE_P1363 = new SignatureEncoding("IEEE_P1363");
            DER = new SignatureEncoding("DER");
        }

        private SignatureEncoding(String name) {
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

    /* synthetic */ EcdsaParameters(SignatureEncoding r1, CurveType r2, HashType r3, Variant r4, AnonymousClass1 r5) {
        this(r1, r2, r3, r4);
    }

    private EcdsaParameters(SignatureEncoding signatureEncoding, CurveType curveType, HashType hashType, Variant variant) {
        this.signatureEncoding = signatureEncoding;
        this.curveType = curveType;
        this.hashType = hashType;
        this.variant = variant;
    }

    public static Builder builder() {
        return new Builder(null);
    }

    public SignatureEncoding getSignatureEncoding() {
        return this.signatureEncoding;
    }

    public CurveType getCurveType() {
        return this.curveType;
    }

    public HashType getHashType() {
        return this.hashType;
    }

    public Variant getVariant() {
        return this.variant;
    }

    public boolean equals(Object o) {
        if ((o instanceof EcdsaParameters) == true) goto L5;
        return false;
    L5:
        EcdsaParameters r4 = (EcdsaParameters) o;
        if (r4.getSignatureEncoding() == getSignatureEncoding()) goto L8;
        return false;
    L8:
        if (r4.getCurveType() == getCurveType()) goto L10;
        return false;
    L10:
        if (r4.getHashType() == getHashType()) goto L12;
        return false;
    L12:
        if (r4.getVariant() != getVariant()) goto L18;
        return true;
    L18:
        return false;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{EcdsaParameters.class, this.signatureEncoding, this.curveType, this.hashType, this.variant});
    }

    @Override // com.google.crypto.tink.Parameters
    public boolean hasIdRequirement() {
        if (this.variant == Variant.NO_PREFIX) goto L5;
        return true;
    L5:
        return false;
    }

    public String toString() {
        return "ECDSA Parameters (variant: " + this.variant + ", hashType: " + this.hashType + ", encoding: " + this.signatureEncoding + ", curve: " + this.curveType + ")";
    }
}
