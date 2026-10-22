package yt;

import java.util.concurrent.Executor;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.d1;
import kotlinx.coroutines.internal.u;
import kotlinx.coroutines.z;

/* JADX INFO: loaded from: classes3.dex */
public final class d extends d1 implements Executor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f23337a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final z f23338b = null;

    static {
        f23337a = new d();
        f23338b = z.limitedParallelism$default(l.f23348a, kotlinx.coroutines.internal.f.j("kotlinx.coroutines.io.parallelism", RangesKt.coerceAtLeast(64, u.f18952a), 0, 0, 12), null, 2, null);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        throw new IllegalStateException("Cannot be invoked on Dispatchers.IO");
    }

    @Override // kotlinx.coroutines.z
    public final void dispatch(CoroutineContext r5, Runnable r10) {
        f23338b.dispatch(r5, r10);
    }

    @Override // kotlinx.coroutines.z
    public final void dispatchYield(CoroutineContext r5, Runnable r10) {
        f23338b.dispatchYield(r5, r10);
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable r5) {
        dispatch(EmptyCoroutineContext.INSTANCE, r5);
    }

    @Override // kotlinx.coroutines.z
    public final z limitedParallelism(int r5, String r10) {
        return l.f23348a.limitedParallelism(r5, r10);
    }

    @Override // kotlinx.coroutines.z
    public final String toString() {
        return "Dispatchers.IO";
    }
}
