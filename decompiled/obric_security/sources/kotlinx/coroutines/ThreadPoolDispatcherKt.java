package kotlinx.coroutines;

import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;

/* JADX INFO: compiled from: ThreadPoolDispatcher.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0007\u001a\u0010\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0005H\u0007¨\u0006\u0007"}, d2 = {"newFixedThreadPoolContext", "Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "nThreads", "", "name", "", "newSingleThreadContext", "kotlinx-coroutines-core"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class ThreadPoolDispatcherKt {
    /* JADX INFO: renamed from: $r8$lambda$IYX-93i18CF3E6e1K_suGGxRFcI, reason: not valid java name */
    public static /* synthetic */ Thread m2271$r8$lambda$IYX93i18CF3E6e1K_suGGxRFcI(int r0, String r1, AtomicInteger r2, Runnable r3) {
        return m2272newFixedThreadPoolContext$lambda1(r0, r1, r2, r3);
    }

    public static final ExecutorCoroutineDispatcher newSingleThreadContext(String r1) {
        return newFixedThreadPoolContext(1, r1);
    }

    public static final ExecutorCoroutineDispatcher newFixedThreadPoolContext(final int r2, final String r3) {
        boolean r0 = true;
        if (r2 >= 1) goto L6;
        r0 = false;
    L6:
        if (r0 == false) goto L10;
        final AtomicInteger r1 = new AtomicInteger();
        return ExecutorsKt.from(Executors.newScheduledThreadPool(r2, new ThreadPoolDispatcherKt$$ExternalSyntheticLambda0(r2, r3, r1)));
    L10:
        throw new IllegalArgumentException(("Expected at least one thread, but " + r2 + " specified").toString());
    }

    /* JADX INFO: renamed from: newFixedThreadPoolContext$lambda-1, reason: not valid java name */
    private static final Thread m2272newFixedThreadPoolContext$lambda1(int r2, String r3, AtomicInteger r4, Runnable r5) {
        if (r2 == 1) goto L6;
        r3 = r3 + '-' + r4.incrementAndGet();
    L6:
        Thread r0 = new Thread(r5, r3);
        r0.setDaemon(true);
        return r0;
    }
}
