package kotlinx.coroutines.flow;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Ref;
import kotlin.time.Duration;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.flow.internal.FlowCoroutineKt;
import kotlinx.coroutines.flow.internal.NullSurrogateKt;
import kotlinx.coroutines.selects.SelectBuilderImpl;

/* JADX INFO: compiled from: Delay.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a2\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00050\u0004H\u0007\u001a:\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00070\u0004H\u0007ø\u0001\u0000¢\u0006\u0002\b\b\u001a&\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0005H\u0007\u001a3\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0007H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\t\u0010\n\u001a7\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00050\u0004H\u0002¢\u0006\u0002\b\r\u001a$\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f*\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00052\b\b\u0002\u0010\u0013\u001a\u00020\u0005H\u0000\u001a&\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u0005H\u0007\u001a3\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\u0016\u001a\u00020\u0007H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0017\u0010\n\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\u0018"}, d2 = {"debounce", "Lkotlinx/coroutines/flow/Flow;", ExifInterface.GPS_DIRECTION_TRUE, "timeoutMillis", "Lkotlin/Function1;", "", "timeout", "Lkotlin/time/Duration;", "debounceDuration", "debounce-HG0u8IE", "(Lkotlinx/coroutines/flow/Flow;J)Lkotlinx/coroutines/flow/Flow;", "debounceInternal", "timeoutMillisSelector", "debounceInternal$FlowKt__DelayKt", "fixedPeriodTicker", "Lkotlinx/coroutines/channels/ReceiveChannel;", "", "Lkotlinx/coroutines/CoroutineScope;", "delayMillis", "initialDelayMillis", "sample", "periodMillis", "period", "sample-HG0u8IE", "kotlinx-coroutines-core"}, k = 5, mv = {1, 6, 0}, xi = 48, xs = "kotlinx/coroutines/flow/FlowKt")
final /* synthetic */ class FlowKt__DelayKt {

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__DelayKt$fixedPeriodTicker$3, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Delay.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00010\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/channels/ProducerScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__DelayKt$fixedPeriodTicker$3", f = "Delay.kt", i = {0, 1, 2}, l = {314, 316, 317}, m = "invokeSuspend", n = {"$this$produce", "$this$produce", "$this$produce"}, s = {"L$0", "L$0", "L$0"})
    static final class C04833 extends SuspendLambda implements Function2<ProducerScope<? super Unit>, Continuation<? super Unit>, Object> {
        final /* synthetic */ long $delayMillis;
        final /* synthetic */ long $initialDelayMillis;
        private /* synthetic */ Object L$0;
        int label;

        C04833(long r1, long r3, Continuation<? super C04833> r5) {
            this.$initialDelayMillis = r1;
            this.$delayMillis = r3;
            super(2, r5);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
            C04833 r6 = new C04833(this.$initialDelayMillis, this.$delayMillis, r9);
            r6.L$0 = r8;
            return r6;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(ProducerScope<? super Unit> r1, Continuation<? super Unit> r2) {
            return invoke2(r1, r2);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(ProducerScope<? super Unit> r1, Continuation<? super Unit> r2) {
            return ((C04833) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0063 -> B:15:0x0042). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r8) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L12;
            if (r1 == 1) goto L11;
            if (r1 == 2) goto L10;
            if (r1 == 3) goto L11;
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L10:
            ProducerScope r2 = (ProducerScope) this.L$0;
            ResultKt.throwOnFailure(r8);
        L18:
            this.L$0 = r2;
            this.label = 3;
            if (DelayKt.delay(this.$delayMillis, this) == r0) goto L20;
        L15:
            this.L$0 = r2;
            this.label = 2;
            if (r2.getChannel().send(Unit.INSTANCE, this) != r0) goto L18;
            return r0;
        L20:
            return r0;
        L11:
            r2 = (ProducerScope) this.L$0;
            ResultKt.throwOnFailure(r8);
            goto L15
        L12:
            ResultKt.throwOnFailure(r8);
            r2 = (ProducerScope) this.L$0;
            this.L$0 = r2;
            this.label = 1;
            if (DelayKt.delay(this.$initialDelayMillis, this) != r0) goto L15;
            return r0;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__DelayKt$sample$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Delay.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0005H\u008a@"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/CoroutineScope;", "downstream", "Lkotlinx/coroutines/flow/FlowCollector;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__DelayKt$sample$2", f = "Delay.kt", i = {0, 0, 0, 0}, l = {352}, m = "invokeSuspend", n = {"downstream", "values", "lastValue", "ticker"}, s = {"L$0", "L$1", "L$2", "L$3"})
    static final class C04842<T> extends SuspendLambda implements Function3<CoroutineScope, FlowCollector<? super T>, Continuation<? super Unit>, Object> {
        final /* synthetic */ long $periodMillis;
        final /* synthetic */ Flow<T> $this_sample;
        private /* synthetic */ Object L$0;
        /* synthetic */ Object L$1;
        Object L$2;
        Object L$3;
        int label;

        /* JADX WARN: Multi-variable type inference failed */
        C04842(long r1, Flow<? extends T> r3, Continuation<? super C04842> r4) {
            this.$periodMillis = r1;
            this.$this_sample = r3;
            super(3, r4);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r1, Object r2, Continuation<? super Unit> r3) {
            return invoke(r1, (FlowCollector) r2, r3);
        }

        public final Object invoke(CoroutineScope r4, FlowCollector<? super T> r5, Continuation<? super Unit> r6) {
            C04842 r0 = new C04842(this.$periodMillis, this.$this_sample, r6);
            r0.L$0 = r4;
            r0.L$1 = r5;
            return r0.invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r14) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ReceiveChannel r2 = (ReceiveChannel) this.L$3;
            Ref.ObjectRef r4 = (Ref.ObjectRef) this.L$2;
            ReceiveChannel r5 = (ReceiveChannel) this.L$1;
            FlowCollector r6 = (FlowCollector) this.L$0;
            ResultKt.throwOnFailure(r14);
        L10:
            if (r4.element == NullSurrogateKt.DONE) goto L22;
            this.L$0 = r6;
            this.L$1 = r5;
            this.L$2 = r4;
            this.L$3 = r2;
            this.label = 1;
            C04842<T> r15 = this;
            SelectBuilderImpl r7 = new SelectBuilderImpl(r15);
            SelectBuilderImpl r8 = r7;     // Catch: Throwable -> L14
            r8.invoke(r5.getOnReceiveCatching(), new FlowKt__DelayKt$sample$2$1$1(r4, r2, null));     // Catch: Throwable -> L14
            r8.invoke(r2.getOnReceive(), new FlowKt__DelayKt$sample$2$1$2(r4, r6, null));     // Catch: Throwable -> L14
        L16:
            Object r9 = r7.getResult();
            if (r9 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L19;
            DebugProbesKt.probeCoroutineSuspended(r15);
        L19:
            if (r9 != r0) goto L10;
            return r0;
        L14:
            th = move-exception;
            r7.handleBuilderException(th);
            goto L16
        L22:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r14);
            CoroutineScope r16 = (CoroutineScope) this.L$0;
            FlowCollector r3 = (FlowCollector) this.L$1;
            ReceiveChannel r11 = ProduceKt.produce$default(r16, null, -1, new FlowKt__DelayKt$sample$2$values$1(this.$this_sample, null), 1, null);
            Ref.ObjectRef r12 = new Ref.ObjectRef();
            ReceiveChannel r17 = FlowKt.fixedPeriodTicker$default(r16, this.$periodMillis, 0, 2, null);
            r6 = r3;
            r5 = r11;
            r4 = r12;
            r2 = r17;
            goto L10
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> Flow<T> debounce(Flow<? extends T> r2, final long r3) {
        if (r3 < 0) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L12;
        if (r3 != 0) goto L10;
        return r2;
    L10:
        return debounceInternal$FlowKt__DelayKt(r2, new AnonymousClass2(r3));
    L12:
        throw new IllegalArgumentException("Debounce timeout should not be negative".toString());
    L5:
        r1 = false;
        goto L6
    }

    public static final <T> Flow<T> debounce(Flow<? extends T> r0, Function1<? super T, Long> r1) {
        return debounceInternal$FlowKt__DelayKt(r0, r1);
    }

    /* JADX INFO: renamed from: debounce-HG0u8IE, reason: not valid java name */
    public static final <T> Flow<T> m2307debounceHG0u8IE(Flow<? extends T> r0, long r1) {
        return FlowKt.debounce(r0, DelayKt.m2264toDelayMillisLRDsOJo(r1));
    }

    public static final <T> Flow<T> debounceDuration(Flow<? extends T> r1, final Function1<? super T, Duration> r2) {
        return debounceInternal$FlowKt__DelayKt(r1, new AnonymousClass3(r2));
    }

    private static final <T> Flow<T> debounceInternal$FlowKt__DelayKt(Flow<? extends T> r2, Function1<? super T, Long> r3) {
        return FlowCoroutineKt.scopedFlow(new FlowKt__DelayKt$debounceInternal$1(r3, r2, null));
    }

    public static final <T> Flow<T> sample(Flow<? extends T> r2, long r3) {
        if (r3 <= 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L10;
        return FlowCoroutineKt.scopedFlow(new C04842(r3, r2, null));
    L10:
        throw new IllegalArgumentException("Sample period should be positive".toString());
    L5:
        r0 = false;
        goto L6
    }

    public static /* synthetic */ ReceiveChannel fixedPeriodTicker$default(CoroutineScope r0, long r1, long r3, int r5, Object r6) {
        if ((r5 & 2) == 0) goto L6;
        r3 = r1;
    L6:
        return FlowKt.fixedPeriodTicker(r0, r1, r3);
    }

    public static final ReceiveChannel<Unit> fixedPeriodTicker(CoroutineScope r10, long r11, long r13) {
        boolean r7 = true;
        if (r11 < 0) goto L5;
        boolean r0 = true;
    L7:
        if (r0 == false) goto L18;
        if (r13 >= 0) goto L12;
        r7 = false;
    L12:
        if (r7 == false) goto L16;
        return ProduceKt.produce$default(r10, null, 0, new C04833(r13, r11, null), 1, null);
    L16:
        throw new IllegalArgumentException(("Expected non-negative initial delay, but has " + r13 + " ms").toString());
    L18:
        throw new IllegalArgumentException(("Expected non-negative delay, but has " + r11 + " ms").toString());
    L5:
        r0 = false;
        goto L7
    }

    /* JADX INFO: renamed from: sample-HG0u8IE, reason: not valid java name */
    public static final <T> Flow<T> m2308sampleHG0u8IE(Flow<? extends T> r0, long r1) {
        return FlowKt.sample(r0, DelayKt.m2264toDelayMillisLRDsOJo(r1));
    }
}
