package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class NonCancellable extends AbstractCoroutineContextElement implements Job {
    static {
        new NonCancellable(Job.g);
    }

    @Override // kotlinx.coroutines.Job
    public final void a(CancellationException r1) {
    }

    @Override // kotlinx.coroutines.Job
    public final boolean isActive() {
        return true;
    }

    @Override // kotlinx.coroutines.Job
    public final boolean isCancelled() {
        return false;
    }

    @Override // kotlinx.coroutines.Job
    public final Object o(ContinuationImpl r1) {
        throw new UnsupportedOperationException("This job is always active");
    }

    @Override // kotlinx.coroutines.Job
    public final DisposableHandle p(boolean r1, boolean r2, Function1 r3) {
        return NonDisposableHandle.b;
    }

    @Override // kotlinx.coroutines.Job
    public final CancellationException q() {
        throw new IllegalStateException("This job is always active");
    }

    @Override // kotlinx.coroutines.Job
    public final ChildHandle r(JobSupport r1) {
        return NonDisposableHandle.b;
    }

    @Override // kotlinx.coroutines.Job
    public final boolean start() {
        return false;
    }

    public final String toString() {
        return "NonCancellable";
    }
}
