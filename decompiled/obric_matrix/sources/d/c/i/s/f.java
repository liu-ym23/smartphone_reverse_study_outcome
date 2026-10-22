package d.c.i.s;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.Build;
import d.c.i.p.q;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes2.dex */
public class f implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f16532a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f16533b;

    public f(boolean r1, int r2) {
        this.f16532a = r1;
        this.f16533b = r2;
    }

    private static Bitmap.CompressFormat e(d.c.h.d r2) {
        if (r2 != null) goto L6;
        return Bitmap.CompressFormat.JPEG;
    L6:
        if (r2 != d.c.h.c.f15819a) goto L10;
        return Bitmap.CompressFormat.JPEG;
    L10:
        if (r2 != d.c.h.c.f15820b) goto L14;
        return Bitmap.CompressFormat.PNG;
    L14:
        if (Build.VERSION.SDK_INT < 14) goto L20;
        if (d.c.h.c.f(r2) == false) goto L20;
        return Bitmap.CompressFormat.WEBP;
    L20:
        return Bitmap.CompressFormat.JPEG;
    }

    private int f(d.c.i.l.e r2, d.c.i.f.g r3, d.c.i.f.f r4) {
        if (this.f16532a == true) goto L6;
        return 1;
    L6:
        return q.b(r3, r4, r2, this.f16533b);
    }

    @Override // d.c.i.s.b
    public String a() {
        return "SimpleImageTranscoder";
    }

    @Override // d.c.i.s.b
    public boolean b(d.c.i.l.e r3, d.c.i.f.g r4, d.c.i.f.f r5) {
        if (r4 != null) goto L5;
        r4 = d.c.i.f.g.a();
    L5:
        if (this.f16532a == true) goto L7;
    L9:
        return false;
    L7:
        if (q.b(r4, r5, r3, this.f16533b) <= 1) goto L9;
        return true;
    }

    @Override // d.c.i.s.b
    public a c(d.c.i.l.e r18, OutputStream r19, d.c.i.f.g r20, d.c.i.f.f r21, d.c.h.d r22, Integer r23) {
        if (r23 != null) goto L5;
        Integer r3 = 85;
    L6:
        if (r20 != null) goto L8;
        d.c.i.f.g r4 = d.c.i.f.g.a();
    L9:
        int r5 = f(r18, r4, r21);
        BitmapFactory.Options r6 = new BitmapFactory.Options();
        r6.inSampleSize = r5;
        Bitmap r7 = BitmapFactory.decodeStream(r18.O(), null, r6);     // Catch: OutOfMemoryError -> L38
        if (r7 != null) goto L14;
        d.c.c.e.a.j("SimpleImageTranscoder", "Couldn't decode the EncodedImage InputStream ! ");
        return new a(2);
    L14:
        Matrix r15 = d.g(r18, r4);
        if (r15 != null) goto L46;
        Bitmap r8 = r7;
    L43:
        r8.compress(e(r22), r3.intValue(), r19);     // Catch: Throwable -> L30 OutOfMemoryError -> L32
        int r9 = 1;
        if (r5 <= 1) goto L27;
        r9 = 0;
    L27:
        a r0 = new a(r9);     // Catch: Throwable -> L30 OutOfMemoryError -> L32
        r8.recycle();
        r7.recycle();
        return r0;
    L32:
        OutOfMemoryError e2 = e;
    L33:
        d.c.c.e.a.k("SimpleImageTranscoder", "Out-Of-Memory during transcode", e2);     // Catch: Throwable -> L30
        a r1 = new a(2);     // Catch: Throwable -> L30
        r8.recycle();
        r7.recycle();
        return r1;
    L30:
        Throwable th = th;
    L36:
        r8.recycle();
        r7.recycle();
        throw th;
    L46:
        r8 = Bitmap.createBitmap(r7, 0, 0, r7.getWidth(), r7.getHeight(), r15, false);     // Catch: Throwable -> L19 OutOfMemoryError -> L21
        goto L43
    L21:
        e2 = e;
        r8 = r7;
    L19:
        th = th;
        r8 = r7;
    L38:
        e = move-exception;
        d.c.c.e.a.k("SimpleImageTranscoder", "Out-Of-Memory during transcode", e);
        return new a(2);
    L8:
        r4 = r20;
        goto L9
    L5:
        r3 = r23;
        goto L6
    }

    @Override // d.c.i.s.b
    public boolean d(d.c.h.d r1) {
        if (r1 != d.c.h.c.f15829k) goto L5;
    L12:
        return true;
    L5:
        if (r1 == d.c.h.c.f15819a) goto L12;
        if (com.facebook.imageutils.d.c() != null) goto L9;
    L11:
        return false;
    L9:
        if (r1 != com.facebook.imageutils.d.c()) goto L11;
        goto L11
    }
}
