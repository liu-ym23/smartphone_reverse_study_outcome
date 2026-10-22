package com.google.android.material.transition;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
public final class FadeThroughProvider implements VisibilityAnimatorProvider {
    static final float PROGRESS_THRESHOLD = 0.35f;

    public FadeThroughProvider() {
    }

    private static Animator createFadeThroughAnimator(final View r8, final float r9, final float r10, @FloatRange(from = 0.0d, to = 1.0d) final float r11, @FloatRange(from = 0.0d, to = 1.0d) final float r12) {
        ValueAnimator r0 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r0.addUpdateListener(new AnonymousClass1(r8, r9, r10, r11, r12));
        return r0;
    }

    @Override // com.google.android.material.transition.VisibilityAnimatorProvider
    @Nullable
    public Animator createAppear(@NonNull ViewGroup r2, @NonNull View r3) {
        return createFadeThroughAnimator(r3, 0.0f, 1.0f, PROGRESS_THRESHOLD, 1.0f);
    }

    @Override // com.google.android.material.transition.VisibilityAnimatorProvider
    @Nullable
    public Animator createDisappear(@NonNull ViewGroup r2, @NonNull View r3) {
        return createFadeThroughAnimator(r3, 1.0f, 0.0f, 0.0f, PROGRESS_THRESHOLD);
    }
}
