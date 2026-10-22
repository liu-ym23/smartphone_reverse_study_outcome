package okhttp3.internal.connection;

import java.io.IOException;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.net.Socket;
import java.util.List;
import okhttp3.Address;
import okhttp3.Call;
import okhttp3.ConnectionPool;
import okhttp3.EventListener;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Route;
import okhttp3.internal.Internal;
import okhttp3.internal.Util;
import okhttp3.internal.http.HttpCodec;
import okhttp3.internal.http2.ConnectionShutdownException;
import okhttp3.internal.http2.ErrorCode;
import okhttp3.internal.http2.StreamResetException;
import okhttp3.ttnet.TTConfigManager;
import okhttp3.ttnet.TTOkHttpConstants;

/* JADX INFO: loaded from: classes5.dex */
public final class StreamAllocation {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public final Address address;
    public final Call call;
    private final Object callStackTrace;
    private boolean canceled;
    private int canceledReason;
    private HttpCodec codec;
    private RealConnection connection;
    private final ConnectionPool connectionPool;
    public final EventListener eventListener;
    private int refusedStreamCount;
    private boolean released;
    private boolean reportedAcquired;
    private Route route;
    private RouteSelector.Selection routeSelection;
    private final RouteSelector routeSelector;

    public static final class StreamAllocationReference extends WeakReference<StreamAllocation> {
        public final Object callStackTrace;

        StreamAllocationReference(StreamAllocation r1, Object r2) {
            super(r1);
            this.callStackTrace = r2;
        }
    }

    static {
    }

    public StreamAllocation(ConnectionPool r2, Address r3, Call r4, EventListener r5, Object r6) {
        this.canceledReason = TTOkHttpConstants.ERR_TTNET_UNKNOWN;
        this.connectionPool = r2;
        this.address = r3;
        this.call = r4;
        this.eventListener = r5;
        this.routeSelector = new RouteSelector(r3, routeDatabase(), r4, r5);
        this.callStackTrace = r6;
    }

    public HttpCodec newStream(OkHttpClient r8, Interceptor.Chain r9, boolean r10) {
        int r1 = r9.connectTimeoutMillis();
        int r2 = r9.readTimeoutMillis();
        int r3 = r9.writeTimeoutMillis();
        int r0 = r8.pingIntervalMillis();
        Call r4 = this.call;
        if (r4 == null) goto L23;
        if (r4.request() == null) goto L23;
        if (this.call.request().url() == null) goto L23;
        if (this.call.request().url().host() == null) goto L23;
        r0 = r8.pingIntervalMillisWithHostPort(this.call.request().url().host(), this.call.request().url().port());
    L23:
        HttpCodec r11 = findHealthyConnection(r1, r2, r3, r0, r8.retryOnConnectionFailure(), r10).newCodec(r8, r9, this);     // Catch: IOException -> L20
        ConnectionPool r12 = this.connectionPool;     // Catch: IOException -> L20
        monitor-enter(r12);     // Catch: IOException -> L20
        this.codec = r11;     // Catch: Throwable -> L17
        monitor-exit(r12);     // Catch: Throwable -> L17
        return r11;
    L17:
        th = move-exception;
        throw th;     // Catch: IOException -> L20
    L20:
        e = move-exception;
        throw new RouteException(e);
    }

    private RealConnection findHealthyConnection(int r4, int r5, int r6, int r7, boolean r8, boolean r9) throws IOException {
    L2:
        RealConnection r0 = findConnection(r4, r5, r6, r7, r8);
        ConnectionPool r1 = this.connectionPool;
        monitor-enter(r1);
    L15:
        th = move-exception;
        throw th;
    L5:
        if (r0.successCount == 0) goto L7;
    L10:
        monitor-exit(r1);     // Catch: Throwable -> L15
        if (r0.isHealthy(r9) == true) goto L14;
        noNewStreams();
        goto L2
    L14:
        return r0;
    L7:
        if (r0.isMultiplexed() == true) goto L10;
        monitor-exit(r1);     // Catch: Throwable -> L15
        return r0;
    }

    private RealConnection findConnection(int r20, int r21, int r22, int r23, boolean r24) throws IOException {
        ConnectionPool r3 = this.connectionPool;
        monitor-enter(r3);
    L102:
        th = move-exception;
        throw th;
    L5:
        if (this.released == true) goto L101;
        if (this.codec != null) goto L99;
        if (this.canceled == true) goto L97;
        RealConnection r2 = this.connection;     // Catch: Throwable -> L102
        Socket r4 = releaseIfNoNewStreams();     // Catch: Throwable -> L102
        RealConnection r5 = this.connection;     // Catch: Throwable -> L102
        Socket r6 = null;
        if (r5 == null) goto L13;
        r2 = null;
    L15:
        if (this.reportedAcquired == true) goto L18;
        r2 = null;
    L18:
        if (r5 != null) goto L23;
        Internal.instance.get(this.connectionPool, this.address, this, null);     // Catch: Throwable -> L102
        RealConnection r9 = this.connection;     // Catch: Throwable -> L102
        if (r9 == null) goto L22;
        boolean r10 = true;
        r5 = r9;
        Route r11 = null;
    L25:
        monitor-exit(r3);     // Catch: Throwable -> L102
        Util.closeQuietly(r4);
        if (r2 == null) goto L29;
        this.eventListener.connectionReleased(this.call, r2);
    L29:
        if (r10 == false) goto L31;
        this.eventListener.connectionAcquired(this.call, r5);
    L31:
        if (r5 == null) goto L34;
        this.route = this.connection.route();
        return r5;
    L34:
        if (r11 != null) goto L45;
        RouteSelector.Selection r7 = this.routeSelection;
        if (r7 != null) goto L38;
    L39:
        this.routeSelection = this.routeSelector.next();
        if (TTConfigManager.inst().getReconnctTimeout() > 0) goto L42;
    L43:
        this.routeSelection.setIsQuickTestPhase(false);
    L44:
        boolean r8 = true;
    L46:
        ConnectionPool r12 = this.connectionPool;
        monitor-enter(r12);
    L93:
        th = move-exception;
        throw th;
    L49:
        if (this.canceled == true) goto L92;
        if (r8 == false) goto L57;
        List<Route> r1 = this.routeSelection.getAll();     // Catch: Throwable -> L93
        int r13 = r1.size();     // Catch: Throwable -> L93
        int r14 = 0;
    L52:
        if (r14 >= r13) goto L57;
        Route r15 = r1.get(r14);     // Catch: Throwable -> L93
        Internal.instance.get(this.connectionPool, this.address, this, r15);     // Catch: Throwable -> L93
        RealConnection r16 = this.connection;     // Catch: Throwable -> L93
        if (r16 != null) goto L55;
        r14 = r14 + 1;     // Catch: Throwable -> L93
        goto L52
    L55:
        this.route = r15;     // Catch: Throwable -> L93
        r10 = true;
        r5 = r16;
    L57:
        if (r10 == true) goto L61;
        if (r11 != null) goto L60;
        r11 = this.routeSelection.next();     // Catch: Throwable -> L93
    L60:
        this.route = r11;     // Catch: Throwable -> L93
        this.refusedStreamCount = 0;     // Catch: Throwable -> L93
        r5 = new RealConnection(this.connectionPool, r11);     // Catch: Throwable -> L93
        acquire(r5, false);     // Catch: Throwable -> L93
    L61:
        monitor-exit(r12);     // Catch: Throwable -> L93
        if (r10 == false) goto L65;
        this.eventListener.connectionAcquired(this.call, r5);
        return r5;
    L65:
        RouteSelector.Selection r17 = this.routeSelection;
        if (r17 != null) goto L68;
    L70:
        int r18 = r20;
    L72:
        if (this.routeSelection == null) goto L74;
    L80:
        r5.connect(r18, r21, r22, r23, r24, this.call, this.eventListener);
        routeDatabase().connected(r5.route());
        ConnectionPool r19 = this.connectionPool;
        monitor-enter(r19);
        this.reportedAcquired = true;     // Catch: Throwable -> L88
        Internal.instance.put(this.connectionPool, r5);     // Catch: Throwable -> L88
        if (r5.isMultiplexed() == false) goto L85;
        r6 = Internal.instance.deduplicate(this.connectionPool, this.address, this);     // Catch: Throwable -> L88
        r5 = this.connection;     // Catch: Throwable -> L88
    L85:
        monitor-exit(r19);     // Catch: Throwable -> L88
        Util.closeQuietly(r6);
        this.eventListener.connectionAcquired(this.call, r5);
        return r5;
    L88:
        th = move-exception;
        throw th;
    L74:
        if (this.route == null) goto L80;
        if (TTConfigManager.inst().isIpReconnQuickTestEnable() == false) goto L80;
        if (TTConfigManager.inst().getReconnctTimeout() <= 0) goto L80;
        r18 = TTConfigManager.inst().getReconnctTimeout();
        goto L80
    L68:
        if (r17.isQuickTestPhase() == false) goto L70;
        r18 = TTConfigManager.inst().getReconnctTimeout();
        goto L72
    L92:
        throw new IOException("Canceled#Reason=" + this.canceledReason);     // Catch: Throwable -> L93
    L42:
        if (TTConfigManager.inst().isIpReconnQuickTestEnable() == true) goto L44;
    L38:
        if (r7.hasNext() == false) goto L39;
    L45:
        r8 = false;
        goto L46
    L22:
        r11 = this.route;     // Catch: Throwable -> L102
    L24:
        r10 = false;
        goto L25
    L23:
        r11 = null;
        goto L24
    L13:
        r5 = null;
        goto L15
    L97:
        throw new IOException("Canceled#Reason=" + this.canceledReason);     // Catch: Throwable -> L102
    L99:
        throw new IllegalStateException("codec != null");     // Catch: Throwable -> L102
    L101:
        throw new IllegalStateException("released");     // Catch: Throwable -> L102
    }

    private Socket releaseIfNoNewStreams() {
        RealConnection r0 = this.connection;
        if (r0 != null) goto L5;
        return null;
    L5:
        if (r0.noNewStreams == true) goto L7;
        return null;
    L7:
        return deallocate(false, false, true);
    }

    public void streamFinished(boolean r4, HttpCodec r5, long r6, IOException r8) {
        this.eventListener.responseBodyEnd(this.call, r6);
        ConnectionPool r7 = this.connectionPool;
        monitor-enter(r7);
        if (r5 == null) goto L24;
    L25:
        th = move-exception;
        throw th;
    L6:
        if (r5 != this.codec) goto L24;
        if (r4 == true) goto L10;
        this.connection.successCount++;     // Catch: Throwable -> L25
    L10:
        RealConnection r9 = this.connection;     // Catch: Throwable -> L25
        Socket r10 = deallocate(r4, false, true);     // Catch: Throwable -> L25
        if (this.connection == null) goto L13;
        r9 = null;
    L13:
        boolean r11 = this.released;     // Catch: Throwable -> L25
        monitor-exit(r7);     // Catch: Throwable -> L25
        Util.closeQuietly(r10);
        if (r9 == null) goto L18;
        this.eventListener.connectionReleased(this.call, r9);
    L18:
        if (r8 == null) goto L20;
        this.eventListener.callFailed(this.call, Internal.instance.timeoutExit(this.call, r8));
        return;
    L20:
        if (r11 == false) goto L30;
        Internal.instance.timeoutExit(this.call, null);
        this.eventListener.callEnd(this.call);
        return;
    L30:
        return;
    L24:
        throw new IllegalStateException("expected " + this.codec + " but was " + r5);     // Catch: Throwable -> L25
    }

    public HttpCodec codec() {
        ConnectionPool r0 = this.connectionPool;
        monitor-enter(r0);
        HttpCodec r1 = this.codec;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    private RouteDatabase routeDatabase() {
        return Internal.instance.routeDatabase(this.connectionPool);
    }

    public Route route() {
        return this.route;
    }

    public synchronized RealConnection connection() {
        monitor-enter(this);
        RealConnection r0 = this.connection;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public void release() {
        ConnectionPool r0 = this.connectionPool;
        monitor-enter(r0);
        RealConnection r1 = this.connection;     // Catch: Throwable -> L12
        Socket r2 = deallocate(false, true, false);     // Catch: Throwable -> L12
        if (this.connection == null) goto L7;
        r1 = null;
    L7:
        monitor-exit(r0);     // Catch: Throwable -> L12
        Util.closeQuietly(r2);
        if (r1 == null) goto L17;
        Internal.instance.timeoutExit(this.call, null);
        this.eventListener.connectionReleased(this.call, r1);
        this.eventListener.callEnd(this.call);
        return;
    L17:
        return;
    L12:
        th = move-exception;
        throw th;
    }

    public void noNewStreams() {
        ConnectionPool r0 = this.connectionPool;
        monitor-enter(r0);
        RealConnection r1 = this.connection;     // Catch: Throwable -> L12
        Socket r2 = deallocate(true, false, false);     // Catch: Throwable -> L12
        if (this.connection == null) goto L7;
        r1 = null;
    L7:
        monitor-exit(r0);     // Catch: Throwable -> L12
        Util.closeQuietly(r2);
        if (r1 == null) goto L17;
        this.eventListener.connectionReleased(this.call, r1);
        return;
    L17:
        return;
    L12:
        th = move-exception;
        throw th;
    }

    private Socket deallocate(boolean r2, boolean r3, boolean r4) {
        if (r4 == false) goto L6;
        this.codec = null;
    L6:
        if (r3 == false) goto L8;
        this.released = true;
    L8:
        RealConnection r5 = this.connection;
        if (r5 == null) goto L26;
        if (r2 == false) goto L13;
        r5.noNewStreams = true;
    L13:
        if (this.codec == null) goto L15;
        return null;
    L15:
        if (this.released == false) goto L17;
    L18:
        release(this.connection);
        if (this.connection.allocations.isEmpty() == false) goto L23;
        this.connection.idleAtNanos = System.nanoTime();
        if (Internal.instance.connectionBecameIdle(this.connectionPool, this.connection) == false) goto L23;
        Socket r6 = this.connection.socket();
    L24:
        this.connection = null;
        return r6;
    L23:
        r6 = null;
        goto L24
    L17:
        if (this.connection.noNewStreams == true) goto L18;
        return null;
    L26:
        return null;
    }

    public void cancel(int r3) {
        ConnectionPool r0 = this.connectionPool;
        monitor-enter(r0);
        this.canceled = true;     // Catch: Throwable -> L12
        this.canceledReason = r3;     // Catch: Throwable -> L12
        HttpCodec r4 = this.codec;     // Catch: Throwable -> L12
        RealConnection r2 = this.connection;     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        if (r4 == null) goto L9;
        r4.cancel();
        return;
    L9:
        if (r2 == null) goto L18;
        r2.cancel();
        return;
    L18:
        return;
    L12:
        th = move-exception;
        throw th;
    }

    public void streamFailed(IOException r7) {
        ConnectionPool r0 = this.connectionPool;
        monitor-enter(r0);
        RealConnection r2 = null;
        if ((r7 instanceof StreamResetException) == false) goto L14;
        ErrorCode r8 = ((StreamResetException) r7).errorCode;     // Catch: Throwable -> L40
        if (r8 != ErrorCode.REFUSED_STREAM) goto L12;
        int r9 = this.refusedStreamCount + 1;     // Catch: Throwable -> L40
        this.refusedStreamCount = r9;     // Catch: Throwable -> L40
        if (r9 <= 1) goto L28;
        this.route = null;     // Catch: Throwable -> L40
    L27:
        boolean r10 = true;
    L29:
        RealConnection r1 = this.connection;     // Catch: Throwable -> L40
        Socket r11 = deallocate(r10, false, true);     // Catch: Throwable -> L40
        if (this.connection == null) goto L32;
    L35:
        monitor-exit(r0);     // Catch: Throwable -> L40
        Util.closeQuietly(r11);
        if (r2 == null) goto L45;
        this.eventListener.connectionReleased(this.call, r2);
        return;
    L45:
        return;
    L32:
        if (this.reportedAcquired == false) goto L35;
        r2 = r1;
    L28:
        r10 = false;
        goto L29
    L12:
        if (r8 == ErrorCode.CANCEL) goto L28;
        this.route = null;     // Catch: Throwable -> L40
        goto L27
    L14:
        RealConnection r3 = this.connection;     // Catch: Throwable -> L40
        if (r3 == null) goto L28;
        if (r3.isMultiplexed() == false) goto L21;
        if ((r7 instanceof ConnectionShutdownException) == false) goto L28;
    L21:
        if (this.connection.successCount != 0) goto L27;
        Route r4 = this.route;     // Catch: Throwable -> L40
        if (r4 == null) goto L26;
        if (r7 == null) goto L26;
        this.routeSelector.connectFailed(r4, r7);     // Catch: Throwable -> L40
    L26:
        this.route = null;     // Catch: Throwable -> L40
    L40:
        th = move-exception;
        throw th;
    }

    public void acquire(RealConnection r2, boolean r3) {
        if (this.connection != null) goto L7;
        this.connection = r2;
        this.reportedAcquired = r3;
        r2.allocations.add(new StreamAllocationReference(this, this.callStackTrace));
        return;
    L7:
        throw new IllegalStateException();
    }

    private void release(RealConnection r4) {
        int r0 = r4.allocations.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L10;
        if (r4.allocations.get(r1).get() == this) goto L6;
        r1 = r1 + 1;
        goto L3
    L6:
        r4.allocations.remove(r1);
        return;
    L10:
        throw new IllegalStateException();
    }

    public Socket releaseAndAcquire(RealConnection r4) {
        if (this.codec != null) goto L9;
        if (this.connection.allocations.size() != 1) goto L9;
        Reference<StreamAllocation> r0 = this.connection.allocations.get(0);
        Socket r1 = deallocate(true, false, false);
        this.connection = r4;
        r4.allocations.add(r0);
        return r1;
    L9:
        throw new IllegalStateException();
    }

    public boolean hasMoreRoutes() {
        if (this.route != null) goto L12;
        RouteSelector.Selection r0 = this.routeSelection;
        if (r0 == null) goto L9;
        if (r0.hasNext() == true) goto L12;
    L9:
        if (this.routeSelector.hasNext() == true) goto L12;
        return false;
    L12:
        return true;
    }

    public String toString() {
        RealConnection r0 = connection();
        if (r0 == null) goto L6;
        return r0.toString();
    L6:
        return this.address.toString();
    }

    public void resetRouteSelector(int r2) {
        this.routeSelector.resetNextProxy(r2);
        this.routeSelection = null;
    }
}
