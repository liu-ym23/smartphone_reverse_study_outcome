package com.android.settings.applications;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.LinearLayout;

/* JADX INFO: loaded from: classes2.dex */
public class LinearColorBar extends LinearLayout {
    static final int GRAY_COLOR = -11184811;
    static final int LEFT_COLOR = -16738680;
    static final int MIDDLE_COLOR = -16738680;
    public static final int REGION_ALL = 7;
    public static final int REGION_GREEN = 4;
    public static final int REGION_RED = 1;
    public static final int REGION_YELLOW = 2;
    static final int RIGHT_COLOR = -3221541;
    static final int WHITE_COLOR = -1;
    final Paint mColorGradientPaint;
    final Path mColorPath;
    private int mColoredRegions;
    final Paint mEdgeGradientPaint;
    final Path mEdgePath;
    private float mGreenRatio;
    int mLastInterestingLeft;
    int mLastInterestingRight;
    int mLastLeftDiv;
    int mLastRegion;
    int mLastRightDiv;
    private int mLeftColor;
    int mLineWidth;
    private int mMiddleColor;
    private OnRegionTappedListener mOnRegionTappedListener;
    final Paint mPaint;
    final Rect mRect;
    private float mRedRatio;
    private int mRightColor;
    private boolean mShowIndicator;
    private boolean mShowingGreen;
    private float mYellowRatio;

    public interface OnRegionTappedListener {
        void onRegionTapped(int r1);
    }

    public LinearColorBar(Context r4, AttributeSet r5) {
        super(r4, r5);
        this.mLeftColor = -16738680;
        this.mMiddleColor = -16738680;
        this.mRightColor = RIGHT_COLOR;
        this.mShowIndicator = true;
        this.mColoredRegions = 7;
        this.mRect = new Rect();
        Paint r6 = new Paint();
        this.mPaint = r6;
        this.mColorPath = new Path();
        this.mEdgePath = new Path();
        Paint r0 = new Paint();
        this.mColorGradientPaint = r0;
        Paint r1 = new Paint();
        this.mEdgeGradientPaint = r1;
        setWillNotDraw(false);
        r6.setStyle(Paint.Style.FILL);
        r0.setStyle(Paint.Style.FILL);
        r0.setAntiAlias(true);
        r1.setStyle(Paint.Style.STROKE);
        if (getResources().getDisplayMetrics().densityDpi < 240) goto L5;
        int r7 = 2;
    L6:
        this.mLineWidth = r7;
        r1.setStrokeWidth(r7);
        r1.setAntiAlias(true);
        return;
    L5:
        r7 = 1;
        goto L6
    }

    public void setOnRegionTappedListener(OnRegionTappedListener r2) {
        if (r2 == this.mOnRegionTappedListener) goto L10;
        this.mOnRegionTappedListener = r2;
        if (r2 == null) goto L7;
        boolean r3 = true;
    L8:
        setClickable(r3);
        return;
    L7:
        r3 = false;
        goto L8
    }

    public void setColoredRegions(int r1) {
        this.mColoredRegions = r1;
        invalidate();
    }

    public void setRatios(float r1, float r2, float r3) {
        this.mRedRatio = r1;
        this.mYellowRatio = r2;
        this.mGreenRatio = r3;
        invalidate();
    }

    public void setColors(int r1, int r2, int r3) {
        this.mLeftColor = r1;
        this.mMiddleColor = r2;
        this.mRightColor = r3;
        updateIndicator();
        invalidate();
    }

    public void setShowIndicator(boolean r1) {
        this.mShowIndicator = r1;
        updateIndicator();
        invalidate();
    }

    public void setShowingGreen(boolean r2) {
        if (this.mShowingGreen == r2) goto L6;
        this.mShowingGreen = r2;
        updateIndicator();
        invalidate();
        return;
    }

    private void updateIndicator() {
        int r0 = getPaddingTop() - getPaddingBottom();
        if (r0 >= 0) goto L5;
        r0 = 0;
    L5:
        this.mRect.top = r0;
        this.mRect.bottom = getHeight();
        if (this.mShowIndicator == true) goto L9;
        return;
    L9:
        if (this.mShowingGreen == false) goto L11;
        Paint r1 = this.mColorGradientPaint;
        int r9 = this.mRightColor;
        r1.setShader(new LinearGradient(0.0f, 0.0f, 0.0f, r0 - 2, r9 & 16777215, r9, Shader.TileMode.CLAMP));
    L12:
        this.mEdgeGradientPaint.setShader(new LinearGradient(0.0f, 0.0f, 0.0f, r0 / 2, 10526880, -6250336, Shader.TileMode.CLAMP));
        return;
    L11:
        Paint r2 = this.mColorGradientPaint;
        int r10 = this.mMiddleColor;
        r2.setShader(new LinearGradient(0.0f, 0.0f, 0.0f, r0 - 2, r10 & 16777215, r10, Shader.TileMode.CLAMP));
        goto L12
    }

    @Override // android.view.View
    protected void onSizeChanged(int r1, int r2, int r3, int r4) {
        super.onSizeChanged(r1, r2, r3, r4);
        updateIndicator();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent r3) {
        if (this.mOnRegionTappedListener == null) goto L16;
        if (r3.getAction() != 0) goto L16;
        int r0 = (int) r3.getX();
        if (r0 >= this.mLastLeftDiv) goto L11;
        this.mLastRegion = 1;
    L14:
        invalidate();
        goto L16
    L11:
        if (r0 >= this.mLastRightDiv) goto L13;
        this.mLastRegion = 2;
        goto L14
    L13:
        this.mLastRegion = 4;
    L16:
        return super.onTouchEvent(r3);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchSetPressed(boolean r1) {
        invalidate();
    }

    @Override // android.view.View
    public boolean performClick() {
        OnRegionTappedListener r0 = this.mOnRegionTappedListener;
        if (r0 == null) goto L8;
        int r1 = this.mLastRegion;
        if (r1 == 0) goto L8;
        r0.onRegionTapped(r1);
        this.mLastRegion = 0;
    L8:
        return super.performClick();
    }

    private int pickColor(int r2, int r3) {
        if (isPressed() == false) goto L9;
        if ((this.mLastRegion & r3) == 0) goto L9;
        return -1;
    L9:
        if ((this.mColoredRegions & r3) != 0) goto L12;
        return GRAY_COLOR;
    L12:
        return r2;
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onDraw(Canvas r24) {
        super.onDraw(r24);
        int r2 = getWidth();
        float r3 = r2;
        int r5 = 0;
        int r4 = ((int) (this.mRedRatio * r3)) + 0;
        int r6 = ((int) (this.mYellowRatio * r3)) + r4;
        int r7 = ((int) (r3 * this.mGreenRatio)) + r6;
        if (this.mShowingGreen == false) goto L5;
        int r8 = r6;
    L7:
        if (this.mLastInterestingLeft == r8) goto L9;
    L10:
        this.mColorPath.reset();
        this.mEdgePath.reset();
        if (this.mShowIndicator == false) goto L14;
        if (r8 >= r7) goto L14;
        int r9 = this.mRect.top;
        float r15 = r8;
        this.mColorPath.moveTo(r15, this.mRect.top);
        float r10 = r9;
        this.mColorPath.cubicTo(r15, 0.0f, -2.0f, r10, -2.0f, 0.0f);
        float r12 = (r2 + 2) - 1;
        this.mColorPath.lineTo(r12, 0.0f);
        float r14 = r7;
        this.mColorPath.cubicTo(r12, r10, r14, 0.0f, r14, this.mRect.top);
        this.mColorPath.close();
        float r11 = this.mLineWidth + 0.5f;
        float r13 = r11 - 2.0f;
        this.mEdgePath.moveTo(r13, 0.0f);
        float r21 = r15 + r11;
        this.mEdgePath.cubicTo(r13, r10, r21, 0.0f, r21, this.mRect.top);
        float r16 = r12 - r11;
        this.mEdgePath.moveTo(r16, 0.0f);
        float r22 = r14 - r11;
        this.mEdgePath.cubicTo(r16, r10, r22, 0.0f, r22, this.mRect.top);
    L14:
        this.mLastInterestingLeft = r8;
        this.mLastInterestingRight = r7;
    L16:
        if (this.mEdgePath.isEmpty() == true) goto L18;
        r24.drawPath(this.mEdgePath, this.mEdgeGradientPaint);
        r24.drawPath(this.mColorPath, this.mColorGradientPaint);
    L18:
        if (r4 <= 0) goto L20;
        this.mRect.left = 0;
        this.mRect.right = r4;
        this.mPaint.setColor(pickColor(this.mLeftColor, 1));
        r24.drawRect(this.mRect, this.mPaint);
        r2 = r2 - (r4 + 0);
        r5 = r4;
    L20:
        this.mLastLeftDiv = r4;
        this.mLastRightDiv = r6;
        if (r5 >= r6) goto L23;
        this.mRect.left = r5;
        this.mRect.right = r6;
        this.mPaint.setColor(pickColor(this.mMiddleColor, 2));
        r24.drawRect(this.mRect, this.mPaint);
        r2 = r2 - (r6 - r5);
    L24:
        int r17 = r2 + r6;
        if (r6 >= r17) goto L28;
        this.mRect.left = r6;
        this.mRect.right = r17;
        this.mPaint.setColor(pickColor(this.mRightColor, 4));
        r24.drawRect(this.mRect, this.mPaint);
        return;
    L28:
        return;
    L23:
        r6 = r5;
        goto L24
    L9:
        if (this.mLastInterestingRight == r7) goto L16;
    L5:
        r8 = r4;
        r7 = r6;
        goto L7
    }
}
