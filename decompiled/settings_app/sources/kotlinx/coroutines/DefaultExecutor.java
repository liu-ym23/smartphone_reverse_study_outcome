package kotlinx.coroutines;

import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: DefaultExecutor.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\bÀ\u0002\u0018\u00002\u00020\u00012\u00060\u0002j\u0002`\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0004J\b\u0010\u001d\u001a\u00020\u001eH\u0002J\b\u0010\u001f\u001a\u00020\u0011H\u0002J\u0014\u0010 \u001a\u00020\u001e2\n\u0010!\u001a\u00060\u0002j\u0002`\u0003H\u0016J\r\u0010\"\u001a\u00020\u001eH\u0000¢\u0006\u0002\b#J$\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\b2\n\u0010'\u001a\u00060\u0002j\u0002`\u00032\u0006\u0010(\u001a\u00020)H\u0016J\b\u0010*\u001a\u00020\u0015H\u0002J\u0018\u0010+\u001a\u00020\u001e2\u0006\u0010,\u001a\u00020\b2\u0006\u0010-\u001a\u00020.H\u0014J\b\u0010/\u001a\u00020\u001eH\u0016J\b\u00100\u001a\u00020\u001eH\u0016J\b\u00101\u001a\u00020\u001eH\u0002J\u000e\u00102\u001a\u00020\u001e2\u0006\u00103\u001a\u00020\bR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0086T¢\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\b\n\u0000\u0012\u0004\b\u0012\u0010\u0004R\u000e\u0010\u0013\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\u00020\u00158BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0016R\u0014\u0010\u0017\u001a\u00020\u00158BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0016R\u0014\u0010\u0018\u001a\u00020\u00158@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0016R\u0014\u0010\u001a\u001a\u00020\u00118TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001c¨\u00064"}, d2 = {"Lkotlinx/coroutines/DefaultExecutor;", "Lkotlinx/coroutines/EventLoopImplBase;", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "()V", "ACTIVE", "", "DEFAULT_KEEP_ALIVE_MS", "", "FRESH", "KEEP_ALIVE_NANOS", "SHUTDOWN", "SHUTDOWN_ACK", "SHUTDOWN_REQ", "THREAD_NAME", "", "_thread", "Ljava/lang/Thread;", "get_thread$annotations", "debugStatus", "isShutDown", "", "()Z", "isShutdownRequested", "isThreadPresent", "isThreadPresent$kotlinx_coroutines_core", "thread", "getThread", "()Ljava/lang/Thread;", "acknowledgeShutdownIfNeeded", "", "createThreadSync", "enqueue", "task", "ensureStarted", "ensureStarted$kotlinx_coroutines_core", "invokeOnTimeout", "Lkotlinx/coroutines/DisposableHandle;", "timeMillis", "block", "context", "Lkotlin/coroutines/CoroutineContext;", "notifyStartup", "reschedule", "now", "delayedTask", "Lkotlinx/coroutines/EventLoopImplBase$DelayedTask;", "run", "shutdown", "shutdownError", "shutdownForTests", "timeout", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class DefaultExecutor extends EventLoopImplBase implements Runnable {
    private static final int ACTIVE = 1;
    private static final long DEFAULT_KEEP_ALIVE_MS = 1000;
    private static final int FRESH = 0;
    public static final DefaultExecutor INSTANCE = null;
    private static final long KEEP_ALIVE_NANOS = 0;
    private static final int SHUTDOWN = 4;
    private static final int SHUTDOWN_ACK = 3;
    private static final int SHUTDOWN_REQ = 2;
    public static final String THREAD_NAME = "kotlinx.coroutines.DefaultExecutor";
    private static volatile Thread _thread;
    private static volatile int debugStatus;

    private static /* synthetic */ void get_thread$annotations() {
    }

    private DefaultExecutor() {
    }

    static {
        DefaultExecutor r0 = new DefaultExecutor();
        INSTANCE = r0;
        EventLoop.incrementUseCount$default(r0, false, 1, null);
        TimeUnit r1 = TimeUnit.MILLISECONDS;
        Long r2 = Long.getLong("kotlinx.coroutines.DefaultExecutor.keepAlive", 1000);     // Catch: SecurityException -> L5
    L6:
        KEEP_ALIVE_NANOS = r1.toNanos(r2.longValue());
        return;
    L5:
        r2 = 1000L;
        goto L6
    }

    @Override // kotlinx.coroutines.EventLoopImplPlatform
    protected Thread getThread() {
        Thread r0 = _thread;
        if (r0 == null) goto L5;
        return r0;
    L5:
        return createThreadSync();
    }

    private final boolean isShutDown() {
        if (debugStatus != 4) goto L5;
        return true;
    L5:
        return false;
    }

    private final boolean isShutdownRequested() {
        int r1 = debugStatus;
        if (r1 != 2) goto L5;
    L8:
        return true;
    L5:
        if (r1 == 3) goto L8;
        return false;
    }

    @Override // kotlinx.coroutines.EventLoopImplBase
    public void enqueue(Runnable r2) {
        if (isShutDown() == false) goto L5;
        shutdownError();
    L5:
        super.enqueue(r2);
    }

    @Override // kotlinx.coroutines.EventLoopImplPlatform
    protected void reschedule(long r1, EventLoopImplBase.DelayedTask r3) {
        shutdownError();
    }

    private final void shutdownError() {
        throw new RejectedExecutionException("DefaultExecutor was shut down. This error indicates that Dispatchers.shutdown() was invoked prior to completion of exiting coroutines, leaving coroutines in incomplete state. Please refer to Dispatchers.shutdown documentation for more details");
    }

    @Override // kotlinx.coroutines.EventLoopImplBase, kotlinx.coroutines.EventLoop
    public void shutdown() {
        debugStatus = 4;
        super.shutdown();
    }

    @Override // kotlinx.coroutines.EventLoopImplBase, kotlinx.coroutines.Delay
    public DisposableHandle invokeOnTimeout(long r1, Runnable r3, CoroutineContext r4) {
        return scheduleInvokeOnTimeout(r1, r3);
    }

    @Override // java.lang.Runnable
    public void run() {
        ThreadLocalEventLoop.INSTANCE.setEventLoop$kotlinx_coroutines_core(this);
        AbstractTimeSource r0 = AbstractTimeSourceKt.getTimeSource();
        if (r0 == null) goto L63;
        r0.registerTimeLoopThread();
    L63:
    L55:
        th = move-exception;
        _thread = null;
        acknowledgeShutdownIfNeeded();
        AbstractTimeSource r1 = AbstractTimeSourceKt.getTimeSource();
        if (r1 == null) goto L60;
        r1.unregisterTimeLoopThread();
    L60:
        if (isEmpty() == true) goto L62;
        getThread();
    L62:
        throw th;
    L7:
        if (notifyStartup() == true) goto L15;
        _thread = null;
        acknowledgeShutdownIfNeeded();
        AbstractTimeSource r2 = AbstractTimeSourceKt.getTimeSource();
        if (r2 == null) goto L12;
        r2.unregisterTimeLoopThread();
    L12:
        if (isEmpty() == true) goto L73;
        getThread();
        return;
    L73:
        return;
    L15:
        long r3 = Long.MAX_VALUE;
    L16:
        Thread.interrupted();     // Catch: Throwable -> L55
        long r5 = processNextEvent();     // Catch: Throwable -> L55
        if (r5 != Long.MAX_VALUE) goto L36;
        AbstractTimeSource r7 = AbstractTimeSourceKt.getTimeSource();     // Catch: Throwable -> L55
        if (r7 == null) goto L21;
        long r10 = r7.nanoTime();     // Catch: Throwable -> L55
    L23:
        if (r3 == Long.MAX_VALUE) goto L25;
    L26:
        long r11 = r3 - r10;
        if (r11 <= 0) goto L28;
        r5 = RangesKt.coerceAtMost(r5, r11);     // Catch: Throwable -> L55
    L38:
        if (r5 <= 0) goto L16;
        if (isShutdownRequested() == true) goto L41;
        AbstractTimeSource r8 = AbstractTimeSourceKt.getTimeSource();     // Catch: Throwable -> L55
        if (r8 == null) goto L51;
        r8.parkNanos(this, r5);     // Catch: Throwable -> L55
        Unit r9 = Unit.INSTANCE;     // Catch: Throwable -> L55
    L52:
        if (r9 != null) goto L16;
        LockSupport.parkNanos(this, r5);     // Catch: Throwable -> L55
        goto L16
    L51:
        r9 = null;
        goto L52
    L41:
        _thread = null;
        acknowledgeShutdownIfNeeded();
        AbstractTimeSource r4 = AbstractTimeSourceKt.getTimeSource();
        if (r4 == null) goto L45;
        r4.unregisterTimeLoopThread();
    L45:
        if (isEmpty() == true) goto L75;
        getThread();
        return;
    L75:
        return;
    L28:
        _thread = null;
        acknowledgeShutdownIfNeeded();
        AbstractTimeSource r6 = AbstractTimeSourceKt.getTimeSource();
        if (r6 == null) goto L32;
        r6.unregisterTimeLoopThread();
    L32:
        if (isEmpty() == true) goto L74;
        getThread();
        return;
    L74:
        return;
    L25:
        r3 = KEEP_ALIVE_NANOS + r10;
        goto L26
    L21:
        r10 = System.nanoTime();     // Catch: Throwable -> L55
        goto L23
    L36:
        r3 = Long.MAX_VALUE;
        goto L38
    }

    private final synchronized Thread createThreadSync() {
        monitor-enter(this);
        Thread r0 = _thread;     // Catch: Throwable -> L8
        if (r0 != null) goto L6;
        r0 = new Thread(this, THREAD_NAME);     // Catch: Throwable -> L8
        _thread = r0;     // Catch: Throwable -> L8
        r0.setDaemon(true);     // Catch: Throwable -> L8
        r0.start();     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
        return r0;
    L8:
        th = move-exception;
        throw th;
    }

    public final synchronized void ensureStarted$kotlinx_coroutines_core() {
        monitor-enter(this);
        boolean r1 = true;
        if (DebugKt.getASSERTIONS_ENABLED() == false) goto L14;
        if (_thread != null) goto L8;
        boolean r0 = true;
    L9:
        if (r0 == true) goto L14;
        throw new AssertionError();     // Catch: Throwable -> L32
    L8:
        r0 = false;
    L14:
        if (DebugKt.getASSERTIONS_ENABLED() == true) goto L16;
    L25:
        debugStatus = 0;     // Catch: Throwable -> L32
        createThreadSync();     // Catch: Throwable -> L32
    L27:
        if (debugStatus != 0) goto L30;
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type java.lang.Object");     // Catch: Throwable -> L32
        wait();     // Catch: Throwable -> L32
        goto L27
    L30:
        monitor-exit(this);
        return;
    L16:
        if (debugStatus != 0) goto L18;
    L21:
        if (r1 == true) goto L25;
        throw new AssertionError();     // Catch: Throwable -> L32
    L18:
        if (debugStatus == 3) goto L21;
        r1 = false;
    L32:
        th = move-exception;
        throw th;
    }

    private final synchronized boolean notifyStartup() {
        monitor-enter(this);
    L12:
        th = move-exception;
        throw th;
    L4:
        if (isShutdownRequested() == false) goto L9;
        monitor-exit(this);
        return false;
    L9:
        debugStatus = 1;     // Catch: Throwable -> L12
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type java.lang.Object");     // Catch: Throwable -> L12
        notifyAll();     // Catch: Throwable -> L12
        monitor-exit(this);
        return true;
    }

    public final synchronized void shutdownForTests(long r7) {
        monitor-enter(this);
        long r0 = System.currentTimeMillis() + r7;     // Catch: Throwable -> L24
        if (isShutdownRequested() == true) goto L7;
        debugStatus = 2;     // Catch: Throwable -> L24
    L7:
        if (debugStatus == 3) goto L21;
        if (_thread == null) goto L21;
        Thread r2 = _thread;     // Catch: Throwable -> L24
        if (r2 == null) goto L19;
        AbstractTimeSource r3 = AbstractTimeSourceKt.getTimeSource();     // Catch: Throwable -> L24
        if (r3 == null) goto L15;
        r3.unpark(r2);     // Catch: Throwable -> L24
        Unit r4 = Unit.INSTANCE;     // Catch: Throwable -> L24
    L16:
        if (r4 != null) goto L19;
        LockSupport.unpark(r2);     // Catch: Throwable -> L24
        goto L19
    L15:
        r4 = null;
    L19:
        if ((r0 - System.currentTimeMillis()) <= 0) goto L21;
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type java.lang.Object");     // Catch: Throwable -> L24
        wait(r7);     // Catch: Throwable -> L24
    L21:
        debugStatus = 0;     // Catch: Throwable -> L24
        monitor-exit(this);
        return;
    L24:
        th = move-exception;
        throw th;
    }

    private final synchronized void acknowledgeShutdownIfNeeded() {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (isShutdownRequested() == true) goto L8;
        monitor-exit(this);
        return;
    L8:
        debugStatus = 3;     // Catch: Throwable -> L11
        resetAll();     // Catch: Throwable -> L11
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type java.lang.Object");     // Catch: Throwable -> L11
        notifyAll();     // Catch: Throwable -> L11
        monitor-exit(this);
    }

    public final boolean isThreadPresent$kotlinx_coroutines_core() {
        if (_thread == null) goto L5;
        return true;
    L5:
        return false;
    }
}
