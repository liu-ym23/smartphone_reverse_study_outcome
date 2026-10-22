package cz.msebera.android.httpclient.client.protocol;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HttpException;
import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.HttpRequestInterceptor;
import cz.msebera.android.httpclient.client.params.ClientPNames;
import cz.msebera.android.httpclient.protocol.HttpContext;
import cz.msebera.android.httpclient.util.Args;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: loaded from: classes5.dex */
public class RequestDefaultHeaders implements HttpRequestInterceptor {
    private final Collection<? extends Header> defaultHeaders;

    public RequestDefaultHeaders(Collection<? extends Header> r1) {
        this.defaultHeaders = r1;
    }

    public RequestDefaultHeaders() {
        this(null);
    }

    @Override // cz.msebera.android.httpclient.HttpRequestInterceptor
    public void process(HttpRequest r2, HttpContext r3) throws HttpException, IOException {
        Args.notNull(r2, "HTTP request");
        if (r2.getRequestLine().getMethod().equalsIgnoreCase("CONNECT") == false) goto L5;
        return;
    L5:
        Collection<? extends Header> r4 = (Collection) r2.getParams().getParameter(ClientPNames.DEFAULT_HEADERS);
        if (r4 != null) goto L8;
        r4 = this.defaultHeaders;
    L8:
        if (r4 == null) goto L13;
        Iterator<? extends Header> r1 = r4.iterator();
    L11:
        if (r1.hasNext() == false) goto L15;
        r2.addHeader(r1.next());
        goto L11
    L15:
        return;
    }
}
