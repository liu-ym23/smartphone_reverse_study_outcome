package com.google.crypto.tink.mac;

import com.google.errorprone.annotations.Immutable;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.util.Objects;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class AesCmacParameters extends MacParameters {
    private final int keySizeBytes;
    private final int tagSizeBytes;
    private final Variant variant;

    /* JADX INFO: renamed from: com.google.crypto.tink.mac.AesCmacParameters$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public static final class Builder {

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
            this.variant = Variant.NO_PREFIX;
        }

        public Builder setKeySizeBytes(int keySizeBytes) throws GeneralSecurityException {
            if (keySizeBytes != 16) goto L5;
        L9:
            this.keySizeBytes = Integer.valueOf(keySizeBytes);
            return this;
        L5:
            if (keySizeBytes == 32) goto L9;
            throw new InvalidAlgorithmParameterException(String.format("Invalid key size %d; only 128-bit and 256-bit AES keys are supported", new Object[]{Integer.valueOf(keySizeBytes * 8)}));
        }

        public Builder setTagSizeBytes(int tagSizeBytes) throws GeneralSecurityException {
            if (tagSizeBytes < 10) goto L9;
            if (16 < tagSizeBytes) goto L9;
            this.tagSizeBytes = Integer.valueOf(tagSizeBytes);
            return this;
        L9:
            throw new GeneralSecurityException("Invalid tag size for AesCmacParameters: " + tagSizeBytes);
        }

        public Builder setVariant(Variant variant) {
            this.variant = variant;
            return this;
        }

        public AesCmacParameters build() throws GeneralSecurityException {
            if (this.keySizeBytes == null) goto L15;
            if (this.tagSizeBytes == null) goto L13;
            if (this.variant == null) goto L11;
            return new AesCmacParameters(this.keySizeBytes.intValue(), this.tagSizeBytes.intValue(), this.variant, null);
        L11:
            throw new GeneralSecurityException("variant not set");
        L13:
            throw new GeneralSecurityException("tag size not set");
        L15:
            throw new GeneralSecurityException("key size not set");
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

    /* synthetic */ AesCmacParameters(int r1, int r2, Variant r3, AnonymousClass1 r4) {
        this(r1, r2, r3);
    }

    private AesCmacParameters(int keySizeBytes, int tagSizeBytes, Variant variant) {
        this.keySizeBytes = keySizeBytes;
        this.tagSizeBytes = tagSizeBytes;
        this.variant = variant;
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

    public boolean equals(Object o) {
        if ((o instanceof AesCmacParameters) == true) goto L5;
        return false;
    L5:
        AesCmacParameters r4 = (AesCmacParameters) o;
        if (r4.getKeySizeBytes() == getKeySizeBytes()) goto L8;
        return false;
    L8:
        if (r4.getTotalTagSizeBytes() == getTotalTagSizeBytes()) goto L10;
        return false;
    L10:
        if (r4.getVariant() != getVariant()) goto L15;
        return true;
    L15:
        return false;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{AesCmacParameters.class, Integer.valueOf(this.keySizeBytes), Integer.valueOf(this.tagSizeBytes), this.variant});
    }

    @Override // com.google.crypto.tink.Parameters
    public boolean hasIdRequirement() {
        if (this.variant == Variant.NO_PREFIX) goto L5;
        return true;
    L5:
        return false;
    }

    public String toString() {
        return "AES-CMAC Parameters (variant: " + this.variant + ", " + this.tagSizeBytes + "-byte tags, and " + this.keySizeBytes + "-byte key)";
    }
}
