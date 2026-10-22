package com.google.crypto.tink.hybrid;

import com.google.errorprone.annotations.Immutable;
import java.security.GeneralSecurityException;
import java.util.Objects;

/* JADX INFO: loaded from: classes4.dex */
public final class HpkeParameters extends HybridParameters {
    private final AeadId aead;
    private final KdfId kdf;
    private final KemId kem;
    private final Variant variant;

    /* JADX INFO: renamed from: com.google.crypto.tink.hybrid.HpkeParameters$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    @Immutable
    public static final class AeadId extends AlgorithmIdentifier {
        public static final AeadId AES_128_GCM = null;
        public static final AeadId AES_256_GCM = null;
        public static final AeadId CHACHA20_POLY1305 = null;

        @Override // com.google.crypto.tink.hybrid.HpkeParameters.AlgorithmIdentifier
        public /* bridge */ /* synthetic */ int getValue() {
            return super.getValue();
        }

        @Override // com.google.crypto.tink.hybrid.HpkeParameters.AlgorithmIdentifier
        public /* bridge */ /* synthetic */ String toString() {
            return super.toString();
        }

        static {
            AES_128_GCM = new AeadId("AES_128_GCM", 1);
            AES_256_GCM = new AeadId("AES_256_GCM", 2);
            CHACHA20_POLY1305 = new AeadId("CHACHA20_POLY1305", 3);
        }

        private AeadId(String name, int value) {
            super(name, value, null);
        }
    }

    @Immutable
    private static class AlgorithmIdentifier {
        protected final String name;
        protected final int value;

        /* synthetic */ AlgorithmIdentifier(String r1, int r2, AnonymousClass1 r3) {
            this(r1, r2);
        }

        private AlgorithmIdentifier(String name, int value) {
            this.name = name;
            this.value = value;
        }

        public int getValue() {
            return this.value;
        }

        public String toString() {
            return String.format("%s(0x%04x)", new Object[]{this.name, Integer.valueOf(this.value)});
        }
    }

    public static final class Builder {
        private AeadId aead;
        private KdfId kdf;
        private KemId kem;
        private Variant variant;

        /* synthetic */ Builder(AnonymousClass1 r1) {
            this();
        }

        private Builder() {
            this.kem = null;
            this.kdf = null;
            this.aead = null;
            this.variant = Variant.NO_PREFIX;
        }

        public Builder setKemId(KemId kem) {
            this.kem = kem;
            return this;
        }

        public Builder setKdfId(KdfId kdf) {
            this.kdf = kdf;
            return this;
        }

        public Builder setAeadId(AeadId aead) {
            this.aead = aead;
            return this;
        }

        public Builder setVariant(Variant variant) {
            this.variant = variant;
            return this;
        }

        public HpkeParameters build() throws GeneralSecurityException {
            if (this.kem == null) goto L19;
            if (this.kdf == null) goto L17;
            if (this.aead == null) goto L15;
            if (this.variant == null) goto L13;
            return new HpkeParameters(this.kem, this.kdf, this.aead, this.variant, null);
        L13:
            throw new GeneralSecurityException("HPKE variant is not set");
        L15:
            throw new GeneralSecurityException("HPKE AEAD parameter is not set");
        L17:
            throw new GeneralSecurityException("HPKE KDF parameter is not set");
        L19:
            throw new GeneralSecurityException("HPKE KEM parameter is not set");
        }
    }

    @Immutable
    public static final class KdfId extends AlgorithmIdentifier {
        public static final KdfId HKDF_SHA256 = null;
        public static final KdfId HKDF_SHA384 = null;
        public static final KdfId HKDF_SHA512 = null;

        @Override // com.google.crypto.tink.hybrid.HpkeParameters.AlgorithmIdentifier
        public /* bridge */ /* synthetic */ int getValue() {
            return super.getValue();
        }

        @Override // com.google.crypto.tink.hybrid.HpkeParameters.AlgorithmIdentifier
        public /* bridge */ /* synthetic */ String toString() {
            return super.toString();
        }

        static {
            HKDF_SHA256 = new KdfId("HKDF_SHA256", 1);
            HKDF_SHA384 = new KdfId("HKDF_SHA384", 2);
            HKDF_SHA512 = new KdfId("HKDF_SHA512", 3);
        }

        private KdfId(String name, int value) {
            super(name, value, null);
        }
    }

    @Immutable
    public static final class KemId extends AlgorithmIdentifier {
        public static final KemId DHKEM_P256_HKDF_SHA256 = null;
        public static final KemId DHKEM_P384_HKDF_SHA384 = null;
        public static final KemId DHKEM_P521_HKDF_SHA512 = null;
        public static final KemId DHKEM_X25519_HKDF_SHA256 = null;

        @Override // com.google.crypto.tink.hybrid.HpkeParameters.AlgorithmIdentifier
        public /* bridge */ /* synthetic */ int getValue() {
            return super.getValue();
        }

        @Override // com.google.crypto.tink.hybrid.HpkeParameters.AlgorithmIdentifier
        public /* bridge */ /* synthetic */ String toString() {
            return super.toString();
        }

        static {
            DHKEM_P256_HKDF_SHA256 = new KemId("DHKEM_P256_HKDF_SHA256", 16);
            DHKEM_P384_HKDF_SHA384 = new KemId("DHKEM_P384_HKDF_SHA384", 17);
            DHKEM_P521_HKDF_SHA512 = new KemId("DHKEM_P521_HKDF_SHA512", 18);
            DHKEM_X25519_HKDF_SHA256 = new KemId("DHKEM_X25519_HKDF_SHA256", 32);
        }

        private KemId(String name, int value) {
            super(name, value, null);
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

    /* synthetic */ HpkeParameters(KemId r1, KdfId r2, AeadId r3, Variant r4, AnonymousClass1 r5) {
        this(r1, r2, r3, r4);
    }

    private HpkeParameters(KemId kem, KdfId kdf, AeadId aead, Variant variant) {
        this.kem = kem;
        this.kdf = kdf;
        this.aead = aead;
        this.variant = variant;
    }

    public static Builder builder() {
        return new Builder(null);
    }

    public KemId getKemId() {
        return this.kem;
    }

    public KdfId getKdfId() {
        return this.kdf;
    }

    public AeadId getAeadId() {
        return this.aead;
    }

    public Variant getVariant() {
        return this.variant;
    }

    @Override // com.google.crypto.tink.Parameters
    public boolean hasIdRequirement() {
        if (this.variant == Variant.NO_PREFIX) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean equals(Object o) {
        if ((o instanceof HpkeParameters) == true) goto L5;
        return false;
    L5:
        HpkeParameters r4 = (HpkeParameters) o;
        if (this.kem == r4.kem) goto L8;
        return false;
    L8:
        if (this.kdf == r4.kdf) goto L10;
        return false;
    L10:
        if (this.aead == r4.aead) goto L12;
        return false;
    L12:
        if (this.variant != r4.variant) goto L18;
        return true;
    L18:
        return false;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{HpkeParameters.class, this.kem, this.kdf, this.aead, this.variant});
    }
}
