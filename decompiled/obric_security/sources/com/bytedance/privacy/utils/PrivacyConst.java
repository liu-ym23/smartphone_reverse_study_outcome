package com.bytedance.privacy.utils;

/* JADX INFO: loaded from: classes.dex */
public class PrivacyConst {
    public static final String ALGORITHM_CHACHA20 = "ChaCha20";
    public static final String ALGORITHM_CHACHA20_POLY1305 = "ChaCha20-Poly1305";
    public static final String ALGORITHM_EC = "EC";
    public static final String ALGORITHM_NONEwithECDSA = "NONEwithECDSA";
    public static final String ALGORITHM_SHA256 = "SHA-256";
    public static final int APP_ID_MAX_SIZE = 128;
    public static final int BITS_ECC_P256_KEY_LEN = 256;
    public static final int BITS_TAG_LEN = 128;
    public static final int BYTES_AES_KEY_LEN = 32;
    public static final int BYTES_CHACHA20_KEY_LEN = 32;
    public static final int BYTES_DIGEST_SHA256_LEN = 32;
    public static final int BYTES_IV_LEN = 12;
    public static final int BYTES_TAG_LEN = 16;
    public static final int BYTES_UNCOMPRESSED_EC_PUBLIC_KEY_LEN = 65;
    public static final int CERTIFICATE_MAX_SIZE = 32768;
    public static final int DECRYPT_BYTES_MAX_SIZE = 1048674;
    public static final int DECRYPT_STREAM_MAX_SIZE = 1074266130;
    public static final int ECC_SIGNATURE_MAX_SIZE = 128;
    public static final int ENCRYPT_BLOCK_MAX_SIZE = 1048576;
    public static final int ENCRYPT_BLOCK_SIZE = 4096;
    public static final int ENCRYPT_BLOCK_SIZE_32K = 32768;
    public static final int ENCRYPT_BYTES_MAX_SIZE = 1048576;
    public static final int ENCRYPT_STREAM_MAX_SIZE = 1073741824;
    public static final int INT_BYTE_LEN = 4;
    public static final int KEY_MANAGER_DECRYPT_MODE = 1;
    public static final int KEY_MANAGER_ENCRYPT_MODE = 0;

    public PrivacyConst() {
    }
}
