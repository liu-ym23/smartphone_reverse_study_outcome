package com.google.crypto.tink.aead;

import com.google.crypto.tink.Key;
import com.google.crypto.tink.Parameters;
import com.google.crypto.tink.internal.OutputPrefixUtil;
import com.google.crypto.tink.util.Bytes;
import com.google.crypto.tink.util.SecretBytes;
import com.google.errorprone.annotations.Immutable;
import java.security.GeneralSecurityException;
import java.util.Objects;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Immutable
public final class AesGcmSivKey extends AeadKey {

    @Nullable
    private final Integer idRequirement;
    private final SecretBytes keyBytes;
    private final Bytes outputPrefix;
    private final AesGcmSivParameters parameters;

    /* JADX INFO: renamed from: com.google.crypto.tink.aead.AesGcmSivKey$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public static class Builder {

        @Nullable
        private Integer idRequirement;

        @Nullable
        private SecretBytes keyBytes;

        @Nullable
        private AesGcmSivParameters parameters;

        /* synthetic */ Builder(AnonymousClass1 r1) {
            this();
        }

        private Builder() {
            this.parameters = null;
            this.keyBytes = null;
            this.idRequirement = null;
        }

        public Builder setParameters(AesGcmSivParameters parameters) {
            this.parameters = parameters;
            return this;
        }

        public Builder setKeyBytes(SecretBytes keyBytes) {
            this.keyBytes = keyBytes;
            return this;
        }

        public Builder setIdRequirement(@Nullable Integer idRequirement) {
            this.idRequirement = idRequirement;
            return this;
        }

        private Bytes getOutputPrefix() {
            if (this.parameters.getVariant() != AesGcmSivParameters.Variant.NO_PREFIX) goto L7;
            return OutputPrefixUtil.EMPTY_PREFIX;
        L7:
            if (this.parameters.getVariant() != AesGcmSivParameters.Variant.CRUNCHY) goto L11;
            return OutputPrefixUtil.getLegacyOutputPrefix(this.idRequirement.intValue());
        L11:
            if (this.parameters.getVariant() != AesGcmSivParameters.Variant.TINK) goto L15;
            return OutputPrefixUtil.getTinkOutputPrefix(this.idRequirement.intValue());
        L15:
            throw new IllegalStateException("Unknown AesGcmSivParameters.Variant: " + this.parameters.getVariant());
        }

        public AesGcmSivKey build() throws GeneralSecurityException {
            AesGcmSivParameters r0 = this.parameters;
            if (r0 == null) goto L27;
            if (this.keyBytes == null) goto L27;
            if (r0.getKeySizeBytes() != this.keyBytes.size()) goto L25;
            if (this.parameters.hasIdRequirement() == false) goto L16;
            if (this.idRequirement != null) goto L16;
            throw new GeneralSecurityException("Cannot create key without ID requirement with parameters with ID requirement");
        L16:
            if (this.parameters.hasIdRequirement() == false) goto L18;
        L22:
            Bytes r4 = getOutputPrefix();
            return new AesGcmSivKey(this.parameters, this.keyBytes, r4, this.idRequirement, null);
        L18:
            if (this.idRequirement == null) goto L22;
            throw new GeneralSecurityException("Cannot create key with ID requirement with parameters without ID requirement");
        L25:
            throw new GeneralSecurityException("Key size mismatch");
        L27:
            throw new GeneralSecurityException("Cannot build without parameters and/or key material");
        }
    }

    @Override // com.google.crypto.tink.aead.AeadKey, com.google.crypto.tink.Key
    public /* bridge */ /* synthetic */ Parameters getParameters() {
        return getParameters();
    }

    @Override // com.google.crypto.tink.aead.AeadKey, com.google.crypto.tink.Key
    public /* bridge */ /* synthetic */ AeadParameters getParameters() {
        return getParameters();
    }

    /* synthetic */ AesGcmSivKey(AesGcmSivParameters r1, SecretBytes r2, Bytes r3, Integer r4, AnonymousClass1 r5) {
        this(r1, r2, r3, r4);
    }

    private AesGcmSivKey(AesGcmSivParameters parameters, SecretBytes keyBytes, Bytes outputPrefix, @Nullable Integer idRequirement) {
        this.parameters = parameters;
        this.keyBytes = keyBytes;
        this.outputPrefix = outputPrefix;
        this.idRequirement = idRequirement;
    }

    public static Builder builder() {
        return new Builder(null);
    }

    public SecretBytes getKeyBytes() {
        return this.keyBytes;
    }

    @Override // com.google.crypto.tink.aead.AeadKey
    public Bytes getOutputPrefix() {
        return this.outputPrefix;
    }

    @Override // com.google.crypto.tink.aead.AeadKey, com.google.crypto.tink.Key
    public AesGcmSivParameters getParameters() {
        return this.parameters;
    }

    @Override // com.google.crypto.tink.Key
    @Nullable
    public Integer getIdRequirementOrNull() {
        return this.idRequirement;
    }

    @Override // com.google.crypto.tink.Key
    public boolean equalsKey(Key o) {
        if ((o instanceof AesGcmSivKey) == true) goto L5;
        return false;
    L5:
        AesGcmSivKey r4 = (AesGcmSivKey) o;
        if (r4.parameters.equals(this.parameters) == true) goto L8;
        return false;
    L8:
        if (r4.keyBytes.equalsSecretBytes(this.keyBytes) == true) goto L10;
        return false;
    L10:
        if (Objects.equals(r4.idRequirement, this.idRequirement) == false) goto L15;
        return true;
    L15:
        return false;
    }
}
