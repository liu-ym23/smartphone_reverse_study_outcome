package com.android.settingslib.fuelgauge;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes.dex */
public final class BatterySaverLogging {
    public static final String ACTION_SAVER_STATE_MANUAL_UPDATE = "com.android.settingslib.fuelgauge.ACTION_SAVER_STATE_MANUAL_UPDATE";
    public static final String EXTRA_POWER_SAVE_MODE_MANUAL_ENABLED = "extra_power_save_mode_manual_enabled";
    public static final String EXTRA_POWER_SAVE_MODE_MANUAL_ENABLED_REASON = "extra_power_save_mode_manual_enabled_reason";
    public static final int SAVER_ENABLED_CONFIRMATION = 1;
    public static final int SAVER_ENABLED_LOW_WARNING = 5;
    public static final int SAVER_ENABLED_QS = 4;
    public static final int SAVER_ENABLED_SETTINGS = 3;
    public static final int SAVER_ENABLED_SEVERE_WARNING = 6;
    public static final int SAVER_ENABLED_UNKNOWN = 0;
    public static final int SAVER_ENABLED_VOICE = 2;

    @Retention(RetentionPolicy.SOURCE)
    public @interface SaverManualEnabledReason {
    }

    public BatterySaverLogging() {
    }
}
