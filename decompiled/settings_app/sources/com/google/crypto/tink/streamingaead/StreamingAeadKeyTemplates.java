package com.google.crypto.tink.streamingaead;

import com.google.crypto.tink.proto.AesCtrHmacStreamingKeyFormat;
import com.google.crypto.tink.proto.AesCtrHmacStreamingParams;
import com.google.crypto.tink.proto.AesGcmHkdfStreamingKeyFormat;
import com.google.crypto.tink.proto.AesGcmHkdfStreamingParams;
import com.google.crypto.tink.proto.HashType;
import com.google.crypto.tink.proto.HmacParams;
import com.google.crypto.tink.proto.KeyTemplate;
import com.google.crypto.tink.proto.OutputPrefixType;

/* JADX INFO: loaded from: classes4.dex */
@Deprecated
public final class StreamingAeadKeyTemplates {
    public static final KeyTemplate AES128_CTR_HMAC_SHA256_1MB = null;
    public static final KeyTemplate AES128_CTR_HMAC_SHA256_4KB = null;
    public static final KeyTemplate AES128_GCM_HKDF_1MB = null;
    public static final KeyTemplate AES128_GCM_HKDF_4KB = null;
    public static final KeyTemplate AES256_CTR_HMAC_SHA256_1MB = null;
    public static final KeyTemplate AES256_CTR_HMAC_SHA256_4KB = null;
    public static final KeyTemplate AES256_GCM_HKDF_1MB = null;
    public static final KeyTemplate AES256_GCM_HKDF_4KB = null;

    static {
        AES128_CTR_HMAC_SHA256_4KB = createAesCtrHmacStreamingKeyTemplate(16, HashType.SHA256, 16, HashType.SHA256, 32, 4096);
        AES128_CTR_HMAC_SHA256_1MB = createAesCtrHmacStreamingKeyTemplate(16, HashType.SHA256, 16, HashType.SHA256, 32, 1048576);
        AES256_CTR_HMAC_SHA256_4KB = createAesCtrHmacStreamingKeyTemplate(32, HashType.SHA256, 32, HashType.SHA256, 32, 4096);
        AES256_CTR_HMAC_SHA256_1MB = createAesCtrHmacStreamingKeyTemplate(32, HashType.SHA256, 32, HashType.SHA256, 32, 1048576);
        AES128_GCM_HKDF_4KB = createAesGcmHkdfStreamingKeyTemplate(16, HashType.SHA256, 16, 4096);
        AES128_GCM_HKDF_1MB = createAesGcmHkdfStreamingKeyTemplate(16, HashType.SHA256, 16, 1048576);
        AES256_GCM_HKDF_4KB = createAesGcmHkdfStreamingKeyTemplate(32, HashType.SHA256, 32, 4096);
        AES256_GCM_HKDF_1MB = createAesGcmHkdfStreamingKeyTemplate(32, HashType.SHA256, 32, 1048576);
    }

    public static KeyTemplate createAesCtrHmacStreamingKeyTemplate(int mainKeySize, HashType hkdfHashType, int derivedKeySize, HashType macHashType, int tagSize, int ciphertextSegmentSize) {
        HmacParams r4 = (HmacParams) HmacParams.newBuilder().setHash(macHashType).setTagSize(tagSize).build();
        AesCtrHmacStreamingParams r2 = (AesCtrHmacStreamingParams) AesCtrHmacStreamingParams.newBuilder().setCiphertextSegmentSize(ciphertextSegmentSize).setDerivedKeySize(derivedKeySize).setHkdfHashType(hkdfHashType).setHmacParams(r4).build();
        AesCtrHmacStreamingKeyFormat r1 = (AesCtrHmacStreamingKeyFormat) AesCtrHmacStreamingKeyFormat.newBuilder().setParams(r2).setKeySize(mainKeySize).build();
        return (KeyTemplate) KeyTemplate.newBuilder().setValue(r1.toByteString()).setTypeUrl(AesCtrHmacStreamingKeyManager.getKeyType()).setOutputPrefixType(OutputPrefixType.RAW).build();
    }

    public static KeyTemplate createAesGcmHkdfStreamingKeyTemplate(int mainKeySize, HashType hkdfHashType, int derivedKeySize, int ciphertextSegmentSize) {
        AesGcmHkdfStreamingParams r2 = (AesGcmHkdfStreamingParams) AesGcmHkdfStreamingParams.newBuilder().setCiphertextSegmentSize(ciphertextSegmentSize).setDerivedKeySize(derivedKeySize).setHkdfHashType(hkdfHashType).build();
        AesGcmHkdfStreamingKeyFormat r1 = (AesGcmHkdfStreamingKeyFormat) AesGcmHkdfStreamingKeyFormat.newBuilder().setKeySize(mainKeySize).setParams(r2).build();
        return (KeyTemplate) KeyTemplate.newBuilder().setValue(r1.toByteString()).setTypeUrl(AesGcmHkdfStreamingKeyManager.getKeyType()).setOutputPrefixType(OutputPrefixType.RAW).build();
    }

    private StreamingAeadKeyTemplates() {
    }
}
