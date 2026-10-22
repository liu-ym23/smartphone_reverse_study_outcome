package com.bytedance.apm6.service.lifecycle;

/* JADX INFO: loaded from: classes.dex */
public interface ActivityLifecycleService {
    String getTopActivityClassName();

    boolean isForeground();

    void register(IActivityLifecycleObserver r1);

    void unregister(IActivityLifecycleObserver r1);
}
