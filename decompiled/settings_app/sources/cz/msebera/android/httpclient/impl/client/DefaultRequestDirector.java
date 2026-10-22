package cz.msebera.android.httpclient.impl.client;

import com.android.settings.utils.HanziToPinyin;
import com.android.settingslib.accessibility.AccessibilityUtils;
import cz.msebera.android.httpclient.ConnectionReuseStrategy;
import cz.msebera.android.httpclient.HttpEntity;
import cz.msebera.android.httpclient.HttpEntityEnclosingRequest;
import cz.msebera.android.httpclient.HttpException;
import cz.msebera.android.httpclient.HttpHost;
import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.NoHttpResponseException;
import cz.msebera.android.httpclient.ProtocolException;
import cz.msebera.android.httpclient.auth.AuthProtocolState;
import cz.msebera.android.httpclient.auth.AuthScheme;
import cz.msebera.android.httpclient.auth.AuthState;
import cz.msebera.android.httpclient.auth.UsernamePasswordCredentials;
import cz.msebera.android.httpclient.client.AuthenticationHandler;
import cz.msebera.android.httpclient.client.AuthenticationStrategy;
import cz.msebera.android.httpclient.client.HttpRequestRetryHandler;
import cz.msebera.android.httpclient.client.NonRepeatableRequestException;
import cz.msebera.android.httpclient.client.RedirectException;
import cz.msebera.android.httpclient.client.RedirectHandler;
import cz.msebera.android.httpclient.client.RedirectStrategy;
import cz.msebera.android.httpclient.client.RequestDirector;
import cz.msebera.android.httpclient.client.UserTokenHandler;
import cz.msebera.android.httpclient.client.methods.AbortableHttpRequest;
import cz.msebera.android.httpclient.client.methods.HttpUriRequest;
import cz.msebera.android.httpclient.client.params.ClientPNames;
import cz.msebera.android.httpclient.client.params.HttpClientParams;
import cz.msebera.android.httpclient.client.utils.URIUtils;
import cz.msebera.android.httpclient.conn.BasicManagedEntity;
import cz.msebera.android.httpclient.conn.ClientConnectionManager;
import cz.msebera.android.httpclient.conn.ClientConnectionRequest;
import cz.msebera.android.httpclient.conn.ConnectionKeepAliveStrategy;
import cz.msebera.android.httpclient.conn.ManagedClientConnection;
import cz.msebera.android.httpclient.conn.routing.BasicRouteDirector;
import cz.msebera.android.httpclient.conn.routing.HttpRoute;
import cz.msebera.android.httpclient.conn.routing.HttpRoutePlanner;
import cz.msebera.android.httpclient.entity.BufferedHttpEntity;
import cz.msebera.android.httpclient.extras.HttpClientAndroidLog;
import cz.msebera.android.httpclient.impl.auth.BasicScheme;
import cz.msebera.android.httpclient.impl.conn.ConnectionShutdownException;
import cz.msebera.android.httpclient.message.BasicHttpRequest;
import cz.msebera.android.httpclient.params.HttpConnectionParams;
import cz.msebera.android.httpclient.params.HttpParams;
import cz.msebera.android.httpclient.params.HttpProtocolParams;
import cz.msebera.android.httpclient.protocol.ExecutionContext;
import cz.msebera.android.httpclient.protocol.HttpContext;
import cz.msebera.android.httpclient.protocol.HttpProcessor;
import cz.msebera.android.httpclient.protocol.HttpRequestExecutor;
import cz.msebera.android.httpclient.util.Args;
import cz.msebera.android.httpclient.util.EntityUtils;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes5.dex */
@Deprecated
public class DefaultRequestDirector implements RequestDirector {
    private final HttpAuthenticator authenticator;
    protected final ClientConnectionManager connManager;
    private int execCount;
    protected final HttpProcessor httpProcessor;
    protected final ConnectionKeepAliveStrategy keepAliveStrategy;
    private final HttpClientAndroidLog log;
    protected ManagedClientConnection managedConn;
    private final int maxRedirects;
    protected final HttpParams params;
    protected final AuthenticationHandler proxyAuthHandler;
    protected final AuthState proxyAuthState;
    protected final AuthenticationStrategy proxyAuthStrategy;
    private int redirectCount;
    protected final RedirectHandler redirectHandler;
    protected final RedirectStrategy redirectStrategy;
    protected final HttpRequestExecutor requestExec;
    protected final HttpRequestRetryHandler retryHandler;
    protected final ConnectionReuseStrategy reuseStrategy;
    protected final HttpRoutePlanner routePlanner;
    protected final AuthenticationHandler targetAuthHandler;
    protected final AuthState targetAuthState;
    protected final AuthenticationStrategy targetAuthStrategy;
    protected final UserTokenHandler userTokenHandler;
    private HttpHost virtualHost;

    public DefaultRequestDirector(HttpRequestExecutor r15, ClientConnectionManager r16, ConnectionReuseStrategy r17, ConnectionKeepAliveStrategy r18, HttpRoutePlanner r19, HttpProcessor r20, HttpRequestRetryHandler r21, RedirectHandler r22, AuthenticationHandler r23, AuthenticationHandler r24, UserTokenHandler r25, HttpParams r26) {
        this(new HttpClientAndroidLog(DefaultRequestDirector.class), r15, r16, r17, r18, r19, r20, r21, new DefaultRedirectStrategyAdaptor(r22), new AuthenticationStrategyAdaptor(r23), new AuthenticationStrategyAdaptor(r24), r25, r26);
    }

    public DefaultRequestDirector(HttpClientAndroidLog r15, HttpRequestExecutor r16, ClientConnectionManager r17, ConnectionReuseStrategy r18, ConnectionKeepAliveStrategy r19, HttpRoutePlanner r20, HttpProcessor r21, HttpRequestRetryHandler r22, RedirectStrategy r23, AuthenticationHandler r24, AuthenticationHandler r25, UserTokenHandler r26, HttpParams r27) {
        this(new HttpClientAndroidLog(DefaultRequestDirector.class), r16, r17, r18, r19, r20, r21, r22, r23, new AuthenticationStrategyAdaptor(r24), new AuthenticationStrategyAdaptor(r25), r26, r27);
    }

    public DefaultRequestDirector(HttpClientAndroidLog r2, HttpRequestExecutor r3, ClientConnectionManager r4, ConnectionReuseStrategy r5, ConnectionKeepAliveStrategy r6, HttpRoutePlanner r7, HttpProcessor r8, HttpRequestRetryHandler r9, RedirectStrategy r10, AuthenticationStrategy r11, AuthenticationStrategy r12, UserTokenHandler r13, HttpParams r14) {
        Args.notNull(r2, "Log");
        Args.notNull(r3, "Request executor");
        Args.notNull(r4, "Client connection manager");
        Args.notNull(r5, "Connection reuse strategy");
        Args.notNull(r6, "Connection keep alive strategy");
        Args.notNull(r7, "Route planner");
        Args.notNull(r8, "HTTP protocol processor");
        Args.notNull(r9, "HTTP request retry handler");
        Args.notNull(r10, "Redirect strategy");
        Args.notNull(r11, "Target authentication strategy");
        Args.notNull(r12, "Proxy authentication strategy");
        Args.notNull(r13, "User token handler");
        Args.notNull(r14, "HTTP parameters");
        this.log = r2;
        this.authenticator = new HttpAuthenticator(r2);
        this.requestExec = r3;
        this.connManager = r4;
        this.reuseStrategy = r5;
        this.keepAliveStrategy = r6;
        this.routePlanner = r7;
        this.httpProcessor = r8;
        this.retryHandler = r9;
        this.redirectStrategy = r10;
        this.targetAuthStrategy = r11;
        this.proxyAuthStrategy = r12;
        this.userTokenHandler = r13;
        this.params = r14;
        if ((r10 instanceof DefaultRedirectStrategyAdaptor) == false) goto L5;
        this.redirectHandler = ((DefaultRedirectStrategyAdaptor) r10).getHandler();
    L7:
        if ((r11 instanceof AuthenticationStrategyAdaptor) == false) goto L9;
        this.targetAuthHandler = ((AuthenticationStrategyAdaptor) r11).getHandler();
    L11:
        if ((r12 instanceof AuthenticationStrategyAdaptor) == false) goto L13;
        this.proxyAuthHandler = ((AuthenticationStrategyAdaptor) r12).getHandler();
    L14:
        this.managedConn = null;
        this.execCount = 0;
        this.redirectCount = 0;
        this.targetAuthState = new AuthState();
        this.proxyAuthState = new AuthState();
        this.maxRedirects = r14.getIntParameter(ClientPNames.MAX_REDIRECTS, 100);
        return;
    L13:
        this.proxyAuthHandler = null;
        goto L14
    L9:
        this.targetAuthHandler = null;
        goto L11
    L5:
        this.redirectHandler = null;
        goto L7
    }

    private RequestWrapper wrapRequest(HttpRequest r1) throws ProtocolException {
        if ((r1 instanceof HttpEntityEnclosingRequest) == false) goto L7;
        return new EntityEnclosingRequestWrapper((HttpEntityEnclosingRequest) r1);
    L7:
        return new RequestWrapper(r1);
    }

    protected void rewriteRequestURI(RequestWrapper r3, HttpRoute r4) throws ProtocolException {
        URI r2 = r3.getURI();     // Catch: URISyntaxException -> L16
        if (r4.getProxyHost() == null) goto L11;
        if (r4.isTunnelled() == true) goto L11;
        if (r2.isAbsolute() == true) goto L9;
        URI r5 = URIUtils.rewriteURI(r2, r4.getTargetHost(), URIUtils.DROP_FRAGMENT_AND_NORMALIZE);     // Catch: URISyntaxException -> L16
    L14:
        r3.setURI(r5);     // Catch: URISyntaxException -> L16
        return;
    L9:
        r5 = URIUtils.rewriteURI(r2);     // Catch: URISyntaxException -> L16
    L11:
        if (r2.isAbsolute() == false) goto L13;
        r5 = URIUtils.rewriteURI(r2, null, URIUtils.DROP_FRAGMENT_AND_NORMALIZE);     // Catch: URISyntaxException -> L16
        goto L14
    L13:
        r5 = URIUtils.rewriteURI(r2);     // Catch: URISyntaxException -> L16
    L16:
        e = move-exception;
        throw new ProtocolException("Invalid URI: " + r3.getRequestLine().getUri(), e);
    }

    @Override // cz.msebera.android.httpclient.client.RequestDirector
    public HttpResponse execute(HttpHost r13, HttpRequest r14, HttpContext r15) throws HttpException, IOException {
        r15.setAttribute("http.auth.target-scope", this.targetAuthState);
        r15.setAttribute("http.auth.proxy-scope", this.proxyAuthState);
        RequestWrapper r1 = wrapRequest(r14);
        r1.setParams(this.params);
        HttpRoute r2 = determineRoute(r13, r1, r15);
        HttpHost r3 = (HttpHost) r1.getParams().getParameter(ClientPNames.VIRTUAL_HOST);
        this.virtualHost = r3;
        if (r3 != null) goto L5;
    L12:
        RoutedRequest r4 = new RoutedRequest(r1, r2);
        boolean r5 = false;
        RoutedRequest r6 = r4;
        HttpResponse r7 = null;
        boolean r8 = false;
    L13:
        if (r5 == true) goto L100;
        RequestWrapper r9 = r6.getRequest();     // Catch: RuntimeException -> L92 IOException -> L94 HttpException -> L96 ConnectionShutdownException -> L98
        HttpRoute r10 = r6.getRoute();     // Catch: RuntimeException -> L92 IOException -> L94 HttpException -> L96 ConnectionShutdownException -> L98
        Object r11 = r15.getAttribute("http.user-token");     // Catch: RuntimeException -> L92 IOException -> L94 HttpException -> L96 ConnectionShutdownException -> L98
        if (this.managedConn != null) goto L31;
        ClientConnectionRequest r12 = this.connManager.requestConnection(r10, r11);     // Catch: RuntimeException -> L92 IOException -> L94 HttpException -> L96 ConnectionShutdownException -> L98
        if ((r14 instanceof AbortableHttpRequest) == false) goto L121;
        ((AbortableHttpRequest) r14).setConnectionRequest(r12);     // Catch: RuntimeException -> L92 IOException -> L94 HttpException -> L96 ConnectionShutdownException -> L98
    L121:
        this.managedConn = r12.getConnection(HttpClientParams.getConnectionManagerTimeout(this.params), TimeUnit.MILLISECONDS);     // Catch: InterruptedException -> L28 RuntimeException -> L92 IOException -> L94 HttpException -> L96 ConnectionShutdownException -> L98
        if (HttpConnectionParams.isStaleCheckingEnabled(this.params) == false) goto L31;
        if (this.managedConn.isOpen() == false) goto L31;
        this.log.debug("Stale connection check");     // Catch: RuntimeException -> L92 IOException -> L94 HttpException -> L96 ConnectionShutdownException -> L98
        if (this.managedConn.isStale() == false) goto L31;
        this.log.debug("Stale connection detected");     // Catch: RuntimeException -> L92 IOException -> L94 HttpException -> L96 ConnectionShutdownException -> L98
        this.managedConn.close();     // Catch: RuntimeException -> L92 IOException -> L94 HttpException -> L96 ConnectionShutdownException -> L98
    L28:
        Thread.currentThread().interrupt();     // Catch: RuntimeException -> L92 IOException -> L94 HttpException -> L96 ConnectionShutdownException -> L98
        throw new InterruptedIOException();     // Catch: RuntimeException -> L92 IOException -> L94 HttpException -> L96 ConnectionShutdownException -> L98
    L31:
        if ((r14 instanceof AbortableHttpRequest) == false) goto L119;
        ((AbortableHttpRequest) r14).setReleaseTrigger(this.managedConn);     // Catch: RuntimeException -> L92 IOException -> L94 HttpException -> L96 ConnectionShutdownException -> L98
    L119:
        tryConnect(r6, r15);     // Catch: TunnelRefusedException -> L87 RuntimeException -> L92 IOException -> L94 HttpException -> L96 ConnectionShutdownException -> L98
        String r16 = r9.getURI().getUserInfo();     // Catch: RuntimeException -> L92 IOException -> L94 HttpException -> L96 ConnectionShutdownException -> L98
        if (r16 == null) goto L37;
        this.targetAuthState.update(new BasicScheme(), new UsernamePasswordCredentials(r16));     // Catch: RuntimeException -> L92 IOException -> L94 HttpException -> L96 ConnectionShutdownException -> L98
    L37:
        HttpHost r17 = this.virtualHost;     // Catch: RuntimeException -> L92 IOException -> L94 HttpException -> L96 ConnectionShutdownException -> L98
        if (r17 == null) goto L40;
        r13 = r17;
    L43:
        if (r13 != null) goto L45;
        r13 = r10.getTargetHost();     // Catch: RuntimeException -> L92 IOException -> L94 HttpException -> L96 ConnectionShutdownException -> L98
    L45:
        r9.resetHeaders();     // Catch: RuntimeException -> L92 IOException -> L94 HttpException -> L96 ConnectionShutdownException -> L98
        rewriteRequestURI(r9, r10);     // Catch: RuntimeException -> L92 IOException -> L94 HttpException -> L96 ConnectionShutdownException -> L98
        r15.setAttribute("http.target_host", r13);     // Catch: RuntimeException -> L92 IOException -> L94 HttpException -> L96 ConnectionShutdownException -> L98
        r15.setAttribute("http.route", r10);     // Catch: RuntimeException -> L92 IOException -> L94 HttpException -> L96 ConnectionShutdownException -> L98
        r15.setAttribute("http.connection", this.managedConn);     // Catch: RuntimeException -> L92 IOException -> L94 HttpException -> L96 ConnectionShutdownException -> L98
        this.requestExec.preProcess(r9, this.httpProcessor, r15);     // Catch: RuntimeException -> L92 IOException -> L94 HttpException -> L96 ConnectionShutdownException -> L98
        r7 = tryExecute(r6, r15);     // Catch: RuntimeException -> L92 IOException -> L94 HttpException -> L96 ConnectionShutdownException -> L98
        if (r7 == null) goto L13;
        r7.setParams(this.params);     // Catch: RuntimeException -> L92 IOException -> L94 HttpException -> L96 ConnectionShutdownException -> L98
        this.requestExec.postProcess(r7, this.httpProcessor, r15);     // Catch: RuntimeException -> L92 IOException -> L94 HttpException -> L96 ConnectionShutdownException -> L98
        r8 = this.reuseStrategy.keepAlive(r7, r15);     // Catch: RuntimeException -> L92 IOException -> L94 HttpException -> L96 ConnectionShutdownException -> L98
        if (r8 == false) goto L58;
        long r18 = this.keepAliveStrategy.getKeepAliveDuration(r7, r15);     // Catch: RuntimeException -> L92 IOException -> L94 HttpException -> L96 ConnectionShutdownException -> L98
        if (this.log.isDebugEnabled() == true) goto L53;
    L57:
        this.managedConn.setIdleDuration(r18, TimeUnit.MILLISECONDS);     // Catch: RuntimeException -> L92 IOException -> L94 HttpException -> L96 ConnectionShutdownException -> L98
        goto L58
    L53:
        if (r18 <= 0) goto L55;
        String r19 = "for " + r18 + HanziToPinyin.Token.SEPARATOR + TimeUnit.MILLISECONDS;     // Catch: RuntimeException -> L92 IOException -> L94 HttpException -> L96 ConnectionShutdownException -> L98
    L56:
        this.log.debug("Connection can be kept alive " + r19);     // Catch: RuntimeException -> L92 IOException -> L94 HttpException -> L96 ConnectionShutdownException -> L98
        goto L57
    L55:
        r19 = "indefinitely";
    L58:
        RoutedRequest r20 = handleResponse(r6, r7, r15);     // Catch: RuntimeException -> L92 IOException -> L94 HttpException -> L96 ConnectionShutdownException -> L98
        if (r20 != null) goto L61;
        r5 = true;
    L82:
        if (this.managedConn == null) goto L13;
        if (r11 != null) goto L85;
        r11 = this.userTokenHandler.getUserToken(r15);     // Catch: RuntimeException -> L92 IOException -> L94 HttpException -> L96 ConnectionShutdownException -> L98
        r15.setAttribute("http.user-token", r11);     // Catch: RuntimeException -> L92 IOException -> L94 HttpException -> L96 ConnectionShutdownException -> L98
    L85:
        if (r11 == null) goto L13;
        this.managedConn.setState(r11);     // Catch: RuntimeException -> L92 IOException -> L94 HttpException -> L96 ConnectionShutdownException -> L98
        goto L13
    L61:
        if (r8 == false) goto L63;
        EntityUtils.consume(r7.getEntity());     // Catch: RuntimeException -> L92 IOException -> L94 HttpException -> L96 ConnectionShutdownException -> L98
        this.managedConn.markReusable();     // Catch: RuntimeException -> L92 IOException -> L94 HttpException -> L96 ConnectionShutdownException -> L98
    L78:
        if (r20.getRoute().equals(r6.getRoute()) == true) goto L80;
        releaseConnection();     // Catch: RuntimeException -> L92 IOException -> L94 HttpException -> L96 ConnectionShutdownException -> L98
    L80:
        r6 = r20;
        goto L82
    L63:
        this.managedConn.close();     // Catch: RuntimeException -> L92 IOException -> L94 HttpException -> L96 ConnectionShutdownException -> L98
        if (this.proxyAuthState.getState().compareTo(AuthProtocolState.CHALLENGED) <= 0) goto L71;
        if (this.proxyAuthState.getAuthScheme() == null) goto L71;
        if (this.proxyAuthState.getAuthScheme().isConnectionBased() == false) goto L71;
        this.log.debug("Resetting proxy auth state");     // Catch: RuntimeException -> L92 IOException -> L94 HttpException -> L96 ConnectionShutdownException -> L98
        this.proxyAuthState.reset();     // Catch: RuntimeException -> L92 IOException -> L94 HttpException -> L96 ConnectionShutdownException -> L98
    L71:
        if (this.targetAuthState.getState().compareTo(AuthProtocolState.CHALLENGED) <= 0) goto L78;
        if (this.targetAuthState.getAuthScheme() == null) goto L78;
        if (this.targetAuthState.getAuthScheme().isConnectionBased() == false) goto L78;
        this.log.debug("Resetting target auth state");     // Catch: RuntimeException -> L92 IOException -> L94 HttpException -> L96 ConnectionShutdownException -> L98
        this.targetAuthState.reset();     // Catch: RuntimeException -> L92 IOException -> L94 HttpException -> L96 ConnectionShutdownException -> L98
        goto L78
    L40:
        URI r21 = r9.getURI();     // Catch: RuntimeException -> L92 IOException -> L94 HttpException -> L96 ConnectionShutdownException -> L98
        if (r21.isAbsolute() == false) goto L43;
        r13 = URIUtils.extractHost(r21);     // Catch: RuntimeException -> L92 IOException -> L94 HttpException -> L96 ConnectionShutdownException -> L98
    L87:
        e = move-exception;
        if (this.log.isDebugEnabled() == false) goto L91;
        this.log.debug(e.getMessage());     // Catch: RuntimeException -> L92 IOException -> L94 HttpException -> L96 ConnectionShutdownException -> L98
    L91:
        r7 = e.getResponse();     // Catch: RuntimeException -> L92 IOException -> L94 HttpException -> L96 ConnectionShutdownException -> L98
    L96:
        e = move-exception;
        abortConnection();
        throw e;
    L98:
        e = move-exception;
        InterruptedIOException r110 = new InterruptedIOException("Connection has been shut down");
        r110.initCause(e);
        throw r110;
    L94:
        e = move-exception;
        abortConnection();
        throw e;
    L92:
        e = move-exception;
        abortConnection();
        throw e;
    L100:
        if (r7 != null) goto L102;
    L107:
        if (r8 == false) goto L109;
        this.managedConn.markReusable();     // Catch: RuntimeException -> L92 IOException -> L94 HttpException -> L96 ConnectionShutdownException -> L98
    L109:
        releaseConnection();     // Catch: RuntimeException -> L92 IOException -> L94 HttpException -> L96 ConnectionShutdownException -> L98
    L110:
        return r7;
    L102:
        if (r7.getEntity() == null) goto L107;
        if (r7.getEntity().isStreaming() == false) goto L107;
        r7.setEntity(new BasicManagedEntity(r7.getEntity(), this.managedConn, r8));     // Catch: RuntimeException -> L92 IOException -> L94 HttpException -> L96 ConnectionShutdownException -> L98
        goto L110
    L5:
        if (r3.getPort() != (-1)) goto L12;
        if (r13 == null) goto L8;
        HttpHost r22 = r13;
    L9:
        int r23 = r22.getPort();
        if (r23 == (-1)) goto L12;
        this.virtualHost = new HttpHost(this.virtualHost.getHostName(), r23, this.virtualHost.getSchemeName());
        goto L12
    L8:
        r22 = r2.getTargetHost();
        goto L9
    }

    private void tryConnect(RoutedRequest r7, HttpContext r8) throws HttpException, IOException {
        HttpRoute r0 = r7.getRoute();
        RequestWrapper r9 = r7.getRequest();
        int r1 = 0;
    L3:
        r8.setAttribute("http.request", r9);
        r1 = r1 + 1;
    L10:
        e = move-exception;
        this.managedConn.close();     // Catch: IOException -> L21
    L13:
        if (this.retryHandler.retryRequest(e, r1, r8) == false) goto L20;
        if (this.log.isInfoEnabled() == false) goto L3;
        this.log.info("I/O exception (" + e.getClass().getName() + ") caught when connecting to " + r0 + ": " + e.getMessage());
        if (this.log.isDebugEnabled() == false) goto L19;
        this.log.debug(e.getMessage(), e);
    L19:
        this.log.info("Retrying connect to " + r0);
        goto L3
    L20:
        throw e;
    L5:
        if (this.managedConn.isOpen() == true) goto L7;
        this.managedConn.open(r0, r8, this.params);     // Catch: IOException -> L10
    L8:
        establishRoute(r0, r8);     // Catch: IOException -> L10
        return;
    L7:
        this.managedConn.setSocketTimeout(HttpConnectionParams.getSoTimeout(this.params));     // Catch: IOException -> L10
        goto L8
    }

    private HttpResponse tryExecute(RoutedRequest r7, HttpContext r8) throws HttpException, IOException {
        RequestWrapper r0 = r7.getRequest();
        HttpRoute r9 = r7.getRoute();
        IOException e = null;
    L3:
        this.execCount++;
        r0.incrementExecCount();
        if (r0.isRepeatable() == false) goto L5;
    L22:
        e = e;
        this.log.debug("Closing the connection.");
        this.managedConn.close();     // Catch: IOException -> L41
    L26:
        if (this.retryHandler.retryRequest(e, r0.getExecCount(), r8) == false) goto L37;
        if (this.log.isInfoEnabled() == false) goto L31;
        this.log.info("I/O exception (" + e.getClass().getName() + ") caught when processing request to " + r9 + ": " + e.getMessage());
    L31:
        if (this.log.isDebugEnabled() == false) goto L34;
        this.log.debug(e.getMessage(), e);
    L34:
        if (this.log.isInfoEnabled() == false) goto L3;
        this.log.info("Retrying request to " + r9);
        goto L3
    L37:
        if ((e instanceof NoHttpResponseException) == false) goto L40;
        NoHttpResponseException r6 = new NoHttpResponseException(r9.getTargetHost().toHostString() + " failed to respond");
        r6.setStackTrace(e.getStackTrace());
        throw r6;
    L40:
        throw e;
    L12:
        if (this.managedConn.isOpen() == true) goto L18;
        if (r9.isTunnelled() == true) goto L16;
        this.log.debug("Reopening the direct connection.");     // Catch: IOException -> L22
        this.managedConn.open(r9, r8, this.params);     // Catch: IOException -> L22
        goto L18
    L16:
        this.log.debug("Proxied connection. Need to start over.");     // Catch: IOException -> L22
        return null;
    L18:
        if (this.log.isDebugEnabled() == false) goto L21;
        this.log.debug("Attempt " + this.execCount + " to execute request");     // Catch: IOException -> L22
    L21:
        return this.requestExec.execute(r0, this.managedConn, r8);
    L5:
        this.log.debug("Cannot retry non-repeatable request");
        if (e == null) goto L10;
        throw new NonRepeatableRequestException("Cannot retry request with a non-repeatable request entity.  The cause lists the reason the original request failed.", e);
    L10:
        throw new NonRepeatableRequestException("Cannot retry request with a non-repeatable request entity.");
    }

    protected void releaseConnection() {
        this.managedConn.releaseConnection();     // Catch: IOException -> L4
    L6:
        this.managedConn = null;
        return;
    L4:
        e = move-exception;
        this.log.debug("IOException releasing connection", e);
        goto L6
    }

    protected HttpRoute determineRoute(HttpHost r2, HttpRequest r3, HttpContext r4) throws HttpException {
        HttpRoutePlanner r1 = this.routePlanner;
        if (r2 != null) goto L7;
        r2 = (HttpHost) r3.getParams().getParameter(ClientPNames.DEFAULT_HOST);
    L7:
        return r1.determineRoute(r2, r3, r4);
    }

    protected void establishRoute(HttpRoute r7, HttpContext r8) throws HttpException, IOException {
        BasicRouteDirector r0 = new BasicRouteDirector();
    L3:
        HttpRoute r1 = this.managedConn.getRoute();
        int r2 = r0.nextStep(r7, r1);
        switch(r2) {
            case -1: goto L14;
            case 0: goto L11;
            case 1: goto L10;
            case 2: goto L10;
            case 3: goto L9;
            case 4: goto L8;
            case 5: goto L7;
            default: goto L6;
        };
    L7:
        this.managedConn.layerProtocol(r8, this.params);
        goto L11
    L8:
        int r3 = r1.getHopCount() - 1;
        boolean r4 = createTunnelToProxy(r7, r3, r8);
        this.log.debug("Tunnel to proxy created.");
        this.managedConn.tunnelProxy(r7.getHopTarget(r3), r4, this.params);
        goto L11
    L9:
        boolean r5 = createTunnelToTarget(r7, r8);
        this.log.debug("Tunnel to target created.");
        this.managedConn.tunnelTarget(r5, this.params);
        goto L11
    L10:
        this.managedConn.open(r7, r8, this.params);
        goto L11
    L6:
        throw new IllegalStateException("Unknown step indicator " + r2 + " from RouteDirector.");
    L14:
        throw new HttpException("Unable to establish route: planned = " + r7 + "; current = " + r1);
    L11:
        if (r2 > 0) goto L3;
    }

    protected boolean createTunnelToTarget(HttpRoute r10, HttpContext r11) throws HttpException, IOException {
        HttpHost r6 = r10.getProxyHost();
        HttpHost r7 = r10.getTargetHost();
    L4:
        if (this.managedConn.isOpen() == true) goto L6;
        this.managedConn.open(r10, r11, this.params);
    L6:
        HttpRequest r0 = createConnectRequest(r10, r11);
        r0.setParams(this.params);
        r11.setAttribute("http.target_host", r7);
        r11.setAttribute("http.route", r10);
        r11.setAttribute(ExecutionContext.HTTP_PROXY_HOST, r6);
        r11.setAttribute("http.connection", this.managedConn);
        r11.setAttribute("http.request", r0);
        this.requestExec.preProcess(r0, this.httpProcessor, r11);
        HttpResponse r8 = this.requestExec.execute(r0, this.managedConn, r11);
        r8.setParams(this.params);
        this.requestExec.postProcess(r8, this.httpProcessor, r11);
        if (r8.getStatusLine().getStatusCode() < 200) goto L28;
        if (HttpClientParams.isAuthenticating(this.params) == false) goto L4;
        if (this.authenticator.isAuthenticationRequested(r6, r8, this.proxyAuthStrategy, this.proxyAuthState, r11) == false) goto L19;
        if (this.authenticator.authenticate(r6, r8, this.proxyAuthStrategy, this.proxyAuthState, r11) == false) goto L19;
        if (this.reuseStrategy.keepAlive(r8, r11) == true) goto L16;
        this.managedConn.close();
        goto L4
    L16:
        this.log.debug("Connection kept alive");
        EntityUtils.consume(r8.getEntity());
    L19:
        if (r8.getStatusLine().getStatusCode() <= 299) goto L25;
        HttpEntity r12 = r8.getEntity();
        if (r12 == null) goto L23;
        r8.setEntity(new BufferedHttpEntity(r12));
    L23:
        this.managedConn.close();
        throw new TunnelRefusedException("CONNECT refused by proxy: " + r8.getStatusLine(), r8);
    L25:
        this.managedConn.markReusable();
        return false;
    L28:
        throw new HttpException("Unexpected response to CONNECT request: " + r8.getStatusLine());
    }

    protected boolean createTunnelToProxy(HttpRoute r1, int r2, HttpContext r3) throws HttpException, IOException {
        throw new HttpException("Proxy chains are not supported.");
    }

    protected HttpRequest createConnectRequest(HttpRoute r3, HttpContext r4) {
        HttpHost r5 = r3.getTargetHost();
        String r6 = r5.getHostName();
        int r0 = r5.getPort();
        if (r0 >= 0) goto L5;
        r0 = this.connManager.getSchemeRegistry().getScheme(r5.getSchemeName()).getDefaultPort();
    L5:
        StringBuilder r7 = new StringBuilder(r6.length() + 6);
        r7.append(r6);
        r7.append(AccessibilityUtils.ENABLED_ACCESSIBILITY_SERVICES_SEPARATOR);
        r7.append(Integer.toString(r0));
        return new BasicHttpRequest("CONNECT", r7.toString(), HttpProtocolParams.getVersion(this.params));
    }

    protected RoutedRequest handleResponse(RoutedRequest r17, HttpResponse r18, HttpContext r19) throws HttpException, IOException {
        HttpRoute r9 = r17.getRoute();
        RequestWrapper r10 = r17.getRequest();
        HttpParams r11 = r10.getParams();
        if (HttpClientParams.isAuthenticating(r11) == false) goto L24;
        HttpHost r1 = (HttpHost) r19.getAttribute("http.target_host");
        if (r1 != null) goto L8;
        r1 = r9.getTargetHost();
    L8:
        if (r1.getPort() >= 0) goto L10;
        HttpHost r12 = new HttpHost(r1.getHostName(), this.connManager.getSchemeRegistry().getScheme(r1).getDefaultPort(), r1.getSchemeName());
    L11:
        boolean r13 = this.authenticator.isAuthenticationRequested(r12, r18, this.targetAuthStrategy, this.targetAuthState, r19);
        HttpHost r2 = r9.getProxyHost();
        if (r2 != null) goto L14;
        r2 = r9.getTargetHost();
    L14:
        HttpHost r14 = r2;
        boolean r15 = this.authenticator.isAuthenticationRequested(r14, r18, this.proxyAuthStrategy, this.proxyAuthState, r19);
        if (r13 == true) goto L17;
    L19:
        if (r15 == false) goto L24;
        if (this.authenticator.authenticate(r14, r18, this.proxyAuthStrategy, this.proxyAuthState, r19) == false) goto L24;
        return r17;
    L17:
        if (this.authenticator.authenticate(r12, r18, this.targetAuthStrategy, this.targetAuthState, r19) == false) goto L19;
        return r17;
    L10:
        r12 = r1;
    L24:
        if (HttpClientParams.isRedirecting(r11) == true) goto L26;
    L46:
        return null;
    L26:
        if (this.redirectStrategy.isRedirected(r10, r18, r19) == false) goto L46;
        int r3 = this.redirectCount;
        if (r3 >= this.maxRedirects) goto L45;
        this.redirectCount = r3 + 1;
        this.virtualHost = null;
        HttpUriRequest r4 = this.redirectStrategy.getRedirect(r10, r18, r19);
        r4.setHeaders(r10.getOriginal().getAllHeaders());
        URI r5 = r4.getURI();
        HttpHost r6 = URIUtils.extractHost(r5);
        if (r6 == null) goto L43;
        if (r9.getTargetHost().equals(r6) == true) goto L38;
        this.log.debug("Resetting target auth state");
        this.targetAuthState.reset();
        AuthScheme r7 = this.proxyAuthState.getAuthScheme();
        if (r7 == null) goto L38;
        if (r7.isConnectionBased() == false) goto L38;
        this.log.debug("Resetting proxy auth state");
        this.proxyAuthState.reset();
    L38:
        RequestWrapper r8 = wrapRequest(r4);
        r8.setParams(r11);
        HttpRoute r16 = determineRoute(r6, r8, r19);
        RoutedRequest r20 = new RoutedRequest(r8, r16);
        if (this.log.isDebugEnabled() == false) goto L41;
        this.log.debug("Redirecting to '" + r5 + "' via " + r16);
    L41:
        return r20;
    L43:
        throw new ProtocolException("Redirect URI does not specify a valid host name: " + r5);
    L45:
        throw new RedirectException("Maximum redirects (" + this.maxRedirects + ") exceeded");
    }

    private void abortConnection() {
        ManagedClientConnection r0 = this.managedConn;
        if (r0 == null) goto L20;
        this.managedConn = null;
        r0.abortConnection();     // Catch: IOException -> L7
    L16:
        r0.releaseConnection();     // Catch: IOException -> L13
        return;
    L13:
        e = move-exception;
        this.log.debug("Error releasing connection", e);
        return;
    L7:
        e = move-exception;
        if (this.log.isDebugEnabled() == false) goto L16;
        this.log.debug(e.getMessage(), e);
        goto L16
    }
}
