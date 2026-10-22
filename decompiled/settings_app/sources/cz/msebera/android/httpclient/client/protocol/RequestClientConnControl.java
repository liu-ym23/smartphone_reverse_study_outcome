package cz.msebera.android.httpclient.client.protocol;

import cz.msebera.android.httpclient.HttpException;
import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.HttpRequestInterceptor;
import cz.msebera.android.httpclient.conn.routing.RouteInfo;
import cz.msebera.android.httpclient.extras.HttpClientAndroidLog;
import cz.msebera.android.httpclient.protocol.HttpContext;
import cz.msebera.android.httpclient.util.Args;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public class RequestClientConnControl implements HttpRequestInterceptor {
    private static final String PROXY_CONN_DIRECTIVE = "Proxy-Connection";
    public HttpClientAndroidLog log;

    public RequestClientConnControl() {
        this.log = new HttpClientAndroidLog(getClass());
    }

    @Override // cz.msebera.android.httpclient.HttpRequestInterceptor
    public void process(HttpRequest r4, HttpContext r5) throws HttpException, IOException {
        Args.notNull(r4, "HTTP request");
        if (r4.getRequestLine().getMethod().equalsIgnoreCase("CONNECT") == false) goto L6;
        r4.setHeader(PROXY_CONN_DIRECTIVE, "Keep-Alive");
        return;
    L6:
        RouteInfo r6 = HttpClientContext.adapt(r5).getHttpRoute();
        if (r6 != null) goto L11;
        this.log.debug("Connection route not set in the context");
        return;
    L11:
        if (r6.getHopCount() == 1) goto L15;
        if (r6.isTunnelled() == true) goto L15;
    L18:
        if (r6.getHopCount() == 2) goto L20;
        return;
    L20:
        if (r6.isTunnelled() == false) goto L22;
        return;
    L22:
        if (r4.containsHeader(PROXY_CONN_DIRECTIVE) == true) goto L27;
        r4.addHeader(PROXY_CONN_DIRECTIVE, "Keep-Alive");
        return;
    L27:
        return;
    L15:
        if (r4.containsHeader("Connection") == true) goto L18;
        r4.addHeader("Connection", "Keep-Alive");
        goto L18
    }
}
