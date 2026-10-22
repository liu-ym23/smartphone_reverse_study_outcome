package d.c.f.a.a.i;

import android.graphics.Rect;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class g extends d.c.i.m.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final d.c.f.a.a.d f15514a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.facebook.common.time.b f15515b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final h f15516c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private c f15517d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private b f15518e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private d.c.f.a.a.i.i.c f15519f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private d.c.f.a.a.i.i.a f15520g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private d.c.i.m.c f15521h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private List<f> f15522i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f15523j;

    public g(com.facebook.common.time.b r1, d.c.f.a.a.d r2) {
        this.f15515b = r1;
        this.f15514a = r2;
        this.f15516c = new h();
    }

    private void t() {
        if (this.f15520g != null) goto L6;
        this.f15520g = new d.c.f.a.a.i.i.a(this.f15515b, this.f15516c, this);
    L6:
        if (this.f15519f != null) goto L9;
        this.f15519f = new d.c.f.a.a.i.i.c(this.f15515b, this.f15516c);
    L9:
        if (this.f15518e != null) goto L11;
        this.f15518e = new d.c.f.a.a.i.i.b(this.f15516c, this);
    L11:
        c r0 = this.f15517d;
        if (r0 != null) goto L14;
        this.f15517d = new c(this.f15514a.s(), this.f15518e);
    L16:
        if (this.f15521h != null) goto L19;
        this.f15521h = new d.c.i.m.c(new d.c.i.m.d[]{this.f15519f, this.f15517d});
        return;
    L19:
        return;
    L14:
        r0.m(this.f15514a.s());
        goto L16
    }

    public void m(f r2) {
        if (r2 != null) goto L5;
        return;
    L5:
        if (this.f15522i != null) goto L7;
        this.f15522i = new LinkedList();
    L7:
        this.f15522i.add(r2);
    }

    public void n() {
        d.c.f.h.b r0 = this.f15514a.d();
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.e() == null) goto L9;
        Rect r1 = r0.e().getBounds();
        this.f15516c.r(r1.width());
        this.f15516c.q(r1.height());
        return;
    }

    public void o() {
        List<f> r0 = this.f15522i;
        if (r0 == null) goto L6;
        r0.clear();
        return;
    }

    public void p(h r2, int r3) {
        if (this.f15523j == false) goto L13;
        List<f> r0 = this.f15522i;
        if (r0 != null) goto L7;
        return;
    L7:
        if (r0.isEmpty() == true) goto L16;
        e r4 = r2.w();
        Iterator<f> r1 = this.f15522i.iterator();
    L11:
        if (r1.hasNext() == false) goto L17;
        r1.next().b(r4, r3);
        goto L11
    L17:
        return;
    L16:
        return;
    }

    public void q(h r2, int r3) {
        r2.k(r3);
        if (this.f15523j == false) goto L16;
        List<f> r0 = this.f15522i;
        if (r0 != null) goto L7;
        return;
    L7:
        if (r0.isEmpty() == false) goto L10;
        return;
    L10:
        if (r3 != 3) goto L12;
        n();
    L12:
        e r4 = r2.w();
        Iterator<f> r1 = this.f15522i.iterator();
    L14:
        if (r1.hasNext() == false) goto L20;
        r1.next().a(r4, r3);
        goto L14
    L20:
        return;
    }

    public void r() {
        o();
        s(false);
        this.f15516c.b();
    }

    public void s(boolean r2) {
        this.f15523j = r2;
        if (r2 == false) goto L13;
        t();
        b r3 = this.f15518e;
        if (r3 == null) goto L7;
        this.f15514a.V(r3);
    L7:
        d.c.f.a.a.i.i.a r4 = this.f15520g;
        if (r4 == null) goto L10;
        this.f15514a.k(r4);
    L10:
        d.c.i.m.c r5 = this.f15521h;
        if (r5 == null) goto L23;
        this.f15514a.W(r5);
        return;
    L23:
        return;
    L13:
        b r6 = this.f15518e;
        if (r6 == null) goto L16;
        this.f15514a.k0(r6);
    L16:
        d.c.f.a.a.i.i.a r7 = this.f15520g;
        if (r7 == null) goto L19;
        this.f15514a.L(r7);
    L19:
        d.c.i.m.c r8 = this.f15521h;
        if (r8 == null) goto L25;
        this.f15514a.l0(r8);
        return;
    }
}
