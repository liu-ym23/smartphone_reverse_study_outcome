package com.google.android.material.transition.platform;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(21)
public final class FadeProvider implements VisibilityAnimatorProvider {
    private float incomingEndThreshold;

    public FadeProvider() {
        this.incomingEndThreshold = 1.0f;
    }

    private static Animator createFadeAnimator(final View r8, final float r9, final float r10, @FloatRange(from = 0.0d, to = 1.0d) final float r11, @FloatRange(from = 0.0d, to = 1.0d) final float r12) {
        ValueAnimator r0 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r0.addUpdateListener(new AnonymousClass1(r8, r9, r10, r11, r12));
        return r0;
    }

    @Override // com.google.android.material.transition.platform.VisibilityAnimatorProvider
    @Nullable
    public Animator createAppear(@NonNull ViewGroup r2, @NonNull View r3) {
        return createFadeAnimator(r3, 0.0f, 1.0f, 0.0f, this.incomingEndThreshold);
    }

    @Override // com.google.android.material.transition.platform.VisibilityAnimatorProvider
    @Nullable
    public Animator createDisappear(@NonNull ViewGroup r1, @NonNull View r2) {
        return createFadeAnimator(r2, 1.0f, 0.0f, 0.0f, 1.0f);
    }

    public float getIncomingEndThreshold() {
        return this.incomingEndThreshold;
    }

    public void setIncomingEndThreshold(float r1) {
        this.incomingEndThreshold = r1;
    }
}
