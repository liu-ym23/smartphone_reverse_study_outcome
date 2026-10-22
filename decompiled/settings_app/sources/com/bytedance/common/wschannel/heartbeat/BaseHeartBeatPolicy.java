package com.bytedance.common.wschannel.heartbeat;

import android.os.Handler;
import com.bytedance.common.wschannel.heartbeat.model.IHeartBeatMeta;

/* JADX INFO: loaded from: classes3.dex */
public abstract class BaseHeartBeatPolicy<T extends IHeartBeatMeta> implements IHeartBeatPolicy {
    protected T mMeta;

    public abstract void init(HeartBeatReactListener r1, Handler r2);

    public BaseHeartBeatPolicy(T r1) {
        this.mMeta = r1;
    }
}
