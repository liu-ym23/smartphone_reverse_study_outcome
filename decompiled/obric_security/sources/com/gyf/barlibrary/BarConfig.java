package com.gyf.barlibrary;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.provider.Settings;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Display;

/* JADX INFO: loaded from: classes2.dex */
class BarConfig {
    private static final String MIUI_FORCE_FSG_NAV_BAR = "force_fsg_nav_bar";
    private static final String NAV_BAR_HEIGHT_LANDSCAPE_RES_NAME = "navigation_bar_height_landscape";
    private static final String NAV_BAR_HEIGHT_RES_NAME = "navigation_bar_height";
    private static final String NAV_BAR_WIDTH_RES_NAME = "navigation_bar_width";
    private static final String STATUS_BAR_HEIGHT_RES_NAME = "status_bar_height";
    private final int mActionBarHeight;
    private final boolean mHasNavigationBar;
    private final boolean mHasNotchScreen;
    private final boolean mInPortrait;
    private final int mNavigationBarHeight;
    private final int mNavigationBarWidth;
    private final float mSmallestWidthDp;
    private final int mStatusBarHeight;

    BarConfig(Activity r5) {
        boolean r1 = false;
        if (r5.getResources().getConfiguration().orientation != 1) goto L5;
        boolean r0 = true;
    L6:
        this.mInPortrait = r0;
        this.mSmallestWidthDp = getSmallestWidthDp(r5);
        this.mStatusBarHeight = getInternalDimensionSize(r5, STATUS_BAR_HEIGHT_RES_NAME);
        this.mActionBarHeight = getActionBarHeight(r5);
        int r2 = getNavigationBarHeight(r5);
        this.mNavigationBarHeight = r2;
        this.mNavigationBarWidth = getNavigationBarWidth(r5);
        if (r2 <= 0) goto L9;
        r1 = true;
    L9:
        this.mHasNavigationBar = r1;
        this.mHasNotchScreen = NotchUtils.hasNotchScreen(r5);
        return;
    L5:
        r0 = false;
        goto L6
    }

    private int getActionBarHeight(Context r4) {
        TypedValue r3 = new TypedValue();
        r4.getTheme().resolveAttribute(android.R.attr.actionBarSize, r3, true);
        return TypedValue.complexToDimensionPixelSize(r3.data, r4.getResources().getDisplayMetrics());
    }

    private int getNavigationBarHeight(Context r2) {
        if (hasNavBar((Activity) r2) == true) goto L5;
        return 0;
    L5:
        if (this.mInPortrait == false) goto L7;
        String r0 = NAV_BAR_HEIGHT_RES_NAME;
    L9:
        return getInternalDimensionSize(r2, r0);
    L7:
        r0 = NAV_BAR_HEIGHT_LANDSCAPE_RES_NAME;
        goto L9
    }

    private int getNavigationBarWidth(Context r2) {
        if (hasNavBar((Activity) r2) == true) goto L5;
        return 0;
    L5:
        return getInternalDimensionSize(r2, NAV_BAR_WIDTH_RES_NAME);
    }

    private boolean hasNavBar(Activity r4) {
        if (Settings.Global.getInt(r4.getContentResolver(), MIUI_FORCE_FSG_NAV_BAR, 0) == 0) goto L5;
        return false;
    L5:
        Display r3 = r4.getWindowManager().getDefaultDisplay();
        DisplayMetrics r5 = new DisplayMetrics();
        r3.getRealMetrics(r5);
        int r0 = r5.heightPixels;
        int r6 = r5.widthPixels;
        DisplayMetrics r2 = new DisplayMetrics();
        r3.getMetrics(r2);
        int r7 = r2.heightPixels;
        if ((r6 - r2.widthPixels) <= 0) goto L8;
    L9:
        return true;
    L8:
        if ((r0 - r7) > 0) goto L9;
        return false;
    }

    private int getInternalDimensionSize(Context r4, String r5) {
        int r6 = Resources.getSystem().getIdentifier(r5, "dimen", "android");     // Catch: Resources.NotFoundException -> L10
        if (r6 <= 0) goto L13;
        int r0 = r4.getResources().getDimensionPixelSize(r6);     // Catch: Resources.NotFoundException -> L10
        int r7 = Resources.getSystem().getDimensionPixelSize(r6);     // Catch: Resources.NotFoundException -> L10
        if (r7 < r0) goto L8;
        return r7;
    L8:
        return Math.round((r0 * Resources.getSystem().getDisplayMetrics().density) / r4.getResources().getDisplayMetrics().density);
    L13:
        return 0;
    L14:
        return 0;
    }

    private float getSmallestWidthDp(Activity r2) {
        DisplayMetrics r1 = new DisplayMetrics();
        r2.getWindowManager().getDefaultDisplay().getRealMetrics(r1);
        return Math.min(r1.widthPixels / r1.density, r1.heightPixels / r1.density);
    }

    boolean isNavigationAtBottom() {
        if (this.mSmallestWidthDp < 600.0f) goto L5;
    L8:
        return true;
    L5:
        if (this.mInPortrait == true) goto L8;
        return false;
    }

    int getStatusBarHeight() {
        return this.mStatusBarHeight;
    }

    int getActionBarHeight() {
        return this.mActionBarHeight;
    }

    boolean hasNavigationBar() {
        return this.mHasNavigationBar;
    }

    int getNavigationBarHeight() {
        return this.mNavigationBarHeight;
    }

    int getNavigationBarWidth() {
        return this.mNavigationBarWidth;
    }

    boolean hasNotchScreen() {
        return this.mHasNotchScreen;
    }
}
