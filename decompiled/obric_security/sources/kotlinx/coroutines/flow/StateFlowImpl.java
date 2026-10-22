package kotlinx.coroutines.flow;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.apm.constant.PerfConsts;
import com.obric.security.health.score.HealthModuleIds;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
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
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0001\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010 \n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00020\u0010062\b\u0012\u0004\u0012\u00028\u0000072\b\u0012\u0004\u0012\u00028\u0000082\b\u0012\u0004\u0012\u00028\u000009B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J!\u0010\t\u001a\u00020\b2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0096@ø\u0001\u0000¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00028\u00002\u0006\u0010\f\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0014¢\u0006\u0004\b\u0011\u0010\u0012J\u001f\u0010\u0016\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u00152\u0006\u0010\u0014\u001a\u00020\u0013H\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\u001b\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0018\u001a\u00028\u0000H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001bJ-\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000!2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u00132\u0006\u0010 \u001a\u00020\u001fH\u0016¢\u0006\u0004\b\"\u0010#J\u000f\u0010$\u001a\u00020\u0019H\u0016¢\u0006\u0004\b$\u0010%J\u0017\u0010&\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00028\u0000H\u0016¢\u0006\u0004\b&\u0010'J!\u0010*\u001a\u00020\r2\b\u0010(\u001a\u0004\u0018\u00010\u00022\u0006\u0010)\u001a\u00020\u0002H\u0002¢\u0006\u0004\b*\u0010\u000fR\u001a\u0010.\u001a\b\u0012\u0004\u0012\u00028\u00000+8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b,\u0010-R\u0016\u0010/\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u00100R*\u0010\u0018\u001a\u00028\u00002\u0006\u0010\u0018\u001a\u00028\u00008V@VX\u0096\u000e¢\u0006\u0012\u0012\u0004\b4\u0010%\u001a\u0004\b1\u00102\"\u0004\b3\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019¨\u00065"}, d2 = {"Lkotlinx/coroutines/flow/StateFlowImpl;", ExifInterface.GPS_DIRECTION_TRUE, "", "initialState", "<init>", "(Ljava/lang/Object;)V", "Lkotlinx/coroutines/flow/FlowCollector;", "collector", "", "collect", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "expect", HealthModuleIds.UPDATE, "", "compareAndSet", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "Lkotlinx/coroutines/flow/StateFlowSlot;", "createSlot", "()Lkotlinx/coroutines/flow/StateFlowSlot;", "", PerfConsts.PERF_DISK_FILE_SIZE, "", "createSlotArray", "(I)[Lkotlinx/coroutines/flow/StateFlowSlot;", "value", "", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlin/coroutines/CoroutineContext;", "context", PerfConsts.KEY_CURRENT_CAPACITY, "Lkotlinx/coroutines/channels/BufferOverflow;", "onBufferOverflow", "Lkotlinx/coroutines/flow/Flow;", "fuse", "(Lkotlin/coroutines/CoroutineContext;ILkotlinx/coroutines/channels/BufferOverflow;)Lkotlinx/coroutines/flow/Flow;", "resetReplayCache", "()V", "tryEmit", "(Ljava/lang/Object;)Z", "expectedState", "newState", "updateState", "", "getReplayCache", "()Ljava/util/List;", "replayCache", "sequence", "I", "getValue", "()Ljava/lang/Object;", "setValue", "getValue$annotations", "kotlinx-coroutines-core", "Lkotlinx/coroutines/flow/internal/AbstractSharedFlow;", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lkotlinx/coroutines/flow/CancellableFlow;", "Lkotlinx/coroutines/flow/internal/FusibleFlow;"}, k = 1, mv = {1, 6, 0}, xi = 48)
final class StateFlowImpl<T> extends AbstractSharedFlow<StateFlowSlot> implements MutableStateFlow<T>, CancellableFlow<T>, FusibleFlow<T> {
    private volatile /* synthetic */ Object _state;
    private int sequence;

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.StateFlowImpl$collect$1, reason: invalid class name */
    /* JADX INFO: compiled from: StateFlow.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "kotlinx.coroutines.flow.StateFlowImpl", f = "StateFlow.kt", i = {0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2}, l = {386, 398, 403}, m = "collect", n = {"this", "collector", "slot", "this", "collector", "slot", "collectorJob", "newState", "this", "collector", "slot", "collectorJob", "oldState"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4"})
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
        T r1 = (T) this._state;
        if (r1 != r0) goto L6;
        return null;
    L6:
        return r1;
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

    private final boolean updateState(Object r7, Object r8) {
        getSlots();
        monitor-enter(this);
        Object r0 = this._state;     // Catch: Throwable -> L43
        if (r7 == null) goto L12;
        if (Intrinsics.areEqual(r0, r7) == true) goto L12;
        monitor-exit(this);
        return false;
    L12:
        if (Intrinsics.areEqual(r0, r8) == false) goto L15;
        monitor-exit(this);
        return true;
    L15:
        this._state = r8;     // Catch: Throwable -> L43
        int r9 = this.sequence;     // Catch: Throwable -> L43
        if ((r9 & 1) != 0) goto L40;
        int r10 = r9 + 1;     // Catch: Throwable -> L43
        this.sequence = r10;     // Catch: Throwable -> L43
        StateFlowSlot[] r11 = getSlots();     // Catch: Throwable -> L43
        Unit r2 = Unit.INSTANCE;     // Catch: Throwable -> L43
        monitor-exit(this);
    L19:
        StateFlowSlot[] r12 = r11;
        if (r12 == null) goto L27;
        int r3 = r12.length;
        int r4 = 0;
    L22:
        if (r4 >= r3) goto L27;
        StateFlowSlot r5 = r12[r4];
        if (r5 == null) goto L26;
        r5.makePending();
    L26:
        r4 = r4 + 1;
    L27:
        monitor-enter(this);
        int r13 = this.sequence;     // Catch: Throwable -> L36
        if (r13 == r10) goto L30;
        StateFlowSlot[] r14 = getSlots();     // Catch: Throwable -> L36
        Unit r6 = Unit.INSTANCE;     // Catch: Throwable -> L36
        monitor-exit(this);
        r11 = r14;
        r10 = r13;
        goto L19
    L30:
        this.sequence = r10 + 1;     // Catch: Throwable -> L36
        monitor-exit(this);
        return true;
    L36:
        th = move-exception;
        throw th;
    L40:
        this.sequence = r9 + 2;     // Catch: Throwable -> L43
        monitor-exit(this);
        return true;
    L43:
        th = move-exception;
        throw th;
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
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:49:0x00dc -> B:33:0x00aa). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:51:0x00ee -> B:33:0x00aa). Please report as a decompilation issue!!! */
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
        if (r2 != 1) goto L59;
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
        Object r7 = this._state;     // Catch: Throwable -> L53
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
    L59:
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
}
