package com.android.settingslib.notification;

import android.content.Context;
import com.android.internal.logging.MetricsLogger;

/* JADX INFO: loaded from: classes.dex */
public class ZenModeDialogMetricsLogger {
    private final Context mContext;

    public ZenModeDialogMetricsLogger(Context r1) {
        this.mContext = r1;
    }

    public void logOnEnableZenModeForever() {
        MetricsLogger.action(this.mContext, 1259);
    }

    public void logOnEnableZenModeUntilAlarm() {
        MetricsLogger.action(this.mContext, 1261);
    }

    public void logOnEnableZenModeUntilCountdown() {
        MetricsLogger.action(this.mContext, 1260);
    }

    public void logOnConditionSelected() {
        MetricsLogger.action(this.mContext, 164);
    }

    public void logOnClickTimeButton(boolean r2) {
        MetricsLogger.action(this.mContext, 163, r2);
    }
}
