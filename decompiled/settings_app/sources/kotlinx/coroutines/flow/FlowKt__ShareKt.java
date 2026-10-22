package kotlinx.coroutines.flow;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.flow.internal.ChannelFlow;

/* JADX INFO: compiled from: Share.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000j\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\u001c\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003\u001a\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0005\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0006\u001a+\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00020\b\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002¢\u0006\u0002\b\f\u001aM\u0010\r\u001a\u00020\u000e\"\u0004\b\u0000\u0010\u0002*\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u00020\t2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u0002H\u0002H\u0002¢\u0006\u0004\b\u0017\u0010\u0018\u001aA\u0010\u0019\u001a\u00020\u001a\"\u0004\b\u0000\u0010\u0002*\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u00020\t2\u0012\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00050\u001cH\u0002¢\u0006\u0002\b\u001d\u001aS\u0010\u001e\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012-\u0010\u001f\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020!\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\"\u0012\u0006\u0012\u0004\u0018\u00010#0 ¢\u0006\u0002\b$ø\u0001\u0000¢\u0006\u0002\u0010%\u001a6\u0010&\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\t2\u0006\u0010'\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\n\u001a\u00020\u000b\u001a/\u0010(\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0005\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\t2\u0006\u0010'\u001a\u00020\u000fH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010)\u001a9\u0010(\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0005\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\t2\u0006\u0010'\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u0002H\u0002¢\u0006\u0002\u0010*\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006+"}, d2 = {"asSharedFlow", "Lkotlinx/coroutines/flow/SharedFlow;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/flow/MutableSharedFlow;", "asStateFlow", "Lkotlinx/coroutines/flow/StateFlow;", "Lkotlinx/coroutines/flow/MutableStateFlow;", "configureSharing", "Lkotlinx/coroutines/flow/SharingConfig;", "Lkotlinx/coroutines/flow/Flow;", "replay", "", "configureSharing$FlowKt__ShareKt", "launchSharing", "Lkotlinx/coroutines/Job;", "Lkotlinx/coroutines/CoroutineScope;", "context", "Lkotlin/coroutines/CoroutineContext;", "upstream", "shared", "started", "Lkotlinx/coroutines/flow/SharingStarted;", "initialValue", "launchSharing$FlowKt__ShareKt", "(Lkotlinx/coroutines/CoroutineScope;Lkotlin/coroutines/CoroutineContext;Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/MutableSharedFlow;Lkotlinx/coroutines/flow/SharingStarted;Ljava/lang/Object;)Lkotlinx/coroutines/Job;", "launchSharingDeferred", "", "result", "Lkotlinx/coroutines/CompletableDeferred;", "launchSharingDeferred$FlowKt__ShareKt", "onSubscription", "action", "Lkotlin/Function2;", "Lkotlinx/coroutines/flow/FlowCollector;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlinx/coroutines/flow/SharedFlow;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/flow/SharedFlow;", "shareIn", "scope", "stateIn", "(Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/CoroutineScope;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "(Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/CoroutineScope;Lkotlinx/coroutines/flow/SharingStarted;Ljava/lang/Object;)Lkotlinx/coroutines/flow/StateFlow;", "kotlinx-coroutines-core"}, k = 5, mv = {1, 8, 0}, xi = 48, xs = "kotlinx/coroutines/flow/FlowKt")
final /* synthetic */ class FlowKt__ShareKt {
    public static /* synthetic */ SharedFlow shareIn$default(Flow r0, CoroutineScope r1, SharingStarted r2, int r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L6;
        r3 = 0;
    L6:
        return FlowKt.shareIn(r0, r1, r2, r3);
    }

    public static final <T> SharedFlow<T> shareIn(Flow<? extends T> r8, CoroutineScope r9, SharingStarted r10, int r11) {
        SharingConfig r12 = configureSharing$FlowKt__ShareKt(r8, r11);
        MutableSharedFlow r13 = SharedFlowKt.MutableSharedFlow(r11, r12.extraBufferCapacity, r12.onBufferOverflow);
        Job r14 = launchSharing$FlowKt__ShareKt(r9, r12.context, r12.upstream, r13, r10, SharedFlowKt.NO_VALUE);
        return new ReadonlySharedFlow(r13, r14);
    }

    private static final <T> SharingConfig<T> configureSharing$FlowKt__ShareKt(Flow<? extends T> r7, int r8) {
        int r1 = 1;
        if (DebugKt.getASSERTIONS_ENABLED() == false) goto L11;
        if (r8 < 0) goto L6;
        boolean r0 = true;
    L7:
        if (r0 == true) goto L11;
        throw new AssertionError();
    L6:
        r0 = false;
    L11:
        int r2 = RangesKt.coerceAtLeast(r8, Channel.Factory.getCHANNEL_DEFAULT_CAPACITY$kotlinx_coroutines_core()) - r8;
        if ((r7 instanceof ChannelFlow) == false) goto L33;
        ChannelFlow r3 = (ChannelFlow) r7;
        Flow<T> r4 = r3.dropChannelOperators();
        if (r4 == null) goto L33;
        int r5 = r3.capacity;
        if (r5 == (-3)) goto L22;
        if (r5 == (-2)) goto L22;
        if (r5 == 0) goto L22;
        r1 = r3.capacity;
    L31:
        return new SharingConfig(r4, r1, r3.onBufferOverflow, r3.context);
    L22:
        if (r3.onBufferOverflow == BufferOverflow.SUSPEND) goto L24;
        if (r8 == 0) goto L31;
    L29:
        r1 = 0;
        goto L31
    L24:
        if (r3.capacity == 0) goto L29;
        r1 = r2;
    L33:
        return new SharingConfig(r7, r2, BufferOverflow.SUSPEND, EmptyCoroutineContext.INSTANCE);
    }

    private static final <T> Job launchSharing$FlowKt__ShareKt(CoroutineScope r8, CoroutineContext r9, Flow<? extends T> r10, MutableSharedFlow<T> r11, SharingStarted r12, T r13) {
        if (Intrinsics.areEqual(r12, SharingStarted.Companion.getEagerly()) == false) goto L5;
        CoroutineStart r0 = CoroutineStart.DEFAULT;
    L7:
        return BuildersKt.launch(r8, r9, r0, new FlowKt__ShareKt$launchSharing$1(r12, r10, r11, r13, null));
    L5:
        r0 = CoroutineStart.UNDISPATCHED;
        goto L7
    }

    public static final <T> StateFlow<T> stateIn(Flow<? extends T> r7, CoroutineScope r8, SharingStarted r9, T r10) {
        SharingConfig r11 = configureSharing$FlowKt__ShareKt(r7, 1);
        MutableStateFlow r0 = StateFlowKt.MutableStateFlow(r10);
        Job r12 = launchSharing$FlowKt__ShareKt(r8, r11.context, r11.upstream, r0, r9, r10);
        return new ReadonlyStateFlow(r0, r12);
    }

    public static final <T> Object stateIn(Flow<? extends T> r2, CoroutineScope r3, Continuation<? super StateFlow<? extends T>> r4) {
        SharingConfig r5 = configureSharing$FlowKt__ShareKt(r2, 1);
        CompletableDeferred r0 = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        launchSharingDeferred$FlowKt__ShareKt(r3, r5.context, r5.upstream, r0);
        return r0.await(r4);
    }

    private static final <T> void launchSharingDeferred$FlowKt__ShareKt(CoroutineScope r6, CoroutineContext r7, Flow<? extends T> r8, CompletableDeferred<StateFlow<T>> r9) {
        BuildersKt.launch$default(r6, r7, null, new FlowKt__ShareKt$launchSharingDeferred$1(r8, r9, null), 2, null);
    }

    public static final <T> SharedFlow<T> asSharedFlow(MutableSharedFlow<T> r2) {
        return new ReadonlySharedFlow(r2, null);
    }

    public static final <T> StateFlow<T> asStateFlow(MutableStateFlow<T> r2) {
        return new ReadonlyStateFlow(r2, null);
    }

    public static final <T> SharedFlow<T> onSubscription(SharedFlow<? extends T> r1, Function2<? super FlowCollector<? super T>, ? super Continuation<? super Unit>, ? extends Object> r2) {
        return new SubscribedSharedFlow(r1, r2);
    }
}
