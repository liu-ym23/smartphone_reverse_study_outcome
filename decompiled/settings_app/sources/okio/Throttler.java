package okio;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Throttler.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\b\u0016¢\u0006\u0002\u0010\u0002B\u000f\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u001d\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0004H\u0000¢\u0006\u0002\b\u0014J$\u0010\u0006\u001a\u00020\u00152\u0006\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\u0010\u001a\u00020\u00042\b\b\u0002\u0010\u000f\u001a\u00020\u0004H\u0007J\u000e\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\u0017J\u000e\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0018\u001a\u00020\u0019J\u0015\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0004H\u0000¢\u0006\u0002\b\u001bJ\f\u0010\u001c\u001a\u00020\u0004*\u00020\u0004H\u0002J\f\u0010\u001d\u001a\u00020\u0004*\u00020\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lokio/Throttler;", "", "()V", "allocatedUntil", "", "(J)V", "bytesPerSecond", "condition", "Ljava/util/concurrent/locks/Condition;", "getCondition", "()Ljava/util/concurrent/locks/Condition;", "lock", "Ljava/util/concurrent/locks/ReentrantLock;", "getLock", "()Ljava/util/concurrent/locks/ReentrantLock;", "maxByteCount", "waitByteCount", "byteCountOrWaitNanos", "now", "byteCount", "byteCountOrWaitNanos$okio", "", "sink", "Lokio/Sink;", "source", "Lokio/Source;", "take", "take$okio", "bytesToNanos", "nanosToBytes", "okio"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class Throttler {
    private long allocatedUntil;
    private long bytesPerSecond;
    private final Condition condition;
    private final ReentrantLock lock;
    private long maxByteCount;
    private long waitByteCount;

    public final void bytesPerSecond(long r10) {
        bytesPerSecond$default(this, r10, 0, 0, 6, null);
    }

    public final void bytesPerSecond(long r10, long r12) {
        bytesPerSecond$default(this, r10, r12, 0, 4, null);
    }

    public Throttler(long r1) {
        this.allocatedUntil = r1;
        this.waitByteCount = 8192;
        this.maxByteCount = 262144;
        ReentrantLock r2 = new ReentrantLock();
        this.lock = r2;
        Condition r3 = r2.newCondition();
        Intrinsics.checkNotNullExpressionValue(r3, "lock.newCondition()");
        this.condition = r3;
    }

    public final ReentrantLock getLock() {
        return this.lock;
    }

    public final Condition getCondition() {
        return this.condition;
    }

    public Throttler() {
        this(System.nanoTime());
    }

    public static /* synthetic */ void bytesPerSecond$default(Throttler r7, long r8, long r10, long r12, int r14, Object r15) {
        if ((r14 & 2) == 0) goto L5;
        r10 = r7.waitByteCount;
    L5:
        long r3 = r10;
        if ((r14 & 4) == 0) goto L8;
        r12 = r7.maxByteCount;
    L8:
        r7.bytesPerSecond(r8, r3, r12);
    }

    public final void bytesPerSecond(long r8, long r10, long r12) {
        ReentrantLock r0 = this.lock;
        r0.lock();
        boolean r4 = true;
        if (r8 < 0) goto L5;
        boolean r3 = true;
    L30:
        if (r3 == false) goto L26;
        if (r10 <= 0) goto L11;
        boolean r1 = true;
    L12:
        if (r1 == false) goto L24;
        if (r12 >= r10) goto L17;
        r4 = false;
    L17:
        if (r4 == false) goto L22;
        this.bytesPerSecond = r8;     // Catch: Throwable -> L27
        this.waitByteCount = r10;     // Catch: Throwable -> L27
        this.maxByteCount = r12;     // Catch: Throwable -> L27
        this.condition.signalAll();     // Catch: Throwable -> L27
        Unit r7 = Unit.INSTANCE;     // Catch: Throwable -> L27
        r0.unlock();
        return;
    L22:
        throw new IllegalArgumentException("Failed requirement.".toString());     // Catch: Throwable -> L27
    L24:
        throw new IllegalArgumentException("Failed requirement.".toString());     // Catch: Throwable -> L27
    L11:
        r1 = false;
        goto L12
    L26:
        throw new IllegalArgumentException("Failed requirement.".toString());     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        r0.unlock();
        throw th;
    L5:
        r3 = false;
        goto L30
    }

    public final long take$okio(long r7) {
        if (r7 <= 0) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == false) goto L19;
        ReentrantLock r3 = this.lock;
        r3.lock();
    L20:
        long r4 = byteCountOrWaitNanos$okio(System.nanoTime(), r7);     // Catch: Throwable -> L15
        if (r4 >= 0) goto L11;
        this.condition.awaitNanos(-r4);     // Catch: Throwable -> L15
        goto L20
    L11:
        r3.unlock();
        return r4;
    L15:
        th = move-exception;
        r3.unlock();
        throw th;
    L19:
        throw new IllegalArgumentException("Failed requirement.".toString());
    L5:
        r2 = false;
        goto L6
    }

    public final long byteCountOrWaitNanos$okio(long r10, long r12) {
        if (this.bytesPerSecond != 0) goto L5;
        return r12;
    L5:
        long r0 = Math.max(this.allocatedUntil - r10, 0);
        long r4 = this.maxByteCount - nanosToBytes(r0);
        if (r4 < r12) goto L9;
        this.allocatedUntil = (r10 + r0) + bytesToNanos(r12);
        return r12;
    L9:
        long r6 = this.waitByteCount;
        if (r4 < r6) goto L13;
        this.allocatedUntil = r10 + bytesToNanos(this.maxByteCount);
        return r4;
    L13:
        long r13 = Math.min(r6, r12);
        long r1 = r0 + bytesToNanos(r13 - this.maxByteCount);
        if (r1 != 0) goto L18;
        this.allocatedUntil = r10 + bytesToNanos(this.maxByteCount);
        return r13;
    L18:
        return -r1;
    }

    private final long nanosToBytes(long r3) {
        return (r3 * this.bytesPerSecond) / 1000000000;
    }

    private final long bytesToNanos(long r3) {
        return (r3 * 1000000000) / this.bytesPerSecond;
    }

    public final Source source(final Source r2) {
        Intrinsics.checkNotNullParameter(r2, "source");
        return new C04371(r2, this);
    }

    public final Sink sink(final Sink r2) {
        Intrinsics.checkNotNullParameter(r2, "sink");
        return new AnonymousClass1(r2, this);
    }
}
