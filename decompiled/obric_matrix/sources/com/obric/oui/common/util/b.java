package com.obric.oui.common.util;

import android.graphics.Color;
import android.graphics.ColorMatrixColorFilter;

/* JADX INFO: loaded from: classes2.dex */
public final class b {
    public static final ColorMatrixColorFilter a(int r5) {
        return new ColorMatrixColorFilter(new float[]{1.0f, 0.0f, 0.0f, 0.0f, Color.red(r5), 0.0f, 1.0f, 0.0f, 0.0f, Color.green(r5), 0.0f, 0.0f, 1.0f, 0.0f, Color.blue(r5), 0.0f, 0.0f, 0.0f, (Color.alpha(r5) * 1.0f) / 255, 0.0f});
    }
}
