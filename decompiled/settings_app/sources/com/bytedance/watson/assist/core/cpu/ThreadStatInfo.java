package com.bytedance.watson.assist.core.cpu;

import org.apache.commons.math3.geometry.VectorFormat;

/* JADX INFO: loaded from: classes3.dex */
public class ThreadStatInfo extends ProcStatInfo {
    public ThreadStatInfo() {
    }

    @Override // com.bytedance.watson.assist.core.cpu.ProcStatInfo
    public String toString() {
        StringBuilder r0 = new StringBuilder("thread_stat:{tid=");
        r0.append(this.pid).append(" thread_name:").append(this.processName).append(" cpu_time:").append(getDeltaCpuTime()).append(" cpu_usage:").append(this.cpuUsage * 100.0d).append("% cpu_speed:").append(this.cpuSpeed).append(VectorFormat.DEFAULT_SUFFIX);
        return r0.toString();
    }

    @Override // com.bytedance.watson.assist.core.cpu.ProcStatInfo
    public String toMergeString() {
        StringBuilder r0 = new StringBuilder("thread_stat:{tid=");
        r0.append(this.pid).append(" thread_name:").append(this.processName).append(" cpu_time:").append(getMergedCpuTime()).append(" cpu_usage:").append(this.mergeCpuUsage * 100.0d).append("% cpu_speed:").append(this.mergeCpuSpeed).append(VectorFormat.DEFAULT_SUFFIX);
        return r0.toString();
    }
}
