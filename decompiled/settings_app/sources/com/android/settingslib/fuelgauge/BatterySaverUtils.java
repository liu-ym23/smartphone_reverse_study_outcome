package com.android.settingslib.fuelgauge;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.PowerManager;
import android.provider.Settings;
import android.util.KeyValueListParser;
import android.util.Slog;

/* JADX INFO: loaded from: classes.dex */
public class BatterySaverUtils {
    public static final String ACTION_SHOW_AUTO_SAVER_SUGGESTION = "PNW.autoSaverSuggestion";
    public static final String ACTION_SHOW_START_SAVER_CONFIRMATION = "PNW.startSaverConfirmation";
    private static final boolean DEBUG = false;
    public static final String EXTRA_CONFIRM_TEXT_ONLY = "extra_confirm_only";
    public static final String EXTRA_POWER_SAVE_MODE_TRIGGER = "extra_power_save_mode_trigger";
    public static final String EXTRA_POWER_SAVE_MODE_TRIGGER_LEVEL = "extra_power_save_mode_trigger_level";
    public static final String KEY_NO_SCHEDULE = "key_battery_saver_no_schedule";
    public static final String KEY_PERCENTAGE = "key_battery_saver_percentage";
    private static final String SYSUI_PACKAGE = "com.android.systemui";
    private static final String TAG = "BatterySaverUtils";

    private static class Parameters {
        private static final int AUTO_SAVER_SUGGESTION_END_NTH = 8;
        private static final int AUTO_SAVER_SUGGESTION_START_NTH = 4;
        public final int endNth;
        private final Context mContext;
        public final int startNth;

        public Parameters(Context r4) {
            this.mContext = r4;
            String r5 = Settings.Global.getString(r4.getContentResolver(), "low_power_mode_suggestion_params");
            KeyValueListParser r0 = new KeyValueListParser(',');
            r0.setString(r5);     // Catch: IllegalArgumentException -> L5
        L6:
            this.startNth = r0.getInt("start_nth", 4);
            this.endNth = r0.getInt("end_nth", 8);
            return;
        L5:
            Slog.wtf(BatterySaverUtils.TAG, "Bad constants: " + r5);
            goto L6
        }
    }

    private BatterySaverUtils() {
    }

    public static synchronized boolean setPowerSaveMode(Context r7, boolean r8, boolean r9, int r10) {
        monitor-enter(BatterySaverUtils.class);
        ContentResolver r1 = r7.getContentResolver();     // Catch: Throwable -> L31
        Bundle r2 = new Bundle(1);     // Catch: Throwable -> L31
        r2.putBoolean(EXTRA_CONFIRM_TEXT_ONLY, false);     // Catch: Throwable -> L31
        if (r8 == false) goto L11;
        if (r9 == false) goto L11;
        if (maybeShowBatterySaverConfirmation(r7, r2) == false) goto L11;
        monitor-exit(BatterySaverUtils.class);
        return false;
    L11:
        if (r8 == false) goto L15;
        if (r9 == true) goto L15;
        setBatterySaverConfirmationAcknowledged(r7);     // Catch: Throwable -> L31
    L15:
        if (((PowerManager) r7.getSystemService(PowerManager.class)).setPowerSaveModeEnabled(r8) == false) goto L29;
        if (r8 == false) goto L26;
        int r11 = Settings.Secure.getInt(r1, "low_power_manual_activation_count", 0) + 1;     // Catch: Throwable -> L31
        Settings.Secure.putInt(r1, "low_power_manual_activation_count", r11);     // Catch: Throwable -> L31
        Parameters r4 = new Parameters(r7);     // Catch: Throwable -> L31
        if (r11 < r4.startNth) goto L26;
        if (r11 > r4.endNth) goto L26;
        if (Settings.Global.getInt(r1, "low_power_trigger_level", 0) != 0) goto L26;
        if (Settings.Secure.getInt(r1, "suppress_auto_battery_saver_suggestion", 0) != 0) goto L26;
        sendSystemUiBroadcast(r7, ACTION_SHOW_AUTO_SAVER_SUGGESTION, r2);     // Catch: Throwable -> L31
    L26:
        recordBatterySaverEnabledReason(r7, r8, r10);     // Catch: Throwable -> L31
        monitor-exit(BatterySaverUtils.class);
        return true;
    L29:
        monitor-exit(BatterySaverUtils.class);
        return false;
    L31:
        th = move-exception;
        throw th;
    }

    public static boolean maybeShowBatterySaverConfirmation(Context r3, Bundle r4) {
        if (Settings.Secure.getInt(r3.getContentResolver(), "low_power_warning_acknowledged", 0) != 0) goto L5;
    L7:
        sendSystemUiBroadcast(r3, ACTION_SHOW_START_SAVER_CONFIRMATION, r4);
        return true;
    L5:
        if (Settings.Secure.getInt(r3.getContentResolver(), "extra_low_power_warning_acknowledged", 0) == 0) goto L7;
        return false;
    }

    private static void recordBatterySaverEnabledReason(Context r2, boolean r3, int r4) {
        Bundle r0 = new Bundle(2);
        r0.putInt(BatterySaverLogging.EXTRA_POWER_SAVE_MODE_MANUAL_ENABLED_REASON, r4);
        r0.putBoolean(BatterySaverLogging.EXTRA_POWER_SAVE_MODE_MANUAL_ENABLED, r3);
        sendSystemUiBroadcast(r2, BatterySaverLogging.ACTION_SAVER_STATE_MANUAL_UPDATE, r0);
    }

    private static void sendSystemUiBroadcast(Context r1, String r2, Bundle r3) {
        Intent r0 = new Intent(r2);
        r0.setFlags(268435456);
        r0.setPackage("com.android.systemui");
        r0.putExtras(r3);
        r1.sendBroadcast(r0);
    }

    private static void setBatterySaverConfirmationAcknowledged(Context r3) {
        Settings.Secure.putInt(r3.getContentResolver(), "low_power_warning_acknowledged", 1);
        Settings.Secure.putInt(r3.getContentResolver(), "extra_low_power_warning_acknowledged", 1);
    }

    public static void suppressAutoBatterySaver(Context r2) {
        Settings.Secure.putInt(r2.getContentResolver(), "suppress_auto_battery_saver_suggestion", 1);
    }

    public static void setAutoBatterySaverTriggerLevel(Context r1, int r2) {
        if (r2 <= 0) goto L4;
        suppressAutoBatterySaver(r1);
    L4:
        Settings.Global.putInt(r1.getContentResolver(), "low_power_trigger_level", r2);
    }

    public static void ensureAutoBatterySaver(Context r3, int r4) {
        if (Settings.Global.getInt(r3.getContentResolver(), "low_power_trigger_level", 0) != 0) goto L6;
        setAutoBatterySaverTriggerLevel(r3, r4);
        return;
    }

    public static void revertScheduleToNoneIfNeeded(Context r4) {
        ContentResolver r5 = r4.getContentResolver();
        if (Settings.Global.getInt(r5, "automatic_power_save_mode", 0) != 1) goto L6;
        Settings.Global.putInt(r5, "low_power_trigger_level", 0);
        Settings.Global.putInt(r5, "automatic_power_save_mode", 0);
        return;
    }

    public static String getBatterySaverScheduleKey(Context r4) {
        ContentResolver r0 = r4.getContentResolver();
        if (Settings.Global.getInt(r0, "automatic_power_save_mode", 0) == 0) goto L5;
        revertScheduleToNoneIfNeeded(r4);
        return KEY_NO_SCHEDULE;
    L5:
        if (Settings.Global.getInt(r0, "low_power_trigger_level", 0) <= 0) goto L11;
        return KEY_PERCENTAGE;
    L11:
        return KEY_NO_SCHEDULE;
    }

    public static void setBatterySaverScheduleMode(Context r4, String r5, int r6) {
        ContentResolver r7 = r4.getContentResolver();
        r5.hashCode();
        if (r5.equals(KEY_NO_SCHEDULE) == false) goto L5;
        Settings.Global.putInt(r7, "automatic_power_save_mode", 0);
        Settings.Global.putInt(r7, "low_power_trigger_level", 0);
        return;
    L5:
        if (r5.equals(KEY_PERCENTAGE) == false) goto L8;
        Settings.Global.putInt(r7, "automatic_power_save_mode", 0);
        Settings.Global.putInt(r7, "low_power_trigger_level", r6);
        return;
    L8:
        throw new IllegalStateException("Not a valid schedule key");
    }
}
