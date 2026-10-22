package cz.msebera.android.httpclient.impl.client.cache;

import cz.msebera.android.httpclient.util.Args;

/* JADX INFO: loaded from: classes5.dex */
public class CacheConfig implements Cloneable {
    public static final CacheConfig DEFAULT = null;
    public static final boolean DEFAULT_303_CACHING_ENABLED = false;
    public static final int DEFAULT_ASYNCHRONOUS_WORKERS_CORE = 1;
    public static final int DEFAULT_ASYNCHRONOUS_WORKERS_MAX = 1;
    public static final int DEFAULT_ASYNCHRONOUS_WORKER_IDLE_LIFETIME_SECS = 60;
    public static final boolean DEFAULT_HEURISTIC_CACHING_ENABLED = false;
    public static final float DEFAULT_HEURISTIC_COEFFICIENT = 0.1f;
    public static final long DEFAULT_HEURISTIC_LIFETIME = 0;
    public static final int DEFAULT_MAX_CACHE_ENTRIES = 1000;
    public static final int DEFAULT_MAX_OBJECT_SIZE_BYTES = 8192;
    public static final int DEFAULT_MAX_UPDATE_RETRIES = 1;
    public static final int DEFAULT_REVALIDATION_QUEUE_SIZE = 100;
    public static final boolean DEFAULT_WEAK_ETAG_ON_PUTDELETE_ALLOWED = false;
    private final boolean allow303Caching;
    private int asynchronousWorkerIdleLifetimeSecs;
    private int asynchronousWorkersCore;
    private int asynchronousWorkersMax;
    private boolean heuristicCachingEnabled;
    private float heuristicCoefficient;
    private long heuristicDefaultLifetime;
    private boolean isSharedCache;
    private int maxCacheEntries;
    private long maxObjectSize;
    private int maxUpdateRetries;
    private boolean neverCacheHTTP10ResponsesWithQuery;
    private int revalidationQueueSize;
    private final boolean weakETagOnPutDeleteAllowed;

    public static class Builder {
        private boolean allow303Caching;
        private int asynchronousWorkerIdleLifetimeSecs;
        private int asynchronousWorkersCore;
        private int asynchronousWorkersMax;
        private boolean heuristicCachingEnabled;
        private float heuristicCoefficient;
        private long heuristicDefaultLifetime;
        private boolean isSharedCache;
        private int maxCacheEntries;
        private long maxObjectSize;
        private int maxUpdateRetries;
        private boolean neverCacheHTTP10ResponsesWithQuery;
        private int revalidationQueueSize;
        private boolean weakETagOnPutDeleteAllowed;

        Builder() {
            this.maxObjectSize = 8192;
            this.maxCacheEntries = 1000;
            this.maxUpdateRetries = 1;
            this.allow303Caching = false;
            this.weakETagOnPutDeleteAllowed = false;
            this.heuristicCachingEnabled = false;
            this.heuristicCoefficient = 0.1f;
            this.heuristicDefaultLifetime = 0;
            this.isSharedCache = true;
            this.asynchronousWorkersMax = 1;
            this.asynchronousWorkersCore = 1;
            this.asynchronousWorkerIdleLifetimeSecs = 60;
            this.revalidationQueueSize = 100;
        }

        public Builder setMaxObjectSize(long r1) {
            this.maxObjectSize = r1;
            return this;
        }

        public Builder setMaxCacheEntries(int r1) {
            this.maxCacheEntries = r1;
            return this;
        }

        public Builder setMaxUpdateRetries(int r1) {
            this.maxUpdateRetries = r1;
            return this;
        }

        public Builder setAllow303Caching(boolean r1) {
            this.allow303Caching = r1;
            return this;
        }

        public Builder setWeakETagOnPutDeleteAllowed(boolean r1) {
            this.weakETagOnPutDeleteAllowed = r1;
            return this;
        }

        public Builder setHeuristicCachingEnabled(boolean r1) {
            this.heuristicCachingEnabled = r1;
            return this;
        }

        public Builder setHeuristicCoefficient(float r1) {
            this.heuristicCoefficient = r1;
            return this;
        }

        public Builder setHeuristicDefaultLifetime(long r1) {
            this.heuristicDefaultLifetime = r1;
            return this;
        }

        public Builder setSharedCache(boolean r1) {
            this.isSharedCache = r1;
            return this;
        }

        public Builder setAsynchronousWorkersMax(int r1) {
            this.asynchronousWorkersMax = r1;
            return this;
        }

        public Builder setAsynchronousWorkersCore(int r1) {
            this.asynchronousWorkersCore = r1;
            return this;
        }

        public Builder setAsynchronousWorkerIdleLifetimeSecs(int r1) {
            this.asynchronousWorkerIdleLifetimeSecs = r1;
            return this;
        }

        public Builder setRevalidationQueueSize(int r1) {
            this.revalidationQueueSize = r1;
            return this;
        }

        public Builder setNeverCacheHTTP10ResponsesWithQueryString(boolean r1) {
            this.neverCacheHTTP10ResponsesWithQuery = r1;
            return this;
        }

        public CacheConfig build() {
            return new CacheConfig(this.maxObjectSize, this.maxCacheEntries, this.maxUpdateRetries, this.allow303Caching, this.weakETagOnPutDeleteAllowed, this.heuristicCachingEnabled, this.heuristicCoefficient, this.heuristicDefaultLifetime, this.isSharedCache, this.asynchronousWorkersMax, this.asynchronousWorkersCore, this.asynchronousWorkerIdleLifetimeSecs, this.revalidationQueueSize, this.neverCacheHTTP10ResponsesWithQuery);
        }
    }

    /* JADX INFO: renamed from: clone, reason: collision with other method in class */
    protected /* bridge */ /* synthetic */ Object m1503clone() throws CloneNotSupportedException {
        return clone();
    }

    static {
        DEFAULT = new Builder().build();
    }

    @Deprecated
    public CacheConfig() {
        this.maxObjectSize = 8192;
        this.maxCacheEntries = 1000;
        this.maxUpdateRetries = 1;
        this.allow303Caching = false;
        this.weakETagOnPutDeleteAllowed = false;
        this.heuristicCachingEnabled = false;
        this.heuristicCoefficient = 0.1f;
        this.heuristicDefaultLifetime = 0;
        this.isSharedCache = true;
        this.asynchronousWorkersMax = 1;
        this.asynchronousWorkersCore = 1;
        this.asynchronousWorkerIdleLifetimeSecs = 60;
        this.revalidationQueueSize = 100;
    }

    CacheConfig(long r4, int r6, int r7, boolean r8, boolean r9, boolean r10, float r11, long r12, boolean r14, int r15, int r16, int r17, int r18, boolean r19) {
        this.maxObjectSize = r4;
        this.maxCacheEntries = r6;
        this.maxUpdateRetries = r7;
        this.allow303Caching = r8;
        this.weakETagOnPutDeleteAllowed = r9;
        this.heuristicCachingEnabled = r10;
        this.heuristicCoefficient = r11;
        this.heuristicDefaultLifetime = r12;
        this.isSharedCache = r14;
        this.asynchronousWorkersMax = r15;
        this.asynchronousWorkersCore = r16;
        this.asynchronousWorkerIdleLifetimeSecs = r17;
        this.revalidationQueueSize = r18;
    }

    @Deprecated
    public int getMaxObjectSizeBytes() {
        long r0 = this.maxObjectSize;
        if (r0 <= 2147483647L) goto L6;
        return Integer.MAX_VALUE;
    L6:
        return (int) r0;
    }

    @Deprecated
    public void setMaxObjectSizeBytes(int r3) {
        if (r3 <= Integer.MAX_VALUE) goto L5;
        this.maxObjectSize = 2147483647L;
        return;
    L5:
        this.maxObjectSize = r3;
    }

    public long getMaxObjectSize() {
        return this.maxObjectSize;
    }

    @Deprecated
    public void setMaxObjectSize(long r1) {
        this.maxObjectSize = r1;
    }

    public boolean isNeverCacheHTTP10ResponsesWithQuery() {
        return this.neverCacheHTTP10ResponsesWithQuery;
    }

    public int getMaxCacheEntries() {
        return this.maxCacheEntries;
    }

    @Deprecated
    public void setMaxCacheEntries(int r1) {
        this.maxCacheEntries = r1;
    }

    public int getMaxUpdateRetries() {
        return this.maxUpdateRetries;
    }

    @Deprecated
    public void setMaxUpdateRetries(int r1) {
        this.maxUpdateRetries = r1;
    }

    public boolean is303CachingEnabled() {
        return this.allow303Caching;
    }

    public boolean isWeakETagOnPutDeleteAllowed() {
        return this.weakETagOnPutDeleteAllowed;
    }

    public boolean isHeuristicCachingEnabled() {
        return this.heuristicCachingEnabled;
    }

    @Deprecated
    public void setHeuristicCachingEnabled(boolean r1) {
        this.heuristicCachingEnabled = r1;
    }

    public float getHeuristicCoefficient() {
        return this.heuristicCoefficient;
    }

    @Deprecated
    public void setHeuristicCoefficient(float r1) {
        this.heuristicCoefficient = r1;
    }

    public long getHeuristicDefaultLifetime() {
        return this.heuristicDefaultLifetime;
    }

    @Deprecated
    public void setHeuristicDefaultLifetime(long r1) {
        this.heuristicDefaultLifetime = r1;
    }

    public boolean isSharedCache() {
        return this.isSharedCache;
    }

    @Deprecated
    public void setSharedCache(boolean r1) {
        this.isSharedCache = r1;
    }

    public int getAsynchronousWorkersMax() {
        return this.asynchronousWorkersMax;
    }

    @Deprecated
    public void setAsynchronousWorkersMax(int r1) {
        this.asynchronousWorkersMax = r1;
    }

    public int getAsynchronousWorkersCore() {
        return this.asynchronousWorkersCore;
    }

    @Deprecated
    public void setAsynchronousWorkersCore(int r1) {
        this.asynchronousWorkersCore = r1;
    }

    public int getAsynchronousWorkerIdleLifetimeSecs() {
        return this.asynchronousWorkerIdleLifetimeSecs;
    }

    @Deprecated
    public void setAsynchronousWorkerIdleLifetimeSecs(int r1) {
        this.asynchronousWorkerIdleLifetimeSecs = r1;
    }

    public int getRevalidationQueueSize() {
        return this.revalidationQueueSize;
    }

    @Deprecated
    public void setRevalidationQueueSize(int r1) {
        this.revalidationQueueSize = r1;
    }

    protected CacheConfig clone() throws CloneNotSupportedException {
        return (CacheConfig) super.clone();
    }

    public static Builder custom() {
        return new Builder();
    }

    public static Builder copy(CacheConfig r3) {
        Args.notNull(r3, "Cache config");
        return new Builder().setMaxObjectSize(r3.getMaxObjectSize()).setMaxCacheEntries(r3.getMaxCacheEntries()).setMaxUpdateRetries(r3.getMaxUpdateRetries()).setHeuristicCachingEnabled(r3.isHeuristicCachingEnabled()).setHeuristicCoefficient(r3.getHeuristicCoefficient()).setHeuristicDefaultLifetime(r3.getHeuristicDefaultLifetime()).setSharedCache(r3.isSharedCache()).setAsynchronousWorkersMax(r3.getAsynchronousWorkersMax()).setAsynchronousWorkersCore(r3.getAsynchronousWorkersCore()).setAsynchronousWorkerIdleLifetimeSecs(r3.getAsynchronousWorkerIdleLifetimeSecs()).setRevalidationQueueSize(r3.getRevalidationQueueSize()).setNeverCacheHTTP10ResponsesWithQueryString(r3.isNeverCacheHTTP10ResponsesWithQuery());
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder("[maxObjectSize=");
        r0.append(this.maxObjectSize).append(", maxCacheEntries=").append(this.maxCacheEntries).append(", maxUpdateRetries=").append(this.maxUpdateRetries).append(", 303CachingEnabled=").append(this.allow303Caching).append(", weakETagOnPutDeleteAllowed=").append(this.weakETagOnPutDeleteAllowed).append(", heuristicCachingEnabled=").append(this.heuristicCachingEnabled).append(", heuristicCoefficient=").append(this.heuristicCoefficient).append(", heuristicDefaultLifetime=").append(this.heuristicDefaultLifetime).append(", isSharedCache=").append(this.isSharedCache).append(", asynchronousWorkersMax=").append(this.asynchronousWorkersMax).append(", asynchronousWorkersCore=").append(this.asynchronousWorkersCore).append(", asynchronousWorkerIdleLifetimeSecs=").append(this.asynchronousWorkerIdleLifetimeSecs).append(", revalidationQueueSize=").append(this.revalidationQueueSize).append(", neverCacheHTTP10ResponsesWithQuery=").append(this.neverCacheHTTP10ResponsesWithQuery).append("]");
        return r0.toString();
    }
}
