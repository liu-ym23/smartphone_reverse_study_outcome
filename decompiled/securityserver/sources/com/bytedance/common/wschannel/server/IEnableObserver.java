package com.bytedance.common.wschannel.server;

/* JADX INFO: loaded from: classes.dex */
public interface IEnableObserver {

    public interface OnWsChannelEnableChangedObserver {
        void onWsChannelEnableChange(boolean r1);
    }

    boolean isEnable();

    void setEnableListener(OnWsChannelEnableChangedObserver r1);

    void startLoad();
}
