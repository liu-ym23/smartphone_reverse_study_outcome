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
public final class FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$2 implements Flow<Object> {

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$2$1, reason: invalid class name */
    @Metadata
    @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$2", f = "Builders.kt", l = {113, 113}, m = "collect")
    public final class AnonymousClass1 extends ContinuationImpl {
        public /* synthetic */ Object f;
        public int i;
        public final /* synthetic */ FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$2 j;
        public FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$2 k;
        public FlowCollector l;
        public Continuation m;
        public FlowCollector n;
        public FlowCollector o;

        public AnonymousClass1(FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$2 r1, Continuation r2) {
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
    public final Object a(FlowCollector r7, Continuation r8) {
        if ((r8 instanceof AnonymousClass1) == false) goto L7;
        AnonymousClass1 r0 = (AnonymousClass1) r8;
        int r1 = r0.i;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.i = r1 - Integer.MIN_VALUE;
    L8:
        Object r9 = r0.f;
        CoroutineSingletons r2 = CoroutineSingletons.b;
        int r3 = r0.i;
        if (r3 != 0) goto L11;
        ResultKt.b(r9);
        r0.k = this;
        r0.l = r7;
        r0.m = r0;
        r0.n = r7;
        r0.o = r7;
        r0.i = 1;
        throw null;
    L11:
        if (r3 == 1) goto L16;
        if (r3 != 2) goto L15;
        ResultKt.b(r9);
    L20:
        return Unit.f330a;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        FlowCollector r10 = r0.o;
        FlowCollector r4 = r0.n;
        Continuation r5 = r0.m;
        FlowCollector r6 = r0.l;
        FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$2 r11 = r0.k;
        ResultKt.b(r9);
        r0.k = r11;
        r0.l = r6;
        r0.m = r5;
        r0.n = r4;
        r0.i = 2;
        if (r10.d(r9, r0) != r2) goto L20;
        return r2;
    L7:
        r0 = new AnonymousClass1(this, r8);
        goto L8
    }
}
