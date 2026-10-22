package kotlinx.coroutines.flow.internal;

import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.IndexedValue;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.channels.AbstractChannel;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.internal.Symbol;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
@DebugMetadata(c = "kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2", f = "Combine.kt", l = {57, 79, 82}, m = "invokeSuspend")
final class CombineKt$combineInternal$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public CoroutineScope i;
    public CoroutineScope j;
    public Object[] k;
    public Channel l;
    public AtomicInteger m;
    public byte[] n;
    public Object[] o;
    public int p;
    public int q;
    public int r;
    public byte s;
    public int t;
    public final /* synthetic */ FlowCollector u;
    public final /* synthetic */ Flow[] v;
    public final /* synthetic */ Function0 w;
    public final /* synthetic */ Function3 x;

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2$1, reason: invalid class name */
    @Metadata
    @DebugMetadata(c = "kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2$1", f = "Combine.kt", l = {145}, m = "invokeSuspend")
    final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public CoroutineScope i;
        public CoroutineScope j;
        public Flow k;
        public int l;
        public final /* synthetic */ CombineKt$combineInternal$2 m;
        public final /* synthetic */ int n;
        public final /* synthetic */ Channel o;
        public final /* synthetic */ AtomicInteger p;

        public AnonymousClass1(CombineKt$combineInternal$2 r1, int r2, AbstractChannel r3, AtomicInteger r4, Continuation r5) {
            this.m = r1;
            this.n = r2;
            this.o = r3;
            this.p = r4;
            super(2, r5);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation f(Object r8, Continuation r9) {
            int r2 = this.n;
            AbstractChannel r3 = (AbstractChannel) this.o;
            AnonymousClass1 r6 = new AnonymousClass1(this.m, r2, r3, this.p, r9);
            r6.i = (CoroutineScope) r8;
            return r6;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object i(Object r8) {
            CoroutineSingletons r0 = CoroutineSingletons.b;
            int r1 = this.l;
            Channel r3 = this.o;
            AtomicInteger r4 = this.p;
            if (r1 == 0) goto L11;
            if (r1 != 1) goto L10;
            ResultKt.b(r8);     // Catch: Throwable -> L7
        L15:
            if (r4.decrementAndGet() != 0) goto L19;
            r3.z(null);
        L19:
            return Unit.f330a;
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L11:
            ResultKt.b(r8);
            CoroutineScope r9 = this.i;
            Flow r2 = this.m.v[this.n];     // Catch: Throwable -> L7
            CombineKt$combineInternal$2$1$invokeSuspend$$inlined$collect$1 r6 = new CombineKt$combineInternal$2$1$invokeSuspend$$inlined$collect$1(this);     // Catch: Throwable -> L7
            this.j = r9;     // Catch: Throwable -> L7
            this.k = r2;     // Catch: Throwable -> L7
            this.l = 1;     // Catch: Throwable -> L7
            if (r2.a(r6, this) != r0) goto L15;
            return r0;
        L7:
            th = move-exception;
            if (r4.decrementAndGet() != 0) goto L23;
            r3.z(null);
        L23:
            throw th;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: invoke */
        public final Object mo7invoke(Object r1, Object r2) {
            return ((AnonymousClass1) f(r1, (Continuation) r2)).i(Unit.f330a);
        }
    }

    public CombineKt$combineInternal$2(FlowCollector r1, Flow[] r2, Function0 r3, Function3 r4, Continuation r5) {
        this.u = r1;
        this.v = r2;
        this.w = r3;
        this.x = r4;
        super(2, r5);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation f(Object r8, Continuation r9) {
        Function0 r3 = this.w;
        Function3 r4 = this.x;
        CombineKt$combineInternal$2 r6 = new CombineKt$combineInternal$2(this.u, this.v, r3, r4, r9);
        r6.i = (CoroutineScope) r8;
        return r6;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:47:0x0183 -> B:48:0x0187). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:49:0x0191 -> B:50:0x019e). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object i(Object r28) {
        CoroutineSingletons r7 = CoroutineSingletons.b;
        int r0 = this.t;
        Symbol r8 = NullSurrogateKt.b;
        Unit r9 = Unit.f330a;
        char r11 = 3;
        if (r0 == 0) goto L12;
        if (r0 == 1) goto L11;
        if (r0 == 2) goto L10;
        if (r0 != 3) goto L9;
        int r1 = this.r;
        byte[] r2 = this.n;
        int r3 = this.q;
        AtomicInteger r4 = this.m;
        Channel r5 = this.l;
        Object[] r6 = this.k;
        int r13 = this.p;
        CoroutineScope r14 = this.j;
        ResultKt.b(r28);
        Symbol r23 = r8;
        char r12 = 3;
        int r10 = r1;
    L48:
        Object[] r15 = r6;
        int r16 = r10;
        byte[] r17 = r2;
        Channel r18 = r5;
        CoroutineScope r25 = r14;
        int r19 = r13;
        CoroutineScope r110 = r25;
    L50:
        r11 = r12;
        r8 = r23;
        int r20 = r16;
    L19:
        byte r21 = (byte) (r20 + 1);
        this.j = r110;
        this.p = r19;
        this.k = r15;
        this.l = r18;
        this.m = r4;
        this.q = r3;
        this.n = r17;
        this.s = r21;
        this.t = 1;
        if (r18 == null) goto L53;
        Object r111 = r18.s(this);
        if (r111 != r7) goto L24;
        return r7;
    L24:
        Channel r26 = r18;
        r2 = r17;
        byte r22 = r21;
        Channel r24 = r26;
    L25:
        IndexedValue r112 = (IndexedValue) r111;
        if (r112 == null) goto L51;
    L27:
        int r113 = r112.f333a;
        Object r27 = r15[r113];
        r15[r113] = r112.b;
        if (r27 != r8) goto L31;
        r3 = r3 - 1;
    L31:
        if (r2[r113] == r22) goto L36;
        r2[r113] = r22;
        r112 = (IndexedValue) r24.poll();
        if (r112 != null) goto L27;
    L36:
        if (r3 != 0) goto L49;
        Object[] r29 = (Object[]) this.w.invoke();
        FlowCollector r114 = this.u;
        Function3 r115 = this.x;
        if (r29 != null) goto L44;
        this.j = r110;
        this.p = r19;
        this.k = r15;
        this.l = r24;
        this.m = r4;
        this.q = r3;
        this.n = r2;
        this.r = r22;
        this.o = r29;
        this.t = 2;
        if (r115.b(r114, r15, this) != r7) goto L43;
        return r7;
    L43:
        r23 = r8;
        r12 = r11;
        Channel r210 = r24;
        r16 = r22;
        r17 = r2;
        r18 = r210;
        r19 = r19;
        r110 = r110;
        goto L50
    L44:
        CoroutineScope r116 = r110;
        r23 = r8;
        int r30 = r19;
        Object[] r211 = r15;
        ArraysKt.i(r15, r29, 0, 0, 0, 14);
        this.j = r116;
        this.p = r30;
        this.k = r211;
        this.l = r24;
        this.m = r4;
        this.q = r3;
        this.n = r2;
        this.r = r22;
        this.o = r29;
        r12 = 3;
        this.t = 3;
        if (r115.b(r114, r29, this) != r7) goto L47;
        return r7;
    L47:
        r5 = r24;
        r13 = r30;
        r14 = r116;
        r6 = r211;
        r10 = r22;
        goto L48
    L49:
        r23 = r8;
        r12 = r11;
        Channel r212 = r24;
        r16 = r22;
        r17 = r2;
        r18 = r212;
        goto L50
    L51:
        return r9;
    L53:
        throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.channels.ReceiveChannel<E?>");
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        int r31 = this.r;
        byte[] r32 = this.n;
        r3 = this.q;
        r4 = this.m;
        Channel r33 = this.l;
        Object[] r34 = this.k;
        int r117 = this.p;
        CoroutineScope r118 = this.j;
        ResultKt.b(r28);
        r15 = r34;
        r23 = r8;
        r12 = 3;
        r16 = r31;
        r17 = r32;
        r18 = r33;
        r19 = r117;
        r110 = r118;
        goto L50
    L11:
        byte r35 = this.s;
        r2 = this.n;
        r3 = this.q;
        r4 = this.m;
        Channel r36 = this.l;
        Object[] r37 = this.k;
        int r119 = this.p;
        CoroutineScope r120 = this.j;
        ResultKt.b(r28);
        r15 = r37;
        r24 = r36;
        r111 = r28;
        r19 = r119;
        r110 = r120;
        r22 = r35;
        goto L25
    L12:
        ResultKt.b(r28);
        r110 = this.i;
        r19 = this.v.length;
        if (r19 != 0) goto L15;
        return r9;
    L15:
        r15 = new Object[r19];
        int r38 = 0;
        ArraysKt.l(r8, r15, 0, r19);
        CoroutineStart r39 = null;
        AbstractChannel r121 = ChannelKt.a(r19, null, 6);
        r4 = new AtomicInteger(r19);
        int r40 = 0;
    L16:
        if (r40 >= r19) goto L18;
        AtomicInteger r213 = r4;
        CoroutineStart r122 = r39;
        BuildersKt.a(r110, r122, new AnonymousClass1(this, r40, r121, r213, null), 3);
        r40 = r40 + 1;
        r39 = r122;
        r4 = r213;
        r38 = r38 == true ? 1 : 0;
        goto L16
    L18:
        r17 = new byte[r19];
        r3 = r19;
        r18 = r121;
        r20 = r38;
        goto L19
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public final Object mo7invoke(Object r1, Object r2) {
        return ((CombineKt$combineInternal$2) f(r1, (Continuation) r2)).i(Unit.f330a);
    }
}
