package com.google.crypto.tink.hybrid;

import com.google.crypto.tink.Key;
import com.google.crypto.tink.Parameters;
import com.google.crypto.tink.internal.EllipticCurvesUtil;
import com.google.crypto.tink.internal.OutputPrefixUtil;
import com.google.crypto.tink.subtle.EllipticCurves;
import com.google.crypto.tink.util.Bytes;
import com.google.errorprone.annotations.Immutable;
import java.security.GeneralSecurityException;
import java.security.spec.ECPoint;
import java.security.spec.EllipticCurve;
import java.util.Objects;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Immutable
public final class EciesPublicKey extends HybridPublicKey {

    @Nullable
    private final Integer idRequirement;

    @Nullable
    private final ECPoint nistPublicPoint;
    private final Bytes outputPrefix;
    private final EciesParameters parameters;

    @Nullable
    private final Bytes x25519PublicPointBytes;

    @Override // com.google.crypto.tink.hybrid.HybridPublicKey, com.google.crypto.tink.Key
    public /* bridge */ /* synthetic */ Parameters getParameters() {
        return getParameters();
    }

    @Override // com.google.crypto.tink.hybrid.HybridPublicKey, com.google.crypto.tink.Key
    public /* bridge */ /* synthetic */ HybridParameters getParameters() {
        return getParameters();
    }

    private EciesPublicKey(EciesParameters parameters, @Nullable ECPoint nistPublicPoint, @Nullable Bytes x25519PublicPointBytes, Bytes outputPrefix, @Nullable Integer idRequirement) {
        this.parameters = parameters;
        this.nistPublicPoint = nistPublicPoint;
        this.x25519PublicPointBytes = x25519PublicPointBytes;
        this.outputPrefix = outputPrefix;
        this.idRequirement = idRequirement;
    }

    private static void validateIdRequirement(EciesParameters.Variant variant, @Nullable Integer idRequirement) throws GeneralSecurityException {
        if (variant.equals(EciesParameters.Variant.NO_PREFIX) == true) goto L9;
        if (idRequirement != null) goto L9;
        throw new GeneralSecurityException("'idRequirement' must be non-null for " + variant + " variant.");
    L9:
        if (variant.equals(EciesParameters.Variant.NO_PREFIX) == false) goto L14;
        if (idRequirement != null) goto L13;
        return;
    L13:
        throw new GeneralSecurityException("'idRequirement' must be null for NO_PREFIX variant.");
    }

    private static EllipticCurve getParameterSpecNistCurve(EciesParameters.CurveType curveType) {
        if (curveType != EciesParameters.CurveType.NIST_P256) goto L7;
        return EllipticCurves.getNistP256Params().getCurve();
    L7:
        if (curveType != EciesParameters.CurveType.NIST_P384) goto L11;
        return EllipticCurves.getNistP384Params().getCurve();
    L11:
        if (curveType != EciesParameters.CurveType.NIST_P521) goto L15;
        return EllipticCurves.getNistP521Params().getCurve();
    L15:
        throw new IllegalArgumentException("Unable to determine NIST curve type for " + curveType);
    }

    private static Bytes createOutputPrefix(EciesParameters.Variant variant, @Nullable Integer idRequirement) {
        if (variant == EciesParameters.Variant.NO_PREFIX) goto L5;
        if (idRequirement == null) goto L18;
        if (variant != EciesParameters.Variant.CRUNCHY) goto L12;
        return OutputPrefixUtil.getLegacyOutputPrefix(idRequirement.intValue());
    L12:
        if (variant != EciesParameters.Variant.TINK) goto L16;
        return OutputPrefixUtil.getTinkOutputPrefix(idRequirement.intValue());
    L16:
        throw new IllegalStateException("Unknown EciesParameters.Variant: " + variant);
    L18:
        throw new IllegalStateException("idRequirement must be non-null for EciesParameters.Variant: " + variant);
    L5:
        return OutputPrefixUtil.EMPTY_PREFIX;
    }

    public static EciesPublicKey createForCurveX25519(EciesParameters parameters, Bytes publicPointBytes, @Nullable Integer idRequirement) throws GeneralSecurityException {
        if (parameters.getCurveType().equals(EciesParameters.CurveType.X25519) == false) goto L11;
        validateIdRequirement(parameters.getVariant(), idRequirement);
        if (publicPointBytes.size() != 32) goto L9;
        return new EciesPublicKey(parameters, null, publicPointBytes, createOutputPrefix(parameters.getVariant(), idRequirement), idRequirement);
    L9:
        throw new GeneralSecurityException("Encoded public point byte length for X25519 curve must be 32");
    L11:
        throw new GeneralSecurityException("createForCurveX25519 may only be called with parameters for curve X25519");
    }

    public static EciesPublicKey createForNistCurve(EciesParameters parameters, ECPoint publicPoint, @Nullable Integer idRequirement) throws GeneralSecurityException {
        if (parameters.getCurveType().equals(EciesParameters.CurveType.X25519) == true) goto L7;
        validateIdRequirement(parameters.getVariant(), idRequirement);
        EllipticCurvesUtil.checkPointOnCurve(publicPoint, getParameterSpecNistCurve(parameters.getCurveType()));
        return new EciesPublicKey(parameters, publicPoint, null, createOutputPrefix(parameters.getVariant(), idRequirement), idRequirement);
    L7:
        throw new GeneralSecurityException("createForNistCurve may only be called with parameters for NIST curve");
    }

    @Nullable
    public ECPoint getNistCurvePoint() {
        return this.nistPublicPoint;
    }

    @Nullable
    public Bytes getX25519CurvePointBytes() {
        return this.x25519PublicPointBytes;
    }

    @Override // com.google.crypto.tink.hybrid.HybridPublicKey
    public Bytes getOutputPrefix() {
        return this.outputPrefix;
    }

    @Override // com.google.crypto.tink.hybrid.HybridPublicKey, com.google.crypto.tink.Key
    public EciesParameters getParameters() {
        return this.parameters;
    }

    @Override // com.google.crypto.tink.Key
    @Nullable
    public Integer getIdRequirementOrNull() {
        return this.idRequirement;
    }

    @Override // com.google.crypto.tink.Key
    public boolean equalsKey(Key o) {
        if ((o instanceof EciesPublicKey) == true) goto L5;
        return false;
    L5:
        EciesPublicKey r4 = (EciesPublicKey) o;
        if (this.parameters.equals(r4.parameters) == true) goto L8;
        return false;
    L8:
        if (Objects.equals(this.x25519PublicPointBytes, r4.x25519PublicPointBytes) == true) goto L10;
        return false;
    L10:
        if (Objects.equals(this.nistPublicPoint, r4.nistPublicPoint) == true) goto L12;
        return false;
    L12:
        if (Objects.equals(this.idRequirement, r4.idRequirement) == false) goto L18;
        return true;
    L18:
        return false;
    }
}
