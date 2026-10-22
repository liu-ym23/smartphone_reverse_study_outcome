package com.bumptech.glide.load.engine;

import android.util.Log;
import androidx.core.util.Pools;
import com.bumptech.glide.GlideContext;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.cache.DiskCache;
import com.bumptech.glide.load.engine.cache.DiskCacheAdapter;
import com.bumptech.glide.load.engine.cache.MemoryCache;
import com.bumptech.glide.load.engine.executor.GlideExecutor;
import com.bumptech.glide.request.ResourceCallback;
import com.bumptech.glide.util.Executors;
import com.bumptech.glide.util.LogTime;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.pool.FactoryPools;
import java.util.Map;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes3.dex */
public class Engine implements EngineJobListener, MemoryCache.ResourceRemovedListener, EngineResource.ResourceListener {
    private static final int JOB_POOL_SIZE = 150;
    private static final String TAG = "Engine";
    private static final boolean VERBOSE_IS_LOGGABLE = false;
    private final ActiveResources activeResources;
    private final MemoryCache cache;
    private final DecodeJobFactory decodeJobFactory;
    private final LazyDiskCacheProvider diskCacheProvider;
    private final EngineJobFactory engineJobFactory;
    private final Jobs jobs;
    private final EngineKeyFactory keyFactory;
    private final ResourceRecycler resourceRecycler;

    static class DecodeJobFactory {
        private int creationOrder;
        final DecodeJob.DiskCacheProvider diskCacheProvider;
        final Pools.Pool<DecodeJob<?>> pool;

        DecodeJobFactory(DecodeJob.DiskCacheProvider r3) {
            this.pool = FactoryPools.threadSafe(150, new AnonymousClass1(this));
            this.diskCacheProvider = r3;
        }

        <R> DecodeJob<R> build(GlideContext r20, Object r21, EngineKey r22, Key r23, int r24, int r25, Class<?> r26, Class<R> r27, Priority r28, DiskCacheStrategy r29, Map<Class<?>, Transformation<?>> r30, boolean r31, boolean r32, boolean r33, Options r34, DecodeJob.Callback<R> r35) {
            DecodeJob r1 = (DecodeJob) Preconditions.checkNotNull(this.pool.acquire());
            int r2 = this.creationOrder;
            this.creationOrder = r2 + 1;
            return r1.init(r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r2);
        }
    }

    static class EngineJobFactory {
        final GlideExecutor animationExecutor;
        final GlideExecutor diskCacheExecutor;
        final EngineJobListener engineJobListener;
        final Pools.Pool<EngineJob<?>> pool;
        final EngineResource.ResourceListener resourceListener;
        final GlideExecutor sourceExecutor;
        final GlideExecutor sourceUnlimitedExecutor;

        EngineJobFactory(GlideExecutor r3, GlideExecutor r4, GlideExecutor r5, GlideExecutor r6, EngineJobListener r7, EngineResource.ResourceListener r8) {
            this.pool = FactoryPools.threadSafe(150, new AnonymousClass1(this));
            this.diskCacheExecutor = r3;
            this.sourceExecutor = r4;
            this.sourceUnlimitedExecutor = r5;
            this.animationExecutor = r6;
            this.engineJobListener = r7;
            this.resourceListener = r8;
        }

        void shutdown() {
            Executors.shutdownAndAwaitTermination(this.diskCacheExecutor);
            Executors.shutdownAndAwaitTermination(this.sourceExecutor);
            Executors.shutdownAndAwaitTermination(this.sourceUnlimitedExecutor);
            Executors.shutdownAndAwaitTermination(this.animationExecutor);
        }

        <R> EngineJob<R> build(Key r7, boolean r8, boolean r9, boolean r10, boolean r11) {
            return ((EngineJob) Preconditions.checkNotNull(this.pool.acquire())).init(r7, r8, r9, r10, r11);
        }
    }

    private static class LazyDiskCacheProvider implements DecodeJob.DiskCacheProvider {
        private volatile DiskCache diskCache;
        private final DiskCache.Factory factory;

        LazyDiskCacheProvider(DiskCache.Factory r1) {
            this.factory = r1;
        }

        synchronized void clearDiskCacheIfCreated() {
            monitor-enter(this);
        L10:
            th = move-exception;
            throw th;
        L4:
            if (this.diskCache != null) goto L7;
            monitor-exit(this);
            return;
        L7:
            this.diskCache.clear();     // Catch: Throwable -> L10
            monitor-exit(this);
        }

        @Override // com.bumptech.glide.load.engine.DecodeJob.DiskCacheProvider
        public DiskCache getDiskCache() {
            if (this.diskCache != null) goto L17;
            monitor-enter(this);
        L13:
            th = move-exception;
            throw th;
        L6:
            if (this.diskCache != null) goto L9;
            this.diskCache = this.factory.build();     // Catch: Throwable -> L13
        L9:
            if (this.diskCache != null) goto L11;
            this.diskCache = new DiskCacheAdapter();     // Catch: Throwable -> L13
        L11:
            monitor-exit(this);     // Catch: Throwable -> L13
        L17:
            return this.diskCache;
        }
    }

    public class LoadStatus {
        private final ResourceCallback cb;
        private final EngineJob<?> engineJob;
        final /* synthetic */ Engine this$0;

        LoadStatus(Engine r1, ResourceCallback r2, EngineJob<?> r3) {
            this.this$0 = r1;
            this.cb = r2;
            this.engineJob = r3;
        }

        public void cancel() {
            Engine r0 = this.this$0;
            monitor-enter(r0);
            this.engineJob.removeCallback(this.cb);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }
    }

    static {
        VERBOSE_IS_LOGGABLE = Log.isLoggable(TAG, 2);
    }

    public Engine(MemoryCache r15, DiskCache.Factory r16, GlideExecutor r17, GlideExecutor r18, GlideExecutor r19, GlideExecutor r20, boolean r21) {
        this(r15, r16, r17, r18, r19, r20, null, null, null, null, null, null, r21);
    }

    Engine(MemoryCache r12, DiskCache.Factory r13, GlideExecutor r14, GlideExecutor r15, GlideExecutor r16, GlideExecutor r17, Jobs r18, EngineKeyFactory r19, ActiveResources r20, EngineJobFactory r21, DecodeJobFactory r22, ResourceRecycler r23, boolean r24) {
        this.cache = r12;
        LazyDiskCacheProvider r9 = new LazyDiskCacheProvider(r13);
        this.diskCacheProvider = r9;
        if (r20 != null) goto L5;
        ActiveResources r0 = new ActiveResources(r24);
    L6:
        this.activeResources = r0;
        r0.setListener(this);
        if (r19 != null) goto L9;
        EngineKeyFactory r1 = new EngineKeyFactory();
    L10:
        this.keyFactory = r1;
        if (r18 != null) goto L13;
        Jobs r2 = new Jobs();
    L14:
        this.jobs = r2;
        if (r21 != null) goto L17;
        EngineJobFactory r10 = new EngineJobFactory(r14, r15, r16, r17, this, this);
    L18:
        this.engineJobFactory = r10;
        if (r22 != null) goto L21;
        DecodeJobFactory r3 = new DecodeJobFactory(r9);
    L22:
        this.decodeJobFactory = r3;
        if (r23 != null) goto L25;
        ResourceRecycler r4 = new ResourceRecycler();
    L26:
        this.resourceRecycler = r4;
        r12.setResourceRemovedListener(this);
        return;
    L25:
        r4 = r23;
        goto L26
    L21:
        r3 = r22;
        goto L22
    L17:
        r10 = r21;
        goto L18
    L13:
        r2 = r18;
        goto L14
    L9:
        r1 = r19;
        goto L10
    L5:
        r0 = r20;
        goto L6
    }

    public <R> LoadStatus load(GlideContext r25, Object r26, Key r27, int r28, int r29, Class<?> r30, Class<R> r31, Priority r32, DiskCacheStrategy r33, Map<Class<?>, Transformation<?>> r34, boolean r35, boolean r36, Options r37, boolean r38, boolean r39, boolean r40, boolean r41, ResourceCallback r42, Executor r43) {
        if (VERBOSE_IS_LOGGABLE == false) goto L5;
        long r0 = LogTime.getLogTime();
    L6:
        long r13 = r0;
        EngineKey r1 = this.keyFactory.buildKey(r26, r27, r28, r29, r34, r30, r31, r37);
        monitor-enter(this);
        EngineResource<?> r2 = loadFromMemory(r1, r38, r13);     // Catch: Throwable -> L17
        if (r2 != null) goto L14;
        LoadStatus r3 = waitForExistingOrStartNewJob(r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r1, r13);     // Catch: Throwable -> L17
        monitor-exit(this);     // Catch: Throwable -> L17
        return r3;
    L14:
        monitor-exit(this);     // Catch: Throwable -> L17
        r42.onResourceReady(r2, DataSource.MEMORY_CACHE, false);
        return null;
    L17:
        th = move-exception;
        throw th;
    L5:
        r0 = 0;
        goto L6
    }

    private <R> LoadStatus waitForExistingOrStartNewJob(GlideContext r21, Object r22, Key r23, int r24, int r25, Class<?> r26, Class<R> r27, Priority r28, DiskCacheStrategy r29, Map<Class<?>, Transformation<?>> r30, boolean r31, boolean r32, Options r33, boolean r34, boolean r35, boolean r36, boolean r37, ResourceCallback r38, Executor r39, EngineKey r40, long r41) {
        EngineJob<?> r3 = this.jobs.get(r40, r37);
        if (r3 == null) goto L9;
        r3.addCallback(r38, r39);
        if (VERBOSE_IS_LOGGABLE == false) goto L8;
        logWithTimeAndKey("Added to existing load", r41, r40);
    L8:
        return new LoadStatus(this, r38, r3);
    L9:
        EngineJob<R> r11 = this.engineJobFactory.build(r40, r34, r35, r36, r37);
        DecodeJob<R> r4 = this.decodeJobFactory.build(r21, r22, r40, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r37, r33, r11);
        this.jobs.put(r40, r11);
        r11.addCallback(r38, r39);
        r11.start(r4);
        if (VERBOSE_IS_LOGGABLE == false) goto L13;
        logWithTimeAndKey("Started new load", r41, r40);
    L13:
        return new LoadStatus(this, r38, r11);
    }

    private EngineResource<?> loadFromMemory(EngineKey r2, boolean r3, long r4) {
        if (r3 == true) goto L5;
        return null;
    L5:
        EngineResource<?> r5 = loadFromActiveResources(r2);
        if (r5 != null) goto L8;
        EngineResource<?> r1 = loadFromCache(r2);
        if (r1 != null) goto L14;
        return null;
    L14:
        if (VERBOSE_IS_LOGGABLE == false) goto L16;
        logWithTimeAndKey("Loaded resource from cache", r4, r2);
    L16:
        return r1;
    L8:
        if (VERBOSE_IS_LOGGABLE == false) goto L10;
        logWithTimeAndKey("Loaded resource from active resources", r4, r2);
    L10:
        return r5;
    }

    private static void logWithTimeAndKey(String r1, long r2, Key r4) {
        Log.v(TAG, r1 + " in " + LogTime.getElapsedMillis(r2) + "ms, key: " + r4);
    }

    private EngineResource<?> loadFromActiveResources(Key r1) {
        EngineResource<?> r0 = this.activeResources.get(r1);
        if (r0 == null) goto L5;
        r0.acquire();
    L5:
        return r0;
    }

    private EngineResource<?> loadFromCache(Key r2) {
        EngineResource<?> r0 = getEngineResourceFromCache(r2);
        if (r0 == null) goto L5;
        r0.acquire();
        this.activeResources.activate(r2, r0);
    L5:
        return r0;
    }

    private EngineResource<?> getEngineResourceFromCache(Key r8) {
        Resource<?> r2 = this.cache.remove(r8);
        if (r2 != null) goto L6;
        return null;
    L6:
        if ((r2 instanceof EngineResource) == false) goto L9;
        return (EngineResource) r2;
    L9:
        return new EngineResource(r2, true, true, r8, this);
    }

    public void release(Resource<?> r1) {
        if ((r1 instanceof EngineResource) == false) goto L7;
        ((EngineResource) r1).release();
        return;
    L7:
        throw new IllegalArgumentException("Cannot release anything but an EngineResource");
    }

    @Override // com.bumptech.glide.load.engine.EngineJobListener
    public synchronized void onEngineJobComplete(EngineJob<?> r2, Key r3, EngineResource<?> r4) {
        monitor-enter(this);
        if (r4 != null) goto L13;
    L7:
        this.jobs.removeIfCurrent(r3, r2);     // Catch: Throwable -> L10
        monitor-exit(this);
        return;
    L10:
        th = move-exception;
        throw th;
    L13:
        if (r4.isMemoryCacheable() == false) goto L7;
        this.activeResources.activate(r3, r4);     // Catch: Throwable -> L10
        goto L7
    }

    @Override // com.bumptech.glide.load.engine.EngineJobListener
    public synchronized void onEngineJobCancelled(EngineJob<?> r2, Key r3) {
        monitor-enter(this);
        this.jobs.removeIfCurrent(r3, r2);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.bumptech.glide.load.engine.cache.MemoryCache.ResourceRemovedListener
    public void onResourceRemoved(Resource<?> r2) {
        this.resourceRecycler.recycle(r2, true);
    }

    @Override // com.bumptech.glide.load.engine.EngineResource.ResourceListener
    public void onResourceReleased(Key r2, EngineResource<?> r3) {
        this.activeResources.deactivate(r2);
        if (r3.isMemoryCacheable() == false) goto L5;
        this.cache.put(r2, r3);
        return;
    L5:
        this.resourceRecycler.recycle(r3, false);
    }

    public void clearDiskCache() {
        this.diskCacheProvider.getDiskCache().clear();
    }

    public void shutdown() {
        this.engineJobFactory.shutdown();
        this.diskCacheProvider.clearDiskCacheIfCreated();
        this.activeResources.shutdown();
    }
}
