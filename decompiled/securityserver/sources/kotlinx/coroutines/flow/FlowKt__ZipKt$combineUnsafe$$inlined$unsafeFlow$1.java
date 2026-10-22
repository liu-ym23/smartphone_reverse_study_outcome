package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlinx.coroutines.flow.internal.CombineKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class FlowKt__ZipKt$combineUnsafe$$inlined$unsafeFlow$1 implements Flow<Object> {

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__ZipKt$combineUnsafe$$inlined$unsafeFlow$1$1, reason: invalid class name */
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
    public final Object a(FlowCollector r4, Continuation r5) {
        Object r3 = CombineKt.a(r4, null, FlowKt__ZipKt$nullArrayFactory$1.b, new FlowKt__ZipKt$combineUnsafe$$inlined$unsafeFlow$1$lambda$1(null, this), r5);
        if (r3 != CoroutineSingletons.b) goto L6;
        return r3;
    L6:
        return Unit.f330a;
    }
}
