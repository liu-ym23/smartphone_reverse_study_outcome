package com.bytedance.retrofit2;

/* JADX INFO: loaded from: classes.dex */
public class OptConfig {
    private static volatile boolean sEnableRequestOpt = false;

    public OptConfig() {
    }

    public static boolean isEnableRequestOpt() {
        return sEnableRequestOpt;
    }

    public static void setEnableRequestOpt(boolean r0) {
        sEnableRequestOpt = r0;
    }
}
