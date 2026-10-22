package com.bytedanceos.security.widget;

import android.animation.Animator;

/* JADX INFO: loaded from: classes2.dex */
public class DefaultAnimatorListener implements Animator.AnimatorListener {
    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator arg0) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator arg0) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator arg0) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator arg0) {
    }

    public DefaultAnimatorListener() {
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animation, boolean isReverse) {
        onAnimationStart(animation);
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animation, boolean isReverse) {
        onAnimationEnd(animation);
    }
}
