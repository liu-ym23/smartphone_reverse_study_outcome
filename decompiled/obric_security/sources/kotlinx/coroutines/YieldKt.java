package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlinx.coroutines.internal.DispatchedContinuation;
import kotlinx.coroutines.internal.DispatchedContinuationKt;

/* JADX INFO: compiled from: Yield.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0000\u001a\u00020\u0001H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0002\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0003"}, d2 = {"yield", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class YieldKt {
    public static final Object yield(Continuation<? super Unit> r4) {
        CoroutineContext r0 = r4.getContext();
        JobKt.ensureActive(r0);
        Continuation r1 = IntrinsicsKt.intercepted(r4);
        if ((r1 instanceof DispatchedContinuation) == false) goto L5;
        DispatchedContinuation r2 = (DispatchedContinuation) r1;
    L6:
        if (r2 != null) goto L9;
        Object r3 = Unit.INSTANCE;
    L19:
        if (r3 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L22;
        DebugProbesKt.probeCoroutineSuspended(r4);
    L22:
        if (r3 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L25;
        return r3;
    L25:
        return Unit.INSTANCE;
    L9:
        if (r2.dispatcher.isDispatchNeeded(r0) == false) goto L11;
        r2.dispatchYield$kotlinx_coroutines_core(r0, Unit.INSTANCE);
    L17:
        r3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        goto L19
    L11:
        YieldContext r5 = new YieldContext();
        r2.dispatchYield$kotlinx_coroutines_core(r0.plus(r5), Unit.INSTANCE);
        if (r5.dispatcherWasUnconfined == false) goto L17;
        if (DispatchedContinuationKt.yieldUndispatched(r2) == false) goto L16;
        r3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        goto L19
    L16:
        r3 = Unit.INSTANCE;
        goto L19
    L5:
        r2 = null;
        goto L6
    }
}
