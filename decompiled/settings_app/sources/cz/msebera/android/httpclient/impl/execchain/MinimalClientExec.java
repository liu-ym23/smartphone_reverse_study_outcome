package cz.msebera.android.httpclient.impl.execchain;

import cz.msebera.android.httpclient.ConnectionReuseStrategy;
import cz.msebera.android.httpclient.HttpClientConnection;
import cz.msebera.android.httpclient.HttpEntity;
import cz.msebera.android.httpclient.HttpException;
import cz.msebera.android.httpclient.HttpHost;
import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.HttpRequestInterceptor;
import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.ProtocolException;
import cz.msebera.android.httpclient.client.config.RequestConfig;
import cz.msebera.android.httpclient.client.methods.CloseableHttpResponse;
import cz.msebera.android.httpclient.client.methods.HttpExecutionAware;
import cz.msebera.android.httpclient.client.methods.HttpRequestWrapper;
import cz.msebera.android.httpclient.client.methods.HttpUriRequest;
import cz.msebera.android.httpclient.client.protocol.HttpClientContext;
import cz.msebera.android.httpclient.client.protocol.RequestClientConnControl;
import cz.msebera.android.httpclient.client.utils.URIUtils;
import cz.msebera.android.httpclient.conn.ConnectionKeepAliveStrategy;
import cz.msebera.android.httpclient.conn.ConnectionRequest;
import cz.msebera.android.httpclient.conn.HttpClientConnectionManager;
import cz.msebera.android.httpclient.conn.routing.HttpRoute;
import cz.msebera.android.httpclient.extras.HttpClientAndroidLog;
import cz.msebera.android.httpclient.impl.conn.ConnectionShutdownException;
import cz.msebera.android.httpclient.protocol.HttpProcessor;
import cz.msebera.android.httpclient.protocol.HttpRequestExecutor;
import cz.msebera.android.httpclient.protocol.ImmutableHttpProcessor;
import cz.msebera.android.httpclient.protocol.RequestContent;
import cz.msebera.android.httpclient.protocol.RequestTargetHost;
import cz.msebera.android.httpclient.protocol.RequestUserAgent;
import cz.msebera.android.httpclient.util.Args;
import cz.msebera.android.httpclient.util.VersionInfo;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.EnumSet;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes5.dex */
public class MinimalClientExec implements ClientExecChain {
    private final HttpClientConnectionManager connManager;
    private final HttpProcessor httpProcessor;
    private final ConnectionKeepAliveStrategy keepAliveStrategy;
    public HttpClientAndroidLog log;
    private final HttpRequestExecutor requestExecutor;
    private final ConnectionReuseStrategy reuseStrategy;

    public MinimalClientExec(HttpRequestExecutor r7, HttpClientConnectionManager r8, ConnectionReuseStrategy r9, ConnectionKeepAliveStrategy r10) {
        this.log = new HttpClientAndroidLog(getClass());
        Args.notNull(r7, "HTTP request executor");
        Args.notNull(r8, "Client connection manager");
        Args.notNull(r9, "Connection reuse strategy");
        Args.notNull(r10, "Connection keep alive strategy");
        this.httpProcessor = new ImmutableHttpProcessor(new HttpRequestInterceptor[]{new RequestContent(), new RequestTargetHost(), new RequestClientConnControl(), new RequestUserAgent(VersionInfo.getUserAgent("Apache-HttpClient", "cz.msebera.android.httpclient.client", getClass()))});
        this.requestExecutor = r7;
        this.connManager = r8;
        this.reuseStrategy = r9;
        this.keepAliveStrategy = r10;
    }

    static void rewriteRequestURI(HttpRequestWrapper r2, HttpRoute r3, boolean r4) throws ProtocolException {
        URI r5 = r2.getURI();     // Catch: URISyntaxException -> L13
        if (r5 != null) goto L5;
        return;
    L5:
        if (r5.isAbsolute() == false) goto L10;
        if (r4 == false) goto L8;
        EnumSet<URIUtils.UriFlag> r6 = URIUtils.DROP_FRAGMENT_AND_NORMALIZE;     // Catch: URISyntaxException -> L13
    L9:
        URI r7 = URIUtils.rewriteURI(r5, null, r6);     // Catch: URISyntaxException -> L13
    L11:
        r2.setURI(r7);     // Catch: URISyntaxException -> L13
        return;
    L8:
        r6 = URIUtils.DROP_FRAGMENT;     // Catch: URISyntaxException -> L13
        goto L9
    L10:
        r7 = URIUtils.rewriteURI(r5);     // Catch: URISyntaxException -> L13
    L13:
        e = move-exception;
        throw new ProtocolException("Invalid URI: " + r2.getRequestLine().getUri(), e);
    }

    @Override // cz.msebera.android.httpclient.impl.execchain.ClientExecChain
    public CloseableHttpResponse execute(HttpRoute r8, HttpRequestWrapper r9, HttpClientContext r10, HttpExecutionAware r11) throws IOException, HttpException {
        Args.notNull(r8, "HTTP route");
        Args.notNull(r9, "HTTP request");
        Args.notNull(r10, "HTTP context");
        rewriteRequestURI(r9, r8, r10.getRequestConfig().isNormalizeUri());
        ConnectionRequest r0 = this.connManager.requestConnection(r8, null);
        if (r11 != null) goto L5;
    L9:
        RequestConfig r3 = r10.getRequestConfig();
        int r4 = r3.getConnectionRequestTimeout();     // Catch: ExecutionException -> L68 InterruptedException -> L75
        if (r4 <= 0) goto L13;
        long r5 = r4;
    L14:
        HttpClientConnection r1 = r0.get(r5, TimeUnit.MILLISECONDS);     // Catch: ExecutionException -> L68 InterruptedException -> L75
        ConnectionHolder r6 = new ConnectionHolder(this.log, this.connManager, r1);
        if (r11 == null) goto L23;
    L62:
        e = move-exception;
        r6.abortConnection();
        throw e;
    L65:
        e = move-exception;
        InterruptedIOException r12 = new InterruptedIOException("Connection has been shut down");
        r12.initCause(e);
        throw r12;
    L59:
        e = move-exception;
        r6.abortConnection();
        throw e;
    L53:
        e = move-exception;
        this.connManager.shutdown();
        throw e;
    L56:
        e = move-exception;
        r6.abortConnection();
        throw e;
    L18:
        if (r11.isAborted() == true) goto L20;
        r11.setCancellable(r6);     // Catch: Error -> L53 RuntimeException -> L56 IOException -> L59 HttpException -> L62 ConnectionShutdownException -> L65
        goto L23
    L20:
        r6.close();     // Catch: Error -> L53 RuntimeException -> L56 IOException -> L59 HttpException -> L62 ConnectionShutdownException -> L65
        throw new RequestAbortedException("Request aborted");     // Catch: Error -> L53 RuntimeException -> L56 IOException -> L59 HttpException -> L62 ConnectionShutdownException -> L65
    L23:
        if (r1.isOpen() == true) goto L29;
        int r13 = r3.getConnectTimeout();     // Catch: Error -> L53 RuntimeException -> L56 IOException -> L59 HttpException -> L62 ConnectionShutdownException -> L65
        HttpClientConnectionManager r2 = this.connManager;     // Catch: Error -> L53 RuntimeException -> L56 IOException -> L59 HttpException -> L62 ConnectionShutdownException -> L65
        if (r13 > 0) goto L28;
        r13 = 0;
    L28:
        r2.connect(r1, r8, r13, r10);     // Catch: Error -> L53 RuntimeException -> L56 IOException -> L59 HttpException -> L62 ConnectionShutdownException -> L65
        this.connManager.routeComplete(r1, r8, r10);     // Catch: Error -> L53 RuntimeException -> L56 IOException -> L59 HttpException -> L62 ConnectionShutdownException -> L65
    L29:
        int r14 = r3.getSocketTimeout();     // Catch: Error -> L53 RuntimeException -> L56 IOException -> L59 HttpException -> L62 ConnectionShutdownException -> L65
        if (r14 < 0) goto L32;
        r1.setSocketTimeout(r14);     // Catch: Error -> L53 RuntimeException -> L56 IOException -> L59 HttpException -> L62 ConnectionShutdownException -> L65
    L32:
        HttpRequest r15 = r9.getOriginal();     // Catch: Error -> L53 RuntimeException -> L56 IOException -> L59 HttpException -> L62 ConnectionShutdownException -> L65
        if ((r15 instanceof HttpUriRequest) == false) goto L37;
        URI r16 = ((HttpUriRequest) r15).getURI();     // Catch: Error -> L53 RuntimeException -> L56 IOException -> L59 HttpException -> L62 ConnectionShutdownException -> L65
        if (r16.isAbsolute() == false) goto L37;
        Object r7 = new HttpHost(r16.getHost(), r16.getPort(), r16.getScheme());     // Catch: Error -> L53 RuntimeException -> L56 IOException -> L59 HttpException -> L62 ConnectionShutdownException -> L65
    L38:
        if (r7 != null) goto L40;
        r7 = r8.getTargetHost();     // Catch: Error -> L53 RuntimeException -> L56 IOException -> L59 HttpException -> L62 ConnectionShutdownException -> L65
    L40:
        r10.setAttribute("http.target_host", r7);     // Catch: Error -> L53 RuntimeException -> L56 IOException -> L59 HttpException -> L62 ConnectionShutdownException -> L65
        r10.setAttribute("http.request", r9);     // Catch: Error -> L53 RuntimeException -> L56 IOException -> L59 HttpException -> L62 ConnectionShutdownException -> L65
        r10.setAttribute("http.connection", r1);     // Catch: Error -> L53 RuntimeException -> L56 IOException -> L59 HttpException -> L62 ConnectionShutdownException -> L65
        r10.setAttribute("http.route", r8);     // Catch: Error -> L53 RuntimeException -> L56 IOException -> L59 HttpException -> L62 ConnectionShutdownException -> L65
        this.httpProcessor.process(r9, r10);     // Catch: Error -> L53 RuntimeException -> L56 IOException -> L59 HttpException -> L62 ConnectionShutdownException -> L65
        HttpResponse r17 = this.requestExecutor.execute(r9, r1, r10);     // Catch: Error -> L53 RuntimeException -> L56 IOException -> L59 HttpException -> L62 ConnectionShutdownException -> L65
        this.httpProcessor.process(r17, r10);     // Catch: Error -> L53 RuntimeException -> L56 IOException -> L59 HttpException -> L62 ConnectionShutdownException -> L65
        if (this.reuseStrategy.keepAlive(r17, r10) == false) goto L43;
        r6.setValidFor(this.keepAliveStrategy.getKeepAliveDuration(r17, r10), TimeUnit.MILLISECONDS);     // Catch: Error -> L53 RuntimeException -> L56 IOException -> L59 HttpException -> L62 ConnectionShutdownException -> L65
        r6.markReusable();     // Catch: Error -> L53 RuntimeException -> L56 IOException -> L59 HttpException -> L62 ConnectionShutdownException -> L65
    L44:
        HttpEntity r18 = r17.getEntity();     // Catch: Error -> L53 RuntimeException -> L56 IOException -> L59 HttpException -> L62 ConnectionShutdownException -> L65
        if (r18 != null) goto L47;
    L51:
        r6.releaseConnection();     // Catch: Error -> L53 RuntimeException -> L56 IOException -> L59 HttpException -> L62 ConnectionShutdownException -> L65
        return new HttpResponseProxy(r17, null);
    L47:
        if (r18.isStreaming() == false) goto L51;
        return new HttpResponseProxy(r17, r6);
    L43:
        r6.markNonReusable();     // Catch: Error -> L53 RuntimeException -> L56 IOException -> L59 HttpException -> L62 ConnectionShutdownException -> L65
    L37:
        r7 = null;
        goto L38
    L13:
        r5 = 0;
    L75:
        e = move-exception;
        Thread.currentThread().interrupt();
        throw new RequestAbortedException("Request aborted", e);
    L68:
        e = e;
        Throwable r19 = e.getCause();
        if (r19 == null) goto L74;
        e = r19;
    L74:
        throw new RequestAbortedException("Request execution failed", e);
    L5:
        if (r11.isAborted() == true) goto L7;
        r11.setCancellable(r0);
        goto L9
    L7:
        r0.cancel();
        throw new RequestAbortedException("Request aborted");
    }
}
