package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class FlowKt__EmittersKt$transform$1$invokeSuspend$$inlined$collect$1 implements FlowCollector<Object> {

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__EmittersKt$transform$1$invokeSuspend$$inlined$collect$1$1, reason: invalid class name */
    @Metadata
    public final class AnonymousClass1 extends ContinuationImpl {
        public /* synthetic */ Object f;

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object i(Object r1) {
            this.f = r1;
            throw null;
        }
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public final Object d(Object r1, Continuation r2) {
        throw null;
    }
}
