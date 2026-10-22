package com.google.crypto.tink.signature;

import com.google.crypto.tink.Key;
import com.google.crypto.tink.Parameters;
import com.google.crypto.tink.internal.OutputPrefixUtil;
import com.google.crypto.tink.util.Bytes;
import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.util.Objects;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class RsaSsaPssPublicKey extends SignaturePublicKey {

    @Nullable
    private final Integer idRequirement;
    private final BigInteger modulus;
    private final Bytes outputPrefix;
    private final RsaSsaPssParameters parameters;

    /* JADX INFO: renamed from: com.google.crypto.tink.signature.RsaSsaPssPublicKey$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public static class Builder {

        @Nullable
        private Integer idRequirement;

        @Nullable
        private BigInteger modulus;

        @Nullable
        private RsaSsaPssParameters parameters;

        /* synthetic */ Builder(AnonymousClass1 r1) {
            this();
        }

        private Builder() {
            this.parameters = null;
            this.modulus = null;
            this.idRequirement = null;
        }

        public Builder setParameters(RsaSsaPssParameters parameters) {
            this.parameters = parameters;
            return this;
        }

        public Builder setModulus(BigInteger modulus) {
            this.modulus = modulus;
            return this;
        }

        public Builder setIdRequirement(@Nullable Integer idRequirement) {
            this.idRequirement = idRequirement;
            return this;
        }

        private Bytes getOutputPrefix() {
            if (this.parameters.getVariant() != RsaSsaPssParameters.Variant.NO_PREFIX) goto L7;
            return OutputPrefixUtil.EMPTY_PREFIX;
        L7:
            if (this.parameters.getVariant() == RsaSsaPssParameters.Variant.LEGACY) goto L18;
            if (this.parameters.getVariant() == RsaSsaPssParameters.Variant.CRUNCHY) goto L18;
            if (this.parameters.getVariant() != RsaSsaPssParameters.Variant.TINK) goto L16;
            return OutputPrefixUtil.getTinkOutputPrefix(this.idRequirement.intValue());
        L16:
            throw new IllegalStateException("Unknown RsaSsaPssParameters.Variant: " + this.parameters.getVariant());
        L18:
            return OutputPrefixUtil.getLegacyOutputPrefix(this.idRequirement.intValue());
        }

        public RsaSsaPssPublicKey build() throws GeneralSecurityException {
            if (this.parameters == null) goto L29;
            BigInteger r0 = this.modulus;
            if (r0 == null) goto L27;
            int r1 = r0.bitLength();
            int r2 = this.parameters.getModulusSizeBits();
            if (r1 != r2) goto L25;
            if (this.parameters.hasIdRequirement() == false) goto L16;
            if (this.idRequirement != null) goto L16;
            throw new GeneralSecurityException("Cannot create key without ID requirement with parameters with ID requirement");
        L16:
            if (this.parameters.hasIdRequirement() == true) goto L23;
            if (this.idRequirement == null) goto L23;
            throw new GeneralSecurityException("Cannot create key with ID requirement with parameters without ID requirement");
        L23:
            return new RsaSsaPssPublicKey(this.parameters, this.modulus, getOutputPrefix(), this.idRequirement, null);
        L25:
            throw new GeneralSecurityException("Got modulus size " + r1 + ", but parameters requires modulus size " + r2);
        L27:
            throw new GeneralSecurityException("Cannot build without modulus");
        L29:
            throw new GeneralSecurityException("Cannot build without parameters");
        }
    }

    /* synthetic */ RsaSsaPssPublicKey(RsaSsaPssParameters r1, BigInteger r2, Bytes r3, Integer r4, AnonymousClass1 r5) {
        this(r1, r2, r3, r4);
    }

    @Override // com.google.crypto.tink.signature.SignaturePublicKey, com.google.crypto.tink.Key
    public /* bridge */ /* synthetic */ Parameters getParameters() {
        return getParameters();
    }

    @Override // com.google.crypto.tink.signature.SignaturePublicKey, com.google.crypto.tink.Key
    public /* bridge */ /* synthetic */ SignatureParameters getParameters() {
        return getParameters();
    }

    private RsaSsaPssPublicKey(RsaSsaPssParameters parameters, BigInteger modulus, Bytes outputPrefix, @Nullable Integer idRequirement) {
        this.parameters = parameters;
        this.modulus = modulus;
        this.outputPrefix = outputPrefix;
        this.idRequirement = idRequirement;
    }

    public static Builder builder() {
        return new Builder(null);
    }

    public BigInteger getModulus() {
        return this.modulus;
    }

    @Override // com.google.crypto.tink.signature.SignaturePublicKey
    public Bytes getOutputPrefix() {
        return this.outputPrefix;
    }

    @Override // com.google.crypto.tink.signature.SignaturePublicKey, com.google.crypto.tink.Key
    public RsaSsaPssParameters getParameters() {
        return this.parameters;
    }

    @Override // com.google.crypto.tink.Key
    @Nullable
    public Integer getIdRequirementOrNull() {
        return this.idRequirement;
    }

    @Override // com.google.crypto.tink.Key
    public boolean equalsKey(Key o) {
        if ((o instanceof RsaSsaPssPublicKey) == true) goto L5;
        return false;
    L5:
        RsaSsaPssPublicKey r4 = (RsaSsaPssPublicKey) o;
        if (r4.parameters.equals(this.parameters) == true) goto L8;
        return false;
    L8:
        if (r4.modulus.equals(this.modulus) == true) goto L10;
        return false;
    L10:
        if (Objects.equals(r4.idRequirement, this.idRequirement) == false) goto L15;
        return true;
    L15:
        return false;
    }
}
