package cz.msebera.android.httpclient.client.protocol;

import cz.msebera.android.httpclient.HttpEntity;
import cz.msebera.android.httpclient.HttpEntityEnclosingRequest;
import cz.msebera.android.httpclient.HttpException;
import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.HttpRequestInterceptor;
import cz.msebera.android.httpclient.HttpVersion;
import cz.msebera.android.httpclient.ProtocolVersion;
import cz.msebera.android.httpclient.protocol.HttpContext;
import cz.msebera.android.httpclient.util.Args;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public class RequestExpectContinue implements HttpRequestInterceptor {
    public RequestExpectContinue() {
    }

    @Override // cz.msebera.android.httpclient.HttpRequestInterceptor
    public void process(HttpRequest r6, HttpContext r7) throws HttpException, IOException {
        Args.notNull(r6, "HTTP request");
        if (r6.containsHeader("Expect") == false) goto L5;
        return;
    L5:
        if ((r6 instanceof HttpEntityEnclosingRequest) == false) goto L17;
        ProtocolVersion r0 = r6.getRequestLine().getProtocolVersion();
        HttpEntity r1 = ((HttpEntityEnclosingRequest) r6).getEntity();
        if (r1 != null) goto L9;
        return;
    L9:
        if (r1.getContentLength() != 0) goto L11;
        return;
    L11:
        if (r0.lessEquals(HttpVersion.HTTP_1_0) == false) goto L13;
        return;
    L13:
        if (HttpClientContext.adapt(r7).getRequestConfig().isExpectContinueEnabled() == false) goto L21;
        r6.addHeader("Expect", "100-continue");
        return;
    L21:
        return;
    }
}
