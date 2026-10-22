package com.obric.oui.common.style;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;

/* JADX INFO: loaded from: classes3.dex */
public class OUIDisplayHelper {
    public OUIDisplayHelper() {
    }

    public static DisplayMetrics getDisplayMetrics(Context r0) {
        return r0.getResources().getDisplayMetrics();
    }

    public static int dp2px(Context r2, int r3) {
        return (int) (((double) (getDensity(r2) * r3)) + 0.5d);
    }

    public static float dp2pxf(Resources r0, float r1) {
        return r0.getDisplayMetrics().density * r1;
    }

    public static int sp2px(Context r2, int r3) {
        return (int) (((double) (getFontDensity(r2) * r3)) + 0.5d);
    }

    public static int px2dp(Context r2, int r3) {
        return (int) (((double) (r3 / getDensity(r2))) + 0.5d);
    }

    public static float getDensity(Context r0) {
        return r0.getResources().getDisplayMetrics().density;
    }

    public static float getFontDensity(Context r0) {
        return r0.getResources().getDisplayMetrics().scaledDensity;
    }
}
