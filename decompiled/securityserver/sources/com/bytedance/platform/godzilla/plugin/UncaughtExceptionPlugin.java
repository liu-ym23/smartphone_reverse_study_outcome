package com.bytedance.platform.godzilla.plugin;

import com.bytedance.platform.godzilla.GodzillaCore;
import com.bytedance.platform.godzilla.common.Logger;
import com.bytedance.platform.godzilla.common.UncaughtExceptionConsumer;

/* JADX INFO: loaded from: classes.dex */
public abstract class UncaughtExceptionPlugin extends BasePlugin implements UncaughtExceptionConsumer {
    public UncaughtExceptionPlugin() {
    }

    public abstract boolean consumeUncaughtException(Thread r1, Throwable r2);

    public abstract boolean shouldEnableOpt();

    @Override // com.bytedance.platform.godzilla.plugin.BasePlugin
    public void start() {
        super.start();
        if (shouldEnableOpt() == false) goto L6;
        GodzillaCore.INSTANCE.addUncaughtExceptionConsumer(this);
        Logger.e(getName(), "start called.");
        return;
    }

    @Override // com.bytedance.platform.godzilla.plugin.BasePlugin
    public StartType startType() {
        return StartType.REGISTER_EXCEPTION;
    }

    @Override // com.bytedance.platform.godzilla.plugin.BasePlugin
    public void stop() {
        super.stop();
        if (shouldEnableOpt() == false) goto L6;
        GodzillaCore.INSTANCE.removeUncaughtExceptionConsumer(this);
        Logger.e(getName(), "stop called.");
        return;
    }
}
