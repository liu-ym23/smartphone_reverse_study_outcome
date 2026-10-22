package com.bytedance.watson.assist.core.cpu;

import com.bytedance.watson.assist.file.FileStatInfo;
import com.bytedance.watson.assist.utils.DebugLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.math3.geometry.VectorFormat;

/* JADX INFO: loaded from: classes3.dex */
public class CpuTimeStatInfo implements FileStatInfo {
    private double cpuUsage;
    private long deltaCpuTime;
    private List<LinkedHashMap<Long, Long>> freqDeltaTimeMapList;
    private List<LinkedHashMap<Long, Long>> freqTimeMapList;
    private long mergedDeltaCpuTime;
    private long totalCpuTime;

    public CpuTimeStatInfo() {
        this.freqTimeMapList = new ArrayList();
        this.freqDeltaTimeMapList = new ArrayList();
        this.totalCpuTime = 0;
        this.deltaCpuTime = 0;
        this.mergedDeltaCpuTime = 0;
        this.cpuUsage = 0.0d;
    }

    public long getDeltaCpuTime() {
        return this.deltaCpuTime;
    }

    public long getTotalCpuTime() {
        if (this.totalCpuTime != 0) goto L14;
        if (this.freqTimeMapList.isEmpty() == true) goto L14;
        Iterator<LinkedHashMap<Long, Long>> r0 = this.freqTimeMapList.iterator();
    L8:
        if (r0.hasNext() == false) goto L14;
        Iterator<Map.Entry<Long, Long>> r1 = r0.next().entrySet().iterator();
    L11:
        if (r1.hasNext() == false) goto L8;
        this.totalCpuTime += r1.next().getValue().longValue();
    L14:
        return this.totalCpuTime;
    }

    public List<LinkedHashMap<Long, Long>> getFreqTimeMapList() {
        return this.freqTimeMapList;
    }

    public List<LinkedHashMap<Long, Long>> getFreqDeltaTimeMapList() {
        return this.freqDeltaTimeMapList;
    }

    public long getMergedDeltaCpuTime() {
        return this.mergedDeltaCpuTime;
    }

    public void putFreqTimeMap(LinkedHashMap<Long, Long> r1) {
        this.freqTimeMapList.add(r1);
    }

    @Override // com.bytedance.watson.assist.file.FileStatInfo
    public void calculateDelta(FileStatInfo r7) {
        if (r7 != null) goto L4;
        return;
    L4:
        long r0 = getTotalCpuTime() - ((CpuTimeStatInfo) r7).getTotalCpuTime();
        this.deltaCpuTime = r0;
        if (this.mergedDeltaCpuTime != 0) goto L8;
        this.mergedDeltaCpuTime = r0;
        return;
    }

    public void calculateFreqDelta(FileStatInfo r12) {
        if (r12 != null) goto L5;
        this.freqDeltaTimeMapList.addAll(this.freqTimeMapList);
        return;
    L5:
        List<LinkedHashMap<Long, Long>> r13 = ((CpuTimeStatInfo) r12).getFreqTimeMapList();
        if (r13.isEmpty() == false) goto L9;
        return;
    L9:
        if (this.freqTimeMapList.size() == r13.size()) goto L12;
        DebugLog.w("calculate cpu freqTime delta size error");
        return;
    L12:
        this.freqDeltaTimeMapList.clear();
        int r0 = 0;
    L14:
        if (r0 >= this.freqTimeMapList.size()) goto L23;
        LinkedHashMap<Long, Long> r1 = this.freqTimeMapList.get(r0);
        LinkedHashMap<Long, Long> r2 = r13.get(r0);
        LinkedHashMap<Long, Long> r3 = new LinkedHashMap();
        Iterator<Map.Entry<Long, Long>> r4 = r1.entrySet().iterator();
    L17:
        if (r4.hasNext() == false) goto L22;
        Map.Entry<Long, Long> r5 = r4.next();
        Long r6 = r5.getKey();
        Long r7 = r5.getValue();
        Long r8 = r2.get(r6);
        if (r8 != null) goto L20;
        DebugLog.e("calculate cpu freqTime delta not found " + r6);
        goto L17
    L20:
        r3.put(r6, Long.valueOf(r7.longValue() - r8.longValue()));
        goto L17
    L22:
        this.freqDeltaTimeMapList.add(r3);
        r0 = r0 + 1;
        goto L14
    }

    @Override // com.bytedance.watson.assist.file.FileStatInfo
    public void merge(FileStatInfo r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        this.mergedDeltaCpuTime += ((CpuTimeStatInfo) r5).getMergedDeltaCpuTime();
    }

    public void reset() {
        this.freqTimeMapList.clear();
        this.freqDeltaTimeMapList.clear();
        this.totalCpuTime = 0;
        this.deltaCpuTime = 0;
        this.mergedDeltaCpuTime = 0;
        this.cpuUsage = 0.0d;
    }

    public double getCpuUsage() {
        return this.cpuUsage;
    }

    public void setCpuUsage(long r5) {
        if (this.deltaCpuTime >= 0) goto L5;
        return;
    L5:
        if (this.totalCpuTime <= 0) goto L9;
        this.cpuUsage = 1.0d - (r5 / getDeltaCpuTime());
        return;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder("cputime:{deltaTime:");
        r0.append(getDeltaCpuTime()).append(" usage:").append(this.cpuUsage).append(" totaltime:").append(getTotalCpuTime()).append(VectorFormat.DEFAULT_SUFFIX);
        return r0.toString();
    }

    public String toMergeString() {
        StringBuilder r0 = new StringBuilder("cputime:{deltaTime:");
        r0.append(getMergedDeltaCpuTime()).append(VectorFormat.DEFAULT_SUFFIX);
        return r0.toString();
    }
}
