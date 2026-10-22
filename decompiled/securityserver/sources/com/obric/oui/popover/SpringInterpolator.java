package com.obric.oui.popover;

import android.view.animation.Interpolator;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class SpringInterpolator implements Interpolator {
    @Override // android.animation.TimeInterpolator
    public final float getInterpolation(float r7) {
        if (r7 != 0.0f) goto L5;
        return r7;
    L5:
        if (r7 == 1.0f) goto L10;
        double r6 = 0.0f;
        return (float) ((Math.sin(((((double) r7) - (r6 / 4.0d)) * 6.283185307179586d) / r6) * Math.pow(2.0d, (-10) * r7)) + ((double) 1));
    L10:
        return r7;
    }
}
