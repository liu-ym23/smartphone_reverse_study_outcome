package com.google.android.material.theme.overlay;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StyleRes;
import androidx.appcompat.view.ContextThemeWrapper;

/* JADX INFO: loaded from: classes2.dex */
public class MaterialThemeOverlay {
    private static final int[] ANDROID_THEME_OVERLAY_ATTRS = null;
    private static final int[] MATERIAL_THEME_OVERLAY_ATTR = null;

    static {
        ANDROID_THEME_OVERLAY_ATTRS = new int[]{R.attr.theme, com.google.android.material.R.attr.theme};
        MATERIAL_THEME_OVERLAY_ATTR = new int[]{com.google.android.material.R.attr.materialThemeOverlay};
    }

    private MaterialThemeOverlay() {
    }

    @StyleRes
    private static int obtainAndroidThemeOverlayId(@NonNull Context r2, AttributeSet r3) {
        TypedArray r4 = r2.obtainStyledAttributes(r3, ANDROID_THEME_OVERLAY_ATTRS);
        int r0 = r4.getResourceId(0, 0);
        int r5 = r4.getResourceId(1, 0);
        r4.recycle();
        if (r0 == 0) goto L6;
        return r0;
    L6:
        return r5;
    }

    @StyleRes
    private static int obtainMaterialThemeOverlayId(@NonNull Context r1, @Nullable AttributeSet r2, @AttrRes int r3, @StyleRes int r4) {
        TypedArray r5 = r1.obtainStyledAttributes(r2, MATERIAL_THEME_OVERLAY_ATTR, r3, r4);
        int r6 = r5.getResourceId(0, 0);
        r5.recycle();
        return r6;
    }

    @NonNull
    public static Context wrap(@NonNull Context r1, @Nullable AttributeSet r2, @AttrRes int r3, @StyleRes int r4) {
        int r5 = obtainMaterialThemeOverlayId(r1, r2, r3, r4);
        if ((r1 instanceof ContextThemeWrapper) == true) goto L5;
    L7:
        boolean r6 = false;
    L8:
        if (r5 == 0) goto L15;
        if (r6 == true) goto L15;
        ContextThemeWrapper r7 = new ContextThemeWrapper(r1, r5);
        int r8 = obtainAndroidThemeOverlayId(r1, r2);
        if (r8 == 0) goto L14;
        r7.getTheme().applyStyle(r8, true);
    L14:
        return r7;
    L15:
        return r1;
    L5:
        if (((ContextThemeWrapper) r1).getThemeResId() != r5) goto L7;
        r6 = true;
        goto L8
    }
}
