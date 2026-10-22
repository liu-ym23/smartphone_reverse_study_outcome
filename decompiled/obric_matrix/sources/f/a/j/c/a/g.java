package f.a.j.c.a;

/* JADX INFO: loaded from: classes2.dex */
public final class g<T, R> extends f.a.j.c.a.a<T, R> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final f.a.i.e<? super T, ? extends R> f17073g;

    static final class a<T, R> implements f.a.c<T>, f.a.g.b {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final f.a.c<? super R> f17074f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final f.a.i.e<? super T, ? extends R> f17075g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        f.a.g.b f17076h;

        a(f.a.c<? super R> r1, f.a.i.e<? super T, ? extends R> r2) {
            this.f17074f = r1;
            this.f17075g = r2;
        }

        @Override // f.a.c
        public void a() {
            this.f17074f.a();
        }

        @Override // f.a.c
        public void b(T r2) {
            R r3 = this.f17075g.apply(r2);     // Catch: Throwable -> L5
            f.a.j.b.b.c(r3, "The mapper returned a null item");     // Catch: Throwable -> L5
            this.f17074f.b(r3);
            return;
        L5:
            th = move-exception;
            f.a.h.b.a(th);
            this.f17074f.onError(th);
        }

        @Override // f.a.c
        public void c(f.a.g.b r2) {
            if (f.a.j.a.c.l(this.f17076h, r2) == false) goto L6;
            this.f17076h = r2;
            this.f17074f.c(this);
            return;
        }

        @Override // f.a.g.b
        public void dispose() {
            f.a.g.b r0 = this.f17076h;
            this.f17076h = f.a.j.a.c.f17051f;
            r0.dispose();
        }

        @Override // f.a.c
        public void onError(Throwable r1) {
            this.f17074f.onError(r1);
        }
    }

    public g(f.a.e<T> r1, f.a.i.e<? super T, ? extends R> r2) {
        super(r1);
        this.f17073g = r2;
    }

    @Override // f.a.a
    protected void i(f.a.c<? super R> r3) {
        this.f17060f.a(new a(r3, this.f17073g));
    }
}
