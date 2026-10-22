package com.android.settings.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.PathInterpolator;
import com.airbnb.lottie.LottieAnimationView;
import com.obric.common.oea.foundation.animation.builder.ValueAnimatable;
import com.obric.common.oea.foundation.animation.manager.AnimationManager;
import com.obric.common.oea.foundation.animation.spec.AnimationSpecKt;
import com.obric.common.oea.foundation.animation.spec.spring.FloatSpringSpec;
import com.obric.common.oea.foundation.animation.token.Token;
import com.obric.olog.OLog;
import kotlin.Unit;

/* JADX INFO: loaded from: classes.dex */
public class FingerprintEnrollProgressLottieView extends LottieAnimationView {
    private static final String TAG = "FingerprintEnrollProgressLottieView";
    protected FingerprintEnrollProgressView.Callback mCallback;
    private final float mMaxProgress;
    private float mProgress;
    private AnimationManager mProgressViewLottieAnimator;
    private int sensorType;

    public FingerprintEnrollProgressLottieView(Context r1) {
        super(r1);
        this.mProgress = 0.0f;
        this.mMaxProgress = 100.0f;
        this.sensorType = 0;
    }

    public FingerprintEnrollProgressLottieView(Context r1, AttributeSet r2) {
        super(r1, r2);
        this.mProgress = 0.0f;
        this.mMaxProgress = 100.0f;
        this.sensorType = 0;
    }

    public FingerprintEnrollProgressLottieView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        this.mProgress = 0.0f;
        this.mMaxProgress = 100.0f;
        this.sensorType = 0;
    }

    public void playAnimationLottie(int r6) {
        OLog.i(TAG, "playAnimationLottie currentProgress=" + r6);
        AnimationManager r0 = this.mProgressViewLottieAnimator;
        if (r0 == null) goto L5;
        r0.cancelAnimation(true);
        this.mProgressViewLottieAnimator = null;
    L5:
        ValueAnimatable.Builder r1 = new ValueAnimatable.Builder();
        FloatSpringSpec r2 = AnimationSpecKt.spring(Token.Bounce.OUI_ANIMATION_BOUNCE_SMOOTH, Token.Duration.OUI_ANIMATION_DURATION_MEDIUM_2, 0);
        float r7 = r6;
        this.mProgress = r7;
        final float r8 = r7 / 100.0f;
        final float r3 = getPathInterpolatorProgress(r8);
        this.mProgressViewLottieAnimator = r1.of(getProgress(), r3, r2, null).onUpdate(new FingerprintEnrollProgressLottieView$$ExternalSyntheticLambda0(this)).onEnd(new FingerprintEnrollProgressLottieView$$ExternalSyntheticLambda1(this, r8, r3)).build().start();
    }

    /* JADX INFO: renamed from: lambda$playAnimationLottie$0$com-android-settings-widget-FingerprintEnrollProgressLottieView, reason: not valid java name */
    /* synthetic */ Unit m655xfaa2b4cc(String r1, Object r2, Object r3) {
        if ((r2 instanceof Float) == false) goto L7;
        OLog.i(TAG, "onUpdate progress=" + r2);
        setProgress(((Float) r2).floatValue());
        return null;
    L7:
        return null;
    }

    /* JADX INFO: renamed from: lambda$playAnimationLottie$1$com-android-settings-widget-FingerprintEnrollProgressLottieView, reason: not valid java name */
    /* synthetic */ Unit m656x48622ccd(float r2, float r3, Boolean r4, Throwable r5) {
        this.mProgressViewLottieAnimator = null;
        if (r4.booleanValue() == false) goto L9;
        OLog.i(TAG, "onEnd targetProgress=" + r2 + ", pathInterpolatorTargetProgress=" + r3);
        setProgress(r3);
        if (100.0f != this.mProgress) goto L9;
        if (this.mCallback == null) goto L9;
        OLog.e(TAG, "onAnimDone: " + this.mProgress + "/100.0");
        this.mCallback.onAnimDone();
    L9:
        return null;
    }

    public void setCallback(FingerprintEnrollProgressView.Callback r1) {
        this.mCallback = r1;
    }

    public void setSensorType(int r1) {
        this.sensorType = r1;
    }

    public void reset() {
        OLog.i(TAG, "reset");
        setProgress(0.0f);
        this.mProgress = 0.0f;
    }

    private float getPathInterpolatorProgress(float r4) {
        if (this.sensorType != 4) goto L7;
        return new PathInterpolator(0.0f, 1.0f, 0.42f, 0.42f).getInterpolation(r4);
    L7:
        return new PathInterpolator(0.0f, 0.0f, 1.0f, 1.0f).getInterpolation(r4);
    }
}
