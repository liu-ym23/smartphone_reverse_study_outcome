package d.c.c.b;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public class c extends AbstractExecutorService {
    private static final Class<?> m = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f15365f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Executor f15366g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private volatile int f15367h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final BlockingQueue<Runnable> f15368i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final b f15369j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final AtomicInteger f15370k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final AtomicInteger f15371l;

    static /* synthetic */ class a {
    }

    private class b implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ c f15372f;

        private b(c r1) {
            this.f15372f = r1;
        }

        /* synthetic */ b(c r1, a r2) {
            this(r1);
        }

        @Override // java.lang.Runnable
        public void run() {
            Runnable r1 = (Runnable) c.a(this.f15372f).poll();     // Catch: Throwable -> L12
            if (r1 == null) goto L6;
            r1.run();     // Catch: Throwable -> L12
        L7:
            int r2 = c.d(this.f15372f).decrementAndGet();
            if (c.a(this.f15372f).isEmpty() == true) goto L10;
            c.e(this.f15372f);
            return;
        L10:
            d.c.c.e.a.t(c.b(), "%s: worker finished; %d workers left", c.c(this.f15372f), Integer.valueOf(r2));
            return;
        L6:
            d.c.c.e.a.s(c.b(), "%s: Worker has nothing to run", c.c(this.f15372f));     // Catch: Throwable -> L12
        L12:
            th = move-exception;
            int r3 = c.d(this.f15372f).decrementAndGet();
            if (c.a(this.f15372f).isEmpty() == true) goto L16;
            c.e(this.f15372f);
        L17:
            throw th;
        L16:
            d.c.c.e.a.t(c.b(), "%s: worker finished; %d workers left", c.c(this.f15372f), Integer.valueOf(r3));
            goto L17
        }
    }

    static {
        m = c.class;
    }

    public c(String r1, int r2, Executor r3, BlockingQueue<Runnable> r4) {
        if (r2 <= 0) goto L7;
        this.f15365f = r1;
        this.f15366g = r3;
        this.f15367h = r2;
        this.f15368i = r4;
        this.f15369j = new b(this, null);
        this.f15370k = new AtomicInteger(0);
        this.f15371l = new AtomicInteger(0);
        return;
    L7:
        throw new IllegalArgumentException("max concurrency must be > 0");
    }

    static /* synthetic */ BlockingQueue a(c r0) {
        return r0.f15368i;
    }

    static /* synthetic */ Class b() {
        return m;
    }

    static /* synthetic */ String c(c r0) {
        return r0.f15365f;
    }

    static /* synthetic */ AtomicInteger d(c r0) {
        return r0.f15370k;
    }

    static /* synthetic */ void e(c r0) {
        r0.f();
    }

    private void f() {
    L2:
        int r0 = this.f15370k.get();
        if (r0 >= this.f15367h) goto L11;
        int r1 = r0 + 1;
        if (this.f15370k.compareAndSet(r0, r1) == true) goto L6;
        d.c.c.e.a.s(m, "%s: race in startWorkerIfNeeded; retrying", this.f15365f);
        goto L2
    L6:
        d.c.c.e.a.u(m, "%s: starting worker %d of %d", this.f15365f, Integer.valueOf(r1), Integer.valueOf(this.f15367h));
        this.f15366g.execute(this.f15369j);
        return;
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean awaitTermination(long r1, TimeUnit r3) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable r4) {
        Objects.requireNonNull(r4, "runnable parameter is null");
        if (this.f15368i.offer(r4) == false) goto L12;
        int r5 = this.f15368i.size();
        int r0 = this.f15371l.get();
        if (r5 > r0) goto L7;
    L9:
        f();
        return;
    L7:
        if (this.f15371l.compareAndSet(r0, r5) == false) goto L9;
        d.c.c.e.a.t(m, "%s: max pending work in queue = %d", this.f15365f, Integer.valueOf(r5));
        goto L9
    L12:
        throw new RejectedExecutionException(this.f15365f + " queue is full, size=" + this.f15368i.size());
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isShutdown() {
        return false;
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isTerminated() {
        return false;
    }

    @Override // java.util.concurrent.ExecutorService
    public void shutdown() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.concurrent.ExecutorService
    public List<Runnable> shutdownNow() {
        throw new UnsupportedOperationException();
    }
}
