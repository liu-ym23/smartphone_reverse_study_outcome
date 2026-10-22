package com.bytedance.watson.assist.core.cpu;

import com.bytedance.watson.assist.file.FileStatInfo;
import org.apache.commons.math3.geometry.VectorFormat;

/* JADX INFO: loaded from: classes3.dex */
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

    public long getDeltaCpuTime() {
        return this.deltaCpuTime;
    }

    public long getMergedCpuTime() {
        return this.mergedCpuTime;
    }

    public double getCpuUsage() {
        return this.cpuUsage;
    }

    public double getCpuSpeed() {
        return this.cpuSpeed;
    }

    public double getMergeCpuSpeed() {
        return this.mergeCpuSpeed;
    }

    public void setCpuUsage(long r5) {
        if (this.deltaCpuTime >= 0) goto L5;
        return;
    L5:
        if (r5 <= 0) goto L9;
        this.cpuUsage = getDeltaCpuTime() / r5;
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

    public void setCpuSpeed(long r5) {
        if (this.deltaCpuTime >= 0) goto L5;
        return;
    L5:
        if (r5 <= 0) goto L9;
        this.cpuSpeed = getDeltaCpuTime() / r5;
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

    @Override // com.bytedance.watson.assist.file.FileStatInfo
    public void merge(FileStatInfo r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        this.mergedCpuTime += ((ProcStatInfo) r5).getMergedCpuTime();
    }

    public int getPid() {
        return this.pid;
    }

    public void setPid(int r1) {
        this.pid = r1;
    }

    public String getProcessName() {
        return this.processName;
    }

    public void setProcessName(String r1) {
        this.processName = r1;
    }

    public long getCpuTime() {
        return this.cpuTime;
    }

    public void setCpuTime(long r1) {
        this.cpuTime = r1;
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

    public String toString() {
        StringBuilder r0 = new StringBuilder("proc_stat:{pid=");
        r0.append(this.pid).append(" process_name:").append(this.processName).append(" delta cpu_time:").append(getDeltaCpuTime()).append(" cpu_usage:").append(this.cpuUsage * 100.0d).append("% cpu_rate:").append(this.cpuSpeed).append(VectorFormat.DEFAULT_SUFFIX);
        return r0.toString();
    }

    public String toMergeString() {
        StringBuilder r0 = new StringBuilder("proc_stat:{pid=");
        r0.append(this.pid).append(" process_name:").append(this.processName).append(" merged cpu_time:").append(getMergedCpuTime()).append(" cpu_usage:").append(this.mergeCpuUsage * 100.0d).append("% cpu_rate:").append(this.mergeCpuSpeed).append(VectorFormat.DEFAULT_SUFFIX);
        return r0.toString();
    }
}
