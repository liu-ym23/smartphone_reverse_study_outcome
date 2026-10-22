package d.c.i.e;

/* JADX INFO: loaded from: classes2.dex */
public class p<K, V> implements q<K, V> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final q<K, V> f15972f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final s f15973g;

    public p(q<K, V> r1, s r2) {
        this.f15972f = r1;
        this.f15973g = r2;
    }

    @Override // d.c.i.e.q
    public d.c.c.h.a<V> b(K r2, d.c.c.h.a<V> r3) {
        this.f15973g.b();
        return this.f15972f.b(r2, r3);
    }

    @Override // d.c.i.e.q
    public d.c.c.h.a<V> get(K r2) {
        d.c.c.h.a<V> r0 = this.f15972f.get(r2);
        s r1 = this.f15973g;
        if (r0 != null) goto L5;
        r1.c();
    L8:
        return r0;
    L5:
        r1.a(r2);
        V r3 = r0.N();
        if ((r3 instanceof d.c.i.l.h) == false) goto L8;
        ((d.c.i.l.h) r3).a();
        goto L8
    }
}
