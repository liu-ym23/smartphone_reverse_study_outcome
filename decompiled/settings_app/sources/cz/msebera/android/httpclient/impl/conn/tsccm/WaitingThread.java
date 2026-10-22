package cz.msebera.android.httpclient.impl.conn.tsccm;

import cz.msebera.android.httpclient.util.Args;
import java.util.Date;
import java.util.concurrent.locks.Condition;

/* JADX INFO: loaded from: classes5.dex */
@Deprecated
public class WaitingThread {
    private boolean aborted;
    private final Condition cond;
    private final RouteSpecificPool pool;
    private Thread waiter;

    public WaitingThread(Condition r2, RouteSpecificPool r3) {
        Args.notNull(r2, "Condition");
        this.cond = r2;
        this.pool = r3;
    }

    public final Condition getCondition() {
        return this.cond;
    }

    public final RouteSpecificPool getPool() {
        return this.pool;
    }

    public final Thread getThread() {
        return this.waiter;
    }

    public boolean await(Date r4) throws InterruptedException {
        if (this.waiter != null) goto L22;
        if (this.aborted == true) goto L20;
        this.waiter = Thread.currentThread();
        if (r4 == null) goto L9;
        boolean r5 = this.cond.awaitUntil(r4);     // Catch: Throwable -> L16
    L11:
        if (this.aborted == true) goto L15;
        this.waiter = null;
        return r5;
    L15:
        throw new InterruptedException("Operation interrupted");     // Catch: Throwable -> L16
    L9:
        this.cond.await();     // Catch: Throwable -> L16
        r5 = true;
    L16:
        th = move-exception;
        this.waiter = null;
        throw th;
    L20:
        throw new InterruptedException("Operation interrupted");
    L22:
        throw new IllegalStateException("A thread is already waiting on this object.\ncaller: " + Thread.currentThread() + "\nwaiter: " + this.waiter);
    }

    public void wakeup() {
        if (this.waiter == null) goto L7;
        this.cond.signalAll();
        return;
    L7:
        throw new IllegalStateException("Nobody waiting on this object.");
    }

    public void interrupt() {
        this.aborted = true;
        this.cond.signalAll();
    }
}
