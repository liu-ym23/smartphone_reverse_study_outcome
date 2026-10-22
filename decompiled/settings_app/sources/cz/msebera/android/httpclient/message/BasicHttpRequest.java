package cz.msebera.android.httpclient.message;

import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.HttpVersion;
import cz.msebera.android.httpclient.ProtocolVersion;
import cz.msebera.android.httpclient.RequestLine;
import cz.msebera.android.httpclient.util.Args;

/* JADX INFO: loaded from: classes5.dex */
public class BasicHttpRequest extends AbstractHttpMessage implements HttpRequest {
    private final String method;
    private RequestLine requestline;
    private final String uri;

    public BasicHttpRequest(String r2, String r3) {
        this.method = (String) Args.notNull(r2, "Method name");
        this.uri = (String) Args.notNull(r3, "Request URI");
        this.requestline = null;
    }

    public BasicHttpRequest(String r2, String r3, ProtocolVersion r4) {
        this(new BasicRequestLine(r2, r3, r4));
    }

    public BasicHttpRequest(RequestLine r2) {
        this.requestline = (RequestLine) Args.notNull(r2, "Request line");
        this.method = r2.getMethod();
        this.uri = r2.getUri();
    }

    @Override // cz.msebera.android.httpclient.HttpMessage
    public ProtocolVersion getProtocolVersion() {
        return getRequestLine().getProtocolVersion();
    }

    @Override // cz.msebera.android.httpclient.HttpRequest
    public RequestLine getRequestLine() {
        if (this.requestline != null) goto L6;
        this.requestline = new BasicRequestLine(this.method, this.uri, HttpVersion.HTTP_1_1);
    L6:
        return this.requestline;
    }

    public String toString() {
        return this.method + TokenParser.SP + this.uri + TokenParser.SP + this.headergroup;
    }
}
