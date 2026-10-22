package cz.msebera.android.httpclient.impl.client;

import cz.msebera.android.httpclient.HttpHost;
import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.client.HttpClient;
import cz.msebera.android.httpclient.client.ResponseHandler;
import cz.msebera.android.httpclient.client.ServiceUnavailableRetryStrategy;
import cz.msebera.android.httpclient.client.methods.HttpUriRequest;
import cz.msebera.android.httpclient.conn.ClientConnectionManager;
import cz.msebera.android.httpclient.extras.HttpClientAndroidLog;
import cz.msebera.android.httpclient.params.HttpParams;
import cz.msebera.android.httpclient.protocol.HttpContext;
import cz.msebera.android.httpclient.util.Args;
import cz.msebera.android.httpclient.util.EntityUtils;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.URI;

/* JADX INFO: loaded from: classes5.dex */
@Deprecated
public class AutoRetryHttpClient implements HttpClient {
    private final HttpClient backend;
    public HttpClientAndroidLog log;
    private final ServiceUnavailableRetryStrategy retryStrategy;

    public AutoRetryHttpClient(HttpClient r3, ServiceUnavailableRetryStrategy r4) {
        this.log = new HttpClientAndroidLog(getClass());
        Args.notNull(r3, "HttpClient");
        Args.notNull(r4, "ServiceUnavailableRetryStrategy");
        this.backend = r3;
        this.retryStrategy = r4;
    }

    public AutoRetryHttpClient() {
        this(new DefaultHttpClient(), new DefaultServiceUnavailableRetryStrategy());
    }

    public AutoRetryHttpClient(ServiceUnavailableRetryStrategy r2) {
        this(new DefaultHttpClient(), r2);
    }

    public AutoRetryHttpClient(HttpClient r2) {
        this(r2, new DefaultServiceUnavailableRetryStrategy());
    }

    @Override // cz.msebera.android.httpclient.client.HttpClient
    public HttpResponse execute(HttpHost r2, HttpRequest r3) throws IOException {
        return execute(r2, r3, null);
    }

    @Override // cz.msebera.android.httpclient.client.HttpClient
    public <T> T execute(HttpHost r2, HttpRequest r3, ResponseHandler<? extends T> r4) throws IOException {
        return (T) execute(r2, r3, r4, null);
    }

    @Override // cz.msebera.android.httpclient.client.HttpClient
    public <T> T execute(HttpHost r1, HttpRequest r2, ResponseHandler<? extends T> r3, HttpContext r4) throws IOException {
        return r3.handleResponse(execute(r1, r2, r4));
    }

    @Override // cz.msebera.android.httpclient.client.HttpClient
    public HttpResponse execute(HttpUriRequest r2) throws IOException {
        return execute(r2, null);
    }

    @Override // cz.msebera.android.httpclient.client.HttpClient
    public HttpResponse execute(HttpUriRequest r5, HttpContext r6) throws IOException {
        URI r0 = r5.getURI();
        return execute(new HttpHost(r0.getHost(), r0.getPort(), r0.getScheme()), r5, r6);
    }

    @Override // cz.msebera.android.httpclient.client.HttpClient
    public <T> T execute(HttpUriRequest r2, ResponseHandler<? extends T> r3) throws IOException {
        return (T) execute(r2, r3, null);
    }

    @Override // cz.msebera.android.httpclient.client.HttpClient
    public <T> T execute(HttpUriRequest r1, ResponseHandler<? extends T> r2, HttpContext r3) throws IOException {
        return r2.handleResponse(execute(r1, r3));
    }

    @Override // cz.msebera.android.httpclient.client.HttpClient
    public HttpResponse execute(HttpHost r8, HttpRequest r9, HttpContext r10) throws IOException {
        int r0 = 1;
    L3:
        HttpResponse r1 = this.backend.execute(r8, r9, r10);
    L12:
        e = move-exception;
        EntityUtils.consume(r1.getEntity());     // Catch: IOException -> L15
    L17:
        throw e;
    L15:
        e = move-exception;
        this.log.warn("I/O error consuming response content", e);
        goto L17
    L5:
        if (this.retryStrategy.retryRequest(r1, r0, r10) == false) goto L11;
        EntityUtils.consume(r1.getEntity());     // Catch: RuntimeException -> L12
        long r2 = this.retryStrategy.getRetryInterval();     // Catch: RuntimeException -> L12
        this.log.trace("Wait for " + r2);     // Catch: InterruptedException -> L9 RuntimeException -> L12
        Thread.sleep(r2);     // Catch: InterruptedException -> L9 RuntimeException -> L12
        r0 = r0 + 1;
        goto L3
    L9:
        Thread.currentThread().interrupt();     // Catch: RuntimeException -> L12
        throw new InterruptedIOException();     // Catch: RuntimeException -> L12
    L11:
        return r1;
    }

    @Override // cz.msebera.android.httpclient.client.HttpClient
    public ClientConnectionManager getConnectionManager() {
        return this.backend.getConnectionManager();
    }

    @Override // cz.msebera.android.httpclient.client.HttpClient
    public HttpParams getParams() {
        return this.backend.getParams();
    }
}
