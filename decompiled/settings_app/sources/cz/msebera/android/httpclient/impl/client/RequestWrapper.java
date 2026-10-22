package cz.msebera.android.httpclient.impl.client;

import com.bytedance.librarian.LibrarianImpl;
import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.ProtocolException;
import cz.msebera.android.httpclient.ProtocolVersion;
import cz.msebera.android.httpclient.RequestLine;
import cz.msebera.android.httpclient.client.methods.HttpUriRequest;
import cz.msebera.android.httpclient.message.AbstractHttpMessage;
import cz.msebera.android.httpclient.message.BasicRequestLine;
import cz.msebera.android.httpclient.params.HttpProtocolParams;
import cz.msebera.android.httpclient.util.Args;
import java.net.URI;
import java.net.URISyntaxException;

/* JADX INFO: loaded from: classes5.dex */
@Deprecated
public class RequestWrapper extends AbstractHttpMessage implements HttpUriRequest {
    private int execCount;
    private String method;
    private final HttpRequest original;
    private URI uri;
    private ProtocolVersion version;

    @Override // cz.msebera.android.httpclient.client.methods.HttpUriRequest
    public boolean isAborted() {
        return false;
    }

    public boolean isRepeatable() {
        return true;
    }

    public RequestWrapper(HttpRequest r4) throws ProtocolException {
        Args.notNull(r4, "HTTP request");
        this.original = r4;
        setParams(r4.getParams());
        setHeaders(r4.getAllHeaders());
        if ((r4 instanceof HttpUriRequest) == false) goto L5;
        HttpUriRequest r5 = (HttpUriRequest) r4;
        this.uri = r5.getURI();
        this.method = r5.getMethod();
        this.version = null;
    L8:
        this.execCount = 0;
        return;
    L5:
        RequestLine r0 = r4.getRequestLine();
        this.uri = new URI(r0.getUri());     // Catch: URISyntaxException -> L10
        this.method = r0.getMethod();
        this.version = r4.getProtocolVersion();
    L10:
        e = move-exception;
        throw new ProtocolException("Invalid request URI: " + r0.getUri(), e);
    }

    public void resetHeaders() {
        this.headergroup.clear();
        setHeaders(this.original.getAllHeaders());
    }

    @Override // cz.msebera.android.httpclient.client.methods.HttpUriRequest
    public String getMethod() {
        return this.method;
    }

    public void setMethod(String r2) {
        Args.notNull(r2, "Method name");
        this.method = r2;
    }

    @Override // cz.msebera.android.httpclient.HttpMessage
    public ProtocolVersion getProtocolVersion() {
        if (this.version != null) goto L6;
        this.version = HttpProtocolParams.getVersion(getParams());
    L6:
        return this.version;
    }

    public void setProtocolVersion(ProtocolVersion r1) {
        this.version = r1;
    }

    @Override // cz.msebera.android.httpclient.client.methods.HttpUriRequest
    public URI getURI() {
        return this.uri;
    }

    public void setURI(URI r1) {
        this.uri = r1;
    }

    @Override // cz.msebera.android.httpclient.HttpRequest
    public RequestLine getRequestLine() {
        ProtocolVersion r0 = getProtocolVersion();
        URI r1 = this.uri;
        if (r1 == null) goto L5;
        String r2 = r1.toASCIIString();
    L6:
        if (r2 != null) goto L8;
    L9:
        r2 = LibrarianImpl.Constants.SEPARATOR;
    L11:
        return new BasicRequestLine(getMethod(), r2, r0);
    L8:
        if (r2.isEmpty() == false) goto L11;
    L5:
        r2 = null;
        goto L6
    }

    @Override // cz.msebera.android.httpclient.client.methods.HttpUriRequest
    public void abort() throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }

    public HttpRequest getOriginal() {
        return this.original;
    }

    public int getExecCount() {
        return this.execCount;
    }

    public void incrementExecCount() {
        this.execCount++;
    }
}
