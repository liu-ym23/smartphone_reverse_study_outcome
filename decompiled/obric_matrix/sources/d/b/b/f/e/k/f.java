package d.b.b.f.e.k;

/* JADX INFO: loaded from: classes.dex */
class f extends a {
    public f(d.b.b.f.e.d r1) {
        super(r1);
    }

    @Override // d.b.b.f.e.g
    public d.b.b.f.e.h c() {
        return d.b.b.f.e.h.f12825f;
    }

    @Override // d.b.b.f.e.k.a
    protected long h() {
        d.b.b.f.d.c r0 = this.f12839b;
        boolean r4 = this.f12841d;
        if (r0 != null) goto L8;
        if (r4 == true) goto L12;
        return 30000;
    L12:
        return 600000;
    L8:
        if (r4 == false) goto L11;
        return 600000;
    L11:
        return ((long) r0.g()) * 1000;
    }

    @Override // d.b.b.f.e.k.a
    protected boolean i(boolean r2) {
        if (r2 == false) goto L10;
        d.b.b.f.a.b r0 = d.b.b.f.e.c.c().a();
        if (r0 != null) goto L6;
    L9:
        this.f12804a.i();
        goto L10
    L6:
        if (r0.a() == false) goto L9;
        return false;
    L10:
        return r2;
    }

    @Override // d.b.b.f.e.k.a
    protected boolean j() {
        return false;
    }
}
