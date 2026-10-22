package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
@DebugMetadata(c = "kotlinx.coroutines.flow.StateFlowImpl", f = "StateFlow.kt", l = {336, 394, 353}, m = "collect")
final class StateFlowImpl$collect$1 extends ContinuationImpl {
    public /* synthetic */ Object f;
    public int i;
    public final /* synthetic */ StateFlowImpl j;
    public Object k;
    public FlowCollector l;
    public Object m;
    public Job n;
    public Object o;
    public Object p;

    public StateFlowImpl$collect$1(StateFlowImpl r1, Continuation r2) {
        this.j = r1;
        super(r2);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object i(Object r2) {
        this.f = r2;
        this.i |= Integer.MIN_VALUE;
        this.j.a(null, this);
        return CoroutineSingletons.b;
    }
}
