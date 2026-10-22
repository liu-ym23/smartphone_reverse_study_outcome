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
public final class FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$4 implements Flow<Object> {

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$4$1, reason: invalid class name */
    @Metadata
    @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$4", f = "Builders.kt", l = {115}, m = "collect")
    public final class AnonymousClass1 extends ContinuationImpl {
        public /* synthetic */ Object f;
        public int i;
        public final /* synthetic */ FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$4 j;
        public FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$4 k;
        public FlowCollector l;
        public Continuation m;
        public FlowCollector n;
        public Iterator o;
        public Iterator p;
        public Object q;
        public Object r;

        public AnonymousClass1(FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$4 r1, Continuation r2) {
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
    public final Object a(FlowCollector r9, Continuation r10) {
        if ((r10 instanceof AnonymousClass1) == false) goto L7;
        AnonymousClass1 r0 = (AnonymousClass1) r10;
        int r1 = r0.i;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.i = r1 - Integer.MIN_VALUE;
    L8:
        Object r11 = r0.f;
        CoroutineSingletons r2 = CoroutineSingletons.b;
        int r3 = r0.i;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        Iterator r8 = r0.p;
        Iterator r12 = r0.o;
        FlowCollector r4 = r0.n;
        Continuation r5 = r0.m;
        FlowCollector r6 = r0.l;
        FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$4 r7 = r0.k;
        ResultKt.b(r11);
        FlowCollector r13 = r4;
        Iterator r14 = r12;
        FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$4 r15 = r7;
        AnonymousClass1 r16 = r0;
        FlowCollector r17 = r6;
        Continuation r18 = r5;
    L16:
        if (r8.hasNext() == false) goto L21;
        Object r19 = r8.next();
        r16.k = r15;
        r16.l = r17;
        r16.m = r18;
        r16.n = r13;
        r16.o = r14;
        r16.p = r8;
        r16.q = r19;
        r16.r = r19;
        r16.i = 1;
        if (r13.d(r19, r16) != r2) goto L16;
        return r2;
    L21:
        return Unit.f330a;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.b(r11);
        r14 = null;
        r16 = r0;
        r18 = r16;
        r13 = r9;
        r17 = r13;
        r15 = this;
        r8 = null;
    L7:
        r0 = new AnonymousClass1(this, r10);
        goto L8
    }
}
