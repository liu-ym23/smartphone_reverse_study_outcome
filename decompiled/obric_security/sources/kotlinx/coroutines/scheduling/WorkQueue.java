package kotlinx.coroutines.scheduling;

import com.bytedance.apm.constant.PerfConsts;
import com.bytedance.framwork.core.sdklib.DBHelper;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlinx.coroutines.DebugKt;
import tmsdkobf.b0$$ExternalSyntheticBackport0;

/* JADX INFO: compiled from: WorkQueue.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0000\b\u0000\u0018\u00002\u00020*B\u0007¢\u0006\u0004\b\u0001\u0010\u0002J!\u0010\u0007\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\t\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0011\u0010\u0012\u001a\u0004\u0018\u00010\u0003H\u0002¢\u0006\u0004\b\u0012\u0010\u0011J\u0017\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0015\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\u0000¢\u0006\u0004\b\u0018\u0010\u0019J\u0015\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\u0000¢\u0006\u0004\b\u001a\u0010\u0019J\u001f\u0010\u001c\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u0015\u0010\u001e\u001a\u00020\r*\u0004\u0018\u00010\u0003H\u0002¢\u0006\u0004\b\u001e\u0010\u001fR\u001c\u0010!\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010&\u001a\u00020#8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b$\u0010%R\u0014\u0010(\u001a\u00020#8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b'\u0010%¨\u0006)"}, d2 = {"Lkotlinx/coroutines/scheduling/WorkQueue;", "<init>", "()V", "Lkotlinx/coroutines/scheduling/Task;", "task", "", "fair", "add", "(Lkotlinx/coroutines/scheduling/Task;Z)Lkotlinx/coroutines/scheduling/Task;", "addLast", "(Lkotlinx/coroutines/scheduling/Task;)Lkotlinx/coroutines/scheduling/Task;", "Lkotlinx/coroutines/scheduling/GlobalQueue;", "globalQueue", "", "offloadAllWorkTo", "(Lkotlinx/coroutines/scheduling/GlobalQueue;)V", "poll", "()Lkotlinx/coroutines/scheduling/Task;", "pollBuffer", DBHelper.TABLE_QUEUE, "pollTo", "(Lkotlinx/coroutines/scheduling/GlobalQueue;)Z", "victim", "", "tryStealBlockingFrom", "(Lkotlinx/coroutines/scheduling/WorkQueue;)J", "tryStealFrom", "blockingOnly", "tryStealLastScheduled", "(Lkotlinx/coroutines/scheduling/WorkQueue;Z)J", "decrementIfBlocking", "(Lkotlinx/coroutines/scheduling/Task;)V", "Ljava/util/concurrent/atomic/AtomicReferenceArray;", "buffer", "Ljava/util/concurrent/atomic/AtomicReferenceArray;", "", "getBufferSize$kotlinx_coroutines_core", "()I", "bufferSize", "getSize$kotlinx_coroutines_core", PerfConsts.PERF_DISK_FILE_SIZE, "kotlinx-coroutines-core", ""}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WorkQueue {
    private static final /* synthetic */ AtomicIntegerFieldUpdater blockingTasksInBuffer$FU = null;
    private static final /* synthetic */ AtomicIntegerFieldUpdater consumerIndex$FU = null;
    private static final /* synthetic */ AtomicReferenceFieldUpdater lastScheduledTask$FU = null;
    private static final /* synthetic */ AtomicIntegerFieldUpdater producerIndex$FU = null;
    private volatile /* synthetic */ int blockingTasksInBuffer;
    private final AtomicReferenceArray<Task> buffer;
    private volatile /* synthetic */ int consumerIndex;
    private volatile /* synthetic */ Object lastScheduledTask;
    private volatile /* synthetic */ int producerIndex;

    static {
        lastScheduledTask$FU = AtomicReferenceFieldUpdater.newUpdater(WorkQueue.class, Object.class, "lastScheduledTask");
        producerIndex$FU = AtomicIntegerFieldUpdater.newUpdater(WorkQueue.class, "producerIndex");
        consumerIndex$FU = AtomicIntegerFieldUpdater.newUpdater(WorkQueue.class, "consumerIndex");
        blockingTasksInBuffer$FU = AtomicIntegerFieldUpdater.newUpdater(WorkQueue.class, "blockingTasksInBuffer");
    }

    public WorkQueue() {
        this.buffer = new AtomicReferenceArray(128);
        this.lastScheduledTask = null;
        this.producerIndex = 0;
        this.consumerIndex = 0;
        this.blockingTasksInBuffer = 0;
    }

    public final int getBufferSize$kotlinx_coroutines_core() {
        return this.producerIndex - this.consumerIndex;
    }

    public final int getSize$kotlinx_coroutines_core() {
        Object r0 = this.lastScheduledTask;
        int r1 = getBufferSize$kotlinx_coroutines_core();
        if (r0 != null) goto L5;
        return r1;
    L5:
        return r1 + 1;
    }

    public final Task poll() {
        Task r0 = (Task) lastScheduledTask$FU.getAndSet(this, null);
        if (r0 == null) goto L5;
        return r0;
    L5:
        return pollBuffer();
    }

    public static /* synthetic */ Task add$default(WorkQueue r0, Task r1, boolean r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = false;
    L6:
        return r0.add(r1, r2);
    }

    public final Task add(Task r1, boolean r2) {
        if (r2 == true) goto L4;
        Task r3 = (Task) lastScheduledTask$FU.getAndSet(this, r1);
        if (r3 != null) goto L10;
        return null;
    L10:
        return addLast(r3);
    L4:
        return addLast(r1);
    }

    public final long tryStealFrom(WorkQueue r5) {
        boolean r1 = true;
        if (DebugKt.getASSERTIONS_ENABLED() == true) goto L5;
    L12:
        Task r0 = r5.pollBuffer();
        if (r0 == null) goto L26;
        Task r4 = add$default(this, r0, false, 2, null);
        if (DebugKt.getASSERTIONS_ENABLED() == false) goto L23;
        if (r4 == null) goto L19;
        r1 = false;
    L19:
        if (r1 == false) goto L22;
        return -1;
    L22:
        throw new AssertionError();
    L23:
        return -1;
    L26:
        return tryStealLastScheduled(r5, false);
    L5:
        if (getBufferSize$kotlinx_coroutines_core() != 0) goto L7;
        boolean r2 = true;
    L8:
        if (r2 == true) goto L12;
        throw new AssertionError();
    L7:
        r2 = false;
        goto L8
    }

    public final long tryStealBlockingFrom(WorkQueue r9) {
        if (DebugKt.getASSERTIONS_ENABLED() == true) goto L5;
    L12:
        int r0 = r9.consumerIndex;
        int r3 = r9.producerIndex;
        AtomicReferenceArray<Task> r4 = r9.buffer;
    L13:
        if (r0 == r3) goto L29;
        int r5 = r0 & 127;
        if (r9.blockingTasksInBuffer == 0) goto L29;
        Task r6 = r4.get(r5);
        if (r6 == null) goto L27;
        if (r6.taskContext.getTaskMode() != 1) goto L21;
        boolean r7 = true;
    L22:
        if (r7 == false) goto L27;
        if (b0$$ExternalSyntheticBackport0.m(r4, r5, r6, null) == false) goto L27;
        blockingTasksInBuffer$FU.decrementAndGet(r9);
        add$default(this, r6, false, 2, null);
        return -1;
    L21:
        r7 = false;
    L27:
        r0 = r0 + 1;
    L29:
        return tryStealLastScheduled(r9, true);
    L5:
        if (getBufferSize$kotlinx_coroutines_core() != 0) goto L7;
        boolean r1 = true;
    L8:
        if (r1 == true) goto L12;
        throw new AssertionError();
    L7:
        r1 = false;
        goto L8
    }

    public final void offloadAllWorkTo(GlobalQueue r3) {
        Task r0 = (Task) lastScheduledTask$FU.getAndSet(this, null);
        if (r0 == null) goto L6;
        r3.addLast(r0);
    L6:
        if (pollTo(r3) == true) goto L6;
    }

    private final long tryStealLastScheduled(WorkQueue r7, boolean r8) {
    L2:
        Task r0 = (Task) r7.lastScheduledTask;
        if (r0 == null) goto L4;
        if (r8 == false) goto L13;
        boolean r5 = true;
        if (r0.taskContext.getTaskMode() == 1) goto L11;
        r5 = false;
    L11:
        if (r5 == true) goto L13;
        return -2;
    L13:
        long r1 = TasksKt.schedulerTimeSource.nanoTime() - r0.submissionTime;
        if (r1 < TasksKt.WORK_STEALING_TIME_RESOLUTION_NS) goto L16;
        if (b0$$ExternalSyntheticBackport0.m(lastScheduledTask$FU, r7, r0, null) == false) goto L2;
        add$default(this, r0, false, 2, null);
        return -1;
    L16:
        return TasksKt.WORK_STEALING_TIME_RESOLUTION_NS - r1;
    L4:
        return -2;
    }

    private final boolean pollTo(GlobalQueue r1) {
        Task r0 = pollBuffer();
        if (r0 != null) goto L6;
        return false;
    L6:
        r1.addLast(r0);
        return true;
    }

    private final Task pollBuffer() {
    L2:
        int r0 = this.consumerIndex;
        if ((r0 - this.producerIndex) == 0) goto L4;
        int r1 = r0 & 127;
        if (consumerIndex$FU.compareAndSet(this, r0, r0 + 1) == false) goto L2;
        Task r2 = this.buffer.getAndSet(r1, null);
        if (r2 == null) goto L2;
        decrementIfBlocking(r2);
        return r2;
    L4:
        return null;
    }

    private final Task addLast(Task r3) {
        boolean r1 = true;
        if (r3.taskContext.getTaskMode() == 1) goto L6;
        r1 = false;
    L6:
        if (r1 == false) goto L9;
        blockingTasksInBuffer$FU.incrementAndGet(this);
    L9:
        if (getBufferSize$kotlinx_coroutines_core() != 127) goto L11;
        return r3;
    L11:
        int r0 = this.producerIndex & 127;
    L13:
        if (this.buffer.get(r0) == null) goto L15;
        Thread.yield();
        goto L13
    L15:
        this.buffer.lazySet(r0, r3);
        producerIndex$FU.incrementAndGet(this);
        return null;
    }

    private final void decrementIfBlocking(Task r3) {
        if (r3 == null) goto L16;
        boolean r0 = false;
        if (r3.taskContext.getTaskMode() != 1) goto L6;
        boolean r4 = true;
    L7:
        if (r4 == false) goto L17;
        int r2 = blockingTasksInBuffer$FU.decrementAndGet(this);
        if (DebugKt.getASSERTIONS_ENABLED() == false) goto L18;
        if (r2 < 0) goto L12;
        r0 = true;
    L12:
        if (r0 == false) goto L15;
        return;
    L15:
        throw new AssertionError();
    L18:
        return;
    L17:
        return;
    L6:
        r4 = false;
        goto L7
    }
}
