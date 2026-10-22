package com.obric.oui.animation;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.obric.olog.OLog;
import com.obric.oui.calendar.format.DayFormatter;
import com.obric.security.R;

/* JADX INFO: loaded from: classes3.dex */
public class RotatePannelView extends RelativeLayout implements ScrollingNumbersView.ScrollNumberListener {
    private static final String TAG = "RotatePannelView";
    AnimationDrawable mAnimationDrawable0;
    AnimationDrawable mAnimationDrawable1;
    AnimationDrawable mAnimationDrawable2;
    ImageView mCleanDoneImgView;
    TextView mCleaningText;
    ImageView mDialGreenBg;
    ImageView mDialGreenFg;
    ViewGroup mDialLayer;
    ImageView mInnerBaseBg;
    ImageView mParticleImgView;
    PieProgressView mPieProgress;
    PieProgressFullView mPieProgressFull;
    ScrollingNumbersView mProgressNumberView;
    private AnimatorSet mScanningAnimatorSet;
    ViewGroup mScanningGroup;
    TextView mScanningText;
    ViewGroup mScoreGroup;
    ScrollingNumbersView mScoreNumberFullView;
    ScrollingNumbersView mScoreNumberView;
    TextView mScoreText;
    private RotatePannelManager.RotateListener rotateListener;

    static /* synthetic */ void access$000(RotatePannelView r0, AnimationDrawable r1) {
        r0.releaseAnimationDrawable(r1);
    }

    public RotatePannelView(Context context) {
        this(context, null);
    }

    public RotatePannelView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public RotatePannelView(Context context, AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }

    public RotatePannelView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context, attrs, defStyleAttr, defStyleRes);
    }

    /* JADX WARN: Type inference failed for: r1v19, types: [com.obric.oui.animation.RotatePannelView$1] */
    private void init(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        inflate(context, R.layout.security_center_main_dial, this);
        this.mDialLayer = (ViewGroup) findViewById(R.id.dial_layer);
        this.mPieProgress = (PieProgressView) findViewById(R.id.dial_pie_progress);
        this.mPieProgressFull = (PieProgressFullView) findViewById(R.id.dial_pie_progress_full);
        this.mDialGreenBg = (ImageView) findViewById(R.id.dial_green_bg);
        this.mDialGreenFg = (ImageView) findViewById(R.id.dial_green_fg);
        this.mParticleImgView = (ImageView) findViewById(R.id.dial_particle_bg);
        new AnonymousClass1(this).execute(new Void[0]);
        this.mCleanDoneImgView = (ImageView) findViewById(R.id.dial_clean_done);
        this.mInnerBaseBg = (ImageView) findViewById(R.id.inner_base_bg);
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
    }

    public static String formatWithLeadingZeros(int number, int totalDigits) {
        return String.format("%0" + totalDigits + DayFormatter.DEFAULT_FORMAT, new Object[]{Integer.valueOf(number)});
    }

    AnimationDrawable getLoadAnimationDrawable() {
        return (AnimationDrawable) getResources().getDrawable(R.drawable.particle_animation_load);
    }

    AnimationDrawable getConvergenceAnimationDrawable() {
        return (AnimationDrawable) getResources().getDrawable(R.drawable.particle_animation_convergence);
    }

    AnimationDrawable getExplosionAnimationDrawable() {
        return (AnimationDrawable) getResources().getDrawable(R.drawable.particle_animation_explosion);
    }

    public void prepare() {
        this.mDialGreenBg.setAlpha(1.0f);
        this.mDialGreenFg.setAlpha(1.0f);
    }

    public static boolean isMainThread() {
        if (Looper.getMainLooper() != Looper.myLooper()) goto L5;
        return true;
    L5:
        return false;
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [com.obric.oui.animation.RotatePannelView$2] */
    /* JADX WARN: Type inference failed for: r0v5, types: [com.obric.oui.animation.RotatePannelView$3] */
    public void scan() {
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
        if (this.mAnimationDrawable0 != null) goto L5;
        this.mAnimationDrawable0 = getLoadAnimationDrawable();
    L5:
        new AnonymousClass2(this).execute(new Void[0]);
        new AnonymousClass3(this).execute(new Void[0]);
        this.mParticleImgView.setVisibility(0);
        OLog.d(TAG, "setImageDrawable 1: " + isMainThread());
        this.mParticleImgView.setImageDrawable(this.mAnimationDrawable0);
        AnimationDrawable r2 = this.mAnimationDrawable0;
        if (r2 == null) goto L9;
        r2.setOneShot(false);
        this.mAnimationDrawable0.start();
        return;
    }

    public void onScanEnd() {
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
    }

    public void clean() {
        this.mParticleImgView.setVisibility(0);
        OLog.d(TAG, "setImageDrawable 3: " + isMainThread());
        this.mParticleImgView.setImageDrawable(this.mAnimationDrawable1);
    }

    public void onCleanEnd() {
        if (this.mAnimationDrawable1 == null) goto L6;
        this.mParticleImgView.setVisibility(0);
        OLog.d(TAG, "setImageDrawable 4: " + isMainThread());
        this.mParticleImgView.setImageDrawable(this.mAnimationDrawable2);
        this.mAnimationDrawable2.setOneShot(true);
        this.mAnimationDrawable2.start();
        this.mAnimationDrawable1.stop();
        releaseAnimationDrawable(this.mAnimationDrawable1);
        this.mAnimationDrawable1 = null;
        this.mParticleImgView.postDelayed(new AnonymousClass4(this), 2000);
        return;
    }

    private void releaseAnimationDrawable(AnimationDrawable drawable) {
        if (drawable == null) goto L21;
        drawable.stop();
        int r0 = 0;
    L5:
        if (r0 >= drawable.getNumberOfFrames()) goto L14;
        Drawable r1 = drawable.getFrame(r0);
        if ((r1 instanceof BitmapDrawable) == false) goto L13;
        Bitmap r2 = ((BitmapDrawable) r1).getBitmap();
        if (r2 == null) goto L13;
        if (r2.isRecycled() == true) goto L13;
        r2.recycle();
    L13:
        r0 = r0 + 1;
        goto L5
    L14:
        drawable.setCallback(null);
        new Thread(new AnonymousClass5(this), "RotatePannelView-gc").start();
        return;
    }

    @Override // com.obric.oui.animation.ScrollingNumbersView.ScrollNumberListener
    public void onFinish() {
        RotatePannelManager.RotateListener r0 = this.rotateListener;
        if (r0 == null) goto L6;
        r0.onScanEnd();
        return;
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
}
