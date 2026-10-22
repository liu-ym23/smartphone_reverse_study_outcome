package com.bytedance.watson.assist.core.cpu;

import com.bytedance.watson.assist.file.FileStatInfo;
import com.bytedance.watson.assist.utils.CpuUtils;
import com.bytedance.watson.assist.utils.DebugLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class ProcTimeInStateInfo implements FileStatInfo {
    private List<Integer> clusterCpuNum;
    private List<LinkedHashMap<Long, Long>> freqDeltaTimeMapList;
    private List<LinkedHashMap<Long, Long>> freqDeltaTimeMergeMapList;
    private List<LinkedHashMap<Long, Long>> freqTimeMapList;
    private boolean inited;
    private long totalCpuTime;
    private long totalDeltaCpuTime;
    private long totalMergeDeltaCpuTime;

    public ProcTimeInStateInfo() {
        this.freqTimeMapList = new ArrayList();
        this.freqDeltaTimeMapList = new ArrayList();
        this.freqDeltaTimeMergeMapList = new ArrayList();
        this.inited = false;
        this.totalCpuTime = 0;
        this.totalDeltaCpuTime = 0;
        this.totalMergeDeltaCpuTime = 0;
    }

    @Override // com.bytedance.watson.assist.file.FileStatInfo
    public void calculateDelta(FileStatInfo r12) {
        if (r12 != null) goto L5;
        this.freqDeltaTimeMapList.addAll(this.freqTimeMapList);
        return;
    L5:
        List<LinkedHashMap<Long, Long>> r13 = ((ProcTimeInStateInfo) r12).getFreqTimeMapList();
        if (r13.isEmpty() == false) goto L9;
        return;
    L9:
        if (this.freqTimeMapList.size() == r13.size()) goto L12;
        DebugLog.w("calculate proc freqTime delta size error");
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
        DebugLog.e("calculate proc freqTime delta not found " + r6);
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
    public void merge(FileStatInfo r14) {
        if (r14 != null) goto L4;
        return;
    L4:
        ProcTimeInStateInfo r15 = (ProcTimeInStateInfo) r14;
        List<LinkedHashMap<Long, Long>> r0 = r15.getFreqTimeMapList();
        List<LinkedHashMap<Long, Long>> r16 = r15.getFreqDeltaTimeMapList();
        if (r16.isEmpty() == true) goto L9;
        r0 = r16;
    L9:
        if (this.freqDeltaTimeMergeMapList.isEmpty() == false) goto L12;
        this.freqDeltaTimeMergeMapList.addAll(r0);
        return;
    L12:
        int r17 = this.freqDeltaTimeMergeMapList.size();
        if (r17 == r0.size()) goto L16;
        DebugLog.w("merge freqTime size error");
        return;
    L16:
        ArrayList r1 = new ArrayList();
        int r2 = 0;
    L17:
        if (r2 >= r17) goto L26;
        LinkedHashMap<Long, Long> r3 = this.freqDeltaTimeMergeMapList.get(r2);
        LinkedHashMap<Long, Long> r4 = r0.get(r2);
        LinkedHashMap r5 = new LinkedHashMap();
        Iterator<Map.Entry<Long, Long>> r6 = r3.entrySet().iterator();
    L20:
        if (r6.hasNext() == false) goto L25;
        Map.Entry<Long, Long> r7 = r6.next();
        Long r8 = r7.getKey();
        Long r9 = r7.getValue();
        Long r10 = r4.get(r8);
        if (r10 != null) goto L23;
        DebugLog.w("merge freqTimeDetla freq not found " + r8);
        goto L20
    L23:
        r5.put(r8, Long.valueOf(r9.longValue() + r10.longValue()));
        goto L20
    L25:
        r1.add(r5);
        r2 = r2 + 1;
        goto L17
    L26:
        this.freqDeltaTimeMergeMapList = r1;
    }

    public void addFreqTimeItem(LinkedHashMap<Long, Long> r1) {
        if (r1 == null) goto L5;
        this.freqTimeMapList.add(r1);
        return;
    }

    public List<LinkedHashMap<Long, Long>> getFreqTimeMapList() {
        return this.freqTimeMapList;
    }

    public List<LinkedHashMap<Long, Long>> getFreqDeltaTimeMapList() {
        return this.freqDeltaTimeMapList;
    }

    public List<LinkedHashMap<Long, Long>> getFreqMergeTimeMapList() {
        return this.freqDeltaTimeMergeMapList;
    }

    private long getTotalTime(List<LinkedHashMap<Long, Long>> r7) {
        if (this.inited == true) goto L5;
        this.clusterCpuNum = CpuUtils.getClusterCpuNum();
        this.inited = true;
    L5:
        long r0 = 0;
        if (r7 != null) goto L8;
    L18:
        return r0;
    L8:
        if (r7.isEmpty() == true) goto L18;
        int r2 = r7.size();
        if (r2 != this.clusterCpuNum.size()) goto L18;
        int r6 = 0;
    L12:
        if (r6 >= r2) goto L18;
        Iterator<Map.Entry<Long, Long>> r3 = r7.get(r6).entrySet().iterator();
    L15:
        if (r3.hasNext() == false) goto L17;
        r0 = r0 + r3.next().getValue().longValue();
        goto L15
    L17:
        r6 = r6 + 1;
        goto L12
    }

    public long getTotalCpuTime() {
        if (this.totalCpuTime != 0) goto L6;
        this.totalCpuTime = getTotalTime(this.freqTimeMapList);
    L6:
        return this.totalCpuTime;
    }

    public long getTotalDeltaCpuTime() {
        if (this.totalDeltaCpuTime != 0) goto L6;
        this.totalDeltaCpuTime = getTotalTime(this.freqDeltaTimeMapList);
    L6:
        return this.totalDeltaCpuTime;
    }

    public long getTotalMergeDeltaCpuTime() {
        if (this.totalMergeDeltaCpuTime != 0) goto L6;
        this.totalMergeDeltaCpuTime = getTotalTime(this.freqDeltaTimeMergeMapList);
    L6:
        return this.totalMergeDeltaCpuTime;
    }

    public void reset() {
        this.freqTimeMapList.clear();
        this.freqDeltaTimeMapList.clear();
        this.freqDeltaTimeMergeMapList.clear();
        this.totalCpuTime = 0;
        this.totalDeltaCpuTime = 0;
        this.totalMergeDeltaCpuTime = 0;
    }

    public String toString() {
        return "ProcTimeInStateInfo{freqTimeMapList=" + this.freqTimeMapList + ", freqDeltaTimeMapList=" + this.freqDeltaTimeMapList + ", totalCpuTime=" + getTotalCpuTime() + ", totalDeltaCpuTime=" + getTotalDeltaCpuTime() + ", totalMergeCpuTime=" + getTotalMergeDeltaCpuTime() + '}';
    }
}
