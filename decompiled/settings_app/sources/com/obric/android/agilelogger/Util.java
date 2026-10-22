package com.obric.android.agilelogger;

import android.app.Application;
import android.content.Context;
import android.os.Looper;

/* JADX INFO: loaded from: classes4.dex */
public class Util {
    public Util() {
    }

    public static boolean isMainThread() {
        if (Looper.getMainLooper().getThread() != Thread.currentThread()) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean isMainProcess(Context r4) {
        String r0 = getProcessName();
        if (r0 != null) goto L6;
        return false;
    L6:
        if (r0.contains(":") == false) goto L9;
        return false;
    L9:
        if (r0.equals(r4.getPackageName()) == false) goto L12;
        return true;
    L12:
        if (r0.equals(r4.getApplicationInfo().processName) == false) goto L14;
        return true;
    L14:
        return false;
    }

    public static String getProcessName() {
        return Application.getProcessName();
    }
}
