package com.bytedance.apm;

import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public class PerfConfig {
    static boolean reportMessage = false;

    public PerfConfig() {
    }

    public static boolean isReportMessage() {
        return reportMessage;
    }

    public static void setReportMessage() {
        Log.e("PerfConfig", "setReportMessage set true");
        reportMessage = true;
    }
}
