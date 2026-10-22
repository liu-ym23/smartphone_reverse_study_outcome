package kotlinx.coroutines;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class DefaultExecutor extends EventLoopImplBase implements Runnable {
    private static volatile Thread _thread;
    private static volatile int debugStatus;
    public static final long l = 0;
    public static final DefaultExecutor m = null;

    static {
        DefaultExecutor r0 = new DefaultExecutor();
        m = r0;
        r0.s(false);
        TimeUnit r1 = TimeUnit.MILLISECONDS;
        Long r2 = Long.getLong("kotlinx.coroutines.DefaultExecutor.keepAlive", 1000);     // Catch: SecurityException -> L5
    L6:
        l = r1.toNanos(r2.longValue());
        return;
    L5:
        r2 = 1000L;
        goto L6
    }

    public final synchronized void L() {
        monitor-enter(this);
        int r0 = debugStatus;     // Catch: Throwable -> L16
        if (r0 == 2) goto L9;
        if (r0 == 3) goto L9;
        boolean r1 = false;
    L10:
        if (r1 == true) goto L13;
        monitor-exit(this);
        return;
    L13:
        debugStatus = 3;     // Catch: Throwable -> L16
        I();     // Catch: Throwable -> L16
        notifyAll();     // Catch: Throwable -> L16
        monitor-exit(this);
        return;
    L9:
        r1 = true;
    L16:
        th = move-exception;
        throw th;
    }

    @Override // kotlinx.coroutines.EventLoopImplBase, kotlinx.coroutines.Delay
    public final DisposableHandle h(long r3, Runnable r5, CoroutineContext r6) {
        long r4 = EventLoop_commonKt.a(r3);
        if (r4 >= 4611686018427387903L) goto L6;
        long r0 = System.nanoTime();
        EventLoopImplBase.DelayedRunnableTask r7 = new EventLoopImplBase.DelayedRunnableTask(r5, r4 + r0);
        J(r0, r7);
        return r7;
    L6:
        return NonDisposableHandle.b;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ThreadLocalEventLoop.f379a.set(this);
        monitor-enter(this);     // Catch: Throwable -> L26
        int r0 = debugStatus;     // Catch: Throwable -> L53
        if (r0 == 2) goto L10;
        if (r0 == 3) goto L10;
        boolean r1 = false;
    L11:
        if (r1 == false) goto L17;
        monitor-exit(this);     // Catch: Throwable -> L26
        _thread = null;
        L();
        if (E() == true) goto L69;
        x();
        return;
    L69:
        return;
    L17:
        debugStatus = 1;     // Catch: Throwable -> L53
        notifyAll();     // Catch: Throwable -> L53
        monitor-exit(this);     // Catch: Throwable -> L26
        long r9 = Long.MAX_VALUE;
    L20:
        Thread.interrupted();     // Catch: Throwable -> L26
        long r11 = G();     // Catch: Throwable -> L26
        if (r11 != Long.MAX_VALUE) goto L37;
        long r15 = System.nanoTime();     // Catch: Throwable -> L26
        if (r9 == Long.MAX_VALUE) goto L25;
    L28:
        long r16 = r9 - r15;
        if (r16 <= 0) goto L30;
        if (r11 <= r16) goto L39;
        r11 = r16;
    L39:
        if (r11 <= 0) goto L20;
        int r2 = debugStatus;     // Catch: Throwable -> L26
        if (r2 == 2) goto L45;
        if (r2 == 3) goto L45;
        boolean r3 = false;
    L46:
        if (r3 == true) goto L47;
        LockSupport.parkNanos(this, r11);     // Catch: Throwable -> L26
        goto L20
    L47:
        _thread = null;
        L();
        if (E() == true) goto L71;
        x();
        return;
    L71:
        return;
    L45:
        r3 = true;
        goto L46
    L30:
        _thread = null;
        L();
        if (E() == true) goto L70;
        x();
        return;
    L70:
        return;
    L25:
        r9 = l + r15;
        goto L28
    L37:
        r9 = Long.MAX_VALUE;
        goto L39
    L10:
        r1 = true;
    L53:
        th = move-exception;
        throw th;     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        _thread = null;
        L();
        if (E() == true) goto L59;
        x();
    L59:
        throw th;
    }

    @Override // kotlinx.coroutines.EventLoopImplPlatform
    public final Thread x() {
        Thread r0 = _thread;
        if (r0 != null) goto L11;
        monitor-enter(this);
        r0 = _thread;     // Catch: Throwable -> L12
        if (r0 != null) goto L10;
        r0 = new Thread(this, "kotlinx.coroutines.DefaultExecutor");     // Catch: Throwable -> L12
        _thread = r0;     // Catch: Throwable -> L12
        r0.setDaemon(true);     // Catch: Throwable -> L12
        r0.start();     // Catch: Throwable -> L12
    L10:
        monitor-exit(this);
    L12:
        th = move-exception;
        throw th;
    L11:
        return r0;
    }
}
