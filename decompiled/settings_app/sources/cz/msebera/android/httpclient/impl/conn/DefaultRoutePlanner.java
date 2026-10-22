package cz.msebera.android.httpclient.impl.conn;

import cz.msebera.android.httpclient.HttpException;
import cz.msebera.android.httpclient.HttpHost;
import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.ProtocolException;
import cz.msebera.android.httpclient.client.config.RequestConfig;
import cz.msebera.android.httpclient.client.protocol.HttpClientContext;
import cz.msebera.android.httpclient.conn.SchemePortResolver;
import cz.msebera.android.httpclient.conn.UnsupportedSchemeException;
import cz.msebera.android.httpclient.conn.routing.HttpRoute;
import cz.msebera.android.httpclient.conn.routing.HttpRoutePlanner;
import cz.msebera.android.httpclient.protocol.HttpContext;
import cz.msebera.android.httpclient.util.Args;
import java.net.InetAddress;
import obric.time.HttpHeadTimeFetcher;

/* JADX INFO: loaded from: classes5.dex */
public class DefaultRoutePlanner implements HttpRoutePlanner {
    private final SchemePortResolver schemePortResolver;

    protected HttpHost determineProxy(HttpHost r1, HttpRequest r2, HttpContext r3) throws HttpException {
        return null;
    }

    public DefaultRoutePlanner(SchemePortResolver r1) {
        if (r1 != null) goto L6;
        r1 = DefaultSchemePortResolver.INSTANCE;
    L6:
        this.schemePortResolver = r1;
    }

    @Override // cz.msebera.android.httpclient.conn.routing.HttpRoutePlanner
    public HttpRoute determineRoute(HttpHost r3, HttpRequest r4, HttpContext r5) throws HttpException {
        Args.notNull(r4, "Request");
        if (r3 == null) goto L20;
        RequestConfig r0 = HttpClientContext.adapt(r5).getRequestConfig();
        InetAddress r1 = r0.getLocalAddress();
        HttpHost r2 = r0.getProxy();
        if (r2 != null) goto L8;
        r2 = determineProxy(r3, r4, r5);
    L8:
        if (r3.getPort() <= 0) goto L21;
    L14:
        boolean r6 = r3.getSchemeName().equalsIgnoreCase(HttpHeadTimeFetcher.FETCHER_TYPE);
        if (r2 != null) goto L17;
        HttpRoute r7 = new HttpRoute(r3, r1, r6);
    L18:
        return r7;
    L17:
        r7 = new HttpRoute(r3, r1, r2, r6);
        goto L18
    L21:
        r3 = new HttpHost(r3.getHostName(), this.schemePortResolver.resolve(r3), r3.getSchemeName());     // Catch: UnsupportedSchemeException -> L11
    L11:
        e = move-exception;
        throw new HttpException(e.getMessage());
    L20:
        throw new ProtocolException("Target host is not specified");
    }
}
