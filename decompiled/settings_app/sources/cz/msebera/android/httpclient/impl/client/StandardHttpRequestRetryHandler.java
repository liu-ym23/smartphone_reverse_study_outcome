package cz.msebera.android.httpclient.impl.client;

import cz.msebera.android.httpclient.HttpRequest;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes5.dex */
public class StandardHttpRequestRetryHandler extends DefaultHttpRequestRetryHandler {
    private final Map<String, Boolean> idempotentMethods;

    public StandardHttpRequestRetryHandler(int r1, boolean r2) {
        super(r1, r2);
        ConcurrentHashMap r3 = new ConcurrentHashMap();
        this.idempotentMethods = r3;
        r3.put("GET", Boolean.TRUE);
        r3.put("HEAD", Boolean.TRUE);
        r3.put("PUT", Boolean.TRUE);
        r3.put("DELETE", Boolean.TRUE);
        r3.put("OPTIONS", Boolean.TRUE);
        r3.put("TRACE", Boolean.TRUE);
    }

    public StandardHttpRequestRetryHandler() {
        this(3, false);
    }

    @Override // cz.msebera.android.httpclient.impl.client.DefaultHttpRequestRetryHandler
    protected boolean handleAsIdempotent(HttpRequest r2) {
        String r3 = r2.getRequestLine().getMethod().toUpperCase(Locale.ROOT);
        Boolean r1 = this.idempotentMethods.get(r3);
        if (r1 != null) goto L5;
    L7:
        return false;
    L5:
        if (r1.booleanValue() == false) goto L7;
        return true;
    }
}
