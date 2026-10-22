package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.flow.internal.NullSurrogateKt;
import kotlinx.coroutines.internal.Symbol;
import kotlinx.coroutines.selects.SelectBuilderImpl;
import kotlinx.coroutines.selects.SelectBuilderImpl$onTimeout$$inlined$Runnable$1;
import kotlinx.coroutines.selects.SelectClause1;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1", f = "Delay.kt", l = {354, 358}, m = "invokeSuspend")
final class FlowKt__DelayKt$debounceInternal$1 extends SuspendLambda implements Function3<CoroutineScope, FlowCollector<Object>, Continuation<? super Unit>, Object> {
    public CoroutineScope i;
    public FlowCollector j;
    public CoroutineScope k;
    public FlowCollector l;
    public Ref.ObjectRef m;
    public Ref.ObjectRef n;
    public Ref.LongRef o;
    public Object p;
    public int q;
    public final /* synthetic */ Flow r;
    public final /* synthetic */ Function1 s;

    public FlowKt__DelayKt$debounceInternal$1(Continuation r1, Function1 r2, Flow r3) {
        this.r = r3;
        this.s = r2;
        super(3, r1);
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object b(Object r3, Object r4, Object r5) {
        Flow r1 = this.r;
        FlowKt__DelayKt$debounceInternal$1 r0 = new FlowKt__DelayKt$debounceInternal$1((Continuation) r5, this.s, r1);
        r0.i = (CoroutineScope) r3;
        r0.j = (FlowCollector) r4;
        return r0.i(Unit.f330a);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:71:0x0171 -> B:72:0x0177). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object i(Object r21) {
        CoroutineSingletons r3 = CoroutineSingletons.b;
        int r0 = this.q;
        int r6 = 2;
        Object r7 = null;
        if (r0 == 0) goto L10;
        if (r0 == 1) goto L9;
        if (r0 != 2) goto L8;
        Ref.ObjectRef r1 = this.n;
        Ref.ObjectRef r8 = this.m;
        FlowCollector r9 = this.l;
        CoroutineScope r10 = this.k;
        ResultKt.b(r21);
        CoroutineScope r11 = r10;
        FlowCollector r12 = r9;
        Ref.ObjectRef r13 = r8;
        Ref.ObjectRef r14 = r1;
    L72:
        r6 = 2;
        r7 = null;
    L11:
        Object r2 = r14.b;
        if (r2 == NullSurrogateKt.c) goto L74;
        Ref.LongRef r15 = new Ref.LongRef();
        r15.b = 0;
        if (r2 == null) goto L31;
        Symbol r16 = NullSurrogateKt.f403a;
        if (r2 != r16) goto L18;
        r2 = r7;
    L18:
        long r17 = ((Number) this.s.invoke(r2)).longValue();
        r15.b = r17;
        if (r17 < 0) goto L30;
        if (r17 != 0) goto L31;
        Object r4 = r14.b;
        if (r4 != r16) goto L24;
        r4 = r7;
    L24:
        this.k = r11;
        this.l = r12;
        this.m = r13;
        this.n = r14;
        this.o = r15;
        this.q = 1;
        if (r12.d(r4, this) != r3) goto L27;
        return r3;
    L27:
        Ref.LongRef r5 = r15;
    L28:
        r14.b = r7;
        Ref.ObjectRef r18 = r14;
        Ref.ObjectRef r19 = r13;
        FlowCollector r110 = r12;
        CoroutineScope r111 = r11;
        Ref.LongRef r112 = r5;
    L32:
        boolean r20 = DebugKt.f370a;
        this.k = r111;
        this.l = r110;
        this.m = r19;
        this.n = r18;
        this.o = r112;
        this.q = r6;
        SelectBuilderImpl r113 = new SelectBuilderImpl(this);
        if (r18.b != null) goto L79;
        Ref.LongRef r114 = r112;
        CoroutineScope r115 = r111;
        FlowCollector r116 = r110;
        final SelectBuilderImpl r117 = r113;
    L57:
        SelectClause1 r22 = ((ReceiveChannel) r19.b).n();     // Catch: Throwable -> L63
        SelectBuilderImpl r23 = r117;
        r22.h(r23, new FlowKt__DelayKt$debounceInternal$1$invokeSuspend$$inlined$select$lambda$2(null, r18, r114, r116, r19));     // Catch: Throwable -> L61
    L69:
        if (r23.L() != r3) goto L71;
        return r3;
    L71:
        r14 = r18;
        r13 = r19;
        r11 = r115;
        r12 = r116;
    L61:
        th = th;
    L67:
        r23.M(th);
        goto L69
    L79:
        long r24 = r112.b;     // Catch: Throwable -> L54
        r114 = r112;
        r115 = r111;
        r116 = r110;
        final FlowKt__DelayKt$debounceInternal$1$invokeSuspend$$inlined$select$lambda$1 r25 = new FlowKt__DelayKt$debounceInternal$1$invokeSuspend$$inlined$select$lambda$1(null, r18, r112, r110, r19);     // Catch: Throwable -> L52
        if (r24 > 0) goto L50;
        if (r113.h() == true) goto L42;
        r117 = r113;
        goto L57
    L42:
        r117 = r113;
        Intrinsics.f(r117, "completion");     // Catch: Throwable -> L63
        TypeIntrinsics.b(1, r25);     // Catch: Throwable -> L47
        Object r26 = r25.invoke(r117);     // Catch: Throwable -> L47
        if (r26 == r3) goto L57;
        r117.k(r26);     // Catch: Throwable -> L63
        goto L57
    L47:
        th = move-exception;
        r117.k(ResultKt.a(th));     // Catch: Throwable -> L63
    L63:
        th = th;
    L51:
        r23 = r117;
        goto L67
    L50:
        r117 = r113;
        Runnable r27 = new SelectBuilderImpl$onTimeout$$inlined$Runnable$1(r117, r25);     // Catch: Throwable -> L63
        r117.s(DelayKt.b(getContext()).h(r24, r27, getContext()));     // Catch: Throwable -> L63
    L52:
        th = th;
        r117 = r113;
    L54:
        th = th;
        r115 = r111;
        r116 = r110;
        r117 = r113;
    L65:
        th = th;
        r23 = r113;
        r115 = r111;
        r116 = r110;
        goto L67
    L30:
        throw new IllegalArgumentException("Debounce timeout should not be negative".toString());
    L31:
        r18 = r14;
        r19 = r13;
        r110 = r12;
        r111 = r11;
        r112 = r15;
        goto L32
    L74:
        return Unit.f330a;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        r5 = this.o;
        r14 = this.n;
        r13 = this.m;
        r12 = this.l;
        r11 = this.k;
        ResultKt.b(r21);
        goto L28
    L10:
        ResultKt.b(r21);
        CoroutineScope r28 = this.i;
        FlowCollector r29 = this.j;
        r13 = new Ref.ObjectRef();
        r13.b = ProduceKt.a(r28, 0, new FlowKt__DelayKt$debounceInternal$1$values$1(this, null), 3);
        Ref.ObjectRef r118 = new Ref.ObjectRef();
        r118.b = null;
        r11 = r28;
        r12 = r29;
        r14 = r118;
        goto L11
    }
}
