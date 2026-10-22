package f.a.j.c.a;

import java.util.concurrent.atomic.AtomicReference;

/* JADX WARN: Unexpected interfaces in signature: [java.lang.Object] */
/* JADX INFO: loaded from: classes2.dex */
public final class b<T> extends AtomicReference<f.a.g.b> implements f.a.c<T>, f.a.g.b {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final f.a.i.d<? super T> f17061f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final f.a.i.d<? super Throwable> f17062g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final f.a.i.a f17063h;

    public b(f.a.i.d<? super T> r1, f.a.i.d<? super Throwable> r2, f.a.i.a r3) {
        this.f17061f = r1;
        this.f17062g = r2;
        this.f17063h = r3;
    }

    @Override // f.a.c
    public void a() {
        lazySet(f.a.j.a.c.f17051f);
        this.f17063h.run();     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        f.a.h.b.a(th);
        f.a.k.a.m(th);
    }

    @Override // f.a.c
    public void b(T r2) {
        lazySet(f.a.j.a.c.f17051f);
        this.f17061f.accept(r2);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        f.a.h.b.a(th);
        f.a.k.a.m(th);
    }

    @Override // f.a.c
    public void c(f.a.g.b r1) {
        f.a.j.a.c.k(this, r1);
    }

    @Override // f.a.g.b
    public void dispose() {
        f.a.j.a.c.a(this);
    }

    @Override // f.a.c
    public void onError(Throwable r4) {
        lazySet(f.a.j.a.c.f17051f);
        this.f17062g.accept(r4);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        f.a.h.b.a(th);
        f.a.k.a.m(new f.a.h.a(new Throwable[]{r4, th}));
    }
}
