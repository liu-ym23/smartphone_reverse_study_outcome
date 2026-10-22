package cz.msebera.android.httpclient.impl.client;

import cz.msebera.android.httpclient.HttpHost;
import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.client.ClientProtocolException;
import cz.msebera.android.httpclient.client.HttpClient;
import cz.msebera.android.httpclient.client.ResponseHandler;
import cz.msebera.android.httpclient.client.methods.CloseableHttpResponse;
import cz.msebera.android.httpclient.client.methods.HttpUriRequest;
import cz.msebera.android.httpclient.client.utils.URIUtils;
import cz.msebera.android.httpclient.extras.HttpClientAndroidLog;
import cz.msebera.android.httpclient.protocol.HttpContext;
import cz.msebera.android.httpclient.util.Args;
import cz.msebera.android.httpclient.util.EntityUtils;
import java.io.Closeable;
import java.io.IOException;
import java.net.URI;

/* JADX INFO: loaded from: classes5.dex */
public abstract class CloseableHttpClient implements HttpClient, Closeable {
    public HttpClientAndroidLog log;

    protected abstract CloseableHttpResponse doExecute(HttpHost r1, HttpRequest r2, HttpContext r3) throws IOException, ClientProtocolException;

    @Override // cz.msebera.android.httpclient.client.HttpClient
    public /* bridge */ /* synthetic */ HttpResponse execute(HttpHost r1, HttpRequest r2) throws IOException, ClientProtocolException {
        return execute(r1, r2);
    }

    @Override // cz.msebera.android.httpclient.client.HttpClient
    public /* bridge */ /* synthetic */ HttpResponse execute(HttpHost r1, HttpRequest r2, HttpContext r3) throws IOException, ClientProtocolException {
        return execute(r1, r2, r3);
    }

    @Override // cz.msebera.android.httpclient.client.HttpClient
    public /* bridge */ /* synthetic */ HttpResponse execute(HttpUriRequest r1) throws IOException, ClientProtocolException {
        return execute(r1);
    }

    @Override // cz.msebera.android.httpclient.client.HttpClient
    public /* bridge */ /* synthetic */ HttpResponse execute(HttpUriRequest r1, HttpContext r2) throws IOException, ClientProtocolException {
        return execute(r1, r2);
    }

    public CloseableHttpClient() {
        this.log = new HttpClientAndroidLog(getClass());
    }

    @Override // cz.msebera.android.httpclient.client.HttpClient
    public CloseableHttpResponse execute(HttpHost r1, HttpRequest r2, HttpContext r3) throws IOException, ClientProtocolException {
        return doExecute(r1, r2, r3);
    }

    @Override // cz.msebera.android.httpclient.client.HttpClient
    public CloseableHttpResponse execute(HttpUriRequest r2, HttpContext r3) throws IOException, ClientProtocolException {
        Args.notNull(r2, "HTTP request");
        return doExecute(determineTarget(r2), r2, r3);
    }

    private static HttpHost determineTarget(HttpUriRequest r3) throws ClientProtocolException {
        URI r4 = r3.getURI();
        if (r4.isAbsolute() == false) goto L9;
        HttpHost r0 = URIUtils.extractHost(r4);
        if (r0 == null) goto L8;
        return r0;
    L8:
        throw new ClientProtocolException("URI does not specify a valid host name: " + r4);
    L9:
        return null;
    }

    @Override // cz.msebera.android.httpclient.client.HttpClient
    public CloseableHttpResponse execute(HttpUriRequest r3) throws IOException, ClientProtocolException {
        HttpContext r1 = (HttpContext) null;
        return execute(r3, null);
    }

    @Override // cz.msebera.android.httpclient.client.HttpClient
    public CloseableHttpResponse execute(HttpHost r2, HttpRequest r3) throws IOException, ClientProtocolException {
        return doExecute(r2, r3, null);
    }

    @Override // cz.msebera.android.httpclient.client.HttpClient
    public <T> T execute(HttpUriRequest r2, ResponseHandler<? extends T> r3) throws IOException, ClientProtocolException {
        return (T) execute(r2, r3, null);
    }

    @Override // cz.msebera.android.httpclient.client.HttpClient
    public <T> T execute(HttpUriRequest r2, ResponseHandler<? extends T> r3, HttpContext r4) throws IOException, ClientProtocolException {
        return (T) execute(determineTarget(r2), r2, r3, r4);
    }

    @Override // cz.msebera.android.httpclient.client.HttpClient
    public <T> T execute(HttpHost r2, HttpRequest r3, ResponseHandler<? extends T> r4) throws IOException, ClientProtocolException {
        return (T) execute(r2, r3, r4, null);
    }

    @Override // cz.msebera.android.httpclient.client.HttpClient
    public <T> T execute(HttpHost r2, HttpRequest r3, ResponseHandler<? extends T> r4, HttpContext r5) throws IOException, ClientProtocolException {
        Args.notNull(r4, "Response handler");
        CloseableHttpResponse r6 = execute(r2, r3, r5);
        T r7 = r4.handleResponse(r6);     // Catch: Throwable -> L6 ClientProtocolException -> L8
        EntityUtils.consume(r6.getEntity());     // Catch: Throwable -> L6 ClientProtocolException -> L8
        r6.close();
        return r7;
    L8:
        e = move-exception;
        EntityUtils.consume(r6.getEntity());     // Catch: Throwable -> L6 Exception -> L12
    L14:
        throw e;     // Catch: Throwable -> L6
    L12:
        e = move-exception;
        this.log.warn("Error consuming content after an exception.", e);     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        r6.close();
        throw th;
    }
}
