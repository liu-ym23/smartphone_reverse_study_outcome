package d.c.f.a.a.i.i;

import d.c.f.a.a.i.h;

/* JADX INFO: loaded from: classes.dex */
public class c extends d.c.i.m.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.facebook.common.time.b f15541a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final h f15542b;

    public c(com.facebook.common.time.b r1, h r2) {
        this.f15541a = r1;
        this.f15542b = r2;
    }

    @Override // d.c.i.m.b, d.c.i.m.d
    public void a(d.c.i.q.b r4, Object r5, String r6, boolean r7) {
        this.f15542b.o(this.f15541a.now());
        this.f15542b.m(r4);
        this.f15542b.c(r5);
        this.f15542b.t(r6);
        this.f15542b.s(r7);
    }

    @Override // d.c.i.m.b, d.c.i.m.d
    public void c(d.c.i.q.b r4, String r5, boolean r6) {
        this.f15542b.n(this.f15541a.now());
        this.f15542b.m(r4);
        this.f15542b.t(r5);
        this.f15542b.s(r6);
    }

    @Override // d.c.i.m.b, d.c.i.m.d
    public void g(d.c.i.q.b r3, String r4, Throwable r5, boolean r6) {
        this.f15542b.n(this.f15541a.now());
        this.f15542b.m(r3);
        this.f15542b.t(r4);
        this.f15542b.s(r6);
    }

    @Override // d.c.i.m.b, d.c.i.m.d
    public void k(String r4) {
        this.f15542b.n(this.f15541a.now());
        this.f15542b.t(r4);
    }
}
