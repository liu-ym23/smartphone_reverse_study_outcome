package com.obric.oui.utils;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class AnimUtils {
    static {
    }

    public static float a(float r1, float r2, float r3) {
        if (r2 != r3) goto L7;
        return 0.0f;
    L7:
        return (r1 - r2) / (r3 - r2);
    }
}
