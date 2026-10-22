package kotlinx.coroutines;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class CommonPool extends ExecutorCoroutineDispatcher {
    public static final int e = 0;
    public static final CommonPool f = null;
    private static volatile Executor pool;

    static {
        f = new CommonPool();
        String r0 = System.getProperty("kotlinx.coroutines.default.parallelism");     // Catch: Throwable -> L5
    L6:
        if (r0 == null) goto L14;
        Integer r1 = StringsKt.I(r0);
        if (r1 == null) goto L13;
        if (r1.intValue() < 1) goto L13;
        int r2 = r1.intValue();
    L15:
        e = r2;
        return;
    L13:
        throw new IllegalStateException("Expected positive number in kotlinx.coroutines.default.parallelism, but has ".concat(r0).toString());
    L14:
        r2 = -1;
    L5:
        r0 = null;
        goto L6
    }

    public static ExecutorService m() {
        final AtomicInteger r0 = new AtomicInteger();
        return Executors.newFixedThreadPool(s(), new CommonPool$createPlainPool$1(r0));
    }

    public static ExecutorService n() {
        if (System.getSecurityManager() != null) goto L5;
        ExecutorService r0 = null;
        Class<?> r1 = Class.forName("java.util.concurrent.ForkJoinPool");     // Catch: Throwable -> L9
    L10:
        if (r1 == null) goto L48;
        int r2 = e;
        CommonPool r3 = f;
        if (r2 >= 0) goto L52;
        Method r4 = r1.getMethod("commonPool", null);     // Catch: Throwable -> L22
        if (r4 == null) goto L16;
        Object r5 = r4.invoke(null, null);     // Catch: Throwable -> L22
    L18:
        if ((r5 instanceof ExecutorService) == true) goto L20;
        r5 = null;
    L20:
        ExecutorService r6 = (ExecutorService) r5;     // Catch: Throwable -> L22
    L23:
        if (r6 == null) goto L52;
        r3.getClass();
        r6.submit(CommonPool$isGoodCommonPool$1.b);
        Object r7 = r1.getMethod("getPoolSize", null).invoke(r6, null);     // Catch: Throwable -> L30
        if ((r7 instanceof Integer) == true) goto L28;
        r7 = null;
    L28:
        Integer r8 = (Integer) r7;     // Catch: Throwable -> L30
    L31:
        if (r8 != null) goto L33;
    L35:
        r6 = null;
    L36:
        if (r6 == null) goto L52;
        return r6;
    L33:
        if (r8.intValue() < 1) goto L35;
    L30:
        r8 = null;
        goto L31
    L16:
        r5 = null;
    L22:
        r6 = null;
    L52:
        Constructor<?> r9 = r1.getConstructor(new Class[]{Integer.TYPE});     // Catch: Throwable -> L49
        r3.getClass();     // Catch: Throwable -> L49
        Object r10 = r9.newInstance(new Object[]{Integer.valueOf(s())});     // Catch: Throwable -> L49
        if ((r10 instanceof ExecutorService) == true) goto L41;
        r10 = null;
    L41:
        r0 = (ExecutorService) r10;     // Catch: Throwable -> L49
    L43:
        if (r0 == null) goto L46;
        return r0;
    L46:
        return m();
    L48:
        return m();
    L9:
        r1 = null;
        goto L10
    L5:
        return m();
    }

    public static int s() {
        int r0 = e;
        Integer r1 = Integer.valueOf(r0);
        if (r0 > 0) goto L6;
        r1 = null;
    L6:
        if (r1 != null) goto L12;
        int r2 = Runtime.getRuntime().availableProcessors() - 1;
        if (r2 < 1) goto L11;
        return r2;
    L11:
        return 1;
    L12:
        return r1.intValue();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        throw new IllegalStateException("Close cannot be invoked on CommonPool".toString());
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public final void j(CoroutineContext r1, Runnable r2) {
        Executor r3 = pool;     // Catch: RejectedExecutionException -> L16
        if (r3 != null) goto L11;
        monitor-enter(this);     // Catch: RejectedExecutionException -> L16
        r3 = pool;     // Catch: Throwable -> L13
        if (r3 != null) goto L10;
        r3 = n();     // Catch: Throwable -> L13
        pool = r3;     // Catch: Throwable -> L13
    L10:
        monitor-exit(this);     // Catch: RejectedExecutionException -> L16
    L13:
        th = move-exception;
        throw th;     // Catch: RejectedExecutionException -> L16
    L11:
        r3.execute(r2);     // Catch: RejectedExecutionException -> L16
        return;
    L16:
        DefaultExecutor.m.A(r2);
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public final String toString() {
        return "CommonPool";
    }
}
