package com.airbnb.lottie.value;

import android.graphics.PointF;
import android.view.animation.Interpolator;
import com.airbnb.lottie.utils.MiscUtils;

/* JADX INFO: loaded from: classes.dex */
public class LottieInterpolatedPointValue extends LottieInterpolatedValue<PointF> {
    private final PointF point;

    @Override // com.airbnb.lottie.value.LottieInterpolatedValue
    /* bridge */ /* synthetic */ PointF interpolateValue(PointF r1, PointF r2, float r3) {
        return interpolateValue2(r1, r2, r3);
    }

    public LottieInterpolatedPointValue(PointF r1, PointF r2) {
        super(r1, r2);
        this.point = new PointF();
    }

    public LottieInterpolatedPointValue(PointF r1, PointF r2, Interpolator r3) {
        super(r1, r2, r3);
        this.point = new PointF();
    }

    /* JADX INFO: renamed from: interpolateValue, reason: avoid collision after fix types in other method */
    PointF interpolateValue2(PointF r4, PointF r5, float r6) {
        this.point.set(MiscUtils.lerp(r4.x, r5.x, r6), MiscUtils.lerp(r4.y, r5.y, r6));
        return this.point;
    }
}
