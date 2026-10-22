package com.bytedance.bdinstall.d1;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f2749a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static int f2750b;

    static {
        int r0 = Build.VERSION.SDK_INT;
        f2749a = "";
        f2750b = -1;
    }

    public static int a(Context r2) {
        if (f2750b != (-1)) goto L7;
        if (r2 == null) goto L7;
        f2750b = r2.getApplicationContext().getResources().getDisplayMetrics().densityDpi;
    L7:
        return f2750b;
    }

    private static int b(Context r1) {
        if (r1 != null) goto L5;
        return 0;
    L5:
        DisplayMetrics r2 = r1.getResources().getDisplayMetrics();
        if (r2 != null) goto L9;
        return 0;
    L9:
        return r2.heightPixels;
    }

    public static String c(Context r2) {
        if (TextUtils.isEmpty(f2749a) == false) goto L10;
        if (r2 == null) goto L10;
        int r0 = d(r2);
        int r3 = b(r2);
        if (r0 <= 0) goto L10;
        if (r3 <= 0) goto L10;
        f2749a = r0 + "*" + r3;
    L10:
        return f2749a;
    }

    private static int d(Context r1) {
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
