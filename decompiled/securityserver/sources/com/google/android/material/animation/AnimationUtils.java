package com.google.android.material.animation;

import a.a;
import android.animation.TimeInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import androidx.annotation.RestrictTo;
import androidx.interpolator.view.animation.FastOutLinearInInterpolator;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import androidx.interpolator.view.animation.LinearOutSlowInInterpolator;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class AnimationUtils {
    public static final TimeInterpolator DECELERATE_INTERPOLATOR = null;
    public static final TimeInterpolator FAST_OUT_LINEAR_IN_INTERPOLATOR = null;
    public static final TimeInterpolator FAST_OUT_SLOW_IN_INTERPOLATOR = null;
    public static final TimeInterpolator LINEAR_INTERPOLATOR = null;
    public static final TimeInterpolator LINEAR_OUT_SLOW_IN_INTERPOLATOR = null;

    static {
        LINEAR_INTERPOLATOR = new LinearInterpolator();
        FAST_OUT_SLOW_IN_INTERPOLATOR = new FastOutSlowInInterpolator();
        FAST_OUT_LINEAR_IN_INTERPOLATOR = new FastOutLinearInInterpolator();
        LINEAR_OUT_SLOW_IN_INTERPOLATOR = new LinearOutSlowInInterpolator();
        DECELERATE_INTERPOLATOR = new DecelerateInterpolator();
    }

    public AnimationUtils() {
    }

    public static float lerp(float r0, float r1, float r2) {
        return a.a(r1, r0, r2, r0);
    }

    public static int lerp(int r0, int r1, float r2) {
        return Math.round(r2 * (r1 - r0)) + r0;
    }
}
