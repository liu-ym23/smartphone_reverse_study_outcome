package cz.msebera.android.httpclient.impl.conn.tsccm;

import cz.msebera.android.httpclient.conn.ConnectionPoolTimeoutException;
import cz.msebera.android.httpclient.conn.OperatedClientConnection;
import cz.msebera.android.httpclient.conn.routing.HttpRoute;
import cz.msebera.android.httpclient.extras.HttpClientAndroidLog;
import cz.msebera.android.httpclient.impl.conn.IdleConnectionHandler;
import cz.msebera.android.httpclient.util.Args;
import java.io.IOException;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: classes5.dex */
@Deprecated
public abstract class AbstractConnPool {
    protected IdleConnectionHandler idleConnHandler;
    protected volatile boolean isShutDown;
    protected Set<BasicPoolEntryRef> issuedConnections;
    protected Set<BasicPoolEntry> leasedConnections;
    private final HttpClientAndroidLog log;
    protected int numConnections;
    protected final Lock poolLock;
    protected ReferenceQueue<Object> refQueue;

    public abstract void deleteClosedConnections();

    public void enableConnectionGC() throws IllegalStateException {
    }

    public abstract void freeEntry(BasicPoolEntry r1, boolean r2, long r3, TimeUnit r5);

    protected abstract void handleLostEntry(HttpRoute r1);

    public void handleReference(Reference<?> r1) {
    }

    public abstract PoolEntryRequest requestPoolEntry(HttpRoute r1, Object r2);

    protected AbstractConnPool() {
        this.log = new HttpClientAndroidLog(getClass());
        this.leasedConnections = new HashSet();
        this.idleConnHandler = new IdleConnectionHandler();
        this.poolLock = new ReentrantLock();
    }

    public final BasicPoolEntry getEntry(HttpRoute r1, Object r2, long r3, TimeUnit r5) throws ConnectionPoolTimeoutException, InterruptedException {
        return requestPoolEntry(r1, r2).getPoolEntry(r3, r5);
    }

    public void closeIdleConnections(long r2, TimeUnit r4) {
        Args.notNull(r4, "Time unit");
        this.poolLock.lock();
        this.idleConnHandler.closeIdleConnections(r4.toMillis(r2));     // Catch: Throwable -> L6
        this.poolLock.unlock();
        return;
    L6:
        th = move-exception;
        this.poolLock.unlock();
        throw th;
    }

    public void closeExpiredConnections() {
        this.poolLock.lock();
        this.idleConnHandler.closeExpiredConnections();     // Catch: Throwable -> L6
        this.poolLock.unlock();
        return;
    L6:
        th = move-exception;
        this.poolLock.unlock();
        throw th;
    }

    public void shutdown() {
        this.poolLock.lock();
    L14:
        th = move-exception;
        this.poolLock.unlock();
        throw th;
    L4:
        if (this.isShutDown == false) goto L7;
        this.poolLock.unlock();
        return;
    L7:
        Iterator<BasicPoolEntry> r0 = this.leasedConnections.iterator();     // Catch: Throwable -> L14
    L9:
        if (r0.hasNext() == false) goto L11;
        BasicPoolEntry r1 = r0.next();     // Catch: Throwable -> L14
        r0.remove();     // Catch: Throwable -> L14
        closeConnection(r1.getConnection());     // Catch: Throwable -> L14
        goto L9
    L11:
        this.idleConnHandler.removeAll();     // Catch: Throwable -> L14
        this.isShutDown = true;     // Catch: Throwable -> L14
        this.poolLock.unlock();
    }

    protected void closeConnection(OperatedClientConnection r2) {
        if (r2 == null) goto L10;
        r2.close();     // Catch: IOException -> L5
        return;
    L5:
        e = move-exception;
        this.log.debug("I/O error closing connection", e);
        return;
    }
}
