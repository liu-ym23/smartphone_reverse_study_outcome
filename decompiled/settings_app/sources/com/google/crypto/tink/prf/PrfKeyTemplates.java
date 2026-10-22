package com.google.crypto.tink.prf;

import com.google.crypto.tink.proto.AesCmacPrfKeyFormat;
import com.google.crypto.tink.proto.HashType;
import com.google.crypto.tink.proto.HkdfPrfKeyFormat;
import com.google.crypto.tink.proto.HkdfPrfParams;
import com.google.crypto.tink.proto.HmacPrfKeyFormat;
import com.google.crypto.tink.proto.HmacPrfParams;
import com.google.crypto.tink.proto.KeyTemplate;
import com.google.crypto.tink.proto.OutputPrefixType;

/* JADX INFO: loaded from: classes4.dex */
@Deprecated
public final class PrfKeyTemplates {
    public static final KeyTemplate AES_CMAC_PRF = null;
    public static final KeyTemplate HKDF_SHA256 = null;
    public static final KeyTemplate HMAC_SHA256_PRF = null;
    public static final KeyTemplate HMAC_SHA512_PRF = null;

    private PrfKeyTemplates() {
    }

    private static KeyTemplate createHkdfKeyTemplate() {
        HkdfPrfKeyFormat r0 = (HkdfPrfKeyFormat) HkdfPrfKeyFormat.newBuilder().setKeySize(32).setParams(HkdfPrfParams.newBuilder().setHash(HashType.SHA256)).build();
        return (KeyTemplate) KeyTemplate.newBuilder().setValue(r0.toByteString()).setTypeUrl(HkdfPrfKeyManager.staticKeyType()).setOutputPrefixType(OutputPrefixType.RAW).build();
    }

    private static KeyTemplate createHmacTemplate(int keySize, HashType hashType) {
        HmacPrfParams r2 = (HmacPrfParams) HmacPrfParams.newBuilder().setHash(hashType).build();
        HmacPrfKeyFormat r1 = (HmacPrfKeyFormat) HmacPrfKeyFormat.newBuilder().setParams(r2).setKeySize(keySize).build();
        return (KeyTemplate) KeyTemplate.newBuilder().setTypeUrl(HmacPrfKeyManager.getKeyType()).setValue(r1.toByteString()).setOutputPrefixType(OutputPrefixType.RAW).build();
    }

    private static KeyTemplate createAes256CmacTemplate() {
        AesCmacPrfKeyFormat r0 = (AesCmacPrfKeyFormat) AesCmacPrfKeyFormat.newBuilder().setKeySize(32).build();
        return (KeyTemplate) KeyTemplate.newBuilder().setTypeUrl(AesCmacPrfKeyManager.getKeyType()).setValue(r0.toByteString()).setOutputPrefixType(OutputPrefixType.RAW).build();
    }

    static {
        HKDF_SHA256 = createHkdfKeyTemplate();
        HMAC_SHA256_PRF = createHmacTemplate(32, HashType.SHA256);
        HMAC_SHA512_PRF = createHmacTemplate(64, HashType.SHA512);
        AES_CMAC_PRF = createAes256CmacTemplate();
    }
}
