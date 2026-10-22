package com.google.crypto.tink.prf;

import com.google.crypto.tink.internal.TinkBugException;

/* JADX INFO: loaded from: classes4.dex */
public final class PredefinedPrfParameters {
    public static final AesCmacPrfParameters AES_CMAC_PRF = null;
    public static final HkdfPrfParameters HKDF_SHA256 = null;
    public static final HmacPrfParameters HMAC_SHA256_PRF = null;
    public static final HmacPrfParameters HMAC_SHA512_PRF = null;

    private PredefinedPrfParameters() {
    }

    static {
        HKDF_SHA256 = (HkdfPrfParameters) TinkBugException.exceptionIsBug(new PredefinedPrfParameters$$ExternalSyntheticLambda0());
        HMAC_SHA256_PRF = (HmacPrfParameters) TinkBugException.exceptionIsBug(new PredefinedPrfParameters$$ExternalSyntheticLambda1());
        HMAC_SHA512_PRF = (HmacPrfParameters) TinkBugException.exceptionIsBug(new PredefinedPrfParameters$$ExternalSyntheticLambda2());
        AES_CMAC_PRF = (AesCmacPrfParameters) TinkBugException.exceptionIsBug(new PredefinedPrfParameters$$ExternalSyntheticLambda3());
    }

    static /* synthetic */ HkdfPrfParameters lambda$static$0() throws Exception {
        return HkdfPrfParameters.builder().setKeySizeBytes(32).setHashType(HkdfPrfParameters.HashType.SHA256).build();
    }

    static /* synthetic */ HmacPrfParameters lambda$static$1() throws Exception {
        return HmacPrfParameters.builder().setKeySizeBytes(32).setHashType(HmacPrfParameters.HashType.SHA256).build();
    }

    static /* synthetic */ HmacPrfParameters lambda$static$2() throws Exception {
        return HmacPrfParameters.builder().setKeySizeBytes(64).setHashType(HmacPrfParameters.HashType.SHA512).build();
    }

    static /* synthetic */ AesCmacPrfParameters lambda$static$3() throws Exception {
        return AesCmacPrfParameters.create(32);
    }
}
