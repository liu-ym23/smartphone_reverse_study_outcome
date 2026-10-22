package d.c.f.a.a;

import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import d.c.f.e.h;

/* JADX INFO: loaded from: classes.dex */
public class a implements d.c.i.j.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Resources f15489a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final d.c.i.j.a f15490b;

    public a(Resources r1, d.c.i.j.a r2) {
        this.f15489a = r1;
        this.f15490b = r2;
    }

    private static boolean d(d.c.i.l.d r2) {
        if (r2.O() != 1) goto L5;
    L7:
        return false;
    L5:
        if (r2.O() == 0) goto L7;
        return true;
    }

    private static boolean e(d.c.i.l.d r1) {
        if (r1.S() != 0) goto L5;
    L7:
        return false;
    L5:
        if (r1.S() == (-1)) goto L7;
        return true;
    }

    @Override // d.c.i.j.a
    public Drawable a(d.c.i.l.c r2, Drawable r3) {
    L25:
        th = move-exception;
        if (d.c.i.r.b.d() == false) goto L29;
        d.c.i.r.b.b();
    L29:
        throw th;
    L3:
        if (d.c.i.r.b.d() == false) goto L6;
        d.c.i.r.b.a("DefaultDrawableFactory#createDrawable");     // Catch: Throwable -> L25
    L6:
        if ((r2 instanceof d.c.i.l.d) == false) goto L12;
        Drawable r1 = c(r2);     // Catch: Throwable -> L25
        if (d.c.i.r.b.d() == false) goto L11;
        d.c.i.r.b.b();
    L11:
        return r1;
    L12:
        d.c.i.j.a r0 = this.f15490b;     // Catch: Throwable -> L25
        if (r0 == null) goto L22;
        if (r0.b(r2) == false) goto L22;
        Drawable r4 = this.f15490b.a(r2, r3);     // Catch: Throwable -> L25
        if (d.c.i.r.b.d() == false) goto L20;
        d.c.i.r.b.b();
    L20:
        return r4;
    L22:
        if (d.c.i.r.b.d() == false) goto L24;
        d.c.i.r.b.b();
    L24:
        return null;
    }

    @Override // d.c.i.j.a
    public boolean b(d.c.i.l.c r1) {
        return true;
    }

    @Override // d.c.i.j.a
    public Drawable c(d.c.i.l.c r3) {
    L33:
        th = move-exception;
        if (d.c.i.r.b.d() == false) goto L37;
        d.c.i.r.b.b();
    L37:
        throw th;
    L3:
        if (d.c.i.r.b.d() == false) goto L6;
        d.c.i.r.b.a("DefaultDrawableFactory#createDrawable");     // Catch: Throwable -> L33
    L6:
        if ((r3 instanceof d.c.i.l.d) == false) goto L20;
        d.c.i.l.d r4 = (d.c.i.l.d) r3;     // Catch: Throwable -> L33
        BitmapDrawable r0 = new BitmapDrawable(this.f15489a, r4.E());     // Catch: Throwable -> L33
        if (e(r4) == false) goto L10;
    L15:
        h r2 = new h(r0, r4.S(), r4.O());     // Catch: Throwable -> L33
        if (d.c.i.r.b.d() == false) goto L19;
        d.c.i.r.b.b();
    L19:
        return r2;
    L10:
        if (d(r4) == true) goto L15;
        if (d.c.i.r.b.d() == false) goto L14;
        d.c.i.r.b.b();
    L14:
        return r0;
    L20:
        d.c.i.j.a r1 = this.f15490b;     // Catch: Throwable -> L33
        if (r1 == null) goto L30;
        if (r1.b(r3) == false) goto L30;
        Drawable r5 = this.f15490b.c(r3);     // Catch: Throwable -> L33
        if (d.c.i.r.b.d() == false) goto L28;
        d.c.i.r.b.b();
    L28:
        return r5;
    L30:
        if (d.c.i.r.b.d() == false) goto L32;
        d.c.i.r.b.b();
    L32:
        return null;
    }
}
