package com.google.android.material.internal;

import android.R;
import android.content.Context;
import android.view.Window;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import com.google.android.material.color.MaterialColors;

/* JADX INFO: loaded from: classes3.dex */
public class EdgeToEdgeUtils {
    private static final int EDGE_TO_EDGE_BAR_ALPHA = 128;

    private EdgeToEdgeUtils() {
    }

    public static void applyEdgeToEdge(Window r1, boolean r2) {
        applyEdgeToEdge(r1, r2, null, null);
    }

    public static void applyEdgeToEdge(Window r5, boolean r6, Integer r7, Integer r8) {
        boolean r0 = false;
        if (r7 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r8 != null) goto L11;
    L12:
        r0 = true;
    L13:
        if (r2 == true) goto L15;
        if (r0 == true) goto L15;
    L20:
        WindowCompat.setDecorFitsSystemWindows(r5, !r6);
        int r1 = getStatusBarColor(r5.getContext(), r6);
        int r9 = getNavigationBarColor(r5.getContext(), r6);
        r5.setStatusBarColor(r1);
        r5.setNavigationBarColor(r9);
        boolean r10 = isUsingLightSystemBar(r1, MaterialColors.isColorLight(r7.intValue()));
        boolean r11 = isUsingLightSystemBar(r9, MaterialColors.isColorLight(r8.intValue()));
        WindowInsetsControllerCompat r12 = WindowCompat.getInsetsController(r5, r5.getDecorView());
        if (r12 == null) goto L24;
        r12.setAppearanceLightStatusBars(r10);
        r12.setAppearanceLightNavigationBars(r11);
        return;
    L24:
        return;
    L15:
        int r3 = MaterialColors.getColor(r5.getContext(), R.attr.colorBackground, -16777216);
        if (r2 == false) goto L18;
        r7 = Integer.valueOf(r3);
    L18:
        if (r0 == false) goto L20;
        r8 = Integer.valueOf(r3);
        goto L20
    L11:
        if (r8.intValue() != 0) goto L13;
    L5:
        if (r7.intValue() == 0) goto L8;
        r2 = false;
        goto L9
    }

    private static int getStatusBarColor(Context r1, boolean r2) {
        if (r2 == false) goto L6;
        return 0;
    L6:
        return MaterialColors.getColor(r1, R.attr.statusBarColor, -16777216);
    }

    private static int getNavigationBarColor(Context r1, boolean r2) {
        if (r2 == false) goto L6;
        return 0;
    L6:
        return MaterialColors.getColor(r1, R.attr.navigationBarColor, -16777216);
    }

    private static boolean isUsingLightSystemBar(int r1, boolean r2) {
        if (MaterialColors.isColorLight(r1) == true) goto L8;
        if (r1 != 0) goto L7;
        if (r2 == true) goto L8;
    L7:
        return false;
    L8:
        return true;
    }
}
