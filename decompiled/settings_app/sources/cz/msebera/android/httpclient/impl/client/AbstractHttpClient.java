package cz.msebera.android.httpclient.impl.client;

import cz.msebera.android.httpclient.ConnectionReuseStrategy;
import cz.msebera.android.httpclient.HttpException;
import cz.msebera.android.httpclient.HttpHost;
import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.HttpRequestInterceptor;
import cz.msebera.android.httpclient.HttpResponseInterceptor;
import cz.msebera.android.httpclient.auth.AuthSchemeRegistry;
import cz.msebera.android.httpclient.client.AuthenticationHandler;
import cz.msebera.android.httpclient.client.AuthenticationStrategy;
import cz.msebera.android.httpclient.client.BackoffManager;
import cz.msebera.android.httpclient.client.ClientProtocolException;
import cz.msebera.android.httpclient.client.ConnectionBackoffStrategy;
import cz.msebera.android.httpclient.client.CookieStore;
import cz.msebera.android.httpclient.client.CredentialsProvider;
import cz.msebera.android.httpclient.client.HttpRequestRetryHandler;
import cz.msebera.android.httpclient.client.RedirectHandler;
import cz.msebera.android.httpclient.client.RedirectStrategy;
import cz.msebera.android.httpclient.client.RequestDirector;
import cz.msebera.android.httpclient.client.UserTokenHandler;
import cz.msebera.android.httpclient.client.methods.CloseableHttpResponse;
import cz.msebera.android.httpclient.client.params.ClientPNames;
import cz.msebera.android.httpclient.client.params.CookiePolicy;
import cz.msebera.android.httpclient.client.params.HttpClientParamConfig;
import cz.msebera.android.httpclient.client.protocol.ClientContext;
import cz.msebera.android.httpclient.conn.ClientConnectionManager;
import cz.msebera.android.httpclient.conn.ClientConnectionManagerFactory;
import cz.msebera.android.httpclient.conn.ConnectionKeepAliveStrategy;
import cz.msebera.android.httpclient.conn.routing.HttpRoute;
import cz.msebera.android.httpclient.conn.routing.HttpRoutePlanner;
import cz.msebera.android.httpclient.conn.scheme.SchemeRegistry;
import cz.msebera.android.httpclient.cookie.CookieSpecRegistry;
import cz.msebera.android.httpclient.extras.HttpClientAndroidLog;
import cz.msebera.android.httpclient.impl.DefaultConnectionReuseStrategy;
import cz.msebera.android.httpclient.impl.auth.BasicSchemeFactory;
import cz.msebera.android.httpclient.impl.auth.DigestSchemeFactory;
import cz.msebera.android.httpclient.impl.auth.NTLMSchemeFactory;
import cz.msebera.android.httpclient.impl.conn.BasicClientConnectionManager;
import cz.msebera.android.httpclient.impl.conn.DefaultHttpRoutePlanner;
import cz.msebera.android.httpclient.impl.conn.SchemeRegistryFactory;
import cz.msebera.android.httpclient.impl.cookie.BestMatchSpecFactory;
import cz.msebera.android.httpclient.impl.cookie.BrowserCompatSpecFactory;
import cz.msebera.android.httpclient.impl.cookie.IgnoreSpecFactory;
import cz.msebera.android.httpclient.impl.cookie.NetscapeDraftSpecFactory;
import cz.msebera.android.httpclient.impl.cookie.RFC2109SpecFactory;
import cz.msebera.android.httpclient.impl.cookie.RFC2965SpecFactory;
import cz.msebera.android.httpclient.params.HttpParams;
import cz.msebera.android.httpclient.protocol.BasicHttpContext;
import cz.msebera.android.httpclient.protocol.BasicHttpProcessor;
import cz.msebera.android.httpclient.protocol.DefaultedHttpContext;
import cz.msebera.android.httpclient.protocol.HttpContext;
import cz.msebera.android.httpclient.protocol.HttpProcessor;
import cz.msebera.android.httpclient.protocol.HttpRequestExecutor;
import cz.msebera.android.httpclient.protocol.ImmutableHttpProcessor;
import cz.msebera.android.httpclient.util.Args;
import java.io.IOException;
import java.lang.reflect.UndeclaredThrowableException;

/* JADX INFO: loaded from: classes5.dex */
@Deprecated
public abstract class AbstractHttpClient extends CloseableHttpClient {
    private BackoffManager backoffManager;
    private ClientConnectionManager connManager;
    private ConnectionBackoffStrategy connectionBackoffStrategy;
    private CookieStore cookieStore;
    private CredentialsProvider credsProvider;
    private HttpParams defaultParams;
    private ConnectionKeepAliveStrategy keepAliveStrategy;
    public HttpClientAndroidLog log;
    private BasicHttpProcessor mutableProcessor;
    private ImmutableHttpProcessor protocolProcessor;
    private AuthenticationStrategy proxyAuthStrategy;
    private RedirectStrategy redirectStrategy;
    private HttpRequestExecutor requestExec;
    private HttpRequestRetryHandler retryHandler;
    private ConnectionReuseStrategy reuseStrategy;
    private HttpRoutePlanner routePlanner;
    private AuthSchemeRegistry supportedAuthSchemes;
    private CookieSpecRegistry supportedCookieSpecs;
    private AuthenticationStrategy targetAuthStrategy;
    private UserTokenHandler userTokenHandler;

    protected abstract HttpParams createHttpParams();

    protected abstract BasicHttpProcessor createHttpProcessor();

    protected AbstractHttpClient(ClientConnectionManager r3, HttpParams r4) {
        this.log = new HttpClientAndroidLog(getClass());
        this.defaultParams = r4;
        this.connManager = r3;
    }

    protected HttpContext createHttpContext() {
        BasicHttpContext r0 = new BasicHttpContext();
        r0.setAttribute(ClientContext.SCHEME_REGISTRY, getConnectionManager().getSchemeRegistry());
        r0.setAttribute("http.authscheme-registry", getAuthSchemes());
        r0.setAttribute("http.cookiespec-registry", getCookieSpecs());
        r0.setAttribute("http.cookie-store", getCookieStore());
        r0.setAttribute("http.auth.credentials-provider", getCredentialsProvider());
        return r0;
    }

    protected ClientConnectionManager createClientConnectionManager() {
        SchemeRegistry r0 = SchemeRegistryFactory.createDefault();
        HttpParams r4 = getParams();
        String r1 = (String) r4.getParameter(ClientPNames.CONNECTION_MANAGER_FACTORY_CLASS_NAME);
        ClassLoader r2 = Thread.currentThread().getContextClassLoader();
        if (r1 != null) goto L23;
        ClientConnectionManagerFactory r3 = null;
    L19:
        if (r3 == null) goto L22;
        return r3.newInstance(r4, r0);
    L22:
        return new BasicClientConnectionManager(r0);
    L23:
        if (r2 != null) goto L6;
        Class<?> r5 = Class.forName(r1);     // Catch: InstantiationException -> L10 IllegalAccessException -> L13 ClassNotFoundException -> L16
    L8:
        r3 = (ClientConnectionManagerFactory) r5.newInstance();     // Catch: InstantiationException -> L10 IllegalAccessException -> L13 ClassNotFoundException -> L16
        goto L17
    L6:
        r5 = Class.forName(r1, true, r2);     // Catch: InstantiationException -> L10 IllegalAccessException -> L13 ClassNotFoundException -> L16
    L13:
        e = move-exception;
        throw new IllegalAccessError(e.getMessage());
    L10:
        e = move-exception;
        throw new InstantiationError(e.getMessage());
    L17:
        throw new IllegalStateException("Invalid class name: " + r1);
    }

    protected AuthSchemeRegistry createAuthSchemeRegistry() {
        AuthSchemeRegistry r2 = new AuthSchemeRegistry();
        r2.register("Basic", new BasicSchemeFactory());
        r2.register("Digest", new DigestSchemeFactory());
        r2.register("NTLM", new NTLMSchemeFactory());
        return r2;
    }

    protected CookieSpecRegistry createCookieSpecRegistry() {
        CookieSpecRegistry r2 = new CookieSpecRegistry();
        r2.register("default", new BestMatchSpecFactory());
        r2.register("best-match", new BestMatchSpecFactory());
        r2.register("compatibility", new BrowserCompatSpecFactory());
        r2.register("netscape", new NetscapeDraftSpecFactory());
        r2.register(CookiePolicy.RFC_2109, new RFC2109SpecFactory());
        r2.register(CookiePolicy.RFC_2965, new RFC2965SpecFactory());
        r2.register("ignoreCookies", new IgnoreSpecFactory());
        return r2;
    }

    protected HttpRequestExecutor createRequestExecutor() {
        return new HttpRequestExecutor();
    }

    protected ConnectionReuseStrategy createConnectionReuseStrategy() {
        return new DefaultConnectionReuseStrategy();
    }

    protected ConnectionKeepAliveStrategy createConnectionKeepAliveStrategy() {
        return new DefaultConnectionKeepAliveStrategy();
    }

    protected HttpRequestRetryHandler createHttpRequestRetryHandler() {
        return new DefaultHttpRequestRetryHandler();
    }

    @Deprecated
    protected RedirectHandler createRedirectHandler() {
        return new DefaultRedirectHandler();
    }

    protected AuthenticationStrategy createTargetAuthenticationStrategy() {
        return new TargetAuthenticationStrategy();
    }

    @Deprecated
    protected AuthenticationHandler createTargetAuthenticationHandler() {
        return new DefaultTargetAuthenticationHandler();
    }

    protected AuthenticationStrategy createProxyAuthenticationStrategy() {
        return new ProxyAuthenticationStrategy();
    }

    @Deprecated
    protected AuthenticationHandler createProxyAuthenticationHandler() {
        return new DefaultProxyAuthenticationHandler();
    }

    protected CookieStore createCookieStore() {
        return new BasicCookieStore();
    }

    protected CredentialsProvider createCredentialsProvider() {
        return new BasicCredentialsProvider();
    }

    protected HttpRoutePlanner createHttpRoutePlanner() {
        return new DefaultHttpRoutePlanner(getConnectionManager().getSchemeRegistry());
    }

    protected UserTokenHandler createUserTokenHandler() {
        return new DefaultUserTokenHandler();
    }

    @Override // cz.msebera.android.httpclient.client.HttpClient
    public final synchronized HttpParams getParams() {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (this.defaultParams != null) goto L6;
        this.defaultParams = createHttpParams();     // Catch: Throwable -> L9
    L6:
        HttpParams r0 = this.defaultParams;     // Catch: Throwable -> L9
        monitor-exit(this);
        return r0;
    }

    public synchronized void setParams(HttpParams r1) {
        monitor-enter(this);
        this.defaultParams = r1;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // cz.msebera.android.httpclient.client.HttpClient
    public final synchronized ClientConnectionManager getConnectionManager() {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (this.connManager != null) goto L6;
        this.connManager = createClientConnectionManager();     // Catch: Throwable -> L9
    L6:
        ClientConnectionManager r0 = this.connManager;     // Catch: Throwable -> L9
        monitor-exit(this);
        return r0;
    }

    public final synchronized HttpRequestExecutor getRequestExecutor() {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (this.requestExec != null) goto L6;
        this.requestExec = createRequestExecutor();     // Catch: Throwable -> L9
    L6:
        HttpRequestExecutor r0 = this.requestExec;     // Catch: Throwable -> L9
        monitor-exit(this);
        return r0;
    }

    public final synchronized AuthSchemeRegistry getAuthSchemes() {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (this.supportedAuthSchemes != null) goto L6;
        this.supportedAuthSchemes = createAuthSchemeRegistry();     // Catch: Throwable -> L9
    L6:
        AuthSchemeRegistry r0 = this.supportedAuthSchemes;     // Catch: Throwable -> L9
        monitor-exit(this);
        return r0;
    }

    public synchronized void setAuthSchemes(AuthSchemeRegistry r1) {
        monitor-enter(this);
        this.supportedAuthSchemes = r1;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized ConnectionBackoffStrategy getConnectionBackoffStrategy() {
        monitor-enter(this);
        ConnectionBackoffStrategy r0 = this.connectionBackoffStrategy;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized void setConnectionBackoffStrategy(ConnectionBackoffStrategy r1) {
        monitor-enter(this);
        this.connectionBackoffStrategy = r1;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized CookieSpecRegistry getCookieSpecs() {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (this.supportedCookieSpecs != null) goto L6;
        this.supportedCookieSpecs = createCookieSpecRegistry();     // Catch: Throwable -> L9
    L6:
        CookieSpecRegistry r0 = this.supportedCookieSpecs;     // Catch: Throwable -> L9
        monitor-exit(this);
        return r0;
    }

    public final synchronized BackoffManager getBackoffManager() {
        monitor-enter(this);
        BackoffManager r0 = this.backoffManager;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized void setBackoffManager(BackoffManager r1) {
        monitor-enter(this);
        this.backoffManager = r1;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized void setCookieSpecs(CookieSpecRegistry r1) {
        monitor-enter(this);
        this.supportedCookieSpecs = r1;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized ConnectionReuseStrategy getConnectionReuseStrategy() {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (this.reuseStrategy != null) goto L6;
        this.reuseStrategy = createConnectionReuseStrategy();     // Catch: Throwable -> L9
    L6:
        ConnectionReuseStrategy r0 = this.reuseStrategy;     // Catch: Throwable -> L9
        monitor-exit(this);
        return r0;
    }

    public synchronized void setReuseStrategy(ConnectionReuseStrategy r1) {
        monitor-enter(this);
        this.reuseStrategy = r1;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized ConnectionKeepAliveStrategy getConnectionKeepAliveStrategy() {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (this.keepAliveStrategy != null) goto L6;
        this.keepAliveStrategy = createConnectionKeepAliveStrategy();     // Catch: Throwable -> L9
    L6:
        ConnectionKeepAliveStrategy r0 = this.keepAliveStrategy;     // Catch: Throwable -> L9
        monitor-exit(this);
        return r0;
    }

    public synchronized void setKeepAliveStrategy(ConnectionKeepAliveStrategy r1) {
        monitor-enter(this);
        this.keepAliveStrategy = r1;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized HttpRequestRetryHandler getHttpRequestRetryHandler() {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (this.retryHandler != null) goto L6;
        this.retryHandler = createHttpRequestRetryHandler();     // Catch: Throwable -> L9
    L6:
        HttpRequestRetryHandler r0 = this.retryHandler;     // Catch: Throwable -> L9
        monitor-exit(this);
        return r0;
    }

    public synchronized void setHttpRequestRetryHandler(HttpRequestRetryHandler r1) {
        monitor-enter(this);
        this.retryHandler = r1;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Deprecated
    public final synchronized RedirectHandler getRedirectHandler() {
        monitor-enter(this);
        RedirectHandler r0 = createRedirectHandler();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    @Deprecated
    public synchronized void setRedirectHandler(RedirectHandler r2) {
        monitor-enter(this);
        this.redirectStrategy = new DefaultRedirectStrategyAdaptor(r2);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized RedirectStrategy getRedirectStrategy() {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (this.redirectStrategy != null) goto L6;
        this.redirectStrategy = new DefaultRedirectStrategy();     // Catch: Throwable -> L9
    L6:
        RedirectStrategy r0 = this.redirectStrategy;     // Catch: Throwable -> L9
        monitor-exit(this);
        return r0;
    }

    public synchronized void setRedirectStrategy(RedirectStrategy r1) {
        monitor-enter(this);
        this.redirectStrategy = r1;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Deprecated
    public final synchronized AuthenticationHandler getTargetAuthenticationHandler() {
        monitor-enter(this);
        AuthenticationHandler r0 = createTargetAuthenticationHandler();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    @Deprecated
    public synchronized void setTargetAuthenticationHandler(AuthenticationHandler r2) {
        monitor-enter(this);
        this.targetAuthStrategy = new AuthenticationStrategyAdaptor(r2);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized AuthenticationStrategy getTargetAuthenticationStrategy() {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (this.targetAuthStrategy != null) goto L6;
        this.targetAuthStrategy = createTargetAuthenticationStrategy();     // Catch: Throwable -> L9
    L6:
        AuthenticationStrategy r0 = this.targetAuthStrategy;     // Catch: Throwable -> L9
        monitor-exit(this);
        return r0;
    }

    public synchronized void setTargetAuthenticationStrategy(AuthenticationStrategy r1) {
        monitor-enter(this);
        this.targetAuthStrategy = r1;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Deprecated
    public final synchronized AuthenticationHandler getProxyAuthenticationHandler() {
        monitor-enter(this);
        AuthenticationHandler r0 = createProxyAuthenticationHandler();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    @Deprecated
    public synchronized void setProxyAuthenticationHandler(AuthenticationHandler r2) {
        monitor-enter(this);
        this.proxyAuthStrategy = new AuthenticationStrategyAdaptor(r2);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized AuthenticationStrategy getProxyAuthenticationStrategy() {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (this.proxyAuthStrategy != null) goto L6;
        this.proxyAuthStrategy = createProxyAuthenticationStrategy();     // Catch: Throwable -> L9
    L6:
        AuthenticationStrategy r0 = this.proxyAuthStrategy;     // Catch: Throwable -> L9
        monitor-exit(this);
        return r0;
    }

    public synchronized void setProxyAuthenticationStrategy(AuthenticationStrategy r1) {
        monitor-enter(this);
        this.proxyAuthStrategy = r1;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized CookieStore getCookieStore() {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (this.cookieStore != null) goto L6;
        this.cookieStore = createCookieStore();     // Catch: Throwable -> L9
    L6:
        CookieStore r0 = this.cookieStore;     // Catch: Throwable -> L9
        monitor-exit(this);
        return r0;
    }

    public synchronized void setCookieStore(CookieStore r1) {
        monitor-enter(this);
        this.cookieStore = r1;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized CredentialsProvider getCredentialsProvider() {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (this.credsProvider != null) goto L6;
        this.credsProvider = createCredentialsProvider();     // Catch: Throwable -> L9
    L6:
        CredentialsProvider r0 = this.credsProvider;     // Catch: Throwable -> L9
        monitor-exit(this);
        return r0;
    }

    public synchronized void setCredentialsProvider(CredentialsProvider r1) {
        monitor-enter(this);
        this.credsProvider = r1;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized HttpRoutePlanner getRoutePlanner() {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (this.routePlanner != null) goto L6;
        this.routePlanner = createHttpRoutePlanner();     // Catch: Throwable -> L9
    L6:
        HttpRoutePlanner r0 = this.routePlanner;     // Catch: Throwable -> L9
        monitor-exit(this);
        return r0;
    }

    public synchronized void setRoutePlanner(HttpRoutePlanner r1) {
        monitor-enter(this);
        this.routePlanner = r1;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized UserTokenHandler getUserTokenHandler() {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (this.userTokenHandler != null) goto L6;
        this.userTokenHandler = createUserTokenHandler();     // Catch: Throwable -> L9
    L6:
        UserTokenHandler r0 = this.userTokenHandler;     // Catch: Throwable -> L9
        monitor-exit(this);
        return r0;
    }

    public synchronized void setUserTokenHandler(UserTokenHandler r1) {
        monitor-enter(this);
        this.userTokenHandler = r1;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    protected final synchronized BasicHttpProcessor getHttpProcessor() {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (this.mutableProcessor != null) goto L6;
        this.mutableProcessor = createHttpProcessor();     // Catch: Throwable -> L9
    L6:
        BasicHttpProcessor r0 = this.mutableProcessor;     // Catch: Throwable -> L9
        monitor-exit(this);
        return r0;
    }

    private synchronized HttpProcessor getProtocolProcessor() {
        monitor-enter(this);
    L15:
        th = move-exception;
        throw th;
    L4:
        if (this.protocolProcessor != null) goto L12;
        BasicHttpProcessor r0 = getHttpProcessor();     // Catch: Throwable -> L15
        int r1 = r0.getRequestInterceptorCount();     // Catch: Throwable -> L15
        HttpRequestInterceptor[] r2 = new HttpRequestInterceptor[r1];     // Catch: Throwable -> L15
        int r3 = 0;
        int r4 = 0;
    L6:
        if (r4 >= r1) goto L8;
        r2[r4] = r0.getRequestInterceptor(r4);     // Catch: Throwable -> L15
        r4 = r4 + 1;     // Catch: Throwable -> L15
        goto L6
    L8:
        int r5 = r0.getResponseInterceptorCount();     // Catch: Throwable -> L15
        HttpResponseInterceptor[] r6 = new HttpResponseInterceptor[r5];     // Catch: Throwable -> L15
    L9:
        if (r3 >= r5) goto L11;
        r6[r3] = r0.getResponseInterceptor(r3);     // Catch: Throwable -> L15
        r3 = r3 + 1;     // Catch: Throwable -> L15
        goto L9
    L11:
        this.protocolProcessor = new ImmutableHttpProcessor(r2, r6);     // Catch: Throwable -> L15
    L12:
        ImmutableHttpProcessor r7 = this.protocolProcessor;     // Catch: Throwable -> L15
        monitor-exit(this);
        return r7;
    }

    public synchronized int getResponseInterceptorCount() {
        monitor-enter(this);
        int r0 = getHttpProcessor().getResponseInterceptorCount();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized HttpResponseInterceptor getResponseInterceptor(int r2) {
        monitor-enter(this);
        HttpResponseInterceptor r3 = getHttpProcessor().getResponseInterceptor(r2);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r3;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized HttpRequestInterceptor getRequestInterceptor(int r2) {
        monitor-enter(this);
        HttpRequestInterceptor r3 = getHttpProcessor().getRequestInterceptor(r2);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r3;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized int getRequestInterceptorCount() {
        monitor-enter(this);
        int r0 = getHttpProcessor().getRequestInterceptorCount();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized void addResponseInterceptor(HttpResponseInterceptor r2) {
        monitor-enter(this);
        getHttpProcessor().addInterceptor(r2);     // Catch: Throwable -> L6
        this.protocolProcessor = null;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized void addResponseInterceptor(HttpResponseInterceptor r2, int r3) {
        monitor-enter(this);
        getHttpProcessor().addInterceptor(r2, r3);     // Catch: Throwable -> L6
        this.protocolProcessor = null;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized void clearResponseInterceptors() {
        monitor-enter(this);
        getHttpProcessor().clearResponseInterceptors();     // Catch: Throwable -> L6
        this.protocolProcessor = null;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized void removeResponseInterceptorByClass(Class<? extends HttpResponseInterceptor> r2) {
        monitor-enter(this);
        getHttpProcessor().removeResponseInterceptorByClass(r2);     // Catch: Throwable -> L6
        this.protocolProcessor = null;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized void addRequestInterceptor(HttpRequestInterceptor r2) {
        monitor-enter(this);
        getHttpProcessor().addInterceptor(r2);     // Catch: Throwable -> L6
        this.protocolProcessor = null;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized void addRequestInterceptor(HttpRequestInterceptor r2, int r3) {
        monitor-enter(this);
        getHttpProcessor().addInterceptor(r2, r3);     // Catch: Throwable -> L6
        this.protocolProcessor = null;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized void clearRequestInterceptors() {
        monitor-enter(this);
        getHttpProcessor().clearRequestInterceptors();     // Catch: Throwable -> L6
        this.protocolProcessor = null;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized void removeRequestInterceptorByClass(Class<? extends HttpRequestInterceptor> r2) {
        monitor-enter(this);
        getHttpProcessor().removeRequestInterceptorByClass(r2);     // Catch: Throwable -> L6
        this.protocolProcessor = null;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // cz.msebera.android.httpclient.impl.client.CloseableHttpClient
    protected final CloseableHttpResponse doExecute(HttpHost r19, HttpRequest r20, HttpContext r21) throws IOException, ClientProtocolException {
        Args.notNull(r20, "HTTP request");
        monitor-enter(this);
        HttpContext r2 = createHttpContext();     // Catch: Throwable -> L47
        if (r21 != null) goto L7;
        HttpContext r13 = r2;
    L8:
        HttpParams r16 = determineParams(r20);     // Catch: Throwable -> L47
        r13.setAttribute("http.request-config", HttpClientParamConfig.getRequestConfig(r16));     // Catch: Throwable -> L47
        HttpContext r17 = r13;
        RequestDirector r1 = createClientRequestDirector(getRequestExecutor(), getConnectionManager(), getConnectionReuseStrategy(), getConnectionKeepAliveStrategy(), getRoutePlanner(), getProtocolProcessor(), getHttpRequestRetryHandler(), getRedirectStrategy(), getTargetAuthenticationStrategy(), getProxyAuthenticationStrategy(), getUserTokenHandler(), r16);     // Catch: Throwable -> L47
        HttpRoutePlanner r3 = getRoutePlanner();     // Catch: Throwable -> L47
        ConnectionBackoffStrategy r4 = getConnectionBackoffStrategy();     // Catch: Throwable -> L47
        BackoffManager r5 = getBackoffManager();     // Catch: Throwable -> L47
        monitor-exit(this);     // Catch: Throwable -> L47
        if (r4 == null) goto L43;
        if (r5 == null) goto L43;
        if (r19 == null) goto L15;
        HttpHost r6 = r19;
    L16:
        HttpRoute r7 = r3.determineRoute(r6, r20, r17);     // Catch: HttpException -> L44
        CloseableHttpResponse r0 = CloseableHttpResponseProxy.newProxy(r1.execute(r19, r20, r17));     // Catch: Exception -> L23 RuntimeException -> L37 HttpException -> L44
    L19:
        if (r4.shouldBackoff(r0) == false) goto L21;
        r5.backOff(r7);     // Catch: HttpException -> L44
    L22:
        return r0;
    L21:
        r5.probe(r7);     // Catch: HttpException -> L44
    L37:
        e = move-exception;
        if (r4.shouldBackoff(e) == false) goto L41;
        r5.backOff(r7);     // Catch: HttpException -> L44
    L41:
        throw e;     // Catch: HttpException -> L44
    L23:
        e = move-exception;
        if (r4.shouldBackoff(e) == false) goto L28;
        r5.backOff(r7);     // Catch: HttpException -> L44
    L28:
        if ((e instanceof HttpException) == true) goto L36;
        if ((e instanceof IOException) == false) goto L34;
        throw ((IOException) e);     // Catch: HttpException -> L44
    L34:
        throw new UndeclaredThrowableException(e);     // Catch: HttpException -> L44
    L36:
        throw ((HttpException) e);     // Catch: HttpException -> L44
    L15:
        r6 = (HttpHost) determineParams(r20).getParameter(ClientPNames.DEFAULT_HOST);     // Catch: HttpException -> L44
    L43:
        return CloseableHttpResponseProxy.newProxy(r1.execute(r19, r20, r17));
    L44:
        e = move-exception;
        throw new ClientProtocolException(e);
    L7:
        r13 = new DefaultedHttpContext(r21, r2);     // Catch: Throwable -> L47
    L47:
        th = move-exception;
        throw th;
    }

    @Deprecated
    protected RequestDirector createClientRequestDirector(HttpRequestExecutor r15, ClientConnectionManager r16, ConnectionReuseStrategy r17, ConnectionKeepAliveStrategy r18, HttpRoutePlanner r19, HttpProcessor r20, HttpRequestRetryHandler r21, RedirectHandler r22, AuthenticationHandler r23, AuthenticationHandler r24, UserTokenHandler r25, HttpParams r26) {
        return new DefaultRequestDirector(r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26);
    }

    @Deprecated
    protected RequestDirector createClientRequestDirector(HttpRequestExecutor r16, ClientConnectionManager r17, ConnectionReuseStrategy r18, ConnectionKeepAliveStrategy r19, HttpRoutePlanner r20, HttpProcessor r21, HttpRequestRetryHandler r22, RedirectStrategy r23, AuthenticationHandler r24, AuthenticationHandler r25, UserTokenHandler r26, HttpParams r27) {
        return new DefaultRequestDirector(this.log, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27);
    }

    protected RequestDirector createClientRequestDirector(HttpRequestExecutor r16, ClientConnectionManager r17, ConnectionReuseStrategy r18, ConnectionKeepAliveStrategy r19, HttpRoutePlanner r20, HttpProcessor r21, HttpRequestRetryHandler r22, RedirectStrategy r23, AuthenticationStrategy r24, AuthenticationStrategy r25, UserTokenHandler r26, HttpParams r27) {
        return new DefaultRequestDirector(this.log, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27);
    }

    protected HttpParams determineParams(HttpRequest r3) {
        return new ClientParamsStack(null, getParams(), r3.getParams(), null);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        getConnectionManager().shutdown();
    }
}
