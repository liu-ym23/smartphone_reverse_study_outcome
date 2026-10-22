package com.android.settingslib.utils;

import android.content.Context;
import android.content.res.TypedArray;

/* JADX INFO: loaded from: classes.dex */
public class ColorUtil {
    public ColorUtil() {
    }

    public static float getDisabledAlpha(Context r3) {
        TypedArray r4 = r3.obtainStyledAttributes(new int[]{android.R.attr.disabledAlpha});
        float r0 = r4.getFloat(0, 0.0f);
        r4.recycle();
        return r0;
    }
}
