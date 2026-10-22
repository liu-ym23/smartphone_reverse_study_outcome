package com.google.crypto.tink.streamingaead;

import com.google.crypto.tink.internal.TinkBugException;

/* JADX INFO: loaded from: classes4.dex */
public final class PredefinedStreamingAeadParameters {
    public static final AesCtrHmacStreamingParameters AES128_CTR_HMAC_SHA256_1MB = null;
    public static final AesCtrHmacStreamingParameters AES128_CTR_HMAC_SHA256_4KB = null;
    public static final AesGcmHkdfStreamingParameters AES128_GCM_HKDF_1MB = null;
    public static final AesGcmHkdfStreamingParameters AES128_GCM_HKDF_4KB = null;
    public static final AesCtrHmacStreamingParameters AES256_CTR_HMAC_SHA256_1MB = null;
    public static final AesCtrHmacStreamingParameters AES256_CTR_HMAC_SHA256_4KB = null;
    public static final AesGcmHkdfStreamingParameters AES256_GCM_HKDF_1MB = null;
    public static final AesGcmHkdfStreamingParameters AES256_GCM_HKDF_4KB = null;

    static {
        AES128_CTR_HMAC_SHA256_4KB = (AesCtrHmacStreamingParameters) TinkBugException.exceptionIsBug(new PredefinedStreamingAeadParameters$$ExternalSyntheticLambda0());
        AES128_CTR_HMAC_SHA256_1MB = (AesCtrHmacStreamingParameters) TinkBugException.exceptionIsBug(new PredefinedStreamingAeadParameters$$ExternalSyntheticLambda1());
        AES256_CTR_HMAC_SHA256_4KB = (AesCtrHmacStreamingParameters) TinkBugException.exceptionIsBug(new PredefinedStreamingAeadParameters$$ExternalSyntheticLambda2());
        AES256_CTR_HMAC_SHA256_1MB = (AesCtrHmacStreamingParameters) TinkBugException.exceptionIsBug(new PredefinedStreamingAeadParameters$$ExternalSyntheticLambda3());
        AES128_GCM_HKDF_4KB = (AesGcmHkdfStreamingParameters) TinkBugException.exceptionIsBug(new PredefinedStreamingAeadParameters$$ExternalSyntheticLambda4());
        AES128_GCM_HKDF_1MB = (AesGcmHkdfStreamingParameters) TinkBugException.exceptionIsBug(new PredefinedStreamingAeadParameters$$ExternalSyntheticLambda5());
        AES256_GCM_HKDF_4KB = (AesGcmHkdfStreamingParameters) TinkBugException.exceptionIsBug(new PredefinedStreamingAeadParameters$$ExternalSyntheticLambda6());
        AES256_GCM_HKDF_1MB = (AesGcmHkdfStreamingParameters) TinkBugException.exceptionIsBug(new PredefinedStreamingAeadParameters$$ExternalSyntheticLambda7());
    }

    static /* synthetic */ AesCtrHmacStreamingParameters lambda$static$0() throws Exception {
        return AesCtrHmacStreamingParameters.builder().setKeySizeBytes(16).setDerivedKeySizeBytes(16).setHkdfHashType(AesCtrHmacStreamingParameters.HashType.SHA256).setHmacHashType(AesCtrHmacStreamingParameters.HashType.SHA256).setHmacTagSizeBytes(32).setCiphertextSegmentSizeBytes(4096).build();
    }

    static /* synthetic */ AesCtrHmacStreamingParameters lambda$static$1() throws Exception {
        return AesCtrHmacStreamingParameters.builder().setKeySizeBytes(16).setDerivedKeySizeBytes(16).setHkdfHashType(AesCtrHmacStreamingParameters.HashType.SHA256).setHmacHashType(AesCtrHmacStreamingParameters.HashType.SHA256).setHmacTagSizeBytes(32).setCiphertextSegmentSizeBytes(1048576).build();
    }

    static /* synthetic */ AesCtrHmacStreamingParameters lambda$static$2() throws Exception {
        return AesCtrHmacStreamingParameters.builder().setKeySizeBytes(32).setDerivedKeySizeBytes(32).setHkdfHashType(AesCtrHmacStreamingParameters.HashType.SHA256).setHmacHashType(AesCtrHmacStreamingParameters.HashType.SHA256).setHmacTagSizeBytes(32).setCiphertextSegmentSizeBytes(4096).build();
    }

    static /* synthetic */ AesCtrHmacStreamingParameters lambda$static$3() throws Exception {
        return AesCtrHmacStreamingParameters.builder().setKeySizeBytes(32).setDerivedKeySizeBytes(32).setHkdfHashType(AesCtrHmacStreamingParameters.HashType.SHA256).setHmacHashType(AesCtrHmacStreamingParameters.HashType.SHA256).setHmacTagSizeBytes(32).setCiphertextSegmentSizeBytes(1048576).build();
    }

    static /* synthetic */ AesGcmHkdfStreamingParameters lambda$static$4() throws Exception {
        return AesGcmHkdfStreamingParameters.builder().setKeySizeBytes(16).setDerivedAesGcmKeySizeBytes(16).setHkdfHashType(AesGcmHkdfStreamingParameters.HashType.SHA256).setCiphertextSegmentSizeBytes(4096).build();
    }

    static /* synthetic */ AesGcmHkdfStreamingParameters lambda$static$5() throws Exception {
        return AesGcmHkdfStreamingParameters.builder().setKeySizeBytes(16).setDerivedAesGcmKeySizeBytes(16).setHkdfHashType(AesGcmHkdfStreamingParameters.HashType.SHA256).setCiphertextSegmentSizeBytes(1048576).build();
    }

    static /* synthetic */ AesGcmHkdfStreamingParameters lambda$static$6() throws Exception {
        return AesGcmHkdfStreamingParameters.builder().setKeySizeBytes(32).setDerivedAesGcmKeySizeBytes(32).setHkdfHashType(AesGcmHkdfStreamingParameters.HashType.SHA256).setCiphertextSegmentSizeBytes(4096).build();
    }

    static /* synthetic */ AesGcmHkdfStreamingParameters lambda$static$7() throws Exception {
        return AesGcmHkdfStreamingParameters.builder().setKeySizeBytes(32).setDerivedAesGcmKeySizeBytes(32).setHkdfHashType(AesGcmHkdfStreamingParameters.HashType.SHA256).setCiphertextSegmentSizeBytes(1048576).build();
    }

    private PredefinedStreamingAeadParameters() {
    }
}
