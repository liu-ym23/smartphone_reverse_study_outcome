package com.bytedance.platform.godzilla.sysopt;

import android.app.Application;
import android.os.Build;
import com.bytedance.platform.godzilla.common.Logger;
import com.bytedance.platform.godzilla.plugin.BasePlugin;

/* JADX INFO: loaded from: classes.dex */
public class IvimageOptPlugin extends BasePlugin {
    @Override // com.bytedance.platform.godzilla.plugin.BasePlugin
    public void destroy() {
    }

    @Override // com.bytedance.platform.godzilla.plugin.BasePlugin
    public String getName() {
        return "IvimageOptPlugin";
    }

    @Override // com.bytedance.platform.godzilla.plugin.BasePlugin
    public void init(Application r1) {
    }

    @Override // com.bytedance.platform.godzilla.plugin.BasePlugin
    public void stop() {
    }

    public IvimageOptPlugin() {
    }

    @Override // com.bytedance.platform.godzilla.plugin.BasePlugin
    public void start() {
        Logger.e(getName(), "start");
        if (Build.DISPLAY.contains("Flyme") == false) goto L5;
    L6:
        Class<?> r4 = null;
        r4 = Class.forName("ivimagesr.o000ooo");     // Catch: Throwable -> L10 ClassNotFoundException -> L12
        Logger.e("GODZILLA", "Class found = " + r4.getName());     // Catch: Throwable -> L10 ClassNotFoundException -> L12
        if (r4 == null) goto L20;
    L15:
        Logger.e("GODZILLA", "Register opt");
        IvimageOpt.start();
    L20:
        return;
    L10:
        th = move-exception;
        if (r4 == null) goto L19;
        Logger.e("GODZILLA", "Register opt");
        IvimageOpt.start();
    L19:
        throw th;
    L12:
        e = move-exception;
        Logger.e("GODZILLA", e.toString());     // Catch: Throwable -> L10
        if (r4 == null) goto L20;
    L5:
        if (Build.USER.equals("flyme") == true) goto L6;
    }
}
