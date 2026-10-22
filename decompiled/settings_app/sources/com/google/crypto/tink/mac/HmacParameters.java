package com.google.crypto.tink.mac;

import com.google.errorprone.annotations.Immutable;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.util.Objects;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class HmacParameters extends MacParameters {
    private final HashType hashType;
    private final int keySizeBytes;
    private final int tagSizeBytes;
    private final Variant variant;

    /* JADX INFO: renamed from: com.google.crypto.tink.mac.HmacParameters$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public static final class Builder {
        private HashType hashType;

        @Nullable
        private Integer keySizeBytes;

        @Nullable
        private Integer tagSizeBytes;
        private Variant variant;

        /* synthetic */ Builder(AnonymousClass1 r1) {
            this();
        }

        private Builder() {
            this.keySizeBytes = null;
            this.tagSizeBytes = null;
            this.hashType = null;
            this.variant = Variant.NO_PREFIX;
        }

        public Builder setKeySizeBytes(int keySizeBytes) throws GeneralSecurityException {
            this.keySizeBytes = Integer.valueOf(keySizeBytes);
            return this;
        }

        public Builder setTagSizeBytes(int tagSizeBytes) throws GeneralSecurityException {
            this.tagSizeBytes = Integer.valueOf(tagSizeBytes);
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

        private static void validateTagSizeBytes(int tagSizeBytes, HashType hashType) throws GeneralSecurityException {
            if (tagSizeBytes < 10) goto L42;
            if (hashType != HashType.SHA1) goto L12;
            if (tagSizeBytes > 20) goto L10;
            return;
        L10:
            throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; can be at most 20 bytes for SHA1", new Object[]{Integer.valueOf(tagSizeBytes)}));
        L12:
            if (hashType != HashType.SHA224) goto L19;
            if (tagSizeBytes > 28) goto L17;
            return;
        L17:
            throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; can be at most 28 bytes for SHA224", new Object[]{Integer.valueOf(tagSizeBytes)}));
        L19:
            if (hashType != HashType.SHA256) goto L26;
            if (tagSizeBytes > 32) goto L24;
            return;
        L24:
            throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; can be at most 32 bytes for SHA256", new Object[]{Integer.valueOf(tagSizeBytes)}));
        L26:
            if (hashType != HashType.SHA384) goto L33;
            if (tagSizeBytes > 48) goto L31;
            return;
        L31:
            throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; can be at most 48 bytes for SHA384", new Object[]{Integer.valueOf(tagSizeBytes)}));
        L33:
            if (hashType != HashType.SHA512) goto L40;
            if (tagSizeBytes > 64) goto L38;
            return;
        L38:
            throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; can be at most 64 bytes for SHA512", new Object[]{Integer.valueOf(tagSizeBytes)}));
        L40:
            throw new GeneralSecurityException("unknown hash type; must be SHA256, SHA384 or SHA512");
        L42:
            throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; must be at least 10 bytes", new Object[]{Integer.valueOf(tagSizeBytes)}));
        }

        public HmacParameters build() throws GeneralSecurityException {
            Integer r0 = this.keySizeBytes;
            if (r0 == null) goto L23;
            if (this.tagSizeBytes == null) goto L21;
            if (this.hashType == null) goto L19;
            if (this.variant == null) goto L17;
            if (r0.intValue() < 16) goto L15;
            validateTagSizeBytes(this.tagSizeBytes.intValue(), this.hashType);
            return new HmacParameters(this.keySizeBytes.intValue(), this.tagSizeBytes.intValue(), this.variant, this.hashType, null);
        L15:
            throw new InvalidAlgorithmParameterException(String.format("Invalid key size in bytes %d; must be at least 16 bytes", new Object[]{this.keySizeBytes}));
        L17:
            throw new GeneralSecurityException("variant is not set");
        L19:
            throw new GeneralSecurityException("hash type is not set");
        L21:
            throw new GeneralSecurityException("tag size is not set");
        L23:
            throw new GeneralSecurityException("key size is not set");
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

    /* synthetic */ HmacParameters(int r1, int r2, Variant r3, HashType r4, AnonymousClass1 r5) {
        this(r1, r2, r3, r4);
    }

    private HmacParameters(int keySizeBytes, int tagSizeBytes, Variant variant, HashType hashType) {
        this.keySizeBytes = keySizeBytes;
        this.tagSizeBytes = tagSizeBytes;
        this.variant = variant;
        this.hashType = hashType;
    }

    public static Builder builder() {
        return new Builder(null);
    }

    public int getKeySizeBytes() {
        return this.keySizeBytes;
    }

    public int getCryptographicTagSizeBytes() {
        return this.tagSizeBytes;
    }

    public int getTotalTagSizeBytes() {
        if (this.variant != Variant.NO_PREFIX) goto L7;
        return getCryptographicTagSizeBytes();
    L7:
        if (this.variant != Variant.TINK) goto L12;
        int r2 = getCryptographicTagSizeBytes();
    L10:
        return r2 + 5;
    L12:
        if (this.variant != Variant.CRUNCHY) goto L15;
        r2 = getCryptographicTagSizeBytes();
        goto L10
    L15:
        if (this.variant != Variant.LEGACY) goto L18;
        r2 = getCryptographicTagSizeBytes();
        goto L10
    L18:
        throw new IllegalStateException("Unknown variant");
    }

    public Variant getVariant() {
        return this.variant;
    }

    public HashType getHashType() {
        return this.hashType;
    }

    public boolean equals(Object o) {
        if ((o instanceof HmacParameters) == true) goto L5;
        return false;
    L5:
        HmacParameters r4 = (HmacParameters) o;
        if (r4.getKeySizeBytes() == getKeySizeBytes()) goto L8;
        return false;
    L8:
        if (r4.getTotalTagSizeBytes() == getTotalTagSizeBytes()) goto L10;
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
        return Objects.hash(new Object[]{HmacParameters.class, Integer.valueOf(this.keySizeBytes), Integer.valueOf(this.tagSizeBytes), this.variant, this.hashType});
    }

    @Override // com.google.crypto.tink.Parameters
    public boolean hasIdRequirement() {
        if (this.variant == Variant.NO_PREFIX) goto L5;
        return true;
    L5:
        return false;
    }

    public String toString() {
        return "HMAC Parameters (variant: " + this.variant + ", hashType: " + this.hashType + ", " + this.tagSizeBytes + "-byte tags, and " + this.keySizeBytes + "-byte key)";
    }
}
