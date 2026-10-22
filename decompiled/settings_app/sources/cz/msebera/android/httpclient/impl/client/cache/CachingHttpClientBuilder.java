package cz.msebera.android.httpclient.impl.client.cache;

import cz.msebera.android.httpclient.client.cache.HttpCacheInvalidator;
import cz.msebera.android.httpclient.client.cache.HttpCacheStorage;
import cz.msebera.android.httpclient.client.cache.ResourceFactory;
import cz.msebera.android.httpclient.impl.client.HttpClientBuilder;
import cz.msebera.android.httpclient.impl.execchain.ClientExecChain;
import java.io.File;

/* JADX INFO: loaded from: classes5.dex */
public class CachingHttpClientBuilder extends HttpClientBuilder {
    private CacheConfig cacheConfig;
    private File cacheDir;
    private boolean deleteCache;
    private HttpCacheInvalidator httpCacheInvalidator;
    private ResourceFactory resourceFactory;
    private SchedulingStrategy schedulingStrategy;
    private HttpCacheStorage storage;

    public static CachingHttpClientBuilder create() {
        return new CachingHttpClientBuilder();
    }

    protected CachingHttpClientBuilder() {
        this.deleteCache = true;
    }

    public final CachingHttpClientBuilder setResourceFactory(ResourceFactory r1) {
        this.resourceFactory = r1;
        return this;
    }

    public final CachingHttpClientBuilder setHttpCacheStorage(HttpCacheStorage r1) {
        this.storage = r1;
        return this;
    }

    public final CachingHttpClientBuilder setCacheDir(File r1) {
        this.cacheDir = r1;
        return this;
    }

    public final CachingHttpClientBuilder setCacheConfig(CacheConfig r1) {
        this.cacheConfig = r1;
        return this;
    }

    public final CachingHttpClientBuilder setSchedulingStrategy(SchedulingStrategy r1) {
        this.schedulingStrategy = r1;
        return this;
    }

    public final CachingHttpClientBuilder setHttpCacheInvalidator(HttpCacheInvalidator r1) {
        this.httpCacheInvalidator = r1;
        return this;
    }

    public CachingHttpClientBuilder setDeleteCache(boolean r1) {
        this.deleteCache = r1;
        return this;
    }

    @Override // cz.msebera.android.httpclient.impl.client.HttpClientBuilder
    protected ClientExecChain decorateMainExec(ClientExecChain r10) {
        CacheConfig r0 = this.cacheConfig;
        if (r0 != null) goto L6;
        r0 = CacheConfig.DEFAULT;
    L6:
        ResourceFactory r1 = this.resourceFactory;
        if (r1 == null) goto L9;
    L12:
        ResourceFactory r2 = r1;
        HttpCacheStorage r3 = this.storage;
        HttpCacheStorage r4 = r3;
        if (r3 == null) goto L15;
    L21:
        HttpCacheStorage r5 = r4;
        AsynchronousValidator r7 = createAsynchronousRevalidator(r0);
        CacheKeyGenerator r6 = new CacheKeyGenerator();
        HttpCacheInvalidator r9 = this.httpCacheInvalidator;
        if (r9 != null) goto L24;
        r9 = new CacheInvalidator(r6, r5);
    L24:
        CacheConfig r8 = r0;
        return new CachingExec(r10, new BasicHttpCache(r2, r5, r8, r6, r9), r0, r7);
    L15:
        if (this.cacheDir != null) goto L17;
        r4 = new BasicHttpCacheStorage(r0);
        goto L21
    L17:
        final ManagedHttpCacheStorage r11 = new ManagedHttpCacheStorage(r0);
        if (this.deleteCache == false) goto L20;
        addCloseable(new AnonymousClass1(this, r11));
        r4 = r11;
        goto L21
    L20:
        addCloseable(r11);
        r4 = r11;
        goto L21
    L9:
        if (this.cacheDir != null) goto L11;
        r1 = new HeapResourceFactory();
        goto L12
    L11:
        r1 = new FileResourceFactory(this.cacheDir);
        goto L12
    }

    private AsynchronousValidator createAsynchronousRevalidator(CacheConfig r2) {
        if (r2.getAsynchronousWorkersMax() <= 0) goto L6;
        AsynchronousValidator r0 = new AsynchronousValidator(createSchedulingStrategy(r2));
        addCloseable(r0);
        return r0;
    L6:
        return null;
    }

    private SchedulingStrategy createSchedulingStrategy(CacheConfig r1) {
        SchedulingStrategy r0 = this.schedulingStrategy;
        if (r0 == null) goto L6;
        return r0;
    L6:
        return new ImmediateSchedulingStrategy(r1);
    }
}
