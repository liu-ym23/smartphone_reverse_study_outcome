package com.android.settings.widget;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import com.android.settings.R;
import com.obric.common.oea.foundation.animation.token.Token;
import com.obric.common.oea.foundation.animation.token.TokenUtil;
import com.obric.olog.OLog;

/* JADX INFO: loaded from: classes.dex */
public class FingerprintEnrollProgressView extends View {
    private static final int DURATION = 0;
    private static final String TAG = "FingerprintEnrollProgressView";
    private Paint mBackgroundPaint;
    private int mBorderWidth;
    protected Callback mCallback;
    private Context mContext;
    private int mForegroundColor;
    private Paint mForegroundPaint;
    private TimeInterpolator mInterpolator;
    private final float mMaxProgress;
    private Paint mPieProgressPaint;
    private float mProgress;
    private Drawable mSuccessIcon;

    public interface Callback {
        void onAnimDone();
    }

    static {
        DURATION = Token.Duration.OUI_ANIMATION_DURATION_MEDIUM_4.getDuration();
    }

    public FingerprintEnrollProgressView(Context r2) {
        super(r2);
        this.mBorderWidth = 0;
        this.mProgress = 0.0f;
        this.mMaxProgress = 100.0f;
        this.mForegroundColor = 0;
        this.mInterpolator = TokenUtil.INSTANCE.getInterpolator(Token.Easing.OUI_ANIMATION_EASING_STANDARD);
    }

    public FingerprintEnrollProgressView(Context r4, AttributeSet r5) {
        super(r4, r5);
        this.mBorderWidth = 0;
        this.mProgress = 0.0f;
        this.mMaxProgress = 100.0f;
        this.mForegroundColor = 0;
        this.mInterpolator = TokenUtil.INSTANCE.getInterpolator(Token.Easing.OUI_ANIMATION_EASING_STANDARD);
        this.mContext = r4;
        this.mBorderWidth = getResources().getDimensionPixelSize(R.dimen.face_enroll_progress_radius2);
        Paint r6 = new Paint(1);
        this.mBackgroundPaint = r6;
        r6.setColor(r4.getColor(R.color.oui_bg_base_1));
        this.mBackgroundPaint.setStyle(Paint.Style.FILL);
        Paint r7 = new Paint(1);
        this.mForegroundPaint = r7;
        r7.setStyle(Paint.Style.FILL);
        setForegroundColor(this.mContext.getColor(R.color.oui_bg_base_1));
        Paint r8 = new Paint(1);
        this.mPieProgressPaint = r8;
        r8.setColor(r4.getColor(R.color.oui_green_6));
        this.mPieProgressPaint.setStyle(Paint.Style.FILL);
        this.mSuccessIcon = this.mContext.getDrawable(R.drawable.check_confirm_rounded_green);
    }

    @Override // android.view.View
    protected void onDraw(Canvas r14) {
        super.onDraw(r14);
        float r0 = getWidth() / 2.0f;
        float r2 = getHeight() / 2.0f;
        r14.drawCircle(r0, r2, r0, this.mBackgroundPaint);
        r14.drawArc(0.0f, 0.0f, getWidth(), getHeight(), -90.0f, (this.mProgress * 360.0f) / 100.0f, true, this.mPieProgressPaint);
        r14.drawCircle(r0, r2, r0 - this.mBorderWidth, this.mBackgroundPaint);
        r14.drawCircle(r0, r2, r0 - this.mBorderWidth, this.mForegroundPaint);
        if (this.mProgress != 100.0f) goto L6;
        int r1 = this.mSuccessIcon.getIntrinsicWidth() / 2;
        float r3 = r1;
        float r4 = this.mSuccessIcon.getIntrinsicHeight() / 2;
        this.mSuccessIcon.setBounds((int) (r0 - r3), (int) (r2 - r4), (int) (r0 + r3), (int) (r2 + r4));
        this.mSuccessIcon.draw(r14);
        return;
    }

    public void setCallback(Callback r1) {
        this.mCallback = r1;
    }

    public void reset() {
        OLog.i(TAG, "reset");
        setProgress(0.0f);
        setForegroundColor(this.mContext.getColor(R.color.oui_bg_base_1));
        setScaleX(1.0f);
        setScaleY(1.0f);
    }

    public void setProgress(float r1) {
        this.mProgress = r1;
        invalidate();
    }

    public void setForegroundColor(int r2) {
        this.mForegroundColor = r2;
        this.mForegroundPaint.setColor(r2);
        invalidate();
    }
}
