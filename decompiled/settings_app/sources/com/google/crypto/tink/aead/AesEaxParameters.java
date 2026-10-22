package com.google.crypto.tink.aead;

import com.google.errorprone.annotations.Immutable;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.util.Objects;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class AesEaxParameters extends AeadParameters {
    private final int ivSizeBytes;
    private final int keySizeBytes;
    private final int tagSizeBytes;
    private final Variant variant;

    /* JADX INFO: renamed from: com.google.crypto.tink.aead.AesEaxParameters$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public static final class Builder {

        @Nullable
        private Integer ivSizeBytes;

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
            this.ivSizeBytes = null;
            this.tagSizeBytes = null;
            this.variant = Variant.NO_PREFIX;
        }

        public Builder setKeySizeBytes(int keySizeBytes) throws GeneralSecurityException {
            if (keySizeBytes != 16) goto L5;
        L11:
            this.keySizeBytes = Integer.valueOf(keySizeBytes);
            return this;
        L5:
            if (keySizeBytes == 24) goto L11;
            if (keySizeBytes == 32) goto L11;
            throw new InvalidAlgorithmParameterException(String.format("Invalid key size %d; only 16-byte, 24-byte and 32-byte AES keys are supported", new Object[]{Integer.valueOf(keySizeBytes)}));
        }

        public Builder setIvSizeBytes(int ivSizeBytes) throws GeneralSecurityException {
            if (ivSizeBytes != 12) goto L5;
        L9:
            this.ivSizeBytes = Integer.valueOf(ivSizeBytes);
            return this;
        L5:
            if (ivSizeBytes == 16) goto L9;
            throw new GeneralSecurityException(String.format("Invalid IV size in bytes %d; acceptable values have 12 or 16 bytes", new Object[]{Integer.valueOf(ivSizeBytes)}));
        }

        public Builder setTagSizeBytes(int tagSizeBytes) throws GeneralSecurityException {
            if (tagSizeBytes < 0) goto L8;
            if (tagSizeBytes > 16) goto L8;
            this.tagSizeBytes = Integer.valueOf(tagSizeBytes);
            return this;
        L8:
            throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; value must be at most 16 bytes", new Object[]{Integer.valueOf(tagSizeBytes)}));
        }

        public Builder setVariant(Variant variant) {
            this.variant = variant;
            return this;
        }

        public AesEaxParameters build() throws GeneralSecurityException {
            if (this.keySizeBytes == null) goto L19;
            if (this.ivSizeBytes == null) goto L17;
            if (this.variant == null) goto L15;
            if (this.tagSizeBytes == null) goto L13;
            return new AesEaxParameters(this.keySizeBytes.intValue(), this.ivSizeBytes.intValue(), this.tagSizeBytes.intValue(), this.variant, null);
        L13:
            throw new GeneralSecurityException("Tag size is not set");
        L15:
            throw new GeneralSecurityException("Variant is not set");
        L17:
            throw new GeneralSecurityException("IV size is not set");
        L19:
            throw new GeneralSecurityException("Key size is not set");
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

    /* synthetic */ AesEaxParameters(int r1, int r2, int r3, Variant r4, AnonymousClass1 r5) {
        this(r1, r2, r3, r4);
    }

    private AesEaxParameters(int keySizeBytes, int ivSizeBytes, int tagSizeBytes, Variant variant) {
        this.keySizeBytes = keySizeBytes;
        this.ivSizeBytes = ivSizeBytes;
        this.tagSizeBytes = tagSizeBytes;
        this.variant = variant;
    }

    public static Builder builder() {
        return new Builder(null);
    }

    public int getKeySizeBytes() {
        return this.keySizeBytes;
    }

    public int getIvSizeBytes() {
        return this.ivSizeBytes;
    }

    public int getTagSizeBytes() {
        return this.tagSizeBytes;
    }

    public Variant getVariant() {
        return this.variant;
    }

    public boolean equals(Object o) {
        if ((o instanceof AesEaxParameters) == true) goto L5;
        return false;
    L5:
        AesEaxParameters r4 = (AesEaxParameters) o;
        if (r4.getKeySizeBytes() == getKeySizeBytes()) goto L8;
        return false;
    L8:
        if (r4.getIvSizeBytes() == getIvSizeBytes()) goto L10;
        return false;
    L10:
        if (r4.getTagSizeBytes() == getTagSizeBytes()) goto L12;
        return false;
    L12:
        if (r4.getVariant() != getVariant()) goto L18;
        return true;
    L18:
        return false;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{AesEaxParameters.class, Integer.valueOf(this.keySizeBytes), Integer.valueOf(this.ivSizeBytes), Integer.valueOf(this.tagSizeBytes), this.variant});
    }

    @Override // com.google.crypto.tink.Parameters
    public boolean hasIdRequirement() {
        if (this.variant == Variant.NO_PREFIX) goto L5;
        return true;
    L5:
        return false;
    }

    public String toString() {
        return "AesEax Parameters (variant: " + this.variant + ", " + this.ivSizeBytes + "-byte IV, " + this.tagSizeBytes + "-byte tag, and " + this.keySizeBytes + "-byte key)";
    }
}
