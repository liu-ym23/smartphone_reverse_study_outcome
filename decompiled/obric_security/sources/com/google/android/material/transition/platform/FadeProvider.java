package com.google.android.material.transition.platform;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes2.dex */
public final class FadeProvider implements VisibilityAnimatorProvider {
    private float incomingEndThreshold;

    public FadeProvider() {
        this.incomingEndThreshold = 1.0f;
    }

    public float getIncomingEndThreshold() {
        return this.incomingEndThreshold;
    }

    public void setIncomingEndThreshold(float r1) {
        this.incomingEndThreshold = r1;
    }

    @Override // com.google.android.material.transition.platform.VisibilityAnimatorProvider
    public Animator createAppear(ViewGroup r7, View r8) {
        if (r8.getAlpha() != 0.0f) goto L5;
        float r9 = 1.0f;
    L6:
        float r5 = r9;
        return createFadeAnimator(r8, 0.0f, r5, 0.0f, this.incomingEndThreshold, r5);
    L5:
        r9 = r8.getAlpha();
        goto L6
    }

    @Override // com.google.android.material.transition.platform.VisibilityAnimatorProvider
    public Animator createDisappear(ViewGroup r7, View r8) {
        if (r8.getAlpha() != 0.0f) goto L5;
        float r6 = 1.0f;
    L6:
        float r5 = r6;
        return createFadeAnimator(r8, r5, 0.0f, 0.0f, 1.0f, r5);
    L5:
        r6 = r8.getAlpha();
        goto L6
    }

    private static Animator createFadeAnimator(final View r8, final float r9, final float r10, final float r11, final float r12, final float r13) {
        ValueAnimator r0 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r0.addUpdateListener(new AnonymousClass1(r8, r9, r10, r11, r12));
        r0.addListener(new AnonymousClass2(r8, r13));
        return r0;
    }
}
