package d.c.f.a.a.i.i;

import d.c.f.a.a.i.g;
import d.c.f.a.a.i.h;

/* JADX INFO: loaded from: classes.dex */
public class b implements d.c.f.a.a.i.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final h f15539a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final g f15540b;

    public b(h r1, g r2) {
        this.f15539a = r1;
        this.f15540b = r2;
    }

    @Override // d.c.f.a.a.i.b
    public void a(String r1, int r2, boolean r3) {
        this.f15539a.l(r2);
        this.f15540b.q(this.f15539a, 1);
    }
}
