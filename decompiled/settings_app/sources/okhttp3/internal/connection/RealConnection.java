package okhttp3.internal.connection;

import android.security.bytedance.guard.BDSecurityGuardStub;
import androidx.core.app.NotificationCompat;
import com.android.settings.deviceinfo.DeviceInfoProvider;
import com.android.settingslib.accessibility.AccessibilityUtils;
import com.bytedance.common.wschannel.WsConstants;
import com.monitor.cloudmessage.consts.CloudControlInf;
import com.obric.aikernel.sdk.ext.CozeCloudExt;
import java.io.IOException;
import java.lang.ref.Reference;
import java.net.ConnectException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownServiceException;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.Address;
import okhttp3.Call;
import okhttp3.CertificatePinner;
import okhttp3.CipherSuite;
import okhttp3.Connection;
import okhttp3.ConnectionSpec;
import okhttp3.EventListener;
import okhttp3.Handshake;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Route;
import okhttp3.internal.Util;
import okhttp3.internal.concurrent.TaskRunner;
import okhttp3.internal.http.ExchangeCodec;
import okhttp3.internal.http.RealInterceptorChain;
import okhttp3.internal.http1.Http1ExchangeCodec;
import okhttp3.internal.http2.ConnectionShutdownException;
import okhttp3.internal.http2.ErrorCode;
import okhttp3.internal.http2.Http2Connection;
import okhttp3.internal.http2.Http2ExchangeCodec;
import okhttp3.internal.http2.Http2Stream;
import okhttp3.internal.http2.Settings;
import okhttp3.internal.http2.StreamResetException;
import okhttp3.internal.platform.Platform;
import okhttp3.internal.tls.OkHostnameVerifier;
import okhttp3.internal.ws.RealWebSocket;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.Okio;

/* JADX INFO: compiled from: RealConnection.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000ì\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u0000 {2\u00020\u00012\u00020\u0002:\u0001{B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0006\u00105\u001a\u000206J\u0018\u00107\u001a\u00020\u001d2\u0006\u00108\u001a\u0002092\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J>\u0010:\u001a\u0002062\u0006\u0010;\u001a\u00020\t2\u0006\u0010<\u001a\u00020\t2\u0006\u0010=\u001a\u00020\t2\u0006\u0010>\u001a\u00020\t2\u0006\u0010?\u001a\u00020\u001d2\u0006\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020CJ%\u0010D\u001a\u0002062\u0006\u0010E\u001a\u00020F2\u0006\u0010G\u001a\u00020\u00062\u0006\u0010H\u001a\u00020IH\u0000¢\u0006\u0002\bJJ(\u0010K\u001a\u0002062\u0006\u0010;\u001a\u00020\t2\u0006\u0010<\u001a\u00020\t2\u0006\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020CH\u0002J\u0010\u0010L\u001a\u0002062\u0006\u0010M\u001a\u00020NH\u0002J0\u0010O\u001a\u0002062\u0006\u0010;\u001a\u00020\t2\u0006\u0010<\u001a\u00020\t2\u0006\u0010=\u001a\u00020\t2\u0006\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020CH\u0002J*\u0010P\u001a\u0004\u0018\u00010Q2\u0006\u0010<\u001a\u00020\t2\u0006\u0010=\u001a\u00020\t2\u0006\u0010R\u001a\u00020Q2\u0006\u00108\u001a\u000209H\u0002J\b\u0010S\u001a\u00020QH\u0002J(\u0010T\u001a\u0002062\u0006\u0010M\u001a\u00020N2\u0006\u0010>\u001a\u00020\t2\u0006\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020CH\u0002J\n\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\r\u0010U\u001a\u000206H\u0000¢\u0006\u0002\bVJ%\u0010W\u001a\u00020\u001d2\u0006\u0010X\u001a\u00020Y2\u000e\u0010Z\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010[H\u0000¢\u0006\u0002\b\\J\u000e\u0010]\u001a\u00020\u001d2\u0006\u0010^\u001a\u00020\u001dJ\u001d\u0010_\u001a\u00020`2\u0006\u0010E\u001a\u00020F2\u0006\u0010a\u001a\u00020bH\u0000¢\u0006\u0002\bcJ\u0015\u0010d\u001a\u00020e2\u0006\u0010f\u001a\u00020gH\u0000¢\u0006\u0002\bhJ\r\u0010 \u001a\u000206H\u0000¢\u0006\u0002\biJ\r\u0010!\u001a\u000206H\u0000¢\u0006\u0002\bjJ\u0018\u0010k\u001a\u0002062\u0006\u0010l\u001a\u00020\u00152\u0006\u0010m\u001a\u00020nH\u0016J\u0010\u0010o\u001a\u0002062\u0006\u0010p\u001a\u00020qH\u0016J\b\u0010%\u001a\u00020&H\u0016J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\u0016\u0010r\u001a\u00020\u001d2\f\u0010s\u001a\b\u0012\u0004\u0012\u00020\u00060[H\u0002J\b\u00101\u001a\u00020(H\u0016J\u0010\u0010t\u001a\u0002062\u0006\u0010>\u001a\u00020\tH\u0002J\u0010\u0010u\u001a\u00020\u001d2\u0006\u00108\u001a\u000209H\u0002J\b\u0010v\u001a\u00020wH\u0016J\u001f\u0010x\u001a\u0002062\u0006\u0010@\u001a\u00020\r2\b\u0010y\u001a\u0004\u0018\u00010IH\u0000¢\u0006\u0002\bzR\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0016\u001a\u00020\u0017X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001c\u001a\u00020\u001d8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u000e\u0010 \u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010!\u001a\u00020\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u001f\"\u0004\b#\u0010$R\u0010\u0010%\u001a\u0004\u0018\u00010&X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u0004\u0018\u00010(X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010*\u001a\u00020\tX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u0010\u0010/\u001a\u0004\u0018\u000100X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00101\u001a\u0004\u0018\u00010(X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00102\u001a\u0004\u0018\u000103X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006|"}, d2 = {"Lokhttp3/internal/connection/RealConnection;", "Lokhttp3/internal/http2/Http2Connection$Listener;", "Lokhttp3/Connection;", "connectionPool", "Lokhttp3/internal/connection/RealConnectionPool;", CloudControlInf.ROUTE, "Lokhttp3/Route;", "(Lokhttp3/internal/connection/RealConnectionPool;Lokhttp3/Route;)V", "allocationLimit", "", "calls", "", "Ljava/lang/ref/Reference;", "Lokhttp3/internal/connection/RealCall;", "getCalls", "()Ljava/util/List;", "getConnectionPool", "()Lokhttp3/internal/connection/RealConnectionPool;", "handshake", "Lokhttp3/Handshake;", "http2Connection", "Lokhttp3/internal/http2/Http2Connection;", "idleAtNs", "", "getIdleAtNs$okhttp", "()J", "setIdleAtNs$okhttp", "(J)V", "isMultiplexed", "", "isMultiplexed$okhttp", "()Z", "noCoalescedConnections", "noNewExchanges", "getNoNewExchanges", "setNoNewExchanges", "(Z)V", "protocol", "Lokhttp3/Protocol;", "rawSocket", "Ljava/net/Socket;", "refusedStreamCount", "routeFailureCount", "getRouteFailureCount$okhttp", "()I", "setRouteFailureCount$okhttp", "(I)V", "sink", "Lokio/BufferedSink;", "socket", "source", "Lokio/BufferedSource;", "successCount", BDSecurityGuardStub.SettingsEventConst.EVENT_RESULT_CANCEL, "", "certificateSupportHost", "url", "Lokhttp3/HttpUrl;", "connect", "connectTimeout", "readTimeout", "writeTimeout", "pingIntervalMillis", "connectionRetryEnabled", NotificationCompat.CATEGORY_CALL, "Lokhttp3/Call;", "eventListener", "Lokhttp3/EventListener;", "connectFailed", DeviceInfoProvider.CLIENT, "Lokhttp3/OkHttpClient;", "failedRoute", "failure", "Ljava/io/IOException;", "connectFailed$okhttp", "connectSocket", "connectTls", "connectionSpecSelector", "Lokhttp3/internal/connection/ConnectionSpecSelector;", "connectTunnel", "createTunnel", "Lokhttp3/Request;", "tunnelRequest", "createTunnelRequest", "establishProtocol", "incrementSuccessCount", "incrementSuccessCount$okhttp", "isEligible", "address", "Lokhttp3/Address;", "routes", "", "isEligible$okhttp", "isHealthy", "doExtensiveChecks", "newCodec", "Lokhttp3/internal/http/ExchangeCodec;", "chain", "Lokhttp3/internal/http/RealInterceptorChain;", "newCodec$okhttp", "newWebSocketStreams", "Lokhttp3/internal/ws/RealWebSocket$Streams;", "exchange", "Lokhttp3/internal/connection/Exchange;", "newWebSocketStreams$okhttp", "noCoalescedConnections$okhttp", "noNewExchanges$okhttp", "onSettings", WsConstants.KEY_CONNECTION, "settings", "Lokhttp3/internal/http2/Settings;", "onStream", CozeCloudExt.API_KEY_HTTP_STREAM_METHOD, "Lokhttp3/internal/http2/Http2Stream;", "routeMatchesAny", "candidates", "startHttp2", "supportsUrl", "toString", "", "trackFailure", "e", "trackFailure$okhttp", "Companion", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class RealConnection extends Http2Connection.Listener implements Connection {
    public static final Companion Companion = null;
    public static final long IDLE_CONNECTION_HEALTHY_NS = 10000000000L;
    private static final int MAX_TUNNEL_ATTEMPTS = 21;
    private static final String NPE_THROW_WITH_NULL = "throw with null exception";
    private int allocationLimit;
    private final List<Reference<RealCall>> calls;
    private final RealConnectionPool connectionPool;
    private Handshake handshake;
    private Http2Connection http2Connection;
    private long idleAtNs;
    private boolean noCoalescedConnections;
    private boolean noNewExchanges;
    private Protocol protocol;
    private Socket rawSocket;
    private int refusedStreamCount;
    private final Route route;
    private int routeFailureCount;
    private BufferedSink sink;
    private Socket socket;
    private BufferedSource source;
    private int successCount;

    /* JADX INFO: compiled from: RealConnection.kt */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J&\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lokhttp3/internal/connection/RealConnection$Companion;", "", "()V", "IDLE_CONNECTION_HEALTHY_NS", "", "MAX_TUNNEL_ATTEMPTS", "", "NPE_THROW_WITH_NULL", "", "newTestConnection", "Lokhttp3/internal/connection/RealConnection;", "connectionPool", "Lokhttp3/internal/connection/RealConnectionPool;", CloudControlInf.ROUTE, "Lokhttp3/Route;", "socket", "Ljava/net/Socket;", "idleAtNs", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }

        public final RealConnection newTestConnection(RealConnectionPool r1, Route r2, Socket r3, long r4) {
            Intrinsics.checkNotNullParameter(r1, "connectionPool");
            Intrinsics.checkNotNullParameter(r2, CloudControlInf.ROUTE);
            Intrinsics.checkNotNullParameter(r3, "socket");
            RealConnection r0 = new RealConnection(r1, r2);
            RealConnection.access$setSocket$p(r0, r3);
            r0.setIdleAtNs$okhttp(r4);
            return r0;
        }
    }

    /* JADX INFO: compiled from: RealConnection.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r0 = new int[Proxy.Type.values().length];
            r0[Proxy.Type.DIRECT.ordinal()] = 1;
            r0[Proxy.Type.HTTP.ordinal()] = 2;
            $EnumSwitchMapping$0 = r0;
        }
    }

    static {
        Companion = new Companion(null);
    }

    public static final /* synthetic */ Handshake access$getHandshake$p(RealConnection r0) {
        return r0.handshake;
    }

    public static final /* synthetic */ void access$setSocket$p(RealConnection r0, Socket r1) {
        r0.socket = r1;
    }

    public final RealConnectionPool getConnectionPool() {
        return this.connectionPool;
    }

    public RealConnection(RealConnectionPool r2, Route r3) {
        Intrinsics.checkNotNullParameter(r2, "connectionPool");
        Intrinsics.checkNotNullParameter(r3, CloudControlInf.ROUTE);
        this.connectionPool = r2;
        this.route = r3;
        this.allocationLimit = 1;
        this.calls = new ArrayList();
        this.idleAtNs = Long.MAX_VALUE;
    }

    public final boolean getNoNewExchanges() {
        return this.noNewExchanges;
    }

    public final void setNoNewExchanges(boolean r1) {
        this.noNewExchanges = r1;
    }

    public final int getRouteFailureCount$okhttp() {
        return this.routeFailureCount;
    }

    public final void setRouteFailureCount$okhttp(int r1) {
        this.routeFailureCount = r1;
    }

    public final List<Reference<RealCall>> getCalls() {
        return this.calls;
    }

    public final long getIdleAtNs$okhttp() {
        return this.idleAtNs;
    }

    public final void setIdleAtNs$okhttp(long r1) {
        this.idleAtNs = r1;
    }

    public final boolean isMultiplexed$okhttp() {
        if (this.http2Connection == null) goto L5;
        return true;
    L5:
        return false;
    }

    public final synchronized void noNewExchanges$okhttp() {
        monitor-enter(this);
        this.noNewExchanges = true;     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public final synchronized void noCoalescedConnections$okhttp() {
        monitor-enter(this);
        this.noCoalescedConnections = true;     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public final synchronized void incrementSuccessCount$okhttp() {
        monitor-enter(this);
        this.successCount++;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public final void connect(int r17, int r18, int r19, int r20, boolean r21, Call r22, EventListener r23) {
        Intrinsics.checkNotNullParameter(r22, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(r23, "eventListener");
        if (this.protocol != null) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L67;
        List<ConnectionSpec> r1 = this.route.address().connectionSpecs();
        ConnectionSpecSelector r11 = new ConnectionSpecSelector(r1);
        if (this.route.address().sslSocketFactory() != null) goto L19;
        if (r1.contains(ConnectionSpec.CLEARTEXT) == false) goto L17;
        String r2 = this.route.address().url().host();
        if (Platform.Companion.get().isCleartextTrafficPermitted(r2) == false) goto L15;
    L20:
        RouteException r13 = null;
    L68:
    L44:
        e = e;
    L47:
        Socket r3 = this.socket;
        if (r3 == null) goto L51;
        Util.closeQuietly(r3);
    L51:
        Socket r4 = this.rawSocket;
        if (r4 == null) goto L55;
        Util.closeQuietly(r4);
    L55:
        this.socket = null;
        this.rawSocket = null;
        this.source = null;
        this.sink = null;
        this.handshake = null;
        this.protocol = null;
        this.http2Connection = null;
        this.allocationLimit = 1;
        r23.connectFailed(r22, this.route.socketAddress(), this.route.proxy(), null, e);
        if (r13 != null) goto L58;
        r13 = new RouteException(e);
    L59:
        if (r21 == false) goto L63;
        if (r11.connectionFailed(e) == true) goto L68;
        throw r13;
    L63:
        throw r13;
    L58:
        r13.addConnectException(e);
        goto L59
    L22:
        if (this.route.requiresTunnel() == false) goto L70;
        connectTunnel(r17, r18, r19, r22, r23);     // Catch: IOException -> L44
        if (this.rawSocket == null) goto L32;
    L72:
        establishProtocol(r11, r20, r22, r23);     // Catch: IOException -> L40
        r23.connectEnd(r22, this.route.socketAddress(), this.route.proxy(), this.protocol);     // Catch: IOException -> L40
    L40:
        e = e;
    L32:
        if (this.route.requiresTunnel() == true) goto L34;
    L38:
        this.idleAtNs = System.nanoTime();
        return;
    L34:
        if (this.rawSocket != null) goto L38;
        throw new RouteException(new ProtocolException("Too many tunnel connections attempted: 21"));
    L70:
        connectSocket(r17, r18, r22, r23);     // Catch: IOException -> L42
    L42:
        e = e;
        goto L47
    L15:
        throw new RouteException(new UnknownServiceException("CLEARTEXT communication to " + r2 + " not permitted by network security policy"));
    L17:
        throw new RouteException(new UnknownServiceException("CLEARTEXT communication not enabled for client"));
    L19:
        if (this.route.address().protocols().contains(Protocol.H2_PRIOR_KNOWLEDGE) == false) goto L20;
        throw new RouteException(new UnknownServiceException("H2_PRIOR_KNOWLEDGE cannot be used with HTTPS"));
    L67:
        throw new IllegalStateException("already connected".toString());
    L5:
        r0 = false;
        goto L6
    }

    private final void connectTunnel(int r7, int r8, int r9, Call r10, EventListener r11) throws IOException {
        Request r0 = createTunnelRequest();
        HttpUrl r1 = r0.url();
        int r2 = 0;
    L4:
        if (r2 >= 21) goto L13;
        r2 = r2 + 1;
        connectSocket(r7, r8, r10, r11);
        r0 = createTunnel(r8, r9, r0, r1);
        if (r0 == null) goto L18;
        Socket r3 = this.rawSocket;
        if (r3 == null) goto L12;
        Util.closeQuietly(r3);
    L12:
        this.rawSocket = null;
        this.sink = null;
        this.source = null;
        r11.connectEnd(r10, this.route.socketAddress(), this.route.proxy(), null);
        goto L4
    L18:
        return;
    }

    private final void connectSocket(int r5, int r6, Call r7, EventListener r8) throws IOException {
        Proxy r0 = this.route.proxy();
        Address r1 = this.route.address();
        Proxy.Type r2 = r0.type();
        if (r2 != null) goto L5;
        int r3 = -1;
    L7:
        if (r3 != 1) goto L9;
    L11:
        Socket r4 = r1.socketFactory().createSocket();
        Intrinsics.checkNotNull(r4);
    L12:
        this.rawSocket = r4;
        r8.connectStart(r7, this.route.socketAddress(), r0);
        r4.setSoTimeout(r6);
        Platform.Companion.get().connectSocket(r4, this.route.socketAddress(), r5);     // Catch: ConnectException -> L22
        this.source = Okio.buffer(Okio.source(r4));     // Catch: NullPointerException -> L16
        this.sink = Okio.buffer(Okio.sink(r4));     // Catch: NullPointerException -> L16
        return;
    L16:
        e = move-exception;
        if (Intrinsics.areEqual(e.getMessage(), NPE_THROW_WITH_NULL) == true) goto L21;
        return;
    L21:
        throw new IOException(e);
    L22:
        e = move-exception;
        ConnectException r9 = new ConnectException(Intrinsics.stringPlus("Failed to connect to ", this.route.socketAddress()));
        r9.initCause(e);
        throw r9;
    L9:
        if (r3 == 2) goto L11;
        r4 = new Socket(r0);
        goto L12
    L5:
        r3 = WhenMappings.$EnumSwitchMapping$0[r2.ordinal()];
        goto L7
    }

    private final void establishProtocol(ConnectionSpecSelector r2, int r3, Call r4, EventListener r5) throws IOException {
        if (this.route.address().sslSocketFactory() == null) goto L5;
        r5.secureConnectStart(r4);
        connectTls(r2);
        r5.secureConnectEnd(r4, this.handshake);
        if (this.protocol != Protocol.HTTP_2) goto L14;
        startHttp2(r3);
        return;
    L14:
        return;
    L5:
        if (this.route.address().protocols().contains(Protocol.H2_PRIOR_KNOWLEDGE) == false) goto L8;
        this.socket = this.rawSocket;
        this.protocol = Protocol.H2_PRIOR_KNOWLEDGE;
        startHttp2(r3);
        return;
    L8:
        this.socket = this.rawSocket;
        this.protocol = Protocol.HTTP_1_1;
    }

    private final void startHttp2(int r8) throws IOException {
        Socket r0 = this.socket;
        Intrinsics.checkNotNull(r0);
        BufferedSource r1 = this.source;
        Intrinsics.checkNotNull(r1);
        BufferedSink r2 = this.sink;
        Intrinsics.checkNotNull(r2);
        r0.setSoTimeout(0);
        Http2Connection r9 = new Http2Connection.Builder(true, TaskRunner.INSTANCE).socket(r0, this.route.address().url().host(), r1, r2).listener(this).pingIntervalMillis(r8).build();
        this.http2Connection = r9;
        this.allocationLimit = Http2Connection.Companion.getDEFAULT_SETTINGS().getMaxConcurrentStreams();
        Http2Connection.start$default(r9, false, null, 3, null);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    private final void connectTls(ConnectionSpecSelector r11) throws IOException {
        final Address r2 = this.route.address();
        SSLSocketFactory r3 = r2.sslSocketFactory();
        SSLSocket r4 = null;
        String r5 = null;
        Intrinsics.checkNotNull(r3);     // Catch: Throwable -> L32
        Socket r6 = r3.createSocket(this.rawSocket, r2.url().host(), r2.url().port(), true);     // Catch: Throwable -> L32
        if (r6 == null) goto L31;
        SSLSocket r7 = (SSLSocket) r6;     // Catch: Throwable -> L32
        ConnectionSpec r12 = r11.configureSecureSocket(r7);     // Catch: Throwable -> L28
        if (r12.supportsTlsExtensions() == false) goto L9;
        Platform.Companion.get().configureTlsExtensions(r7, r2.url().host(), r2.protocols());     // Catch: Throwable -> L28
    L9:
        r7.startHandshake();     // Catch: Throwable -> L28
        SSLSession r8 = r7.getSession();     // Catch: Throwable -> L28
        Handshake.Companion r9 = Handshake.Companion;     // Catch: Throwable -> L28
        Intrinsics.checkNotNullExpressionValue(r8, "sslSocketSession");     // Catch: Throwable -> L28
        final Handshake r10 = r9.get(r8);     // Catch: Throwable -> L28
        HostnameVerifier r13 = r2.hostnameVerifier();     // Catch: Throwable -> L28
        Intrinsics.checkNotNull(r13);     // Catch: Throwable -> L28
        if (r13.verify(r2.url().host(), r8) == true) goto L17;
        List<Certificate> r14 = r10.peerCertificates();     // Catch: Throwable -> L28
        if ((!r14.isEmpty()) == false) goto L16;
        X509Certificate r15 = (X509Certificate) r14.get(0);     // Catch: Throwable -> L28
        throw new SSLPeerUnverifiedException(StringsKt.trimMargin$default("\n              |Hostname " + r2.url().host() + " not verified:\n              |    certificate: " + CertificatePinner.Companion.pin(r15) + "\n              |    DN: " + r15.getSubjectDN().getName() + "\n              |    subjectAltNames: " + OkHostnameVerifier.INSTANCE.allSubjectAltNames(r15) + "\n              ", null, 1, null));     // Catch: Throwable -> L28
    L16:
        throw new SSLPeerUnverifiedException("Hostname " + r2.url().host() + " not verified (no certificates)");     // Catch: Throwable -> L28
    L17:
        final CertificatePinner r0 = r2.certificatePinner();     // Catch: Throwable -> L28
        Intrinsics.checkNotNull(r0);     // Catch: Throwable -> L28
        this.handshake = new Handshake(r10.tlsVersion(), r10.cipherSuite(), r10.localCertificates(), new AnonymousClass1(r0, r10, r2));     // Catch: Throwable -> L28
        r0.check$okhttp(r2.url().host(), new AnonymousClass2(this));     // Catch: Throwable -> L28
        if (r12.supportsTlsExtensions() == false) goto L20;
        r5 = Platform.Companion.get().getSelectedProtocol(r7);     // Catch: Throwable -> L28
    L21:
        this.socket = r7;     // Catch: Throwable -> L28
        this.source = Okio.buffer(Okio.source(r7));     // Catch: Throwable -> L28
        this.sink = Okio.buffer(Okio.sink(r7));     // Catch: Throwable -> L28
        if (r5 == null) goto L24;
        Protocol r16 = Protocol.Companion.get(r5);     // Catch: Throwable -> L28
    L25:
        this.protocol = r16;     // Catch: Throwable -> L28
        Platform.Companion.get().afterHandshake(r7);
        return;
    L24:
        r16 = Protocol.HTTP_1_1;     // Catch: Throwable -> L28
        goto L25
    L20:
        String r17 = (String) null;     // Catch: Throwable -> L28
    L28:
        th = th;
        r4 = r7;
    L33:
        if (r4 == null) goto L35;
        Platform.Companion.get().afterHandshake(r4);
    L35:
        if (r4 == null) goto L38;
        Util.closeQuietly(r4);
    L38:
        throw th;
    L31:
        throw new NullPointerException("null cannot be cast to non-null type javax.net.ssl.SSLSocket");     // Catch: Throwable -> L32
    L32:
        th = th;
        goto L33
    }

    private final Request createTunnel(int r10, int r11, Request r12, HttpUrl r13) throws IOException {
        String r14 = "CONNECT " + Util.toHostHeader(r13, true) + " HTTP/1.1";
    L3:
        BufferedSource r0 = this.source;
        Intrinsics.checkNotNull(r0);
        BufferedSink r2 = this.sink;
        Intrinsics.checkNotNull(r2);
        Http1ExchangeCodec r3 = new Http1ExchangeCodec(null, this, r0, r2);
        r0.timeout().timeout(r10, TimeUnit.MILLISECONDS);
        r2.timeout().timeout(r11, TimeUnit.MILLISECONDS);
        r3.writeRequest(r12.headers(), r14);
        r3.finishRequest();
        Response.Builder r5 = r3.readResponseHeaders(false);
        Intrinsics.checkNotNull(r5);
        Response r15 = r5.request(r12).build();
        r3.skipConnectBody(r15);
        int r4 = r15.code();
        if (r4 == 200) goto L18;
        if (r4 != 407) goto L16;
        Request r1 = this.route.address().proxyAuthenticator().authenticate(this.route, r15);
        if (r1 == null) goto L14;
        if (StringsKt.equals("close", Response.header$default(r15, "Connection", null, 2, null), true) == true) goto L11;
        r12 = r1;
        goto L3
    L11:
        return r1;
    L14:
        throw new IOException("Failed to authenticate with proxy");
    L16:
        throw new IOException(Intrinsics.stringPlus("Unexpected response code for CONNECT: ", Integer.valueOf(r15.code())));
    L18:
        if (r0.getBuffer().exhausted() == false) goto L23;
        if (r2.getBuffer().exhausted() == false) goto L23;
        return null;
    L23:
        throw new IOException("TLS tunnel buffered too many bytes!");
    }

    private final Request createTunnelRequest() throws IOException {
        Request r0 = new Request.Builder().url(this.route.address().url()).method("CONNECT", null).header("Host", Util.toHostHeader(this.route.address().url(), true)).header("Proxy-Connection", "Keep-Alive").header("User-Agent", Util.userAgent).build();
        Response r1 = new Response.Builder().request(r0).protocol(Protocol.HTTP_1_1).code(407).message("Preemptive Authenticate").body(Util.EMPTY_RESPONSE).sentRequestAtMillis(-1).receivedResponseAtMillis(-1).header("Proxy-Authenticate", "OkHttp-Preemptive").build();
        Request r4 = this.route.address().proxyAuthenticator().authenticate(this.route, r1);
        if (r4 != null) goto L6;
        return r0;
    L6:
        return r4;
    }

    private final boolean routeMatchesAny(List<Route> r6) {
        List<Route> r7 = r6;
        if ((r7 instanceof Collection) == true) goto L5;
    L7:
        Iterator<T> r8 = r7.iterator();
    L9:
        if (r8.hasNext() == false) goto L27;
        Route r0 = (Route) r8.next();
        if (r0.proxy().type() == Proxy.Type.DIRECT) goto L13;
    L17:
        boolean r1 = false;
    L18:
        if (r1 == false) goto L9;
        return true;
    L13:
        if (this.route.proxy().type() != Proxy.Type.DIRECT) goto L17;
        if (Intrinsics.areEqual(this.route.socketAddress(), r0.socketAddress()) == false) goto L17;
        r1 = true;
        goto L18
    L27:
        return false;
    L5:
        if (r7.isEmpty() == false) goto L7;
        return false;
    }

    private final boolean certificateSupportHost(HttpUrl r3, Handshake r4) {
        List<Certificate> r2 = r4.peerCertificates();
        if ((!r2.isEmpty()) == false) goto L8;
        if (OkHostnameVerifier.INSTANCE.verify(r3.host(), (X509Certificate) r2.get(0)) == false) goto L8;
        return true;
    L8:
        return false;
    }

    public final ExchangeCodec newCodec$okhttp(OkHttpClient r7, RealInterceptorChain r8) throws SocketException {
        Intrinsics.checkNotNullParameter(r7, DeviceInfoProvider.CLIENT);
        Intrinsics.checkNotNullParameter(r8, "chain");
        Socket r0 = this.socket;
        Intrinsics.checkNotNull(r0);
        BufferedSource r1 = this.source;
        Intrinsics.checkNotNull(r1);
        BufferedSink r2 = this.sink;
        Intrinsics.checkNotNull(r2);
        Http2Connection r3 = this.http2Connection;
        if (r3 != null) goto L7;
        r0.setSoTimeout(r8.readTimeoutMillis());
        r1.timeout().timeout(r8.getReadTimeoutMillis$okhttp(), TimeUnit.MILLISECONDS);
        r2.timeout().timeout(r8.getWriteTimeoutMillis$okhttp(), TimeUnit.MILLISECONDS);
        return new Http1ExchangeCodec(r7, this, r1, r2);
    L7:
        return new Http2ExchangeCodec(r7, this, r8, r3);
    }

    public final RealWebSocket.Streams newWebSocketStreams$okhttp(final Exchange r5) throws SocketException {
        Intrinsics.checkNotNullParameter(r5, "exchange");
        Socket r0 = this.socket;
        Intrinsics.checkNotNull(r0);
        final BufferedSource r1 = this.source;
        Intrinsics.checkNotNull(r1);
        final BufferedSink r2 = this.sink;
        Intrinsics.checkNotNull(r2);
        r0.setSoTimeout(0);
        noNewExchanges$okhttp();
        return new RealConnection$newWebSocketStreams$1(r1, r2, r5);
    }

    @Override // okhttp3.Connection
    public Route route() {
        return this.route;
    }

    public final void cancel() {
        Socket r0 = this.rawSocket;
        if (r0 == null) goto L7;
        Util.closeQuietly(r0);
        return;
    }

    @Override // okhttp3.Connection
    public Socket socket() {
        Socket r0 = this.socket;
        Intrinsics.checkNotNull(r0);
        return r0;
    }

    @Override // okhttp3.internal.http2.Http2Connection.Listener
    public void onStream(Http2Stream r2) throws IOException {
        Intrinsics.checkNotNullParameter(r2, CozeCloudExt.API_KEY_HTTP_STREAM_METHOD);
        r2.close(ErrorCode.REFUSED_STREAM, null);
    }

    @Override // okhttp3.internal.http2.Http2Connection.Listener
    public synchronized void onSettings(Http2Connection r2, Settings r3) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r2, WsConstants.KEY_CONNECTION);     // Catch: Throwable -> L6
        Intrinsics.checkNotNullParameter(r3, "settings");     // Catch: Throwable -> L6
        this.allocationLimit = r3.getMaxConcurrentStreams();     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // okhttp3.Connection
    public Handshake handshake() {
        return this.handshake;
    }

    public final void connectFailed$okhttp(OkHttpClient r3, Route r4, IOException r5) {
        Intrinsics.checkNotNullParameter(r3, DeviceInfoProvider.CLIENT);
        Intrinsics.checkNotNullParameter(r4, "failedRoute");
        Intrinsics.checkNotNullParameter(r5, "failure");
        if (r4.proxy().type() == Proxy.Type.DIRECT) goto L5;
        Address r2 = r4.address();
        r2.proxySelector().connectFailed(r2.url().uri(), r4.proxy().address(), r5);
    L5:
        r3.getRouteDatabase().failed(r4);
    }

    public final synchronized void trackFailure$okhttp(RealCall r4, IOException r5) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r4, NotificationCompat.CATEGORY_CALL);     // Catch: Throwable -> L27
        if ((r5 instanceof StreamResetException) == false) goto L17;
        if (((StreamResetException) r5).errorCode != ErrorCode.REFUSED_STREAM) goto L11;
        int r6 = this.refusedStreamCount + 1;     // Catch: Throwable -> L27
        this.refusedStreamCount = r6;     // Catch: Throwable -> L27
        if (r6 <= 1) goto L25;
        this.noNewExchanges = true;     // Catch: Throwable -> L27
        this.routeFailureCount++;     // Catch: Throwable -> L27
    L25:
        monitor-exit(this);
        return;
    L11:
        if (((StreamResetException) r5).errorCode == ErrorCode.CANCEL) goto L13;
    L15:
        this.noNewExchanges = true;     // Catch: Throwable -> L27
        this.routeFailureCount++;     // Catch: Throwable -> L27
        goto L25
    L13:
        if (r4.isCanceled() == false) goto L15;
    L17:
        if (isMultiplexed$okhttp() == true) goto L19;
    L20:
        this.noNewExchanges = true;     // Catch: Throwable -> L27
        if (this.successCount != 0) goto L25;
        if (r5 == null) goto L24;
        connectFailed$okhttp(r4.getClient(), this.route, r5);     // Catch: Throwable -> L27
    L24:
        this.routeFailureCount++;     // Catch: Throwable -> L27
        goto L25
    L19:
        if ((r5 instanceof ConnectionShutdownException) == false) goto L25;
    L27:
        th = move-exception;
        throw th;
    }

    @Override // okhttp3.Connection
    public Protocol protocol() {
        Protocol r0 = this.protocol;
        Intrinsics.checkNotNull(r0);
        return r0;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder("Connection{").append(this.route.address().url().host()).append(AccessibilityUtils.ENABLED_ACCESSIBILITY_SERVICES_SEPARATOR).append(this.route.address().url().port()).append(", proxy=").append(this.route.proxy()).append(" hostAddress=").append(this.route.socketAddress()).append(" cipherSuite=");
        Handshake r1 = this.handshake;
        Object r2 = "none";
        if (r1 == null) goto L10;
        CipherSuite r3 = r1.cipherSuite();
        if (r3 == null) goto L10;
        r2 = r3;
    L10:
        return r0.append(r2).append(" protocol=").append(this.protocol).append('}').toString();
    }

    public final boolean isEligible$okhttp(Address r4, List<Route> r5) {
        Intrinsics.checkNotNullParameter(r4, "address");
        if (Util.assertionsEnabled == false) goto L10;
        if (Thread.holdsLock(this) == true) goto L10;
        throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + this);
    L10:
        if (this.calls.size() < this.allocationLimit) goto L12;
    L35:
        return false;
    L12:
        if (this.noNewExchanges == true) goto L35;
        if (this.route.address().equalsNonHost$okhttp(r4) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(r4.url().host(), route().address().url().host()) == false) goto L21;
        return true;
    L21:
        if (this.http2Connection != null) goto L23;
        return false;
    L23:
        if (r5 == null) goto L35;
        if (routeMatchesAny(r5) == false) goto L35;
        if (r4.hostnameVerifier() == OkHostnameVerifier.INSTANCE) goto L31;
        return false;
    L31:
        if (supportsUrl(r4.url()) == true) goto L37;
        return false;
    L37:
        CertificatePinner r6 = r4.certificatePinner();     // Catch: SSLPeerUnverifiedException -> L36
        Intrinsics.checkNotNull(r6);     // Catch: SSLPeerUnverifiedException -> L36
        String r7 = r4.url().host();     // Catch: SSLPeerUnverifiedException -> L36
        Handshake r3 = handshake();     // Catch: SSLPeerUnverifiedException -> L36
        Intrinsics.checkNotNull(r3);     // Catch: SSLPeerUnverifiedException -> L36
        r6.check(r7, r3.peerCertificates());     // Catch: SSLPeerUnverifiedException -> L36
        return true;
    }

    private final boolean supportsUrl(HttpUrl r5) {
        if (Util.assertionsEnabled == true) goto L5;
    L9:
        HttpUrl r0 = this.route.address().url();
        if (r5.port() == r0.port()) goto L13;
        return false;
    L13:
        if (Intrinsics.areEqual(r5.host(), r0.host()) == false) goto L16;
        return true;
    L16:
        if (this.noCoalescedConnections == true) goto L23;
        Handshake r1 = this.handshake;
        if (r1 == null) goto L24;
        Intrinsics.checkNotNull(r1);
        if (certificateSupportHost(r5, r1) == true) goto L22;
        return false;
    L22:
        return true;
    L24:
        return false;
    L23:
        return false;
    L5:
        if (Thread.holdsLock(this) == true) goto L9;
        throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + this);
    }

    public final boolean isHealthy(boolean r8) {
        if (Util.assertionsEnabled == true) goto L5;
    L9:
        long r0 = System.nanoTime();
        Socket r2 = this.rawSocket;
        Intrinsics.checkNotNull(r2);
        Socket r3 = this.socket;
        Intrinsics.checkNotNull(r3);
        BufferedSource r4 = this.source;
        Intrinsics.checkNotNull(r4);
        if (r2.isClosed() == false) goto L12;
        return false;
    L12:
        if (r3.isClosed() == false) goto L14;
        return false;
    L14:
        if (r3.isInputShutdown() == false) goto L16;
        return false;
    L16:
        if (r3.isOutputShutdown() == true) goto L43;
        Http2Connection r5 = this.http2Connection;
        if (r5 != null) goto L21;
        monitor-enter(this);
        long r1 = r0 - getIdleAtNs$okhttp();
        monitor-exit(this);
        if (r1 < IDLE_CONNECTION_HEALTHY_NS) goto L31;
        if (r8 == true) goto L30;
        return true;
    L30:
        return Util.isHealthy(r3, r4);
    L31:
        return true;
    L33:
        th = move-exception;
        throw th;
    L21:
        return r5.isHealthy(r0);
    L43:
        return false;
    L5:
        if (Thread.holdsLock(this) == false) goto L9;
        throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + this);
    }
}
