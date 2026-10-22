package com.bytedance.watson.assist.core.battery;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.PowerManager;
import android.os.SystemClock;
import com.bytedance.apm.battery.config.BatteryTypeInf;
import com.bytedance.apm.constant.CommonServiceName;
import com.bytedance.watson.assist.api.IAssistStat;
import com.bytedance.watson.assist.core.BaseInfoManager;

/* JADX INFO: loaded from: classes.dex */
public class BatteryInfoManager extends BaseInfoManager {
    private static final long UPDATE_TIME = 5000;
    private int mBatteryLevel;
    private BatteryManager mBatteryManager;
    private int mBatteryStatus;
    private float mBatteryTemperature;
    private boolean mIsCharging;
    private long mLastUpdate;
    private PowerManager mPowerManager;

    public BatteryInfoManager(Context r1, IAssistStat r2) {
        super(r1, r2);
        this.mIsCharging = false;
        this.mBatteryStatus = -1;
        this.mBatteryLevel = 0;
        this.mBatteryTemperature = 0.0f;
        this.mLastUpdate = 0;
        this.mPowerManager = (PowerManager) this.mContext.getSystemService(BatteryTypeInf.BATTERY_POWER_LOCK);
        this.mBatteryManager = (BatteryManager) this.mContext.getSystemService("batterymanager");
    }

    private int getPowerSaveModeState() {
        PowerManager r0 = this.mPowerManager;
        if (r0 != null) goto L5;
        return -1;
    L5:
        return r0.isPowerSaveMode() ? 1 : 0;
    }

    private boolean isPowerPlugIn() {
        BatteryManager r0 = this.mBatteryManager;
        if (r0 != null) goto L5;
        return false;
    L5:
        return r0.isCharging();
    }

    private synchronized void updateBatteryIntent() {
        monitor-enter(this);
        long r0 = SystemClock.elapsedRealtime();     // Catch: Throwable -> L18
        long r2 = this.mLastUpdate;     // Catch: Throwable -> L18
        if (r2 != 0) goto L6;
    L7:
        this.mLastUpdate = r0;     // Catch: Throwable -> L18
        Intent r1 = this.mContext.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));     // Catch: Throwable -> L18
        if (r1 != null) goto L11;
        monitor-exit(this);
        return;
    L11:
        int r3 = r1.getIntExtra("status", -1);     // Catch: Throwable -> L18
        this.mBatteryStatus = r3;     // Catch: Throwable -> L18
        if (r3 != 2) goto L14;
    L21:
        boolean r4 = true;
    L22:
        this.mIsCharging = r4;     // Catch: Throwable -> L18
        this.mBatteryLevel = r1.getIntExtra("level", 0);     // Catch: Throwable -> L18
        this.mBatteryTemperature = r1.getIntExtra(CommonServiceName.MONITOR_TYPE_TEMPERATURE, 0) / 10.0f;     // Catch: Throwable -> L18
    L23:
        monitor-exit(this);
        return;
    L14:
        if (r3 == 5) goto L16;
    L20:
        r4 = false;
        goto L22
    L16:
        if (isPowerPlugIn() == false) goto L20;
    L6:
        if ((r0 - r2) < 5000) goto L23;
    L18:
        th = move-exception;
        throw th;
    }

    public int getBatteryLevel() {
        updateBatteryIntent();
        return this.mBatteryLevel;
    }

    public float getBatteryTemperature() {
        updateBatteryIntent();
        return this.mBatteryTemperature;
    }

    public boolean isCharging() {
        updateBatteryIntent();
        return this.mIsCharging;
    }

    public int isPowerSaveMode() {
        return getPowerSaveModeState();
    }
}
