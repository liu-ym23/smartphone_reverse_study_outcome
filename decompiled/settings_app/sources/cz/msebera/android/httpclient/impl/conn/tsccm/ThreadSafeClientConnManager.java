package cz.msebera.android.httpclient.impl.conn.tsccm;

import com.android.settings.utils.HanziToPinyin;
import cz.msebera.android.httpclient.conn.ClientConnectionManager;
import cz.msebera.android.httpclient.conn.ClientConnectionOperator;
import cz.msebera.android.httpclient.conn.ClientConnectionRequest;
import cz.msebera.android.httpclient.conn.ManagedClientConnection;
import cz.msebera.android.httpclient.conn.params.ConnPerRouteBean;
import cz.msebera.android.httpclient.conn.routing.HttpRoute;
import cz.msebera.android.httpclient.conn.scheme.SchemeRegistry;
import cz.msebera.android.httpclient.extras.HttpClientAndroidLog;
import cz.msebera.android.httpclient.impl.conn.DefaultClientConnectionOperator;
import cz.msebera.android.httpclient.impl.conn.SchemeRegistryFactory;
import cz.msebera.android.httpclient.params.HttpParams;
import cz.msebera.android.httpclient.util.Args;
import cz.msebera.android.httpclient.util.Asserts;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes5.dex */
@Deprecated
public class ThreadSafeClientConnManager implements ClientConnectionManager {
    protected final ClientConnectionOperator connOperator;
    protected final ConnPerRouteBean connPerRoute;
    protected final AbstractConnPool connectionPool;
    private final HttpClientAndroidLog log;
    protected final ConnPoolByRoute pool;
    protected final SchemeRegistry schemeRegistry;

    static /* synthetic */ HttpClientAndroidLog access$000(ThreadSafeClientConnManager r0) {
        return r0.log;
    }

    public ThreadSafeClientConnManager(SchemeRegistry r4) {
        this(r4, -1, TimeUnit.MILLISECONDS);
    }

    public ThreadSafeClientConnManager() {
        this(SchemeRegistryFactory.createDefault());
    }

    public ThreadSafeClientConnManager(SchemeRegistry r7, long r8, TimeUnit r10) {
        this(r7, r8, r10, new ConnPerRouteBean());
    }

    public ThreadSafeClientConnManager(SchemeRegistry r3, long r4, TimeUnit r6, ConnPerRouteBean r7) {
        Args.notNull(r3, "Scheme registry");
        this.log = new HttpClientAndroidLog(getClass());
        this.schemeRegistry = r3;
        this.connPerRoute = r7;
        this.connOperator = createConnectionOperator(r3);
        ConnPoolByRoute r5 = createConnectionPool(r4, r6);
        this.pool = r5;
        this.connectionPool = r5;
    }

    @Deprecated
    public ThreadSafeClientConnManager(HttpParams r3, SchemeRegistry r4) {
        Args.notNull(r4, "Scheme registry");
        this.log = new HttpClientAndroidLog(getClass());
        this.schemeRegistry = r4;
        this.connPerRoute = new ConnPerRouteBean();
        this.connOperator = createConnectionOperator(r4);
        ConnPoolByRoute r5 = (ConnPoolByRoute) createConnectionPool(r3);
        this.pool = r5;
        this.connectionPool = r5;
    }

    protected void finalize() throws Throwable {
        shutdown();     // Catch: Throwable -> L5
        super.finalize();
        return;
    L5:
        th = move-exception;
        super.finalize();
        throw th;
    }

    @Deprecated
    protected AbstractConnPool createConnectionPool(HttpParams r2) {
        return new ConnPoolByRoute(this.connOperator, r2);
    }

    protected ConnPoolByRoute createConnectionPool(long r9, TimeUnit r11) {
        return new ConnPoolByRoute(this.connOperator, this.connPerRoute, 20, r9, r11);
    }

    protected ClientConnectionOperator createConnectionOperator(SchemeRegistry r1) {
        return new DefaultClientConnectionOperator(r1);
    }

    @Override // cz.msebera.android.httpclient.conn.ClientConnectionManager
    public SchemeRegistry getSchemeRegistry() {
        return this.schemeRegistry;
    }

    @Override // cz.msebera.android.httpclient.conn.ClientConnectionManager
    public ClientConnectionRequest requestConnection(final HttpRoute r2, Object r3) {
        final PoolEntryRequest r4 = this.pool.requestPoolEntry(r2, r3);
        return new AnonymousClass1(this, r4, r2);
    }

    @Override // cz.msebera.android.httpclient.conn.ClientConnectionManager
    public void releaseConnection(ManagedClientConnection r8, long r9, TimeUnit r11) {
        Args.check(r8 instanceof BasicPooledConnAdapter, "Connection class mismatch, connection not obtained from this manager");
        BasicPooledConnAdapter r10 = (BasicPooledConnAdapter) r8;
        if (r10.getPoolEntry() != null) goto L5;
    L9:
        monitor-enter(r10);
        BasicPoolEntry r2 = (BasicPoolEntry) r10.getPoolEntry();     // Catch: Throwable -> L48
        if (r2 != null) goto L52;
        monitor-exit(r10);     // Catch: Throwable -> L48
        return;
    L52:
    L29:
        e = move-exception;
        if (this.log.isDebugEnabled() == false) goto L33;
        this.log.debug("Exception shutting down released connection.", e);     // Catch: Throwable -> L27
    L33:
        boolean r3 = r10.isMarkedReusable();     // Catch: Throwable -> L48
        if (this.log.isDebugEnabled() == false) goto L38;
        if (r3 == false) goto L37;
        this.log.debug("Released connection is reusable.");     // Catch: Throwable -> L48
        goto L38
    L37:
        this.log.debug("Released connection is not reusable.");     // Catch: Throwable -> L48
    L38:
        r10.detach();     // Catch: Throwable -> L48
        ConnPoolByRoute r1 = this.pool;     // Catch: Throwable -> L48
    L25:
        r1.freeEntry(r2, r3, r9, r11);     // Catch: Throwable -> L48
        monitor-exit(r10);     // Catch: Throwable -> L48
        return;
    L15:
        if (r10.isOpen() == true) goto L17;
    L19:
        r3 = r10.isMarkedReusable();     // Catch: Throwable -> L48
        if (this.log.isDebugEnabled() == false) goto L24;
        if (r3 == false) goto L23;
        this.log.debug("Released connection is reusable.");     // Catch: Throwable -> L48
        goto L24
    L23:
        this.log.debug("Released connection is not reusable.");     // Catch: Throwable -> L48
    L24:
        r10.detach();     // Catch: Throwable -> L48
        r1 = this.pool;     // Catch: Throwable -> L48
        goto L25
    L17:
        if (r10.isMarkedReusable() == true) goto L19;
        r10.shutdown();     // Catch: Throwable -> L27 IOException -> L29
    L27:
        th = move-exception;
        boolean r4 = r10.isMarkedReusable();     // Catch: Throwable -> L48
        if (this.log.isDebugEnabled() == false) goto L46;
        if (r4 == false) goto L45;
        this.log.debug("Released connection is reusable.");     // Catch: Throwable -> L48
        goto L46
    L45:
        this.log.debug("Released connection is not reusable.");     // Catch: Throwable -> L48
    L46:
        r10.detach();     // Catch: Throwable -> L48
        this.pool.freeEntry(r2, r4, r9, r11);     // Catch: Throwable -> L48
        throw th;     // Catch: Throwable -> L48
    L48:
        th = move-exception;
        throw th;
    L5:
        if (r10.getManager() != this) goto L7;
        boolean r0 = true;
    L8:
        Asserts.check(r0, "Connection not obtained from this manager");
        goto L9
    L7:
        r0 = false;
        goto L8
    }

    @Override // cz.msebera.android.httpclient.conn.ClientConnectionManager
    public void shutdown() {
        this.log.debug("Shutting down");
        this.pool.shutdown();
    }

    public int getConnectionsInPool(HttpRoute r1) {
        return this.pool.getConnectionsInPool(r1);
    }

    public int getConnectionsInPool() {
        return this.pool.getConnectionsInPool();
    }

    @Override // cz.msebera.android.httpclient.conn.ClientConnectionManager
    public void closeIdleConnections(long r4, TimeUnit r6) {
        if (this.log.isDebugEnabled() == false) goto L5;
        this.log.debug("Closing connections idle longer than " + r4 + HanziToPinyin.Token.SEPARATOR + r6);
    L5:
        this.pool.closeIdleConnections(r4, r6);
    }

    @Override // cz.msebera.android.httpclient.conn.ClientConnectionManager
    public void closeExpiredConnections() {
        this.log.debug("Closing expired connections");
        this.pool.closeExpiredConnections();
    }

    public int getMaxTotal() {
        return this.pool.getMaxTotalConnections();
    }

    public void setMaxTotal(int r1) {
        this.pool.setMaxTotalConnections(r1);
    }

    public int getDefaultMaxPerRoute() {
        return this.connPerRoute.getDefaultMaxPerRoute();
    }

    public void setDefaultMaxPerRoute(int r1) {
        this.connPerRoute.setDefaultMaxPerRoute(r1);
    }

    public int getMaxForRoute(HttpRoute r1) {
        return this.connPerRoute.getMaxForRoute(r1);
    }

    public void setMaxForRoute(HttpRoute r1, int r2) {
        this.connPerRoute.setMaxForRoute(r1, r2);
    }
}
