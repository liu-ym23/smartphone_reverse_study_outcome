package com.bytedance.bdinstall.callback.event;

import com.bytedance.bdinstall.InstallInfo;

/* JADX INFO: loaded from: classes3.dex */
public class InstallFinishEvent {
    private InstallInfo info;

    public InstallFinishEvent(InstallInfo r1) {
        this.info = r1;
    }

    public InstallInfo getInfo() {
        return this.info;
    }
}
