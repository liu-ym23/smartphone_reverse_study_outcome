package com.android.settingslib;

import android.content.Context;
import com.android.internal.logging.MetricsLogger;

/* JADX INFO: loaded from: classes.dex */
public final class TronUtils {
    private static final String TAG = "TronUtils";

    private TronUtils() {
    }

    public static void logWifiSettingsSpeed(Context r1, int r2) {
        MetricsLogger.histogram(r1, "settings_wifi_speed_labels", r2);
    }
}
