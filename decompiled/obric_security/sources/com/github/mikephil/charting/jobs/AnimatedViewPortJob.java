package com.github.mikephil.charting.jobs;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.view.View;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.ViewPortHandler;

/* JADX INFO: loaded from: classes2.dex */
public abstract class AnimatedViewPortJob extends ViewPortJob implements ValueAnimator.AnimatorUpdateListener, Animator.AnimatorListener {
    protected ObjectAnimator animator;
    protected float phase;
    protected float xOrigin;
    protected float yOrigin;

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator r1) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator r1) {
    }

    public void onAnimationUpdate(ValueAnimator r1) {
    }

    public abstract void recycleSelf();

    public AnimatedViewPortJob(ViewPortHandler r1, float r2, float r3, Transformer r4, View r5, float r6, float r7, long r8) {
        super(r1, r2, r3, r4, r5);
        this.xOrigin = r6;
        this.yOrigin = r7;
        ObjectAnimator r9 = ObjectAnimator.ofFloat(this, "phase", new float[]{0.0f, 1.0f});
        this.animator = r9;
        r9.setDuration(r8);
        this.animator.addUpdateListener(this);
        this.animator.addListener(this);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.animator.start();
    }

    public float getPhase() {
        return this.phase;
    }

    public void setPhase(float r1) {
        this.phase = r1;
    }

    public float getXOrigin() {
        return this.xOrigin;
    }

    public float getYOrigin() {
        return this.yOrigin;
    }

    protected void resetAnimator() {
        this.animator.removeAllListeners();
        this.animator.removeAllUpdateListeners();
        this.animator.reverse();
        this.animator.addUpdateListener(this);
        this.animator.addListener(this);
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator r1) {
        recycleSelf();     // Catch: IllegalArgumentException -> L4
        return;
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator r1) {
        recycleSelf();     // Catch: IllegalArgumentException -> L4
        return;
    }
}
