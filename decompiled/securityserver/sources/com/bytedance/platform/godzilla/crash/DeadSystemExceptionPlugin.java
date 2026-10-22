package com.bytedance.platform.godzilla.crash;

import android.app.Application;
import com.bytedance.platform.godzilla.crash.deadsystemexception.IConnectivityManagerProxy;
import com.bytedance.platform.godzilla.plugin.BasePlugin;

/* JADX INFO: loaded from: classes.dex */
public class DeadSystemExceptionPlugin extends BasePlugin {
    private Application mApplication;

    public DeadSystemExceptionPlugin(Application r1) {
        this.mApplication = r1;
        if (r1 == null) goto L6;
        return;
    L6:
        throw new IllegalArgumentException("Argument application can not be null!");
    }

    @Override // com.bytedance.platform.godzilla.plugin.BasePlugin
    public String getName() {
        return "DeadSystemExceptionPlugin";
    }

    @Override // com.bytedance.platform.godzilla.plugin.BasePlugin
    public void start() {
        super.start();
        new IConnectivityManagerProxy().onInstall();
    }
}
