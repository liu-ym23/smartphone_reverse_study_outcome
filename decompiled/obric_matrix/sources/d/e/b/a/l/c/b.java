package d.e.b.a.l.c;

/* JADX INFO: loaded from: classes2.dex */
final class b implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final d<Integer> f16645a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final d<String> f16646b;

    b() {
        this.f16645a = d.b();
        this.f16646b = d.c();
    }

    @Override // d.e.b.a.l.c.f
    public void a(d.e.b.a.g r2) {
        if (d.e.b.a.k.a.b(this.f16646b.d().a(r2)) == false) goto L5;
        f r1 = this.f16646b;
    L6:
        r1.a(r2);
        return;
    L5:
        r1 = this.f16645a;
        goto L6
    }

    d.e.b.a.g b(int r1) {
        return this.f16645a.e(Integer.valueOf(r1));
    }

    d.e.b.a.g c(String r1) {
        return this.f16646b.e(r1);
    }
}
