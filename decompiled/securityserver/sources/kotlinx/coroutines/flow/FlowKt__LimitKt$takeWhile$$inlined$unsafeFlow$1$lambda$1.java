package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlinx.coroutines.flow.internal.AbortFlowException;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class FlowKt__LimitKt$takeWhile$$inlined$unsafeFlow$1$lambda$1 implements FlowCollector<Object> {
    public final /* synthetic */ FlowCollector b;
    public final /* synthetic */ FlowKt__LimitKt$takeWhile$$inlined$unsafeFlow$1 c;

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__LimitKt$takeWhile$$inlined$unsafeFlow$1$lambda$1$1, reason: invalid class name */
    @Metadata
    public final class AnonymousClass1 extends ContinuationImpl {
        public /* synthetic */ Object f;
        public int i;
        public FlowKt__LimitKt$takeWhile$$inlined$unsafeFlow$1$lambda$1 j;
        public Object k;
        public Continuation l;
        public Object m;
        public final /* synthetic */ FlowKt__LimitKt$takeWhile$$inlined$unsafeFlow$1$lambda$1 n;

        public AnonymousClass1(FlowKt__LimitKt$takeWhile$$inlined$unsafeFlow$1$lambda$1 r1, Continuation r2) {
            this.n = r1;
            super(r2);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object i(Object r2) {
            this.f = r2;
            this.i |= Integer.MIN_VALUE;
            return this.n.d(null, this);
        }
    }

    public FlowKt__LimitKt$takeWhile$$inlined$unsafeFlow$1$lambda$1(FlowCollector r1, FlowKt__LimitKt$takeWhile$$inlined$unsafeFlow$1 r2) {
        this.b = r1;
        this.c = r2;
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public final Object d(Object r7, Continuation r8) {
        if ((r8 instanceof AnonymousClass1) == false) goto L7;
        AnonymousClass1 r0 = (AnonymousClass1) r8;
        int r1 = r0.i;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.i = r1 - Integer.MIN_VALUE;
    L8:
        Object r9 = r0.f;
        CoroutineSingletons r2 = CoroutineSingletons.b;
        int r3 = r0.i;
        boolean r4 = true;
        if (r3 != 0) goto L11;
        ResultKt.b(r9);
        this.c.getClass();
        r0.j = this;
        r0.k = r7;
        r0.l = r0;
        r0.m = r7;
        r0.i = 1;
        throw null;
    L11:
        if (r3 == 1) goto L16;
        if (r3 != 2) goto L15;
        FlowKt__LimitKt$takeWhile$$inlined$unsafeFlow$1$lambda$1 r6 = r0.j;
        ResultKt.b(r9);
    L22:
        FlowKt__LimitKt$takeWhile$$inlined$unsafeFlow$1$lambda$1 r5 = r6;
    L24:
        if (r4 == false) goto L28;
        return Unit.f330a;
    L28:
        throw new AbortFlowException(r5);
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        Object r10 = r0.m;
        Continuation r11 = r0.l;
        Object r12 = r0.k;
        r5 = r0.j;
        ResultKt.b(r9);
        if (((Boolean) r9).booleanValue() == false) goto L23;
        FlowCollector r13 = r5.b;
        r0.j = r5;
        r0.k = r12;
        r0.l = r11;
        r0.m = r10;
        r0.i = 2;
        if (r13.d(r10, r0) != r2) goto L21;
        return r2;
    L21:
        r6 = r5;
        goto L22
    L23:
        r4 = false;
    L7:
        r0 = new AnonymousClass1(this, r8);
        goto L8
    }
}
