package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.flow.internal.AbortFlowException;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class FlowKt__ReduceKt$firstOrNull$$inlined$collectWhile$2 implements FlowCollector<Object> {
    public final /* synthetic */ Function2 b;
    public final /* synthetic */ Ref.ObjectRef c;

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__ReduceKt$firstOrNull$$inlined$collectWhile$2$1, reason: invalid class name */
    @Metadata
    @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ReduceKt$firstOrNull$$inlined$collectWhile$2", f = "Reduce.kt", l = {144}, m = "emit")
    public final class AnonymousClass1 extends ContinuationImpl {
        public /* synthetic */ Object f;
        public int i;
        public FlowKt__ReduceKt$firstOrNull$$inlined$collectWhile$2 j;
        public Object k;
        public final /* synthetic */ FlowKt__ReduceKt$firstOrNull$$inlined$collectWhile$2 l;
        public Object m;

        public AnonymousClass1(FlowKt__ReduceKt$firstOrNull$$inlined$collectWhile$2 r1, Continuation r2) {
            this.l = r1;
            super(r2);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object i(Object r2) {
            this.f = r2;
            this.i |= Integer.MIN_VALUE;
            return this.l.d(null, this);
        }
    }

    public FlowKt__ReduceKt$firstOrNull$$inlined$collectWhile$2(Ref.ObjectRef r2) {
        this.b = null;
        this.c = r2;
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public final Object d(Object r5, Continuation r6) {
        if ((r6 instanceof AnonymousClass1) == false) goto L7;
        AnonymousClass1 r0 = (AnonymousClass1) r6;
        int r1 = r0.i;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.i = r1 - Integer.MIN_VALUE;
    L8:
        Object r7 = r0.f;
        CoroutineSingletons r2 = CoroutineSingletons.b;
        int r3 = r0.i;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        r5 = r0.m;
        FlowKt__ReduceKt$firstOrNull$$inlined$collectWhile$2 this = r0.j;
        ResultKt.b(r7);
    L18:
        if (((Boolean) r7).booleanValue() == false) goto L20;
        this.c.b = r5;
        throw new AbortFlowException(this);
    L20:
        return Unit.f330a;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.b(r7);
        r0.j = this;
        r0.k = r5;
        r0.getClass();
        r0.m = r5;
        r0.i = 1;
        r7 = this.b.mo7invoke(r5, r0);
        if (r7 != r2) goto L18;
        return r2;
    L7:
        r0 = new AnonymousClass1(this, r6);
        goto L8
    }
}
