package com.facebook.imageutils;

import android.content.Context;
import com.facebook.soloader.SoLoader;

/* JADX INFO: loaded from: classes2.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Class<?> f6768a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static a f6769b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile boolean f6770c = false;

    public interface a {
        void loadLibrary(String r1);
    }

    static {
        f6768a = c.class;
    }

    public c() {
    }

    public static void a(Context r3) {
        if (f6769b == null) goto L12;
        f6770c = true;
        return;
    L12:
        SoLoader.d(r3, 0);     // Catch: Throwable -> L9
        f6770c = true;     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        d.c.c.e.a.B(f6768a, th, "Could not initialize SoLoader", new Object[0]);
    }

    public static void b(String r4) {
        if (f6770c == true) goto L13;
    L11:
        System.loadLibrary(r4);
        return;
    L13:
        a r0 = f6769b;     // Catch: Throwable -> L9
        if (r0 == null) goto L7;
        r0.loadLibrary(r4);     // Catch: Throwable -> L9
        return;
    L7:
        SoLoader.h(r4);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        d.c.c.e.a.B(f6768a, th, "loadLibrary fail", new Object[0]);
        goto L11
    }

    public static void c(a r0) {
        f6769b = r0;
    }
}
