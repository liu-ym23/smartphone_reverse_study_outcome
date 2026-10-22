package d.c.i.q;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import com.facebook.imagepipeline.nativecode.Bitmaps;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Bitmap.Config f16490a = null;

    static {
        f16490a = Bitmap.Config.ARGB_8888;
    }

    public a() {
    }

    private static void d(Bitmap r2, Bitmap r3) {
        if (r2.getConfig() != r3.getConfig()) goto L5;
        Bitmaps.a(r2, r3);
        return;
    L5:
        new Canvas(r2).drawBitmap(r3, 0.0f, 0.0f, null);
    }

    @Override // d.c.i.q.d
    public d.c.c.h.a<Bitmap> b(Bitmap r4, d.c.i.d.f r5) {
        Bitmap.Config r0 = r4.getConfig();
        int r1 = r4.getWidth();
        int r2 = r4.getHeight();
        if (r0 != null) goto L6;
        r0 = f16490a;
    L6:
        d.c.c.h.a<Bitmap> r6 = r5.l(r1, r2, r0);
        g(r6.N(), r4);     // Catch: Throwable -> L10
        d.c.c.h.a<Bitmap> r3 = d.c.c.h.a.E(r6);     // Catch: Throwable -> L10
        d.c.c.h.a.L(r6);
        return r3;
    L10:
        th = move-exception;
        d.c.c.h.a.L(r6);
        throw th;
    }

    @Override // d.c.i.q.d
    public d.c.b.a.d c() {
        return null;
    }

    public d.c.c.h.a<Bitmap> e(Bitmap r1, d.c.i.d.f r2, Map<String, String> r3) {
        return b(r1, r2);
    }

    public void f(Bitmap r1) {
    }

    public void g(Bitmap r1, Bitmap r2) {
        d(r1, r2);
        f(r1);
    }

    @Override // d.c.i.q.d
    public String getName() {
        return "Unknown postprocessor";
    }
}
