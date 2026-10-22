package com.bytedance.ttnet.config;

import com.bytedance.common.utility.reflect.Reflect;

/* JADX INFO: loaded from: classes.dex */
public class SDKConfig {
    private static final int TTNET_SID = 2616;
    private static volatile boolean enable = true;

    public SDKConfig() {
    }

    public static void disableRegisterSdk() {
        enable = false;
    }

    public static void registerSdk() {
        if (enable == true) goto L10;
        return;
    L10:
        Reflect.on(Class.forName("com.bytedance.crash.Npth").newInstance()).call("registerSdk", new Class[]{Integer.TYPE, String.class}, new Object[]{Integer.valueOf(TTNET_SID), "4.2.228.16-pico"});     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        th.printStackTrace();
    }
}
