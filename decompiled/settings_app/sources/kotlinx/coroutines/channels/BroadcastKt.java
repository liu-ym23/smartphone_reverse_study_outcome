package kotlinx.coroutines.channels;

import com.android.settings.fuelgauge.BatteryHistoryDetail;
import com.bytedance.apm.constant.PerfConsts;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineContextKt;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;

/* JADX INFO: compiled from: Broadcast.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000V\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u009e\u0001\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2-\b\u0002\u0010\n\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\f¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000bj\u0004\u0018\u0001`\u00112/\b\u0001\u0010\u0012\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u00160\u0013¢\u0006\u0002\b\u0017H\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u0018\u001a2\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00192\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tH\u0007\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001a"}, d2 = {BatteryHistoryDetail.EXTRA_BROADCAST, "Lkotlinx/coroutines/channels/BroadcastChannel;", "E", "Lkotlinx/coroutines/CoroutineScope;", "context", "Lkotlin/coroutines/CoroutineContext;", PerfConsts.KEY_CURRENT_CAPACITY, "", "start", "Lkotlinx/coroutines/CoroutineStart;", "onCompletion", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "cause", "", "Lkotlinx/coroutines/CompletionHandler;", "block", "Lkotlin/Function2;", "Lkotlinx/coroutines/channels/ProducerScope;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlinx/coroutines/CoroutineScope;Lkotlin/coroutines/CoroutineContext;ILkotlinx/coroutines/CoroutineStart;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/channels/BroadcastChannel;", "Lkotlinx/coroutines/channels/ReceiveChannel;", "kotlinx-coroutines-core"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class BroadcastKt {

    /* JADX INFO: Add missing generic type declarations: [E] */
    /* JADX INFO: renamed from: kotlinx.coroutines.channels.BroadcastKt$broadcast$2, reason: invalid class name */
    /* JADX INFO: compiled from: Broadcast.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "E", "Lkotlinx/coroutines/channels/ProducerScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "kotlinx.coroutines.channels.BroadcastKt$broadcast$2", f = "Broadcast.kt", i = {0, 1}, l = {56, 57}, m = "invokeSuspend", n = {"$this$broadcast", "$this$broadcast"}, s = {"L$0", "L$0"})
    static final class AnonymousClass2<E> extends SuspendLambda implements Function2<ProducerScope<? super E>, Continuation<? super Unit>, Object> {
        final /* synthetic */ ReceiveChannel<E> $channel;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass2(ReceiveChannel<? extends E> r1, Continuation<? super AnonymousClass2> r2) {
            this.$channel = r1;
            super(2, r2);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            AnonymousClass2 r0 = new AnonymousClass2(this.$channel, r3);
            r0.L$0 = r2;
            return r0;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Object r1, Continuation<? super Unit> r2) {
            return invoke((ProducerScope) r1, r2);
        }

        public final Object invoke(ProducerScope<? super E> r1, Continuation<? super Unit> r2) {
            return ((AnonymousClass2) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0068 -> B:7:0x0019). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r8) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L11;
            if (r1 == 1) goto L10;
            if (r1 != 2) goto L9;
            ChannelIterator<E> r2 = (ChannelIterator) this.L$1;
            ProducerScope r4 = (ProducerScope) this.L$0;
            ResultKt.throwOnFailure(r8);
        L7:
            ProducerScope r9 = r4;
        L12:
            this.L$0 = r9;
            this.L$1 = r2;
            this.label = 1;
            Object r5 = r2.hasNext(this);
            if (r5 != r0) goto L15;
            return r0;
        L15:
            r4 = r9;
            r8 = r5;
        L17:
            if (((Boolean) r8).booleanValue() == false) goto L22;
            this.L$0 = r4;
            this.L$1 = r2;
            this.label = 2;
            if (r4.send(r2.next(), this) != r0) goto L7;
            return r0;
        L22:
            return Unit.INSTANCE;
        L9:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L10:
            r2 = (ChannelIterator) this.L$1;
            r4 = (ProducerScope) this.L$0;
            ResultKt.throwOnFailure(r8);
            goto L17
        L11:
            ResultKt.throwOnFailure(r8);
            r9 = (ProducerScope) this.L$0;
            r2 = this.$channel.iterator();
            goto L12
        }
    }

    public static /* synthetic */ BroadcastChannel broadcast$default(ReceiveChannel r0, int r1, CoroutineStart r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = 1;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = CoroutineStart.LAZY;
    L9:
        return broadcast(r0, r1, r2);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "BroadcastChannel is deprecated in the favour of SharedFlow and is no longer supported")
    public static final <E> BroadcastChannel<E> broadcast(final ReceiveChannel<? extends E> r11, int r12, CoroutineStart r13) {
        return broadcast$default(CoroutineScopeKt.plus(CoroutineScopeKt.plus(GlobalScope.INSTANCE, Dispatchers.getUnconfined()), new BroadcastKt$broadcast$$inlined$CoroutineExceptionHandler$1(CoroutineExceptionHandler.Key)), null, r12, r13, new AnonymousClass1(r11), new AnonymousClass2(r11, null), 1, null);
    }

    public static /* synthetic */ BroadcastChannel broadcast$default(CoroutineScope r6, EmptyCoroutineContext r7, int r8, CoroutineStart r9, Function1 r10, Function2 r11, int r12, Object r13) {
        if ((r12 & 1) == 0) goto L5;
        r7 = EmptyCoroutineContext.INSTANCE;
    L5:
        CoroutineContext r1 = r7;
        if ((r12 & 2) == 0) goto L8;
        r8 = 1;
    L8:
        int r2 = r8;
        if ((r12 & 4) == 0) goto L11;
        r9 = CoroutineStart.LAZY;
    L11:
        CoroutineStart r3 = r9;
        if ((r12 & 8) == 0) goto L15;
        r10 = null;
    L15:
        return broadcast(r6, r1, r2, r3, r10, r11);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "BroadcastChannel is deprecated in the favour of SharedFlow and is no longer supported")
    public static final <E> BroadcastChannel<E> broadcast(CoroutineScope r1, CoroutineContext r2, int r3, CoroutineStart r4, Function1<? super Throwable, Unit> r5, Function2<? super ProducerScope<? super E>, ? super Continuation<? super Unit>, ? extends Object> r6) {
        CoroutineContext r7 = CoroutineContextKt.newCoroutineContext(r1, r2);
        BroadcastChannel r8 = BroadcastChannelKt.BroadcastChannel(r3);
        if (r4.isLazy() == false) goto L5;
        LazyBroadcastCoroutine r9 = new LazyBroadcastCoroutine(r7, r8, r6);
    L6:
        if (r5 == null) goto L8;
        r9.invokeOnCompletion(r5);
    L8:
        r9.start(r4, r9, r6);
        return r9;
    L5:
        r9 = new BroadcastCoroutine(r7, r8, true);
        goto L6
    }
}
