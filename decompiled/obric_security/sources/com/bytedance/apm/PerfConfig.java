package com.bytedance.apm;

import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public class PerfConfig {
    static boolean reportMessage = false;

    static {
    }

    public PerfConfig() {
    }

    public static void setReportMessage() {
        Log.e("PerfConfig", "setReportMessage set true");
        reportMessage = true;
    }

    public static boolean isReportMessage() {
        return reportMessage;
    }
}
