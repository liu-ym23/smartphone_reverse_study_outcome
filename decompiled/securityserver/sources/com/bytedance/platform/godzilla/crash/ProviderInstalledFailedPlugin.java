package com.bytedance.platform.godzilla.crash;

import android.app.Application;
import com.bytedance.platform.godzilla.common.Logger;
import com.bytedance.platform.godzilla.crash.boostcrash.api.fileProviderInstalledFailed.ExceptionCatcher;
import com.bytedance.platform.godzilla.crash.boostcrash.impl.InstrumentationWrapper;
import com.bytedance.platform.godzilla.crash.boostcrash.impl.providerInstalledFailed.FileProviderInstallFailedExceptionCatcher;
import com.bytedance.platform.godzilla.crash.boostcrash.impl.providerInstalledFailed.ProviderClassNotFoundException;
import com.bytedance.platform.godzilla.plugin.BasePlugin;

/* JADX INFO: loaded from: classes.dex */
public class ProviderInstalledFailedPlugin extends BasePlugin {
    public ProviderInstalledFailedPlugin() {
    }

    @Override // com.bytedance.platform.godzilla.plugin.BasePlugin
    public void destroy() {
        super.destroy();
    }

    @Override // com.bytedance.platform.godzilla.plugin.BasePlugin
    public String getName() {
        return "ProviderInstalledFailedPlugin";
    }

    @Override // com.bytedance.platform.godzilla.plugin.BasePlugin
    public void init(Application r1) {
        super.init(r1);
        InstrumentationWrapper.registerExceptionCatcher(new FileProviderInstallFailedExceptionCatcher());
        InstrumentationWrapper.registerExceptionCatcher(new ProviderClassNotFoundException());
    }

    public void registerCustomExceptionCatcher(ExceptionCatcher r1) {
        InstrumentationWrapper.registerExceptionCatcher(r1);
    }

    @Override // com.bytedance.platform.godzilla.plugin.BasePlugin
    public void start() {
        super.start();
        InstrumentationWrapper.startFix();
        Logger.e(getName(), "start");
    }

    @Override // com.bytedance.platform.godzilla.plugin.BasePlugin
    public void stop() {
        super.stop();
    }
}
