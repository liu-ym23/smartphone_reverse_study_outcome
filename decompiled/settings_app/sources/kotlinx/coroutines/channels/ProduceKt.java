package kotlinx.coroutines.channels;

import com.bytedance.apm.constant.PerfConsts;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineContextKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

/* JADX INFO: compiled from: Produce.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000b\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a)\u0010\u0000\u001a\u00020\u0001*\u0006\u0012\u0002\b\u00030\u00022\u000e\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00010\u0004H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0005\u001a\u009e\u0001\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\b0\u0007\"\u0004\b\u0000\u0010\b*\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2-\b\u0002\u0010\u0010\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0012¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0011j\u0004\u0018\u0001`\u00162/\b\u0001\u0010\u0003\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\b0\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u0017¢\u0006\u0002\b\u001aH\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u001b\u001a¨\u0001\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\b0\u0007\"\u0004\b\u0000\u0010\b*\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2-\b\u0002\u0010\u0010\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0012¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0011j\u0004\u0018\u0001`\u00162/\b\u0001\u0010\u0003\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\b0\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u0017¢\u0006\u0002\b\u001aH\u0000ø\u0001\u0000¢\u0006\u0002\u0010\u001e\u001ae\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\b0\u0007\"\u0004\b\u0000\u0010\b*\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2/\b\u0001\u0010\u0003\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\b0\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u0017¢\u0006\u0002\b\u001aH\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u001f\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006 "}, d2 = {"awaitClose", "", "Lkotlinx/coroutines/channels/ProducerScope;", "block", "Lkotlin/Function0;", "(Lkotlinx/coroutines/channels/ProducerScope;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "produce", "Lkotlinx/coroutines/channels/ReceiveChannel;", "E", "Lkotlinx/coroutines/CoroutineScope;", "context", "Lkotlin/coroutines/CoroutineContext;", PerfConsts.KEY_CURRENT_CAPACITY, "", "start", "Lkotlinx/coroutines/CoroutineStart;", "onCompletion", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "cause", "Lkotlinx/coroutines/CompletionHandler;", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlinx/coroutines/CoroutineScope;Lkotlin/coroutines/CoroutineContext;ILkotlinx/coroutines/CoroutineStart;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/channels/ReceiveChannel;", "onBufferOverflow", "Lkotlinx/coroutines/channels/BufferOverflow;", "(Lkotlinx/coroutines/CoroutineScope;Lkotlin/coroutines/CoroutineContext;ILkotlinx/coroutines/channels/BufferOverflow;Lkotlinx/coroutines/CoroutineStart;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/channels/ReceiveChannel;", "(Lkotlinx/coroutines/CoroutineScope;Lkotlin/coroutines/CoroutineContext;ILkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/channels/ReceiveChannel;", "kotlinx-coroutines-core"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ProduceKt {

    /* JADX INFO: renamed from: kotlinx.coroutines.channels.ProduceKt$awaitClose$1, reason: invalid class name */
    /* JADX INFO: compiled from: Produce.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "kotlinx.coroutines.channels.ProduceKt", f = "Produce.kt", i = {0, 0}, l = {153}, m = "awaitClose", n = {"$this$awaitClose", "block"}, s = {"L$0", "L$1"})
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> r1) {
            super(r1);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= Integer.MIN_VALUE;
            return ProduceKt.awaitClose(null, null, this);
        }
    }

    public static final Object awaitClose(ProducerScope<?> r4, Function0<Unit> r5, Continuation<? super Unit> r6) {
        if ((r6 instanceof AnonymousClass1) == false) goto L7;
        AnonymousClass1 r0 = (AnonymousClass1) r6;
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r7 = r0.result;
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r0.label;
        if (r2 == 0) goto L18;
        if (r2 != 1) goto L17;
        r5 = (Function0) r0.L$1;
        ProducerScope r8 = (ProducerScope) r0.L$0;
        ResultKt.throwOnFailure(r7);     // Catch: Throwable -> L14
    L28:
        r5.invoke();
        return Unit.INSTANCE;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r7);
        if (r0.getContext().get(Job.Key) != r4) goto L21;
        boolean r9 = true;
    L22:
        if (r9 == false) goto L33;
        r0.L$0 = r4;     // Catch: Throwable -> L14
        r0.L$1 = r5;     // Catch: Throwable -> L14
        r0.label = 1;     // Catch: Throwable -> L14
        CancellableContinuationImpl r3 = new CancellableContinuationImpl(IntrinsicsKt.intercepted(r0), 1);     // Catch: Throwable -> L14
        r3.initCancellability();     // Catch: Throwable -> L14
        final CancellableContinuationImpl r10 = r3;     // Catch: Throwable -> L14
        r4.invokeOnClose(new ProduceKt$awaitClose$4$1(r10));     // Catch: Throwable -> L14
        Object r11 = r3.getResult();     // Catch: Throwable -> L14
        if (r11 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L26;
        DebugProbesKt.probeCoroutineSuspended(r0);     // Catch: Throwable -> L14
    L26:
        if (r11 != r1) goto L28;
        return r1;
    L33:
        throw new IllegalStateException("awaitClose() can only be invoked from the producer context".toString());
    L21:
        r9 = false;
    L14:
        th = move-exception;
        r5.invoke();
        throw th;
    L7:
        r0 = new AnonymousClass1(r6);
        goto L8
    }

    public static /* synthetic */ Object awaitClose$default(ProducerScope r0, AnonymousClass2 r1, Continuation r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = AnonymousClass2.INSTANCE;
    L6:
        return awaitClose(r0, r1, r2);
    }

    public static /* synthetic */ ReceiveChannel produce$default(CoroutineScope r0, EmptyCoroutineContext r1, int r2, Function2 r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = EmptyCoroutineContext.INSTANCE;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = 0;
    L9:
        return produce(r0, r1, r2, r3);
    }

    public static final <E> ReceiveChannel<E> produce(CoroutineScope r7, CoroutineContext r8, int r9, Function2<? super ProducerScope<? super E>, ? super Continuation<? super Unit>, ? extends Object> r10) {
        return produce(r7, r8, r9, BufferOverflow.SUSPEND, CoroutineStart.DEFAULT, null, r10);
    }

    public static /* synthetic */ ReceiveChannel produce$default(CoroutineScope r6, EmptyCoroutineContext r7, int r8, CoroutineStart r9, Function1 r10, Function2 r11, int r12, Object r13) {
        if ((r12 & 1) == 0) goto L5;
        r7 = EmptyCoroutineContext.INSTANCE;
    L5:
        CoroutineContext r1 = r7;
        if ((r12 & 2) == 0) goto L8;
        r8 = 0;
    L8:
        int r2 = r8;
        if ((r12 & 4) == 0) goto L11;
        r9 = CoroutineStart.DEFAULT;
    L11:
        CoroutineStart r3 = r9;
        if ((r12 & 8) == 0) goto L15;
        r10 = null;
    L15:
        return produce(r6, r1, r2, r3, r10, r11);
    }

    public static final <E> ReceiveChannel<E> produce(CoroutineScope r7, CoroutineContext r8, int r9, CoroutineStart r10, Function1<? super Throwable, Unit> r11, Function2<? super ProducerScope<? super E>, ? super Continuation<? super Unit>, ? extends Object> r12) {
        return produce(r7, r8, r9, BufferOverflow.SUSPEND, r10, r11, r12);
    }

    public static /* synthetic */ ReceiveChannel produce$default(CoroutineScope r7, EmptyCoroutineContext r8, int r9, BufferOverflow r10, CoroutineStart r11, Function1 r12, Function2 r13, int r14, Object r15) {
        if ((r14 & 1) == 0) goto L5;
        r8 = EmptyCoroutineContext.INSTANCE;
    L5:
        CoroutineContext r1 = r8;
        if ((r14 & 2) == 0) goto L8;
        r9 = 0;
    L8:
        int r2 = r9;
        if ((r14 & 4) == 0) goto L11;
        r10 = BufferOverflow.SUSPEND;
    L11:
        BufferOverflow r3 = r10;
        if ((r14 & 8) == 0) goto L14;
        r11 = CoroutineStart.DEFAULT;
    L14:
        CoroutineStart r4 = r11;
        if ((r14 & 16) == 0) goto L18;
        r12 = null;
    L18:
        return produce(r7, r1, r2, r3, r4, r12, r13);
    }

    public static final <E> ReceiveChannel<E> produce(CoroutineScope r2, CoroutineContext r3, int r4, BufferOverflow r5, CoroutineStart r6, Function1<? super Throwable, Unit> r7, Function2<? super ProducerScope<? super E>, ? super Continuation<? super Unit>, ? extends Object> r8) {
        Channel r9 = ChannelKt.Channel$default(r4, r5, null, 4, null);
        ProducerCoroutine r10 = new ProducerCoroutine(CoroutineContextKt.newCoroutineContext(r2, r3), r9);
        if (r7 == null) goto L5;
        r10.invokeOnCompletion(r7);
    L5:
        r10.start(r6, r10, r8);
        return r10;
    }
}
