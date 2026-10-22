package com.android.settingslib.fuelgauge;

import android.content.Context;
import android.content.Intent;
import com.android.settingslib.R;
import java.util.Optional;
import org.apache.commons.math3.geometry.VectorFormat;

/* JADX INFO: loaded from: classes.dex */
public class BatteryStatus {
    public static final int BATTERY_LEVEL_UNKNOWN = -1;
    public static final int CHARGING_FAST = 2;
    public static final int CHARGING_REGULAR = 1;
    public static final int CHARGING_SLOWLY = 0;
    public static final int CHARGING_UNKNOWN = -1;
    private static final int DEFAULT_CHARGING_VOLTAGE_MICRO_VOLT = 5000000;
    public static final int EXTREME_LOW_BATTERY_THRESHOLD = 3;
    public static final int LOW_BATTERY_THRESHOLD = 20;
    public static final int SEVERE_LOW_BATTERY_THRESHOLD = 10;
    public final int chargingStatus;
    public final Optional<Boolean> incompatibleCharger;
    public final int level;
    public final int maxChargingWattage;
    public final int plugged;
    public final boolean present;
    public final int status;

    public static boolean isBatteryDefender(int r1) {
        if (r1 != 4) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean isCharged(int r1, int r2) {
        if (r1 != 5) goto L5;
    L8:
        return true;
    L5:
        if (r2 >= 100) goto L8;
        return false;
    }

    public static boolean isExtremeLowBattery(int r1) {
        if (r1 > 3) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean isLowBattery(int r1) {
        if (r1 > 20) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean isPluggedIn(int r2) {
        if (r2 != 1) goto L5;
        return true;
    L5:
        if (r2 != 2) goto L7;
        return true;
    L7:
        if (r2 != 4) goto L9;
        return true;
    L9:
        if (r2 == 8) goto L16;
        return false;
    L16:
        return true;
    }

    public static boolean isPluggedInDock(int r1) {
        if (r1 != 8) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean isSevereLowBattery(int r1) {
        if (r1 > 10) goto L5;
        return true;
    L5:
        return false;
    }

    public static BatteryStatus create(Context r1, boolean r2) {
        Intent r3 = BatteryUtils.getBatteryIntent(r1);
        if (r3 != null) goto L6;
        return null;
    L6:
        return new BatteryStatus(r3, r2);
    }

    public BatteryStatus(int r1, int r2, int r3, int r4, int r5, boolean r6) {
        this.status = r1;
        this.level = r2;
        this.plugged = r3;
        this.chargingStatus = r4;
        this.maxChargingWattage = r5;
        this.present = r6;
        this.incompatibleCharger = Optional.empty();
    }

    public BatteryStatus(Intent r2) {
        this(r2, Optional.empty());
    }

    public BatteryStatus(Intent r1, boolean r2) {
        this(r1, Optional.of(Boolean.valueOf(r2)));
    }

    private BatteryStatus(Intent r4, Optional<Boolean> r5) {
        this.status = r4.getIntExtra("status", 1);
        this.plugged = r4.getIntExtra("plugged", 0);
        this.level = getBatteryLevel(r4);
        this.chargingStatus = r4.getIntExtra("android.os.extra.CHARGING_STATUS", 1);
        this.present = r4.getBooleanExtra("present", true);
        this.incompatibleCharger = r5;
        this.maxChargingWattage = calculateMaxChargingMicroWatt(r4);
    }

    public boolean isPluggedIn() {
        return isPluggedIn(this.plugged);
    }

    public boolean isPluggedInWired() {
        int r2 = this.plugged;
        if (r2 != 1) goto L5;
        return true;
    L5:
        if (r2 == 2) goto L10;
        return false;
    L10:
        return true;
    }

    public boolean isPluggedInWireless() {
        if (this.plugged != 4) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isPluggedInDock() {
        return isPluggedInDock(this.plugged);
    }

    public boolean isCharged() {
        return isCharged(this.status, this.level);
    }

    public boolean isBatteryLow() {
        return isLowBattery(this.level);
    }

    public boolean isBatteryDefender() {
        return isBatteryDefender(this.chargingStatus);
    }

    public final int getChargingSpeed(Context r3) {
        int r0 = r3.getResources().getInteger(R.integer.config_chargingSlowlyThreshold);
        int r4 = r3.getResources().getInteger(getFastChargingThresholdResId());
        int r2 = this.maxChargingWattage;
        if (r2 > 0) goto L5;
        return -1;
    L5:
        if (r2 >= r0) goto L7;
        return 0;
    L7:
        if (r2 <= r4) goto L9;
        return 2;
    L9:
        return 1;
    }

    public String toString() {
        return "BatteryStatus{status=" + this.status + ",level=" + this.level + ",plugged=" + this.plugged + ",chargingStatus=" + this.chargingStatus + ",maxChargingWattage=" + this.maxChargingWattage + VectorFormat.DEFAULT_SUFFIX;
    }

    public static boolean isCharged(Intent r2) {
        return isCharged(r2.getIntExtra("status", 1), getBatteryLevel(r2));
    }

    public static boolean isCharged(int r0, int r1, int r2) {
        return isCharged(r0, getBatteryLevel(r1, r2));
    }

    public static int getBatteryLevel(Intent r3) {
        if (r3 != null) goto L6;
        return -1;
    L6:
        return getBatteryLevel(r3.getIntExtra("level", -1), r3.getIntExtra("scale", 0));
    }

    public static int getBatteryLevel(int r0, int r1) {
        if (r1 != 0) goto L5;
        return -1;
    L5:
        return Math.round((r0 / r1) * 100.0f);
    }

    public static int getPluggedType(Intent r2) {
        return r2.getIntExtra("plugged", 0);
    }

    public static boolean isPluggedIn(Intent r0) {
        return isPluggedIn(getPluggedType(r0));
    }

    public static boolean isPluggedInDock(Intent r2) {
        return isPluggedInDock(r2.getIntExtra("plugged", 0));
    }

    public static boolean isLowBattery(Intent r0) {
        return isLowBattery(getBatteryLevel(r0));
    }

    public static boolean isSevereLowBattery(Intent r0) {
        return isSevereLowBattery(getBatteryLevel(r0));
    }

    public static boolean isExtremeLowBattery(Intent r0) {
        return isExtremeLowBattery(getBatteryLevel(r0));
    }

    public static boolean isBatteryDefender(Intent r2) {
        return isBatteryDefender(r2.getIntExtra("android.os.extra.CHARGING_STATUS", 1));
    }

    public static int getChargingSpeed(Context r3, Intent r4) {
        return calculateChargingSpeed(r3, r4.getIntExtra("max_charging_current", -1), r4.getIntExtra("max_charging_voltage", -1));
    }

    public static int calculateChargingSpeed(Context r1, int r2, int r3) {
        int r4 = calculateMaxChargingMicroWatt(r2, r3);
        if (r4 > 0) goto L7;
        return -1;
    L7:
        if (r4 >= r1.getResources().getInteger(R.integer.config_chargingSlowlyThreshold)) goto L11;
        return 0;
    L11:
        if (r4 <= r1.getResources().getInteger(getFastChargingThresholdResId())) goto L14;
        return 2;
    L14:
        return 1;
    }

    private static int calculateMaxChargingMicroWatt(Intent r3) {
        return calculateMaxChargingMicroWatt(r3.getIntExtra("max_charging_current", -1), r3.getIntExtra("max_charging_voltage", -1));
    }

    private static int calculateMaxChargingMicroWatt(int r4, int r5) {
        if (r5 > 0) goto L4;
        r5 = DEFAULT_CHARGING_VOLTAGE_MICRO_VOLT;
    L4:
        if (r4 > 0) goto L6;
        return -1;
    L6:
        return (int) Math.round(((((double) r4) * 0.001d) * ((double) r5)) * 0.001d);
    }

    private static int getFastChargingThresholdResId() {
        if (BatteryUtils.isChargingStringV2Enabled() == false) goto L6;
        return R.integer.config_chargingFastThreshold_v2;
    L6:
        return R.integer.config_chargingFastThreshold;
    }
}
