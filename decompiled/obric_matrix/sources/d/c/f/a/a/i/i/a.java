package d.c.f.a.a.i.i;

import android.graphics.drawable.Animatable;
import d.c.f.a.a.i.g;
import d.c.f.a.a.i.h;
import d.c.i.l.f;

/* JADX INFO: loaded from: classes.dex */
public class a extends d.c.f.c.c<f> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.facebook.common.time.b f15536b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final h f15537c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final g f15538d;

    public a(com.facebook.common.time.b r1, h r2, g r3) {
        this.f15536b = r1;
        this.f15537c = r2;
        this.f15538d = r3;
    }

    private void m(long r3) {
        this.f15537c.v(false);
        this.f15537c.p(r3);
        this.f15538d.p(this.f15537c, 2);
    }

    @Override // d.c.f.c.c, d.c.f.c.d
    public /* bridge */ /* synthetic */ void a(String r1, Object r2) {
        l(r1, (f) r2);
    }

    @Override // d.c.f.c.c, d.c.f.c.d
    public /* bridge */ /* synthetic */ void b(String r1, Object r2, Animatable r3) {
        k(r1, (f) r2, r3);
    }

    @Override // d.c.f.c.c, d.c.f.c.d
    public void c(String r4, Throwable r5) {
        long r0 = this.f15536b.now();
        this.f15537c.e(r0);
        this.f15537c.g(r4);
        this.f15538d.q(this.f15537c, 5);
        m(r0);
    }

    @Override // d.c.f.c.c, d.c.f.c.d
    public void d(String r5) {
        super.d(r5);
        long r0 = this.f15536b.now();
        int r2 = this.f15537c.a();
        if (r2 != 3) goto L5;
    L7:
        m(r0);
        return;
    L5:
        if (r2 == 5) goto L7;
        this.f15537c.d(r0);
        this.f15537c.g(r5);
        this.f15538d.q(this.f15537c, 4);
        goto L7
    }

    @Override // d.c.f.c.c, d.c.f.c.d
    public void e(String r4, Object r5) {
        long r0 = this.f15536b.now();
        this.f15537c.i(r0);
        this.f15537c.g(r4);
        this.f15537c.c(r5);
        this.f15538d.q(this.f15537c, 0);
        n(r0);
    }

    public void k(String r3, f r4, Animatable r5) {
        long r0 = this.f15536b.now();
        this.f15537c.f(r0);
        this.f15537c.n(r0);
        this.f15537c.g(r3);
        this.f15537c.j(r4);
        this.f15538d.q(this.f15537c, 3);
    }

    public void l(String r4, f r5) {
        long r0 = this.f15536b.now();
        this.f15537c.h(r0);
        this.f15537c.g(r4);
        this.f15537c.j(r5);
        this.f15538d.q(this.f15537c, 2);
    }

    public void n(long r3) {
        this.f15537c.v(true);
        this.f15537c.u(r3);
        this.f15538d.p(this.f15537c, 1);
    }
}
