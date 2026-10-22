package com.bytedance.platform.godzilla.sysopt;

import android.app.Application;
import com.bytedance.platform.godzilla.plugin.BasePlugin;

/* JADX INFO: loaded from: classes.dex */
public class PthreadCreateHookPlugin extends BasePlugin {
    private int mNewSize;

    @Override // com.bytedance.platform.godzilla.plugin.BasePlugin
    public void destroy() {
    }

    @Override // com.bytedance.platform.godzilla.plugin.BasePlugin
    public String getName() {
        return "PthreadCreateHookPlugin";
    }

    @Override // com.bytedance.platform.godzilla.plugin.BasePlugin
    public void init(Application r1) {
    }

    public PthreadCreateHookPlugin(int r1) {
        this.mNewSize = r1;
    }

    @Override // com.bytedance.platform.godzilla.plugin.BasePlugin
    public void start() {
        PthreadCreateHook.start(this.mNewSize);
    }

    @Override // com.bytedance.platform.godzilla.plugin.BasePlugin
    public void stop() {
        PthreadCreateHook.end();
    }
}
