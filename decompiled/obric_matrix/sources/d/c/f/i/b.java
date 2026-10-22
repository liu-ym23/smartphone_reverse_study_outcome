package d.c.f.i;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import d.c.c.d.h;
import d.c.c.d.i;
import d.c.f.e.s;
import d.c.f.e.t;
import d.c.f.h.b;

/* JADX INFO: loaded from: classes.dex */
public class b<DH extends d.c.f.h.b> implements t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f15721a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f15722b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f15723c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private DH f15724d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private d.c.f.h.a f15725e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final d.c.f.b.b f15726f;

    public b(DH r2) {
        this.f15721a = false;
        this.f15722b = false;
        this.f15723c = true;
        this.f15725e = null;
        this.f15726f = d.c.f.b.b.a();
        if (r2 == null) goto L6;
        p(r2);
        return;
    }

    private void c() {
        if (this.f15721a == false) goto L5;
        return;
    L5:
        this.f15726f.b(d.c.f.b.b.a.f15557l);
        this.f15721a = true;
        d.c.f.h.a r0 = this.f15725e;
        if (r0 != null) goto L8;
        return;
    L8:
        if (r0.d() == null) goto L12;
        this.f15725e.f();
        return;
    }

    private void d() {
        if (this.f15722b == true) goto L5;
    L7:
        f();
        return;
    L5:
        if (this.f15723c == false) goto L7;
        c();
    }

    public static <DH extends d.c.f.h.b> b<DH> e(DH r1, Context r2) {
        b<DH> r0 = new b(r1);
        r0.n(r2);
        return r0;
    }

    private void f() {
        if (this.f15721a == true) goto L5;
        return;
    L5:
        this.f15726f.b(d.c.f.b.b.a.m);
        this.f15721a = false;
        if (j() == false) goto L9;
        this.f15725e.c();
        return;
    }

    private void q(t r2) {
        Object r1 = i();
        if ((r1 instanceof s) == false) goto L6;
        ((s) r1).j(r2);
        return;
    }

    @Override // d.c.f.e.t
    public void a() {
        if (this.f15721a == false) goto L5;
        return;
    L5:
        d.c.c.e.a.A(d.c.f.b.b.class, "%x: Draw requested for a non-attached controller %x. %s", new Object[]{Integer.valueOf(System.identityHashCode(this)), Integer.valueOf(System.identityHashCode(this.f15725e)), toString()});
        this.f15722b = true;
        this.f15723c = true;
        d();
    }

    @Override // d.c.f.e.t
    public void b(boolean r3) {
        if (this.f15723c != r3) goto L5;
        return;
    L5:
        d.c.f.b.b r0 = this.f15726f;
        if (r3 == false) goto L8;
        d.c.f.b.b.a r1 = d.c.f.b.b.a.v;
    L9:
        r0.b(r1);
        this.f15723c = r3;
        d();
        return;
    L8:
        r1 = d.c.f.b.b.a.w;
        goto L9
    }

    public d.c.f.h.a g() {
        return this.f15725e;
    }

    public DH h() {
        DH r0 = this.f15724d;
        i.g(r0);
        return r0;
    }

    public Drawable i() {
        DH r0 = this.f15724d;
        if (r0 != null) goto L6;
        return null;
    L6:
        return r0.e();
    }

    public boolean j() {
        d.c.f.h.a r0 = this.f15725e;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.d() != this.f15724d) goto L7;
        return true;
    }

    public void k() {
        this.f15726f.b(d.c.f.b.b.a.t);
        this.f15722b = true;
        d();
    }

    public void l() {
        this.f15726f.b(d.c.f.b.b.a.u);
        this.f15722b = false;
        d();
    }

    public boolean m(MotionEvent r2) {
        if (j() == true) goto L7;
        return false;
    L7:
        return this.f15725e.onTouchEvent(r2);
    }

    public void n(Context r1) {
    }

    public void o(d.c.f.h.a r4) {
        boolean r0 = this.f15721a;
        if (r0 == false) goto L6;
        f();
    L6:
        if (j() == false) goto L8;
        this.f15726f.b(d.c.f.b.b.a.f15554i);
        this.f15725e.g(null);
    L8:
        this.f15725e = r4;
        if (r4 == null) goto L11;
        this.f15726f.b(d.c.f.b.b.a.f15553h);
        this.f15725e.g(this.f15724d);
    L12:
        if (r0 == false) goto L15;
        c();
        return;
    L15:
        return;
    L11:
        this.f15726f.b(d.c.f.b.b.a.f15555j);
        goto L12
    }

    public void p(DH r3) {
        this.f15726f.b(d.c.f.b.b.a.f15551f);
        boolean r0 = j();
        q(null);
        i.g(r3);
        DH r1 = r3;
        this.f15724d = r1;
        Drawable r2 = r1.e();
        if (r2 != null) goto L5;
    L8:
        boolean r4 = true;
    L9:
        b(r4);
        q(this);
        if (r0 == false) goto L13;
        this.f15725e.g(r3);
        return;
    L13:
        return;
    L5:
        if (r2.isVisible() == true) goto L8;
        r4 = false;
        goto L9
    }

    public String toString() {
        h.b r0 = h.d(this);
        r0.c("controllerAttached", this.f15721a);
        r0.c("holderAttached", this.f15722b);
        r0.c("drawableVisible", this.f15723c);
        r0.b("events", this.f15726f.toString());
        return r0.toString();
    }
}
