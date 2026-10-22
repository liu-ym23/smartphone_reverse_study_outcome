package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.Key;
import com.bumptech.glide.util.Preconditions;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: classes.dex */
final class ActiveResources {
    final Map<Key, ResourceWeakReference> activeEngineResources;
    private volatile DequeuedResourceCallback cb;
    private final boolean isActiveResourceRetentionAllowed;
    private volatile boolean isShutdown;
    private EngineResource.ResourceListener listener;
    private final Executor monitorClearedResourcesExecutor;
    private final ReferenceQueue<EngineResource<?>> resourceReferenceQueue;

    interface DequeuedResourceCallback {
        void onResourceDequeued();
    }

    static final class ResourceWeakReference extends WeakReference<EngineResource<?>> {
        final boolean isCacheable;
        final Key key;
        Resource<?> resource;

        ResourceWeakReference(Key r1, EngineResource<?> r2, ReferenceQueue<? super EngineResource<?>> r3, boolean r4) {
            super(r2, r3);
            this.key = (Key) Preconditions.checkNotNull(r1);
            if (r2.isMemoryCacheable() == false) goto L6;
            if (r4 == false) goto L6;
            Resource<?> r5 = (Resource) Preconditions.checkNotNull(r2.getResource());
        L7:
            this.resource = r5;
            this.isCacheable = r2.isMemoryCacheable();
            return;
        L6:
            r5 = null;
            goto L7
        }

        void reset() {
            this.resource = null;
            clear();
        }
    }

    ActiveResources(boolean r2) {
        this(r2, Executors.newSingleThreadExecutor(new AnonymousClass1()));
    }

    ActiveResources(boolean r2, Executor r3) {
        this.activeEngineResources = new HashMap();
        this.resourceReferenceQueue = new ReferenceQueue();
        this.isActiveResourceRetentionAllowed = r2;
        this.monitorClearedResourcesExecutor = r3;
        r3.execute(new AnonymousClass2(this));
    }

    void setListener(EngineResource.ResourceListener r2) {
        monitor-enter(r2);
        monitor-enter(this);     // Catch: Throwable -> L11
        this.listener = r2;     // Catch: Throwable -> L8
        monitor-exit(this);     // Catch: Throwable -> L8
        monitor-exit(r2);     // Catch: Throwable -> L11
        return;
    L8:
        th = move-exception;
        throw th;     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    synchronized void activate(Key r4, EngineResource<?> r5) {
        monitor-enter(this);
        ResourceWeakReference r0 = new ResourceWeakReference(r4, r5, this.resourceReferenceQueue, this.isActiveResourceRetentionAllowed);     // Catch: Throwable -> L8
        ResourceWeakReference r6 = this.activeEngineResources.put(r4, r0);     // Catch: Throwable -> L8
        if (r6 == null) goto L6;
        r6.reset();     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    synchronized void deactivate(Key r2) {
        monitor-enter(this);
        ResourceWeakReference r3 = this.activeEngineResources.remove(r2);     // Catch: Throwable -> L8
        if (r3 == null) goto L6;
        r3.reset();     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    synchronized EngineResource<?> get(Key r2) {
        monitor-enter(this);
        ResourceWeakReference r3 = this.activeEngineResources.get(r2);     // Catch: Throwable -> L13
        if (r3 != null) goto L8;
        monitor-exit(this);
        return null;
    L8:
        EngineResource<?> r0 = (EngineResource) r3.get();     // Catch: Throwable -> L13
        if (r0 != null) goto L11;
        cleanupActiveReference(r3);     // Catch: Throwable -> L13
    L11:
        monitor-exit(this);
        return r0;
    L13:
        th = move-exception;
        throw th;
    }

    void cleanupActiveReference(ResourceWeakReference r8) {
        monitor-enter(this);
        this.activeEngineResources.remove(r8.key);     // Catch: Throwable -> L13
        if (r8.isCacheable == true) goto L6;
    L11:
        monitor-exit(this);     // Catch: Throwable -> L13
        return;
    L6:
        if (r8.resource == null) goto L11;
        monitor-exit(this);     // Catch: Throwable -> L13
        EngineResource<?> r0 = new EngineResource(r8.resource, true, false, r8.key, this.listener);
        this.listener.onResourceReleased(r8.key, r0);
        return;
    L13:
        th = move-exception;
        throw th;
    }

    void cleanReferenceQueue() {
    L3:
        if (this.isShutdown == true) goto L9;
        cleanupActiveReference((ResourceWeakReference) this.resourceReferenceQueue.remove());     // Catch: InterruptedException -> L8
        DequeuedResourceCallback r0 = this.cb;     // Catch: InterruptedException -> L8
        if (r0 == null) goto L3;
        r0.onResourceDequeued();     // Catch: InterruptedException -> L8
    L8:
        Thread.currentThread().interrupt();
        goto L3
    }

    void setDequeuedResourceCallback(DequeuedResourceCallback r1) {
        this.cb = r1;
    }

    void shutdown() {
        this.isShutdown = true;
        Executor r1 = this.monitorClearedResourcesExecutor;
        if ((r1 instanceof ExecutorService) == false) goto L6;
        com.bumptech.glide.util.Executors.shutdownAndAwaitTermination((ExecutorService) r1);
        return;
    }
}
