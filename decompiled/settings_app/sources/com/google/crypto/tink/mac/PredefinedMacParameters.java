package com.google.crypto.tink.mac;

import com.google.crypto.tink.internal.TinkBugException;

/* JADX INFO: loaded from: classes4.dex */
public final class PredefinedMacParameters {
    public static final AesCmacParameters AES_CMAC = null;
    public static final HmacParameters HMAC_SHA256_128BITTAG = null;
    public static final HmacParameters HMAC_SHA256_256BITTAG = null;
    public static final HmacParameters HMAC_SHA512_256BITTAG = null;
    public static final HmacParameters HMAC_SHA512_512BITTAG = null;

    static {
        HMAC_SHA256_128BITTAG = (HmacParameters) TinkBugException.exceptionIsBug(new PredefinedMacParameters$$ExternalSyntheticLambda0());
        HMAC_SHA256_256BITTAG = (HmacParameters) TinkBugException.exceptionIsBug(new PredefinedMacParameters$$ExternalSyntheticLambda1());
        HMAC_SHA512_256BITTAG = (HmacParameters) TinkBugException.exceptionIsBug(new PredefinedMacParameters$$ExternalSyntheticLambda2());
        HMAC_SHA512_512BITTAG = (HmacParameters) TinkBugException.exceptionIsBug(new PredefinedMacParameters$$ExternalSyntheticLambda3());
        AES_CMAC = (AesCmacParameters) TinkBugException.exceptionIsBug(new PredefinedMacParameters$$ExternalSyntheticLambda4());
    }

    static /* synthetic */ HmacParameters lambda$static$0() throws Exception {
        return HmacParameters.builder().setKeySizeBytes(32).setTagSizeBytes(16).setVariant(HmacParameters.Variant.TINK).setHashType(HmacParameters.HashType.SHA256).build();
    }

    static /* synthetic */ HmacParameters lambda$static$1() throws Exception {
        return HmacParameters.builder().setKeySizeBytes(32).setTagSizeBytes(32).setVariant(HmacParameters.Variant.TINK).setHashType(HmacParameters.HashType.SHA256).build();
    }

    static /* synthetic */ HmacParameters lambda$static$2() throws Exception {
        return HmacParameters.builder().setKeySizeBytes(64).setTagSizeBytes(32).setVariant(HmacParameters.Variant.TINK).setHashType(HmacParameters.HashType.SHA512).build();
    }

    static /* synthetic */ HmacParameters lambda$static$3() throws Exception {
        return HmacParameters.builder().setKeySizeBytes(64).setTagSizeBytes(64).setVariant(HmacParameters.Variant.TINK).setHashType(HmacParameters.HashType.SHA512).build();
    }

    static /* synthetic */ AesCmacParameters lambda$static$4() throws Exception {
        return AesCmacParameters.builder().setKeySizeBytes(32).setTagSizeBytes(16).setVariant(AesCmacParameters.Variant.TINK).build();
    }

    private PredefinedMacParameters() {
    }
}
