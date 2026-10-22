package com.google.android.material.progressindicator;

import android.animation.Animator;
import androidx.annotation.NonNull;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;

/* JADX INFO: loaded from: classes2.dex */
abstract class IndeterminateAnimatorDelegate<T extends Animator> {
    protected IndeterminateDrawable drawable;
    protected final int[] segmentColors;
    protected final float[] segmentPositions;

    protected IndeterminateAnimatorDelegate(int r2) {
        this.segmentPositions = new float[r2 * 2];
        this.segmentColors = new int[r2];
    }

    abstract void cancelAnimatorImmediately();

    protected float getFractionInRange(int r1, int r2, int r3) {
        return (r1 - r2) / r3;
    }

    public abstract void invalidateSpecValues();

    public abstract void registerAnimatorsCompleteCallback(@NonNull Animatable2Compat.AnimationCallback r1);

    protected void registerDrawable(@NonNull IndeterminateDrawable r1) {
        this.drawable = r1;
    }

    abstract void requestCancelAnimatorAfterCurrentCycle();

    abstract void startAnimator();

    public abstract void unregisterAnimatorsCompleteCallback();
}
