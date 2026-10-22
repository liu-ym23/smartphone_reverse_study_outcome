package kotlinx.coroutines.flow;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.internal.AbstractSharedFlow;
import kotlinx.coroutines.flow.internal.AbstractSharedFlowKt;
import kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
final class StateFlowSlot extends AbstractSharedFlowSlot<StateFlowImpl<?>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f401a = null;
    volatile Object _state;

    static {
        f401a = AtomicReferenceFieldUpdater.newUpdater(StateFlowSlot.class, Object.class, "_state");
    }

    @Override // kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot
    public final boolean a(AbstractSharedFlow r1) {
        StateFlowImpl r2 = (StateFlowImpl) r1;
        if (this._state == null) goto L5;
        return false;
    L5:
        this._state = StateFlowKt.f400a;
        return true;
    }

    @Override // kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot
    public final Continuation[] b(AbstractSharedFlow r1) {
        StateFlowImpl r2 = (StateFlowImpl) r1;
        this._state = null;
        return AbstractSharedFlowKt.f402a;
    }
}
