package cz.msebera.android.httpclient.impl.client;

import cz.msebera.android.httpclient.ConnectionReuseStrategy;
import cz.msebera.android.httpclient.HttpEntity;
import cz.msebera.android.httpclient.HttpException;
import cz.msebera.android.httpclient.HttpHost;
import cz.msebera.android.httpclient.HttpRequestInterceptor;
import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.HttpVersion;
import cz.msebera.android.httpclient.auth.AuthSchemeRegistry;
import cz.msebera.android.httpclient.auth.AuthScope;
import cz.msebera.android.httpclient.auth.AuthState;
import cz.msebera.android.httpclient.auth.Credentials;
import cz.msebera.android.httpclient.client.config.RequestConfig;
import cz.msebera.android.httpclient.client.params.HttpClientParamConfig;
import cz.msebera.android.httpclient.client.protocol.RequestClientConnControl;
import cz.msebera.android.httpclient.config.ConnectionConfig;
import cz.msebera.android.httpclient.conn.HttpConnectionFactory;
import cz.msebera.android.httpclient.conn.ManagedHttpClientConnection;
import cz.msebera.android.httpclient.conn.routing.HttpRoute;
import cz.msebera.android.httpclient.conn.routing.RouteInfo;
import cz.msebera.android.httpclient.entity.BufferedHttpEntity;
import cz.msebera.android.httpclient.impl.DefaultConnectionReuseStrategy;
import cz.msebera.android.httpclient.impl.auth.BasicSchemeFactory;
import cz.msebera.android.httpclient.impl.auth.DigestSchemeFactory;
import cz.msebera.android.httpclient.impl.auth.NTLMSchemeFactory;
import cz.msebera.android.httpclient.impl.conn.ManagedHttpClientConnectionFactory;
import cz.msebera.android.httpclient.message.BasicHttpRequest;
import cz.msebera.android.httpclient.params.BasicHttpParams;
import cz.msebera.android.httpclient.params.HttpParamConfig;
import cz.msebera.android.httpclient.params.HttpParams;
import cz.msebera.android.httpclient.protocol.BasicHttpContext;
import cz.msebera.android.httpclient.protocol.HttpContext;
import cz.msebera.android.httpclient.protocol.HttpProcessor;
import cz.msebera.android.httpclient.protocol.HttpRequestExecutor;
import cz.msebera.android.httpclient.protocol.ImmutableHttpProcessor;
import cz.msebera.android.httpclient.protocol.RequestTargetHost;
import cz.msebera.android.httpclient.protocol.RequestUserAgent;
import cz.msebera.android.httpclient.util.Args;
import cz.msebera.android.httpclient.util.EntityUtils;
import java.io.IOException;
import java.net.Socket;

/* JADX INFO: loaded from: classes5.dex */
public class ProxyClient {
    private final AuthSchemeRegistry authSchemeRegistry;
    private final cz.msebera.android.httpclient.impl.auth.HttpAuthenticator authenticator;
    private final HttpConnectionFactory<HttpRoute, ManagedHttpClientConnection> connFactory;
    private final ConnectionConfig connectionConfig;
    private final HttpProcessor httpProcessor;
    private final AuthState proxyAuthState;
    private final ProxyAuthenticationStrategy proxyAuthStrategy;
    private final RequestConfig requestConfig;
    private final HttpRequestExecutor requestExec;
    private final ConnectionReuseStrategy reuseStrategy;

    public ProxyClient(HttpConnectionFactory<HttpRoute, ManagedHttpClientConnection> r2, ConnectionConfig r3, RequestConfig r4) {
        if (r2 != null) goto L6;
        r2 = ManagedHttpClientConnectionFactory.INSTANCE;
    L6:
        this.connFactory = r2;
        if (r3 != null) goto L10;
        r3 = ConnectionConfig.DEFAULT;
    L10:
        this.connectionConfig = r3;
        if (r4 != null) goto L14;
        r4 = RequestConfig.DEFAULT;
    L14:
        this.requestConfig = r4;
        this.httpProcessor = new ImmutableHttpProcessor(new HttpRequestInterceptor[]{new RequestTargetHost(), new RequestClientConnControl(), new RequestUserAgent()});
        this.requestExec = new HttpRequestExecutor();
        this.proxyAuthStrategy = new ProxyAuthenticationStrategy();
        this.authenticator = new cz.msebera.android.httpclient.impl.auth.HttpAuthenticator();
        this.proxyAuthState = new AuthState();
        AuthSchemeRegistry r5 = new AuthSchemeRegistry();
        this.authSchemeRegistry = r5;
        r5.register("Basic", new BasicSchemeFactory());
        r5.register("Digest", new DigestSchemeFactory());
        r5.register("NTLM", new NTLMSchemeFactory());
        this.reuseStrategy = new DefaultConnectionReuseStrategy();
    }

    @Deprecated
    public ProxyClient(HttpParams r3) {
        this(null, HttpParamConfig.getConnectionConfig(r3), HttpClientParamConfig.getRequestConfig(r3));
    }

    public ProxyClient(RequestConfig r2) {
        this(null, null, r2);
    }

    public ProxyClient() {
        this(null, null, null);
    }

    @Deprecated
    public HttpParams getParams() {
        return new BasicHttpParams();
    }

    @Deprecated
    public AuthSchemeRegistry getAuthSchemeRegistry() {
        return this.authSchemeRegistry;
    }

    public Socket tunnel(HttpHost r12, HttpHost r13, Credentials r14) throws IOException, HttpException {
        Args.notNull(r12, "Proxy host");
        Args.notNull(r13, "Target host");
        Args.notNull(r14, "Credentials");
        if (r13.getPort() > 0) goto L5;
        HttpHost r0 = new HttpHost(r13.getHostName(), 80, r13.getSchemeName());
    L6:
        HttpRoute r1 = new HttpRoute(r0, this.requestConfig.getLocalAddress(), r12, false, RouteInfo.TunnelType.TUNNELLED, RouteInfo.LayerType.PLAIN);
        ManagedHttpClientConnection r2 = (ManagedHttpClientConnection) this.connFactory.create(r1, this.connectionConfig);
        HttpContext r9 = new BasicHttpContext();
        BasicHttpRequest r10 = new BasicHttpRequest("CONNECT", r0.toHostString(), HttpVersion.HTTP_1_1);
        BasicCredentialsProvider r3 = new BasicCredentialsProvider();
        r3.setCredentials(new AuthScope(r12), r14);
        r9.setAttribute("http.target_host", r13);
        r9.setAttribute("http.connection", r2);
        r9.setAttribute("http.request", r10);
        r9.setAttribute("http.route", r1);
        r9.setAttribute("http.auth.proxy-scope", this.proxyAuthState);
        r9.setAttribute("http.auth.credentials-provider", r3);
        r9.setAttribute("http.authscheme-registry", this.authSchemeRegistry);
        r9.setAttribute("http.request-config", this.requestConfig);
        this.requestExec.preProcess(r10, this.httpProcessor, r9);
    L8:
        if (r2.isOpen() == true) goto L10;
        r2.bind(new Socket(r12.getHostName(), r12.getPort()));
    L10:
        this.authenticator.generateAuthResponse(r10, this.proxyAuthState, r9);
        HttpResponse r15 = this.requestExec.execute(r10, r2, r9);
        if (r15.getStatusLine().getStatusCode() < 200) goto L31;
        if (this.authenticator.isAuthenticationRequested(r12, r15, this.proxyAuthStrategy, this.proxyAuthState, r9) == false) goto L22;
        if (this.authenticator.handleAuthChallenge(r12, r15, this.proxyAuthStrategy, this.proxyAuthState, r9) == false) goto L22;
        if (this.reuseStrategy.keepAlive(r15, r9) == false) goto L19;
        EntityUtils.consume(r15.getEntity());
    L20:
        r10.removeHeaders("Proxy-Authorization");
        goto L8
    L19:
        r2.close();
    L22:
        if (r15.getStatusLine().getStatusCode() <= 299) goto L29;
        HttpEntity r11 = r15.getEntity();
        if (r11 == null) goto L26;
        r15.setEntity(new BufferedHttpEntity(r11));
    L26:
        r2.close();
        throw new cz.msebera.android.httpclient.impl.execchain.TunnelRefusedException("CONNECT refused by proxy: " + r15.getStatusLine(), r15);
    L29:
        return r2.getSocket();
    L31:
        throw new HttpException("Unexpected response to CONNECT request: " + r15.getStatusLine());
    L5:
        r0 = r13;
        goto L6
    }
}
