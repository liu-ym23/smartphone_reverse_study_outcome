package com.bumptech.glide.provider;

import androidx.collection.ArrayMap;
import com.bumptech.glide.load.engine.DecodePath;
import com.bumptech.glide.load.engine.LoadPath;
import com.bumptech.glide.load.resource.transcode.UnitTranscoder;
import com.bumptech.glide.util.MultiClassKey;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes3.dex */
public class LoadPathCache {
    private static final LoadPath<?, ?, ?> NO_PATHS_SIGNAL = null;
    private final ArrayMap<MultiClassKey, LoadPath<?, ?, ?>> cache;
    private final AtomicReference<MultiClassKey> keyRef;

    public LoadPathCache() {
        this.cache = new ArrayMap();
        this.keyRef = new AtomicReference();
    }

    static {
        NO_PATHS_SIGNAL = new LoadPath(Object.class, Object.class, Object.class, Collections.singletonList(new DecodePath(Object.class, Object.class, Object.class, Collections.emptyList(), new UnitTranscoder(), null)), null);
    }

    public boolean isEmptyLoadPath(LoadPath<?, ?, ?> r1) {
        return NO_PATHS_SIGNAL.equals(r1);
    }

    public <Data, TResource, Transcode> LoadPath<Data, TResource, Transcode> get(Class<Data> r1, Class<TResource> r2, Class<Transcode> r3) {
        MultiClassKey r4 = getKey(r1, r2, r3);
        ArrayMap<MultiClassKey, LoadPath<?, ?, ?>> r5 = this.cache;
        monitor-enter(r5);
        LoadPath<Data, TResource, Transcode> r6 = (LoadPath) this.cache.get(r4);     // Catch: Throwable -> L8
        monitor-exit(r5);     // Catch: Throwable -> L8
        this.keyRef.set(r4);
        return r6;
    L8:
        th = move-exception;
        throw th;
    }

    public void put(Class<?> r3, Class<?> r4, Class<?> r5, LoadPath<?, ?, ?> r6) {
        ArrayMap<MultiClassKey, LoadPath<?, ?, ?>> r0 = this.cache;
        monitor-enter(r0);
        ArrayMap<MultiClassKey, LoadPath<?, ?, ?>> r2 = this.cache;     // Catch: Throwable -> L11
        MultiClassKey r1 = new MultiClassKey(r3, r4, r5);     // Catch: Throwable -> L11
        if (r6 != null) goto L8;
        r6 = NO_PATHS_SIGNAL;     // Catch: Throwable -> L11
    L8:
        r2.put(r1, r6);     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    }

    private MultiClassKey getKey(Class<?> r2, Class<?> r3, Class<?> r4) {
        MultiClassKey r1 = this.keyRef.getAndSet(null);
        if (r1 != null) goto L5;
        r1 = new MultiClassKey();
    L5:
        r1.set(r2, r3, r4);
        return r1;
    }
}
