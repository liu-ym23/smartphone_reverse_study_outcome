package kotlinx.coroutines.flow;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.BroadcastChannel;
import kotlinx.coroutines.channels.ChannelResult;
import kotlinx.coroutines.channels.ChannelsKt;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.flow.internal.ChannelFlowKt;

/* JADX INFO: compiled from: Channels.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001e\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u0007\u001a\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0005\u001a/\u0010\u0006\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0005H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\n\u001a9\u0010\u000b\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00052\u0006\u0010\f\u001a\u00020\rH\u0082@ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000f\u001a&\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0005\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u0012H\u0007\u001a\u001c\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0005\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0014"}, d2 = {"asFlow", "Lkotlinx/coroutines/flow/Flow;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/channels/BroadcastChannel;", "consumeAsFlow", "Lkotlinx/coroutines/channels/ReceiveChannel;", "emitAll", "", "Lkotlinx/coroutines/flow/FlowCollector;", "channel", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlinx/coroutines/channels/ReceiveChannel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "emitAllImpl", "consume", "", "emitAllImpl$FlowKt__ChannelsKt", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlinx/coroutines/channels/ReceiveChannel;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "produceIn", "scope", "Lkotlinx/coroutines/CoroutineScope;", "receiveAsFlow", "kotlinx-coroutines-core"}, k = 5, mv = {1, 6, 0}, xi = 48, xs = "kotlinx/coroutines/flow/FlowKt")
final /* synthetic */ class FlowKt__ChannelsKt {
    public static final /* synthetic */ Object access$emitAllImpl$FlowKt__ChannelsKt(FlowCollector r0, ReceiveChannel r1, boolean r2, Continuation r3) {
        return emitAllImpl$FlowKt__ChannelsKt(r0, r1, r2, r3);
    }

    public static final <T> Object emitAll(FlowCollector<? super T> r1, ReceiveChannel<? extends T> r2, Continuation<? super Unit> r3) {
        Object r4 = emitAllImpl$FlowKt__ChannelsKt(r1, r2, true, r3);
        if (r4 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r4;
    L6:
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r6v0, types: [kotlinx.coroutines.flow.FlowCollector, kotlinx.coroutines.flow.FlowCollector<? super T>] */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v17 */
    /* JADX WARN: Type inference failed for: r6v18, types: [boolean] */
    /* JADX WARN: Type inference failed for: r6v19, types: [boolean] */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v21 */
    /* JADX WARN: Type inference failed for: r6v22 */
    /* JADX WARN: Type inference failed for: r6v23 */
    /* JADX WARN: Type inference failed for: r6v24 */
    /* JADX WARN: Type inference failed for: r6v25 */
    /* JADX WARN: Type inference failed for: r6v26 */
    /* JADX WARN: Type inference failed for: r6v3, types: [boolean] */
    /* JADX WARN: Type inference failed for: r6v6, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v8 */
    /* JADX WARN: Type inference failed for: r8v14 */
    /* JADX WARN: Type inference failed for: r8v15 */
    /* JADX WARN: Type inference failed for: r8v16 */
    /* JADX WARN: Type inference failed for: r8v17 */
    /* JADX WARN: Type inference failed for: r8v3, types: [java.lang.Object, kotlinx.coroutines.flow.FlowCollector] */
    /* JADX WARN: Type inference failed for: r8v5, types: [boolean] */
    /* JADX WARN: Type inference failed for: r8v7 */
    /* JADX WARN: Type inference failed for: r8v8 */
    /* JADX WARN: Type inference failed for: r8v9 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:37:0x0096 -> B:14:0x0036). Please report as a decompilation issue!!! */
    private static final <T> Object emitAllImpl$FlowKt__ChannelsKt(FlowCollector<? super T> r6, ReceiveChannel<? extends T> r7, boolean r8, Continuation<? super Unit> r9) {
        if ((r9 instanceof FlowKt__ChannelsKt$emitAllImpl$1) == false) goto L7;
        FlowKt__ChannelsKt$emitAllImpl$1 r0 = (FlowKt__ChannelsKt$emitAllImpl$1) r9;
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r10 = r0.result;
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r0.label;
        if (r2 == 0) goto L22;
        if (r2 == 1) goto L17;
        if (r2 != 2) goto L16;
        boolean r11 = (FlowCollector<? super T>) r0.Z$0;
        r7 = (ReceiveChannel) r0.L$1;
        FlowCollector r12 = (FlowCollector) r0.L$0;
        ResultKt.throwOnFailure(r10);     // Catch: Throwable -> L20
        ?? r13 = r11;
        ?? r14 = r12;
    L14:
        ?? r5 = r14;
        ?? r15 = r13;
        ?? r16 = (FlowCollector<? super T>) r5;
    L48:
        r0.L$0 = r16;     // Catch: Throwable -> L39
        r0.L$1 = r7;     // Catch: Throwable -> L39
        r0.Z$0 = r15;     // Catch: Throwable -> L39
        r0.label = 1;     // Catch: Throwable -> L39
        Object r17 = r7.mo2279receiveCatchingJP2dKIU(r0);     // Catch: Throwable -> L39
        if (r17 != r1) goto L26;
        return r1;
    L26:
        ?? r18 = r15;
        ?? r19 = r16;
        r6 = (FlowCollector<? super T>) (r18 == true ? 1 : 0 ? 1 : 0);
    L28:
        if (ChannelResult.m2294isClosedimpl(r17) == false) goto L36;
        Throwable r20 = ChannelResult.m2290exceptionOrNullimpl(r17);     // Catch: Throwable -> L20
        if (r20 != null) goto L35;
        if (r6 == 0) goto L34;
        ChannelsKt.cancelConsumed(r7, null);
    L34:
        return Unit.INSTANCE;
    L35:
        throw r20;     // Catch: Throwable -> L20
    L36:
        Object r21 = ChannelResult.m2292getOrThrowimpl(r17);     // Catch: Throwable -> L20
        r0.L$0 = r19;     // Catch: Throwable -> L20
        r0.L$1 = r7;     // Catch: Throwable -> L20
        r0.Z$0 = (boolean) r6;     // Catch: Throwable -> L20
        r0.label = 2;     // Catch: Throwable -> L20
        Object r22 = r19.emit(r21, r0);     // Catch: Throwable -> L20
        r13 = r6;
        r14 = r19;
        if (r22 != r1) goto L14;
        return r1;
    L39:
        th = move-exception;
        ?? r23 = r15;
        th = th;
        r6 = r23 == true ? 1 : 0;
    L50:
        throw th;     // Catch: Throwable -> L42
    L42:
        th = move-exception;
        if (r6 == 0) goto L45;
        ChannelsKt.cancelConsumed(r7, th);
    L45:
        throw th;
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        boolean r24 = (FlowCollector<? super T>) r0.Z$0;
        r7 = (ReceiveChannel) r0.L$1;
        FlowCollector r25 = (FlowCollector) r0.L$0;
        ResultKt.throwOnFailure(r10);     // Catch: Throwable -> L20
        r17 = ((ChannelResult) r10).m2298unboximpl();     // Catch: Throwable -> L20
        r6 = r24;
        r19 = r25;
        goto L28
    L22:
        ResultKt.throwOnFailure(r10);
        FlowKt.ensureActive(r6);
        r16 = r6;
        r15 = r8;
    L20:
        th = th;
    L7:
        r0 = new FlowKt__ChannelsKt$emitAllImpl$1(r9);
        goto L8
    }

    public static final <T> Flow<T> receiveAsFlow(ReceiveChannel<? extends T> r9) {
        return new ChannelAsFlow(r9, false, null, 0, null, 28, null);
    }

    public static final <T> Flow<T> consumeAsFlow(ReceiveChannel<? extends T> r9) {
        return new ChannelAsFlow(r9, true, null, 0, null, 28, null);
    }

    public static final <T> ReceiveChannel<T> produceIn(Flow<? extends T> r0, CoroutineScope r1) {
        return ChannelFlowKt.asChannelFlow(r0).produceImpl(r1);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "'BroadcastChannel' is obsolete and all corresponding operators are deprecated in the favour of StateFlow and SharedFlow")
    public static final <T> Flow<T> asFlow(final BroadcastChannel<T> r1) {
        return new FlowKt__ChannelsKt$asFlow$$inlined$unsafeFlow$1(r1);
    }
}
