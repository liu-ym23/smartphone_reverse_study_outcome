package com.google.android.material.circularreveal;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Build;
import android.view.View;
import android.view.ViewAnimationUtils;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes2.dex */
public final class CircularRevealCompat {
    private CircularRevealCompat() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NonNull
    public static Animator createCircularReveal(@NonNull CircularRevealWidget r6, float r7, float r8, float r9) {
        ObjectAnimator r0 = ObjectAnimator.ofObject(r6, CircularRevealWidget.CircularRevealProperty.CIRCULAR_REVEAL, CircularRevealWidget.CircularRevealEvaluator.CIRCULAR_REVEAL, new CircularRevealWidget.RevealInfo[]{new CircularRevealWidget.RevealInfo(r7, r8, r9)});
        if (Build.VERSION.SDK_INT < 21) goto L10;
        CircularRevealWidget.RevealInfo r1 = r6.getRevealInfo();
        if (r1 == null) goto L9;
        Animator r10 = ViewAnimationUtils.createCircularReveal((View) r6, (int) r7, (int) r8, r1.radius, r9);
        AnimatorSet r11 = new AnimatorSet();
        r11.playTogether(new Animator[]{r0, r10});
        return r11;
    L9:
        throw new IllegalStateException("Caller must set a non-null RevealInfo before calling this.");
    L10:
        return r0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NonNull
    public static Animator createCircularReveal(CircularRevealWidget r7, float r8, float r9, float r10, float r11) {
        ObjectAnimator r0 = ObjectAnimator.ofObject(r7, CircularRevealWidget.CircularRevealProperty.CIRCULAR_REVEAL, CircularRevealWidget.CircularRevealEvaluator.CIRCULAR_REVEAL, new CircularRevealWidget.RevealInfo[]{new CircularRevealWidget.RevealInfo(r8, r9, r10), new CircularRevealWidget.RevealInfo(r8, r9, r11)});
        if (Build.VERSION.SDK_INT < 21) goto L6;
        Animator r12 = ViewAnimationUtils.createCircularReveal((View) r7, (int) r8, (int) r9, r10, r11);
        AnimatorSet r13 = new AnimatorSet();
        r13.playTogether(new Animator[]{r0, r12});
        return r13;
    L6:
        return r0;
    }

    @NonNull
    public static Animator.AnimatorListener createCircularRevealListener(@NonNull final CircularRevealWidget r1) {
        return new AnonymousClass1(r1);
    }
}
