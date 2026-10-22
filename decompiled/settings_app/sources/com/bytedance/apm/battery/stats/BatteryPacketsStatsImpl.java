package com.bytedance.apm.battery.stats;

import com.bytedance.apm.ApmContext;
import com.bytedance.apm.battery.BatteryCollector;
import com.bytedance.apm.battery.config.BatteryTypeInf;
import com.bytedance.apm.battery.internal.BatteryStatsRet;
import com.bytedance.apm.entity.BatteryLogEntity;
import com.bytedance.apm.logging.DebugLogger;
import com.bytedance.apm.logging.Logger;
import com.bytedance.apm.perf.traffic.TrafficStatisticWrapper;
import com.bytedance.services.apm.api.EnsureManager;

/* JADX INFO: loaded from: classes3.dex */
public class BatteryPacketsStatsImpl extends AbsBatteryValueStats {
    private volatile long mLastBackPackets;
    private volatile long mLastFrontPackets;
    private TrafficStatisticWrapper mTrafficStatisticWrapper;

    public BatteryPacketsStatsImpl() {
        super(BatteryTypeInf.BATTERY_PACKETS);
        this.mLastFrontPackets = -1;
        this.mLastBackPackets = -1;
        this.mTrafficStatisticWrapper = TrafficStatisticWrapper.getInstance();
    }

    @Override // com.bytedance.apm.battery.stats.AbsBatteryValueStats
    protected void computeValue(boolean r3, boolean r4) {
        if (isMainProcess() == false) goto L14;
        handlePacketsMonitor(r4);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        if (ApmContext.isDebugMode() == false) goto L10;
        Logger.i(DebugLogger.TAG_BATTERY, new String[]{"handleTrafficMonitor error: " + th.getCause()});
    L10:
        EnsureManager.ensureNotReachHere(th, "BatteryPacketsStatsImpl");
        return;
    }

    private void handlePacketsMonitor(boolean r9) {
        long r0 = this.mTrafficStatisticWrapper.getFrontPackets();
        long r2 = this.mTrafficStatisticWrapper.getBackPackets();
        if (this.mLastBackPackets > (-1)) goto L5;
    L8:
        this.mLastFrontPackets = r0;
        this.mLastBackPackets = r2;
        return;
    L5:
        if (this.mLastFrontPackets <= (-1)) goto L8;
        if (r9 == false) goto L8;
        String r10 = BatteryCollector.getInstance().getCurSceneSetStr();
        saveData(true, r0 - this.mLastFrontPackets, r10);
        saveData(false, r2 - this.mLastBackPackets, r10);
        goto L8
    }

    @Override // com.bytedance.apm.battery.stats.IBatteryStats
    public void updateStatsRet(BatteryStatsRet r3, BatteryLogEntity r4) {
        if (r4.isFront() == false) goto L5;
        r3.addFrontTrafficPackets(r4.getAccumulation());
        return;
    L5:
        r3.addBackTrafficPackets(r4.getAccumulation());
    }
}
