package com.android.settings.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

/* JADX INFO: loaded from: classes.dex */
public class TransferAnimationTextLayout extends LinearLayout {
    private static final long ANIMATION_DURATION = 150;
    private static final int FIXED_CHILD_COUNT = 2;
    private AnimatorSet mAnimatorSet;
    private View mFirstView;
    private View mSecondView;

    public TransferAnimationTextLayout(Context r2) {
        this(r2, null);
    }

    public TransferAnimationTextLayout(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    public TransferAnimationTextLayout(Context r2, AttributeSet r3, int r4) {
        this(r2, r3, r4, 0);
    }

    public TransferAnimationTextLayout(Context r1, AttributeSet r2, int r3, int r4) {
        super(r1, r2, r3, r4);
        this.mAnimatorSet = new AnimatorSet();
        setOrientation(0);
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        if (getChildCount() != 2) goto L7;
        this.mFirstView = getChildAt(0);
        this.mSecondView = getChildAt(1);
        return;
    L7:
        throw new IllegalArgumentException("wrong child count");
    }

    public void startTransferAnimation(AnimatorListenerAdapter r9) {
        ObjectAnimator r0 = ObjectAnimator.ofFloat(this.mFirstView, "translationX", new float[]{(getWidth() / 2.0f) - (this.mFirstView.getWidth() / 2.0f), 0.0f});
        ObjectAnimator r1 = ObjectAnimator.ofFloat(this.mSecondView, "alpha", new float[]{0.0f, 1.0f});
        AnimatorSet r3 = new AnimatorSet();
        this.mAnimatorSet = r3;
        r3.setDuration(150);
        this.mAnimatorSet.playTogether(new Animator[]{r0, r1});
        this.mAnimatorSet.addListener(r9);
        this.mAnimatorSet.start();
    }

    public void cancelAnimation() {
        if (this.mAnimatorSet.isRunning() == false) goto L6;
        this.mAnimatorSet.cancel();
        return;
    }
}
