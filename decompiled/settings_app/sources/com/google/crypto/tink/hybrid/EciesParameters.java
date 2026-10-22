package com.google.crypto.tink.hybrid;

import com.google.crypto.tink.Parameters;
import com.google.crypto.tink.aead.AesCtrHmacAeadParameters;
import com.google.crypto.tink.aead.AesGcmParameters;
import com.google.crypto.tink.aead.XChaCha20Poly1305Parameters;
import com.google.crypto.tink.daead.AesSivParameters;
import com.google.crypto.tink.internal.TinkBugException;
import com.google.crypto.tink.util.Bytes;
import com.google.errorprone.annotations.Immutable;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class EciesParameters extends HybridParameters {
    private static final Set<Parameters> acceptedDemParameters = null;
    private final CurveType curveType;
    private final Parameters demParameters;
    private final HashType hashType;

    @Nullable
    private final PointFormat nistCurvePointFormat;

    @Nullable
    private final Bytes salt;
    private final Variant variant;

    /* JADX INFO: renamed from: com.google.crypto.tink.hybrid.EciesParameters$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public static final class Builder {
        private CurveType curveType;
        private Parameters demParameters;
        private HashType hashType;
        private PointFormat nistCurvePointFormat;

        @Nullable
        private Bytes salt;
        private Variant variant;

        /* synthetic */ Builder(AnonymousClass1 r1) {
            this();
        }

        private Builder() {
            this.curveType = null;
            this.hashType = null;
            this.nistCurvePointFormat = null;
            this.demParameters = null;
            this.variant = Variant.NO_PREFIX;
            this.salt = null;
        }

        public Builder setCurveType(CurveType curveType) {
            this.curveType = curveType;
            return this;
        }

        public Builder setHashType(HashType hashType) {
            this.hashType = hashType;
            return this;
        }

        public Builder setNistCurvePointFormat(PointFormat pointFormat) {
            this.nistCurvePointFormat = pointFormat;
            return this;
        }

        public Builder setDemParameters(Parameters demParameters) throws GeneralSecurityException {
            if (EciesParameters.access$000().contains(demParameters) == false) goto L7;
            this.demParameters = demParameters;
            return this;
        L7:
            throw new GeneralSecurityException("Invalid DEM parameters " + demParameters + "; only AES128_GCM_RAW, AES256_GCM_RAW, AES128_CTR_HMAC_SHA256_RAW, AES256_CTR_HMAC_SHA256_RAW XCHACHA20_POLY1305_RAW and AES256_SIV_RAW are currently supported.");
        }

        public Builder setVariant(Variant variant) {
            this.variant = variant;
            return this;
        }

        public Builder setSalt(Bytes salt) {
            if (salt.size() != 0) goto L6;
            this.salt = null;
            return this;
        L6:
            this.salt = salt;
            return this;
        }

        public EciesParameters build() throws GeneralSecurityException {
            CurveType r0 = this.curveType;
            if (r0 == null) goto L33;
            if (this.hashType == null) goto L31;
            if (this.demParameters == null) goto L29;
            if (this.variant == null) goto L27;
            if (r0 == CurveType.X25519) goto L18;
            if (this.nistCurvePointFormat != null) goto L18;
            throw new GeneralSecurityException("Point format is not set");
        L18:
            if (this.curveType != CurveType.X25519) goto L25;
            if (this.nistCurvePointFormat == null) goto L25;
            throw new GeneralSecurityException("For Curve25519 point format must not be set");
        L25:
            return new EciesParameters(this.curveType, this.hashType, this.nistCurvePointFormat, this.demParameters, this.variant, this.salt, null);
        L27:
            throw new GeneralSecurityException("Variant is not set");
        L29:
            throw new GeneralSecurityException("DEM parameters are not set");
        L31:
            throw new GeneralSecurityException("Hash type is not set");
        L33:
            throw new GeneralSecurityException("Elliptic curve type is not set");
        }
    }

    @Immutable
    public static final class CurveType {
        public static final CurveType NIST_P256 = null;
        public static final CurveType NIST_P384 = null;
        public static final CurveType NIST_P521 = null;
        public static final CurveType X25519 = null;
        private final String name;

        static {
            NIST_P256 = new CurveType("NIST_P256");
            NIST_P384 = new CurveType("NIST_P384");
            NIST_P521 = new CurveType("NIST_P521");
            X25519 = new CurveType("X25519");
        }

        private CurveType(String name) {
            this.name = name;
        }

        public String toString() {
            return this.name;
        }
    }

    @Immutable
    public static final class HashType {
        public static final HashType SHA1 = null;
        public static final HashType SHA224 = null;
        public static final HashType SHA256 = null;
        public static final HashType SHA384 = null;
        public static final HashType SHA512 = null;
        private final String name;

        static {
            SHA1 = new HashType("SHA1");
            SHA224 = new HashType("SHA224");
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
    public static final class PointFormat {
        public static final PointFormat COMPRESSED = null;
        public static final PointFormat LEGACY_UNCOMPRESSED = null;
        public static final PointFormat UNCOMPRESSED = null;
        private final String name;

        static {
            COMPRESSED = new PointFormat("COMPRESSED");
            UNCOMPRESSED = new PointFormat("UNCOMPRESSED");
            LEGACY_UNCOMPRESSED = new PointFormat("LEGACY_UNCOMPRESSED");
        }

        private PointFormat(String name) {
            this.name = name;
        }

        public String toString() {
            return this.name;
        }
    }

    @Immutable
    public static final class Variant {
        public static final Variant CRUNCHY = null;
        public static final Variant NO_PREFIX = null;
        public static final Variant TINK = null;
        private final String name;

        static {
            TINK = new Variant("TINK");
            CRUNCHY = new Variant("CRUNCHY");
            NO_PREFIX = new Variant("NO_PREFIX");
        }

        private Variant(String name) {
            this.name = name;
        }

        public String toString() {
            return this.name;
        }
    }

    /* synthetic */ EciesParameters(CurveType r1, HashType r2, PointFormat r3, Parameters r4, Variant r5, Bytes r6, AnonymousClass1 r7) {
        this(r1, r2, r3, r4, r5, r6);
    }

    static /* synthetic */ Set access$000() {
        return acceptedDemParameters;
    }

    private static Set<Parameters> listAcceptedDemParameters() throws GeneralSecurityException {
        HashSet r0 = new HashSet();
        r0.add(AesGcmParameters.builder().setIvSizeBytes(12).setKeySizeBytes(16).setTagSizeBytes(16).setVariant(AesGcmParameters.Variant.NO_PREFIX).build());
        r0.add(AesGcmParameters.builder().setIvSizeBytes(12).setKeySizeBytes(32).setTagSizeBytes(16).setVariant(AesGcmParameters.Variant.NO_PREFIX).build());
        r0.add(AesCtrHmacAeadParameters.builder().setAesKeySizeBytes(16).setHmacKeySizeBytes(32).setTagSizeBytes(16).setIvSizeBytes(16).setHashType(AesCtrHmacAeadParameters.HashType.SHA256).setVariant(AesCtrHmacAeadParameters.Variant.NO_PREFIX).build());
        r0.add(AesCtrHmacAeadParameters.builder().setAesKeySizeBytes(32).setHmacKeySizeBytes(32).setTagSizeBytes(32).setIvSizeBytes(16).setHashType(AesCtrHmacAeadParameters.HashType.SHA256).setVariant(AesCtrHmacAeadParameters.Variant.NO_PREFIX).build());
        r0.add(XChaCha20Poly1305Parameters.create());
        r0.add(AesSivParameters.builder().setKeySizeBytes(64).setVariant(AesSivParameters.Variant.NO_PREFIX).build());
        return Collections.unmodifiableSet(r0);
    }

    static {
        acceptedDemParameters = (Set) TinkBugException.exceptionIsBug(new EciesParameters$$ExternalSyntheticLambda0());
    }

    static /* synthetic */ Set lambda$static$0() throws Exception {
        return listAcceptedDemParameters();
    }

    private EciesParameters(CurveType curveType, HashType hashType, @Nullable PointFormat pointFormat, Parameters demParameters, Variant variant, Bytes salt) {
        this.curveType = curveType;
        this.hashType = hashType;
        this.nistCurvePointFormat = pointFormat;
        this.demParameters = demParameters;
        this.variant = variant;
        this.salt = salt;
    }

    public static Builder builder() {
        return new Builder(null);
    }

    public CurveType getCurveType() {
        return this.curveType;
    }

    public HashType getHashType() {
        return this.hashType;
    }

    @Nullable
    public PointFormat getNistCurvePointFormat() {
        return this.nistCurvePointFormat;
    }

    public Parameters getDemParameters() {
        return this.demParameters;
    }

    public Variant getVariant() {
        return this.variant;
    }

    @Nullable
    public Bytes getSalt() {
        return this.salt;
    }

    @Override // com.google.crypto.tink.Parameters
    public boolean hasIdRequirement() {
        if (this.variant == Variant.NO_PREFIX) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean equals(Object o) {
        if ((o instanceof EciesParameters) == true) goto L5;
        return false;
    L5:
        EciesParameters r4 = (EciesParameters) o;
        if (Objects.equals(r4.getCurveType(), getCurveType()) == true) goto L8;
        return false;
    L8:
        if (Objects.equals(r4.getHashType(), getHashType()) == true) goto L10;
        return false;
    L10:
        if (Objects.equals(r4.getNistCurvePointFormat(), getNistCurvePointFormat()) == true) goto L12;
        return false;
    L12:
        if (Objects.equals(r4.getDemParameters(), getDemParameters()) == true) goto L14;
        return false;
    L14:
        if (Objects.equals(r4.getVariant(), getVariant()) == true) goto L16;
        return false;
    L16:
        if (Objects.equals(r4.getSalt(), getSalt()) == false) goto L24;
        return true;
    L24:
        return false;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{EciesParameters.class, this.curveType, this.hashType, this.nistCurvePointFormat, this.demParameters, this.variant, this.salt});
    }

    public String toString() {
        return String.format("EciesParameters(curveType=%s, hashType=%s, pointFormat=%s, demParameters=%s, variant=%s, salt=%s)", new Object[]{this.curveType, this.hashType, this.nistCurvePointFormat, this.demParameters, this.variant, this.salt});
    }
}
