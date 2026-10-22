package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.Key;
import com.bumptech.glide.util.Preconditions;

/* JADX INFO: loaded from: classes.dex */
class EngineResource<Z> implements Resource<Z> {
    private int acquired;
    private final boolean isMemoryCacheable;
    private final boolean isRecyclable;
    private boolean isRecycled;
    private final Key key;
    private final ResourceListener listener;
    private final Resource<Z> resource;

    interface ResourceListener {
        void onResourceReleased(Key r1, EngineResource<?> r2);
    }

    EngineResource(Resource<Z> r1, boolean r2, boolean r3, Key r4, ResourceListener r5) {
        this.resource = (Resource) Preconditions.checkNotNull(r1);
        this.isMemoryCacheable = r2;
        this.isRecyclable = r3;
        this.key = r4;
        this.listener = (ResourceListener) Preconditions.checkNotNull(r5);
    }

    Resource<Z> getResource() {
        return this.resource;
    }

    boolean isMemoryCacheable() {
        return this.isMemoryCacheable;
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public Class<Z> getResourceClass() {
        return this.resource.getResourceClass();
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public Z get() {
        return this.resource.get();
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public int getSize() {
        return this.resource.getSize();
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public synchronized void recycle() {
        monitor-enter(this);
    L16:
        th = move-exception;
        throw th;
    L4:
        if (this.acquired > 0) goto L15;
        if (this.isRecycled == true) goto L13;
        this.isRecycled = true;     // Catch: Throwable -> L16
        if (this.isRecyclable == false) goto L10;
        this.resource.recycle();     // Catch: Throwable -> L16
    L10:
        monitor-exit(this);
        return;
    L13:
        throw new IllegalStateException("Cannot recycle a resource that has already been recycled");     // Catch: Throwable -> L16
    L15:
        throw new IllegalStateException("Cannot recycle a resource while it is still acquired");     // Catch: Throwable -> L16
    }

    synchronized void acquire() {
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L4:
        if (this.isRecycled == true) goto L9;
        this.acquired++;     // Catch: Throwable -> L10
        monitor-exit(this);
        return;
    L9:
        throw new IllegalStateException("Cannot acquire a recycled resource");     // Catch: Throwable -> L10
    }

    void release() {
        monitor-enter(this);
        int r0 = this.acquired;     // Catch: Throwable -> L15
        if (r0 <= 0) goto L14;
        boolean r1 = true;
        int r2 = r0 - 1;     // Catch: Throwable -> L15
        this.acquired = r2;     // Catch: Throwable -> L15
        if (r2 == 0) goto L9;
        r1 = false;
    L9:
        monitor-exit(this);     // Catch: Throwable -> L15
        if (r1 == false) goto L19;
        this.listener.onResourceReleased(this.key, this);
        return;
    L19:
        return;
    L14:
        throw new IllegalStateException("Cannot release a recycled or not yet acquired resource");     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        throw th;
    }

    public synchronized String toString() {
        monitor-enter(this);
        String r0 = "EngineResource{isMemoryCacheable=" + this.isMemoryCacheable + ", listener=" + this.listener + ", key=" + this.key + ", acquired=" + this.acquired + ", isRecycled=" + this.isRecycled + ", resource=" + this.resource + '}';     // Catch: Throwable -> L7
        monitor-exit(this);
        return r0;
    L7:
        th = move-exception;
        throw th;
    }
}
