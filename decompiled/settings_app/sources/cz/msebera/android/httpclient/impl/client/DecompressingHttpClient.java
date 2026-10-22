package cz.msebera.android.httpclient.impl.client;

import cz.msebera.android.httpclient.HttpEntity;
import cz.msebera.android.httpclient.HttpEntityEnclosingRequest;
import cz.msebera.android.httpclient.HttpException;
import cz.msebera.android.httpclient.HttpHost;
import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.HttpRequestInterceptor;
import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.HttpResponseInterceptor;
import cz.msebera.android.httpclient.client.ClientProtocolException;
import cz.msebera.android.httpclient.client.HttpClient;
import cz.msebera.android.httpclient.client.ResponseHandler;
import cz.msebera.android.httpclient.client.methods.HttpUriRequest;
import cz.msebera.android.httpclient.client.protocol.RequestAcceptEncoding;
import cz.msebera.android.httpclient.client.protocol.ResponseContentEncoding;
import cz.msebera.android.httpclient.client.utils.URIUtils;
import cz.msebera.android.httpclient.conn.ClientConnectionManager;
import cz.msebera.android.httpclient.params.HttpParams;
import cz.msebera.android.httpclient.protocol.BasicHttpContext;
import cz.msebera.android.httpclient.protocol.HttpContext;
import cz.msebera.android.httpclient.util.EntityUtils;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
@Deprecated
public class DecompressingHttpClient implements HttpClient {
    private final HttpRequestInterceptor acceptEncodingInterceptor;
    private final HttpClient backend;
    private final HttpResponseInterceptor contentEncodingInterceptor;

    public DecompressingHttpClient() {
        this(new DefaultHttpClient());
    }

    public DecompressingHttpClient(HttpClient r3) {
        this(r3, new RequestAcceptEncoding(), new ResponseContentEncoding());
    }

    DecompressingHttpClient(HttpClient r1, HttpRequestInterceptor r2, HttpResponseInterceptor r3) {
        this.backend = r1;
        this.acceptEncodingInterceptor = r2;
        this.contentEncodingInterceptor = r3;
    }

    @Override // cz.msebera.android.httpclient.client.HttpClient
    public HttpParams getParams() {
        return this.backend.getParams();
    }

    @Override // cz.msebera.android.httpclient.client.HttpClient
    public ClientConnectionManager getConnectionManager() {
        return this.backend.getConnectionManager();
    }

    @Override // cz.msebera.android.httpclient.client.HttpClient
    public HttpResponse execute(HttpUriRequest r4) throws IOException, ClientProtocolException {
        HttpContext r2 = (HttpContext) null;
        return execute(getHttpHost(r4), r4, null);
    }

    public HttpClient getHttpClient() {
        return this.backend;
    }

    HttpHost getHttpHost(HttpUriRequest r1) {
        return URIUtils.extractHost(r1.getURI());
    }

    @Override // cz.msebera.android.httpclient.client.HttpClient
    public HttpResponse execute(HttpUriRequest r2, HttpContext r3) throws IOException, ClientProtocolException {
        return execute(getHttpHost(r2), r2, r3);
    }

    @Override // cz.msebera.android.httpclient.client.HttpClient
    public HttpResponse execute(HttpHost r3, HttpRequest r4) throws IOException, ClientProtocolException {
        HttpContext r1 = (HttpContext) null;
        return execute(r3, r4, null);
    }

    @Override // cz.msebera.android.httpclient.client.HttpClient
    public HttpResponse execute(HttpHost r2, HttpRequest r3, HttpContext r4) throws IOException, ClientProtocolException {
        if (r4 != null) goto L6;
        r4 = new BasicHttpContext();     // Catch: HttpException -> L23
    L23:
        e = move-exception;
        throw new ClientProtocolException(e);
    L6:
        if ((r3 instanceof HttpEntityEnclosingRequest) == false) goto L8;
        HttpRequest r0 = new EntityEnclosingRequestWrapper((HttpEntityEnclosingRequest) r3);     // Catch: HttpException -> L23
    L9:
        this.acceptEncodingInterceptor.process(r0, r4);     // Catch: HttpException -> L23
        HttpResponse r5 = this.backend.execute(r2, r0, r4);     // Catch: HttpException -> L23
        this.contentEncodingInterceptor.process(r5, r4);     // Catch: RuntimeException -> L14 IOException -> L17 HttpException -> L20
        if (Boolean.TRUE.equals(r4.getAttribute(ResponseContentEncoding.UNCOMPRESSED)) == false) goto L13;
        r5.removeHeaders("Content-Length");     // Catch: RuntimeException -> L14 IOException -> L17 HttpException -> L20
        r5.removeHeaders("Content-Encoding");     // Catch: RuntimeException -> L14 IOException -> L17 HttpException -> L20
        r5.removeHeaders("Content-MD5");     // Catch: RuntimeException -> L14 IOException -> L17 HttpException -> L20
    L13:
        return r5;
    L20:
        e = move-exception;
        EntityUtils.consume(r5.getEntity());     // Catch: HttpException -> L23
        throw e;     // Catch: HttpException -> L23
    L17:
        e = move-exception;
        EntityUtils.consume(r5.getEntity());     // Catch: HttpException -> L23
        throw e;     // Catch: HttpException -> L23
    L14:
        e = move-exception;
        EntityUtils.consume(r5.getEntity());     // Catch: HttpException -> L23
        throw e;     // Catch: HttpException -> L23
    L8:
        r0 = new RequestWrapper(r3);     // Catch: HttpException -> L23
        goto L9
    }

    @Override // cz.msebera.android.httpclient.client.HttpClient
    public <T> T execute(HttpUriRequest r2, ResponseHandler<? extends T> r3) throws IOException, ClientProtocolException {
        return (T) execute(getHttpHost(r2), r2, r3);
    }

    @Override // cz.msebera.android.httpclient.client.HttpClient
    public <T> T execute(HttpUriRequest r2, ResponseHandler<? extends T> r3, HttpContext r4) throws IOException, ClientProtocolException {
        return (T) execute(getHttpHost(r2), r2, r3, r4);
    }

    @Override // cz.msebera.android.httpclient.client.HttpClient
    public <T> T execute(HttpHost r2, HttpRequest r3, ResponseHandler<? extends T> r4) throws IOException, ClientProtocolException {
        return (T) execute(r2, r3, r4, null);
    }

    @Override // cz.msebera.android.httpclient.client.HttpClient
    public <T> T execute(HttpHost r1, HttpRequest r2, ResponseHandler<? extends T> r3, HttpContext r4) throws IOException, ClientProtocolException {
        HttpResponse r0 = execute(r1, r2, r4);
        T r5 = r3.handleResponse(r0);     // Catch: Throwable -> L8
        HttpEntity r6 = r0.getEntity();
        if (r6 == null) goto L7;
        EntityUtils.consume(r6);
    L7:
        return r5;
    L8:
        th = move-exception;
        HttpEntity r7 = r0.getEntity();
        if (r7 == null) goto L12;
        EntityUtils.consume(r7);
    L12:
        throw th;
    }
}
