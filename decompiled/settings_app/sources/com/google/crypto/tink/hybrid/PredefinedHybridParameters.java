package com.google.crypto.tink.hybrid;

import com.google.crypto.tink.aead.AesCtrHmacAeadParameters;
import com.google.crypto.tink.aead.AesGcmParameters;
import com.google.crypto.tink.internal.TinkBugException;

/* JADX INFO: loaded from: classes4.dex */
public final class PredefinedHybridParameters {
    public static final EciesParameters ECIES_P256_HKDF_HMAC_SHA256_AES128_CTR_HMAC_SHA256 = null;
    public static final EciesParameters ECIES_P256_HKDF_HMAC_SHA256_AES128_GCM = null;
    public static final EciesParameters ECIES_P256_HKDF_HMAC_SHA256_AES128_GCM_COMPRESSED_WITHOUT_PREFIX = null;

    static {
        ECIES_P256_HKDF_HMAC_SHA256_AES128_GCM = (EciesParameters) TinkBugException.exceptionIsBug(new PredefinedHybridParameters$$ExternalSyntheticLambda0());
        ECIES_P256_HKDF_HMAC_SHA256_AES128_GCM_COMPRESSED_WITHOUT_PREFIX = (EciesParameters) TinkBugException.exceptionIsBug(new PredefinedHybridParameters$$ExternalSyntheticLambda1());
        ECIES_P256_HKDF_HMAC_SHA256_AES128_CTR_HMAC_SHA256 = (EciesParameters) TinkBugException.exceptionIsBug(new PredefinedHybridParameters$$ExternalSyntheticLambda2());
    }

    static /* synthetic */ EciesParameters lambda$static$0() throws Exception {
        return EciesParameters.builder().setCurveType(EciesParameters.CurveType.NIST_P256).setHashType(EciesParameters.HashType.SHA256).setNistCurvePointFormat(EciesParameters.PointFormat.UNCOMPRESSED).setVariant(EciesParameters.Variant.TINK).setDemParameters(AesGcmParameters.builder().setIvSizeBytes(12).setKeySizeBytes(16).setTagSizeBytes(16).setVariant(AesGcmParameters.Variant.NO_PREFIX).build()).build();
    }

    static /* synthetic */ EciesParameters lambda$static$1() throws Exception {
        return EciesParameters.builder().setCurveType(EciesParameters.CurveType.NIST_P256).setHashType(EciesParameters.HashType.SHA256).setNistCurvePointFormat(EciesParameters.PointFormat.COMPRESSED).setVariant(EciesParameters.Variant.NO_PREFIX).setDemParameters(AesGcmParameters.builder().setIvSizeBytes(12).setKeySizeBytes(16).setTagSizeBytes(16).setVariant(AesGcmParameters.Variant.NO_PREFIX).build()).build();
    }

    static /* synthetic */ EciesParameters lambda$static$2() throws Exception {
        return EciesParameters.builder().setCurveType(EciesParameters.CurveType.NIST_P256).setHashType(EciesParameters.HashType.SHA256).setNistCurvePointFormat(EciesParameters.PointFormat.UNCOMPRESSED).setVariant(EciesParameters.Variant.TINK).setDemParameters(AesCtrHmacAeadParameters.builder().setAesKeySizeBytes(16).setHmacKeySizeBytes(32).setTagSizeBytes(16).setIvSizeBytes(16).setHashType(AesCtrHmacAeadParameters.HashType.SHA256).setVariant(AesCtrHmacAeadParameters.Variant.NO_PREFIX).build()).build();
    }

    private PredefinedHybridParameters() {
    }
}
