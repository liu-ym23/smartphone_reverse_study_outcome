package com.google.android.material.color;

import android.content.Context;
import android.graphics.Color;
import android.util.TypedValue;
import android.view.View;
import com.google.android.material.R;
import com.google.android.material.resources.MaterialAttributes;

/* JADX INFO: loaded from: classes3.dex */
public class MaterialColors {
    public static final float ALPHA_DISABLED = 0.38f;
    public static final float ALPHA_DISABLED_LOW = 0.12f;
    public static final float ALPHA_FULL = 1.0f;
    public static final float ALPHA_LOW = 0.32f;
    public static final float ALPHA_MEDIUM = 0.54f;
    private static final int TONE_ACCENT_CONTAINER_DARK = 30;
    private static final int TONE_ACCENT_CONTAINER_LIGHT = 90;
    private static final int TONE_ACCENT_DARK = 80;
    private static final int TONE_ACCENT_LIGHT = 40;
    private static final int TONE_ON_ACCENT_CONTAINER_DARK = 90;
    private static final int TONE_ON_ACCENT_CONTAINER_LIGHT = 10;
    private static final int TONE_ON_ACCENT_DARK = 20;
    private static final int TONE_ON_ACCENT_LIGHT = 100;

    private MaterialColors() {
    }

    public static int getColor(View r0, int r1) {
        return MaterialAttributes.resolveOrThrow(r0, r1);
    }

    public static int getColor(Context r0, int r1, String r2) {
        return MaterialAttributes.resolveOrThrow(r0, r1, r2);
    }

    public static int getColor(View r0, int r1, int r2) {
        return getColor(r0.getContext(), r1, r2);
    }

    public static int getColor(Context r0, int r1, int r2) {
        TypedValue r3 = MaterialAttributes.resolve(r0, r1);
        if (r3 != null) goto L5;
        return r2;
    L5:
        return r3.data;
    }

    public static int layer(View r1, int r2, int r3) {
        return layer(r1, r2, r3, 1.0f);
    }

    public static int layer(View r0, int r1, int r2, float r3) {
        return layer(getColor(r0, r1), getColor(r0, r2), r3);
    }

    public static int layer(int r1, int r2, float r3) {
        return layer(r1, androidx.core.graphics.ColorUtils.setAlphaComponent(r2, Math.round(Color.alpha(r2) * r3)));
    }

    public static int layer(int r0, int r1) {
        return androidx.core.graphics.ColorUtils.compositeColors(r1, r0);
    }

    public static int compositeARGBWithAlpha(int r1, int r2) {
        return androidx.core.graphics.ColorUtils.setAlphaComponent(r1, (Color.alpha(r1) * r2) / 255);
    }

    public static boolean isColorLight(int r4) {
        if (r4 != 0) goto L4;
    L6:
        return false;
    L4:
        if (androidx.core.graphics.ColorUtils.calculateLuminance(r4) <= 0.5d) goto L6;
        return true;
    }

    public static int harmonizeWithPrimary(Context r2, int r3) {
        return harmonize(r3, getColor(r2, R.attr.colorPrimary, MaterialColors.class.getCanonicalName()));
    }

    public static int harmonize(int r0, int r1) {
        return Blend.harmonize(r0, r1);
    }

    public static ColorRoles getColorRoles(Context r2, int r3) {
        return getColorRoles(r3, MaterialAttributes.resolveBoolean(r2, R.attr.isLightTheme, true));
    }

    public static ColorRoles getColorRoles(int r4, boolean r5) {
        if (r5 == false) goto L6;
        return new ColorRoles(getColorRole(r4, 40), getColorRole(r4, 100), getColorRole(r4, 90), getColorRole(r4, 10));
    L6:
        return new ColorRoles(getColorRole(r4, 80), getColorRole(r4, 20), getColorRole(r4, 30), getColorRole(r4, 90));
    }

    private static int getColorRole(int r0, int r1) {
        Hct r2 = Hct.fromInt(r0);
        r2.setTone(r1);
        return r2.toInt();
    }
}
