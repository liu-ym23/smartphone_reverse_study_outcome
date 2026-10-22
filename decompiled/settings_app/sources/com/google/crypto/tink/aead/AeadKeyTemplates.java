package com.google.crypto.tink.aead;

import com.google.crypto.tink.proto.AesCtrHmacAeadKeyFormat;
import com.google.crypto.tink.proto.AesCtrKeyFormat;
import com.google.crypto.tink.proto.AesCtrParams;
import com.google.crypto.tink.proto.AesEaxKeyFormat;
import com.google.crypto.tink.proto.AesEaxParams;
import com.google.crypto.tink.proto.AesGcmKeyFormat;
import com.google.crypto.tink.proto.HashType;
import com.google.crypto.tink.proto.HmacKeyFormat;
import com.google.crypto.tink.proto.HmacParams;
import com.google.crypto.tink.proto.KeyTemplate;
import com.google.crypto.tink.proto.KmsEnvelopeAeadKeyFormat;
import com.google.crypto.tink.proto.OutputPrefixType;

/* JADX INFO: loaded from: classes4.dex */
public final class AeadKeyTemplates {
    public static final KeyTemplate AES128_CTR_HMAC_SHA256 = null;
    public static final KeyTemplate AES128_EAX = null;
    public static final KeyTemplate AES128_GCM = null;
    public static final KeyTemplate AES256_CTR_HMAC_SHA256 = null;
    public static final KeyTemplate AES256_EAX = null;
    public static final KeyTemplate AES256_GCM = null;
    public static final KeyTemplate CHACHA20_POLY1305 = null;
    public static final KeyTemplate XCHACHA20_POLY1305 = null;

    static {
        AES128_GCM = createAesGcmKeyTemplate(16);
        AES256_GCM = createAesGcmKeyTemplate(32);
        AES128_EAX = createAesEaxKeyTemplate(16, 16);
        AES256_EAX = createAesEaxKeyTemplate(32, 16);
        AES128_CTR_HMAC_SHA256 = createAesCtrHmacAeadKeyTemplate(16, 16, 32, 16, HashType.SHA256);
        AES256_CTR_HMAC_SHA256 = createAesCtrHmacAeadKeyTemplate(32, 16, 32, 32, HashType.SHA256);
        CHACHA20_POLY1305 = (KeyTemplate) KeyTemplate.newBuilder().setTypeUrl(ChaCha20Poly1305KeyManager.getKeyType()).setOutputPrefixType(OutputPrefixType.TINK).build();
        XCHACHA20_POLY1305 = (KeyTemplate) KeyTemplate.newBuilder().setTypeUrl(XChaCha20Poly1305KeyManager.getKeyType()).setOutputPrefixType(OutputPrefixType.TINK).build();
    }

    public static KeyTemplate createAesGcmKeyTemplate(int keySize) {
        AesGcmKeyFormat r1 = (AesGcmKeyFormat) AesGcmKeyFormat.newBuilder().setKeySize(keySize).build();
        return (KeyTemplate) KeyTemplate.newBuilder().setValue(r1.toByteString()).setTypeUrl(AesGcmKeyManager.getKeyType()).setOutputPrefixType(OutputPrefixType.TINK).build();
    }

    public static KeyTemplate createAesEaxKeyTemplate(int keySize, int ivSize) {
        AesEaxKeyFormat r1 = (AesEaxKeyFormat) AesEaxKeyFormat.newBuilder().setKeySize(keySize).setParams((AesEaxParams) AesEaxParams.newBuilder().setIvSize(ivSize).build()).build();
        return (KeyTemplate) KeyTemplate.newBuilder().setValue(r1.toByteString()).setTypeUrl(AesEaxKeyManager.getKeyType()).setOutputPrefixType(OutputPrefixType.TINK).build();
    }

    public static KeyTemplate createAesCtrHmacAeadKeyTemplate(int aesKeySize, int ivSize, int hmacKeySize, int tagSize, HashType hashType) {
        AesCtrKeyFormat r2 = (AesCtrKeyFormat) AesCtrKeyFormat.newBuilder().setParams((AesCtrParams) AesCtrParams.newBuilder().setIvSize(ivSize).build()).setKeySize(aesKeySize).build();
        HmacKeyFormat r3 = (HmacKeyFormat) HmacKeyFormat.newBuilder().setParams((HmacParams) HmacParams.newBuilder().setHash(hashType).setTagSize(tagSize).build()).setKeySize(hmacKeySize).build();
        AesCtrHmacAeadKeyFormat r4 = (AesCtrHmacAeadKeyFormat) AesCtrHmacAeadKeyFormat.newBuilder().setAesCtrKeyFormat(r2).setHmacKeyFormat(r3).build();
        return (KeyTemplate) KeyTemplate.newBuilder().setValue(r4.toByteString()).setTypeUrl(AesCtrHmacAeadKeyManager.getKeyType()).setOutputPrefixType(OutputPrefixType.TINK).build();
    }

    public static KeyTemplate createKmsEnvelopeAeadKeyTemplate(String kekUri, KeyTemplate dekTemplate) {
        KmsEnvelopeAeadKeyFormat r1 = (KmsEnvelopeAeadKeyFormat) KmsEnvelopeAeadKeyFormat.newBuilder().setDekTemplate(dekTemplate).setKekUri(kekUri).build();
        return (KeyTemplate) KeyTemplate.newBuilder().setValue(r1.toByteString()).setTypeUrl(KmsEnvelopeAeadKeyManager.getKeyType()).setOutputPrefixType(OutputPrefixType.RAW).build();
    }

    private AeadKeyTemplates() {
    }
}
