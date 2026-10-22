package com.android.settings.widget;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import com.android.settings.R;
import com.obric.common.oea.foundation.animation.token.Token;
import com.obric.common.oea.foundation.animation.token.TokenUtil;
import com.obric.olog.OLog;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class FingerprintEnrollIntroductionView extends View {
    private static final int DURATION = 0;
    private static final String TAG = "FingerprintEnrollProgressView";
    private Context mContext;
    private TimeInterpolator mInterpolator;
    private int mIntroductionHeight;
    private Drawable mIntroductionIcon;
    private int mIntroductionLeft;
    private int mIntroductionTop;
    private int mIntroductionWidth;
    private int mOffsetBase;
    private float mOffsetRate;
    private int mProgress;
    private float mRotate;

    static {
        DURATION = Token.Duration.OUI_ANIMATION_DURATION_MEDIUM_4.getDuration();
    }

    public FingerprintEnrollIntroductionView(Context r2) {
        super(r2);
        this.mProgress = 0;
        this.mIntroductionLeft = 0;
        this.mIntroductionTop = 0;
        this.mIntroductionWidth = 0;
        this.mIntroductionHeight = 0;
        this.mOffsetBase = 0;
        this.mOffsetRate = 0.0f;
        this.mRotate = 0.0f;
        this.mInterpolator = TokenUtil.INSTANCE.getInterpolator(Token.Easing.OUI_ANIMATION_EASING_STANDARD);
    }

    public FingerprintEnrollIntroductionView(Context r2, AttributeSet r3) {
        super(r2, r3);
        this.mProgress = 0;
        this.mIntroductionLeft = 0;
        this.mIntroductionTop = 0;
        this.mIntroductionWidth = 0;
        this.mIntroductionHeight = 0;
        this.mOffsetBase = 0;
        this.mOffsetRate = 0.0f;
        this.mRotate = 0.0f;
        this.mInterpolator = TokenUtil.INSTANCE.getInterpolator(Token.Easing.OUI_ANIMATION_EASING_STANDARD);
        this.mContext = r2;
        this.mIntroductionIcon = r2.getDrawable(R.drawable.front_fingerprint_enroll_init_hand3);
        this.mIntroductionLeft = r2.getResources().getDimensionPixelSize(R.dimen.fingerprint_enroll_icon_left_margin);
        this.mIntroductionTop = r2.getResources().getDimensionPixelSize(R.dimen.fingerprint_enroll_icon_top_margin);
        this.mIntroductionWidth = r2.getResources().getDimensionPixelSize(R.dimen.fingerprint_enroll_icon_width);
        this.mIntroductionHeight = r2.getResources().getDimensionPixelSize(R.dimen.fingerprint_enroll_icon_height);
        this.mOffsetBase = r2.getResources().getDimensionPixelSize(R.dimen.fingerprint_enroll_icon_base);
    }

    @Override // android.view.View
    protected void onDraw(Canvas r6) {
        super.onDraw(r6);
        float r0 = getWidth() / 2.0f;
        float r2 = getHeight() / 2.0f;
        float r3 = getWidth() / 2.0f;
        Path r1 = new Path();
        r1.addCircle(r0, r2, r3, Path.Direction.CCW);
        r6.save();
        r6.rotate(-this.mRotate, r0, r2);
        r6.clipPath(r1);
        int r4 = this.mIntroductionLeft;
        int r5 = this.mIntroductionTop;
        int r7 = (-r5) + ((int) ((this.mOffsetBase + r5) * this.mOffsetRate));
        this.mIntroductionIcon.setBounds(r4, r7, this.mIntroductionWidth + r4, this.mIntroductionHeight + r7);
        this.mIntroductionIcon.draw(r6);
        r6.restore();
    }

    public void setProgressWithAnimation(int r7) {
        OLog.i(TAG, "setProgressWithAnimation: " + this.mProgress + " -> " + r7);
        int r0 = DURATION;
        if (this.mProgress != 0) goto L7;
        if (r7 == 0) goto L8;
        ArrayList r1 = new ArrayList();
        r1.add(ObjectAnimator.ofInt(this, "progress", new int[]{this.mProgress, r7}));
        ObjectAnimator r8 = ObjectAnimator.ofFloat(this, "scaleX", new float[]{1.0f, 0.625f});
        ObjectAnimator r3 = ObjectAnimator.ofFloat(this, "scaleY", new float[]{1.0f, 0.625f});
        r1.add(r8);
        r1.add(r3);
        r1.add(ObjectAnimator.ofFloat(this, "offsetRate", new float[]{0.0f, 1.0f}));
        r1.add(ObjectAnimator.ofFloat(this, "rotate", new float[]{0.0f, 30.0f}));
        r1.add(ObjectAnimator.ofFloat(this, "alpha", new float[]{1.0f, 0.5f}));
        AnimatorSet r9 = new AnimatorSet();
        r9.setDuration(r0);
        r9.setInterpolator(this.mInterpolator);
        r9.playTogether(r1);
        r9.start();
        return;
    L8:
        return;
    }

    public void reset() {
        OLog.i(TAG, "reset");
        setProgress(0);
        setScaleX(1.0f);
        setScaleY(1.0f);
        setOffsetRate(0.0f);
        setRotate(0.0f);
        setAlpha(1.0f);
    }

    public void setOffsetRate(float r1) {
        this.mOffsetRate = r1;
        invalidate();
    }

    public void setRotate(float r1) {
        this.mRotate = r1;
        invalidate();
    }

    public void setProgress(int r1) {
        this.mProgress = r1;
        invalidate();
    }
}
