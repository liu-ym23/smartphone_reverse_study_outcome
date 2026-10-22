package com.google.crypto.tink.aead;

import com.google.errorprone.annotations.Immutable;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.util.Objects;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class AesCtrHmacAeadParameters extends AeadParameters {
    private static final int PREFIX_SIZE_IN_BYTES = 5;
    private final int aesKeySizeBytes;
    private final HashType hashType;
    private final int hmacKeySizeBytes;
    private final int ivSizeBytes;
    private final int tagSizeBytes;
    private final Variant variant;

    /* JADX INFO: renamed from: com.google.crypto.tink.aead.AesCtrHmacAeadParameters$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public static final class Builder {

        @Nullable
        private Integer aesKeySizeBytes;
        private HashType hashType;

        @Nullable
        private Integer hmacKeySizeBytes;

        @Nullable
        private Integer ivSizeBytes;

        @Nullable
        private Integer tagSizeBytes;
        private Variant variant;

        /* synthetic */ Builder(AnonymousClass1 r1) {
            this();
        }

        private Builder() {
            this.aesKeySizeBytes = null;
            this.hmacKeySizeBytes = null;
            this.ivSizeBytes = null;
            this.tagSizeBytes = null;
            this.hashType = null;
            this.variant = Variant.NO_PREFIX;
        }

        public Builder setAesKeySizeBytes(int aesKeySizeBytes) throws GeneralSecurityException {
            if (aesKeySizeBytes != 16) goto L5;
        L11:
            this.aesKeySizeBytes = Integer.valueOf(aesKeySizeBytes);
            return this;
        L5:
            if (aesKeySizeBytes == 24) goto L11;
            if (aesKeySizeBytes == 32) goto L11;
            throw new InvalidAlgorithmParameterException(String.format("Invalid key size %d; only 16-byte, 24-byte and 32-byte AES keys are supported", new Object[]{Integer.valueOf(aesKeySizeBytes)}));
        }

        public Builder setHmacKeySizeBytes(int hmacKeySizeBytes) throws GeneralSecurityException {
            if (hmacKeySizeBytes < 16) goto L7;
            this.hmacKeySizeBytes = Integer.valueOf(hmacKeySizeBytes);
            return this;
        L7:
            throw new InvalidAlgorithmParameterException(String.format("Invalid key size in bytes %d; HMAC key must be at least 16 bytes", new Object[]{Integer.valueOf(hmacKeySizeBytes)}));
        }

        public Builder setIvSizeBytes(int ivSizeBytes) throws GeneralSecurityException {
            if (ivSizeBytes < 12) goto L9;
            if (ivSizeBytes > 16) goto L9;
            this.ivSizeBytes = Integer.valueOf(ivSizeBytes);
            return this;
        L9:
            throw new GeneralSecurityException(String.format("Invalid IV size in bytes %d; IV size must be between 12 and 16 bytes", new Object[]{Integer.valueOf(ivSizeBytes)}));
        }

        public Builder setTagSizeBytes(int tagSizeBytes) throws GeneralSecurityException {
            if (tagSizeBytes < 10) goto L7;
            this.tagSizeBytes = Integer.valueOf(tagSizeBytes);
            return this;
        L7:
            throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; must be at least 10 bytes", new Object[]{Integer.valueOf(tagSizeBytes)}));
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
            if (hashType != HashType.SHA1) goto L10;
            if (tagSizeBytes > 20) goto L8;
            return;
        L8:
            throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; can be at most 20 bytes for SHA1", new Object[]{Integer.valueOf(tagSizeBytes)}));
        L10:
            if (hashType != HashType.SHA224) goto L17;
            if (tagSizeBytes > 28) goto L15;
            return;
        L15:
            throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; can be at most 28 bytes for SHA224", new Object[]{Integer.valueOf(tagSizeBytes)}));
        L17:
            if (hashType != HashType.SHA256) goto L24;
            if (tagSizeBytes > 32) goto L22;
            return;
        L22:
            throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; can be at most 32 bytes for SHA256", new Object[]{Integer.valueOf(tagSizeBytes)}));
        L24:
            if (hashType != HashType.SHA384) goto L31;
            if (tagSizeBytes > 48) goto L29;
            return;
        L29:
            throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; can be at most 48 bytes for SHA384", new Object[]{Integer.valueOf(tagSizeBytes)}));
        L31:
            if (hashType != HashType.SHA512) goto L38;
            if (tagSizeBytes > 64) goto L36;
            return;
        L36:
            throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; can be at most 64 bytes for SHA512", new Object[]{Integer.valueOf(tagSizeBytes)}));
        L38:
            throw new GeneralSecurityException("unknown hash type; must be SHA1, SHA224, SHA256, SHA384 or SHA512");
        }

        public AesCtrHmacAeadParameters build() throws GeneralSecurityException {
            if (this.aesKeySizeBytes == null) goto L27;
            if (this.hmacKeySizeBytes == null) goto L25;
            if (this.ivSizeBytes == null) goto L23;
            Integer r0 = this.tagSizeBytes;
            if (r0 == null) goto L21;
            if (this.hashType == null) goto L19;
            if (this.variant == null) goto L17;
            validateTagSizeBytes(r0.intValue(), this.hashType);
            return new AesCtrHmacAeadParameters(this.aesKeySizeBytes.intValue(), this.hmacKeySizeBytes.intValue(), this.ivSizeBytes.intValue(), this.tagSizeBytes.intValue(), this.variant, this.hashType, null);
        L17:
            throw new GeneralSecurityException("variant is not set");
        L19:
            throw new GeneralSecurityException("hash type is not set");
        L21:
            throw new GeneralSecurityException("tag size is not set");
        L23:
            throw new GeneralSecurityException("iv size is not set");
        L25:
            throw new GeneralSecurityException("HMAC key size is not set");
        L27:
            throw new GeneralSecurityException("AES key size is not set");
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

    /* synthetic */ AesCtrHmacAeadParameters(int r1, int r2, int r3, int r4, Variant r5, HashType r6, AnonymousClass1 r7) {
        this(r1, r2, r3, r4, r5, r6);
    }

    private AesCtrHmacAeadParameters(int aesKeySizeBytes, int hmacKeySizeBytes, int ivSizeBytes, int tagSizeBytes, Variant variant, HashType hashType) {
        this.aesKeySizeBytes = aesKeySizeBytes;
        this.hmacKeySizeBytes = hmacKeySizeBytes;
        this.ivSizeBytes = ivSizeBytes;
        this.tagSizeBytes = tagSizeBytes;
        this.variant = variant;
        this.hashType = hashType;
    }

    public static Builder builder() {
        return new Builder(null);
    }

    public int getAesKeySizeBytes() {
        return this.aesKeySizeBytes;
    }

    public int getHmacKeySizeBytes() {
        return this.hmacKeySizeBytes;
    }

    public int getTagSizeBytes() {
        return this.tagSizeBytes;
    }

    public int getIvSizeBytes() {
        return this.ivSizeBytes;
    }

    public int getCiphertextOverheadSizeBytes() {
        if (this.variant != Variant.NO_PREFIX) goto L7;
        return getTagSizeBytes() + getIvSizeBytes();
    L7:
        if (this.variant == Variant.TINK) goto L14;
        if (this.variant == Variant.CRUNCHY) goto L14;
        throw new IllegalStateException("Unknown variant");
    L14:
        return (getTagSizeBytes() + getIvSizeBytes()) + 5;
    }

    public Variant getVariant() {
        return this.variant;
    }

    public HashType getHashType() {
        return this.hashType;
    }

    public boolean equals(Object o) {
        if ((o instanceof AesCtrHmacAeadParameters) == true) goto L5;
        return false;
    L5:
        AesCtrHmacAeadParameters r4 = (AesCtrHmacAeadParameters) o;
        if (r4.getAesKeySizeBytes() == getAesKeySizeBytes()) goto L8;
        return false;
    L8:
        if (r4.getHmacKeySizeBytes() == getHmacKeySizeBytes()) goto L10;
        return false;
    L10:
        if (r4.getIvSizeBytes() == getIvSizeBytes()) goto L12;
        return false;
    L12:
        if (r4.getTagSizeBytes() == getTagSizeBytes()) goto L14;
        return false;
    L14:
        if (r4.getVariant() == getVariant()) goto L16;
        return false;
    L16:
        if (r4.getHashType() != getHashType()) goto L24;
        return true;
    L24:
        return false;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{AesCtrHmacAeadParameters.class, Integer.valueOf(this.aesKeySizeBytes), Integer.valueOf(this.hmacKeySizeBytes), Integer.valueOf(this.ivSizeBytes), Integer.valueOf(this.tagSizeBytes), this.variant, this.hashType});
    }

    @Override // com.google.crypto.tink.Parameters
    public boolean hasIdRequirement() {
        if (this.variant == Variant.NO_PREFIX) goto L5;
        return true;
    L5:
        return false;
    }

    public String toString() {
        return "AesCtrHmacAead Parameters (variant: " + this.variant + ", hashType: " + this.hashType + ", " + this.ivSizeBytes + "-byte IV, and " + this.tagSizeBytes + "-byte tags, and " + this.aesKeySizeBytes + "-byte AES key, and " + this.hmacKeySizeBytes + "-byte HMAC key)";
    }
}
