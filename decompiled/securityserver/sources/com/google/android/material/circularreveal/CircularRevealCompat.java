package com.google.android.material.circularreveal;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewAnimationUtils;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes.dex */
public final class CircularRevealCompat {
    private CircularRevealCompat() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NonNull
    public static Animator createCircularReveal(@NonNull CircularRevealWidget r3, float r4, float r5, float r6) {
        ObjectAnimator r0 = ObjectAnimator.ofObject(r3, CircularRevealWidget.CircularRevealProperty.CIRCULAR_REVEAL, CircularRevealWidget.CircularRevealEvaluator.CIRCULAR_REVEAL, new CircularRevealWidget.RevealInfo[]{new CircularRevealWidget.RevealInfo(r4, r5, r6)});
        CircularRevealWidget.RevealInfo r1 = r3.getRevealInfo();
        if (r1 == null) goto L7;
        Animator r7 = ViewAnimationUtils.createCircularReveal((View) r3, (int) r4, (int) r5, r1.radius, r6);
        AnimatorSet r8 = new AnimatorSet();
        r8.playTogether(new Animator[]{r0, r7});
        return r8;
    L7:
        throw new IllegalStateException("Caller must set a non-null RevealInfo before calling this.");
    }

    @NonNull
    public static Animator.AnimatorListener createCircularRevealListener(@NonNull final CircularRevealWidget r1) {
        return new AnonymousClass1(r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NonNull
    public static Animator createCircularReveal(CircularRevealWidget r4, float r5, float r6, float r7, float r8) {
        ObjectAnimator r0 = ObjectAnimator.ofObject(r4, CircularRevealWidget.CircularRevealProperty.CIRCULAR_REVEAL, CircularRevealWidget.CircularRevealEvaluator.CIRCULAR_REVEAL, new CircularRevealWidget.RevealInfo[]{new CircularRevealWidget.RevealInfo(r5, r6, r7), new CircularRevealWidget.RevealInfo(r5, r6, r8)});
        Animator r9 = ViewAnimationUtils.createCircularReveal((View) r4, (int) r5, (int) r6, r7, r8);
        AnimatorSet r10 = new AnimatorSet();
        r10.playTogether(new Animator[]{r0, r9});
        return r10;
    }
}
