package kotlinx.coroutines.scheduling;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlinx.coroutines.DebugKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class WorkQueue {
    public static final AtomicReferenceFieldUpdater b = null;
    public static final AtomicIntegerFieldUpdater c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final AtomicIntegerFieldUpdater f435d = null;
    public static final AtomicIntegerFieldUpdater e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicReferenceArray f436a;
    private volatile int blockingTasksInBuffer;
    private volatile int consumerIndex;
    private volatile Object lastScheduledTask;
    private volatile int producerIndex;

    static {
        b = AtomicReferenceFieldUpdater.newUpdater(WorkQueue.class, Object.class, "lastScheduledTask");
        c = AtomicIntegerFieldUpdater.newUpdater(WorkQueue.class, "producerIndex");
        f435d = AtomicIntegerFieldUpdater.newUpdater(WorkQueue.class, "consumerIndex");
        e = AtomicIntegerFieldUpdater.newUpdater(WorkQueue.class, "blockingTasksInBuffer");
    }

    public WorkQueue() {
        this.f436a = new AtomicReferenceArray(128);
        this.lastScheduledTask = null;
        this.producerIndex = 0;
        this.consumerIndex = 0;
        this.blockingTasksInBuffer = 0;
    }

    public final Task a(Task r3) {
        if (r3.c.g() != 1) goto L6;
        e.incrementAndGet(this);
    L6:
        if ((this.producerIndex - this.consumerIndex) != 127) goto L8;
        return r3;
    L8:
        int r0 = this.producerIndex & 127;
    L10:
        if (this.f436a.get(r0) == null) goto L12;
        Thread.yield();
        goto L10
    L12:
        this.f436a.lazySet(r0, r3);
        c.incrementAndGet(this);
        return null;
    }

    public final int b() {
        if (this.lastScheduledTask == null) goto L6;
        return (this.producerIndex - this.consumerIndex) + 1;
    L6:
        return this.producerIndex - this.consumerIndex;
    }

    public final Task c() {
    L3:
        int r1 = this.consumerIndex;
        if ((r1 - this.producerIndex) == 0) goto L5;
        int r2 = r1 & 127;
        if (f435d.compareAndSet(this, r1, r1 + 1) == false) goto L3;
        Task r3 = (Task) this.f436a.getAndSet(r2, null);
        if (r3 == null) goto L3;
        if (r3.c.g() != 1) goto L13;
        e.decrementAndGet(this);
        boolean r6 = DebugKt.f370a;
    L13:
        return r3;
    L5:
        return null;
    }

    public final long d(WorkQueue r8) {
        boolean r1 = DebugKt.f370a;
        int r2 = r8.consumerIndex;
        int r3 = r8.producerIndex;
        AtomicReferenceArray r4 = r8.f436a;
    L3:
        if (r2 == r3) goto L20;
        int r5 = r2 & 127;
        if (r8.blockingTasksInBuffer == 0) goto L20;
        Task r6 = (Task) r4.get(r5);
        if (r6 == null) goto L18;
        if (r6.c.g() != 1) goto L18;
        if (r4.compareAndSet(r5, r6, null) == false) goto L18;
        e.decrementAndGet(r8);
        Task r9 = (Task) b.getAndSet(this, r6);
        if (r9 == null) goto L27;
        a(r9);
        return -1;
    L27:
        return -1;
    L18:
        r2 = r2 + 1;
    L20:
        return e(r8, true);
    }

    public final long e(WorkQueue r7, boolean r8) {
    L2:
        Task r0 = (Task) r7.lastScheduledTask;
        if (r0 == null) goto L20;
        if (r8 == true) goto L6;
    L9:
        TasksKt.e.getClass();
        long r1 = System.nanoTime() - r0.b;
        long r3 = TasksKt.f433a;
        if (r1 < r3) goto L12;
        AtomicReferenceFieldUpdater r2 = b;
        if (r2.compareAndSet(r7, r0, null) == false) goto L2;
        Task r9 = (Task) r2.getAndSet(this, r0);
        if (r9 == null) goto L26;
        a(r9);
        return -1;
    L26:
        return -1;
    L12:
        return r3 - r1;
    L6:
        if (r0.c.g() == 1) goto L9;
        return -2;
    L20:
        return -2;
    }
}
