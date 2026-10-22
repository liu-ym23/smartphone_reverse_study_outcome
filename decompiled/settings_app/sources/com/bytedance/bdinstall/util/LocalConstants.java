package com.bytedance.bdinstall.util;

/* JADX INFO: loaded from: classes3.dex */
public class LocalConstants extends Constants {
    public static int getVersionCode() {
        return 311;
    }

    public LocalConstants() {
    }

    public static String getOldSpName() {
        return StringEncryptUtils.base64DecodeToString("Y29tLnNzLmFuZHJvaWQuZGV2aWNlcmVnaXN0ZXIudXRpbHMuQ2RpZA==");
    }
}
