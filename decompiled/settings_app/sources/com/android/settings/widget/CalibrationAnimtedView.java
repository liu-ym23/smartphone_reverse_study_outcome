package com.android.settings.widget;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.android.settings.R;
import com.obric.olog.OLog;

/* JADX INFO: loaded from: classes.dex */
public class CalibrationAnimtedView extends RelativeLayout {
    public static final int STATE_CALIBRATED = 2;
    public static final int STATE_CALIBRATING = 1;
    public static final int STATE_INIT = 0;
    public static final int STATE_KEY_ABSENT = 3;
    private ObjectAnimator animWave;
    private int currentState;
    private ImageView mImgDone;
    private ImageView mImgWave;
    float scaleValue;
    private AnimatorSet selectedAnimSet;

    private class AnimatorListenerWrapper implements Animator.AnimatorListener {
        final /* synthetic */ CalibrationAnimtedView this$0;

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator r1) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator r1) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator r1) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator r1) {
        }

        private AnimatorListenerWrapper(CalibrationAnimtedView r1) {
            this.this$0 = r1;
        }

        /* synthetic */ AnimatorListenerWrapper(CalibrationAnimtedView r1, AnonymousClass1 r2) {
            this(r1);
        }
    }

    static /* synthetic */ ImageView access$100(CalibrationAnimtedView r0) {
        return r0.mImgDone;
    }

    public CalibrationAnimtedView(Context r2) {
        this(r2, null);
    }

    public CalibrationAnimtedView(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    public CalibrationAnimtedView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        this.currentState = 0;
        this.scaleValue = 1.0f;
        View r4 = LayoutInflater.from(r1).inflate(R.layout.calibration_animated_view, this, true);
        this.mImgWave = (ImageView) r4.findViewById(R.id.calibration_img_wave);
        this.mImgDone = (ImageView) r4.findViewById(R.id.calibration_img_done);
    }

    private void initWaveAnim() {
        if (this.animWave != null) goto L6;
        PropertyValuesHolder r1 = PropertyValuesHolder.ofFloat("scaleX", new float[]{1.0f, 1.6f});
        PropertyValuesHolder r2 = PropertyValuesHolder.ofFloat("scaleY", new float[]{1.0f, 1.6f});
        ObjectAnimator r3 = ObjectAnimator.ofPropertyValuesHolder(this.mImgWave, new PropertyValuesHolder[]{r1, r2}).setDuration(500);
        this.animWave = r3;
        r3.setRepeatMode(2);
        this.animWave.setStartDelay(1);
        this.animWave.setInterpolator(new AccelerateDecelerateInterpolator());
        this.animWave.setRepeatCount(-1);
        this.animWave.addUpdateListener(new AnonymousClass1(this));
        return;
    }

    public void startAnim(int r3) {
        if (r3 != 0) goto L4;
        return;
    L4:
        if (this.currentState != 2) goto L7;
        return;
    L7:
        if (r3 == 1) goto L21;
        if (r3 != 2) goto L38;
        this.currentState = r3;
        ObjectAnimator r4 = this.animWave;
        if (r4 == null) goto L16;
        if (r4.isRunning() == false) goto L16;
        this.animWave.cancel();
    L16:
        if (this.selectedAnimSet != null) goto L19;
        initSelectedAnim();
    L19:
        if (this.selectedAnimSet.isRunning() == true) goto L34;
        this.selectedAnimSet.start();
        return;
    L34:
        return;
    L38:
        return;
    L21:
        this.currentState = r3;
        this.mImgWave.setImageResource(R.drawable.calibration_wave);
        AnimatorSet r5 = this.selectedAnimSet;
        if (r5 == null) goto L27;
        if (r5.isRunning() == false) goto L27;
        this.selectedAnimSet.cancel();
    L27:
        if (this.animWave != null) goto L30;
        initWaveAnim();
    L30:
        if (this.animWave.isRunning() == true) goto L36;
        this.animWave.start();
        return;
    }

    public void stopAnim() {
        ObjectAnimator r0 = this.animWave;
        if (r0 != null) goto L5;
    L7:
        AnimatorSet r1 = this.selectedAnimSet;
        if (r1 != null) goto L10;
        return;
    L10:
        if (r1.isRunning() == false) goto L14;
        this.selectedAnimSet.cancel();
        return;
    L14:
        return;
    L5:
        if (r0.isRunning() == false) goto L7;
        this.animWave.cancel();
        goto L7
    }

    private void initSelectedAnim() {
        OLog.d("", "scaleValue:" + this.scaleValue);
        AnimatorSet r0 = new AnimatorSet();
        PropertyValuesHolder r2 = PropertyValuesHolder.ofFloat("scaleX", new float[]{this.scaleValue, 0.9f});
        PropertyValuesHolder r7 = PropertyValuesHolder.ofFloat("scaleY", new float[]{this.scaleValue, 0.9f});
        long r9 = 100;
        ObjectAnimator r8 = ObjectAnimator.ofPropertyValuesHolder(this.mImgWave, new PropertyValuesHolder[]{r2, r7}).setDuration(r9);
        ObjectAnimator r3 = ObjectAnimator.ofPropertyValuesHolder(this.mImgDone, new PropertyValuesHolder[]{r2, r7}).setDuration(r9);
        ObjectAnimator r10 = ObjectAnimator.ofFloat(this.mImgWave, "alpha", new float[]{1.0f, 0.0f});
        r10.addListener(new AnonymousClass2(this));
        r10.setDuration(r9);
        ObjectAnimator r11 = ObjectAnimator.ofFloat(this.mImgDone, "alpha", new float[]{0.0f, 1.0f});
        r11.addListener(new AnonymousClass3(this));
        r11.setDuration(r9);
        r0.playTogether(new Animator[]{r8, r3, r10, r11});
        ObjectAnimator r4 = ObjectAnimator.ofPropertyValuesHolder(this.mImgDone, new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat("scaleX", new float[]{0.9f, 1.0f}), PropertyValuesHolder.ofFloat("scaleY", new float[]{0.9f, 1.0f})}).setDuration(200);
        if (this.selectedAnimSet != null) goto L6;
        AnimatorSet r5 = new AnimatorSet();
        this.selectedAnimSet = r5;
        r5.playSequentially(new Animator[]{r0, r4});
        return;
    }
}
