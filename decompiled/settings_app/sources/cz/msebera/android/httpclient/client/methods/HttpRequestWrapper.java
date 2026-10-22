package cz.msebera.android.httpclient.client.methods;

import com.android.settings.utils.HanziToPinyin;
import com.bytedance.librarian.LibrarianImpl;
import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HttpEntity;
import cz.msebera.android.httpclient.HttpEntityEnclosingRequest;
import cz.msebera.android.httpclient.HttpHost;
import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.ProtocolVersion;
import cz.msebera.android.httpclient.RequestLine;
import cz.msebera.android.httpclient.message.AbstractHttpMessage;
import cz.msebera.android.httpclient.message.BasicRequestLine;
import cz.msebera.android.httpclient.params.HttpParams;
import cz.msebera.android.httpclient.util.Args;
import java.net.URI;

/* JADX INFO: loaded from: classes5.dex */
public class HttpRequestWrapper extends AbstractHttpMessage implements HttpUriRequest {
    private final String method;
    private final HttpRequest original;
    private RequestLine requestLine;
    private final HttpHost target;
    private URI uri;
    private ProtocolVersion version;

    /* JADX INFO: renamed from: cz.msebera.android.httpclient.client.methods.HttpRequestWrapper$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    static class HttpEntityEnclosingRequestWrapper extends HttpRequestWrapper implements HttpEntityEnclosingRequest {
        private HttpEntity entity;

        HttpEntityEnclosingRequestWrapper(HttpEntityEnclosingRequest r2, HttpHost r3) {
            super(r2, r3, null);
            this.entity = r2.getEntity();
        }

        @Override // cz.msebera.android.httpclient.HttpEntityEnclosingRequest
        public HttpEntity getEntity() {
            return this.entity;
        }

        @Override // cz.msebera.android.httpclient.HttpEntityEnclosingRequest
        public void setEntity(HttpEntity r1) {
            this.entity = r1;
        }

        @Override // cz.msebera.android.httpclient.HttpEntityEnclosingRequest
        public boolean expectContinue() {
            Header r1 = getFirstHeader("Expect");
            if (r1 != null) goto L5;
        L7:
            return false;
        L5:
            if ("100-continue".equalsIgnoreCase(r1.getValue()) == false) goto L7;
            return true;
        }
    }

    @Override // cz.msebera.android.httpclient.client.methods.HttpUriRequest
    public boolean isAborted() {
        return false;
    }

    /* synthetic */ HttpRequestWrapper(HttpRequest r1, HttpHost r2, AnonymousClass1 r3) {
        this(r1, r2);
    }

    private HttpRequestWrapper(HttpRequest r2, HttpHost r3) {
        HttpRequest r0 = (HttpRequest) Args.notNull(r2, "HTTP request");
        this.original = r0;
        this.target = r3;
        this.version = r0.getRequestLine().getProtocolVersion();
        this.method = r0.getRequestLine().getMethod();
        if ((r2 instanceof HttpUriRequest) == false) goto L5;
        this.uri = ((HttpUriRequest) r2).getURI();
    L6:
        setHeaders(r2.getAllHeaders());
        return;
    L5:
        this.uri = null;
        goto L6
    }

    @Override // cz.msebera.android.httpclient.HttpMessage
    public ProtocolVersion getProtocolVersion() {
        ProtocolVersion r0 = this.version;
        if (r0 == null) goto L6;
        return r0;
    L6:
        return this.original.getProtocolVersion();
    }

    public void setProtocolVersion(ProtocolVersion r1) {
        this.version = r1;
        this.requestLine = null;
    }

    @Override // cz.msebera.android.httpclient.client.methods.HttpUriRequest
    public URI getURI() {
        return this.uri;
    }

    public void setURI(URI r1) {
        this.uri = r1;
        this.requestLine = null;
    }

    @Override // cz.msebera.android.httpclient.client.methods.HttpUriRequest
    public String getMethod() {
        return this.method;
    }

    @Override // cz.msebera.android.httpclient.client.methods.HttpUriRequest
    public void abort() throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }

    @Override // cz.msebera.android.httpclient.HttpRequest
    public RequestLine getRequestLine() {
        if (this.requestLine != null) goto L14;
        URI r0 = this.uri;
        if (r0 == null) goto L7;
        String r1 = r0.toASCIIString();
    L8:
        if (r1 != null) goto L10;
    L11:
        r1 = LibrarianImpl.Constants.SEPARATOR;
    L12:
        this.requestLine = new BasicRequestLine(this.method, r1, getProtocolVersion());
        goto L14
    L10:
        if (r1.isEmpty() == false) goto L12;
    L7:
        r1 = this.original.getRequestLine().getUri();
    L14:
        return this.requestLine;
    }

    public HttpRequest getOriginal() {
        return this.original;
    }

    public HttpHost getTarget() {
        return this.target;
    }

    public String toString() {
        return getRequestLine() + HanziToPinyin.Token.SEPARATOR + this.headergroup;
    }

    public static HttpRequestWrapper wrap(HttpRequest r1) {
        return wrap(r1, null);
    }

    public static HttpRequestWrapper wrap(HttpRequest r1, HttpHost r2) {
        Args.notNull(r1, "HTTP request");
        if ((r1 instanceof HttpEntityEnclosingRequest) == false) goto L6;
        return new HttpEntityEnclosingRequestWrapper((HttpEntityEnclosingRequest) r1, r2);
    L6:
        return new HttpRequestWrapper(r1, r2);
    }

    @Override // cz.msebera.android.httpclient.message.AbstractHttpMessage, cz.msebera.android.httpclient.HttpMessage
    @Deprecated
    public HttpParams getParams() {
        if (this.params != null) goto L6;
        this.params = this.original.getParams().copy();
    L6:
        return this.params;
    }
}
