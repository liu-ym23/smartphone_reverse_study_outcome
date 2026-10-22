package com.bytedance.apm.entity;

/* JADX INFO: loaded from: classes3.dex */
public class CpuMonitorItem {
    public long firstMonitorTime;
    public double maxCpuRate;
    public double maxStatSpeed;
    public double totalCpuRate;
    public double totalStatSpeed;
    public long totalTimes;

    public CpuMonitorItem(long r1, double r3, double r5, double r7, double r9) {
        this.firstMonitorTime = r1;
        this.maxCpuRate = r3;
        this.totalTimes = 1;
        this.totalCpuRate = r5;
        this.maxStatSpeed = r7;
        this.totalStatSpeed = r9;
    }

    public void reset() {
        this.firstMonitorTime = 0;
        this.maxCpuRate = 0.0d;
        this.totalTimes = 0;
        this.totalCpuRate = 0.0d;
        this.maxStatSpeed = 0.0d;
        this.totalStatSpeed = 0.0d;
    }
}
