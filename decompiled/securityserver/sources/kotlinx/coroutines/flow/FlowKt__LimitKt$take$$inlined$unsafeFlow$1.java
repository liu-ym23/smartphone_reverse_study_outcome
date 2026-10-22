package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.flow.internal.AbortFlowException;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class FlowKt__LimitKt$take$$inlined$unsafeFlow$1 implements Flow<Object> {

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__LimitKt$take$$inlined$unsafeFlow$1$1, reason: invalid class name */
    @Metadata
    @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__LimitKt$take$$inlined$unsafeFlow$1", f = "Limit.kt", l = {116}, m = "collect")
    public final class AnonymousClass1 extends ContinuationImpl {
        public /* synthetic */ Object f;
        public int i;
        public final /* synthetic */ FlowKt__LimitKt$take$$inlined$unsafeFlow$1 j;
        public FlowCollector k;
        public FlowCollector l;

        public AnonymousClass1(FlowKt__LimitKt$take$$inlined$unsafeFlow$1 r1, Continuation r2) {
            this.j = r1;
            super(r2);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object i(Object r2) {
            this.f = r2;
            this.i |= Integer.MIN_VALUE;
            this.j.a(null, this);
            return Unit.f330a;
        }
    }

    @Override // kotlinx.coroutines.flow.Flow
    public final Object a(FlowCollector r5, Continuation r6) {
        if ((r6 instanceof AnonymousClass1) == false) goto L7;
        AnonymousClass1 r0 = (AnonymousClass1) r6;
        int r1 = r0.i;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.i = r1 - Integer.MIN_VALUE;
    L8:
        Object r4 = r0.f;
        int r7 = r0.i;
        if (r7 == 0) goto L18;
        if (r7 != 1) goto L17;
        FlowCollector r8 = r0.l;
        ResultKt.b(r4);     // Catch: AbortFlowException -> L14
    L25:
        return Unit.f330a;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.b(r4);
        new Ref.IntRef().b = 0;
        r0.getClass();     // Catch: AbortFlowException -> L14
        r0.k = r5;     // Catch: AbortFlowException -> L14
        r0.getClass();     // Catch: AbortFlowException -> L14
        r0.l = r5;     // Catch: AbortFlowException -> L14
        r0.getClass();     // Catch: AbortFlowException -> L14
        r0.i = 1;     // Catch: AbortFlowException -> L14
        throw null;
    L14:
        e = move-exception;
        if (e.b == r5) goto L25;
        throw e;
    L7:
        r0 = new AnonymousClass1(this, r6);
        goto L8
    }
}
