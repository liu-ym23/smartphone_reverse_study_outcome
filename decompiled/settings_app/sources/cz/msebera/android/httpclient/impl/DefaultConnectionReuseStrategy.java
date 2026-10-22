package cz.msebera.android.httpclient.impl;

import cz.msebera.android.httpclient.ConnectionReuseStrategy;
import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HeaderIterator;
import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.HttpVersion;
import cz.msebera.android.httpclient.ParseException;
import cz.msebera.android.httpclient.ProtocolVersion;
import cz.msebera.android.httpclient.TokenIterator;
import cz.msebera.android.httpclient.message.BasicTokenIterator;
import cz.msebera.android.httpclient.protocol.HttpContext;
import cz.msebera.android.httpclient.util.Args;

/* JADX INFO: loaded from: classes5.dex */
public class DefaultConnectionReuseStrategy implements ConnectionReuseStrategy {
    public static final DefaultConnectionReuseStrategy INSTANCE = null;

    static {
        INSTANCE = new DefaultConnectionReuseStrategy();
    }

    public DefaultConnectionReuseStrategy() {
    }

    @Override // cz.msebera.android.httpclient.ConnectionReuseStrategy
    public boolean keepAlive(HttpResponse r8, HttpContext r9) {
        Args.notNull(r8, "HTTP response");
        Args.notNull(r9, "HTTP context");
        if (r8.getStatusLine().getStatusCode() != 204) goto L12;
        Header r0 = r8.getFirstHeader("Content-Length");
        if (r0 == null) goto L10;
        if (Integer.parseInt(r0.getValue()) <= 0) goto L10;
        return false;
    L10:
        if (r8.getFirstHeader("Transfer-Encoding") == null) goto L12;
        return false;
    L12:
        HttpRequest r10 = (HttpRequest) r9.getAttribute("http.request");
        if (r10 != null) goto L57;
    L20:
        ProtocolVersion r5 = r8.getStatusLine().getProtocolVersion();
        Header r2 = r8.getFirstHeader("Transfer-Encoding");
        if (r2 == null) goto L26;
        if ("chunked".equalsIgnoreCase(r2.getValue()) == true) goto L33;
        return false;
    L33:
        HeaderIterator r7 = r8.headerIterator("Connection");
        if (r7.hasNext() == true) goto L37;
        r7 = r8.headerIterator("Proxy-Connection");
    L37:
        if (r7.hasNext() == false) goto L51;
        BasicTokenIterator r11 = new BasicTokenIterator(r7);     // Catch: ParseException -> L49
        boolean r12 = false;
    L40:
        if (r11.hasNext() == false) goto L47;
        String r13 = r11.nextToken();     // Catch: ParseException -> L49
        if ("Close".equalsIgnoreCase(r13) == true) goto L43;
        if ("Keep-Alive".equalsIgnoreCase(r13) == false) goto L40;
        r12 = true;
        goto L40
    L43:
        return false;
    L47:
        if (r12 == false) goto L51;
        return true;
    L49:
        return false;
    L51:
        return !r5.lessEquals(HttpVersion.HTTP_1_0);
    L26:
        if (canResponseHaveBody(r10, r8) == false) goto L33;
        Header[] r14 = r8.getHeaders("Content-Length");
        if (r14.length == 1) goto L55;
    L32:
        return false;
    L55:
        if (Integer.parseInt(r14[0].getValue()) >= 0) goto L33;
    L57:
        BasicTokenIterator r6 = new BasicTokenIterator(r10.headerIterator("Connection"));     // Catch: ParseException -> L54
    L16:
        if (r6.hasNext() == false) goto L20;
        if ("Close".equalsIgnoreCase(r6.nextToken()) == false) goto L16;
    L19:
        return false;
    }

    protected TokenIterator createTokenIterator(HeaderIterator r1) {
        return new BasicTokenIterator(r1);
    }

    private boolean canResponseHaveBody(HttpRequest r2, HttpResponse r3) {
        if (r2 != null) goto L5;
    L7:
        int r4 = r3.getStatusLine().getStatusCode();
        if (r4 >= 200) goto L10;
        return false;
    L10:
        if (r4 != 204) goto L12;
        return false;
    L12:
        if (r4 != 304) goto L14;
        return false;
    L14:
        if (r4 == 205) goto L20;
        return true;
    L20:
        return false;
    L5:
        if (r2.getRequestLine().getMethod().equalsIgnoreCase("HEAD") == false) goto L7;
        return false;
    }
}
