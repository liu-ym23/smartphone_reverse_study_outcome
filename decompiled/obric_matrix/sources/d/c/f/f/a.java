package d.c.f.f;

import android.content.res.Resources;
import android.graphics.ColorFilter;
import android.graphics.PointF;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import d.c.c.d.i;
import d.c.f.e.f;
import d.c.f.e.g;
import d.c.f.e.o;
import d.c.f.e.p;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class a implements d.c.f.h.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Drawable f15679a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Resources f15680b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private d f15681c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final c f15682d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final d.c.f.e.e f15683e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final f f15684f;

    a(b r11) {
        int r1 = 0;
        ColorDrawable r0 = new ColorDrawable(0);
        this.f15679a = r0;
        if (d.c.i.r.b.d() == false) goto L5;
        d.c.i.r.b.a("GenericDraweeHierarchy()");
    L5:
        this.f15680b = r11.o();
        this.f15681c = r11.r();
        f r2 = new f(r0);
        this.f15684f = r2;
        int r3 = 1;
        if (r11.i() == null) goto L8;
        int r4 = r11.i().size();
    L10:
        if (r11.l() == null) goto L12;
        int r5 = 1;
    L13:
        int r6 = r4 + r5;
        Drawable[] r7 = new Drawable[r6 + 6];
        r7[0] = h(r11.e(), null);
        r7[1] = h(r11.j(), r11.k());
        r7[2] = g(r2, r11.d(), r11.c(), r11.b());
        r7[3] = h(r11.m(), r11.n());
        r7[4] = h(r11.p(), r11.q());
        r7[5] = h(r11.g(), r11.h());
        if (r6 > 0) goto L16;
    L25:
        d.c.f.e.e r8 = new d.c.f.e.e(r7);
        this.f15683e = r8;
        r8.r(r11.f());
        c r9 = new c(e.e(r8, this.f15681c));
        this.f15682d = r9;
        r9.mutate();
        p();
        if (d.c.i.r.b.d() == false) goto L30;
        d.c.i.r.b.b();
        return;
    L30:
        return;
    L16:
        if (r11.i() == null) goto L23;
        Iterator<Drawable> r10 = r11.i().iterator();
    L19:
        if (r10.hasNext() == false) goto L21;
        r7[r1 + 6] = h(r10.next(), null);
        r1 = r1 + 1;
        goto L19
    L21:
        r3 = r1;
    L23:
        if (r11.l() == null) goto L25;
        r7[r3 + 6] = h(r11.l(), null);
        goto L25
    L12:
        r5 = 0;
        goto L13
    L8:
        r4 = 1;
        goto L10
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void C(float r4) {
        Drawable r0 = this.f15683e.c(3);
        if (r0 != 0) goto L6;
        return;
    L6:
        if (r4 < 0.999f) goto L12;
        if ((r0 instanceof Animatable) == false) goto L10;
        ((Animatable) r0).stop();
    L10:
        k(3);
    L15:
        r0.setLevel(Math.round(r4 * 10000.0f));
        return;
    L12:
        if ((r0 instanceof Animatable) == false) goto L14;
        ((Animatable) r0).start();
    L14:
        i(3);
        goto L15
    }

    private Drawable g(Drawable r1, p.b r2, PointF r3, ColorFilter r4) {
        r1.setColorFilter(r4);
        return e.g(r1, r2, r3);
    }

    private Drawable h(Drawable r2, p.b r3) {
        return e.f(e.d(r2, this.f15681c, this.f15680b), r3);
    }

    private void i(int r1) {
        if (r1 < 0) goto L5;
        this.f15683e.m(r1);
        return;
    }

    private void j() {
        k(1);
        k(2);
        k(3);
        k(4);
        k(5);
    }

    private void k(int r1) {
        if (r1 < 0) goto L5;
        this.f15683e.n(r1);
        return;
    }

    private d.c.f.e.b l(int r1) {
        d.c.f.e.b r0 = this.f15683e.e(r1);
        if ((r0.k() instanceof g) == false) goto L6;
        r0 = (g) r0.k();
    L6:
        if ((r0.k() instanceof o) == true) goto L8;
        return r0;
    L8:
        return (o) r0.k();
    }

    private o n(int r1) {
        d.c.f.e.b r0 = l(r1);
        if ((r0 instanceof o) == false) goto L7;
        return (o) r0;
    L7:
        return e.k(r0, p.b.f15662a);
    }

    private void o() {
        this.f15684f.f(this.f15679a);
    }

    private void p() {
        d.c.f.e.e r0 = this.f15683e;
        if (r0 == null) goto L6;
        r0.i();
        this.f15683e.l();
        j();
        i(1);
        this.f15683e.o();
        this.f15683e.k();
        return;
    }

    private void s(int r3, Drawable r4) {
        if (r4 != null) goto L5;
        this.f15683e.h(r3, null);
        return;
    L5:
        Drawable r5 = e.d(r4, this.f15681c, this.f15680b);
        l(r3).f(r5);
    }

    public void A(Drawable r2) {
        s(1, r2);
    }

    public void B(Drawable r2, p.b r3) {
        s(1, r2);
        n(1).t(r3);
    }

    public void D(int r2) {
        F(this.f15680b.getDrawable(r2));
    }

    public void E(int r2, p.b r3) {
        G(this.f15680b.getDrawable(r2), r3);
    }

    public void F(Drawable r2) {
        s(4, r2);
    }

    public void G(Drawable r2, p.b r3) {
        s(4, r2);
        n(4).t(r3);
    }

    public void H(d r4) {
        this.f15681c = r4;
        e.j(this.f15682d, r4);
        int r5 = 0;
    L4:
        if (r5 >= this.f15683e.f()) goto L6;
        e.i(l(r5), this.f15681c, this.f15680b);
        r5 = r5 + 1;
        goto L4
    }

    @Override // d.c.f.h.c
    public void a(Drawable r1) {
        this.f15682d.p(r1);
    }

    @Override // d.c.f.h.c
    public void b(Throwable r2) {
        this.f15683e.i();
        j();
        if (this.f15683e.c(4) == null) goto L5;
        i(4);
    L6:
        this.f15683e.k();
        return;
    L5:
        i(1);
        goto L6
    }

    @Override // d.c.f.h.c
    public void c(Throwable r2) {
        this.f15683e.i();
        j();
        if (this.f15683e.c(5) == null) goto L5;
        i(5);
    L6:
        this.f15683e.k();
        return;
    L5:
        i(1);
        goto L6
    }

    @Override // d.c.f.h.c
    public void d(float r3, boolean r4) {
        if (this.f15683e.c(3) != null) goto L5;
        return;
    L5:
        this.f15683e.i();
        C(r3);
        if (r4 == false) goto L8;
        this.f15683e.o();
    L8:
        this.f15683e.k();
    }

    @Override // d.c.f.h.b
    public Drawable e() {
        return this.f15682d;
    }

    @Override // d.c.f.h.c
    public void f(Drawable r3, float r4, boolean r5) {
        Drawable r6 = e.d(r3, this.f15681c, this.f15680b);
        r6.mutate();
        this.f15684f.f(r6);
        this.f15683e.i();
        j();
        i(2);
        C(r4);
        if (r5 == false) goto L5;
        this.f15683e.o();
    L5:
        this.f15683e.k();
    }

    public d m() {
        return this.f15681c;
    }

    public void q(p.b r2) {
        i.g(r2);
        n(2).t(r2);
    }

    public void r(Drawable r2) {
        s(0, r2);
    }

    @Override // d.c.f.h.c
    public void reset() {
        o();
        p();
    }

    public void t(int r1) {
        this.f15683e.r(r1);
    }

    public void u(int r2) {
        w(this.f15680b.getDrawable(r2));
    }

    public void v(int r2, p.b r3) {
        x(this.f15680b.getDrawable(r2), r3);
    }

    public void w(Drawable r2) {
        s(5, r2);
    }

    public void x(Drawable r2, p.b r3) {
        s(5, r2);
        n(5).t(r3);
    }

    public void y(int r2) {
        A(this.f15680b.getDrawable(r2));
    }

    public void z(int r2, p.b r3) {
        B(this.f15680b.getDrawable(r2), r3);
    }
}
