package d.b.w.a.b;

import android.content.Context;
import d.b.w.a.a.c;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class a implements c {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static volatile a f15176g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f15177a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private d.b.w.a.b.d.a f15178b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private d.b.w.a.b.f.a f15179c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private d.b.w.a.b.e.b f15180d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private d.b.w.a.b.c.a f15181e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private d.b.w.a.a.a f15182f;

    static {
    }

    private a(Context r2) {
        this(r2, d.b.w.a.a.a.f15142i);
    }

    private a(Context r2, d.b.w.a.a.a r3) {
        Context r4 = r2.getApplicationContext();
        this.f15177a = r4;
        if (r3 != null) goto L5;
        d.b.w.a.a.a r0 = d.b.w.a.a.a.f15142i;
    L6:
        this.f15182f = r0;
        this.f15178b = new d.b.w.a.b.d.a(r4, this);
        this.f15179c = new d.b.w.a.b.f.a(this.f15177a, this);
        this.f15180d = new d.b.w.a.b.e.b(this.f15177a, this);
        this.f15181e = new d.b.w.a.b.c.a(this);
        d.b.w.a.d.b.e("new assist obj:" + this + " config : " + r3);
        return;
    L5:
        r0 = r3;
        goto L6
    }

    public static a k(Context r2) {
        if (f15176g != null) goto L15;
        monitor-enter(a.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f15176g != null) goto L9;
        f15176g = new a(r2);     // Catch: Throwable -> L11
    L9:
        monitor-exit(a.class);     // Catch: Throwable -> L11
    L15:
        return f15176g;
    }

    @Override // d.b.w.a.a.c
    public float a() {
        return this.f15178b.d();
    }

    @Override // d.b.w.a.a.c
    public c.b b() {
        return this.f15180d.e();
    }

    @Override // d.b.w.a.a.c
    public int c() {
        return this.f15178b.h();
    }

    @Override // d.b.w.a.a.c
    public int d() {
        return this.f15178b.c();
    }

    @Override // d.b.w.a.a.c
    public c.a e() {
        c.a r0 = new c.a();
        r0.f15157a = i();
        r0.f15158b = m();
        r0.f15159c = d();
        r0.f15160d = j();
        r0.f15161e = c();
        r0.f15162f = a();
        r0.f15163g = l();
        return r0;
    }

    @Override // d.b.w.a.a.c
    public boolean f(float r1) {
        return this.f15181e.a(r1);
    }

    @Override // d.b.w.a.a.c
    public void g() {
        this.f15180d.h();
    }

    @Override // d.b.w.a.a.c
    public d.b.w.a.a.a getConfig() {
        return this.f15182f;
    }

    @Override // d.b.w.a.a.c
    public boolean h() {
        return this.f15181e.b();
    }

    public String i() {
        return d.b.w.a.d.a.d();
    }

    public int j() {
        return this.f15179c.b();
    }

    public List<List<Integer>> l() {
        return this.f15180d.d();
    }

    public boolean m() {
        return this.f15178b.f();
    }

    @Override // d.b.w.a.a.c
    public c start() {
        d.b.w.a.d.b.a("start, obj:" + this);
        this.f15178b.a();
        this.f15179c.a();
        this.f15180d.a();
        return this;
    }
}
