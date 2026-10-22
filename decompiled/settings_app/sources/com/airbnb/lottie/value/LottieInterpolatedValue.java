package com.airbnb.lottie.value;

import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;

/* JADX INFO: loaded from: classes.dex */
abstract class LottieInterpolatedValue<T> extends LottieValueCallback<T> {
    private final T endValue;
    private final Interpolator interpolator;
    private final T startValue;

    abstract T interpolateValue(T r1, T r2, float r3);

    LottieInterpolatedValue(T r2, T r3) {
        this(r2, r3, new LinearInterpolator());
    }

    LottieInterpolatedValue(T r1, T r2, Interpolator r3) {
        this.startValue = r1;
        this.endValue = r2;
        this.interpolator = r3;
    }

    @Override // com.airbnb.lottie.value.LottieValueCallback
    public T getValue(LottieFrameInfo<T> r3) {
        float r4 = this.interpolator.getInterpolation(r3.getOverallProgress());
        return interpolateValue(this.startValue, this.endValue, r4);
    }
}
