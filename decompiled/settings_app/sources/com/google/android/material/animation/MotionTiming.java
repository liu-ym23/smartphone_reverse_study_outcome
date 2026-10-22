package com.google.android.material.animation;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;

/* JADX INFO: loaded from: classes3.dex */
public class MotionTiming {
    private long delay;
    private long duration;
    private TimeInterpolator interpolator;
    private int repeatCount;
    private int repeatMode;

    public MotionTiming(long r2, long r4) {
        this.interpolator = null;
        this.repeatCount = 0;
        this.repeatMode = 1;
        this.delay = r2;
        this.duration = r4;
    }

    public MotionTiming(long r2, long r4, TimeInterpolator r6) {
        this.repeatCount = 0;
        this.repeatMode = 1;
        this.delay = r2;
        this.duration = r4;
        this.interpolator = r6;
    }

    public void apply(Animator r3) {
        r3.setStartDelay(getDelay());
        r3.setDuration(getDuration());
        r3.setInterpolator(getInterpolator());
        if ((r3 instanceof ValueAnimator) == false) goto L6;
        ValueAnimator r4 = (ValueAnimator) r3;
        r4.setRepeatCount(getRepeatCount());
        r4.setRepeatMode(getRepeatMode());
        return;
    }

    public long getDelay() {
        return this.delay;
    }

    public long getDuration() {
        return this.duration;
    }

    public TimeInterpolator getInterpolator() {
        TimeInterpolator r0 = this.interpolator;
        if (r0 == null) goto L6;
        return r0;
    L6:
        return AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR;
    }

    public int getRepeatCount() {
        return this.repeatCount;
    }

    public int getRepeatMode() {
        return this.repeatMode;
    }

    static MotionTiming createFromAnimator(ValueAnimator r7) {
        MotionTiming r6 = new MotionTiming(r7.getStartDelay(), r7.getDuration(), getInterpolatorCompat(r7));
        r6.repeatCount = r7.getRepeatCount();
        r6.repeatMode = r7.getRepeatMode();
        return r6;
    }

    private static TimeInterpolator getInterpolatorCompat(ValueAnimator r1) {
        TimeInterpolator r2 = r1.getInterpolator();
        if ((r2 instanceof AccelerateDecelerateInterpolator) == true) goto L15;
        if (r2 == null) goto L15;
        if ((r2 instanceof AccelerateInterpolator) == false) goto L11;
        return AnimationUtils.FAST_OUT_LINEAR_IN_INTERPOLATOR;
    L11:
        if ((r2 instanceof DecelerateInterpolator) == true) goto L13;
        return r2;
    L13:
        return AnimationUtils.LINEAR_OUT_SLOW_IN_INTERPOLATOR;
    L15:
        return AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR;
    }

    public boolean equals(Object r7) {
        if (this != r7) goto L6;
        return true;
    L6:
        if ((r7 instanceof MotionTiming) == true) goto L8;
        return false;
    L8:
        MotionTiming r8 = (MotionTiming) r7;
        if (getDelay() == r8.getDelay()) goto L12;
        return false;
    L12:
        if (getDuration() == r8.getDuration()) goto L15;
        return false;
    L15:
        if (getRepeatCount() == r8.getRepeatCount()) goto L18;
        return false;
    L18:
        if (getRepeatMode() == r8.getRepeatMode()) goto L21;
        return false;
    L21:
        return getInterpolator().getClass().equals(r8.getInterpolator().getClass());
    }

    public int hashCode() {
        return (((((((((int) (getDelay() ^ (getDelay() >>> 32))) * 31) + ((int) (getDuration() ^ (getDuration() >>> 32)))) * 31) + getInterpolator().getClass().hashCode()) * 31) + getRepeatCount()) * 31) + getRepeatMode();
    }

    public String toString() {
        return "\n" + getClass().getName() + '{' + Integer.toHexString(System.identityHashCode(this)) + " delay: " + getDelay() + " duration: " + getDuration() + " interpolator: " + getInterpolator().getClass() + " repeatCount: " + getRepeatCount() + " repeatMode: " + getRepeatMode() + "}\n";
    }
}
