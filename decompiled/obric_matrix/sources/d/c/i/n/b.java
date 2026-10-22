package d.c.i.n;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapRegionDecoder;
import android.graphics.ColorSpace;
import android.graphics.Rect;
import android.os.Build;
import androidx.core.util.Pools;
import d.c.c.d.i;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
@TargetApi(21)
public abstract class b implements g {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Class<?> f16193c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final byte[] f16194d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.facebook.imagepipeline.memory.d f16195a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Pools.SynchronizedPool<ByteBuffer> f16196b;

    static {
        f16193c = b.class;
        f16194d = new byte[]{-1, -39};
    }

    public b(com.facebook.imagepipeline.memory.d r2, int r3, Pools.SynchronizedPool r4) {
        this.f16195a = r2;
        this.f16196b = r4;
        int r5 = 0;
    L3:
        if (r5 >= r3) goto L5;
        this.f16196b.release(ByteBuffer.allocate(16384));
        r5 = r5 + 1;
        goto L3
    }

    private d.c.c.h.a<Bitmap> e(InputStream r11, BitmapFactory.Options r12, Rect r13, boolean r14) {
        i.g(r11);
        int r0 = r12.outWidth;
        int r1 = r12.outHeight;
        if (r13 == null) goto L5;
        r0 = r13.width() / r12.inSampleSize;
        r1 = r13.height() / r12.inSampleSize;
    L5:
        int r5 = r0;
        int r6 = r1;
        Bitmap r2 = this.f16195a.get(f(r5, r6, r12));
        Objects.requireNonNull(r2, "BitmapPool.get returned null");
        r12.inBitmap = r2;
        if (Build.VERSION.SDK_INT < 26) goto L9;
        if (r14 == false) goto L9;
        r12.inPreferredColorSpace = ColorSpace.get(ColorSpace.Named.SRGB);
    L9:
        ByteBuffer r15 = this.f16196b.acquire();
        if (r15 != null) goto L60;
        r15 = ByteBuffer.allocate(16384);
    L60:
        r12.inTempStorage = r15.array();     // Catch: Throwable -> L39 OutOfMemoryError -> L41 RuntimeException -> L44 IllegalArgumentException -> L47
        if (r13 != null) goto L64;
    L30:
        Bitmap r16 = null;
    L31:
        if (r16 != null) goto L33;
        r16 = d(r11, r12, r5, r6, r2);     // Catch: Throwable -> L39 OutOfMemoryError -> L41 RuntimeException -> L44 IllegalArgumentException -> L47
    L33:
        this.f16196b.release(r15);
        com.facebook.imagepipeline.memory.d r10 = this.f16195a;
        if (r2 == r16) goto L36;
        r10.release(r2);
        r16.recycle();
        throw new IllegalStateException();
    L36:
        return d.c.c.h.a.X(r16, r10);
    L64:
        r2.reconfigure(r5, r6, r12.inPreferredConfig);     // Catch: Throwable -> L20 IOException -> L22
        BitmapRegionDecoder r3 = BitmapRegionDecoder.newInstance(r11, true);     // Catch: Throwable -> L20 IOException -> L22
        r16 = r3.decodeRegion(r13, r12);     // Catch: IOException -> L58 Throwable -> L26
        if (r3 == null) goto L31;
        r3.recycle();     // Catch: Throwable -> L39 OutOfMemoryError -> L41 RuntimeException -> L44 IllegalArgumentException -> L47
    L26:
        th = th;
    L27:
        if (r3 == null) goto L29;
        r3.recycle();     // Catch: Throwable -> L39 OutOfMemoryError -> L41 RuntimeException -> L44 IllegalArgumentException -> L47
    L29:
        throw th;     // Catch: Throwable -> L39 OutOfMemoryError -> L41 RuntimeException -> L44 IllegalArgumentException -> L47
    L23:
        d.c.c.e.a.h(f16193c, "Could not decode region %s, decoding full bitmap instead.", new Object[]{r13});     // Catch: Throwable -> L26
        if (r3 == null) goto L30;
        r3.recycle();     // Catch: Throwable -> L39 OutOfMemoryError -> L41 RuntimeException -> L44 IllegalArgumentException -> L47
        goto L30
    L22:
        r3 = null;
    L20:
        th = th;
        r3 = null;
    L39:
        th = move-exception;
        this.f16196b.release(r15);
        throw th;
    L47:
        e = move-exception;
        this.f16195a.release(r2);     // Catch: Throwable -> L39
        r11.reset();     // Catch: Throwable -> L39 IOException -> L55
        BitmapFactory.Options r4 = new BitmapFactory.Options();     // Catch: Throwable -> L39 IOException -> L55
        r4.inMutable = true;     // Catch: Throwable -> L39 IOException -> L55
        r4.inSampleSize = r12.inSampleSize;     // Catch: Throwable -> L39 IOException -> L55
        Bitmap r17 = BitmapFactory.decodeStream(r11, null, r4);     // Catch: Throwable -> L39 IOException -> L55
        if (r17 == null) goto L54;
        d.c.c.h.a<Bitmap> r18 = d.c.c.h.a.X(r17, d.c.i.d.g.a());     // Catch: Throwable -> L39 IOException -> L55
        this.f16196b.release(r15);
        return r18;
    L54:
        throw e;     // Catch: Throwable -> L39 IOException -> L55
    L55:
        throw e;     // Catch: Throwable -> L39
    L41:
        e = move-exception;
        this.f16195a.release(r2);     // Catch: Throwable -> L39
        throw e;     // Catch: Throwable -> L39
    L44:
        e = move-exception;
        this.f16195a.release(r2);     // Catch: Throwable -> L39
        throw e;     // Catch: Throwable -> L39
    }

    private static BitmapFactory.Options g(d.c.i.l.e r4, Bitmap.Config r5) {
        BitmapFactory.Options r0 = new BitmapFactory.Options();
        r0.inSampleSize = r4.V();
        r0.inJustDecodeBounds = true;
        BitmapFactory.decodeStream(r4.O(), null, r0);
        if (r0.outWidth == (-1)) goto L9;
        if (r0.outHeight == (-1)) goto L9;
        r0.inJustDecodeBounds = false;
        r0.inDither = true;
        r0.inPreferredConfig = r5;
        r0.inMutable = true;
        return r0;
    L9:
        throw new IllegalArgumentException(d.c.i.i.b.m(r4));
    }

    @Override // d.c.i.n.g
    public d.c.c.h.a<Bitmap> a(d.c.i.l.e r8, Bitmap.Config r9, Rect r10, int r11, boolean r12) {
        boolean r0 = r8.i0(r11);
        BitmapFactory.Options r13 = g(r8, r9);
        InputStream r1 = r8.O();
        i.g(r1);
        if (r8.X() <= r11) goto L5;
        r1 = new d.c.c.j.a(r1, r11);
    L5:
        if (r0 == true) goto L8;
        r1 = new d.c.c.j.b(r1, f16194d);
    L8:
        if (r13.inPreferredConfig == Bitmap.Config.ARGB_8888) goto L10;
        boolean r2 = true;
    L18:
        return e(r1, r13, r10, r12);
    L13:
        e = move-exception;
        if (r2 == true) goto L16;
        throw e;
    L16:
        return a(r8, Bitmap.Config.ARGB_8888, r10, r11, r12);
    L10:
        r2 = false;
        goto L18
    }

    @Override // d.c.i.n.g
    public d.c.c.h.a<Bitmap> b(d.c.i.l.e r3, Bitmap.Config r4, Rect r5, boolean r6) {
        BitmapFactory.Options r7 = g(r3, r4);
        if (r7.inPreferredConfig == Bitmap.Config.ARGB_8888) goto L5;
        boolean r0 = true;
    L13:
        return e(r3.O(), r7, r5, r6);
    L8:
        e = move-exception;
        if (r0 == true) goto L11;
        throw e;
    L11:
        return b(r3, Bitmap.Config.ARGB_8888, r5, r6);
    L5:
        r0 = false;
        goto L13
    }

    @Override // d.c.i.n.g
    public d.c.c.h.a<Bitmap> c(d.c.i.l.e r7, Bitmap.Config r8, Rect r9, int r10) {
        return a(r7, r8, r9, r10, false);
    }

    protected Bitmap d(InputStream r1, BitmapFactory.Options r2, int r3, int r4, Bitmap r5) {
        return BitmapFactory.decodeStream(r1, null, r2);
    }

    public abstract int f(int r1, int r2, BitmapFactory.Options r3);
}
