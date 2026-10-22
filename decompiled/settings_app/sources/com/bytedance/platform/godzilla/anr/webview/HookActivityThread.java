package com.bytedance.platform.godzilla.anr.webview;

import android.app.Application;
import com.bytedance.platform.godzilla.common.ActivityThreadHelper;
import com.bytedance.platform.godzilla.common.Logger;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes3.dex */
public class HookActivityThread {
    private static final String TAG = "HookActivityThreadSetInitialApplication";

    public HookActivityThread() {
    }

    public boolean preSetApplication(Application r3) {
        Field r2 = Class.forName("android.app.ActivityThread").getDeclaredField("mInitialApplication");     // Catch: Exception -> L4
        r2.setAccessible(true);     // Catch: Exception -> L4
        r2.set(ActivityThreadHelper.currentActivityThread(), r3);     // Catch: Exception -> L4
        return true;
    L4:
        Logger.e(TAG, "WebView hook fix ANR fail.");
        return false;
    }
}
