package com.google.crypto.tink.aead;

import com.google.crypto.tink.Key;
import com.google.crypto.tink.Parameters;
import com.google.crypto.tink.internal.OutputPrefixUtil;
import com.google.crypto.tink.util.Bytes;
import com.google.crypto.tink.util.SecretBytes;
import java.security.GeneralSecurityException;
import java.util.Objects;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class AesCtrHmacAeadKey extends AeadKey {
    private final SecretBytes aesKeyBytes;
    private final SecretBytes hmacKeyBytes;

    @Nullable
    private final Integer idRequirement;
    private final Bytes outputPrefix;
    private final AesCtrHmacAeadParameters parameters;

    /* JADX INFO: renamed from: com.google.crypto.tink.aead.AesCtrHmacAeadKey$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public static class Builder {

        @Nullable
        private SecretBytes aesKeyBytes;

        @Nullable
        private SecretBytes hmacKeyBytes;

        @Nullable
        private Integer idRequirement;

        @Nullable
        private AesCtrHmacAeadParameters parameters;

        /* synthetic */ Builder(AnonymousClass1 r1) {
            this();
        }

        private Builder() {
            this.parameters = null;
            this.aesKeyBytes = null;
            this.hmacKeyBytes = null;
            this.idRequirement = null;
        }

        public Builder setParameters(AesCtrHmacAeadParameters parameters) {
            this.parameters = parameters;
            return this;
        }

        public Builder setAesKeyBytes(SecretBytes aesKeyBytes) {
            this.aesKeyBytes = aesKeyBytes;
            return this;
        }

        public Builder setHmacKeyBytes(SecretBytes hmacKeyBytes) {
            this.hmacKeyBytes = hmacKeyBytes;
            return this;
        }

        public Builder setIdRequirement(@Nullable Integer idRequirement) {
            this.idRequirement = idRequirement;
            return this;
        }

        private Bytes getOutputPrefix() {
            if (this.parameters.getVariant() != AesCtrHmacAeadParameters.Variant.NO_PREFIX) goto L7;
            return OutputPrefixUtil.EMPTY_PREFIX;
        L7:
            if (this.parameters.getVariant() != AesCtrHmacAeadParameters.Variant.CRUNCHY) goto L11;
            return OutputPrefixUtil.getLegacyOutputPrefix(this.idRequirement.intValue());
        L11:
            if (this.parameters.getVariant() != AesCtrHmacAeadParameters.Variant.TINK) goto L15;
            return OutputPrefixUtil.getTinkOutputPrefix(this.idRequirement.intValue());
        L15:
            throw new IllegalStateException("Unknown AesCtrHmacAeadParameters.Variant: " + this.parameters.getVariant());
        }

        public AesCtrHmacAeadKey build() throws GeneralSecurityException {
            AesCtrHmacAeadParameters r0 = this.parameters;
            if (r0 == null) goto L35;
            if (this.aesKeyBytes == null) goto L33;
            if (this.hmacKeyBytes == null) goto L33;
            if (r0.getAesKeySizeBytes() != this.aesKeyBytes.size()) goto L31;
            if (this.parameters.getHmacKeySizeBytes() != this.hmacKeyBytes.size()) goto L29;
            if (this.parameters.hasIdRequirement() == false) goto L20;
            if (this.idRequirement != null) goto L20;
            throw new GeneralSecurityException("Cannot create key without ID requirement with parameters with ID requirement");
        L20:
            if (this.parameters.hasIdRequirement() == false) goto L22;
        L26:
            Bytes r5 = getOutputPrefix();
            return new AesCtrHmacAeadKey(this.parameters, this.aesKeyBytes, this.hmacKeyBytes, r5, this.idRequirement, null);
        L22:
            if (this.idRequirement == null) goto L26;
            throw new GeneralSecurityException("Cannot create key with ID requirement with parameters without ID requirement");
        L29:
            throw new GeneralSecurityException("HMAC key size mismatch");
        L31:
            throw new GeneralSecurityException("AES key size mismatch");
        L33:
            throw new GeneralSecurityException("Cannot build without key material");
        L35:
            throw new GeneralSecurityException("Cannot build without parameters");
        }
    }

    /* synthetic */ AesCtrHmacAeadKey(AesCtrHmacAeadParameters r1, SecretBytes r2, SecretBytes r3, Bytes r4, Integer r5, AnonymousClass1 r6) {
        this(r1, r2, r3, r4, r5);
    }

    @Override // com.google.crypto.tink.aead.AeadKey, com.google.crypto.tink.Key
    public /* bridge */ /* synthetic */ Parameters getParameters() {
        return getParameters();
    }

    @Override // com.google.crypto.tink.aead.AeadKey, com.google.crypto.tink.Key
    public /* bridge */ /* synthetic */ AeadParameters getParameters() {
        return getParameters();
    }

    private AesCtrHmacAeadKey(AesCtrHmacAeadParameters parameters, SecretBytes aesKeyBytes, SecretBytes hmacKeyBytes, Bytes outputPrefix, @Nullable Integer idRequirement) {
        this.parameters = parameters;
        this.aesKeyBytes = aesKeyBytes;
        this.hmacKeyBytes = hmacKeyBytes;
        this.outputPrefix = outputPrefix;
        this.idRequirement = idRequirement;
    }

    public static Builder builder() {
        return new Builder(null);
    }

    public SecretBytes getAesKeyBytes() {
        return this.aesKeyBytes;
    }

    public SecretBytes getHmacKeyBytes() {
        return this.hmacKeyBytes;
    }

    @Override // com.google.crypto.tink.aead.AeadKey
    public Bytes getOutputPrefix() {
        return this.outputPrefix;
    }

    @Override // com.google.crypto.tink.aead.AeadKey, com.google.crypto.tink.Key
    public AesCtrHmacAeadParameters getParameters() {
        return this.parameters;
    }

    @Override // com.google.crypto.tink.Key
    @Nullable
    public Integer getIdRequirementOrNull() {
        return this.idRequirement;
    }

    @Override // com.google.crypto.tink.Key
    public boolean equalsKey(Key o) {
        if ((o instanceof AesCtrHmacAeadKey) == true) goto L5;
        return false;
    L5:
        AesCtrHmacAeadKey r4 = (AesCtrHmacAeadKey) o;
        if (r4.parameters.equals(this.parameters) == true) goto L8;
        return false;
    L8:
        if (r4.aesKeyBytes.equalsSecretBytes(this.aesKeyBytes) == true) goto L10;
        return false;
    L10:
        if (r4.hmacKeyBytes.equalsSecretBytes(this.hmacKeyBytes) == true) goto L12;
        return false;
    L12:
        if (Objects.equals(r4.idRequirement, this.idRequirement) == false) goto L18;
        return true;
    L18:
        return false;
    }
}
