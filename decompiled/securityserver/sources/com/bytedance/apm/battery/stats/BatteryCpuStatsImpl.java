package com.bytedance.apm.battery.stats;

import com.bytedance.apm.battery.BatteryCollector;
import com.bytedance.apm.battery.config.BatteryTypeInf;
import com.bytedance.apm.battery.config.Constants;
import com.bytedance.apm.battery.internal.BatteryStatsRet;
import com.bytedance.apm.entity.BatteryLogEntity;
import com.bytedance.apm.logging.ApmAlogHelper;
import com.bytedance.apm.util.CommonMonitorUtil;

/* JADX INFO: loaded from: classes.dex */
public class BatteryCpuStatsImpl extends AbsBatteryValueStats {
    private long mLastCpuActiveTime;

    public BatteryCpuStatsImpl() {
        super(BatteryTypeInf.BATTERY_CPU_ACTIVE);
        this.mLastCpuActiveTime = 0;
    }

    private long getJiffyHz() {
        return CommonMonitorUtil.getScClkTck(100);
    }

    @Override // com.bytedance.apm.battery.stats.AbsBatteryValueStats
    public void computeValue(boolean r8, boolean r9) {
        long r0 = CommonMonitorUtil.getAppCPUTime();
        long r2 = this.mLastCpuActiveTime;
        if (r2 <= 0) goto L9;
        if (r9 == false) goto L9;
        long r3 = r0 - r2;
        if (r3 <= 0) goto L8;
        saveData(r8, r3, BatteryCollector.getInstance().getCurSceneSetStr());
        goto L9
    L8:
        ApmAlogHelper.i(Constants.TAG_BATTERY, "CPU Value:" + r3);
    L9:
        this.mLastCpuActiveTime = r0;
    }

    @Override // com.bytedance.apm.battery.stats.IBatteryStats
    public void updateStatsRet(BatteryStatsRet r8, BatteryLogEntity r9) {
        if (r9.isFront() == false) goto L5;
        r8.addFrontCpuMs((long) ((r9.getAccumulation() / getJiffyHz()) * 1000.0d));
        return;
    L5:
        r8.addBackCpuMs((long) ((r9.getAccumulation() / getJiffyHz()) * 1000.0d));
    }
}
