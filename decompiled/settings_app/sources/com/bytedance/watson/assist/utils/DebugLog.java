package com.bytedance.watson.assist.utils;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

/* JADX INFO: loaded from: classes3.dex */
public class DebugLog {
    private static final String TAG = "watson_assist";
    private static boolean sDebug;

    public DebugLog() {
    }

    static {
        sDebug = Log.isLoggable(TAG, 3);
    }

    public static void v(String r1) {
        v(TAG, r1);
    }

    public static void d(String r1) {
        d(TAG, r1);
    }

    public static void i(String r1) {
        i(TAG, r1);
    }

    public static void w(String r1) {
        w(TAG, r1);
    }

    public static void e(String r1) {
        e(TAG, r1);
    }

    public static void v(String r1, String r2) {
        if (sDebug == false) goto L6;
        Log.v(r1, r2);
        return;
    }

    public static void d(String r1, String r2) {
        if (sDebug == false) goto L6;
        Log.d(r1, r2);
        return;
    }

    public static void i(String r0, String r1) {
        Log.i(r0, r1);
    }

    public static void w(String r0, String r1) {
        Log.w(r0, r1);
    }

    public static void e(String r0, String r1) {
        Log.e(r0, r1);
    }

    public static void toast(Context r1, String r2) {
        Toast.makeText(r1, r2, 1).show();
    }
}
