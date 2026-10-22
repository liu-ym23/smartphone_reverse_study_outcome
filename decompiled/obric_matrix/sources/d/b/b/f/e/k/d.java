package d.b.b.f.e.k;

import android.app.Activity;

/* JADX INFO: loaded from: classes.dex */
public class d extends d.b.b.n.g.b implements d.b.b.f.e.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile d.b.b.f.e.d f12852a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private d.b.b.n.g.a f12853b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private d.b.b.f.e.g f12854c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private d.b.b.f.e.g f12855d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private d.b.b.f.e.g f12856e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private d.b.b.f.e.g f12857f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private d.b.b.f.e.g f12858g;

    public d() {
        d.b.b.n.g.a r0 = (d.b.b.n.g.a) d.b.b.n.c.a(d.b.b.n.g.a.class);
        this.f12853b = r0;
        this.f12852a = new d.b.b.f.e.d(r0);
        this.f12854c = new f(this.f12852a);
        this.f12855d = new g(this.f12852a);
        this.f12856e = new h(this.f12852a);
        this.f12857f = new c(this.f12852a);
        this.f12858g = new e(this.f12852a);
        this.f12852a.c(this.f12854c, this.f12855d, this.f12856e, this.f12857f, this.f12858g);
        this.f12853b.b(this);
    }

    @Override // d.b.b.f.e.f
    public void a(d.b.b.f.d.c r1) {
        this.f12852a.k(r1);
    }

    @Override // d.b.b.f.e.f
    public void b() {
        this.f12852a.l();
    }

    @Override // d.b.b.n.g.b, d.b.b.n.g.c
    public void onBackground(Activity r1) {
        this.f12852a.g(true);
    }

    @Override // d.b.b.n.g.b, d.b.b.n.g.c
    public void onFront(Activity r1) {
        this.f12852a.g(false);
    }
}
