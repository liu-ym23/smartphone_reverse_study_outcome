package kotlinx.coroutines.flow;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.sequences.Sequence;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$5 implements Flow<Object> {

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$5$1, reason: invalid class name */
    @Metadata
    @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$5", f = "Builders.kt", l = {115}, m = "collect")
    public final class AnonymousClass1 extends ContinuationImpl {
        public /* synthetic */ Object f;
        public int i;
        public final /* synthetic */ FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$5 j;
        public FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$5 k;
        public FlowCollector l;
        public Continuation m;
        public FlowCollector n;
        public Sequence o;
        public Iterator p;
        public Object q;
        public Object r;

        public AnonymousClass1(FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$5 r1, Continuation r2) {
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
    public final Object a(FlowCollector r8, Continuation r9) {
        if ((r9 instanceof AnonymousClass1) == false) goto L7;
        AnonymousClass1 r10 = (AnonymousClass1) r9;
        int r0 = r10.i;
        if ((r0 & Integer.MIN_VALUE) == 0) goto L7;
        r10.i = r0 - Integer.MIN_VALUE;
    L8:
        Object r7 = r10.f;
        CoroutineSingletons r11 = CoroutineSingletons.b;
        int r1 = r10.i;
        if (r1 != 0) goto L11;
        ResultKt.b(r7);
        throw null;
    L11:
        if (r1 != 1) goto L21;
        Iterator r2 = r10.p;
        Sequence r3 = r10.o;
        FlowCollector r4 = r10.n;
        Continuation r5 = r10.m;
        FlowCollector r6 = r10.l;
        FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$5 r12 = r10.k;
        ResultKt.b(r7);
    L14:
        if (r2.hasNext() == false) goto L19;
        Object r13 = r2.next();
        r10.k = r12;
        r10.l = r6;
        r10.m = r5;
        r10.n = r4;
        r10.o = r3;
        r10.p = r2;
        r10.q = r13;
        r10.r = r13;
        r10.i = 1;
        if (r4.d(r13, r10) != r11) goto L14;
        return r11;
    L19:
        return Unit.f330a;
    L21:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L7:
        r10 = new AnonymousClass1(this, r9);
        goto L8
    }
}
