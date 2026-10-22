package com.github.mikephil.charting.animation;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;

/* JADX INFO: loaded from: classes2.dex */
public class ChartAnimator {
    private ValueAnimator.AnimatorUpdateListener mListener;
    protected float mPhaseX;
    protected float mPhaseY;

    public ChartAnimator() {
        this.mPhaseY = 1.0f;
        this.mPhaseX = 1.0f;
    }

    public ChartAnimator(ValueAnimator.AnimatorUpdateListener r2) {
        this.mPhaseY = 1.0f;
        this.mPhaseX = 1.0f;
        this.mListener = r2;
    }

    private ObjectAnimator xAnimator(int r3, Easing.EasingFunction r4) {
        ObjectAnimator r2 = ObjectAnimator.ofFloat(this, "phaseX", new float[]{0.0f, 1.0f});
        r2.setInterpolator(r4);
        r2.setDuration(r3);
        return r2;
    }

    private ObjectAnimator yAnimator(int r3, Easing.EasingFunction r4) {
        ObjectAnimator r2 = ObjectAnimator.ofFloat(this, "phaseY", new float[]{0.0f, 1.0f});
        r2.setInterpolator(r4);
        r2.setDuration(r3);
        return r2;
    }

    public void animateX(int r2) {
        animateX(r2, Easing.Linear);
    }

    public void animateX(int r1, Easing.EasingFunction r2) {
        ObjectAnimator r3 = xAnimator(r1, r2);
        r3.addUpdateListener(this.mListener);
        r3.start();
    }

    public void animateXY(int r3, int r4) {
        animateXY(r3, r4, Easing.Linear, Easing.Linear);
    }

    public void animateXY(int r2, int r3, Easing.EasingFunction r4) {
        ObjectAnimator r0 = xAnimator(r2, r4);
        ObjectAnimator r5 = yAnimator(r3, r4);
        if (r2 <= r3) goto L5;
        r0.addUpdateListener(this.mListener);
    L6:
        r0.start();
        r5.start();
        return;
    L5:
        r5.addUpdateListener(this.mListener);
        goto L6
    }

    public void animateXY(int r1, int r2, Easing.EasingFunction r3, Easing.EasingFunction r4) {
        ObjectAnimator r5 = xAnimator(r1, r3);
        ObjectAnimator r6 = yAnimator(r2, r4);
        if (r1 <= r2) goto L5;
        r5.addUpdateListener(this.mListener);
    L6:
        r5.start();
        r6.start();
        return;
    L5:
        r6.addUpdateListener(this.mListener);
        goto L6
    }

    public void animateY(int r2) {
        animateY(r2, Easing.Linear);
    }

    public void animateY(int r1, Easing.EasingFunction r2) {
        ObjectAnimator r3 = yAnimator(r1, r2);
        r3.addUpdateListener(this.mListener);
        r3.start();
    }

    public float getPhaseY() {
        return this.mPhaseY;
    }

    public void setPhaseY(float r3) {
        float r0 = 1.0f;
        if (r3 <= 1.0f) goto L5;
    L4:
        r3 = r0;
    L8:
        this.mPhaseY = r3;
        return;
    L5:
        r0 = 0.0f;
        if (r3 >= 0.0f) goto L8;
        goto L8
    }

    public float getPhaseX() {
        return this.mPhaseX;
    }

    public void setPhaseX(float r3) {
        float r0 = 1.0f;
        if (r3 <= 1.0f) goto L5;
    L4:
        r3 = r0;
    L8:
        this.mPhaseX = r3;
        return;
    L5:
        r0 = 0.0f;
        if (r3 >= 0.0f) goto L8;
        goto L8
    }
}
