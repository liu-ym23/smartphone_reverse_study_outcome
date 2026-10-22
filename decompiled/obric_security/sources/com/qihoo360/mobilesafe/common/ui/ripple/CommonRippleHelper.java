package com.qihoo360.mobilesafe.common.ui.ripple;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;

/* JADX INFO: loaded from: classes4.dex */
public class CommonRippleHelper {
    private static final float ALPHA_TARGET = 0.06f;
    private static final int EXP_DURATION_FAST = 200;
    private static final int EXP_DURATION_SLOW = 1200;
    private static final int FPS = 20;
    private static long sLastClickTime;
    private static int screenW;
    private float mAlpha;
    private float mAlphaAdd;
    private int mAlphaDuration;
    private float mAlphaTarget;
    private RectF mBound;
    private float mCenterX;
    private float mCenterXAdd;
    private float mCenterXTarget;
    private float mCenterY;
    private boolean mClicked;
    private boolean mDrawRipple;
    private int mExpandDurationFast;
    private int mExpandDurationSlow;
    private int mHeight;
    private final View mHost;
    private final Paint mPaint;
    private float mRadius;
    private float mRadiusAdd;
    private float mRadiusTarget;
    private boolean mRippleEnabled;
    private float mRoundRadius;
    private int mWidth;

    static /* synthetic */ void access$000(CommonRippleHelper r0) {
        r0.checkListItemClick();
    }

    static /* synthetic */ View access$100(CommonRippleHelper r0) {
        return r0.mHost;
    }

    public CommonRippleHelper(View r2) {
        this.mRippleEnabled = true;
        this.mHost = r2;
        r2.setClickable(true);
        Paint r3 = new Paint();
        this.mPaint = r3;
        r3.setAntiAlias(true);
    }

    public void onRippleTouch(MotionEvent r10) {
        if (this.mRippleEnabled == true) goto L6;
        return;
    L6:
        if (r10.getAction() != 0) goto L30;
        if (this.mClicked == false) goto L10;
        return;
    L10:
        if (this.mHost.isEnabled() == false) goto L46;
        View r0 = this.mHost;
        if ((r0 instanceof ViewGroup) == true) goto L15;
    L17:
        this.mDrawRipple = true;
        this.mCenterY = r10.getY();
        if (screenW != 0) goto L20;
        screenW = ((WindowManager) this.mHost.getContext().getSystemService("window")).getDefaultDisplay().getWidth();
    L20:
        this.mWidth = this.mHost.getWidth();
        this.mHeight = this.mHost.getHeight();
        if (this.mBound != null) goto L23;
        this.mBound = new RectF(0.0f, 0.0f, this.mWidth, this.mHeight);
    L23:
        this.mExpandDurationSlow = (int) ((this.mWidth / screenW) * 1200.0f);
        this.mExpandDurationFast = 200;
        this.mAlphaDuration = 200;
        float r11 = r10.getX();
        this.mCenterX = r11;
        int r1 = this.mWidth;
        float r3 = r1 >> 1;
        this.mCenterXTarget = r3;
        this.mCenterXAdd = ((r3 - r11) * 20.0f) / this.mExpandDurationSlow;
        this.mRadius = 0.0f;
        int r4 = this.mHeight;
        if (this.mCenterY < (r4 >> 1)) goto L26;
        this.mRadiusTarget = (float) Math.sqrt(Math.pow(r1 >> 1, 2.0d) + Math.pow(this.mCenterY, 2.0d));
    L27:
        this.mRadiusAdd = ((this.mRadiusTarget - this.mRadius) * 20.0f) / this.mExpandDurationSlow;
        this.mAlpha = 0.0f;
        this.mAlphaTarget = ALPHA_TARGET;
        this.mAlphaAdd = 1.1999999f / this.mAlphaDuration;
        this.mHost.invalidate();
        return;
    L26:
        this.mRadiusTarget = (float) Math.sqrt(Math.pow(r1 >> 1, 2.0d) + Math.pow(r4 - this.mCenterY, 2.0d));
        goto L27
    L15:
        if (interByChild((ViewGroup) r0, r10.getX(), r10.getY()) == false) goto L17;
        return;
    L46:
        return;
    L30:
        if (r10.getAction() != 2) goto L41;
        float r2 = r10.getX();
        float r12 = r10.getY();
        if (r2 >= 0.0f) goto L34;
    L39:
        quickAnim();
        return;
    L34:
        if (r2 > this.mWidth) goto L39;
        if (r12 < 0.0f) goto L39;
        if (r12 > this.mHeight) goto L39;
        return;
    L41:
        if (r10.getAction() != 1) goto L43;
    L44:
        quickAnim();
        return;
    L43:
        if (r10.getAction() == 3) goto L44;
    }

    private boolean interByChild(ViewGroup r8, float r9, float r10) {
        int r0 = r8.getChildCount();
        if (r0 <= 0) goto L35;
        int r2 = 0;
    L5:
        if (r2 >= r0) goto L35;
        View r3 = r8.getChildAt(r2);
        if (r3.getVisibility() != 0) goto L34;
        if ((r3 instanceof ViewGroup) == false) goto L24;
        if (r9 >= r3.getRight()) goto L34;
        if (r9 <= r3.getLeft()) goto L34;
        if (r10 >= r3.getBottom()) goto L34;
        if (r10 <= r3.getTop()) goto L34;
        if (interByChild((ViewGroup) r3, r9 - r3.getLeft(), r10 - r3.getTop()) == false) goto L34;
        return true;
    L24:
        if (r3.isClickable() == false) goto L34;
        if (r9 >= r3.getRight()) goto L34;
        if (r9 <= r3.getLeft()) goto L34;
        if (r10 >= r3.getBottom()) goto L34;
        if (r10 <= r3.getTop()) goto L34;
        return true;
    L34:
        r2 = r2 + 1;
    L35:
        return false;
    }

    public void setRoundRadius(float r1) {
        this.mRoundRadius = r1;
    }

    private void quickAnim() {
        if (this.mDrawRipple == true) goto L5;
        return;
    L5:
        float r0 = this.mAlphaAdd;
        if (r0 <= 0.0f) goto L9;
        this.mAlpha = ALPHA_TARGET;
        this.mAlphaAdd = -r0;
        this.mAlphaTarget = 0.0f;
        float r1 = this.mCenterXAdd;
        int r2 = this.mExpandDurationSlow;
        int r3 = this.mExpandDurationFast;
        this.mCenterXAdd = (r1 * r2) / r3;
        this.mRadiusAdd = (this.mRadiusAdd * r2) / r3;
        return;
    }

    public void onRippleDraw(Canvas r11) {
        if (this.mDrawRipple == true) goto L5;
        return;
    L5:
        if (this.mRippleEnabled == false) goto L47;
        r11.save();
        int r0 = this.mHost.getScrollX();
        int r1 = this.mHost.getScrollY();
        if (r0 != 0) goto L9;
        if (r1 != 0) goto L9;
    L10:
        this.mPaint.setColor(0);
        this.mPaint.setAlpha((int) (this.mAlpha * 255.0f));
        float r2 = this.mRoundRadius;
        if (r2 != 0.0f) goto L13;
        r11.drawRect(0.0f, 0.0f, this.mWidth, this.mHeight, this.mPaint);
    L14:
        float r3 = this.mAlpha;
        float r4 = this.mAlphaAdd;
        float r5 = r3 + r4;
        this.mAlpha = r5;
        if (r4 >= 0.0f) goto L21;
        float r6 = this.mAlphaTarget;
        if (r5 >= r6) goto L25;
        this.mAlpha = r6;
        this.mDrawRipple = false;
        if (this.mClicked == false) goto L25;
        this.mHost.post(new AnonymousClass1(this));
        this.mClicked = false;
    L25:
        if (this.mAlphaTarget != ALPHA_TARGET) goto L27;
        this.mPaint.setAlpha(15);
    L27:
        float r7 = this.mRoundRadius;
        if (r7 != 0.0f) goto L30;
    L32:
        r11.drawCircle(this.mCenterX, this.mCenterY, this.mRadius, this.mPaint);
    L33:
        float r8 = this.mCenterX;
        float r9 = this.mCenterXAdd;
        float r10 = r8 + r9;
        this.mCenterX = r10;
        if (r9 >= 0.0f) goto L38;
        float r12 = this.mCenterXTarget;
        if (r10 >= r12) goto L41;
        this.mCenterX = r12;
    L41:
        float r13 = this.mRadius + this.mRadiusAdd;
        this.mRadius = r13;
        float r14 = this.mRadiusTarget;
        if (r13 <= r14) goto L44;
        this.mRadius = r14;
    L44:
        r11.restore();
        this.mHost.invalidate();
        return;
    L38:
        float r15 = this.mCenterXTarget;
        if (r10 <= r15) goto L41;
        this.mCenterX = r15;
        goto L41
    L30:
        if (this.mRadius < (this.mRadiusTarget - r7)) goto L32;
        r11.drawRoundRect(this.mBound, r7, r7, this.mPaint);
        goto L33
    L21:
        float r16 = this.mAlphaTarget;
        if (r5 <= r16) goto L25;
        this.mAlpha = r16;
        goto L25
    L13:
        r11.drawRoundRect(this.mBound, r2, r2, this.mPaint);
    L9:
        r11.translate(r0, r1);
        goto L10
    }

    private void checkListItemClick() {
        View r0 = (View) this.mHost.getParent();     // Catch: Exception -> L13
        int r1 = 3;
    L3:
        if (r1 <= 0) goto L21;
        if (r0 == null) goto L22;
        if ((r0 instanceof AdapterView) == true) goto L7;
        r0 = (View) r0.getParent();     // Catch: Exception -> L13
        r1 = r1 - 1;
        goto L3
    L7:
        AdapterView<?> r4 = (AdapterView) r0;     // Catch: Exception -> L13
        int r6 = r4.getPositionForView(this.mHost);     // Catch: Exception -> L13
        AdapterView.OnItemClickListener r3 = r4.getOnItemClickListener();     // Catch: Exception -> L13
        if (r3 == null) goto L12;
        r3.onItemClick(r4, this.mHost, r6, r4.getItemIdAtPosition(r6));     // Catch: Exception -> L13
        return;
    L12:
        return;
    L22:
        return;
    L21:
        return;
    }

    public boolean isDrawRippleDrawing() {
        return this.mDrawRipple;
    }

    public void performClick() {
        long r0 = System.currentTimeMillis();
        if (Math.abs(r0 - sLastClickTime) <= 200) goto L6;
        sLastClickTime = r0;
        this.mClicked = true;
        return;
    }

    public void clearRipple() {
        this.mDrawRipple = false;
    }

    public void disableRipple() {
        this.mRippleEnabled = false;
    }

    public void releaseRipple() {
        quickAnim();
    }
}
