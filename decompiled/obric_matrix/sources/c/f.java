package c;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public class f<TResult> {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final Executor f430i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static volatile d f431j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static f<?> f432k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static f<Boolean> f433l;
    private static f<Boolean> m;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f434a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f435b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f436c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private TResult f437d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Exception f438e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f439f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private h f440g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private List<c.d<TResult, Void>> f441h;

    class a implements c.d<TResult, Void> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ g f442a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ c.d f443b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Executor f444c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ c.c f445d;

        a(f r1, g r2, c.d r3, Executor r4, c.c r5) {
            this.f442a = r2;
            this.f443b = r3;
            this.f444c = r4;
        }

        @Override // c.d
        public /* bridge */ /* synthetic */ Void a(f r1) {
            return b(r1);
        }

        public Void b(f<TResult> r4) {
            f.a(this.f442a, this.f443b, r4, this.f444c, this.f445d);
            return null;
        }
    }

    static class b implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ c.c f446f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ g f447g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ c.d f448h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ f f449i;

        b(c.c r1, g r2, c.d r3, f r4) {
            this.f447g = r2;
            this.f448h = r3;
            this.f449i = r4;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            c.c r0 = this.f446f;
            if (r0 == null) goto L12;
            r0.a();
            throw null;
        L12:
            Object r1 = this.f448h.a(this.f449i);     // Catch: Exception -> L6 CancellationException -> L8
            this.f447g.d(r1);     // Catch: Exception -> L6 CancellationException -> L8
        L15:
            return;
        L8:
            this.f447g.b();
            return;
        L6:
            e = move-exception;
            this.f447g.c(e);
        }
    }

    static class c implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ c.c f450f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ g f451g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ Callable f452h;

        c(c.c r1, g r2, Callable r3) {
            this.f451g = r2;
            this.f452h = r3;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            c.c r0 = this.f450f;
            if (r0 == null) goto L12;
            r0.a();
            throw null;
        L12:
            this.f451g.d(this.f452h.call());     // Catch: Exception -> L6 CancellationException -> L8
        L15:
            return;
        L8:
            this.f451g.b();
            return;
        L6:
            e = move-exception;
            this.f451g.c(e);
        }
    }

    public interface d {
        void a(f<?> r1, i r2);
    }

    static {
        c.b.a();
        f430i = c.b.b();
        c.a.c();
        f432k = new f(null);
        f433l = new f(Boolean.TRUE);
        m = new f(Boolean.FALSE);
        new f(true);
    }

    f() {
        this.f434a = new Object();
        this.f441h = new ArrayList();
    }

    private f(TResult r2) {
        this.f434a = new Object();
        this.f441h = new ArrayList();
        r(r2);
    }

    private f(boolean r2) {
        this.f434a = new Object();
        this.f441h = new ArrayList();
        if (r2 == false) goto L5;
        p();
        return;
    L5:
        r(null);
    }

    static /* synthetic */ void a(g r0, c.d r1, f r2, Executor r3, c.c r4) {
        d(r0, r1, r2, r3, r4);
    }

    public static <TResult> f<TResult> b(Callable<TResult> r1, Executor r2) {
        return c(r1, r2, null);
    }

    public static <TResult> f<TResult> c(Callable<TResult> r2, Executor r3, c.c r4) {
        g r0 = new g();
        r3.execute(new c(r4, r0, r2));     // Catch: Exception -> L5
    L8:
        return r0.a();
    L5:
        e = move-exception;
        r0.c(new e(e));
        goto L8
    }

    private static <TContinuationResult, TResult> void d(g<TContinuationResult> r1, c.d<TResult, TContinuationResult> r2, f<TResult> r3, Executor r4, c.c r5) {
        r4.execute(new b(r5, r1, r2, r3));     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        r1.c(new e(e));
    }

    public static <TResult> f<TResult> g(Exception r1) {
        g r0 = new g();
        r0.c(r1);
        return r0.a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <TResult> f<TResult> h(TResult r1) {
        if (r1 != 0) goto L6;
        return (f<TResult>) f432k;
    L6:
        if ((r1 instanceof Boolean) == true) goto L8;
        g r0 = new g();
        r0.d(r1);
        return r0.a();
    L8:
        if (((Boolean) r1).booleanValue() == false) goto L11;
        return (f<TResult>) f433l;
    L11:
        return (f<TResult>) m;
    }

    public static d k() {
        return f431j;
    }

    private void o() {
        Object r0 = this.f434a;
        monitor-enter(r0);
        Iterator<c.d<TResult, Void>> r1 = this.f441h.iterator();     // Catch: Throwable -> L18
    L6:
        if (r1.hasNext() == false) goto L15;
        r1.next().a(this);     // Catch: Exception -> L10 RuntimeException -> L13 Throwable -> L18
    L13:
        e = move-exception;
        throw e;     // Catch: Throwable -> L18
    L10:
        e = move-exception;
        throw new RuntimeException(e);     // Catch: Throwable -> L18
    L15:
        this.f441h = null;     // Catch: Throwable -> L18
        monitor-exit(r0);     // Catch: Throwable -> L18
        return;
    L18:
        th = move-exception;
        throw th;
    }

    public <TContinuationResult> f<TContinuationResult> e(c.d<TResult, TContinuationResult> r3) {
        return f(r3, f430i, null);
    }

    public <TContinuationResult> f<TContinuationResult> f(c.d<TResult, TContinuationResult> r12, Executor r13, c.c r14) {
        g r6 = new g();
        Object r7 = this.f434a;
        monitor-enter(r7);
        boolean r8 = m();     // Catch: Throwable -> L12
        if (r8 == true) goto L7;
        this.f441h.add(new a(this, r6, r12, r13, r14));     // Catch: Throwable -> L12
    L7:
        monitor-exit(r7);     // Catch: Throwable -> L12
        if (r8 == false) goto L11;
        d(r6, r12, this, r13, r14);
    L11:
        return r6.a();
    L12:
        th = move-exception;
        throw th;
    }

    public Exception i() {
        Object r0 = this.f434a;
        monitor-enter(r0);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (this.f438e == null) goto L9;
        this.f439f = true;     // Catch: Throwable -> L12
        h r1 = this.f440g;     // Catch: Throwable -> L12
        if (r1 == null) goto L9;
        r1.a();     // Catch: Throwable -> L12
        this.f440g = null;     // Catch: Throwable -> L12
    L9:
        Exception r2 = this.f438e;     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        return r2;
    }

    public TResult j() {
        Object r0 = this.f434a;
        monitor-enter(r0);
        TResult r1 = this.f437d;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public boolean l() {
        Object r0 = this.f434a;
        monitor-enter(r0);
        boolean r1 = this.f436c;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public boolean m() {
        Object r0 = this.f434a;
        monitor-enter(r0);
        boolean r1 = this.f435b;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public boolean n() {
        Object r0 = this.f434a;
        monitor-enter(r0);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (i() == null) goto L7;
        boolean r1 = true;
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r1;
    L7:
        r1 = false;
        goto L8
    }

    boolean p() {
        Object r0 = this.f434a;
        monitor-enter(r0);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (this.f435b == true) goto L7;
        this.f435b = true;     // Catch: Throwable -> L12
        this.f436c = true;     // Catch: Throwable -> L12
        this.f434a.notifyAll();     // Catch: Throwable -> L12
        o();     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        return true;
    L7:
        monitor-exit(r0);     // Catch: Throwable -> L12
        return false;
    }

    boolean q(Exception r4) {
        Object r0 = this.f434a;
        monitor-enter(r0);
    L15:
        th = move-exception;
        throw th;
    L5:
        if (this.f435b == false) goto L8;
        monitor-exit(r0);     // Catch: Throwable -> L15
        return false;
    L8:
        this.f435b = true;     // Catch: Throwable -> L15
        this.f438e = r4;     // Catch: Throwable -> L15
        this.f439f = false;     // Catch: Throwable -> L15
        this.f434a.notifyAll();     // Catch: Throwable -> L15
        o();     // Catch: Throwable -> L15
        if (this.f439f == false) goto L11;
    L13:
        monitor-exit(r0);     // Catch: Throwable -> L15
        return true;
    L11:
        if (k() == null) goto L13;
        this.f440g = new h(this);     // Catch: Throwable -> L15
        goto L13
    }

    boolean r(TResult r3) {
        Object r0 = this.f434a;
        monitor-enter(r0);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (this.f435b == true) goto L7;
        this.f435b = true;     // Catch: Throwable -> L12
        this.f437d = r3;     // Catch: Throwable -> L12
        this.f434a.notifyAll();     // Catch: Throwable -> L12
        o();     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        return true;
    L7:
        monitor-exit(r0);     // Catch: Throwable -> L12
        return false;
    }
}
