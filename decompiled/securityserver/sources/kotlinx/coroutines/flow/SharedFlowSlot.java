package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.flow.internal.AbstractSharedFlow;
import kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
final class SharedFlowSlot extends AbstractSharedFlowSlot<SharedFlowImpl<?>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f398a;
    public CancellableContinuationImpl b;

    @Override // kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot
    public final boolean a(AbstractSharedFlow r5) {
        SharedFlowImpl r6 = (SharedFlowImpl) r5;
        if (this.f398a < 0) goto L5;
        return false;
    L5:
        long r0 = r6.i;
        if (r0 >= r6.j) goto L8;
        r6.j = r0;
    L8:
        this.f398a = r0;
        return true;
    }

    @Override // kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot
    public final Continuation[] b(AbstractSharedFlow r5) {
        boolean r0 = DebugKt.f370a;
        long r1 = this.f398a;
        this.f398a = -1;
        this.b = null;
        return ((SharedFlowImpl) r5).p(r1);
    }
}
