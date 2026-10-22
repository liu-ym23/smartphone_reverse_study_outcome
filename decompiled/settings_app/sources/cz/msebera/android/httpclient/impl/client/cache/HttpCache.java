package cz.msebera.android.httpclient.impl.client.cache;

import cz.msebera.android.httpclient.HttpHost;
import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.client.cache.HttpCacheEntry;
import cz.msebera.android.httpclient.client.methods.CloseableHttpResponse;
import java.io.IOException;
import java.util.Date;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
interface HttpCache {
    HttpResponse cacheAndReturnResponse(HttpHost r1, HttpRequest r2, HttpResponse r3, Date r4, Date r5) throws IOException;

    CloseableHttpResponse cacheAndReturnResponse(HttpHost r1, HttpRequest r2, CloseableHttpResponse r3, Date r4, Date r5) throws IOException;

    void flushCacheEntriesFor(HttpHost r1, HttpRequest r2) throws IOException;

    void flushInvalidatedCacheEntriesFor(HttpHost r1, HttpRequest r2) throws IOException;

    void flushInvalidatedCacheEntriesFor(HttpHost r1, HttpRequest r2, HttpResponse r3);

    HttpCacheEntry getCacheEntry(HttpHost r1, HttpRequest r2) throws IOException;

    Map<String, Variant> getVariantCacheEntriesWithEtags(HttpHost r1, HttpRequest r2) throws IOException;

    void reuseVariantEntryFor(HttpHost r1, HttpRequest r2, Variant r3) throws IOException;

    HttpCacheEntry updateCacheEntry(HttpHost r1, HttpRequest r2, HttpCacheEntry r3, HttpResponse r4, Date r5, Date r6) throws IOException;

    HttpCacheEntry updateVariantCacheEntry(HttpHost r1, HttpRequest r2, HttpCacheEntry r3, HttpResponse r4, Date r5, Date r6, String r7) throws IOException;
}
