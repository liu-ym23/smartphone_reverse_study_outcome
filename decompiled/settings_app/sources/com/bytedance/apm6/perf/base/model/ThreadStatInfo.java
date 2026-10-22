package com.bytedance.apm6.perf.base.model;

/* JADX INFO: loaded from: classes3.dex */
public class ThreadStatInfo {
    public long threadCpuTime;
    public String threadName;

    public ThreadStatInfo(String r1, long r2) {
        this.threadName = r1;
        this.threadCpuTime = r2;
    }
}
