package com.bumptech.glide.load.engine;

import androidx.core.util.Pools;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.executor.GlideExecutor;
import com.bumptech.glide.request.ResourceCallback;
import com.bumptech.glide.util.Executors;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.pool.FactoryPools;
import com.bumptech.glide.util.pool.StateVerifier;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes3.dex */
class EngineJob<R> implements DecodeJob.Callback<R>, FactoryPools.Poolable {
    private static final EngineResourceFactory DEFAULT_FACTORY = null;
    private final GlideExecutor animationExecutor;
    final ResourceCallbacksAndExecutors cbs;
    DataSource dataSource;
    private DecodeJob<R> decodeJob;
    private final GlideExecutor diskCacheExecutor;
    private final EngineJobListener engineJobListener;
    EngineResource<?> engineResource;
    private final EngineResourceFactory engineResourceFactory;
    GlideException exception;
    private boolean hasLoadFailed;
    private boolean hasResource;
    private boolean isCacheable;
    private volatile boolean isCancelled;
    private boolean isLoadedFromAlternateCacheKey;
    private Key key;
    private boolean onlyRetrieveFromCache;
    private final AtomicInteger pendingCallbacks;
    private final Pools.Pool<EngineJob<?>> pool;
    private Resource<?> resource;
    private final EngineResource.ResourceListener resourceListener;
    private final GlideExecutor sourceExecutor;
    private final GlideExecutor sourceUnlimitedExecutor;
    private final StateVerifier stateVerifier;
    private boolean useAnimationPool;
    private boolean useUnlimitedSourceGeneratorPool;

    private class CallLoadFailed implements Runnable {
        private final ResourceCallback cb;
        final /* synthetic */ EngineJob this$0;

        CallLoadFailed(EngineJob r1, ResourceCallback r2) {
            this.this$0 = r1;
            this.cb = r2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Object r0 = this.cb.getLock();
            monitor-enter(r0);
            EngineJob r1 = this.this$0;     // Catch: Throwable -> L16
            monitor-enter(r1);     // Catch: Throwable -> L16
        L13:
            th = move-exception;
            throw th;     // Catch: Throwable -> L16
        L7:
            if (this.this$0.cbs.contains(this.cb) == false) goto L9;
            this.this$0.callCallbackOnLoadFailed(this.cb);     // Catch: Throwable -> L13
        L9:
            this.this$0.decrementPendingCallbacks();     // Catch: Throwable -> L13
            monitor-exit(r1);     // Catch: Throwable -> L13
            monitor-exit(r0);     // Catch: Throwable -> L16
            return;
        L16:
            th = move-exception;
            throw th;
        }
    }

    private class CallResourceReady implements Runnable {
        private final ResourceCallback cb;
        final /* synthetic */ EngineJob this$0;

        CallResourceReady(EngineJob r1, ResourceCallback r2) {
            this.this$0 = r1;
            this.cb = r2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Object r0 = this.cb.getLock();
            monitor-enter(r0);
            EngineJob r1 = this.this$0;     // Catch: Throwable -> L16
            monitor-enter(r1);     // Catch: Throwable -> L16
        L13:
            th = move-exception;
            throw th;     // Catch: Throwable -> L16
        L7:
            if (this.this$0.cbs.contains(this.cb) == false) goto L9;
            this.this$0.engineResource.acquire();     // Catch: Throwable -> L13
            this.this$0.callCallbackOnResourceReady(this.cb);     // Catch: Throwable -> L13
            this.this$0.removeCallback(this.cb);     // Catch: Throwable -> L13
        L9:
            this.this$0.decrementPendingCallbacks();     // Catch: Throwable -> L13
            monitor-exit(r1);     // Catch: Throwable -> L13
            monitor-exit(r0);     // Catch: Throwable -> L16
            return;
        L16:
            th = move-exception;
            throw th;
        }
    }

    static class EngineResourceFactory {
        EngineResourceFactory() {
        }

        public <R> EngineResource<R> build(Resource<R> r7, boolean r8, Key r9, EngineResource.ResourceListener r10) {
            return new EngineResource(r7, r8, true, r9, r10);
        }
    }

    static final class ResourceCallbackAndExecutor {
        final ResourceCallback cb;
        final Executor executor;

        ResourceCallbackAndExecutor(ResourceCallback r1, Executor r2) {
            this.cb = r1;
            this.executor = r2;
        }

        public boolean equals(Object r2) {
            if ((r2 instanceof ResourceCallbackAndExecutor) == true) goto L5;
            return false;
        L5:
            return this.cb.equals(((ResourceCallbackAndExecutor) r2).cb);
        }

        public int hashCode() {
            return this.cb.hashCode();
        }
    }

    static final class ResourceCallbacksAndExecutors implements Iterable<ResourceCallbackAndExecutor> {
        private final List<ResourceCallbackAndExecutor> callbacksAndExecutors;

        ResourceCallbacksAndExecutors() {
            this(new ArrayList(2));
        }

        ResourceCallbacksAndExecutors(List<ResourceCallbackAndExecutor> r1) {
            this.callbacksAndExecutors = r1;
        }

        void add(ResourceCallback r2, Executor r3) {
            this.callbacksAndExecutors.add(new ResourceCallbackAndExecutor(r2, r3));
        }

        void remove(ResourceCallback r1) {
            this.callbacksAndExecutors.remove(defaultCallbackAndExecutor(r1));
        }

        boolean contains(ResourceCallback r1) {
            return this.callbacksAndExecutors.contains(defaultCallbackAndExecutor(r1));
        }

        boolean isEmpty() {
            return this.callbacksAndExecutors.isEmpty();
        }

        int size() {
            return this.callbacksAndExecutors.size();
        }

        void clear() {
            this.callbacksAndExecutors.clear();
        }

        ResourceCallbacksAndExecutors copy() {
            return new ResourceCallbacksAndExecutors(new ArrayList(this.callbacksAndExecutors));
        }

        private static ResourceCallbackAndExecutor defaultCallbackAndExecutor(ResourceCallback r2) {
            return new ResourceCallbackAndExecutor(r2, Executors.directExecutor());
        }

        @Override // java.lang.Iterable
        public Iterator<ResourceCallbackAndExecutor> iterator() {
            return this.callbacksAndExecutors.iterator();
        }
    }

    static {
        DEFAULT_FACTORY = new EngineResourceFactory();
    }

    EngineJob(GlideExecutor r10, GlideExecutor r11, GlideExecutor r12, GlideExecutor r13, EngineJobListener r14, EngineResource.ResourceListener r15, Pools.Pool<EngineJob<?>> r16) {
        this(r10, r11, r12, r13, r14, r15, r16, DEFAULT_FACTORY);
    }

    EngineJob(GlideExecutor r2, GlideExecutor r3, GlideExecutor r4, GlideExecutor r5, EngineJobListener r6, EngineResource.ResourceListener r7, Pools.Pool<EngineJob<?>> r8, EngineResourceFactory r9) {
        this.cbs = new ResourceCallbacksAndExecutors();
        this.stateVerifier = StateVerifier.newInstance();
        this.pendingCallbacks = new AtomicInteger();
        this.diskCacheExecutor = r2;
        this.sourceExecutor = r3;
        this.sourceUnlimitedExecutor = r4;
        this.animationExecutor = r5;
        this.engineJobListener = r6;
        this.resourceListener = r7;
        this.pool = r8;
        this.engineResourceFactory = r9;
    }

    synchronized EngineJob<R> init(Key r1, boolean r2, boolean r3, boolean r4, boolean r5) {
        monitor-enter(this);
        this.key = r1;     // Catch: Throwable -> L6
        this.isCacheable = r2;     // Catch: Throwable -> L6
        this.useUnlimitedSourceGeneratorPool = r3;     // Catch: Throwable -> L6
        this.useAnimationPool = r4;     // Catch: Throwable -> L6
        this.onlyRetrieveFromCache = r5;     // Catch: Throwable -> L6
        monitor-exit(this);
        return this;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized void start(DecodeJob<R> r2) {
        monitor-enter(this);
        this.decodeJob = r2;     // Catch: Throwable -> L10
        if (r2.willDecodeFromCache() == false) goto L6;
        GlideExecutor r0 = this.diskCacheExecutor;     // Catch: Throwable -> L10
    L7:
        r0.execute(r2);     // Catch: Throwable -> L10
        monitor-exit(this);
        return;
    L6:
        r0 = getActiveSourceExecutor();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    synchronized void addCallback(ResourceCallback r3, Executor r4) {
        monitor-enter(this);
        this.stateVerifier.throwIfRecycled();     // Catch: Throwable -> L16
        this.cbs.add(r3, r4);     // Catch: Throwable -> L16
        boolean r1 = true;
        if (this.hasResource == false) goto L7;
        incrementPendingCallbacks(1);     // Catch: Throwable -> L16
        r4.execute(new CallResourceReady(this, r3));     // Catch: Throwable -> L16
    L14:
        monitor-exit(this);
        return;
    L7:
        if (this.hasLoadFailed == false) goto L10;
        incrementPendingCallbacks(1);     // Catch: Throwable -> L16
        r4.execute(new CallLoadFailed(this, r3));     // Catch: Throwable -> L16
        goto L14
    L10:
        if (this.isCancelled == false) goto L13;
        r1 = false;
    L13:
        Preconditions.checkArgument(r1, "Cannot add callbacks to a cancelled EngineJob");     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        throw th;
    }

    void callCallbackOnResourceReady(ResourceCallback r3) {
        r3.onResourceReady(this.engineResource, this.dataSource, this.isLoadedFromAlternateCacheKey);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        throw new CallbackException(th);
    }

    void callCallbackOnLoadFailed(ResourceCallback r1) {
        r1.onLoadFailed(this.exception);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        throw new CallbackException(th);
    }

    synchronized void removeCallback(ResourceCallback r2) {
        monitor-enter(this);
        this.stateVerifier.throwIfRecycled();     // Catch: Throwable -> L18
        this.cbs.remove(r2);     // Catch: Throwable -> L18
        if (this.cbs.isEmpty() == false) goto L16;
        cancel();     // Catch: Throwable -> L18
        if (this.hasResource == false) goto L8;
    L11:
        boolean r3 = true;
    L12:
        if (r3 == false) goto L16;
        if (this.pendingCallbacks.get() != 0) goto L16;
        release();     // Catch: Throwable -> L18
        goto L16
    L8:
        if (this.hasLoadFailed == true) goto L11;
        r3 = false;
    L16:
        monitor-exit(this);
        return;
    L18:
        th = move-exception;
        throw th;
    }

    boolean onlyRetrieveFromCache() {
        return this.onlyRetrieveFromCache;
    }

    private GlideExecutor getActiveSourceExecutor() {
        if (this.useUnlimitedSourceGeneratorPool == false) goto L6;
        return this.sourceUnlimitedExecutor;
    L6:
        if (this.useAnimationPool == false) goto L9;
        return this.animationExecutor;
    L9:
        return this.sourceExecutor;
    }

    void cancel() {
        if (isDone() == false) goto L5;
        return;
    L5:
        this.isCancelled = true;
        this.decodeJob.cancel();
        this.engineJobListener.onEngineJobCancelled(this, this.key);
    }

    synchronized boolean isCancelled() {
        monitor-enter(this);
        boolean r0 = this.isCancelled;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    private boolean isDone() {
        if (this.hasLoadFailed == false) goto L5;
    L10:
        return true;
    L5:
        if (this.hasResource == true) goto L10;
        if (this.isCancelled == true) goto L10;
        return false;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    void notifyCallbacksOfResult() {
        monitor-enter(this);
        this.stateVerifier.throwIfRecycled();     // Catch: Throwable -> L24
        if (this.isCancelled == false) goto L9;
        this.resource.recycle();     // Catch: Throwable -> L24
        release();     // Catch: Throwable -> L24
        monitor-exit(this);     // Catch: Throwable -> L24
        return;
    L9:
        if (this.cbs.isEmpty() == true) goto L23;
        if (this.hasResource == true) goto L21;
        this.engineResource = this.engineResourceFactory.build(this.resource, this.isCacheable, this.key, this.resourceListener);     // Catch: Throwable -> L24
        this.hasResource = true;     // Catch: Throwable -> L24
        ResourceCallbacksAndExecutors r1 = this.cbs.copy();     // Catch: Throwable -> L24
        incrementPendingCallbacks(r1.size() + 1);     // Catch: Throwable -> L24
        Key r0 = this.key;     // Catch: Throwable -> L24
        EngineResource<?> r2 = this.engineResource;     // Catch: Throwable -> L24
        monitor-exit(this);     // Catch: Throwable -> L24
        this.engineJobListener.onEngineJobComplete(this, r0, r2);
        Iterator<ResourceCallbackAndExecutor> r3 = r1.iterator();
    L16:
        if (r3.hasNext() == false) goto L18;
        ResourceCallbackAndExecutor r4 = r3.next();
        r4.executor.execute(new CallResourceReady(this, r4.cb));
        goto L16
    L18:
        decrementPendingCallbacks();
        return;
    L21:
        throw new IllegalStateException("Already have resource");     // Catch: Throwable -> L24
    L23:
        throw new IllegalStateException("Received a resource without any callbacks to notify");     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        throw th;
    }

    synchronized void incrementPendingCallbacks(int r3) {
        monitor-enter(this);
        Preconditions.checkArgument(isDone(), "Not yet complete!");     // Catch: Throwable -> L10
        if (this.pendingCallbacks.getAndAdd(r3) != 0) goto L8;
        EngineResource<?> r4 = this.engineResource;     // Catch: Throwable -> L10
        if (r4 == null) goto L8;
        r4.acquire();     // Catch: Throwable -> L10
    L8:
        monitor-exit(this);
        return;
    L10:
        th = move-exception;
        throw th;
    }

    void decrementPendingCallbacks() {
        monitor-enter(this);
        this.stateVerifier.throwIfRecycled();     // Catch: Throwable -> L15
        Preconditions.checkArgument(isDone(), "Not yet complete!");     // Catch: Throwable -> L15
        int r0 = this.pendingCallbacks.decrementAndGet();     // Catch: Throwable -> L15
        if (r0 < 0) goto L6;
        boolean r1 = true;
    L7:
        Preconditions.checkArgument(r1, "Can't decrement below 0");     // Catch: Throwable -> L15
        if (r0 != 0) goto L10;
        EngineResource<?> r2 = this.engineResource;     // Catch: Throwable -> L15
        release();     // Catch: Throwable -> L15
    L11:
        monitor-exit(this);     // Catch: Throwable -> L15
        if (r2 == null) goto L20;
        r2.release();
        return;
    L20:
        return;
    L10:
        r2 = null;
        goto L11
    L6:
        r1 = false;
    L15:
        th = move-exception;
        throw th;
    }

    private synchronized void release() {
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L4:
        if (this.key == null) goto L9;
        this.cbs.clear();     // Catch: Throwable -> L10
        this.key = null;     // Catch: Throwable -> L10
        this.engineResource = null;     // Catch: Throwable -> L10
        this.resource = null;     // Catch: Throwable -> L10
        this.hasLoadFailed = false;     // Catch: Throwable -> L10
        this.isCancelled = false;     // Catch: Throwable -> L10
        this.hasResource = false;     // Catch: Throwable -> L10
        this.isLoadedFromAlternateCacheKey = false;     // Catch: Throwable -> L10
        this.decodeJob.release(false);     // Catch: Throwable -> L10
        this.decodeJob = null;     // Catch: Throwable -> L10
        this.exception = null;     // Catch: Throwable -> L10
        this.dataSource = null;     // Catch: Throwable -> L10
        this.pool.release(this);     // Catch: Throwable -> L10
        monitor-exit(this);
        return;
    L9:
        throw new IllegalArgumentException();     // Catch: Throwable -> L10
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bumptech.glide.load.engine.DecodeJob.Callback
    public void onResourceReady(Resource<R> r1, DataSource r2, boolean r3) {
        monitor-enter(this);
        this.resource = r1;     // Catch: Throwable -> L7
        this.dataSource = r2;     // Catch: Throwable -> L7
        this.isLoadedFromAlternateCacheKey = r3;     // Catch: Throwable -> L7
        monitor-exit(this);     // Catch: Throwable -> L7
        notifyCallbacksOfResult();
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.bumptech.glide.load.engine.DecodeJob.Callback
    public void onLoadFailed(GlideException r1) {
        monitor-enter(this);
        this.exception = r1;     // Catch: Throwable -> L7
        monitor-exit(this);     // Catch: Throwable -> L7
        notifyCallbacksOfException();
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.bumptech.glide.load.engine.DecodeJob.Callback
    public void reschedule(DecodeJob<?> r1) {
        getActiveSourceExecutor().execute(r1);
    }

    void notifyCallbacksOfException() {
        monitor-enter(this);
        this.stateVerifier.throwIfRecycled();     // Catch: Throwable -> L24
        if (this.isCancelled == false) goto L9;
        release();     // Catch: Throwable -> L24
        monitor-exit(this);     // Catch: Throwable -> L24
        return;
    L9:
        if (this.cbs.isEmpty() == true) goto L23;
        if (this.hasLoadFailed == true) goto L21;
        this.hasLoadFailed = true;     // Catch: Throwable -> L24
        Key r1 = this.key;     // Catch: Throwable -> L24
        ResourceCallbacksAndExecutors r2 = this.cbs.copy();     // Catch: Throwable -> L24
        incrementPendingCallbacks(r2.size() + 1);     // Catch: Throwable -> L24
        monitor-exit(this);     // Catch: Throwable -> L24
        this.engineJobListener.onEngineJobComplete(this, r1, null);
        Iterator<ResourceCallbackAndExecutor> r0 = r2.iterator();
    L16:
        if (r0.hasNext() == false) goto L18;
        ResourceCallbackAndExecutor r3 = r0.next();
        r3.executor.execute(new CallLoadFailed(this, r3.cb));
        goto L16
    L18:
        decrementPendingCallbacks();
        return;
    L21:
        throw new IllegalStateException("Already failed once");     // Catch: Throwable -> L24
    L23:
        throw new IllegalStateException("Received an exception without any callbacks to notify");     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        throw th;
    }

    @Override // com.bumptech.glide.util.pool.FactoryPools.Poolable
    public StateVerifier getVerifier() {
        return this.stateVerifier;
    }
}
