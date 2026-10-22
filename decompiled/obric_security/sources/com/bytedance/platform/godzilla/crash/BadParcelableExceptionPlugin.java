package com.bytedance.platform.godzilla.crash;

import android.app.Application;
import android.content.Context;
import com.bytedance.platform.godzilla.plugin.BasePlugin;
import com.bytedance.sysoptimizer.BadParcelableCrashOptimizer;

/* JADX INFO: loaded from: classes.dex */
public class BadParcelableExceptionPlugin extends BasePlugin {
    private Context mContext;

    @Override // com.bytedance.platform.godzilla.plugin.BasePlugin
    public String getName() {
        return "BadParcelableExceptionPlugin";
    }

    public BadParcelableExceptionPlugin() {
    }

    @Override // com.bytedance.platform.godzilla.plugin.BasePlugin
    public void init(Application r1) {
        super.init(r1);
        this.mContext = r1;
    }

    @Override // com.bytedance.platform.godzilla.plugin.BasePlugin
    public void start() {
        super.start();
        BadParcelableCrashOptimizer.fix(this.mContext);
    }
}
