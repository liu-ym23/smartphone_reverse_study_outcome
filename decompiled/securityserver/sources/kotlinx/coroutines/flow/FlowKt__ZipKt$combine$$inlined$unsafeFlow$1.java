package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlinx.coroutines.flow.internal.CombineKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class FlowKt__ZipKt$combine$$inlined$unsafeFlow$1 implements Flow<Object> {
    @Override // kotlinx.coroutines.flow.Flow
    public final Object a(FlowCollector r5, Continuation r6) {
        Object r4 = CombineKt.a(r5, new Flow[]{null, null}, FlowKt__ZipKt$nullArrayFactory$1.b, new FlowKt__ZipKt$combine$$inlined$unsafeFlow$1$lambda$1(null, this), r6);
        if (r4 != CoroutineSingletons.b) goto L6;
        return r4;
    L6:
        return Unit.f330a;
    }
}
