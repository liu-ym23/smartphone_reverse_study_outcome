package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class FlowKt__LimitKt$dropWhile$$inlined$unsafeFlow$1 implements Flow<Object> {
    @Override // kotlinx.coroutines.flow.Flow
    public final Object a(FlowCollector r2, Continuation r3) {
        Ref.BooleanRef r4 = new Ref.BooleanRef();
        r4.b = false;
        new FlowKt__LimitKt$dropWhile$$inlined$unsafeFlow$1$lambda$1(r2, r4, this);
        throw null;
    }
}
