package kotlinx.coroutines;

import kotlin.Metadata;
import kotlinx.coroutines.scheduling.DefaultScheduler;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class Dispatchers {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ExecutorCoroutineDispatcher f372a = null;

    static {
        if (CoroutineContextKt.f366a == false) goto L5;
        ExecutorCoroutineDispatcher r0 = DefaultScheduler.i;
    L6:
        f372a = r0;
        int r1 = Unconfined.e;
        DefaultScheduler.i.getClass();
        CoroutineDispatcher r2 = DefaultScheduler.f;
        return;
    L5:
        r0 = CommonPool.f;
        goto L6
    }
}
