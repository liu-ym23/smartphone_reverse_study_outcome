package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorSet;
import androidx.annotation.AnimatorRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.animation.MotionSpec;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
interface MotionStrategy {
    void addAnimationListener(@NonNull Animator.AnimatorListener r1);

    AnimatorSet createAnimator();

    MotionSpec getCurrentMotionSpec();

    @AnimatorRes
    int getDefaultMotionSpecResource();

    List<Animator.AnimatorListener> getListeners();

    @Nullable
    MotionSpec getMotionSpec();

    void onAnimationCancel();

    void onAnimationEnd();

    void onAnimationStart(Animator r1);

    void onChange(@Nullable ExtendedFloatingActionButton.OnChangedCallback r1);

    void performNow();

    void removeAnimationListener(@NonNull Animator.AnimatorListener r1);

    void setMotionSpec(@Nullable MotionSpec r1);

    boolean shouldCancel();
}
