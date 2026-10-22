package d.c.i.p;

import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public abstract class w0<T> extends d.c.c.b.g<T> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final k<T> f16464g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final n0 f16465h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final String f16466i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final String f16467j;

    public w0(k<T> r1, n0 r2, String r3, String r4) {
        this.f16464g = r1;
        this.f16465h = r2;
        this.f16466i = r3;
        this.f16467j = r4;
        r2.b(r4, r3);
    }

    @Override // d.c.c.b.g
    protected void e() {
        n0 r0 = this.f16465h;
        String r1 = this.f16467j;
        String r2 = this.f16466i;
        if (r0.f(r1) == false) goto L5;
        Map<String, String> r3 = h();
    L6:
        r0.d(r1, r2, r3);
        this.f16464g.b();
        return;
    L5:
        r3 = null;
        goto L6
    }

    @Override // d.c.c.b.g
    protected void f(Exception r5) {
        n0 r0 = this.f16465h;
        String r1 = this.f16467j;
        String r2 = this.f16466i;
        if (r0.f(r1) == false) goto L5;
        Map<String, String> r3 = i(r5);
    L6:
        r0.j(r1, r2, r5, r3);
        this.f16464g.a(r5);
        return;
    L5:
        r3 = null;
        goto L6
    }

    @Override // d.c.c.b.g
    protected void g(T r5) {
        n0 r0 = this.f16465h;
        String r1 = this.f16467j;
        String r2 = this.f16466i;
        if (r0.f(r1) == false) goto L5;
        Map<String, String> r3 = j(r5);
    L6:
        r0.i(r1, r2, r3);
        this.f16464g.d(r5, 1);
        return;
    L5:
        r3 = null;
        goto L6
    }

    protected Map<String, String> h() {
        return null;
    }

    protected Map<String, String> i(Exception r1) {
        return null;
    }

    protected Map<String, String> j(T r1) {
        return null;
    }
}
