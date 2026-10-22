package com.android.settings.deviceinfo;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import com.android.settings.R;

/* JADX INFO: loaded from: classes2.dex */
public class StorageProgressBar extends View {
    private Rect mFirstTempRect;
    private Drawable mProgressBg;
    private Bitmap mProgressLeft;
    private Drawable mProgressMiddle;
    private Drawable mProgressMiddleBorder;
    private Bitmap mProgressRight;
    private Rect mSecondTempRect;
    private Rect mTotalRect;
    private double mUsedPercent;
    private Rect mUsedRect;

    public StorageProgressBar(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        this.mFirstTempRect = new Rect();
        this.mSecondTempRect = new Rect();
        init();
    }

    public StorageProgressBar(Context r1, AttributeSet r2) {
        super(r1, r2);
        this.mFirstTempRect = new Rect();
        this.mSecondTempRect = new Rect();
        init();
    }

    public StorageProgressBar(Context r1) {
        super(r1);
        this.mFirstTempRect = new Rect();
        this.mSecondTempRect = new Rect();
        init();
    }

    private void init() {
        this.mTotalRect = new Rect();
        this.mUsedRect = new Rect();
        this.mUsedPercent = 0.0d;
        this.mProgressBg = getResources().getDrawable(R.drawable.progress_bar_bg);
        this.mProgressLeft = BitmapFactory.decodeResource(getResources(), R.drawable.progress_bar_left);
        this.mProgressMiddle = getResources().getDrawable(R.drawable.progress_bar_center);
        this.mProgressMiddleBorder = getResources().getDrawable(R.drawable.progress_bar_center_border);
        this.mProgressRight = BitmapFactory.decodeResource(getResources(), R.drawable.progress_bar_right);
    }

    @Override // android.view.View
    protected void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        int r6 = r4 - r2;
        this.mTotalRect.set(0, 0, r6, r5 - r3);
        setUsedRight((int) (((double) r6) * this.mUsedPercent));
        this.mProgressBg.setBounds(this.mTotalRect);
    }

    @Override // android.view.View
    protected void onMeasure(int r1, int r2) {
        setMeasuredDimension(View.MeasureSpec.getSize(r1), this.mProgressBg.getIntrinsicHeight());
    }

    public void setUsedPercentage(double r3, boolean r5) {
        this.mUsedPercent = r3;
        setUsedRight((int) (((double) this.mTotalRect.width()) * this.mUsedPercent));
        if (r5 == false) goto L5;
        this.mProgressLeft = BitmapFactory.decodeResource(getResources(), R.drawable.progress_bar_full_left);
        this.mProgressMiddle = getResources().getDrawable(R.drawable.progress_bar_full_center);
        this.mProgressMiddleBorder = getResources().getDrawable(R.drawable.progress_bar_full_center_border);
        this.mProgressRight = BitmapFactory.decodeResource(getResources(), R.drawable.progress_bar_full_right);
    L6:
        invalidate();
        return;
    L5:
        this.mProgressLeft = BitmapFactory.decodeResource(getResources(), R.drawable.progress_bar_left);
        this.mProgressMiddle = getResources().getDrawable(R.drawable.progress_bar_center);
        this.mProgressMiddleBorder = getResources().getDrawable(R.drawable.progress_bar_center_border);
        this.mProgressRight = BitmapFactory.decodeResource(getResources(), R.drawable.progress_bar_right);
        goto L6
    }

    private void setUsedRight(int r3) {
        if (r3 != 0) goto L6;
        this.mUsedRect.set(0, 0, 0, this.mTotalRect.height());
        return;
    L6:
        if (r3 >= this.mTotalRect.width()) goto L8;
        this.mUsedRect.set(0, 0, r3, this.mTotalRect.height());
        return;
    L8:
        this.mUsedRect.set(0, 0, this.mTotalRect.width(), this.mTotalRect.height());
    }

    @Override // android.view.View
    protected void onDraw(Canvas r8) {
        this.mProgressBg.draw(r8);
        this.mFirstTempRect.setEmpty();
        this.mSecondTempRect.setEmpty();
        int r0 = this.mProgressLeft.getWidth();
        int r1 = this.mTotalRect.width() - this.mProgressRight.getWidth();
        int r2 = this.mTotalRect.height();
        if (this.mUsedRect.width() > r0) goto L6;
        Rect r3 = this.mFirstTempRect;
        r3.set(0, 0, this.mUsedRect.width(), r2);
        r8.drawBitmap(this.mProgressLeft, r3, r3, null);
        return;
    L6:
        if (this.mUsedRect.width() > r0) goto L8;
    L10:
        Rect r4 = this.mFirstTempRect;
        r4.set(0, 0, r0, r2);
        r8.drawBitmap(this.mProgressLeft, r4, r4, null);
        r4.left = r0;
        r4.right = r1;
        this.mProgressMiddle.setBounds(r4);
        this.mProgressMiddle.draw(r8);
        r4.left = r1;
        r4.right = this.mUsedRect.width();
        Rect r5 = this.mSecondTempRect;
        r5.set(0, 0, r4.width(), r2);
        r8.drawBitmap(this.mProgressRight, r5, r4, null);
        return;
    L8:
        if (this.mUsedRect.width() > r1) goto L10;
        Rect r6 = this.mFirstTempRect;
        r6.set(0, 0, r0, r2);
        r8.drawBitmap(this.mProgressLeft, r6, r6, null);
        r6.left = r0;
        r6.right = this.mUsedRect.width();
        this.mProgressMiddleBorder.setBounds(r6);
        this.mProgressMiddleBorder.draw(r8);
    }
}
