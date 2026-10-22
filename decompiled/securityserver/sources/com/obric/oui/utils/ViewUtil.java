package com.obric.oui.utils;

import android.graphics.Color;
import kotlin.Metadata;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class ViewUtil {
    public static final int a(int r3, float r4) {
        if (r4 != 1.0f) goto L5;
        return r3;
    L5:
        float r5 = RangesKt.a(r4, 0.0f, 1.0f);
        return Color.argb((int) (Color.alpha(r3) * r5), Color.red(r3), Color.green(r3), Color.blue(r3));
    }
}
