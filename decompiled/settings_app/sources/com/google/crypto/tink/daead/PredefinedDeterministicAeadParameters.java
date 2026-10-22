package com.google.crypto.tink.daead;

import com.google.crypto.tink.internal.TinkBugException;

/* JADX INFO: loaded from: classes4.dex */
public final class PredefinedDeterministicAeadParameters {
    public static final AesSivParameters AES256_SIV = null;

    static {
        AES256_SIV = (AesSivParameters) TinkBugException.exceptionIsBug(new PredefinedDeterministicAeadParameters$$ExternalSyntheticLambda0());
    }

    static /* synthetic */ AesSivParameters lambda$static$0() throws Exception {
        return AesSivParameters.builder().setKeySizeBytes(64).setVariant(AesSivParameters.Variant.TINK).build();
    }

    private PredefinedDeterministicAeadParameters() {
    }
}
