package com.bytedance.apm.battery.stats;

import a.a;
import com.bytedance.apm.ApmContext;
import com.bytedance.apm.battery.config.Constants;
import com.bytedance.apm.battery.internal.BatteryDataManager;
import com.bytedance.apm.battery.util.BatteryUtils;
import com.bytedance.apm.core.ActivityLifeObserver;
import com.bytedance.apm.entity.BatteryLogEntity;
import com.bytedance.apm.logging.ApmAlogHelper;
import com.bytedance.apm.logging.DebugLogger;
import com.bytedance.apm.logging.Logger;

/* JADX INFO: loaded from: classes.dex */
public abstract class AbsBatteryValueStats implements IBatteryStats {
    volatile boolean mIsCharging;
    volatile boolean mIsFront;
    private final String mType;
    private final boolean mainProcess;

    public AbsBatteryValueStats(String r1) {
        this.mType = r1;
        this.mainProcess = ApmContext.isMainProcess();
        this.mIsFront = ActivityLifeObserver.getInstance().isForeground();
        this.mIsCharging = BatteryUtils.isCharging(ApmContext.getContext());
    }

    public abstract void computeValue(boolean r1, boolean r2);

    public boolean isMainProcess() {
        return this.mainProcess;
    }

    @Override // com.bytedance.apm.battery.stats.IBatteryStats
    public void onBack(boolean r2) {
        computeValue(this.mIsFront, r2);
        this.mIsFront = false;
    }

    @Override // com.bytedance.apm.battery.stats.IBatteryStats
    public void onChargeStatusChange(boolean r2, boolean r3) {
        computeValue(this.mIsFront, r3);
        this.mIsCharging = r2;
    }

    @Override // com.bytedance.apm.battery.stats.IBatteryStats
    public void onFront(boolean r2) {
        computeValue(this.mIsFront, r2);
        this.mIsFront = true;
    }

    @Override // com.bytedance.apm.battery.stats.IBatteryStats
    public void onTimer(boolean r2) {
        computeValue(this.mIsFront, r2);
    }

    public void saveData(boolean r11, long r12, String r14) {
        if (r12 < 0) goto L5;
        BatteryLogEntity r9 = new BatteryLogEntity(r11, System.currentTimeMillis(), this.mType, this.mIsCharging, r12, r14);
        BatteryDataManager.getInstance().record(r9);
        return;
    L5:
        if (ApmContext.isDebugMode() == false) goto L7;
        String r13 = DebugLogger.TAG_BATTERY;
        StringBuilder r1 = a.s("AbsBatteryValueStats value error: ", r12, " type:");
        r1.append(this.mType);
        Logger.i(r13, new String[]{r1.toString()});
    L7:
        StringBuilder r15 = a.s("AbsBatteryValueStats value error: ", r12, " type:");
        r15.append(this.mType);
        ApmAlogHelper.i(Constants.TAG_BATTERY, r15.toString());
    }

    @Override // com.bytedance.apm.battery.stats.IBatteryStats
    public void startSceneMonitor(String r1, boolean r2) {
        computeValue(this.mIsFront, r2);
    }

    @Override // com.bytedance.apm.battery.stats.IBatteryStats
    public void stopSceneMonitor(String r1, boolean r2) {
        computeValue(this.mIsFront, r2);
    }
}
