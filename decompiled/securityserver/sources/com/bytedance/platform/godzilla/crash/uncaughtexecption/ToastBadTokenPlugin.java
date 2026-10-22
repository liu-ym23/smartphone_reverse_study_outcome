package com.bytedance.platform.godzilla.crash.uncaughtexecption;

import android.view.WindowManager;
import com.bytedance.platform.godzilla.common.Logger;
import com.bytedance.platform.godzilla.plugin.UncaughtExceptionPlugin;

/* JADX INFO: loaded from: classes.dex */
public class ToastBadTokenPlugin extends UncaughtExceptionPlugin {
    private static final String STACK_CLASS = "android.widget.Toast$TN";
    private static final String STACK_METHOD = "handleShow";

    public ToastBadTokenPlugin() {
    }

    private boolean isBadTokenException(Thread r6, Throwable r7) {
        if ((r7 instanceof WindowManager.BadTokenException) == false) goto L15;
        StackTraceElement[] r8 = r7.getStackTrace();
        int r9 = r8.length;
        int r1 = 0;
    L5:
        if (r1 >= r9) goto L15;
        StackTraceElement r2 = r8[r1];
        if (r2 == null) goto L14;
        if (STACK_CLASS.equals(r2.getClassName()) == false) goto L14;
        if (STACK_METHOD.equals(r2.getMethodName()) == false) goto L14;
        Logger.e(getName(), "Hint ToastBadToken case ,fix it.");
        return true;
    L14:
        r1 = r1 + 1;
    L15:
        return false;
    }

    @Override // com.bytedance.platform.godzilla.plugin.UncaughtExceptionPlugin, com.bytedance.platform.godzilla.common.UncaughtExceptionConsumer
    public boolean consumeUncaughtException(Thread r1, Throwable r2) {
        return isBadTokenException(r1, r2);
    }

    @Override // com.bytedance.platform.godzilla.plugin.BasePlugin
    public String getName() {
        return "ToastBadTokenPlugin";
    }

    @Override // com.bytedance.platform.godzilla.plugin.UncaughtExceptionPlugin
    public boolean shouldEnableOpt() {
        return false;
    }
}
