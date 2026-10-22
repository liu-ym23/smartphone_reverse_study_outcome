package com.bytedance.apm.battery.stats;

import android.os.BatteryManager;
import com.bytedance.apm.ApmContext;
import com.bytedance.apm.battery.BatteryCollector;
import com.bytedance.apm.battery.config.BatteryTypeInf;
import com.bytedance.apm.battery.internal.BatteryStatsRet;
import com.bytedance.apm.entity.BatteryLogEntity;
import com.bytedance.apm.logging.DebugLogger;
import com.bytedance.apm.logging.Logger;
import com.bytedance.services.apm.api.EnsureManager;

/* JADX INFO: loaded from: classes3.dex */
public class BatteryConsumeStatsImpl extends AbsBatteryValueStats {
    private boolean hasFirstData;
    private final BatteryManager mBatterManager;
    private int mLastBatteryCapacity;

    public BatteryConsumeStatsImpl() {
        super(BatteryTypeInf.BATTERY_CONSUME);
        this.hasFirstData = false;
        this.mLastBatteryCapacity = -1;
        this.mBatterManager = (BatteryManager) ApmContext.getContext().getSystemService("batterymanager");
    }

    @Override // com.bytedance.apm.battery.stats.AbsBatteryValueStats
    protected void computeValue(boolean r4, boolean r5) {
        if (isMainProcess() == true) goto L6;
        return;
    L6:
        if (r4 == true) goto L21;
    L13:
        boolean r6 = true;
    L14:
        handleBatteryConsumeMonitor(r5, r6);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        if (ApmContext.isDebugMode() == false) goto L19;
        Logger.i(DebugLogger.TAG_BATTERY, new String[]{"BatteryConsumeStatsImpl error: " + th.getCause()});
    L19:
        EnsureManager.ensureNotReachHere("BatteryConsumeStatsImpl");
        return;
    L21:
        if (this.mIsCharging == true) goto L13;
        r6 = false;
        goto L14
    }

    private void handleBatteryConsumeMonitor(boolean r4, boolean r5) {
        int r0 = this.mBatterManager.getIntProperty(1);
        if (r5 == true) goto L8;
        if (r4 == false) goto L8;
        if (this.hasFirstData == false) goto L8;
        saveData(true, Math.abs(r0 - this.mLastBatteryCapacity), BatteryCollector.getInstance().getCurSceneSetStr());
    L8:
        this.mLastBatteryCapacity = r0;
        this.hasFirstData = true;
    }

    @Override // com.bytedance.apm.battery.stats.IBatteryStats
    public void updateStatsRet(BatteryStatsRet r5, BatteryLogEntity r6) {
        r5.addBatteryConsume(r6.getAccumulation() / 1000);
    }
}
