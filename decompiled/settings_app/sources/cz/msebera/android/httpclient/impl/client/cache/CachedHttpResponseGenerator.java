package cz.msebera.android.httpclient.impl.client.cache;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HttpEntity;
import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.HttpVersion;
import cz.msebera.android.httpclient.client.cache.HttpCacheEntry;
import cz.msebera.android.httpclient.client.methods.CloseableHttpResponse;
import cz.msebera.android.httpclient.client.methods.HttpRequestWrapper;
import cz.msebera.android.httpclient.client.utils.DateUtils;
import cz.msebera.android.httpclient.message.BasicHeader;
import cz.msebera.android.httpclient.message.BasicHttpResponse;
import java.util.Date;

/* JADX INFO: loaded from: classes5.dex */
class CachedHttpResponseGenerator {
    private final CacheValidityPolicy validityStrategy;

    CachedHttpResponseGenerator(CacheValidityPolicy r1) {
        this.validityStrategy = r1;
    }

    CachedHttpResponseGenerator() {
        this(new CacheValidityPolicy());
    }

    CloseableHttpResponse generateResponse(HttpRequestWrapper r6, HttpCacheEntry r7) {
        Date r0 = new Date();
        BasicHttpResponse r1 = new BasicHttpResponse(HttpVersion.HTTP_1_1, r7.getStatusCode(), r7.getReasonPhrase());
        r1.setHeaders(r7.getAllHeaders());
        if (responseShouldContainEntity(r6, r7) == false) goto L5;
        CacheEntity r8 = new CacheEntity(r7);
        addMissingContentLengthHeader(r1, r8);
        r1.setEntity(r8);
    L5:
        long r5 = this.validityStrategy.getCurrentAgeSecs(r7, r0);
        if (r5 <= 0) goto L12;
        if (r5 < 2147483647L) goto L10;
        r1.setHeader("Age", "2147483648");
        goto L12
    L10:
        r1.setHeader("Age", "" + ((int) r5));
    L12:
        return Proxies.enhanceResponse(r1);
    }

    CloseableHttpResponse generateNotModifiedResponse(HttpCacheEntry r4) {
        BasicHttpResponse r3 = new BasicHttpResponse(HttpVersion.HTTP_1_1, 304, "Not Modified");
        Header r1 = r4.getFirstHeader("Date");
        if (r1 != null) goto L5;
        r1 = new BasicHeader("Date", DateUtils.formatDate(new Date()));
    L5:
        r3.addHeader(r1);
        Header r0 = r4.getFirstHeader("ETag");
        if (r0 == null) goto L8;
        r3.addHeader(r0);
    L8:
        Header r2 = r4.getFirstHeader("Content-Location");
        if (r2 == null) goto L11;
        r3.addHeader(r2);
    L11:
        Header r5 = r4.getFirstHeader("Expires");
        if (r5 == null) goto L14;
        r3.addHeader(r5);
    L14:
        Header r6 = r4.getFirstHeader("Cache-Control");
        if (r6 == null) goto L17;
        r3.addHeader(r6);
    L17:
        Header r7 = r4.getFirstHeader("Vary");
        if (r7 == null) goto L21;
        r3.addHeader(r7);
    L21:
        return Proxies.enhanceResponse(r3);
    }

    private void addMissingContentLengthHeader(HttpResponse r3, HttpEntity r4) {
        if (transferEncodingIsPresent(r3) == false) goto L5;
        return;
    L5:
        r3.setHeader(new BasicHeader("Content-Length", Long.toString(r4.getContentLength())));
    }

    private boolean transferEncodingIsPresent(HttpResponse r1) {
        if (r1.getFirstHeader("Transfer-Encoding") == null) goto L5;
        return true;
    L5:
        return false;
    }

    private boolean responseShouldContainEntity(HttpRequestWrapper r1, HttpCacheEntry r2) {
        if (r1.getRequestLine().getMethod().equals("GET") == true) goto L5;
    L7:
        return false;
    L5:
        if (r2.getResource() == null) goto L7;
        return true;
    }
}
