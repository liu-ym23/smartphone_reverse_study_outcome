package com.google.crypto.tink.hybrid;

import com.google.crypto.tink.Key;
import com.google.crypto.tink.Parameters;
import com.google.crypto.tink.internal.EllipticCurvesUtil;
import com.google.crypto.tink.internal.OutputPrefixUtil;
import com.google.crypto.tink.subtle.EllipticCurves;
import com.google.crypto.tink.util.Bytes;
import com.google.errorprone.annotations.Immutable;
import java.security.GeneralSecurityException;
import java.security.spec.EllipticCurve;
import java.util.Objects;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Immutable
public final class HpkePublicKey extends HybridPublicKey {

    @Nullable
    private final Integer idRequirement;
    private final Bytes outputPrefix;
    private final HpkeParameters parameters;
    private final Bytes publicKeyBytes;

    @Override // com.google.crypto.tink.hybrid.HybridPublicKey, com.google.crypto.tink.Key
    public /* bridge */ /* synthetic */ Parameters getParameters() {
        return getParameters();
    }

    @Override // com.google.crypto.tink.hybrid.HybridPublicKey, com.google.crypto.tink.Key
    public /* bridge */ /* synthetic */ HybridParameters getParameters() {
        return getParameters();
    }

    private HpkePublicKey(HpkeParameters parameters, Bytes publicKeyBytes, Bytes outputPrefix, @Nullable Integer idRequirement) {
        this.parameters = parameters;
        this.publicKeyBytes = publicKeyBytes;
        this.outputPrefix = outputPrefix;
        this.idRequirement = idRequirement;
    }

    private static void validateIdRequirement(HpkeParameters.Variant variant, @Nullable Integer idRequirement) throws GeneralSecurityException {
        if (variant.equals(HpkeParameters.Variant.NO_PREFIX) == true) goto L9;
        if (idRequirement != null) goto L9;
        throw new GeneralSecurityException("'idRequirement' must be non-null for " + variant + " variant.");
    L9:
        if (variant.equals(HpkeParameters.Variant.NO_PREFIX) == false) goto L14;
        if (idRequirement != null) goto L13;
        return;
    L13:
        throw new GeneralSecurityException("'idRequirement' must be null for NO_PREFIX variant.");
    }

    private static void validatePublicKeyByteLength(HpkeParameters.KemId kemId, Bytes publicKeyBytes) throws GeneralSecurityException {
        int r5 = publicKeyBytes.size();
        String r0 = "Encoded public key byte length for " + kemId + " must be %d, not " + r5;
        if (kemId != HpkeParameters.KemId.DHKEM_P256_HKDF_SHA256) goto L10;
        if (r5 != 65) goto L8;
        return;
    L8:
        throw new GeneralSecurityException(String.format(r0, new Object[]{65}));
    L10:
        if (kemId != HpkeParameters.KemId.DHKEM_P384_HKDF_SHA384) goto L17;
        if (r5 != 97) goto L15;
        return;
    L15:
        throw new GeneralSecurityException(String.format(r0, new Object[]{97}));
    L17:
        if (kemId != HpkeParameters.KemId.DHKEM_P521_HKDF_SHA512) goto L24;
        if (r5 != 133) goto L22;
        return;
    L22:
        throw new GeneralSecurityException(String.format(r0, new Object[]{133}));
    L24:
        if (kemId != HpkeParameters.KemId.DHKEM_X25519_HKDF_SHA256) goto L31;
        if (r5 != 32) goto L29;
        return;
    L29:
        throw new GeneralSecurityException(String.format(r0, new Object[]{32}));
    L31:
        throw new GeneralSecurityException("Unable to validate public key length for " + kemId);
    }

    private static boolean isNistKem(HpkeParameters.KemId kemId) {
        if (kemId != HpkeParameters.KemId.DHKEM_P256_HKDF_SHA256) goto L5;
    L10:
        return true;
    L5:
        if (kemId == HpkeParameters.KemId.DHKEM_P384_HKDF_SHA384) goto L10;
        if (kemId == HpkeParameters.KemId.DHKEM_P521_HKDF_SHA512) goto L10;
        return false;
    }

    private static EllipticCurve getNistCurve(HpkeParameters.KemId kemId) {
        if (kemId != HpkeParameters.KemId.DHKEM_P256_HKDF_SHA256) goto L7;
        return EllipticCurves.getNistP256Params().getCurve();
    L7:
        if (kemId != HpkeParameters.KemId.DHKEM_P384_HKDF_SHA384) goto L11;
        return EllipticCurves.getNistP384Params().getCurve();
    L11:
        if (kemId != HpkeParameters.KemId.DHKEM_P521_HKDF_SHA512) goto L15;
        return EllipticCurves.getNistP521Params().getCurve();
    L15:
        throw new IllegalArgumentException("Unable to determine NIST curve type for " + kemId);
    }

    private static void validatePublicKeyOnCurve(HpkeParameters.KemId kemId, Bytes publicKeyBytes) throws GeneralSecurityException {
        if (isNistKem(kemId) == true) goto L5;
        return;
    L5:
        EllipticCurve r1 = getNistCurve(kemId);
        EllipticCurvesUtil.checkPointOnCurve(EllipticCurves.pointDecode(r1, EllipticCurves.PointFormatType.UNCOMPRESSED, publicKeyBytes.toByteArray()), r1);
    }

    private static void validatePublicKey(HpkeParameters.KemId kemId, Bytes publicKeyBytes) throws GeneralSecurityException {
        validatePublicKeyByteLength(kemId, publicKeyBytes);
        validatePublicKeyOnCurve(kemId, publicKeyBytes);
    }

    private static Bytes createOutputPrefix(HpkeParameters.Variant variant, @Nullable Integer idRequirement) {
        if (variant == HpkeParameters.Variant.NO_PREFIX) goto L5;
        if (idRequirement == null) goto L18;
        if (variant != HpkeParameters.Variant.CRUNCHY) goto L12;
        return OutputPrefixUtil.getLegacyOutputPrefix(idRequirement.intValue());
    L12:
        if (variant != HpkeParameters.Variant.TINK) goto L16;
        return OutputPrefixUtil.getTinkOutputPrefix(idRequirement.intValue());
    L16:
        throw new IllegalStateException("Unknown HpkeParameters.Variant: " + variant);
    L18:
        throw new IllegalStateException("idRequirement must be non-null for HpkeParameters.Variant " + variant);
    L5:
        return OutputPrefixUtil.EMPTY_PREFIX;
    }

    public static HpkePublicKey create(HpkeParameters parameters, Bytes publicKeyBytes, @Nullable Integer idRequirement) throws GeneralSecurityException {
        validateIdRequirement(parameters.getVariant(), idRequirement);
        validatePublicKey(parameters.getKemId(), publicKeyBytes);
        return new HpkePublicKey(parameters, publicKeyBytes, createOutputPrefix(parameters.getVariant(), idRequirement), idRequirement);
    }

    public Bytes getPublicKeyBytes() {
        return this.publicKeyBytes;
    }

    @Override // com.google.crypto.tink.hybrid.HybridPublicKey
    public Bytes getOutputPrefix() {
        return this.outputPrefix;
    }

    @Override // com.google.crypto.tink.hybrid.HybridPublicKey, com.google.crypto.tink.Key
    public HpkeParameters getParameters() {
        return this.parameters;
    }

    @Override // com.google.crypto.tink.Key
    @Nullable
    public Integer getIdRequirementOrNull() {
        return this.idRequirement;
    }

    @Override // com.google.crypto.tink.Key
    public boolean equalsKey(Key o) {
        if ((o instanceof HpkePublicKey) == true) goto L5;
        return false;
    L5:
        HpkePublicKey r4 = (HpkePublicKey) o;
        if (this.parameters.equals(r4.parameters) == true) goto L8;
        return false;
    L8:
        if (this.publicKeyBytes.equals(r4.publicKeyBytes) == true) goto L10;
        return false;
    L10:
        if (Objects.equals(this.idRequirement, r4.idRequirement) == false) goto L15;
        return true;
    L15:
        return false;
    }
}
