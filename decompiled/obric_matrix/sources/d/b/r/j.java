package d.b.r;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
final class j extends c.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Executor f14396a;

    class a implements c<Object, d.b.r.b<?>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Type f14397a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Executor f14398b;

        a(j r1, Type r2, Executor r3) {
            this.f14397a = r2;
            this.f14398b = r3;
        }

        @Override // d.b.r.c
        public Type a() {
            return this.f14397a;
        }

        @Override // d.b.r.c
        public /* bridge */ /* synthetic */ d.b.r.b<?> b(d.b.r.b<Object> r1) {
            return c(r1);
        }

        public d.b.r.b<Object> c(d.b.r.b<Object> r2) {
            Executor r1 = this.f14398b;
            if (r1 != null) goto L6;
            return r2;
        L6:
            return new b(r1, r2);
        }
    }

    static final class b<T> implements d.b.r.b<T>, n {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final Executor f14399f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final d.b.r.b<T> f14400g;

        class a implements k<T> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ e f14401a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ b f14402b;

            /* JADX INFO: renamed from: d.b.r.j$b$a$a, reason: collision with other inner class name */
            class RunnableC0389a implements Runnable {

                /* JADX INFO: renamed from: f, reason: collision with root package name */
                final /* synthetic */ d0 f14403f;

                /* JADX INFO: renamed from: g, reason: collision with root package name */
                final /* synthetic */ a f14404g;

                RunnableC0389a(a r1, d0 r2) {
                    this.f14404g = r1;
                    this.f14403f = r2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    if (this.f14404g.f14402b.f14400g.g() == false) goto L5;
                    a r3 = this.f14404g;
                    r3.f14401a.b(r3.f14402b, new IOException("Canceled"));
                    return;
                L5:
                    a r0 = this.f14404g;
                    r0.f14401a.a(r0.f14402b, this.f14403f);
                }
            }

            /* JADX INFO: renamed from: d.b.r.j$b$a$b, reason: collision with other inner class name */
            class RunnableC0390b implements Runnable {

                /* JADX INFO: renamed from: f, reason: collision with root package name */
                final /* synthetic */ Throwable f14405f;

                /* JADX INFO: renamed from: g, reason: collision with root package name */
                final /* synthetic */ a f14406g;

                RunnableC0390b(a r1, Throwable r2) {
                    this.f14406g = r1;
                    this.f14405f = r2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    a r0 = this.f14406g;
                    r0.f14401a.b(r0.f14402b, this.f14405f);
                }
            }

            a(b r1, e r2) {
                this.f14402b = r1;
                this.f14401a = r2;
            }

            @Override // d.b.r.e
            public void a(d.b.r.b<T> r2, d0<T> r3) {
                this.f14402b.f14399f.execute(new RunnableC0389a(this, r3));
            }

            @Override // d.b.r.e
            public void b(d.b.r.b<T> r2, Throwable r3) {
                this.f14402b.f14399f.execute(new RunnableC0390b(this, r3));
            }

            @Override // d.b.r.k
            public void c(t r2) {
                e r1 = this.f14401a;
                if ((r1 instanceof k) == false) goto L6;
                ((k) r1).c(r2);
                return;
            }

            @Override // d.b.r.k
            public void d(d.b.r.b<T> r2, d0<T> r3) {
                e r1 = this.f14401a;
                if ((r1 instanceof k) == false) goto L6;
                ((k) r1).d(r2, r3);
                return;
            }
        }

        b(Executor r1, d.b.r.b<T> r2) {
            this.f14399f = r1;
            this.f14400g = r2;
        }

        @Override // d.b.r.b
        public d.b.r.b<T> A() {
            return new b(this.f14399f, this.f14400g.A());
        }

        @Override // d.b.r.b
        public d.b.r.h0.c b() {
            return this.f14400g.b();
        }

        @Override // d.b.r.n
        public void c() {
            d.b.r.b<T> r1 = this.f14400g;
            if ((r1 instanceof n) == false) goto L6;
            ((n) r1).c();
            return;
        }

        @Override // d.b.r.b
        public void cancel() {
            this.f14400g.cancel();
        }

        public /* bridge */ /* synthetic */ Object clone() {
            return A();
        }

        @Override // d.b.r.b
        public d0 execute() {
            return this.f14400g.execute();
        }

        @Override // d.b.r.b
        public boolean g() {
            return this.f14400g.g();
        }

        @Override // d.b.r.b
        public void l(e<T> r3) {
            f0.a(r3, "callback == null");
            this.f14400g.l(new a(this, r3));
        }
    }

    j(Executor r1) {
        this.f14396a = r1;
    }

    @Override // d.b.r.c.a
    public c<?, ?> a(Type r3, Annotation[] r4, v r5) {
        Executor r1 = null;
        if (c.a.b(r3) == d.b.r.b.class) goto L6;
        return null;
    L6:
        if ((r3 instanceof ParameterizedType) == false) goto L14;
        Type r6 = f0.f(r3);
        if (f0.n(r4, a0.class) == true) goto L12;
        r1 = this.f14396a;
    L12:
        return new a(this, r6, r1);
    L14:
        throw new IllegalArgumentException("Call return type must be parameterized as Call<Foo> or Call<? extends Foo>");
    }
}
