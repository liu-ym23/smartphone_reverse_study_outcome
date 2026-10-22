package com.bytedance.keva;

import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public class KevaMonitor {
    public KevaMonitor() {
    }

    protected void loadLibrary(String r1) {
        System.loadLibrary(r1);
    }

    protected void logDebug(String r2) {
        Log.println(4, KevaConstants.TAG, r2);
    }

    protected void onLoadRepo(String r2, int r3) {
        Log.println(4, KevaConstants.TAG, "load repo: " + r2 + ", with mode: " + r3);
    }

    protected void reportThrowable(int r2, String r3, String r4, Object r5, Throwable r6) {
        Log.e(KevaConstants.TAG, "action: [" + r2 + "], repo: [" + r3 + "], key: [" + r4 + "], value: [" + r5 + "], msg: " + r6.getMessage(), r6);
    }

    protected void reportWarning(int r2, String r3, String r4, Object r5, String r6) {
        Log.println(5, KevaConstants.TAG, "action: [" + r2 + "], repo: [" + r3 + "], key: [" + r4 + "], value: [" + r5 + "], msg: " + r6);
    }
}
