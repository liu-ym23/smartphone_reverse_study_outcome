package kotlinx.coroutines.scheduling;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.DefaultExecutor;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
final class LimitingDispatcher extends ExecutorCoroutineDispatcher implements TaskContext, Executor {
    public static final AtomicIntegerFieldUpdater l = null;
    public final ConcurrentLinkedQueue e;
    public final ExperimentalCoroutineDispatcher f;
    public final int i;
    private volatile int inFlightTasks;
    public final String j;
    public final int k;

    static {
        l = AtomicIntegerFieldUpdater.newUpdater(LimitingDispatcher.class, "inFlightTasks");
    }

    public LimitingDispatcher(DefaultScheduler r1, int r2) {
        this.f = r1;
        this.i = r2;
        this.j = "Dispatchers.IO";
        this.k = 1;
        this.e = new ConcurrentLinkedQueue();
        this.inFlightTasks = 0;
    }

    @Override // kotlinx.coroutines.scheduling.TaskContext
    public final void c() {
        ConcurrentLinkedQueue r0 = this.e;
        Runnable r1 = (Runnable) r0.poll();
        if (r1 == null) goto L13;
        CoroutineScheduler r2 = this.f.e;
        r2.b(r1, this, true);     // Catch: RejectedExecutionException -> L7
        return;
    L7:
        DefaultExecutor r3 = DefaultExecutor.m;
        r2.getClass();
        TasksKt.e.getClass();
        long r4 = System.nanoTime();
        if ((r1 instanceof Task) == false) goto L10;
        Task r5 = (Task) r1;
        r5.b = r4;
        r5.c = this;
    L11:
        r3.A(r5);
        return;
    L10:
        r5 = new TaskImpl(r1, r4, this);
        goto L11
    L13:
        l.decrementAndGet(this);
        Runnable r6 = (Runnable) r0.poll();
        if (r6 == null) goto L20;
        m(r6, true);
        return;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        throw new IllegalStateException("Close cannot be invoked on LimitingBlockingDispatcher".toString());
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable r2) {
        m(r2, false);
    }

    @Override // kotlinx.coroutines.scheduling.TaskContext
    public final int g() {
        return this.k;
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public final void j(CoroutineContext r1, Runnable r2) {
        m(r2, false);
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public final void k(CoroutineContext r1, Runnable r2) {
        m(r2, true);
    }

    public final void m(Runnable r4, boolean r5) {
    L2:
        AtomicIntegerFieldUpdater r0 = l;
        int r1 = r0.incrementAndGet(this);
        int r2 = this.i;
        if (r1 <= r2) goto L4;
        ConcurrentLinkedQueue r3 = this.e;
        r3.add(r4);
        if (r0.decrementAndGet(this) >= r2) goto L15;
        r4 = (Runnable) r3.poll();
        if (r4 != null) goto L2;
        return;
    L15:
        return;
    L4:
        CoroutineScheduler r6 = this.f.e;
        r6.b(r4, this, r5);     // Catch: RejectedExecutionException -> L7
        return;
    L7:
        DefaultExecutor r7 = DefaultExecutor.m;
        r6.getClass();
        TasksKt.e.getClass();
        long r8 = System.nanoTime();
        if ((r4 instanceof Task) == false) goto L10;
        Task r9 = (Task) r4;
        r9.b = r8;
        r9.c = this;
    L11:
        r7.A(r9);
        return;
    L10:
        r9 = new TaskImpl(r4, r8, this);
        goto L11
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public final String toString() {
        String r0 = this.j;
        if (r0 == null) goto L6;
        return r0;
    L6:
        return super.toString() + "[dispatcher = " + this.f + ']';
    }
}
