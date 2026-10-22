package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class FlowKt__LimitKt$dropWhile$$inlined$unsafeFlow$1$lambda$1 implements FlowCollector<Object> {
    public final /* synthetic */ FlowCollector b;
    public final /* synthetic */ Ref.BooleanRef c;
    public final /* synthetic */ FlowKt__LimitKt$dropWhile$$inlined$unsafeFlow$1 e;

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__LimitKt$dropWhile$$inlined$unsafeFlow$1$lambda$1$1, reason: invalid class name */
    @Metadata
    public final class AnonymousClass1 extends ContinuationImpl {
        public /* synthetic */ Object f;
        public int i;
        public FlowKt__LimitKt$dropWhile$$inlined$unsafeFlow$1$lambda$1 j;
        public Object k;
        public Continuation l;
        public Object m;
        public final /* synthetic */ FlowKt__LimitKt$dropWhile$$inlined$unsafeFlow$1$lambda$1 n;

        public AnonymousClass1(FlowKt__LimitKt$dropWhile$$inlined$unsafeFlow$1$lambda$1 r1, Continuation r2) {
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

    public FlowKt__LimitKt$dropWhile$$inlined$unsafeFlow$1$lambda$1(FlowCollector r1, Ref.BooleanRef r2, FlowKt__LimitKt$dropWhile$$inlined$unsafeFlow$1 r3) {
        this.b = r1;
        this.c = r2;
        this.e = r3;
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
        if (r3 == 0) goto L21;
        if (r3 == 1) goto L13;
        if (r3 == 2) goto L16;
        if (r3 == 3) goto L13;
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        Object r6 = r0.m;
        Continuation r10 = r0.l;
        Object r4 = r0.k;
        FlowKt__LimitKt$dropWhile$$inlined$unsafeFlow$1$lambda$1 r5 = r0.j;
        ResultKt.b(r9);
        if (((Boolean) r9).booleanValue() == true) goto L27;
        r5.c.b = true;
        r0.j = r5;
        r0.k = r4;
        r0.l = r10;
        r0.m = r6;
        r0.i = 3;
        if (r5.b.d(r6, r0) != r2) goto L27;
        return r2;
    L27:
        return Unit.f330a;
    L13:
        ResultKt.b(r9);
        goto L27
    L21:
        ResultKt.b(r9);
        if (this.c.b == false) goto L28;
        r0.j = this;
        r0.k = r7;
        r0.l = r0;
        r0.m = r7;
        r0.i = 1;
        if (this.b.d(r7, r0) != r2) goto L27;
        return r2;
    L28:
        this.e.getClass();
        r0.j = this;
        r0.k = r7;
        r0.l = r0;
        r0.m = r7;
        r0.i = 2;
        throw null;
    L7:
        r0 = new AnonymousClass1(this, r8);
        goto L8
    }
}
