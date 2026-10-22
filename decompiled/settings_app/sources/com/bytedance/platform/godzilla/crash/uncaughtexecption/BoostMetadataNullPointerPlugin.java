package com.bytedance.platform.godzilla.crash.uncaughtexecption;

import com.bytedance.platform.godzilla.plugin.UncaughtExceptionPlugin;

/* JADX INFO: loaded from: classes3.dex */
public class BoostMetadataNullPointerPlugin extends UncaughtExceptionPlugin {
    @Override // com.bytedance.platform.godzilla.plugin.BasePlugin
    public String getName() {
        return "BoostMetadataNullPointerPlugin";
    }

    @Override // com.bytedance.platform.godzilla.plugin.UncaughtExceptionPlugin
    public boolean shouldEnableOpt() {
        return true;
    }

    public BoostMetadataNullPointerPlugin() {
    }

    @Override // com.bytedance.platform.godzilla.plugin.UncaughtExceptionPlugin, com.bytedance.platform.godzilla.common.UncaughtExceptionConsumer
    public boolean consumeUncaughtException(Thread r6, Throwable r7) throws Throwable {
        if ((r7 instanceof NullPointerException) == true) goto L5;
        return false;
    L5:
        StackTraceElement[] r5 = r7.getStackTrace();
        int r0 = r5.length;
        int r1 = 0;
    L6:
        if (r1 >= r0) goto L14;
        StackTraceElement r2 = r5[r1];
        if ("android.app.ActivityThread".equalsIgnoreCase(r2.getClassName()) == false) goto L13;
        if ("handleBindApplication".equalsIgnoreCase(r2.getMethodName()) == false) goto L13;
        return r7.toString().contains("Attempt to read from field 'android.os.Bundle android.content.pm.PackageItemInfo.metaData' on a null object reference");
    L13:
        r1 = r1 + 1;
        goto L6
    L14:
        return false;
    }
}
