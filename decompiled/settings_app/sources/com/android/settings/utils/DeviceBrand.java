package com.android.settings.utils;

import android.os.Build;
import com.android.settings.SettingsFeature;

/* JADX INFO: loaded from: classes2.dex */
public class DeviceBrand {
    private static final String[] BRAND_ID_LOWER_CASE_NUBIA = null;
    private static final String[] BRAND_ID_LOWER_CASE_ZTE = null;
    static final String BRAND_NAME_NUBIA = "nubia";
    static final String BRAND_NAME_ZTE = "ZTE";
    private static final int BRAND_TYPE_NUBIA = 105170387;
    private static final int BRAND_TYPE_ZTE = 89163;
    static final String CURRENT_BRAND_NAME = null;
    private static final int CURRENT_BRAND_TYPE = 0;
    private static final String PAC_BRAND_NAME = "pacific";
    private static final int PAC_BRAND_TYPE = 0;

    public DeviceBrand() {
    }

    static {
        String[] r1 = {BRAND_NAME_NUBIA};
        BRAND_ID_LOWER_CASE_NUBIA = r1;
        String[] r2 = {"zte"};
        BRAND_ID_LOWER_CASE_ZTE = r2;
        String r3 = Build.BRAND.toLowerCase();
        String r4 = Build.MANUFACTURER.toLowerCase();
        if (compareBrand(r3, r4, r1) == false) goto L6;
        CURRENT_BRAND_TYPE = BRAND_TYPE_NUBIA;
        CURRENT_BRAND_NAME = BRAND_NAME_NUBIA;
        return;
    L6:
        if (compareBrand(r3, r4, r2) == false) goto L8;
        CURRENT_BRAND_TYPE = BRAND_TYPE_ZTE;
        CURRENT_BRAND_NAME = BRAND_NAME_ZTE;
        return;
    L8:
        CURRENT_BRAND_TYPE = 0;
        CURRENT_BRAND_NAME = "pacific";
    }

    public static boolean isNubia() {
        return SettingsFeature.isSupportNubiaShare();
    }

    public static boolean isZte() {
        if (CURRENT_BRAND_TYPE != BRAND_TYPE_ZTE) goto L5;
        return true;
    L5:
        return false;
    }

    private static boolean compareBrand(String r5, String r6, String... r7) {
        int r0 = r7.length;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L12;
        String r3 = r7[r2];
        if (r5.contains(r3) == true) goto L10;
        if (r6.contains(r3) == true) goto L16;
        r2 = r2 + 1;
        goto L3
    L16:
        return true;
    L10:
        return true;
    L12:
        return false;
    }
}
