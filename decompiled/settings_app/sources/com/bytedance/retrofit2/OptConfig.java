package com.bytedance.retrofit2;

/* JADX INFO: loaded from: classes3.dex */
public class OptConfig {
    private static volatile boolean sEnableRequestOpt = false;

    static {
    }

    public OptConfig() {
    }

    public static void setEnableRequestOpt(boolean r0) {
        sEnableRequestOpt = r0;
    }

    public static boolean isEnableRequestOpt() {
        return sEnableRequestOpt;
    }
}
