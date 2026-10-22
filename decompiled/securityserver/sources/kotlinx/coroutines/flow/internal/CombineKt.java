package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.intrinsics.UndispatchedKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class CombineKt {
    public static final Object a(FlowCollector r7, Flow[] r8, Function0 r9, Function3 r10, Continuation r11) {
        CombineKt$combineInternal$2 r6 = new CombineKt$combineInternal$2(r7, r8, r9, r10, null);
        FlowCoroutine r12 = new FlowCoroutine(r11, r11.getContext());
        Object r13 = UndispatchedKt.b(r12, r12, r6);
        if (r13 != CoroutineSingletons.b) goto L6;
        return r13;
    L6:
        return Unit.f330a;
    }
}
