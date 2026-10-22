package f.a.j.c.a;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
public final class h<T> extends f.a.j.c.a.a<T, T> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final f.a.f f17077g;

    static final class a<T> extends AtomicReference<f.a.g.b> implements f.a.c<T>, f.a.g.b {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final f.a.j.a.f f17078f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final f.a.c<? super T> f17079g;

        a(f.a.c<? super T> r1) {
            this.f17079g = r1;
            this.f17078f = new f.a.j.a.f();
        }

        @Override // f.a.c
        public void a() {
            this.f17079g.a();
        }

        @Override // f.a.c
        public void b(T r1) {
            this.f17079g.b(r1);
        }

        @Override // f.a.c
        public void c(f.a.g.b r1) {
            f.a.j.a.c.k(this, r1);
        }

        @Override // f.a.g.b
        public void dispose() {
            f.a.j.a.c.a(this);
            this.f17078f.dispose();
        }

        @Override // f.a.c
        public void onError(Throwable r1) {
            this.f17079g.onError(r1);
        }
    }

    static final class b<T> implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final f.a.c<? super T> f17080f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final f.a.e<T> f17081g;

        b(f.a.c<? super T> r1, f.a.e<T> r2) {
            this.f17080f = r1;
            this.f17081g = r2;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f17081g.a(this.f17080f);
        }
    }

    public h(f.a.e<T> r1, f.a.f r2) {
        super(r1);
        this.f17077g = r2;
    }

    @Override // f.a.a
    protected void i(f.a.c<? super T> r4) {
        a r0 = new a(r4);
        r4.c(r0);
        r0.f17078f.a(this.f17077g.b(new b(r0, this.f17060f)));
    }
}
