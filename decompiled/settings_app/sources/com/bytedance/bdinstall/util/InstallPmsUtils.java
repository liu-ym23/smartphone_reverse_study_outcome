package com.bytedance.bdinstall.util;

import android.content.Context;

/* JADX INFO: loaded from: classes3.dex */
public class InstallPmsUtils {
    public InstallPmsUtils() {
    }

    public static boolean checkReadPhoneStatePermission(Context r1) {
        return checkPermission(r1, "android.permission.READ_PHONE_STATE");
    }

    private static boolean checkPermission(Context r1, String r2) {
        if (r1.checkSelfPermission(r2) != 0) goto L10;
        return true;
    L10:
        return false;
    L11:
        return false;
    }
}
