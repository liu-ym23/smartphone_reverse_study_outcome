package com.bytedance.apm.battery.stats;

import com.bytedance.apm.ApmContext;
import com.bytedance.apm.battery.BatteryCollector;
import com.bytedance.apm.battery.internal.BatteryStatsRet;
import com.bytedance.apm.entity.BatteryLogEntity;
import com.bytedance.apm.logging.DebugLogger;
import com.bytedance.apm.logging.Logger;
import com.bytedance.apm.perf.traffic.TrafficStatisticWrapper;
import com.bytedance.services.apm.api.EnsureManager;

/* JADX INFO: loaded from: classes3.dex */
public class BatteryTrafficStatsImpl extends AbsBatteryValueStats {
    private volatile long mLastBackBytes;
    private volatile long mLastFrontBytes;
    private TrafficStatisticWrapper mTrafficStatisticWrapper;

    public BatteryTrafficStatsImpl() {
        super("traffic");
        this.mLastFrontBytes = -1;
        this.mLastBackBytes = -1;
        this.mTrafficStatisticWrapper = TrafficStatisticWrapper.getInstance();
    }

    @Override // com.bytedance.apm.battery.stats.AbsBatteryValueStats
    protected void computeValue(boolean r3, boolean r4) {
        if (isMainProcess() == false) goto L14;
        handleTrafficMonitor(r4);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        if (ApmContext.isDebugMode() == false) goto L10;
        Logger.i(DebugLogger.TAG_BATTERY, new String[]{"handleTrafficMonitor error: " + th.getCause()});
    L10:
        EnsureManager.ensureNotReachHere(th, "BatteryTrafficStatsImpl");
        return;
    }

    private void handleTrafficMonitor(boolean r9) {
        long r0 = this.mTrafficStatisticWrapper.getFrontBytes();
        long r2 = this.mTrafficStatisticWrapper.getBackBytes();
        if (this.mLastBackBytes > (-1)) goto L5;
    L8:
        this.mLastFrontBytes = r0;
        this.mLastBackBytes = r2;
        return;
    L5:
        if (this.mLastFrontBytes <= (-1)) goto L8;
        if (r9 == false) goto L8;
        String r10 = BatteryCollector.getInstance().getCurSceneSetStr();
        saveData(true, r0 - this.mLastFrontBytes, r10);
        saveData(false, r2 - this.mLastBackBytes, r10);
        goto L8
    }

    @Override // com.bytedance.apm.battery.stats.IBatteryStats
    public void updateStatsRet(BatteryStatsRet r3, BatteryLogEntity r4) {
        if (r4.isFront() == false) goto L5;
        r3.addFrontTrafficBytes(r4.getAccumulation());
        return;
    L5:
        r3.addBackTrafficBytes(r4.getAccumulation());
    }
}
