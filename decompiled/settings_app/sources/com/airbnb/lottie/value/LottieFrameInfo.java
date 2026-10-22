package com.airbnb.lottie.value;

/* JADX INFO: loaded from: classes.dex */
public class LottieFrameInfo<T> {
    private float endFrame;
    private T endValue;
    private float interpolatedKeyframeProgress;
    private float linearKeyframeProgress;
    private float overallProgress;
    private float startFrame;
    private T startValue;

    public LottieFrameInfo() {
    }

    public LottieFrameInfo<T> set(float r1, float r2, T r3, T r4, float r5, float r6, float r7) {
        this.startFrame = r1;
        this.endFrame = r2;
        this.startValue = r3;
        this.endValue = r4;
        this.linearKeyframeProgress = r5;
        this.interpolatedKeyframeProgress = r6;
        this.overallProgress = r7;
        return this;
    }

    public float getStartFrame() {
        return this.startFrame;
    }

    public float getEndFrame() {
        return this.endFrame;
    }

    public T getStartValue() {
        return this.startValue;
    }

    public T getEndValue() {
        return this.endValue;
    }

    public float getLinearKeyframeProgress() {
        return this.linearKeyframeProgress;
    }

    public float getInterpolatedKeyframeProgress() {
        return this.interpolatedKeyframeProgress;
    }

    public float getOverallProgress() {
        return this.overallProgress;
    }
}
