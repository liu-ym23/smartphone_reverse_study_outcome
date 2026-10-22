package cz.msebera.android.httpclient.impl.client;

import cz.msebera.android.httpclient.HttpException;
import cz.msebera.android.httpclient.HttpHost;
import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.auth.AuthSchemeProvider;
import cz.msebera.android.httpclient.auth.AuthState;
import cz.msebera.android.httpclient.client.ClientProtocolException;
import cz.msebera.android.httpclient.client.CookieStore;
import cz.msebera.android.httpclient.client.CredentialsProvider;
import cz.msebera.android.httpclient.client.config.RequestConfig;
import cz.msebera.android.httpclient.client.methods.CloseableHttpResponse;
import cz.msebera.android.httpclient.client.methods.Configurable;
import cz.msebera.android.httpclient.client.methods.HttpExecutionAware;
import cz.msebera.android.httpclient.client.methods.HttpRequestWrapper;
import cz.msebera.android.httpclient.client.params.ClientPNames;
import cz.msebera.android.httpclient.client.params.HttpClientParamConfig;
import cz.msebera.android.httpclient.client.protocol.HttpClientContext;
import cz.msebera.android.httpclient.config.Lookup;
import cz.msebera.android.httpclient.conn.ClientConnectionManager;
import cz.msebera.android.httpclient.conn.HttpClientConnectionManager;
import cz.msebera.android.httpclient.conn.routing.HttpRoute;
import cz.msebera.android.httpclient.conn.routing.HttpRoutePlanner;
import cz.msebera.android.httpclient.cookie.CookieSpecProvider;
import cz.msebera.android.httpclient.extras.HttpClientAndroidLog;
import cz.msebera.android.httpclient.impl.execchain.ClientExecChain;
import cz.msebera.android.httpclient.params.HttpParams;
import cz.msebera.android.httpclient.params.HttpParamsNames;
import cz.msebera.android.httpclient.protocol.BasicHttpContext;
import cz.msebera.android.httpclient.protocol.HttpContext;
import cz.msebera.android.httpclient.util.Args;
import java.io.Closeable;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
class InternalHttpClient extends CloseableHttpClient implements Configurable {
    private final Lookup<AuthSchemeProvider> authSchemeRegistry;
    private final List<Closeable> closeables;
    private final HttpClientConnectionManager connManager;
    private final Lookup<CookieSpecProvider> cookieSpecRegistry;
    private final CookieStore cookieStore;
    private final CredentialsProvider credentialsProvider;
    private final RequestConfig defaultConfig;
    private final ClientExecChain execChain;
    public HttpClientAndroidLog log;
    private final HttpRoutePlanner routePlanner;

    static /* synthetic */ HttpClientConnectionManager access$000(InternalHttpClient r0) {
        return r0.connManager;
    }

    public InternalHttpClient(ClientExecChain r3, HttpClientConnectionManager r4, HttpRoutePlanner r5, Lookup<CookieSpecProvider> r6, Lookup<AuthSchemeProvider> r7, CookieStore r8, CredentialsProvider r9, RequestConfig r10, List<Closeable> r11) {
        this.log = new HttpClientAndroidLog(getClass());
        Args.notNull(r3, "HTTP client exec chain");
        Args.notNull(r4, "HTTP connection manager");
        Args.notNull(r5, "HTTP route planner");
        this.execChain = r3;
        this.connManager = r4;
        this.routePlanner = r5;
        this.cookieSpecRegistry = r6;
        this.authSchemeRegistry = r7;
        this.cookieStore = r8;
        this.credentialsProvider = r9;
        this.defaultConfig = r10;
        this.closeables = r11;
    }

    private HttpRoute determineRoute(HttpHost r2, HttpRequest r3, HttpContext r4) throws HttpException {
        if (r2 != null) goto L5;
        r2 = (HttpHost) r3.getParams().getParameter(ClientPNames.DEFAULT_HOST);
    L5:
        return this.routePlanner.determineRoute(r2, r3, r4);
    }

    private void setupContext(HttpClientContext r3) {
        if (r3.getAttribute("http.auth.target-scope") != null) goto L6;
        r3.setAttribute("http.auth.target-scope", new AuthState());
    L6:
        if (r3.getAttribute("http.auth.proxy-scope") != null) goto L9;
        r3.setAttribute("http.auth.proxy-scope", new AuthState());
    L9:
        if (r3.getAttribute("http.authscheme-registry") != null) goto L12;
        r3.setAttribute("http.authscheme-registry", this.authSchemeRegistry);
    L12:
        if (r3.getAttribute("http.cookiespec-registry") != null) goto L15;
        r3.setAttribute("http.cookiespec-registry", this.cookieSpecRegistry);
    L15:
        if (r3.getAttribute("http.cookie-store") != null) goto L18;
        r3.setAttribute("http.cookie-store", this.cookieStore);
    L18:
        if (r3.getAttribute("http.auth.credentials-provider") != null) goto L21;
        r3.setAttribute("http.auth.credentials-provider", this.credentialsProvider);
    L21:
        if (r3.getAttribute("http.request-config") != null) goto L24;
        r3.setAttribute("http.request-config", this.defaultConfig);
        return;
    }

    @Override // cz.msebera.android.httpclient.impl.client.CloseableHttpClient
    protected CloseableHttpResponse doExecute(HttpHost r5, HttpRequest r6, HttpContext r7) throws IOException, ClientProtocolException {
        Args.notNull(r6, "HTTP request");
        RequestConfig r1 = null;
        if ((r6 instanceof HttpExecutionAware) == false) goto L5;
        HttpExecutionAware r0 = (HttpExecutionAware) r6;
    L27:
        HttpRequestWrapper r2 = HttpRequestWrapper.wrap(r6, r5);     // Catch: HttpException -> L24
        if (r7 != null) goto L10;
        r7 = new BasicHttpContext();     // Catch: HttpException -> L24
    L10:
        HttpClientContext r8 = HttpClientContext.adapt(r7);     // Catch: HttpException -> L24
        if ((r6 instanceof Configurable) == false) goto L13;
        r1 = ((Configurable) r6).getConfig();     // Catch: HttpException -> L24
    L13:
        if (r1 != null) goto L20;
        HttpParams r9 = r6.getParams();     // Catch: HttpException -> L24
        if ((r9 instanceof HttpParamsNames) == true) goto L17;
        r1 = HttpClientParamConfig.getRequestConfig(r9, this.defaultConfig);     // Catch: HttpException -> L24
        goto L20
    L17:
        if (((HttpParamsNames) r9).getNames().isEmpty() == true) goto L20;
        r1 = HttpClientParamConfig.getRequestConfig(r9, this.defaultConfig);     // Catch: HttpException -> L24
    L20:
        if (r1 == null) goto L22;
        r8.setRequestConfig(r1);     // Catch: HttpException -> L24
    L22:
        setupContext(r8);     // Catch: HttpException -> L24
        return this.execChain.execute(determineRoute(r5, r2, r8), r2, r8, r0);
    L24:
        e = move-exception;
        throw new ClientProtocolException(e);
    L5:
        r0 = null;
        goto L27
    }

    @Override // cz.msebera.android.httpclient.client.methods.Configurable
    public RequestConfig getConfig() {
        return this.defaultConfig;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        List<Closeable> r0 = this.closeables;
        if (r0 == null) goto L12;
        Iterator<Closeable> r1 = r0.iterator();
    L6:
        if (r1.hasNext() == false) goto L19;
        r1.next().close();     // Catch: IOException -> L10
    L10:
        e = move-exception;
        this.log.error(e.getMessage(), e);
        goto L6
    L19:
        return;
    }

    @Override // cz.msebera.android.httpclient.client.HttpClient
    public HttpParams getParams() {
        throw new UnsupportedOperationException();
    }

    @Override // cz.msebera.android.httpclient.client.HttpClient
    public ClientConnectionManager getConnectionManager() {
        return new AnonymousClass1(this);
    }
}
