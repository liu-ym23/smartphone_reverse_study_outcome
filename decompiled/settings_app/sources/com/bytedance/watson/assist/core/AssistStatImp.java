package com.bytedance.watson.assist.core;

import android.content.Context;
import com.bytedance.watson.assist.api.AssistConfig;
import com.bytedance.watson.assist.api.IAssistStat;
import com.bytedance.watson.assist.core.abnormal.AbnormalManager;
import com.bytedance.watson.assist.core.battery.BatteryInfoManager;
import com.bytedance.watson.assist.core.cpu.CpuInfoManager;
import com.bytedance.watson.assist.core.cpu.ThreadStatInfo;
import com.bytedance.watson.assist.core.thermal.ThermalInfoManager;
import com.bytedance.watson.assist.utils.CpuUtils;
import com.bytedance.watson.assist.utils.DebugLog;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class AssistStatImp implements IAssistStat {
    private static volatile AssistStatImp mInstance;
    private AbnormalManager mAbnormalManager;
    private BatteryInfoManager mBatteryInfoManager;
    private AssistConfig mConfig;
    private Context mContext;
    private CpuInfoManager mCpuInfoManager;
    private ThermalInfoManager mThermalInfoManager;

    static {
    }

    private AssistStatImp(Context r2) {
        this(r2, AssistConfig.DEFAULT);
    }

    private AssistStatImp(Context r2, AssistConfig r3) {
        this.mContext = r2.getApplicationContext();
        if (r3 != null) goto L5;
        AssistConfig r4 = AssistConfig.DEFAULT;
    L6:
        this.mConfig = r4;
        this.mBatteryInfoManager = new BatteryInfoManager(this.mContext, this);
        this.mThermalInfoManager = new ThermalInfoManager(this.mContext, this);
        this.mCpuInfoManager = new CpuInfoManager(this.mContext, this);
        this.mAbnormalManager = new AbnormalManager(this);
        DebugLog.i("new assist obj:" + this + " config : " + r3);
        return;
    L5:
        r4 = r3;
        goto L6
    }

    public static AssistStatImp getInstance(Context r2) {
        if (mInstance != null) goto L15;
        monitor-enter(AssistStatImp.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (mInstance != null) goto L9;
        mInstance = new AssistStatImp(r2);     // Catch: Throwable -> L11
    L9:
        monitor-exit(AssistStatImp.class);     // Catch: Throwable -> L11
    L15:
        return mInstance;
    }

    public static AssistStatImp createNewInstance(Context r1, AssistConfig r2) {
        return new AssistStatImp(r1, r2);
    }

    @Override // com.bytedance.watson.assist.api.IAssistStat
    public IAssistStat start() {
        DebugLog.d("start, obj:" + this);
        this.mBatteryInfoManager.start();
        this.mThermalInfoManager.start();
        this.mCpuInfoManager.start();
        return this;
    }

    @Override // com.bytedance.watson.assist.api.IAssistStat
    public void end() {
        DebugLog.d("end, obj:" + this);
        this.mBatteryInfoManager.end();
        this.mThermalInfoManager.end();
        this.mCpuInfoManager.end();
    }

    @Override // com.bytedance.watson.assist.api.IAssistStat
    public AssistConfig getConfig() {
        return this.mConfig;
    }

    @Override // com.bytedance.watson.assist.api.IAssistStat
    public void updateConfig(AssistConfig r3) {
        if (r3 == null) goto L5;
        this.mConfig = r3;
        DebugLog.i("update config : " + r3 + ", obj:" + this);
        return;
    }

    @Override // com.bytedance.watson.assist.api.IAssistStat
    public String getCpuHardware() {
        return CpuUtils.getCpuHardware();
    }

    @Override // com.bytedance.watson.assist.api.IAssistStat
    public String getCpuHardwareFromProp() {
        return CpuUtils.getCpuHardwareFromProp();
    }

    @Override // com.bytedance.watson.assist.api.IAssistStat
    public double getSystemCpuUsage() {
        return this.mCpuInfoManager.getSystemCpuUsage();
    }

    @Override // com.bytedance.watson.assist.api.IAssistStat
    public double getProcCpuUsage() {
        return this.mCpuInfoManager.getProcCpuUsage();
    }

    @Override // com.bytedance.watson.assist.api.IAssistStat
    public double getProcCpuSpeed() {
        return this.mCpuInfoManager.getProcCpuSpeed();
    }

    @Override // com.bytedance.watson.assist.api.IAssistStat
    public double getThreadCpuSpeed(int r1) {
        return this.mCpuInfoManager.getThreadCpuSpeed(r1);
    }

    @Override // com.bytedance.watson.assist.api.IAssistStat
    public double getThreadCpuUsage(int r1) {
        return this.mCpuInfoManager.getThreadCpuUsage(r1);
    }

    @Override // com.bytedance.watson.assist.api.IAssistStat
    public List<LinkedHashMap<Long, Long>> getProcCpuTimeDetail() {
        return this.mCpuInfoManager.getProcCpuTimeDetail();
    }

    @Override // com.bytedance.watson.assist.api.IAssistStat
    public List<LinkedHashMap<Long, Long>> getThreadCpuTimeDetail(int r1) {
        return this.mCpuInfoManager.getThreadCpuTimeDetail(r1);
    }

    @Override // com.bytedance.watson.assist.api.IAssistStat
    public List<LinkedHashMap<Long, Long>> getSystemCpuTimeFreqDetail() {
        return this.mCpuInfoManager.getSystemCpuTimeFreqDetail();
    }

    @Override // com.bytedance.watson.assist.api.IAssistStat
    public List<List<Integer>> getProcessCpuTimeFreqPercent() {
        return this.mCpuInfoManager.getProcessCpuTimeFreqPercent();
    }

    @Override // com.bytedance.watson.assist.api.IAssistStat
    public List<List<Integer>> getThreadCpuTimeFreqPercent(int r1) {
        return this.mCpuInfoManager.getThreadCpuTimeFreqPercent(r1);
    }

    @Override // com.bytedance.watson.assist.api.IAssistStat
    public List<List<Integer>> getSystemCpuTimeFreqPercent() {
        return this.mCpuInfoManager.getSystemCpuTimeFreqPercent();
    }

    @Override // com.bytedance.watson.assist.api.IAssistStat
    public IAssistStat.CpuTimePercent getProcessCpuTimePercent() {
        return this.mCpuInfoManager.getProcessCpuTimePercent();
    }

    @Override // com.bytedance.watson.assist.api.IAssistStat
    public IAssistStat.CpuTimePercent getThreadCpuTimePercent(int r1) {
        return this.mCpuInfoManager.getThreadCpuTimePercent(r1);
    }

    @Override // com.bytedance.watson.assist.api.IAssistStat
    public IAssistStat.CpuTimePercent getSystemCpuTimePercent() {
        return this.mCpuInfoManager.getSystemCpuTimePercent();
    }

    @Override // com.bytedance.watson.assist.api.IAssistStat
    public ThreadStatInfo getThreadCpuStatInfo(int r1) {
        return this.mCpuInfoManager.getThreadCpuStatInfo(r1);
    }

    @Override // com.bytedance.watson.assist.api.IAssistStat
    public List<IAssistStat.CpuClusterFreqInfo> getCurrentCpuClusterFreqInfo() {
        List<CpuUtils.CpuClusterInfo> r9 = CpuUtils.getCpuClusterInfoList();
        if (r9 != null) goto L6;
        return null;
    L6:
        ArrayList r0 = new ArrayList();
        int r1 = r9.size();
        int r2 = 0;
    L7:
        if (r2 >= r1) goto L16;
        CpuUtils.CpuClusterInfo r3 = r9.get(r2);
        IAssistStat.CpuClusterFreqInfo r4 = new IAssistStat.CpuClusterFreqInfo();
        r4.name = r3.getName();
        r4.affectedCpuList = r3.getAffectedCpuList();
        r4.freqList = r3.getFreqList();
        r4.scalingMinFreq = CpuUtils.getClusterMaxFreq(r2);
        r4.scalingCurFreq = CpuUtils.getClusterCurrentFreq(r2);
        r4.scalingMaxFreq = CpuUtils.getClusterMaxFreq(r2);
        if (r4.scalingMinFreq == (-1)) goto L15;
        if (r4.scalingMaxFreq == (-1)) goto L15;
        if (r4.scalingMinFreq != r4.scalingMaxFreq) goto L15;
        r4.isLockFreq = true;
    L15:
        r4.scalingMinFreqLevel = CpuUtils.getFreqLevel(r2, r4.scalingMinFreq);
        r4.scalingCurFreqLevel = CpuUtils.getFreqLevel(r2, r4.scalingCurFreq);
        r4.scalingMaxFreqLevel = CpuUtils.getFreqLevel(r2, r4.scalingMaxFreq);
        r0.add(r4);
        r2 = r2 + 1;
        goto L7
    L16:
        return r0;
    }

    @Override // com.bytedance.watson.assist.api.IAssistStat
    public List<ThreadStatInfo> getSortedThreadStatInfoList() {
        return this.mCpuInfoManager.getSortedThreadStatInfoList();
    }

    @Override // com.bytedance.watson.assist.api.IAssistStat
    public List<ThreadStatInfo> getTopThreadCpuStatInfoList(int r1) {
        return this.mCpuInfoManager.getTopThreadCpuStatInfoList(r1);
    }

    @Override // com.bytedance.watson.assist.api.IAssistStat
    public boolean isCharging() {
        return this.mBatteryInfoManager.isCharging();
    }

    @Override // com.bytedance.watson.assist.api.IAssistStat
    public int isPowerSaveMode() {
        return this.mBatteryInfoManager.isPowerSaveMode();
    }

    @Override // com.bytedance.watson.assist.api.IAssistStat
    public int getBatteryLevel() {
        return this.mBatteryInfoManager.getBatteryLevel();
    }

    @Override // com.bytedance.watson.assist.api.IAssistStat
    public float getBatteryTemperature() {
        return this.mBatteryInfoManager.getBatteryTemperature();
    }

    @Override // com.bytedance.watson.assist.api.IAssistStat
    public int getCurrentThermalStatus() {
        return this.mThermalInfoManager.getCurrentThermalStatus();
    }

    @Override // com.bytedance.watson.assist.api.IAssistStat
    public void refreshCpuStat() {
        this.mCpuInfoManager.refresh();
    }

    @Override // com.bytedance.watson.assist.api.IAssistStat
    public boolean isCpuSampleEnvironment() {
        return this.mAbnormalManager.isCpuSampleEnvironment();
    }

    @Override // com.bytedance.watson.assist.api.IAssistStat
    public boolean isCpuAbnormalProcess(float r1) {
        return this.mAbnormalManager.isAbnormalProcess(r1);
    }

    @Override // com.bytedance.watson.assist.api.IAssistStat
    public boolean isCpuAbnormalProcess() {
        return this.mAbnormalManager.isAbnormalProcess();
    }

    @Override // com.bytedance.watson.assist.api.IAssistStat
    public boolean isCpuAbnormalThread(int r1) {
        return this.mAbnormalManager.isAbnormalThread(r1);
    }

    @Override // com.bytedance.watson.assist.api.IAssistStat
    public IAssistStat.CpuFactorTag getCpuFactorTag() {
        IAssistStat.CpuFactorTag r0 = new IAssistStat.CpuFactorTag();
        r0.cpuHardware = getCpuHardwareFromProp();
        r0.isCharging = isCharging();
        r0.batteryLevel = getBatteryLevel();
        r0.thermalStatus = getCurrentThermalStatus();
        r0.powerSaveMode = isPowerSaveMode();
        r0.batteryThermal = getBatteryTemperature();
        r0.processCpuTimeFreqPercent = getProcessCpuTimeFreqPercent();
        return r0;
    }

    @Override // com.bytedance.watson.assist.api.IAssistStat
    public void test(int r4) {
        test();
        DebugLog.d("get thread cpu usage :" + getThreadCpuUsage(r4));
        DebugLog.d("get thread cpu time detail :" + getThreadCpuTimeDetail(r4));
        DebugLog.d("get thread cpu time percent :" + getThreadCpuTimeFreqPercent(r4));
        DebugLog.d("get thread stat :" + getThreadCpuStatInfo(r4));
        DebugLog.d("get TopN thread stat :" + getTopThreadCpuStatInfoList(r4));
    }

    @Override // com.bytedance.watson.assist.api.IAssistStat
    public void test() {
        refreshCpuStat();
        StringBuilder r0 = new StringBuilder();
        r0.append(" get cpu hardware:" + getCpuHardware()).append("\n get cpu cur freq : " + CpuUtils.getClusterCurrentFreq(0)).append("\n get cpu max freq: " + CpuUtils.getClusterMaxFreq(0)).append("\n get cpu min freq: " + CpuUtils.getClusterMinFreq(0)).append("\n get process cpu usage : " + getProcCpuUsage()).append("\n get process cpu speed : " + getProcCpuSpeed()).append("\n get cluster info list : " + CpuUtils.getCpuClusterInfoList()).append("\n get cpu scaling max : " + CpuUtils.getClusterMaxFreq(1)).append("\n get cpu scaling max level: " + CpuUtils.getClusterMaxFreqLevel(1)).append("\n get process cpu time percent : " + getProcessCpuTimePercent()).append("\n getThreadInfoList:" + getSortedThreadStatInfoList()).append("\n getSystemCpuTimeFreqDetail:" + getSystemCpuTimeFreqDetail()).append("\n getSystemCpuTimeFreqPercent:" + getSystemCpuTimeFreqPercent()).append("\n getSystemCpuTimePercent:" + getSystemCpuTimePercent()).append("\n getSystemCpuUsage:" + getSystemCpuUsage()).append("\n getCurrentCpuClusterFreqInfo:" + getCurrentCpuClusterFreqInfo());
        DebugLog.i(r0.toString());
        DebugLog.toast(this.mContext, r0.toString());
    }
}
