package com.bytedance.common.utility;

import android.content.Context;
import android.os.Build;
import android.util.DisplayMetrics;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f3290a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static int f3291b;

    static {
        int r0 = Build.VERSION.SDK_INT;
        f3290a = "";
        f3291b = -1;
    }

    public static float a(Context r0, float r1) {
        if (r0 != null) goto L4;
        return 0.0f;
    L4:
        return (r1 * r0.getResources().getDisplayMetrics().density) + 0.5f;
    }

    public static int b(Context r2) {
        if (f3291b != (-1)) goto L7;
        if (r2 == null) goto L7;
        f3291b = r2.getApplicationContext().getResources().getDisplayMetrics().densityDpi;
    L7:
        return f3291b;
    }

    public static int c(Context r1) {
        if (r1 != null) goto L5;
        return 0;
    L5:
        DisplayMetrics r2 = r1.getResources().getDisplayMetrics();
        if (r2 != null) goto L9;
        return 0;
    L9:
        return r2.heightPixels;
    }

    public static String d(Context r2) {
        if (k.c(f3290a) == false) goto L10;
        if (r2 == null) goto L10;
        int r0 = e(r2);
        int r3 = c(r2);
        if (r0 <= 0) goto L10;
        if (r3 <= 0) goto L10;
        f3290a = r0 + "*" + r3;
    L10:
        return f3290a;
    }

    public static int e(Context r1) {
        if (r1 != null) goto L5;
        return 0;
    L5:
        DisplayMetrics r2 = r1.getResources().getDisplayMetrics();
        if (r2 != null) goto L9;
        return 0;
    L9:
        return r2.widthPixels;
    }
}
