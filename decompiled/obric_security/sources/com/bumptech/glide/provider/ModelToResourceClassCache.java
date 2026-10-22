package com.bumptech.glide.provider;

import androidx.collection.ArrayMap;
import com.bumptech.glide.util.MultiClassKey;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
public class ModelToResourceClassCache {
    private final ArrayMap<MultiClassKey, List<Class<?>>> registeredResourceClassCache;
    private final AtomicReference<MultiClassKey> resourceClassKeyRef;

    public ModelToResourceClassCache() {
        this.resourceClassKeyRef = new AtomicReference();
        this.registeredResourceClassCache = new ArrayMap();
    }

    public List<Class<?>> get(Class<?> r3, Class<?> r4, Class<?> r5) {
        MultiClassKey r0 = this.resourceClassKeyRef.getAndSet(null);
        if (r0 != null) goto L5;
        r0 = new MultiClassKey(r3, r4, r5);
    L6:
        ArrayMap<MultiClassKey, List<Class<?>>> r6 = this.registeredResourceClassCache;
        monitor-enter(r6);
        List<Class<?>> r7 = this.registeredResourceClassCache.get(r0);     // Catch: Throwable -> L12
        monitor-exit(r6);     // Catch: Throwable -> L12
        this.resourceClassKeyRef.set(r0);
        return r7;
    L12:
        th = move-exception;
        throw th;
    L5:
        r0.set(r3, r4, r5);
        goto L6
    }

    public void put(Class<?> r3, Class<?> r4, Class<?> r5, List<Class<?>> r6) {
        ArrayMap<MultiClassKey, List<Class<?>>> r0 = this.registeredResourceClassCache;
        monitor-enter(r0);
        this.registeredResourceClassCache.put(new MultiClassKey(r3, r4, r5), r6);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void clear() {
        ArrayMap<MultiClassKey, List<Class<?>>> r0 = this.registeredResourceClassCache;
        monitor-enter(r0);
        this.registeredResourceClassCache.clear();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }
}
