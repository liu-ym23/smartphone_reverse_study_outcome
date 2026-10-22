package com.bytedance.android.standard.tools.device;

import com.bytedance.android.standard.tools.logging.Logger;

/* JADX INFO: loaded from: classes3.dex */
public final class SystemPropertiesUtils {
    private static final String TAG = "SystemPropertiesUtils";
    public static volatile boolean hasProxy = true;
    private static SystemPropertiesProxy proxy;

    private SystemPropertiesUtils() {
    }

    static {
        proxy = new SystemPropertiesProxy();
    }

    public static String getSystemProperty(String r3) {
        if (hasProxy == false) goto L9;
        return proxy.get(r3);
    L6:
        th = move-exception;
        Logger.e(TAG, "android.os.SystemProperties reflect fail.", th);
        return CmdSystemProperties.getSystemProperty(r3);
    L9:
        return CmdSystemProperties.getSystemProperty(r3);
    }
}
