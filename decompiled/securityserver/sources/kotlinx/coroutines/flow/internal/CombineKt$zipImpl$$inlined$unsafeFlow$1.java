package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.internal.ScopeCoroutine;
import kotlinx.coroutines.intrinsics.UndispatchedKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class CombineKt$zipImpl$$inlined$unsafeFlow$1 implements Flow<Object> {
    @Override // kotlinx.coroutines.flow.Flow
    public final Object a(FlowCollector r3, Continuation r4) {
        CombineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1 r0 = new CombineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1(r3, null, this);
        ScopeCoroutine r2 = new ScopeCoroutine(r4, r4.getContext());
        Object r5 = UndispatchedKt.b(r2, r2, r0);
        if (r5 != CoroutineSingletons.b) goto L6;
        return r5;
    L6:
        return Unit.f330a;
    }
}
