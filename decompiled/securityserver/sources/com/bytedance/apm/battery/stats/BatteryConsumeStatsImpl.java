package com.bytedance.apm.battery.stats;

import android.os.BatteryManager;
import androidx.annotation.RequiresApi;
import com.bytedance.apm.ApmContext;
import com.bytedance.apm.battery.BatteryCollector;
import com.bytedance.apm.battery.config.BatteryTypeInf;
import com.bytedance.apm.battery.internal.BatteryStatsRet;
import com.bytedance.apm.entity.BatteryLogEntity;
import com.bytedance.apm.logging.DebugLogger;
import com.bytedance.apm.logging.Logger;
import com.bytedance.services.apm.api.EnsureManager;

/* JADX INFO: loaded from: classes.dex */
public class BatteryConsumeStatsImpl extends AbsBatteryValueStats {
    private boolean hasFirstData;
    private final BatteryManager mBatterManager;
    private int mLastBatteryCapacity;

    @RequiresApi(api = 21)
    public BatteryConsumeStatsImpl() {
        super(BatteryTypeInf.BATTERY_CONSUME);
        this.hasFirstData = false;
        this.mLastBatteryCapacity = -1;
        this.mBatterManager = (BatteryManager) ApmContext.getContext().getSystemService("batterymanager");
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

    @Override // com.bytedance.apm.battery.stats.AbsBatteryValueStats
    public void computeValue(boolean r2, boolean r3) {
        if (isMainProcess() == true) goto L5;
        return;
    L5:
        if (r2 == true) goto L20;
    L12:
        boolean r4 = true;
    L13:
        handleBatteryConsumeMonitor(r3, r4);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        if (ApmContext.isDebugMode() == false) goto L18;
        Logger.i(DebugLogger.TAG_BATTERY, new String[]{"BatteryConsumeStatsImpl error: " + th.getCause()});
    L18:
        EnsureManager.ensureNotReachHere("BatteryConsumeStatsImpl");
        return;
    L20:
        if (this.mIsCharging == true) goto L12;
        r4 = false;
        goto L13
    }

    @Override // com.bytedance.apm.battery.stats.IBatteryStats
    public void updateStatsRet(BatteryStatsRet r5, BatteryLogEntity r6) {
        r5.addBatteryConsume(r6.getAccumulation() / 1000);
    }
}
