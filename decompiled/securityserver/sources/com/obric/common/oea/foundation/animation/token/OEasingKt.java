package com.obric.common.oea.foundation.animation.token;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class OEasingKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f129a = 0;

    static {
        new CubicBezierEasing(0.4f, 0.0f, 0.2f, 1.0f);
    }

    public static final int a(float r3, float[] r4, int r5) {
        float r0 = 0.0f;
        if (r3 < 0.0f) goto L5;
        r0 = 1.0f;
        if (r3 > 1.0f) goto L11;
    L13:
        r4[r5] = r3;
        return !Float.isNaN(r3) ? 1 : 0;
    L11:
        if (r3 <= 1.0000008f) goto L6;
    L7:
        r3 = Float.NaN;
    L6:
        r3 = r0;
        goto L13
    L5:
        if (r3 < (-8.34465E-7f)) goto L7;
        goto L6
    }
}
