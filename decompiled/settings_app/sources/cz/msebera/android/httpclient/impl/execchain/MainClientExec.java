package cz.msebera.android.httpclient.impl.execchain;

import com.android.settings.utils.HanziToPinyin;
import cz.msebera.android.httpclient.ConnectionReuseStrategy;
import cz.msebera.android.httpclient.HttpClientConnection;
import cz.msebera.android.httpclient.HttpEntity;
import cz.msebera.android.httpclient.HttpEntityEnclosingRequest;
import cz.msebera.android.httpclient.HttpException;
import cz.msebera.android.httpclient.HttpHost;
import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.HttpRequestInterceptor;
import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.auth.AuthProtocolState;
import cz.msebera.android.httpclient.auth.AuthState;
import cz.msebera.android.httpclient.client.AuthenticationStrategy;
import cz.msebera.android.httpclient.client.NonRepeatableRequestException;
import cz.msebera.android.httpclient.client.UserTokenHandler;
import cz.msebera.android.httpclient.client.config.RequestConfig;
import cz.msebera.android.httpclient.client.methods.CloseableHttpResponse;
import cz.msebera.android.httpclient.client.methods.HttpExecutionAware;
import cz.msebera.android.httpclient.client.methods.HttpRequestWrapper;
import cz.msebera.android.httpclient.client.protocol.HttpClientContext;
import cz.msebera.android.httpclient.conn.ConnectionKeepAliveStrategy;
import cz.msebera.android.httpclient.conn.ConnectionRequest;
import cz.msebera.android.httpclient.conn.HttpClientConnectionManager;
import cz.msebera.android.httpclient.conn.routing.BasicRouteDirector;
import cz.msebera.android.httpclient.conn.routing.HttpRoute;
import cz.msebera.android.httpclient.conn.routing.HttpRouteDirector;
import cz.msebera.android.httpclient.conn.routing.RouteTracker;
import cz.msebera.android.httpclient.entity.BufferedHttpEntity;
import cz.msebera.android.httpclient.extras.HttpClientAndroidLog;
import cz.msebera.android.httpclient.impl.auth.HttpAuthenticator;
import cz.msebera.android.httpclient.impl.conn.ConnectionShutdownException;
import cz.msebera.android.httpclient.message.BasicHttpRequest;
import cz.msebera.android.httpclient.protocol.HttpProcessor;
import cz.msebera.android.httpclient.protocol.HttpRequestExecutor;
import cz.msebera.android.httpclient.protocol.ImmutableHttpProcessor;
import cz.msebera.android.httpclient.protocol.RequestTargetHost;
import cz.msebera.android.httpclient.util.Args;
import cz.msebera.android.httpclient.util.EntityUtils;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes5.dex */
public class MainClientExec implements ClientExecChain {
    private final HttpAuthenticator authenticator;
    private final HttpClientConnectionManager connManager;
    private final ConnectionKeepAliveStrategy keepAliveStrategy;
    public HttpClientAndroidLog log;
    private final AuthenticationStrategy proxyAuthStrategy;
    private final HttpProcessor proxyHttpProcessor;
    private final HttpRequestExecutor requestExecutor;
    private final ConnectionReuseStrategy reuseStrategy;
    private final HttpRouteDirector routeDirector;
    private final AuthenticationStrategy targetAuthStrategy;
    private final UserTokenHandler userTokenHandler;

    public MainClientExec(HttpRequestExecutor r3, HttpClientConnectionManager r4, ConnectionReuseStrategy r5, ConnectionKeepAliveStrategy r6, HttpProcessor r7, AuthenticationStrategy r8, AuthenticationStrategy r9, UserTokenHandler r10) {
        this.log = new HttpClientAndroidLog(getClass());
        Args.notNull(r3, "HTTP request executor");
        Args.notNull(r4, "Client connection manager");
        Args.notNull(r5, "Connection reuse strategy");
        Args.notNull(r6, "Connection keep alive strategy");
        Args.notNull(r7, "Proxy HTTP processor");
        Args.notNull(r8, "Target authentication strategy");
        Args.notNull(r9, "Proxy authentication strategy");
        Args.notNull(r10, "User token handler");
        this.authenticator = new HttpAuthenticator();
        this.routeDirector = new BasicRouteDirector();
        this.requestExecutor = r3;
        this.connManager = r4;
        this.reuseStrategy = r5;
        this.keepAliveStrategy = r6;
        this.proxyHttpProcessor = r7;
        this.targetAuthStrategy = r8;
        this.proxyAuthStrategy = r9;
        this.userTokenHandler = r10;
    }

    public MainClientExec(HttpRequestExecutor r10, HttpClientConnectionManager r11, ConnectionReuseStrategy r12, ConnectionKeepAliveStrategy r13, AuthenticationStrategy r14, AuthenticationStrategy r15, UserTokenHandler r16) {
        this(r10, r11, r12, r13, new ImmutableHttpProcessor(new HttpRequestInterceptor[]{new RequestTargetHost()}), r14, r15, r16);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // cz.msebera.android.httpclient.impl.execchain.ClientExecChain
    public CloseableHttpResponse execute(HttpRoute r25, HttpRequestWrapper r26, HttpClientContext r27, HttpExecutionAware r28) throws IOException, HttpException {
        HttpRoute r8 = r25;
        HttpExecutionAware r11 = r28;
        Args.notNull(r8, "HTTP route");
        Args.notNull(r26, "HTTP request");
        Args.notNull(r27, "HTTP context");
        AuthState r1 = r27.getTargetAuthState();
        if (r1 != null) goto L5;
        r1 = new AuthState();
        r27.setAttribute("http.auth.target-scope", r1);
    L5:
        AuthState r14 = r1;
        AuthState r2 = r27.getProxyAuthState();
        if (r2 != null) goto L8;
        r2 = new AuthState();
        r27.setAttribute("http.auth.proxy-scope", r2);
    L8:
        AuthState r15 = r2;
        if ((r26 instanceof HttpEntityEnclosingRequest) == false) goto L11;
        RequestEntityProxy.enhance((HttpEntityEnclosingRequest) r26);
    L11:
        Object r6 = r27.getUserToken();
        ConnectionRequest r3 = this.connManager.requestConnection(r8, r6);
        String r5 = "Request aborted";
        if (r11 != null) goto L14;
    L18:
        RequestConfig r16 = r27.getRequestConfig();
        int r4 = r16.getConnectionRequestTimeout();     // Catch: ExecutionException -> L233 InterruptedException -> L240
        if (r4 <= 0) goto L22;
        long r7 = r4;
    L23:
        HttpClientConnection r9 = r3.get(r7, TimeUnit.MILLISECONDS);     // Catch: ExecutionException -> L233 InterruptedException -> L240
        r27.setAttribute("http.connection", r9);
        if (r16.isStaleConnectionCheckEnabled() == true) goto L27;
    L31:
        ConnectionHolder r10 = new ConnectionHolder(this.log, this.connManager, r9);
        if (r11 != null) goto L262;
    L44:
        int r12 = 1;
        int r13 = 1;
    L45:
        if (r13 > r12) goto L47;
    L51:
        if (r11 != null) goto L53;
    L263:
        if (r9.isOpen() == false) goto L60;
        int r19 = r12;
        ConnectionHolder r21 = r10;
        Object r23 = r6;
        AuthState r22 = r15;
    L246:
        int r17 = r16.getSocketTimeout();     // Catch: Error -> L34 ConnectionShutdownException -> L42 RuntimeException -> L198 IOException -> L200 HttpException -> L202
        if (r17 < 0) goto L88;
        r9.setSocketTimeout(r17);     // Catch: Error -> L34 ConnectionShutdownException -> L42 RuntimeException -> L80 IOException -> L83 HttpException -> L86
    L88:
        if (r11 == null) goto L95;
        if (r28.isAborted() == false) goto L95;
        throw new RequestAbortedException(r5);     // Catch: Error -> L34 ConnectionShutdownException -> L42 RuntimeException -> L80 IOException -> L83 HttpException -> L86
    L95:
        if (this.log.isDebugEnabled() == false) goto L98;
        this.log.debug("Executing request " + r26.getRequestLine());     // Catch: Error -> L34 ConnectionShutdownException -> L42 RuntimeException -> L80 IOException -> L83 HttpException -> L86
    L98:
        if (r26.containsHeader("Authorization") == false) goto L100;
    L103:
        if (r26.containsHeader("Proxy-Authorization") == false) goto L106;
    L118:
        AuthState r18 = r22;
    L254:
        r27.setAttribute("http.request", r26);     // Catch: Error -> L34 ConnectionShutdownException -> L42 RuntimeException -> L194 IOException -> L196 HttpException -> L202
        HttpResponse r20 = this.requestExecutor.execute(r26, r9, r27);     // Catch: Error -> L34 ConnectionShutdownException -> L42 RuntimeException -> L194 IOException -> L196 HttpException -> L202
        if (this.reuseStrategy.keepAlive(r20, r27) == true) goto L249;
        r20 = r20;
        ConnectionHolder r110 = r21;
        r110.markNonReusable();     // Catch: Error -> L34 ConnectionShutdownException -> L42 HttpException -> L176 RuntimeException -> L190 IOException -> L192
    L146:
        HttpResponse r24 = r20;
        r22 = r18;
    L174:
        e = e;
    L218:
        IOException r29 = e;
    L219:
        r110.abortConnection();
        if (r22.isConnectionBased() == false) goto L223;
        r22.reset();
    L223:
        if (r14.isConnectionBased() == false) goto L272;
        r14.reset();
        throw r29;
    L272:
        throw r29;
    L172:
        e = e;
    L208:
        RuntimeException r30 = e;
    L209:
        r110.abortConnection();
        if (r22.isConnectionBased() == false) goto L213;
        r22.reset();
    L213:
        if (r14.isConnectionBased() == false) goto L271;
        r14.reset();
        throw r30;
    L271:
        throw r30;
    L148:
        if (needAuthentication(r14, r18, r25, r24, r27) == false) goto L169;
        HttpEntity r31 = r24.getEntity();     // Catch: Error -> L34 ConnectionShutdownException -> L42 RuntimeException -> L172 IOException -> L174 HttpException -> L176
        if (r110.isReusable() == false) goto L152;
        EntityUtils.consume(r31);     // Catch: Error -> L34 ConnectionShutdownException -> L42 RuntimeException -> L172 IOException -> L174 HttpException -> L176
    L162:
        HttpRequest r32 = r26.getOriginal();     // Catch: Error -> L34 ConnectionShutdownException -> L42 RuntimeException -> L172 IOException -> L174 HttpException -> L176
        if (r32.containsHeader("Authorization") == true) goto L166;
        r26.removeHeaders("Authorization");     // Catch: Error -> L34 ConnectionShutdownException -> L42 RuntimeException -> L172 IOException -> L174 HttpException -> L176
    L166:
        if (r32.containsHeader("Proxy-Authorization") == true) goto L168;
        r26.removeHeaders("Proxy-Authorization");     // Catch: Error -> L34 ConnectionShutdownException -> L42 RuntimeException -> L172 IOException -> L174 HttpException -> L176
    L168:
        r13 = r13 + 1;     // Catch: Error -> L34 ConnectionShutdownException -> L42 RuntimeException -> L172 IOException -> L174 HttpException -> L176
        r9 = r9;
        r10 = r110;
        r5 = r5;
        r12 = r19;
        r15 = r22;
        r6 = r23;
        r8 = r25;
        r11 = r28;
        goto L45
    L152:
        r9.close();     // Catch: Error -> L34 ConnectionShutdownException -> L42 RuntimeException -> L172 IOException -> L174 HttpException -> L176
        if (r22.getState() != AuthProtocolState.SUCCESS) goto L158;
        if (r22.isConnectionBased() == false) goto L158;
        this.log.debug("Resetting proxy auth state");     // Catch: Error -> L34 ConnectionShutdownException -> L42 RuntimeException -> L172 IOException -> L174 HttpException -> L176
        r22.reset();     // Catch: Error -> L34 ConnectionShutdownException -> L42 RuntimeException -> L172 IOException -> L174 HttpException -> L176
    L158:
        if (r14.getState() != AuthProtocolState.SUCCESS) goto L162;
        if (r14.isConnectionBased() == false) goto L162;
        this.log.debug("Resetting target auth state");     // Catch: Error -> L34 ConnectionShutdownException -> L42 RuntimeException -> L172 IOException -> L174 HttpException -> L176
        r14.reset();     // Catch: Error -> L34 ConnectionShutdownException -> L42 RuntimeException -> L172 IOException -> L174 HttpException -> L176
        goto L162
    L169:
        HttpResponse r33 = r24;
    L170:
        if (r23 != null) goto L178;
        Object r34 = this.userTokenHandler.getUserToken(r27);     // Catch: Error -> L34 ConnectionShutdownException -> L42 RuntimeException -> L172 IOException -> L174 HttpException -> L176
        r27.setAttribute("http.user-token", r34);     // Catch: Error -> L34 ConnectionShutdownException -> L42 RuntimeException -> L172 IOException -> L174 HttpException -> L176
    L179:
        if (r34 == null) goto L181;
        r110.setState(r34);     // Catch: Error -> L34 ConnectionShutdownException -> L42 RuntimeException -> L172 IOException -> L174 HttpException -> L176
    L181:
        HttpEntity r35 = r33.getEntity();     // Catch: Error -> L34 ConnectionShutdownException -> L42 RuntimeException -> L172 IOException -> L174 HttpException -> L176
        if (r35 != null) goto L184;
    L188:
        r110.releaseConnection();     // Catch: Error -> L34 ConnectionShutdownException -> L42 RuntimeException -> L172 IOException -> L174 HttpException -> L176
        return new HttpResponseProxy(r33, null);
    L184:
        if (r35.isStreaming() == false) goto L188;
        return new HttpResponseProxy(r33, r110);
    L178:
        r34 = r23;
        goto L179
    L192:
        e = e;
        r22 = r18;
    L190:
        e = e;
        r22 = r18;
        goto L208
    L249:
        long r36 = this.keepAliveStrategy.getKeepAliveDuration(r20, r27);     // Catch: Error -> L34 ConnectionShutdownException -> L42 RuntimeException -> L138 IOException -> L141 HttpException -> L202
        if (this.log.isDebugEnabled() == false) goto L130;
        if (r36 <= 0) goto L126;
        String r37 = "for " + r36 + HanziToPinyin.Token.SEPARATOR + TimeUnit.MILLISECONDS;     // Catch: Error -> L34 ConnectionShutdownException -> L42 HttpException -> L86 RuntimeException -> L114 IOException -> L116
    L127:
        this.log.debug("Connection can be kept alive " + r37);     // Catch: Error -> L34 ConnectionShutdownException -> L42 HttpException -> L86 RuntimeException -> L114 IOException -> L116
        goto L130
    L126:
        r37 = "indefinitely";
    L130:
        r110 = r21;
        r110.setValidFor(r36, TimeUnit.MILLISECONDS);     // Catch: Error -> L34 ConnectionShutdownException -> L42 RuntimeException -> L134 IOException -> L136 HttpException -> L176
        r110.markReusable();     // Catch: Error -> L34 ConnectionShutdownException -> L42 RuntimeException -> L134 IOException -> L136 HttpException -> L176
    L176:
        e = e;
    L228:
        HttpException r38 = e;
    L229:
        r110.abortConnection();
        throw r38;
    L136:
        e = e;
    L143:
        r29 = e;
        r22 = r18;
    L134:
        e = e;
    L140:
        r30 = e;
        r22 = r18;
        goto L209
    L141:
        e = e;
        r110 = r21;
    L138:
        e = e;
        r110 = r21;
        goto L140
    L196:
        e = e;
        r22 = r18;
    L201:
        r110 = r21;
    L194:
        e = e;
        r22 = r18;
    L199:
        r110 = r21;
        goto L208
    L106:
        if (r25.isTunnelled() == true) goto L118;
        if (this.log.isDebugEnabled() == false) goto L111;
        this.log.debug("Proxy auth state: " + r22.getState());     // Catch: Error -> L34 ConnectionShutdownException -> L42 RuntimeException -> L80 IOException -> L83 HttpException -> L86
    L111:
        r18 = r22;
        this.authenticator.generateAuthResponse(r26, r18, r27);     // Catch: Error -> L34 ConnectionShutdownException -> L42 HttpException -> L86 RuntimeException -> L114 IOException -> L116
    L116:
        e = move-exception;
        r29 = e;
        r22 = r18;
    L85:
        r110 = r21;
    L114:
        e = move-exception;
        r30 = e;
        r22 = r18;
    L82:
        r110 = r21;
        goto L209
    L100:
        if (this.log.isDebugEnabled() == false) goto L102;
        this.log.debug("Target auth state: " + r14.getState());     // Catch: Error -> L34 ConnectionShutdownException -> L42 RuntimeException -> L80 IOException -> L83 HttpException -> L86
    L102:
        this.authenticator.generateAuthResponse(r26, r14, r27);     // Catch: Error -> L34 ConnectionShutdownException -> L42 RuntimeException -> L80 IOException -> L83 HttpException -> L86
    L202:
        e = e;
        r110 = r21;
    L200:
        e = e;
    L198:
        e = e;
        goto L199
    L60:
        r21 = r10;
        this.log.debug("Opening connection " + r8);     // Catch: Error -> L34 ConnectionShutdownException -> L42 RuntimeException -> L72 IOException -> L74 HttpException -> L86
        r19 = 1;
        r22 = r15;
        r23 = r6;
        establishRoute(r15, r9, r25, r26, r27);     // Catch: Error -> L34 ConnectionShutdownException -> L42 TunnelRefusedException -> L65 RuntimeException -> L80 IOException -> L83 HttpException -> L86
    L65:
        e = move-exception;
        if (this.log.isDebugEnabled() == false) goto L70;
        this.log.debug(e.getMessage());     // Catch: Error -> L34 ConnectionShutdownException -> L42 RuntimeException -> L80 IOException -> L83 HttpException -> L86
    L70:
        r33 = e.getResponse();     // Catch: Error -> L34 ConnectionShutdownException -> L42 RuntimeException -> L80 IOException -> L83 HttpException -> L86
        r110 = r21;
    L83:
        e = move-exception;
        r29 = e;
    L80:
        e = move-exception;
        r30 = e;
        goto L82
    L86:
        e = move-exception;
        r38 = e;
        r110 = r21;
    L74:
        e = move-exception;
        r29 = e;
        r22 = r15;
    L72:
        e = move-exception;
        r30 = e;
        r22 = r15;
        goto L82
    L226:
        e = e;
        r110 = r10;
    L216:
        e = e;
        r110 = r10;
        r22 = r15;
    L206:
        e = e;
        r110 = r10;
        r22 = r15;
        goto L208
    L53:
        if (r28.isAborted() == false) goto L263;
        throw new RequestAbortedException(r5);     // Catch: Error -> L34 RuntimeException -> L36 IOException -> L38 HttpException -> L40 ConnectionShutdownException -> L42
    L47:
        if (RequestEntityProxy.isRepeatable(r26) == true) goto L51;
        throw new NonRepeatableRequestException("Cannot retry request with a non-repeatable request entity.");     // Catch: Error -> L34 RuntimeException -> L36 IOException -> L38 HttpException -> L40 ConnectionShutdownException -> L42
    L262:
        r11.setCancellable(r10);     // Catch: Error -> L34 RuntimeException -> L36 IOException -> L38 HttpException -> L40 ConnectionShutdownException -> L42
    L42:
        e = move-exception;
        InterruptedIOException r39 = new InterruptedIOException("Connection has been shut down");
        r39.initCause(e);
        throw r39;
    L34:
        e = move-exception;
        this.connManager.shutdown();
        throw e;
    L40:
        e = move-exception;
        r38 = e;
        r110 = r10;
    L38:
        e = move-exception;
        r29 = e;
        r110 = r10;
        r22 = r15;
    L36:
        e = move-exception;
        r30 = e;
        r110 = r10;
        r22 = r15;
        goto L209
    L27:
        if (r9.isOpen() == false) goto L31;
        this.log.debug("Stale connection check");
        if (r9.isStale() == false) goto L31;
        this.log.debug("Stale connection detected");
        r9.close();
        goto L31
    L22:
        r7 = 0;
    L240:
        e = move-exception;
        Thread.currentThread().interrupt();
        throw new RequestAbortedException("Request aborted", e);
    L233:
        e = move-exception;
        ExecutionException r40 = e;
        Throwable r41 = r40.getCause();
        if (r41 == null) goto L239;
        r40 = r41;
    L239:
        throw new RequestAbortedException("Request execution failed", r40);
    L14:
        if (r28.isAborted() == true) goto L16;
        r11.setCancellable(r3);
        goto L18
    L16:
        r3.cancel();
        throw new RequestAbortedException("Request aborted");
    }

    void establishRoute(AuthState r8, HttpClientConnection r9, HttpRoute r10, HttpRequest r11, HttpClientContext r12) throws HttpException, IOException {
        int r0 = r12.getRequestConfig().getConnectTimeout();
        RouteTracker r1 = new RouteTracker(r10);
    L3:
        HttpRoute r2 = r1.toRoute();
        int r3 = this.routeDirector.nextStep(r10, r2);
        boolean r4 = true;
        int r5 = 0;
        switch(r3) {
            case -1: goto L29;
            case 0: goto L25;
            case 1: goto L21;
            case 2: goto L10;
            case 3: goto L9;
            case 4: goto L8;
            case 5: goto L7;
            default: goto L6;
        };
    L7:
        this.connManager.upgrade(r9, r10, r12);
        r1.layerProtocol(r10.isSecure());
    L26:
        if (r3 > 0) goto L3;
        return;
    L8:
        int r6 = r2.getHopCount() - 1;
        boolean r7 = createTunnelToProxy(r10, r6, r12);
        this.log.debug("Tunnel to proxy created.");
        r1.tunnelProxy(r10.getHopTarget(r6), r7);
        goto L26
    L9:
        boolean r13 = createTunnelToTarget(r8, r9, r10, r11, r12);
        this.log.debug("Tunnel to target created.");
        r1.tunnelTarget(r13);
        goto L26
    L10:
        HttpClientConnectionManager r14 = this.connManager;
        if (r0 <= 0) goto L13;
        int r15 = r0;
    L14:
        r14.connect(r9, r10, r15, r12);
        HttpHost r16 = r10.getProxyHost();
        if (r10.isSecure() == true) goto L17;
    L19:
        r4 = false;
    L20:
        r1.connectProxy(r16, r4);
        goto L26
    L17:
        if (r10.isTunnelled() == true) goto L19;
    L13:
        r15 = 0;
        goto L14
    L21:
        HttpClientConnectionManager r17 = this.connManager;
        if (r0 <= 0) goto L24;
        r5 = r0;
    L24:
        r17.connect(r9, r10, r5, r12);
        r1.connectTarget(r10.isSecure());
        goto L26
    L25:
        this.connManager.routeComplete(r9, r10, r12);
        goto L26
    L6:
        throw new IllegalStateException("Unknown step indicator " + r3 + " from RouteDirector.");
    L29:
        throw new HttpException("Unable to establish route: planned = " + r10 + "; current = " + r2);
    }

    private boolean createTunnelToTarget(AuthState r17, HttpClientConnection r18, HttpRoute r19, HttpRequest r20, HttpClientContext r21) throws HttpException, IOException {
        RequestConfig r9 = r21.getRequestConfig();
        int r10 = r9.getConnectTimeout();
        HttpHost r2 = r19.getTargetHost();
        HttpHost r11 = r19.getProxyHost();
        BasicHttpRequest r12 = new BasicHttpRequest("CONNECT", r2.toHostString(), r20.getProtocolVersion());
        this.requestExecutor.preProcess(r12, this.proxyHttpProcessor, r21);
    L3:
        HttpResponse r3 = null;
    L4:
        int r4 = 0;
        if (r3 != null) goto L31;
        if (r18.isOpen() == true) goto L13;
        HttpClientConnectionManager r5 = this.connManager;
        if (r10 <= 0) goto L11;
        r4 = r10;
    L11:
        r5.connect(r18, r19, r4, r21);
    L13:
        r12.removeHeaders("Proxy-Authorization");
        this.authenticator.generateAuthResponse(r12, r17, r21);
        HttpResponse r7 = this.requestExecutor.execute(r12, r18, r21);
        this.requestExecutor.postProcess(r7, this.proxyHttpProcessor, r21);
        if (r7.getStatusLine().getStatusCode() < 200) goto L29;
        if (r9.isAuthenticationEnabled() == true) goto L18;
        HttpResponse r6 = r7;
    L27:
        r3 = r6;
        goto L4
    L18:
        if (this.authenticator.isAuthenticationRequested(r11, r7, this.proxyAuthStrategy, r17, r21) == true) goto L20;
    L25:
        r6 = r7;
        goto L27
    L20:
        if (this.authenticator.handleAuthChallenge(r11, r7, this.proxyAuthStrategy, r17, r21) == false) goto L25;
        if (this.reuseStrategy.keepAlive(r7, r21) == true) goto L23;
        r18.close();
        goto L3
    L23:
        this.log.debug("Connection kept alive");
        EntityUtils.consume(r7.getEntity());
        goto L3
    L29:
        throw new HttpException("Unexpected response to CONNECT request: " + r7.getStatusLine());
    L31:
        if (r3.getStatusLine().getStatusCode() <= 299) goto L37;
        HttpEntity r0 = r3.getEntity();
        if (r0 == null) goto L35;
        r3.setEntity(new BufferedHttpEntity(r0));
    L35:
        r18.close();
        throw new TunnelRefusedException("CONNECT refused by proxy: " + r3.getStatusLine(), r3);
    L37:
        return false;
    }

    private boolean createTunnelToProxy(HttpRoute r1, int r2, HttpClientContext r3) throws HttpException {
        throw new HttpException("Proxy chains are not supported.");
    }

    private boolean needAuthentication(AuthState r11, AuthState r12, HttpRoute r13, HttpResponse r14, HttpClientContext r15) {
        if (r15.getRequestConfig().isAuthenticationEnabled() == false) goto L20;
        HttpHost r0 = r15.getTargetHost();
        if (r0 != null) goto L8;
        r0 = r13.getTargetHost();
    L8:
        if (r0.getPort() >= 0) goto L10;
        r0 = new HttpHost(r0.getHostName(), r13.getTargetHost().getPort(), r0.getSchemeName());
    L10:
        HttpHost r5 = r0;
        boolean r1 = this.authenticator.isAuthenticationRequested(r5, r14, this.targetAuthStrategy, r11, r15);
        HttpHost r2 = r13.getProxyHost();
        if (r2 != null) goto L13;
        r2 = r13.getTargetHost();
    L13:
        HttpHost r4 = r2;
        boolean r16 = this.authenticator.isAuthenticationRequested(r4, r14, this.proxyAuthStrategy, r12, r15);
        if (r1 == false) goto L17;
        HttpHost r6 = r0;
        return this.authenticator.handleAuthChallenge(r6, r14, this.targetAuthStrategy, r11, r15);
    L17:
        if (r16 == false) goto L22;
        HttpHost r7 = r2;
        return this.authenticator.handleAuthChallenge(r7, r14, this.proxyAuthStrategy, r12, r15);
    L22:
        return false;
    L20:
        return false;
    }
}
