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
public final class FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$8 implements Flow<Long> {

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$8$1, reason: invalid class name */
    @Metadata
    @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$8", f = "Builders.kt", l = {115}, m = "collect")
    public final class AnonymousClass1 extends ContinuationImpl {
        public /* synthetic */ Object f;
        public int i;
        public final /* synthetic */ FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$8 j;
        public FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$8 k;
        public FlowCollector l;
        public Continuation m;
        public FlowCollector n;
        public long[] o;
        public long[] p;
        public int q;
        public int r;

        public AnonymousClass1(FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$8 r1, Continuation r2) {
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
    public final Object a(FlowCollector r12, Continuation r13) {
        if ((r13 instanceof AnonymousClass1) == false) goto L7;
        AnonymousClass1 r14 = (AnonymousClass1) r13;
        int r0 = r14.i;
        if ((r0 & Integer.MIN_VALUE) == 0) goto L7;
        r14.i = r0 - Integer.MIN_VALUE;
    L8:
        Object r11 = r14.f;
        CoroutineSingletons r15 = CoroutineSingletons.b;
        int r1 = r14.i;
        if (r1 != 0) goto L11;
        ResultKt.b(r11);
        throw null;
    L11:
        if (r1 != 1) goto L21;
        int r2 = r14.r;
        int r3 = r14.q;
        long[] r4 = r14.p;
        long[] r5 = r14.o;
        FlowCollector r6 = r14.n;
        Continuation r7 = r14.m;
        FlowCollector r8 = r14.l;
        FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$8 r9 = r14.k;
        ResultKt.b(r11);
    L13:
        r2 = r2 + 1;
        if (r2 >= r3) goto L19;
        Long r16 = new Long(new Long(r4[r2]).longValue());
        r14.k = r9;
        r14.l = r8;
        r14.m = r7;
        r14.n = r6;
        r14.o = r5;
        r14.p = r4;
        r14.q = r3;
        r14.r = r2;
        r14.i = 1;
        if (r6.d(r16, r14) != r15) goto L13;
        return r15;
    L19:
        return Unit.f330a;
    L21:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L7:
        r14 = new AnonymousClass1(this, r13);
        goto L8
    }
}
