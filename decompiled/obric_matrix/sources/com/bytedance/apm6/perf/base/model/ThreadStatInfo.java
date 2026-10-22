package com.bytedance.apm6.perf.base.model;

import androidx.annotation.Keep;

/* JADX INFO: loaded from: classes.dex */
@Keep
public class ThreadStatInfo {
    public long threadCpuTime;
    public String threadName;

    public ThreadStatInfo(String r1, long r2) {
        this.threadName = r1;
        this.threadCpuTime = r2;
    }
}
