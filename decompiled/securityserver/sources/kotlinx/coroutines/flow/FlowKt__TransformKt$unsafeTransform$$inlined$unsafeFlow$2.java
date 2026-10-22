package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class FlowKt__TransformKt$unsafeTransform$$inlined$unsafeFlow$2 implements Flow<Object> {

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__TransformKt$unsafeTransform$$inlined$unsafeFlow$2$1, reason: invalid class name */
    @Metadata
    public final class AnonymousClass1 extends ContinuationImpl {
        public /* synthetic */ Object f;

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object i(Object r1) {
            this.f = r1;
            throw null;
        }
    }

    @Override // kotlinx.coroutines.flow.Flow
    public final Object a(FlowCollector r1, Continuation r2) {
        throw null;
    }
}
