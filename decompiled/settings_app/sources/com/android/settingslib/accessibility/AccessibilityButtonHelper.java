package com.android.settingslib.accessibility;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.content.Context;
import android.provider.Settings;
import android.view.accessibility.AccessibilityManager;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class AccessibilityButtonHelper {
    public AccessibilityButtonHelper() {
    }

    public static boolean isRequestedByMagnification(Context r2) {
        if (Settings.Secure.getInt(r2.getContentResolver(), "accessibility_display_magnification_navbar_enabled", 0) == 1) goto L5;
        return false;
    L5:
        return true;
    }

    public static boolean isRequestedByAccessibilityService(Context r4) {
        List<AccessibilityServiceInfo> r5 = ((AccessibilityManager) r4.getSystemService(AccessibilityManager.class)).getEnabledAccessibilityServiceList(-1);
        if (r5 == null) goto L11;
        int r1 = r5.size();
        int r2 = 0;
    L5:
        if (r2 >= r1) goto L11;
        if ((r5.get(r2).flags & 256) != 0) goto L8;
        r2 = r2 + 1;
        goto L5
    L8:
        return true;
    L11:
        return false;
    }

    public static boolean isRequested(Context r1) {
        if (isRequestedByMagnification(r1) == false) goto L5;
    L8:
        return true;
    L5:
        if (isRequestedByAccessibilityService(r1) == true) goto L8;
        return false;
    }
}
