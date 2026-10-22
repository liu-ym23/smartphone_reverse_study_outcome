package com.obric.security.robots;

import android.app.ActivityThread;
import android.content.Context;
import android.provider.Settings;
import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public final class RobotsProtocolHelper {
    private static final String KEY_ROBOTS_ENABLED = "robots_protocol_enabled";
    private static final int ROBOTS_DISABLED = 0;
    private static final int ROBOTS_ENABLED = 1;
    private static final String TAG = "RobotsProtocolHelper";

    private RobotsProtocolHelper() {
    }

    public static boolean isRobotsEnabled(Context context) {
        if (context != null) goto L17;
        Log.d(TAG, "isRobotsEnabled: context is null, default disabled");
        return false;
    L17:
    L8:
        if (Settings.Secure.getInt(context.getContentResolver(), KEY_ROBOTS_ENABLED) == 1) goto L10;
        return false;
    L10:
        return true;
    L14:
        e = move-exception;
        Log.d(TAG, "isRobotsEnabled: key not found, default disabled", e);
        return false;
    L11:
        e = move-exception;
        Log.w(TAG, "isRobotsEnabled failed to read robots protocol state", e);
        return false;
    }

    public static boolean isRobotsEnabled() {
        Context context = ActivityThread.currentApplication();     // Catch: Exception -> L4
        return isRobotsEnabled(context);
    L4:
        e = move-exception;
        Log.w(TAG, "isRobotsEnabled failed to get application context", e);
        return false;
    }
}
