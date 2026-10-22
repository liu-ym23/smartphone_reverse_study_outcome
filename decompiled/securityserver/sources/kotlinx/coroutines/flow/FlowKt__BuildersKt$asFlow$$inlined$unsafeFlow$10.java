package kotlinx.coroutines.flow;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$10 implements Flow<Long> {

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$10$1, reason: invalid class name */
    @Metadata
    @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$10", f = "Builders.kt", l = {115}, m = "collect")
    public final class AnonymousClass1 extends ContinuationImpl {
        public /* synthetic */ Object f;
        public int i;
        public final /* synthetic */ FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$10 j;
        public FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$10 k;
        public FlowCollector l;
        public Continuation m;
        public FlowCollector n;
        public Iterable o;
        public Iterator p;
        public Object q;

        public AnonymousClass1(FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$10 r1, Continuation r2) {
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
        Iterator r2 = r13.p;
        Iterable r3 = r13.o;
        FlowCollector r4 = r13.n;
        Continuation r5 = r13.m;
        FlowCollector r6 = r13.l;
        FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$10 r7 = r13.k;
        ResultKt.b(r10);
    L14:
        if (r2.hasNext() == false) goto L19;
        Object r15 = r2.next();
        Long r9 = new Long(((Number) r15).longValue());
        r13.k = r7;
        r13.l = r6;
        r13.m = r5;
        r13.n = r4;
        r13.o = r3;
        r13.p = r2;
        r13.q = r15;
        r13.i = 1;
        if (r4.d(r9, r13) != r14) goto L14;
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
