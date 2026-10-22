package com.bytedance.frameworks.baselib.network.http.util;

/* JADX INFO: loaded from: classes.dex */
public class TaskInfo {
    private volatile boolean mCanceled;

    public TaskInfo() {
        this.mCanceled = false;
    }

    public boolean isCanceled() {
        return this.mCanceled;
    }

    public void setCanceled() {
        this.mCanceled = true;
    }
}
