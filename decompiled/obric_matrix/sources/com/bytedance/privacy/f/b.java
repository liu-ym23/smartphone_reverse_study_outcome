package com.bytedance.privacy.f;

import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final boolean f5368a = false;

    static {
        f5368a = d.a();
    }

    public static void a(String r1, String r2) {
        if (f5368a == false) goto L6;
        Log.i(r1, r2);
        return;
    }

    public static void b(String r0, String r1) {
        Log.e(r0, r1);
    }

    public static void c(String r0, String r1, Throwable r2) {
        Log.e(r0, r1, r2);
    }

    public static void d(String r0, String r1) {
        Log.i(r0, r1);
    }

    public static void e(String r0, String r1) {
        Log.w(r0, r1);
    }
}
