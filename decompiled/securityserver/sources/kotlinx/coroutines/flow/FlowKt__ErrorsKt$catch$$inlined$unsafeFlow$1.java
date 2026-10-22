package kotlinx.coroutines.flow;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class FlowKt__ErrorsKt$catch$$inlined$unsafeFlow$1 implements Flow<Object> {

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__ErrorsKt$catch$$inlined$unsafeFlow$1$1, reason: invalid class name */
    @Metadata
    @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ErrorsKt$catch$$inlined$unsafeFlow$1", f = "Errors.kt", l = {113, 114}, m = "collect")
    public final class AnonymousClass1 extends ContinuationImpl {
        public /* synthetic */ Object f;
        public int i;
        public final /* synthetic */ FlowKt__ErrorsKt$catch$$inlined$unsafeFlow$1 j;
        public FlowKt__ErrorsKt$catch$$inlined$unsafeFlow$1 k;
        public FlowCollector l;
        public Continuation m;
        public FlowCollector n;

        public AnonymousClass1(FlowKt__ErrorsKt$catch$$inlined$unsafeFlow$1 r1, Continuation r2) {
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
        if (r3 == 0) goto L16;
        if (r3 == 1) goto L15;
        if (r3 != 2) goto L14;
        ResultKt.b(r9);
    L23:
        return Unit.f330a;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        FlowCollector r10 = r0.n;
        Continuation r6 = r0.m;
        FlowCollector r4 = r0.l;
        FlowKt__ErrorsKt$catch$$inlined$unsafeFlow$1 r5 = r0.k;
        ResultKt.b(r9);
        Continuation r11 = r6;
        FlowKt__ErrorsKt$catch$$inlined$unsafeFlow$1 this = r5;
        Object r12 = r9;
        FlowCollector r13 = r10;
    L21:
        if (((Throwable) r12) == null) goto L23;
        this.getClass();
        r0.k = this;
        r0.l = r4;
        r0.m = r11;
        r0.n = r13;
        r0.getClass();
        r0.i = 2;
        throw null;
    L16:
        ResultKt.b(r9);
        r0.k = this;
        r0.l = r7;
        r0.m = r0;
        r0.n = r7;
        r0.i = 1;
        Serializable r14 = FlowKt.a(r7, r0);
        if (r14 != r2) goto L19;
        return r2;
    L19:
        r4 = r7;
        r12 = r14;
        r13 = r4;
        r11 = r0;
    L7:
        r0 = new AnonymousClass1(this, r8);
        goto L8
    }
}
