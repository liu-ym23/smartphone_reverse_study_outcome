package okhttp3.internal.connection;

import androidx.core.app.NotificationCompat;
import com.android.settings.deviceinfo.DeviceInfoProvider;
import java.io.IOException;
import java.net.Socket;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
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

/* JADX INFO: compiled from: ExchangeFinder.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0016\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cJ0\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u000e2\u0006\u0010 \u001a\u00020\u000e2\u0006\u0010!\u001a\u00020\u000e2\u0006\u0010\"\u001a\u00020\u000e2\u0006\u0010#\u001a\u00020$H\u0002J8\u0010%\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u000e2\u0006\u0010 \u001a\u00020\u000e2\u0006\u0010!\u001a\u00020\u000e2\u0006\u0010\"\u001a\u00020\u000e2\u0006\u0010#\u001a\u00020$2\u0006\u0010&\u001a\u00020$H\u0002J\u0006\u0010'\u001a\u00020$J\n\u0010(\u001a\u0004\u0018\u00010\u0010H\u0002J\u000e\u0010)\u001a\u00020$2\u0006\u0010*\u001a\u00020+J\u000e\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/R\u0014\u0010\u0004\u001a\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00060"}, d2 = {"Lokhttp3/internal/connection/ExchangeFinder;", "", "connectionPool", "Lokhttp3/internal/connection/RealConnectionPool;", "address", "Lokhttp3/Address;", NotificationCompat.CATEGORY_CALL, "Lokhttp3/internal/connection/RealCall;", "eventListener", "Lokhttp3/EventListener;", "(Lokhttp3/internal/connection/RealConnectionPool;Lokhttp3/Address;Lokhttp3/internal/connection/RealCall;Lokhttp3/EventListener;)V", "getAddress$okhttp", "()Lokhttp3/Address;", "connectionShutdownCount", "", "nextRouteToTry", "Lokhttp3/Route;", "otherFailureCount", "refusedStreamCount", "routeSelection", "Lokhttp3/internal/connection/RouteSelector$Selection;", "routeSelector", "Lokhttp3/internal/connection/RouteSelector;", "find", "Lokhttp3/internal/http/ExchangeCodec;", DeviceInfoProvider.CLIENT, "Lokhttp3/OkHttpClient;", "chain", "Lokhttp3/internal/http/RealInterceptorChain;", "findConnection", "Lokhttp3/internal/connection/RealConnection;", "connectTimeout", "readTimeout", "writeTimeout", "pingIntervalMillis", "connectionRetryEnabled", "", "findHealthyConnection", "doExtensiveHealthChecks", "retryAfterFailure", "retryRoute", "sameHostAndPort", "url", "Lokhttp3/HttpUrl;", "trackFailure", "", "e", "Ljava/io/IOException;", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ExchangeFinder {
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

    public ExchangeFinder(RealConnectionPool r2, Address r3, RealCall r4, EventListener r5) {
        Intrinsics.checkNotNullParameter(r2, "connectionPool");
        Intrinsics.checkNotNullParameter(r3, "address");
        Intrinsics.checkNotNullParameter(r4, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(r5, "eventListener");
        this.connectionPool = r2;
        this.address = r3;
        this.call = r4;
        this.eventListener = r5;
    }

    public final Address getAddress$okhttp() {
        return this.address;
    }

    public final ExchangeCodec find(OkHttpClient r9, RealInterceptorChain r10) {
        Intrinsics.checkNotNullParameter(r9, DeviceInfoProvider.CLIENT);
        Intrinsics.checkNotNullParameter(r10, "chain");
        int r2 = r10.getConnectTimeoutMillis$okhttp();     // Catch: IOException -> L9 RouteException -> L12
        int r3 = r10.getReadTimeoutMillis$okhttp();     // Catch: IOException -> L9 RouteException -> L12
        int r4 = r10.getWriteTimeoutMillis$okhttp();     // Catch: IOException -> L9 RouteException -> L12
        int r5 = r9.pingIntervalMillis();     // Catch: IOException -> L9 RouteException -> L12
        boolean r6 = r9.retryOnConnectionFailure();     // Catch: IOException -> L9 RouteException -> L12
        if (Intrinsics.areEqual(r10.getRequest$okhttp().method(), "GET") == true) goto L6;
        boolean r0 = true;
    L7:
        return findHealthyConnection(r2, r3, r4, r5, r6, r0).newCodec$okhttp(r9, r10);
    L6:
        r0 = false;
    L9:
        e = move-exception;
        trackFailure(e);
        throw new RouteException(e);
    L12:
        e = move-exception;
        trackFailure(e.getLastConnectException());
        throw e;
    }

    private final RealConnection findHealthyConnection(int r3, int r4, int r5, int r6, boolean r7, boolean r8) throws IOException {
    L2:
        RealConnection r0 = findConnection(r3, r4, r5, r6, r7);
        if (r0.isHealthy(r8) == true) goto L4;
        r0.noNewExchanges$okhttp();
        if (this.nextRouteToTry != null) goto L2;
        RouteSelector.Selection r1 = this.routeSelection;
        boolean r2 = true;
        if (r1 != null) goto L11;
        boolean r9 = true;
    L12:
        if (r9 == true) goto L2;
        RouteSelector r10 = this.routeSelector;
        if (r10 == null) goto L18;
        r2 = r10.hasNext();
    L18:
        if (r2 == true) goto L2;
        throw new IOException("exhausted all routes");
    L11:
        r9 = r1.hasNext();
        goto L12
    L4:
        return r0;
    }

    private final RealConnection findConnection(int r15, int r16, int r17, int r18, boolean r19) throws IOException {
        if (this.call.isCanceled() == true) goto L75;
        RealConnection r2 = this.call.getConnection();
        boolean r0 = true;
        if (r2 == null) goto L32;
        monitor-enter(r2);
    L29:
        th = move-exception;
        throw th;
    L8:
        if (r2.getNoNewExchanges() == false) goto L10;
    L13:
        Socket r5 = this.call.releaseConnectionNoEvents$okhttp();     // Catch: Throwable -> L29
    L14:
        Unit r6 = Unit.INSTANCE;     // Catch: Throwable -> L29
        monitor-exit(r2);
        if (this.call.getConnection() == null) goto L25;
        if (r5 == null) goto L21;
        r0 = false;
    L21:
        if (r0 == false) goto L24;
        return r2;
    L24:
        throw new IllegalStateException("Check failed.".toString());
    L25:
        if (r5 == null) goto L28;
        Util.closeQuietly(r5);
    L28:
        this.eventListener.connectionReleased(this.call, r2);
        goto L32
    L10:
        if (sameHostAndPort(r2.route().address().url()) == false) goto L13;
        r5 = null;
    L32:
        this.refusedStreamCount = 0;
        this.connectionShutdownCount = 0;
        this.otherFailureCount = 0;
        if (this.connectionPool.callAcquirePooledConnection(this.address, this.call, null, false) == false) goto L36;
        RealConnection r1 = this.call.getConnection();
        Intrinsics.checkNotNull(r1);
        this.eventListener.connectionAcquired(this.call, r1);
        return r1;
    L36:
        Route r3 = this.nextRouteToTry;
        if (r3 == null) goto L40;
        Intrinsics.checkNotNull(r3);
        this.nextRouteToTry = null;
    L39:
        List<Route> r7 = null;
    L55:
        RealConnection r4 = new RealConnection(this.connectionPool, r3);
        this.call.setConnectionToCancel(r4);
        r4.connect(r15, r16, r17, r18, r19, this.call, this.eventListener);     // Catch: Throwable -> L69
        this.call.setConnectionToCancel(null);
        this.call.getClient().getRouteDatabase().connected(r4.route());
        if (this.connectionPool.callAcquirePooledConnection(this.address, this.call, r7, true) == false) goto L61;
        RealConnection r8 = this.call.getConnection();
        Intrinsics.checkNotNull(r8);
        this.nextRouteToTry = r3;
        Util.closeQuietly(r4.socket());
        this.eventListener.connectionAcquired(this.call, r8);
        return r8;
    L61:
        monitor-enter(r4);
        this.connectionPool.put(r4);     // Catch: Throwable -> L66
        this.call.acquireConnectionNoEvents(r4);     // Catch: Throwable -> L66
        Unit r9 = Unit.INSTANCE;     // Catch: Throwable -> L66
        monitor-exit(r4);
        this.eventListener.connectionAcquired(this.call, r4);
        return r4;
    L66:
        th = move-exception;
        throw th;
    L69:
        th = move-exception;
        this.call.setConnectionToCancel(null);
        throw th;
    L40:
        RouteSelector.Selection r10 = this.routeSelection;
        if (r10 == null) goto L45;
        Intrinsics.checkNotNull(r10);
        if (r10.hasNext() == false) goto L45;
        RouteSelector.Selection r11 = this.routeSelection;
        Intrinsics.checkNotNull(r11);
        r3 = r11.next();
    L45:
        RouteSelector r12 = this.routeSelector;
        if (r12 != null) goto L48;
        r12 = new RouteSelector(this.address, this.call.getClient().getRouteDatabase(), this.call, this.eventListener);
        this.routeSelector = r12;
    L48:
        RouteSelector.Selection r13 = r12.next();
        this.routeSelection = r13;
        r7 = r13.getRoutes();
        if (this.call.isCanceled() == true) goto L73;
        if (this.connectionPool.callAcquirePooledConnection(this.address, this.call, r7, false) == false) goto L54;
        RealConnection r14 = this.call.getConnection();
        Intrinsics.checkNotNull(r14);
        this.eventListener.connectionAcquired(this.call, r14);
        return r14;
    L54:
        r3 = r13.next();
        goto L55
    L73:
        throw new IOException("Canceled");
    L75:
        throw new IOException("Canceled");
    }

    public final void trackFailure(IOException r3) {
        Intrinsics.checkNotNullParameter(r3, "e");
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

    public final boolean retryAfterFailure() {
        boolean r1 = false;
        if (this.refusedStreamCount != 0) goto L10;
        if (this.connectionShutdownCount != 0) goto L10;
        if (this.otherFailureCount != 0) goto L10;
        return false;
    L10:
        if (this.nextRouteToTry == null) goto L12;
        return true;
    L12:
        Route r0 = retryRoute();
        if (r0 == null) goto L16;
        this.nextRouteToTry = r0;
        return true;
    L16:
        RouteSelector.Selection r2 = this.routeSelection;
        if (r2 != null) goto L20;
    L22:
        if (r1 == false) goto L24;
        return true;
    L24:
        RouteSelector r3 = this.routeSelector;
        if (r3 != null) goto L28;
        return true;
    L28:
        return r3.hasNext();
    L20:
        if (r2.hasNext() != true) goto L22;
        r1 = true;
        goto L22
    }

    private final Route retryRoute() {
        if (this.refusedStreamCount <= 1) goto L5;
    L27:
        return null;
    L5:
        if (this.connectionShutdownCount > 1) goto L27;
        if (this.otherFailureCount > 0) goto L27;
        RealConnection r0 = this.call.getConnection();
        if (r0 != null) goto L12;
        return null;
    L12:
        monitor-enter(r0);
    L24:
        th = move-exception;
        throw th;
    L14:
        if (r0.getRouteFailureCount$okhttp() == 0) goto L18;
        monitor-exit(r0);
        return null;
    L18:
        if (Util.canReuseConnectionFor(r0.route().address().url(), getAddress$okhttp().url()) == true) goto L21;
        monitor-exit(r0);
        return null;
    L21:
        Route r3 = r0.route();     // Catch: Throwable -> L24
        monitor-exit(r0);
        return r3;
    }

    public final boolean sameHostAndPort(HttpUrl r3) {
        Intrinsics.checkNotNullParameter(r3, "url");
        HttpUrl r2 = this.address.url();
        if (r3.port() == r2.port()) goto L5;
    L7:
        return false;
    L5:
        if (Intrinsics.areEqual(r3.host(), r2.host()) == false) goto L7;
        return true;
    }
}
