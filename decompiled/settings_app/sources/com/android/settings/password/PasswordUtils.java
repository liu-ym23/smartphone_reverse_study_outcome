package com.android.settings.password;

import android.app.ActivityManager;
import android.app.IActivityManager;
import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.UserHandle;
import com.android.settingslib.Utils;
import com.obric.olog.OLog;

/* JADX INFO: loaded from: classes2.dex */
public final class PasswordUtils extends Utils {
    private static final String TAG = "Settings";

    public PasswordUtils() {
    }

    public static boolean isCallingAppPermitted(Context r2, IBinder r3, String r4) {
        if (r2.checkPermission(r4, -1, ActivityManager.getService().getLaunchedFromUid(r3)) != 0) goto L12;
        return true;
    L12:
        return false;
    L7:
        e = move-exception;
        OLog.v(TAG, "Could not talk to activity manager.", e);
        return false;
    }

    public static CharSequence getCallingAppLabel(Context r1, IBinder r2) {
        String r3 = getCallingAppPackageName(r2);
        if (r3 != null) goto L5;
        return null;
    L5:
        if (r3.equals("com.android.settings") == false) goto L8;
        return null;
    L8:
        return com.android.settings.Utils.getApplicationLabel(r1, r3);
    }

    public static String getCallingAppPackageName(IBinder r2) {
        return ActivityManager.getService().getLaunchedFromPackage(r2);
    L4:
        e = move-exception;
        OLog.v(TAG, "Could not talk to activity manager.", e);
        return null;
    }

    public static void crashCallingApplication(IBinder r8, String r9, int r10) {
        IActivityManager r0 = ActivityManager.getService();
        int r1 = r0.getLaunchedFromUid(r8);     // Catch: RemoteException -> L5
        int r4 = UserHandle.getUserId(r1);     // Catch: RemoteException -> L5
        r0.crashApplicationWithType(r1, -1, getCallingAppPackageName(r8), r4, r9, false, r10);     // Catch: RemoteException -> L5
        return;
    L5:
        e = move-exception;
        OLog.v(TAG, "Could not talk to activity manager.", e);
    }
}
