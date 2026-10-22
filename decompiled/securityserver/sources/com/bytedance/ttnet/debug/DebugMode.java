package com.bytedance.ttnet.debug;

import android.content.Context;
import com.bytedance.common.utility.Logger;
import com.bytedance.retrofit2.RetrofitLogger;
import com.bytedance.ttnet.TTNetInit;

/* JADX INFO: loaded from: classes.dex */
public class DebugMode {
    private static String TTNET_DEBUG_MODE = "ttnet_debug_mode";

    public DebugMode() {
    }

    private static boolean isOpenDebugMode() {
        if (TTNetInit.ENV.RELEASE == TTNetInit.getEnv()) goto L5;
        return true;
    L5:
        return false;
    }

    public static void openIfDebug(Context r1) {
        if (isOpenDebugMode() == true) goto L6;
        Logger.d(TTNET_DEBUG_MODE, "debug_mode close");
        return;
    L6:
        run(r1);
    }

    public static void openLogger() {
        Logger.setLogLevel(2);
        RetrofitLogger.setLogLevel(Logger.getLogLevel());
    }

    private static void run(Context r2) {
        Logger.d(TTNET_DEBUG_MODE, "debug_mode open");
        if (DebugSetting.isLogOpen(r2) == false) goto L6;
        openLogger();
        return;
    }

    public static boolean x86Support() {
        if (isOpenDebugMode() == true) goto L7;
        return false;
    L7:
        return DebugSetting.isX86Support(TTNetInit.getTTNetDepend().getContext());
    }
}
