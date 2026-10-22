package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.flow.internal.SafeCollector;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class FlowKt__EmittersKt$onEmpty$$inlined$unsafeFlow$1 implements Flow<Object> {

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__EmittersKt$onEmpty$$inlined$unsafeFlow$1$1, reason: invalid class name */
    @Metadata
    @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__EmittersKt$onEmpty$$inlined$unsafeFlow$1", f = "Emitters.kt", l = {115, 122}, m = "collect")
    public final class AnonymousClass1 extends ContinuationImpl {
        public /* synthetic */ Object f;
        public int i;
        public final /* synthetic */ FlowKt__EmittersKt$onEmpty$$inlined$unsafeFlow$1 j;
        public FlowKt__EmittersKt$onEmpty$$inlined$unsafeFlow$1 k;
        public FlowCollector l;
        public Continuation m;
        public FlowCollector n;
        public Ref.BooleanRef o;
        public SafeCollector p;

        public AnonymousClass1(FlowKt__EmittersKt$onEmpty$$inlined$unsafeFlow$1 r1, Continuation r2) {
            this.j = r1;
            super(r2);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object i(Object r2) {
            this.f = r2;
            this.i |= Integer.MIN_VALUE;
            this.j.a(null, this);
            return Unit.f330a;
        }
    }

    @Override // kotlinx.coroutines.flow.Flow
    public final Object a(FlowCollector r8, Continuation r9) {
        if ((r9 instanceof AnonymousClass1) == false) goto L7;
        AnonymousClass1 r0 = (AnonymousClass1) r9;
        int r1 = r0.i;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.i = r1 - Integer.MIN_VALUE;
    L8:
        Object r10 = r0.f;
        int r2 = r0.i;
        if (r2 != 0) goto L11;
        ResultKt.b(r10);
        Ref.BooleanRef r11 = new Ref.BooleanRef();
        r11.b = true;
        r0.k = this;
        r0.l = r8;
        r0.m = r0;
        r0.n = r8;
        r0.o = r11;
        r0.p = null;
        r0.i = 1;
        throw null;
    L11:
        if (r2 == 1) goto L20;
        if (r2 != 2) goto L19;
        SafeCollector r7 = r0.p;
        ResultKt.b(r10);     // Catch: Throwable -> L16
        r7.j();
    L23:
        return Unit.f330a;
    L16:
        th = th;
    L29:
        r7.j();
        throw th;
    L19:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L20:
        Flow r12 = (Flow) r0.p;
        Ref.BooleanRef r13 = r0.o;
        FlowCollector r3 = r0.n;
        Continuation r4 = r0.m;
        FlowCollector r5 = r0.l;
        FlowKt__EmittersKt$onEmpty$$inlined$unsafeFlow$1 r6 = r0.k;
        ResultKt.b(r10);
        if (r13.b == false) goto L23;
        CoroutineContext r14 = r0.c;
        Intrinsics.c(r14);
        SafeCollector r15 = new SafeCollector(r3, r14);
        r6.getClass();     // Catch: Throwable -> L27
        r0.k = r6;     // Catch: Throwable -> L27
        r0.l = r5;     // Catch: Throwable -> L27
        r0.m = r4;     // Catch: Throwable -> L27
        r0.n = r3;     // Catch: Throwable -> L27
        r0.o = r13;     // Catch: Throwable -> L27
        r0.p = r15;     // Catch: Throwable -> L27
        r0.i = 2;     // Catch: Throwable -> L27
        throw null;     // Catch: Throwable -> L27
    L27:
        th = th;
        r7 = r15;
    L7:
        r0 = new AnonymousClass1(this, r9);
        goto L8
    }
}
