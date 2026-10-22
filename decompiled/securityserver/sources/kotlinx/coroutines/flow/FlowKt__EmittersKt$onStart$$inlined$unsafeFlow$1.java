package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.internal.SafeCollector;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1 implements Flow<Object> {

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1$1, reason: invalid class name */
    @Metadata
    @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1", f = "Emitters.kt", l = {116, 120}, m = "collect")
    public final class AnonymousClass1 extends ContinuationImpl {
        public /* synthetic */ Object f;
        public int i;
        public final /* synthetic */ FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1 j;
        public FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1 k;
        public FlowCollector l;
        public Continuation m;
        public FlowCollector n;
        public SafeCollector o;

        public AnonymousClass1(FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1 r1, Continuation r2) {
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
    public final Object a(FlowCollector r7, Continuation r8) {
        if ((r8 instanceof AnonymousClass1) == false) goto L7;
        AnonymousClass1 r0 = (AnonymousClass1) r8;
        int r1 = r0.i;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.i = r1 - Integer.MIN_VALUE;
    L8:
        Object r9 = r0.f;
        int r2 = r0.i;
        if (r2 != 0) goto L11;
        ResultKt.b(r9);
        CoroutineContext r10 = r0.c;
        Intrinsics.c(r10);
        SafeCollector r3 = new SafeCollector(r7, r10);
        r0.k = this;     // Catch: Throwable -> L26
        r0.l = r7;     // Catch: Throwable -> L26
        r0.m = r0;     // Catch: Throwable -> L26
        r0.n = r7;     // Catch: Throwable -> L26
        r0.o = r3;     // Catch: Throwable -> L26
        r0.i = 1;     // Catch: Throwable -> L26
        throw null;     // Catch: Throwable -> L26
    L26:
        th = th;
        SafeCollector r11 = r3;
    L28:
        r11.j();
        throw th;
    L11:
        if (r2 == 1) goto L17;
        if (r2 != 2) goto L16;
        ResultKt.b(r9);
        return Unit.f330a;
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        r11 = r0.o;
        FlowCollector r4 = r0.n;
        Continuation r5 = r0.m;
        FlowCollector r6 = r0.l;
        FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1 r12 = r0.k;
        ResultKt.b(r9);     // Catch: Throwable -> L21
        r11.j();
        r12.getClass();
        r0.k = r12;
        r0.l = r6;
        r0.m = r5;
        r0.n = r4;
        r0.o = r11;
        r0.i = 2;
        throw null;
    L21:
        th = th;
    L7:
        r0 = new AnonymousClass1(this, r8);
        goto L8
    }
}
