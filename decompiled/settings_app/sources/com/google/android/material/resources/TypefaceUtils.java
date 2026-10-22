package com.google.android.material.resources;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Typeface;
import androidx.core.math.MathUtils;

/* JADX INFO: loaded from: classes3.dex */
public class TypefaceUtils {
    private TypefaceUtils() {
    }

    public static Typeface maybeCopyWithFontWeightAdjustment(Context r0, Typeface r1) {
        return maybeCopyWithFontWeightAdjustment(r0.getResources().getConfiguration(), r1);
    }

    public static Typeface maybeCopyWithFontWeightAdjustment(Configuration r2, Typeface r3) {
        if (r2.fontWeightAdjustment != Integer.MAX_VALUE) goto L5;
        return null;
    L5:
        if (r2.fontWeightAdjustment != 0) goto L7;
        return null;
    L7:
        return Typeface.create(r3, MathUtils.clamp(r3.getWeight() + r2.fontWeightAdjustment, 1, 1000), r3.isItalic());
    }
}
