package com.bytedance.applog.util;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import com.bytedance.bdinstall.c0;

/* JADX INFO: loaded from: classes.dex */
public class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static c0 f2429a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f2430b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile boolean f2431c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f2432d = 0;

    static {
        int r0 = 5052090;
        if (String.valueOf(5052090).charAt(0) < '4') goto L5;
        r0 = 15051689;
    L5:
        f2432d = r0;
    }

    public static void a(String r1) {
        b(r1, null);
    }

    public static void b(String r1, Throwable r2) {
        c0 r0 = f2429a;
        if (r0 == null) goto L6;
        r0.a(r1, r2);
        return;
    }

    public static void c(String r1, Throwable r2) {
        c0 r0 = f2429a;
        if (r0 == null) goto L6;
        r0.d(r1, r2);
        return;
    }

    public static void d(String r1, Throwable r2) {
        c0 r0 = f2429a;
        if (r0 == null) goto L6;
        r0.e(r1, r2);
        return;
    }

    public static void e(String r1) {
        f(r1, null);
    }

    public static void f(String r2, Throwable r3) {
        h(r2, r3);     // Catch: Throwable -> L14
    L4:
        if (f2429a != null) goto L6;
        return;
    L6:
        if (f2431c == false) goto L21;
        Bundle r0 = new Bundle();     // Catch: Throwable -> L15
        if (TextUtils.isEmpty(r2) == true) goto L10;
        r0.putString(NotificationCompat.CATEGORY_MESSAGE, r2);     // Catch: Throwable -> L15
    L10:
        if (r3 == null) goto L12;
        r0.putString("exception", r3.toString());     // Catch: Throwable -> L15
    L12:
        com.bytedance.applog.a.E("AppLogTracker", r0);     // Catch: Throwable -> L15
        return;
    L22:
        return;
    }

    public static void g(Context r1, @NonNull c0 r2) {
    L9:
        f2430b = true;
    L10:
        f2429a = r2;
        return;
    L4:
        if ((r1.getApplicationInfo().flags & 2) == 0) goto L6;
        boolean r3 = true;
    L7:
        f2430b = r3;     // Catch: Throwable -> L9
        goto L10
    L6:
        r3 = false;
        goto L7
    }

    public static void h(String r1, Throwable r2) {
        c0 r0 = f2429a;
        if (r0 == null) goto L6;
        r0.b(r1, r2);
        return;
    }

    public static void i(Throwable r1) {
        h("U SHALL NOT PASS!", r1);
    }
}
