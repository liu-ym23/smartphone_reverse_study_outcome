package androidx.startup;

import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public final class StartupLogger {
    static final boolean DEBUG = false;
    private static final String TAG = "StartupLogger";

    private StartupLogger() {
    }

    public static void i(String r1) {
        Log.i(TAG, r1);
    }

    public static void w(String r1) {
        Log.w(TAG, r1);
    }

    public static void e(String r1, Throwable r2) {
        Log.e(TAG, r1, r2);
    }
}
