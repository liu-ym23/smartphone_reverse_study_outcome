package d.c.f.f;

import android.content.res.Resources;
import android.graphics.PointF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.os.Build;
import d.c.f.e.f;
import d.c.f.e.i;
import d.c.f.e.j;
import d.c.f.e.k;
import d.c.f.e.l;
import d.c.f.e.n;
import d.c.f.e.o;
import d.c.f.e.p;

/* JADX INFO: loaded from: classes.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Drawable f15711a = null;

    static {
        f15711a = new ColorDrawable(0);
    }

    private static Drawable a(Drawable r2, d r3, Resources r4) {
        if ((r2 instanceof BitmapDrawable) == false) goto L7;
        BitmapDrawable r5 = (BitmapDrawable) r2;
        j r0 = new j(r4, r5.getBitmap(), r5.getPaint());
        b(r0, r3);
        return r0;
    L7:
        if ((r2 instanceof NinePatchDrawable) == false) goto L11;
        n r6 = new n((NinePatchDrawable) r2);
        b(r6, r3);
        return r6;
    L11:
        if ((r2 instanceof ColorDrawable) == true) goto L13;
    L16:
        d.c.c.e.a.C("WrappingUtils", "Don't know how to round that drawable: %s", new Object[]{r2});
        return r2;
    L13:
        if (Build.VERSION.SDK_INT < 11) goto L16;
        k r7 = k.b((ColorDrawable) r2);
        b(r7, r3);
        return r7;
    }

    static void b(i r2, d r3) {
        r2.c(r3.g());
        r2.l(r3.c());
        r2.a(r3.a(), r3.b());
        r2.h(r3.f());
        r2.e(r3.i());
    }

    static d.c.f.e.b c(d.c.f.e.b r2) {
    L2:
        Object r0 = r2.k();
        if (r0 == r2) goto L8;
        if ((r0 instanceof d.c.f.e.b) == false) goto L8;
        r2 = (d.c.f.e.b) r0;
    L8:
        return r2;
    }

    static Drawable d(Drawable r2, d r3, Resources r4) {
    L26:
        th = move-exception;
        if (d.c.i.r.b.d() == false) goto L30;
        d.c.i.r.b.b();
    L30:
        throw th;
    L3:
        if (d.c.i.r.b.d() == false) goto L5;
        d.c.i.r.b.a("WrappingUtils#maybeApplyLeafRounding");     // Catch: Throwable -> L26
    L5:
        if (r2 == null) goto L23;
        if (r3 == null) goto L23;
        if (r3.h() != d.a.f15709g) goto L23;
        if ((r2 instanceof f) == false) goto L17;
        d.c.f.e.b r0 = c((f) r2);     // Catch: Throwable -> L26
        r0.f(a(r0.f(f15711a), r3, r4));     // Catch: Throwable -> L26
        if (d.c.i.r.b.d() == false) goto L16;
        d.c.i.r.b.b();
    L16:
        return r2;
    L17:
        Drawable r5 = a(r2, r3, r4);     // Catch: Throwable -> L26
        if (d.c.i.r.b.d() == false) goto L21;
        d.c.i.r.b.b();
    L21:
        return r5;
    L23:
        if (d.c.i.r.b.d() == false) goto L25;
        d.c.i.r.b.b();
    L25:
        return r2;
    }

    static Drawable e(Drawable r2, d r3) {
    L19:
        th = move-exception;
        if (d.c.i.r.b.d() == false) goto L23;
        d.c.i.r.b.b();
    L23:
        throw th;
    L3:
        if (d.c.i.r.b.d() == false) goto L5;
        d.c.i.r.b.a("WrappingUtils#maybeWrapWithRoundedOverlayColor");     // Catch: Throwable -> L19
    L5:
        if (r2 == null) goto L16;
        if (r3 == null) goto L16;
        if (r3.h() != d.a.f15708f) goto L16;
        l r0 = new l(r2);     // Catch: Throwable -> L19
        b(r0, r3);     // Catch: Throwable -> L19
        r0.p(r3.e());     // Catch: Throwable -> L19
        if (d.c.i.r.b.d() == false) goto L14;
        d.c.i.r.b.b();
    L14:
        return r0;
    L16:
        if (d.c.i.r.b.d() == false) goto L18;
        d.c.i.r.b.b();
    L18:
        return r2;
    }

    static Drawable f(Drawable r1, p.b r2) {
        return g(r1, r2, null);
    }

    static Drawable g(Drawable r1, p.b r2, PointF r3) {
        if (d.c.i.r.b.d() == false) goto L5;
        d.c.i.r.b.a("WrappingUtils#maybeWrapWithScaleType");
    L5:
        if (r1 == null) goto L16;
        if (r2 == null) goto L16;
        o r0 = new o(r1, r2);
        if (r3 == null) goto L12;
        r0.s(r3);
    L12:
        if (d.c.i.r.b.d() == false) goto L14;
        d.c.i.r.b.b();
    L14:
        return r0;
    L16:
        if (d.c.i.r.b.d() == false) goto L18;
        d.c.i.r.b.b();
    L18:
        return r1;
    }

    static void h(i r2) {
        r2.c(false);
        r2.i(0.0f);
        r2.a(0, 0.0f);
        r2.h(0.0f);
        r2.e(false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    static void i(d.c.f.e.b r3, d r4, Resources r5) {
        d.c.f.e.b r6 = c(r3);
        Drawable r0 = r6.k();
        if (r4 == null) goto L12;
        if (r4.h() != d.a.f15709g) goto L12;
        if ((r0 instanceof i) == false) goto L9;
        b((i) r0, r4);
        return;
    L9:
        if (r0 == 0) goto L16;
        r6.f(f15711a);
        r6.f(a(r0, r4, r5));
        return;
    L16:
        return;
    L12:
        if ((r0 instanceof i) == false) goto L18;
        h((i) r0);
        return;
    }

    static void j(d.c.f.e.b r3, d r4) {
        Drawable r0 = r3.k();
        if (r4 == null) goto L11;
        if (r4.h() != d.a.f15708f) goto L11;
        if ((r0 instanceof l) == false) goto L9;
        l r1 = (l) r0;
        b(r1, r4);
        r1.p(r4.e());
        return;
    L9:
        r3.f(e(r3.f(f15711a), r4));
        return;
    L11:
        if ((r0 instanceof l) == false) goto L16;
        Drawable r5 = f15711a;
        r3.f(((l) r0).n(r5));
        r5.setCallback(null);
        return;
    }

    static o k(d.c.f.e.b r1, p.b r2) {
        Drawable r3 = f(r1.f(f15711a), r2);
        r1.f(r3);
        d.c.c.d.i.h(r3, "Parent has no child drawable!");
        return (o) r3;
    }
}
