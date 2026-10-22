package com.facebook.imagepipeline.nativecode;

import android.os.Build;

/* JADX INFO: loaded from: classes2.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f6759a;

    public static synchronized void a() {
        monitor-enter(d.class);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (f6759a == false) goto L8;
    L11:
        monitor-exit(d.class);
        return;
    L8:
        if (Build.VERSION.SDK_INT <= 16) goto L19;
    L10:
        com.facebook.imageutils.c.b("static-webp");     // Catch: Throwable -> L13
        f6759a = true;     // Catch: Throwable -> L13
        goto L11
    L19:
        com.facebook.imageutils.c.b("fb_jpegturbo");     // Catch: Throwable -> L16 Throwable -> L13
        goto L10
    }
}
