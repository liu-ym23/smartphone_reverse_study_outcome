package com.facebook.imagepipeline.nativecode;

import d.c.c.d.i;
import d.c.i.f.g;
import d.c.i.p.q;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes2.dex */
@d.c.c.d.d
public class NativeJpegTranscoder implements d.c.i.s.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f6753a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f6754b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f6755c;

    static {
        a.a();
    }

    public NativeJpegTranscoder(boolean r1, int r2, boolean r3) {
        this.f6753a = r1;
        this.f6754b = r2;
        this.f6755c = r3;
    }

    public static void e(InputStream r3, OutputStream r4, int r5, int r6, int r7) {
        boolean r0 = false;
        if (r6 < 1) goto L5;
        boolean r2 = true;
    L6:
        i.b(r2);
        if (r6 > 16) goto L9;
        boolean r8 = true;
    L10:
        i.b(r8);
        if (r7 < 0) goto L13;
        boolean r9 = true;
    L14:
        i.b(r9);
        if (r7 > 100) goto L17;
        boolean r10 = true;
    L18:
        i.b(r10);
        i.b(d.c.i.s.d.j(r5));
        if (r6 != 8) goto L21;
        if (r5 != 0) goto L21;
    L22:
        i.c(r0, "no transformation requested");
        i.g(r3);
        i.g(r4);
        nativeTranscodeJpeg(r3, r4, r5, r6, r7);
        return;
    L21:
        r0 = true;
        goto L22
    L17:
        r10 = false;
        goto L18
    L13:
        r9 = false;
        goto L14
    L9:
        r8 = false;
        goto L10
    L5:
        r2 = false;
        goto L6
    }

    public static void f(InputStream r3, OutputStream r4, int r5, int r6, int r7) {
        boolean r0 = false;
        if (r6 < 1) goto L5;
        boolean r2 = true;
    L6:
        i.b(r2);
        if (r6 > 16) goto L9;
        boolean r8 = true;
    L10:
        i.b(r8);
        if (r7 < 0) goto L13;
        boolean r9 = true;
    L14:
        i.b(r9);
        if (r7 > 100) goto L17;
        boolean r10 = true;
    L18:
        i.b(r10);
        i.b(d.c.i.s.d.i(r5));
        if (r6 != 8) goto L21;
        if (r5 != 1) goto L21;
    L22:
        i.c(r0, "no transformation requested");
        i.g(r3);
        i.g(r4);
        nativeTranscodeJpegWithExifOrientation(r3, r4, r5, r6, r7);
        return;
    L21:
        r0 = true;
        goto L22
    L17:
        r10 = false;
        goto L18
    L13:
        r9 = false;
        goto L14
    L9:
        r8 = false;
        goto L10
    L5:
        r2 = false;
        goto L6
    }

    @d.c.c.d.d
    private static native void nativeTranscodeJpeg(InputStream r0, OutputStream r1, int r2, int r3, int r4);

    @d.c.c.d.d
    private static native void nativeTranscodeJpegWithExifOrientation(InputStream r0, OutputStream r1, int r2, int r3, int r4);

    @Override // d.c.i.s.b
    public String a() {
        return "NativeJpegTranscoder";
    }

    @Override // d.c.i.s.b
    public boolean b(d.c.i.l.e r1, g r2, d.c.i.f.f r3) {
        if (r2 != null) goto L5;
        r2 = g.a();
    L5:
        if (d.c.i.s.d.f(r2, r3, r1, this.f6753a) >= 8) goto L7;
        return true;
    L7:
        return false;
    }

    @Override // d.c.i.s.b
    public d.c.i.s.a c(d.c.i.l.e r3, OutputStream r4, g r5, d.c.i.f.f r6, d.c.h.d r7, Integer r8) {
        if (r8 != null) goto L4;
        r8 = 85;
    L4:
        if (r5 != null) goto L6;
        r5 = g.a();
    L6:
        int r9 = q.b(r5, r6, r3, this.f6754b);
        int r10 = d.c.i.s.d.f(r5, r6, r3, this.f6753a);     // Catch: Throwable -> L20
        int r1 = d.c.i.s.d.a(r9);     // Catch: Throwable -> L20
        if (this.f6755c == false) goto L10;
        r10 = r1;
    L10:
        InputStream r0 = r3.O();     // Catch: Throwable -> L20
        if (d.c.i.s.d.f16527a.contains(Integer.valueOf(r3.E())) == false) goto L13;
        f(r0, r4, d.c.i.s.d.d(r5, r3), r10, r8.intValue());     // Catch: Throwable -> L20
    L14:
        d.c.c.d.b.b(r0);
        int r11 = 1;
        if (r9 == 1) goto L19;
        r11 = 0;
    L19:
        return new d.c.i.s.a(r11);
    L13:
        e(r0, r4, d.c.i.s.d.e(r5, r3), r10, r8.intValue());     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        d.c.c.d.b.b(null);
        throw th;
    }

    @Override // d.c.i.s.b
    public boolean d(d.c.h.d r1) {
        if (r1 != d.c.h.c.f15819a) goto L5;
        return true;
    L5:
        return false;
    }
}
