package com.bytedance.privacy.utils;

import android.util.Log;
import com.bytedance.privacy.bridge.ILogBridge;

/* JADX INFO: loaded from: classes.dex */
public class LogUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static ILogBridge f32a;

    public static void a(String r0, String r1) {
        Log.i(r0, r1);
        ILogBridge r2 = f32a;
        if (r2 == null) goto L6;
        r2.c();
        return;
    }

    public static void b(String r0, String r1) {
        Log.e(r0, r1);
        ILogBridge r2 = f32a;
        if (r2 == null) goto L6;
        r2.a();
        return;
    }

    public static void c(String r0, String r1, Throwable r2) {
        Log.e(r0, r1, r2);
        ILogBridge r3 = f32a;
        if (r3 == null) goto L6;
        r3.a();
        return;
    }

    public static void d(String r0, String r1) {
        Log.i(r0, r1);
        ILogBridge r2 = f32a;
        if (r2 == null) goto L6;
        r2.c();
        return;
    }
}
