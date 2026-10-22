package cz.msebera.android.httpclient.protocol;

import cz.msebera.android.httpclient.HttpEntity;
import cz.msebera.android.httpclient.HttpEntityEnclosingRequest;
import cz.msebera.android.httpclient.HttpException;
import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.HttpRequestInterceptor;
import cz.msebera.android.httpclient.HttpVersion;
import cz.msebera.android.httpclient.ProtocolException;
import cz.msebera.android.httpclient.ProtocolVersion;
import cz.msebera.android.httpclient.util.Args;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public class RequestContent implements HttpRequestInterceptor {
    private final boolean overwrite;

    public RequestContent() {
        this(false);
    }

    public RequestContent(boolean r1) {
        this.overwrite = r1;
    }

    @Override // cz.msebera.android.httpclient.HttpRequestInterceptor
    public void process(HttpRequest r7, HttpContext r8) throws HttpException, IOException {
        Args.notNull(r7, "HTTP request");
        if ((r7 instanceof HttpEntityEnclosingRequest) == true) goto L5;
        return;
    L5:
        if (this.overwrite == false) goto L8;
        r7.removeHeaders("Transfer-Encoding");
        r7.removeHeaders("Content-Length");
    L11:
        ProtocolVersion r6 = r7.getRequestLine().getProtocolVersion();
        HttpEntity r1 = ((HttpEntityEnclosingRequest) r7).getEntity();
        if (r1 != null) goto L16;
        r7.addHeader("Content-Length", "0");
        return;
    L16:
        if (r1.isChunked() == true) goto L22;
        if (r1.getContentLength() < 0) goto L22;
        r7.addHeader("Content-Length", Long.toString(r1.getContentLength()));
    L25:
        if (r1.getContentType() == null) goto L30;
        if (r7.containsHeader("Content-Type") == true) goto L30;
        r7.addHeader(r1.getContentType());
    L30:
        if (r1.getContentEncoding() != null) goto L32;
        return;
    L32:
        if (r7.containsHeader("Content-Encoding") == true) goto L42;
        r7.addHeader(r1.getContentEncoding());
        return;
    L42:
        return;
    L22:
        if (r6.lessEquals(HttpVersion.HTTP_1_0) == true) goto L35;
        r7.addHeader("Transfer-Encoding", "chunked");
        goto L25
    L35:
        throw new ProtocolException("Chunked transfer encoding not allowed for " + r6);
    L8:
        if (r7.containsHeader("Transfer-Encoding") == true) goto L39;
        if (r7.containsHeader("Content-Length") == false) goto L11;
        throw new ProtocolException("Content-Length header already present");
    L39:
        throw new ProtocolException("Transfer-encoding header already present");
    }
}
