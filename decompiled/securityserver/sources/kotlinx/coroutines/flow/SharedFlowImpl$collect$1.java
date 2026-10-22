package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
@DebugMetadata(c = "kotlinx.coroutines.flow.SharedFlowImpl", f = "SharedFlow.kt", l = {331, 338, 341}, m = "collect")
final class SharedFlowImpl$collect$1 extends ContinuationImpl {
    public /* synthetic */ Object f;
    public int i;
    public final /* synthetic */ SharedFlowImpl j;
    public Object k;
    public FlowCollector l;
    public Object m;
    public Job n;
    public Object o;

    public SharedFlowImpl$collect$1(SharedFlowImpl r1, Continuation r2) {
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
