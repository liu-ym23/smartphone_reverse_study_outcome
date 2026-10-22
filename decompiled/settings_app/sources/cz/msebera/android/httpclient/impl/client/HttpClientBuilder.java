package cz.msebera.android.httpclient.impl.client;

import cz.msebera.android.httpclient.ConnectionReuseStrategy;
import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HttpHost;
import cz.msebera.android.httpclient.HttpRequestInterceptor;
import cz.msebera.android.httpclient.HttpResponseInterceptor;
import cz.msebera.android.httpclient.auth.AuthSchemeProvider;
import cz.msebera.android.httpclient.client.AuthenticationStrategy;
import cz.msebera.android.httpclient.client.BackoffManager;
import cz.msebera.android.httpclient.client.ConnectionBackoffStrategy;
import cz.msebera.android.httpclient.client.CookieStore;
import cz.msebera.android.httpclient.client.CredentialsProvider;
import cz.msebera.android.httpclient.client.HttpRequestRetryHandler;
import cz.msebera.android.httpclient.client.RedirectStrategy;
import cz.msebera.android.httpclient.client.ServiceUnavailableRetryStrategy;
import cz.msebera.android.httpclient.client.UserTokenHandler;
import cz.msebera.android.httpclient.client.config.RequestConfig;
import cz.msebera.android.httpclient.client.entity.InputStreamFactory;
import cz.msebera.android.httpclient.client.protocol.RequestAcceptEncoding;
import cz.msebera.android.httpclient.client.protocol.RequestAddCookies;
import cz.msebera.android.httpclient.client.protocol.RequestAuthCache;
import cz.msebera.android.httpclient.client.protocol.RequestClientConnControl;
import cz.msebera.android.httpclient.client.protocol.RequestDefaultHeaders;
import cz.msebera.android.httpclient.client.protocol.RequestExpectContinue;
import cz.msebera.android.httpclient.client.protocol.ResponseContentEncoding;
import cz.msebera.android.httpclient.client.protocol.ResponseProcessCookies;
import cz.msebera.android.httpclient.config.ConnectionConfig;
import cz.msebera.android.httpclient.config.Lookup;
import cz.msebera.android.httpclient.config.Registry;
import cz.msebera.android.httpclient.config.RegistryBuilder;
import cz.msebera.android.httpclient.config.SocketConfig;
import cz.msebera.android.httpclient.conn.ConnectionKeepAliveStrategy;
import cz.msebera.android.httpclient.conn.DnsResolver;
import cz.msebera.android.httpclient.conn.HttpClientConnectionManager;
import cz.msebera.android.httpclient.conn.SchemePortResolver;
import cz.msebera.android.httpclient.conn.routing.HttpRoutePlanner;
import cz.msebera.android.httpclient.conn.socket.ConnectionSocketFactory;
import cz.msebera.android.httpclient.conn.socket.LayeredConnectionSocketFactory;
import cz.msebera.android.httpclient.conn.socket.PlainConnectionSocketFactory;
import cz.msebera.android.httpclient.conn.ssl.DefaultHostnameVerifier;
import cz.msebera.android.httpclient.conn.ssl.SSLConnectionSocketFactory;
import cz.msebera.android.httpclient.conn.ssl.X509HostnameVerifier;
import cz.msebera.android.httpclient.conn.util.PublicSuffixMatcher;
import cz.msebera.android.httpclient.conn.util.PublicSuffixMatcherLoader;
import cz.msebera.android.httpclient.cookie.CookieSpecProvider;
import cz.msebera.android.httpclient.impl.NoConnectionReuseStrategy;
import cz.msebera.android.httpclient.impl.auth.BasicSchemeFactory;
import cz.msebera.android.httpclient.impl.auth.DigestSchemeFactory;
import cz.msebera.android.httpclient.impl.auth.NTLMSchemeFactory;
import cz.msebera.android.httpclient.impl.conn.DefaultProxyRoutePlanner;
import cz.msebera.android.httpclient.impl.conn.DefaultRoutePlanner;
import cz.msebera.android.httpclient.impl.conn.DefaultSchemePortResolver;
import cz.msebera.android.httpclient.impl.conn.PoolingHttpClientConnectionManager;
import cz.msebera.android.httpclient.impl.conn.SystemDefaultRoutePlanner;
import cz.msebera.android.httpclient.impl.execchain.BackoffStrategyExec;
import cz.msebera.android.httpclient.impl.execchain.ClientExecChain;
import cz.msebera.android.httpclient.impl.execchain.MainClientExec;
import cz.msebera.android.httpclient.impl.execchain.ProtocolExec;
import cz.msebera.android.httpclient.impl.execchain.RedirectExec;
import cz.msebera.android.httpclient.impl.execchain.RetryExec;
import cz.msebera.android.httpclient.impl.execchain.ServiceUnavailableRetryExec;
import cz.msebera.android.httpclient.protocol.HttpProcessor;
import cz.msebera.android.httpclient.protocol.HttpProcessorBuilder;
import cz.msebera.android.httpclient.protocol.HttpRequestExecutor;
import cz.msebera.android.httpclient.protocol.ImmutableHttpProcessor;
import cz.msebera.android.httpclient.protocol.RequestContent;
import cz.msebera.android.httpclient.protocol.RequestTargetHost;
import cz.msebera.android.httpclient.protocol.RequestUserAgent;
import cz.msebera.android.httpclient.ssl.SSLContexts;
import cz.msebera.android.httpclient.util.TextUtils;
import cz.msebera.android.httpclient.util.VersionInfo;
import java.io.Closeable;
import java.net.ProxySelector;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import obric.time.HttpHeadTimeFetcher;

/* JADX INFO: loaded from: classes5.dex */
public class HttpClientBuilder {
    private boolean authCachingDisabled;
    private Lookup<AuthSchemeProvider> authSchemeRegistry;
    private boolean automaticRetriesDisabled;
    private BackoffManager backoffManager;
    private List<Closeable> closeables;
    private HttpClientConnectionManager connManager;
    private boolean connManagerShared;
    private long connTimeToLive;
    private TimeUnit connTimeToLiveTimeUnit;
    private ConnectionBackoffStrategy connectionBackoffStrategy;
    private boolean connectionStateDisabled;
    private boolean contentCompressionDisabled;
    private Map<String, InputStreamFactory> contentDecoderMap;
    private boolean cookieManagementDisabled;
    private Lookup<CookieSpecProvider> cookieSpecRegistry;
    private CookieStore cookieStore;
    private CredentialsProvider credentialsProvider;
    private ConnectionConfig defaultConnectionConfig;
    private Collection<? extends Header> defaultHeaders;
    private RequestConfig defaultRequestConfig;
    private SocketConfig defaultSocketConfig;
    private boolean defaultUserAgentDisabled;
    private DnsResolver dnsResolver;
    private boolean evictExpiredConnections;
    private boolean evictIdleConnections;
    private HostnameVerifier hostnameVerifier;
    private HttpProcessor httpprocessor;
    private ConnectionKeepAliveStrategy keepAliveStrategy;
    private int maxConnPerRoute;
    private int maxConnTotal;
    private long maxIdleTime;
    private TimeUnit maxIdleTimeUnit;
    private HttpHost proxy;
    private AuthenticationStrategy proxyAuthStrategy;
    private PublicSuffixMatcher publicSuffixMatcher;
    private boolean redirectHandlingDisabled;
    private RedirectStrategy redirectStrategy;
    private HttpRequestExecutor requestExec;
    private LinkedList<HttpRequestInterceptor> requestFirst;
    private LinkedList<HttpRequestInterceptor> requestLast;
    private LinkedList<HttpResponseInterceptor> responseFirst;
    private LinkedList<HttpResponseInterceptor> responseLast;
    private HttpRequestRetryHandler retryHandler;
    private ConnectionReuseStrategy reuseStrategy;
    private HttpRoutePlanner routePlanner;
    private SchemePortResolver schemePortResolver;
    private ServiceUnavailableRetryStrategy serviceUnavailStrategy;
    private SSLContext sslContext;
    private LayeredConnectionSocketFactory sslSocketFactory;
    private boolean systemProperties;
    private AuthenticationStrategy targetAuthStrategy;
    private String userAgent;
    private UserTokenHandler userTokenHandler;

    protected ClientExecChain decorateMainExec(ClientExecChain r1) {
        return r1;
    }

    protected ClientExecChain decorateProtocolExec(ClientExecChain r1) {
        return r1;
    }

    public static HttpClientBuilder create() {
        return new HttpClientBuilder();
    }

    protected HttpClientBuilder() {
        this.maxConnTotal = 0;
        this.maxConnPerRoute = 0;
        this.connTimeToLive = -1;
        this.connTimeToLiveTimeUnit = TimeUnit.MILLISECONDS;
    }

    public final HttpClientBuilder setRequestExecutor(HttpRequestExecutor r1) {
        this.requestExec = r1;
        return this;
    }

    @Deprecated
    public final HttpClientBuilder setHostnameVerifier(X509HostnameVerifier r1) {
        this.hostnameVerifier = r1;
        return this;
    }

    public final HttpClientBuilder setSSLHostnameVerifier(HostnameVerifier r1) {
        this.hostnameVerifier = r1;
        return this;
    }

    public final HttpClientBuilder setPublicSuffixMatcher(PublicSuffixMatcher r1) {
        this.publicSuffixMatcher = r1;
        return this;
    }

    @Deprecated
    public final HttpClientBuilder setSslcontext(SSLContext r1) {
        return setSSLContext(r1);
    }

    public final HttpClientBuilder setSSLContext(SSLContext r1) {
        this.sslContext = r1;
        return this;
    }

    public final HttpClientBuilder setSSLSocketFactory(LayeredConnectionSocketFactory r1) {
        this.sslSocketFactory = r1;
        return this;
    }

    public final HttpClientBuilder setMaxConnTotal(int r1) {
        this.maxConnTotal = r1;
        return this;
    }

    public final HttpClientBuilder setMaxConnPerRoute(int r1) {
        this.maxConnPerRoute = r1;
        return this;
    }

    public final HttpClientBuilder setDefaultSocketConfig(SocketConfig r1) {
        this.defaultSocketConfig = r1;
        return this;
    }

    public final HttpClientBuilder setDefaultConnectionConfig(ConnectionConfig r1) {
        this.defaultConnectionConfig = r1;
        return this;
    }

    public final HttpClientBuilder setConnectionTimeToLive(long r1, TimeUnit r3) {
        this.connTimeToLive = r1;
        this.connTimeToLiveTimeUnit = r3;
        return this;
    }

    public final HttpClientBuilder setConnectionManager(HttpClientConnectionManager r1) {
        this.connManager = r1;
        return this;
    }

    public final HttpClientBuilder setConnectionManagerShared(boolean r1) {
        this.connManagerShared = r1;
        return this;
    }

    public final HttpClientBuilder setConnectionReuseStrategy(ConnectionReuseStrategy r1) {
        this.reuseStrategy = r1;
        return this;
    }

    public final HttpClientBuilder setKeepAliveStrategy(ConnectionKeepAliveStrategy r1) {
        this.keepAliveStrategy = r1;
        return this;
    }

    public final HttpClientBuilder setTargetAuthenticationStrategy(AuthenticationStrategy r1) {
        this.targetAuthStrategy = r1;
        return this;
    }

    public final HttpClientBuilder setProxyAuthenticationStrategy(AuthenticationStrategy r1) {
        this.proxyAuthStrategy = r1;
        return this;
    }

    public final HttpClientBuilder setUserTokenHandler(UserTokenHandler r1) {
        this.userTokenHandler = r1;
        return this;
    }

    public final HttpClientBuilder disableConnectionState() {
        this.connectionStateDisabled = true;
        return this;
    }

    public final HttpClientBuilder setSchemePortResolver(SchemePortResolver r1) {
        this.schemePortResolver = r1;
        return this;
    }

    public final HttpClientBuilder setUserAgent(String r1) {
        this.userAgent = r1;
        return this;
    }

    public final HttpClientBuilder setDefaultHeaders(Collection<? extends Header> r1) {
        this.defaultHeaders = r1;
        return this;
    }

    public final HttpClientBuilder addInterceptorFirst(HttpResponseInterceptor r2) {
        if (r2 != null) goto L5;
        return this;
    L5:
        if (this.responseFirst != null) goto L7;
        this.responseFirst = new LinkedList();
    L7:
        this.responseFirst.addFirst(r2);
        return this;
    }

    public final HttpClientBuilder addInterceptorLast(HttpResponseInterceptor r2) {
        if (r2 != null) goto L5;
        return this;
    L5:
        if (this.responseLast != null) goto L7;
        this.responseLast = new LinkedList();
    L7:
        this.responseLast.addLast(r2);
        return this;
    }

    public final HttpClientBuilder addInterceptorFirst(HttpRequestInterceptor r2) {
        if (r2 != null) goto L5;
        return this;
    L5:
        if (this.requestFirst != null) goto L7;
        this.requestFirst = new LinkedList();
    L7:
        this.requestFirst.addFirst(r2);
        return this;
    }

    public final HttpClientBuilder addInterceptorLast(HttpRequestInterceptor r2) {
        if (r2 != null) goto L5;
        return this;
    L5:
        if (this.requestLast != null) goto L7;
        this.requestLast = new LinkedList();
    L7:
        this.requestLast.addLast(r2);
        return this;
    }

    public final HttpClientBuilder disableCookieManagement() {
        this.cookieManagementDisabled = true;
        return this;
    }

    public final HttpClientBuilder disableContentCompression() {
        this.contentCompressionDisabled = true;
        return this;
    }

    public final HttpClientBuilder disableAuthCaching() {
        this.authCachingDisabled = true;
        return this;
    }

    public final HttpClientBuilder setHttpProcessor(HttpProcessor r1) {
        this.httpprocessor = r1;
        return this;
    }

    public final HttpClientBuilder setDnsResolver(DnsResolver r1) {
        this.dnsResolver = r1;
        return this;
    }

    public final HttpClientBuilder setRetryHandler(HttpRequestRetryHandler r1) {
        this.retryHandler = r1;
        return this;
    }

    public final HttpClientBuilder disableAutomaticRetries() {
        this.automaticRetriesDisabled = true;
        return this;
    }

    public final HttpClientBuilder setProxy(HttpHost r1) {
        this.proxy = r1;
        return this;
    }

    public final HttpClientBuilder setRoutePlanner(HttpRoutePlanner r1) {
        this.routePlanner = r1;
        return this;
    }

    public final HttpClientBuilder setRedirectStrategy(RedirectStrategy r1) {
        this.redirectStrategy = r1;
        return this;
    }

    public final HttpClientBuilder disableRedirectHandling() {
        this.redirectHandlingDisabled = true;
        return this;
    }

    public final HttpClientBuilder setConnectionBackoffStrategy(ConnectionBackoffStrategy r1) {
        this.connectionBackoffStrategy = r1;
        return this;
    }

    public final HttpClientBuilder setBackoffManager(BackoffManager r1) {
        this.backoffManager = r1;
        return this;
    }

    public final HttpClientBuilder setServiceUnavailableRetryStrategy(ServiceUnavailableRetryStrategy r1) {
        this.serviceUnavailStrategy = r1;
        return this;
    }

    public final HttpClientBuilder setDefaultCookieStore(CookieStore r1) {
        this.cookieStore = r1;
        return this;
    }

    public final HttpClientBuilder setDefaultCredentialsProvider(CredentialsProvider r1) {
        this.credentialsProvider = r1;
        return this;
    }

    public final HttpClientBuilder setDefaultAuthSchemeRegistry(Lookup<AuthSchemeProvider> r1) {
        this.authSchemeRegistry = r1;
        return this;
    }

    public final HttpClientBuilder setDefaultCookieSpecRegistry(Lookup<CookieSpecProvider> r1) {
        this.cookieSpecRegistry = r1;
        return this;
    }

    public final HttpClientBuilder setContentDecoderRegistry(Map<String, InputStreamFactory> r1) {
        this.contentDecoderMap = r1;
        return this;
    }

    public final HttpClientBuilder setDefaultRequestConfig(RequestConfig r1) {
        this.defaultRequestConfig = r1;
        return this;
    }

    public final HttpClientBuilder useSystemProperties() {
        this.systemProperties = true;
        return this;
    }

    public final HttpClientBuilder evictExpiredConnections() {
        this.evictExpiredConnections = true;
        return this;
    }

    @Deprecated
    public final HttpClientBuilder evictIdleConnections(Long r3, TimeUnit r4) {
        return evictIdleConnections(r3.longValue(), r4);
    }

    public final HttpClientBuilder evictIdleConnections(long r2, TimeUnit r4) {
        this.evictIdleConnections = true;
        this.maxIdleTime = r2;
        this.maxIdleTimeUnit = r4;
        return this;
    }

    public final HttpClientBuilder disableDefaultUserAgent() {
        this.defaultUserAgentDisabled = true;
        return this;
    }

    protected ClientExecChain createMainExec(HttpRequestExecutor r11, HttpClientConnectionManager r12, ConnectionReuseStrategy r13, ConnectionKeepAliveStrategy r14, HttpProcessor r15, AuthenticationStrategy r16, AuthenticationStrategy r17, UserTokenHandler r18) {
        return new MainClientExec(r11, r12, r13, r14, r15, r16, r17, r18);
    }

    protected void addCloseable(Closeable r2) {
        if (r2 != null) goto L5;
        return;
    L5:
        if (this.closeables != null) goto L7;
        this.closeables = new ArrayList();
    L7:
        this.closeables.add(r2);
    }

    private static String[] split(String r1) {
        if (TextUtils.isBlank(r1) == false) goto L7;
        return null;
    L7:
        return r1.split(" *, *");
    }

    public CloseableHttpClient build() {
        PublicSuffixMatcher r0 = this.publicSuffixMatcher;
        if (r0 != null) goto L5;
        r0 = PublicSuffixMatcherLoader.getDefault();
    L5:
        PublicSuffixMatcher r10 = r0;
        HttpRequestExecutor r1 = this.requestExec;
        if (r1 != null) goto L8;
        r1 = new HttpRequestExecutor();
    L8:
        HttpRequestExecutor r2 = r1;
        HttpClientConnectionManager r3 = this.connManager;
        if (r3 != null) goto L53;
        ConnectionSocketFactory r4 = this.sslSocketFactory;
        if (r4 == null) goto L13;
    L31:
        Registry r14 = RegistryBuilder.create().register("http", PlainConnectionSocketFactory.getSocketFactory()).register(HttpHeadTimeFetcher.FETCHER_TYPE, r4).build();
        DnsResolver r5 = this.dnsResolver;
        long r6 = this.connTimeToLive;
        TimeUnit r7 = this.connTimeToLiveTimeUnit;
        if (r7 != null) goto L35;
        r7 = TimeUnit.MILLISECONDS;
    L35:
        PoolingHttpClientConnectionManager r8 = new PoolingHttpClientConnectionManager(r14, null, null, r5, r6, r7);
        SocketConfig r9 = this.defaultSocketConfig;
        if (r9 == null) goto L38;
        r8.setDefaultSocketConfig(r9);
    L38:
        ConnectionConfig r11 = this.defaultConnectionConfig;
        if (r11 == null) goto L42;
        r8.setDefaultConnectionConfig(r11);
    L42:
        if (this.systemProperties == true) goto L44;
    L46:
        int r12 = this.maxConnTotal;
        if (r12 <= 0) goto L49;
        r8.setMaxTotal(r12);
    L49:
        int r13 = this.maxConnPerRoute;
        if (r13 <= 0) goto L52;
        r8.setDefaultMaxPerRoute(r13);
    L52:
        final HttpClientConnectionManager r15 = r8;
    L54:
        ConnectionReuseStrategy r16 = this.reuseStrategy;
        if (r16 == null) goto L57;
    L63:
        ConnectionReuseStrategy r17 = r16;
        ConnectionKeepAliveStrategy r18 = this.keepAliveStrategy;
        if (r18 != null) goto L66;
        r18 = DefaultConnectionKeepAliveStrategy.INSTANCE;
    L66:
        ConnectionKeepAliveStrategy r19 = r18;
        AuthenticationStrategy r20 = this.targetAuthStrategy;
        if (r20 != null) goto L69;
        r20 = TargetAuthenticationStrategy.INSTANCE;
    L69:
        AuthenticationStrategy r21 = r20;
        AuthenticationStrategy r22 = this.proxyAuthStrategy;
        if (r22 != null) goto L72;
        r22 = ProxyAuthenticationStrategy.INSTANCE;
    L72:
        AuthenticationStrategy r23 = r22;
        UserTokenHandler r24 = this.userTokenHandler;
        if (r24 == null) goto L75;
    L78:
        UserTokenHandler r25 = r24;
        String r26 = this.userAgent;
        if (r26 == null) goto L81;
    L87:
        String r110 = r26;
        HttpClientConnectionManager r27 = r15;
        ClientExecChain r28 = decorateMainExec(createMainExec(r2, r27, r17, r19, new ImmutableHttpProcessor(new HttpRequestInterceptor[]{new RequestTargetHost(), new RequestUserAgent(r110)}), r21, r23, r25));
        HttpProcessor r29 = this.httpprocessor;
        if (r29 != null) goto L139;
        HttpProcessorBuilder r30 = HttpProcessorBuilder.create();
        LinkedList<HttpRequestInterceptor> r31 = this.requestFirst;
        if (r31 == null) goto L95;
        Iterator<HttpRequestInterceptor> r32 = r31.iterator();
    L93:
        if (r32.hasNext() == false) goto L95;
        r30.addFirst(r32.next());
    L95:
        LinkedList<HttpResponseInterceptor> r33 = this.responseFirst;
        if (r33 == null) goto L101;
        Iterator<HttpResponseInterceptor> r34 = r33.iterator();
    L99:
        if (r34.hasNext() == false) goto L101;
        r30.addFirst(r34.next());
    L101:
        r30.addAll(new HttpRequestInterceptor[]{new RequestDefaultHeaders(this.defaultHeaders), new RequestContent(), new RequestTargetHost(), new RequestClientConnControl(), new RequestUserAgent(r110), new RequestExpectContinue()});
        if (this.cookieManagementDisabled == true) goto L105;
        r30.add(new RequestAddCookies());
    L105:
        if (this.contentCompressionDisabled == true) goto L111;
        if (this.contentDecoderMap == null) goto L109;
        ArrayList r35 = new ArrayList(this.contentDecoderMap.keySet());
        Collections.sort(r35);
        r30.add(new RequestAcceptEncoding(r35));
        goto L111
    L109:
        r30.add(new RequestAcceptEncoding());
    L111:
        if (this.authCachingDisabled == true) goto L114;
        r30.add(new RequestAuthCache());
    L114:
        if (this.cookieManagementDisabled == true) goto L117;
        r30.add(new ResponseProcessCookies());
    L117:
        if (this.contentCompressionDisabled == false) goto L119;
    L126:
        LinkedList<HttpRequestInterceptor> r36 = this.requestLast;
        if (r36 == null) goto L132;
        Iterator<HttpRequestInterceptor> r37 = r36.iterator();
    L130:
        if (r37.hasNext() == false) goto L132;
        r30.addLast(r37.next());
    L132:
        LinkedList<HttpResponseInterceptor> r38 = this.responseLast;
        if (r38 == null) goto L138;
        Iterator<HttpResponseInterceptor> r39 = r38.iterator();
    L136:
        if (r39.hasNext() == false) goto L138;
        r30.addLast(r39.next());
    L138:
        r29 = r30.build();
        goto L139
    L119:
        if (this.contentDecoderMap == null) goto L125;
        RegistryBuilder r40 = RegistryBuilder.create();
        Iterator<Map.Entry<String, InputStreamFactory>> r41 = this.contentDecoderMap.entrySet().iterator();
    L122:
        if (r41.hasNext() == false) goto L124;
        Map.Entry<String, InputStreamFactory> r42 = r41.next();
        r40.register(r42.getKey(), r42.getValue());
        goto L122
    L124:
        r30.add(new ResponseContentEncoding(r40.build()));
        goto L126
    L125:
        r30.add(new ResponseContentEncoding());
    L139:
        ClientExecChain r43 = decorateProtocolExec(new ProtocolExec(r28, r29));
        if (this.automaticRetriesDisabled == true) goto L145;
        HttpRequestRetryHandler r44 = this.retryHandler;
        if (r44 != null) goto L144;
        r44 = DefaultHttpRequestRetryHandler.INSTANCE;
    L144:
        r43 = new RetryExec(r43, r44);
    L145:
        HttpRoutePlanner r45 = this.routePlanner;
        if (r45 != null) goto L157;
        SchemePortResolver r46 = this.schemePortResolver;
        if (r46 != null) goto L151;
        r46 = DefaultSchemePortResolver.INSTANCE;
    L151:
        if (this.proxy == null) goto L154;
        HttpRoutePlanner r47 = new DefaultProxyRoutePlanner(this.proxy, r46);
    L158:
        ServiceUnavailableRetryStrategy r48 = this.serviceUnavailStrategy;
        if (r48 == null) goto L162;
        r43 = new ServiceUnavailableRetryExec(r43, r48);
    L162:
        if (this.redirectHandlingDisabled == true) goto L168;
        RedirectStrategy r49 = this.redirectStrategy;
        if (r49 != null) goto L166;
        r49 = DefaultRedirectStrategy.INSTANCE;
    L166:
        r43 = new RedirectExec(r43, r47, r49);
    L168:
        if (this.backoffManager != null) goto L170;
    L172:
        Lookup r50 = this.authSchemeRegistry;
        if (r50 != null) goto L175;
        r50 = RegistryBuilder.create().register("Basic", new BasicSchemeFactory()).register("Digest", new DigestSchemeFactory()).register("NTLM", new NTLMSchemeFactory()).build();
    L175:
        Lookup<CookieSpecProvider> r51 = this.cookieSpecRegistry;
        if (r51 != null) goto L178;
        r51 = CookieSpecRegistries.createDefault(r10);
    L178:
        CookieStore r52 = this.cookieStore;
        if (r52 != null) goto L181;
        r52 = new BasicCookieStore();
    L181:
        CredentialsProvider r53 = this.credentialsProvider;
        if (r53 != null) goto L188;
        if (this.systemProperties == false) goto L186;
        r53 = new SystemDefaultCredentialsProvider();
        goto L188
    L186:
        r53 = new BasicCredentialsProvider();
    L188:
        if (this.closeables == null) goto L190;
        ArrayList r111 = new ArrayList(this.closeables);
    L192:
        if (this.connManagerShared == true) goto L212;
        if (r111 != null) goto L195;
        ArrayList r54 = new ArrayList(1);
    L197:
        if (this.evictExpiredConnections == false) goto L199;
    L202:
        long r112 = this.maxIdleTime;
        if (r112 > 0) goto L206;
        r112 = 10;
    L206:
        TimeUnit r55 = this.maxIdleTimeUnit;
        if (r55 != null) goto L210;
        r55 = TimeUnit.SECONDS;
    L210:
        final IdleConnectionEvictor r56 = new IdleConnectionEvictor(r15, r112, r55, this.maxIdleTime, this.maxIdleTimeUnit);
        r54.add(new AnonymousClass1(this, r56));
        r56.start();
    L211:
        r54.add(new AnonymousClass2(this, r15));
        ArrayList r210 = r54;
    L213:
        RequestConfig r57 = this.defaultRequestConfig;
        if (r57 != null) goto L218;
        r57 = RequestConfig.DEFAULT;
    L218:
        return new InternalHttpClient(r43, r15, r47, r51, r50, r52, r53, r57, r210);
    L199:
        if (this.evictIdleConnections == false) goto L211;
    L195:
        r54 = r111;
        goto L197
    L212:
        r15 = r15;
        r210 = r111;
        goto L213
    L190:
        r111 = null;
        goto L192
    L170:
        if (this.connectionBackoffStrategy == null) goto L172;
        r43 = new BackoffStrategyExec(r43, this.connectionBackoffStrategy, this.backoffManager);
        goto L172
    L154:
        if (this.systemProperties == false) goto L156;
        r47 = new SystemDefaultRoutePlanner(r46, ProxySelector.getDefault());
        goto L158
    L156:
        r47 = new DefaultRoutePlanner(r46);
        goto L158
    L157:
        r47 = r45;
        goto L158
    L81:
        if (this.systemProperties == false) goto L83;
        r26 = System.getProperty("http.agent");
    L83:
        if (r26 != null) goto L87;
        if (this.defaultUserAgentDisabled == true) goto L87;
        r26 = VersionInfo.getUserAgent("Apache-HttpClient", "cz.msebera.android.httpclient.client", getClass());
        goto L87
    L75:
        if (this.connectionStateDisabled == true) goto L77;
        r24 = DefaultUserTokenHandler.INSTANCE;
        goto L78
    L77:
        r24 = NoopUserTokenHandler.INSTANCE;
        goto L78
    L57:
        if (this.systemProperties == true) goto L59;
        r16 = DefaultClientConnectionReuseStrategy.INSTANCE;
        goto L63
    L59:
        if ("true".equalsIgnoreCase(System.getProperty("http.keepAlive", "true")) == false) goto L61;
        r16 = DefaultClientConnectionReuseStrategy.INSTANCE;
        goto L63
    L61:
        r16 = NoConnectionReuseStrategy.INSTANCE;
        goto L63
    L44:
        if ("true".equalsIgnoreCase(System.getProperty("http.keepAlive", "true")) == false) goto L46;
        int r58 = Integer.parseInt(System.getProperty("http.maxConnections", "5"));
        r8.setDefaultMaxPerRoute(r58);
        r8.setMaxTotal(r58 * 2);
        goto L46
    L13:
        if (this.systemProperties == false) goto L15;
        String[] r59 = split(System.getProperty("https.protocols"));
    L17:
        if (this.systemProperties == false) goto L19;
        String[] r60 = split(System.getProperty("https.cipherSuites"));
    L20:
        HostnameVerifier r61 = this.hostnameVerifier;
        if (r61 != null) goto L24;
        r61 = new DefaultHostnameVerifier(r10);
    L24:
        if (this.sslContext == null) goto L28;
        ConnectionSocketFactory r62 = new SSLConnectionSocketFactory(this.sslContext, r59, r60, r61);
    L26:
        r4 = r62;
        goto L31
    L28:
        if (this.systemProperties == false) goto L30;
        r62 = new SSLConnectionSocketFactory((SSLSocketFactory) SSLSocketFactory.getDefault(), r59, r60, r61);
        goto L26
    L30:
        r4 = new SSLConnectionSocketFactory(SSLContexts.createDefault(), r61);
        goto L31
    L19:
        r60 = null;
        goto L20
    L15:
        r59 = null;
        goto L17
    L53:
        r15 = r3;
        goto L54
    }
}
