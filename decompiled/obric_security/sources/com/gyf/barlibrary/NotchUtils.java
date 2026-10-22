package com.gyf.barlibrary;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.view.DisplayCutout;
import android.view.View;
import android.view.Window;
import android.view.WindowInsets;

/* JADX INFO: loaded from: classes2.dex */
public class NotchUtils {
    private static final String NOTCH_HUA_WEI = "com.huawei.android.util.HwNotchSizeUtil";
    private static final String NOTCH_OPPO = "com.oppo.feature.screen.heteromorphism";
    private static final String NOTCH_VIVO = "android.util.FtFeature";
    private static final String NOTCH_XIAO_MI = "ro.miui.notch";
    private static final String SYSTEM_PROPERTIES = "android.os.SystemProperties";
    private static boolean isNotchResultInitialized = false;
    private static boolean sNotchResult = false;

    static {
    }

    public NotchUtils() {
    }

    public static boolean hasNotchScreen(Activity r3) {
        if (isNotchResultInitialized == true) goto L5;
        boolean r0 = false;
        if (r3 != null) goto L10;
        return false;
    L10:
        if (hasNotchAtXiaoMi(r3) == false) goto L12;
    L19:
        r0 = true;
    L20:
        sNotchResult = r0;
        isNotchResultInitialized = true;
        return r0;
    L12:
        if (hasNotchAtHuaWei(r3) == true) goto L19;
        if (hasNotchAtOPPO(r3) == true) goto L19;
        if (hasNotchAtVIVO(r3) == true) goto L19;
        if (hasNotchAtAndroidP(r3) == false) goto L20;
    L5:
        return sNotchResult;
    }

    public static boolean hasNotchScreen(View r3) {
        if (isNotchResultInitialized == true) goto L5;
        boolean r0 = false;
        if (r3 != null) goto L10;
        return false;
    L10:
        if (hasNotchAtXiaoMi(r3.getContext()) == false) goto L12;
    L19:
        r0 = true;
    L20:
        sNotchResult = r0;
        isNotchResultInitialized = true;
        return r0;
    L12:
        if (hasNotchAtHuaWei(r3.getContext()) == true) goto L19;
        if (hasNotchAtOPPO(r3.getContext()) == true) goto L19;
        if (hasNotchAtVIVO(r3.getContext()) == true) goto L19;
        if (hasNotchAtAndroidP(r3) == false) goto L20;
    L5:
        return sNotchResult;
    }

    private static boolean hasNotchAtAndroidP(View r0) {
        if (getDisplayCutout(r0) == null) goto L5;
        return true;
    L5:
        return false;
    }

    private static boolean hasNotchAtAndroidP(Activity r0) {
        if (getDisplayCutout(r0) == null) goto L5;
        return true;
    L5:
        return false;
    }

    private static DisplayCutout getDisplayCutout(Activity r0) {
        if (r0 == null) goto L9;
        Window r1 = r0.getWindow();
        if (r1 == null) goto L11;
        WindowInsets r2 = r1.getDecorView().getRootWindowInsets();
        if (r2 != null) goto L8;
        return null;
    L8:
        return r2.getDisplayCutout();
    L11:
        return null;
    L9:
        return null;
    }

    private static DisplayCutout getDisplayCutout(View r0) {
        if (r0 == null) goto L7;
        WindowInsets r1 = r0.getRootWindowInsets();
        if (r1 != null) goto L6;
        return null;
    L6:
        return r1.getDisplayCutout();
    L7:
        return null;
    }

    private static boolean hasNotchAtXiaoMi(Context r6) {
        if ("Xiaomi".equals(Build.MANUFACTURER) == true) goto L12;
    L6:
        int r7 = 0;
    L7:
        if (r7 != 1) goto L10;
        return true;
    L10:
        return false;
    L12:
        Class<?> r8 = r6.getClassLoader().loadClass(SYSTEM_PROPERTIES);     // Catch: Throwable -> L11
        r7 = ((Integer) r8.getMethod("getInt", new Class[]{String.class, Integer.TYPE}).invoke(r8, new Object[]{NOTCH_XIAO_MI, 0})).intValue();     // Catch: Throwable -> L11
        goto L7
    }

    private static boolean hasNotchAtHuaWei(Context r3) {
        Class<?> r4 = r3.getClassLoader().loadClass(NOTCH_HUA_WEI);     // Catch: Throwable -> L5
        return ((Boolean) r4.getMethod("hasNotchInScreen", new Class[0]).invoke(r4, new Object[0])).booleanValue();
    L8:
        return false;
    }

    private static boolean hasNotchAtVIVO(Context r5) {
        Class<?> r6 = r5.getClassLoader().loadClass(NOTCH_VIVO);     // Catch: Throwable -> L5
        return ((Boolean) r6.getMethod("isFeatureSupport", new Class[]{Integer.TYPE}).invoke(r6, new Object[]{32})).booleanValue();
    L8:
        return false;
    }

    private static boolean hasNotchAtOPPO(Context r1) {
        return r1.getPackageManager().hasSystemFeature(NOTCH_OPPO);
    L4:
        return false;
    }
}
