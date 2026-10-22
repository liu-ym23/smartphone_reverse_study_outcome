package com.bytedanceos.security.multi.adpter;

import android.os.PowerManager;
import com.bytedanceos.security.reflect.ReflectHelper;

/* JADX INFO: loaded from: classes2.dex */
public class AndroidQSDKAdapter extends SDKAdapter {
    public static final String TAG = "AndroidQSDKAdapter";

    public AndroidQSDKAdapter() {
    }

    public static void setPowerSaveMode(PowerManager powerManager, boolean enable) {
        if (powerManager != null) goto L4;
        return;
    L4:
        ReflectHelper.invokeMethod(powerManager, "setPowerSaveModeEnabled", new Class[]{Boolean.TYPE}, new Object[]{Boolean.valueOf(enable)});
    }
}
