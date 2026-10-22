package com.bumptech.glide;

import android.content.Context;
import androidx.collection.ArrayMap;
import com.bumptech.glide.load.engine.Engine;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPoolAdapter;
import com.bumptech.glide.load.engine.bitmap_recycle.LruArrayPool;
import com.bumptech.glide.load.engine.bitmap_recycle.LruBitmapPool;
import com.bumptech.glide.load.engine.cache.DiskCache;
import com.bumptech.glide.load.engine.cache.InternalCacheDiskCacheFactory;
import com.bumptech.glide.load.engine.cache.LruResourceCache;
import com.bumptech.glide.load.engine.cache.MemoryCache;
import com.bumptech.glide.load.engine.cache.MemorySizeCalculator;
import com.bumptech.glide.load.engine.executor.GlideExecutor;
import com.bumptech.glide.manager.ConnectivityMonitorFactory;
import com.bumptech.glide.manager.DefaultConnectivityMonitorFactory;
import com.bumptech.glide.manager.RequestManagerRetriever;
import com.bumptech.glide.module.AppGlideModule;
import com.bumptech.glide.module.GlideModule;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.util.Preconditions;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class GlideBuilder {
    private GlideExecutor animationExecutor;
    private ArrayPool arrayPool;
    private BitmapPool bitmapPool;
    private ConnectivityMonitorFactory connectivityMonitorFactory;
    private List<RequestListener<Object>> defaultRequestListeners;
    private Glide.RequestOptionsFactory defaultRequestOptionsFactory;
    private final Map<Class<?>, TransitionOptions<?, ?>> defaultTransitionOptions;
    private GlideExecutor diskCacheExecutor;
    private DiskCache.Factory diskCacheFactory;
    private Engine engine;
    private final GlideExperiments.Builder glideExperimentsBuilder;
    private boolean isActiveResourceRetentionAllowed;
    private int logLevel;
    private MemoryCache memoryCache;
    private MemorySizeCalculator memorySizeCalculator;
    private RequestManagerRetriever.RequestManagerFactory requestManagerFactory;
    private GlideExecutor sourceExecutor;

    static final class EnableImageDecoderForBitmaps implements GlideExperiments.Experiment {
        EnableImageDecoderForBitmaps() {
        }
    }

    public static final class LogRequestOrigins implements GlideExperiments.Experiment {
        public LogRequestOrigins() {
        }
    }

    static final class ManualOverrideHardwareBitmapMaxFdCount implements GlideExperiments.Experiment {
        final int fdCount;

        ManualOverrideHardwareBitmapMaxFdCount(int r1) {
            this.fdCount = r1;
        }
    }

    @Deprecated
    public GlideBuilder setDisableHardwareBitmapsOnO(boolean r1) {
        return this;
    }

    public GlideBuilder() {
        this.defaultTransitionOptions = new ArrayMap();
        this.glideExperimentsBuilder = new GlideExperiments.Builder();
        this.logLevel = 4;
        this.defaultRequestOptionsFactory = new AnonymousClass1(this);
    }

    public GlideBuilder setBitmapPool(BitmapPool r1) {
        this.bitmapPool = r1;
        return this;
    }

    public GlideBuilder setArrayPool(ArrayPool r1) {
        this.arrayPool = r1;
        return this;
    }

    public GlideBuilder setMemoryCache(MemoryCache r1) {
        this.memoryCache = r1;
        return this;
    }

    public GlideBuilder setDiskCache(DiskCache.Factory r1) {
        this.diskCacheFactory = r1;
        return this;
    }

    @Deprecated
    public GlideBuilder setResizeExecutor(GlideExecutor r1) {
        return setSourceExecutor(r1);
    }

    public GlideBuilder setSourceExecutor(GlideExecutor r1) {
        this.sourceExecutor = r1;
        return this;
    }

    public GlideBuilder setDiskCacheExecutor(GlideExecutor r1) {
        this.diskCacheExecutor = r1;
        return this;
    }

    public GlideBuilder setAnimationExecutor(GlideExecutor r1) {
        this.animationExecutor = r1;
        return this;
    }

    public GlideBuilder setDefaultRequestOptions(final RequestOptions r2) {
        return setDefaultRequestOptions(new AnonymousClass2(this, r2));
    }

    public GlideBuilder setDefaultRequestOptions(Glide.RequestOptionsFactory r1) {
        this.defaultRequestOptionsFactory = (Glide.RequestOptionsFactory) Preconditions.checkNotNull(r1);
        return this;
    }

    public <T> GlideBuilder setDefaultTransitionOptions(Class<T> r2, TransitionOptions<?, T> r3) {
        this.defaultTransitionOptions.put(r2, r3);
        return this;
    }

    public GlideBuilder setMemorySizeCalculator(MemorySizeCalculator.Builder r1) {
        return setMemorySizeCalculator(r1.build());
    }

    public GlideBuilder setMemorySizeCalculator(MemorySizeCalculator r1) {
        this.memorySizeCalculator = r1;
        return this;
    }

    public GlideBuilder setConnectivityMonitorFactory(ConnectivityMonitorFactory r1) {
        this.connectivityMonitorFactory = r1;
        return this;
    }

    public GlideBuilder setLogLevel(int r2) {
        if (r2 < 2) goto L9;
        if (r2 > 6) goto L9;
        this.logLevel = r2;
        return this;
    L9:
        throw new IllegalArgumentException("Log level must be one of Log.VERBOSE, Log.DEBUG, Log.INFO, Log.WARN, or Log.ERROR");
    }

    public GlideBuilder setIsActiveResourceRetentionAllowed(boolean r1) {
        this.isActiveResourceRetentionAllowed = r1;
        return this;
    }

    public GlideBuilder addGlobalRequestListener(RequestListener<Object> r2) {
        if (this.defaultRequestListeners != null) goto L5;
        this.defaultRequestListeners = new ArrayList();
    L5:
        this.defaultRequestListeners.add(r2);
        return this;
    }

    public GlideBuilder setLogRequestOrigins(boolean r3) {
        this.glideExperimentsBuilder.update(new LogRequestOrigins(), r3);
        return this;
    }

    public GlideBuilder setImageDecoderEnabledForBitmaps(boolean r3) {
        GlideExperiments.Builder r0 = this.glideExperimentsBuilder;
        EnableImageDecoderForBitmaps r1 = new EnableImageDecoderForBitmaps();
        if (r3 == false) goto L5;
        boolean r4 = true;
    L6:
        r0.update(r1, r4);
        return this;
    L5:
        r4 = false;
        goto L6
    }

    void setRequestManagerFactory(RequestManagerRetriever.RequestManagerFactory r1) {
        this.requestManagerFactory = r1;
    }

    GlideBuilder setEngine(Engine r1) {
        this.engine = r1;
        return this;
    }

    Glide build(Context r17, List<GlideModule> r18, AppGlideModule r19) {
        if (this.sourceExecutor != null) goto L6;
        this.sourceExecutor = GlideExecutor.newSourceExecutor();
    L6:
        if (this.diskCacheExecutor != null) goto L9;
        this.diskCacheExecutor = GlideExecutor.newDiskCacheExecutor();
    L9:
        if (this.animationExecutor != null) goto L12;
        this.animationExecutor = GlideExecutor.newAnimationExecutor();
    L12:
        if (this.memorySizeCalculator != null) goto L15;
        this.memorySizeCalculator = new MemorySizeCalculator.Builder(r17).build();
    L15:
        if (this.connectivityMonitorFactory != null) goto L18;
        this.connectivityMonitorFactory = new DefaultConnectivityMonitorFactory();
    L18:
        if (this.bitmapPool != null) goto L24;
        int r2 = this.memorySizeCalculator.getBitmapPoolSize();
        if (r2 <= 0) goto L22;
        this.bitmapPool = new LruBitmapPool(r2);
        goto L24
    L22:
        this.bitmapPool = new BitmapPoolAdapter();
    L24:
        if (this.arrayPool != null) goto L27;
        this.arrayPool = new LruArrayPool(this.memorySizeCalculator.getArrayPoolSizeInBytes());
    L27:
        if (this.memoryCache != null) goto L30;
        this.memoryCache = new LruResourceCache(this.memorySizeCalculator.getMemoryCacheSize());
    L30:
        if (this.diskCacheFactory != null) goto L33;
        this.diskCacheFactory = new InternalCacheDiskCacheFactory(r17);
    L33:
        if (this.engine != null) goto L35;
        this.engine = new Engine(this.memoryCache, this.diskCacheFactory, this.diskCacheExecutor, this.sourceExecutor, GlideExecutor.newUnlimitedSourceExecutor(), this.animationExecutor, this.isActiveResourceRetentionAllowed);
    L35:
        List<RequestListener<Object>> r3 = this.defaultRequestListeners;
        if (r3 != null) goto L38;
        this.defaultRequestListeners = Collections.emptyList();
    L39:
        GlideExperiments r14 = this.glideExperimentsBuilder.build();
        return new Glide(r17, this.engine, this.memoryCache, this.bitmapPool, this.arrayPool, new RequestManagerRetriever(this.requestManagerFactory), this.connectivityMonitorFactory, this.logLevel, this.defaultRequestOptionsFactory, this.defaultTransitionOptions, this.defaultRequestListeners, r18, r19, r14);
    L38:
        this.defaultRequestListeners = Collections.unmodifiableList(r3);
        goto L39
    }
}
