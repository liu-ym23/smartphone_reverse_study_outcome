package com.bytedance.apm.battery.stats;

import com.bytedance.apm.battery.internal.BatteryStatsRet;
import com.bytedance.apm.entity.BatteryLogEntity;

/* JADX INFO: loaded from: classes3.dex */
public interface IBatteryStats {
    void onBack(boolean r1);

    void onChargeStatusChange(boolean r1, boolean r2);

    void onFront(boolean r1);

    void onTimer(boolean r1);

    void startSceneMonitor(String r1, boolean r2);

    void stopSceneMonitor(String r1, boolean r2);

    void updateStatsRet(BatteryStatsRet r1, BatteryLogEntity r2);
}
