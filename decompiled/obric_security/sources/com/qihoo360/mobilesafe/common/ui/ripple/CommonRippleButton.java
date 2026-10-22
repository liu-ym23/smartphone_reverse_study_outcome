package com.qihoo360.mobilesafe.common.ui.ripple;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.Button;

/* JADX INFO: loaded from: classes4.dex */
public class CommonRippleButton extends Button {
    private final CommonRippleHelper mRippleHelper;

    public CommonRippleButton(Context r2) {
        this(r2, null);
    }

    public CommonRippleButton(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    public CommonRippleButton(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        setGravity(17);
        this.mRippleHelper = new CommonRippleHelper(this);
    }

    @Override // android.view.View
    public boolean dispatchTouchEvent(MotionEvent r2) {
        this.mRippleHelper.onRippleTouch(r2);
        return super.dispatchTouchEvent(r2);
    }

    @Override // android.widget.TextView, android.view.View
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

    public void setRoundRadius(float r1) {
        this.mRippleHelper.setRoundRadius(r1);
    }

    public void disableRipple() {
        this.mRippleHelper.disableRipple();
    }

    public void releaseRipple() {
        this.mRippleHelper.releaseRipple();
    }
}
