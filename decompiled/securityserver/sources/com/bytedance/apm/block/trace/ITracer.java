package com.bytedance.apm.block.trace;

import com.bytedance.services.apm.api.IActivityLifeObserver;

/* JADX INFO: loaded from: classes.dex */
public interface ITracer extends IActivityLifeObserver {
    boolean isAlive();

    void onCloseTrace();

    void onStartTrace();
}
