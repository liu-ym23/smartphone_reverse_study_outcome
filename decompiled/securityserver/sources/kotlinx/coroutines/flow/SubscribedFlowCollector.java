package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class SubscribedFlowCollector<T> implements FlowCollector<T> {
    public final Object a(Continuation r5) {
        if ((r5 instanceof SubscribedFlowCollector$onSubscription$1) == false) goto L7;
        SubscribedFlowCollector$onSubscription$1 r0 = (SubscribedFlowCollector$onSubscription$1) r5;
        int r1 = r0.i;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.i = r1 - Integer.MIN_VALUE;
    L8:
        Object r4 = r0.f;
        int r6 = r0.i;
        if (r6 != 0) goto L11;
        ResultKt.b(r4);
        Intrinsics.c(r0.c);
        throw null;
    L11:
        if (r6 != 1) goto L13;
        r0.getClass();
        ResultKt.b(r4);     // Catch: Throwable -> L22
        throw null;
    L23:
        throw null;
    L13:
        if (r6 != 2) goto L17;
        ResultKt.b(r4);
        return Unit.f330a;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L7:
        r0 = new SubscribedFlowCollector$onSubscription$1(this, r5);
        goto L8
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public final Object d(Object r1, Continuation r2) {
        throw null;
    }
}
