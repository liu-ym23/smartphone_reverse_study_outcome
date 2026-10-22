package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
class AnimatorTracker {

    @Nullable
    private Animator currentAnimator;

    public AnimatorTracker() {
    }

    public void cancelCurrent() {
        Animator r0 = this.currentAnimator;
        if (r0 == null) goto L6;
        r0.cancel();
        return;
    }

    public void clear() {
        this.currentAnimator = null;
    }

    public void onNextAnimationStart(Animator r1) {
        cancelCurrent();
        this.currentAnimator = r1;
    }
}
