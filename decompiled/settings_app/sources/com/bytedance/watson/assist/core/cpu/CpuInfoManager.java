package com.bytedance.watson.assist.core.cpu;

import android.content.Context;
import com.bytedance.watson.assist.api.IAssistStat;
import com.bytedance.watson.assist.core.BaseInfoManager;
import com.bytedance.watson.assist.file.ProcPidStatFile;
import com.bytedance.watson.assist.file.ProcTidStatFile;
import com.bytedance.watson.assist.file.ProcTimeInStateFile;
import com.bytedance.watson.assist.file.SystemIdleTimeFile;
import com.bytedance.watson.assist.file.SystemPolicyTimeInStateFile;
import com.bytedance.watson.assist.utils.DebugLog;
import com.bytedance.watson.assist.utils.ProcessUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public class CpuInfoManager extends BaseInfoManager {
    private static final int CLUSTER_INFO_SIZE = 5;
    private boolean isStart;
    private CpuIdleTimeStatInfo mLastCpuIdleTimeStatInfo;
    private CpuTimeStatInfo mLastCpuTimeInStatInfo;
    private ProcStatInfo mLastProcStatInfo;
    private ProcTimeInStateInfo mLastProcTimeInStateInfo;
    private long mLastRefreshTime;
    private Map<Long, ThreadStatInfo> mLastTidStatInfo;
    private Map<Long, ProcTimeInStateInfo> mLastTidTimeInStateInfo;
    private ProcPidStatFile mProcPidStatFile;
    private Map<Long, ProcTidStatFile> mProcTidStatFileMap;
    private Map<Long, ProcTimeInStateFile> mProcTidTimeInStateFileMap;
    private ProcTimeInStateFile mProcTimeInStateFile;
    private SystemIdleTimeFile mSystemIdleTimeInStatFile;
    private SystemPolicyTimeInStateFile mSystemTimeInStatFile;

    private boolean isBigLittle(int r1) {
        if (r1 != 2) goto L5;
        return true;
    L5:
        return false;
    }

    private boolean isBigMidLittle(int r1) {
        if (r1 != 3) goto L5;
        return true;
    L5:
        return false;
    }

    public CpuInfoManager(Context r1, IAssistStat r2) {
        super(r1, r2);
        this.isStart = false;
        this.mLastRefreshTime = 0;
        this.mProcTimeInStateFile = new ProcTimeInStateFile();
        this.mLastProcTimeInStateInfo = new ProcTimeInStateInfo();
        this.mProcTidTimeInStateFileMap = new HashMap();
        this.mLastTidTimeInStateInfo = new HashMap();
        this.mSystemTimeInStatFile = new SystemPolicyTimeInStateFile();
        this.mLastCpuTimeInStatInfo = new CpuTimeStatInfo();
        this.mProcPidStatFile = new ProcPidStatFile();
        this.mLastProcStatInfo = new ProcStatInfo();
        this.mProcTidStatFileMap = new HashMap();
        this.mLastTidStatInfo = new HashMap();
        this.mSystemIdleTimeInStatFile = new SystemIdleTimeFile();
        this.mLastCpuIdleTimeStatInfo = new CpuIdleTimeStatInfo();
    }

    @Override // com.bytedance.watson.assist.core.BaseInfoManager
    public void start() {
        if (this.isStart == true) goto L6;
        this.isStart = true;
        refresh();
        return;
    }

    @Override // com.bytedance.watson.assist.core.BaseInfoManager
    public void end() {
        if (this.isStart == false) goto L6;
        this.isStart = false;
        clear();
        return;
    }

    private void clear() {
        this.mLastProcTimeInStateInfo.reset();
        this.mProcTidTimeInStateFileMap.clear();
        this.mLastTidTimeInStateInfo.clear();
        this.mLastCpuTimeInStatInfo.reset();
        this.mLastProcStatInfo.reset();
        this.mProcTidStatFileMap.clear();
        this.mLastTidStatInfo.clear();
        this.mLastCpuIdleTimeStatInfo.reset();
    }

    public List<LinkedHashMap<Long, Long>> getProcCpuTimeDetail() {
        if (this.mAssistStat.getConfig().isEnableProcessTimeFreqPercent() == true) goto L5;
        return null;
    L5:
        return this.mLastProcTimeInStateInfo.getFreqMergeTimeMapList();
    }

    public List<LinkedHashMap<Long, Long>> getThreadCpuTimeDetail(int r3) {
        if (this.mAssistStat.getConfig().isEnableProcessTimeFreqPercent() == false) goto L8;
        ProcTimeInStateInfo r2 = this.mLastTidTimeInStateInfo.get(Long.valueOf(r3));
        if (r2 != null) goto L7;
        return null;
    L7:
        return r2.getFreqDeltaTimeMapList();
    L8:
        return null;
    }

    public List<LinkedHashMap<Long, Long>> getSystemCpuTimeFreqDetail() {
        if (this.mAssistStat.getConfig().isEnableCpuUsageStat() == true) goto L5;
        return null;
    L5:
        if (this.mAssistStat.getConfig().isEnableSystemCpuTimeFreqPercent() == true) goto L7;
        return null;
    L7:
        return this.mLastCpuTimeInStatInfo.getFreqDeltaTimeMapList();
    }

    public double getSystemCpuUsage() {
        if (this.mAssistStat.getConfig().isEnableSystemCpuUsageStat() == true) goto L5;
        return 0.0d;
    L5:
        if (this.mAssistStat.getConfig().isEnableCpuUsageStat() == true) goto L7;
        return 0.0d;
    L7:
        return this.mLastCpuTimeInStatInfo.getCpuUsage();
    }

    public double getProcCpuUsage() {
        if (this.mAssistStat.getConfig().isEnableCpuUsageStat() == true) goto L5;
        return 0.0d;
    L5:
        return this.mLastProcStatInfo.getCpuUsage();
    }

    public double getThreadCpuUsage(int r3) {
        if (this.mAssistStat.getConfig().isEnableCpuUsageStat() == true) goto L5;
        return 0.0d;
    L5:
        if (this.mAssistStat.getConfig().isEnableThreadCpuUsageStat() == false) goto L12;
        ThreadStatInfo r2 = this.mLastTidStatInfo.get(Long.valueOf(r3));
        if (r2 != null) goto L9;
        return 0.0d;
    L9:
        return r2.getCpuUsage();
    L12:
        return 0.0d;
    }

    public double getProcCpuSpeed() {
        if (this.mAssistStat.getConfig().isEnableCpuUsageStat() == true) goto L5;
        return 0.0d;
    L5:
        return this.mLastProcStatInfo.getCpuSpeed();
    }

    public double getThreadCpuSpeed(int r3) {
        if (this.mAssistStat.getConfig().isEnableCpuUsageStat() == true) goto L5;
        return 0.0d;
    L5:
        if (this.mAssistStat.getConfig().isEnableThreadCpuUsageStat() == false) goto L12;
        ThreadStatInfo r2 = this.mLastTidStatInfo.get(Long.valueOf(r3));
        if (r2 != null) goto L9;
        return 0.0d;
    L9:
        return r2.getCpuSpeed();
    L12:
        return 0.0d;
    }

    public ThreadStatInfo getThreadCpuStatInfo(int r3) {
        if (this.mAssistStat.getConfig().isEnableCpuUsageStat() == true) goto L5;
        return null;
    L5:
        if (this.mAssistStat.getConfig().isEnableThreadCpuUsageStat() == true) goto L7;
        return null;
    L7:
        return this.mLastTidStatInfo.get(Long.valueOf(r3));
    }

    public List<ThreadStatInfo> getSortedThreadStatInfoList() {
        if (this.mAssistStat.getConfig().isEnableCpuUsageStat() == true) goto L5;
        return null;
    L5:
        if (this.mAssistStat.getConfig().isEnableThreadCpuUsageStat() == false) goto L10;
        ArrayList r0 = new ArrayList(this.mLastTidStatInfo.values());
        Collections.sort(r0, new AnonymousClass1(this));
        return r0;
    L10:
        return null;
    }

    public List<ThreadStatInfo> getTopThreadCpuStatInfoList(int r2) {
        if (this.mAssistStat.getConfig().isEnableCpuUsageStat() == true) goto L5;
        return null;
    L5:
        if (this.mAssistStat.getConfig().isEnableThreadCpuUsageStat() == false) goto L16;
        if (r2 <= 0) goto L17;
        List<ThreadStatInfo> r1 = getSortedThreadStatInfoList();
        if (r1 == null) goto L18;
        int r0 = r1.size();
        if (r2 <= r0) goto L13;
        r2 = r0;
    L13:
        return r1.subList(0, r2);
    L18:
        return null;
    L17:
        return null;
    L16:
        return null;
    }

    public void refreshCpuUsageStat(long r13) {
        CpuTimeStatInfo r0 = (CpuTimeStatInfo) this.mSystemTimeInStatFile.refresh();
        ProcStatInfo r1 = (ProcStatInfo) this.mProcPidStatFile.refresh();
        if (r0 == null) goto L52;
        if (r1 == null) goto L53;
        r0.calculateDelta(this.mLastCpuTimeInStatInfo);
        if (this.mAssistStat.getConfig().isEnableSystemCpuTimeFreqPercent() == false) goto L10;
        r0.calculateFreqDelta(this.mLastCpuTimeInStatInfo);
    L10:
        if (this.mAssistStat.getConfig().isEnableSystemCpuUsageStat() == false) goto L12;
        CpuIdleTimeStatInfo r2 = (CpuIdleTimeStatInfo) this.mSystemIdleTimeInStatFile.refresh();
        r2.calculateDelta(this.mLastCpuIdleTimeStatInfo);
        r2.calculateIdleDelta(this.mLastCpuIdleTimeStatInfo);
        DebugLog.d("current cpu idle stat : " + r2);
        this.mLastCpuIdleTimeStatInfo = r2;
        r0.setCpuUsage(r2.getDeltaCpuIdleTime());
        DebugLog.d("current cpu usage stat : " + r0);
    L12:
        long r3 = r0.getDeltaCpuTime();
        long r14 = r13 - this.mLastRefreshTime;
        r1.calculateDelta(this.mLastProcStatInfo);
        r1.setCpuUsage(r3);
        r1.setCpuSpeed(r14);
        if (this.mAssistStat.getConfig().isEnableThreadCpuUsageStat() == false) goto L38;
        ArrayList<Long> r4 = ProcessUtils.threadListFromProcFs();
        HashSet r5 = new HashSet();
        Iterator<Long> r6 = r4.iterator();
    L16:
        if (r6.hasNext() == false) goto L24;
        long r7 = r6.next().longValue();
        ProcTidStatFile r9 = this.mProcTidStatFileMap.get(Long.valueOf(r7));
        if (r9 != null) goto L20;
        r9 = new ProcTidStatFile(r7);
        this.mProcTidStatFileMap.put(Long.valueOf(r7), r9);
    L20:
        ThreadStatInfo r10 = (ThreadStatInfo) r9.refresh();
        if (r10 == null) goto L22;
        r10.calculateDelta(this.mLastTidStatInfo.get(Long.valueOf(r7)));
        r10.setCpuUsage(r3);
        r10.setCpuSpeed(r14);
        this.mLastTidStatInfo.put(Long.valueOf(r7), r10);
        DebugLog.d("current tid stat : " + r10);
        goto L16
    L22:
        r5.add(Long.valueOf(r7));
        DebugLog.d("dead tid found from refresh thread usage: " + r7);
        goto L16
    L24:
        Set<Long> r15 = this.mProcTidStatFileMap.keySet();
        if (r15 != null) goto L27;
    L34:
        Iterator r16 = r5.iterator();
    L36:
        if (r16.hasNext() == false) goto L38;
        long r8 = ((Long) r16.next()).longValue();
        this.mProcTidStatFileMap.remove(Long.valueOf(r8));
        this.mLastTidStatInfo.remove(Long.valueOf(r8));
        goto L36
    L27:
        if (r15.isEmpty() == true) goto L34;
        Iterator<Long> r17 = r15.iterator();
    L30:
        if (r17.hasNext() == false) goto L34;
        Long r18 = r17.next();
        if (r4.contains(r18) == true) goto L30;
        r5.add(r18);
        DebugLog.d("dead tid found from compare last thread usage: " + r18);
    L38:
        this.mLastCpuTimeInStatInfo = r0;
        this.mLastProcStatInfo = r1;
        return;
    L53:
        return;
    }

    public void refreshCpuFreqStat() {
        ProcTimeInStateInfo r0 = (ProcTimeInStateInfo) this.mProcTimeInStateFile.refresh();
        if (r0 != null) goto L5;
        return;
    L5:
        r0.calculateDelta(this.mLastProcTimeInStateInfo);
        this.mLastProcTimeInStateInfo = r0;
        ArrayList<Long> r1 = ProcessUtils.threadListFromProcFs();
        HashSet r2 = new HashSet();
        Iterator<Long> r3 = r1.iterator();
    L7:
        if (r3.hasNext() == false) goto L19;
        long r4 = r3.next().longValue();
        ProcTimeInStateFile r5 = this.mProcTidTimeInStateFileMap.get(Long.valueOf(r4));
        if (r5 != null) goto L11;
        r5 = new ProcTimeInStateFile((int) r4);
        this.mProcTidTimeInStateFileMap.put(Long.valueOf(r4), r5);
    L11:
        ProcTimeInStateInfo r6 = (ProcTimeInStateInfo) r5.refresh();
        if (r6 == null) goto L13;
        r6.calculateDelta(this.mLastTidTimeInStateInfo.get(Long.valueOf(r4)));
        this.mLastTidTimeInStateInfo.put(Long.valueOf(r4), r6);
        if (ProcessUtils.getMainThreadId() != r4) goto L17;
        DebugLog.d("not merge main thread, id:" + r4);
    L18:
        DebugLog.d("current tid " + r4 + " stat : " + r6);
        DebugLog.d("current tid " + r4 + " delta : " + r6.getTotalDeltaCpuTime());
        goto L7
    L17:
        this.mLastProcTimeInStateInfo.merge(r6);
        goto L18
    L13:
        r2.add(Long.valueOf(r4));
        DebugLog.d("dead tid found from refresh cpu freq stat: " + r4);
        goto L7
    L19:
        Set<Long> r7 = this.mProcTidTimeInStateFileMap.keySet();
        if (r7 != null) goto L22;
    L29:
        Iterator r8 = r2.iterator();
    L31:
        if (r8.hasNext() == false) goto L33;
        long r9 = ((Long) r8.next()).longValue();
        this.mProcTidTimeInStateFileMap.remove(Long.valueOf(r9));
        this.mLastTidTimeInStateInfo.remove(Long.valueOf(r9));
        goto L31
    L33:
        return;
    L22:
        if (r7.isEmpty() == true) goto L29;
        Iterator<Long> r10 = r7.iterator();
    L25:
        if (r10.hasNext() == false) goto L29;
        Long r11 = r10.next();
        if (r1.contains(r11) == true) goto L25;
        r2.add(r11);
        DebugLog.d("dead tid found from compare last cpu freq stat: " + r11);
        goto L25
    }

    public void refresh() {
        if (this.isStart == false) goto L12;
        long r0 = System.currentTimeMillis();
        if (this.mAssistStat.getConfig().isEnableCpuUsageStat() == false) goto L8;
        refreshCpuUsageStat(r0);
    L8:
        if (this.mAssistStat.getConfig().isEnableProcessTimeFreqPercent() == false) goto L10;
        refreshCpuFreqStat();
    L10:
        this.mLastRefreshTime = r0;
        return;
    }

    public List<List<Integer>> getProcessCpuTimeFreqPercent() {
        if (this.mAssistStat.getConfig().isEnableProcessTimeFreqPercent() == true) goto L5;
        return null;
    L5:
        return generateCpuTimeFreqPercent(this.mLastProcTimeInStateInfo.getFreqMergeTimeMapList(), this.mLastProcTimeInStateInfo.getTotalMergeDeltaCpuTime());
    }

    public List<List<Integer>> getThreadCpuTimeFreqPercent(int r4) {
        if (this.mAssistStat.getConfig().isEnableProcessTimeFreqPercent() == false) goto L8;
        ProcTimeInStateInfo r5 = this.mLastTidTimeInStateInfo.get(Long.valueOf(r4));
        if (r5 != null) goto L7;
        return null;
    L7:
        return generateCpuTimeFreqPercent(r5.getFreqDeltaTimeMapList(), r5.getTotalDeltaCpuTime());
    L8:
        return null;
    }

    public List<List<Integer>> getSystemCpuTimeFreqPercent() {
        if (this.mAssistStat.getConfig().isEnableSystemCpuTimeFreqPercent() == true) goto L5;
        return null;
    L5:
        if (this.mAssistStat.getConfig().isEnableCpuUsageStat() == true) goto L7;
        return null;
    L7:
        return generateCpuTimeFreqPercent(this.mLastCpuTimeInStatInfo.getFreqDeltaTimeMapList(), this.mLastCpuTimeInStatInfo.getDeltaCpuTime());
    }

    private List<List<Integer>> generateCpuTimeFreqPercent(List<LinkedHashMap<Long, Long>> r21, long r22) {
        if (r21 == null) goto L27;
        long r2 = 0;
        if (r22 <= 0) goto L37;
        ArrayList r4 = new ArrayList();
        Iterator<LinkedHashMap<Long, Long>> r5 = r21.iterator();
    L9:
        if (r5.hasNext() == false) goto L26;
        LinkedHashMap<Long, Long> r6 = r5.next();
        ArrayList r7 = new ArrayList();
        int r8 = r6.size() / 4;
        Iterator<Map.Entry<Long, Long>> r9 = r6.entrySet().iterator();
        int r10 = 0;
        long r11 = r2;
        long r13 = r11;
        int r12 = 0;
    L12:
        if (r9.hasNext() == false) goto L25;
        Map.Entry<Long, Long> r15 = r9.next();
        Long r18 = r15.getKey();
        Long r16 = r15.getValue();
        if (r18 == null) goto L12;
        if (r16 == null) goto L12;
        r13 = r13 + r16.longValue();
        if (r10 >= 3) goto L22;
        if (r12 >= r8) goto L21;
        r11 = r11 + r16.longValue();
        r12 = r12 + 1;
        goto L12
    L21:
        r7.add(Integer.valueOf((int) ((r11 / r22) * 100.0d)));
        r11 = r16.longValue();
        r10 = r10 + 1;
        r12 = 1;
        goto L12
    L22:
        if (r10 != 3) goto L12;
        r11 = r11 + r16.longValue();
        goto L12
    L25:
        double r14 = r22;
        r7.add(Integer.valueOf((int) ((r11 / r14) * 100.0d)));
        r7.add(Integer.valueOf((int) ((r13 / r14) * 100.0d)));
        r4.add(r7);
        r2 = 0;
        goto L9
    L26:
        return r4;
    L37:
        return null;
    L27:
        return null;
    }

    private IAssistStat.CpuTimePercent generateCpuTimePercentFromList(List<List<Integer>> r11) {
        if (r11 != null) goto L5;
        return null;
    L5:
        boolean r0 = isBigLittle(r11.size());
        boolean r10 = isBigMidLittle(r11.size());
        IAssistStat.CpuTimePercent r1 = new IAssistStat.CpuTimePercent();
        Iterator<List<Integer>> r12 = r11.iterator();
        int r3 = 0;
    L7:
        if (r12.hasNext() == false) goto L26;
        List<Integer> r4 = r12.next();
        if (r4 == null) goto L7;
        if (r4.size() < 5) goto L7;
        if (r3 != 0) goto L16;
        r1.smallCoreLow = r4.get(0).intValue();
        r1.smallCoreMidLow = r4.get(1).intValue();
        r1.smallCoreMidHigh = r4.get(2).intValue();
        r1.smallCoreHigh = r4.get(3).intValue();
        float r9 = r4.get(4).intValue();
        r1.smallCoreLow = r9;
        r1.smallCoreSum = r9;
    L16:
        if (r3 != 1) goto L19;
        if (r10 == false) goto L19;
        r1.middleCoreLow = r4.get(0).intValue();
        r1.middleCoreMidLow = r4.get(1).intValue();
        r1.middleCoreMidHigh = r4.get(2).intValue();
        r1.middleCoreHigh = r4.get(3).intValue();
        r1.middleCoreSum = r4.get(4).intValue();
    L19:
        if (r3 != 1) goto L22;
        if (r0 == false) goto L22;
        r1.middleCoreLow = 0.0f;
        r1.middleCoreMidLow = 0.0f;
        r1.middleCoreMidHigh = 0.0f;
        r1.middleCoreHigh = 0.0f;
        r1.middleCoreSum = 0.0f;
        r1.bigCoreLow = r4.get(0).intValue();
        r1.bigCoreMidLow = r4.get(1).intValue();
        r1.bigCoreMidHigh = r4.get(2).intValue();
        r1.bigCoreHigh = r4.get(3).intValue();
        r1.bigCoreSum = r4.get(4).intValue();
    L22:
        if (r3 != 2) goto L25;
        if (r10 == false) goto L25;
        r1.bigCoreLow = r4.get(0).intValue();
        r1.bigCoreMidLow = r4.get(1).intValue();
        r1.bigCoreMidHigh = r4.get(2).intValue();
        r1.bigCoreHigh = r4.get(3).intValue();
        r1.bigCoreSum = r4.get(4).intValue();
    L25:
        r3 = r3 + 1;
        goto L7
    L26:
        return r1;
    }

    public IAssistStat.CpuTimePercent getProcessCpuTimePercent() {
        if (this.mAssistStat.getConfig().isEnableProcessTimeFreqPercent() == true) goto L5;
        return null;
    L5:
        return generateCpuTimePercentFromList(getProcessCpuTimeFreqPercent());
    }

    public IAssistStat.CpuTimePercent getThreadCpuTimePercent(int r2) {
        if (this.mAssistStat.getConfig().isEnableProcessTimeFreqPercent() == true) goto L5;
        return null;
    L5:
        return generateCpuTimePercentFromList(getThreadCpuTimeFreqPercent(r2));
    }

    public IAssistStat.CpuTimePercent getSystemCpuTimePercent() {
        if (this.mAssistStat.getConfig().isEnableSystemCpuTimeFreqPercent() == true) goto L5;
        return null;
    L5:
        if (this.mAssistStat.getConfig().isEnableCpuUsageStat() == true) goto L7;
        return null;
    L7:
        return generateCpuTimePercentFromList(getSystemCpuTimeFreqPercent());
    }
}
