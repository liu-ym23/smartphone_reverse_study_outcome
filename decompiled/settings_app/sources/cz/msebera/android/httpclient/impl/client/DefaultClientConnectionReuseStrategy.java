package cz.msebera.android.httpclient.impl.client;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.impl.DefaultConnectionReuseStrategy;
import cz.msebera.android.httpclient.message.BasicHeaderIterator;
import cz.msebera.android.httpclient.message.BasicTokenIterator;
import cz.msebera.android.httpclient.protocol.HttpContext;

/* JADX INFO: loaded from: classes5.dex */
public class DefaultClientConnectionReuseStrategy extends DefaultConnectionReuseStrategy {
    public static final DefaultClientConnectionReuseStrategy INSTANCE = null;

    public DefaultClientConnectionReuseStrategy() {
    }

    static {
        INSTANCE = new DefaultClientConnectionReuseStrategy();
    }

    @Override // cz.msebera.android.httpclient.impl.DefaultConnectionReuseStrategy, cz.msebera.android.httpclient.ConnectionReuseStrategy
    public boolean keepAlive(HttpResponse r5, HttpContext r6) {
        HttpRequest r0 = (HttpRequest) r6.getAttribute("http.request");
        if (r0 == null) goto L14;
        Header[] r1 = r0.getHeaders("Connection");
        if (r1.length == 0) goto L14;
        BasicTokenIterator r2 = new BasicTokenIterator(new BasicHeaderIterator(r1, null));
    L8:
        if (r2.hasNext() == false) goto L14;
        if ("Close".equalsIgnoreCase(r2.nextToken()) == false) goto L8;
        return false;
    L14:
        return super.keepAlive(r5, r6);
    }
}
