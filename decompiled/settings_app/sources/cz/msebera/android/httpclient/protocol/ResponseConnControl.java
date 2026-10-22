package cz.msebera.android.httpclient.protocol;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HttpEntity;
import cz.msebera.android.httpclient.HttpException;
import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.HttpResponseInterceptor;
import cz.msebera.android.httpclient.HttpVersion;
import cz.msebera.android.httpclient.ProtocolVersion;
import cz.msebera.android.httpclient.util.Args;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public class ResponseConnControl implements HttpResponseInterceptor {
    public ResponseConnControl() {
    }

    @Override // cz.msebera.android.httpclient.HttpResponseInterceptor
    public void process(HttpResponse r8, HttpContext r9) throws HttpException, IOException {
        Args.notNull(r8, "HTTP response");
        HttpCoreContext r7 = HttpCoreContext.adapt(r9);
        int r10 = r8.getStatusLine().getStatusCode();
        if (r10 != 400) goto L5;
    L41:
        r8.setHeader("Connection", "Close");
        return;
    L5:
        if (r10 == 408) goto L41;
        if (r10 == 411) goto L41;
        if (r10 == 413) goto L41;
        if (r10 == 414) goto L41;
        if (r10 == 503) goto L41;
        if (r10 == 501) goto L41;
        Header r11 = r8.getFirstHeader("Connection");
        if (r11 != null) goto L20;
    L22:
        HttpEntity r12 = r8.getEntity();
        if (r12 == null) goto L32;
        ProtocolVersion r0 = r8.getStatusLine().getProtocolVersion();
        if (r12.getContentLength() >= 0) goto L32;
        if (r12.isChunked() == true) goto L29;
    L30:
        r8.setHeader("Connection", "Close");
        return;
    L29:
        if (r0.lessEquals(HttpVersion.HTTP_1_0) == true) goto L30;
    L32:
        HttpRequest r13 = r7.getRequest();
        if (r13 == null) goto L43;
        Header r14 = r13.getFirstHeader("Connection");
        if (r14 == null) goto L38;
        r8.setHeader("Connection", r14.getValue());
        return;
    L38:
        if (r13.getProtocolVersion().lessEquals(HttpVersion.HTTP_1_0) == false) goto L45;
        r8.setHeader("Connection", "Close");
        return;
    L45:
        return;
    L43:
        return;
    L20:
        if ("Close".equalsIgnoreCase(r11.getValue()) == false) goto L22;
    }
}
