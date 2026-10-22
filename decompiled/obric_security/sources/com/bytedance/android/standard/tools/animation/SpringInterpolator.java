package com.bytedance.android.standard.tools.animation;

import android.view.animation.Interpolator;

/* JADX INFO: loaded from: classes.dex */
public class SpringInterpolator implements Interpolator {
    private float mFactor;

    public SpringInterpolator() {
        this.mFactor = 1.0f;
    }

    public SpringInterpolator(float r1) {
        this.mFactor = r1;
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float r7) {
        double r0 = Math.pow(2.0d, (-10.0f) * r7);
        float r6 = this.mFactor;
        return (float) ((r0 * Math.sin((((double) (r7 - (r6 / 4.0f))) * 6.283185307179586d) / ((double) r6))) + 1.0d);
    }
}
