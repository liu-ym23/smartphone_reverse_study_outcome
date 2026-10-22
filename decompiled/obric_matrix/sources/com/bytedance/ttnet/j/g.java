package com.bytedance.ttnet.j;

import com.bytedance.common.utility.reflect.Reflect;

/* JADX INFO: loaded from: classes.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile boolean f6379a = true;

    static {
    }

    public static void a() {
        if (f6379a == true) goto L8;
        return;
    L8:
        Reflect.on(Class.forName("com.bytedance.crash.Npth").newInstance()).call("registerSdk", new Class[]{Integer.TYPE, String.class}, new Object[]{2616, "4.2.228.16-pico"});     // Catch: Throwable -> L7
        return;
    }
}
