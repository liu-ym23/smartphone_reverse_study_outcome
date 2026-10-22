package com.bytedance.platform.godzilla.crash.uncaughtexecption;

import com.bytedance.platform.godzilla.plugin.UncaughtExceptionPlugin;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes3.dex */
public class LiteTimeoutException extends UncaughtExceptionPlugin {
    private static final String KEY_MESSAGE = "java.util.regex.Pattern.finalize() timed out after";

    @Override // com.bytedance.platform.godzilla.plugin.BasePlugin
    public String getName() {
        return "LiteTimeoutException";
    }

    @Override // com.bytedance.platform.godzilla.plugin.UncaughtExceptionPlugin
    public boolean shouldEnableOpt() {
        return true;
    }

    public LiteTimeoutException() {
    }

    @Override // com.bytedance.platform.godzilla.plugin.UncaughtExceptionPlugin, com.bytedance.platform.godzilla.common.UncaughtExceptionConsumer
    public boolean consumeUncaughtException(Thread r1, Throwable r2) throws Throwable {
        return r2 instanceof TimeoutException;
    }
}
