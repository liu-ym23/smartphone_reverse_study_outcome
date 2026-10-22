package h.a.i3;

import h.a.q0;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0000\b\u0000\u0018\u00002\u00020*B\u0007¢\u0006\u0004\b\u0001\u0010\u0002J!\u0010\u0007\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\t\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0011\u0010\u0012\u001a\u0004\u0018\u00010\u0003H\u0002¢\u0006\u0004\b\u0012\u0010\u0011J\u0017\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0015\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\u0000¢\u0006\u0004\b\u0018\u0010\u0019J\u0015\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\u0000¢\u0006\u0004\b\u001a\u0010\u0019J\u001f\u0010\u001c\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u0015\u0010\u001e\u001a\u00020\r*\u0004\u0018\u00010\u0003H\u0002¢\u0006\u0004\b\u001e\u0010\u001fR\u001c\u0010!\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010&\u001a\u00020#8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b$\u0010%R\u0014\u0010(\u001a\u00020#8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b'\u0010%¨\u0006)"}, d2 = {"Lkotlinx/coroutines/scheduling/WorkQueue;", "<init>", "()V", "Lkotlinx/coroutines/scheduling/Task;", "task", "", "fair", "add", "(Lkotlinx/coroutines/scheduling/Task;Z)Lkotlinx/coroutines/scheduling/Task;", "addLast", "(Lkotlinx/coroutines/scheduling/Task;)Lkotlinx/coroutines/scheduling/Task;", "Lkotlinx/coroutines/scheduling/GlobalQueue;", "globalQueue", "", "offloadAllWorkTo", "(Lkotlinx/coroutines/scheduling/GlobalQueue;)V", "poll", "()Lkotlinx/coroutines/scheduling/Task;", "pollBuffer", "queue", "pollTo", "(Lkotlinx/coroutines/scheduling/GlobalQueue;)Z", "victim", "", "tryStealBlockingFrom", "(Lkotlinx/coroutines/scheduling/WorkQueue;)J", "tryStealFrom", "blockingOnly", "tryStealLastScheduled", "(Lkotlinx/coroutines/scheduling/WorkQueue;Z)J", "decrementIfBlocking", "(Lkotlinx/coroutines/scheduling/Task;)V", "Ljava/util/concurrent/atomic/AtomicReferenceArray;", "buffer", "Ljava/util/concurrent/atomic/AtomicReferenceArray;", "", "getBufferSize$kotlinx_coroutines_core", "()I", "bufferSize", "getSize$kotlinx_coroutines_core", "size", "kotlinx-coroutines-core", ""}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class n {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f17509b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final /* synthetic */ AtomicIntegerFieldUpdater f17510c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final /* synthetic */ AtomicIntegerFieldUpdater f17511d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final /* synthetic */ AtomicIntegerFieldUpdater f17512e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AtomicReferenceArray<h> f17513a;
    private volatile /* synthetic */ int blockingTasksInBuffer;
    private volatile /* synthetic */ int consumerIndex;
    private volatile /* synthetic */ Object lastScheduledTask;
    private volatile /* synthetic */ int producerIndex;

    static {
        f17509b = AtomicReferenceFieldUpdater.newUpdater(n.class, Object.class, "lastScheduledTask");
        f17510c = AtomicIntegerFieldUpdater.newUpdater(n.class, "producerIndex");
        f17511d = AtomicIntegerFieldUpdater.newUpdater(n.class, "consumerIndex");
        f17512e = AtomicIntegerFieldUpdater.newUpdater(n.class, "blockingTasksInBuffer");
    }

    public n() {
        this.f17513a = new AtomicReferenceArray(128);
        this.lastScheduledTask = null;
        this.producerIndex = 0;
        this.consumerIndex = 0;
        this.blockingTasksInBuffer = 0;
    }

    public static /* synthetic */ h b(n r0, h r1, boolean r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = false;
    L6:
        return r0.a(r1, r2);
    }

    private final h c(h r3) {
        boolean r1 = true;
        if (r3.f17498g.b() == 1) goto L6;
        r1 = false;
    L6:
        if (r1 == false) goto L9;
        f17512e.incrementAndGet(this);
    L9:
        if (e() != 127) goto L11;
        return r3;
    L11:
        int r0 = this.producerIndex & 127;
    L13:
        if (this.f17513a.get(r0) == null) goto L15;
        Thread.yield();
        goto L13
    L15:
        this.f17513a.lazySet(r0, r3);
        f17510c.incrementAndGet(this);
        return null;
    }

    private final void d(h r3) {
        if (r3 == null) goto L16;
        boolean r0 = false;
        if (r3.f17498g.b() != 1) goto L6;
        boolean r4 = true;
    L7:
        if (r4 == false) goto L17;
        int r2 = f17512e.decrementAndGet(this);
        if (q0.a() == false) goto L18;
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

    private final h i() {
    L2:
        int r0 = this.consumerIndex;
        if ((r0 - this.producerIndex) == 0) goto L4;
        int r1 = r0 & 127;
        if (f17511d.compareAndSet(this, r0, r0 + 1) == false) goto L2;
        h r2 = this.f17513a.getAndSet(r1, null);
        if (r2 == null) goto L2;
        d(r2);
        return r2;
    L4:
        return null;
    }

    private final boolean j(d r1) {
        h r0 = i();
        if (r0 != null) goto L6;
        return false;
    L6:
        r1.a(r0);
        return true;
    }

    private final long m(n r8, boolean r9) {
    L2:
        h r0 = (h) r8.lastScheduledTask;
        if (r0 == null) goto L4;
        if (r9 == false) goto L13;
        boolean r5 = true;
        if (r0.f17498g.b() == 1) goto L11;
        r5 = false;
    L11:
        if (r5 == true) goto L13;
        return -2;
    L13:
        long r1 = l.f17505e.a() - r0.f17497f;
        long r4 = l.f17501a;
        if (r1 < r4) goto L16;
        if (f17509b.compareAndSet(r8, r0, null) == false) goto L2;
        b(this, r0, false, 2, null);
        return -1;
    L16:
        return r4 - r1;
    L4:
        return -2;
    }

    public final h a(h r1, boolean r2) {
        if (r2 == true) goto L4;
        h r3 = (h) f17509b.getAndSet(this, r1);
        if (r3 != null) goto L10;
        return null;
    L10:
        return c(r3);
    L4:
        return c(r1);
    }

    public final int e() {
        return this.producerIndex - this.consumerIndex;
    }

    public final int f() {
        Object r0 = this.lastScheduledTask;
        int r1 = e();
        if (r0 != null) goto L5;
        return r1;
    L5:
        return r1 + 1;
    }

    public final void g(d r3) {
        h r0 = (h) f17509b.getAndSet(this, null);
        if (r0 == null) goto L7;
        r3.a(r0);
    L7:
        if (j(r3) == true) goto L7;
    }

    public final h h() {
        h r0 = (h) f17509b.getAndSet(this, null);
        if (r0 == null) goto L5;
        return r0;
    L5:
        return i();
    }

    public final long k(n r9) {
        if (q0.a() == true) goto L5;
    L12:
        int r0 = r9.consumerIndex;
        int r3 = r9.producerIndex;
        AtomicReferenceArray<h> r4 = r9.f17513a;
    L13:
        if (r0 == r3) goto L30;
        int r5 = r0 & 127;
        if (r9.blockingTasksInBuffer == 0) goto L30;
        h r6 = r4.get(r5);
        if (r6 == null) goto L28;
        if (r6.f17498g.b() != 1) goto L22;
        boolean r7 = true;
    L23:
        if (r7 == false) goto L28;
        if (r4.compareAndSet(r5, r6, null) == false) goto L28;
        f17512e.decrementAndGet(r9);
        b(this, r6, false, 2, null);
        return -1;
    L22:
        r7 = false;
    L28:
        r0 = r0 + 1;
    L30:
        return m(r9, true);
    L5:
        if (e() != 0) goto L7;
        boolean r1 = true;
    L8:
        if (r1 == true) goto L12;
        throw new AssertionError();
    L7:
        r1 = false;
        goto L8
    }

    public final long l(n r5) {
        boolean r1 = true;
        if (q0.a() == true) goto L5;
    L12:
        h r0 = r5.i();
        if (r0 == null) goto L26;
        h r4 = b(this, r0, false, 2, null);
        if (q0.a() == false) goto L23;
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
        return m(r5, false);
    L5:
        if (e() != 0) goto L7;
        boolean r2 = true;
    L8:
        if (r2 == true) goto L12;
        throw new AssertionError();
    L7:
        r2 = false;
        goto L8
    }
}
