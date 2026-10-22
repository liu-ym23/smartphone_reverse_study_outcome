package com.android.settings.widget;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.android.settings.R;
import com.bytedance.framwork.core.sdkmonitor.MonitorConstants;
import com.obric.oui.texteffects.preset.DimPointEffectTokens;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class BigbangGifAnimView extends RelativeLayout {
    private static final DecelerateInterpolator mInterpolator = null;
    private int HAND_END_X;
    private int HAND_END_Y;
    private int HAND_START_X;
    private int HAND_START_Y;
    private AnimatorSet mAnimSet;
    private ImageView mBigbangCenterView;
    private ImageView mCircleView;
    private ImageView mHandView;
    private ImageView mTextBgView;

    static {
        mInterpolator = new DecelerateInterpolator(1.5f);
    }

    public BigbangGifAnimView(Context r2) {
        this(r2, null);
    }

    public BigbangGifAnimView(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    public BigbangGifAnimView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        LayoutInflater.from(r1).inflate(R.layout.bigbang_gif_anim_layout, this, true);
        this.mTextBgView = (ImageView) findViewById(R.id.text_bg);
        this.mBigbangCenterView = (ImageView) findViewById(R.id.bigbang_result);
        this.mCircleView = (ImageView) findViewById(R.id.circle);
        this.mHandView = (ImageView) findViewById(R.id.hand);
        init();
    }

    private void init() {
        this.HAND_START_X = getResources().getDimensionPixelSize(R.dimen.bigbang_anim_hand_start_x);
        this.HAND_START_Y = getResources().getDimensionPixelSize(R.dimen.bigbang_anim_hand_start_y);
        this.HAND_END_X = getResources().getDimensionPixelSize(R.dimen.bigbang_anim_hand_end_x);
        this.HAND_END_Y = getResources().getDimensionPixelSize(R.dimen.bigbang_anim_hand_end_y);
        this.mTextBgView.setAlpha(1.0f);
        this.mBigbangCenterView.setAlpha(0.0f);
        this.mBigbangCenterView.setScaleX(0.3f);
        this.mBigbangCenterView.setScaleY(0.3f);
        this.mCircleView.setAlpha(0.0f);
        this.mCircleView.setScaleX(5.0f);
        this.mCircleView.setScaleY(5.0f);
        this.mHandView.setX(this.HAND_START_X);
        this.mHandView.setY(this.HAND_START_Y);
        this.mHandView.setAlpha(0.0f);
    }

    public void cancelAnim() {
        AnimatorSet r0 = this.mAnimSet;
        if (r0 == null) goto L6;
        r0.removeAllListeners();
        this.mAnimSet.end();
        this.mAnimSet.cancel();
        this.mAnimSet = null;
        return;
    }

    public void startAnim() {
        cancelAnim();
        init();
        ArrayList r0 = new ArrayList();
        r0.add(createHandInAnim());
        r0.add(createCircleFlashAnim());
        r0.add(createHandOutAnim());
        r0.add(createBigbangTriggerAnim());
        AnimatorSet r1 = new AnimatorSet();
        this.mAnimSet = r1;
        r1.playTogether(r0);
        this.mAnimSet.setStartDelay(DimPointEffectTokens.PendingCycleMs);
        this.mAnimSet.addListener(new AnonymousClass1(this));
        this.mAnimSet.start();
    }

    private Animator createHandInAnim() {
        ArrayList r0 = new ArrayList();
        ObjectAnimator r1 = ObjectAnimator.ofFloat(this.mHandView, "X", new float[]{this.HAND_START_X, this.HAND_END_X});
        r1.setDuration(500);
        DecelerateInterpolator r7 = mInterpolator;
        r1.setInterpolator(r7);
        r0.add(r1);
        ObjectAnimator r2 = ObjectAnimator.ofFloat(this.mHandView, "Y", new float[]{this.HAND_START_Y, this.HAND_END_Y});
        r2.setDuration(500);
        r2.setInterpolator(r7);
        r0.add(r2);
        r0.add(createAlphaAnim(this.mHandView, 0.0f, 1.0f, 300));
        r0.add(createAlphaAnim(this.mTextBgView, 1.0f, 0.2f, 400, 500));
        AnimatorSet r14 = new AnimatorSet();
        r14.playTogether(r0);
        return r14;
    }

    private Animator createHandOutAnim() {
        ArrayList r0 = new ArrayList();
        ObjectAnimator r1 = ObjectAnimator.ofFloat(this.mHandView, "X", new float[]{this.HAND_END_X, this.HAND_START_X});
        r1.setDuration(500);
        DecelerateInterpolator r7 = mInterpolator;
        r1.setInterpolator(r7);
        r0.add(r1);
        ObjectAnimator r2 = ObjectAnimator.ofFloat(this.mHandView, "Y", new float[]{this.HAND_END_Y, this.HAND_START_Y});
        r2.setDuration(500);
        r2.setInterpolator(r7);
        r0.add(r2);
        r0.add(createAlphaAnim(this.mHandView, 1.0f, 0.0f, 300));
        AnimatorSet r14 = new AnimatorSet();
        r14.playTogether(r0);
        r14.setStartDelay(2900);
        return r14;
    }

    private Animator createCircleFlashAnim() {
        ArrayList r0 = new ArrayList();
        r0.add(createAlphaAnim(this.mCircleView, 0.0f, 1.0f, 300, 0));
        r0.add(createScaleAnim(this.mCircleView, 5.0f, 1.0f, 300, 0));
        r0.add(createAlphaAnim(this.mCircleView, 1.0f, 0.3f, 300, 300));
        r0.add(createAlphaAnim(this.mCircleView, 0.3f, 1.0f, 300, 600));
        r0.add(createAlphaAnim(this.mCircleView, 1.0f, 0.3f, 300, 900));
        r0.add(createAlphaAnim(this.mCircleView, 0.3f, 1.0f, 300, 1200));
        r0.add(createAlphaAnim(this.mCircleView, 1.0f, 0.3f, 300, DimPointEffectTokens.PendingCycleMs));
        r0.add(createAlphaAnim(this.mCircleView, 0.3f, 1.0f, 300, MonitorConstants.STOP_MORE_CHANNEL_INTERVAL));
        r0.add(createScaleAnim(this.mCircleView, 1.0f, 5.0f, 300, 2100));
        r0.add(createAlphaAnim(this.mCircleView, 1.0f, 0.0f, 300, 2100));
        AnimatorSet r10 = new AnimatorSet();
        r10.playTogether(r0);
        r10.setStartDelay(500);
        return r10;
    }

    private Animator createBigbangTriggerAnim() {
        ArrayList r0 = new ArrayList();
        r0.add(createAlphaAnim(this.mBigbangCenterView, 0.0f, 1.0f, 300, 100));
        r0.add(createScaleAnim(this.mBigbangCenterView, 0.3f, 1.0f, 300, 100));
        r0.add(createAlphaAnim(this.mTextBgView, 0.4f, 1.0f, 200, 1300));
        r0.add(createAlphaAnim(this.mBigbangCenterView, 1.0f, 0.0f, 500, DimPointEffectTokens.PendingCycleMs));
        AnimatorSet r10 = new AnimatorSet();
        r10.playTogether(r0);
        r10.setStartDelay(2700);
        return r10;
    }

    private Animator createScaleAnim(View r6, float r7, float r8, long r9, long r11) {
        ArrayList r5 = new ArrayList();
        ObjectAnimator r1 = ObjectAnimator.ofFloat(r6, "scaleX", new float[]{r7, r8});
        r1.setDuration(r9);
        DecelerateInterpolator r4 = mInterpolator;
        r1.setInterpolator(r4);
        r5.add(r1);
        ObjectAnimator r10 = ObjectAnimator.ofFloat(r6, "scaleY", new float[]{r7, r8});
        r10.setDuration(r9);
        r10.setInterpolator(r4);
        r5.add(r10);
        AnimatorSet r12 = new AnimatorSet();
        r12.playTogether(r5);
        r12.setStartDelay(r11);
        return r12;
    }

    private Animator createAlphaAnim(View r9, float r10, float r11, long r12) {
        return createAlphaAnim(r9, r10, r11, r12, 0);
    }

    private Animator createAlphaAnim(View r2, float r3, float r4, long r5, long r7) {
        ObjectAnimator r1 = ObjectAnimator.ofFloat(r2, "alpha", new float[]{r3, r4});
        r1.setDuration(r5);
        r1.setStartDelay(r7);
        r1.setInterpolator(mInterpolator);
        return r1;
    }
}
