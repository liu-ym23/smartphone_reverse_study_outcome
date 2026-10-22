package com.obric.oui.animation.style;

import android.util.Log;
import kotlin.Metadata;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class CommonStyleKt {
    public static final void a(float r2) {
        RangesKt.a(r2, 0.0f, 1.0f);     // Catch: Exception -> L5
        throw null;     // Catch: Exception -> L5
    L5:
        e = move-exception;
        Log.w("CommonAnimStyle", "updateWindowDimWithAnim: " + e.getMessage());
    }
}
