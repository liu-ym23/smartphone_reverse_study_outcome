package com.bytedance.apm;

import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public class PerfConfig {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static boolean f1117a = false;

    static {
    }

    public PerfConfig() {
    }

    public static boolean a() {
        return f1117a;
    }

    public static void setReportMessage() {
        Log.e("PerfConfig", "setReportMessage set true");
        f1117a = true;
    }
}
