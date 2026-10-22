package cz.msebera.android.httpclient.impl.client.cache;

import cz.msebera.android.httpclient.client.cache.HttpCacheEntry;

/* JADX INFO: loaded from: classes5.dex */
class Variant {
    private final String cacheKey;
    private final HttpCacheEntry entry;
    private final String variantKey;

    public Variant(String r1, String r2, HttpCacheEntry r3) {
        this.variantKey = r1;
        this.cacheKey = r2;
        this.entry = r3;
    }

    public String getVariantKey() {
        return this.variantKey;
    }

    public String getCacheKey() {
        return this.cacheKey;
    }

    public HttpCacheEntry getEntry() {
        return this.entry;
    }
}
