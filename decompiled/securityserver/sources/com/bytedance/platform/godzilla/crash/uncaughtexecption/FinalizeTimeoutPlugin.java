package com.bytedance.platform.godzilla.crash.uncaughtexecption;

import com.bytedance.platform.godzilla.common.Logger;
import com.bytedance.platform.godzilla.plugin.UncaughtExceptionPlugin;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes.dex */
public class FinalizeTimeoutPlugin extends UncaughtExceptionPlugin {
    public FinalizeTimeoutPlugin() {
    }

    private boolean isFinalizeTimeout(Thread r1, Throwable r2) {
        if (r1 == null) goto L9;
        if (r2 == null) goto L9;
        if (r1.getName().equals("FinalizerWatchdogDaemon") == false) goto L9;
        if ((r2 instanceof TimeoutException) == false) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // com.bytedance.platform.godzilla.plugin.UncaughtExceptionPlugin, com.bytedance.platform.godzilla.common.UncaughtExceptionConsumer
    public boolean consumeUncaughtException(Thread r1, Throwable r2) {
        boolean r3 = isFinalizeTimeout(r1, r2);
        if (r3 == false) goto L5;
        Logger.e(getName(), "Hint FinalizeTimeout case ,fix it.");
    L5:
        return r3;
    }

    @Override // com.bytedance.platform.godzilla.plugin.BasePlugin
    public String getName() {
        return "FinalizeTimeoutPlugin";
    }

    @Override // com.bytedance.platform.godzilla.plugin.UncaughtExceptionPlugin
    public boolean shouldEnableOpt() {
        return true;
    }

    @Override // com.bytedance.platform.godzilla.plugin.UncaughtExceptionPlugin, com.bytedance.platform.godzilla.plugin.BasePlugin
    public void start() {
        super.start();
    }

    @Override // com.bytedance.platform.godzilla.plugin.UncaughtExceptionPlugin, com.bytedance.platform.godzilla.plugin.BasePlugin
    public void stop() {
        super.stop();
    }
}
