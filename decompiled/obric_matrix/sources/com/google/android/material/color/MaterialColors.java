package com.google.android.material.color;

import android.content.Context;
import android.graphics.Color;
import android.util.TypedValue;
import android.view.View;
import androidx.annotation.AttrRes;
import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import com.google.android.material.R;
import com.google.android.material.resources.MaterialAttributes;

/* JADX INFO: loaded from: classes2.dex */
public class MaterialColors {
    public static final float ALPHA_DISABLED = 0.38f;
    public static final float ALPHA_DISABLED_LOW = 0.12f;
    public static final float ALPHA_FULL = 1.0f;
    public static final float ALPHA_LOW = 0.32f;
    public static final float ALPHA_MEDIUM = 0.54f;
    private static final int TONE_ACCENT_CONTAINER_DARK = 20;
    private static final int TONE_ACCENT_CONTAINER_LIGHT = 90;
    private static final int TONE_ACCENT_DARK = 70;
    private static final int TONE_ACCENT_LIGHT = 40;
    private static final int TONE_ON_ACCENT_CONTAINER_DARK = 80;
    private static final int TONE_ON_ACCENT_CONTAINER_LIGHT = 10;
    private static final int TONE_ON_ACCENT_DARK = 10;
    private static final int TONE_ON_ACCENT_LIGHT = 100;

    private MaterialColors() {
    }

    @ColorInt
    public static int compositeARGBWithAlpha(@ColorInt int r1, @IntRange(from = 0, to = 255) int r2) {
        return androidx.core.graphics.ColorUtils.setAlphaComponent(r1, (Color.alpha(r1) * r2) / 255);
    }

    @ColorInt
    public static int getColor(@NonNull Context r0, @AttrRes int r1, @ColorInt int r2) {
        TypedValue r3 = MaterialAttributes.resolve(r0, r1);
        if (r3 != null) goto L5;
        return r2;
    L5:
        return r3.data;
    }

    @ColorInt
    public static int getColor(Context r0, @AttrRes int r1, String r2) {
        return MaterialAttributes.resolveOrThrow(r0, r1, r2);
    }

    @ColorInt
    public static int getColor(@NonNull View r0, @AttrRes int r1) {
        return MaterialAttributes.resolveOrThrow(r0, r1);
    }

    @ColorInt
    public static int getColor(@NonNull View r0, @AttrRes int r1, @ColorInt int r2) {
        return getColor(r0.getContext(), r1, r2);
    }

    @ColorInt
    private static int getColorRole(@ColorInt int r0, @IntRange(from = 0, to = 100) int r1) {
        Hct r2 = Hct.fromInt(r0);
        r2.setTone(r1);
        return r2.toInt();
    }

    @NonNull
    public static ColorRoles getColorRoles(@ColorInt int r4, boolean r5) {
        if (r5 == false) goto L6;
        return new ColorRoles(getColorRole(r4, 40), getColorRole(r4, 100), getColorRole(r4, 90), getColorRole(r4, 10));
    L6:
        return new ColorRoles(getColorRole(r4, 70), getColorRole(r4, 10), getColorRole(r4, 20), getColorRole(r4, 80));
    }

    @NonNull
    public static ColorRoles getColorRoles(@NonNull Context r2, @ColorInt int r3) {
        return getColorRoles(r3, MaterialAttributes.resolveBoolean(r2, R.attr.isLightTheme, true));
    }

    @ColorInt
    public static int harmonize(@ColorInt int r0, @ColorInt int r1) {
        return Blend.harmonize(r0, r1);
    }

    @ColorInt
    public static int harmonizeWithPrimary(@NonNull Context r2, @ColorInt int r3) {
        return harmonize(r3, getColor(r2, R.attr.colorPrimary, MaterialColors.class.getCanonicalName()));
    }

    public static boolean isColorLight(@ColorInt int r4) {
        if (r4 != 0) goto L4;
    L6:
        return false;
    L4:
        if (androidx.core.graphics.ColorUtils.calculateLuminance(r4) <= 0.5d) goto L6;
        return true;
    }

    @ColorInt
    public static int layer(@ColorInt int r0, @ColorInt int r1) {
        return androidx.core.graphics.ColorUtils.compositeColors(r1, r0);
    }

    @ColorInt
    public static int layer(@ColorInt int r1, @ColorInt int r2, @FloatRange(from = 0.0d, to = 1.0d) float r3) {
        return layer(r1, androidx.core.graphics.ColorUtils.setAlphaComponent(r2, Math.round(Color.alpha(r2) * r3)));
    }

    @ColorInt
    public static int layer(@NonNull View r1, @AttrRes int r2, @AttrRes int r3) {
        return layer(r1, r2, r3, 1.0f);
    }

    @ColorInt
    public static int layer(@NonNull View r0, @AttrRes int r1, @AttrRes int r2, @FloatRange(from = 0.0d, to = 1.0d) float r3) {
        return layer(getColor(r0, r1), getColor(r0, r2), r3);
    }
}
