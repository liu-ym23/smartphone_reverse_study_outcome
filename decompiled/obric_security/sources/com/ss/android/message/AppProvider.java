package com.ss.android.message;

import android.app.Application;
import com.bytedance.common.push.ActivityLifecycleObserver;
import com.ss.android.message.util.ToolUtils;

/* JADX INFO: loaded from: classes4.dex */
public class AppProvider {
    private static Application app;
    private static boolean mRegisteredActivityLifecycleCallback;

    public AppProvider() {
    }

    public static void initApp(Application r1) {
        app = r1;
        if (mRegisteredActivityLifecycleCallback == false) goto L5;
        return;
    L5:
        mRegisteredActivityLifecycleCallback = true;
        if (ToolUtils.isMainProcess(r1) == true) goto L8;
        return;
    L8:
        app.registerActivityLifecycleCallbacks(ActivityLifecycleObserver.getIns());
    }

    public static Application getApp() {
        return app;
    }

    public static int getTargetSdkVersion() {
        return app.getApplicationInfo().targetSdkVersion;
    }
}
