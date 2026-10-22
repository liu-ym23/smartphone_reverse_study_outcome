package com.bytedance.watson.assist.core.cpu;

import com.bytedance.watson.assist.file.FileStatInfo;

/* JADX INFO: loaded from: classes.dex */
public class ProcStatInfo implements FileStatInfo {
    protected double cpuSpeed;
    protected long cpuTime;
    protected double cpuUsage;
    protected long deltaCpuTime;
    protected double mergeCpuSpeed;
    protected double mergeCpuUsage;
    protected long mergedCpuTime;
    protected int pid;
    protected String processName;

    public ProcStatInfo() {
        this.processName = null;
        this.pid = -1;
        this.cpuTime = 0;
        this.deltaCpuTime = 0;
        this.mergedCpuTime = 0;
        this.cpuUsage = 0.0d;
        this.mergeCpuUsage = 0.0d;
        this.cpuSpeed = 0.0d;
        this.mergeCpuSpeed = 0.0d;
    }

    @Override // com.bytedance.watson.assist.file.FileStatInfo
    public void calculateDelta(FileStatInfo r7) {
        long r0 = getCpuTime();
        if (r7 != null) goto L5;
        long r4 = 0;
    L6:
        long r1 = r0 - r4;
        this.deltaCpuTime = r1;
        if (this.mergedCpuTime != 0) goto L10;
        this.mergedCpuTime = r1;
        return;
    L10:
        return;
    L5:
        r4 = ((ProcStatInfo) r7).getCpuTime();
        goto L6
    }

    public double getCpuSpeed() {
        return this.cpuSpeed;
    }

    public long getCpuTime() {
        return this.cpuTime;
    }

    public double getCpuUsage() {
        return this.cpuUsage;
    }

    public long getDeltaCpuTime() {
        return this.deltaCpuTime;
    }

    public double getMergeCpuSpeed() {
        return this.mergeCpuSpeed;
    }

    public long getMergedCpuTime() {
        return this.mergedCpuTime;
    }

    public int getPid() {
        return this.pid;
    }

    public String getProcessName() {
        return this.processName;
    }

    @Override // com.bytedance.watson.assist.file.FileStatInfo
    public void merge(FileStatInfo r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        long r0 = this.mergedCpuTime;
        this.mergedCpuTime = ((ProcStatInfo) r5).getMergedCpuTime() + r0;
    }

    public void reset() {
        this.processName = null;
        this.pid = -1;
        this.cpuTime = 0;
        this.deltaCpuTime = 0;
        this.mergedCpuTime = 0;
        this.cpuUsage = 0.0d;
        this.mergeCpuUsage = 0.0d;
        this.cpuSpeed = 0.0d;
        this.mergeCpuSpeed = 0.0d;
    }

    public void setCpuSpeed(long r5) {
        if (this.deltaCpuTime >= 0) goto L5;
        return;
    L5:
        if (r5 <= 0) goto L9;
        this.cpuSpeed = getDeltaCpuTime() / r5;
        return;
    }

    public void setCpuTime(long r1) {
        this.cpuTime = r1;
    }

    public void setCpuUsage(long r5) {
        if (this.deltaCpuTime >= 0) goto L5;
        return;
    L5:
        if (r5 <= 0) goto L9;
        this.cpuUsage = getDeltaCpuTime() / r5;
        return;
    }

    public void setMergeCpuSpeed(long r5) {
        if (this.mergedCpuTime >= 0) goto L5;
        return;
    L5:
        if (r5 <= 0) goto L9;
        this.mergeCpuSpeed = getMergedCpuTime() / r5;
        return;
    }

    public void setMergedCpuUsage(long r5) {
        if (this.mergedCpuTime >= 0) goto L5;
        return;
    L5:
        if (r5 <= 0) goto L9;
        this.mergeCpuUsage = getMergedCpuTime() / r5;
        return;
    }

    public void setPid(int r1) {
        this.pid = r1;
    }

    public void setProcessName(String r1) {
        this.processName = r1;
    }

    public String toMergeString() {
        return "proc_stat:{pid=" + this.pid + " process_name:" + this.processName + " merged cpu_time:" + getMergedCpuTime() + " cpu_usage:" + (this.mergeCpuUsage * 100.0d) + "% cpu_rate:" + this.mergeCpuSpeed + "}";
    }

    public String toString() {
        return "proc_stat:{pid=" + this.pid + " process_name:" + this.processName + " delta cpu_time:" + getDeltaCpuTime() + " cpu_usage:" + (this.cpuUsage * 100.0d) + "% cpu_rate:" + this.cpuSpeed + "}";
    }

    public ProcStatInfo(String r3, int r4) {
        this.cpuTime = 0;
        this.deltaCpuTime = 0;
        this.mergedCpuTime = 0;
        this.cpuUsage = 0.0d;
        this.mergeCpuUsage = 0.0d;
        this.cpuSpeed = 0.0d;
        this.mergeCpuSpeed = 0.0d;
        this.processName = r3;
        this.pid = r4;
    }
}
