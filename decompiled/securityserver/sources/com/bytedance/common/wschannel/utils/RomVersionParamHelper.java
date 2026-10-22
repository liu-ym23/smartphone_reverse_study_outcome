package com.bytedance.common.wschannel.utils;

import com.ss.android.common.util.ToolUtils;

/* JADX INFO: loaded from: classes.dex */
public class RomVersionParamHelper {
    public static final String RUNTIME_MIUI = "ro.miui.ui.version.name";
    private static final SystemPropertiesProxy sPropertiesProxy = null;

    static {
        sPropertiesProxy = new SystemPropertiesProxy();
    }

    public RomVersionParamHelper() {
    }

    private static String getSystemProperty(String r1) {
        return sPropertiesProxy.get(r1);
    }

    public static boolean isMIUI12() {
        if (ToolUtils.isMiui() == true) goto L12;
        return false;
    L12:
        if (Integer.parseInt(getSystemProperty("ro.miui.ui.version.name").substring(1)) >= 12) goto L10;
        return false;
    L10:
        return true;
    L15:
        return false;
    }
}
