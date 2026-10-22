package com.bytedance.watson.assist.core.cpu;

import com.bytedance.watson.assist.file.FileStatInfo;
import com.bytedance.watson.assist.utils.DebugLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class CpuIdleTimeStatInfo implements FileStatInfo {
    private long deltaCpuIdleTime;
    private long mergedDeltaCpuIdleTime;
    private List<List<Long>> stateDeltaTimeLists;
    private List<List<Long>> stateTimeLists;
    private long totalCpuIdleTime;

    public CpuIdleTimeStatInfo() {
        this.stateTimeLists = new ArrayList();
        this.stateDeltaTimeLists = new ArrayList();
        this.totalCpuIdleTime = 0;
        this.deltaCpuIdleTime = 0;
        this.mergedDeltaCpuIdleTime = 0;
    }

    @Override // com.bytedance.watson.assist.file.FileStatInfo
    public void calculateDelta(FileStatInfo r7) {
        if (r7 != null) goto L4;
        return;
    L4:
        long r0 = getTotalCpuIdleTime() - ((CpuIdleTimeStatInfo) r7).getTotalCpuIdleTime();
        this.deltaCpuIdleTime = r0;
        if (this.mergedDeltaCpuIdleTime != 0) goto L8;
        this.mergedDeltaCpuIdleTime = r0;
        return;
    }

    public void calculateIdleDelta(FileStatInfo r12) {
        if (r12 != null) goto L5;
        this.stateDeltaTimeLists.addAll(this.stateTimeLists);
        return;
    L5:
        List<List<Long>> r13 = ((CpuIdleTimeStatInfo) r12).getCpuIdleTimeLists();
        if (r13.isEmpty() == false) goto L8;
        return;
    L8:
        int r0 = this.stateTimeLists.size();
        if (r0 == r13.size()) goto L12;
        DebugLog.w("calculate cpu idle time delta size error1");
        return;
    L12:
        this.stateDeltaTimeLists.clear();
        int r2 = 0;
    L13:
        if (r2 >= r0) goto L32;
        List<Long> r3 = this.stateTimeLists.get(r2);
        List<Long> r4 = r13.get(r2);
        ArrayList r5 = new ArrayList();
        if (r3 == null) goto L25;
        if (r4 == null) goto L25;
        if (r3.size() != r4.size()) goto L25;
        int r6 = 0;
    L22:
        if (r6 >= r3.size()) goto L24;
        r5.add(Long.valueOf(r3.get(r6).longValue() - r4.get(r6).longValue()));
        r6 = r6 + 1;
        goto L22
    L24:
        this.stateDeltaTimeLists.add(r5);
        r2 = r2 + 1;
    L25:
        DebugLog.w("calculate cpu idle time delta size error2");
        return;
    }

    public List<List<Long>> getCpuIdleDeltaTimeLists() {
        return this.stateDeltaTimeLists;
    }

    public List<List<Long>> getCpuIdleTimeLists() {
        return this.stateTimeLists;
    }

    public long getDeltaCpuIdleTime() {
        return this.deltaCpuIdleTime;
    }

    public long getMergedDeltaCpuIdleTime() {
        return this.mergedDeltaCpuIdleTime;
    }

    public long getTotalCpuIdleTime() {
        if (this.totalCpuIdleTime != 0) goto L14;
        if (this.stateTimeLists.isEmpty() == true) goto L14;
        Iterator<List<Long>> r0 = this.stateTimeLists.iterator();
    L8:
        if (r0.hasNext() == false) goto L14;
        Iterator<Long> r1 = r0.next().iterator();
    L11:
        if (r1.hasNext() == false) goto L8;
        Long r2 = r1.next();
        long r3 = this.totalCpuIdleTime;
        this.totalCpuIdleTime = r2.longValue() + r3;
    L14:
        return this.totalCpuIdleTime;
    }

    @Override // com.bytedance.watson.assist.file.FileStatInfo
    public void merge(FileStatInfo r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        long r0 = this.mergedDeltaCpuIdleTime;
        this.mergedDeltaCpuIdleTime = ((CpuIdleTimeStatInfo) r5).getMergedDeltaCpuIdleTime() + r0;
    }

    public void putStateTimeList(List<Long> r1) {
        if (r1 == null) goto L5;
        this.stateTimeLists.add(r1);
        return;
    }

    public void reset() {
        this.stateTimeLists.clear();
        this.stateDeltaTimeLists.clear();
        this.totalCpuIdleTime = 0;
        this.deltaCpuIdleTime = 0;
        this.mergedDeltaCpuIdleTime = 0;
    }

    public String toString() {
        return "CpuIdleTimeStatInfo{stateTimeLists=" + this.stateTimeLists + ", stateDeltaTimeLists=" + this.stateDeltaTimeLists + ", totalCpuIdleTime=" + this.totalCpuIdleTime + ", deltaCpuIdleTime=" + this.deltaCpuIdleTime + ", mergedDeltaCpuIdleTime=" + this.mergedDeltaCpuIdleTime + '}';
    }
}
