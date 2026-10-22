package com.qihoo360.mobilesafe.common.ui.ripple;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.RelativeLayout;

/* JADX INFO: loaded from: classes4.dex */
public class CommonRippleRelativeLayout extends RelativeLayout {
    private final CommonRippleHelper mRippleHelper;

    public CommonRippleRelativeLayout(Context r2) {
        this(r2, null);
    }

    public CommonRippleRelativeLayout(Context r1, AttributeSet r2) {
        super(r1, r2);
        setWillNotDraw(false);
        this.mRippleHelper = new CommonRippleHelper(this);
    }

    public CommonRippleRelativeLayout(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        setWillNotDraw(false);
        this.mRippleHelper = new CommonRippleHelper(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent r2) {
        this.mRippleHelper.onRippleTouch(r2);
        return super.dispatchTouchEvent(r2);
    }

    @Override // android.view.View
    protected void onDraw(Canvas r2) {
        this.mRippleHelper.onRippleDraw(r2);
        super.onDraw(r2);
    }

    @Override // android.view.View
    public boolean performClick() {
        if (this.mRippleHelper.isDrawRippleDrawing() == false) goto L7;
        this.mRippleHelper.performClick();
        return true;
    L7:
        return super.performClick();
    }

    public void clearRipple() {
        this.mRippleHelper.clearRipple();
    }

    public void disableRipple() {
        this.mRippleHelper.disableRipple();
    }

    public void releaseRipple() {
        this.mRippleHelper.releaseRipple();
    }
}
