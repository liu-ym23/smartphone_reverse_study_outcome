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
public final class FlowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1 implements Flow<Object> {

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1$1, reason: invalid class name */
    @Metadata
    @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1", f = "Errors.kt", l = {117, 119}, m = "collect")
    public final class AnonymousClass1 extends ContinuationImpl {
        public /* synthetic */ Object f;
        public int i;
        public final /* synthetic */ FlowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1 j;
        public FlowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1 k;
        public FlowCollector l;
        public Continuation m;
        public FlowCollector n;
        public Throwable o;
        public long p;

        public AnonymousClass1(FlowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1 r1, Continuation r2) {
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

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x0085 -> B:27:0x008b). Please report as a decompilation issue!!! */
    @Override // kotlinx.coroutines.flow.Flow
    public final Object a(FlowCollector r14, Continuation r15) {
        if ((r15 instanceof AnonymousClass1) == false) goto L7;
        AnonymousClass1 r0 = (AnonymousClass1) r15;
        int r1 = r0.i;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.i = r1 - Integer.MIN_VALUE;
    L8:
        Object r16 = r0.f;
        CoroutineSingletons r2 = CoroutineSingletons.b;
        int r3 = r0.i;
        if (r3 == 0) goto L19;
        if (r3 == 1) goto L18;
        if (r3 != 2) goto L17;
        Throwable r13 = r0.o;
        long r5 = r0.p;
        r14 = r0.n;
        Continuation r4 = r0.m;
        FlowCollector r7 = r0.l;
        FlowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1 r8 = r0.k;
        ResultKt.b(r16);
        if (((Boolean) r16).booleanValue() == false) goto L15;
        long r6 = r5 + 1;
        boolean r17 = true;
        FlowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1 this = r8;
    L27:
        if (r17 == false) goto L29;
        FlowCollector r18 = r7;
    L20:
        this.getClass();
        r0.k = this;
        r0.l = r18;
        r0.m = r4;
        r0.n = r14;
        r0.p = r6;
        r0.i = 1;
        Serializable r9 = FlowKt.a(r14, r0);
        if (r9 != r2) goto L23;
        return r2;
    L23:
        FlowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1 r10 = this;
        Continuation r19 = r4;
        FlowCollector r11 = r14;
        FlowCollector r110 = r18;
        r16 = r9;
    L24:
        Throwable r111 = (Throwable) r16;
        if (r111 != null) goto L31;
        r17 = false;
        FlowCollector r12 = r11;
        r4 = r19;
        this = r10;
        r7 = r110;
        r14 = r12;
        goto L27
    L31:
        r10.getClass();
        new Long(r6);
        r0.k = r10;
        r0.l = r110;
        r0.m = r19;
        r0.n = r11;
        r0.p = r6;
        r0.o = r111;
        r0.i = 2;
        throw null;
    L29:
        return Unit.f330a;
    L15:
        throw r13;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        long r112 = r0.p;
        r11 = r0.n;
        Continuation r20 = r0.m;
        FlowCollector r21 = r0.l;
        r10 = r0.k;
        ResultKt.b(r16);
        r19 = r20;
        r110 = r21;
        r6 = r112;
        goto L24
    L19:
        ResultKt.b(r16);
        r6 = 0;
        r18 = r14;
        r4 = r0;
    L7:
        r0 = new AnonymousClass1(this, r15);
        goto L8
    }
}
