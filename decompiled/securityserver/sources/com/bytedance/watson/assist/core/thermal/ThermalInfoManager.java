package com.bytedance.watson.assist.core.thermal;

import android.content.Context;
import android.os.PowerManager;
import com.bytedance.apm.battery.config.BatteryTypeInf;
import com.bytedance.watson.assist.api.IAssistStat;
import com.bytedance.watson.assist.core.BaseInfoManager;

/* JADX INFO: loaded from: classes.dex */
public class ThermalInfoManager extends BaseInfoManager {
    private PowerManager mPowerManager;

    public ThermalInfoManager(Context r1, IAssistStat r2) {
        super(r1, r2);
        this.mPowerManager = (PowerManager) this.mContext.getSystemService(BatteryTypeInf.BATTERY_POWER_LOCK);
    }

    public int getCurrentThermalStatus() {
        PowerManager r0 = this.mPowerManager;
        if (r0 != null) goto L5;
        return -1;
    L5:
        return r0.getCurrentThermalStatus();
    }
}
