package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.Key;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
final class Jobs {
    private final Map<Key, EngineJob<?>> jobs;
    private final Map<Key, EngineJob<?>> onlyCacheJobs;

    Jobs() {
        this.jobs = new HashMap();
        this.onlyCacheJobs = new HashMap();
    }

    Map<Key, EngineJob<?>> getAll() {
        return Collections.unmodifiableMap(this.jobs);
    }

    EngineJob<?> get(Key r1, boolean r2) {
        return getJobMap(r2).get(r1);
    }

    void put(Key r2, EngineJob<?> r3) {
        getJobMap(r3.onlyRetrieveFromCache()).put(r2, r3);
    }

    void removeIfCurrent(Key r2, EngineJob<?> r3) {
        Map<Key, EngineJob<?>> r1 = getJobMap(r3.onlyRetrieveFromCache());
        if (r3.equals(r1.get(r2)) == false) goto L6;
        r1.remove(r2);
        return;
    }

    private Map<Key, EngineJob<?>> getJobMap(boolean r1) {
        if (r1 == false) goto L5;
        return this.onlyCacheJobs;
    L5:
        return this.jobs;
    }
}
