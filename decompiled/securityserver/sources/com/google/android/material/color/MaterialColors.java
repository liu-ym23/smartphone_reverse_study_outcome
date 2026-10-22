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
import androidx.core.graphics.ColorUtils;
import com.google.android.material.resources.MaterialAttributes;

/* JADX INFO: loaded from: classes.dex */
public class MaterialColors {
    public static final float ALPHA_DISABLED = 0.38f;
    public static final float ALPHA_DISABLED_LOW = 0.12f;
    public static final float ALPHA_FULL = 1.0f;
    public static final float ALPHA_LOW = 0.32f;
    public static final float ALPHA_MEDIUM = 0.54f;

    private MaterialColors() {
    }

    @ColorInt
    public static int compositeARGBWithAlpha(@ColorInt int r1, @IntRange(from = 0, to = 255) int r2) {
        return ColorUtils.setAlphaComponent(r1, (Color.alpha(r1) * r2) / 255);
    }

    @ColorInt
    public static int getColor(@NonNull View r0, @AttrRes int r1) {
        return MaterialAttributes.resolveOrThrow(r0, r1);
    }

    @ColorInt
    public static int layer(@NonNull View r1, @AttrRes int r2, @AttrRes int r3) {
        return layer(r1, r2, r3, 1.0f);
    }

    @ColorInt
    public static int getColor(Context r0, @AttrRes int r1, String r2) {
        return MaterialAttributes.resolveOrThrow(r0, r1, r2);
    }

    @ColorInt
    public static int layer(@NonNull View r0, @AttrRes int r1, @AttrRes int r2, @FloatRange(from = 0.0d, to = 1.0d) float r3) {
        return layer(getColor(r0, r1), getColor(r0, r2), r3);
    }

    @ColorInt
    public static int getColor(@NonNull View r0, @AttrRes int r1, @ColorInt int r2) {
        return getColor(r0.getContext(), r1, r2);
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
    public static int layer(@ColorInt int r1, @ColorInt int r2, @FloatRange(from = 0.0d, to = 1.0d) float r3) {
        return layer(r1, ColorUtils.setAlphaComponent(r2, Math.round(Color.alpha(r2) * r3)));
    }

    @ColorInt
    public static int layer(@ColorInt int r0, @ColorInt int r1) {
        return ColorUtils.compositeColors(r1, r0);
    }
}
