package cz.msebera.android.httpclient.impl.conn;

import cz.msebera.android.httpclient.HttpException;
import cz.msebera.android.httpclient.HttpHost;
import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.conn.SchemePortResolver;
import cz.msebera.android.httpclient.protocol.HttpContext;
import cz.msebera.android.httpclient.util.Args;

/* JADX INFO: loaded from: classes5.dex */
public class DefaultProxyRoutePlanner extends DefaultRoutePlanner {
    private final HttpHost proxy;

    public DefaultProxyRoutePlanner(HttpHost r1, SchemePortResolver r2) {
        super(r2);
        this.proxy = (HttpHost) Args.notNull(r1, "Proxy host");
    }

    public DefaultProxyRoutePlanner(HttpHost r2) {
        this(r2, null);
    }

    @Override // cz.msebera.android.httpclient.impl.conn.DefaultRoutePlanner
    protected HttpHost determineProxy(HttpHost r1, HttpRequest r2, HttpContext r3) throws HttpException {
        return this.proxy;
    }
}
