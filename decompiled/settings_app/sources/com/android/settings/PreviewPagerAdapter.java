package com.android.settings;

import android.animation.Animator;
import android.content.Context;
import android.content.res.Configuration;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.viewpager.widget.PagerAdapter;

/* JADX INFO: loaded from: classes2.dex */
public class PreviewPagerAdapter extends PagerAdapter {
    private static final long CROSS_FADE_DURATION_MS = 400;
    private static final Interpolator FADE_IN_INTERPOLATOR = null;
    private static final Interpolator FADE_OUT_INTERPOLATOR = null;
    private int mAnimationCounter;
    private Runnable mAnimationEndAction;
    private boolean mIsLayoutRtl;
    private FrameLayout[] mPreviewFrames;

    private class PreviewFrameAnimatorListener implements Animator.AnimatorListener {
        final /* synthetic */ PreviewPagerAdapter this$0;

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator r1) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator r1) {
        }

        private PreviewFrameAnimatorListener(PreviewPagerAdapter r1) {
            this.this$0 = r1;
        }

        /* synthetic */ PreviewFrameAnimatorListener(PreviewPagerAdapter r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator r1) {
            PreviewPagerAdapter.access$108(this.this$0);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator r1) {
            PreviewPagerAdapter.access$110(this.this$0);
            PreviewPagerAdapter.access$200(this.this$0);
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View r1, Object r2) {
        if (r1 != r2) goto L4;
        return true;
    L4:
        return false;
    }

    static /* synthetic */ int access$108(PreviewPagerAdapter r2) {
        int r0 = r2.mAnimationCounter;
        r2.mAnimationCounter = r0 + 1;
        return r0;
    }

    static /* synthetic */ int access$110(PreviewPagerAdapter r2) {
        int r0 = r2.mAnimationCounter;
        r2.mAnimationCounter = r0 - 1;
        return r0;
    }

    static /* synthetic */ void access$200(PreviewPagerAdapter r0) {
        r0.runAnimationEndAction();
    }

    static {
        FADE_IN_INTERPOLATOR = new DecelerateInterpolator();
        FADE_OUT_INTERPOLATOR = new AccelerateInterpolator();
    }

    public PreviewPagerAdapter(Context r8, boolean r9, int[] r10, Configuration[] r11) {
        this.mIsLayoutRtl = r9;
        this.mPreviewFrames = new FrameLayout[r10.length];
        int r0 = 0;
    L4:
        if (r0 >= r10.length) goto L13;
        if (this.mIsLayoutRtl == false) goto L8;
        int r1 = (r10.length - 1) - r0;
    L9:
        this.mPreviewFrames[r1] = new FrameLayout(r8);
        this.mPreviewFrames[r1].setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        int r2 = r11.length;
        int r3 = 0;
    L10:
        if (r3 >= r2) goto L12;
        Context r4 = r8.createConfigurationContext(r11[r3]);
        r4.setTheme(r8.getThemeResId());
        View r5 = LayoutInflater.from(r4).inflate(r10[r0], this.mPreviewFrames[r1], false);
        r5.setAlpha(0.0f);
        r5.setVisibility(4);
        this.mPreviewFrames[r1].addView(r5);
        r3 = r3 + 1;
        goto L10
    L12:
        r0 = r0 + 1;
        goto L4
    L8:
        r1 = r0;
        goto L9
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup r1, int r2, Object r3) {
        r1.removeView((View) r3);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return this.mPreviewFrames.length;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup r2, int r3) {
        r2.addView(this.mPreviewFrames[r3]);
        return this.mPreviewFrames[r3];
    }

    boolean isAnimating() {
        if (this.mAnimationCounter <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    void setAnimationEndAction(Runnable r1) {
        this.mAnimationEndAction = r1;
    }

    void setPreviewLayer(int r12, int r13, int r14, boolean r15) {
        FrameLayout[] r0 = this.mPreviewFrames;
        int r1 = r0.length;
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L19;
        FrameLayout r4 = r0[r3];
        AnonymousClass1 r5 = null;
        if (r13 < 0) goto L12;
        final View r8 = r4.getChildAt(r13);
        if (r15 == true) goto L9;
    L11:
        r8.setAlpha(0.0f);
        r8.setVisibility(4);
        goto L12
    L9:
        if (r4 != this.mPreviewFrames[r14]) goto L11;
        r8.animate().alpha(0.0f).setInterpolator(FADE_OUT_INTERPOLATOR).setDuration(CROSS_FADE_DURATION_MS).setListener(new PreviewFrameAnimatorListener(this, r5)).withEndAction(new AnonymousClass1(this, r8));
    L12:
        final View r9 = r4.getChildAt(r12);
        if (r15 == true) goto L15;
    L17:
        r9.setVisibility(0);
        r9.setAlpha(1.0f);
    L18:
        r3 = r3 + 1;
        goto L3
    L15:
        if (r4 != this.mPreviewFrames[r14]) goto L17;
        r9.animate().alpha(1.0f).setInterpolator(FADE_IN_INTERPOLATOR).setDuration(CROSS_FADE_DURATION_MS).setListener(new PreviewFrameAnimatorListener(this, r5)).withStartAction(new AnonymousClass2(this, r9));
        goto L18
    }

    private void runAnimationEndAction() {
        if (this.mAnimationEndAction != null) goto L5;
        return;
    L5:
        if (isAnimating() == true) goto L9;
        this.mAnimationEndAction.run();
        this.mAnimationEndAction = null;
        return;
    }
}
