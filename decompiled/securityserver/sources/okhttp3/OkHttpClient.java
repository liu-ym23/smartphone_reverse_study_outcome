package okhttp3;

import a.a;
import com.bytedance.keva.KevaImpl;
import com.bytedance.ttnet.utils.MultiProcessFileUtils;
import java.net.Proxy;
import java.net.ProxySelector;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.Util;
import okhttp3.internal.concurrent.TaskRunner;
import okhttp3.internal.connection.RealCall;
import okhttp3.internal.connection.RouteDatabase;
import okhttp3.internal.platform.Platform;
import okhttp3.internal.proxy.NullProxySelector;
import okhttp3.internal.tls.CertificateChainCleaner;
import okhttp3.internal.tls.OkHostnameVerifier;
import okhttp3.internal.ws.RealWebSocket;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public class OkHttpClient implements Cloneable, Call.Factory, WebSocket.Factory {
    public static final Companion Companion = null;

    @NotNull
    private static final List<ConnectionSpec> DEFAULT_CONNECTION_SPECS = null;

    @NotNull
    private static final List<Protocol> DEFAULT_PROTOCOLS = null;

    @NotNull
    private final Authenticator authenticator;

    @Nullable
    private final Cache cache;
    private final int callTimeoutMillis;

    @Nullable
    private final CertificateChainCleaner certificateChainCleaner;

    @NotNull
    private final CertificatePinner certificatePinner;
    private final int connectTimeoutMillis;

    @NotNull
    private final ConnectionPool connectionPool;

    @NotNull
    private final List<ConnectionSpec> connectionSpecs;

    @NotNull
    private final CookieJar cookieJar;

    @NotNull
    private final Dispatcher dispatcher;

    @NotNull
    private final Dns dns;

    @NotNull
    private final EventListener.Factory eventListenerFactory;
    private final boolean followRedirects;
    private final boolean followSslRedirects;

    @NotNull
    private final HostnameVerifier hostnameVerifier;

    @NotNull
    private final List<Interceptor> interceptors;
    private final long minWebSocketMessageToCompress;

    @NotNull
    private final List<Interceptor> networkInterceptors;
    private final int pingIntervalMillis;

    @NotNull
    private final List<Protocol> protocols;

    @Nullable
    private final Proxy proxy;

    @NotNull
    private final Authenticator proxyAuthenticator;

    @NotNull
    private final ProxySelector proxySelector;
    private final int readTimeoutMillis;
    private final boolean retryOnConnectionFailure;

    @NotNull
    private final RouteDatabase routeDatabase;

    @NotNull
    private final SocketFactory socketFactory;
    private final SSLSocketFactory sslSocketFactoryOrNull;
    private final int writeTimeoutMillis;

    @Nullable
    private final X509TrustManager x509TrustManager;

    @Metadata
    public static final class Builder {

        @NotNull
        private Authenticator authenticator;

        @Nullable
        private Cache cache;
        private int callTimeout;

        @Nullable
        private CertificateChainCleaner certificateChainCleaner;

        @NotNull
        private CertificatePinner certificatePinner;
        private int connectTimeout;

        @NotNull
        private ConnectionPool connectionPool;

        @NotNull
        private List<ConnectionSpec> connectionSpecs;

        @NotNull
        private CookieJar cookieJar;

        @NotNull
        private Dispatcher dispatcher;

        @NotNull
        private Dns dns;

        @NotNull
        private EventListener.Factory eventListenerFactory;
        private boolean followRedirects;
        private boolean followSslRedirects;

        @NotNull
        private HostnameVerifier hostnameVerifier;

        @NotNull
        private final List<Interceptor> interceptors;
        private long minWebSocketMessageToCompress;

        @NotNull
        private final List<Interceptor> networkInterceptors;
        private int pingInterval;

        @NotNull
        private List<? extends Protocol> protocols;

        @Nullable
        private Proxy proxy;

        @NotNull
        private Authenticator proxyAuthenticator;

        @Nullable
        private ProxySelector proxySelector;
        private int readTimeout;
        private boolean retryOnConnectionFailure;

        @Nullable
        private RouteDatabase routeDatabase;

        @NotNull
        private SocketFactory socketFactory;

        @Nullable
        private SSLSocketFactory sslSocketFactoryOrNull;
        private int writeTimeout;

        @Nullable
        private X509TrustManager x509TrustManagerOrNull;

        public Builder() {
            this.dispatcher = new Dispatcher();
            this.connectionPool = new ConnectionPool();
            this.interceptors = new ArrayList();
            this.networkInterceptors = new ArrayList();
            this.eventListenerFactory = Util.asFactory(EventListener.NONE);
            this.retryOnConnectionFailure = true;
            Authenticator r1 = Authenticator.NONE;
            this.authenticator = r1;
            this.followRedirects = true;
            this.followSslRedirects = true;
            this.cookieJar = CookieJar.NO_COOKIES;
            this.dns = Dns.SYSTEM;
            this.proxyAuthenticator = r1;
            SocketFactory r0 = SocketFactory.getDefault();
            Intrinsics.e(r0, "SocketFactory.getDefault()");
            this.socketFactory = r0;
            Companion r2 = OkHttpClient.Companion;
            this.connectionSpecs = r2.getDEFAULT_CONNECTION_SPECS$okhttp();
            this.protocols = r2.getDEFAULT_PROTOCOLS$okhttp();
            this.hostnameVerifier = OkHostnameVerifier.INSTANCE;
            this.certificatePinner = CertificatePinner.DEFAULT;
            this.connectTimeout = KevaImpl.PrivateConstants.REPORT_VALUE_SIZE_THRESHOLD;
            this.readTimeout = KevaImpl.PrivateConstants.REPORT_VALUE_SIZE_THRESHOLD;
            this.writeTimeout = KevaImpl.PrivateConstants.REPORT_VALUE_SIZE_THRESHOLD;
            this.minWebSocketMessageToCompress = 1024;
        }

        @JvmName
        @NotNull
        /* JADX INFO: renamed from: -addInterceptor, reason: not valid java name */
        public final Builder m155addInterceptor(@NotNull final Function1<? super Interceptor.Chain, Response> r2) {
            Intrinsics.f(r2, "block");
            return addInterceptor(new OkHttpClient$Builder$addInterceptor$2(r2));
        }

        @JvmName
        @NotNull
        /* JADX INFO: renamed from: -addNetworkInterceptor, reason: not valid java name */
        public final Builder m156addNetworkInterceptor(@NotNull final Function1<? super Interceptor.Chain, Response> r2) {
            Intrinsics.f(r2, "block");
            return addNetworkInterceptor(new OkHttpClient$Builder$addNetworkInterceptor$2(r2));
        }

        @NotNull
        public final Builder addInterceptor(@NotNull Interceptor r2) {
            Intrinsics.f(r2, "interceptor");
            this.interceptors.add(r2);
            return this;
        }

        @NotNull
        public final Builder addNetworkInterceptor(@NotNull Interceptor r2) {
            Intrinsics.f(r2, "interceptor");
            this.networkInterceptors.add(r2);
            return this;
        }

        @NotNull
        public final Builder authenticator(@NotNull Authenticator r2) {
            Intrinsics.f(r2, "authenticator");
            this.authenticator = r2;
            return this;
        }

        @NotNull
        public final OkHttpClient build() {
            return new OkHttpClient(this);
        }

        @NotNull
        public final Builder cache(@Nullable Cache r1) {
            this.cache = r1;
            return this;
        }

        @NotNull
        public final Builder callTimeout(long r2, @NotNull TimeUnit r4) {
            Intrinsics.f(r4, "unit");
            this.callTimeout = Util.checkDuration("timeout", r2, r4);
            return this;
        }

        @NotNull
        public final Builder certificatePinner(@NotNull CertificatePinner r2) {
            Intrinsics.f(r2, "certificatePinner");
            if ((!r2.equals(this.certificatePinner)) == false) goto L5;
            this.routeDatabase = null;
        L5:
            this.certificatePinner = r2;
            return this;
        }

        @NotNull
        public final Builder connectTimeout(long r2, @NotNull TimeUnit r4) {
            Intrinsics.f(r4, "unit");
            this.connectTimeout = Util.checkDuration("timeout", r2, r4);
            return this;
        }

        @NotNull
        public final Builder connectionPool(@NotNull ConnectionPool r2) {
            Intrinsics.f(r2, "connectionPool");
            this.connectionPool = r2;
            return this;
        }

        @NotNull
        public final Builder connectionSpecs(@NotNull List<ConnectionSpec> r2) {
            Intrinsics.f(r2, "connectionSpecs");
            if ((!r2.equals(this.connectionSpecs)) == false) goto L5;
            this.routeDatabase = null;
        L5:
            this.connectionSpecs = Util.toImmutableList(r2);
            return this;
        }

        @NotNull
        public final Builder cookieJar(@NotNull CookieJar r2) {
            Intrinsics.f(r2, "cookieJar");
            this.cookieJar = r2;
            return this;
        }

        @NotNull
        public final Builder dispatcher(@NotNull Dispatcher r2) {
            Intrinsics.f(r2, "dispatcher");
            this.dispatcher = r2;
            return this;
        }

        @NotNull
        public final Builder dns(@NotNull Dns r2) {
            Intrinsics.f(r2, MultiProcessFileUtils.KEY_DNS);
            if ((!r2.equals(this.dns)) == false) goto L5;
            this.routeDatabase = null;
        L5:
            this.dns = r2;
            return this;
        }

        @NotNull
        public final Builder eventListener(@NotNull EventListener r2) {
            Intrinsics.f(r2, "eventListener");
            this.eventListenerFactory = Util.asFactory(r2);
            return this;
        }

        @NotNull
        public final Builder eventListenerFactory(@NotNull EventListener.Factory r2) {
            Intrinsics.f(r2, "eventListenerFactory");
            this.eventListenerFactory = r2;
            return this;
        }

        @NotNull
        public final Builder followRedirects(boolean r1) {
            this.followRedirects = r1;
            return this;
        }

        @NotNull
        public final Builder followSslRedirects(boolean r1) {
            this.followSslRedirects = r1;
            return this;
        }

        @NotNull
        public final Authenticator getAuthenticator$okhttp() {
            return this.authenticator;
        }

        @Nullable
        public final Cache getCache$okhttp() {
            return this.cache;
        }

        public final int getCallTimeout$okhttp() {
            return this.callTimeout;
        }

        @Nullable
        public final CertificateChainCleaner getCertificateChainCleaner$okhttp() {
            return this.certificateChainCleaner;
        }

        @NotNull
        public final CertificatePinner getCertificatePinner$okhttp() {
            return this.certificatePinner;
        }

        public final int getConnectTimeout$okhttp() {
            return this.connectTimeout;
        }

        @NotNull
        public final ConnectionPool getConnectionPool$okhttp() {
            return this.connectionPool;
        }

        @NotNull
        public final List<ConnectionSpec> getConnectionSpecs$okhttp() {
            return this.connectionSpecs;
        }

        @NotNull
        public final CookieJar getCookieJar$okhttp() {
            return this.cookieJar;
        }

        @NotNull
        public final Dispatcher getDispatcher$okhttp() {
            return this.dispatcher;
        }

        @NotNull
        public final Dns getDns$okhttp() {
            return this.dns;
        }

        @NotNull
        public final EventListener.Factory getEventListenerFactory$okhttp() {
            return this.eventListenerFactory;
        }

        public final boolean getFollowRedirects$okhttp() {
            return this.followRedirects;
        }

        public final boolean getFollowSslRedirects$okhttp() {
            return this.followSslRedirects;
        }

        @NotNull
        public final HostnameVerifier getHostnameVerifier$okhttp() {
            return this.hostnameVerifier;
        }

        @NotNull
        public final List<Interceptor> getInterceptors$okhttp() {
            return this.interceptors;
        }

        public final long getMinWebSocketMessageToCompress$okhttp() {
            return this.minWebSocketMessageToCompress;
        }

        @NotNull
        public final List<Interceptor> getNetworkInterceptors$okhttp() {
            return this.networkInterceptors;
        }

        public final int getPingInterval$okhttp() {
            return this.pingInterval;
        }

        @NotNull
        public final List<Protocol> getProtocols$okhttp() {
            return this.protocols;
        }

        @Nullable
        public final Proxy getProxy$okhttp() {
            return this.proxy;
        }

        @NotNull
        public final Authenticator getProxyAuthenticator$okhttp() {
            return this.proxyAuthenticator;
        }

        @Nullable
        public final ProxySelector getProxySelector$okhttp() {
            return this.proxySelector;
        }

        public final int getReadTimeout$okhttp() {
            return this.readTimeout;
        }

        public final boolean getRetryOnConnectionFailure$okhttp() {
            return this.retryOnConnectionFailure;
        }

        @Nullable
        public final RouteDatabase getRouteDatabase$okhttp() {
            return this.routeDatabase;
        }

        @NotNull
        public final SocketFactory getSocketFactory$okhttp() {
            return this.socketFactory;
        }

        @Nullable
        public final SSLSocketFactory getSslSocketFactoryOrNull$okhttp() {
            return this.sslSocketFactoryOrNull;
        }

        public final int getWriteTimeout$okhttp() {
            return this.writeTimeout;
        }

        @Nullable
        public final X509TrustManager getX509TrustManagerOrNull$okhttp() {
            return this.x509TrustManagerOrNull;
        }

        @NotNull
        public final Builder hostnameVerifier(@NotNull HostnameVerifier r2) {
            Intrinsics.f(r2, "hostnameVerifier");
            if ((!r2.equals(this.hostnameVerifier)) == false) goto L5;
            this.routeDatabase = null;
        L5:
            this.hostnameVerifier = r2;
            return this;
        }

        @NotNull
        public final List<Interceptor> interceptors() {
            return this.interceptors;
        }

        @NotNull
        public final Builder minWebSocketMessageToCompress(long r3) {
            if (r3 < 0) goto L5;
            boolean r0 = true;
        L6:
            if (r0 == false) goto L10;
            this.minWebSocketMessageToCompress = r3;
            return this;
        L10:
            throw new IllegalArgumentException(a.h("minWebSocketMessageToCompress must be positive: ", r3).toString());
        L5:
            r0 = false;
            goto L6
        }

        @NotNull
        public final List<Interceptor> networkInterceptors() {
            return this.networkInterceptors;
        }

        @NotNull
        public final Builder pingInterval(long r2, @NotNull TimeUnit r4) {
            Intrinsics.f(r4, "unit");
            this.pingInterval = Util.checkDuration("interval", r2, r4);
            return this;
        }

        @NotNull
        public final Builder protocols(@NotNull List<? extends Protocol> r4) {
            Intrinsics.f(r4, "protocols");
            ArrayList r5 = CollectionsKt.r(r4);
            Protocol r0 = Protocol.H2_PRIOR_KNOWLEDGE;
            if (r5.contains(r0) == true) goto L10;
            if (r5.contains(Protocol.HTTP_1_1) == true) goto L10;
            throw new IllegalArgumentException(("protocols must contain h2_prior_knowledge or http/1.1: " + r5).toString());
        L10:
            if (r5.contains(r0) == false) goto L17;
            if (r5.size() <= 1) goto L17;
            throw new IllegalArgumentException(("protocols containing h2_prior_knowledge cannot use other protocols: " + r5).toString());
        L17:
            if ((!r5.contains(Protocol.HTTP_1_0)) == false) goto L28;
            if ((!r5.contains(null)) == false) goto L26;
            r5.remove(Protocol.SPDY_3);
            if ((true ^ r5.equals(this.protocols)) == false) goto L23;
            this.routeDatabase = null;
        L23:
            List<? extends Protocol> r6 = Collections.unmodifiableList(r5);
            Intrinsics.e(r6, "Collections.unmodifiableList(protocolsCopy)");
            this.protocols = r6;
            return this;
        L26:
            throw new IllegalArgumentException("protocols must not contain null".toString());
        L28:
            throw new IllegalArgumentException(("protocols must not contain http/1.0: " + r5).toString());
        }

        @NotNull
        public final Builder proxy(@Nullable Proxy r2) {
            if ((!Intrinsics.a(r2, this.proxy)) == false) goto L5;
            this.routeDatabase = null;
        L5:
            this.proxy = r2;
            return this;
        }

        @NotNull
        public final Builder proxyAuthenticator(@NotNull Authenticator r2) {
            Intrinsics.f(r2, "proxyAuthenticator");
            if ((!r2.equals(this.proxyAuthenticator)) == false) goto L5;
            this.routeDatabase = null;
        L5:
            this.proxyAuthenticator = r2;
            return this;
        }

        @NotNull
        public final Builder proxySelector(@NotNull ProxySelector r2) {
            Intrinsics.f(r2, "proxySelector");
            if ((!r2.equals(this.proxySelector)) == false) goto L5;
            this.routeDatabase = null;
        L5:
            this.proxySelector = r2;
            return this;
        }

        @NotNull
        public final Builder readTimeout(long r2, @NotNull TimeUnit r4) {
            Intrinsics.f(r4, "unit");
            this.readTimeout = Util.checkDuration("timeout", r2, r4);
            return this;
        }

        @NotNull
        public final Builder retryOnConnectionFailure(boolean r1) {
            this.retryOnConnectionFailure = r1;
            return this;
        }

        public final void setAuthenticator$okhttp(@NotNull Authenticator r2) {
            Intrinsics.f(r2, "<set-?>");
            this.authenticator = r2;
        }

        public final void setCache$okhttp(@Nullable Cache r1) {
            this.cache = r1;
        }

        public final void setCallTimeout$okhttp(int r1) {
            this.callTimeout = r1;
        }

        public final void setCertificateChainCleaner$okhttp(@Nullable CertificateChainCleaner r1) {
            this.certificateChainCleaner = r1;
        }

        public final void setCertificatePinner$okhttp(@NotNull CertificatePinner r2) {
            Intrinsics.f(r2, "<set-?>");
            this.certificatePinner = r2;
        }

        public final void setConnectTimeout$okhttp(int r1) {
            this.connectTimeout = r1;
        }

        public final void setConnectionPool$okhttp(@NotNull ConnectionPool r2) {
            Intrinsics.f(r2, "<set-?>");
            this.connectionPool = r2;
        }

        public final void setConnectionSpecs$okhttp(@NotNull List<ConnectionSpec> r2) {
            Intrinsics.f(r2, "<set-?>");
            this.connectionSpecs = r2;
        }

        public final void setCookieJar$okhttp(@NotNull CookieJar r2) {
            Intrinsics.f(r2, "<set-?>");
            this.cookieJar = r2;
        }

        public final void setDispatcher$okhttp(@NotNull Dispatcher r2) {
            Intrinsics.f(r2, "<set-?>");
            this.dispatcher = r2;
        }

        public final void setDns$okhttp(@NotNull Dns r2) {
            Intrinsics.f(r2, "<set-?>");
            this.dns = r2;
        }

        public final void setEventListenerFactory$okhttp(@NotNull EventListener.Factory r2) {
            Intrinsics.f(r2, "<set-?>");
            this.eventListenerFactory = r2;
        }

        public final void setFollowRedirects$okhttp(boolean r1) {
            this.followRedirects = r1;
        }

        public final void setFollowSslRedirects$okhttp(boolean r1) {
            this.followSslRedirects = r1;
        }

        public final void setHostnameVerifier$okhttp(@NotNull HostnameVerifier r2) {
            Intrinsics.f(r2, "<set-?>");
            this.hostnameVerifier = r2;
        }

        public final void setMinWebSocketMessageToCompress$okhttp(long r1) {
            this.minWebSocketMessageToCompress = r1;
        }

        public final void setPingInterval$okhttp(int r1) {
            this.pingInterval = r1;
        }

        public final void setProtocols$okhttp(@NotNull List<? extends Protocol> r2) {
            Intrinsics.f(r2, "<set-?>");
            this.protocols = r2;
        }

        public final void setProxy$okhttp(@Nullable Proxy r1) {
            this.proxy = r1;
        }

        public final void setProxyAuthenticator$okhttp(@NotNull Authenticator r2) {
            Intrinsics.f(r2, "<set-?>");
            this.proxyAuthenticator = r2;
        }

        public final void setProxySelector$okhttp(@Nullable ProxySelector r1) {
            this.proxySelector = r1;
        }

        public final void setReadTimeout$okhttp(int r1) {
            this.readTimeout = r1;
        }

        public final void setRetryOnConnectionFailure$okhttp(boolean r1) {
            this.retryOnConnectionFailure = r1;
        }

        public final void setRouteDatabase$okhttp(@Nullable RouteDatabase r1) {
            this.routeDatabase = r1;
        }

        public final void setSocketFactory$okhttp(@NotNull SocketFactory r2) {
            Intrinsics.f(r2, "<set-?>");
            this.socketFactory = r2;
        }

        public final void setSslSocketFactoryOrNull$okhttp(@Nullable SSLSocketFactory r1) {
            this.sslSocketFactoryOrNull = r1;
        }

        public final void setWriteTimeout$okhttp(int r1) {
            this.writeTimeout = r1;
        }

        public final void setX509TrustManagerOrNull$okhttp(@Nullable X509TrustManager r1) {
            this.x509TrustManagerOrNull = r1;
        }

        @NotNull
        public final Builder socketFactory(@NotNull SocketFactory r2) {
            Intrinsics.f(r2, "socketFactory");
            if ((!(r2 instanceof SSLSocketFactory)) == false) goto L10;
            if ((!r2.equals(this.socketFactory)) == false) goto L7;
            this.routeDatabase = null;
        L7:
            this.socketFactory = r2;
            return this;
        L10:
            throw new IllegalArgumentException("socketFactory instanceof SSLSocketFactory".toString());
        }

        @Deprecated
        @NotNull
        public final Builder sslSocketFactory(@NotNull SSLSocketFactory r4) {
            Intrinsics.f(r4, "sslSocketFactory");
            if ((!r4.equals(this.sslSocketFactoryOrNull)) == false) goto L5;
            this.routeDatabase = null;
        L5:
            this.sslSocketFactoryOrNull = r4;
            Platform.Companion r0 = Platform.Companion;
            X509TrustManager r1 = r0.get().trustManager(r4);
            if (r1 == null) goto L10;
            this.x509TrustManagerOrNull = r1;
            Platform r5 = r0.get();
            X509TrustManager r2 = this.x509TrustManagerOrNull;
            Intrinsics.c(r2);
            this.certificateChainCleaner = r5.buildCertificateChainCleaner(r2);
            return this;
        L10:
            throw new IllegalStateException("Unable to extract the trust manager on " + r0.get() + ", sslSocketFactory is " + r4.getClass());
        }

        @NotNull
        public final Builder writeTimeout(long r2, @NotNull TimeUnit r4) {
            Intrinsics.f(r4, "unit");
            this.writeTimeout = Util.checkDuration("timeout", r2, r4);
            return this;
        }

        @IgnoreJRERequirement
        @NotNull
        public final Builder callTimeout(@NotNull Duration r3) {
            Intrinsics.f(r3, "duration");
            callTimeout(r3.toMillis(), TimeUnit.MILLISECONDS);
            return this;
        }

        @IgnoreJRERequirement
        @NotNull
        public final Builder connectTimeout(@NotNull Duration r3) {
            Intrinsics.f(r3, "duration");
            connectTimeout(r3.toMillis(), TimeUnit.MILLISECONDS);
            return this;
        }

        @IgnoreJRERequirement
        @NotNull
        public final Builder pingInterval(@NotNull Duration r3) {
            Intrinsics.f(r3, "duration");
            pingInterval(r3.toMillis(), TimeUnit.MILLISECONDS);
            return this;
        }

        @IgnoreJRERequirement
        @NotNull
        public final Builder readTimeout(@NotNull Duration r3) {
            Intrinsics.f(r3, "duration");
            readTimeout(r3.toMillis(), TimeUnit.MILLISECONDS);
            return this;
        }

        @IgnoreJRERequirement
        @NotNull
        public final Builder writeTimeout(@NotNull Duration r3) {
            Intrinsics.f(r3, "duration");
            writeTimeout(r3.toMillis(), TimeUnit.MILLISECONDS);
            return this;
        }

        @NotNull
        public final Builder sslSocketFactory(@NotNull SSLSocketFactory r2, @NotNull X509TrustManager r3) {
            Intrinsics.f(r2, "sslSocketFactory");
            Intrinsics.f(r3, "trustManager");
            if ((!r2.equals(this.sslSocketFactoryOrNull)) == false) goto L5;
        L6:
            this.routeDatabase = null;
        L7:
            this.sslSocketFactoryOrNull = r2;
            this.certificateChainCleaner = CertificateChainCleaner.Companion.get(r3);
            this.x509TrustManagerOrNull = r3;
            return this;
        L5:
            if ((!r3.equals(this.x509TrustManagerOrNull)) == false) goto L7;
            goto L6
        }

        public Builder(@NotNull OkHttpClient r3) {
            Intrinsics.f(r3, "okHttpClient");
            this();
            this.dispatcher = r3.dispatcher();
            this.connectionPool = r3.connectionPool();
            CollectionsKt.d(this.interceptors, r3.interceptors());
            CollectionsKt.d(this.networkInterceptors, r3.networkInterceptors());
            this.eventListenerFactory = r3.eventListenerFactory();
            this.retryOnConnectionFailure = r3.retryOnConnectionFailure();
            this.authenticator = r3.authenticator();
            this.followRedirects = r3.followRedirects();
            this.followSslRedirects = r3.followSslRedirects();
            this.cookieJar = r3.cookieJar();
            this.cache = r3.cache();
            this.dns = r3.dns();
            this.proxy = r3.proxy();
            this.proxySelector = r3.proxySelector();
            this.proxyAuthenticator = r3.proxyAuthenticator();
            this.socketFactory = r3.socketFactory();
            this.sslSocketFactoryOrNull = OkHttpClient.access$getSslSocketFactoryOrNull$p(r3);
            this.x509TrustManagerOrNull = r3.x509TrustManager();
            this.connectionSpecs = r3.connectionSpecs();
            this.protocols = r3.protocols();
            this.hostnameVerifier = r3.hostnameVerifier();
            this.certificatePinner = r3.certificatePinner();
            this.certificateChainCleaner = r3.certificateChainCleaner();
            this.callTimeout = r3.callTimeoutMillis();
            this.connectTimeout = r3.connectTimeoutMillis();
            this.readTimeout = r3.readTimeoutMillis();
            this.writeTimeout = r3.writeTimeoutMillis();
            this.pingInterval = r3.pingIntervalMillis();
            this.minWebSocketMessageToCompress = r3.minWebSocketMessageToCompress();
            this.routeDatabase = r3.getRouteDatabase();
        }
    }

    @Metadata
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final List<ConnectionSpec> getDEFAULT_CONNECTION_SPECS$okhttp() {
            return OkHttpClient.access$getDEFAULT_CONNECTION_SPECS$cp();
        }

        @NotNull
        public final List<Protocol> getDEFAULT_PROTOCOLS$okhttp() {
            return OkHttpClient.access$getDEFAULT_PROTOCOLS$cp();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
        DEFAULT_PROTOCOLS = Util.immutableListOf(new Protocol[]{Protocol.HTTP_2, Protocol.HTTP_1_1});
        DEFAULT_CONNECTION_SPECS = Util.immutableListOf(new ConnectionSpec[]{ConnectionSpec.MODERN_TLS, ConnectionSpec.CLEARTEXT});
    }

    public OkHttpClient(@NotNull Builder r4) {
        Intrinsics.f(r4, "builder");
        this.dispatcher = r4.getDispatcher$okhttp();
        this.connectionPool = r4.getConnectionPool$okhttp();
        this.interceptors = Util.toImmutableList(r4.getInterceptors$okhttp());
        this.networkInterceptors = Util.toImmutableList(r4.getNetworkInterceptors$okhttp());
        this.eventListenerFactory = r4.getEventListenerFactory$okhttp();
        this.retryOnConnectionFailure = r4.getRetryOnConnectionFailure$okhttp();
        this.authenticator = r4.getAuthenticator$okhttp();
        this.followRedirects = r4.getFollowRedirects$okhttp();
        this.followSslRedirects = r4.getFollowSslRedirects$okhttp();
        this.cookieJar = r4.getCookieJar$okhttp();
        this.cache = r4.getCache$okhttp();
        this.dns = r4.getDns$okhttp();
        this.proxy = r4.getProxy$okhttp();
        if (r4.getProxy$okhttp() == null) goto L5;
        ProxySelector r0 = NullProxySelector.INSTANCE;
    L12:
        this.proxySelector = r0;
        this.proxyAuthenticator = r4.getProxyAuthenticator$okhttp();
        this.socketFactory = r4.getSocketFactory$okhttp();
        List<ConnectionSpec> r1 = r4.getConnectionSpecs$okhttp();
        this.connectionSpecs = r1;
        this.protocols = r4.getProtocols$okhttp();
        this.hostnameVerifier = r4.getHostnameVerifier$okhttp();
        this.callTimeoutMillis = r4.getCallTimeout$okhttp();
        this.connectTimeoutMillis = r4.getConnectTimeout$okhttp();
        this.readTimeoutMillis = r4.getReadTimeout$okhttp();
        this.writeTimeoutMillis = r4.getWriteTimeout$okhttp();
        this.pingIntervalMillis = r4.getPingInterval$okhttp();
        this.minWebSocketMessageToCompress = r4.getMinWebSocketMessageToCompress$okhttp();
        RouteDatabase r2 = r4.getRouteDatabase$okhttp();
        if (r2 != null) goto L16;
        r2 = new RouteDatabase();
    L16:
        this.routeDatabase = r2;
        if ((r1 instanceof Collection) == true) goto L19;
    L21:
        Iterator<T> r3 = r1.iterator();
    L23:
        if (r3.hasNext() == false) goto L30;
        if (((ConnectionSpec) r3.next()).isTls() == false) goto L23;
        if (r4.getSslSocketFactoryOrNull$okhttp() == null) goto L29;
        this.sslSocketFactoryOrNull = r4.getSslSocketFactoryOrNull$okhttp();
        CertificateChainCleaner r5 = r4.getCertificateChainCleaner$okhttp();
        Intrinsics.c(r5);
        this.certificateChainCleaner = r5;
        X509TrustManager r6 = r4.getX509TrustManagerOrNull$okhttp();
        Intrinsics.c(r6);
        this.x509TrustManager = r6;
        this.certificatePinner = r4.getCertificatePinner$okhttp().withCertificateChainCleaner$okhttp(r5);
    L31:
        verifyClientState();
        return;
    L29:
        Platform.Companion r7 = Platform.Companion;
        X509TrustManager r8 = r7.get().platformTrustManager();
        this.x509TrustManager = r8;
        Platform r9 = r7.get();
        Intrinsics.c(r8);
        this.sslSocketFactoryOrNull = r9.newSslSocketFactory(r8);
        CertificateChainCleaner.Companion r10 = CertificateChainCleaner.Companion;
        Intrinsics.c(r8);
        CertificateChainCleaner r11 = r10.get(r8);
        this.certificateChainCleaner = r11;
        CertificatePinner r12 = r4.getCertificatePinner$okhttp();
        Intrinsics.c(r11);
        this.certificatePinner = r12.withCertificateChainCleaner$okhttp(r11);
    L30:
        this.sslSocketFactoryOrNull = null;
        this.certificateChainCleaner = null;
        this.x509TrustManager = null;
        this.certificatePinner = CertificatePinner.DEFAULT;
        goto L31
    L19:
        if (r1.isEmpty() == false) goto L21;
    L5:
        r0 = r4.getProxySelector$okhttp();
        if (r0 != null) goto L9;
        r0 = ProxySelector.getDefault();
    L9:
        if (r0 != null) goto L12;
        r0 = NullProxySelector.INSTANCE;
        goto L12
    }

    public static final /* synthetic */ List access$getDEFAULT_CONNECTION_SPECS$cp() {
        return DEFAULT_CONNECTION_SPECS;
    }

    public static final /* synthetic */ List access$getDEFAULT_PROTOCOLS$cp() {
        return DEFAULT_PROTOCOLS;
    }

    public static final /* synthetic */ SSLSocketFactory access$getSslSocketFactoryOrNull$p(OkHttpClient r0) {
        return r0.sslSocketFactoryOrNull;
    }

    private final void verifyClientState() {
        List<Interceptor> r0 = this.interceptors;
        if (r0 == null) goto L67;
        boolean r3 = true;
        if ((!r0.contains(null)) == false) goto L65;
        List<Interceptor> r1 = this.networkInterceptors;
        if (r1 == null) goto L63;
        if ((!r1.contains(null)) == false) goto L61;
        List<ConnectionSpec> r2 = this.connectionSpecs;
        if ((r2 instanceof Collection) == true) goto L13;
    L15:
        Iterator<T> r4 = r2.iterator();
    L17:
        if (r4.hasNext() == false) goto L34;
        if (((ConnectionSpec) r4.next()).isTls() == false) goto L17;
        if (this.sslSocketFactoryOrNull == null) goto L32;
        if (this.certificateChainCleaner == null) goto L30;
        if (this.x509TrustManager == null) goto L28;
        return;
    L28:
        throw new IllegalStateException("x509TrustManager == null".toString());
    L30:
        throw new IllegalStateException("certificateChainCleaner == null".toString());
    L32:
        throw new IllegalStateException("sslSocketFactory == null".toString());
    L34:
        if (this.sslSocketFactoryOrNull != null) goto L36;
        boolean r5 = true;
    L38:
        if (r5 == false) goto L59;
        if (this.certificateChainCleaner != null) goto L42;
        boolean r6 = true;
    L43:
        if (r6 == false) goto L57;
        if (this.x509TrustManager == null) goto L48;
        r3 = false;
    L48:
        if (r3 == false) goto L55;
        if (Intrinsics.a(this.certificatePinner, CertificatePinner.DEFAULT) == false) goto L53;
        return;
    L53:
        throw new IllegalStateException("Check failed.".toString());
    L55:
        throw new IllegalStateException("Check failed.".toString());
    L57:
        throw new IllegalStateException("Check failed.".toString());
    L42:
        r6 = false;
        goto L43
    L59:
        throw new IllegalStateException("Check failed.".toString());
    L36:
        r5 = false;
        goto L38
    L13:
        if (r2.isEmpty() == false) goto L15;
    L61:
        throw new IllegalStateException(("Null network interceptor: " + this.networkInterceptors).toString());
    L63:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.List<okhttp3.Interceptor?>");
    L65:
        throw new IllegalStateException(("Null interceptor: " + this.interceptors).toString());
    L67:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.List<okhttp3.Interceptor?>");
    }

    @Deprecated
    @JvmName
    @NotNull
    /* JADX INFO: renamed from: -deprecated_authenticator, reason: not valid java name */
    public final Authenticator m129deprecated_authenticator() {
        return this.authenticator;
    }

    @Deprecated
    @JvmName
    @Nullable
    /* JADX INFO: renamed from: -deprecated_cache, reason: not valid java name */
    public final Cache m130deprecated_cache() {
        return this.cache;
    }

    @Deprecated
    @JvmName
    /* JADX INFO: renamed from: -deprecated_callTimeoutMillis, reason: not valid java name */
    public final int m131deprecated_callTimeoutMillis() {
        return this.callTimeoutMillis;
    }

    @Deprecated
    @JvmName
    @NotNull
    /* JADX INFO: renamed from: -deprecated_certificatePinner, reason: not valid java name */
    public final CertificatePinner m132deprecated_certificatePinner() {
        return this.certificatePinner;
    }

    @Deprecated
    @JvmName
    /* JADX INFO: renamed from: -deprecated_connectTimeoutMillis, reason: not valid java name */
    public final int m133deprecated_connectTimeoutMillis() {
        return this.connectTimeoutMillis;
    }

    @Deprecated
    @JvmName
    @NotNull
    /* JADX INFO: renamed from: -deprecated_connectionPool, reason: not valid java name */
    public final ConnectionPool m134deprecated_connectionPool() {
        return this.connectionPool;
    }

    @Deprecated
    @JvmName
    @NotNull
    /* JADX INFO: renamed from: -deprecated_connectionSpecs, reason: not valid java name */
    public final List<ConnectionSpec> m135deprecated_connectionSpecs() {
        return this.connectionSpecs;
    }

    @Deprecated
    @JvmName
    @NotNull
    /* JADX INFO: renamed from: -deprecated_cookieJar, reason: not valid java name */
    public final CookieJar m136deprecated_cookieJar() {
        return this.cookieJar;
    }

    @Deprecated
    @JvmName
    @NotNull
    /* JADX INFO: renamed from: -deprecated_dispatcher, reason: not valid java name */
    public final Dispatcher m137deprecated_dispatcher() {
        return this.dispatcher;
    }

    @Deprecated
    @JvmName
    @NotNull
    /* JADX INFO: renamed from: -deprecated_dns, reason: not valid java name */
    public final Dns m138deprecated_dns() {
        return this.dns;
    }

    @Deprecated
    @JvmName
    @NotNull
    /* JADX INFO: renamed from: -deprecated_eventListenerFactory, reason: not valid java name */
    public final EventListener.Factory m139deprecated_eventListenerFactory() {
        return this.eventListenerFactory;
    }

    @Deprecated
    @JvmName
    /* JADX INFO: renamed from: -deprecated_followRedirects, reason: not valid java name */
    public final boolean m140deprecated_followRedirects() {
        return this.followRedirects;
    }

    @Deprecated
    @JvmName
    /* JADX INFO: renamed from: -deprecated_followSslRedirects, reason: not valid java name */
    public final boolean m141deprecated_followSslRedirects() {
        return this.followSslRedirects;
    }

    @Deprecated
    @JvmName
    @NotNull
    /* JADX INFO: renamed from: -deprecated_hostnameVerifier, reason: not valid java name */
    public final HostnameVerifier m142deprecated_hostnameVerifier() {
        return this.hostnameVerifier;
    }

    @Deprecated
    @JvmName
    @NotNull
    /* JADX INFO: renamed from: -deprecated_interceptors, reason: not valid java name */
    public final List<Interceptor> m143deprecated_interceptors() {
        return this.interceptors;
    }

    @Deprecated
    @JvmName
    @NotNull
    /* JADX INFO: renamed from: -deprecated_networkInterceptors, reason: not valid java name */
    public final List<Interceptor> m144deprecated_networkInterceptors() {
        return this.networkInterceptors;
    }

    @Deprecated
    @JvmName
    /* JADX INFO: renamed from: -deprecated_pingIntervalMillis, reason: not valid java name */
    public final int m145deprecated_pingIntervalMillis() {
        return this.pingIntervalMillis;
    }

    @Deprecated
    @JvmName
    @NotNull
    /* JADX INFO: renamed from: -deprecated_protocols, reason: not valid java name */
    public final List<Protocol> m146deprecated_protocols() {
        return this.protocols;
    }

    @Deprecated
    @JvmName
    @Nullable
    /* JADX INFO: renamed from: -deprecated_proxy, reason: not valid java name */
    public final Proxy m147deprecated_proxy() {
        return this.proxy;
    }

    @Deprecated
    @JvmName
    @NotNull
    /* JADX INFO: renamed from: -deprecated_proxyAuthenticator, reason: not valid java name */
    public final Authenticator m148deprecated_proxyAuthenticator() {
        return this.proxyAuthenticator;
    }

    @Deprecated
    @JvmName
    @NotNull
    /* JADX INFO: renamed from: -deprecated_proxySelector, reason: not valid java name */
    public final ProxySelector m149deprecated_proxySelector() {
        return this.proxySelector;
    }

    @Deprecated
    @JvmName
    /* JADX INFO: renamed from: -deprecated_readTimeoutMillis, reason: not valid java name */
    public final int m150deprecated_readTimeoutMillis() {
        return this.readTimeoutMillis;
    }

    @Deprecated
    @JvmName
    /* JADX INFO: renamed from: -deprecated_retryOnConnectionFailure, reason: not valid java name */
    public final boolean m151deprecated_retryOnConnectionFailure() {
        return this.retryOnConnectionFailure;
    }

    @Deprecated
    @JvmName
    @NotNull
    /* JADX INFO: renamed from: -deprecated_socketFactory, reason: not valid java name */
    public final SocketFactory m152deprecated_socketFactory() {
        return this.socketFactory;
    }

    @Deprecated
    @JvmName
    @NotNull
    /* JADX INFO: renamed from: -deprecated_sslSocketFactory, reason: not valid java name */
    public final SSLSocketFactory m153deprecated_sslSocketFactory() {
        return sslSocketFactory();
    }

    @Deprecated
    @JvmName
    /* JADX INFO: renamed from: -deprecated_writeTimeoutMillis, reason: not valid java name */
    public final int m154deprecated_writeTimeoutMillis() {
        return this.writeTimeoutMillis;
    }

    @JvmName
    @NotNull
    public final Authenticator authenticator() {
        return this.authenticator;
    }

    @JvmName
    @Nullable
    public final Cache cache() {
        return this.cache;
    }

    @JvmName
    public final int callTimeoutMillis() {
        return this.callTimeoutMillis;
    }

    @JvmName
    @Nullable
    public final CertificateChainCleaner certificateChainCleaner() {
        return this.certificateChainCleaner;
    }

    @JvmName
    @NotNull
    public final CertificatePinner certificatePinner() {
        return this.certificatePinner;
    }

    @NotNull
    public Object clone() {
        return super.clone();
    }

    @JvmName
    public final int connectTimeoutMillis() {
        return this.connectTimeoutMillis;
    }

    @JvmName
    @NotNull
    public final ConnectionPool connectionPool() {
        return this.connectionPool;
    }

    @JvmName
    @NotNull
    public final List<ConnectionSpec> connectionSpecs() {
        return this.connectionSpecs;
    }

    @JvmName
    @NotNull
    public final CookieJar cookieJar() {
        return this.cookieJar;
    }

    @JvmName
    @NotNull
    public final Dispatcher dispatcher() {
        return this.dispatcher;
    }

    @JvmName
    @NotNull
    public final Dns dns() {
        return this.dns;
    }

    @JvmName
    @NotNull
    public final EventListener.Factory eventListenerFactory() {
        return this.eventListenerFactory;
    }

    @JvmName
    public final boolean followRedirects() {
        return this.followRedirects;
    }

    @JvmName
    public final boolean followSslRedirects() {
        return this.followSslRedirects;
    }

    @NotNull
    public final RouteDatabase getRouteDatabase() {
        return this.routeDatabase;
    }

    @JvmName
    @NotNull
    public final HostnameVerifier hostnameVerifier() {
        return this.hostnameVerifier;
    }

    @JvmName
    @NotNull
    public final List<Interceptor> interceptors() {
        return this.interceptors;
    }

    @JvmName
    public final long minWebSocketMessageToCompress() {
        return this.minWebSocketMessageToCompress;
    }

    @JvmName
    @NotNull
    public final List<Interceptor> networkInterceptors() {
        return this.networkInterceptors;
    }

    @NotNull
    public Builder newBuilder() {
        return new Builder(this);
    }

    @Override // okhttp3.Call.Factory
    @NotNull
    public Call newCall(@NotNull Request r3) {
        Intrinsics.f(r3, "request");
        return new RealCall(this, r3, false);
    }

    @Override // okhttp3.WebSocket.Factory
    @NotNull
    public WebSocket newWebSocket(@NotNull Request r12, @NotNull WebSocketListener r13) {
        Intrinsics.f(r12, "request");
        Intrinsics.f(r13, "listener");
        RealWebSocket r0 = new RealWebSocket(TaskRunner.INSTANCE, r12, r13, new Random(), this.pingIntervalMillis, null, this.minWebSocketMessageToCompress);
        r0.connect(this);
        return r0;
    }

    @JvmName
    public final int pingIntervalMillis() {
        return this.pingIntervalMillis;
    }

    @JvmName
    @NotNull
    public final List<Protocol> protocols() {
        return this.protocols;
    }

    @JvmName
    @Nullable
    public final Proxy proxy() {
        return this.proxy;
    }

    @JvmName
    @NotNull
    public final Authenticator proxyAuthenticator() {
        return this.proxyAuthenticator;
    }

    @JvmName
    @NotNull
    public final ProxySelector proxySelector() {
        return this.proxySelector;
    }

    @JvmName
    public final int readTimeoutMillis() {
        return this.readTimeoutMillis;
    }

    @JvmName
    public final boolean retryOnConnectionFailure() {
        return this.retryOnConnectionFailure;
    }

    @JvmName
    @NotNull
    public final SocketFactory socketFactory() {
        return this.socketFactory;
    }

    @JvmName
    @NotNull
    public final SSLSocketFactory sslSocketFactory() {
        SSLSocketFactory r1 = this.sslSocketFactoryOrNull;
        if (r1 == null) goto L6;
        return r1;
    L6:
        throw new IllegalStateException("CLEARTEXT-only client");
    }

    @JvmName
    public final int writeTimeoutMillis() {
        return this.writeTimeoutMillis;
    }

    @JvmName
    @Nullable
    public final X509TrustManager x509TrustManager() {
        return this.x509TrustManager;
    }

    public OkHttpClient() {
        this(new Builder());
    }
}
