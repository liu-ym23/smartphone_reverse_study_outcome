package com.android.settings.fingerprint;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import com.android.settings.R;

/* JADX INFO: loaded from: classes2.dex */
public class FingerprintLocationAnimationView extends View implements FingerprintFindSensorAnimation {
    private static final float ANIMATION_VALUE_ALPHA = 255.0f;
    private static final long DELAY_BETWEEN_PHASE = 1000;
    private static final float MAX_PULSE_ALPHA = 0.15f;
    private ValueAnimator mAlphaAnimator;
    private final Paint mDotPaint;
    private final int mDotRadius;
    private final Interpolator mFastOutSlowInInterpolator;
    private final float mFractionCenterX;
    private final float mFractionCenterY;
    private final Interpolator mLinearOutSlowInInterpolator;
    private final int mMaxPulseRadius;
    private final Paint mPulsePaint;
    private float mPulseRadius;
    private ValueAnimator mRadiusAnimator;
    private final Runnable mStartPhaseRunnable;

    static /* synthetic */ float access$002(FingerprintLocationAnimationView r0, float r1) {
        r0.mPulseRadius = r1;
        return r1;
    }

    static /* synthetic */ ValueAnimator access$102(FingerprintLocationAnimationView r0, ValueAnimator r1) {
        r0.mRadiusAnimator = r1;
        return r1;
    }

    static /* synthetic */ Runnable access$200(FingerprintLocationAnimationView r0) {
        return r0.mStartPhaseRunnable;
    }

    static /* synthetic */ Paint access$300(FingerprintLocationAnimationView r0) {
        return r0.mPulsePaint;
    }

    static /* synthetic */ ValueAnimator access$402(FingerprintLocationAnimationView r0, ValueAnimator r1) {
        r0.mAlphaAnimator = r1;
        return r1;
    }

    static /* synthetic */ void access$500(FingerprintLocationAnimationView r0) {
        r0.startPhase();
    }

    public FingerprintLocationAnimationView(Context r6, AttributeSet r7) {
        super(r6, r7);
        Paint r8 = new Paint();
        this.mDotPaint = r8;
        Paint r0 = new Paint();
        this.mPulsePaint = r0;
        this.mStartPhaseRunnable = new AnonymousClass5(this);
        this.mDotRadius = getResources().getDimensionPixelSize(R.dimen.fingerprint_dot_radius);
        this.mMaxPulseRadius = getResources().getDimensionPixelSize(R.dimen.fingerprint_pulse_radius);
        this.mFractionCenterX = getResources().getFraction(R.fraction.fingerprint_sensor_location_fraction_x, 1, 1);
        this.mFractionCenterY = getResources().getFraction(R.fraction.fingerprint_sensor_location_fraction_y, 1, 1);
        TypedValue r1 = new TypedValue();
        r6.getTheme().resolveAttribute(android.R.attr.colorAccent, r1, true);
        int r2 = getResources().getColor(r1.resourceId, null);
        r8.setAntiAlias(true);
        r0.setAntiAlias(true);
        r8.setColor(r2);
        r0.setColor(r2);
        this.mLinearOutSlowInInterpolator = AnimationUtils.loadInterpolator(r6, 17563662);
        this.mFastOutSlowInInterpolator = AnimationUtils.loadInterpolator(r6, 17563662);
    }

    @Override // android.view.View
    protected void onDraw(Canvas r1) {
        drawPulse(r1);
        drawDot(r1);
    }

    private void drawDot(Canvas r4) {
        r4.drawCircle(getCenterX(), getCenterY(), this.mDotRadius, this.mDotPaint);
    }

    private void drawPulse(Canvas r4) {
        r4.drawCircle(getCenterX(), getCenterY(), this.mPulseRadius, this.mPulsePaint);
    }

    private float getCenterX() {
        return getWidth() * this.mFractionCenterX;
    }

    private float getCenterY() {
        return getHeight() * this.mFractionCenterY;
    }

    @Override // com.android.settings.fingerprint.FingerprintFindSensorAnimation
    public void startAnimation() {
        startPhase();
    }

    @Override // com.android.settings.fingerprint.FingerprintFindSensorAnimation
    public void stopAnimation() {
        removeCallbacks(this.mStartPhaseRunnable);
        ValueAnimator r0 = this.mRadiusAnimator;
        if (r0 == null) goto L5;
        r0.cancel();
    L5:
        ValueAnimator r1 = this.mAlphaAnimator;
        if (r1 == null) goto L9;
        r1.cancel();
        return;
    }

    @Override // com.android.settings.fingerprint.FingerprintFindSensorAnimation
    public void pauseAnimation() {
        stopAnimation();
    }

    private void startPhase() {
        startRadiusAnimation();
        startAlphaAnimation();
    }

    private void startRadiusAnimation() {
        ValueAnimator r0 = ValueAnimator.ofFloat(new float[]{0.0f, this.mMaxPulseRadius});
        r0.addUpdateListener(new AnonymousClass1(this));
        r0.addListener(new AnonymousClass2(this));
        r0.setDuration(1000);
        r0.setInterpolator(this.mLinearOutSlowInInterpolator);
        r0.start();
        this.mRadiusAnimator = r0;
    }

    private void startAlphaAnimation() {
        this.mPulsePaint.setAlpha(38);
        ValueAnimator r0 = ValueAnimator.ofFloat(new float[]{MAX_PULSE_ALPHA, 0.0f});
        r0.addUpdateListener(new AnonymousClass3(this));
        r0.addListener(new AnonymousClass4(this));
        r0.setDuration(750);
        r0.setInterpolator(this.mFastOutSlowInInterpolator);
        r0.setStartDelay(250);
        r0.start();
        this.mAlphaAnimator = r0;
    }
}
