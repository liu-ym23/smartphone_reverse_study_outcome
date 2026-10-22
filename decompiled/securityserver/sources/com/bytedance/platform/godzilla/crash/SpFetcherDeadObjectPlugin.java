package com.bytedance.platform.godzilla.crash;

import android.app.Application;
import android.os.storage.StorageManager;
import com.bytedance.platform.godzilla.common.Logger;
import com.bytedance.platform.godzilla.crash.boostcrash.impl.deadobject.IMountServiceProxy;
import com.bytedance.platform.godzilla.plugin.BasePlugin;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes.dex */
public class SpFetcherDeadObjectPlugin extends BasePlugin {
    private boolean mHitTargetAPI;

    public SpFetcherDeadObjectPlugin() {
        this.mHitTargetAPI = false;
    }

    @Override // com.bytedance.platform.godzilla.plugin.BasePlugin
    public void destroy() {
        super.destroy();
    }

    @Override // com.bytedance.platform.godzilla.plugin.BasePlugin
    public String getName() {
        return "SpFetcherDeadObjectPlugin";
    }

    @Override // com.bytedance.platform.godzilla.plugin.BasePlugin
    public void init(Application r1) {
        super.init(r1);
        this.mHitTargetAPI = false;
    }

    @Override // com.bytedance.platform.godzilla.plugin.BasePlugin
    public void start() {
        super.start();
        if (this.mHitTargetAPI == false) goto L9;
        new IMountServiceProxy().onInstall();
        Field r1 = StorageManager.class.getDeclaredField("sStorageManager");     // Catch: Exception -> L7
        r1.setAccessible(true);     // Catch: Exception -> L7
        r1.set(null, null);     // Catch: Exception -> L7
        Logger.d("DeadObjectFixer", "Fix success.");     // Catch: Exception -> L7
    L7:
        e = move-exception;
        Logger.d("DeadObjectFixer", "Fix fail " + e);
    L9:
        Logger.e(getName(), "start");
    }

    @Override // com.bytedance.platform.godzilla.plugin.BasePlugin
    public void stop() {
        super.stop();
    }
}
