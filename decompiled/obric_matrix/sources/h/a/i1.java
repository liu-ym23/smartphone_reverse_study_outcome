package h.a;

import androidx.core.location.LocationRequestCompat;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\u0018\u0002\b \u0018\u00002\u0002092\u00020::\u00044567B\u0007¢\u0006\u0004\b\u0001\u0010\u0002J\u000f\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0004\u0010\u0002J\u0017\u0010\u0007\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\bJ!\u0010\f\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\t2\n\u0010\u000b\u001a\u00060\u0005j\u0002`\u0006¢\u0006\u0004\b\f\u0010\rJ\u001b\u0010\u000f\u001a\u00020\u00032\n\u0010\u000e\u001a\u00060\u0005j\u0002`\u0006H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u001b\u0010\u0012\u001a\u00020\u00112\n\u0010\u000e\u001a\u00060\u0005j\u0002`\u0006H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0017\u0010\u0002J\u000f\u0010\u0018\u001a\u00020\u0003H\u0004¢\u0006\u0004\b\u0018\u0010\u0002J\u001d\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u001a¢\u0006\u0004\b\u001c\u0010\u001dJ\u001f\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u001aH\u0002¢\u0006\u0004\b\u001f\u0010 J#\u0010#\u001a\u00020\"2\u0006\u0010!\u001a\u00020\u00142\n\u0010\u000b\u001a\u00060\u0005j\u0002`\u0006H\u0004¢\u0006\u0004\b#\u0010$J%\u0010'\u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u00142\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00030%H\u0016¢\u0006\u0004\b'\u0010(J\u0017\u0010)\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u001aH\u0002¢\u0006\u0004\b)\u0010*J\u000f\u0010+\u001a\u00020\u0003H\u0016¢\u0006\u0004\b+\u0010\u0002R$\u0010-\u001a\u00020\u00112\u0006\u0010,\u001a\u00020\u00118B@BX\u0082\u000e¢\u0006\f\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u0014\u00101\u001a\u00020\u00118TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b1\u0010.R\u0014\u00103\u001a\u00020\u00148TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b2\u0010\u0016¨\u00068"}, d2 = {"Lkotlinx/coroutines/EventLoopImplBase;", "<init>", "()V", "", "closeQueue", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "dequeue", "()Ljava/lang/Runnable;", "Lkotlin/coroutines/CoroutineContext;", "context", "block", "dispatch", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Runnable;)V", "task", "enqueue", "(Ljava/lang/Runnable;)V", "", "enqueueImpl", "(Ljava/lang/Runnable;)Z", "", "processNextEvent", "()J", "rescheduleAllDelayed", "resetAll", "now", "Lkotlinx/coroutines/EventLoopImplBase$DelayedTask;", "delayedTask", "schedule", "(JLkotlinx/coroutines/EventLoopImplBase$DelayedTask;)V", "", "scheduleImpl", "(JLkotlinx/coroutines/EventLoopImplBase$DelayedTask;)I", "timeMillis", "Lkotlinx/coroutines/DisposableHandle;", "scheduleInvokeOnTimeout", "(JLjava/lang/Runnable;)Lkotlinx/coroutines/DisposableHandle;", "Lkotlinx/coroutines/CancellableContinuation;", "continuation", "scheduleResumeAfterDelay", "(JLkotlinx/coroutines/CancellableContinuation;)V", "shouldUnpark", "(Lkotlinx/coroutines/EventLoopImplBase$DelayedTask;)Z", "shutdown", "value", "isCompleted", "()Z", "setCompleted", "(Z)V", "isEmpty", "getNextTime", "nextTime", "DelayedResumeTask", "DelayedRunnableTask", "DelayedTask", "DelayedTaskQueue", "kotlinx-coroutines-core", "Lkotlinx/coroutines/EventLoopImplPlatform;", "Lkotlinx/coroutines/Delay;"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class i1 extends j1 implements u0 {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f17458i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f17459j = null;
    private volatile /* synthetic */ Object _delayed;
    private volatile /* synthetic */ int _isCompleted;
    private volatile /* synthetic */ Object _queue;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\b\u0010\b\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\nH\u0016R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lkotlinx/coroutines/EventLoopImplBase$DelayedResumeTask;", "Lkotlinx/coroutines/EventLoopImplBase$DelayedTask;", "nanoTime", "", "cont", "Lkotlinx/coroutines/CancellableContinuation;", "", "(Lkotlinx/coroutines/EventLoopImplBase;JLkotlinx/coroutines/CancellableContinuation;)V", "run", "toString", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
    private final class a extends c {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private final n<kotlin.f0> f17460i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final /* synthetic */ i1 f17461j;

        /* JADX WARN: Multi-variable type inference failed */
        public a(i1 r1, long r2, n<? super kotlin.f0> r4) {
            this.f17461j = r1;
            super(r2);
            this.f17460i = r4;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f17460i.m(this.f17461j, kotlin.f0.f18324a);
        }

        @Override // h.a.i1.c
        public String toString() {
            return kotlin.n0.d.o.m(super.toString(), this.f17460i);
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\u0010\u0004\u001a\u00060\u0005j\u0002`\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\u000bH\u0016R\u0012\u0010\u0004\u001a\u00060\u0005j\u0002`\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lkotlinx/coroutines/EventLoopImplBase$DelayedRunnableTask;", "Lkotlinx/coroutines/EventLoopImplBase$DelayedTask;", "nanoTime", "", "block", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "(JLjava/lang/Runnable;)V", "run", "", "toString", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
    private static final class b extends c {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private final Runnable f17462i;

        public b(long r1, Runnable r3) {
            super(r1);
            this.f17462i = r3;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f17462i.run();
        }

        @Override // h.a.i1.c
        public String toString() {
            return kotlin.n0.d.o.m(super.toString(), this.f17462i);
        }
    }

    @Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\b \u0018\u00002\u00060\u0001j\u0002`\u00022\b\u0012\u0004\u0012\u00020\u00000\u00032\u00020\u00042\u00020\u0005B\r\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0011\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u0000H\u0096\u0002J\u0006\u0010\u001a\u001a\u00020\u001bJ\u001e\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!J\u000e\u0010\"\u001a\u00020#2\u0006\u0010\u001d\u001a\u00020\u0007J\b\u0010$\u001a\u00020%H\u0016R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R0\u0010\r\u001a\b\u0012\u0002\b\u0003\u0018\u00010\f2\f\u0010\u000b\u001a\b\u0012\u0002\b\u0003\u0018\u00010\f8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0012\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lkotlinx/coroutines/EventLoopImplBase$DelayedTask;", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "", "Lkotlinx/coroutines/DisposableHandle;", "Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "nanoTime", "", "(J)V", "_heap", "", "value", "Lkotlinx/coroutines/internal/ThreadSafeHeap;", "heap", "getHeap", "()Lkotlinx/coroutines/internal/ThreadSafeHeap;", "setHeap", "(Lkotlinx/coroutines/internal/ThreadSafeHeap;)V", "index", "", "getIndex", "()I", "setIndex", "(I)V", "compareTo", "other", "dispose", "", "scheduleTask", "now", "delayed", "Lkotlinx/coroutines/EventLoopImplBase$DelayedTaskQueue;", "eventLoop", "Lkotlinx/coroutines/EventLoopImplBase;", "timeToExecute", "", "toString", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static abstract class c implements Runnable, Comparable<c>, d1, h.a.f3.n0 {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public long f17463f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private Object f17464g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private int f17465h;

        public c(long r1) {
            this.f17463f = r1;
            this.f17465h = -1;
        }

        @Override // h.a.f3.n0
        public void a(h.a.f3.m0<?> r3) {
            if (this.f17464g == l1.b()) goto L5;
            boolean r0 = true;
        L6:
            if (r0 == false) goto L10;
            this.f17464g = r3;
            return;
        L10:
            throw new IllegalArgumentException("Failed requirement.".toString());
        L5:
            r0 = false;
            goto L6
        }

        @Override // h.a.f3.n0
        public h.a.f3.m0<?> b() {
            Object r1 = this.f17464g;
            if ((r1 instanceof h.a.f3.m0) == true) goto L7;
            return null;
        L7:
            return (h.a.f3.m0) r1;
        }

        @Override // java.lang.Comparable
        public /* bridge */ /* synthetic */ int compareTo(c r1) {
            return k(r1);
        }

        @Override // h.a.d1
        public final synchronized void dispose() {
            monitor-enter(this);
            Object r0 = this.f17464g;     // Catch: Throwable -> L17
            if (r0 != l1.b()) goto L8;
            monitor-exit(this);
            return;
        L8:
            if ((r0 instanceof d) == false) goto L10;
            d r1 = (d) r0;     // Catch: Throwable -> L17
        L11:
            if (r1 == null) goto L14;
            r1.g(this);     // Catch: Throwable -> L17
        L14:
            this.f17464g = l1.b();     // Catch: Throwable -> L17
            monitor-exit(this);
            return;
        L10:
            r1 = null;
        L17:
            th = move-exception;
            throw th;
        }

        @Override // h.a.f3.n0
        public void g(int r1) {
            this.f17465h = r1;
        }

        @Override // h.a.f3.n0
        public int j() {
            return this.f17465h;
        }

        public int k(c r3) {
            long r0 = this.f17463f - r3.f17463f;
            if (r0 <= 0) goto L5;
            return 1;
        L5:
            if (r0 >= 0) goto L7;
            return -1;
        L7:
            return 0;
        }

        public final synchronized int l(long r8, d r10, i1 r11) {
            monitor-enter(this);
        L34:
            th = move-exception;
            throw th;
        L4:
            if (this.f17464g != l1.b()) goto L8;
            int r9 = 2;
        L6:
            monitor-exit(this);
            return r9;
        L8:
            monitor-enter(r10);     // Catch: Throwable -> L34
            c r0 = r10.b();     // Catch: Throwable -> L31
            if (i1.w0(r11) == false) goto L16;
            monitor-exit(r10);     // Catch: Throwable -> L34
            monitor-exit(this);
            return 1;
        L16:
            if (r0 != null) goto L18;
        L17:
            r10.f17466b = r8;     // Catch: Throwable -> L31
        L25:
            long r12 = this.f17463f;     // Catch: Throwable -> L31
            long r3 = r10.f17466b;     // Catch: Throwable -> L31
            if ((r12 - r3) >= 0) goto L28;
            this.f17463f = r3;     // Catch: Throwable -> L31
        L28:
            r10.a(this);     // Catch: Throwable -> L31
            monitor-exit(r10);     // Catch: Throwable -> L34
            r9 = 0;
            goto L6
        L18:
            long r4 = r0.f17463f;     // Catch: Throwable -> L31
            if ((r4 - r8) >= 0) goto L23;
            r8 = r4;
        L23:
            if ((r8 - r10.f17466b) <= 0) goto L25;
        L31:
            th = move-exception;
            throw th;     // Catch: Throwable -> L34
        }

        public final boolean m(long r3) {
            if ((r3 - this.f17463f) < 0) goto L5;
            return true;
        L5:
            return false;
        }

        public String toString() {
            return "Delayed[nanos=" + this.f17463f + ']';
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005R\u0012\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lkotlinx/coroutines/EventLoopImplBase$DelayedTaskQueue;", "Lkotlinx/coroutines/internal/ThreadSafeHeap;", "Lkotlinx/coroutines/EventLoopImplBase$DelayedTask;", "timeNow", "", "(J)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class d extends h.a.f3.m0<c> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f17466b;

        public d(long r1) {
            this.f17466b = r1;
        }
    }

    static {
        f17458i = AtomicReferenceFieldUpdater.newUpdater(i1.class, Object.class, "_queue");
        f17459j = AtomicReferenceFieldUpdater.newUpdater(i1.class, Object.class, "_delayed");
    }

    public i1() {
        this._queue = null;
        this._delayed = null;
        this._isCompleted = 0;
    }

    private final boolean A0(Runnable r6) {
    L2:
        Object r0 = this._queue;
        if (B0() == true) goto L4;
        if (r0 == null) goto L8;
        if ((r0 instanceof h.a.f3.u) == true) goto L12;
        if (r0 == l1.a()) goto L23;
        h.a.f3.u r2 = new h.a.f3.u(8, true);
        Objects.requireNonNull(r0, "null cannot be cast to non-null type java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }");
        r2.a((Runnable) r0);
        r2.a(r6);
        if (f17458i.compareAndSet(this, r0, r2) == false) goto L2;
        return true;
    L23:
        return false;
    L12:
        Objects.requireNonNull(r0, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeTaskQueueCore<java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }>{ kotlinx.coroutines.EventLoop_commonKt.Queue<java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }> }");
        h.a.f3.u r3 = (h.a.f3.u) r0;
        int r4 = r3.a(r6);
        if (r4 == 0) goto L20;
        if (r4 != 1) goto L16;
        f17458i.compareAndSet(this, r0, r3.i());
        goto L2
    L16:
        if (r4 != 2) goto L2;
        return false;
    L20:
        return true;
    L8:
        if (f17458i.compareAndSet(this, null, r6) == false) goto L2;
        return true;
    L4:
        return false;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [boolean, int] */
    private final boolean B0() {
        return this._isCompleted;
    }

    private final void D0() {
        h.a.b r0 = h.a.c.a();
        if (r0 != null) goto L5;
        Long r1 = null;
    L6:
        if (r1 != null) goto L8;
        long r2 = System.nanoTime();
    L9:
        d r3 = (d) this._delayed;
        if (r3 != null) goto L12;
        c r4 = null;
    L13:
        if (r4 == null) goto L14;
        u0(r2, r4);
        goto L9
    L14:
        return;
    L12:
        r4 = r3.i();
        goto L13
    L8:
        r2 = r1.longValue();
        goto L9
    L5:
        r1 = Long.valueOf(r0.a());
        goto L6
    }

    private final int G0(long r4, c r6) {
        if (B0() == false) goto L6;
        return 1;
    L6:
        d r0 = (d) this._delayed;
        if (r0 != null) goto L10;
        f17459j.compareAndSet(this, null, new d(r4));
        Object r1 = this._delayed;
        kotlin.n0.d.o.c(r1);
        r0 = (d) r1;
    L10:
        return r6.l(r4, r0, this);
    }

    private final void I0(boolean r1) {
        this._isCompleted = r1 ? 1 : 0;
    }

    private final boolean J0(c r1) {
        d r0 = (d) this._delayed;
        if (r0 != null) goto L5;
        c r2 = null;
    L6:
        if (r2 != r1) goto L8;
        return true;
    L8:
        return false;
    L5:
        r2 = r0.e();
        goto L6
    }

    public static final /* synthetic */ boolean w0(i1 r0) {
        return r0.B0();
    }

    private final void x0() {
        if (q0.a() == false) goto L9;
        if (B0() == true) goto L9;
        throw new AssertionError();
    L9:
        Object r0 = this._queue;
        if (r0 == null) goto L12;
        if ((r0 instanceof h.a.f3.u) == true) goto L16;
        if (r0 == l1.a()) goto L20;
        h.a.f3.u r1 = new h.a.f3.u(8, true);
        Objects.requireNonNull(r0, "null cannot be cast to non-null type java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }");
        r1.a((Runnable) r0);
        if (f17458i.compareAndSet(this, r0, r1) == false) goto L9;
        return;
    L20:
        return;
    L16:
        ((h.a.f3.u) r0).d();
        return;
    L12:
        if (f17458i.compareAndSet(this, null, l1.a()) == false) goto L9;
    }

    private final Runnable y0() {
    L2:
        Object r0 = this._queue;
        if (r0 == null) goto L4;
        if ((r0 instanceof h.a.f3.u) == true) goto L7;
        if (r0 == l1.a()) goto L14;
        if (f17458i.compareAndSet(this, r0, null) == false) goto L2;
        Objects.requireNonNull(r0, "null cannot be cast to non-null type java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }");
        return (Runnable) r0;
    L14:
        return null;
    L7:
        Objects.requireNonNull(r0, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeTaskQueueCore<java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }>{ kotlinx.coroutines.EventLoop_commonKt.Queue<java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }> }");
        h.a.f3.u r1 = (h.a.f3.u) r0;
        Object r2 = r1.j();
        if (r2 != h.a.f3.u.f17421h) goto L10;
        f17458i.compareAndSet(this, r0, r1.i());
        goto L2
    L10:
        return (Runnable) r2;
    L4:
        return null;
    }

    protected boolean C0() {
        if (p0() == true) goto L5;
        return false;
    L5:
        d r0 = (d) this._delayed;
        if (r0 != null) goto L8;
    L10:
        Object r3 = this._queue;
        if (r3 != null) goto L14;
    L19:
        return true;
    L14:
        if ((r3 instanceof h.a.f3.u) == false) goto L17;
        return ((h.a.f3.u) r3).g();
    L17:
        if (r3 == l1.a()) goto L19;
        return false;
    L8:
        if (r0.d() == true) goto L10;
        return false;
    }

    protected final void E0() {
        this._queue = null;
        this._delayed = null;
    }

    public final void F0(long r3, c r5) {
        int r0 = G0(r3, r5);
        if (r0 == 0) goto L13;
        if (r0 != 1) goto L7;
        u0(r3, r5);
        return;
    L7:
        if (r0 != 2) goto L10;
        return;
    L10:
        throw new IllegalStateException("unexpected result".toString());
    L13:
        if (J0(r5) == false) goto L17;
        v0();
        return;
    }

    protected final d1 H0(long r4, Runnable r6) {
        long r5 = l1.c(r4);
        if (r5 >= 4611686018427387903L) goto L13;
        h.a.b r0 = h.a.c.a();
        if (r0 != null) goto L7;
        Long r1 = null;
    L8:
        if (r1 != null) goto L10;
        long r2 = System.nanoTime();
    L11:
        b r3 = new b(r5 + r2, r6);
        F0(r2, r3);
        return r3;
    L10:
        r2 = r1.longValue();
        goto L11
    L7:
        r1 = Long.valueOf(r0.a());
        goto L8
    L13:
        return k2.f17534f;
    }

    @Override // h.a.u0
    public d1 M(long r1, Runnable r3, kotlin.k0.g r4) {
        return u0.a.a(this, r1, r3, r4);
    }

    @Override // h.a.g0
    public final void dispatch(kotlin.k0.g r1, Runnable r2) {
        z0(r2);
    }

    @Override // h.a.u0
    public void l(long r4, n<? super kotlin.f0> r6) {
        long r5 = l1.c(r4);
        if (r5 >= 4611686018427387903L) goto L13;
        h.a.b r0 = h.a.c.a();
        if (r0 != null) goto L7;
        Long r1 = null;
    L8:
        if (r1 != null) goto L10;
        long r2 = System.nanoTime();
    L11:
        a r3 = new a(this, r5 + r2, r6);
        q.a(r6, r3);
        F0(r2, r3);
        return;
    L10:
        r2 = r1.longValue();
        goto L11
    L7:
        r1 = Long.valueOf(r0.a());
        goto L8
    }

    @Override // h.a.h1
    protected long l0() {
        if (super.l0() != 0) goto L5;
        return 0;
    L5:
        Object r0 = this._queue;
        if (r0 != null) goto L9;
    L13:
        d r6 = (d) this._delayed;
        Long r1 = null;
        if (r6 != null) goto L16;
        c r7 = null;
    L17:
        if (r7 != null) goto L19;
        return LocationRequestCompat.PASSIVE_INTERVAL;
    L19:
        long r4 = r7.f17463f;
        h.a.b r8 = h.a.c.a();
        if (r8 == null) goto L23;
        r1 = Long.valueOf(r8.a());
    L23:
        if (r1 != null) goto L25;
        long r2 = System.nanoTime();
    L27:
        return kotlin.r0.e.d(r4 - r2, 0);
    L25:
        r2 = r1.longValue();
        goto L27
    L16:
        r7 = r6.e();
        goto L17
    L9:
        if ((r0 instanceof h.a.f3.u) == false) goto L29;
        if (((h.a.f3.u) r0).g() == true) goto L13;
        return 0;
    L29:
        if (r0 != l1.a()) goto L31;
        return LocationRequestCompat.PASSIVE_INTERVAL;
    L31:
        return 0;
    }

    @Override // h.a.h1
    public long q0() {
        if (r0() == false) goto L5;
        return 0;
    L5:
        d r0 = (d) this._delayed;
        if (r0 != null) goto L8;
    L36:
        Runnable r1 = y0();
        if (r1 == null) goto L41;
        r1.run();
        return 0;
    L41:
        return l0();
    L8:
        if (r0.d() == true) goto L36;
        h.a.b r3 = h.a.c.a();
        if (r3 != null) goto L12;
        Long r4 = null;
    L13:
        if (r4 != null) goto L15;
        long r5 = System.nanoTime();
    L16:
        monitor-enter(r0);
        c r6 = r0.b();     // Catch: Throwable -> L33
        if (r6 != null) goto L21;
        monitor-exit(r0);
        c r7 = null;
    L31:
        if (r7 != null) goto L16;
    L21:
        c r8 = r6;     // Catch: Throwable -> L33
        if (r8.m(r5) == false) goto L24;
        boolean r9 = A0(r8);     // Catch: Throwable -> L33
    L25:
        if (r9 == false) goto L28;
        r7 = r0.h(0);     // Catch: Throwable -> L33
    L29:
        monitor-exit(r0);
        goto L31
    L28:
        r7 = null;
        goto L29
    L24:
        r9 = false;
    L33:
        th = move-exception;
        throw th;
    L15:
        r5 = r4.longValue();
        goto L16
    L12:
        r4 = Long.valueOf(r3.a());
        goto L13
    }

    @Override // h.a.h1
    public void shutdown() {
        v2.f17573a.c();
        I0(true);
        x0();
    L4:
        if (q0() <= 0) goto L4;
        D0();
    }

    public void z0(Runnable r2) {
        if (A0(r2) == false) goto L5;
        v0();
        return;
    L5:
        s0.f17564k.z0(r2);
    }
}
