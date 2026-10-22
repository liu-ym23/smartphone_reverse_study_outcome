package d.b.b.f.e.k;

import androidx.lifecycle.CoroutineLiveDataKt;

/* JADX INFO: loaded from: classes.dex */
class g extends a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f12859e;

    public g(d.b.b.f.e.d r1) {
        super(r1);
        this.f12859e = 0;
    }

    @Override // d.b.b.f.e.k.a, d.b.b.f.e.a, d.b.b.f.e.g
    public void b(boolean r2) {
        if (r2 == false) goto L4;
        this.f12859e = 0;
    L4:
        super.b(r2);
    }

    @Override // d.b.b.f.e.g
    public d.b.b.f.e.h c() {
        return d.b.b.f.e.h.f12826g;
    }

    @Override // d.b.b.f.e.k.a
    protected long h() {
        if (this.f12841d == false) goto L5;
        return 300000;
    L5:
        return CoroutineLiveDataKt.DEFAULT_TIMEOUT;
    }

    @Override // d.b.b.f.e.k.a
    protected boolean i(boolean r4) {
        if (r4 == false) goto L9;
        this.f12859e++;
        e("over time: " + this.f12859e + " max over time: 2");
        if (this.f12859e < 2) goto L8;
        this.f12859e = 0;
        this.f12804a.j();
        return true;
    L8:
        return false;
    L9:
        this.f12859e = 0;
        this.f12804a.h();
        return true;
    }

    @Override // d.b.b.f.e.k.a
    protected boolean j() {
        this.f12859e = 0;
        this.f12804a.h();
        return true;
    }
}
