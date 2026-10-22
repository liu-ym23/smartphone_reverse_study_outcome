package kotlinx.coroutines.flow;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.internal.SafeCollector;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1 implements Flow<Object> {

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1$1, reason: invalid class name */
    @Metadata
    @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1", f = "Emitters.kt", l = {114, 121, 128}, m = "collect")
    public final class AnonymousClass1 extends ContinuationImpl {
        public /* synthetic */ Object f;
        public int i;
        public final /* synthetic */ FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1 j;
        public FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1 k;
        public FlowCollector l;
        public Continuation m;
        public FlowCollector n;
        public Serializable o;

        public AnonymousClass1(FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1 r1, Continuation r2) {
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
        Unit r4 = Unit.f330a;
        if (r3 != 0) goto L11;
        ResultKt.b(r11);
        r0.k = this;     // Catch: Throwable -> L37
        r0.l = r9;     // Catch: Throwable -> L37
        r0.m = r0;     // Catch: Throwable -> L37
        r0.n = r9;     // Catch: Throwable -> L37
        r0.i = 1;     // Catch: Throwable -> L37
        throw null;     // Catch: Throwable -> L37
    L37:
        th = move-exception;
        FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1 r7 = this;
        Throwable th = th;
        Continuation r5 = r0;
        FlowCollector r12 = r9;
    L39:
        ThrowingCollector r6 = new ThrowingCollector(th);
        r7.getClass();
        r0.k = r7;
        r0.l = r9;
        r0.m = r5;
        r0.n = r12;
        r0.o = th;
        r0.i = 2;
        FlowKt__EmittersKt.a(r6, th, r0);
        if (r4 != r2) goto L51;
        return r2;
    L51:
        throw th;
    L11:
        if (r3 == 1) goto L23;
        if (r3 == 2) goto L22;
        if (r3 != 3) goto L21;
        SafeCollector r8 = (SafeCollector) r0.o;
        ResultKt.b(r11);     // Catch: Throwable -> L18
        r8.j();
        return r4;
    L18:
        th = th;
    L30:
        r8.j();
        throw th;
    L21:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L22:
        Throwable r13 = (Throwable) r0.o;
        ResultKt.b(r11);
        throw r13;
    L23:
        FlowCollector r14 = r0.n;
        r5 = r0.m;
        FlowCollector r15 = r0.l;
        r7 = r0.k;
        ResultKt.b(r11);     // Catch: Throwable -> L32
        CoroutineContext r16 = r0.c;
        Intrinsics.c(r16);
        SafeCollector r17 = new SafeCollector(r14, r16);
        r7.getClass();     // Catch: Throwable -> L28
        r0.k = r7;     // Catch: Throwable -> L28
        r0.l = r15;     // Catch: Throwable -> L28
        r0.m = r5;     // Catch: Throwable -> L28
        r0.n = r14;     // Catch: Throwable -> L28
        r0.o = r17;     // Catch: Throwable -> L28
        r0.i = 3;     // Catch: Throwable -> L28
        throw null;     // Catch: Throwable -> L28
    L28:
        th = th;
        r8 = r17;
    L32:
        th = th;
        r12 = r14;
        r9 = r15;
    L7:
        r0 = new AnonymousClass1(this, r10);
        goto L8
    }
}
