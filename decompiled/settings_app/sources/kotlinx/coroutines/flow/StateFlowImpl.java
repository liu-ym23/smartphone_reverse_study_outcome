package kotlinx.coroutines.flow;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.apm.constant.PerfConsts;
import java.util.List;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.Volatile;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.internal.AbstractSharedFlow;
import kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot;
import kotlinx.coroutines.flow.internal.FusibleFlow;
import kotlinx.coroutines.flow.internal.NullSurrogateKt;
import kotlinx.coroutines.internal.Symbol;

/* JADX INFO: compiled from: StateFlow.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0012\u0004\u0012\u0002H\u00010\u00042\b\u0012\u0004\u0012\u0002H\u00010\u00052\b\u0012\u0004\u0012\u0002H\u00010\u0006B\r\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u001f\u0010\u0018\u001a\u00020\u00192\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00028\u00000\u001bH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u001cJ\u001d\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00028\u00002\u0006\u0010 \u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010!J\b\u0010\"\u001a\u00020\u0003H\u0014J\u001d\u0010#\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030$2\u0006\u0010%\u001a\u00020\u0011H\u0014¢\u0006\u0002\u0010&J\u0019\u0010'\u001a\u00020(2\u0006\u0010\u0012\u001a\u00028\u0000H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010)J&\u0010*\u001a\b\u0012\u0004\u0012\u00028\u00000+2\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\u00112\u0006\u0010/\u001a\u000200H\u0016J\b\u00101\u001a\u00020(H\u0016J\u0015\u00102\u001a\u00020\u001e2\u0006\u0010\u0012\u001a\u00028\u0000H\u0016¢\u0006\u0002\u00103J\u001a\u00104\u001a\u00020\u001e2\b\u00105\u001a\u0004\u0018\u00010\b2\u0006\u00106\u001a\u00020\bH\u0002R\u000f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\b0\u000bX\u0082\u0004R\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R*\u0010\u0012\u001a\u00028\u00002\u0006\u0010\u0012\u001a\u00028\u00008V@VX\u0096\u000e¢\u0006\u0012\u0012\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\t\u0082\u0002\u0004\n\u0002\b\u0019¨\u00067"}, d2 = {"Lkotlinx/coroutines/flow/StateFlowImpl;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/flow/internal/AbstractSharedFlow;", "Lkotlinx/coroutines/flow/StateFlowSlot;", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lkotlinx/coroutines/flow/CancellableFlow;", "Lkotlinx/coroutines/flow/internal/FusibleFlow;", "initialState", "", "(Ljava/lang/Object;)V", "_state", "Lkotlinx/atomicfu/AtomicRef;", "replayCache", "", "getReplayCache", "()Ljava/util/List;", "sequence", "", "value", "getValue$annotations", "()V", "getValue", "()Ljava/lang/Object;", "setValue", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "compareAndSet", "", "expect", "update", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "createSlot", "createSlotArray", "", PerfConsts.PERF_DISK_FILE_SIZE, "(I)[Lkotlinx/coroutines/flow/StateFlowSlot;", "emit", "", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fuse", "Lkotlinx/coroutines/flow/Flow;", "context", "Lkotlin/coroutines/CoroutineContext;", PerfConsts.KEY_CURRENT_CAPACITY, "onBufferOverflow", "Lkotlinx/coroutines/channels/BufferOverflow;", "resetReplayCache", "tryEmit", "(Ljava/lang/Object;)Z", "updateState", "expectedState", "newState", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class StateFlowImpl<T> extends AbstractSharedFlow<StateFlowSlot> implements MutableStateFlow<T>, CancellableFlow<T>, FusibleFlow<T> {
    private static final AtomicReferenceFieldUpdater _state$FU = null;

    @Volatile
    private volatile Object _state;
    private int sequence;

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.StateFlowImpl$collect$1, reason: invalid class name */
    /* JADX INFO: compiled from: StateFlow.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "kotlinx.coroutines.flow.StateFlowImpl", f = "StateFlow.kt", i = {0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2}, l = {384, 396, 401}, m = "collect", n = {"this", "collector", "slot", "this", "collector", "slot", "collectorJob", "newState", "this", "collector", "slot", "collectorJob", "oldState"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4"})
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ StateFlowImpl<T> this$0;

        AnonymousClass1(StateFlowImpl<T> r1, Continuation<? super AnonymousClass1> r2) {
            this.this$0 = r1;
            super(r2);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.collect(null, this);
        }
    }

    static {
        _state$FU = AtomicReferenceFieldUpdater.newUpdater(StateFlowImpl.class, Object.class, "_state");
    }

    public static /* synthetic */ void getValue$annotations() {
    }

    @Override // kotlinx.coroutines.flow.internal.AbstractSharedFlow
    public /* bridge */ /* synthetic */ AbstractSharedFlowSlot createSlot() {
        return createSlot();
    }

    @Override // kotlinx.coroutines.flow.internal.AbstractSharedFlow
    public /* bridge */ /* synthetic */ AbstractSharedFlowSlot[] createSlotArray(int r1) {
        return createSlotArray(r1);
    }

    public StateFlowImpl(Object r1) {
        this._state = r1;
    }

    @Override // kotlinx.coroutines.flow.MutableStateFlow, kotlinx.coroutines.flow.StateFlow
    public T getValue() {
        Symbol r0 = NullSurrogateKt.NULL;
        T r2 = (T) _state$FU.get(this);
        if (r2 != r0) goto L6;
        return null;
    L6:
        return r2;
    }

    @Override // kotlinx.coroutines.flow.MutableStateFlow
    public void setValue(T r2) {
        if (r2 != null) goto L4;
        r2 = (T) NullSurrogateKt.NULL;
    L4:
        updateState(null, r2);
    }

    @Override // kotlinx.coroutines.flow.MutableStateFlow
    public boolean compareAndSet(T r1, T r2) {
        if (r1 != null) goto L4;
        r1 = (T) NullSurrogateKt.NULL;
    L4:
        if (r2 != null) goto L7;
        r2 = (T) NullSurrogateKt.NULL;
    L7:
        return updateState(r1, r2);
    }

    @Override // kotlinx.coroutines.flow.SharedFlow
    public List<T> getReplayCache() {
        return CollectionsKt.listOf(getValue());
    }

    @Override // kotlinx.coroutines.flow.MutableSharedFlow
    public boolean tryEmit(T r1) {
        setValue(r1);
        return true;
    }

    @Override // kotlinx.coroutines.flow.MutableSharedFlow, kotlinx.coroutines.flow.FlowCollector
    public Object emit(T r1, Continuation<? super Unit> r2) {
        setValue(r1);
        return Unit.INSTANCE;
    }

    @Override // kotlinx.coroutines.flow.MutableSharedFlow
    public void resetReplayCache() {
        throw new UnsupportedOperationException("MutableStateFlow.resetReplayCache is not supported");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v20 */
    /* JADX WARN: Type inference failed for: r2v21 */
    /* JADX WARN: Type inference failed for: r2v22 */
    /* JADX WARN: Type inference failed for: r2v23 */
    /* JADX WARN: Type inference failed for: r2v24 */
    /* JADX WARN: Type inference failed for: r2v25 */
    /* JADX WARN: Type inference failed for: r2v26 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v7, types: [java.lang.Object, kotlinx.coroutines.flow.StateFlowSlot] */
    /* JADX WARN: Type inference failed for: r2v8, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v12 */
    /* JADX WARN: Type inference failed for: r6v13 */
    /* JADX WARN: Type inference failed for: r6v14 */
    /* JADX WARN: Type inference failed for: r6v15 */
    /* JADX WARN: Type inference failed for: r6v16 */
    /* JADX WARN: Type inference failed for: r6v17 */
    /* JADX WARN: Type inference failed for: r6v2, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v3, types: [java.lang.Object, kotlinx.coroutines.flow.FlowCollector] */
    /* JADX WARN: Type inference failed for: r6v6 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:49:0x00e0 -> B:33:0x00aa). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:51:0x00f2 -> B:33:0x00aa). Please report as a decompilation issue!!! */
    @Override // kotlinx.coroutines.flow.SharedFlow, kotlinx.coroutines.flow.Flow
    public Object collect(FlowCollector<? super T> r11, Continuation<?> r12) {
        if ((r12 instanceof AnonymousClass1) == false) goto L7;
        AnonymousClass1 r0 = (AnonymousClass1) r12;
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r13 = r0.result;
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ?? r2 = r0.label;
        if (r2 == 0) goto L26;
        if (r2 != 1) goto L57;
        StateFlowSlot r3 = (StateFlowSlot) r0.L$2;
        r11 = (FlowCollector) r0.L$1;
        StateFlowImpl<T> this = (StateFlowImpl) r0.L$0;
        ResultKt.throwOnFailure(r13);     // Catch: Throwable -> L53
        StateFlowSlot r4 = r3;
    L32:
        ?? r6 = r11;
        Job r14 = (Job) r0.getContext().get(Job.Key);     // Catch: Throwable -> L53
        Object r15 = null;
        r2 = r4;
    L33:
        Object r7 = _state$FU.get(this);     // Catch: Throwable -> L53
        if (r14 == null) goto L36;
        JobKt.ensureActive(r14);     // Catch: Throwable -> L53
    L36:
        if (r15 == null) goto L40;
        ?? r5 = r2;
        ?? r8 = r6;
        if (Intrinsics.areEqual(r15, r7) == false) goto L40;
    L48:
        boolean r9 = r5.takePending();     // Catch: Throwable -> L53
        r2 = r5;
        r6 = r8;
        if (r9 == true) goto L33;
        r0.L$0 = this;     // Catch: Throwable -> L53
        r0.L$1 = r8;     // Catch: Throwable -> L53
        r0.L$2 = r5;     // Catch: Throwable -> L53
        r0.L$3 = r14;     // Catch: Throwable -> L53
        r0.L$4 = r15;     // Catch: Throwable -> L53
        r0.label = 3;     // Catch: Throwable -> L53
        Object r10 = r5.awaitPending(r0);     // Catch: Throwable -> L53
        r2 = r5;
        r6 = r8;
        if (r10 != r1) goto L33;
        return r1;
    L40:
        if (r7 != NullSurrogateKt.NULL) goto L42;
        Object r16 = null;
    L43:
        r0.L$0 = this;     // Catch: Throwable -> L53
        r0.L$1 = r6;     // Catch: Throwable -> L53
        r0.L$2 = r2;     // Catch: Throwable -> L53
        r0.L$3 = r14;     // Catch: Throwable -> L53
        r0.L$4 = r7;     // Catch: Throwable -> L53
        r0.label = 2;     // Catch: Throwable -> L53
        if (r6.emit(r16, r0) != r1) goto L46;
        return r1;
    L46:
        StateFlowImpl<T> r17 = this;
        Object r18 = r7;
        ?? r19 = r2;
        ?? r20 = r6;
    L47:
        r15 = r18;
        this = r17;
        r5 = r19;
        r8 = r20;
        goto L48
    L42:
        r16 = r7;
        goto L43
    L57:
        if (r2 == 2) goto L18;
        if (r2 != 3) goto L17;
        Object r110 = r0.L$4;
        r14 = (Job) r0.L$3;
        StateFlowSlot r21 = (StateFlowSlot) r0.L$2;
        FlowCollector r22 = (FlowCollector) r0.L$1;
        StateFlowImpl<T> r23 = (StateFlowImpl) r0.L$0;
        ResultKt.throwOnFailure(r13);     // Catch: Throwable -> L21
        r15 = r110;
        this = r23;
        r2 = r21;
        r6 = r22;
        goto L33
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        r18 = r0.L$4;
        r14 = (Job) r0.L$3;
        StateFlowSlot r24 = (StateFlowSlot) r0.L$2;
        FlowCollector r25 = (FlowCollector) r0.L$1;
        r17 = (StateFlowImpl) r0.L$0;
        ResultKt.throwOnFailure(r13);     // Catch: Throwable -> L21
        r19 = r24;
        r20 = r25;
    L21:
        Throwable th = th;
    L55:
        r7.freeSlot((AbstractSharedFlowSlot) r2);
        throw th;
    L26:
        ResultKt.throwOnFailure(r13);
        StateFlowSlot r26 = allocateSlot();
        r4 = r26;
        if ((r11 instanceof SubscribedFlowCollector) == false) goto L32;
        r0.L$0 = this;     // Catch: Throwable -> L53
        r0.L$1 = r11;     // Catch: Throwable -> L53
        r0.L$2 = r26;     // Catch: Throwable -> L53
        r0.label = 1;     // Catch: Throwable -> L53
        r4 = r26;
        if (((SubscribedFlowCollector) r11).onSubscription(r0) != r1) goto L32;
        return r1;
    L53:
        th = move-exception;
        StateFlowImpl<T> r27 = this;
        th = th;
    L7:
        r0 = new AnonymousClass1(this, r12);
        goto L8
    }

    @Override // kotlinx.coroutines.flow.internal.AbstractSharedFlow
    protected StateFlowSlot createSlot() {
        return new StateFlowSlot();
    }

    @Override // kotlinx.coroutines.flow.internal.AbstractSharedFlow
    protected StateFlowSlot[] createSlotArray(int r1) {
        return new StateFlowSlot[r1];
    }

    @Override // kotlinx.coroutines.flow.internal.FusibleFlow
    public Flow<T> fuse(CoroutineContext r1, int r2, BufferOverflow r3) {
        return StateFlowKt.fuseStateFlow(this, r1, r2, r3);
    }

    private final boolean updateState(Object r7, Object r8) {
        monitor-enter(this);
        AtomicReferenceFieldUpdater r0 = _state$FU;     // Catch: Throwable -> L42
        Object r1 = r0.get(this);     // Catch: Throwable -> L42
        if (r7 == null) goto L11;
        if (Intrinsics.areEqual(r1, r7) == true) goto L11;
        monitor-exit(this);
        return false;
    L11:
        if (Intrinsics.areEqual(r1, r8) == false) goto L14;
        monitor-exit(this);
        return true;
    L14:
        r0.set(this, r8);     // Catch: Throwable -> L42
        int r9 = this.sequence;     // Catch: Throwable -> L42
        if ((r9 & 1) != 0) goto L39;
        int r10 = r9 + 1;     // Catch: Throwable -> L42
        this.sequence = r10;     // Catch: Throwable -> L42
        StateFlowSlot[] r11 = getSlots();     // Catch: Throwable -> L42
        Unit r2 = Unit.INSTANCE;     // Catch: Throwable -> L42
        monitor-exit(this);
    L18:
        StateFlowSlot[] r12 = r11;
        if (r12 == null) goto L26;
        int r3 = r12.length;
        int r4 = 0;
    L21:
        if (r4 >= r3) goto L26;
        StateFlowSlot r5 = r12[r4];
        if (r5 == null) goto L25;
        r5.makePending();
    L25:
        r4 = r4 + 1;
    L26:
        monitor-enter(this);
        int r13 = this.sequence;     // Catch: Throwable -> L35
        if (r13 == r10) goto L29;
        StateFlowSlot[] r14 = getSlots();     // Catch: Throwable -> L35
        Unit r6 = Unit.INSTANCE;     // Catch: Throwable -> L35
        monitor-exit(this);
        r11 = r14;
        r10 = r13;
        goto L18
    L29:
        this.sequence = r10 + 1;     // Catch: Throwable -> L35
        monitor-exit(this);
        return true;
    L35:
        th = move-exception;
        throw th;
    L39:
        this.sequence = r9 + 2;     // Catch: Throwable -> L42
        monitor-exit(this);
        return true;
    L42:
        th = move-exception;
        throw th;
    }
}
