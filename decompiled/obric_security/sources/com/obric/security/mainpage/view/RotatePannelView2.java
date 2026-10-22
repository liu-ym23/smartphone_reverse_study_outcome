package com.obric.security.mainpage.view;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.obric.olog.OLog;
import com.obric.oui.animation.RotatePannelManager;
import com.obric.oui.animation.ScrollingNumbersView;
import com.obric.security.R;

/* JADX INFO: loaded from: classes4.dex */
public class RotatePannelView2 extends RelativeLayout implements ScrollingNumbersView.ScrollNumberListener {
    private static final String TAG = "RotatePannelView2";
    AnimationDrawable convergenceAnimation;
    AnimationDrawable mAnimationDrawable0;
    ImageView mCleanDoneImgView;
    TextView mCleaningText;
    ImageView mDialGreenBg;
    ImageView mDialGreenFg;
    ViewGroup mDialLayer;
    ImageView mInnerBaseBg;
    ImageView mParticleImgView;
    ScrollingNumbersView mProgressNumberView;
    private AnimatorSet mScanningAnimatorSet;
    ViewGroup mScanningGroup;
    TextView mScanningText;
    ViewGroup mScoreGroup;
    ScrollingNumbersView mScoreNumberFullView;
    ScrollingNumbersView mScoreNumberView;
    TextView mScoreText;
    GlowDotRingProg progressBar;
    private RotatePannelManager.RotateListener rotateListener;

    @Override // com.obric.oui.animation.ScrollingNumbersView.ScrollNumberListener
    public void onFinish() {
    }

    public RotatePannelView2(Context context) {
        this(context, null);
    }

    public RotatePannelView2(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public RotatePannelView2(Context context, AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }

    public RotatePannelView2(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context, attrs, defStyleAttr, defStyleRes);
    }

    private void init(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        inflate(context, R.layout.security_center_main_dial2, this);
        this.mDialLayer = (ViewGroup) findViewById(R.id.dial_layer);
        this.mParticleImgView = (ImageView) findViewById(R.id.dial_particle_bg);
        this.mDialGreenBg = (ImageView) findViewById(R.id.dial_green_bg);
        this.mDialGreenFg = (ImageView) findViewById(R.id.dial_green_fg);
        this.mScanningGroup = (ViewGroup) findViewById(R.id.scanning_group);
        this.mScoreGroup = (ViewGroup) findViewById(R.id.score_group);
        this.mProgressNumberView = (ScrollingNumbersView) findViewById(R.id.inner_scanning_progress);
        this.mScanningText = (TextView) findViewById(R.id.scanning_text);
        this.mScoreNumberView = (ScrollingNumbersView) findViewById(R.id.inner_score_number);
        ScrollingNumbersView r1 = (ScrollingNumbersView) findViewById(R.id.inner_score_number_full);
        this.mScoreNumberFullView = r1;
        r1.setInitialValue(100);
        this.mScoreText = (TextView) findViewById(R.id.score_text);
        this.mCleaningText = (TextView) findViewById(R.id.cleaning_text);
        this.mCleanDoneImgView = (ImageView) findViewById(R.id.dial_clean_done);
        this.progressBar = (GlowDotRingProg) findViewById(R.id.progress_bar);
        this.mInnerBaseBg = (ImageView) findViewById(R.id.inner_base_bg);
    }

    public static boolean isMainThread() {
        if (Looper.getMainLooper() != Looper.myLooper()) goto L5;
        return true;
    L5:
        return false;
    }

    public void prepare() {
        this.mDialGreenBg.setAlpha(1.0f);
        this.mDialGreenFg.setAlpha(1.0f);
    }

    public void setRotatingDialColor(int color) {
        this.mDialGreenBg.setColorFilter(color);
        this.mDialGreenFg.setColorFilter(color);
    }

    public void scan() {
        if (this.mDialGreenBg.getDrawable() != null) goto L6;
        this.mDialGreenBg.setImageResource(R.drawable.oic_transparent_dial_green_bg);
    L6:
        if (this.mDialGreenFg.getDrawable() != null) goto L8;
        this.mDialGreenFg.setImageResource(R.drawable.oic_transparent_dial_green_fg);
    L8:
        this.mDialGreenBg.setAlpha(1.0f);
        this.mDialGreenFg.setAlpha(1.0f);
        ObjectAnimator r0 = ObjectAnimator.ofFloat(this.mDialGreenBg, View.ROTATION, new float[]{-90.0f, 270.0f});
        r0.setDuration(2000);
        r0.setInterpolator(new LinearInterpolator());
        r0.setRepeatCount(-1);
        r0.setRepeatMode(1);
        ObjectAnimator r6 = ObjectAnimator.ofFloat(this.mDialGreenFg, View.ROTATION, new float[]{-90.0f, 270.0f});
        r6.setDuration(2000);
        r6.setInterpolator(new LinearInterpolator());
        r6.setRepeatCount(-1);
        r6.setRepeatMode(1);
        AnimatorSet r1 = new AnimatorSet();
        this.mScanningAnimatorSet = r1;
        r1.playTogether(new Animator[]{r0, r6});
        this.mScanningAnimatorSet.start();
        this.mAnimationDrawable0 = getLoadAnimationDrawable();
        this.mParticleImgView.setVisibility(0);
        OLog.d(TAG, "new setImageDrawable 1: " + this.mAnimationDrawable0);
        this.mParticleImgView.setImageDrawable(this.mAnimationDrawable0);
        AnimationDrawable r2 = this.mAnimationDrawable0;
        if (r2 == null) goto L12;
        r2.setOneShot(false);
        this.mAnimationDrawable0.start();
        return;
    }

    public void onScanEnd() {
        OLog.d(TAG, "onScanEnd ");
        AnimatorSet r0 = this.mScanningAnimatorSet;
        if (r0 == null) goto L6;
        r0.cancel();
    L6:
        if (this.mAnimationDrawable0 == null) goto L8;
        OLog.d(TAG, "setImageDrawable 2: " + isMainThread());
        this.mParticleImgView.setImageDrawable(null);
        this.mParticleImgView.setVisibility(8);
        this.mAnimationDrawable0.stop();
        releaseAnimationDrawable(this.mAnimationDrawable0);
        this.mAnimationDrawable0 = null;
    L8:
        this.mDialGreenBg.setAlpha(0);
        this.mDialGreenFg.setAlpha(0);
        this.mDialGreenBg.setImageDrawable(null);
        this.mDialGreenFg.setImageDrawable(null);
    }

    private void releaseAnimationDrawable(AnimationDrawable drawable) {
        if (drawable == null) goto L10;
        drawable.stop();
        int r2 = 0;
    L5:
        if (r2 >= drawable.getNumberOfFrames()) goto L7;
        drawable.getFrame(r2).setCallback(null);
        r2 = r2 + 1;
        goto L5
    L7:
        drawable.setCallback(null);
        return;
    }

    public void onCleanEnd() {
        if (this.convergenceAnimation == null) goto L6;
        OLog.d(TAG, "setImageDrawable 4: " + isMainThread());
        this.mParticleImgView.setVisibility(8);
        this.convergenceAnimation.stop();
        this.mParticleImgView.setImageDrawable(null);
        releaseAnimationDrawable(this.convergenceAnimation);
        this.convergenceAnimation = null;
        return;
    }

    public void clean() {
        this.mParticleImgView.setVisibility(0);
        OLog.d(TAG, "setImageDrawable 3: " + isMainThread());
        this.mParticleImgView.setImageDrawable(getConvergenceAnimationDrawable());
    }

    @Override // com.obric.oui.animation.ScrollingNumbersView.ScrollNumberListener
    public void onPause() {
        AnimatorSet r0 = this.mScanningAnimatorSet;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isRunning() == false) goto L9;
        this.mScanningAnimatorSet.pause();
        return;
    }

    @Override // com.obric.oui.animation.ScrollingNumbersView.ScrollNumberListener
    public void onResume() {
        AnimatorSet r0 = this.mScanningAnimatorSet;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isPaused() == false) goto L9;
        this.mScanningAnimatorSet.resume();
        return;
    }

    public void onDestory() {
        OLog.d(TAG, "onDestory: ");
        AnimatorSet r0 = this.mScanningAnimatorSet;
        if (r0 == null) goto L5;
        r0.cancel();
    L5:
        this.mParticleImgView.setImageDrawable(null);
        this.mParticleImgView.setVisibility(8);
        AnimationDrawable r1 = this.mAnimationDrawable0;
        if (r1 == null) goto L8;
        releaseAnimationDrawable(r1);
        this.mAnimationDrawable0 = null;
    L8:
        AnimationDrawable r2 = this.convergenceAnimation;
        if (r2 == null) goto L11;
        releaseAnimationDrawable(r2);
        this.convergenceAnimation = null;
    L11:
        System.gc();
        this.mProgressNumberView.destory();
    }

    AnimationDrawable getLoadAnimationDrawable() {
        return (AnimationDrawable) getResources().getDrawable(R.drawable.particle_animation_load);
    }

    AnimationDrawable getConvergenceAnimationDrawable() {
        AnimationDrawable r0 = this.convergenceAnimation;
        if (r0 == null) goto L5;
        return r0;
    L5:
        AnimationDrawable r1 = (AnimationDrawable) getResources().getDrawable(R.drawable.particle_animation_convergence);
        this.convergenceAnimation = r1;
        return r1;
    }

    public ScrollingNumbersView getProgressNumberView() {
        return this.mProgressNumberView;
    }

    public TextView getScanningText() {
        return this.mScanningText;
    }

    public ScrollingNumbersView getScoreNumberView() {
        return this.mScoreNumberView;
    }

    public ScrollingNumbersView getScoreNumberFullView() {
        return this.mScoreNumberFullView;
    }

    public TextView getScoreText() {
        return this.mScoreText;
    }

    public ImageView getCleanDoneImgView() {
        return this.mCleanDoneImgView;
    }

    public GlowDotRingProg getProgressBar() {
        return this.progressBar;
    }

    public ViewGroup getScanningGroup() {
        return this.mScanningGroup;
    }

    public ViewGroup getScoreGroup() {
        return this.mScoreGroup;
    }

    public ImageView getInnerBaseBg() {
        return this.mInnerBaseBg;
    }
}
