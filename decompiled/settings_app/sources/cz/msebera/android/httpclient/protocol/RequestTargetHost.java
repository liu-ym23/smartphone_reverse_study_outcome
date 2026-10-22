package cz.msebera.android.httpclient.protocol;

import cz.msebera.android.httpclient.HttpConnection;
import cz.msebera.android.httpclient.HttpException;
import cz.msebera.android.httpclient.HttpHost;
import cz.msebera.android.httpclient.HttpInetConnection;
import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.HttpRequestInterceptor;
import cz.msebera.android.httpclient.HttpVersion;
import cz.msebera.android.httpclient.ProtocolException;
import cz.msebera.android.httpclient.ProtocolVersion;
import cz.msebera.android.httpclient.util.Args;
import java.io.IOException;
import java.net.InetAddress;

/* JADX INFO: loaded from: classes5.dex */
public class RequestTargetHost implements HttpRequestInterceptor {
    public RequestTargetHost() {
    }

    @Override // cz.msebera.android.httpclient.HttpRequestInterceptor
    public void process(HttpRequest r4, HttpContext r5) throws HttpException, IOException {
        Args.notNull(r4, "HTTP request");
        HttpCoreContext r3 = HttpCoreContext.adapt(r5);
        ProtocolVersion r6 = r4.getRequestLine().getProtocolVersion();
        if (r4.getRequestLine().getMethod().equalsIgnoreCase("CONNECT") == false) goto L8;
        if (r6.lessEquals(HttpVersion.HTTP_1_0) == false) goto L8;
        return;
    L8:
        if (r4.containsHeader("Host") == true) goto L24;
        HttpHost r1 = r3.getTargetHost();
        if (r1 != null) goto L22;
        HttpConnection r7 = r3.getConnection();
        if ((r7 instanceof HttpInetConnection) == false) goto L16;
        HttpInetConnection r8 = (HttpInetConnection) r7;
        InetAddress r2 = r8.getRemoteAddress();
        int r9 = r8.getRemotePort();
        if (r2 == null) goto L16;
        r1 = new HttpHost(r2.getHostName(), r9);
    L16:
        if (r1 != null) goto L22;
        if (r6.lessEquals(HttpVersion.HTTP_1_0) == false) goto L21;
        return;
    L21:
        throw new ProtocolException("Target host missing");
    L22:
        r4.addHeader("Host", r1.toHostString());
        return;
    }
}
