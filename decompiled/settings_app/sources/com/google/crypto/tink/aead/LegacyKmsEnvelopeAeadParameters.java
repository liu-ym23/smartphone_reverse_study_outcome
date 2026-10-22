package com.google.crypto.tink.aead;

import com.google.errorprone.annotations.Immutable;
import java.security.GeneralSecurityException;
import java.util.Objects;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class LegacyKmsEnvelopeAeadParameters extends AeadParameters {
    private final AeadParameters dekParametersForNewKeys;
    private final DekParsingStrategy dekParsingStrategy;
    private final String kekUri;
    private final Variant variant;

    /* JADX INFO: renamed from: com.google.crypto.tink.aead.LegacyKmsEnvelopeAeadParameters$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public static class Builder {

        @Nullable
        private AeadParameters dekParametersForNewKeys;

        @Nullable
        private DekParsingStrategy dekParsingStrategy;

        @Nullable
        private String kekUri;

        @Nullable
        private Variant variant;

        /* synthetic */ Builder(AnonymousClass1 r1) {
            this();
        }

        private Builder() {
        }

        public Builder setVariant(Variant variant) {
            this.variant = variant;
            return this;
        }

        public Builder setKekUri(String kekUri) {
            this.kekUri = kekUri;
            return this;
        }

        public Builder setDekParsingStrategy(DekParsingStrategy dekParsingStrategy) {
            this.dekParsingStrategy = dekParsingStrategy;
            return this;
        }

        public Builder setDekParametersForNewKeys(AeadParameters aeadParameters) {
            this.dekParametersForNewKeys = aeadParameters;
            return this;
        }

        private static boolean parsingStrategyAllowed(DekParsingStrategy parsingStrategy, AeadParameters aeadParameters) {
            if (parsingStrategy.equals(DekParsingStrategy.ASSUME_AES_GCM) == false) goto L8;
            if ((aeadParameters instanceof AesGcmParameters) == false) goto L8;
            return true;
        L8:
            if (parsingStrategy.equals(DekParsingStrategy.ASSUME_CHACHA20POLY1305) == false) goto L13;
            if ((aeadParameters instanceof ChaCha20Poly1305Parameters) == false) goto L13;
            return true;
        L13:
            if (parsingStrategy.equals(DekParsingStrategy.ASSUME_XCHACHA20POLY1305) == false) goto L18;
            if ((aeadParameters instanceof XChaCha20Poly1305Parameters) == false) goto L18;
            return true;
        L18:
            if (parsingStrategy.equals(DekParsingStrategy.ASSUME_AES_CTR_HMAC) == false) goto L23;
            if ((aeadParameters instanceof AesCtrHmacAeadParameters) == false) goto L23;
            return true;
        L23:
            if (parsingStrategy.equals(DekParsingStrategy.ASSUME_AES_EAX) == false) goto L28;
            if ((aeadParameters instanceof AesEaxParameters) == false) goto L28;
            return true;
        L28:
            if (parsingStrategy.equals(DekParsingStrategy.ASSUME_AES_GCM_SIV) == true) goto L30;
            return false;
        L30:
            if ((aeadParameters instanceof AesGcmSivParameters) == false) goto L34;
            return true;
        L34:
            return false;
        }

        public LegacyKmsEnvelopeAeadParameters build() throws GeneralSecurityException {
            if (this.variant != null) goto L6;
            this.variant = Variant.NO_PREFIX;
        L6:
            if (this.kekUri == null) goto L26;
            if (this.dekParsingStrategy == null) goto L24;
            AeadParameters r0 = this.dekParametersForNewKeys;
            if (r0 == null) goto L22;
            if (r0.hasIdRequirement() == true) goto L20;
            if (parsingStrategyAllowed(this.dekParsingStrategy, this.dekParametersForNewKeys) == false) goto L18;
            return new LegacyKmsEnvelopeAeadParameters(this.variant, this.kekUri, this.dekParsingStrategy, this.dekParametersForNewKeys, null);
        L18:
            throw new GeneralSecurityException("Cannot use parsing strategy " + this.dekParsingStrategy.toString() + " when new keys are picked according to " + this.dekParametersForNewKeys + ".");
        L20:
            throw new GeneralSecurityException("dekParametersForNewKeys must not have ID Requirements");
        L22:
            throw new GeneralSecurityException("dekParametersForNewKeys must be set");
        L24:
            throw new GeneralSecurityException("dekParsingStrategy must be set");
        L26:
            throw new GeneralSecurityException("kekUri must be set");
        }
    }

    @Immutable
    public static final class DekParsingStrategy {
        public static final DekParsingStrategy ASSUME_AES_CTR_HMAC = null;
        public static final DekParsingStrategy ASSUME_AES_EAX = null;
        public static final DekParsingStrategy ASSUME_AES_GCM = null;
        public static final DekParsingStrategy ASSUME_AES_GCM_SIV = null;
        public static final DekParsingStrategy ASSUME_CHACHA20POLY1305 = null;
        public static final DekParsingStrategy ASSUME_XCHACHA20POLY1305 = null;
        private final String name;

        static {
            ASSUME_AES_GCM = new DekParsingStrategy("ASSUME_AES_GCM");
            ASSUME_XCHACHA20POLY1305 = new DekParsingStrategy("ASSUME_XCHACHA20POLY1305");
            ASSUME_CHACHA20POLY1305 = new DekParsingStrategy("ASSUME_CHACHA20POLY1305");
            ASSUME_AES_CTR_HMAC = new DekParsingStrategy("ASSUME_AES_CTR_HMAC");
            ASSUME_AES_EAX = new DekParsingStrategy("ASSUME_AES_EAX");
            ASSUME_AES_GCM_SIV = new DekParsingStrategy("ASSUME_AES_GCM_SIV");
        }

        private DekParsingStrategy(String name) {
            this.name = name;
        }

        public String toString() {
            return this.name;
        }
    }

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

    /* synthetic */ LegacyKmsEnvelopeAeadParameters(Variant r1, String r2, DekParsingStrategy r3, AeadParameters r4, AnonymousClass1 r5) {
        this(r1, r2, r3, r4);
    }

    private LegacyKmsEnvelopeAeadParameters(Variant variant, String kekUri, DekParsingStrategy dekParsingStrategy, AeadParameters dekParametersForNewKeys) {
        this.variant = variant;
        this.kekUri = kekUri;
        this.dekParsingStrategy = dekParsingStrategy;
        this.dekParametersForNewKeys = dekParametersForNewKeys;
    }

    public static Builder builder() {
        return new Builder(null);
    }

    public String getKekUri() {
        return this.kekUri;
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

    public DekParsingStrategy getDekParsingStrategy() {
        return this.dekParsingStrategy;
    }

    public AeadParameters getDekParametersForNewKeys() {
        return this.dekParametersForNewKeys;
    }

    public boolean equals(Object o) {
        if ((o instanceof LegacyKmsEnvelopeAeadParameters) == true) goto L5;
        return false;
    L5:
        LegacyKmsEnvelopeAeadParameters r4 = (LegacyKmsEnvelopeAeadParameters) o;
        if (r4.dekParsingStrategy.equals(this.dekParsingStrategy) == true) goto L8;
        return false;
    L8:
        if (r4.dekParametersForNewKeys.equals(this.dekParametersForNewKeys) == true) goto L10;
        return false;
    L10:
        if (r4.kekUri.equals(this.kekUri) == true) goto L12;
        return false;
    L12:
        if (r4.variant.equals(this.variant) == false) goto L18;
        return true;
    L18:
        return false;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{LegacyKmsEnvelopeAeadParameters.class, this.kekUri, this.dekParsingStrategy, this.dekParametersForNewKeys, this.variant});
    }

    public String toString() {
        return "LegacyKmsEnvelopeAead Parameters (kekUri: " + this.kekUri + ", dekParsingStrategy: " + this.dekParsingStrategy + ", dekParametersForNewKeys: " + this.dekParametersForNewKeys + ", variant: " + this.variant + ")";
    }
}
