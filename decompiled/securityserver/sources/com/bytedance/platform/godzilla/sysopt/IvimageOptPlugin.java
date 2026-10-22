package com.bytedance.platform.godzilla.sysopt;

import android.app.Application;
import android.os.Build;
import com.bytedance.platform.godzilla.common.Logger;
import com.bytedance.platform.godzilla.plugin.BasePlugin;

/* JADX INFO: loaded from: classes.dex */
public class IvimageOptPlugin extends BasePlugin {
    public IvimageOptPlugin() {
    }

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
    public void start() {
        Logger.e(getName(), "start");
        if (Build.DISPLAY.contains("Flyme") == false) goto L5;
    L6:
        Class<?> r4 = null;
        r4 = Class.forName("ivimagesr.o000ooo");     // Catch: Throwable -> L9 ClassNotFoundException -> L11
        Logger.e("GODZILLA", "Class found = ".concat(r4.getName()));     // Catch: Throwable -> L9 ClassNotFoundException -> L11
    L8:
        Logger.e("GODZILLA", "Register opt");
        IvimageOpt.start();
        return;
    L11:
        e = move-exception;
        Logger.e("GODZILLA", e.toString());     // Catch: Throwable -> L9
        if (r4 != null) goto L8;
        return;
    L9:
        th = move-exception;
        if (r4 == null) goto L18;
        Logger.e("GODZILLA", "Register opt");
        IvimageOpt.start();
    L18:
        throw th;
    L5:
        if (Build.USER.equals("flyme") == true) goto L6;
    }

    @Override // com.bytedance.platform.godzilla.plugin.BasePlugin
    public void stop() {
    }
}
