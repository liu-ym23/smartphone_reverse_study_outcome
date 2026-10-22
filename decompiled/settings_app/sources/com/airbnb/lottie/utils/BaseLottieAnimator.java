package com.airbnb.lottie.utils;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: loaded from: classes.dex */
public abstract class BaseLottieAnimator extends ValueAnimator {
    private final Set<Animator.AnimatorListener> listeners;
    private final Set<ValueAnimator.AnimatorUpdateListener> updateListeners;

    public BaseLottieAnimator() {
        this.updateListeners = new CopyOnWriteArraySet();
        this.listeners = new CopyOnWriteArraySet();
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public /* bridge */ /* synthetic */ Animator setDuration(long r1) {
        return setDuration(r1);
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public long getStartDelay() {
        throw new UnsupportedOperationException("LottieAnimator does not support getStartDelay.");
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public void setStartDelay(long r1) {
        throw new UnsupportedOperationException("LottieAnimator does not support setStartDelay.");
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public ValueAnimator setDuration(long r1) {
        throw new UnsupportedOperationException("LottieAnimator does not support setDuration.");
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public void setInterpolator(TimeInterpolator r1) {
        throw new UnsupportedOperationException("LottieAnimator does not support setInterpolator.");
    }

    @Override // android.animation.ValueAnimator
    public void addUpdateListener(ValueAnimator.AnimatorUpdateListener r1) {
        this.updateListeners.add(r1);
    }

    @Override // android.animation.ValueAnimator
    public void removeUpdateListener(ValueAnimator.AnimatorUpdateListener r1) {
        this.updateListeners.remove(r1);
    }

    @Override // android.animation.ValueAnimator
    public void removeAllUpdateListeners() {
        this.updateListeners.clear();
    }

    @Override // android.animation.Animator
    public void addListener(Animator.AnimatorListener r1) {
        this.listeners.add(r1);
    }

    @Override // android.animation.Animator
    public void removeListener(Animator.AnimatorListener r1) {
        this.listeners.remove(r1);
    }

    @Override // android.animation.Animator
    public void removeAllListeners() {
        this.listeners.clear();
    }

    void notifyStart(boolean r3) {
        Iterator<Animator.AnimatorListener> r0 = this.listeners.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().onAnimationStart(this, r3);
        goto L4
    }

    void notifyRepeat() {
        Iterator<Animator.AnimatorListener> r0 = this.listeners.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().onAnimationRepeat(this);
        goto L4
    }

    void notifyEnd(boolean r3) {
        Iterator<Animator.AnimatorListener> r0 = this.listeners.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().onAnimationEnd(this, r3);
        goto L4
    }

    void notifyCancel() {
        Iterator<Animator.AnimatorListener> r0 = this.listeners.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().onAnimationCancel(this);
        goto L4
    }

    void notifyUpdate() {
        Iterator<ValueAnimator.AnimatorUpdateListener> r0 = this.updateListeners.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().onAnimationUpdate(this);
        goto L4
    }
}
