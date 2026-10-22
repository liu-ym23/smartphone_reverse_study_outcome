package okhttp3.internal.connection;

import androidx.core.app.NotificationCompat;
import com.bytedance.retrofit2.HttpMethodContrants;
import java.io.IOException;
import java.net.Socket;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Address;
import okhttp3.EventListener;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Route;
import okhttp3.internal.Util;
import okhttp3.internal.http.ExchangeCodec;
import okhttp3.internal.http.RealInterceptorChain;
import okhttp3.internal.http2.ConnectionShutdownException;
import okhttp3.internal.http2.ErrorCode;
import okhttp3.internal.http2.StreamResetException;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class ExchangeFinder {

    @NotNull
    private final Address address;
    private final RealCall call;
    private final RealConnectionPool connectionPool;
    private int connectionShutdownCount;
    private final EventListener eventListener;
    private Route nextRouteToTry;
    private int otherFailureCount;
    private int refusedStreamCount;
    private RouteSelector.Selection routeSelection;
    private RouteSelector routeSelector;

    public ExchangeFinder(@NotNull RealConnectionPool r2, @NotNull Address r3, @NotNull RealCall r4, @NotNull EventListener r5) {
        Intrinsics.f(r2, "connectionPool");
        Intrinsics.f(r3, "address");
        Intrinsics.f(r4, NotificationCompat.CATEGORY_CALL);
        Intrinsics.f(r5, "eventListener");
        this.connectionPool = r2;
        this.address = r3;
        this.call = r4;
        this.eventListener = r5;
    }

    private final RealConnection findConnection(int r15, int r16, int r17, int r18, boolean r19) {
        if (this.call.isCanceled() == true) goto L74;
        RealConnection r2 = this.call.getConnection();
        boolean r0 = true;
        if (r2 == null) goto L31;
        monitor-enter(r2);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (r2.getNoNewExchanges() == false) goto L10;
    L15:
        Socket r5 = this.call.releaseConnectionNoEvents$okhttp();     // Catch: Throwable -> L13
    L16:
        monitor-exit(r2);
        if (this.call.getConnection() == null) goto L26;
        if (r5 == null) goto L22;
        r0 = false;
    L22:
        if (r0 == false) goto L25;
        return r2;
    L25:
        throw new IllegalStateException("Check failed.".toString());
    L26:
        if (r5 == null) goto L28;
        Util.closeQuietly(r5);
    L28:
        this.eventListener.connectionReleased(this.call, r2);
        goto L31
    L10:
        if (sameHostAndPort(r2.route().address().url()) == false) goto L15;
        r5 = null;
    L31:
        this.refusedStreamCount = 0;
        this.connectionShutdownCount = 0;
        this.otherFailureCount = 0;
        if (this.connectionPool.callAcquirePooledConnection(this.address, this.call, null, false) == false) goto L35;
        RealConnection r1 = this.call.getConnection();
        Intrinsics.c(r1);
        this.eventListener.connectionAcquired(this.call, r1);
        return r1;
    L35:
        Route r3 = this.nextRouteToTry;
        if (r3 == null) goto L39;
        Intrinsics.c(r3);
        this.nextRouteToTry = null;
    L38:
        List<Route> r6 = null;
    L54:
        RealConnection r4 = new RealConnection(this.connectionPool, r3);
        this.call.setConnectionToCancel(r4);
        r4.connect(r15, r16, r17, r18, r19, this.call, this.eventListener);     // Catch: Throwable -> L68
        this.call.setConnectionToCancel(null);
        this.call.getClient().getRouteDatabase().connected(r4.route());
        if (this.connectionPool.callAcquirePooledConnection(this.address, this.call, r6, true) == false) goto L60;
        RealConnection r7 = this.call.getConnection();
        Intrinsics.c(r7);
        this.nextRouteToTry = r3;
        Util.closeQuietly(r4.socket());
        this.eventListener.connectionAcquired(this.call, r7);
        return r7;
    L60:
        monitor-enter(r4);
        this.connectionPool.put(r4);     // Catch: Throwable -> L65
        this.call.acquireConnectionNoEvents(r4);     // Catch: Throwable -> L65
        monitor-exit(r4);
        this.eventListener.connectionAcquired(this.call, r4);
        return r4;
    L65:
        th = move-exception;
        throw th;
    L68:
        th = move-exception;
        this.call.setConnectionToCancel(null);
        throw th;
    L39:
        RouteSelector.Selection r8 = this.routeSelection;
        if (r8 == null) goto L44;
        Intrinsics.c(r8);
        if (r8.hasNext() == false) goto L44;
        RouteSelector.Selection r9 = this.routeSelection;
        Intrinsics.c(r9);
        r3 = r9.next();
    L44:
        RouteSelector r10 = this.routeSelector;
        if (r10 != null) goto L47;
        r10 = new RouteSelector(this.address, this.call.getClient().getRouteDatabase(), this.call, this.eventListener);
        this.routeSelector = r10;
    L47:
        RouteSelector.Selection r11 = r10.next();
        this.routeSelection = r11;
        r6 = r11.getRoutes();
        if (this.call.isCanceled() == true) goto L72;
        if (this.connectionPool.callAcquirePooledConnection(this.address, this.call, r6, false) == false) goto L53;
        RealConnection r12 = this.call.getConnection();
        Intrinsics.c(r12);
        this.eventListener.connectionAcquired(this.call, r12);
        return r12;
    L53:
        r3 = r11.next();
        goto L54
    L72:
        throw new IOException("Canceled");
    L74:
        throw new IOException("Canceled");
    }

    private final RealConnection findHealthyConnection(int r3, int r4, int r5, int r6, boolean r7, boolean r8) {
    L2:
        RealConnection r0 = findConnection(r3, r4, r5, r6, r7);
        if (r0.isHealthy(r8) == true) goto L4;
        r0.noNewExchanges$okhttp();
        if (this.nextRouteToTry != null) goto L2;
        RouteSelector.Selection r1 = this.routeSelection;
        boolean r2 = true;
        if (r1 == null) goto L11;
        boolean r9 = r1.hasNext();
    L12:
        if (r9 == true) goto L2;
        RouteSelector r10 = this.routeSelector;
        if (r10 == null) goto L17;
        r2 = r10.hasNext();
    L17:
        if (r2 == true) goto L2;
        throw new IOException("exhausted all routes");
    L11:
        r9 = true;
        goto L12
    L4:
        return r0;
    }

    private final Route retryRoute() {
        if (this.refusedStreamCount <= 1) goto L5;
    L26:
        return null;
    L5:
        if (this.connectionShutdownCount > 1) goto L26;
        if (this.otherFailureCount > 0) goto L26;
        RealConnection r0 = this.call.getConnection();
        if (r0 == null) goto L26;
        monitor-enter(r0);
    L23:
        th = move-exception;
        throw th;
    L13:
        if (r0.getRouteFailureCount$okhttp() == 0) goto L17;
        monitor-exit(r0);
        return null;
    L17:
        if (Util.canReuseConnectionFor(r0.route().address().url(), this.address.url()) == true) goto L20;
        monitor-exit(r0);
        return null;
    L20:
        Route r3 = r0.route();     // Catch: Throwable -> L23
        monitor-exit(r0);
        return r3;
    }

    @NotNull
    public final ExchangeCodec find(@NotNull OkHttpClient r9, @NotNull RealInterceptorChain r10) {
        Intrinsics.f(r9, "client");
        Intrinsics.f(r10, "chain");
        return findHealthyConnection(r10.getConnectTimeoutMillis$okhttp(), r10.getReadTimeoutMillis$okhttp(), r10.getWriteTimeoutMillis$okhttp(), r9.pingIntervalMillis(), r9.retryOnConnectionFailure(), !Intrinsics.a(r10.getRequest$okhttp().method(), HttpMethodContrants.GET)).newCodec$okhttp(r9, r10);
    L5:
        e = move-exception;
        trackFailure(e);
        throw new RouteException(e);
    L7:
        e = move-exception;
        trackFailure(e.getLastConnectException());
        throw e;
    }

    @NotNull
    public final Address getAddress$okhttp() {
        return this.address;
    }

    public final boolean retryAfterFailure() {
        if (this.refusedStreamCount != 0) goto L11;
        if (this.connectionShutdownCount != 0) goto L11;
        if (this.otherFailureCount != 0) goto L11;
        return false;
    L11:
        if (this.nextRouteToTry == null) goto L13;
        return true;
    L13:
        Route r0 = retryRoute();
        if (r0 == null) goto L17;
        this.nextRouteToTry = r0;
        return true;
    L17:
        RouteSelector.Selection r1 = this.routeSelection;
        if (r1 != null) goto L20;
    L22:
        RouteSelector r2 = this.routeSelector;
        if (r2 != null) goto L25;
        return true;
    L25:
        return r2.hasNext();
    L20:
        if (r1.hasNext() != true) goto L22;
        return true;
    }

    public final boolean sameHostAndPort(@NotNull HttpUrl r3) {
        Intrinsics.f(r3, "url");
        HttpUrl r2 = this.address.url();
        if (r3.port() == r2.port()) goto L5;
    L7:
        return false;
    L5:
        if (Intrinsics.a(r3.host(), r2.host()) == false) goto L7;
        return true;
    }

    public final void trackFailure(@NotNull IOException r3) {
        Intrinsics.f(r3, "e");
        this.nextRouteToTry = null;
        if ((r3 instanceof StreamResetException) == false) goto L8;
        if (((StreamResetException) r3).errorCode != ErrorCode.REFUSED_STREAM) goto L8;
        this.refusedStreamCount++;
        return;
    L8:
        if ((r3 instanceof ConnectionShutdownException) == false) goto L10;
        this.connectionShutdownCount++;
        return;
    L10:
        this.otherFailureCount++;
    }
}
