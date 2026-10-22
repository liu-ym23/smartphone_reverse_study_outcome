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
public final class FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$7 implements Flow<Integer> {

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$7$1, reason: invalid class name */
    @Metadata
    @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$7", f = "Builders.kt", l = {115}, m = "collect")
    public final class AnonymousClass1 extends ContinuationImpl {
        public /* synthetic */ Object f;
        public int i;
        public final /* synthetic */ FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$7 j;
        public FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$7 k;
        public FlowCollector l;
        public Continuation m;
        public FlowCollector n;
        public int[] o;
        public int[] p;
        public int q;
        public int r;

        public AnonymousClass1(FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$7 r1, Continuation r2) {
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
    public final Object a(FlowCollector r11, Continuation r12) {
        if ((r12 instanceof AnonymousClass1) == false) goto L7;
        AnonymousClass1 r13 = (AnonymousClass1) r12;
        int r0 = r13.i;
        if ((r0 & Integer.MIN_VALUE) == 0) goto L7;
        r13.i = r0 - Integer.MIN_VALUE;
    L8:
        Object r10 = r13.f;
        CoroutineSingletons r14 = CoroutineSingletons.b;
        int r1 = r13.i;
        if (r1 != 0) goto L11;
        ResultKt.b(r10);
        throw null;
    L11:
        if (r1 != 1) goto L21;
        int r2 = r13.r;
        int r3 = r13.q;
        int[] r4 = r13.p;
        int[] r5 = r13.o;
        FlowCollector r6 = r13.n;
        Continuation r7 = r13.m;
        FlowCollector r8 = r13.l;
        FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$7 r9 = r13.k;
        ResultKt.b(r10);
    L13:
        r2 = r2 + 1;
        if (r2 >= r3) goto L19;
        Integer r15 = new Integer(new Integer(r4[r2]).intValue());
        r13.k = r9;
        r13.l = r8;
        r13.m = r7;
        r13.n = r6;
        r13.o = r5;
        r13.p = r4;
        r13.q = r3;
        r13.r = r2;
        r13.i = 1;
        if (r6.d(r15, r13) != r14) goto L13;
        return r14;
    L19:
        return Unit.f330a;
    L21:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L7:
        r13 = new AnonymousClass1(this, r12);
        goto L8
    }
}
