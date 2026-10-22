package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.AbstractTimeSource;
import kotlinx.coroutines.AbstractTimeSourceKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.EventLoop_commonKt;
import kotlinx.coroutines.GlobalScope;

/* JADX INFO: compiled from: TickerChannels.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a/\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u0006H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u0007\u001a/\u0010\b\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u0006H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u0007\u001a4\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00010\n2\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000eH\u0007\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u000f"}, d2 = {"fixedDelayTicker", "", "delayMillis", "", "initialDelayMillis", "channel", "Lkotlinx/coroutines/channels/SendChannel;", "(JJLkotlinx/coroutines/channels/SendChannel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fixedPeriodTicker", "ticker", "Lkotlinx/coroutines/channels/ReceiveChannel;", "context", "Lkotlin/coroutines/CoroutineContext;", "mode", "Lkotlinx/coroutines/channels/TickerMode;", "kotlinx-coroutines-core"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class TickerChannelsKt {

    /* JADX INFO: renamed from: kotlinx.coroutines.channels.TickerChannelsKt$fixedDelayTicker$1, reason: invalid class name */
    /* JADX INFO: compiled from: TickerChannels.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "kotlinx.coroutines.channels.TickerChannelsKt", f = "TickerChannels.kt", i = {0, 0, 1, 1, 2, 2}, l = {106, 108, 109}, m = "fixedDelayTicker", n = {"channel", "delayMillis", "channel", "delayMillis", "channel", "delayMillis"}, s = {"L$0", "J$0", "L$0", "J$0", "L$0", "J$0"})
    static final class AnonymousClass1 extends ContinuationImpl {
        long J$0;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> r1) {
            super(r1);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r7) {
            this.result = r7;
            this.label |= Integer.MIN_VALUE;
            return TickerChannelsKt.access$fixedDelayTicker(0, 0, null, this);
        }
    }

    /* JADX INFO: renamed from: kotlinx.coroutines.channels.TickerChannelsKt$fixedPeriodTicker$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: TickerChannels.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "kotlinx.coroutines.channels.TickerChannelsKt", f = "TickerChannels.kt", i = {0, 0, 0, 1, 1, 1, 2, 2, 2, 3, 3, 3}, l = {84, 88, 94, 96}, m = "fixedPeriodTicker", n = {"channel", "delayMillis", "deadline", "channel", "deadline", "delayNs", "channel", "deadline", "delayNs", "channel", "deadline", "delayNs"}, s = {"L$0", "J$0", "J$1", "L$0", "J$0", "J$1", "L$0", "J$0", "J$1", "L$0", "J$0", "J$1"})
    static final class C04101 extends ContinuationImpl {
        long J$0;
        long J$1;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C04101(Continuation<? super C04101> r1) {
            super(r1);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r7) {
            this.result = r7;
            this.label |= Integer.MIN_VALUE;
            return TickerChannelsKt.access$fixedPeriodTicker(0, 0, null, this);
        }
    }

    /* JADX INFO: renamed from: kotlinx.coroutines.channels.TickerChannelsKt$ticker$3, reason: invalid class name */
    /* JADX INFO: compiled from: TickerChannels.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00010\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/channels/ProducerScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "kotlinx.coroutines.channels.TickerChannelsKt$ticker$3", f = "TickerChannels.kt", i = {}, l = {72, 73}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass3 extends SuspendLambda implements Function2<ProducerScope<? super Unit>, Continuation<? super Unit>, Object> {
        final /* synthetic */ long $delayMillis;
        final /* synthetic */ long $initialDelayMillis;
        final /* synthetic */ TickerMode $mode;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX INFO: renamed from: kotlinx.coroutines.channels.TickerChannelsKt$ticker$3$WhenMappings */
        /* JADX INFO: compiled from: TickerChannels.kt */
        @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

            static {
                int[] r0 = new int[TickerMode.values().length];
                r0[TickerMode.FIXED_PERIOD.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
            L9:
                r0[TickerMode.FIXED_DELAY.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
            L5:
                $EnumSwitchMapping$0 = r0;
            }
        }

        AnonymousClass3(TickerMode r1, long r2, long r4, Continuation<? super AnonymousClass3> r6) {
            this.$mode = r1;
            this.$delayMillis = r2;
            this.$initialDelayMillis = r4;
            super(2, r6);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r9, Continuation<?> r10) {
            AnonymousClass3 r7 = new AnonymousClass3(this.$mode, this.$delayMillis, this.$initialDelayMillis, r10);
            r7.L$0 = r9;
            return r7;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(ProducerScope<? super Unit> r1, Continuation<? super Unit> r2) {
            return invoke2(r1, r2);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(ProducerScope<? super Unit> r1, Continuation<? super Unit> r2) {
            return ((AnonymousClass3) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r11) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L9;
            if (r1 == 1) goto L6;
            if (r1 == 2) goto L6;
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L6:
            ResultKt.throwOnFailure(r11);
        L20:
            return Unit.INSTANCE;
        L9:
            ResultKt.throwOnFailure(r11);
            ProducerScope r12 = (ProducerScope) this.L$0;
            TickerMode r2 = this.$mode;
            int r3 = WhenMappings.$EnumSwitchMapping$0[r2.ordinal()];
            if (r3 == 1) goto L16;
            if (r3 != 2) goto L20;
            this.label = 2;
            if (TickerChannelsKt.access$fixedDelayTicker(this.$delayMillis, this.$initialDelayMillis, r12.getChannel(), this) != r0) goto L20;
            return r0;
        L16:
            this.label = 1;
            if (TickerChannelsKt.access$fixedPeriodTicker(this.$delayMillis, this.$initialDelayMillis, r12.getChannel(), this) != r0) goto L20;
            return r0;
        }
    }

    public static final /* synthetic */ Object access$fixedDelayTicker(long r0, long r2, SendChannel r4, Continuation r5) {
        return fixedDelayTicker(r0, r2, r4, r5);
    }

    public static final /* synthetic */ Object access$fixedPeriodTicker(long r0, long r2, SendChannel r4, Continuation r5) {
        return fixedPeriodTicker(r0, r2, r4, r5);
    }

    public static /* synthetic */ ReceiveChannel ticker$default(long r0, long r2, EmptyCoroutineContext r4, TickerMode r5, int r6, Object r7) {
        if ((r6 & 2) == 0) goto L6;
        r2 = r0;
    L6:
        if ((r6 & 4) == 0) goto L9;
        r4 = EmptyCoroutineContext.INSTANCE;
    L9:
        if ((r6 & 8) == 0) goto L12;
        r5 = TickerMode.FIXED_PERIOD;
    L12:
        return ticker(r0, r2, r4, r5);
    }

    public static final ReceiveChannel<Unit> ticker(long r11, long r13, CoroutineContext r15, TickerMode r16) {
        boolean r7 = true;
        if (r11 < 0) goto L5;
        boolean r6 = true;
    L7:
        if (r6 == false) goto L18;
        if (r13 >= 0) goto L12;
        r7 = false;
    L12:
        if (r7 == false) goto L16;
        return ProduceKt.produce(GlobalScope.INSTANCE, Dispatchers.getUnconfined().plus(r15), 0, new AnonymousClass3(r16, r11, r13, null));
    L16:
        throw new IllegalArgumentException(("Expected non-negative initial delay, but has " + r13 + " ms").toString());
    L18:
        throw new IllegalArgumentException(("Expected non-negative delay, but has " + r11 + " ms").toString());
    L5:
        r6 = false;
        goto L7
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:46:0x00fd -> B:31:0x00ab). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:48:0x0113 -> B:15:0x003e). Please report as a decompilation issue!!! */
    private static final Object fixedPeriodTicker(long r18, long r20, SendChannel<? super Unit> r22, Continuation<? super Unit> r23) {
        if ((r23 instanceof C04101) == false) goto L7;
        C04101 r1 = (C04101) r23;
        if ((r1.label & Integer.MIN_VALUE) == 0) goto L7;
        r1.label -= Integer.MIN_VALUE;
    L8:
        Object r0 = r1.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r1.label;
        if (r3 == 0) goto L22;
        if (r3 == 1) goto L21;
        if (r3 == 2) goto L20;
        if (r3 == 3) goto L18;
        if (r3 != 4) goto L17;
        long r7 = r1.J$1;
        long r9 = r1.J$0;
        SendChannel r4 = (SendChannel) r1.L$0;
        ResultKt.throwOnFailure(r0);
        char r11 = 4;
        char r5 = 3;
    L15:
        long r16 = r7;
        long r8 = r9;
        long r10 = r16;
        SendChannel r6 = r4;
    L31:
        long r12 = r8 + r10;
        Unit r13 = Unit.INSTANCE;
        r1.L$0 = r6;
        r1.J$0 = r12;
        r1.J$1 = r10;
        r1.label = 2;
        if (r6.send(r13, r1) != r2) goto L34;
        return r2;
    L34:
        r4 = r6;
        r7 = r10;
        r9 = r12;
    L35:
        AbstractTimeSource r14 = AbstractTimeSourceKt.getTimeSource();
        if (r14 == null) goto L38;
        long r15 = r14.nanoTime();
    L39:
        long r17 = RangesKt.coerceAtLeast(r9 - r15, 0);
        if (r17 == 0) goto L42;
    L47:
        r5 = 3;
        long r19 = EventLoop_commonKt.delayNanosToMillis(r17);
        r1.L$0 = r4;
        r1.J$0 = r9;
        r1.J$1 = r7;
        r11 = 4;
        r1.label = 4;
        if (DelayKt.delay(r19, r1) != r2) goto L15;
        return r2;
    L42:
        if (r7 == 0) goto L47;
        long r21 = r7 - ((r15 - r9) % r7);
        long r24 = r15 + r21;
        long r25 = EventLoop_commonKt.delayNanosToMillis(r21);
        r1.L$0 = r4;
        r1.J$0 = r24;
        r1.J$1 = r7;
        char r26 = 3;
        r1.label = 3;
        if (DelayKt.delay(r25, r1) == r2) goto L45;
    L19:
        long r110 = r7;
        r8 = r24;
        r10 = r110;
        r6 = r4;
        goto L31
    L45:
        return r2;
    L38:
        r15 = System.nanoTime();
        goto L39
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        r7 = r1.J$1;
        r24 = r1.J$0;
        r4 = (SendChannel) r1.L$0;
        ResultKt.throwOnFailure(r0);
        r26 = 3;
        goto L19
    L20:
        r7 = r1.J$1;
        r9 = r1.J$0;
        r4 = (SendChannel) r1.L$0;
        ResultKt.throwOnFailure(r0);
        goto L35
    L21:
        r8 = r1.J$1;
        long r27 = r1.J$0;
        SendChannel r28 = (SendChannel) r1.L$0;
        ResultKt.throwOnFailure(r0);
        r6 = r28;
        long r111 = r27;
    L30:
        r10 = EventLoop_commonKt.delayToNanos(r111);
        goto L31
    L22:
        ResultKt.throwOnFailure(r0);
        AbstractTimeSource r29 = AbstractTimeSourceKt.getTimeSource();
        if (r29 == null) goto L25;
        long r30 = r29.nanoTime();
    L26:
        long r31 = r30 + EventLoop_commonKt.delayToNanos(r20);
        r6 = r22;
        r1.L$0 = r6;
        r111 = r18;
        r1.J$0 = r111;
        r1.J$1 = r31;
        r1.label = 1;
        if (DelayKt.delay(r20, r1) != r2) goto L29;
        return r2;
    L29:
        r8 = r31;
        goto L30
    L25:
        r30 = System.nanoTime();
    L7:
        r1 = new C04101(r23);
        goto L8
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x007e -> B:14:0x0035). Please report as a decompilation issue!!! */
    private static final Object fixedDelayTicker(long r6, long r8, SendChannel<? super Unit> r10, Continuation<? super Unit> r11) {
        if ((r11 instanceof AnonymousClass1) == false) goto L7;
        AnonymousClass1 r0 = (AnonymousClass1) r11;
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r12 = r0.result;
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r0.label;
        if (r2 == 0) goto L19;
        if (r2 == 1) goto L18;
        if (r2 == 2) goto L17;
        if (r2 != 3) goto L16;
        r6 = r0.J$0;
        SendChannel<? super Unit> r9 = (SendChannel) r0.L$0;
        ResultKt.throwOnFailure(r12);
    L14:
        r10 = r9;
    L22:
        Unit r13 = Unit.INSTANCE;
        r0.L$0 = r10;
        r0.J$0 = r6;
        r0.label = 2;
        if (r10.send(r13, r0) != r1) goto L25;
        return r1;
    L25:
        r9 = r10;
    L26:
        r0.L$0 = r9;
        r0.J$0 = r6;
        r0.label = 3;
        if (DelayKt.delay(r6, r0) != r1) goto L14;
        return r1;
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        r6 = r0.J$0;
        r9 = (SendChannel) r0.L$0;
        ResultKt.throwOnFailure(r12);
        goto L26
    L18:
        r6 = r0.J$0;
        r10 = (SendChannel) r0.L$0;
        ResultKt.throwOnFailure(r12);
        goto L22
    L19:
        ResultKt.throwOnFailure(r12);
        r0.L$0 = r10;
        r0.J$0 = r6;
        r0.label = 1;
        if (DelayKt.delay(r8, r0) != r1) goto L22;
        return r1;
    L7:
        r0 = new AnonymousClass1(r11);
        goto L8
    }
}
