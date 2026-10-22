package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlinx.coroutines.flow.internal.AbortFlowException;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class FlowKt__LimitKt$transformWhile$1$invokeSuspend$$inlined$collectWhile$1 implements FlowCollector<Object> {

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__LimitKt$transformWhile$1$invokeSuspend$$inlined$collectWhile$1$1, reason: invalid class name */
    @Metadata
    @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__LimitKt$transformWhile$1$invokeSuspend$$inlined$collectWhile$1", f = "Limit.kt", l = {144}, m = "emit")
    public final class AnonymousClass1 extends ContinuationImpl {
        public /* synthetic */ Object f;
        public int i;
        public final /* synthetic */ FlowKt__LimitKt$transformWhile$1$invokeSuspend$$inlined$collectWhile$1 j;

        public AnonymousClass1(FlowKt__LimitKt$transformWhile$1$invokeSuspend$$inlined$collectWhile$1 r1, Continuation r2) {
            this.j = r1;
            super(r2);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object i(Object r2) {
            this.f = r2;
            this.i |= Integer.MIN_VALUE;
            return this.j.d(null, this);
        }
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public final Object d(Object r4, Continuation r5) {
        if ((r5 instanceof AnonymousClass1) == false) goto L7;
        AnonymousClass1 r6 = (AnonymousClass1) r5;
        int r0 = r6.i;
        if ((r0 & Integer.MIN_VALUE) == 0) goto L7;
        r6.i = r0 - Integer.MIN_VALUE;
    L8:
        Object r3 = r6.f;
        int r7 = r6.i;
        if (r7 != 0) goto L11;
        ResultKt.b(r3);
        throw null;
    L11:
        if (r7 != 1) goto L19;
        r6.getClass();
        ResultKt.b(r3);
        if (((Boolean) r3).booleanValue() == false) goto L17;
        return Unit.f330a;
    L17:
        throw new AbortFlowException(null);
    L19:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L7:
        r6 = new AnonymousClass1(this, r5);
        goto L8
    }
}
