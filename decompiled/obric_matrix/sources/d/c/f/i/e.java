package d.c.f.i;

import d.c.c.d.i;

/* JADX INFO: loaded from: classes.dex */
public class e implements d.c.i.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private d.c.i.q.c f15737a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private d.c.f.c.b f15738b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private c f15739c;

    public e(d.c.i.q.c r1, d.c.f.c.b r2, c r3) {
        b(r1, r2, r3);
    }

    private void b(d.c.i.q.c r1, d.c.f.c.b r2, c r3) {
        i.g(r1);
        i.g(r2);
        i.g(r3);
        this.f15737a = r1;
        this.f15738b = r2;
        this.f15739c = r3;
    }

    @Override // d.c.i.b
    public void a(int r4, int r5) {
        d.c.i.q.c r0 = this.f15737a;
        d.c.f.c.b r1 = this.f15738b;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.I(new d.c.i.f.f(r4, r5));
        r1.D(r0.a());
        this.f15739c.setController(r1.c());
    }
}
