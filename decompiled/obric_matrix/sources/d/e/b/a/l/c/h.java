package d.e.b.a.l.c;

/* JADX INFO: loaded from: classes2.dex */
public final class h implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final k f16649a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final e<b> f16650b;

    public h(k r3, d.e.b.a.b r4, d.e.b.a.l.b.b r5) {
        this(r3, new a(r4, r5, new b()));
    }

    public h(k r1, e<b> r2) {
        this.f16649a = r1;
        this.f16650b = r2;
    }

    @Override // d.e.b.a.l.c.j
    public d.e.b.a.g a(int r3) {
        if (d.e.b.a.k.a.a(r3) == true) goto L7;
        return ((b) this.f16650b.a(this.f16649a.a(Integer.valueOf(r3)))).b(r3);
    L7:
        throw new IllegalArgumentException(r3 + " calling code belongs to a geo entity");
    }

    @Override // d.e.b.a.l.c.l
    public d.e.b.a.g b(String r2) {
        if (d.e.b.a.k.a.b(r2) == false) goto L7;
        return ((b) this.f16650b.a(this.f16649a.a(r2))).c(r2);
    L7:
        throw new IllegalArgumentException(r2 + " region code is a non-geo entity");
    }
}
