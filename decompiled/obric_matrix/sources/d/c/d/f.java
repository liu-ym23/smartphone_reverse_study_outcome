package d.c.d;

import d.c.c.d.i;
import d.c.c.d.l;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class f<T> implements l<c<T>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<l<c<T>>> f15473a;

    static /* synthetic */ class a {
    }

    private class b extends d.c.d.a<T> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private int f15474g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private c<T> f15475h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private c<T> f15476i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final /* synthetic */ f f15477j;

        private class a implements e<T> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ b f15478a;

            private a(b r1) {
                this.f15478a = r1;
            }

            /* synthetic */ a(b r1, a r2) {
                this(r1);
            }

            @Override // d.c.d.e
            public void a(c<T> r1) {
            }

            @Override // d.c.d.e
            public void b(c<T> r1) {
                b.t(this.f15478a, r1);
            }

            @Override // d.c.d.e
            public void c(c<T> r2) {
                if (r2.a() == false) goto L6;
                b.u(this.f15478a, r2);
                return;
            L6:
                if (r2.b() == false) goto L10;
                b.t(this.f15478a, r2);
                return;
            }

            @Override // d.c.d.e
            public void d(c<T> r2) {
                float r0 = this.f15478a.getProgress();
                this.f15478a.o(Math.max(r0, r2.getProgress()));
            }
        }

        public b(f r2) {
            this.f15477j = r2;
            this.f15474g = 0;
            this.f15475h = null;
            this.f15476i = null;
            if (D() == true) goto L6;
            m(new RuntimeException("No data source supplier or supplier returned null."));
            return;
        }

        private void A(c<T> r2) {
            if (v(r2) == true) goto L6;
            return;
        L6:
            if (r2 == x()) goto L9;
            w(r2);
        L9:
            if ((r2.c() instanceof OutOfMemoryError) == false) goto L12;
            m(r2.c());
        L12:
            if (D() == true) goto L15;
            m(r2.c());
            return;
        }

        private void B(c<T> r2) {
            z(r2, r2.b());
            if (r2 != x()) goto L6;
            q(null, r2.b());
            return;
        }

        private synchronized boolean C(c<T> r2) {
            monitor-enter(this);
        L10:
            th = move-exception;
            throw th;
        L4:
            if (i() == false) goto L8;
            boolean r3 = false;
        L6:
            monitor-exit(this);
            return r3;
        L8:
            this.f15475h = r2;     // Catch: Throwable -> L10
            r3 = true;
            goto L6
        }

        private boolean D() {
            l<c<T>> r0 = y();
            a r1 = null;
            if (r0 == null) goto L5;
            c<T> r2 = r0.get();
        L7:
            if (C(r2) == false) goto L11;
            if (r2 == null) goto L11;
            r2.f(new a(this, r1), d.c.c.b.b.a());
            return true;
        L11:
            w(r2);
            return false;
        L5:
            r2 = null;
            goto L7
        }

        static /* synthetic */ void t(b r0, c r1) {
            r0.A(r1);
        }

        static /* synthetic */ void u(b r0, c r1) {
            r0.B(r1);
        }

        private synchronized boolean v(c<T> r2) {
            monitor-enter(this);
        L13:
            th = move-exception;
            throw th;
        L4:
            if (i() == false) goto L6;
        L12:
            boolean r3 = false;
        L10:
            monitor-exit(this);
            return r3;
        L6:
            if (r2 != this.f15475h) goto L12;
            this.f15475h = null;     // Catch: Throwable -> L13
            r3 = true;
            goto L10
        }

        private void w(c<T> r1) {
            if (r1 == null) goto L5;
            r1.close();
            return;
        }

        private synchronized c<T> x() {
            monitor-enter(this);
            c<T> r0 = this.f15476i;     // Catch: Throwable -> L6
            monitor-exit(this);
            return r0;
        L6:
            th = move-exception;
            throw th;
        }

        private synchronized l<c<T>> y() {
            monitor-enter(this);
        L13:
            th = move-exception;
            throw th;
        L4:
            if (i() == true) goto L11;
            if (this.f15474g >= f.a(this.f15477j).size()) goto L11;
            List r0 = f.a(this.f15477j);     // Catch: Throwable -> L13
            int r1 = this.f15474g;     // Catch: Throwable -> L13
            this.f15474g = r1 + 1;     // Catch: Throwable -> L13
            l<c<T>> r2 = (l) r0.get(r1);     // Catch: Throwable -> L13
            monitor-exit(this);
            return r2;
        L11:
            monitor-exit(this);
            return null;
        }

        private void z(c<T> r2, boolean r3) {
            monitor-enter(this);
        L18:
            th = move-exception;
            throw th;
        L4:
            if (r2 != this.f15475h) goto L16;
            c<T> r0 = this.f15476i;     // Catch: Throwable -> L18
            if (r2 == r0) goto L16;
            if (r0 == null) goto L12;
            if (r3 == true) goto L12;
            r0 = null;
        L13:
            monitor-exit(this);     // Catch: Throwable -> L18
            w(r0);
            return;
        L12:
            this.f15476i = r2;     // Catch: Throwable -> L18
        L16:
            monitor-exit(this);     // Catch: Throwable -> L18
        }

        @Override // d.c.d.a, d.c.d.c
        public synchronized boolean a() {
            monitor-enter(this);
            c<T> r0 = x();     // Catch: Throwable -> L11
            if (r0 == null) goto L8;
            if (r0.a() == false) goto L8;
            boolean r1 = true;
        L9:
            monitor-exit(this);
            return r1;
        L8:
            r1 = false;
        L11:
            th = move-exception;
            throw th;
        }

        @Override // d.c.d.a, d.c.d.c
        public boolean close() {
            monitor-enter(this);
        L12:
            th = move-exception;
            throw th;
        L4:
            if (super.close() == false) goto L6;
            c<T> r0 = this.f15475h;     // Catch: Throwable -> L12
            this.f15475h = null;     // Catch: Throwable -> L12
            c<T> r2 = this.f15476i;     // Catch: Throwable -> L12
            this.f15476i = null;     // Catch: Throwable -> L12
            monitor-exit(this);     // Catch: Throwable -> L12
            w(r2);
            w(r0);
            return true;
        L6:
            monitor-exit(this);     // Catch: Throwable -> L12
            return false;
        }

        @Override // d.c.d.a, d.c.d.c
        public synchronized T e() {
            monitor-enter(this);
            c<T> r0 = x();     // Catch: Throwable -> L10
            if (r0 == null) goto L7;
            T r1 = r0.e();     // Catch: Throwable -> L10
        L8:
            monitor-exit(this);
            return r1;
        L7:
            r1 = null;
        L10:
            th = move-exception;
            throw th;
        }
    }

    private f(List<l<c<T>>> r3) {
        i.c(!r3.isEmpty(), "List of suppliers is empty!");
        this.f15473a = r3;
    }

    static /* synthetic */ List a(f r0) {
        return r0.f15473a;
    }

    public static <T> f<T> b(List<l<c<T>>> r1) {
        return new f(r1);
    }

    public c<T> c() {
        return new b(this);
    }

    public boolean equals(Object r2) {
        if (r2 != this) goto L6;
        return true;
    L6:
        if ((r2 instanceof f) == true) goto L10;
        return false;
    L10:
        return d.c.c.d.h.a(this.f15473a, ((f) r2).f15473a);
    }

    @Override // d.c.c.d.l
    public /* bridge */ /* synthetic */ Object get() {
        return c();
    }

    public int hashCode() {
        return this.f15473a.hashCode();
    }

    public String toString() {
        d.c.c.d.h.b r0 = d.c.c.d.h.d(this);
        r0.b("list", this.f15473a);
        return r0.toString();
    }
}
