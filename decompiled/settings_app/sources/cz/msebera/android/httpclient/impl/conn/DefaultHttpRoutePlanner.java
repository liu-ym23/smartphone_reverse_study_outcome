package cz.msebera.android.httpclient.impl.conn;

import cz.msebera.android.httpclient.HttpException;
import cz.msebera.android.httpclient.HttpHost;
import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.conn.params.ConnRouteParams;
import cz.msebera.android.httpclient.conn.routing.HttpRoute;
import cz.msebera.android.httpclient.conn.routing.HttpRoutePlanner;
import cz.msebera.android.httpclient.conn.scheme.SchemeRegistry;
import cz.msebera.android.httpclient.protocol.HttpContext;
import cz.msebera.android.httpclient.util.Args;
import cz.msebera.android.httpclient.util.Asserts;
import java.net.InetAddress;

/* JADX INFO: loaded from: classes5.dex */
@Deprecated
public class DefaultHttpRoutePlanner implements HttpRoutePlanner {
    protected final SchemeRegistry schemeRegistry;

    public DefaultHttpRoutePlanner(SchemeRegistry r2) {
        Args.notNull(r2, "Scheme registry");
        this.schemeRegistry = r2;
    }

    @Override // cz.msebera.android.httpclient.conn.routing.HttpRoutePlanner
    public HttpRoute determineRoute(HttpHost r2, HttpRequest r3, HttpContext r4) throws HttpException {
        Args.notNull(r3, "HTTP request");
        HttpRoute r5 = ConnRouteParams.getForcedRoute(r3.getParams());
        if (r5 == null) goto L5;
        return r5;
    L5:
        Asserts.notNull(r2, "Target host");
        InetAddress r6 = ConnRouteParams.getLocalAddress(r3.getParams());
        HttpHost r7 = ConnRouteParams.getDefaultProxy(r3.getParams());
        boolean r1 = this.schemeRegistry.getScheme(r2.getSchemeName()).isLayered();
        if (r7 != null) goto L11;
        return new HttpRoute(r2, r6, r1);
    L11:
        return new HttpRoute(r2, r6, r7, r1);
    L12:
        e = move-exception;
        throw new HttpException(e.getMessage());
    }
}
