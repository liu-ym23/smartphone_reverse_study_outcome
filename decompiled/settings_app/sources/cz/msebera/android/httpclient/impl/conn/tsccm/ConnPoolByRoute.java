package cz.msebera.android.httpclient.impl.conn.tsccm;

import com.android.settings.utils.HanziToPinyin;
import cz.msebera.android.httpclient.conn.ClientConnectionOperator;
import cz.msebera.android.httpclient.conn.ConnectionPoolTimeoutException;
import cz.msebera.android.httpclient.conn.OperatedClientConnection;
import cz.msebera.android.httpclient.conn.params.ConnManagerParams;
import cz.msebera.android.httpclient.conn.params.ConnPerRoute;
import cz.msebera.android.httpclient.conn.routing.HttpRoute;
import cz.msebera.android.httpclient.extras.HttpClientAndroidLog;
import cz.msebera.android.httpclient.params.HttpParams;
import cz.msebera.android.httpclient.util.Args;
import cz.msebera.android.httpclient.util.Asserts;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/* JADX INFO: loaded from: classes5.dex */
@Deprecated
public class ConnPoolByRoute extends AbstractConnPool {
    protected final ConnPerRoute connPerRoute;
    private final long connTTL;
    private final TimeUnit connTTLTimeUnit;
    protected final Queue<BasicPoolEntry> freeConnections;
    protected final Set<BasicPoolEntry> leasedConnections;
    public HttpClientAndroidLog log;
    protected volatile int maxTotalConnections;
    protected volatile int numConnections;
    protected final ClientConnectionOperator operator;
    private final Lock poolLock;
    protected final Map<HttpRoute, RouteSpecificPool> routeToPool;
    protected volatile boolean shutdown;
    protected final Queue<WaitingThread> waitingThreads;

    static /* synthetic */ Lock access$000(ConnPoolByRoute r0) {
        return r0.poolLock;
    }

    public ConnPoolByRoute(ClientConnectionOperator r8, ConnPerRoute r9, int r10) {
        this(r8, r9, r10, -1, TimeUnit.MILLISECONDS);
    }

    public ConnPoolByRoute(ClientConnectionOperator r3, ConnPerRoute r4, int r5, long r6, TimeUnit r8) {
        this.log = new HttpClientAndroidLog(getClass());
        Args.notNull(r3, "Connection operator");
        Args.notNull(r4, "Connections per route");
        this.poolLock = this.poolLock;
        this.leasedConnections = this.leasedConnections;
        this.operator = r3;
        this.connPerRoute = r4;
        this.maxTotalConnections = r5;
        this.freeConnections = createFreeConnQueue();
        this.waitingThreads = createWaitingThreadQueue();
        this.routeToPool = createRouteToPoolMap();
        this.connTTL = r6;
        this.connTTLTimeUnit = r8;
    }

    protected Lock getLock() {
        return this.poolLock;
    }

    @Deprecated
    public ConnPoolByRoute(ClientConnectionOperator r2, HttpParams r3) {
        this(r2, ConnManagerParams.getMaxConnectionsPerRoute(r3), ConnManagerParams.getMaxTotalConnections(r3));
    }

    protected Queue<BasicPoolEntry> createFreeConnQueue() {
        return new LinkedList();
    }

    protected Queue<WaitingThread> createWaitingThreadQueue() {
        return new LinkedList();
    }

    protected Map<HttpRoute, RouteSpecificPool> createRouteToPoolMap() {
        return new HashMap();
    }

    protected RouteSpecificPool newRouteSpecificPool(HttpRoute r2) {
        return new RouteSpecificPool(r2, this.connPerRoute);
    }

    protected WaitingThread newWaitingThread(Condition r1, RouteSpecificPool r2) {
        return new WaitingThread(r1, r2);
    }

    private void closeConnection(BasicPoolEntry r2) {
        OperatedClientConnection r3 = r2.getConnection();
        if (r3 == null) goto L11;
        r3.close();     // Catch: IOException -> L6
        return;
    L6:
        e = move-exception;
        this.log.debug("I/O error closing connection", e);
        return;
    }

    protected RouteSpecificPool getRoutePool(HttpRoute r2, boolean r3) {
        this.poolLock.lock();
        RouteSpecificPool r0 = this.routeToPool.get(r2);     // Catch: Throwable -> L9
        if (r0 != null) goto L7;
        if (r3 == false) goto L7;
        r0 = newRouteSpecificPool(r2);     // Catch: Throwable -> L9
        this.routeToPool.put(r2, r0);     // Catch: Throwable -> L9
    L7:
        this.poolLock.unlock();
        return r0;
    L9:
        th = move-exception;
        this.poolLock.unlock();
        throw th;
    }

    public int getConnectionsInPool(HttpRoute r2) {
        this.poolLock.lock();
        int r0 = 0;
        RouteSpecificPool r3 = getRoutePool(r2, false);     // Catch: Throwable -> L8
        if (r3 == null) goto L6;
        r0 = r3.getEntryCount();     // Catch: Throwable -> L8
    L6:
        this.poolLock.unlock();
        return r0;
    L8:
        th = move-exception;
        this.poolLock.unlock();
        throw th;
    }

    public int getConnectionsInPool() {
        this.poolLock.lock();
        int r0 = this.numConnections;     // Catch: Throwable -> L6
        this.poolLock.unlock();
        return r0;
    L6:
        th = move-exception;
        this.poolLock.unlock();
        throw th;
    }

    @Override // cz.msebera.android.httpclient.impl.conn.tsccm.AbstractConnPool
    public PoolEntryRequest requestPoolEntry(final HttpRoute r3, final Object r4) {
        final WaitingThreadAborter r0 = new WaitingThreadAborter();
        return new AnonymousClass1(this, r0, r3, r4);
    }

    protected BasicPoolEntry getEntryBlocking(HttpRoute r10, Object r11, long r12, TimeUnit r14, WaitingThreadAborter r15) throws ConnectionPoolTimeoutException, InterruptedException {
        BasicPoolEntry r1 = null;
        if (r12 <= 0) goto L5;
        Date r0 = new Date(System.currentTimeMillis() + r14.toMillis(r12));
    L6:
        this.poolLock.lock();
        RouteSpecificPool r13 = getRoutePool(r10, true);     // Catch: Throwable -> L54
        WaitingThread r16 = null;
    L8:
        if (r1 != null) goto L52;
        boolean r2 = false;
        if (this.shutdown == true) goto L12;
        boolean r3 = true;
    L13:
        Asserts.check(r3, "Connection pool shut down");     // Catch: Throwable -> L54
        if (this.log.isDebugEnabled() == false) goto L17;
        this.log.debug("[" + r10 + "] total kept alive: " + this.freeConnections.size() + ", total issued: " + this.leasedConnections.size() + ", total allocated: " + this.numConnections + " out of " + this.maxTotalConnections);     // Catch: Throwable -> L54
    L17:
        r1 = getFreeEntry(r13, r11);     // Catch: Throwable -> L54
        if (r1 != null) goto L52;
        if (r13.getCapacity() <= 0) goto L25;
        r2 = true;
    L25:
        if (this.log.isDebugEnabled() == false) goto L27;
        this.log.debug("Available capacity: " + r13.getCapacity() + " out of " + r13.getMaxEntries() + " [" + r10 + "][" + r11 + "]");     // Catch: Throwable -> L54
    L27:
        if (r2 == false) goto L31;
        if (this.numConnections >= this.maxTotalConnections) goto L31;
        r1 = createEntry(r13, this.operator);     // Catch: Throwable -> L54
    L31:
        if (r2 == false) goto L36;
        if (this.freeConnections.isEmpty() == true) goto L36;
        deleteLeastUsedEntry();     // Catch: Throwable -> L54
        r13 = getRoutePool(r10, true);     // Catch: Throwable -> L54
        r1 = createEntry(r13, this.operator);     // Catch: Throwable -> L54
    L36:
        if (this.log.isDebugEnabled() == false) goto L38;
        this.log.debug("Need to wait for connection [" + r10 + "][" + r11 + "]");     // Catch: Throwable -> L54
    L38:
        if (r16 != null) goto L57;
        r16 = newWaitingThread(this.poolLock.newCondition(), r13);     // Catch: Throwable -> L54
        r15.setWaitingThread(r16);     // Catch: Throwable -> L54
    L57:
        r13.queueThread(r16);     // Catch: Throwable -> L49
        this.waitingThreads.add(r16);     // Catch: Throwable -> L49
        boolean r4 = r16.await(r0);     // Catch: Throwable -> L49
        r13.removeThread(r16);     // Catch: Throwable -> L54
        this.waitingThreads.remove(r16);     // Catch: Throwable -> L54
        if (r4 == true) goto L8;
        if (r0 == null) goto L8;
        if (r0.getTime() > System.currentTimeMillis()) goto L8;
        throw new ConnectionPoolTimeoutException("Timeout waiting for connection from pool");     // Catch: Throwable -> L54
    L49:
        th = move-exception;
        r13.removeThread(r16);     // Catch: Throwable -> L54
        this.waitingThreads.remove(r16);     // Catch: Throwable -> L54
        throw th;     // Catch: Throwable -> L54
    L12:
        r3 = false;
    L52:
        this.poolLock.unlock();
        return r1;
    L54:
        th = move-exception;
        this.poolLock.unlock();
        throw th;
    L5:
        r0 = null;
        goto L6
    }

    @Override // cz.msebera.android.httpclient.impl.conn.tsccm.AbstractConnPool
    public void freeEntry(BasicPoolEntry r9, boolean r10, long r11, TimeUnit r13) {
        HttpRoute r2 = r9.getPlannedRoute();
        if (this.log.isDebugEnabled() == false) goto L5;
        this.log.debug("Releasing connection [" + r2 + "][" + r9.getState() + "]");
    L5:
        this.poolLock.lock();
    L27:
        th = move-exception;
        this.poolLock.unlock();
        throw th;
    L7:
        if (this.shutdown == false) goto L11;
        closeConnection(r9);     // Catch: Throwable -> L27
        this.poolLock.unlock();
        return;
    L11:
        this.leasedConnections.remove(r9);     // Catch: Throwable -> L27
        RouteSpecificPool r5 = getRoutePool(r2, true);     // Catch: Throwable -> L27
        if (r10 == true) goto L14;
    L23:
        closeConnection(r9);     // Catch: Throwable -> L27
        r5.dropEntry();     // Catch: Throwable -> L27
        this.numConnections--;     // Catch: Throwable -> L27
    L24:
        notifyWaitingThread(r5);     // Catch: Throwable -> L27
        this.poolLock.unlock();
        return;
    L14:
        if (r5.getCapacity() < 0) goto L23;
        if (this.log.isDebugEnabled() == true) goto L18;
    L22:
        r5.freeEntry(r9);     // Catch: Throwable -> L27
        r9.updateExpiry(r11, r13);     // Catch: Throwable -> L27
        this.freeConnections.add(r9);     // Catch: Throwable -> L27
        goto L24
    L18:
        if (r11 <= 0) goto L20;
        String r12 = "for " + r11 + HanziToPinyin.Token.SEPARATOR + r13;     // Catch: Throwable -> L27
    L21:
        this.log.debug("Pooling connection [" + r2 + "][" + r9.getState() + "]; keep alive " + r12);     // Catch: Throwable -> L27
        goto L22
    L20:
        r12 = "indefinitely";
        goto L21
    }

    protected BasicPoolEntry getFreeEntry(RouteSpecificPool r9, Object r10) {
        this.poolLock.lock();
        BasicPoolEntry r0 = null;
        boolean r1 = false;
    L3:
        if (r1 == true) goto L24;
        r0 = r9.allocEntry(r10);     // Catch: Throwable -> L21
        if (r0 == null) goto L18;
        if (this.log.isDebugEnabled() == false) goto L10;
        this.log.debug("Getting free connection [" + r9.getRoute() + "][" + r10 + "]");     // Catch: Throwable -> L21
    L10:
        this.freeConnections.remove(r0);     // Catch: Throwable -> L21
        if (r0.isExpired(System.currentTimeMillis()) == true) goto L13;
        this.leasedConnections.add(r0);     // Catch: Throwable -> L21
    L20:
        r1 = true;
        goto L3
    L13:
        if (this.log.isDebugEnabled() == false) goto L15;
        this.log.debug("Closing expired free connection [" + r9.getRoute() + "][" + r10 + "]");     // Catch: Throwable -> L21
    L15:
        closeConnection(r0);     // Catch: Throwable -> L21
        r9.dropEntry();     // Catch: Throwable -> L21
        this.numConnections--;     // Catch: Throwable -> L21
        goto L3
    L18:
        if (this.log.isDebugEnabled() == false) goto L20;
        this.log.debug("No free connections [" + r9.getRoute() + "][" + r10 + "]");     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        this.poolLock.unlock();
        throw th;
    L24:
        this.poolLock.unlock();
        return r0;
    }

    protected BasicPoolEntry createEntry(RouteSpecificPool r9, ClientConnectionOperator r10) {
        if (this.log.isDebugEnabled() == false) goto L5;
        this.log.debug("Creating new connection [" + r9.getRoute() + "]");
    L5:
        BasicPoolEntry r0 = new BasicPoolEntry(r10, r9.getRoute(), this.connTTL, this.connTTLTimeUnit);
        this.poolLock.lock();
        r9.createdEntry(r0);     // Catch: Throwable -> L9
        this.numConnections++;     // Catch: Throwable -> L9
        this.leasedConnections.add(r0);     // Catch: Throwable -> L9
        this.poolLock.unlock();
        return r0;
    L9:
        th = move-exception;
        this.poolLock.unlock();
        throw th;
    }

    protected void deleteEntry(BasicPoolEntry r5) {
        HttpRoute r0 = r5.getPlannedRoute();
        if (this.log.isDebugEnabled() == false) goto L5;
        this.log.debug("Deleting connection [" + r0 + "][" + r5.getState() + "]");
    L5:
        this.poolLock.lock();
        closeConnection(r5);     // Catch: Throwable -> L11
        RouteSpecificPool r2 = getRoutePool(r0, true);     // Catch: Throwable -> L11
        r2.deleteEntry(r5);     // Catch: Throwable -> L11
        this.numConnections--;     // Catch: Throwable -> L11
        if (r2.isUnused() == false) goto L9;
        this.routeToPool.remove(r0);     // Catch: Throwable -> L11
    L9:
        this.poolLock.unlock();
        return;
    L11:
        th = move-exception;
        this.poolLock.unlock();
        throw th;
    }

    protected void deleteLeastUsedEntry() {
        this.poolLock.lock();
        BasicPoolEntry r0 = this.freeConnections.remove();     // Catch: Throwable -> L11
        if (r0 == null) goto L7;
        deleteEntry(r0);     // Catch: Throwable -> L11
    L9:
        this.poolLock.unlock();
        return;
    L7:
        if (this.log.isDebugEnabled() == false) goto L9;
        this.log.debug("No free connection to delete");     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        this.poolLock.unlock();
        throw th;
    }

    @Override // cz.msebera.android.httpclient.impl.conn.tsccm.AbstractConnPool
    protected void handleLostEntry(HttpRoute r4) {
        this.poolLock.lock();
        RouteSpecificPool r1 = getRoutePool(r4, true);     // Catch: Throwable -> L9
        r1.dropEntry();     // Catch: Throwable -> L9
        if (r1.isUnused() == false) goto L6;
        this.routeToPool.remove(r4);     // Catch: Throwable -> L9
    L6:
        this.numConnections--;     // Catch: Throwable -> L9
        notifyWaitingThread(r1);     // Catch: Throwable -> L9
        this.poolLock.unlock();
        return;
    L9:
        th = move-exception;
        this.poolLock.unlock();
        throw th;
    }

    protected void notifyWaitingThread(RouteSpecificPool r4) {
        this.poolLock.lock();
        if (r4 == null) goto L11;
    L24:
        th = move-exception;
        this.poolLock.unlock();
        throw th;
    L5:
        if (r4.hasThread() == false) goto L11;
        if (this.log.isDebugEnabled() == false) goto L9;
        this.log.debug("Notifying thread waiting on pool [" + r4.getRoute() + "]");     // Catch: Throwable -> L24
    L9:
        WaitingThread r5 = r4.nextThread();     // Catch: Throwable -> L24
    L20:
        if (r5 == null) goto L22;
        r5.wakeup();     // Catch: Throwable -> L24
    L22:
        this.poolLock.unlock();
        return;
    L11:
        if (this.waitingThreads.isEmpty() == true) goto L17;
        if (this.log.isDebugEnabled() == false) goto L15;
        this.log.debug("Notifying thread waiting on any pool");     // Catch: Throwable -> L24
    L15:
        r5 = this.waitingThreads.remove();     // Catch: Throwable -> L24
        goto L20
    L17:
        if (this.log.isDebugEnabled() == false) goto L19;
        this.log.debug("Notifying no-one, there are no waiting threads");     // Catch: Throwable -> L24
    L19:
        r5 = null;
        goto L20
    }

    @Override // cz.msebera.android.httpclient.impl.conn.tsccm.AbstractConnPool
    public void deleteClosedConnections() {
        this.poolLock.lock();
        Iterator<BasicPoolEntry> r0 = this.freeConnections.iterator();     // Catch: Throwable -> L12
    L5:
        if (r0.hasNext() == false) goto L10;
        BasicPoolEntry r1 = r0.next();     // Catch: Throwable -> L12
        if (r1.getConnection().isOpen() == true) goto L5;
        r0.remove();     // Catch: Throwable -> L12
        deleteEntry(r1);     // Catch: Throwable -> L12
        goto L5
    L10:
        this.poolLock.unlock();
        return;
    L12:
        th = move-exception;
        this.poolLock.unlock();
        throw th;
    }

    @Override // cz.msebera.android.httpclient.impl.conn.tsccm.AbstractConnPool
    public void closeIdleConnections(long r7, TimeUnit r9) {
        Args.notNull(r9, "Time unit");
        if (r7 > 0) goto L7;
        r7 = 0;
    L7:
        if (this.log.isDebugEnabled() == false) goto L9;
        this.log.debug("Closing connections idle longer than " + r7 + HanziToPinyin.Token.SEPARATOR + r9);
    L9:
        long r0 = System.currentTimeMillis() - r9.toMillis(r7);
        this.poolLock.lock();
        Iterator<BasicPoolEntry> r8 = this.freeConnections.iterator();     // Catch: Throwable -> L22
    L11:
        if (r8.hasNext() == false) goto L20;
        BasicPoolEntry r10 = r8.next();     // Catch: Throwable -> L22
        if (r10.getUpdated() > r0) goto L11;
        if (this.log.isDebugEnabled() == false) goto L18;
        this.log.debug("Closing connection last used @ " + new Date(r10.getUpdated()));     // Catch: Throwable -> L22
    L18:
        r8.remove();     // Catch: Throwable -> L22
        deleteEntry(r10);     // Catch: Throwable -> L22
        goto L11
    L20:
        this.poolLock.unlock();
        return;
    L22:
        th = move-exception;
        this.poolLock.unlock();
        throw th;
    }

    @Override // cz.msebera.android.httpclient.impl.conn.tsccm.AbstractConnPool
    public void closeExpiredConnections() {
        this.log.debug("Closing expired connections");
        long r0 = System.currentTimeMillis();
        this.poolLock.lock();
        Iterator<BasicPoolEntry> r2 = this.freeConnections.iterator();     // Catch: Throwable -> L15
    L4:
        if (r2.hasNext() == false) goto L13;
        BasicPoolEntry r3 = r2.next();     // Catch: Throwable -> L15
        if (r3.isExpired(r0) == false) goto L4;
        if (this.log.isDebugEnabled() == false) goto L11;
        this.log.debug("Closing connection expired @ " + new Date(r3.getExpiry()));     // Catch: Throwable -> L15
    L11:
        r2.remove();     // Catch: Throwable -> L15
        deleteEntry(r3);     // Catch: Throwable -> L15
        goto L4
    L13:
        this.poolLock.unlock();
        return;
    L15:
        th = move-exception;
        this.poolLock.unlock();
        throw th;
    }

    @Override // cz.msebera.android.httpclient.impl.conn.tsccm.AbstractConnPool
    public void shutdown() {
        this.poolLock.lock();
    L26:
        th = move-exception;
        this.poolLock.unlock();
        throw th;
    L4:
        if (this.shutdown == false) goto L8;
        this.poolLock.unlock();
        return;
    L8:
        this.shutdown = true;     // Catch: Throwable -> L26
        Iterator<BasicPoolEntry> r0 = this.leasedConnections.iterator();     // Catch: Throwable -> L26
    L10:
        if (r0.hasNext() == false) goto L12;
        BasicPoolEntry r1 = r0.next();     // Catch: Throwable -> L26
        r0.remove();     // Catch: Throwable -> L26
        closeConnection(r1);     // Catch: Throwable -> L26
        goto L10
    L12:
        Iterator<BasicPoolEntry> r2 = this.freeConnections.iterator();     // Catch: Throwable -> L26
    L14:
        if (r2.hasNext() == false) goto L19;
        BasicPoolEntry r3 = r2.next();     // Catch: Throwable -> L26
        r2.remove();     // Catch: Throwable -> L26
        if (this.log.isDebugEnabled() == false) goto L18;
        this.log.debug("Closing connection [" + r3.getPlannedRoute() + "][" + r3.getState() + "]");     // Catch: Throwable -> L26
    L18:
        closeConnection(r3);     // Catch: Throwable -> L26
        goto L14
    L19:
        Iterator<WaitingThread> r4 = this.waitingThreads.iterator();     // Catch: Throwable -> L26
    L21:
        if (r4.hasNext() == false) goto L23;
        WaitingThread r5 = r4.next();     // Catch: Throwable -> L26
        r4.remove();     // Catch: Throwable -> L26
        r5.wakeup();     // Catch: Throwable -> L26
        goto L21
    L23:
        this.routeToPool.clear();     // Catch: Throwable -> L26
        this.poolLock.unlock();
    }

    public void setMaxTotalConnections(int r2) {
        this.poolLock.lock();
        this.maxTotalConnections = r2;     // Catch: Throwable -> L6
        this.poolLock.unlock();
        return;
    L6:
        th = move-exception;
        this.poolLock.unlock();
        throw th;
    }

    public int getMaxTotalConnections() {
        return this.maxTotalConnections;
    }
}
