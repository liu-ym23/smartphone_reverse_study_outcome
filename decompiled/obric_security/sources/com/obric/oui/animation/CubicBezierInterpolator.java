package com.obric.oui.animation;

import android.view.animation.Interpolator;

/* JADX INFO: loaded from: classes3.dex */
public class CubicBezierInterpolator implements Interpolator {
    private final float mControlPoint1X;
    private final float mControlPoint1Y;
    private final float mControlPoint2X;
    private final float mControlPoint2Y;

    private float calculateBezier(float t, float p1, float p2) {
        float r3 = 1.0f - t;
        float r0 = t * t;
        float r2 = 3.0f * r3;
        float r4 = (((r3 * r2) * t) * p1) + ((r2 * r0) * p2);
        return r4 + (r0 * t);
    }

    public CubicBezierInterpolator(float controlPoint1X, float controlPoint1Y, float controlPoint2X, float controlPoint2Y) {
        this.mControlPoint1X = controlPoint1X;
        this.mControlPoint1Y = controlPoint1Y;
        this.mControlPoint2X = controlPoint2X;
        this.mControlPoint2Y = controlPoint2Y;
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float t) {
        return calculateBezier(t, this.mControlPoint1Y, this.mControlPoint2Y);
    }
}
