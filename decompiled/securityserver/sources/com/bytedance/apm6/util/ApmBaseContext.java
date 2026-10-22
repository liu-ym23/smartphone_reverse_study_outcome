package com.bytedance.apm6.util;

import android.app.Application;
import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public class ApmBaseContext {
    private static Application context = null;
    private static boolean debugMode = false;
    private static boolean systraceMode = false;

    public ApmBaseContext() {
    }

    private static Application getApplication(Context r1) {
        if (r1 != null) goto L6;
        return null;
    L6:
        if ((r1 instanceof Application) == true) goto L9;
        r1 = r1.getApplicationContext();
    L9:
        return (Application) r1;
    }

    public static Application getContext() {
        return context;
    }

    public static boolean isDebugMode() {
        if (debugMode == true) goto L5;
    L7:
        return false;
    L5:
        if (systraceMode == true) goto L7;
        return true;
    }

    public static boolean isSystraceMode() {
        return systraceMode;
    }

    public static void setContext(Context r0) {
        if (r0 == null) goto L5;
        context = getApplication(r0);
        return;
    }

    public static void setDebugMode(boolean r0) {
        debugMode = r0;
    }

    public static void setSystraceMode(boolean r0) {
        systraceMode = r0;
    }
}
