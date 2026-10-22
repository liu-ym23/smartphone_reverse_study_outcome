package cz.msebera.android.httpclient.pool;

import cz.msebera.android.httpclient.concurrent.FutureCallback;
import cz.msebera.android.httpclient.pool.PoolEntry;
import cz.msebera.android.httpclient.util.Args;
import cz.msebera.android.httpclient.util.Asserts;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: classes5.dex */
public abstract class AbstractConnPool<T, C, E extends PoolEntry<T, C>> implements ConnPool<T, E>, ConnPoolControl<T> {
    private final LinkedList<E> available;
    private final Condition condition;
    private final ConnFactory<T, C> connFactory;
    private volatile int defaultMaxPerRoute;
    private volatile boolean isShutDown;
    private final Set<E> leased;
    private final Lock lock;
    private final Map<T, Integer> maxPerRoute;
    private volatile int maxTotal;
    private final LinkedList<Future<E>> pending;
    private final Map<T, RouteSpecificPool<T, C, E>> routeToPool;
    private volatile int validateAfterInactivity;

    protected abstract E createEntry(T r1, C r2);

    protected void onLease(E r1) {
    }

    protected void onRelease(E r1) {
    }

    protected void onReuse(E r1) {
    }

    protected boolean validate(E r1) {
        return true;
    }

    @Override // cz.msebera.android.httpclient.pool.ConnPool
    public /* bridge */ /* synthetic */ void release(Object r1, boolean r2) {
        release((PoolEntry) r1, r2);
    }

    static /* synthetic */ Lock access$000(AbstractConnPool r0) {
        return r0.lock;
    }

    static /* synthetic */ Condition access$100(AbstractConnPool r0) {
        return r0.condition;
    }

    static /* synthetic */ PoolEntry access$200(AbstractConnPool r0, Object r1, Object r2, long r3, TimeUnit r5, Future r6) throws IOException, InterruptedException, TimeoutException {
        return r0.getPoolEntryBlocking(r1, r2, r3, r5, r6);
    }

    static /* synthetic */ int access$300(AbstractConnPool r0) {
        return r0.validateAfterInactivity;
    }

    public AbstractConnPool(ConnFactory<T, C> r2, int r3, int r4) {
        this.connFactory = (ConnFactory) Args.notNull(r2, "Connection factory");
        this.defaultMaxPerRoute = Args.positive(r3, "Max per route value");
        this.maxTotal = Args.positive(r4, "Max total value");
        ReentrantLock r5 = new ReentrantLock();
        this.lock = r5;
        this.condition = r5.newCondition();
        this.routeToPool = new HashMap();
        this.leased = new HashSet();
        this.available = new LinkedList();
        this.pending = new LinkedList();
        this.maxPerRoute = new HashMap();
    }

    public boolean isShutdown() {
        return this.isShutDown;
    }

    public void shutdown() throws IOException {
        if (this.isShutDown == false) goto L5;
        return;
    L5:
        this.isShutDown = true;
        this.lock.lock();
        Iterator<E> r0 = this.available.iterator();     // Catch: Throwable -> L21
    L8:
        if (r0.hasNext() == false) goto L10;
        r0.next().close();     // Catch: Throwable -> L21
        goto L8
    L10:
        Iterator<E> r1 = this.leased.iterator();     // Catch: Throwable -> L21
    L12:
        if (r1.hasNext() == false) goto L14;
        r1.next().close();     // Catch: Throwable -> L21
        goto L12
    L14:
        Iterator<RouteSpecificPool<T, C, E>> r2 = this.routeToPool.values().iterator();     // Catch: Throwable -> L21
    L16:
        if (r2.hasNext() == false) goto L18;
        r2.next().shutdown();     // Catch: Throwable -> L21
        goto L16
    L18:
        this.routeToPool.clear();     // Catch: Throwable -> L21
        this.leased.clear();     // Catch: Throwable -> L21
        this.available.clear();     // Catch: Throwable -> L21
        this.lock.unlock();
        return;
    L21:
        th = move-exception;
        this.lock.unlock();
        throw th;
    }

    private RouteSpecificPool<T, C, E> getPool(final T r2) {
        RouteSpecificPool<T, C, E> r0 = this.routeToPool.get(r2);
        if (r0 != null) goto L6;
        RouteSpecificPool<T, C, E> r1 = (RouteSpecificPool<T, C, E>) new AnonymousClass1(this, r2, r2);
        this.routeToPool.put(r2, r1);
        return r1;
    L6:
        return r0;
    }

    @Override // cz.msebera.android.httpclient.pool.ConnPool
    public Future<E> lease(final T r3, final Object r4, final FutureCallback<E> r5) {
        Args.notNull(r3, "Route");
        Asserts.check(!this.isShutDown, "Connection pool shut down");
        return (Future<E>) new AnonymousClass2(this, r5, r3, r4);
    }

    public Future<E> lease(T r2, Object r3) {
        return lease(r2, r3, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private E getPoolEntryBlocking(T r7, Object r8, long r9, TimeUnit r11, Future<E> r12) throws IOException, InterruptedException, TimeoutException {
        if (r9 <= 0) goto L5;
        Date r0 = new Date(System.currentTimeMillis() + r11.toMillis(r9));
    L6:
        this.lock.lock();
        RouteSpecificPool r10 = getPool(r7);     // Catch: Throwable -> L70
    L8:
        boolean r13 = true;
        if (this.isShutDown == true) goto L11;
        boolean r14 = true;
    L12:
        Asserts.check(r14, "Connection pool shut down");     // Catch: Throwable -> L70
    L13:
        E r15 = (E) r10.getFree(r8);
        if (r15 == null) goto L22;
        if (r15.isExpired(System.currentTimeMillis()) == false) goto L20;
        r15.close();     // Catch: Throwable -> L70
    L20:
        if (r15.isClosed() == false) goto L22;
        this.available.remove(r15);     // Catch: Throwable -> L70
        r10.free(r15, false);     // Catch: Throwable -> L70
    L22:
        if (r15 != null) goto L23;
        int r16 = getMax(r7);     // Catch: Throwable -> L70
        int r2 = Math.max(0, (r10.getAllocatedCount() + 1) - r16);     // Catch: Throwable -> L70
        if (r2 <= 0) goto L35;
        int r3 = 0;
    L29:
        if (r3 >= r2) goto L35;
        PoolEntry r4 = r10.getLastUsed();     // Catch: Throwable -> L70
        if (r4 == null) goto L35;
        r4.close();     // Catch: Throwable -> L70
        this.available.remove(r4);     // Catch: Throwable -> L70
        r10.remove(r4);     // Catch: Throwable -> L70
        r3 = r3 + 1;     // Catch: Throwable -> L70
    L35:
        if (r10.getAllocatedCount() >= r16) goto L73;
        int r17 = Math.max(this.maxTotal - this.leased.size(), 0);     // Catch: Throwable -> L70
        if (r17 <= 0) goto L73;
        if (this.available.size() > (r17 - 1)) goto L41;
    L43:
        E r18 = (E) r10.add(this.connFactory.create(r7));
        this.leased.add(r18);     // Catch: Throwable -> L70
        this.lock.unlock();
        return r18;
    L41:
        if (this.available.isEmpty() == true) goto L43;
        E r19 = this.available.removeLast();     // Catch: Throwable -> L70
        r19.close();     // Catch: Throwable -> L70
        getPool(r19.getRoute()).remove(r19);     // Catch: Throwable -> L70
    L73:
    L67:
        th = move-exception;
        r10.unqueue(r12);     // Catch: Throwable -> L70
        this.pending.remove(r12);     // Catch: Throwable -> L70
        throw th;     // Catch: Throwable -> L70
    L48:
        if (r12.isCancelled() == true) goto L66;
        r10.queue(r12);     // Catch: Throwable -> L67
        this.pending.add(r12);     // Catch: Throwable -> L67
        if (r0 == null) goto L52;
        r13 = this.condition.awaitUntil(r0);     // Catch: Throwable -> L67
    L54:
        if (r12.isCancelled() == true) goto L64;
        r10.unqueue(r12);     // Catch: Throwable -> L70
        this.pending.remove(r12);     // Catch: Throwable -> L70
        if (r13 == true) goto L8;
        if (r0 == null) goto L8;
        if (r0.getTime() > System.currentTimeMillis()) goto L8;
        throw new TimeoutException("Timeout waiting for connection");     // Catch: Throwable -> L70
    L64:
        throw new InterruptedException("Operation interrupted");     // Catch: Throwable -> L67
    L52:
        this.condition.await();     // Catch: Throwable -> L67
        goto L54
    L66:
        throw new InterruptedException("Operation interrupted");     // Catch: Throwable -> L67
    L23:
        this.available.remove(r15);     // Catch: Throwable -> L70
        this.leased.add(r15);     // Catch: Throwable -> L70
        onReuse(r15);     // Catch: Throwable -> L70
        this.lock.unlock();
        return r15;
    L11:
        r14 = false;
    L70:
        th = move-exception;
        this.lock.unlock();
        throw th;
    L5:
        r0 = null;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void release(E r2, boolean r3) {
        this.lock.lock();
    L19:
        th = move-exception;
        this.lock.unlock();
        throw th;
    L4:
        if (this.leased.remove(r2) == false) goto L17;
        RouteSpecificPool r0 = getPool(r2.getRoute());     // Catch: Throwable -> L19
        r0.free(r2, r3);     // Catch: Throwable -> L19
        if (r3 == true) goto L8;
    L10:
        r2.close();     // Catch: Throwable -> L19
    L11:
        onRelease(r2);     // Catch: Throwable -> L19
        Future<E> r4 = r0.nextPending();     // Catch: Throwable -> L19
        if (r4 == null) goto L14;
        this.pending.remove(r4);     // Catch: Throwable -> L19
    L15:
        if (r4 == null) goto L17;
        this.condition.signalAll();     // Catch: Throwable -> L19
        goto L17
    L14:
        r4 = this.pending.poll();     // Catch: Throwable -> L19
        goto L15
    L8:
        if (this.isShutDown == true) goto L10;
        this.available.addFirst(r2);     // Catch: Throwable -> L19
    L17:
        this.lock.unlock();
    }

    private int getMax(T r2) {
        Integer r3 = this.maxPerRoute.get(r2);
        if (r3 == null) goto L6;
        return r3.intValue();
    L6:
        return this.defaultMaxPerRoute;
    }

    @Override // cz.msebera.android.httpclient.pool.ConnPoolControl
    public void setMaxTotal(int r2) {
        Args.positive(r2, "Max value");
        this.lock.lock();
        this.maxTotal = r2;     // Catch: Throwable -> L6
        this.lock.unlock();
        return;
    L6:
        th = move-exception;
        this.lock.unlock();
        throw th;
    }

    @Override // cz.msebera.android.httpclient.pool.ConnPoolControl
    public int getMaxTotal() {
        this.lock.lock();
        int r0 = this.maxTotal;     // Catch: Throwable -> L6
        this.lock.unlock();
        return r0;
    L6:
        th = move-exception;
        this.lock.unlock();
        throw th;
    }

    @Override // cz.msebera.android.httpclient.pool.ConnPoolControl
    public void setDefaultMaxPerRoute(int r2) {
        Args.positive(r2, "Max per route value");
        this.lock.lock();
        this.defaultMaxPerRoute = r2;     // Catch: Throwable -> L6
        this.lock.unlock();
        return;
    L6:
        th = move-exception;
        this.lock.unlock();
        throw th;
    }

    @Override // cz.msebera.android.httpclient.pool.ConnPoolControl
    public int getDefaultMaxPerRoute() {
        this.lock.lock();
        int r0 = this.defaultMaxPerRoute;     // Catch: Throwable -> L6
        this.lock.unlock();
        return r0;
    L6:
        th = move-exception;
        this.lock.unlock();
        throw th;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [cz.msebera.android.httpclient.pool.AbstractConnPool, cz.msebera.android.httpclient.pool.AbstractConnPool<T, C, E extends cz.msebera.android.httpclient.pool.PoolEntry<T, C>>] */
    /* JADX WARN: Type inference failed for: r1v1, types: [cz.msebera.android.httpclient.pool.AbstractConnPool] */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.util.concurrent.locks.Lock] */
    @Override // cz.msebera.android.httpclient.pool.ConnPoolControl
    public void setMaxPerRoute(T r2, int r3) {
        Args.notNull(r2, "Route");
        this.lock.lock();
        if (r3 <= (-1)) goto L5;
        this.maxPerRoute.put(r2, Integer.valueOf(r3));     // Catch: Throwable -> L8
    L6:
        AbstractConnPool<T, C, E> this = (AbstractConnPool<T, C, E>) this.lock;
        this.unlock();
        return;
    L5:
        this.maxPerRoute.remove(r2);     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        this.lock.unlock();
        throw th;
    }

    @Override // cz.msebera.android.httpclient.pool.ConnPoolControl
    public int getMaxPerRoute(T r2) {
        Args.notNull(r2, "Route");
        this.lock.lock();
        int r3 = getMax(r2);     // Catch: Throwable -> L6
        this.lock.unlock();
        return r3;
    L6:
        th = move-exception;
        this.lock.unlock();
        throw th;
    }

    @Override // cz.msebera.android.httpclient.pool.ConnPoolControl
    public PoolStats getTotalStats() {
        this.lock.lock();
        PoolStats r0 = new PoolStats(this.leased.size(), this.pending.size(), this.available.size(), this.maxTotal);     // Catch: Throwable -> L6
        this.lock.unlock();
        return r0;
    L6:
        th = move-exception;
        this.lock.unlock();
        throw th;
    }

    @Override // cz.msebera.android.httpclient.pool.ConnPoolControl
    public PoolStats getStats(T r5) {
        Args.notNull(r5, "Route");
        this.lock.lock();
        RouteSpecificPool<T, C, E> r0 = getPool(r5);     // Catch: Throwable -> L6
        PoolStats r1 = new PoolStats(r0.getLeasedCount(), r0.getPendingCount(), r0.getAvailableCount(), getMax(r5));     // Catch: Throwable -> L6
        this.lock.unlock();
        return r1;
    L6:
        th = move-exception;
        this.lock.unlock();
        throw th;
    }

    public Set<T> getRoutes() {
        this.lock.lock();
        HashSet r0 = new HashSet(this.routeToPool.keySet());     // Catch: Throwable -> L6
        this.lock.unlock();
        return r0;
    L6:
        th = move-exception;
        this.lock.unlock();
        throw th;
    }

    protected void enumAvailable(PoolEntryCallback<T, C> r4) {
        this.lock.lock();
        Iterator<E> r0 = this.available.iterator();     // Catch: Throwable -> L12
    L5:
        if (r0.hasNext() == false) goto L9;
        E r1 = r0.next();     // Catch: Throwable -> L12
        r4.process(r1);     // Catch: Throwable -> L12
        if (r1.isClosed() == false) goto L5;
        getPool(r1.getRoute()).remove(r1);     // Catch: Throwable -> L12
        r0.remove();     // Catch: Throwable -> L12
        goto L5
    L9:
        purgePoolMap();     // Catch: Throwable -> L12
        this.lock.unlock();
        return;
    L12:
        th = move-exception;
        this.lock.unlock();
        throw th;
    }

    protected void enumLeased(PoolEntryCallback<T, C> r3) {
        this.lock.lock();
        Iterator<E> r0 = this.leased.iterator();     // Catch: Throwable -> L10
    L5:
        if (r0.hasNext() == false) goto L8;
        r3.process(r0.next());     // Catch: Throwable -> L10
        goto L5
    L8:
        this.lock.unlock();
        return;
    L10:
        th = move-exception;
        this.lock.unlock();
        throw th;
    }

    private void purgePoolMap() {
        Iterator<Map.Entry<T, RouteSpecificPool<T, C, E>>> r2 = this.routeToPool.entrySet().iterator();
    L4:
        if (r2.hasNext() == false) goto L8;
        RouteSpecificPool<T, C, E> r0 = r2.next().getValue();
        if ((r0.getPendingCount() + r0.getAllocatedCount()) != 0) goto L4;
        r2.remove();
        goto L4
    }

    public void closeIdle(long r3, TimeUnit r5) {
        Args.notNull(r5, "Time unit");
        long r4 = r5.toMillis(r3);
        if (r4 >= 0) goto L5;
        r4 = 0;
    L5:
        final long r0 = System.currentTimeMillis() - r4;
        enumAvailable(new AnonymousClass3(this, r0));
    }

    public void closeExpired() {
        final long r0 = System.currentTimeMillis();
        enumAvailable(new AnonymousClass4(this, r0));
    }

    public int getValidateAfterInactivity() {
        return this.validateAfterInactivity;
    }

    public void setValidateAfterInactivity(int r1) {
        this.validateAfterInactivity = r1;
    }

    public String toString() {
        this.lock.lock();
        String r0 = "[leased: " + this.leased + "][available: " + this.available + "][pending: " + this.pending + "]";     // Catch: Throwable -> L6
        this.lock.unlock();
        return r0;
    L6:
        th = move-exception;
        this.lock.unlock();
        throw th;
    }
}
