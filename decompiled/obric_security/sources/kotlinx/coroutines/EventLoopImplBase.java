package kotlinx.coroutines;

import com.bytedanceos.security.Utils;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.time.DurationKt;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;
import kotlinx.coroutines.internal.ThreadSafeHeap;
import kotlinx.coroutines.internal.ThreadSafeHeapNode;
import tmsdkobf.b0$$ExternalSyntheticBackport0;

/* JADX INFO: compiled from: EventLoop.common.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\u0018\u0002\b \u0018\u00002\u0002092\u00020::\u00044567B\u0007¢\u0006\u0004\b\u0001\u0010\u0002J\u000f\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0004\u0010\u0002J\u0017\u0010\u0007\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\bJ!\u0010\f\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\t2\n\u0010\u000b\u001a\u00060\u0005j\u0002`\u0006¢\u0006\u0004\b\f\u0010\rJ\u001b\u0010\u000f\u001a\u00020\u00032\n\u0010\u000e\u001a\u00060\u0005j\u0002`\u0006H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u001b\u0010\u0012\u001a\u00020\u00112\n\u0010\u000e\u001a\u00060\u0005j\u0002`\u0006H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0017\u0010\u0002J\u000f\u0010\u0018\u001a\u00020\u0003H\u0004¢\u0006\u0004\b\u0018\u0010\u0002J\u001d\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u001a¢\u0006\u0004\b\u001c\u0010\u001dJ\u001f\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u001aH\u0002¢\u0006\u0004\b\u001f\u0010 J#\u0010#\u001a\u00020\"2\u0006\u0010!\u001a\u00020\u00142\n\u0010\u000b\u001a\u00060\u0005j\u0002`\u0006H\u0004¢\u0006\u0004\b#\u0010$J%\u0010'\u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u00142\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00030%H\u0016¢\u0006\u0004\b'\u0010(J\u0017\u0010)\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u001aH\u0002¢\u0006\u0004\b)\u0010*J\u000f\u0010+\u001a\u00020\u0003H\u0016¢\u0006\u0004\b+\u0010\u0002R$\u0010-\u001a\u00020\u00112\u0006\u0010,\u001a\u00020\u00118B@BX\u0082\u000e¢\u0006\f\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u0014\u00101\u001a\u00020\u00118TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b1\u0010.R\u0014\u00103\u001a\u00020\u00148TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b2\u0010\u0016¨\u00068"}, d2 = {"Lkotlinx/coroutines/EventLoopImplBase;", "<init>", "()V", "", "closeQueue", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "dequeue", "()Ljava/lang/Runnable;", "Lkotlin/coroutines/CoroutineContext;", "context", "block", "dispatch", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Runnable;)V", "task", "enqueue", "(Ljava/lang/Runnable;)V", "", "enqueueImpl", "(Ljava/lang/Runnable;)Z", "", "processNextEvent", "()J", "rescheduleAllDelayed", "resetAll", "now", "Lkotlinx/coroutines/EventLoopImplBase$DelayedTask;", "delayedTask", "schedule", "(JLkotlinx/coroutines/EventLoopImplBase$DelayedTask;)V", "", "scheduleImpl", "(JLkotlinx/coroutines/EventLoopImplBase$DelayedTask;)I", "timeMillis", "Lkotlinx/coroutines/DisposableHandle;", "scheduleInvokeOnTimeout", "(JLjava/lang/Runnable;)Lkotlinx/coroutines/DisposableHandle;", "Lkotlinx/coroutines/CancellableContinuation;", "continuation", "scheduleResumeAfterDelay", "(JLkotlinx/coroutines/CancellableContinuation;)V", "shouldUnpark", "(Lkotlinx/coroutines/EventLoopImplBase$DelayedTask;)Z", "shutdown", "value", "isCompleted", "()Z", "setCompleted", "(Z)V", "isEmpty", "getNextTime", "nextTime", "DelayedResumeTask", "DelayedRunnableTask", "DelayedTask", "DelayedTaskQueue", "kotlinx-coroutines-core", "Lkotlinx/coroutines/EventLoopImplPlatform;", "Lkotlinx/coroutines/Delay;"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class EventLoopImplBase extends EventLoopImplPlatform implements Delay {
    private static final /* synthetic */ AtomicReferenceFieldUpdater _delayed$FU = null;
    private static final /* synthetic */ AtomicReferenceFieldUpdater _queue$FU = null;
    private volatile /* synthetic */ Object _delayed;
    private volatile /* synthetic */ int _isCompleted;
    private volatile /* synthetic */ Object _queue;

    /* JADX INFO: compiled from: EventLoop.common.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\b\u0010\b\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\nH\u0016R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lkotlinx/coroutines/EventLoopImplBase$DelayedResumeTask;", "Lkotlinx/coroutines/EventLoopImplBase$DelayedTask;", "nanoTime", "", "cont", "Lkotlinx/coroutines/CancellableContinuation;", "", "(Lkotlinx/coroutines/EventLoopImplBase;JLkotlinx/coroutines/CancellableContinuation;)V", "run", "toString", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
    private final class DelayedResumeTask extends DelayedTask {
        private final CancellableContinuation<Unit> cont;
        final /* synthetic */ EventLoopImplBase this$0;

        /* JADX WARN: Multi-variable type inference failed */
        public DelayedResumeTask(EventLoopImplBase r1, long r2, CancellableContinuation<? super Unit> r4) {
            this.this$0 = r1;
            super(r2);
            this.cont = r4;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.cont.resumeUndispatched(this.this$0, Unit.INSTANCE);
        }

        @Override // kotlinx.coroutines.EventLoopImplBase.DelayedTask
        public String toString() {
            return super.toString() + this.cont;
        }
    }

    /* JADX INFO: compiled from: EventLoop.common.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\u0010\u0004\u001a\u00060\u0005j\u0002`\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\u000bH\u0016R\u0012\u0010\u0004\u001a\u00060\u0005j\u0002`\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lkotlinx/coroutines/EventLoopImplBase$DelayedRunnableTask;", "Lkotlinx/coroutines/EventLoopImplBase$DelayedTask;", "nanoTime", "", "block", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "(JLjava/lang/Runnable;)V", "run", "", "toString", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
    private static final class DelayedRunnableTask extends DelayedTask {
        private final Runnable block;

        public DelayedRunnableTask(long r1, Runnable r3) {
            super(r1);
            this.block = r3;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.block.run();
        }

        @Override // kotlinx.coroutines.EventLoopImplBase.DelayedTask
        public String toString() {
            return super.toString() + this.block;
        }
    }

    /* JADX INFO: compiled from: EventLoop.common.kt */
    @Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\b \u0018\u00002\u00060\u0001j\u0002`\u00022\b\u0012\u0004\u0012\u00020\u00000\u00032\u00020\u00042\u00020\u0005B\r\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0011\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u0000H\u0096\u0002J\u0006\u0010\u001a\u001a\u00020\u001bJ\u001e\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!J\u000e\u0010\"\u001a\u00020#2\u0006\u0010\u001d\u001a\u00020\u0007J\b\u0010$\u001a\u00020%H\u0016R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R0\u0010\r\u001a\b\u0012\u0002\b\u0003\u0018\u00010\f2\f\u0010\u000b\u001a\b\u0012\u0002\b\u0003\u0018\u00010\f8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0012\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lkotlinx/coroutines/EventLoopImplBase$DelayedTask;", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "", "Lkotlinx/coroutines/DisposableHandle;", "Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "nanoTime", "", "(J)V", "_heap", "", "value", "Lkotlinx/coroutines/internal/ThreadSafeHeap;", "heap", "getHeap", "()Lkotlinx/coroutines/internal/ThreadSafeHeap;", "setHeap", "(Lkotlinx/coroutines/internal/ThreadSafeHeap;)V", Utils.INTENT_KEY_INDEX, "", "getIndex", "()I", "setIndex", "(I)V", "compareTo", "other", "dispose", "", "scheduleTask", "now", "delayed", "Lkotlinx/coroutines/EventLoopImplBase$DelayedTaskQueue;", "eventLoop", "Lkotlinx/coroutines/EventLoopImplBase;", "timeToExecute", "", "toString", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static abstract class DelayedTask implements Runnable, Comparable<DelayedTask>, DisposableHandle, ThreadSafeHeapNode {
        private volatile Object _heap;
        private int index;
        public long nanoTime;

        public DelayedTask(long r1) {
            this.nanoTime = r1;
            this.index = -1;
        }

        @Override // java.lang.Comparable
        public /* bridge */ /* synthetic */ int compareTo(DelayedTask r1) {
            return compareTo2(r1);
        }

        @Override // kotlinx.coroutines.internal.ThreadSafeHeapNode
        public ThreadSafeHeap<?> getHeap() {
            Object r1 = this._heap;
            if ((r1 instanceof ThreadSafeHeap) == true) goto L7;
            return null;
        L7:
            return (ThreadSafeHeap) r1;
        }

        @Override // kotlinx.coroutines.internal.ThreadSafeHeapNode
        public void setHeap(ThreadSafeHeap<?> r3) {
            if (this._heap == EventLoop_commonKt.access$getDISPOSED_TASK$p()) goto L5;
            boolean r0 = true;
        L6:
            if (r0 == false) goto L10;
            this._heap = r3;
            return;
        L10:
            throw new IllegalArgumentException("Failed requirement.".toString());
        L5:
            r0 = false;
            goto L6
        }

        @Override // kotlinx.coroutines.internal.ThreadSafeHeapNode
        public int getIndex() {
            return this.index;
        }

        @Override // kotlinx.coroutines.internal.ThreadSafeHeapNode
        public void setIndex(int r1) {
            this.index = r1;
        }

        /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
        public int compareTo2(DelayedTask r3) {
            long r0 = this.nanoTime - r3.nanoTime;
            if (r0 <= 0) goto L5;
            return 1;
        L5:
            if (r0 >= 0) goto L7;
            return -1;
        L7:
            return 0;
        }

        public final boolean timeToExecute(long r3) {
            if ((r3 - this.nanoTime) < 0) goto L5;
            return true;
        L5:
            return false;
        }

        public final synchronized int scheduleTask(long r9, DelayedTaskQueue r11, EventLoopImplBase r12) {
            monitor-enter(this);
        L37:
            th = move-exception;
            throw th;
        L4:
            if (this._heap != EventLoop_commonKt.access$getDISPOSED_TASK$p()) goto L8;
            monitor-exit(this);
            return 2;
        L8:
            DelayedTaskQueue r0 = r11;     // Catch: Throwable -> L37
            monitor-enter(r0);     // Catch: Throwable -> L37
            DelayedTask r1 = r0.firstImpl();     // Catch: Throwable -> L34
            if (EventLoopImplBase.access$isCompleted(r12) == false) goto L17;
            monitor-exit(r0);     // Catch: Throwable -> L37
            monitor-exit(this);
            return 1;
        L17:
            if (r1 != null) goto L19;
            r11.timeNow = r9;     // Catch: Throwable -> L34
        L27:
            if ((this.nanoTime - r11.timeNow) >= 0) goto L29;
            this.nanoTime = r11.timeNow;     // Catch: Throwable -> L34
        L29:
            r0.addImpl(this);     // Catch: Throwable -> L34
            monitor-exit(r0);     // Catch: Throwable -> L37
            monitor-exit(this);
            return 0;
        L19:
            long r4 = r1.nanoTime;     // Catch: Throwable -> L34
            if ((r4 - r9) >= 0) goto L24;
            r9 = r4;
        L24:
            if ((r9 - r11.timeNow) <= 0) goto L27;
            r11.timeNow = r9;     // Catch: Throwable -> L34
        L34:
            th = move-exception;
            throw th;     // Catch: Throwable -> L37
        }

        @Override // kotlinx.coroutines.DisposableHandle
        public final synchronized void dispose() {
            monitor-enter(this);
            Object r0 = this._heap;     // Catch: Throwable -> L16
            if (r0 != EventLoop_commonKt.access$getDISPOSED_TASK$p()) goto L8;
            monitor-exit(this);
            return;
        L8:
            if ((r0 instanceof DelayedTaskQueue) == false) goto L10;
            DelayedTaskQueue r1 = (DelayedTaskQueue) r0;     // Catch: Throwable -> L16
        L11:
            if (r1 == null) goto L13;
            r1.remove(this);     // Catch: Throwable -> L16
        L13:
            this._heap = EventLoop_commonKt.access$getDISPOSED_TASK$p();     // Catch: Throwable -> L16
            monitor-exit(this);
            return;
        L10:
            r1 = null;
        L16:
            th = move-exception;
            throw th;
        }

        public String toString() {
            return "Delayed[nanos=" + this.nanoTime + ']';
        }
    }

    /* JADX INFO: compiled from: EventLoop.common.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005R\u0012\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lkotlinx/coroutines/EventLoopImplBase$DelayedTaskQueue;", "Lkotlinx/coroutines/internal/ThreadSafeHeap;", "Lkotlinx/coroutines/EventLoopImplBase$DelayedTask;", "timeNow", "", "(J)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class DelayedTaskQueue extends ThreadSafeHeap<DelayedTask> {
        public long timeNow;

        public DelayedTaskQueue(long r1) {
            this.timeNow = r1;
        }
    }

    static {
        _queue$FU = AtomicReferenceFieldUpdater.newUpdater(EventLoopImplBase.class, Object.class, "_queue");
        _delayed$FU = AtomicReferenceFieldUpdater.newUpdater(EventLoopImplBase.class, Object.class, "_delayed");
    }

    public EventLoopImplBase() {
        this._queue = null;
        this._delayed = null;
        this._isCompleted = 0;
    }

    public static final /* synthetic */ boolean access$isCompleted(EventLoopImplBase r0) {
        return r0.isCompleted();
    }

    @Override // kotlinx.coroutines.Delay
    @Deprecated(level = DeprecationLevel.ERROR, message = "Deprecated without replacement as an internal method never intended for public use")
    public Object delay(long r1, Continuation<? super Unit> r3) {
        return Delay.DefaultImpls.delay(this, r1, r3);
    }

    public DisposableHandle invokeOnTimeout(long r1, Runnable r3, CoroutineContext r4) {
        return Delay.DefaultImpls.invokeOnTimeout(this, r1, r3, r4);
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [boolean, int] */
    private final boolean isCompleted() {
        return this._isCompleted;
    }

    private final void setCompleted(boolean r1) {
        this._isCompleted = r1 ? 1 : 0;
    }

    @Override // kotlinx.coroutines.EventLoop
    protected boolean isEmpty() {
        if (isUnconfinedQueueEmpty() == true) goto L5;
        return false;
    L5:
        DelayedTaskQueue r0 = (DelayedTaskQueue) this._delayed;
        if (r0 != null) goto L8;
    L10:
        Object r3 = this._queue;
        if (r3 != null) goto L14;
    L19:
        return true;
    L14:
        if ((r3 instanceof LockFreeTaskQueueCore) == false) goto L17;
        return ((LockFreeTaskQueueCore) r3).isEmpty();
    L17:
        if (r3 == EventLoop_commonKt.access$getCLOSED_EMPTY$p()) goto L19;
        return false;
    L8:
        if (r0.isEmpty() == true) goto L10;
        return false;
    }

    @Override // kotlinx.coroutines.EventLoop
    protected long getNextTime() {
        if (super.getNextTime() != 0) goto L5;
        return 0;
    L5:
        Object r0 = this._queue;
        if (r0 != null) goto L8;
    L16:
        DelayedTaskQueue r6 = (DelayedTaskQueue) this._delayed;
        if (r6 == null) goto L27;
        DelayedTask r7 = r6.peek();
        if (r7 == null) goto L27;
        long r1 = r7.nanoTime;
        AbstractTimeSource r8 = AbstractTimeSourceKt.getTimeSource();
        if (r8 == null) goto L24;
        long r4 = r8.nanoTime();
    L26:
        return RangesKt.coerceAtLeast(r1 - r4, 0);
    L24:
        r4 = System.nanoTime();
    L27:
        return Long.MAX_VALUE;
    L8:
        if ((r0 instanceof LockFreeTaskQueueCore) == false) goto L13;
        if (((LockFreeTaskQueueCore) r0).isEmpty() == true) goto L16;
        return 0;
    L13:
        if (r0 != EventLoop_commonKt.access$getCLOSED_EMPTY$p()) goto L15;
        return Long.MAX_VALUE;
    L15:
        return 0;
    }

    @Override // kotlinx.coroutines.EventLoop
    public void shutdown() {
        ThreadLocalEventLoop.INSTANCE.resetEventLoop$kotlinx_coroutines_core();
        setCompleted(true);
        closeQueue();
    L4:
        if (processNextEvent() <= 0) goto L4;
        rescheduleAllDelayed();
    }

    @Override // kotlinx.coroutines.Delay
    /* JADX INFO: renamed from: scheduleResumeAfterDelay */
    public void mo2327scheduleResumeAfterDelay(long r4, CancellableContinuation<? super Unit> r6) {
        long r5 = EventLoop_commonKt.delayToNanos(r4);
        if (r5 >= DurationKt.MAX_MILLIS) goto L10;
        AbstractTimeSource r0 = AbstractTimeSourceKt.getTimeSource();
        if (r0 == null) goto L7;
        long r1 = r0.nanoTime();
    L8:
        DelayedResumeTask r2 = new DelayedResumeTask(this, r5 + r1, r6);
        schedule(r1, r2);
        CancellableContinuationKt.disposeOnCancellation(r6, r2);
        return;
    L7:
        r1 = System.nanoTime();
        goto L8
    }

    protected final DisposableHandle scheduleInvokeOnTimeout(long r4, Runnable r6) {
        long r5 = EventLoop_commonKt.delayToNanos(r4);
        if (r5 >= DurationKt.MAX_MILLIS) goto L10;
        AbstractTimeSource r0 = AbstractTimeSourceKt.getTimeSource();
        if (r0 == null) goto L7;
        long r1 = r0.nanoTime();
    L8:
        DelayedRunnableTask r2 = new DelayedRunnableTask(r5 + r1, r6);
        schedule(r1, r2);
        return r2;
    L7:
        r1 = System.nanoTime();
        goto L8
    L10:
        return NonDisposableHandle.INSTANCE;
    }

    @Override // kotlinx.coroutines.EventLoop
    public long processNextEvent() {
        if (processUnconfinedEvent() == false) goto L5;
        return 0;
    L5:
        DelayedTaskQueue r0 = (DelayedTaskQueue) this._delayed;
        if (r0 != null) goto L8;
    L34:
        Runnable r1 = dequeue();
        if (r1 == null) goto L39;
        r1.run();
        return 0;
    L39:
        return getNextTime();
    L8:
        if (r0.isEmpty() == true) goto L34;
        AbstractTimeSource r3 = AbstractTimeSourceKt.getTimeSource();
        if (r3 == null) goto L12;
        long r4 = r3.nanoTime();
    L13:
        DelayedTaskQueue r5 = r0;
        monitor-enter(r5);
        DelayedTask r6 = r5.firstImpl();     // Catch: Throwable -> L31
        DelayedTask r7 = null;
        if (r6 != null) goto L20;
        monitor-exit(r5);
    L29:
        if (r7 != null) goto L13;
    L20:
        DelayedTask r8 = r6;     // Catch: Throwable -> L31
        if (r8.timeToExecute(r4) == false) goto L23;
        boolean r9 = enqueueImpl(r8);     // Catch: Throwable -> L31
    L24:
        if (r9 == false) goto L26;
        r7 = r5.removeAtImpl(0);     // Catch: Throwable -> L31
    L27:
        monitor-exit(r5);
        goto L29
    L26:
        ThreadSafeHeapNode r10 = (ThreadSafeHeapNode) null;     // Catch: Throwable -> L31
        goto L27
    L23:
        r9 = false;
    L31:
        th = move-exception;
        throw th;
    L12:
        r4 = System.nanoTime();
        goto L13
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    /* JADX INFO: renamed from: dispatch */
    public final void mo2326dispatch(CoroutineContext r1, Runnable r2) {
        enqueue(r2);
    }

    public void enqueue(Runnable r2) {
        if (enqueueImpl(r2) == false) goto L5;
        unpark();
        return;
    L5:
        DefaultExecutor.INSTANCE.enqueue(r2);
    }

    private final void closeQueue() {
        if (DebugKt.getASSERTIONS_ENABLED() == false) goto L9;
        if (isCompleted() == true) goto L9;
        throw new AssertionError();
    L9:
        Object r0 = this._queue;
        if (r0 == null) goto L12;
        if ((r0 instanceof LockFreeTaskQueueCore) == true) goto L16;
        if (r0 == EventLoop_commonKt.access$getCLOSED_EMPTY$p()) goto L20;
        LockFreeTaskQueueCore r1 = new LockFreeTaskQueueCore(8, true);
        if (r0 == null) goto L27;
        r1.addLast((Runnable) r0);
        if (b0$$ExternalSyntheticBackport0.m(_queue$FU, this, r0, r1) == false) goto L9;
        return;
    L27:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }");
    L20:
        return;
    L16:
        ((LockFreeTaskQueueCore) r0).close();
        return;
    L12:
        if (b0$$ExternalSyntheticBackport0.m(_queue$FU, this, null, EventLoop_commonKt.access$getCLOSED_EMPTY$p()) == false) goto L9;
    }

    public final void schedule(long r3, DelayedTask r5) {
        int r0 = scheduleImpl(r3, r5);
        if (r0 == 0) goto L13;
        if (r0 != 1) goto L7;
        reschedule(r3, r5);
        return;
    L7:
        if (r0 != 2) goto L10;
        return;
    L10:
        throw new IllegalStateException("unexpected result".toString());
    L13:
        if (shouldUnpark(r5) == false) goto L17;
        unpark();
        return;
    }

    private final boolean shouldUnpark(DelayedTask r1) {
        DelayedTaskQueue r0 = (DelayedTaskQueue) this._delayed;
        if (r0 == null) goto L5;
        DelayedTask r2 = r0.peek();
    L6:
        if (r2 != r1) goto L8;
        return true;
    L8:
        return false;
    L5:
        r2 = null;
        goto L6
    }

    private final int scheduleImpl(long r4, DelayedTask r6) {
        if (isCompleted() == false) goto L6;
        return 1;
    L6:
        DelayedTaskQueue r0 = (DelayedTaskQueue) this._delayed;
        if (r0 != null) goto L10;
        b0$$ExternalSyntheticBackport0.m(_delayed$FU, this, null, new DelayedTaskQueue(r4));
        Object r1 = this._delayed;
        Intrinsics.checkNotNull(r1);
        r0 = (DelayedTaskQueue) r1;
    L10:
        return r6.scheduleTask(r4, r0, this);
    }

    protected final void resetAll() {
        this._queue = null;
        this._delayed = null;
    }

    private final void rescheduleAllDelayed() {
        AbstractTimeSource r0 = AbstractTimeSourceKt.getTimeSource();
        if (r0 == null) goto L5;
        long r1 = r0.nanoTime();
    L6:
        DelayedTaskQueue r2 = (DelayedTaskQueue) this._delayed;
        if (r2 == null) goto L12;
        DelayedTask r3 = r2.removeFirstOrNull();
        if (r3 == null) goto L16;
        reschedule(r1, r3);
        goto L6
    L16:
        return;
    L12:
        return;
    L5:
        r1 = System.nanoTime();
        goto L6
    }

    private final boolean enqueueImpl(Runnable r6) {
    L2:
        Object r0 = this._queue;
        if (isCompleted() == true) goto L4;
        if (r0 == null) goto L8;
        if ((r0 instanceof LockFreeTaskQueueCore) == true) goto L12;
        if (r0 == EventLoop_commonKt.access$getCLOSED_EMPTY$p()) goto L26;
        LockFreeTaskQueueCore r2 = new LockFreeTaskQueueCore(8, true);
        if (r0 == null) goto L33;
        r2.addLast((Runnable) r0);
        r2.addLast(r6);
        if (b0$$ExternalSyntheticBackport0.m(_queue$FU, this, r0, r2) == false) goto L2;
        return true;
    L33:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }");
    L26:
        return false;
    L12:
        if (r0 == null) goto L23;
        LockFreeTaskQueueCore r3 = (LockFreeTaskQueueCore) r0;
        int r4 = r3.addLast(r6);
        if (r4 == 0) goto L21;
        if (r4 != 1) goto L17;
        b0$$ExternalSyntheticBackport0.m(_queue$FU, this, r0, r3.next());
        goto L2
    L17:
        if (r4 != 2) goto L2;
        return false;
    L21:
        return true;
    L23:
        throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeTaskQueueCore<java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }>{ kotlinx.coroutines.EventLoop_commonKt.Queue<java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }> }");
    L8:
        if (b0$$ExternalSyntheticBackport0.m(_queue$FU, this, null, r6) == false) goto L2;
        return true;
    L4:
        return false;
    }

    private final Runnable dequeue() {
    L2:
        Object r0 = this._queue;
        if (r0 == null) goto L4;
        if ((r0 instanceof LockFreeTaskQueueCore) == true) goto L7;
        if (r0 == EventLoop_commonKt.access$getCLOSED_EMPTY$p()) goto L17;
        if (b0$$ExternalSyntheticBackport0.m(_queue$FU, this, r0, null) == false) goto L2;
        if (r0 == null) goto L24;
        return (Runnable) r0;
    L24:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }");
    L17:
        return null;
    L7:
        if (r0 == null) goto L14;
        LockFreeTaskQueueCore r1 = (LockFreeTaskQueueCore) r0;
        Object r2 = r1.removeFirstOrNull();
        if (r2 != LockFreeTaskQueueCore.REMOVE_FROZEN) goto L11;
        b0$$ExternalSyntheticBackport0.m(_queue$FU, this, r0, r1.next());
        goto L2
    L11:
        return (Runnable) r2;
    L14:
        throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeTaskQueueCore<java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }>{ kotlinx.coroutines.EventLoop_commonKt.Queue<java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }> }");
    L4:
        return null;
    }
}
