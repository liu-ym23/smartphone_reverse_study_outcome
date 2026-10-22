package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class CancellableFlowImpl$collect$$inlined$collect$1 implements FlowCollector<Object> {
    @Override // kotlinx.coroutines.flow.FlowCollector
    public final Object d(Object r1, Continuation r2) {
        Job r0 = (Job) r2.getContext().f(Job.g);
        if (r0 == null) goto L10;
        if (r0.isActive() == true) goto L10;
        throw r0.q();
    L10:
        throw null;
    }
}
