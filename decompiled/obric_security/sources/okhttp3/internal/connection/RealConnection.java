package okhttp3.internal.connection;

import com.bytedance.frameworks.baselib.network.http.util.HttpStatus;
import com.ss.android.http.legacy.protocol.HTTP;
import java.io.IOException;
import java.lang.ref.Reference;
import java.net.ConnectException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownServiceException;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import okhttp3.Address;
import okhttp3.Call;
import okhttp3.CertificatePinner;
import okhttp3.Connection;
import okhttp3.ConnectionPool;
import okhttp3.ConnectionSpec;
import okhttp3.EventListener;
import okhttp3.Handshake;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Route;
import okhttp3.internal.Internal;
import okhttp3.internal.Util;
import okhttp3.internal.Version;
import okhttp3.internal.http.HttpCodec;
import okhttp3.internal.http.HttpHeaders;
import okhttp3.internal.http1.Http1Codec;
import okhttp3.internal.http2.ErrorCode;
import okhttp3.internal.http2.Http2Codec;
import okhttp3.internal.http2.Http2Connection;
import okhttp3.internal.http2.Http2Stream;
import okhttp3.internal.platform.Platform;
import okhttp3.internal.tls.OkHostnameVerifier;
import okhttp3.internal.ws.RealWebSocket;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.Okio;
import okio.Source;

/* JADX INFO: loaded from: classes5.dex */
public final class RealConnection extends Http2Connection.Listener implements Connection {
    private static final int MAX_TUNNEL_ATTEMPTS = 21;
    private static final String NPE_THROW_WITH_NULL = "throw with null exception";
    public int allocationLimit;
    public final List<Reference<StreamAllocation>> allocations;
    private final ConnectionPool connectionPool;
    private Handshake handshake;
    private Http2Connection http2Connection;
    public long idleAtNanos;
    public boolean noNewStreams;
    private Protocol protocol;
    private Socket rawSocket;
    private final Route route;
    private BufferedSink sink;
    private Socket socket;
    private BufferedSource source;
    public int successCount;

    public RealConnection(ConnectionPool r3, Route r4) {
        this.allocationLimit = 1;
        this.allocations = new ArrayList();
        this.idleAtNanos = Long.MAX_VALUE;
        this.connectionPool = r3;
        this.route = r4;
    }

    public static RealConnection testConnection(ConnectionPool r1, Route r2, Socket r3, long r4) {
        RealConnection r0 = new RealConnection(r1, r2);
        r0.socket = r3;
        r0.idleAtNanos = r4;
        return r0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v0 */
    /* JADX WARN: Type inference failed for: r12v1, types: [java.net.Socket, okhttp3.Handshake, okhttp3.Protocol, okhttp3.internal.http2.Http2Connection, okio.BufferedSink, okio.BufferedSource] */
    /* JADX WARN: Type inference failed for: r12v3 */
    /* JADX WARN: Type inference failed for: r2v4 */
    public void connect(int r17, int r18, int r19, int r20, boolean r21, Call r22, EventListener r23) {
        if (this.protocol != null) goto L66;
        List<ConnectionSpec> r0 = this.route.address().connectionSpecs();
        ConnectionSpecSelector r13 = new ConnectionSpecSelector(r0);
        if (this.route.address().sslSocketFactory() != null) goto L16;
        if (r0.contains(ConnectionSpec.CLEARTEXT) == false) goto L14;
        String r1 = this.route.address().url().host();
        if (Platform.get().isCleartextTrafficPermitted(r1) == false) goto L12;
    L17:
        ?? r12 = 0;
        RouteException r11 = null;
    L69:
    L50:
        e = e;
    L53:
        Util.closeQuietly(this.socket);
        Util.closeQuietly(this.rawSocket);
        this.socket = r12;
        this.rawSocket = r12;
        this.source = r12;
        this.sink = r12;
        this.handshake = r12;
        this.protocol = r12;
        this.http2Connection = r12;
        r23.connectFailed(r22, this.route.socketAddress(), this.route.proxy(), null, e);
        RouteException r2 = r11;
        ?? r3 = r12;
        ConnectionSpecSelector r4 = r13;
        r23.connectFailed(r22, this.route.socketAddress(), this.route.proxy(), null, e, this.route.dnsInfoJson());
        if (r2 != null) goto L56;
        r2 = new RouteException(e);
    L57:
        r11 = r2;
        if (r21 == false) goto L62;
        if (r4.connectionFailed(e) == false) goto L80;
        r12 = r3;
        r13 = r4;
        goto L69
    L80:
        throw r11;
    L62:
        throw r11;
    L56:
        r2.addConnectException(e);
        goto L57
    L19:
        if (this.route.requiresTunnel() == false) goto L71;
        connectTunnel(r17, r18, r19, r22, r23);     // Catch: IOException -> L50
        if (this.rawSocket == null) goto L29;
    L73:
        establishProtocol(r13, r20, r22, r23);     // Catch: IOException -> L46
        r23.connectEnd(r22, this.route.socketAddress(), this.route.proxy(), this.protocol);     // Catch: IOException -> L46
    L46:
        e = e;
    L29:
        if (this.route.requiresTunnel() == false) goto L36;
        if (this.rawSocket != null) goto L36;
        throw new RouteException(new ProtocolException("Too many tunnel connections attempted: 21"));
    L36:
        if (this.http2Connection == null) goto L45;
        ConnectionPool r5 = this.connectionPool;
        monitor-enter(r5);
        this.allocationLimit = this.http2Connection.maxConcurrentStreams();     // Catch: Throwable -> L42
        monitor-exit(r5);     // Catch: Throwable -> L42
        return;
    L42:
        th = move-exception;
        throw th;
    L45:
        return;
    L71:
        connectSocket(r17, r18, r22, r23);     // Catch: IOException -> L48
    L48:
        e = e;
        goto L53
    L12:
        throw new RouteException(new UnknownServiceException("CLEARTEXT communication to " + r1 + " not permitted by network security policy"));
    L14:
        throw new RouteException(new UnknownServiceException("CLEARTEXT communication not enabled for client"));
    L16:
        if (this.route.address().protocols().contains(Protocol.H2_PRIOR_KNOWLEDGE) == false) goto L17;
        throw new RouteException(new UnknownServiceException("H2_PRIOR_KNOWLEDGE cannot be used with HTTPS"));
    L66:
        throw new IllegalStateException("already connected");
    }

    private void connectTunnel(int r7, int r8, int r9, Call r10, EventListener r11) throws IOException {
        Request r0 = createTunnelRequest();
        HttpUrl r1 = r0.url();
        int r2 = 0;
    L4:
        if (r2 >= 21) goto L9;
        connectSocket(r7, r8, r10, r11);
        r0 = createTunnel(r8, r9, r0, r1);
        if (r0 == null) goto L12;
        Util.closeQuietly(this.rawSocket);
        this.rawSocket = null;
        this.sink = null;
        this.source = null;
        r11.connectEnd(r10, this.route.socketAddress(), this.route.proxy(), null);
        r2 = r2 + 1;
        goto L4
    L12:
        return;
    }

    private void connectSocket(int r5, int r6, Call r7, EventListener r8) throws IOException {
        Proxy r0 = this.route.proxy();
        Address r1 = this.route.address();
        if (r0.type() != Proxy.Type.DIRECT) goto L5;
    L8:
        Socket r2 = r1.socketFactory().createSocket();
    L9:
        this.rawSocket = r2;
        r8.connectStart(r7, this.route.socketAddress(), r0);
        this.rawSocket.setSoTimeout(r6);
        Platform.get().connectSocket(this.rawSocket, this.route.socketAddress(), r5);     // Catch: ConnectException -> L19
        this.source = Okio.buffer(Okio.source(this.rawSocket));     // Catch: NullPointerException -> L13
        this.sink = Okio.buffer(Okio.sink(this.rawSocket));     // Catch: NullPointerException -> L13
        return;
    L13:
        e = move-exception;
        if (NPE_THROW_WITH_NULL.equals(e.getMessage()) == true) goto L18;
        return;
    L18:
        throw new IOException(e);
    L19:
        e = move-exception;
        ConnectException r9 = new ConnectException("Failed to connect to " + this.route.socketAddress());
        r9.initCause(e);
        throw r9;
    L5:
        if (r0.type() == Proxy.Type.HTTP) goto L8;
        r2 = new Socket(r0);
        goto L9
    }

    private void establishProtocol(ConnectionSpecSelector r2, int r3, Call r4, EventListener r5) throws IOException {
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

    private void startHttp2(int r6) throws IOException {
        this.socket.setSoTimeout(0);
        Http2Connection r7 = new Http2Connection.Builder(true).socket(this.socket, this.route.address().url().host(), this.source, this.sink).listener(this).pingIntervalMillis(r6).build();
        this.http2Connection = r7;
        r7.start();
    }

    private void connectTls(ConnectionSpecSelector r8) throws IOException {
        Address r0 = this.route.address();
        SSLSocket r2 = null;
        String r3 = null;
        SSLSocket r1 = (SSLSocket) r0.sslSocketFactory().createSocket(this.rawSocket, r0.url().host(), r0.url().port(), true);     // Catch: Throwable -> L32 AssertionError -> L34
        ConnectionSpec r9 = r8.configureSecureSocket(r1);     // Catch: Throwable -> L28 AssertionError -> L30
        if (r9.supportsTlsExtensions() == false) goto L7;
        Platform.get().configureTlsExtensions(r1, r0.url().host(), r0.protocols());     // Catch: Throwable -> L28 AssertionError -> L30
    L7:
        r1.startHandshake();     // Catch: Throwable -> L28 AssertionError -> L30
        SSLSession r4 = r1.getSession();     // Catch: Throwable -> L28 AssertionError -> L30
        Handshake r5 = Handshake.get(r4);     // Catch: Throwable -> L28 AssertionError -> L30
        if (r0.hostnameVerifier().verify(r0.url().host(), r4) == true) goto L17;
        List<Certificate> r7 = r5.peerCertificates();     // Catch: Throwable -> L28 AssertionError -> L30
        if (r7.isEmpty() == true) goto L16;
        X509Certificate r10 = (X509Certificate) r7.get(0);     // Catch: Throwable -> L28 AssertionError -> L30
        throw new SSLPeerUnverifiedException("Hostname " + r0.url().host() + " not verified:\n    certificate: " + CertificatePinner.pin(r10) + "\n    DN: " + r10.getSubjectDN().getName() + "\n    subjectAltNames: " + OkHostnameVerifier.allSubjectAltNames(r10));     // Catch: Throwable -> L28 AssertionError -> L30
    L16:
        throw new SSLPeerUnverifiedException("Hostname " + r0.url().host() + " not verified (no certificates)");     // Catch: Throwable -> L28 AssertionError -> L30
    L17:
        r0.certificatePinner().check(r0.url().host(), r5.peerCertificates());     // Catch: Throwable -> L28 AssertionError -> L30
        if (r9.supportsTlsExtensions() == false) goto L20;
        r3 = Platform.get().getSelectedProtocol(r1);     // Catch: Throwable -> L28 AssertionError -> L30
    L20:
        this.socket = r1;     // Catch: Throwable -> L28 AssertionError -> L30
        this.source = Okio.buffer(Okio.source(r1));     // Catch: Throwable -> L28 AssertionError -> L30
        this.sink = Okio.buffer(Okio.sink(this.socket));     // Catch: Throwable -> L28 AssertionError -> L30
        this.handshake = r5;     // Catch: Throwable -> L28 AssertionError -> L30
        if (r3 == null) goto L23;
        Protocol r11 = Protocol.get(r3);     // Catch: Throwable -> L28 AssertionError -> L30
    L24:
        this.protocol = r11;     // Catch: Throwable -> L28 AssertionError -> L30
        if (r1 == null) goto L47;
        Platform.get().afterHandshake(r1);
        return;
    L47:
        return;
    L23:
        r11 = Protocol.HTTP_1_1;     // Catch: Throwable -> L28 AssertionError -> L30
    L30:
        e = e;
    L36:
        if (Util.isAndroidGetsocknameError(e) == true) goto L38;
        throw e;     // Catch: Throwable -> L32
    L38:
        throw new IOException(e);     // Catch: Throwable -> L32
    L28:
        th = th;
        r2 = r1;
    L40:
        if (r2 == null) goto L42;
        Platform.get().afterHandshake(r2);
    L42:
        Util.closeQuietly(r2);
        throw th;
    L32:
        th = th;
    L34:
        e = e;
        goto L36
    }

    private Request createTunnel(int r7, int r8, Request r9, HttpUrl r10) throws IOException {
        String r11 = "CONNECT " + Util.hostHeader(r10, true) + " HTTP/1.1";
    L3:
        Http1Codec r0 = new Http1Codec(null, null, this.source, this.sink);
        this.source.timeout().timeout(r7, TimeUnit.MILLISECONDS);
        this.sink.timeout().timeout(r8, TimeUnit.MILLISECONDS);
        r0.writeRequest(r9.headers(), r11);
        r0.finishRequest();
        Response r12 = r0.readResponseHeaders(false).request(r9).build();
        long r1 = HttpHeaders.contentLength(r12);
        if (r1 != (-1)) goto L6;
        r1 = 0;
    L6:
        Source r2 = r0.newFixedLengthSource(r1);
        Util.skipAll(r2, Integer.MAX_VALUE, TimeUnit.MILLISECONDS);
        r2.close();
        int r3 = r12.code();
        if (r3 == 200) goto L21;
        if (r3 != 407) goto L19;
        Request r4 = this.route.address().proxyAuthenticator().authenticate(this.route, r12);
        if (r4 == null) goto L17;
        if ("close".equalsIgnoreCase(r12.header(HTTP.CONN_DIRECTIVE)) == true) goto L14;
        r9 = r4;
        goto L3
    L14:
        return r4;
    L17:
        throw new IOException("Failed to authenticate with proxy");
    L19:
        throw new IOException("Unexpected response code for CONNECT: " + r12.code());
    L21:
        if (this.source.buffer().exhausted() == false) goto L26;
        if (this.sink.buffer().exhausted() == false) goto L26;
        return null;
    L26:
        throw new IOException("TLS tunnel buffered too many bytes!");
    }

    private Request createTunnelRequest() throws IOException {
        Request r0 = new Request.Builder().url(this.route.address().url()).method("CONNECT", null).header(HTTP.TARGET_HOST, Util.hostHeader(this.route.address().url(), true)).header("Proxy-Connection", HTTP.CONN_KEEP_ALIVE).header("User-Agent", Version.userAgent()).build();
        Response r1 = new Response.Builder().request(r0).protocol(Protocol.HTTP_1_1).code(HttpStatus.SC_PROXY_AUTHENTICATION_REQUIRED).message("Preemptive Authenticate").body(Util.EMPTY_RESPONSE).sentRequestAtMillis(-1).receivedResponseAtMillis(-1).header("Proxy-Authenticate", "OkHttp-Preemptive").build();
        Request r4 = this.route.address().proxyAuthenticator().authenticate(this.route, r1);
        if (r4 != null) goto L5;
        return r0;
    L5:
        return r4;
    }

    public boolean isEligible(Address r5, @Nullable Route r6) {
        if (this.allocations.size() < this.allocationLimit) goto L5;
    L35:
        return false;
    L5:
        if (this.noNewStreams == true) goto L35;
        if (Internal.instance.equalsNonHost(this.route.address(), r5) == true) goto L11;
        return false;
    L11:
        if (r5.url().host().equals(route().address().url().host()) == false) goto L14;
        return true;
    L14:
        if (this.http2Connection != null) goto L16;
        return false;
    L16:
        if (r6 != null) goto L19;
        return false;
    L19:
        if (r6.proxy().type() == Proxy.Type.DIRECT) goto L22;
        return false;
    L22:
        if (this.route.proxy().type() == Proxy.Type.DIRECT) goto L25;
        return false;
    L25:
        if (this.route.socketAddress().equals(r6.socketAddress()) == true) goto L28;
        return false;
    L28:
        if (r6.address().hostnameVerifier() == OkHostnameVerifier.INSTANCE) goto L31;
        return false;
    L31:
        if (supportsUrl(r5.url()) == true) goto L37;
        return false;
    L37:
        r5.certificatePinner().check(r5.url().host(), handshake().peerCertificates());     // Catch: SSLPeerUnverifiedException -> L36
        return true;
    }

    public boolean supportsUrl(HttpUrl r4) {
        if (r4.port() == this.route.address().url().port()) goto L6;
        return false;
    L6:
        if (r4.host().equals(this.route.address().url().host()) == false) goto L8;
        return true;
    L8:
        if (this.handshake != null) goto L10;
        return false;
    L10:
        if (OkHostnameVerifier.INSTANCE.verify(r4.host(), (X509Certificate) this.handshake.peerCertificates().get(0)) == true) goto L12;
        return false;
    L12:
        return true;
    }

    public HttpCodec newCodec(OkHttpClient r5, Interceptor.Chain r6, StreamAllocation r7) throws SocketException {
        if (this.http2Connection != null) goto L5;
        this.socket.setSoTimeout(r6.readTimeoutMillis());
        this.source.timeout().timeout(r6.readTimeoutMillis(), TimeUnit.MILLISECONDS);
        this.sink.timeout().timeout(r6.writeTimeoutMillis(), TimeUnit.MILLISECONDS);
        return new Http1Codec(r5, r7, this.source, this.sink);
    L5:
        return new Http2Codec(r5, r6, r7, this.http2Connection);
    }

    public RealWebSocket.Streams newWebSocketStreams(final StreamAllocation r8) {
        final boolean r2 = true;
        final BufferedSource r3 = this.source;
        final BufferedSink r4 = this.sink;
        return new AnonymousClass1(this, r2, r3, r4, r8);
    }

    @Override // okhttp3.Connection
    public Route route() {
        return this.route;
    }

    public void cancel() {
        Util.closeQuietly(this.rawSocket);
    }

    @Override // okhttp3.Connection
    public Socket socket() {
        return this.socket;
    }

    public boolean isHealthy(boolean r4) {
        if (this.socket.isClosed() == false) goto L5;
    L27:
        return false;
    L5:
        if (this.socket.isInputShutdown() == true) goto L27;
        if (this.socket.isOutputShutdown() == true) goto L27;
        Http2Connection r0 = this.http2Connection;
        if (r0 == null) goto L14;
        return r0.isHealthy(System.nanoTime());
    L14:
        if (r4 == true) goto L31;
    L26:
        return true;
    L31:
        int r5 = this.socket.getSoTimeout();     // Catch: IOException -> L25 SocketTimeoutException -> L28
        this.socket.setSoTimeout(1);     // Catch: Throwable -> L22
        if (this.source.exhausted() == false) goto L20;
        this.socket.setSoTimeout(r5);     // Catch: IOException -> L25 SocketTimeoutException -> L28
        return false;
    L20:
        this.socket.setSoTimeout(r5);     // Catch: IOException -> L25 SocketTimeoutException -> L28
        return true;
    L22:
        th = move-exception;
        this.socket.setSoTimeout(r5);     // Catch: IOException -> L25 SocketTimeoutException -> L28
        throw th;     // Catch: IOException -> L25 SocketTimeoutException -> L28
    L25:
        return false;
    }

    @Override // okhttp3.internal.http2.Http2Connection.Listener
    public void onStream(Http2Stream r1) throws IOException {
        r1.close(ErrorCode.REFUSED_STREAM);
    }

    @Override // okhttp3.internal.http2.Http2Connection.Listener
    public void onSettings(Http2Connection r2) {
        ConnectionPool r0 = this.connectionPool;
        monitor-enter(r0);
        this.allocationLimit = r2.maxConcurrentStreams();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // okhttp3.Connection
    public Handshake handshake() {
        return this.handshake;
    }

    public boolean isMultiplexed() {
        if (this.http2Connection == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // okhttp3.Connection
    public Protocol protocol() {
        return this.protocol;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder("Connection{").append(this.route.address().url().host()).append(":").append(this.route.address().url().port()).append(", proxy=").append(this.route.proxy()).append(" hostAddress=").append(this.route.socketAddress()).append(" cipherSuite=");
        Handshake r1 = this.handshake;
        if (r1 == null) goto L5;
        Object r2 = r1.cipherSuite();
    L7:
        return r0.append(r2).append(" protocol=").append(this.protocol).append('}').toString();
    L5:
        r2 = "none";
        goto L7
    }
}
