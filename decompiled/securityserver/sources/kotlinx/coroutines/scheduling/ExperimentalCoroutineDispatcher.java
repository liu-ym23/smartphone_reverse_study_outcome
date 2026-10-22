package kotlinx.coroutines.scheduling;

import java.util.concurrent.RejectedExecutionException;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.DefaultExecutor;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import kotlinx.coroutines.InternalCoroutinesApi;

/* JADX INFO: loaded from: classes2.dex */
@InternalCoroutinesApi
@Metadata
public class ExperimentalCoroutineDispatcher extends ExecutorCoroutineDispatcher {
    public final CoroutineScheduler e;

    public ExperimentalCoroutineDispatcher() {
        int r4 = TasksKt.b;
        int r5 = TasksKt.c;
        this.e = new CoroutineScheduler(TasksKt.f434d, "DefaultDispatcher", r4, r5);
    }

    public void close() {
        this.e.close();
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public final void j(CoroutineContext r2, Runnable r3) {
        CoroutineScheduler.c(this.e, r3, false, 6);     // Catch: RejectedExecutionException -> L4
        return;
    L4:
        DefaultExecutor.m.A(r3);
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public final void k(CoroutineContext r2, Runnable r3) {
        CoroutineScheduler.c(this.e, r3, true, 2);     // Catch: RejectedExecutionException -> L4
        return;
    L4:
        DefaultExecutor.m.A(r3);
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public String toString() {
        return super.toString() + "[scheduler = " + this.e + ']';
    }
}
