package com.bytedance.platform.godzilla.anr;

import android.app.Application;
import com.bytedance.platform.godzilla.anr.webview.HookActivityThread;
import com.bytedance.platform.godzilla.common.Logger;
import com.bytedance.platform.godzilla.plugin.BasePlugin;

/* JADX INFO: loaded from: classes.dex */
public class CookieManagerPlugin extends BasePlugin {
    private Application mApplication;
    private boolean mHintTargetApi;

    @Override // com.bytedance.platform.godzilla.plugin.BasePlugin
    public String getName() {
        return "CookieManagerPlugin";
    }

    public CookieManagerPlugin() {
    }

    @Override // com.bytedance.platform.godzilla.plugin.BasePlugin
    public void init(Application r1) {
        super.init(r1);
        this.mApplication = r1;
        this.mHintTargetApi = false;
    }

    @Override // com.bytedance.platform.godzilla.plugin.BasePlugin
    public void start() {
        super.start();
        if (this.mApplication == null) goto L10;
        Logger.e(getName(), "start");
        if (this.mHintTargetApi == true) goto L7;
        return;
    L7:
        new HookActivityThread().preSetApplication(this.mApplication);
        return;
    L10:
        throw new RuntimeException("mApplication must not null!!!");
    }

    @Override // com.bytedance.platform.godzilla.plugin.BasePlugin
    public void stop() {
        super.stop();
    }

    @Override // com.bytedance.platform.godzilla.plugin.BasePlugin
    public void destroy() {
        super.destroy();
    }
}
