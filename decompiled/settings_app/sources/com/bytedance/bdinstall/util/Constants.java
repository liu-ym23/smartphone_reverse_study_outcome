package com.bytedance.bdinstall.util;

import android.content.Context;
import android.content.SharedPreferences;
import com.bytedance.bdinstall.AbsEnv;

/* JADX INFO: loaded from: classes3.dex */
class Constants {
    public static final long ACTIVE_RETRY_TIME = 900000;
    public static final String NAME_NEW_USER_IMPL = "com.bytedance.bdinstall.nu.NUModeServiceImpl";
    public static final String SP_FILE_OPEN_UDID = "snssdk_openudid";
    public static final String SP_INSTALL = "ug_install_settings_pref";
    private static final Singleton<SharedPreferences> sInstallSpref = null;

    Constants() {
    }

    static {
        sInstallSpref = new AnonymousClass1();
    }

    public static SharedPreferences getCommonSp(Context r3) {
        return sInstallSpref.get(new Object[]{r3});
    }

    public static String wrapEnvSuffix(String r1, AbsEnv r2) {
        if (r2.isI18n() == false) goto L6;
        r1 = r1 + "_i18n";
    L6:
        if (r2.isBoe() == false) goto L9;
        r1 = r1 + "_boe";
    L9:
        if (r2.isChildMode() == true) goto L11;
        return r1;
    L11:
        return r1 + "_cm";
    }

    public static String wrapServerIdSpName(AbsEnv r1) {
        return wrapEnvSuffix(SP_INSTALL, r1);
    }
}
