package com.bytedance.platform.godzilla.crash.uncaughtexecption;

import com.bytedance.platform.godzilla.common.Logger;
import com.bytedance.platform.godzilla.plugin.UncaughtExceptionPlugin;

/* JADX INFO: loaded from: classes.dex */
public class OppoMessageNPEPlugin extends UncaughtExceptionPlugin {
    private static final String STACK_CLASS = "android.os.Message";
    private static final String STACK_METHOD = "toString";

    @Override // com.bytedance.platform.godzilla.plugin.BasePlugin
    public String getName() {
        return "OppoMessageNPEPlugin";
    }

    @Override // com.bytedance.platform.godzilla.plugin.UncaughtExceptionPlugin
    public boolean shouldEnableOpt() {
        return false;
    }

    public OppoMessageNPEPlugin() {
    }

    @Override // com.bytedance.platform.godzilla.plugin.UncaughtExceptionPlugin, com.bytedance.platform.godzilla.common.UncaughtExceptionConsumer
    public boolean consumeUncaughtException(Thread r1, Throwable r2) throws Throwable {
        return doInterceptMainException(r2);
    }

    private boolean doInterceptMainException(Throwable r7) {
        if ((r7 instanceof NullPointerException) == false) goto L13;
        StackTraceElement[] r8 = r7.getStackTrace();
        int r0 = r8.length;
        int r2 = 0;
    L5:
        if (r2 >= r0) goto L13;
        StackTraceElement r3 = r8[r2];
        if (STACK_CLASS.equals(r3.getClassName()) == false) goto L12;
        if (STACK_METHOD.equals(r3.getMethodName()) == false) goto L12;
        Logger.e(getName(), "Hint OppoMessageNPE case ,fix it.");
        return true;
    L12:
        r2 = r2 + 1;
    L13:
        return false;
    }
}
