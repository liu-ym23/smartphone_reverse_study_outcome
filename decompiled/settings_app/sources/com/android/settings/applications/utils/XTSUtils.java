package com.android.settings.applications.utils;

import android.provider.Settings;
import android.text.TextUtils;
import com.android.settings.SettingsApplication;

/* JADX INFO: loaded from: classes2.dex */
public class XTSUtils {
    public XTSUtils() {
    }

    public static boolean isInXtsMode() {
        if (Settings.Global.getInt(SettingsApplication.getContext().getContentResolver(), "apprecord_testmode", 0) == 1) goto L7;
        return false;
    L7:
        return true;
    L12:
        return false;
    }

    public static boolean isCTSWithPackage(String r1) {
        if (TextUtils.isEmpty(r1) == false) goto L7;
        return false;
    L7:
        return r1.contains(".cts");
    }
}
