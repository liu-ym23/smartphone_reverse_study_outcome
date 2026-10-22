package com.bytedance.feedbackerlib.m;

import android.content.Context;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Object[] f4259a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Class<?>[] f4260b = null;

    static {
        f4259a = new Object[0];
        f4260b = new Class[0];
    }

    public static boolean a(@Nullable Object[] r5, @Nullable Object r6) {
        if (r5 != null) goto L5;
        return false;
    L5:
        int r1 = r5.length;
        int r2 = 0;
    L6:
        if (r2 >= r1) goto L16;
        Object r3 = r5[r2];
        if (r3 == r6) goto L9;
        if (r3 == null) goto L15;
        if (r3.equals(r6) == false) goto L15;
        return true;
    L15:
        r2 = r2 + 1;
        goto L6
    L9:
        return true;
    L16:
        return false;
    }

    public static boolean b(@NonNull Context r2, @NonNull String r3) {
        if (r2 != null) goto L5;
    L15:
        return false;
    L5:
        if (r2.getApplicationContext() == null) goto L15;
        if (TextUtils.isEmpty(r3) == false) goto L10;
        return false;
    L10:
        PackageManager r4 = r2.getPackageManager();
        if (r4 != null) goto L17;
        return false;
    L17:
        return r3.equals(r4.getPackageInfo(r3, 0).packageName);
    }

    public static boolean c(@NonNull Context r2) {
        if (r2 != null) goto L5;
        return false;
    L5:
        if (r2.getApplicationContext() == null) goto L17;
        if ((r2.getApplicationInfo().flags & 2) == 0) goto L16;
        return true;
    L16:
        return false;
    L18:
        return false;
    L17:
        return false;
    }

    public static Class<?>[] d(Class<?>[] r1) {
        if (r1 == null) goto L8;
        if (r1.length == 0) goto L8;
        return r1;
    L8:
        return f4260b;
    }

    public static Object[] e(Object[] r1) {
        if (r1 == null) goto L8;
        if (r1.length == 0) goto L8;
        return r1;
    L8:
        return f4259a;
    }

    public static Class<?>[] f(Object... r3) {
        if (r3 == null) goto L16;
        if (r3.length == 0) goto L16;
        Class<?>[] r0 = new Class[r3.length];
        int r1 = 0;
    L8:
        if (r1 >= r3.length) goto L14;
        if (r3[r1] != null) goto L12;
        Class<?> r2 = null;
    L13:
        r0[r1] = r2;
        r1 = r1 + 1;
        goto L8
    L12:
        r2 = r3[r1].getClass();
        goto L13
    L14:
        return r0;
    L16:
        return f4260b;
    }
}
