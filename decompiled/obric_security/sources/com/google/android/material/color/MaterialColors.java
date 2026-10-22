package com.google.android.material.color;

import android.content.Context;
import android.graphics.Color;
import android.util.TypedValue;
import android.view.View;
import androidx.core.graphics.ColorUtils;
import com.google.android.material.resources.MaterialAttributes;

/* JADX INFO: loaded from: classes2.dex */
public class MaterialColors {
    public static final float ALPHA_DISABLED = 0.38f;
    public static final float ALPHA_DISABLED_LOW = 0.12f;
    public static final float ALPHA_FULL = 1.0f;
    public static final float ALPHA_LOW = 0.32f;
    public static final float ALPHA_MEDIUM = 0.54f;

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
        return layer(r1, ColorUtils.setAlphaComponent(r2, Math.round(Color.alpha(r2) * r3)));
    }

    public static int layer(int r0, int r1) {
        return ColorUtils.compositeColors(r1, r0);
    }

    public static int compositeARGBWithAlpha(int r1, int r2) {
        return ColorUtils.setAlphaComponent(r1, (Color.alpha(r1) * r2) / 255);
    }
}
