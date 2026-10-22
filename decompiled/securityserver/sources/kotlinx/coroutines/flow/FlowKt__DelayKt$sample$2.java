package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.flow.internal.NullSurrogateKt;
import kotlinx.coroutines.selects.SelectBuilderImpl;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__DelayKt$sample$2", f = "Delay.kt", l = {355}, m = "invokeSuspend")
final class FlowKt__DelayKt$sample$2 extends SuspendLambda implements Function3<CoroutineScope, FlowCollector<Object>, Continuation<? super Unit>, Object> {
    public CoroutineScope i;
    public FlowCollector j;
    public CoroutineScope k;
    public FlowCollector l;
    public Ref.ObjectRef m;
    public Ref.ObjectRef n;
    public ReceiveChannel o;
    public Object p;
    public int q;
    public final /* synthetic */ Flow r;
    public final /* synthetic */ long s;

    public FlowKt__DelayKt$sample$2(Flow r1, long r2, Continuation r4) {
        this.r = r1;
        this.s = r2;
        super(3, r4);
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object b(Object r5, Object r6, Object r7) {
        Flow r1 = this.r;
        long r2 = this.s;
        FlowKt__DelayKt$sample$2 r0 = new FlowKt__DelayKt$sample$2(r1, r2, (Continuation) r7);
        r0.i = (CoroutineScope) r5;
        r0.j = (FlowCollector) r6;
        return r0.i(Unit.f330a);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x00b1 -> B:26:0x00b4). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object i(Object r18) {
        CoroutineSingletons r2 = CoroutineSingletons.b;
        int r0 = this.q;
        int r3 = 1;
        if (r0 == 0) goto L8;
        if (r0 != 1) goto L7;
        ReceiveChannel r1 = this.o;
        Ref.ObjectRef r4 = this.n;
        Ref.ObjectRef r5 = this.m;
        FlowCollector r6 = this.l;
        CoroutineScope r7 = this.k;
        ResultKt.b(r18);
        CoroutineScope r14 = r7;
        ReceiveChannel r8 = r1;
    L26:
        r3 = 1;
    L17:
        if (r4.b == NullSurrogateKt.c) goto L28;
        this.k = r14;
        this.l = r6;
        this.m = r5;
        this.n = r4;
        this.o = r8;
        this.q = r3;
        SelectBuilderImpl r15 = new SelectBuilderImpl(this);
        ((ReceiveChannel) r5.b).n().h(r15, new FlowKt__DelayKt$sample$2$invokeSuspend$$inlined$select$lambda$1(null, r5, r8, r4, r6));     // Catch: Throwable -> L21
        r8.l().h(r15, new FlowKt__DelayKt$sample$2$invokeSuspend$$inlined$select$lambda$2(null, r5, r8, r4, r6));     // Catch: Throwable -> L21
    L24:
        if (r15.L() != r2) goto L26;
        return r2;
    L21:
        th = move-exception;
        r15.M(th);
        goto L24
    L28:
        return Unit.f330a;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.b(r18);
        CoroutineScope r9 = this.i;
        FlowCollector r10 = this.j;
        r5 = new Ref.ObjectRef();
        r5.b = ProduceKt.a(r9, -1, new FlowKt__DelayKt$sample$2$values$1(this, null), 1);
        Ref.ObjectRef r11 = new Ref.ObjectRef();
        r11.b = null;
        long r12 = this.s;
        if (r12 < 0) goto L11;
        boolean r13 = true;
    L13:
        if (r13 == false) goto L32;
        if (r12 < 0) goto L30;
        r8 = ProduceKt.a(r9, 0, new FlowKt__DelayKt$fixedPeriodTicker$3(r12, r12, null), 1);
        r14 = r9;
        r6 = r10;
        r4 = r11;
        goto L17
    L30:
        throw new IllegalArgumentException(("Expected non-negative initial delay, but has " + r12 + " ms").toString());
    L32:
        throw new IllegalArgumentException(("Expected non-negative delay, but has " + r12 + " ms").toString());
    L11:
        r13 = false;
        goto L13
    }
}
