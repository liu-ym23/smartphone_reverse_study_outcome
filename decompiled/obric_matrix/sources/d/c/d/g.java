package d.c.d;

import d.c.c.d.i;
import d.c.c.d.l;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public class g<T> implements l<c<T>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<l<c<T>>> f15479a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f15480b;

    private class a extends d.c.d.a<T> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private ArrayList<c<T>> f15481g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private int f15482h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private int f15483i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private AtomicInteger f15484j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private Throwable f15485k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        final /* synthetic */ g f15486l;

        /* JADX INFO: renamed from: d.c.d.g$a$a, reason: collision with other inner class name */
        private class C0417a implements e<T> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private int f15487a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ a f15488b;

            public C0417a(a r1, int r2) {
                this.f15488b = r1;
                this.f15487a = r2;
            }

            @Override // d.c.d.e
            public void a(c<T> r1) {
            }

            @Override // d.c.d.e
            public void b(c<T> r2) {
                a.u(this.f15488b, this.f15487a, r2);
            }

            @Override // d.c.d.e
            public void c(c<T> r2) {
                if (r2.a() == false) goto L6;
                a.t(this.f15488b, this.f15487a, r2);
                return;
            L6:
                if (r2.b() == false) goto L10;
                a.u(this.f15488b, this.f15487a, r2);
                return;
            }

            @Override // d.c.d.e
            public void d(c<T> r2) {
                if (this.f15487a != 0) goto L6;
                this.f15488b.o(r2.getProgress());
                return;
            }
        }

        public a(g r1) {
            this.f15486l = r1;
            if (g.a(r1) == true) goto L6;
            w();
            return;
        }

        private void A() {
            if (this.f15484j.incrementAndGet() != this.f15483i) goto L8;
            Throwable r0 = this.f15485k;
            if (r0 == null) goto L9;
            m(r0);
            return;
        L9:
            return;
        }

        private void B(int r3, c<T> r4, boolean r5) {
            monitor-enter(this);
            int r0 = this.f15482h;     // Catch: Throwable -> L22
            if (r4 == y(r3)) goto L6;
        L20:
            monitor-exit(this);     // Catch: Throwable -> L22
            return;
        L6:
            if (r3 == this.f15482h) goto L20;
            if (z() == null) goto L15;
            if (r5 == true) goto L12;
        L14:
            r3 = r0;
        L16:
            monitor-exit(this);     // Catch: Throwable -> L22
        L17:
            if (r0 <= r3) goto L19;
            v(x(r0));
            r0 = r0 - 1;
            goto L17
        L19:
            return;
        L12:
            if (r3 >= this.f15482h) goto L14;
        L15:
            this.f15482h = r3;     // Catch: Throwable -> L22
        L22:
            th = move-exception;
            throw th;
        }

        private void C(int r2, c<T> r3) {
            v(E(r2, r3));
            if (r2 != 0) goto L5;
            this.f15485k = r3.c();
        L5:
            A();
        }

        private void D(int r2, c<T> r3) {
            B(r2, r3, r3.b());
            if (r3 == z()) goto L5;
        L11:
            A();
            return;
        L5:
            if (r2 == 0) goto L7;
        L9:
            boolean r4 = false;
        L10:
            q(null, r4);
            goto L11
        L7:
            if (r3.b() == false) goto L9;
            r4 = true;
            goto L10
        }

        private synchronized c<T> E(int r2, c<T> r3) {
            monitor-enter(this);
        L15:
            th = move-exception;
            throw th;
        L4:
            if (r3 != z()) goto L9;
            monitor-exit(this);
            return null;
        L9:
            if (r3 != y(r2)) goto L13;
            c<T> r4 = x(r2);     // Catch: Throwable -> L15
            monitor-exit(this);
            return r4;
        L13:
            monitor-exit(this);
            return r3;
        }

        static /* synthetic */ void t(a r0, int r1, c r2) {
            r0.D(r1, r2);
        }

        static /* synthetic */ void u(a r0, int r1, c r2) {
            r0.C(r1, r2);
        }

        private void v(c<T> r1) {
            if (r1 == null) goto L5;
            r1.close();
            return;
        }

        private void w() {
            if (this.f15484j == null) goto L5;
            return;
        L5:
            monitor-enter(this);
        L16:
            th = move-exception;
            throw th;
        L7:
            if (this.f15484j != null) goto L14;
            int r1 = 0;
            this.f15484j = new AtomicInteger(0);     // Catch: Throwable -> L16
            int r0 = g.b(this.f15486l).size();     // Catch: Throwable -> L16
            this.f15483i = r0;     // Catch: Throwable -> L16
            this.f15482h = r0;     // Catch: Throwable -> L16
            this.f15481g = new ArrayList(r0);     // Catch: Throwable -> L16
        L9:
            if (r1 >= r0) goto L14;
            c<T> r2 = (c) ((l) g.b(this.f15486l).get(r1)).get();     // Catch: Throwable -> L16
            this.f15481g.add(r2);     // Catch: Throwable -> L16
            r2.f(new C0417a(this, r1), d.c.c.b.b.a());     // Catch: Throwable -> L16
            if (r2.a() == true) goto L14;
            r1 = r1 + 1;     // Catch: Throwable -> L16
        L14:
            monitor-exit(this);     // Catch: Throwable -> L16
        }

        private synchronized c<T> x(int r3) {
            monitor-enter(this);
            ArrayList<c<T>> r0 = this.f15481g;     // Catch: Throwable -> L10
            c<T> r1 = null;
            if (r0 != null) goto L6;
        L8:
            monitor-exit(this);
            return r1;
        L6:
            if (r3 >= r0.size()) goto L8;
            r1 = this.f15481g.set(r3, null);     // Catch: Throwable -> L10
        L10:
            th = move-exception;
            throw th;
        }

        private synchronized c<T> y(int r2) {
            monitor-enter(this);
            ArrayList<c<T>> r0 = this.f15481g;     // Catch: Throwable -> L12
            if (r0 != null) goto L6;
        L9:
            c<T> r3 = null;
        L10:
            monitor-exit(this);
            return r3;
        L6:
            if (r2 >= r0.size()) goto L9;
            r3 = this.f15481g.get(r2);     // Catch: Throwable -> L12
        L12:
            th = move-exception;
            throw th;
        }

        private synchronized c<T> z() {
            monitor-enter(this);
            c<T> r0 = y(this.f15482h);     // Catch: Throwable -> L6
            monitor-exit(this);
            return r0;
        L6:
            th = move-exception;
            throw th;
        }

        @Override // d.c.d.a, d.c.d.c
        public synchronized boolean a() {
            monitor-enter(this);
        L14:
            th = move-exception;
            throw th;
        L4:
            if (g.a(this.f15486l) == false) goto L6;
            w();     // Catch: Throwable -> L14
        L6:
            c<T> r0 = z();     // Catch: Throwable -> L14
            if (r0 == null) goto L11;
            if (r0.a() == false) goto L11;
            boolean r1 = true;
        L12:
            monitor-exit(this);
            return r1;
        L11:
            r1 = false;
            goto L12
        }

        @Override // d.c.d.a, d.c.d.c
        public boolean close() {
            if (g.a(this.f15486l) == false) goto L5;
            w();
        L5:
            monitor-enter(this);
            int r1 = 0;
            if (super.close() == true) goto L10;
            monitor-exit(this);     // Catch: Throwable -> L18
            return false;
        L10:
            ArrayList<c<T>> r0 = this.f15481g;     // Catch: Throwable -> L18
            this.f15481g = null;     // Catch: Throwable -> L18
            monitor-exit(this);     // Catch: Throwable -> L18
            if (r0 != null) goto L14;
            return true;
        L14:
            if (r1 >= r0.size()) goto L23;
            v(r0.get(r1));
            r1 = r1 + 1;
            goto L14
        L23:
            return true;
        L18:
            th = move-exception;
            throw th;
        }

        @Override // d.c.d.a, d.c.d.c
        public synchronized T e() {
            monitor-enter(this);
        L13:
            th = move-exception;
            throw th;
        L4:
            if (g.a(this.f15486l) == false) goto L6;
            w();     // Catch: Throwable -> L13
        L6:
            c<T> r0 = z();     // Catch: Throwable -> L13
            if (r0 == null) goto L10;
            T r1 = r0.e();     // Catch: Throwable -> L13
        L11:
            monitor-exit(this);
            return r1;
        L10:
            r1 = null;
            goto L11
        }
    }

    private g(List<l<c<T>>> r3, boolean r4) {
        i.c(!r3.isEmpty(), "List of suppliers is empty!");
        this.f15479a = r3;
        this.f15480b = r4;
    }

    static /* synthetic */ boolean a(g r0) {
        return r0.f15480b;
    }

    static /* synthetic */ List b(g r0) {
        return r0.f15479a;
    }

    public static <T> g<T> c(List<l<c<T>>> r1, boolean r2) {
        return new g(r1, r2);
    }

    public c<T> d() {
        return new a(this);
    }

    public boolean equals(Object r2) {
        if (r2 != this) goto L6;
        return true;
    L6:
        if ((r2 instanceof g) == true) goto L10;
        return false;
    L10:
        return d.c.c.d.h.a(this.f15479a, ((g) r2).f15479a);
    }

    @Override // d.c.c.d.l
    public /* bridge */ /* synthetic */ Object get() {
        return d();
    }

    public int hashCode() {
        return this.f15479a.hashCode();
    }

    public String toString() {
        d.c.c.d.h.b r0 = d.c.c.d.h.d(this);
        r0.b("list", this.f15479a);
        return r0.toString();
    }
}
