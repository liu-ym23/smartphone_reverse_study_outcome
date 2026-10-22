package h.a.f3;

import h.a.d1;
import h.a.t0;
import h.a.u0;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u00012\u00060\u0002j\u0002`\u00032\u00020\u0004B\u0015\u0012\u0006\u0010\u0005\u001a\u00020\u0001\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0014\u0010\u000f\u001a\u00020\u00102\n\u0010\u0011\u001a\u00060\u0002j\u0002`\u0003H\u0002J\u0019\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0097Aø\u0001\u0000¢\u0006\u0002\u0010\u0016J\u001c\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u00192\n\u0010\u0011\u001a\u00060\u0002j\u0002`\u0003H\u0016J#\u0010\u001a\u001a\u00020\u00132\n\u0010\u0011\u001a\u00060\u0002j\u0002`\u00032\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00130\u001bH\u0082\bJ\u001c\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u00192\n\u0010\u0011\u001a\u00060\u0002j\u0002`\u0003H\u0017J%\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00152\n\u0010\u0011\u001a\u00060\u0002j\u0002`\u00032\u0006\u0010\u0018\u001a\u00020\u0019H\u0096\u0001J\u0010\u0010 \u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0007H\u0017J\b\u0010!\u001a\u00020\u0013H\u0016J\u001f\u0010\"\u001a\u00020\u00132\u0006\u0010\u001f\u001a\u00020\u00152\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00130$H\u0096\u0001J\b\u0010%\u001a\u00020\u0010H\u0002R\u000e\u0010\u0005\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\t\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\f\u001a\u00060\rj\u0002`\u000eX\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006&"}, d2 = {"Lkotlinx/coroutines/internal/LimitedDispatcher;", "Lkotlinx/coroutines/CoroutineDispatcher;", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "Lkotlinx/coroutines/Delay;", "dispatcher", "parallelism", "", "(Lkotlinx/coroutines/CoroutineDispatcher;I)V", "queue", "Lkotlinx/coroutines/internal/LockFreeTaskQueue;", "runningWorkers", "workerAllocationLock", "", "Lkotlinx/coroutines/internal/SynchronizedObject;", "addAndTryDispatching", "", "block", "delay", "", "time", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "dispatch", "context", "Lkotlin/coroutines/CoroutineContext;", "dispatchInternal", "Lkotlin/Function0;", "dispatchYield", "invokeOnTimeout", "Lkotlinx/coroutines/DisposableHandle;", "timeMillis", "limitedParallelism", "run", "scheduleResumeAfterDelay", "continuation", "Lkotlinx/coroutines/CancellableContinuation;", "tryAllocateWorker", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class o extends h.a.g0 implements Runnable, u0 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final h.a.g0 f17398f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int f17399g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final /* synthetic */ u0 f17400h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final t<Runnable> f17401i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final Object f17402j;
    private volatile int runningWorkers;

    /* JADX WARN: Multi-variable type inference failed */
    public o(h.a.g0 r1, int r2) {
        this.f17398f = r1;
        this.f17399g = r2;
        if ((r1 instanceof u0) == false) goto L5;
        u0 r3 = (u0) r1;
    L6:
        if (r3 != null) goto L8;
        r3 = t0.a();
    L8:
        this.f17400h = r3;
        this.f17401i = new t(false);
        this.f17402j = new Object();
        return;
    L5:
        r3 = null;
        goto L6
    }

    private final boolean h0(Runnable r2) {
        this.f17401i.a(r2);
        if (this.runningWorkers < this.f17399g) goto L5;
        return true;
    L5:
        return false;
    }

    private final boolean i0() {
        Object r0 = this.f17402j;
        monitor-enter(r0);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (this.runningWorkers >= this.f17399g) goto L7;
        this.runningWorkers++;     // Catch: Throwable -> L12
        monitor-exit(r0);
        return true;
    L7:
        monitor-exit(r0);
        return false;
    }

    @Override // h.a.u0
    public d1 M(long r1, Runnable r3, kotlin.k0.g r4) {
        return this.f17400h.M(r1, r3, r4);
    }

    @Override // h.a.g0
    public void dispatch(kotlin.k0.g r1, Runnable r2) {
        if (h0(r2) == false) goto L6;
        return;
    L6:
        if (i0() == false) goto L11;
        this.f17398f.dispatch(this, this);
        return;
    }

    @Override // h.a.g0
    public void dispatchYield(kotlin.k0.g r1, Runnable r2) {
        if (h0(r2) == false) goto L6;
        return;
    L6:
        if (i0() == false) goto L11;
        this.f17398f.dispatchYield(this, this);
        return;
    }

    @Override // h.a.u0
    public void l(long r1, h.a.n<? super kotlin.f0> r3) {
        this.f17400h.l(r1, r3);
    }

    @Override // h.a.g0
    public h.a.g0 limitedParallelism(int r2) {
        p.a(r2);
        if (r2 < this.f17399g) goto L6;
        return this;
    L6:
        return super.limitedParallelism(r2);
    }

    @Override // java.lang.Runnable
    public void run() {
    L3:
        int r1 = 0;
    L4:
        Runnable r2 = this.f17401i.d();
        if (r2 == null) goto L16;
        r2.run();     // Catch: Throwable -> L8
    L10:
        r1 = r1 + 1;
        if (r1 < 16) goto L4;
        if (this.f17398f.isDispatchNeeded(this) == false) goto L4;
        this.f17398f.dispatch(this, this);
        return;
    L8:
        th = move-exception;
        h.a.j0.a(kotlin.k0.h.f18399f, th);
        goto L10
    L16:
        Object r3 = this.f17402j;
        monitor-enter(r3);
        this.runningWorkers--;     // Catch: Throwable -> L25
        if (this.f17401i.c() == 0) goto L20;
        this.runningWorkers++;     // Catch: Throwable -> L25
        kotlin.f0 r4 = kotlin.f0.f18324a;     // Catch: Throwable -> L25
        monitor-exit(r3);
        goto L3
    L20:
        monitor-exit(r3);
        return;
    L25:
        th = move-exception;
        throw th;
    }
}
