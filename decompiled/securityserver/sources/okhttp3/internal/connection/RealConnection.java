package okhttp3.internal.connection;

import a.a;
import androidx.core.app.NotificationCompat;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.frameworks.baselib.network.http.util.HttpStatus;
import com.monitor.cloudmessage.consts.CloudControlInf;
import com.ss.android.http.legacy.protocol.HTTP;
import io.reactivex.annotations.SchedulerSupport;
import java.io.IOException;
import java.lang.ref.Reference;
import java.net.ConnectException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.Socket;
import java.net.UnknownServiceException;
import java.security.Principal;
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
import okio.Timeout;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class RealConnection extends Http2Connection.Listener implements Connection {
    public static final Companion Companion = null;
    public static final long IDLE_CONNECTION_HEALTHY_NS = 10000000000L;
    private static final int MAX_TUNNEL_ATTEMPTS = 21;
    private static final String NPE_THROW_WITH_NULL = "throw with null exception";
    private int allocationLimit;

    @NotNull
    private final List<Reference<RealCall>> calls;

    @NotNull
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

    @Metadata
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final RealConnection newTestConnection(@NotNull RealConnectionPool r1, @NotNull Route r2, @NotNull Socket r3, long r4) {
            Intrinsics.f(r1, "connectionPool");
            Intrinsics.f(r2, CloudControlInf.ROUTE);
            Intrinsics.f(r3, "socket");
            RealConnection r0 = new RealConnection(r1, r2);
            RealConnection.access$setSocket$p(r0, r3);
            r0.setIdleAtNs$okhttp(r4);
            return r0;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r0 = new int[Proxy.Type.values().length];
            $EnumSwitchMapping$0 = r0;
            r0[Proxy.Type.DIRECT.ordinal()] = 1;
            r0[Proxy.Type.HTTP.ordinal()] = 2;
        }
    }

    static {
        Companion = new Companion(null);
    }

    public RealConnection(@NotNull RealConnectionPool r2, @NotNull Route r3) {
        Intrinsics.f(r2, "connectionPool");
        Intrinsics.f(r3, CloudControlInf.ROUTE);
        this.connectionPool = r2;
        this.route = r3;
        this.allocationLimit = 1;
        this.calls = new ArrayList();
        this.idleAtNs = Long.MAX_VALUE;
    }

    public static final /* synthetic */ Handshake access$getHandshake$p(RealConnection r0) {
        return r0.handshake;
    }

    public static final /* synthetic */ Socket access$getSocket$p(RealConnection r0) {
        return r0.socket;
    }

    public static final /* synthetic */ void access$setHandshake$p(RealConnection r0, Handshake r1) {
        r0.handshake = r1;
    }

    public static final /* synthetic */ void access$setSocket$p(RealConnection r0, Socket r1) {
        r0.socket = r1;
    }

    private final boolean certificateSupportHost(HttpUrl r3, Handshake r4) {
        List<Certificate> r2 = r4.peerCertificates();
        if ((!r2.isEmpty()) == false) goto L12;
        OkHostnameVerifier r5 = OkHostnameVerifier.INSTANCE;
        String r6 = r3.host();
        Certificate r7 = r2.get(0);
        if (r7 == null) goto L10;
        if (r5.verify(r6, (X509Certificate) r7) == false) goto L12;
        return true;
    L10:
        throw new NullPointerException("null cannot be cast to non-null type java.security.cert.X509Certificate");
    L12:
        return false;
    }

    private final void connectSocket(int r5, int r6, Call r7, EventListener r8) {
        Proxy r0 = this.route.proxy();
        Address r1 = this.route.address();
        Proxy.Type r2 = r0.type();
        if (r2 == null) goto L9;
        int r3 = WhenMappings.$EnumSwitchMapping$0[r2.ordinal()];
        if (r3 != 1) goto L8;
    L10:
        Socket r4 = r1.socketFactory().createSocket();
        Intrinsics.c(r4);
    L11:
        this.rawSocket = r4;
        r8.connectStart(r7, this.route.socketAddress(), r0);
        r4.setSoTimeout(r6);
        Platform.Companion.get().connectSocket(r4, this.route.socketAddress(), r5);     // Catch: ConnectException -> L21
        this.source = Okio.buffer(Okio.source(r4));     // Catch: NullPointerException -> L15
        this.sink = Okio.buffer(Okio.sink(r4));     // Catch: NullPointerException -> L15
        return;
    L15:
        e = move-exception;
        if (Intrinsics.a(e.getMessage(), NPE_THROW_WITH_NULL) == true) goto L20;
        return;
    L20:
        throw new IOException(e);
    L21:
        e = move-exception;
        ConnectException r9 = new ConnectException("Failed to connect to " + this.route.socketAddress());
        r9.initCause(e);
        throw r9;
    L8:
        if (r3 == 2) goto L10;
    L9:
        r4 = new Socket(r0);
        goto L11
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
    private final void connectTls(ConnectionSpecSelector r11) {
        final Address r2 = this.route.address();
        SSLSocketFactory r3 = r2.sslSocketFactory();
        SSLSocket r4 = null;
        String r5 = null;
        Intrinsics.c(r3);     // Catch: Throwable -> L33
        Socket r6 = r3.createSocket(this.rawSocket, r2.url().host(), r2.url().port(), true);     // Catch: Throwable -> L33
        if (r6 == null) goto L36;
        SSLSocket r7 = (SSLSocket) r6;     // Catch: Throwable -> L33
        ConnectionSpec r12 = r11.configureSecureSocket(r7);     // Catch: Throwable -> L9
        if (r12.supportsTlsExtensions() == false) goto L11;
        Platform.Companion.get().configureTlsExtensions(r7, r2.url().host(), r2.protocols());     // Catch: Throwable -> L9
    L11:
        r7.startHandshake();     // Catch: Throwable -> L9
        SSLSession r8 = r7.getSession();     // Catch: Throwable -> L9
        Handshake.Companion r9 = Handshake.Companion;     // Catch: Throwable -> L9
        Intrinsics.e(r8, "sslSocketSession");     // Catch: Throwable -> L9
        final Handshake r10 = r9.get(r8);     // Catch: Throwable -> L9
        HostnameVerifier r13 = r2.hostnameVerifier();     // Catch: Throwable -> L9
        Intrinsics.c(r13);     // Catch: Throwable -> L9
        if (r13.verify(r2.url().host(), r8) == true) goto L23;
        List<Certificate> r14 = r10.peerCertificates();     // Catch: Throwable -> L9
        if ((!r14.isEmpty()) == false) goto L22;
        Certificate r15 = r14.get(0);     // Catch: Throwable -> L9
        if (r15 == null) goto L18;
        X509Certificate r16 = (X509Certificate) r15;     // Catch: Throwable -> L9
        StringBuilder r0 = new StringBuilder("\n              |Hostname ");     // Catch: Throwable -> L9
        r0.append(r2.url().host());     // Catch: Throwable -> L9
        r0.append(" not verified:\n              |    certificate: ");     // Catch: Throwable -> L9
        r0.append(CertificatePinner.Companion.pin(r16));     // Catch: Throwable -> L9
        r0.append("\n              |    DN: ");     // Catch: Throwable -> L9
        Principal r1 = r16.getSubjectDN();     // Catch: Throwable -> L9
        Intrinsics.e(r1, "cert.subjectDN");     // Catch: Throwable -> L9
        r0.append(r1.getName());     // Catch: Throwable -> L9
        r0.append("\n              |    subjectAltNames: ");     // Catch: Throwable -> L9
        r0.append(OkHostnameVerifier.INSTANCE.allSubjectAltNames(r16));     // Catch: Throwable -> L9
        r0.append("\n              ");     // Catch: Throwable -> L9
        throw new SSLPeerUnverifiedException(StringsKt.L(r0.toString()));     // Catch: Throwable -> L9
    L18:
        throw new NullPointerException("null cannot be cast to non-null type java.security.cert.X509Certificate");     // Catch: Throwable -> L9
    L22:
        throw new SSLPeerUnverifiedException("Hostname " + r2.url().host() + " not verified (no certificates)");     // Catch: Throwable -> L9
    L23:
        final CertificatePinner r17 = r2.certificatePinner();     // Catch: Throwable -> L9
        Intrinsics.c(r17);     // Catch: Throwable -> L9
        this.handshake = new Handshake(r10.tlsVersion(), r10.cipherSuite(), r10.localCertificates(), new AnonymousClass1(r17, r10, r2));     // Catch: Throwable -> L9
        r17.check$okhttp(r2.url().host(), new AnonymousClass2(this));     // Catch: Throwable -> L9
        if (r12.supportsTlsExtensions() == false) goto L26;
        r5 = Platform.Companion.get().getSelectedProtocol(r7);     // Catch: Throwable -> L9
    L26:
        this.socket = r7;     // Catch: Throwable -> L9
        this.source = Okio.buffer(Okio.source(r7));     // Catch: Throwable -> L9
        this.sink = Okio.buffer(Okio.sink(r7));     // Catch: Throwable -> L9
        if (r5 == null) goto L29;
        Protocol r18 = Protocol.Companion.get(r5);     // Catch: Throwable -> L9
    L30:
        this.protocol = r18;     // Catch: Throwable -> L9
        Platform.Companion.get().afterHandshake(r7);
        return;
    L29:
        r18 = Protocol.HTTP_1_1;     // Catch: Throwable -> L9
    L9:
        th = th;
        r4 = r7;
    L37:
        if (r4 == null) goto L39;
        Platform.Companion.get().afterHandshake(r4);
    L39:
        if (r4 == null) goto L41;
        Util.closeQuietly(r4);
    L41:
        throw th;
    L36:
        throw new NullPointerException("null cannot be cast to non-null type javax.net.ssl.SSLSocket");     // Catch: Throwable -> L33
    L33:
        th = th;
        goto L37
    }

    private final void connectTunnel(int r7, int r8, int r9, Call r10, EventListener r11) {
        Request r0 = createTunnelRequest();
        HttpUrl r1 = r0.url();
        int r2 = 0;
    L4:
        if (r2 >= 21) goto L11;
        connectSocket(r7, r8, r10, r11);
        r0 = createTunnel(r8, r9, r0, r1);
        if (r0 == null) goto L16;
        Socket r3 = this.rawSocket;
        if (r3 == null) goto L10;
        Util.closeQuietly(r3);
    L10:
        this.rawSocket = null;
        this.sink = null;
        this.source = null;
        r11.connectEnd(r10, this.route.socketAddress(), this.route.proxy(), null);
        r2 = r2 + 1;
        goto L4
    L16:
        return;
    }

    private final Request createTunnel(int r9, int r10, Request r11, HttpUrl r12) {
        String r13 = "CONNECT " + Util.toHostHeader(r12, true) + " HTTP/1.1";
    L3:
        BufferedSource r0 = this.source;
        Intrinsics.c(r0);
        BufferedSink r1 = this.sink;
        Intrinsics.c(r1);
        Http1ExchangeCodec r2 = new Http1ExchangeCodec(null, this, r0, r1);
        TimeUnit r7 = TimeUnit.MILLISECONDS;
        r0.timeout().timeout(r9, r7);
        r1.timeout().timeout(r10, r7);
        r2.writeRequest(r11.headers(), r13);
        r2.finishRequest();
        Response.Builder r4 = r2.readResponseHeaders(false);
        Intrinsics.c(r4);
        Response r14 = r4.request(r11).build();
        r2.skipConnectBody(r14);
        int r3 = r14.code();
        if (r3 == 200) goto L18;
        if (r3 != 407) goto L16;
        Request r5 = this.route.address().proxyAuthenticator().authenticate(this.route, r14);
        if (r5 == null) goto L14;
        if ("close".equalsIgnoreCase(Response.header$default(r14, HTTP.CONN_DIRECTIVE, null, 2, null)) == true) goto L11;
        r11 = r5;
        goto L3
    L11:
        return r5;
    L14:
        throw new IOException("Failed to authenticate with proxy");
    L16:
        throw new IOException("Unexpected response code for CONNECT: " + r14.code());
    L18:
        if (r0.getBuffer().exhausted() == false) goto L23;
        if (r1.getBuffer().exhausted() == false) goto L23;
        return null;
    L23:
        throw new IOException("TLS tunnel buffered too many bytes!");
    }

    private final Request createTunnelRequest() {
        Request r0 = new Request.Builder().url(this.route.address().url()).method("CONNECT", null).header(HTTP.TARGET_HOST, Util.toHostHeader(this.route.address().url(), true)).header("Proxy-Connection", HTTP.CONN_KEEP_ALIVE).header("User-Agent", Util.userAgent).build();
        Response r1 = new Response.Builder().request(r0).protocol(Protocol.HTTP_1_1).code(HttpStatus.SC_PROXY_AUTHENTICATION_REQUIRED).message("Preemptive Authenticate").body(Util.EMPTY_RESPONSE).sentRequestAtMillis(-1).receivedResponseAtMillis(-1).header("Proxy-Authenticate", "OkHttp-Preemptive").build();
        Request r4 = this.route.address().proxyAuthenticator().authenticate(this.route, r1);
        if (r4 != null) goto L5;
        return r0;
    L5:
        return r4;
    }

    private final void establishProtocol(ConnectionSpecSelector r2, int r3, Call r4, EventListener r5) {
        if (this.route.address().sslSocketFactory() != null) goto L10;
        List<Protocol> r6 = this.route.address().protocols();
        Protocol r7 = Protocol.H2_PRIOR_KNOWLEDGE;
        if (r6.contains(r7) == false) goto L8;
        this.socket = this.rawSocket;
        this.protocol = r7;
        startHttp2(r3);
        return;
    L8:
        this.socket = this.rawSocket;
        this.protocol = Protocol.HTTP_1_1;
        return;
    L10:
        r5.secureConnectStart(r4);
        connectTls(r2);
        r5.secureConnectEnd(r4, this.handshake);
        if (this.protocol != Protocol.HTTP_2) goto L14;
        startHttp2(r3);
        return;
    }

    private final boolean routeMatchesAny(List<Route> r5) {
        if ((r5 instanceof Collection) == true) goto L5;
    L7:
        Iterator<T> r6 = r5.iterator();
    L9:
        if (r6.hasNext() == false) goto L27;
        Route r0 = (Route) r6.next();
        Proxy.Type r2 = r0.proxy().type();
        Proxy.Type r3 = Proxy.Type.DIRECT;
        if (r2 != r3) goto L9;
        if (this.route.proxy().type() != r3) goto L9;
        if (Intrinsics.a(this.route.socketAddress(), r0.socketAddress()) == false) goto L9;
        return true;
    L27:
        return false;
    L5:
        if (r5.isEmpty() == false) goto L7;
        return false;
    }

    private final void startHttp2(int r8) {
        Socket r0 = this.socket;
        Intrinsics.c(r0);
        BufferedSource r1 = this.source;
        Intrinsics.c(r1);
        BufferedSink r2 = this.sink;
        Intrinsics.c(r2);
        r0.setSoTimeout(0);
        Http2Connection r9 = new Http2Connection.Builder(true, TaskRunner.INSTANCE).socket(r0, this.route.address().url().host(), r1, r2).listener(this).pingIntervalMillis(r8).build();
        this.http2Connection = r9;
        this.allocationLimit = Http2Connection.Companion.getDEFAULT_SETTINGS().getMaxConcurrentStreams();
        Http2Connection.start$default(r9, false, null, 3, null);
    }

    private final boolean supportsUrl(HttpUrl r5) {
        if (Util.assertionsEnabled == true) goto L5;
    L9:
        HttpUrl r0 = this.route.address().url();
        if (r5.port() == r0.port()) goto L13;
        return false;
    L13:
        if (Intrinsics.a(r5.host(), r0.host()) == false) goto L16;
        return true;
    L16:
        if (this.noCoalescedConnections == true) goto L23;
        Handshake r1 = this.handshake;
        if (r1 == null) goto L24;
        Intrinsics.c(r1);
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
        StringBuilder r2 = new StringBuilder("Thread ");
        Thread r3 = Thread.currentThread();
        Intrinsics.e(r3, "Thread.currentThread()");
        r2.append(r3.getName());
        r2.append(" MUST hold lock on ");
        r2.append(this);
        throw new AssertionError(r2.toString());
    }

    public final void cancel() {
        Socket r0 = this.rawSocket;
        if (r0 == null) goto L6;
        Util.closeQuietly(r0);
        return;
    }

    public final void connect(int r17, int r18, int r19, int r20, boolean r21, @NotNull Call r22, @NotNull EventListener r23) {
        Intrinsics.f(r22, NotificationCompat.CATEGORY_CALL);
        Intrinsics.f(r23, "eventListener");
        if (this.protocol != null) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L66;
        List<ConnectionSpec> r1 = this.route.address().connectionSpecs();
        ConnectionSpecSelector r11 = new ConnectionSpecSelector(r1);
        if (this.route.address().sslSocketFactory() != null) goto L19;
        if (r1.contains(ConnectionSpec.CLEARTEXT) == false) goto L17;
        String r2 = this.route.address().url().host();
        if (Platform.Companion.get().isCleartextTrafficPermitted(r2) == false) goto L15;
    L20:
        RouteException r13 = null;
    L71:
    L28:
        e = e;
    L48:
        Socket r3 = this.socket;
        if (r3 == null) goto L51;
        Util.closeQuietly(r3);
    L51:
        Socket r4 = this.rawSocket;
        if (r4 == null) goto L54;
        Util.closeQuietly(r4);
    L54:
        this.socket = null;
        this.rawSocket = null;
        this.source = null;
        this.sink = null;
        this.handshake = null;
        this.protocol = null;
        this.http2Connection = null;
        this.allocationLimit = 1;
        r23.connectFailed(r22, this.route.socketAddress(), this.route.proxy(), null, e);
        if (r13 != null) goto L57;
        r13 = new RouteException(e);
    L58:
        if (r21 == false) goto L62;
        if (r11.connectionFailed(e) == true) goto L71;
        throw r13;
    L62:
        throw r13;
    L57:
        r13.addConnectException(e);
        goto L58
    L22:
        if (this.route.requiresTunnel() == false) goto L67;
        connectTunnel(r17, r18, r19, r22, r23);     // Catch: IOException -> L28
        if (this.rawSocket == null) goto L36;
    L69:
        establishProtocol(r11, r20, r22, r23);     // Catch: IOException -> L44
        r23.connectEnd(r22, this.route.socketAddress(), this.route.proxy(), this.protocol);     // Catch: IOException -> L44
    L44:
        e = e;
    L36:
        if (this.route.requiresTunnel() == true) goto L38;
    L42:
        this.idleAtNs = System.nanoTime();
        return;
    L38:
        if (this.rawSocket != null) goto L42;
        throw new RouteException(new ProtocolException("Too many tunnel connections attempted: 21"));
    L67:
        connectSocket(r17, r18, r22, r23);     // Catch: IOException -> L46
    L46:
        e = e;
        goto L48
    L15:
        throw new RouteException(new UnknownServiceException(a.k("CLEARTEXT communication to ", r2, " not permitted by network security policy")));
    L17:
        throw new RouteException(new UnknownServiceException("CLEARTEXT communication not enabled for client"));
    L19:
        if (this.route.address().protocols().contains(Protocol.H2_PRIOR_KNOWLEDGE) == false) goto L20;
        throw new RouteException(new UnknownServiceException("H2_PRIOR_KNOWLEDGE cannot be used with HTTPS"));
    L66:
        throw new IllegalStateException("already connected".toString());
    L5:
        r0 = false;
        goto L6
    }

    public final void connectFailed$okhttp(@NotNull OkHttpClient r3, @NotNull Route r4, @NotNull IOException r5) {
        Intrinsics.f(r3, "client");
        Intrinsics.f(r4, "failedRoute");
        Intrinsics.f(r5, "failure");
        if (r4.proxy().type() == Proxy.Type.DIRECT) goto L5;
        Address r2 = r4.address();
        r2.proxySelector().connectFailed(r2.url().uri(), r4.proxy().address(), r5);
    L5:
        r3.getRouteDatabase().failed(r4);
    }

    @NotNull
    public final List<Reference<RealCall>> getCalls() {
        return this.calls;
    }

    @NotNull
    public final RealConnectionPool getConnectionPool() {
        return this.connectionPool;
    }

    public final long getIdleAtNs$okhttp() {
        return this.idleAtNs;
    }

    public final boolean getNoNewExchanges() {
        return this.noNewExchanges;
    }

    public final int getRouteFailureCount$okhttp() {
        return this.routeFailureCount;
    }

    @Override // okhttp3.Connection
    @Nullable
    public Handshake handshake() {
        return this.handshake;
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

    public final boolean isEligible$okhttp(@NotNull Address r4, @Nullable List<Route> r5) {
        Intrinsics.f(r4, "address");
        if (Util.assertionsEnabled == false) goto L10;
        if (Thread.holdsLock(this) == true) goto L10;
        StringBuilder r6 = new StringBuilder("Thread ");
        Thread r0 = Thread.currentThread();
        Intrinsics.e(r0, "Thread.currentThread()");
        r6.append(r0.getName());
        r6.append(" MUST hold lock on ");
        r6.append(this);
        throw new AssertionError(r6.toString());
    L10:
        if (this.calls.size() < this.allocationLimit) goto L12;
    L35:
        return false;
    L12:
        if (this.noNewExchanges == true) goto L35;
        if (this.route.address().equalsNonHost$okhttp(r4) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.a(r4.url().host(), route().address().url().host()) == false) goto L21;
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
        CertificatePinner r7 = r4.certificatePinner();     // Catch: SSLPeerUnverifiedException -> L36
        Intrinsics.c(r7);     // Catch: SSLPeerUnverifiedException -> L36
        String r8 = r4.url().host();     // Catch: SSLPeerUnverifiedException -> L36
        Handshake r3 = handshake();     // Catch: SSLPeerUnverifiedException -> L36
        Intrinsics.c(r3);     // Catch: SSLPeerUnverifiedException -> L36
        r7.check(r8, r3.peerCertificates());     // Catch: SSLPeerUnverifiedException -> L36
        return true;
    }

    public final boolean isHealthy(boolean r8) {
        if (Util.assertionsEnabled == true) goto L5;
    L9:
        long r0 = System.nanoTime();
        Socket r2 = this.rawSocket;
        Intrinsics.c(r2);
        Socket r3 = this.socket;
        Intrinsics.c(r3);
        BufferedSource r4 = this.source;
        Intrinsics.c(r4);
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
        long r1 = r0 - this.idleAtNs;
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
        StringBuilder r6 = new StringBuilder("Thread ");
        Thread r7 = Thread.currentThread();
        Intrinsics.e(r7, "Thread.currentThread()");
        r6.append(r7.getName());
        r6.append(" MUST NOT hold lock on ");
        r6.append(this);
        throw new AssertionError(r6.toString());
    }

    public final boolean isMultiplexed$okhttp() {
        if (this.http2Connection == null) goto L5;
        return true;
    L5:
        return false;
    }

    @NotNull
    public final ExchangeCodec newCodec$okhttp(@NotNull OkHttpClient r7, @NotNull RealInterceptorChain r8) {
        Intrinsics.f(r7, "client");
        Intrinsics.f(r8, "chain");
        Socket r0 = this.socket;
        Intrinsics.c(r0);
        BufferedSource r1 = this.source;
        Intrinsics.c(r1);
        BufferedSink r2 = this.sink;
        Intrinsics.c(r2);
        Http2Connection r3 = this.http2Connection;
        if (r3 != null) goto L7;
        r0.setSoTimeout(r8.readTimeoutMillis());
        Timeout r4 = r1.timeout();
        long r5 = r8.getReadTimeoutMillis$okhttp();
        TimeUnit r6 = TimeUnit.MILLISECONDS;
        r4.timeout(r5, r6);
        r2.timeout().timeout(r8.getWriteTimeoutMillis$okhttp(), r6);
        return new Http1ExchangeCodec(r7, this, r1, r2);
    L7:
        return new Http2ExchangeCodec(r7, this, r8, r3);
    }

    @NotNull
    public final RealWebSocket.Streams newWebSocketStreams$okhttp(@NotNull final Exchange r9) {
        Intrinsics.f(r9, "exchange");
        Socket r0 = this.socket;
        Intrinsics.c(r0);
        final BufferedSource r6 = this.source;
        Intrinsics.c(r6);
        final BufferedSink r7 = this.sink;
        Intrinsics.c(r7);
        r0.setSoTimeout(0);
        noNewExchanges$okhttp();
        final boolean r5 = true;
        return new RealConnection$newWebSocketStreams$1(r9, r6, r7, r5, r6, r7);
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

    public final synchronized void noNewExchanges$okhttp() {
        monitor-enter(this);
        this.noNewExchanges = true;     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // okhttp3.internal.http2.Http2Connection.Listener
    public synchronized void onSettings(@NotNull Http2Connection r2, @NotNull Settings r3) {
        monitor-enter(this);
        Intrinsics.f(r2, WsConstants.KEY_CONNECTION);     // Catch: Throwable -> L6
        Intrinsics.f(r3, "settings");     // Catch: Throwable -> L6
        this.allocationLimit = r3.getMaxConcurrentStreams();     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // okhttp3.internal.http2.Http2Connection.Listener
    public void onStream(@NotNull Http2Stream r2) {
        Intrinsics.f(r2, "stream");
        r2.close(ErrorCode.REFUSED_STREAM, null);
    }

    @Override // okhttp3.Connection
    @NotNull
    public Protocol protocol() {
        Protocol r0 = this.protocol;
        Intrinsics.c(r0);
        return r0;
    }

    @Override // okhttp3.Connection
    @NotNull
    public Route route() {
        return this.route;
    }

    public final void setIdleAtNs$okhttp(long r1) {
        this.idleAtNs = r1;
    }

    public final void setNoNewExchanges(boolean r1) {
        this.noNewExchanges = r1;
    }

    public final void setRouteFailureCount$okhttp(int r1) {
        this.routeFailureCount = r1;
    }

    @Override // okhttp3.Connection
    @NotNull
    public Socket socket() {
        Socket r0 = this.socket;
        Intrinsics.c(r0);
        return r0;
    }

    @NotNull
    public String toString() {
        StringBuilder r0 = new StringBuilder("Connection{");
        r0.append(this.route.address().url().host());
        r0.append(':');
        r0.append(this.route.address().url().port());
        r0.append(", proxy=");
        r0.append(this.route.proxy());
        r0.append(" hostAddress=");
        r0.append(this.route.socketAddress());
        r0.append(" cipherSuite=");
        Handshake r1 = this.handshake;
        if (r1 == null) goto L7;
        Object r2 = r1.cipherSuite();
        if (r2 == null) goto L7;
    L8:
        r0.append(r2);
        r0.append(" protocol=");
        r0.append(this.protocol);
        r0.append('}');
        return r0.toString();
    L7:
        r2 = SchedulerSupport.NONE;
        goto L8
    }

    public final synchronized void trackFailure$okhttp(@NotNull RealCall r4, @Nullable IOException r5) {
        monitor-enter(this);
        Intrinsics.f(r4, NotificationCompat.CATEGORY_CALL);     // Catch: Throwable -> L10
        if ((r5 instanceof StreamResetException) == false) goto L19;
        if (((StreamResetException) r5).errorCode != ErrorCode.REFUSED_STREAM) goto L13;
        int r6 = this.refusedStreamCount + 1;     // Catch: Throwable -> L10
        this.refusedStreamCount = r6;     // Catch: Throwable -> L10
        if (r6 <= 1) goto L27;
        this.noNewExchanges = true;     // Catch: Throwable -> L10
        this.routeFailureCount++;     // Catch: Throwable -> L10
    L27:
        monitor-exit(this);
        return;
    L13:
        if (((StreamResetException) r5).errorCode == ErrorCode.CANCEL) goto L15;
    L17:
        this.noNewExchanges = true;     // Catch: Throwable -> L10
        this.routeFailureCount++;     // Catch: Throwable -> L10
        goto L27
    L15:
        if (r4.isCanceled() == false) goto L17;
    L19:
        if (isMultiplexed$okhttp() == true) goto L21;
    L22:
        this.noNewExchanges = true;     // Catch: Throwable -> L10
        if (this.successCount != 0) goto L27;
        if (r5 == null) goto L26;
        connectFailed$okhttp(r4.getClient(), this.route, r5);     // Catch: Throwable -> L10
    L26:
        this.routeFailureCount++;     // Catch: Throwable -> L10
        goto L27
    L21:
        if ((r5 instanceof ConnectionShutdownException) == false) goto L27;
    L10:
        th = move-exception;
        throw th;
    }
}
