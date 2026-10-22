package cz.msebera.android.httpclient.protocol;

import cz.msebera.android.httpclient.HttpException;
import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.HttpRequestInterceptor;
import cz.msebera.android.httpclient.util.Args;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public class RequestConnControl implements HttpRequestInterceptor {
    public RequestConnControl() {
    }

    @Override // cz.msebera.android.httpclient.HttpRequestInterceptor
    public void process(HttpRequest r1, HttpContext r2) throws HttpException, IOException {
        Args.notNull(r1, "HTTP request");
        if (r1.getRequestLine().getMethod().equalsIgnoreCase("CONNECT") == false) goto L6;
        return;
    L6:
        if (r1.containsHeader("Connection") == true) goto L9;
        r1.addHeader("Connection", "Keep-Alive");
        return;
    }
}
