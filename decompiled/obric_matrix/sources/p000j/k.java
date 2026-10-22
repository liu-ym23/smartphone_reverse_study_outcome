package p000j;

import com.ttnet.org.chromium.base.TimeUtils;
import java.lang.ref.Reference;
import java.net.Socket;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import p000j.k0.f.c;
import p000j.k0.f.d;
import p000j.k0.f.g;

/* JADX INFO: loaded from: classes2.dex */
public final class k {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final Executor f17782g = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f17783a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f17784b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Runnable f17785c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Deque<c> f17786d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final d f17787e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    boolean f17788f;

    class a implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ k f17789f;

        a(k r1) {
            this.f17789f = r1;
        }

        @Override // java.lang.Runnable
        public void run() {
        L2:
            long r0 = this.f17789f.a(System.nanoTime());
            if (r0 == (-1)) goto L4;
            if (r0 <= 0) goto L2;
            long r4 = r0 / TimeUtils.NANOSECONDS_PER_MILLISECOND;
            long r1 = r0 - (TimeUtils.NANOSECONDS_PER_MILLISECOND * r4);
            k r2 = this.f17789f;
            monitor-enter(r2);
            this.f17789f.wait(r4, (int) r1);     // Catch: Throwable -> L11 InterruptedException -> L17
        L11:
            th = move-exception;
            throw th;
        L13:
            monitor-exit(r2);     // Catch: Throwable -> L11
            goto L2
        }
    }

    static {
        f17782g = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), p000j.k0.c.G("OkHttp ConnectionPool", true));
    }

    public k() {
        this(5, 5, TimeUnit.MINUTES);
    }

    public k(int r3, long r4, TimeUnit r6) {
        this.f17785c = new a(this);
        this.f17786d = new ArrayDeque();
        this.f17787e = new d();
        this.f17783a = r3;
        this.f17784b = r6.toNanos(r4);
        if (r4 <= 0) goto L6;
        return;
    L6:
        throw new IllegalArgumentException("keepAliveDuration <= 0: " + r4);
    }

    private int e(c r7, long r8) {
        List<Reference<g>> r0 = r7.n;
        int r2 = 0;
    L4:
        if (r2 >= r0.size()) goto L13;
        Reference<g> r3 = r0.get(r2);
        if (r3.get() != null) goto L7;
        p000j.k0.j.g.m().u("A connection to " + r7.a().a().m() + " was leaked. Did you forget to close a response body?", ((g.a) r3).f17870a);
        r0.remove(r2);
        r7.f17839k = true;
        if (r0.isEmpty() == false) goto L4;
        r7.o = r8 - this.f17784b;
        return 0;
    L7:
        r2 = r2 + 1;
        goto L4
    L13:
        return r0.size();
    }

    long a(long r12) {
        monitor-enter(this);
        Iterator<c> r0 = this.f17786d.iterator();     // Catch: Throwable -> L31
        c r2 = null;
        long r3 = Long.MIN_VALUE;
        int r5 = 0;
        int r6 = 0;
    L5:
        if (r0.hasNext() == false) goto L12;
        c r7 = r0.next();     // Catch: Throwable -> L31
        if (e(r7, r12) > 0) goto L8;
        r5 = r5 + 1;     // Catch: Throwable -> L31
        long r8 = r12 - r7.o;     // Catch: Throwable -> L31
        if (r8 <= r3) goto L5;
        r2 = r7;
        r3 = r8;
        goto L5
    L8:
        r6 = r6 + 1;     // Catch: Throwable -> L31
        goto L5
    L12:
        long r13 = this.f17784b;     // Catch: Throwable -> L31
        if (r3 < r13) goto L15;
    L27:
        this.f17786d.remove(r2);     // Catch: Throwable -> L31
        monitor-exit(this);     // Catch: Throwable -> L31
        p000j.k0.c.h(r2.b());
        return 0;
    L15:
        if (r5 > this.f17783a) goto L27;
        if (r5 <= 0) goto L21;
        long r14 = r13 - r3;     // Catch: Throwable -> L31
        monitor-exit(this);     // Catch: Throwable -> L31
        return r14;
    L21:
        if (r6 <= 0) goto L24;
        monitor-exit(this);     // Catch: Throwable -> L31
        return r13;
    L24:
        this.f17788f = false;     // Catch: Throwable -> L31
        monitor-exit(this);     // Catch: Throwable -> L31
        return -1;
    L31:
        th = move-exception;
        throw th;
    }

    boolean b(c r2) {
        if (r2.f17839k == false) goto L5;
    L9:
        this.f17786d.remove(r2);
        return true;
    L5:
        if (this.f17783a == 0) goto L9;
        notifyAll();
        return false;
    }

    Socket c(p000j.a r3, g r4) {
        Iterator<c> r2 = this.f17786d.iterator();
    L4:
        if (r2.hasNext() == false) goto L13;
        c r0 = r2.next();
        if (r0.n(r3, null) == false) goto L4;
        if (r0.p() == false) goto L4;
        if (r0 == r4.d()) goto L4;
        return r4.m(r0);
    L13:
        return null;
    }

    c d(p000j.a r3, g r4, h0 r5) {
        Iterator<c> r2 = this.f17786d.iterator();
    L4:
        if (r2.hasNext() == false) goto L9;
        c r0 = r2.next();
        if (r0.n(r3, r5) == false) goto L4;
        r4.a(r0, true);
        return r0;
    L9:
        return null;
    }

    void f(c r3) {
        if (this.f17788f == true) goto L5;
        this.f17788f = true;
        f17782g.execute(this.f17785c);
    L5:
        this.f17786d.add(r3);
    }
}
