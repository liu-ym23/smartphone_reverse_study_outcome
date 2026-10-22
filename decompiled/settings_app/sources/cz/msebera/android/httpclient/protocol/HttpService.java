package cz.msebera.android.httpclient.protocol;

import cz.msebera.android.httpclient.ConnectionReuseStrategy;
import cz.msebera.android.httpclient.HttpEntityEnclosingRequest;
import cz.msebera.android.httpclient.HttpException;
import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.HttpResponseFactory;
import cz.msebera.android.httpclient.HttpServerConnection;
import cz.msebera.android.httpclient.HttpVersion;
import cz.msebera.android.httpclient.MethodNotSupportedException;
import cz.msebera.android.httpclient.ProtocolException;
import cz.msebera.android.httpclient.UnsupportedHttpVersionException;
import cz.msebera.android.httpclient.entity.ByteArrayEntity;
import cz.msebera.android.httpclient.impl.DefaultConnectionReuseStrategy;
import cz.msebera.android.httpclient.impl.DefaultHttpResponseFactory;
import cz.msebera.android.httpclient.params.HttpParams;
import cz.msebera.android.httpclient.util.Args;
import cz.msebera.android.httpclient.util.EncodingUtils;
import cz.msebera.android.httpclient.util.EntityUtils;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public class HttpService {
    private volatile ConnectionReuseStrategy connStrategy;
    private volatile HttpExpectationVerifier expectationVerifier;
    private volatile HttpRequestHandlerMapper handlerMapper;
    private volatile HttpParams params;
    private volatile HttpProcessor processor;
    private volatile HttpResponseFactory responseFactory;

    @Deprecated
    private static class HttpRequestHandlerResolverAdapter implements HttpRequestHandlerMapper {
        private final HttpRequestHandlerResolver resolver;

        public HttpRequestHandlerResolverAdapter(HttpRequestHandlerResolver r1) {
            this.resolver = r1;
        }

        @Override // cz.msebera.android.httpclient.protocol.HttpRequestHandlerMapper
        public HttpRequestHandler lookup(HttpRequest r1) {
            return this.resolver.lookup(r1.getRequestLine().getUri());
        }
    }

    @Deprecated
    public HttpService(HttpProcessor r7, ConnectionReuseStrategy r8, HttpResponseFactory r9, HttpRequestHandlerResolver r10, HttpExpectationVerifier r11, HttpParams r12) {
        this(r7, r8, r9, new HttpRequestHandlerResolverAdapter(r10), r11);
        this.params = r12;
    }

    @Deprecated
    public HttpService(HttpProcessor r7, ConnectionReuseStrategy r8, HttpResponseFactory r9, HttpRequestHandlerResolver r10, HttpParams r11) {
        this(r7, r8, r9, new HttpRequestHandlerResolverAdapter(r10), null);
        this.params = r11;
    }

    @Deprecated
    public HttpService(HttpProcessor r2, ConnectionReuseStrategy r3, HttpResponseFactory r4) {
        this.params = null;
        this.processor = null;
        this.handlerMapper = null;
        this.connStrategy = null;
        this.responseFactory = null;
        this.expectationVerifier = null;
        setHttpProcessor(r2);
        setConnReuseStrategy(r3);
        setResponseFactory(r4);
    }

    public HttpService(HttpProcessor r2, ConnectionReuseStrategy r3, HttpResponseFactory r4, HttpRequestHandlerMapper r5, HttpExpectationVerifier r6) {
        this.params = null;
        this.processor = null;
        this.handlerMapper = null;
        this.connStrategy = null;
        this.responseFactory = null;
        this.expectationVerifier = null;
        this.processor = (HttpProcessor) Args.notNull(r2, "HTTP processor");
        if (r3 != null) goto L6;
        r3 = DefaultConnectionReuseStrategy.INSTANCE;
    L6:
        this.connStrategy = r3;
        if (r4 != null) goto L10;
        r4 = DefaultHttpResponseFactory.INSTANCE;
    L10:
        this.responseFactory = r4;
        this.handlerMapper = r5;
        this.expectationVerifier = r6;
    }

    public HttpService(HttpProcessor r7, ConnectionReuseStrategy r8, HttpResponseFactory r9, HttpRequestHandlerMapper r10) {
        this(r7, r8, r9, r10, null);
    }

    public HttpService(HttpProcessor r7, HttpRequestHandlerMapper r8) {
        this(r7, null, null, r8, null);
    }

    @Deprecated
    public void setHttpProcessor(HttpProcessor r2) {
        Args.notNull(r2, "HTTP processor");
        this.processor = r2;
    }

    @Deprecated
    public void setConnReuseStrategy(ConnectionReuseStrategy r2) {
        Args.notNull(r2, "Connection reuse strategy");
        this.connStrategy = r2;
    }

    @Deprecated
    public void setResponseFactory(HttpResponseFactory r2) {
        Args.notNull(r2, "Response factory");
        this.responseFactory = r2;
    }

    @Deprecated
    public void setParams(HttpParams r1) {
        this.params = r1;
    }

    @Deprecated
    public void setHandlerResolver(HttpRequestHandlerResolver r2) {
        this.handlerMapper = new HttpRequestHandlerResolverAdapter(r2);
    }

    @Deprecated
    public void setExpectationVerifier(HttpExpectationVerifier r1) {
        this.expectationVerifier = r1;
    }

    @Deprecated
    public HttpParams getParams() {
        return this.params;
    }

    public void handleRequest(HttpServerConnection r9, HttpContext r10) throws IOException, HttpException {
        r10.setAttribute("http.connection", r9);
        HttpResponse r1 = null;
        HttpRequest r2 = r9.receiveRequestHeader();     // Catch: HttpException -> L28
    L26:
        HttpException e = e;
    L30:
        HttpResponse r0 = this.responseFactory.newHttpResponse(HttpVersion.HTTP_1_0, 500, r10);
        handleException(e, r0);
        r1 = r0;
    L31:
        r10.setAttribute("http.response", r1);
        this.processor.process(r1, r10);
        r9.sendResponseHeader(r1);
        if (canResponseHaveBody(r2, r1) == false) goto L34;
        r9.sendResponseEntity(r1);
    L34:
        r9.flush();
        if (this.connStrategy.keepAlive(r1, r10) == true) goto L44;
        r9.close();
        return;
    L44:
        return;
    L5:
        if ((r2 instanceof HttpEntityEnclosingRequest) == true) goto L7;
    L19:
        r10.setAttribute("http.request", r2);     // Catch: HttpException -> L26
        if (r1 != null) goto L23;
        r1 = this.responseFactory.newHttpResponse(HttpVersion.HTTP_1_1, 200, r10);     // Catch: HttpException -> L26
        this.processor.process(r2, r10);     // Catch: HttpException -> L26
        doService(r2, r1, r10);     // Catch: HttpException -> L26
    L23:
        if ((r2 instanceof HttpEntityEnclosingRequest) == false) goto L31;
        EntityUtils.consume(((HttpEntityEnclosingRequest) r2).getEntity());     // Catch: HttpException -> L26
        goto L31
    L7:
        if (((HttpEntityEnclosingRequest) r2).expectContinue() == false) goto L18;
        HttpResponse r3 = this.responseFactory.newHttpResponse(HttpVersion.HTTP_1_1, 100, r10);     // Catch: HttpException -> L26
        if (this.expectationVerifier == null) goto L15;
        this.expectationVerifier.verify(r2, r3, r10);     // Catch: HttpException -> L12
    L12:
        e = move-exception;
        HttpResponse r5 = this.responseFactory.newHttpResponse(HttpVersion.HTTP_1_0, 500, r10);     // Catch: HttpException -> L26
        handleException(e, r5);     // Catch: HttpException -> L26
        r3 = r5;
    L15:
        if (r3.getStatusLine().getStatusCode() >= 200) goto L17;
        r9.sendResponseHeader(r3);     // Catch: HttpException -> L26
        r9.flush();     // Catch: HttpException -> L26
        r9.receiveRequestEntity((HttpEntityEnclosingRequest) r2);     // Catch: HttpException -> L26
        goto L19
    L17:
        r1 = r3;
        goto L19
    L18:
        r9.receiveRequestEntity((HttpEntityEnclosingRequest) r2);     // Catch: HttpException -> L26
    L28:
        e = move-exception;
        r2 = null;
        e = e;
        goto L30
    }

    private boolean canResponseHaveBody(HttpRequest r2, HttpResponse r3) {
        if (r2 != null) goto L5;
    L7:
        int r4 = r3.getStatusLine().getStatusCode();
        if (r4 >= 200) goto L10;
        return false;
    L10:
        if (r4 != 204) goto L12;
        return false;
    L12:
        if (r4 != 304) goto L14;
        return false;
    L14:
        if (r4 == 205) goto L20;
        return true;
    L20:
        return false;
    L5:
        if ("HEAD".equalsIgnoreCase(r2.getRequestLine().getMethod()) == false) goto L7;
        return false;
    }

    protected void handleException(HttpException r1, HttpResponse r2) {
        if ((r1 instanceof MethodNotSupportedException) == false) goto L6;
        r2.setStatusCode(501);
    L12:
        String r0 = r1.getMessage();
        if (r0 != null) goto L15;
        r0 = r1.toString();
    L15:
        ByteArrayEntity r3 = new ByteArrayEntity(EncodingUtils.getAsciiBytes(r0));
        r3.setContentType("text/plain; charset=US-ASCII");
        r2.setEntity(r3);
        return;
    L6:
        if ((r1 instanceof UnsupportedHttpVersionException) == false) goto L9;
        r2.setStatusCode(505);
        goto L12
    L9:
        if ((r1 instanceof ProtocolException) == false) goto L11;
        r2.setStatusCode(400);
        goto L12
    L11:
        r2.setStatusCode(500);
        goto L12
    }

    protected void doService(HttpRequest r2, HttpResponse r3, HttpContext r4) throws HttpException, IOException {
        if (this.handlerMapper == null) goto L5;
        HttpRequestHandler r1 = this.handlerMapper.lookup(r2);
    L6:
        if (r1 == null) goto L8;
        r1.handle(r2, r3, r4);
        return;
    L8:
        r3.setStatusCode(501);
        return;
    L5:
        r1 = null;
        goto L6
    }
}
