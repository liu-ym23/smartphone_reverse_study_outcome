package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.flow.internal.NullSurrogateKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
final class DistinctFlowImpl<T> implements Flow<T> {
    @Override // kotlinx.coroutines.flow.Flow
    public final Object a(FlowCollector r2, Continuation r3) {
        Ref.ObjectRef r4 = new Ref.ObjectRef();
        r4.b = NullSurrogateKt.f403a;
        new DistinctFlowImpl$collect$$inlined$collect$1(this, r4, r2);
        throw null;
    }
}
