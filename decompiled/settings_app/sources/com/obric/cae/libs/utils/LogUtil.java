package com.obric.cae.libs.utils;

import android.util.Log;

/* JADX INFO: loaded from: classes4.dex */
public class LogUtil {
    public LogUtil() {
    }

    public static void d(String r2, String r3) {
        Log.d("CaeLib", "[" + r2 + "] " + r3);
    }

    public static void e(String r2, String r3, Throwable r4) {
        Log.e("CaeLib", "[" + r2 + "] " + r3, r4);
    }

    public static void i(String r2, String r3) {
        Log.i("CaeLib", "[" + r2 + "] " + r3);
    }

    public static boolean isLoggable(int r1) {
        return Log.isLoggable("CaeLib", r1);
    }

    public static void v(String r2, String r3) {
        Log.v("CaeLib", "[" + r2 + "] " + r3);
    }

    public static void w(String r2, String r3, Throwable r4) {
        Log.w("CaeLib", "[" + r2 + "] " + r3, r4);
    }

    public static void d(String r1) {
        Log.d("CaeLib", r1);
    }

    public static void e(String r1, Throwable r2) {
        Log.e("CaeLib", r1, r2);
    }

    public static void i(String r1) {
        Log.i("CaeLib", r1);
    }

    public static void v(String r1) {
        Log.v("CaeLib", r1);
    }

    public static void w(String r1, Throwable r2) {
        Log.w("CaeLib", r1, r2);
    }

    public static void e(String r2, String r3) {
        Log.e("CaeLib", "[" + r2 + "] " + r3);
    }

    public static void w(String r2, String r3) {
        Log.w("CaeLib", "[" + r2 + "] " + r3);
    }

    public static void e(String r1) {
        Log.e("CaeLib", r1);
    }

    public static void w(String r1) {
        Log.w("CaeLib", r1);
    }
}
