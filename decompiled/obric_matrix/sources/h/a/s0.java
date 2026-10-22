package h.a;

import androidx.core.location.LocationRequestCompat;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\bÀ\u0002\u0018\u00002\u00020\u00012\u00060\u0002j\u0002`\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0004J\b\u0010\u001d\u001a\u00020\u001eH\u0002J\b\u0010\u001f\u001a\u00020\u0011H\u0002J\u0014\u0010 \u001a\u00020\u001e2\n\u0010!\u001a\u00060\u0002j\u0002`\u0003H\u0016J\r\u0010\"\u001a\u00020\u001eH\u0000¢\u0006\u0002\b#J$\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\b2\n\u0010'\u001a\u00060\u0002j\u0002`\u00032\u0006\u0010(\u001a\u00020)H\u0016J\b\u0010*\u001a\u00020\u0015H\u0002J\u0018\u0010+\u001a\u00020\u001e2\u0006\u0010,\u001a\u00020\b2\u0006\u0010-\u001a\u00020.H\u0014J\b\u0010/\u001a\u00020\u001eH\u0016J\b\u00100\u001a\u00020\u001eH\u0016J\b\u00101\u001a\u00020\u001eH\u0002J\u000e\u00102\u001a\u00020\u001e2\u0006\u00103\u001a\u00020\bR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0086T¢\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\b\n\u0000\u0012\u0004\b\u0012\u0010\u0004R\u000e\u0010\u0013\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\u00020\u00158BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0016R\u0014\u0010\u0017\u001a\u00020\u00158BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0016R\u0014\u0010\u0018\u001a\u00020\u00158@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0016R\u0014\u0010\u001a\u001a\u00020\u00118TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001c¨\u00064"}, d2 = {"Lkotlinx/coroutines/DefaultExecutor;", "Lkotlinx/coroutines/EventLoopImplBase;", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "()V", "ACTIVE", "", "DEFAULT_KEEP_ALIVE_MS", "", "FRESH", "KEEP_ALIVE_NANOS", "SHUTDOWN", "SHUTDOWN_ACK", "SHUTDOWN_REQ", "THREAD_NAME", "", "_thread", "Ljava/lang/Thread;", "get_thread$annotations", "debugStatus", "isShutDown", "", "()Z", "isShutdownRequested", "isThreadPresent", "isThreadPresent$kotlinx_coroutines_core", "thread", "getThread", "()Ljava/lang/Thread;", "acknowledgeShutdownIfNeeded", "", "createThreadSync", "enqueue", "task", "ensureStarted", "ensureStarted$kotlinx_coroutines_core", "invokeOnTimeout", "Lkotlinx/coroutines/DisposableHandle;", "timeMillis", "block", "context", "Lkotlin/coroutines/CoroutineContext;", "notifyStartup", "reschedule", "now", "delayedTask", "Lkotlinx/coroutines/EventLoopImplBase$DelayedTask;", "run", "shutdown", "shutdownError", "shutdownForTests", LocationMonitorConst.TIMEOUT, "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class s0 extends i1 implements Runnable {
    private static volatile Thread _thread;
    private static volatile int debugStatus;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final s0 f17564k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final long f17565l = 0;

    static {
        s0 r0 = new s0();
        f17564k = r0;
        h1.n0(r0, false, 1, null);
        TimeUnit r1 = TimeUnit.MILLISECONDS;
        Long r2 = Long.getLong("kotlinx.coroutines.DefaultExecutor.keepAlive", 1000);     // Catch: SecurityException -> L5
    L6:
        f17565l = r1.toNanos(r2.longValue());
        return;
    L5:
        r2 = 1000L;
        goto L6
    }

    private s0() {
    }

    private final synchronized void K0() {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (N0() == true) goto L8;
        monitor-exit(this);
        return;
    L8:
        debugStatus = 3;     // Catch: Throwable -> L11
        E0();     // Catch: Throwable -> L11
        notifyAll();     // Catch: Throwable -> L11
        monitor-exit(this);
    }

    private final synchronized Thread L0() {
        monitor-enter(this);
        Thread r0 = _thread;     // Catch: Throwable -> L8
        if (r0 != null) goto L6;
        r0 = new Thread(this, "kotlinx.coroutines.DefaultExecutor");     // Catch: Throwable -> L8
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

    private final boolean M0() {
        if (debugStatus != 4) goto L5;
        return true;
    L5:
        return false;
    }

    private final boolean N0() {
        int r1 = debugStatus;
        if (r1 != 2) goto L5;
    L8:
        return true;
    L5:
        if (r1 == 3) goto L8;
        return false;
    }

    private final synchronized boolean O0() {
        monitor-enter(this);
    L12:
        th = move-exception;
        throw th;
    L4:
        if (N0() == false) goto L9;
        monitor-exit(this);
        return false;
    L9:
        debugStatus = 1;     // Catch: Throwable -> L12
        notifyAll();     // Catch: Throwable -> L12
        monitor-exit(this);
        return true;
    }

    private final void P0() {
        throw new RejectedExecutionException("DefaultExecutor was shut down. This error indicates that Dispatchers.shutdown() was invoked prior to completion of exiting coroutines, leaving coroutines in incomplete state. Please refer to Dispatchers.shutdown documentation for more details");
    }

    @Override // h.a.i1, h.a.u0
    public d1 M(long r1, Runnable r3, kotlin.k0.g r4) {
        return H0(r1, r3);
    }

    @Override // java.lang.Runnable
    public void run() {
        v2.f17573a.d(this);
        b r0 = c.a();
        if (r0 == null) goto L71;
        r0.c();
    L71:
    L62:
        th = move-exception;
        _thread = null;
        K0();
        b r1 = c.a();
        if (r1 == null) goto L68;
        r1.g();
    L68:
        if (C0() == true) goto L70;
        t0();
    L70:
        throw th;
    L8:
        if (O0() == true) goto L17;
        _thread = null;
        K0();
        b r2 = c.a();
        if (r2 == null) goto L14;
        r2.g();
    L14:
        if (C0() == true) goto L81;
        t0();
        return;
    L81:
        return;
    L17:
        long r3 = Long.MAX_VALUE;
    L18:
        Thread.interrupted();     // Catch: Throwable -> L62
        long r5 = q0();     // Catch: Throwable -> L62
        if (r5 != LocationRequestCompat.PASSIVE_INTERVAL) goto L42;
        b r7 = c.a();     // Catch: Throwable -> L62
        if (r7 != null) goto L23;
        Long r8 = null;
    L24:
        if (r8 != null) goto L26;
        long r10 = System.nanoTime();     // Catch: Throwable -> L62
    L28:
        if (r3 == LocationRequestCompat.PASSIVE_INTERVAL) goto L30;
    L31:
        long r11 = r3 - r10;
        if (r11 <= 0) goto L33;
        r5 = kotlin.r0.e.g(r5, r11);     // Catch: Throwable -> L62
    L44:
        if (r5 <= 0) goto L18;
        if (N0() == true) goto L47;
        b r9 = c.a();     // Catch: Throwable -> L62
        if (r9 != null) goto L58;
        kotlin.f0 r12 = null;
    L59:
        if (r12 != null) goto L18;
        LockSupport.parkNanos(this, r5);     // Catch: Throwable -> L62
        goto L18
    L58:
        r9.b(this, r5);     // Catch: Throwable -> L62
        r12 = kotlin.f0.f18324a;     // Catch: Throwable -> L62
        goto L59
    L47:
        _thread = null;
        K0();
        b r4 = c.a();
        if (r4 == null) goto L52;
        r4.g();
    L52:
        if (C0() == true) goto L83;
        t0();
        return;
    L83:
        return;
    L33:
        _thread = null;
        K0();
        b r6 = c.a();
        if (r6 == null) goto L38;
        r6.g();
    L38:
        if (C0() == true) goto L82;
        t0();
        return;
    L82:
        return;
    L30:
        r3 = f17565l + r10;
        goto L31
    L26:
        r10 = r8.longValue();     // Catch: Throwable -> L62
        goto L28
    L23:
        r8 = Long.valueOf(r7.a());     // Catch: Throwable -> L62
        goto L24
    L42:
        r3 = Long.MAX_VALUE;
        goto L44
    }

    @Override // h.a.i1, h.a.h1
    public void shutdown() {
        debugStatus = 4;
        super.shutdown();
    }

    @Override // h.a.j1
    protected Thread t0() {
        Thread r0 = _thread;
        if (r0 == null) goto L5;
        return r0;
    L5:
        return L0();
    }

    @Override // h.a.j1
    protected void u0(long r1, i1.c r3) {
        P0();
        throw null;
    }

    @Override // h.a.i1
    public void z0(Runnable r2) {
        if (M0() == true) goto L6;
        super.z0(r2);
        return;
    L6:
        P0();
        throw null;
    }
}
