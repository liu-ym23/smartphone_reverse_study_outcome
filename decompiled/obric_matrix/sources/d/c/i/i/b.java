package d.c.i.i;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Build;
import d.c.i.l.i;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class b implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final c f16146a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final c f16147b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final c f16148c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final c f16149d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final d.c.i.n.g f16150e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final c f16151f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Map<d.c.h.d, c> f16152g;

    class a implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ b f16153a;

        a(b r1) {
            this.f16153a = r1;
        }

        @Override // d.c.i.i.c
        public d.c.i.l.c a(d.c.i.l.e r4, int r5, i r6, d.c.i.f.c r7) {
            d.c.i.f.c r0 = b.b(r7, r4);
            d.c.h.d r1 = r4.N();
            if (r1 != d.c.h.c.f15819a) goto L7;
            return this.f16153a.f(r4, r5, r6, r0);
        L7:
            if (r1 != d.c.h.c.f15821c) goto L11;
            return this.f16153a.e(r4, r5, r6, r0);
        L11:
            if (r1 != d.c.h.c.f15828j) goto L15;
            return this.f16153a.d(r4, r5, r6, r0);
        L15:
            if (r1 != com.facebook.imageutils.d.d()) goto L19;
            return this.f16153a.c(r4, r5, r6, r7);
        L19:
            if (r1 == d.c.h.d.f15831b) goto L23;
            return this.f16153a.g(r4, r0);
        L23:
            throw new d.c.i.i.a("unknown image format" + b.m(r4), r4);
        }
    }

    public b(c r8, c r9, c r10, c r11, d.c.i.n.g r12) {
        this(r8, r9, r10, r11, r12, null);
    }

    public b(c r2, c r3, c r4, c r5, d.c.i.n.g r6, Map<d.c.h.d, c> r7) {
        this.f16151f = new a(this);
        this.f16146a = r2;
        this.f16147b = r3;
        this.f16148c = r4;
        this.f16149d = r5;
        this.f16150e = r6;
        this.f16152g = r7;
    }

    static /* synthetic */ d.c.i.f.c b(d.c.i.f.c r0, d.c.i.l.e r1) {
        return l(r0, r1);
    }

    private static Bitmap.Config h(d.c.i.f.c r1, d.c.i.l.e r2) {
        return i(r1, r2.d0(), r2.N());
    }

    private static Bitmap.Config i(d.c.i.f.c r1, boolean r2, d.c.h.d r3) {
        if (r1.f16002l == false) goto L7;
        return r1.f15998h;
    L7:
        return d.c.i.f.b.b().a(r2, r3);
    }

    private Rect j(d.c.i.l.e r1, d.c.i.f.c r2) {
        Rect r0 = r1.Q();
        if (r0 == null) goto L10;
        if (r2.m == false) goto L8;
        return r0;
    L8:
        return r2.n;
    L10:
        return r2.n;
    }

    private void k(d.c.i.t.a r2, d.c.c.h.a<Bitmap> r3) {
        if (r2 != null) goto L4;
        return;
    L4:
        Bitmap r1 = r3.N();
        if (Build.VERSION.SDK_INT >= 12) goto L7;
    L9:
        r2.b(r1);
        return;
    L7:
        if (r2.a() == false) goto L9;
        r1.setHasAlpha(true);
        goto L9
    }

    private static d.c.i.f.c l(d.c.i.f.c r1, d.c.i.l.e r2) {
        d.c.i.f.d r0 = new d.c.i.f.d();
        r0.s(r1);
        r0.p(h(r1, r2));
        return r0.a();
    }

    public static String m(d.c.i.l.e r7) {
        InputStream r0 = r7.O();
        byte[] r1 = new byte[64];
        r0.read(r1);     // Catch: Throwable -> L6 IOException -> L8
    L22:
        d.c.c.d.b.a(r0, true);     // Catch: IOException -> L15
    L12:
        return "ImageFormat:" + r7.N().a() + ":" + Arrays.toString(r1);
    L6:
        th = move-exception;
        d.c.c.d.b.a(r0, true);     // Catch: IOException -> L16
    L14:
        throw th;
    L8:
        e = move-exception;
        d.c.c.e.a.D("DefaultImageDecoder", e, "read encode Image 64 byte", new Object[0]);     // Catch: Throwable -> L6
        goto L22
    }

    @Override // d.c.i.i.c
    public d.c.i.l.c a(d.c.i.l.e r3, int r4, i r5, d.c.i.f.c r6) {
        c r0 = r6.f15999i;
        if (r0 != null) goto L5;
        d.c.h.d r1 = r3.N();
        if (r1 != null) goto L9;
    L10:
        r1 = d.c.h.e.c(r3.O());
        r3.D0(r1);
    L11:
        Map<d.c.h.d, c> r2 = this.f16152g;
        if (r2 == null) goto L18;
        c r7 = r2.get(r1);
        if (r7 == null) goto L18;
        return r7.a(r3, r4, r5, r6);
    L18:
        return this.f16151f.a(r3, r4, r5, r6);
    L9:
        if (r1 != d.c.h.d.f15831b) goto L11;
    L5:
        return r0.a(r3, r4, r5, r6);
    }

    public d.c.i.l.c c(d.c.i.l.e r1, int r2, i r3, d.c.i.f.c r4) {
        return this.f16148c.a(r1, r2, r3, r4);
    }

    public d.c.i.l.c d(d.c.i.l.e r1, int r2, i r3, d.c.i.f.c r4) {
        return this.f16147b.a(r1, r2, r3, r4);
    }

    public d.c.i.l.c e(d.c.i.l.e r2, int r3, i r4, d.c.i.f.c r5) {
        if (r5.f15996f == true) goto L9;
        c r0 = this.f16146a;
        if (r0 == null) goto L9;
        return r0.a(r2, r3, r4, r5);
    L9:
        return g(r2, r5);
    }

    public d.c.i.l.d f(d.c.i.l.e r10, int r11, i r12, d.c.i.f.c r13) {
        Rect r6 = j(r10, r13);
        d.c.c.h.a<Bitmap> r14 = this.f16150e.a(r10, r13.f15998h, r6, r11, r13.f15997g);
        k(r13.f16000j, r14);     // Catch: Throwable -> L6
        d.c.i.l.d r9 = new d.c.i.l.d(r14, r12, r10.S(), r10.E(), r6, r10.Q(), r10.V(), r10.N());     // Catch: Throwable -> L6
        r14.close();
        return r9;
    L6:
        th = move-exception;
        r14.close();
        throw th;
    }

    public d.c.i.l.d g(d.c.i.l.e r11, d.c.i.f.c r12) {
        Rect r5 = j(r11, r12);
        d.c.c.h.a<Bitmap> r9 = this.f16150e.b(r11, r12.f15998h, r5, r12.f15997g);
        k(r12.f16000j, r9);     // Catch: Throwable -> L6
        d.c.i.l.d r10 = new d.c.i.l.d(r9, d.c.i.l.g.f16188d, r11.S(), r11.E(), r5, r11.Q(), r11.V(), r11.N());     // Catch: Throwable -> L6
        r9.close();
        return r10;
    L6:
        th = move-exception;
        r9.close();
        throw th;
    }
}
