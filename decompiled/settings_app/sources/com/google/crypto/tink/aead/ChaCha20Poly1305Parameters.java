package com.google.crypto.tink.aead;

import com.google.errorprone.annotations.Immutable;
import java.util.Objects;

/* JADX INFO: loaded from: classes4.dex */
public final class ChaCha20Poly1305Parameters extends AeadParameters {
    private final Variant variant;

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

    public static ChaCha20Poly1305Parameters create() {
        return new ChaCha20Poly1305Parameters(Variant.NO_PREFIX);
    }

    public static ChaCha20Poly1305Parameters create(Variant variant) {
        return new ChaCha20Poly1305Parameters(variant);
    }

    private ChaCha20Poly1305Parameters(Variant variant) {
        this.variant = variant;
    }

    public Variant getVariant() {
        return this.variant;
    }

    public boolean equals(Object o) {
        if ((o instanceof ChaCha20Poly1305Parameters) == true) goto L6;
        return false;
    L6:
        if (((ChaCha20Poly1305Parameters) o).getVariant() != getVariant()) goto L9;
        return true;
    L9:
        return false;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{ChaCha20Poly1305Parameters.class, this.variant});
    }

    @Override // com.google.crypto.tink.Parameters
    public boolean hasIdRequirement() {
        if (this.variant == Variant.NO_PREFIX) goto L5;
        return true;
    L5:
        return false;
    }

    public String toString() {
        return "ChaCha20Poly1305 Parameters (variant: " + this.variant + ")";
    }
}
