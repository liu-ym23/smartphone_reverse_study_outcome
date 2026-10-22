package cz.msebera.android.httpclient.impl.client.cache;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HttpHost;
import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.client.cache.HttpCacheEntry;
import cz.msebera.android.httpclient.client.cache.HttpCacheInvalidator;
import cz.msebera.android.httpclient.client.cache.HttpCacheStorage;
import cz.msebera.android.httpclient.client.utils.DateUtils;
import cz.msebera.android.httpclient.extras.HttpClientAndroidLog;
import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.Iterator;

/* JADX INFO: loaded from: classes5.dex */
class CacheInvalidator implements HttpCacheInvalidator {
    private final CacheKeyGenerator cacheKeyGenerator;
    public HttpClientAndroidLog log;
    private final HttpCacheStorage storage;

    public CacheInvalidator(CacheKeyGenerator r3, HttpCacheStorage r4) {
        this.log = new HttpClientAndroidLog(getClass());
        this.cacheKeyGenerator = r3;
        this.storage = r4;
    }

    @Override // cz.msebera.android.httpclient.client.cache.HttpCacheInvalidator
    public void flushInvalidatedCacheEntries(HttpHost r5, HttpRequest r6) {
        String r7 = this.cacheKeyGenerator.getURI(r5, r6);
        HttpCacheEntry r0 = getEntry(r7);
        if (requestShouldNotBeCached(r6) == false) goto L5;
    L6:
        this.log.debug("Invalidating parent cache entry: " + r0);
        if (r0 == null) goto L13;
        Iterator<String> r1 = r0.getVariantMap().values().iterator();
    L10:
        if (r1.hasNext() == false) goto L12;
        flushEntry(r1.next());
        goto L10
    L12:
        flushEntry(r7);
    L13:
        URL r8 = getAbsoluteURL(r7);
        if (r8 != null) goto L17;
        this.log.error("Couldn't transform request into valid URL");
        return;
    L17:
        Header r2 = r6.getFirstHeader("Content-Location");
        if (r2 == null) goto L22;
        String r3 = r2.getValue();
        if (flushAbsoluteUriFromSameHost(r8, r3) == true) goto L22;
        flushRelativeUriFromSameHost(r8, r3);
    L22:
        Header r9 = r6.getFirstHeader("Location");
        if (r9 == null) goto L28;
        flushAbsoluteUriFromSameHost(r8, r9.getValue());
        return;
    L28:
        return;
    L5:
        if (shouldInvalidateHeadCacheEntry(r6, r0) == true) goto L6;
    }

    private boolean shouldInvalidateHeadCacheEntry(HttpRequest r1, HttpCacheEntry r2) {
        if (requestIsGet(r1) == true) goto L5;
    L7:
        return false;
    L5:
        if (isAHeadCacheEntry(r2) == false) goto L7;
        return true;
    }

    private boolean requestIsGet(HttpRequest r1) {
        return r1.getRequestLine().getMethod().equals("GET");
    }

    private boolean isAHeadCacheEntry(HttpCacheEntry r1) {
        if (r1 != null) goto L4;
    L6:
        return false;
    L4:
        if (r1.getRequestMethod().equals("HEAD") == false) goto L6;
        return true;
    }

    private void flushEntry(String r2) {
        this.storage.removeEntry(r2);     // Catch: IOException -> L4
        return;
    L4:
        e = move-exception;
        this.log.warn("unable to flush cache entry", e);
    }

    private HttpCacheEntry getEntry(String r2) {
        return this.storage.getEntry(r2);
    L4:
        e = move-exception;
        this.log.warn("could not retrieve entry from storage", e);
        return null;
    }

    protected void flushUriIfSameHost(URL r2, URL r3) {
        URL r4 = getAbsoluteURL(this.cacheKeyGenerator.canonicalizeUri(r3.toString()));
        if (r4 != null) goto L6;
        return;
    L6:
        if (r4.getAuthority().equalsIgnoreCase(r2.getAuthority()) == false) goto L9;
        flushEntry(r4.toString());
        return;
    }

    protected void flushRelativeUriFromSameHost(URL r1, String r2) {
        URL r3 = getRelativeURL(r1, r2);
        if (r3 != null) goto L5;
        return;
    L5:
        flushUriIfSameHost(r1, r3);
    }

    protected boolean flushAbsoluteUriFromSameHost(URL r1, String r2) {
        URL r3 = getAbsoluteURL(r2);
        if (r3 != null) goto L6;
        return false;
    L6:
        flushUriIfSameHost(r1, r3);
        return true;
    }

    private URL getAbsoluteURL(String r1) {
        return new URL(r1);
    L4:
        return null;
    }

    private URL getRelativeURL(URL r1, String r2) {
        return new URL(r1, r2);
    L4:
        return null;
    }

    protected boolean requestShouldNotBeCached(HttpRequest r1) {
        return notGetOrHeadRequest(r1.getRequestLine().getMethod());
    }

    private boolean notGetOrHeadRequest(String r1) {
        if ("GET".equals(r1) == false) goto L5;
    L7:
        return false;
    L5:
        if ("HEAD".equals(r1) == true) goto L7;
        return true;
    }

    @Override // cz.msebera.android.httpclient.client.cache.HttpCacheInvalidator
    public void flushInvalidatedCacheEntries(HttpHost r3, HttpRequest r4, HttpResponse r5) {
        int r0 = r5.getStatusLine().getStatusCode();
        if (r0 >= 200) goto L5;
        return;
    L5:
        if (r0 > 299) goto L19;
        URL r6 = getAbsoluteURL(this.cacheKeyGenerator.getURI(r3, r4));
        if (r6 != null) goto L10;
        return;
    L10:
        URL r7 = getContentLocationURL(r6, r5);
        if (r7 == null) goto L13;
        flushLocationCacheEntry(r6, r5, r7);
    L13:
        URL r8 = getLocationURL(r6, r5);
        if (r8 == null) goto L18;
        flushLocationCacheEntry(r6, r5, r8);
        return;
    L18:
        return;
    }

    private void flushLocationCacheEntry(URL r3, HttpResponse r4, URL r5) {
        HttpCacheEntry r0 = getEntry(this.cacheKeyGenerator.canonicalizeUri(r5.toString()));
        if (r0 != null) goto L6;
        return;
    L6:
        if (responseDateOlderThanEntryDate(r4, r0) == false) goto L9;
        return;
    L9:
        if (responseAndEntryEtagsDiffer(r4, r0) == true) goto L11;
        return;
    L11:
        flushUriIfSameHost(r3, r5);
    }

    private URL getContentLocationURL(URL r2, HttpResponse r3) {
        Header r4 = r3.getFirstHeader("Content-Location");
        if (r4 != null) goto L6;
        return null;
    L6:
        String r5 = r4.getValue();
        URL r0 = getAbsoluteURL(r5);
        if (r0 == null) goto L10;
        return r0;
    L10:
        return getRelativeURL(r2, r5);
    }

    private URL getLocationURL(URL r2, HttpResponse r3) {
        Header r4 = r3.getFirstHeader("Location");
        if (r4 != null) goto L6;
        return null;
    L6:
        String r5 = r4.getValue();
        URL r0 = getAbsoluteURL(r5);
        if (r0 == null) goto L10;
        return r0;
    L10:
        return getRelativeURL(r2, r5);
    }

    private boolean responseAndEntryEtagsDiffer(HttpResponse r1, HttpCacheEntry r2) {
        Header r3 = r2.getFirstHeader("ETag");
        Header r0 = r1.getFirstHeader("ETag");
        if (r3 == null) goto L8;
        if (r0 != null) goto L7;
        return false;
    L7:
        return !r3.getValue().equals(r0.getValue());
    L8:
        return false;
    }

    private boolean responseDateOlderThanEntryDate(HttpResponse r1, HttpCacheEntry r2) {
        Header r3 = r2.getFirstHeader("Date");
        Header r0 = r1.getFirstHeader("Date");
        if (r3 == null) goto L12;
        if (r0 == null) goto L12;
        Date r4 = DateUtils.parseDate(r3.getValue());
        Date r5 = DateUtils.parseDate(r0.getValue());
        if (r4 == null) goto L12;
        if (r5 == null) goto L12;
        return r5.before(r4);
    L12:
        return false;
    }
}
