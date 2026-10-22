package com.google.crypto.tink.mac;

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
public final class AesCmacKey extends MacKey {
    private final SecretBytes aesKeyBytes;

    @Nullable
    private final Integer idRequirement;
    private final Bytes outputPrefix;
    private final AesCmacParameters parameters;

    /* JADX INFO: renamed from: com.google.crypto.tink.mac.AesCmacKey$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public static class Builder {

        @Nullable
        private SecretBytes aesKeyBytes;

        @Nullable
        private Integer idRequirement;

        @Nullable
        private AesCmacParameters parameters;

        /* synthetic */ Builder(AnonymousClass1 r1) {
            this();
        }

        private Builder() {
            this.parameters = null;
            this.aesKeyBytes = null;
            this.idRequirement = null;
        }

        public Builder setParameters(AesCmacParameters parameters) {
            this.parameters = parameters;
            return this;
        }

        public Builder setAesKeyBytes(SecretBytes aesKeyBytes) throws GeneralSecurityException {
            this.aesKeyBytes = aesKeyBytes;
            return this;
        }

        public Builder setIdRequirement(@Nullable Integer idRequirement) {
            this.idRequirement = idRequirement;
            return this;
        }

        private Bytes getOutputPrefix() {
            if (this.parameters.getVariant() != AesCmacParameters.Variant.NO_PREFIX) goto L7;
            return OutputPrefixUtil.EMPTY_PREFIX;
        L7:
            if (this.parameters.getVariant() == AesCmacParameters.Variant.LEGACY) goto L18;
            if (this.parameters.getVariant() == AesCmacParameters.Variant.CRUNCHY) goto L18;
            if (this.parameters.getVariant() != AesCmacParameters.Variant.TINK) goto L16;
            return OutputPrefixUtil.getTinkOutputPrefix(this.idRequirement.intValue());
        L16:
            throw new IllegalStateException("Unknown AesCmacParametersParameters.Variant: " + this.parameters.getVariant());
        L18:
            return OutputPrefixUtil.getLegacyOutputPrefix(this.idRequirement.intValue());
        }

        public AesCmacKey build() throws GeneralSecurityException {
            AesCmacParameters r0 = this.parameters;
            if (r0 == null) goto L27;
            if (this.aesKeyBytes == null) goto L27;
            if (r0.getKeySizeBytes() != this.aesKeyBytes.size()) goto L25;
            if (this.parameters.hasIdRequirement() == false) goto L16;
            if (this.idRequirement != null) goto L16;
            throw new GeneralSecurityException("Cannot create key without ID requirement with parameters with ID requirement");
        L16:
            if (this.parameters.hasIdRequirement() == false) goto L18;
        L22:
            Bytes r4 = getOutputPrefix();
            return new AesCmacKey(this.parameters, this.aesKeyBytes, r4, this.idRequirement, null);
        L18:
            if (this.idRequirement == null) goto L22;
            throw new GeneralSecurityException("Cannot create key with ID requirement with parameters without ID requirement");
        L25:
            throw new GeneralSecurityException("Key size mismatch");
        L27:
            throw new GeneralSecurityException("Cannot build without parameters and/or key material");
        }
    }

    @Override // com.google.crypto.tink.mac.MacKey, com.google.crypto.tink.Key
    public /* bridge */ /* synthetic */ Parameters getParameters() {
        return getParameters();
    }

    @Override // com.google.crypto.tink.mac.MacKey, com.google.crypto.tink.Key
    public /* bridge */ /* synthetic */ MacParameters getParameters() {
        return getParameters();
    }

    /* synthetic */ AesCmacKey(AesCmacParameters r1, SecretBytes r2, Bytes r3, Integer r4, AnonymousClass1 r5) {
        this(r1, r2, r3, r4);
    }

    private AesCmacKey(AesCmacParameters parameters, SecretBytes aesKeyBytes, Bytes outputPrefix, @Nullable Integer idRequirement) {
        this.parameters = parameters;
        this.aesKeyBytes = aesKeyBytes;
        this.outputPrefix = outputPrefix;
        this.idRequirement = idRequirement;
    }

    public static Builder builder() {
        return new Builder(null);
    }

    public SecretBytes getAesKey() {
        return this.aesKeyBytes;
    }

    @Override // com.google.crypto.tink.mac.MacKey
    public Bytes getOutputPrefix() {
        return this.outputPrefix;
    }

    @Override // com.google.crypto.tink.mac.MacKey, com.google.crypto.tink.Key
    public AesCmacParameters getParameters() {
        return this.parameters;
    }

    @Override // com.google.crypto.tink.Key
    @Nullable
    public Integer getIdRequirementOrNull() {
        return this.idRequirement;
    }

    @Override // com.google.crypto.tink.Key
    public boolean equalsKey(Key o) {
        if ((o instanceof AesCmacKey) == true) goto L5;
        return false;
    L5:
        AesCmacKey r4 = (AesCmacKey) o;
        if (r4.parameters.equals(this.parameters) == true) goto L8;
        return false;
    L8:
        if (r4.aesKeyBytes.equalsSecretBytes(this.aesKeyBytes) == true) goto L10;
        return false;
    L10:
        if (Objects.equals(r4.idRequirement, this.idRequirement) == false) goto L15;
        return true;
    L15:
        return false;
    }
}
