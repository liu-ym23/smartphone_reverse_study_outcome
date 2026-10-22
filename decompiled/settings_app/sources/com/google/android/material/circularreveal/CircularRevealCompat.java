package com.google.android.material.circularreveal;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewAnimationUtils;

/* JADX INFO: loaded from: classes3.dex */
public final class CircularRevealCompat {
    private CircularRevealCompat() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Animator createCircularReveal(CircularRevealWidget r6, float r7, float r8, float r9) {
        ObjectAnimator r0 = ObjectAnimator.ofObject(r6, CircularRevealWidget.CircularRevealProperty.CIRCULAR_REVEAL, CircularRevealWidget.CircularRevealEvaluator.CIRCULAR_REVEAL, new CircularRevealWidget.RevealInfo[]{new CircularRevealWidget.RevealInfo(r7, r8, r9)});
        CircularRevealWidget.RevealInfo r1 = r6.getRevealInfo();
        if (r1 == null) goto L7;
        Animator r10 = ViewAnimationUtils.createCircularReveal((View) r6, (int) r7, (int) r8, r1.radius, r9);
        AnimatorSet r11 = new AnimatorSet();
        r11.playTogether(new Animator[]{r0, r10});
        return r11;
    L7:
        throw new IllegalStateException("Caller must set a non-null RevealInfo before calling this.");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Animator createCircularReveal(CircularRevealWidget r7, float r8, float r9, float r10, float r11) {
        ObjectAnimator r0 = ObjectAnimator.ofObject(r7, CircularRevealWidget.CircularRevealProperty.CIRCULAR_REVEAL, CircularRevealWidget.CircularRevealEvaluator.CIRCULAR_REVEAL, new CircularRevealWidget.RevealInfo[]{new CircularRevealWidget.RevealInfo(r8, r9, r10), new CircularRevealWidget.RevealInfo(r8, r9, r11)});
        Animator r12 = ViewAnimationUtils.createCircularReveal((View) r7, (int) r8, (int) r9, r10, r11);
        AnimatorSet r13 = new AnimatorSet();
        r13.playTogether(new Animator[]{r0, r12});
        return r13;
    }

    public static Animator.AnimatorListener createCircularRevealListener(final CircularRevealWidget r1) {
        return new AnonymousClass1(r1);
    }
}
