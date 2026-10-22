package f.a.j.c.a;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
public final class e<T, R> extends f.a.j.c.a.a<T, R> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final f.a.i.e<? super T, ? extends f.a.e<? extends R>> f17067g;

    static final class a<T, R> extends AtomicReference<f.a.g.b> implements f.a.c<T>, f.a.g.b {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final f.a.c<? super R> f17068f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final f.a.i.e<? super T, ? extends f.a.e<? extends R>> f17069g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        f.a.g.b f17070h;

        /* JADX INFO: renamed from: f.a.j.c.a.e$a$a, reason: collision with other inner class name */
        final class C0452a implements f.a.c<R> {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ a f17071f;

            C0452a(a r1) {
                this.f17071f = r1;
            }

            @Override // f.a.c
            public void a() {
                this.f17071f.f17068f.a();
            }

            @Override // f.a.c
            public void b(R r1) {
                this.f17071f.f17068f.b(r1);
            }

            @Override // f.a.c
            public void c(f.a.g.b r1) {
                f.a.j.a.c.k(this.f17071f, r1);
            }

            @Override // f.a.c
            public void onError(Throwable r1) {
                this.f17071f.f17068f.onError(r1);
            }
        }

        a(f.a.c<? super R> r1, f.a.i.e<? super T, ? extends f.a.e<? extends R>> r2) {
            this.f17068f = r1;
            this.f17069g = r2;
        }

        @Override // f.a.c
        public void a() {
            this.f17068f.a();
        }

        @Override // f.a.c
        public void b(T r2) {
            f.a.e<? extends R> r3 = this.f17069g.apply(r2);     // Catch: Exception -> L7
            f.a.j.b.b.c(r3, "The mapper returned a null MaybeSource");     // Catch: Exception -> L7
            f.a.e<? extends R> r4 = r3;     // Catch: Exception -> L7
            if (d() == true) goto L12;
            r4.a(new C0452a(this));
            return;
        L12:
            return;
        L7:
            e = move-exception;
            f.a.h.b.a(e);
            this.f17068f.onError(e);
        }

        @Override // f.a.c
        public void c(f.a.g.b r2) {
            if (f.a.j.a.c.l(this.f17070h, r2) == false) goto L6;
            this.f17070h = r2;
            this.f17068f.c(this);
            return;
        }

        public boolean d() {
            return f.a.j.a.c.b(get());
        }

        @Override // f.a.g.b
        public void dispose() {
            f.a.j.a.c.a(this);
            this.f17070h.dispose();
        }

        @Override // f.a.c
        public void onError(Throwable r1) {
            this.f17068f.onError(r1);
        }
    }

    public e(f.a.e<T> r1, f.a.i.e<? super T, ? extends f.a.e<? extends R>> r2) {
        super(r1);
        this.f17067g = r2;
    }

    @Override // f.a.a
    protected void i(f.a.c<? super R> r3) {
        this.f17060f.a(new a(r3, this.f17067g));
    }
}
