package t2;

import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadPoolExecutor;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.z;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ThreadPoolExecutor f22088a;

    public a(ThreadPoolExecutor r5) {
        Intrinsics.checkNotNullParameter(r5, "executor");
        this.f22088a = r5;
    }

    @Override // kotlinx.coroutines.z
    public final void dispatch(CoroutineContext r5, Runnable r10) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r10, "block");
        this.f22088a.execute(r10);     // Catch: RejectedExecutionException -> L5
        return;
    }

    @Override // kotlin.coroutines.AbstractCoroutineContextElement, kotlin.coroutines.CoroutineContext
    public final CoroutineContext plus(CoroutineContext r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        return super.plus(r5);
    }
}
