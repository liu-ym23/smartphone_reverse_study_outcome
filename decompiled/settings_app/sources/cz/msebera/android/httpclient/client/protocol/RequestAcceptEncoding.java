package cz.msebera.android.httpclient.client.protocol;

import cz.msebera.android.httpclient.HttpException;
import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.HttpRequestInterceptor;
import cz.msebera.android.httpclient.client.config.RequestConfig;
import cz.msebera.android.httpclient.protocol.HttpContext;
import java.io.IOException;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class RequestAcceptEncoding implements HttpRequestInterceptor {
    private final String acceptEncoding;

    public RequestAcceptEncoding(List<String> r4) {
        if (r4 != null) goto L5;
    L13:
        this.acceptEncoding = "gzip,deflate";
        return;
    L5:
        if (r4.isEmpty() == true) goto L13;
        StringBuilder r0 = new StringBuilder();
        int r1 = 0;
    L8:
        if (r1 >= r4.size()) goto L12;
        if (r1 <= 0) goto L11;
        r0.append(",");
    L11:
        r0.append(r4.get(r1));
        r1 = r1 + 1;
        goto L8
    L12:
        this.acceptEncoding = r0.toString();
    }

    public RequestAcceptEncoding() {
        this(null);
    }

    @Override // cz.msebera.android.httpclient.HttpRequestInterceptor
    public void process(HttpRequest r3, HttpContext r4) throws HttpException, IOException {
        RequestConfig r5 = HttpClientContext.adapt(r4).getRequestConfig();
        if (r3.containsHeader("Accept-Encoding") == false) goto L5;
        return;
    L5:
        if (r5.isContentCompressionEnabled() == false) goto L9;
        r3.addHeader("Accept-Encoding", this.acceptEncoding);
        return;
    }
}
