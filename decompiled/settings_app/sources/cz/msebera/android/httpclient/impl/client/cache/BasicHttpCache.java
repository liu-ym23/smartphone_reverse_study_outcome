package cz.msebera.android.httpclient.impl.client.cache;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HttpHost;
import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.HttpVersion;
import cz.msebera.android.httpclient.client.cache.HttpCacheEntry;
import cz.msebera.android.httpclient.client.cache.HttpCacheInvalidator;
import cz.msebera.android.httpclient.client.cache.HttpCacheStorage;
import cz.msebera.android.httpclient.client.cache.HttpCacheUpdateException;
import cz.msebera.android.httpclient.client.cache.Resource;
import cz.msebera.android.httpclient.client.cache.ResourceFactory;
import cz.msebera.android.httpclient.client.methods.CloseableHttpResponse;
import cz.msebera.android.httpclient.client.methods.HttpRequestWrapper;
import cz.msebera.android.httpclient.entity.ByteArrayEntity;
import cz.msebera.android.httpclient.extras.HttpClientAndroidLog;
import cz.msebera.android.httpclient.message.BasicHttpResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes5.dex */
class BasicHttpCache implements HttpCache {
    private static final Set<String> safeRequestMethods = null;
    private final CacheEntryUpdater cacheEntryUpdater;
    private final HttpCacheInvalidator cacheInvalidator;
    public HttpClientAndroidLog log;
    private final long maxObjectSizeBytes;
    private final ResourceFactory resourceFactory;
    private final CachedHttpResponseGenerator responseGenerator;
    private final HttpCacheStorage storage;
    private final CacheKeyGenerator uriExtractor;

    static /* synthetic */ CacheKeyGenerator access$000(BasicHttpCache r0) {
        return r0.uriExtractor;
    }

    static {
        safeRequestMethods = new HashSet(Arrays.asList(new String[]{"HEAD", "GET", "OPTIONS", "TRACE"}));
    }

    public BasicHttpCache(ResourceFactory r3, HttpCacheStorage r4, CacheConfig r5, CacheKeyGenerator r6, HttpCacheInvalidator r7) {
        this.log = new HttpClientAndroidLog(getClass());
        this.resourceFactory = r3;
        this.uriExtractor = r6;
        this.cacheEntryUpdater = new CacheEntryUpdater(r3);
        this.maxObjectSizeBytes = r5.getMaxObjectSize();
        this.responseGenerator = new CachedHttpResponseGenerator();
        this.storage = r4;
        this.cacheInvalidator = r7;
    }

    public BasicHttpCache(ResourceFactory r7, HttpCacheStorage r8, CacheConfig r9, CacheKeyGenerator r10) {
        this(r7, r8, r9, r10, new CacheInvalidator(r10, r8));
    }

    public BasicHttpCache(ResourceFactory r2, HttpCacheStorage r3, CacheConfig r4) {
        this(r2, r3, r4, new CacheKeyGenerator());
    }

    public BasicHttpCache(CacheConfig r3) {
        this(new HeapResourceFactory(), new BasicHttpCacheStorage(r3), r3);
    }

    public BasicHttpCache() {
        this(CacheConfig.DEFAULT);
    }

    @Override // cz.msebera.android.httpclient.impl.client.cache.HttpCache
    public void flushCacheEntriesFor(HttpHost r3, HttpRequest r4) throws IOException {
        if (safeRequestMethods.contains(r4.getRequestLine().getMethod()) == true) goto L6;
        String r5 = this.uriExtractor.getURI(r3, r4);
        this.storage.removeEntry(r5);
        return;
    }

    @Override // cz.msebera.android.httpclient.impl.client.cache.HttpCache
    public void flushInvalidatedCacheEntriesFor(HttpHost r3, HttpRequest r4, HttpResponse r5) {
        if (safeRequestMethods.contains(r4.getRequestLine().getMethod()) == true) goto L6;
        this.cacheInvalidator.flushInvalidatedCacheEntries(r3, r4, r5);
        return;
    }

    void storeInCache(HttpHost r2, HttpRequest r3, HttpCacheEntry r4) throws IOException {
        if (r4.hasVariants() == false) goto L5;
        storeVariantEntry(r2, r3, r4);
        return;
    L5:
        storeNonVariantEntry(r2, r3, r4);
    }

    void storeNonVariantEntry(HttpHost r2, HttpRequest r3, HttpCacheEntry r4) throws IOException {
        String r5 = this.uriExtractor.getURI(r2, r3);
        this.storage.putEntry(r5, r4);
    }

    void storeVariantEntry(HttpHost r3, final HttpRequest r4, final HttpCacheEntry r5) throws IOException {
        String r0 = this.uriExtractor.getURI(r3, r4);
        final String r6 = this.uriExtractor.getVariantURI(r3, r4, r5);
        this.storage.putEntry(r6, r5);
        this.storage.updateEntry(r0, new AnonymousClass1(this, r4, r5, r6));     // Catch: HttpCacheUpdateException -> L5
        return;
    L5:
        e = move-exception;
        this.log.warn("Could not update key [" + r0 + "]", e);
    }

    @Override // cz.msebera.android.httpclient.impl.client.cache.HttpCache
    public void reuseVariantEntryFor(HttpHost r7, final HttpRequest r8, Variant r9) throws IOException {
        String r10 = this.uriExtractor.getURI(r7, r8);
        final HttpCacheEntry r3 = r9.getEntry();
        final String r4 = this.uriExtractor.getVariantKey(r8, r3);
        final String r5 = r9.getCacheKey();
        this.storage.updateEntry(r10, new AnonymousClass2(this, r8, r3, r4, r5));     // Catch: HttpCacheUpdateException -> L5
        return;
    L5:
        e = move-exception;
        this.log.warn("Could not update key [" + r10 + "]", e);
    }

    boolean isIncompleteResponse(HttpResponse r5, Resource r6) {
        int r4 = r5.getStatusLine().getStatusCode();
        if (r4 != 200) goto L5;
    L7:
        Header r7 = r5.getFirstHeader("Content-Length");
        if (r7 != null) goto L18;
        return false;
    L18:
        int r8 = Integer.parseInt(r7.getValue());     // Catch: NumberFormatException -> L17
        if (r6 != null) goto L14;
        return false;
    L14:
        if (r6.length() >= r8) goto L20;
        return true;
    L20:
        return false;
    L21:
        return false;
    L5:
        if (r4 == 206) goto L7;
        return false;
    }

    CloseableHttpResponse generateIncompleteResponseError(HttpResponse r5, Resource r6) {
        Integer r7 = Integer.valueOf(r5.getFirstHeader("Content-Length").getValue());
        BasicHttpResponse r0 = new BasicHttpResponse(HttpVersion.HTTP_1_1, 502, "Bad Gateway");
        r0.setHeader("Content-Type", "text/plain;charset=UTF-8");
        byte[] r8 = String.format("Received incomplete response with Content-Length %d but actual body length %d", new Object[]{r7, Long.valueOf(r6.length())}).getBytes();
        r0.setHeader("Content-Length", Integer.toString(r8.length));
        r0.setEntity(new ByteArrayEntity(r8));
        return Proxies.enhanceResponse(r0);
    }

    HttpCacheEntry doGetUpdatedParentEntry(String r9, HttpCacheEntry r10, HttpCacheEntry r11, String r12, String r13) throws IOException {
        if (r10 != null) goto L5;
        r10 = r11;
    L5:
        if (r10.getResource() == null) goto L7;
        Resource r8 = this.resourceFactory.copy(r9, r10.getResource());
    L8:
        Resource r5 = r8;
        HashMap r6 = new HashMap(r10.getVariantMap());
        r6.put(r12, r13);
        return new HttpCacheEntry(r10.getRequestDate(), r10.getResponseDate(), r10.getStatusLine(), r10.getAllHeaders(), r5, r6, r10.getRequestMethod());
    L7:
        r8 = null;
        goto L8
    }

    @Override // cz.msebera.android.httpclient.impl.client.cache.HttpCache
    public HttpCacheEntry updateCacheEntry(HttpHost r7, HttpRequest r8, HttpCacheEntry r9, HttpResponse r10, Date r11, Date r12) throws IOException {
        HttpCacheEntry r13 = this.cacheEntryUpdater.updateCacheEntry(r8.getRequestLine().getUri(), r9, r11, r12, r10);
        storeInCache(r7, r8, r13);
        return r13;
    }

    @Override // cz.msebera.android.httpclient.impl.client.cache.HttpCache
    public HttpCacheEntry updateVariantCacheEntry(HttpHost r7, HttpRequest r8, HttpCacheEntry r9, HttpResponse r10, Date r11, Date r12, String r13) throws IOException {
        HttpCacheEntry r14 = this.cacheEntryUpdater.updateCacheEntry(r8.getRequestLine().getUri(), r9, r11, r12, r10);
        this.storage.putEntry(r13, r14);
        return r14;
    }

    @Override // cz.msebera.android.httpclient.impl.client.cache.HttpCache
    public HttpResponse cacheAndReturnResponse(HttpHost r7, HttpRequest r8, HttpResponse r9, Date r10, Date r11) throws IOException {
        return cacheAndReturnResponse(r7, r8, Proxies.enhanceResponse(r9), r10, r11);
    }

    @Override // cz.msebera.android.httpclient.impl.client.cache.HttpCache
    public CloseableHttpResponse cacheAndReturnResponse(HttpHost r10, HttpRequest r11, CloseableHttpResponse r12, Date r13, Date r14) throws IOException {
        SizeLimitedResponseReader r0 = getResponseReader(r11, r12);
        boolean r1 = true;
        r0.readResponse();     // Catch: Throwable -> L17
        if (r0.isLimitReached() == true) goto L22;
        Resource r7 = r0.getResource();     // Catch: Throwable -> L17
        if (isIncompleteResponse(r12, r7) == false) goto L14;
        CloseableHttpResponse r9 = generateIncompleteResponseError(r12, r7);     // Catch: Throwable -> L17
        r12.close();
        return r9;
    L14:
        HttpCacheEntry r2 = new HttpCacheEntry(r13, r14, r12.getStatusLine(), r12.getAllHeaders(), r7, r11.getRequestLine().getMethod());     // Catch: Throwable -> L17
        storeInCache(r10, r11, r2);     // Catch: Throwable -> L17
        CloseableHttpResponse r15 = this.responseGenerator.generateResponse(HttpRequestWrapper.wrap(r11, r10), r2);     // Catch: Throwable -> L17
        r12.close();
        return r15;
    L22:
        return r0.getReconstructedResponse();
    L7:
        th = th;
        r1 = false;
    L18:
        if (r1 == false) goto L20;
        r12.close();
    L20:
        throw th;
    L17:
        th = th;
        goto L18
    }

    SizeLimitedResponseReader getResponseReader(HttpRequest r8, CloseableHttpResponse r9) {
        return new SizeLimitedResponseReader(this.resourceFactory, this.maxObjectSizeBytes, r8, r9);
    }

    @Override // cz.msebera.android.httpclient.impl.client.cache.HttpCache
    public HttpCacheEntry getCacheEntry(HttpHost r4, HttpRequest r5) throws IOException {
        HttpCacheEntry r6 = this.storage.getEntry(this.uriExtractor.getURI(r4, r5));
        if (r6 != null) goto L6;
        return null;
    L6:
        if (r6.hasVariants() == true) goto L8;
        return r6;
    L8:
        String r7 = r6.getVariantMap().get(this.uriExtractor.getVariantKey(r5, r6));
        if (r7 != null) goto L12;
        return null;
    L12:
        return this.storage.getEntry(r7);
    }

    @Override // cz.msebera.android.httpclient.impl.client.cache.HttpCache
    public void flushInvalidatedCacheEntriesFor(HttpHost r1, HttpRequest r2) throws IOException {
        this.cacheInvalidator.flushInvalidatedCacheEntries(r1, r2);
    }

    @Override // cz.msebera.android.httpclient.impl.client.cache.HttpCache
    public Map<String, Variant> getVariantCacheEntriesWithEtags(HttpHost r4, HttpRequest r5) throws IOException {
        HashMap r0 = new HashMap();
        HttpCacheEntry r6 = this.storage.getEntry(this.uriExtractor.getURI(r4, r5));
        if (r6 != null) goto L5;
    L11:
        return r0;
    L5:
        if (r6.hasVariants() == false) goto L11;
        Iterator<Map.Entry<String, String>> r7 = r6.getVariantMap().entrySet().iterator();
    L9:
        if (r7.hasNext() == false) goto L11;
        Map.Entry<String, String> r8 = r7.next();
        addVariantWithEtag(r8.getKey(), r8.getValue(), r0);
        goto L9
    }

    private void addVariantWithEtag(String r3, String r4, Map<String, Variant> r5) throws IOException {
        HttpCacheEntry r2 = this.storage.getEntry(r4);
        if (r2 != null) goto L5;
        return;
    L5:
        Header r0 = r2.getFirstHeader("ETag");
        if (r0 != null) goto L8;
        return;
    L8:
        r5.put(r0.getValue(), new Variant(r3, r4, r2));
    }
}
