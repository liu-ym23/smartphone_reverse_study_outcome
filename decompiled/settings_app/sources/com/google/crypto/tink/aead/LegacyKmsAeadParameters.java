package com.google.crypto.tink.aead;

import com.google.errorprone.annotations.Immutable;
import java.security.GeneralSecurityException;
import java.util.Objects;

/* JADX INFO: loaded from: classes4.dex */
public final class LegacyKmsAeadParameters extends AeadParameters {
    private final String keyUri;
    private final Variant variant;

    @Immutable
    public static final class Variant {
        public static final Variant NO_PREFIX = null;
        public static final Variant TINK = null;
        private final String name;

        static {
            TINK = new Variant("TINK");
            NO_PREFIX = new Variant("NO_PREFIX");
        }

        private Variant(String name) {
            this.name = name;
        }

        public String toString() {
            return this.name;
        }
    }

    private LegacyKmsAeadParameters(String keyUri, Variant variant) {
        this.keyUri = keyUri;
        this.variant = variant;
    }

    public static LegacyKmsAeadParameters create(String keyUri) throws GeneralSecurityException {
        return new LegacyKmsAeadParameters(keyUri, Variant.NO_PREFIX);
    }

    public static LegacyKmsAeadParameters create(String keyUri, Variant variant) {
        return new LegacyKmsAeadParameters(keyUri, variant);
    }

    public String keyUri() {
        return this.keyUri;
    }

    public Variant variant() {
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
        if ((o instanceof LegacyKmsAeadParameters) == true) goto L5;
        return false;
    L5:
        LegacyKmsAeadParameters r4 = (LegacyKmsAeadParameters) o;
        if (r4.keyUri.equals(this.keyUri) == true) goto L8;
        return false;
    L8:
        if (r4.variant.equals(this.variant) == false) goto L12;
        return true;
    L12:
        return false;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{LegacyKmsAeadParameters.class, this.keyUri, this.variant});
    }

    public String toString() {
        return "LegacyKmsAead Parameters (keyUri: " + this.keyUri + ", variant: " + this.variant + ")";
    }
}
