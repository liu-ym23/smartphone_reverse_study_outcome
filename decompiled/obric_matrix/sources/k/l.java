package k;

import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public class l extends a0 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private a0 f18276e;

    public l(a0 r2) {
        kotlin.n0.d.o.g(r2, "delegate");
        this.f18276e = r2;
    }

    @Override // k.a0
    public a0 a() {
        return this.f18276e.a();
    }

    @Override // k.a0
    public a0 b() {
        return this.f18276e.b();
    }

    @Override // k.a0
    public long c() {
        return this.f18276e.c();
    }

    @Override // k.a0
    public a0 d(long r1) {
        return this.f18276e.d(r1);
    }

    @Override // k.a0
    public boolean e() {
        return this.f18276e.e();
    }

    @Override // k.a0
    public void f() {
        this.f18276e.f();
    }

    @Override // k.a0
    public a0 g(long r2, TimeUnit r4) {
        kotlin.n0.d.o.g(r4, "unit");
        return this.f18276e.g(r2, r4);
    }

    @Override // k.a0
    public long h() {
        return this.f18276e.h();
    }

    public final a0 i() {
        return this.f18276e;
    }

    public final l j(a0 r2) {
        kotlin.n0.d.o.g(r2, "delegate");
        this.f18276e = r2;
        return this;
    }
}
