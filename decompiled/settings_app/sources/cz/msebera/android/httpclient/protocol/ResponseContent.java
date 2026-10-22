package cz.msebera.android.httpclient.protocol;

import cz.msebera.android.httpclient.HttpEntity;
import cz.msebera.android.httpclient.HttpException;
import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.HttpResponseInterceptor;
import cz.msebera.android.httpclient.HttpVersion;
import cz.msebera.android.httpclient.ProtocolException;
import cz.msebera.android.httpclient.ProtocolVersion;
import cz.msebera.android.httpclient.util.Args;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public class ResponseContent implements HttpResponseInterceptor {
    private final boolean overwrite;

    public ResponseContent() {
        this(false);
    }

    public ResponseContent(boolean r1) {
        this.overwrite = r1;
    }

    @Override // cz.msebera.android.httpclient.HttpResponseInterceptor
    public void process(HttpResponse r7, HttpContext r8) throws HttpException, IOException {
        Args.notNull(r7, "HTTP response");
        if (this.overwrite == false) goto L6;
        r7.removeHeaders("Transfer-Encoding");
        r7.removeHeaders("Content-Length");
    L9:
        ProtocolVersion r6 = r7.getStatusLine().getProtocolVersion();
        HttpEntity r1 = r7.getEntity();
        if (r1 == null) goto L29;
        long r2 = r1.getContentLength();
        if (r1.isChunked() == false) goto L17;
        if (r6.lessEquals(HttpVersion.HTTP_1_0) == true) goto L17;
        r7.addHeader("Transfer-Encoding", "chunked");
    L20:
        if (r1.getContentType() == null) goto L25;
        if (r7.containsHeader("Content-Type") == true) goto L25;
        r7.addHeader(r1.getContentType());
    L25:
        if (r1.getContentEncoding() != null) goto L27;
        return;
    L27:
        if (r7.containsHeader("Content-Encoding") == true) goto L42;
        r7.addHeader(r1.getContentEncoding());
        return;
    L42:
        return;
    L17:
        if (r2 < 0) goto L20;
        r7.addHeader("Content-Length", Long.toString(r1.getContentLength()));
        goto L20
    L29:
        int r9 = r7.getStatusLine().getStatusCode();
        if (r9 != 204) goto L32;
        return;
    L32:
        if (r9 != 304) goto L34;
        return;
    L34:
        if (r9 == 205) goto L46;
        r7.addHeader("Content-Length", "0");
        return;
    L46:
        return;
    L6:
        if (r7.containsHeader("Transfer-Encoding") == true) goto L40;
        if (r7.containsHeader("Content-Length") == false) goto L9;
        throw new ProtocolException("Content-Length header already present");
    L40:
        throw new ProtocolException("Transfer-encoding header already present");
    }
}
