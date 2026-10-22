package cz.msebera.android.httpclient.impl.client.cache;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HeaderElement;
import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.HttpVersion;
import cz.msebera.android.httpclient.client.cache.HeaderConstants;
import cz.msebera.android.httpclient.extras.HttpClientAndroidLog;

/* JADX INFO: loaded from: classes5.dex */
class CacheableRequestPolicy {
    public HttpClientAndroidLog log;

    CacheableRequestPolicy() {
        this.log = new HttpClientAndroidLog(getClass());
    }

    public boolean isServableFromCache(HttpRequest r10) {
        String r0 = r10.getRequestLine().getMethod();
        if (HttpVersion.HTTP_1_1.compareToVersion(r10.getRequestLine().getProtocolVersion()) == 0) goto L7;
        this.log.trace("non-HTTP/1.1 request was not serveable from cache");
        return false;
    L7:
        if (r0.equals("GET") == true) goto L13;
        if (r0.equals("HEAD") == true) goto L13;
        this.log.trace("non-GET or non-HEAD request was not serveable from cache");
        return false;
    L13:
        if (r10.getHeaders("Pragma").length <= 0) goto L16;
        this.log.trace("request with Pragma header was not serveable from cache");
        return false;
    L16:
        Header[] r11 = r10.getHeaders("Cache-Control");
        int r1 = r11.length;
        int r2 = 0;
    L17:
        if (r2 >= r1) goto L30;
        HeaderElement[] r3 = r11[r2].getElements();
        int r4 = r3.length;
        int r5 = 0;
    L19:
        if (r5 >= r4) goto L29;
        HeaderElement r6 = r3[r5];
        if (HeaderConstants.CACHE_CONTROL_NO_STORE.equalsIgnoreCase(r6.getName()) == true) goto L22;
        if (HeaderConstants.CACHE_CONTROL_NO_CACHE.equalsIgnoreCase(r6.getName()) == true) goto L26;
        r5 = r5 + 1;
        goto L19
    L26:
        this.log.trace("Request with no-cache was not serveable from cache");
        return false;
    L22:
        this.log.trace("Request with no-store was not serveable from cache");
        return false;
    L29:
        r2 = r2 + 1;
        goto L17
    L30:
        this.log.trace("Request was serveable from cache");
        return true;
    }
}
