package com.bytedance.platform.godzilla.sysopt;

import android.app.Application;
import com.bytedance.platform.godzilla.plugin.BasePlugin;
import com.bytedance.sysoptimizer.DvmOptimizer;

/* JADX INFO: loaded from: classes.dex */
public class DvmOptimizerPlugin extends BasePlugin {
    private Application mApp;

    @Override // com.bytedance.platform.godzilla.plugin.BasePlugin
    public void destroy() {
    }

    @Override // com.bytedance.platform.godzilla.plugin.BasePlugin
    public String getName() {
        return "DvmOptimizerPlugin";
    }

    @Override // com.bytedance.platform.godzilla.plugin.BasePlugin
    public void stop() {
    }

    public DvmOptimizerPlugin() {
    }

    @Override // com.bytedance.platform.godzilla.plugin.BasePlugin
    public void init(Application r1) {
        super.init(r1);
        this.mApp = r1;
    }

    @Override // com.bytedance.platform.godzilla.plugin.BasePlugin
    public void start() {
        Application r0 = this.mApp;
        if (r0 == null) goto L6;
        DvmOptimizer.optDvmLinearAllocBuffer(r0);
        return;
    }
}
