package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.internal.DispatchedContinuationKt;
import kotlinx.coroutines.internal.ScopeCoroutine;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
final class DispatchedCoroutine<T> extends ScopeCoroutine<T> {
    public static final AtomicIntegerFieldUpdater i = null;
    private volatile int _decision;

    static {
        i = AtomicIntegerFieldUpdater.newUpdater(DispatchedCoroutine.class, "_decision");
    }

    @Override // kotlinx.coroutines.internal.ScopeCoroutine, kotlinx.coroutines.JobSupport
    public final void M(Object r1) {
        N(r1);
    }

    @Override // kotlinx.coroutines.internal.ScopeCoroutine, kotlinx.coroutines.JobSupport
    public final void N(Object r4) {
    L2:
        int r0 = this._decision;
        if (r0 != 0) goto L5;
        if (i.compareAndSet(this, 0, 2) == false) goto L2;
        return;
    L5:
        if (r0 != 1) goto L9;
        Continuation r1 = IntrinsicsKt.b(this.f);
        DispatchedContinuationKt.a(CompletionStateKt.a(r4, this.f), r1, null);
        return;
    L9:
        throw new IllegalStateException("Already resumed".toString());
    }
}
