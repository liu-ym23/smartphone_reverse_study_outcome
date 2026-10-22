package com.google.android.material.transition.platform;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.transition.TransitionValues;
import android.transition.Visibility;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes2.dex */
@RequiresApi(21)
public final class Hold extends Visibility {
    public Hold() {
    }

    @Override // android.transition.Visibility
    @NonNull
    public Animator onAppear(@NonNull ViewGroup r1, @NonNull View r2, @Nullable TransitionValues r3, @Nullable TransitionValues r4) {
        return ValueAnimator.ofFloat(new float[]{0.0f});
    }

    @Override // android.transition.Visibility
    @NonNull
    public Animator onDisappear(@NonNull ViewGroup r1, @NonNull View r2, @Nullable TransitionValues r3, @Nullable TransitionValues r4) {
        return ValueAnimator.ofFloat(new float[]{0.0f});
    }
}
