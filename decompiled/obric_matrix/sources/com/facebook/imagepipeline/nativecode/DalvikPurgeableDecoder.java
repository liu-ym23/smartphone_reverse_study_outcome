package com.facebook.imagepipeline.nativecode;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.os.Build;
import d.c.c.d.i;
import d.c.c.d.n;
import d.c.c.g.h;
import d.c.i.n.g;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
@d.c.c.d.d
public abstract class DalvikPurgeableDecoder implements g {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected static final byte[] f6751b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.facebook.imagepipeline.memory.b f6752a;

    static {
        a.a();
        f6751b = new byte[]{-1, -39};
    }

    protected DalvikPurgeableDecoder() {
        this.f6752a = com.facebook.imagepipeline.memory.c.a();
    }

    public static boolean f(d.c.c.h.a<h> r3, int r4) {
        h r5 = r3.N();
        if (r4 >= 2) goto L5;
    L9:
        return false;
    L5:
        if (r5.f(r4 - 2) != (-1)) goto L9;
        if (r5.f(r4 - 1) != (-39)) goto L9;
        return true;
    }

    public static BitmapFactory.Options g(int r2, Bitmap.Config r3) {
        BitmapFactory.Options r0 = new BitmapFactory.Options();
        r0.inDither = true;
        r0.inPreferredConfig = r3;
        r0.inPurgeable = true;
        r0.inInputShareable = true;
        r0.inSampleSize = r2;
        if (Build.VERSION.SDK_INT < 11) goto L5;
        r0.inMutable = true;
    L5:
        return r0;
    }

    @d.c.c.d.d
    private static native void nativePinBitmap(Bitmap r0);

    @Override // d.c.i.n.g
    public d.c.c.h.a<Bitmap> a(d.c.i.l.e r1, Bitmap.Config r2, Rect r3, int r4, boolean r5) {
        BitmapFactory.Options r6 = g(r1.V(), r2);
        d.c.c.h.a<h> r7 = r1.s();
        i.g(r7);
        d.c.c.h.a<Bitmap> r0 = h(e(r7, r4, r6));     // Catch: Throwable -> L6
        d.c.c.h.a.L(r7);
        return r0;
    L6:
        th = move-exception;
        d.c.c.h.a.L(r7);
        throw th;
    }

    @Override // d.c.i.n.g
    public d.c.c.h.a<Bitmap> b(d.c.i.l.e r1, Bitmap.Config r2, Rect r3, boolean r4) {
        BitmapFactory.Options r5 = g(r1.V(), r2);
        d.c.c.h.a<h> r6 = r1.s();
        i.g(r6);
        d.c.c.h.a<Bitmap> r0 = h(d(r6, r5));     // Catch: Throwable -> L6
        d.c.c.h.a.L(r6);
        return r0;
    L6:
        th = move-exception;
        d.c.c.h.a.L(r6);
        throw th;
    }

    @Override // d.c.i.n.g
    public d.c.c.h.a<Bitmap> c(d.c.i.l.e r7, Bitmap.Config r8, Rect r9, int r10) {
        return a(r7, r8, r9, r10, false);
    }

    protected abstract Bitmap d(d.c.c.h.a<h> r1, BitmapFactory.Options r2);

    protected abstract Bitmap e(d.c.c.h.a<h> r1, int r2, BitmapFactory.Options r3);

    public d.c.c.h.a<Bitmap> h(Bitmap r5) {
        i.g(r5);
        nativePinBitmap(r5);     // Catch: Exception -> L10
        if (this.f6752a.g(r5) == true) goto L7;
        int r0 = com.facebook.imageutils.b.e(r5);
        r5.recycle();
        throw new d.c.i.f.h(String.format(Locale.US, "Attempted to pin a bitmap of size %d bytes. The current pool count is %d, the current pool size is %d bytes. The current pool max count is %d, the current pool max size is %d bytes.", new Object[]{Integer.valueOf(r0), Integer.valueOf(this.f6752a.b()), Long.valueOf(this.f6752a.f()), Integer.valueOf(this.f6752a.c()), Integer.valueOf(this.f6752a.d())}));
    L7:
        return d.c.c.h.a.X(r5, this.f6752a.e());
    L10:
        e = move-exception;
        r5.recycle();
        n.a(e);
        throw null;
    }
}
