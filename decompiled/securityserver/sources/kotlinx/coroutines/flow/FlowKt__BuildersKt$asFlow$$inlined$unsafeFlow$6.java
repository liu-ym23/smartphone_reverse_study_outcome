package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$6 implements Flow<Object> {

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$6$1, reason: invalid class name */
    @Metadata
    @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$6", f = "Builders.kt", l = {115}, m = "collect")
    public final class AnonymousClass1 extends ContinuationImpl {
        public /* synthetic */ Object f;
        public int i;
        public final /* synthetic */ FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$6 j;
        public FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$6 k;
        public FlowCollector l;
        public Continuation m;
        public FlowCollector n;
        public Object[] o;
        public Object[] p;
        public Object q;
        public Object r;
        public int s;
        public int t;

        public AnonymousClass1(FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$6 r1, Continuation r2) {
            this.j = r1;
            super(r2);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object i(Object r2) {
            this.f = r2;
            this.i |= Integer.MIN_VALUE;
            return this.j.a(null, this);
        }
    }

    @Override // kotlinx.coroutines.flow.Flow
    public final Object a(FlowCollector r10, Continuation r11) {
        if ((r11 instanceof AnonymousClass1) == false) goto L7;
        AnonymousClass1 r12 = (AnonymousClass1) r11;
        int r0 = r12.i;
        if ((r0 & Integer.MIN_VALUE) == 0) goto L7;
        r12.i = r0 - Integer.MIN_VALUE;
    L8:
        Object r9 = r12.f;
        CoroutineSingletons r13 = CoroutineSingletons.b;
        int r1 = r12.i;
        if (r1 != 0) goto L11;
        ResultKt.b(r9);
        throw null;
    L11:
        if (r1 != 1) goto L21;
        int r2 = r12.t;
        int r3 = r12.s;
        Object[] r4 = r12.p;
        Object[] r5 = r12.o;
        FlowCollector r6 = r12.n;
        Continuation r7 = r12.m;
        FlowCollector r8 = r12.l;
        FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$6 r14 = r12.k;
        ResultKt.b(r9);
    L13:
        r2 = r2 + 1;
        if (r2 >= r3) goto L19;
        Object r15 = r4[r2];
        r12.k = r14;
        r12.l = r8;
        r12.m = r7;
        r12.n = r6;
        r12.o = r5;
        r12.p = r4;
        r12.s = r3;
        r12.t = r2;
        r12.q = r15;
        r12.r = r15;
        r12.i = 1;
        if (r6.d(r15, r12) != r13) goto L13;
        return r13;
    L19:
        return Unit.f330a;
    L21:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L7:
        r12 = new AnonymousClass1(this, r11);
        goto L8
    }
}
