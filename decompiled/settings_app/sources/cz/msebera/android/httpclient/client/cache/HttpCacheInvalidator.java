package cz.msebera.android.httpclient.client.cache;

import cz.msebera.android.httpclient.HttpHost;
import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.HttpResponse;

/* JADX INFO: loaded from: classes5.dex */
public interface HttpCacheInvalidator {
    void flushInvalidatedCacheEntries(HttpHost r1, HttpRequest r2);

    void flushInvalidatedCacheEntries(HttpHost r1, HttpRequest r2, HttpResponse r3);
}
