package com.google.crypto.tink.signature;

import com.google.crypto.tink.Key;
import com.google.crypto.tink.Parameters;
import com.google.crypto.tink.internal.EllipticCurvesUtil;
import com.google.crypto.tink.internal.OutputPrefixUtil;
import com.google.crypto.tink.util.Bytes;
import com.google.errorprone.annotations.Immutable;
import java.security.GeneralSecurityException;
import java.security.spec.ECPoint;
import java.util.Objects;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Immutable
public final class EcdsaPublicKey extends SignaturePublicKey {

    @Nullable
    private final Integer idRequirement;
    private final Bytes outputPrefix;
    private final EcdsaParameters parameters;
    private final ECPoint publicPoint;

    /* JADX INFO: renamed from: com.google.crypto.tink.signature.EcdsaPublicKey$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public static class Builder {

        @Nullable
        private Integer idRequirement;

        @Nullable
        private EcdsaParameters parameters;

        @Nullable
        private ECPoint publicPoint;

        /* synthetic */ Builder(AnonymousClass1 r1) {
            this();
        }

        private Builder() {
            this.parameters = null;
            this.publicPoint = null;
            this.idRequirement = null;
        }

        public Builder setParameters(EcdsaParameters parameters) {
            this.parameters = parameters;
            return this;
        }

        public Builder setPublicPoint(ECPoint publicPoint) {
            this.publicPoint = publicPoint;
            return this;
        }

        public Builder setIdRequirement(@Nullable Integer idRequirement) {
            this.idRequirement = idRequirement;
            return this;
        }

        private Bytes getOutputPrefix() {
            if (this.parameters.getVariant() != EcdsaParameters.Variant.NO_PREFIX) goto L7;
            return OutputPrefixUtil.EMPTY_PREFIX;
        L7:
            if (this.parameters.getVariant() == EcdsaParameters.Variant.LEGACY) goto L18;
            if (this.parameters.getVariant() == EcdsaParameters.Variant.CRUNCHY) goto L18;
            if (this.parameters.getVariant() != EcdsaParameters.Variant.TINK) goto L16;
            return OutputPrefixUtil.getTinkOutputPrefix(this.idRequirement.intValue());
        L16:
            throw new IllegalStateException("Unknown EcdsaParameters.Variant: " + this.parameters.getVariant());
        L18:
            return OutputPrefixUtil.getLegacyOutputPrefix(this.idRequirement.intValue());
        }

        public EcdsaPublicKey build() throws GeneralSecurityException {
            EcdsaParameters r0 = this.parameters;
            if (r0 == null) goto L25;
            ECPoint r1 = this.publicPoint;
            if (r1 == null) goto L23;
            EllipticCurvesUtil.checkPointOnCurve(r1, r0.getCurveType().toParameterSpec().getCurve());
            if (this.parameters.hasIdRequirement() == false) goto L14;
            if (this.idRequirement != null) goto L14;
            throw new GeneralSecurityException("Cannot create key without ID requirement with parameters with ID requirement");
        L14:
            if (this.parameters.hasIdRequirement() == false) goto L16;
        L20:
            Bytes r4 = getOutputPrefix();
            return new EcdsaPublicKey(this.parameters, this.publicPoint, r4, this.idRequirement, null);
        L16:
            if (this.idRequirement == null) goto L20;
            throw new GeneralSecurityException("Cannot create key with ID requirement with parameters without ID requirement");
        L23:
            throw new GeneralSecurityException("Cannot build without public point");
        L25:
            throw new GeneralSecurityException("Cannot build without parameters");
        }
    }

    @Override // com.google.crypto.tink.signature.SignaturePublicKey, com.google.crypto.tink.Key
    public /* bridge */ /* synthetic */ Parameters getParameters() {
        return getParameters();
    }

    @Override // com.google.crypto.tink.signature.SignaturePublicKey, com.google.crypto.tink.Key
    public /* bridge */ /* synthetic */ SignatureParameters getParameters() {
        return getParameters();
    }

    /* synthetic */ EcdsaPublicKey(EcdsaParameters r1, ECPoint r2, Bytes r3, Integer r4, AnonymousClass1 r5) {
        this(r1, r2, r3, r4);
    }

    private EcdsaPublicKey(EcdsaParameters parameters, ECPoint publicPoint, Bytes outputPrefix, @Nullable Integer idRequirement) {
        this.parameters = parameters;
        this.publicPoint = publicPoint;
        this.outputPrefix = outputPrefix;
        this.idRequirement = idRequirement;
    }

    public static Builder builder() {
        return new Builder(null);
    }

    public ECPoint getPublicPoint() {
        return this.publicPoint;
    }

    @Override // com.google.crypto.tink.signature.SignaturePublicKey
    public Bytes getOutputPrefix() {
        return this.outputPrefix;
    }

    @Override // com.google.crypto.tink.signature.SignaturePublicKey, com.google.crypto.tink.Key
    public EcdsaParameters getParameters() {
        return this.parameters;
    }

    @Override // com.google.crypto.tink.Key
    @Nullable
    public Integer getIdRequirementOrNull() {
        return this.idRequirement;
    }

    @Override // com.google.crypto.tink.Key
    public boolean equalsKey(Key o) {
        if ((o instanceof EcdsaPublicKey) == true) goto L5;
        return false;
    L5:
        EcdsaPublicKey r4 = (EcdsaPublicKey) o;
        if (r4.parameters.equals(this.parameters) == true) goto L8;
        return false;
    L8:
        if (r4.publicPoint.equals(this.publicPoint) == true) goto L10;
        return false;
    L10:
        if (Objects.equals(r4.idRequirement, this.idRequirement) == false) goto L15;
        return true;
    L15:
        return false;
    }
}
