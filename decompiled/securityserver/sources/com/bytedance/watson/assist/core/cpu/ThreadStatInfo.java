package com.bytedance.watson.assist.core.cpu;

/* JADX INFO: loaded from: classes.dex */
public class ThreadStatInfo extends ProcStatInfo {
    public ThreadStatInfo() {
    }

    @Override // com.bytedance.watson.assist.core.cpu.ProcStatInfo
    public String toMergeString() {
        return "thread_stat:{tid=" + this.pid + " thread_name:" + this.processName + " cpu_time:" + getMergedCpuTime() + " cpu_usage:" + (this.mergeCpuUsage * 100.0d) + "% cpu_speed:" + this.mergeCpuSpeed + "}";
    }

    @Override // com.bytedance.watson.assist.core.cpu.ProcStatInfo
    public String toString() {
        return "thread_stat:{tid=" + this.pid + " thread_name:" + this.processName + " cpu_time:" + getDeltaCpuTime() + " cpu_usage:" + (this.cpuUsage * 100.0d) + "% cpu_speed:" + this.cpuSpeed + "}";
    }
}
