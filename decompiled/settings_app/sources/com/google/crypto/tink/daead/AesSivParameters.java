package com.google.crypto.tink.daead;

import com.google.errorprone.annotations.Immutable;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.util.Objects;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class AesSivParameters extends DeterministicAeadParameters {
    private final int keySizeBytes;
    private final Variant variant;

    /* JADX INFO: renamed from: com.google.crypto.tink.daead.AesSivParameters$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public static final class Builder {

        @Nullable
        private Integer keySizeBytes;
        private Variant variant;

        /* synthetic */ Builder(AnonymousClass1 r1) {
            this();
        }

        private Builder() {
            this.keySizeBytes = null;
            this.variant = Variant.NO_PREFIX;
        }

        public Builder setKeySizeBytes(int keySizeBytes) throws GeneralSecurityException {
            if (keySizeBytes != 32) goto L5;
        L11:
            this.keySizeBytes = Integer.valueOf(keySizeBytes);
            return this;
        L5:
            if (keySizeBytes == 48) goto L11;
            if (keySizeBytes == 64) goto L11;
            throw new InvalidAlgorithmParameterException(String.format("Invalid key size %d; only 32-byte, 48-byte and 64-byte AES-SIV keys are supported", new Object[]{Integer.valueOf(keySizeBytes)}));
        }

        public Builder setVariant(Variant variant) {
            this.variant = variant;
            return this;
        }

        public AesSivParameters build() throws GeneralSecurityException {
            if (this.keySizeBytes == null) goto L11;
            if (this.variant == null) goto L9;
            return new AesSivParameters(this.keySizeBytes.intValue(), this.variant, null);
        L9:
            throw new GeneralSecurityException("Variant is not set");
        L11:
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

    /* synthetic */ AesSivParameters(int r1, Variant r2, AnonymousClass1 r3) {
        this(r1, r2);
    }

    private AesSivParameters(int keySizeBytes, Variant variant) {
        this.keySizeBytes = keySizeBytes;
        this.variant = variant;
    }

    public static Builder builder() {
        return new Builder(null);
    }

    public int getKeySizeBytes() {
        return this.keySizeBytes;
    }

    public Variant getVariant() {
        return this.variant;
    }

    public boolean equals(Object o) {
        if ((o instanceof AesSivParameters) == true) goto L5;
        return false;
    L5:
        AesSivParameters r4 = (AesSivParameters) o;
        if (r4.getKeySizeBytes() == getKeySizeBytes()) goto L8;
        return false;
    L8:
        if (r4.getVariant() != getVariant()) goto L12;
        return true;
    L12:
        return false;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{AesSivParameters.class, Integer.valueOf(this.keySizeBytes), this.variant});
    }

    @Override // com.google.crypto.tink.Parameters
    public boolean hasIdRequirement() {
        if (this.variant == Variant.NO_PREFIX) goto L5;
        return true;
    L5:
        return false;
    }

    public String toString() {
        return "AesSiv Parameters (variant: " + this.variant + ", " + this.keySizeBytes + "-byte key)";
    }
}
