package com.facebook.imageutils;

import java.io.InputStream;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Class f6762a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static d.c.h.d f6763b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static d.c.h.d f6764c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static Method f6765d;

    static {
        f6762a = Class.forName("com.bytedance.fresco.avif.AvifDecoder");     // Catch: ClassNotFoundException -> L4
        return;
    L4:
        e = move-exception;
        d.c.c.e.a.k("AvifFormatUtil", "AvifDecoder init ", e);
    }

    public static d.c.h.d a() {
        d.c.h.d r2 = f6763b;
        if (r2 == null) goto L5;
        return r2;
    L5:
        Class r3 = f6762a;
        if (r3 == null) goto L8;
        f6763b = (d.c.h.d) r3.getDeclaredField("AVIF_FORMAT").get(null);     // Catch: Throwable -> L11
    L14:
        return f6763b;
    L11:
        e = move-exception;
        d.c.c.e.a.k("AvifFormatUtil", "AVIF_FORMAT init ", e);
        goto L14
    L8:
        return d.c.h.d.f15831b;
    }

    public static d.c.h.d b() {
        d.c.h.d r2 = f6764c;
        if (r2 == null) goto L5;
        return r2;
    L5:
        Class r3 = f6762a;
        if (r3 == null) goto L8;
        f6764c = (d.c.h.d) r3.getDeclaredField("AVIF_FORMAT_ANIMATED").get(null);     // Catch: Throwable -> L11
    L14:
        return f6764c;
    L11:
        e = move-exception;
        d.c.c.e.a.k("AvifFormatUtil", "AVIF_FORMAT_ANIMATED init ", e);
        goto L14
    L8:
        return d.c.h.d.f15831b;
    }

    public static int[] c(byte[] r10, int r11) {
        Class r2 = f6762a;
        if (r2 != null) goto L15;
        return null;
    L15:
    L12:
        e = move-exception;
        d.c.c.e.a.k("AvifFormatUtil", "parseSimpleMeta init ", e);
    L14:
        return null;
    L6:
        if (f6765d != null) goto L8;
        f6765d = r2.getDeclaredMethod("parseSimpleMeta", new Class[]{byte[].class, Integer.TYPE});     // Catch: Throwable -> L12
    L8:
        Method r3 = f6765d;     // Catch: Throwable -> L12
        if (r3 == null) goto L14;
        r3.setAccessible(true);     // Catch: Throwable -> L12
        return (int[]) f6765d.invoke(null, new Object[]{r10, Integer.valueOf(r11)});
    }

    public static int[] d(InputStream r3) {
        int r0 = r3.available();
        byte[] r1 = new byte[r0];
        r3.reset();
        if (r3.read(r1, 0, r0) != (-1)) goto L5;
        return null;
    L5:
        return c(r1, r0);
    }
}
