package com.google.crypto.tink.aead;

import com.google.crypto.tink.internal.TinkBugException;

/* JADX INFO: loaded from: classes4.dex */
public final class PredefinedAeadParameters {
    public static final AesCtrHmacAeadParameters AES128_CTR_HMAC_SHA256 = null;
    public static final AesEaxParameters AES128_EAX = null;
    public static final AesGcmParameters AES128_GCM = null;
    public static final AesCtrHmacAeadParameters AES256_CTR_HMAC_SHA256 = null;
    public static final AesEaxParameters AES256_EAX = null;
    public static final AesGcmParameters AES256_GCM = null;
    public static final ChaCha20Poly1305Parameters CHACHA20_POLY1305 = null;
    public static final XChaCha20Poly1305Parameters XCHACHA20_POLY1305 = null;

    static {
        AES128_GCM = (AesGcmParameters) TinkBugException.exceptionIsBug(new PredefinedAeadParameters$$ExternalSyntheticLambda0());
        AES256_GCM = (AesGcmParameters) TinkBugException.exceptionIsBug(new PredefinedAeadParameters$$ExternalSyntheticLambda1());
        AES128_EAX = (AesEaxParameters) TinkBugException.exceptionIsBug(new PredefinedAeadParameters$$ExternalSyntheticLambda2());
        AES256_EAX = (AesEaxParameters) TinkBugException.exceptionIsBug(new PredefinedAeadParameters$$ExternalSyntheticLambda3());
        AES128_CTR_HMAC_SHA256 = (AesCtrHmacAeadParameters) TinkBugException.exceptionIsBug(new PredefinedAeadParameters$$ExternalSyntheticLambda4());
        AES256_CTR_HMAC_SHA256 = (AesCtrHmacAeadParameters) TinkBugException.exceptionIsBug(new PredefinedAeadParameters$$ExternalSyntheticLambda5());
        CHACHA20_POLY1305 = ChaCha20Poly1305Parameters.create(ChaCha20Poly1305Parameters.Variant.TINK);
        XCHACHA20_POLY1305 = XChaCha20Poly1305Parameters.create(XChaCha20Poly1305Parameters.Variant.TINK);
    }

    static /* synthetic */ AesGcmParameters lambda$static$0() throws Exception {
        return AesGcmParameters.builder().setIvSizeBytes(12).setKeySizeBytes(16).setTagSizeBytes(16).setVariant(AesGcmParameters.Variant.TINK).build();
    }

    static /* synthetic */ AesGcmParameters lambda$static$1() throws Exception {
        return AesGcmParameters.builder().setIvSizeBytes(12).setKeySizeBytes(32).setTagSizeBytes(16).setVariant(AesGcmParameters.Variant.TINK).build();
    }

    static /* synthetic */ AesEaxParameters lambda$static$2() throws Exception {
        return AesEaxParameters.builder().setIvSizeBytes(16).setKeySizeBytes(16).setTagSizeBytes(16).setVariant(AesEaxParameters.Variant.TINK).build();
    }

    static /* synthetic */ AesEaxParameters lambda$static$3() throws Exception {
        return AesEaxParameters.builder().setIvSizeBytes(16).setKeySizeBytes(32).setTagSizeBytes(16).setVariant(AesEaxParameters.Variant.TINK).build();
    }

    static /* synthetic */ AesCtrHmacAeadParameters lambda$static$4() throws Exception {
        return AesCtrHmacAeadParameters.builder().setAesKeySizeBytes(16).setHmacKeySizeBytes(32).setTagSizeBytes(16).setIvSizeBytes(16).setHashType(AesCtrHmacAeadParameters.HashType.SHA256).setVariant(AesCtrHmacAeadParameters.Variant.TINK).build();
    }

    static /* synthetic */ AesCtrHmacAeadParameters lambda$static$5() throws Exception {
        return AesCtrHmacAeadParameters.builder().setAesKeySizeBytes(32).setHmacKeySizeBytes(32).setTagSizeBytes(32).setIvSizeBytes(16).setHashType(AesCtrHmacAeadParameters.HashType.SHA256).setVariant(AesCtrHmacAeadParameters.Variant.TINK).build();
    }

    private PredefinedAeadParameters() {
    }
}
