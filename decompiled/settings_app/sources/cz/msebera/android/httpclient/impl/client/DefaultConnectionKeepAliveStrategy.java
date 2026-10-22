package cz.msebera.android.httpclient.impl.client;

import cz.msebera.android.httpclient.HeaderElement;
import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.conn.ConnectionKeepAliveStrategy;
import cz.msebera.android.httpclient.message.BasicHeaderElementIterator;
import cz.msebera.android.httpclient.protocol.HttpContext;
import cz.msebera.android.httpclient.util.Args;

/* JADX INFO: loaded from: classes5.dex */
public class DefaultConnectionKeepAliveStrategy implements ConnectionKeepAliveStrategy {
    public static final DefaultConnectionKeepAliveStrategy INSTANCE = null;

    public DefaultConnectionKeepAliveStrategy() {
    }

    static {
        INSTANCE = new DefaultConnectionKeepAliveStrategy();
    }

    @Override // cz.msebera.android.httpclient.conn.ConnectionKeepAliveStrategy
    public long getKeepAliveDuration(HttpResponse r3, HttpContext r4) {
        Args.notNull(r3, "HTTP response");
        BasicHeaderElementIterator r2 = new BasicHeaderElementIterator(r3.headerIterator("Keep-Alive"));
    L4:
        if (r2.hasNext() == false) goto L12;
        HeaderElement r5 = r2.nextElement();
        String r6 = r5.getName();
        String r7 = r5.getValue();
        if (r7 == null) goto L4;
        if (r6.equalsIgnoreCase("timeout") == false) goto L4;
        return Long.parseLong(r7) * 1000;
    L12:
        return -1;
    }
}
