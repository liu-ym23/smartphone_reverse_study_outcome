package kotlinx.coroutines.flow;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.apm.constant.PerfConsts;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CancellableContinuationKt;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.internal.AbstractSharedFlow;
import kotlinx.coroutines.flow.internal.AbstractSharedFlowKt;
import kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot;
import kotlinx.coroutines.flow.internal.FusibleFlow;

/* JADX INFO: compiled from: SharedFlow.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0012\b\u0010\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0012\u0004\u0012\u0002H\u00010\u00042\b\u0012\u0004\u0012\u0002H\u00010\u00052\b\u0012\u0004\u0012\u0002H\u00010\u0006:\u0001hB\u001d\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u0019\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\u0003H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010.J\u0010\u0010/\u001a\u00020,2\u0006\u00100\u001a\u000201H\u0002J\b\u00102\u001a\u00020,H\u0002J\u001f\u00103\u001a\u0002042\f\u00105\u001a\b\u0012\u0004\u0012\u00028\u000006H\u0096@ø\u0001\u0000¢\u0006\u0002\u00107J\u0010\u00108\u001a\u00020,2\u0006\u00109\u001a\u00020\u0012H\u0002J\b\u0010:\u001a\u00020\u0003H\u0014J\u001d\u0010;\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u000e2\u0006\u0010<\u001a\u00020\bH\u0014¢\u0006\u0002\u0010=J\b\u0010>\u001a\u00020,H\u0002J\u0019\u0010?\u001a\u00020,2\u0006\u0010@\u001a\u00028\u0000H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010AJ\u0019\u0010B\u001a\u00020,2\u0006\u0010@\u001a\u00028\u0000H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010AJ\u0012\u0010C\u001a\u00020,2\b\u0010D\u001a\u0004\u0018\u00010\u000fH\u0002J1\u0010E\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020,\u0018\u00010F0\u000e2\u0014\u0010G\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020,\u0018\u00010F0\u000eH\u0002¢\u0006\u0002\u0010HJ&\u0010I\u001a\b\u0012\u0004\u0012\u00028\u00000J2\u0006\u0010K\u001a\u00020L2\u0006\u0010M\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0012\u0010N\u001a\u0004\u0018\u00010\u000f2\u0006\u0010O\u001a\u00020\u0012H\u0002J7\u0010P\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000e2\u0010\u0010Q\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010\u000e2\u0006\u0010R\u001a\u00020\b2\u0006\u0010S\u001a\u00020\bH\u0002¢\u0006\u0002\u0010TJ\b\u0010U\u001a\u00020,H\u0016J\u0015\u0010V\u001a\u00020W2\u0006\u0010@\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010XJ\u0015\u0010Y\u001a\u00020W2\u0006\u0010@\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010XJ\u0015\u0010Z\u001a\u00020W2\u0006\u0010@\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010XJ\u0010\u0010[\u001a\u00020\u00122\u0006\u0010-\u001a\u00020\u0003H\u0002J\u0012\u0010\\\u001a\u0004\u0018\u00010\u000f2\u0006\u0010-\u001a\u00020\u0003H\u0002J(\u0010]\u001a\u00020,2\u0006\u0010^\u001a\u00020\u00122\u0006\u0010_\u001a\u00020\u00122\u0006\u0010`\u001a\u00020\u00122\u0006\u0010a\u001a\u00020\u0012H\u0002J%\u0010b\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020,\u0018\u00010F0\u000e2\u0006\u0010c\u001a\u00020\u0012H\u0000¢\u0006\u0004\bd\u0010eJ\r\u0010f\u001a\u00020\u0012H\u0000¢\u0006\u0002\bgR\u001a\u0010\r\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0010R\u000e\u0010\t\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\u00020\u00128BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\u00020\u00128BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0014R\u001a\u0010\u0018\u001a\u00028\u00008DX\u0084\u0004¢\u0006\f\u0012\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u000e\u0010\u001d\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001e\u001a\u00020\u00128BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u0014R\u000e\u0010 \u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010!\u001a\b\u0012\u0004\u0012\u00028\u00000\"8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b#\u0010$R\u000e\u0010%\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010&\u001a\u00020\b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b'\u0010(R\u0014\u0010)\u001a\u00020\b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b*\u0010(\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006i"}, d2 = {"Lkotlinx/coroutines/flow/SharedFlowImpl;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/flow/internal/AbstractSharedFlow;", "Lkotlinx/coroutines/flow/SharedFlowSlot;", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lkotlinx/coroutines/flow/CancellableFlow;", "Lkotlinx/coroutines/flow/internal/FusibleFlow;", "replay", "", "bufferCapacity", "onBufferOverflow", "Lkotlinx/coroutines/channels/BufferOverflow;", "(IILkotlinx/coroutines/channels/BufferOverflow;)V", "buffer", "", "", "[Ljava/lang/Object;", "bufferEndIndex", "", "getBufferEndIndex", "()J", "bufferSize", "head", "getHead", "lastReplayedLocked", "getLastReplayedLocked$annotations", "()V", "getLastReplayedLocked", "()Ljava/lang/Object;", "minCollectorIndex", "queueEndIndex", "getQueueEndIndex", "queueSize", "replayCache", "", "getReplayCache", "()Ljava/util/List;", "replayIndex", "replaySize", "getReplaySize", "()I", "totalSize", "getTotalSize", "awaitValue", "", "slot", "(Lkotlinx/coroutines/flow/SharedFlowSlot;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cancelEmitter", "emitter", "Lkotlinx/coroutines/flow/SharedFlowImpl$Emitter;", "cleanupTailLocked", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "correctCollectorIndexesOnDropOldest", "newHead", "createSlot", "createSlotArray", PerfConsts.PERF_DISK_FILE_SIZE, "(I)[Lkotlinx/coroutines/flow/SharedFlowSlot;", "dropOldestLocked", "emit", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "emitSuspend", "enqueueLocked", "item", "findSlotsToResumeLocked", "Lkotlin/coroutines/Continuation;", "resumesIn", "([Lkotlin/coroutines/Continuation;)[Lkotlin/coroutines/Continuation;", "fuse", "Lkotlinx/coroutines/flow/Flow;", "context", "Lkotlin/coroutines/CoroutineContext;", PerfConsts.KEY_CURRENT_CAPACITY, "getPeekedValueLockedAt", "index", "growBuffer", "curBuffer", "curSize", "newSize", "([Ljava/lang/Object;II)[Ljava/lang/Object;", "resetReplayCache", "tryEmit", "", "(Ljava/lang/Object;)Z", "tryEmitLocked", "tryEmitNoCollectorsLocked", "tryPeekLocked", "tryTakeValue", "updateBufferLocked", "newReplayIndex", "newMinCollectorIndex", "newBufferEndIndex", "newQueueEndIndex", "updateCollectorIndexLocked", "oldIndex", "updateCollectorIndexLocked$kotlinx_coroutines_core", "(J)[Lkotlin/coroutines/Continuation;", "updateNewCollectorIndexLocked", "updateNewCollectorIndexLocked$kotlinx_coroutines_core", "Emitter", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public class SharedFlowImpl<T> extends AbstractSharedFlow<SharedFlowSlot> implements MutableSharedFlow<T>, CancellableFlow<T>, FusibleFlow<T> {
    private Object[] buffer;
    private final int bufferCapacity;
    private int bufferSize;
    private long minCollectorIndex;
    private final BufferOverflow onBufferOverflow;
    private int queueSize;
    private final int replay;
    private long replayIndex;

    /* JADX INFO: compiled from: SharedFlow.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B1\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0002\u0010\u000bJ\b\u0010\f\u001a\u00020\nH\u0016R\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lkotlinx/coroutines/flow/SharedFlowImpl$Emitter;", "Lkotlinx/coroutines/DisposableHandle;", "flow", "Lkotlinx/coroutines/flow/SharedFlowImpl;", "index", "", "value", "", "cont", "Lkotlin/coroutines/Continuation;", "", "(Lkotlinx/coroutines/flow/SharedFlowImpl;JLjava/lang/Object;Lkotlin/coroutines/Continuation;)V", "dispose", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class Emitter implements DisposableHandle {
        public final Continuation<Unit> cont;
        public final SharedFlowImpl<?> flow;
        public long index;
        public final Object value;

        /* JADX WARN: Multi-variable type inference failed */
        public Emitter(SharedFlowImpl<?> r1, long r2, Object r4, Continuation<? super Unit> r5) {
            this.flow = r1;
            this.index = r2;
            this.value = r4;
            this.cont = r5;
        }

        @Override // kotlinx.coroutines.DisposableHandle
        public void dispose() {
            SharedFlowImpl.access$cancelEmitter(this.flow, this);
        }
    }

    /* JADX INFO: compiled from: SharedFlow.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r0 = new int[BufferOverflow.values().length];
            r0[BufferOverflow.SUSPEND.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[BufferOverflow.DROP_LATEST.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[BufferOverflow.DROP_OLDEST.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            $EnumSwitchMapping$0 = r0;
        }
    }

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.SharedFlowImpl$collect$1, reason: invalid class name */
    /* JADX INFO: compiled from: SharedFlow.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "kotlinx.coroutines.flow.SharedFlowImpl", f = "SharedFlow.kt", i = {0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 2}, l = {372, 379, 382}, m = "collect$suspendImpl", n = {"$this", "collector", "slot", "$this", "collector", "slot", "collectorJob", "$this", "collector", "slot", "collectorJob"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3"})
    static final class AnonymousClass1<T> extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ SharedFlowImpl<T> this$0;

        AnonymousClass1(SharedFlowImpl<T> r1, Continuation<? super AnonymousClass1> r2) {
            this.this$0 = r1;
            super(r2);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= Integer.MIN_VALUE;
            return SharedFlowImpl.collect$suspendImpl(this.this$0, null, this);
        }
    }

    protected static /* synthetic */ void getLastReplayedLocked$annotations() {
    }

    @Override // kotlinx.coroutines.flow.SharedFlow, kotlinx.coroutines.flow.Flow
    public Object collect(FlowCollector<? super T> r1, Continuation<?> r2) {
        return collect$suspendImpl(this, r1, r2);
    }

    @Override // kotlinx.coroutines.flow.MutableSharedFlow, kotlinx.coroutines.flow.FlowCollector
    public Object emit(T r1, Continuation<? super Unit> r2) {
        return emit$suspendImpl(this, r1, r2);
    }

    public static final /* synthetic */ Object access$awaitValue(SharedFlowImpl r0, SharedFlowSlot r1, Continuation r2) {
        return r0.awaitValue(r1, r2);
    }

    public static final /* synthetic */ void access$cancelEmitter(SharedFlowImpl r0, Emitter r1) {
        r0.cancelEmitter(r1);
    }

    public static final /* synthetic */ Object access$emitSuspend(SharedFlowImpl r0, Object r1, Continuation r2) {
        return r0.emitSuspend(r1, r2);
    }

    public static final /* synthetic */ void access$enqueueLocked(SharedFlowImpl r0, Object r1) {
        r0.enqueueLocked(r1);
    }

    public static final /* synthetic */ Continuation[] access$findSlotsToResumeLocked(SharedFlowImpl r0, Continuation[] r1) {
        return r0.findSlotsToResumeLocked(r1);
    }

    public static final /* synthetic */ int access$getBufferCapacity$p(SharedFlowImpl r0) {
        return r0.bufferCapacity;
    }

    public static final /* synthetic */ long access$getHead(SharedFlowImpl r2) {
        return r2.getHead();
    }

    public static final /* synthetic */ int access$getQueueSize$p(SharedFlowImpl r0) {
        return r0.queueSize;
    }

    public static final /* synthetic */ int access$getTotalSize(SharedFlowImpl r0) {
        return r0.getTotalSize();
    }

    public static final /* synthetic */ void access$setQueueSize$p(SharedFlowImpl r0, int r1) {
        r0.queueSize = r1;
    }

    public static final /* synthetic */ boolean access$tryEmitLocked(SharedFlowImpl r0, Object r1) {
        return r0.tryEmitLocked(r1);
    }

    public static final /* synthetic */ long access$tryPeekLocked(SharedFlowImpl r0, SharedFlowSlot r1) {
        return r0.tryPeekLocked(r1);
    }

    @Override // kotlinx.coroutines.flow.internal.AbstractSharedFlow
    public /* bridge */ /* synthetic */ AbstractSharedFlowSlot createSlot() {
        return createSlot();
    }

    @Override // kotlinx.coroutines.flow.internal.AbstractSharedFlow
    public /* bridge */ /* synthetic */ AbstractSharedFlowSlot[] createSlotArray(int r1) {
        return createSlotArray(r1);
    }

    public SharedFlowImpl(int r1, int r2, BufferOverflow r3) {
        this.replay = r1;
        this.bufferCapacity = r2;
        this.onBufferOverflow = r3;
    }

    private final long getHead() {
        return Math.min(this.minCollectorIndex, this.replayIndex);
    }

    private final int getReplaySize() {
        return (int) ((getHead() + ((long) this.bufferSize)) - this.replayIndex);
    }

    private final int getTotalSize() {
        return this.bufferSize + this.queueSize;
    }

    private final long getBufferEndIndex() {
        return getHead() + ((long) this.bufferSize);
    }

    private final long getQueueEndIndex() {
        return (getHead() + ((long) this.bufferSize)) + ((long) this.queueSize);
    }

    protected final T getLastReplayedLocked() {
        Object[] r0 = this.buffer;
        Intrinsics.checkNotNull(r0);
        return (T) SharedFlowKt.access$getBufferAt(r0, (this.replayIndex + ((long) getReplaySize())) - 1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ <T> Object collect$suspendImpl(SharedFlowImpl<T> r8, FlowCollector<? super T> r9, Continuation<?> r10) {
        if ((r10 instanceof AnonymousClass1) == false) goto L7;
        AnonymousClass1 r0 = (AnonymousClass1) r10;
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r11 = r0.result;
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r0.label;
        if (r2 == 0) goto L26;
        if (r2 == 1) goto L21;
        if (r2 == 2) goto L16;
        if (r2 != 3) goto L15;
        Job r12 = (Job) r0.L$3;
        SharedFlowSlot r13 = (SharedFlowSlot) r0.L$2;
        FlowCollector r3 = (FlowCollector) r0.L$1;
        SharedFlowImpl<T> r5 = (SharedFlowImpl) r0.L$0;
    L56:
        ResultKt.throwOnFailure(r11);     // Catch: Throwable -> L19
        FlowCollector r14 = r3;
        Job r4 = r12;
        r8 = r5;
    L34:
        Object r6 = r8.tryTakeValue(r13);     // Catch: Throwable -> L44
        if (r6 == SharedFlowKt.NO_VALUE) goto L36;
        if (r4 == null) goto L41;
        JobKt.ensureActive(r4);     // Catch: Throwable -> L44
    L41:
        r0.L$0 = r8;     // Catch: Throwable -> L44
        r0.L$1 = r14;     // Catch: Throwable -> L44
        r0.L$2 = r13;     // Catch: Throwable -> L44
        r0.L$3 = r4;     // Catch: Throwable -> L44
        r0.label = 3;     // Catch: Throwable -> L44
        if (r14.emit(r6, r0) != r1) goto L34;
        return r1;
    L36:
        r0.L$0 = r8;     // Catch: Throwable -> L44
        r0.L$1 = r14;     // Catch: Throwable -> L44
        r0.L$2 = r13;     // Catch: Throwable -> L44
        r0.L$3 = r4;     // Catch: Throwable -> L44
        r0.label = 2;     // Catch: Throwable -> L44
        if (r8.awaitValue(r13, r0) != r1) goto L34;
        return r1;
    L44:
        th = move-exception;
        r5 = r8;
        Throwable th = th;
    L48:
        r5.freeSlot(r13);
        throw th;
    L19:
        th = th;
        goto L48
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        r12 = (Job) r0.L$3;
        r13 = (SharedFlowSlot) r0.L$2;
        r3 = (FlowCollector) r0.L$1;
        r5 = (SharedFlowImpl) r0.L$0;
        goto L56
    L21:
        r13 = (SharedFlowSlot) r0.L$2;
        FlowCollector<? super T> r15 = (FlowCollector) r0.L$1;
        SharedFlowImpl<T> r7 = (SharedFlowImpl) r0.L$0;
        ResultKt.throwOnFailure(r11);     // Catch: Throwable -> L24
        FlowCollector<? super T> r16 = r15;
        r8 = r7;
    L52:
        r4 = (Job) r0.getContext().get(Job.Key);     // Catch: Throwable -> L44
        r14 = r16;
    L24:
        th = th;
        r5 = r7;
        goto L48
    L26:
        ResultKt.throwOnFailure(r11);
        SharedFlowSlot r17 = r8.allocateSlot();
    L46:
        th = move-exception;
        r5 = r8;
        th = th;
        r13 = r17;
        goto L48
    L28:
        if ((r9 instanceof SubscribedFlowCollector) == false) goto L32;
        r0.L$0 = r8;     // Catch: Throwable -> L46
        r0.L$1 = r9;     // Catch: Throwable -> L46
        r0.L$2 = r17;     // Catch: Throwable -> L46
        r0.label = 1;     // Catch: Throwable -> L46
        if (((SubscribedFlowCollector) r9).onSubscription(r0) != r1) goto L32;
        return r1;
    L32:
        r16 = r9;
        r13 = r17;
    L7:
        r0 = new AnonymousClass1(r8, r10);
        goto L8
    }

    @Override // kotlinx.coroutines.flow.MutableSharedFlow
    public boolean tryEmit(T r5) {
        Continuation<Unit>[] r0 = AbstractSharedFlowKt.EMPTY_RESUMES;
        monitor-enter(this);
        int r1 = 0;
        if (tryEmitLocked(r5) == false) goto L8;
        r0 = findSlotsToResumeLocked(r0);     // Catch: Throwable -> L17
        boolean r6 = true;
    L9:
        monitor-exit(this);
        int r4 = r0.length;
    L11:
        if (r1 >= r4) goto L16;
        Continuation<Unit> r2 = r0[r1];
        if (r2 == null) goto L15;
        Result.Companion r3 = Result.Companion;
        r2.resumeWith(Result.m1508constructorimpl(Unit.INSTANCE));
    L15:
        r1 = r1 + 1;
        goto L11
    L16:
        return r6;
    L8:
        r6 = false;
    L17:
        th = move-exception;
        throw th;
    }

    static /* synthetic */ <T> Object emit$suspendImpl(SharedFlowImpl<T> r1, T r2, Continuation<? super Unit> r3) {
        if (r1.tryEmit(r2) == true) goto L5;
        Object r4 = r1.emitSuspend(r2, r3);
        if (r4 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L10;
        return r4;
    L10:
        return Unit.INSTANCE;
    L5:
        return Unit.INSTANCE;
    }

    private final boolean tryEmitLocked(T r15) {
        if (getNCollectors() != 0) goto L7;
        return tryEmitNoCollectorsLocked(r15);
    L7:
        if (this.bufferSize >= this.bufferCapacity) goto L9;
    L18:
        enqueueLocked(r15);
        int r16 = this.bufferSize + 1;
        this.bufferSize = r16;
        if (r16 <= this.bufferCapacity) goto L22;
        dropOldestLocked();
    L22:
        if (getReplaySize() <= this.replay) goto L24;
        updateBufferLocked(this.replayIndex + 1, this.minCollectorIndex, getBufferEndIndex(), getQueueEndIndex());
    L24:
        return true;
    L9:
        if (this.minCollectorIndex > this.replayIndex) goto L18;
        BufferOverflow r0 = this.onBufferOverflow;
        int r1 = WhenMappings.$EnumSwitchMapping$0[r0.ordinal()];
        if (r1 != 1) goto L13;
        return false;
    L13:
        if (r1 != 2) goto L18;
        return true;
    }

    private final boolean tryEmitNoCollectorsLocked(T r7) {
        if (DebugKt.getASSERTIONS_ENABLED() == false) goto L13;
        if (getNCollectors() != 0) goto L7;
        boolean r0 = true;
    L8:
        if (r0 == true) goto L13;
        throw new AssertionError();
    L7:
        r0 = false;
    L13:
        if (this.replay != 0) goto L15;
        return true;
    L15:
        enqueueLocked(r7);
        int r8 = this.bufferSize + 1;
        this.bufferSize = r8;
        if (r8 <= this.replay) goto L18;
        dropOldestLocked();
    L18:
        this.minCollectorIndex = getHead() + ((long) this.bufferSize);
        return true;
    }

    private final void dropOldestLocked() {
        Object[] r0 = this.buffer;
        Intrinsics.checkNotNull(r0);
        SharedFlowKt.access$setBufferAt(r0, getHead(), null);
        this.bufferSize--;
        long r1 = getHead() + 1;
        if (this.replayIndex >= r1) goto L6;
        this.replayIndex = r1;
    L6:
        if (this.minCollectorIndex >= r1) goto L9;
        correctCollectorIndexesOnDropOldest(r1);
    L9:
        if (DebugKt.getASSERTIONS_ENABLED() == true) goto L11;
        return;
    L11:
        if (getHead() != r1) goto L13;
        boolean r4 = true;
    L14:
        if (r4 == false) goto L17;
        return;
    L17:
        throw new AssertionError();
    L13:
        r4 = false;
        goto L14
    }

    private final void correctCollectorIndexesOnDropOldest(long r9) {
        SharedFlowImpl<T> r0 = this;
        if (AbstractSharedFlow.access$getNCollectors(r0) == 0) goto L16;
        AbstractSharedFlowSlot[] r1 = AbstractSharedFlow.access$getSlots(r0);
        if (r1 == null) goto L16;
        int r2 = r1.length;
        int r3 = 0;
    L7:
        if (r3 >= r2) goto L16;
        AbstractSharedFlowSlot r4 = r1[r3];
        if (r4 == null) goto L15;
        SharedFlowSlot r5 = (SharedFlowSlot) r4;
        if (r5.index < 0) goto L15;
        if (r5.index >= r9) goto L15;
        r5.index = r9;
    L15:
        r3 = r3 + 1;
    L16:
        this.minCollectorIndex = r9;
    }

    private final void enqueueLocked(Object r7) {
        int r0 = getTotalSize();
        Object[] r1 = this.buffer;
        if (r1 != null) goto L6;
        r1 = growBuffer(null, 0, 2);
    L8:
        SharedFlowKt.access$setBufferAt(r1, getHead() + ((long) r0), r7);
        return;
    L6:
        if (r0 < r1.length) goto L8;
        r1 = growBuffer(r1, r0, r1.length * 2);
        goto L8
    }

    private final Object[] growBuffer(Object[] r6, int r7, int r8) {
        int r0 = 0;
        if (r8 <= 0) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L15;
        Object[] r9 = new Object[r8];
        this.buffer = r9;
        if (r6 != null) goto L10;
        return r9;
    L10:
        long r2 = getHead();
    L11:
        if (r0 >= r7) goto L13;
        long r3 = ((long) r0) + r2;
        SharedFlowKt.access$setBufferAt(r9, r3, SharedFlowKt.access$getBufferAt(r6, r3));
        r0 = r0 + 1;
        goto L11
    L13:
        return r9;
    L15:
        throw new IllegalStateException("Buffer size overflow".toString());
    L5:
        r1 = false;
        goto L6
    }

    public final long updateNewCollectorIndexLocked$kotlinx_coroutines_core() {
        long r0 = this.replayIndex;
        if (r0 >= this.minCollectorIndex) goto L5;
        this.minCollectorIndex = r0;
    L5:
        return r0;
    }

    public final Continuation<Unit>[] updateCollectorIndexLocked$kotlinx_coroutines_core(long r21) {
        if (DebugKt.getASSERTIONS_ENABLED() == false) goto L13;
        if (r21 < this.minCollectorIndex) goto L7;
        boolean r0 = true;
    L8:
        if (r0 == true) goto L13;
        throw new AssertionError();
    L7:
        r0 = false;
    L13:
        if (r21 > this.minCollectorIndex) goto L15;
        long r1 = getHead();
        long r2 = ((long) this.bufferSize) + r1;
        if (this.bufferCapacity == 0) goto L19;
    L21:
        SharedFlowImpl<T> r4 = this;
        if (AbstractSharedFlow.access$getNCollectors(r4) == 0) goto L36;
        AbstractSharedFlowSlot[] r5 = AbstractSharedFlow.access$getSlots(r4);
        if (r5 == null) goto L36;
        int r7 = r5.length;
        int r8 = 0;
    L26:
        if (r8 >= r7) goto L36;
        AbstractSharedFlowSlot r12 = r5[r8];
        if (r12 == null) goto L34;
        SharedFlowSlot r13 = (SharedFlowSlot) r12;
        if (r13.index < 0) goto L34;
        if (r13.index >= r2) goto L34;
        r2 = r13.index;
    L34:
        r8 = r8 + 1;
    L36:
        if (DebugKt.getASSERTIONS_ENABLED() == false) goto L46;
        if (r2 < this.minCollectorIndex) goto L40;
        boolean r6 = true;
    L41:
        if (r6 == true) goto L46;
        throw new AssertionError();
    L40:
        r6 = false;
    L46:
        if (r2 <= this.minCollectorIndex) goto L48;
        long r9 = getBufferEndIndex();
        if (getNCollectors() <= 0) goto L52;
        int r10 = (int) (r9 - r2);
        int r11 = Math.min(this.queueSize, this.bufferCapacity - r10);
    L53:
        Continuation<Unit>[] r14 = AbstractSharedFlowKt.EMPTY_RESUMES;
        long r15 = ((long) this.queueSize) + r9;
        if (r11 <= 0) goto L67;
        r14 = new Continuation[r11];
        Object[] r16 = this.buffer;
        Intrinsics.checkNotNull(r16);
        long r17 = r9;
        int r18 = 0;
    L57:
        if (r9 >= r15) goto L65;
        Object r19 = SharedFlowKt.access$getBufferAt(r16, r9);
        if (r19 == SharedFlowKt.NO_VALUE) goto L63;
        Intrinsics.checkNotNull(r19, "null cannot be cast to non-null type kotlinx.coroutines.flow.SharedFlowImpl.Emitter");
        Emitter r20 = (Emitter) r19;
        int r22 = r18 + 1;
        long r110 = r2;
        r14[r18] = r20.cont;
        SharedFlowKt.access$setBufferAt(r16, r9, SharedFlowKt.NO_VALUE);
        SharedFlowKt.access$setBufferAt(r16, r17, r20.value);
        long r3 = 1;
        r17 = r17 + 1;
        if (r22 >= r11) goto L66;
        r18 = r22;
    L64:
        r9 = r9 + r3;
        r2 = r110;
    L66:
        r9 = r17;
    L68:
        int r23 = (int) (r9 - r1);
        if (getNCollectors() != 0) goto L71;
        long r24 = r9;
    L72:
        long r25 = Math.max(this.replayIndex, r9 - ((long) Math.min(this.replay, r23)));
        if (this.bufferCapacity == 0) goto L75;
    L79:
        updateBufferLocked(r25, r24, r9, r15);
        cleanupTailLocked();
        if (r14.length != 0) goto L82;
        boolean r111 = true;
    L84:
        if ((true ^ r111) == true) goto L86;
        return r14;
    L86:
        return findSlotsToResumeLocked(r14);
    L82:
        r111 = false;
        goto L84
    L75:
        if (r25 >= r15) goto L79;
        Object[] r26 = this.buffer;
        Intrinsics.checkNotNull(r26);
        if (Intrinsics.areEqual(SharedFlowKt.access$getBufferAt(r26, r25), SharedFlowKt.NO_VALUE) == false) goto L79;
        r9 = r9 + 1;
        r25 = r25 + 1;
        goto L79
    L71:
        r24 = r110;
        goto L72
    L63:
        r110 = r2;
        r3 = 1;
        goto L64
    L65:
        r110 = r2;
        goto L66
    L67:
        r110 = r2;
        goto L68
    L52:
        r11 = this.queueSize;
        goto L53
    L48:
        return AbstractSharedFlowKt.EMPTY_RESUMES;
    L19:
        if (this.queueSize <= 0) goto L21;
        r2 = r2 + 1;
        goto L21
    L15:
        return AbstractSharedFlowKt.EMPTY_RESUMES;
    }

    private final void updateBufferLocked(long r15, long r17, long r19, long r21) {
        long r5 = Math.min(r17, r15);
        boolean r8 = true;
        if (DebugKt.getASSERTIONS_ENABLED() == true) goto L5;
    L12:
        long r10 = getHead();
    L14:
        if (r10 >= r5) goto L16;
        Object[] r7 = this.buffer;
        Intrinsics.checkNotNull(r7);
        SharedFlowKt.access$setBufferAt(r7, r10, null);
        r10 = r10 + 1;
        goto L14
    L16:
        this.replayIndex = r15;
        this.minCollectorIndex = r17;
        this.bufferSize = (int) (r19 - r5);
        this.queueSize = (int) (r21 - r19);
        if (DebugKt.getASSERTIONS_ENABLED() == false) goto L27;
        if (this.bufferSize < 0) goto L21;
        boolean r1 = true;
    L22:
        if (r1 == true) goto L27;
        throw new AssertionError();
    L21:
        r1 = false;
    L27:
        if (DebugKt.getASSERTIONS_ENABLED() == false) goto L37;
        if (this.queueSize < 0) goto L31;
        boolean r2 = true;
    L32:
        if (r2 == true) goto L37;
        throw new AssertionError();
    L31:
        r2 = false;
    L37:
        if (DebugKt.getASSERTIONS_ENABLED() == true) goto L39;
        return;
    L39:
        if (this.replayIndex <= (getHead() + ((long) this.bufferSize))) goto L42;
        r8 = false;
    L42:
        if (r8 == false) goto L45;
        return;
    L45:
        throw new AssertionError();
    L5:
        if (r5 < getHead()) goto L7;
        boolean r9 = true;
    L8:
        if (r9 == true) goto L12;
        throw new AssertionError();
    L7:
        r9 = false;
        goto L8
    }

    private final void cleanupTailLocked() {
        if (this.bufferCapacity == 0) goto L5;
    L7:
        Object[] r0 = this.buffer;
        Intrinsics.checkNotNull(r0);
    L9:
        if (this.queueSize <= 0) goto L13;
        if (SharedFlowKt.access$getBufferAt(r0, (getHead() + ((long) getTotalSize())) - 1) != SharedFlowKt.NO_VALUE) goto L16;
        this.queueSize--;
        SharedFlowKt.access$setBufferAt(r0, getHead() + ((long) getTotalSize()), null);
        goto L9
    L16:
        return;
    L13:
        return;
    L5:
        if (this.queueSize > 1) goto L7;
    }

    private final Object tryTakeValue(SharedFlowSlot r9) {
        Continuation<Unit>[] r0 = AbstractSharedFlowKt.EMPTY_RESUMES;
        monitor-enter(this);
        long r1 = tryPeekLocked(r9);     // Catch: Throwable -> L17
        if (r1 >= 0) goto L7;
        Object r10 = SharedFlowKt.NO_VALUE;     // Catch: Throwable -> L17
    L9:
        monitor-exit(this);
        int r8 = r0.length;
        int r2 = 0;
    L11:
        if (r2 >= r8) goto L16;
        Continuation<Unit> r3 = r0[r2];
        if (r3 == null) goto L15;
        Result.Companion r4 = Result.Companion;
        r3.resumeWith(Result.m1508constructorimpl(Unit.INSTANCE));
    L15:
        r2 = r2 + 1;
        goto L11
    L16:
        return r10;
    L7:
        long r5 = r9.index;     // Catch: Throwable -> L17
        Object r6 = getPeekedValueLockedAt(r1);     // Catch: Throwable -> L17
        r9.index = r1 + 1;     // Catch: Throwable -> L17
        r0 = updateCollectorIndexLocked$kotlinx_coroutines_core(r5);     // Catch: Throwable -> L17
        r10 = r6;
    L17:
        th = move-exception;
        throw th;
    }

    private final long tryPeekLocked(SharedFlowSlot r7) {
        long r0 = r7.index;
        if (r0 >= getBufferEndIndex()) goto L6;
        return r0;
    L6:
        if (this.bufferCapacity <= 0) goto L9;
        return -1;
    L9:
        if (r0 <= getHead()) goto L12;
        return -1;
    L12:
        if (this.queueSize != 0) goto L14;
        return -1;
    L14:
        return r0;
    }

    private final Object getPeekedValueLockedAt(long r1) {
        Object[] r0 = this.buffer;
        Intrinsics.checkNotNull(r0);
        Object r2 = SharedFlowKt.access$getBufferAt(r0, r1);
        if ((r2 instanceof Emitter) == true) goto L5;
        return r2;
    L5:
        return ((Emitter) r2).value;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v0, types: [kotlin.coroutines.Continuation<kotlin.Unit>[]] */
    /* JADX WARN: Type inference failed for: r11v1 */
    /* JADX WARN: Type inference failed for: r11v10 */
    /* JADX WARN: Type inference failed for: r11v3, types: [java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r11v4 */
    /* JADX WARN: Type inference failed for: r11v5 */
    /* JADX WARN: Type inference failed for: r11v7 */
    /* JADX WARN: Type inference failed for: r11v8 */
    /* JADX WARN: Type inference failed for: r11v9 */
    /* JADX WARN: Type inference failed for: r6v3 */
    private final Continuation<Unit>[] findSlotsToResumeLocked(Continuation<Unit>[] r11) {
        int r0 = r11.length;
        SharedFlowImpl<T> r1 = this;
        if (AbstractSharedFlow.access$getNCollectors(r1) == 0) goto L21;
        AbstractSharedFlowSlot[] r2 = AbstractSharedFlow.access$getSlots(r1);
        if (r2 == null) goto L21;
        int r3 = r2.length;
        int r4 = 0;
        r11 = r11;
    L7:
        if (r4 >= r3) goto L21;
        AbstractSharedFlowSlot r5 = r2[r4];
        if (r5 == null) goto L19;
        SharedFlowSlot r6 = (SharedFlowSlot) r5;
        Continuation<? super Unit> r7 = r6.cont;
        if (r7 == null) goto L19;
        if (tryPeekLocked(r6) < 0) goto L19;
        int r8 = r11.length;
        r11 = r11;
        if (r0 < r8) goto L18;
        Object[] r12 = Arrays.copyOf(r11, Math.max(2, r11.length * 2));
        Intrinsics.checkNotNullExpressionValue(r12, "copyOf(this, newSize)");
        r11 = r12;
    L18:
        ((Continuation[]) r11)[r0] = r7;
        r6.cont = null;
        r0 = r0 + 1;
    L19:
        r4 = r4 + 1;
        r11 = r11;
    L21:
        return (Continuation[]) r11;
    }

    @Override // kotlinx.coroutines.flow.internal.AbstractSharedFlow
    protected SharedFlowSlot createSlot() {
        return new SharedFlowSlot();
    }

    @Override // kotlinx.coroutines.flow.internal.AbstractSharedFlow
    protected SharedFlowSlot[] createSlotArray(int r1) {
        return new SharedFlowSlot[r1];
    }

    @Override // kotlinx.coroutines.flow.internal.FusibleFlow
    public Flow<T> fuse(CoroutineContext r1, int r2, BufferOverflow r3) {
        return SharedFlowKt.fuseSharedFlow(this, r1, r2, r3);
    }

    @Override // kotlinx.coroutines.flow.SharedFlow
    public List<T> getReplayCache() {
        monitor-enter(this);
        int r0 = getReplaySize();     // Catch: Throwable -> L15
        if (r0 != 0) goto L8;
        List<T> r1 = CollectionsKt.emptyList();     // Catch: Throwable -> L15
        monitor-exit(this);
        return r1;
    L8:
        ArrayList r2 = new ArrayList(r0);     // Catch: Throwable -> L15
        Object[] r3 = this.buffer;     // Catch: Throwable -> L15
        Intrinsics.checkNotNull(r3);     // Catch: Throwable -> L15
        int r4 = 0;
    L9:
        if (r4 >= r0) goto L12;
        r2.add(SharedFlowKt.access$getBufferAt(r3, this.replayIndex + ((long) r4)));     // Catch: Throwable -> L15
        r4 = r4 + 1;
        goto L9
    L12:
        monitor-exit(this);
        return r2;
    L15:
        th = move-exception;
        throw th;
    }

    private final Object emitSuspend(T r12, Continuation<? super Unit> r13) {
        CancellableContinuationImpl r0 = new CancellableContinuationImpl(IntrinsicsKt.intercepted(r13), 1);
        r0.initCancellability();
        CancellableContinuationImpl r1 = r0;
        Continuation<Unit>[] r3 = AbstractSharedFlowKt.EMPTY_RESUMES;
        monitor-enter(this);
    L28:
        th = move-exception;
        throw th;
    L5:
        if (access$tryEmitLocked(this, r12) == false) goto L7;
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L28
        r1.resumeWith(Result.m1508constructorimpl(Unit.INSTANCE));     // Catch: Throwable -> L28
        Continuation<Unit>[] r14 = access$findSlotsToResumeLocked(this, r3);     // Catch: Throwable -> L28
        Emitter r4 = null;
    L11:
        monitor-exit(this);
        if (r4 == null) goto L14;
        CancellableContinuationKt.disposeOnCancellation(r1, r4);
    L14:
        int r11 = r14.length;
        int r5 = 0;
    L15:
        if (r5 >= r11) goto L20;
        Continuation<Unit> r6 = r14[r5];
        if (r6 == null) goto L19;
        Result.Companion r7 = Result.Companion;
        r6.resumeWith(Result.m1508constructorimpl(Unit.INSTANCE));
    L19:
        r5 = r5 + 1;
        goto L15
    L20:
        Object r15 = r0.getResult();
        if (r15 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L24;
        DebugProbesKt.probeCoroutineSuspended(r13);
    L24:
        if (r15 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L27;
        return r15;
    L27:
        return Unit.INSTANCE;
    L7:
        long r8 = access$getHead(this);     // Catch: Throwable -> L28
        Emitter r10 = new Emitter(this, ((long) access$getTotalSize(this)) + r8, r12, r1);     // Catch: Throwable -> L28
        access$enqueueLocked(this, r10);     // Catch: Throwable -> L28
        access$setQueueSize$p(this, access$getQueueSize$p(this) + 1);     // Catch: Throwable -> L28
        if (access$getBufferCapacity$p(this) != 0) goto L10;
        r3 = access$findSlotsToResumeLocked(this, r3);     // Catch: Throwable -> L28
    L10:
        r14 = r3;
        r4 = r10;
        goto L11
    }

    private final void cancelEmitter(Emitter r5) {
        monitor-enter(this);
    L15:
        th = move-exception;
        throw th;
    L5:
        if (r5.index >= getHead()) goto L8;
        monitor-exit(this);
        return;
    L8:
        Object[] r0 = this.buffer;     // Catch: Throwable -> L15
        Intrinsics.checkNotNull(r0);     // Catch: Throwable -> L15
        if (SharedFlowKt.access$getBufferAt(r0, r5.index) == r5) goto L12;
        monitor-exit(this);
        return;
    L12:
        SharedFlowKt.access$setBufferAt(r0, r5.index, SharedFlowKt.NO_VALUE);     // Catch: Throwable -> L15
        cleanupTailLocked();     // Catch: Throwable -> L15
        Unit r6 = Unit.INSTANCE;     // Catch: Throwable -> L15
        monitor-exit(this);
    }

    private final Object awaitValue(SharedFlowSlot r7, Continuation<? super Unit> r8) {
        CancellableContinuationImpl r0 = new CancellableContinuationImpl(IntrinsicsKt.intercepted(r8), 1);
        r0.initCancellability();
        CancellableContinuationImpl r1 = r0;
        monitor-enter(this);
    L18:
        th = move-exception;
        throw th;
    L5:
        if (access$tryPeekLocked(this, r7) >= 0) goto L7;
        r7.cont = r1;     // Catch: Throwable -> L18
        r7.cont = r1;     // Catch: Throwable -> L18
    L8:
        Unit r9 = Unit.INSTANCE;     // Catch: Throwable -> L18
        monitor-exit(this);
        Object r6 = r0.getResult();
        if (r6 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L14;
        DebugProbesKt.probeCoroutineSuspended(r8);
    L14:
        if (r6 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L17;
        return r6;
    L17:
        return Unit.INSTANCE;
    L7:
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L18
        r1.resumeWith(Result.m1508constructorimpl(Unit.INSTANCE));     // Catch: Throwable -> L18
        goto L8
    }

    @Override // kotlinx.coroutines.flow.MutableSharedFlow
    public void resetReplayCache() {
        monitor-enter(this);
        updateBufferLocked(getBufferEndIndex(), this.minCollectorIndex, getBufferEndIndex(), getQueueEndIndex());     // Catch: Throwable -> L6
        Unit r0 = Unit.INSTANCE;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }
}
