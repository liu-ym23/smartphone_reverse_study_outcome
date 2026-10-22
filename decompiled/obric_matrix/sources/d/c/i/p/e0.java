package d.c.i.p;

import android.util.Pair;
import java.io.Closeable;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: loaded from: classes2.dex */
public abstract class e0<K, T extends Closeable> implements k0<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Map<K, e0<K, T>.b> f16244a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final k0<T> f16245b;

    static /* synthetic */ class a {
    }

    /* JADX WARN: Field signature parse error: a
    jadx.core.utils.exceptions.JadxRuntimeException: Can't parse type: TK at position 1 ('K'), unexpected: T
    	at jadx.core.dex.nodes.parser.SignatureParser.consumeType(SignatureParser.java:169)
    	at jadx.core.dex.visitors.SignatureProcessor.parseFieldSignature(SignatureProcessor.java:161)
    	at jadx.core.dex.visitors.SignatureProcessor.visit(SignatureProcessor.java:37)
     */
    class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Object f16246a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final CopyOnWriteArraySet<Pair<k<T>, l0>> f16247b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private T f16248c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private float f16249d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f16250e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private d f16251f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private e0<K, T>.b.C0431b f16252g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ e0 f16253h;

        class a extends e {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ Pair f16254a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ b f16255b;

            a(b r1, Pair r2) {
                this.f16255b = r1;
                this.f16254a = r2;
            }

            @Override // d.c.i.p.m0
            public void a() {
                b r0 = this.f16255b;
                monitor-enter(r0);
                boolean r1 = b.b(this.f16255b).remove(this.f16254a);     // Catch: Throwable -> L19
                List r2 = null;
                if (r1 == true) goto L7;
                d r3 = null;
                List r4 = null;
            L11:
                List r5 = r4;
            L12:
                monitor-exit(r0);     // Catch: Throwable -> L19
                d.k(r2);
                d.l(r4);
                d.j(r5);
                if (r3 == null) goto L16;
                r3.m();
            L16:
                if (r1 == false) goto L24;
                ((k) this.f16254a.first).b();
                return;
            L24:
                return;
            L7:
                if (b.b(this.f16255b).isEmpty() == false) goto L9;
                r3 = b.c(this.f16255b);     // Catch: Throwable -> L19
                r4 = null;
                goto L11
            L9:
                List r6 = b.d(this.f16255b);     // Catch: Throwable -> L19
                r4 = b.e(this.f16255b);     // Catch: Throwable -> L19
                r5 = b.f(this.f16255b);     // Catch: Throwable -> L19
                r3 = null;
                r2 = r6;
            L19:
                th = move-exception;
                throw th;
            }

            @Override // d.c.i.p.e, d.c.i.p.m0
            public void b() {
                d.j(b.f(this.f16255b));
            }

            @Override // d.c.i.p.e, d.c.i.p.m0
            public void c() {
                d.l(b.e(this.f16255b));
            }

            @Override // d.c.i.p.e, d.c.i.p.m0
            public void d() {
                d.k(b.d(this.f16255b));
            }
        }

        /* JADX INFO: renamed from: d.c.i.p.e0$b$b, reason: collision with other inner class name */
        private class C0431b extends d.c.i.p.b<T> {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ b f16256b;

            private C0431b(b r1) {
                this.f16256b = r1;
            }

            /* synthetic */ C0431b(b r1, a r2) {
                this(r1);
            }

            @Override // d.c.i.p.b
            protected void g() {
            L10:
                th = move-exception;
                if (d.c.i.r.b.d() == false) goto L14;
                d.c.i.r.b.b();
            L14:
                throw th;
            L3:
                if (d.c.i.r.b.d() == false) goto L5;
                d.c.i.r.b.a("MultiplexProducer#onCancellation");     // Catch: Throwable -> L10
            L5:
                this.f16256b.m(this);     // Catch: Throwable -> L10
                if (d.c.i.r.b.d() == false) goto L17;
                d.c.i.r.b.b();
                return;
            }

            @Override // d.c.i.p.b
            protected void h(Throwable r2) {
            L10:
                th = move-exception;
                if (d.c.i.r.b.d() == false) goto L14;
                d.c.i.r.b.b();
            L14:
                throw th;
            L3:
                if (d.c.i.r.b.d() == false) goto L5;
                d.c.i.r.b.a("MultiplexProducer#onFailure");     // Catch: Throwable -> L10
            L5:
                this.f16256b.n(this, r2);     // Catch: Throwable -> L10
                if (d.c.i.r.b.d() == false) goto L17;
                d.c.i.r.b.b();
                return;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // d.c.i.p.b
            protected /* bridge */ /* synthetic */ void i(Object r1, int r2) {
                p((Closeable) r1, r2);
            }

            @Override // d.c.i.p.b
            protected void j(float r2) {
            L10:
                th = move-exception;
                if (d.c.i.r.b.d() == false) goto L14;
                d.c.i.r.b.b();
            L14:
                throw th;
            L3:
                if (d.c.i.r.b.d() == false) goto L5;
                d.c.i.r.b.a("MultiplexProducer#onProgressUpdate");     // Catch: Throwable -> L10
            L5:
                this.f16256b.p(this, r2);     // Catch: Throwable -> L10
                if (d.c.i.r.b.d() == false) goto L17;
                d.c.i.r.b.b();
                return;
            }

            protected void p(T r2, int r3) {
            L10:
                th = move-exception;
                if (d.c.i.r.b.d() == false) goto L14;
                d.c.i.r.b.b();
            L14:
                throw th;
            L3:
                if (d.c.i.r.b.d() == false) goto L5;
                d.c.i.r.b.a("MultiplexProducer#onNewResult");     // Catch: Throwable -> L10
            L5:
                this.f16256b.o(this, r2, r3);     // Catch: Throwable -> L10
                if (d.c.i.r.b.d() == false) goto L17;
                d.c.i.r.b.b();
                return;
            }
        }

        public b(e0 r1, K r2) {
            this.f16253h = r1;
            this.f16247b = d.c.c.d.k.a();
            this.f16246a = r2;
        }

        static /* synthetic */ void a(b r0) {
            r0.q();
        }

        static /* synthetic */ CopyOnWriteArraySet b(b r0) {
            return r0.f16247b;
        }

        static /* synthetic */ d c(b r0) {
            return r0.f16251f;
        }

        static /* synthetic */ List d(b r0) {
            return r0.s();
        }

        static /* synthetic */ List e(b r0) {
            return r0.t();
        }

        static /* synthetic */ List f(b r0) {
            return r0.r();
        }

        private void g(Pair<k<T>, l0> r2, l0 r3) {
            r3.d(new a(this, r2));
        }

        private void i(Closeable r1) {
            if (r1 != null) goto L9;
            return;
        L9:
            r1.close();     // Catch: IOException -> L5
            return;
        L5:
            e = move-exception;
            throw new RuntimeException(e);
        }

        private synchronized boolean j() {
            monitor-enter(this);
            Iterator<Pair<k<T>, l0>> r0 = this.f16247b.iterator();     // Catch: Throwable -> L12
        L5:
            if (r0.hasNext() == false) goto L11;
            if (((l0) r0.next().second).g() == false) goto L5;
            boolean r1 = true;
        L9:
            monitor-exit(this);
            return r1;
        L11:
            r1 = false;
        L12:
            th = move-exception;
            throw th;
        }

        private synchronized boolean k() {
            monitor-enter(this);
            Iterator<Pair<k<T>, l0>> r0 = this.f16247b.iterator();     // Catch: Throwable -> L12
        L5:
            if (r0.hasNext() == false) goto L11;
            if (((l0) r0.next().second).e() == true) goto L5;
            boolean r1 = false;
        L9:
            monitor-exit(this);
            return r1;
        L11:
            r1 = true;
        L12:
            th = move-exception;
            throw th;
        }

        private synchronized d.c.i.f.e l() {
            monitor-enter(this);
            d.c.i.f.e r0 = d.c.i.f.e.f16015f;     // Catch: Throwable -> L10
            Iterator<Pair<k<T>, l0>> r1 = this.f16247b.iterator();     // Catch: Throwable -> L10
        L5:
            if (r1.hasNext() == false) goto L8;
            r0 = d.c.i.f.e.a(r0, ((l0) r1.next().second).b());     // Catch: Throwable -> L10
            goto L5
        L8:
            monitor-exit(this);
            return r0;
        L10:
            th = move-exception;
            throw th;
        }

        private void q() {
            monitor-enter(this);
            boolean r1 = true;
            if (this.f16251f != null) goto L6;
            boolean r0 = true;
        L7:
            d.c.c.d.i.b(r0);     // Catch: Throwable -> L20
            if (this.f16252g == null) goto L11;
            r1 = false;
        L11:
            d.c.c.d.i.b(r1);     // Catch: Throwable -> L20
            if (this.f16247b.isEmpty() == false) goto L16;
            e0.d(this.f16253h, this.f16246a, this);     // Catch: Throwable -> L20
            monitor-exit(this);     // Catch: Throwable -> L20
            return;
        L16:
            l0 r2 = (l0) this.f16247b.iterator().next().second;     // Catch: Throwable -> L20
            d r10 = new d(r2.c(), r2.getId(), r2.f(), r2.a(), r2.h(), k(), j(), l());     // Catch: Throwable -> L20
            this.f16251f = r10;     // Catch: Throwable -> L20
            e0<K, T>.b.C0431b r3 = new C0431b(this, null);     // Catch: Throwable -> L20
            this.f16252g = r3;     // Catch: Throwable -> L20
            monitor-exit(this);     // Catch: Throwable -> L20
            e0.e(this.f16253h).b(r3, r10);
            return;
        L6:
            r0 = false;
        L20:
            th = move-exception;
            throw th;
        }

        private synchronized List<m0> r() {
            monitor-enter(this);
            d r0 = this.f16251f;     // Catch: Throwable -> L11
            if (r0 == null) goto L6;
            List<m0> r1 = r0.o(j());     // Catch: Throwable -> L11
            monitor-exit(this);
            return r1;
        L6:
            monitor-exit(this);
            return null;
        L11:
            th = move-exception;
            throw th;
        }

        private synchronized List<m0> s() {
            monitor-enter(this);
            d r0 = this.f16251f;     // Catch: Throwable -> L11
            if (r0 == null) goto L6;
            List<m0> r1 = r0.p(k());     // Catch: Throwable -> L11
            monitor-exit(this);
            return r1;
        L6:
            monitor-exit(this);
            return null;
        L11:
            th = move-exception;
            throw th;
        }

        private synchronized List<m0> t() {
            monitor-enter(this);
            d r0 = this.f16251f;     // Catch: Throwable -> L11
            if (r0 == null) goto L6;
            List<m0> r1 = r0.q(l());     // Catch: Throwable -> L11
            monitor-exit(this);
            return r1;
        L6:
            monitor-exit(this);
            return null;
        L11:
            th = move-exception;
            throw th;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public boolean h(k<T> r8, l0 r9) {
            Pair<k<T>, l0> r0 = Pair.create(r8, r9);
            monitor-enter(this);
        L34:
            th = move-exception;
            throw th;
        L5:
            if (e0.c(this.f16253h, this.f16246a) != this) goto L7;
            this.f16247b.add(r0);     // Catch: Throwable -> L34
            List<m0> r1 = s();     // Catch: Throwable -> L34
            List<m0> r2 = t();     // Catch: Throwable -> L34
            List<m0> r3 = r();     // Catch: Throwable -> L34
            Closeable r4 = this.f16248c;     // Catch: Throwable -> L34
            float r5 = this.f16249d;     // Catch: Throwable -> L34
            int r6 = this.f16250e;     // Catch: Throwable -> L34
            monitor-exit(this);     // Catch: Throwable -> L34
            d.k(r1);
            d.l(r2);
            d.j(r3);
            monitor-enter(r0);
            monitor-enter(this);     // Catch: Throwable -> L31
        L28:
            th = move-exception;
            throw th;     // Catch: Throwable -> L31
        L15:
            if (r4 == this.f16248c) goto L17;
            r4 = null;
        L19:
            monitor-exit(this);     // Catch: Throwable -> L28
            if (r4 != null) goto L22;
        L25:
            monitor-exit(r0);     // Catch: Throwable -> L31
            g(r0, r9);
            return true;
        L22:
            if (r5 <= 0.0f) goto L24;
            r8.c(r5);     // Catch: Throwable -> L31
        L24:
            r8.d(r4, r6);     // Catch: Throwable -> L31
            i(r4);     // Catch: Throwable -> L31
            goto L25
        L17:
            if (r4 == null) goto L19;
            r4 = this.f16253h.f(r4);     // Catch: Throwable -> L28
        L31:
            th = move-exception;
            throw th;
        L7:
            monitor-exit(this);     // Catch: Throwable -> L34
            return false;
        }

        public void m(e0<K, T>.b.C0431b r2) {
            monitor-enter(this);
        L11:
            th = move-exception;
            throw th;
        L4:
            if (this.f16252g == r2) goto L7;
            monitor-exit(this);     // Catch: Throwable -> L11
            return;
        L7:
            this.f16252g = null;     // Catch: Throwable -> L11
            this.f16251f = null;     // Catch: Throwable -> L11
            i(this.f16248c);     // Catch: Throwable -> L11
            this.f16248c = null;     // Catch: Throwable -> L11
            monitor-exit(this);     // Catch: Throwable -> L11
            q();
        }

        public void n(e0<K, T>.b.C0431b r3, Throwable r4) {
            monitor-enter(this);
        L20:
            th = move-exception;
            throw th;
        L4:
            if (this.f16252g == r3) goto L7;
            monitor-exit(this);     // Catch: Throwable -> L20
            return;
        L7:
            Iterator<Pair<k<T>, l0>> r5 = this.f16247b.iterator();     // Catch: Throwable -> L20
            this.f16247b.clear();     // Catch: Throwable -> L20
            e0.d(this.f16253h, this.f16246a, this);     // Catch: Throwable -> L20
            i(this.f16248c);     // Catch: Throwable -> L20
            this.f16248c = null;     // Catch: Throwable -> L20
            monitor-exit(this);     // Catch: Throwable -> L20
        L10:
            if (r5.hasNext() == false) goto L19;
            Pair<k<T>, l0> r2 = r5.next();
            monitor-enter(r2);
            ((k) r2.first).a(r4);     // Catch: Throwable -> L16
            monitor-exit(r2);     // Catch: Throwable -> L16
        L16:
            th = move-exception;
            throw th;
        }

        public void o(e0<K, T>.b.C0431b r3, T r4, int r5) {
            monitor-enter(this);
        L23:
            th = move-exception;
            throw th;
        L4:
            if (this.f16252g == r3) goto L7;
            monitor-exit(this);     // Catch: Throwable -> L23
            return;
        L7:
            i(this.f16248c);     // Catch: Throwable -> L23
            this.f16248c = null;     // Catch: Throwable -> L23
            Iterator<Pair<k<T>, l0>> r6 = this.f16247b.iterator();     // Catch: Throwable -> L23
            if (d.c.i.p.b.f(r5) == false) goto L10;
            this.f16248c = (T) this.f16253h.f(r4);     // Catch: Throwable -> L23
            this.f16250e = r5;     // Catch: Throwable -> L23
        L11:
            monitor-exit(this);     // Catch: Throwable -> L23
        L13:
            if (r6.hasNext() == false) goto L22;
            Pair<k<T>, l0> r2 = r6.next();
            monitor-enter(r2);
            ((k) r2.first).d(r4, r5);     // Catch: Throwable -> L19
            monitor-exit(r2);     // Catch: Throwable -> L19
        L19:
            th = move-exception;
            throw th;
        L22:
            return;
        L10:
            this.f16247b.clear();     // Catch: Throwable -> L23
            e0.d(this.f16253h, this.f16246a, this);     // Catch: Throwable -> L23
            goto L11
        }

        public void p(e0<K, T>.b.C0431b r2, float r3) {
            monitor-enter(this);
        L20:
            th = move-exception;
            throw th;
        L4:
            if (this.f16252g == r2) goto L7;
            monitor-exit(this);     // Catch: Throwable -> L20
            return;
        L7:
            this.f16249d = r3;     // Catch: Throwable -> L20
            Iterator<Pair<k<T>, l0>> r4 = this.f16247b.iterator();     // Catch: Throwable -> L20
            monitor-exit(this);     // Catch: Throwable -> L20
        L10:
            if (r4.hasNext() == false) goto L19;
            Pair<k<T>, l0> r1 = r4.next();
            monitor-enter(r1);
            ((k) r1.first).c(r3);     // Catch: Throwable -> L16
            monitor-exit(r1);     // Catch: Throwable -> L16
        L16:
            th = move-exception;
            throw th;
        }
    }

    protected e0(k0<T> r1) {
        this.f16245b = r1;
        this.f16244a = new HashMap();
    }

    static /* synthetic */ b c(e0 r0, Object r1) {
        return r0.h(r1);
    }

    static /* synthetic */ void d(e0 r0, Object r1, b r2) {
        r0.j(r1, r2);
    }

    static /* synthetic */ k0 e(e0 r0) {
        return r0.f16245b;
    }

    private synchronized e0<K, T>.b g(K r3) {
        monitor-enter(this);
        e0<K, T>.b r0 = new b(this, r3);     // Catch: Throwable -> L6
        this.f16244a.put(r3, r0);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    private synchronized e0<K, T>.b h(K r2) {
        monitor-enter(this);
        e0<K, T>.b r3 = this.f16244a.get(r2);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r3;
    L6:
        th = move-exception;
        throw th;
    }

    private synchronized void j(K r2, e0<K, T>.b r3) {
        monitor-enter(this);
    L8:
        th = move-exception;
        throw th;
    L4:
        if (this.f16244a.get(r2) != r3) goto L6;
        this.f16244a.remove(r2);     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
    }

    @Override // d.c.i.p.k0
    public void b(k<T> r5, l0 r6) {
    L23:
        th = move-exception;
        if (d.c.i.r.b.d() == false) goto L27;
        d.c.i.r.b.b();
    L27:
        throw th;
    L3:
        if (d.c.i.r.b.d() == false) goto L5;
        d.c.i.r.b.a("MultiplexProducer#produceResults");     // Catch: Throwable -> L23
    L5:
        K r0 = i(r6);     // Catch: Throwable -> L23
    L6:
        boolean r1 = false;
        monitor-enter(this);     // Catch: Throwable -> L23
        e0<K, T>.b r2 = h(r0);     // Catch: Throwable -> L20
        if (r2 != null) goto L11;
        r2 = g(r0);     // Catch: Throwable -> L20
        r1 = true;
    L11:
        monitor-exit(this);     // Catch: Throwable -> L20
        if (r2.h(r5, r6) == false) goto L6;
        if (r1 == false) goto L17;
        b.a(r2);     // Catch: Throwable -> L23
    L17:
        if (d.c.i.r.b.d() == false) goto L33;
        d.c.i.r.b.b();
        return;
    L33:
        return;
    L20:
        th = move-exception;
        throw th;     // Catch: Throwable -> L23
    }

    protected abstract T f(T r1);

    protected abstract K i(l0 r1);
}
