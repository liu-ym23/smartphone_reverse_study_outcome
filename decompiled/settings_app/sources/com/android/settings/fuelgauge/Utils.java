package com.android.settings.fuelgauge;

import android.content.Context;
import com.android.settings.PreferenceMgr;
import com.android.settings.R;

/* JADX INFO: loaded from: classes2.dex */
public class Utils {
    public static final String FIRST_PLUGGED_TIME = "first_plugged_time";
    private static final String REPORT_DAILY_POWER_USAGE_TIME = "report_daily_power_usage_time";
    public static final String SAVE_POWER_MAX_TIME = "save_power_max_time";
    private static final int SECONDS_PER_DAY = 86400;
    private static final int SECONDS_PER_HOUR = 3600;
    private static final int SECONDS_PER_MINUTE = 60;
    public static final String SYNC_POWER_TO_CLOUD_TIME = "first_plugged_time";

    public Utils() {
    }

    public static String formatElapsedTime(Context r7, double r8, boolean r10) {
        StringBuilder r0 = new StringBuilder();
        int r9 = (int) Math.floor(r8 / 1000.0d);
        if (r10 == true) goto L6;
        r9 = r9 + 30;
    L6:
        if (r9 <= 86400) goto L8;
        int r2 = r9 / 86400;
        r9 = r9 - (86400 * r2);
    L10:
        if (r9 <= 3600) goto L12;
        int r11 = r9 / 3600;
        r9 = r9 - (r11 * 3600);
    L14:
        if (r9 <= 60) goto L16;
        int r3 = r9 / 60;
        r9 = r9 - (r3 * 60);
    L18:
        if (r10 == false) goto L26;
        if (r2 <= 0) goto L21;
        r0.append(r7.getString(R.string.battery_history_days, new Object[]{Integer.valueOf(r2), Integer.valueOf(r11), Integer.valueOf(r3), Integer.valueOf(r9)}));
    L32:
        return r0.toString();
    L21:
        if (r11 <= 0) goto L23;
        r0.append(r7.getString(R.string.battery_history_hours, new Object[]{Integer.valueOf(r11), Integer.valueOf(r3), Integer.valueOf(r9)}));
        goto L32
    L23:
        if (r3 <= 0) goto L25;
        r0.append(r7.getString(R.string.battery_history_minutes, new Object[]{Integer.valueOf(r3), Integer.valueOf(r9)}));
        goto L32
    L25:
        r0.append(r7.getString(R.string.battery_history_seconds, new Object[]{Integer.valueOf(r9)}));
        goto L32
    L26:
        if (r2 <= 0) goto L28;
        r0.append(r7.getString(R.string.battery_history_days_no_seconds, new Object[]{Integer.valueOf(r2), Integer.valueOf(r11), Integer.valueOf(r3)}));
        goto L32
    L28:
        if (r11 <= 0) goto L30;
        r0.append(r7.getString(R.string.battery_history_hours_no_seconds, new Object[]{Integer.valueOf(r11), Integer.valueOf(r3)}));
        goto L32
    L30:
        r0.append(r7.getString(R.string.battery_history_minutes_no_seconds, new Object[]{Integer.valueOf(r3)}));
        goto L32
    L16:
        r3 = 0;
        goto L18
    L12:
        r11 = 0;
        goto L14
    L8:
        r2 = 0;
        goto L10
    }

    public static long getUnplugedTime(Context r3) {
        return PreferenceMgr.getInstance(r3).getLong("first_plugged_time", System.currentTimeMillis());
    }

    public static void setUnplugedTime(Context r1, long r2) {
        PreferenceMgr.getInstance(r1).putLong("first_plugged_time", r2);
    }

    public static long getSyncPowerCloudTime(Context r3) {
        return PreferenceMgr.getInstance(r3).getLong("first_plugged_time", 0);
    }

    public static void setSyncPowerCloudTime(Context r1, long r2) {
        PreferenceMgr.getInstance(r1).putLong("first_plugged_time", r2);
    }

    public static long getSavePowerMaxTime(Context r3) {
        return PreferenceMgr.getInstance(r3).getLong(SAVE_POWER_MAX_TIME, System.currentTimeMillis());
    }

    public static void setSavePowerMaxTime(Context r1, long r2) {
        PreferenceMgr.getInstance(r1).putLong(SAVE_POWER_MAX_TIME, r2);
    }

    public static void setReportDailyPowerUsageTime(Context r1, long r2) {
        PreferenceMgr.getInstance(r1).putLong(REPORT_DAILY_POWER_USAGE_TIME, r2);
    }

    public static long getReportDailyPowerUsageTime(Context r3) {
        return PreferenceMgr.getInstance(r3).getLong(REPORT_DAILY_POWER_USAGE_TIME, 0);
    }
}
