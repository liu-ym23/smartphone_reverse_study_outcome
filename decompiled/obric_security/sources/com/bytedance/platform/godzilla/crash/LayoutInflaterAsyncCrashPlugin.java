package com.bytedance.platform.godzilla.crash;

import android.app.Application;
import android.content.Context;
import com.bytedance.platform.godzilla.plugin.BasePlugin;
import com.bytedance.sysoptimizer.LayoutInflaterAsyncCrashOptimizer;

/* JADX INFO: loaded from: classes.dex */
public class LayoutInflaterAsyncCrashPlugin extends BasePlugin {
    private Context mContext;

    @Override // com.bytedance.platform.godzilla.plugin.BasePlugin
    public String getName() {
        return "LayoutInflaterAsyncCrashPlugin";
    }

    public LayoutInflaterAsyncCrashPlugin() {
    }

    @Override // com.bytedance.platform.godzilla.plugin.BasePlugin
    public void init(Application r1) {
        super.init(r1);
        this.mContext = r1;
    }

    @Override // com.bytedance.platform.godzilla.plugin.BasePlugin
    public void start() {
        super.start();
        LayoutInflaterAsyncCrashOptimizer.fix(this.mContext);
    }
}
