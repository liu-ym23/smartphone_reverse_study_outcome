package p000j;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import p000j.k0.c;

/* JADX INFO: loaded from: classes2.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f18177a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f18178b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Runnable f18179c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private ExecutorService f18180d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Deque<c0.b> f18181e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Deque<c0.b> f18182f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Deque<c0> f18183g;

    static {
    }

    public q() {
        this.f18177a = 64;
        this.f18178b = 5;
        this.f18181e = new ArrayDeque();
        this.f18182f = new ArrayDeque();
        this.f18183g = new ArrayDeque();
    }

    private <T> void d(Deque<T> r1, T r2) {
        monitor-enter(this);
    L14:
        th = move-exception;
        throw th;
    L4:
        if (r1.remove(r2) == false) goto L13;
        Runnable r3 = this.f18179c;     // Catch: Throwable -> L14
        monitor-exit(this);     // Catch: Throwable -> L14
        if (g() == true) goto L18;
        if (r3 == null) goto L19;
        r3.run();
        return;
    L19:
        return;
    L18:
        return;
    L13:
        throw new AssertionError("Call wasn't in-flight!");     // Catch: Throwable -> L14
    }

    private boolean g() {
        ArrayList r0 = new ArrayList();
        monitor-enter(this);
        Iterator<c0.b> r1 = this.f18181e.iterator();     // Catch: Throwable -> L23
    L6:
        if (r1.hasNext() == false) goto L14;
        c0.b r2 = r1.next();     // Catch: Throwable -> L23
        if (this.f18182f.size() >= this.f18177a) goto L14;
        if (i(r2) >= this.f18178b) goto L6;
        r1.remove();     // Catch: Throwable -> L23
        r0.add(r2);     // Catch: Throwable -> L23
        this.f18182f.add(r2);     // Catch: Throwable -> L23
    L14:
        int r3 = 0;
        if (h() <= 0) goto L17;
        boolean r4 = true;
    L18:
        monitor-exit(this);     // Catch: Throwable -> L23
        int r5 = r0.size();
    L20:
        if (r3 >= r5) goto L22;
        ((c0.b) r0.get(r3)).m(c());
        r3 = r3 + 1;
        goto L20
    L22:
        return r4;
    L17:
        r4 = false;
    L23:
        th = move-exception;
        throw th;
    }

    private int i(c0.b r4) {
        Iterator<c0.b> r3 = this.f18182f.iterator();
        int r0 = 0;
    L4:
        if (r3.hasNext() == false) goto L11;
        c0.b r1 = r3.next();
        if (r1.n().f17685k == true) goto L4;
        if (r1.o().equals(r4.o()) == false) goto L4;
        r0 = r0 + 1;
        goto L4
    L11:
        return r0;
    }

    void a(c0.b r2) {
        monitor-enter(this);
        this.f18181e.add(r2);     // Catch: Throwable -> L7
        monitor-exit(this);     // Catch: Throwable -> L7
        g();
        return;
    L7:
        th = move-exception;
        throw th;
    }

    synchronized void b(c0 r2) {
        monitor-enter(this);
        this.f18183g.add(r2);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized ExecutorService c() {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (this.f18180d != null) goto L6;
        this.f18180d = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), c.G("OkHttp Dispatcher", false));     // Catch: Throwable -> L9
    L6:
        ExecutorService r0 = this.f18180d;     // Catch: Throwable -> L9
        monitor-exit(this);
        return r0;
    }

    void e(c0.b r2) {
        d(this.f18182f, r2);
    }

    void f(c0 r2) {
        d(this.f18183g, r2);
    }

    public synchronized int h() {
        monitor-enter(this);
        int r0 = this.f18182f.size() + this.f18183g.size();
        monitor-exit(this);
        return r0;
    L7:
        th = move-exception;
        throw th;
    }
}
