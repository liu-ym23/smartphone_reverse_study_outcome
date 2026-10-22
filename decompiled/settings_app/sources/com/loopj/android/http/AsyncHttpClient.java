package com.loopj.android.http;

import android.content.Context;
import android.os.Looper;
import androidx.core.view.MotionEventCompat;
import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HttpEntity;
import cz.msebera.android.httpclient.HttpHost;
import cz.msebera.android.httpclient.HttpVersion;
import cz.msebera.android.httpclient.auth.AuthScope;
import cz.msebera.android.httpclient.auth.Credentials;
import cz.msebera.android.httpclient.auth.UsernamePasswordCredentials;
import cz.msebera.android.httpclient.client.CookieStore;
import cz.msebera.android.httpclient.client.CredentialsProvider;
import cz.msebera.android.httpclient.client.HttpClient;
import cz.msebera.android.httpclient.client.RedirectHandler;
import cz.msebera.android.httpclient.client.methods.HttpEntityEnclosingRequestBase;
import cz.msebera.android.httpclient.client.methods.HttpHead;
import cz.msebera.android.httpclient.client.methods.HttpOptions;
import cz.msebera.android.httpclient.client.methods.HttpPatch;
import cz.msebera.android.httpclient.client.methods.HttpPost;
import cz.msebera.android.httpclient.client.methods.HttpPut;
import cz.msebera.android.httpclient.client.methods.HttpUriRequest;
import cz.msebera.android.httpclient.client.params.ClientPNames;
import cz.msebera.android.httpclient.conn.ClientConnectionManager;
import cz.msebera.android.httpclient.conn.params.ConnManagerParams;
import cz.msebera.android.httpclient.conn.params.ConnPerRouteBean;
import cz.msebera.android.httpclient.conn.params.ConnRoutePNames;
import cz.msebera.android.httpclient.conn.scheme.PlainSocketFactory;
import cz.msebera.android.httpclient.conn.scheme.Scheme;
import cz.msebera.android.httpclient.conn.scheme.SchemeRegistry;
import cz.msebera.android.httpclient.conn.ssl.SSLSocketFactory;
import cz.msebera.android.httpclient.entity.HttpEntityWrapper;
import cz.msebera.android.httpclient.impl.client.DefaultHttpClient;
import cz.msebera.android.httpclient.impl.conn.tsccm.ThreadSafeClientConnManager;
import cz.msebera.android.httpclient.params.BasicHttpParams;
import cz.msebera.android.httpclient.params.HttpConnectionParams;
import cz.msebera.android.httpclient.params.HttpParams;
import cz.msebera.android.httpclient.params.HttpProtocolParams;
import cz.msebera.android.httpclient.protocol.BasicHttpContext;
import cz.msebera.android.httpclient.protocol.HttpContext;
import cz.msebera.android.httpclient.protocol.SyncBasicHttpContext;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PushbackInputStream;
import java.lang.reflect.Field;
import java.net.URI;
import java.net.URL;
import java.net.URLDecoder;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.zip.GZIPInputStream;
import obric.time.HttpHeadTimeFetcher;

/* JADX INFO: loaded from: classes4.dex */
public class AsyncHttpClient {
    public static final int DEFAULT_MAX_CONNECTIONS = 10;
    public static final int DEFAULT_MAX_RETRIES = 5;
    public static final int DEFAULT_RETRY_SLEEP_TIME_MILLIS = 1500;
    public static final int DEFAULT_SOCKET_BUFFER_SIZE = 8192;
    public static final int DEFAULT_SOCKET_TIMEOUT = 10000;
    public static final String ENCODING_GZIP = "gzip";
    public static final String HEADER_ACCEPT_ENCODING = "Accept-Encoding";
    public static final String HEADER_CONTENT_DISPOSITION = "Content-Disposition";
    public static final String HEADER_CONTENT_ENCODING = "Content-Encoding";
    public static final String HEADER_CONTENT_RANGE = "Content-Range";
    public static final String HEADER_CONTENT_TYPE = "Content-Type";
    public static final String LOG_TAG = "AsyncHttpClient";
    public static LogInterface log;
    private final Map<String, String> clientHeaderMap;
    private int connectTimeout;
    private final DefaultHttpClient httpClient;
    private final HttpContext httpContext;
    private boolean isUrlEncodingEnabled;
    private int maxConnections;
    private final Map<Context, List<RequestHandle>> requestMap;
    private int responseTimeout;
    private ExecutorService threadPool;

    private static class InflatingEntity extends HttpEntityWrapper {
        GZIPInputStream gzippedStream;
        PushbackInputStream pushbackStream;
        InputStream wrappedStream;

        public InflatingEntity(HttpEntity r1) {
            super(r1);
        }

        @Override // cz.msebera.android.httpclient.entity.HttpEntityWrapper, cz.msebera.android.httpclient.HttpEntity
        public InputStream getContent() throws IOException {
            this.wrappedStream = this.wrappedEntity.getContent();
            PushbackInputStream r0 = new PushbackInputStream(this.wrappedStream, 2);
            this.pushbackStream = r0;
            if (AsyncHttpClient.isInputStreamGZIPCompressed(r0) == false) goto L7;
            GZIPInputStream r1 = new GZIPInputStream(this.pushbackStream);
            this.gzippedStream = r1;
            return r1;
        L7:
            return this.pushbackStream;
        }

        @Override // cz.msebera.android.httpclient.entity.HttpEntityWrapper, cz.msebera.android.httpclient.HttpEntity
        public long getContentLength() {
            if (this.wrappedEntity != null) goto L6;
            return 0;
        L6:
            return this.wrappedEntity.getContentLength();
        }

        @Override // cz.msebera.android.httpclient.entity.HttpEntityWrapper, cz.msebera.android.httpclient.HttpEntity
        public void consumeContent() throws IOException {
            AsyncHttpClient.silentCloseInputStream(this.wrappedStream);
            AsyncHttpClient.silentCloseInputStream(this.pushbackStream);
            AsyncHttpClient.silentCloseInputStream(this.gzippedStream);
            super.consumeContent();
        }
    }

    static /* synthetic */ Map access$000(AsyncHttpClient r0) {
        return r0.clientHeaderMap;
    }

    static /* synthetic */ void access$100(AsyncHttpClient r0, List r1, boolean r2) {
        r0.cancelRequests(r1, r2);
    }

    static {
        log = new LogHandler();
    }

    public AsyncHttpClient() {
        this(false, 80, 443);
    }

    public AsyncHttpClient(int r3) {
        this(false, r3, 443);
    }

    public AsyncHttpClient(int r2, int r3) {
        this(false, r2, r3);
    }

    public AsyncHttpClient(boolean r1, int r2, int r3) {
        this(getDefaultSchemeRegistry(r1, r2, r3));
    }

    public AsyncHttpClient(SchemeRegistry r6) {
        this.maxConnections = 10;
        this.connectTimeout = 10000;
        this.responseTimeout = 10000;
        boolean r1 = true;
        this.isUrlEncodingEnabled = true;
        BasicHttpParams r2 = new BasicHttpParams();
        ConnManagerParams.setTimeout(r2, this.connectTimeout);
        ConnManagerParams.setMaxConnectionsPerRoute(r2, new ConnPerRouteBean(this.maxConnections));
        ConnManagerParams.setMaxTotalConnections(r2, 10);
        HttpConnectionParams.setSoTimeout(r2, this.responseTimeout);
        HttpConnectionParams.setConnectionTimeout(r2, this.connectTimeout);
        HttpConnectionParams.setTcpNoDelay(r2, true);
        HttpConnectionParams.setSocketBufferSize(r2, 8192);
        HttpProtocolParams.setVersion(r2, HttpVersion.HTTP_1_1);
        ClientConnectionManager r7 = createConnectionManager(r6, r2);
        if (r7 != null) goto L6;
        r1 = false;
    L6:
        Utils.asserts(r1, "Custom implementation of #createConnectionManager(SchemeRegistry, BasicHttpParams) returned null");
        this.threadPool = getDefaultThreadPool();
        this.requestMap = Collections.synchronizedMap(new WeakHashMap());
        this.clientHeaderMap = new HashMap();
        this.httpContext = new SyncBasicHttpContext(new BasicHttpContext());
        DefaultHttpClient r3 = new DefaultHttpClient(r7, r2);
        this.httpClient = r3;
        r3.addRequestInterceptor(new AnonymousClass1(this));
        r3.addResponseInterceptor(new AnonymousClass2(this));
        r3.addRequestInterceptor(new AnonymousClass3(this), 0);
        r3.setHttpRequestRetryHandler(new RetryHandler(5, 1500));
    }

    private static SchemeRegistry getDefaultSchemeRegistry(boolean r4, int r5, int r6) {
        if (r4 == false) goto L6;
        log.d(LOG_TAG, "Beware! Using the fix is insecure, as it doesn't verify SSL certificates.");
    L6:
        if (r5 >= 1) goto L8;
        log.d(LOG_TAG, "Invalid HTTP port number specified, defaulting to 80");
        r5 = 80;
    L8:
        if (r6 >= 1) goto L10;
        log.d(LOG_TAG, "Invalid HTTPS port number specified, defaulting to 443");
        r6 = 443;
    L10:
        if (r4 == false) goto L12;
        SSLSocketFactory r7 = MySSLSocketFactory.getFixedSocketFactory();
    L13:
        SchemeRegistry r0 = new SchemeRegistry();
        r0.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), r5));
        r0.register(new Scheme(HttpHeadTimeFetcher.FETCHER_TYPE, r7, r6));
        return r0;
    L12:
        r7 = SSLSocketFactory.getSocketFactory();
        goto L13
    }

    public static void allowRetryExceptionClass(Class<?> r0) {
        if (r0 == null) goto L5;
        RetryHandler.addClassToWhitelist(r0);
        return;
    }

    public static void blockRetryExceptionClass(Class<?> r0) {
        if (r0 == null) goto L5;
        RetryHandler.addClassToBlacklist(r0);
        return;
    }

    public static String getUrlWithQueryString(boolean r9, String r10, RequestParams r11) {
        if (r10 != null) goto L5;
        return null;
    L5:
        if (r9 == true) goto L20;
    L10:
        if (r11 == null) goto L22;
        String r12 = r11.getParamString().trim();
        if (r12.equals("") == true) goto L23;
        String r13 = "?";
        if (r12.equals("?") == true) goto L24;
        StringBuilder r0 = new StringBuilder().append(r10);
        if (r10.contains("?") == false) goto L19;
        r13 = "&";
    L19:
        return r0.append(r13).toString() + r12;
    L24:
        return r10;
    L23:
        return r10;
    L22:
        return r10;
    L20:
        URL r1 = new URL(URLDecoder.decode(r10, "UTF-8"));     // Catch: Exception -> L8
        r10 = new URI(r1.getProtocol(), r1.getUserInfo(), r1.getHost(), r1.getPort(), r1.getPath(), r1.getQuery(), r1.getRef()).toASCIIString();     // Catch: Exception -> L8
    L8:
        e = move-exception;
        log.e(LOG_TAG, "getUrlWithQueryString encoding URL", e);
        goto L10
    }

    public static boolean isInputStreamGZIPCompressed(PushbackInputStream r5) throws IOException {
        if (r5 != null) goto L5;
        return false;
    L5:
        byte[] r2 = new byte[2];
        int r3 = 0;
    L6:
        if (r3 >= 2) goto L16;
        int r4 = r5.read(r2, r3, 2 - r3);     // Catch: Throwable -> L13
        if (r4 < 0) goto L10;
        r3 = r3 + r4;
        goto L6
    L10:
        r5.unread(r2, 0, r3);
        return false;
    L13:
        th = move-exception;
        r5.unread(r2, 0, r3);
        throw th;
    L16:
        r5.unread(r2, 0, r3);
        if (35615 == ((r2[0] & 255) | ((r2[1] << 8) & MotionEventCompat.ACTION_POINTER_INDEX_MASK))) goto L19;
        return false;
    L19:
        return true;
    }

    public static void silentCloseInputStream(InputStream r3) {
        if (r3 == null) goto L10;
        r3.close();     // Catch: IOException -> L5
        return;
    L5:
        e = move-exception;
        log.w(LOG_TAG, "Cannot close input stream", e);
        return;
    }

    public static void silentCloseOutputStream(OutputStream r3) {
        if (r3 == null) goto L10;
        r3.close();     // Catch: IOException -> L5
        return;
    L5:
        e = move-exception;
        log.w(LOG_TAG, "Cannot close output stream", e);
        return;
    }

    public static void endEntityViaReflection(HttpEntity r6) {
        if ((r6 instanceof HttpEntityWrapper) == false) goto L23;
        Field[] r0 = HttpEntityWrapper.class.getDeclaredFields();     // Catch: Throwable -> L16
        int r1 = r0.length;     // Catch: Throwable -> L16
        int r2 = 0;
    L5:
        if (r2 >= r1) goto L10;
        Field r3 = r0[r2];     // Catch: Throwable -> L16
        if (r3.getName().equals("wrappedEntity") == true) goto L11;
        r2 = r2 + 1;     // Catch: Throwable -> L16
    L11:
        if (r3 == null) goto L24;
        r3.setAccessible(true);     // Catch: Throwable -> L16
        HttpEntity r7 = (HttpEntity) r3.get(r6);     // Catch: Throwable -> L16
        if (r7 == null) goto L25;
        r7.consumeContent();     // Catch: Throwable -> L16
        return;
    L25:
        return;
    L24:
        return;
    L10:
        r3 = null;
    L16:
        th = move-exception;
        log.e(LOG_TAG, "wrappedEntity consume", th);
        return;
    }

    public HttpClient getHttpClient() {
        return this.httpClient;
    }

    public HttpContext getHttpContext() {
        return this.httpContext;
    }

    public boolean isLoggingEnabled() {
        return log.isLoggingEnabled();
    }

    public void setLoggingEnabled(boolean r1) {
        log.setLoggingEnabled(r1);
    }

    public int getLoggingLevel() {
        return log.getLoggingLevel();
    }

    public void setLoggingLevel(int r1) {
        log.setLoggingLevel(r1);
    }

    public LogInterface getLogInterface() {
        return log;
    }

    public void setLogInterface(LogInterface r1) {
        if (r1 == null) goto L5;
        log = r1;
        return;
    }

    public void setCookieStore(CookieStore r2) {
        this.httpContext.setAttribute("http.cookie-store", r2);
    }

    public ExecutorService getThreadPool() {
        return this.threadPool;
    }

    public void setThreadPool(ExecutorService r1) {
        this.threadPool = r1;
    }

    protected ExecutorService getDefaultThreadPool() {
        return Executors.newCachedThreadPool();
    }

    protected ClientConnectionManager createConnectionManager(SchemeRegistry r1, BasicHttpParams r2) {
        return new ThreadSafeClientConnManager(r2, r1);
    }

    public void setEnableRedirects(boolean r3, boolean r4, boolean r5) {
        this.httpClient.getParams().setBooleanParameter(ClientPNames.REJECT_RELATIVE_REDIRECT, !r4);
        this.httpClient.getParams().setBooleanParameter(ClientPNames.ALLOW_CIRCULAR_REDIRECTS, r5);
        this.httpClient.setRedirectHandler(new MyRedirectHandler(r3));
    }

    public void setEnableRedirects(boolean r2, boolean r3) {
        setEnableRedirects(r2, r3, true);
    }

    public void setEnableRedirects(boolean r1) {
        setEnableRedirects(r1, r1, r1);
    }

    public void setRedirectHandler(RedirectHandler r1) {
        this.httpClient.setRedirectHandler(r1);
    }

    public void setUserAgent(String r1) {
        HttpProtocolParams.setUserAgent(this.httpClient.getParams(), r1);
    }

    public int getMaxConnections() {
        return this.maxConnections;
    }

    public void setMaxConnections(int r2) {
        if (r2 >= 1) goto L5;
        r2 = 10;
    L5:
        this.maxConnections = r2;
        ConnManagerParams.setMaxConnectionsPerRoute(this.httpClient.getParams(), new ConnPerRouteBean(this.maxConnections));
    }

    public void setTimeout(int r2) {
        if (r2 >= 1000) goto L5;
        r2 = 10000;
    L5:
        setConnectTimeout(r2);
        setResponseTimeout(r2);
    }

    public int getConnectTimeout() {
        return this.connectTimeout;
    }

    public void setConnectTimeout(int r3) {
        if (r3 >= 1000) goto L5;
        r3 = 10000;
    L5:
        this.connectTimeout = r3;
        HttpParams r4 = this.httpClient.getParams();
        ConnManagerParams.setTimeout(r4, this.connectTimeout);
        HttpConnectionParams.setConnectionTimeout(r4, this.connectTimeout);
    }

    public int getResponseTimeout() {
        return this.responseTimeout;
    }

    public void setResponseTimeout(int r2) {
        if (r2 >= 1000) goto L5;
        r2 = 10000;
    L5:
        this.responseTimeout = r2;
        HttpConnectionParams.setSoTimeout(this.httpClient.getParams(), this.responseTimeout);
    }

    public void setProxy(String r2, int r3) {
        HttpHost r0 = new HttpHost(r2, r3);
        this.httpClient.getParams().setParameter(ConnRoutePNames.DEFAULT_PROXY, r0);
    }

    public void setProxy(String r4, int r5, String r6, String r7) {
        this.httpClient.getCredentialsProvider().setCredentials(new AuthScope(r4, r5), new UsernamePasswordCredentials(r6, r7));
        HttpHost r8 = new HttpHost(r4, r5);
        this.httpClient.getParams().setParameter(ConnRoutePNames.DEFAULT_PROXY, r8);
    }

    public void setSSLSocketFactory(SSLSocketFactory r4) {
        this.httpClient.getConnectionManager().getSchemeRegistry().register(new Scheme(HttpHeadTimeFetcher.FETCHER_TYPE, r4, 443));
    }

    public void setMaxRetriesAndTimeout(int r2, int r3) {
        this.httpClient.setHttpRequestRetryHandler(new RetryHandler(r2, r3));
    }

    public void removeAllHeaders() {
        this.clientHeaderMap.clear();
    }

    public void addHeader(String r1, String r2) {
        this.clientHeaderMap.put(r1, r2);
    }

    public void removeHeader(String r1) {
        this.clientHeaderMap.remove(r1);
    }

    public void setBearerAuth(String r3) {
        setBearerAuth(r3, AuthScope.ANY, false);
    }

    public void setBearerAuth(String r2, AuthScope r3, boolean r4) {
        setCredentials(r3, new TokenCredentials(r2));
        setAuthenticationPreemptive(r4);
    }

    public void setBasicAuth(String r2, String r3) {
        setBasicAuth(r2, r3, false);
    }

    public void setBasicAuth(String r2, String r3, boolean r4) {
        setBasicAuth(r2, r3, null, r4);
    }

    public void setBasicAuth(String r2, String r3, AuthScope r4) {
        setBasicAuth(r2, r3, r4, false);
    }

    public void setBasicAuth(String r2, String r3, AuthScope r4, boolean r5) {
        setCredentials(r4, new UsernamePasswordCredentials(r2, r3));
        setAuthenticationPreemptive(r5);
    }

    public void setCredentials(AuthScope r1, Credentials r2) {
        if (r2 != null) goto L5;
        log.d(LOG_TAG, "Provided credentials are null, not setting");
        return;
    L5:
        CredentialsProvider r0 = this.httpClient.getCredentialsProvider();
        if (r1 != null) goto L8;
        r1 = AuthScope.ANY;
    L8:
        r0.setCredentials(r1, r2);
    }

    public void setAuthenticationPreemptive(boolean r2) {
        if (r2 == false) goto L4;
        this.httpClient.addRequestInterceptor(new PreemptiveAuthorizationHttpRequestInterceptor(), 0);
        return;
    L4:
        this.httpClient.removeRequestInterceptorByClass(PreemptiveAuthorizationHttpRequestInterceptor.class);
    }

    public void clearCredentialsProvider() {
        this.httpClient.getCredentialsProvider().clear();
    }

    public void cancelRequests(Context r3, final boolean r4) {
        if (r3 != null) goto L5;
        log.e(LOG_TAG, "Passed null Context to cancelRequests");
        return;
    L5:
        final List<RequestHandle> r0 = this.requestMap.get(r3);
        this.requestMap.remove(r3);
        if (Looper.myLooper() != Looper.getMainLooper()) goto L8;
        Runnable r5 = new AnonymousClass4(this, r0, r4);
        this.threadPool.submit(r5);
        return;
    L8:
        cancelRequests(r0, r4);
    }

    private void cancelRequests(List<RequestHandle> r1, boolean r2) {
        if (r1 == null) goto L7;
        Iterator<RequestHandle> r0 = r1.iterator();
    L5:
        if (r0.hasNext() == false) goto L9;
        r0.next().cancel(r2);
        goto L5
    L9:
        return;
    }

    public void cancelAllRequests(boolean r4) {
        Iterator<List<RequestHandle>> r0 = this.requestMap.values().iterator();
    L4:
        if (r0.hasNext() == false) goto L11;
        List<RequestHandle> r1 = r0.next();
        if (r1 == null) goto L4;
        Iterator<RequestHandle> r2 = r1.iterator();
    L9:
        if (r2.hasNext() == false) goto L4;
        r2.next().cancel(r4);
        goto L9
    L11:
        this.requestMap.clear();
    }

    public void cancelRequestsByTAG(Object r4, boolean r5) {
        if (r4 != null) goto L5;
        log.d(LOG_TAG, "cancelRequestsByTAG, passed TAG is null, cannot proceed");
        return;
    L5:
        Iterator<List<RequestHandle>> r3 = this.requestMap.values().iterator();
    L7:
        if (r3.hasNext() == false) goto L16;
        List<RequestHandle> r0 = r3.next();
        if (r0 == null) goto L7;
        Iterator<RequestHandle> r1 = r0.iterator();
    L12:
        if (r1.hasNext() == false) goto L7;
        RequestHandle r2 = r1.next();
        if (r4.equals(r2.getTag()) == false) goto L12;
        r2.cancel(r5);
        goto L12
    }

    public RequestHandle options(String r2, ResponseHandlerInterface r3) {
        return options(null, r2, null, r3);
    }

    public RequestHandle options(Context r8, String r9, RequestParams r10, ResponseHandlerInterface r11) {
        return sendRequest(this.httpClient, this.httpContext, new HttpOptions(getUrlWithQueryString(isUrlEncodingEnabled(), r9, r10)), null, r11, r8);
    }

    public RequestHandle head(String r2, ResponseHandlerInterface r3) {
        return head(null, r2, null, r3);
    }

    public RequestHandle head(String r2, RequestParams r3, ResponseHandlerInterface r4) {
        return head(null, r2, r3, r4);
    }

    public RequestHandle head(Context r2, String r3, ResponseHandlerInterface r4) {
        return head(r2, r3, null, r4);
    }

    public RequestHandle head(Context r8, String r9, RequestParams r10, ResponseHandlerInterface r11) {
        return sendRequest(this.httpClient, this.httpContext, new HttpHead(getUrlWithQueryString(this.isUrlEncodingEnabled, r9, r10)), null, r11, r8);
    }

    public RequestHandle head(Context r8, String r9, Header[] r10, RequestParams r11, ResponseHandlerInterface r12) {
        HttpHead r3 = new HttpHead(getUrlWithQueryString(this.isUrlEncodingEnabled, r9, r11));
        if (r10 == null) goto L6;
        r3.setHeaders(r10);
    L6:
        return sendRequest(this.httpClient, this.httpContext, r3, null, r12, r8);
    }

    public RequestHandle get(String r2, ResponseHandlerInterface r3) {
        return get(null, r2, null, r3);
    }

    public RequestHandle get(String r2, RequestParams r3, ResponseHandlerInterface r4) {
        return get(null, r2, r3, r4);
    }

    public RequestHandle get(Context r2, String r3, ResponseHandlerInterface r4) {
        return get(r2, r3, null, r4);
    }

    public RequestHandle get(Context r8, String r9, RequestParams r10, ResponseHandlerInterface r11) {
        return sendRequest(this.httpClient, this.httpContext, new HttpGet(getUrlWithQueryString(this.isUrlEncodingEnabled, r9, r10)), null, r11, r8);
    }

    public RequestHandle get(Context r8, String r9, Header[] r10, RequestParams r11, ResponseHandlerInterface r12) {
        HttpGet r3 = new HttpGet(getUrlWithQueryString(this.isUrlEncodingEnabled, r9, r11));
        if (r10 == null) goto L6;
        r3.setHeaders(r10);
    L6:
        return sendRequest(this.httpClient, this.httpContext, r3, null, r12, r8);
    }

    public RequestHandle get(Context r8, String r9, HttpEntity r10, String r11, ResponseHandlerInterface r12) {
        return sendRequest(this.httpClient, this.httpContext, addEntityToRequestBase(new HttpGet(URI.create(r9).normalize()), r10), r11, r12, r8);
    }

    public RequestHandle post(String r2, ResponseHandlerInterface r3) {
        return post(null, r2, null, r3);
    }

    public RequestHandle post(String r2, RequestParams r3, ResponseHandlerInterface r4) {
        return post(null, r2, r3, r4);
    }

    public RequestHandle post(Context r7, String r8, RequestParams r9, ResponseHandlerInterface r10) {
        return post(r7, r8, paramsToEntity(r9, r10), null, r10);
    }

    public RequestHandle post(Context r8, String r9, HttpEntity r10, String r11, ResponseHandlerInterface r12) {
        return sendRequest(this.httpClient, this.httpContext, addEntityToRequestBase(new HttpPost(getURI(r9)), r10), r11, r12, r8);
    }

    public RequestHandle post(Context r8, String r9, Header[] r10, RequestParams r11, String r12, ResponseHandlerInterface r13) {
        HttpPost r3 = new HttpPost(getURI(r9));
        if (r11 == null) goto L5;
        r3.setEntity(paramsToEntity(r11, r13));
    L5:
        if (r10 == null) goto L8;
        r3.setHeaders(r10);
    L8:
        return sendRequest(this.httpClient, this.httpContext, r3, r12, r13, r8);
    }

    public RequestHandle post(Context r9, String r10, Header[] r11, HttpEntity r12, String r13, ResponseHandlerInterface r14) {
        HttpEntityEnclosingRequestBase r4 = addEntityToRequestBase(new HttpPost(getURI(r10)), r12);
        if (r11 == null) goto L6;
        r4.setHeaders(r11);
    L6:
        return sendRequest(this.httpClient, this.httpContext, r4, r13, r14, r9);
    }

    public RequestHandle put(String r2, ResponseHandlerInterface r3) {
        return put(null, r2, null, r3);
    }

    public RequestHandle put(String r2, RequestParams r3, ResponseHandlerInterface r4) {
        return put(null, r2, r3, r4);
    }

    public RequestHandle put(Context r7, String r8, RequestParams r9, ResponseHandlerInterface r10) {
        return put(r7, r8, paramsToEntity(r9, r10), null, r10);
    }

    public RequestHandle put(Context r8, String r9, HttpEntity r10, String r11, ResponseHandlerInterface r12) {
        return sendRequest(this.httpClient, this.httpContext, addEntityToRequestBase(new HttpPut(getURI(r9)), r10), r11, r12, r8);
    }

    public RequestHandle put(Context r9, String r10, Header[] r11, HttpEntity r12, String r13, ResponseHandlerInterface r14) {
        HttpEntityEnclosingRequestBase r4 = addEntityToRequestBase(new HttpPut(getURI(r10)), r12);
        if (r11 == null) goto L6;
        r4.setHeaders(r11);
    L6:
        return sendRequest(this.httpClient, this.httpContext, r4, r13, r14, r9);
    }

    public RequestHandle patch(String r2, ResponseHandlerInterface r3) {
        return patch(null, r2, null, r3);
    }

    public RequestHandle patch(String r2, RequestParams r3, ResponseHandlerInterface r4) {
        return patch(null, r2, r3, r4);
    }

    public RequestHandle patch(Context r7, String r8, RequestParams r9, ResponseHandlerInterface r10) {
        return patch(r7, r8, paramsToEntity(r9, r10), null, r10);
    }

    public RequestHandle patch(Context r8, String r9, HttpEntity r10, String r11, ResponseHandlerInterface r12) {
        return sendRequest(this.httpClient, this.httpContext, addEntityToRequestBase(new HttpPatch(getURI(r9)), r10), r11, r12, r8);
    }

    public RequestHandle patch(Context r9, String r10, Header[] r11, HttpEntity r12, String r13, ResponseHandlerInterface r14) {
        HttpEntityEnclosingRequestBase r4 = addEntityToRequestBase(new HttpPatch(getURI(r10)), r12);
        if (r11 == null) goto L6;
        r4.setHeaders(r11);
    L6:
        return sendRequest(this.httpClient, this.httpContext, r4, r13, r14, r9);
    }

    public RequestHandle delete(String r2, ResponseHandlerInterface r3) {
        return delete(null, r2, r3);
    }

    public RequestHandle delete(Context r8, String r9, ResponseHandlerInterface r10) {
        HttpDelete r3 = new HttpDelete(getURI(r9));
        return sendRequest(this.httpClient, this.httpContext, r3, null, r10, r8);
    }

    public RequestHandle delete(Context r8, String r9, Header[] r10, ResponseHandlerInterface r11) {
        HttpDelete r3 = new HttpDelete(getURI(r9));
        if (r10 == null) goto L6;
        r3.setHeaders(r10);
    L6:
        return sendRequest(this.httpClient, this.httpContext, r3, null, r11, r8);
    }

    public RequestHandle delete(String r8, RequestParams r9, AsyncHttpResponseHandler r10) {
        HttpDelete r3 = new HttpDelete(getUrlWithQueryString(this.isUrlEncodingEnabled, r8, r9));
        return sendRequest(this.httpClient, this.httpContext, r3, null, r10, null);
    }

    public RequestHandle delete(Context r8, String r9, Header[] r10, RequestParams r11, ResponseHandlerInterface r12) {
        HttpDelete r3 = new HttpDelete(getUrlWithQueryString(this.isUrlEncodingEnabled, r9, r11));
        if (r10 == null) goto L6;
        r3.setHeaders(r10);
    L6:
        return sendRequest(this.httpClient, this.httpContext, r3, null, r12, r8);
    }

    public RequestHandle delete(Context r8, String r9, HttpEntity r10, String r11, ResponseHandlerInterface r12) {
        return sendRequest(this.httpClient, this.httpContext, addEntityToRequestBase(new HttpDelete(URI.create(r9).normalize()), r10), r11, r12, r8);
    }

    protected AsyncHttpRequest newAsyncHttpRequest(DefaultHttpClient r1, HttpContext r2, HttpUriRequest r3, String r4, ResponseHandlerInterface r5, Context r6) {
        return new AsyncHttpRequest(r1, r2, r3, r5);
    }

    protected RequestHandle sendRequest(DefaultHttpClient r4, HttpContext r5, HttpUriRequest r6, String r7, ResponseHandlerInterface r8, Context r9) {
        if (r6 == null) goto L41;
        if (r8 == null) goto L39;
        if (r8.getUseSynchronousMode() == true) goto L7;
    L11:
        if (r7 != null) goto L13;
    L20:
        r8.setRequestHeaders(r6.getAllHeaders());
        r8.setRequestURI(r6.getURI());
        AsyncHttpRequest r10 = newAsyncHttpRequest(r4, r5, r6, r7, r8, r9);
        this.threadPool.submit(r10);
        RequestHandle r11 = new RequestHandle(r10);
        if (r9 == null) goto L37;
        Map<Context, List<RequestHandle>> r12 = this.requestMap;
        monitor-enter(r12);
        List<RequestHandle> r13 = this.requestMap.get(r9);     // Catch: Throwable -> L34
        if (r13 != null) goto L27;
        r13 = Collections.synchronizedList(new LinkedList());     // Catch: Throwable -> L34
        this.requestMap.put(r9, r13);     // Catch: Throwable -> L34
    L27:
        monitor-exit(r12);     // Catch: Throwable -> L34
        r13.add(r11);
        Iterator<RequestHandle> r3 = r13.iterator();
    L30:
        if (r3.hasNext() == false) goto L37;
        if (r3.next().shouldBeGarbageCollected() == false) goto L30;
        r3.remove();
    L34:
        th = move-exception;
        throw th;
    L37:
        return r11;
    L13:
        if ((r6 instanceof HttpEntityEnclosingRequestBase) == true) goto L15;
    L19:
        r6.setHeader("Content-Type", r7);
        goto L20
    L15:
        if (((HttpEntityEnclosingRequestBase) r6).getEntity() == null) goto L19;
        if (r6.containsHeader("Content-Type") == false) goto L19;
        log.w(LOG_TAG, "Passed contentType will be ignored because HttpEntity sets content type");
        goto L20
    L7:
        if (r8.getUsePoolThread() == true) goto L11;
        throw new IllegalArgumentException("Synchronous ResponseHandler used in AsyncHttpClient. You should create your response handler in a looper thread or use SyncHttpClient instead.");
    L39:
        throw new IllegalArgumentException("ResponseHandler must not be null");
    L41:
        throw new IllegalArgumentException("HttpUriRequest must not be null");
    }

    protected URI getURI(String r1) {
        return URI.create(r1).normalize();
    }

    public void setURLEncodingEnabled(boolean r1) {
        this.isUrlEncodingEnabled = r1;
    }

    private HttpEntity paramsToEntity(RequestParams r2, ResponseHandlerInterface r3) {
        if (r2 == null) goto L13;
        return r2.getEntity(r3);
    L6:
        e = move-exception;
        if (r3 == null) goto L9;
        r3.sendFailureMessage(0, null, null, e);
        return null;
    L9:
        e.printStackTrace();
        return null;
    L13:
        return null;
    }

    public boolean isUrlEncodingEnabled() {
        return this.isUrlEncodingEnabled;
    }

    private HttpEntityEnclosingRequestBase addEntityToRequestBase(HttpEntityEnclosingRequestBase r1, HttpEntity r2) {
        if (r2 == null) goto L4;
        r1.setEntity(r2);
    L4:
        return r1;
    }
}
