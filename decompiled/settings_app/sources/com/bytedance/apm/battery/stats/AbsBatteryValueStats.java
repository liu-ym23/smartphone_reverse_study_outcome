package com.bytedance.apm.battery.stats;

import com.bytedance.apm.ApmContext;
import com.bytedance.apm.battery.config.Constants;
import com.bytedance.apm.battery.internal.BatteryDataManager;
import com.bytedance.apm.battery.util.BatteryUtils;
import com.bytedance.apm.core.ActivityLifeObserver;
import com.bytedance.apm.entity.BatteryLogEntity;
import com.bytedance.apm.logging.ApmAlogHelper;
import com.bytedance.apm.logging.DebugLogger;
import com.bytedance.apm.logging.Logger;

/* JADX INFO: loaded from: classes3.dex */
public abstract class AbsBatteryValueStats implements IBatteryStats {
    volatile boolean mIsCharging;
    volatile boolean mIsFront;
    private final String mType;
    private final boolean mainProcess;

    protected abstract void computeValue(boolean r1, boolean r2);

    AbsBatteryValueStats(String r1) {
        this.mType = r1;
        this.mainProcess = ApmContext.isMainProcess();
        this.mIsFront = ActivityLifeObserver.getInstance().isForeground();
        this.mIsCharging = BatteryUtils.isCharging(ApmContext.getContext());
    }

    protected boolean isMainProcess() {
        return this.mainProcess;
    }

    @Override // com.bytedance.apm.battery.stats.IBatteryStats
    public void onFront(boolean r2) {
        computeValue(this.mIsFront, r2);
        this.mIsFront = true;
    }

    @Override // com.bytedance.apm.battery.stats.IBatteryStats
    public void onBack(boolean r2) {
        computeValue(this.mIsFront, r2);
        this.mIsFront = false;
    }

    @Override // com.bytedance.apm.battery.stats.IBatteryStats
    public void onTimer(boolean r2) {
        computeValue(this.mIsFront, r2);
    }

    @Override // com.bytedance.apm.battery.stats.IBatteryStats
    public void onChargeStatusChange(boolean r2, boolean r3) {
        computeValue(this.mIsFront, r3);
        this.mIsCharging = r2;
    }

    @Override // com.bytedance.apm.battery.stats.IBatteryStats
    public void startSceneMonitor(String r1, boolean r2) {
        computeValue(this.mIsFront, r2);
    }

    @Override // com.bytedance.apm.battery.stats.IBatteryStats
    public void stopSceneMonitor(String r1, boolean r2) {
        computeValue(this.mIsFront, r2);
    }

    void saveData(boolean r11, long r12, String r14) {
        if (r12 < 0) goto L5;
        BatteryDataManager.getInstance().record(new BatteryLogEntity(r11, System.currentTimeMillis(), this.mType, this.mIsCharging, r12, r14));
        return;
    L5:
        if (ApmContext.isDebugMode() == false) goto L7;
        Logger.i(DebugLogger.TAG_BATTERY, new String[]{"AbsBatteryValueStats value error: " + r12 + " type:" + this.mType});
    L7:
        ApmAlogHelper.i(Constants.TAG_BATTERY, "AbsBatteryValueStats value error: " + r12 + " type:" + this.mType);
    }
}
