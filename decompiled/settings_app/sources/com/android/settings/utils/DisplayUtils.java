package com.android.settings.utils;

import android.content.res.Resources;
import android.util.TypedValue;

/* JADX INFO: loaded from: classes2.dex */
public class DisplayUtils {
    public DisplayUtils() {
    }

    public static float dip2px(float r2) {
        return TypedValue.applyDimension(1, r2, Resources.getSystem().getDisplayMetrics());
    }
}
