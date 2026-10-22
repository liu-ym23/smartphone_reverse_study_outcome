package com.bytedance.frameworks.core.encrypt;

import com.bytedance.frameworks.encryptor.EncryptorUtil;

/* JADX INFO: loaded from: classes.dex */
public class TTEncryptUtils {
    public static volatile boolean sUseNewEncrypt = true;

    static {
    }

    public TTEncryptUtils() {
    }

    public static byte[] encrypt(byte[] r0, int r1) {
        return EncryptorUtil.encrypt(r0, r1);
    }
}
