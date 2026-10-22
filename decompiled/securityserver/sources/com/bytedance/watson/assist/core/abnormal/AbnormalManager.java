package com.bytedance.watson.assist.core.abnormal;

import android.os.SystemClock;
import com.bytedance.watson.assist.api.AssistConfig;
import com.bytedance.watson.assist.api.IAssistStat;
import com.bytedance.watson.assist.utils.DebugLog;

/* JADX INFO: loaded from: classes.dex */
public class AbnormalManager {
    private static final long UPDATE_TIME = 5000;
    private IAssistStat mAssistStat;
    private boolean mIsCpuSampleEnvironment;
    private long mLastUpdate;

    public AbnormalManager(IAssistStat r2) {
        this.mIsCpuSampleEnvironment = false;
        this.mAssistStat = r2;
    }

    private void updateCpuSampleEnvironment() {
        long r0 = SystemClock.elapsedRealtime();
        long r2 = this.mLastUpdate;
        if (r2 != 0) goto L5;
    L6:
        this.mLastUpdate = r0;
        float r1 = this.mAssistStat.getBatteryTemperature();
        int r3 = this.mAssistStat.getBatteryLevel();
        int r4 = this.mAssistStat.isPowerSaveMode();
        boolean r5 = false;
        if (r1 <= this.mAssistStat.getConfig().getCpuSampleBatteryTemp()) goto L9;
        boolean r6 = false;
    L11:
        if (r3 >= this.mAssistStat.getConfig().getCpuSampleBatteryLevel()) goto L13;
        r6 = false;
    L13:
        if (r4 == 1) goto L16;
        r5 = r6;
    L16:
        DebugLog.i("updateCpuSampleEnvironment:" + r5 + ", temp:" + r1 + ", level:" + r3 + ", powerSave:" + r4);
        this.mIsCpuSampleEnvironment = r5;
        return;
    L9:
        r6 = true;
        goto L11
    L5:
        if ((r0 - r2) >= 5000) goto L6;
    }

    public boolean isAbnormalProcess() {
        if (isCpuSampleEnvironment() == true) goto L6;
        return false;
    L6:
        return true;
    }

    public boolean isAbnormalThread(int r1) {
        return false;
    }

    public boolean isCpuSampleEnvironment() {
        updateCpuSampleEnvironment();
        return this.mIsCpuSampleEnvironment;
    }

    public boolean isAbnormalProcess(float r10) {
        if (isCpuSampleEnvironment() == true) goto L6;
        DebugLog.i("isAbnormalProcess false, cpuSpeed " + r10 + ", not sample environment");
        return false;
    L6:
        AssistConfig.CpuAbnormalConfig r0 = this.mAssistStat.getConfig().getCpuAbnormalConfig();
        if (r0 != null) goto L10;
        DebugLog.i("isAbnormalProcess true, cpuSpeed " + r10 + ", configSpeed:null");
        return true;
    L10:
        float r4 = r0.getCpuSpeed();
        float r1 = r0.getBigCpuCoreTimePercent();
        if (r10 >= r4) goto L13;
        return false;
    L13:
        if (r1 <= 0.0d) goto L20;
        IAssistStat.CpuTimePercent r9 = this.mAssistStat.getProcessCpuTimePercent();
        if (r9 == null) goto L20;
        DebugLog.i("isAbnormalProcess true, cpuSpeed " + r10 + ", configSpeed:" + r4 + ", bigCorePercent:" + r9.bigCoreSum + ", config bigCorePercent:" + r1);
        if (r9.bigCoreSum > r1) goto L19;
        return false;
    L19:
        return true;
    L20:
        DebugLog.i("isAbnormalProcess true, cpuSpeed " + r10 + ", configSpeed:" + r4);
        return true;
    }
}
