package com.bytedance.services.apm.api;

import com.bytedance.news.common.service.manager.IService;

/* JADX INFO: loaded from: classes3.dex */
public interface IActivityLifeManager extends IService {
    boolean isForeground();

    void register(IActivityLifeObserver r1);

    void unregister(IActivityLifeObserver r1);
}
