package com.google.android.material.transition;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public final class FadeThroughProvider implements VisibilityAnimatorProvider {
    static final float FADE_THROUGH_THRESHOLD = 0.35f;
    private float progressThreshold;

    public FadeThroughProvider() {
        this.progressThreshold = FADE_THROUGH_THRESHOLD;
    }

    private static Animator createFadeThroughAnimator(final View r8, final float r9, final float r10, @FloatRange(from = 0.0d, to = 1.0d) final float r11, @FloatRange(from = 0.0d, to = 1.0d) final float r12, final float r13) {
        ValueAnimator r0 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r0.addUpdateListener(new AnonymousClass1(r8, r9, r10, r11, r12));
        r0.addListener(new AnonymousClass2(r8, r13));
        return r0;
    }

    @Override // com.google.android.material.transition.VisibilityAnimatorProvider
    @Nullable
    public Animator createAppear(@NonNull ViewGroup r7, @NonNull View r8) {
        if (r8.getAlpha() != 0.0f) goto L5;
        float r9 = 1.0f;
    L6:
        float r5 = r9;
        return createFadeThroughAnimator(r8, 0.0f, r5, this.progressThreshold, 1.0f, r5);
    L5:
        r9 = r8.getAlpha();
        goto L6
    }

    @Override // com.google.android.material.transition.VisibilityAnimatorProvider
    @Nullable
    public Animator createDisappear(@NonNull ViewGroup r7, @NonNull View r8) {
        if (r8.getAlpha() != 0.0f) goto L5;
        float r9 = 1.0f;
    L6:
        float r5 = r9;
        return createFadeThroughAnimator(r8, r5, 0.0f, 0.0f, this.progressThreshold, r5);
    L5:
        r9 = r8.getAlpha();
        goto L6
    }

    public float getProgressThreshold() {
        return this.progressThreshold;
    }

    public void setProgressThreshold(@FloatRange(from = 0.0d, to = 1.0d) float r1) {
        this.progressThreshold = r1;
    }
}
