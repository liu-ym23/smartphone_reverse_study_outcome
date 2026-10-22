package d.c.i.p;

import android.util.Pair;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
public class a1<T> implements k0<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final k0<T> f16212a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f16213b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f16214c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ConcurrentLinkedQueue<Pair<k<T>, l0>> f16215d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Executor f16216e;

    static /* synthetic */ class a {
    }

    private class b extends n<T, T> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ a1 f16217c;

        class a implements Runnable {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ Pair f16218f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            final /* synthetic */ b f16219g;

            a(b r1, Pair r2) {
                this.f16219g = r1;
                this.f16218f = r2;
            }

            @Override // java.lang.Runnable
            public void run() {
                a1 r0 = this.f16219g.f16217c;
                Pair r2 = this.f16218f;
                r0.f((k) r2.first, (l0) r2.second);
            }
        }

        private b(a1 r1, k<T> r2) {
            this.f16217c = r1;
            super(r2);
        }

        /* synthetic */ b(a1 r1, k r2, a r3) {
            this(r1, r2);
        }

        private void q() {
            a1 r0 = this.f16217c;
            monitor-enter(r0);
            Pair r1 = (Pair) a1.c(this.f16217c).poll();     // Catch: Throwable -> L11
            if (r1 != null) goto L7;
            a1.d(this.f16217c);     // Catch: Throwable -> L11
        L7:
            monitor-exit(r0);     // Catch: Throwable -> L11
            if (r1 == null) goto L16;
            a1.e(this.f16217c).execute(new a(this, r1));
            return;
        L16:
            return;
        L11:
            th = move-exception;
            throw th;
        }

        @Override // d.c.i.p.n, d.c.i.p.b
        protected void g() {
            p().b();
            q();
        }

        @Override // d.c.i.p.n, d.c.i.p.b
        protected void h(Throwable r2) {
            p().a(r2);
            q();
        }

        @Override // d.c.i.p.b
        protected void i(T r2, int r3) {
            p().d(r2, r3);
            if (d.c.i.p.b.e(r3) == false) goto L6;
            q();
            return;
        }
    }

    public a1(int r1, Executor r2, k0<T> r3) {
        this.f16213b = r1;
        d.c.c.d.i.g(r2);
        this.f16216e = r2;
        d.c.c.d.i.g(r3);
        this.f16212a = r3;
        this.f16215d = new ConcurrentLinkedQueue();
        this.f16214c = 0;
    }

    static /* synthetic */ ConcurrentLinkedQueue c(a1 r0) {
        return r0.f16215d;
    }

    static /* synthetic */ int d(a1 r2) {
        int r0 = r2.f16214c;
        r2.f16214c = r0 - 1;
        return r0;
    }

    static /* synthetic */ Executor e(a1 r0) {
        return r0.f16216e;
    }

    @Override // d.c.i.p.k0
    public void b(k<T> r4, l0 r5) {
        r5.f().b(r5.getId(), "ThrottlingProducer");
        monitor-enter(this);
        int r0 = this.f16214c;     // Catch: Throwable -> L12
        boolean r2 = true;
        if (r0 < this.f16213b) goto L7;
        this.f16215d.add(Pair.create(r4, r5));     // Catch: Throwable -> L12
    L8:
        monitor-exit(this);     // Catch: Throwable -> L12
        if (r2 == true) goto L17;
        f(r4, r5);
        return;
    L17:
        return;
    L7:
        this.f16214c = r0 + 1;     // Catch: Throwable -> L12
        r2 = false;
    L12:
        th = move-exception;
        throw th;
    }

    void f(k<T> r5, l0 r6) {
        r6.f().i(r6.getId(), "ThrottlingProducer", null);
        this.f16212a.b(new b(this, r5, null), r6);
    }
}
