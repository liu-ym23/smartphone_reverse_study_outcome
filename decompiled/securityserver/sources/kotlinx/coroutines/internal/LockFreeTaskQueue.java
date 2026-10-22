package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlinx.coroutines.scheduling.Task;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public class LockFreeTaskQueue<E> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f418a = null;
    private volatile Object _cur;

    static {
        f418a = AtomicReferenceFieldUpdater.newUpdater(LockFreeTaskQueue.class, Object.class, "_cur");
    }

    public LockFreeTaskQueue() {
        this._cur = new LockFreeTaskQueueCore(8, false);
    }

    public final boolean a(Task r4) {
    L2:
        LockFreeTaskQueueCore r0 = (LockFreeTaskQueueCore) this._cur;
        int r1 = r0.a(r4);
        if (r1 == 0) goto L11;
        if (r1 != 1) goto L6;
        f418a.compareAndSet(this, r0, r0.e());
        goto L2
    L6:
        if (r1 != 2) goto L2;
        return false;
    L11:
        return true;
    }

    public final void b() {
    L2:
        LockFreeTaskQueueCore r0 = (LockFreeTaskQueueCore) this._cur;
        if (r0.b() == true) goto L4;
        f418a.compareAndSet(this, r0, r0.e());
        goto L2
    }

    public final int c() {
        return ((LockFreeTaskQueueCore) this._cur).c();
    }

    public final Object d() {
    L2:
        LockFreeTaskQueueCore r0 = (LockFreeTaskQueueCore) this._cur;
        Object r1 = r0.f();
        if (r1 != LockFreeTaskQueueCore.g) goto L4;
        f418a.compareAndSet(this, r0, r0.e());
        goto L2
    L4:
        return r1;
    }
}
