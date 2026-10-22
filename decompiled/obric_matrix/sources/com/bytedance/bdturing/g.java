package com.bytedance.bdturing;

import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static int f3052a = 1;

    static {
    }

    public static final void a(String r2, String r3) {
        if (f3052a >= 3) goto L5;
        return;
    L5:
        Log.d(r2, String.valueOf(r3));
    }

    public static final void b(String r2, String r3) {
        if (f3052a >= 6) goto L5;
        return;
    L5:
        Log.e(r2, String.valueOf(r3));
    }

    public static final void c(String r2, String r3) {
        if (f3052a >= 4) goto L5;
        return;
    L5:
        Log.i(r2, String.valueOf(r3));
    }

    public static final boolean d() {
        if (f3052a <= 6) goto L5;
        return true;
    L5:
        return false;
    }

    public static final void e(Exception r2) {
        kotlin.n0.d.o.g(r2, "e");
        if (f3052a >= 3) goto L6;
        r2.printStackTrace();
        return;
    }

    public static final void f(String r2, String r3) {
        if (f3052a >= 5) goto L5;
        return;
    L5:
        Log.w(r2, String.valueOf(r3));
    }
}
