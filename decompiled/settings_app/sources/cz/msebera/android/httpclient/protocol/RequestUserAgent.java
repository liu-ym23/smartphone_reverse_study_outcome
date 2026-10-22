package cz.msebera.android.httpclient.protocol;

import cz.msebera.android.httpclient.HttpException;
import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.HttpRequestInterceptor;
import cz.msebera.android.httpclient.params.HttpParams;
import cz.msebera.android.httpclient.util.Args;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public class RequestUserAgent implements HttpRequestInterceptor {
    private final String userAgent;

    public RequestUserAgent(String r1) {
        this.userAgent = r1;
    }

    public RequestUserAgent() {
        this(null);
    }

    @Override // cz.msebera.android.httpclient.HttpRequestInterceptor
    public void process(HttpRequest r3, HttpContext r4) throws HttpException, IOException {
        Args.notNull(r3, "HTTP request");
        if (r3.containsHeader("User-Agent") == true) goto L13;
        HttpParams r0 = r3.getParams();
        if (r0 == null) goto L7;
        String r1 = (String) r0.getParameter("http.useragent");
    L8:
        if (r1 != null) goto L10;
        r1 = this.userAgent;
    L10:
        if (r1 == null) goto L14;
        r3.addHeader("User-Agent", r1);
        return;
    L14:
        return;
    L7:
        r1 = null;
        goto L8
    }
}
