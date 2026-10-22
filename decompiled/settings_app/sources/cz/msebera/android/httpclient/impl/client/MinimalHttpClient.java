package cz.msebera.android.httpclient.impl.client;

import cz.msebera.android.httpclient.HttpException;
import cz.msebera.android.httpclient.HttpHost;
import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.client.ClientProtocolException;
import cz.msebera.android.httpclient.client.config.RequestConfig;
import cz.msebera.android.httpclient.client.methods.CloseableHttpResponse;
import cz.msebera.android.httpclient.client.methods.Configurable;
import cz.msebera.android.httpclient.client.methods.HttpExecutionAware;
import cz.msebera.android.httpclient.client.methods.HttpRequestWrapper;
import cz.msebera.android.httpclient.client.protocol.HttpClientContext;
import cz.msebera.android.httpclient.conn.ClientConnectionManager;
import cz.msebera.android.httpclient.conn.HttpClientConnectionManager;
import cz.msebera.android.httpclient.conn.routing.HttpRoute;
import cz.msebera.android.httpclient.impl.DefaultConnectionReuseStrategy;
import cz.msebera.android.httpclient.impl.execchain.MinimalClientExec;
import cz.msebera.android.httpclient.params.BasicHttpParams;
import cz.msebera.android.httpclient.params.HttpParams;
import cz.msebera.android.httpclient.protocol.BasicHttpContext;
import cz.msebera.android.httpclient.protocol.HttpContext;
import cz.msebera.android.httpclient.protocol.HttpRequestExecutor;
import cz.msebera.android.httpclient.util.Args;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
class MinimalHttpClient extends CloseableHttpClient {
    private final HttpClientConnectionManager connManager;
    private final HttpParams params;
    private final MinimalClientExec requestExecutor;

    static /* synthetic */ HttpClientConnectionManager access$000(MinimalHttpClient r0) {
        return r0.connManager;
    }

    public MinimalHttpClient(HttpClientConnectionManager r5) {
        this.connManager = (HttpClientConnectionManager) Args.notNull(r5, "HTTP connection manager");
        this.requestExecutor = new MinimalClientExec(new HttpRequestExecutor(), r5, DefaultConnectionReuseStrategy.INSTANCE, DefaultConnectionKeepAliveStrategy.INSTANCE);
        this.params = new BasicHttpParams();
    }

    @Override // cz.msebera.android.httpclient.impl.client.CloseableHttpClient
    protected CloseableHttpResponse doExecute(HttpHost r5, HttpRequest r6, HttpContext r7) throws IOException, ClientProtocolException {
        Args.notNull(r5, "Target host");
        Args.notNull(r6, "HTTP request");
        RequestConfig r1 = null;
        if ((r6 instanceof HttpExecutionAware) == false) goto L5;
        HttpExecutionAware r0 = (HttpExecutionAware) r6;
    L20:
        HttpRequestWrapper r2 = HttpRequestWrapper.wrap(r6);     // Catch: HttpException -> L17
        if (r7 != null) goto L10;
        r7 = new BasicHttpContext();     // Catch: HttpException -> L17
    L10:
        HttpClientContext r8 = HttpClientContext.adapt(r7);     // Catch: HttpException -> L17
        HttpRoute r3 = new HttpRoute(r5);     // Catch: HttpException -> L17
        if ((r6 instanceof Configurable) == false) goto L13;
        r1 = ((Configurable) r6).getConfig();     // Catch: HttpException -> L17
    L13:
        if (r1 == null) goto L15;
        r8.setRequestConfig(r1);     // Catch: HttpException -> L17
    L15:
        return this.requestExecutor.execute(r3, r2, r8, r0);
    L17:
        e = move-exception;
        throw new ClientProtocolException(e);
    L5:
        r0 = null;
        goto L20
    }

    @Override // cz.msebera.android.httpclient.client.HttpClient
    public HttpParams getParams() {
        return this.params;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.connManager.shutdown();
    }

    @Override // cz.msebera.android.httpclient.client.HttpClient
    public ClientConnectionManager getConnectionManager() {
        return new AnonymousClass1(this);
    }
}
