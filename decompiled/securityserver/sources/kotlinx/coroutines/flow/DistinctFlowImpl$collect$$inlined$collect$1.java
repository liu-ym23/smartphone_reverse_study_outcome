package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class DistinctFlowImpl$collect$$inlined$collect$1 implements FlowCollector<Object> {
    public final /* synthetic */ DistinctFlowImpl b;
    public final /* synthetic */ Ref.ObjectRef c;
    public final /* synthetic */ FlowCollector e;

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.DistinctFlowImpl$collect$$inlined$collect$1$1, reason: invalid class name */
    @Metadata
    @DebugMetadata(c = "kotlinx.coroutines.flow.DistinctFlowImpl$collect$$inlined$collect$1", f = "Distinct.kt", l = {137}, m = "emit")
    public final class AnonymousClass1 extends ContinuationImpl {
        public /* synthetic */ Object f;
        public int i;
        public final /* synthetic */ DistinctFlowImpl$collect$$inlined$collect$1 j;
        public Object k;
        public Object l;
        public Object m;

        public AnonymousClass1(DistinctFlowImpl$collect$$inlined$collect$1 r1, Continuation r2) {
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

    public DistinctFlowImpl$collect$$inlined$collect$1(DistinctFlowImpl r1, Ref.ObjectRef r2, FlowCollector r3) {
        this.b = r1;
        this.c = r2;
        this.e = r3;
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public final Object d(Object r4, Continuation r5) {
        if ((r5 instanceof AnonymousClass1) == false) goto L7;
        AnonymousClass1 r6 = (AnonymousClass1) r5;
        int r0 = r6.i;
        if ((r0 & Integer.MIN_VALUE) == 0) goto L7;
        r6.i = r0 - Integer.MIN_VALUE;
    L8:
        Object r7 = r6.f;
        int r8 = r6.i;
        if (r8 == 0) goto L15;
        if (r8 != 1) goto L14;
        ResultKt.b(r7);
        return Unit.f330a;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.b(r7);
        this.b.getClass();
        throw null;
    L7:
        r6 = new AnonymousClass1(this, r5);
        goto L8
    }
}
