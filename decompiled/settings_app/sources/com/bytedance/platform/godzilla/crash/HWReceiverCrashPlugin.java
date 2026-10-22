package com.bytedance.platform.godzilla.crash;

import android.app.Application;
import com.bytedance.platform.godzilla.plugin.BasePlugin;
import com.bytedance.sysoptimizer.HWReceiverCrashOptimizer;

/* JADX INFO: loaded from: classes3.dex */
public class HWReceiverCrashPlugin extends BasePlugin {
    private Application mApplication;

    @Override // com.bytedance.platform.godzilla.plugin.BasePlugin
    public String getName() {
        return "HWReceiverCrashPlugin";
    }

    public HWReceiverCrashPlugin() {
    }

    @Override // com.bytedance.platform.godzilla.plugin.BasePlugin
    public void init(Application r1) {
        super.init(r1);
        this.mApplication = r1;
    }

    @Override // com.bytedance.platform.godzilla.plugin.BasePlugin
    public void start() {
        super.start();
        HWReceiverCrashOptimizer.fix(this.mApplication);
    }
}
