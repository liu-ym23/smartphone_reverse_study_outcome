package com.bytedance.platform.godzilla.crash.uncaughtexecption;

import android.os.Build;
import com.bytedance.platform.godzilla.common.Logger;
import com.bytedance.platform.godzilla.plugin.UncaughtExceptionPlugin;
import com.bytedance.platform.godzilla.utils.RomUtils;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class StopActivityNPEPlugin extends UncaughtExceptionPlugin {
    private static final String STACK_CLASS = "android.app.ActivityThread";
    private static final String STACK_METHOD = "handleStopActivity";
    private static Set<Integer> sOptSDKInts;

    static {
        HashSet r0 = new HashSet();
        sOptSDKInts = r0;
        r0.add(23);
        sOptSDKInts.add(24);
        sOptSDKInts.add(25);
    }

    public StopActivityNPEPlugin() {
    }

    @Override // com.bytedance.platform.godzilla.plugin.UncaughtExceptionPlugin, com.bytedance.platform.godzilla.common.UncaughtExceptionConsumer
    public boolean consumeUncaughtException(Thread r3, Throwable r4) {
        if ((r4 instanceof NullPointerException) == false) goto L12;
        StackTraceElement[] r5 = r4.getStackTrace();
        if (r5.length <= 0) goto L12;
        StackTraceElement r6 = r5[0];
        if (STACK_CLASS.equals(r6.getClassName()) == false) goto L12;
        if (STACK_METHOD.equals(r6.getMethodName()) == false) goto L12;
        Logger.e(getName(), "Hint StopActivityNPE case ,fix it.");
        return true;
    L12:
        return false;
    }

    @Override // com.bytedance.platform.godzilla.plugin.BasePlugin
    public String getName() {
        return "StopActivityNPEPlugin";
    }

    @Override // com.bytedance.platform.godzilla.plugin.UncaughtExceptionPlugin
    public boolean shouldEnableOpt() {
        if (sOptSDKInts.contains(Integer.valueOf(Build.VERSION.SDK_INT)) == true) goto L5;
        return false;
    L5:
        String r3 = Build.MODEL;
        if (r3.startsWith("GIONEE") == false) goto L9;
        return true;
    L9:
        if (r3.startsWith("Funtouch") == false) goto L12;
        return true;
    L12:
        if (r3.startsWith("coloros_V3.0") == false) goto L15;
        return true;
    L15:
        if (RomUtils.isAmigo() == false) goto L17;
        return true;
    L17:
        return false;
    }
}
