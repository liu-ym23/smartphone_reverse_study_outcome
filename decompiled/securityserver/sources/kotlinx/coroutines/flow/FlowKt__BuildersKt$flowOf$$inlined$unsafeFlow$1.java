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
public final class FlowKt__BuildersKt$flowOf$$inlined$unsafeFlow$1 implements Flow<Object> {

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__BuildersKt$flowOf$$inlined$unsafeFlow$1$1, reason: invalid class name */
    @Metadata
    @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__BuildersKt$flowOf$$inlined$unsafeFlow$1", f = "Builders.kt", l = {114}, m = "collect")
    public final class AnonymousClass1 extends ContinuationImpl {
        public /* synthetic */ Object f;
        public int i;
        public final /* synthetic */ FlowKt__BuildersKt$flowOf$$inlined$unsafeFlow$1 j;
        public FlowKt__BuildersKt$flowOf$$inlined$unsafeFlow$1 k;
        public FlowCollector l;
        public Continuation m;
        public FlowCollector n;
        public Object[] o;
        public Object p;
        public int q;
        public int r;

        public AnonymousClass1(FlowKt__BuildersKt$flowOf$$inlined$unsafeFlow$1 r1, Continuation r2) {
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
        AnonymousClass1 r11 = (AnonymousClass1) r10;
        int r0 = r11.i;
        if ((r0 & Integer.MIN_VALUE) == 0) goto L7;
        r11.i = r0 - Integer.MIN_VALUE;
    L8:
        Object r8 = r11.f;
        CoroutineSingletons r12 = CoroutineSingletons.b;
        int r1 = r11.i;
        if (r1 != 0) goto L11;
        ResultKt.b(r8);
        throw null;
    L11:
        if (r1 != 1) goto L21;
        int r2 = r11.r;
        int r3 = r11.q;
        Object[] r4 = r11.o;
        FlowCollector r5 = r11.n;
        Continuation r6 = r11.m;
        FlowCollector r7 = r11.l;
        FlowKt__BuildersKt$flowOf$$inlined$unsafeFlow$1 r13 = r11.k;
        ResultKt.b(r8);
    L13:
        r2 = r2 + 1;
        if (r2 >= r3) goto L19;
        Object r14 = r4[r2];
        r11.k = r13;
        r11.l = r7;
        r11.m = r6;
        r11.n = r5;
        r11.o = r4;
        r11.q = r3;
        r11.r = r2;
        r11.p = r14;
        r11.i = 1;
        if (r5.d(r14, r11) != r12) goto L13;
        return r12;
    L19:
        return Unit.f330a;
    L21:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L7:
        r11 = new AnonymousClass1(this, r10);
        goto L8
    }
}
