package com.bytedance.boost_multidex;

import android.app.Application;
import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public class BoostMultiDexApplication extends Application {
    private boolean isOptProcess;

    public BoostMultiDexApplication() {
    }

    @Override // android.content.ContextWrapper
    protected void attachBaseContext(Context r2) {
        super.attachBaseContext(r2);
        boolean r0 = BoostMultiDex.isOptimizeProcess(Utility.getCurProcessName(r2));
        this.isOptProcess = r0;
        if (r0 == true) goto L5;
        return;
    L5:
        BoostMultiDex.install(r2);
    }

    @Override // android.app.Application
    public void onCreate() {
        super.onCreate();
        boolean r0 = this.isOptProcess;
    }
}
