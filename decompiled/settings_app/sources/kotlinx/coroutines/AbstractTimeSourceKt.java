package kotlinx.coroutines;

import java.util.concurrent.locks.LockSupport;
import kotlin.Metadata;
import kotlin.Unit;

/* JADX INFO: compiled from: AbstractTimeSource.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00004\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\t\u0010\u0006\u001a\u00020\u0007H\u0081\b\u001a\t\u0010\b\u001a\u00020\u0007H\u0081\b\u001a\u0019\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0007H\u0081\b\u001a\t\u0010\u000e\u001a\u00020\nH\u0081\b\u001a\t\u0010\u000f\u001a\u00020\nH\u0081\b\u001a\t\u0010\u0010\u001a\u00020\nH\u0081\b\u001a\u0011\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0013H\u0081\b\u001a\t\u0010\u0014\u001a\u00020\nH\u0081\b\u001a\u0019\u0010\u0015\u001a\u00060\u0016j\u0002`\u00172\n\u0010\u0018\u001a\u00060\u0016j\u0002`\u0017H\u0081\b\"\u001c\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"\u0004\b\u0004\u0010\u0005¨\u0006\u0019"}, d2 = {"timeSource", "Lkotlinx/coroutines/AbstractTimeSource;", "getTimeSource", "()Lkotlinx/coroutines/AbstractTimeSource;", "setTimeSource", "(Lkotlinx/coroutines/AbstractTimeSource;)V", "currentTimeMillis", "", "nanoTime", "parkNanos", "", "blocker", "", "nanos", "registerTimeLoopThread", "trackTask", "unTrackTask", "unpark", "thread", "Ljava/lang/Thread;", "unregisterTimeLoopThread", "wrapTask", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "block", "kotlinx-coroutines-core"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class AbstractTimeSourceKt {
    private static AbstractTimeSource timeSource;

    static {
    }

    public static final AbstractTimeSource getTimeSource() {
        return timeSource;
    }

    public static final void setTimeSource(AbstractTimeSource r0) {
        timeSource = r0;
    }

    private static final long currentTimeMillis() {
        AbstractTimeSource r0 = getTimeSource();
        if (r0 == null) goto L6;
        return r0.currentTimeMillis();
    L6:
        return System.currentTimeMillis();
    }

    private static final long nanoTime() {
        AbstractTimeSource r0 = getTimeSource();
        if (r0 == null) goto L6;
        return r0.nanoTime();
    L6:
        return System.nanoTime();
    }

    private static final Runnable wrapTask(Runnable r1) {
        AbstractTimeSource r0 = getTimeSource();
        if (r0 == null) goto L9;
        Runnable r2 = r0.wrapTask(r1);
        if (r2 != null) goto L8;
        return r1;
    L8:
        return r2;
    L9:
        return r1;
    }

    private static final void trackTask() {
        AbstractTimeSource r0 = getTimeSource();
        if (r0 == null) goto L6;
        r0.trackTask();
        return;
    }

    private static final void unTrackTask() {
        AbstractTimeSource r0 = getTimeSource();
        if (r0 == null) goto L6;
        r0.unTrackTask();
        return;
    }

    private static final void registerTimeLoopThread() {
        AbstractTimeSource r0 = getTimeSource();
        if (r0 == null) goto L6;
        r0.registerTimeLoopThread();
        return;
    }

    private static final void unregisterTimeLoopThread() {
        AbstractTimeSource r0 = getTimeSource();
        if (r0 == null) goto L6;
        r0.unregisterTimeLoopThread();
        return;
    }

    private static final void parkNanos(Object r1, long r2) {
        AbstractTimeSource r0 = getTimeSource();
        if (r0 == null) goto L5;
        r0.parkNanos(r1, r2);
        Unit r3 = Unit.INSTANCE;
    L6:
        if (r3 != null) goto L9;
        LockSupport.parkNanos(r1, r2);
        return;
    L9:
        return;
    L5:
        r3 = null;
        goto L6
    }

    private static final void unpark(Thread r1) {
        AbstractTimeSource r0 = getTimeSource();
        if (r0 == null) goto L5;
        r0.unpark(r1);
        Unit r2 = Unit.INSTANCE;
    L6:
        if (r2 != null) goto L9;
        LockSupport.unpark(r1);
        return;
    L9:
        return;
    L5:
        r2 = null;
        goto L6
    }
}
