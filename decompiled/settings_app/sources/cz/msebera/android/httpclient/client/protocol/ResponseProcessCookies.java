package cz.msebera.android.httpclient.client.protocol;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HeaderIterator;
import cz.msebera.android.httpclient.HttpException;
import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.HttpResponseInterceptor;
import cz.msebera.android.httpclient.client.CookieStore;
import cz.msebera.android.httpclient.cookie.Cookie;
import cz.msebera.android.httpclient.cookie.CookieOrigin;
import cz.msebera.android.httpclient.cookie.CookieSpec;
import cz.msebera.android.httpclient.cookie.MalformedCookieException;
import cz.msebera.android.httpclient.extras.HttpClientAndroidLog;
import cz.msebera.android.httpclient.protocol.HttpContext;
import cz.msebera.android.httpclient.util.Args;
import java.io.IOException;
import java.util.Iterator;

/* JADX INFO: loaded from: classes5.dex */
public class ResponseProcessCookies implements HttpResponseInterceptor {
    public HttpClientAndroidLog log;

    public ResponseProcessCookies() {
        this.log = new HttpClientAndroidLog(getClass());
    }

    @Override // cz.msebera.android.httpclient.HttpResponseInterceptor
    public void process(HttpResponse r4, HttpContext r5) throws HttpException, IOException {
        Args.notNull(r4, "HTTP request");
        Args.notNull(r5, "HTTP context");
        HttpClientContext r6 = HttpClientContext.adapt(r5);
        CookieSpec r0 = r6.getCookieSpec();
        if (r0 != null) goto L6;
        this.log.debug("Cookie spec not specified in HTTP context");
        return;
    L6:
        CookieStore r1 = r6.getCookieStore();
        if (r1 != null) goto L10;
        this.log.debug("Cookie store not specified in HTTP context");
        return;
    L10:
        CookieOrigin r7 = r6.getCookieOrigin();
        if (r7 != null) goto L14;
        this.log.debug("Cookie origin not specified in HTTP context");
        return;
    L14:
        processCookies(r4.headerIterator("Set-Cookie"), r0, r7, r1);
        if (r0.getVersion() <= 0) goto L18;
        processCookies(r4.headerIterator("Set-Cookie2"), r0, r7, r1);
        return;
    }

    private void processCookies(HeaderIterator r8, CookieSpec r9, CookieOrigin r10, CookieStore r11) {
    L3:
        if (r8.hasNext() == false) goto L22;
        Header r0 = r8.nextHeader();
        Iterator<Cookie> r1 = r9.parse(r0, r10).iterator();     // Catch: MalformedCookieException -> L18
    L7:
        if (r1.hasNext() == false) goto L3;
        Cookie r2 = r1.next();     // Catch: MalformedCookieException -> L18
        r9.validate(r2, r10);     // Catch: MalformedCookieException -> L13
        r11.addCookie(r2);     // Catch: MalformedCookieException -> L13
        if (this.log.isDebugEnabled() == false) goto L7;
        this.log.debug("Cookie accepted [" + formatCooke(r2) + "]");     // Catch: MalformedCookieException -> L13
    L13:
        e = move-exception;
        if (this.log.isWarnEnabled() == false) goto L7;
        this.log.warn("Cookie rejected [" + formatCooke(r2) + "] " + e.getMessage());     // Catch: MalformedCookieException -> L18
    L18:
        e = move-exception;
        if (this.log.isWarnEnabled() == false) goto L3;
        this.log.warn("Invalid cookie header: \"" + r0 + "\". " + e.getMessage());
        goto L3
    }

    private static String formatCooke(Cookie r5) {
        StringBuilder r0 = new StringBuilder();
        r0.append(r5.getName());
        r0.append("=\"");
        String r1 = r5.getValue();
        if (r1 != null) goto L5;
    L8:
        r0.append("\", version:");
        r0.append(Integer.toString(r5.getVersion()));
        r0.append(", domain:");
        r0.append(r5.getDomain());
        r0.append(", path:");
        r0.append(r5.getPath());
        r0.append(", expiry:");
        r0.append(r5.getExpiryDate());
        return r0.toString();
    L5:
        if (r1.length() <= 100) goto L7;
        r1 = r1.substring(0, 100) + "...";
    L7:
        r0.append(r1);
        goto L8
    }
}
