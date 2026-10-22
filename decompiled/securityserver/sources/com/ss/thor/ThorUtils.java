package com.ss.thor;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;

/* JADX INFO: loaded from: classes2.dex */
public class ThorUtils {
    private static IntentFilter ifilter;
    private static BatteryManager mBatteryManager;

    static {
        ifilter = new IntentFilter("android.intent.action.BATTERY_CHANGED");
    }

    public ThorUtils() {
    }

    private static BatteryManager getBatteryManager(Context r2) {
        if (mBatteryManager != null) goto L16;
        monitor-enter(ThorUtils.class);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (mBatteryManager != null) goto L11;
        mBatteryManager = (BatteryManager) r2.getSystemService("batterymanager");     // Catch: Throwable -> L9
    L11:
        monitor-exit(ThorUtils.class);     // Catch: Throwable -> L9
    L16:
        return mBatteryManager;
    }

    public static long getCapacity(Context r2) {
        if (r2 != null) goto L5;
        return -1;
    L5:
        BatteryManager r3 = getBatteryManager(r2);
        if (r3 != null) goto L9;
        return -1;
    L9:
        return r3.getLongProperty(4);
    }

    public static double getEnergy(Context r4) {
        if (r4 != null) goto L5;
        return -1.0d;
    L5:
        BatteryManager r5 = getBatteryManager(r4);
        if (r5 != null) goto L9;
        return -1.0d;
    L9:
        return (r5.getLongProperty(5) / 1.0E9d) / 1000.0d;
    }

    public static float getGalvanicAvg(Context r3) {
        if (r3 != null) goto L5;
        return -1.0f;
    L5:
        BatteryManager r4 = getBatteryManager(r3);
        if (r4 != null) goto L8;
        return -1.0f;
    L8:
        float r5 = r4.getLongProperty(3);
        if (Utils.isSihi() == true) goto L22;
        if (Utils.isSamsung() == true) goto L22;
        if (Utils.isOppo() == false) goto L20;
        if (r5 > 10000.0f) goto L18;
        return r5;
    L18:
        return r5 / 1000.0f;
    L20:
        return r5 / 1000.0f;
    L22:
        if (r5 >= (-1.0E7f)) goto L24;
    L31:
        return -1.0f;
    L24:
        if (r5 > 1.0E7f) goto L31;
        if (r5 >= (-10000.0f)) goto L30;
        r5 = r5 / 1000.0f;
    L30:
        return -r5;
    }

    public static float getGalvanicNow(Context r3) {
        if (r3 != null) goto L5;
        return -1.0f;
    L5:
        BatteryManager r4 = getBatteryManager(r3);
        if (r4 != null) goto L8;
        return -1.0f;
    L8:
        float r5 = r4.getLongProperty(2);
        if (r5 >= (-1.0E7f)) goto L11;
    L31:
        return -1.0f;
    L11:
        if (r5 > 1.0E7f) goto L31;
        if (Utils.isSihi() == true) goto L27;
        if (Utils.isSamsung() == true) goto L27;
        if (Utils.isOppo() == false) goto L25;
        if (r5 > 10000.0f) goto L23;
        return r5;
    L23:
        return r5 / 1000.0f;
    L25:
        return r5 / 1000.0f;
    L27:
        if (r5 >= (-10000.0f)) goto L30;
        r5 = r5 / 1000.0f;
    L30:
        return -r5;
    }

    public static double getUseBattery(Context r4) {
        return (((double) getGalvanicNow(r4)) * 0.5d) / 3600.0d;
    }

    public static float getVoltage(Context r3) {
        if (r3 != null) goto L5;
        return -1.0f;
    L5:
        Intent r4 = r3.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (r4 != null) goto L9;
        return -1.0f;
    L9:
        return r4.getIntExtra("voltage", -1) / 1000.0f;
    }
}
