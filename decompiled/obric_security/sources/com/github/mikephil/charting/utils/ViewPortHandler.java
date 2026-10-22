package com.github.mikephil.charting.utils;

import android.graphics.Matrix;
import android.graphics.RectF;
import android.view.View;

/* JADX INFO: loaded from: classes2.dex */
public class ViewPortHandler {
    protected Matrix mCenterViewPortMatrixBuffer;
    protected float mChartHeight;
    protected float mChartWidth;
    protected RectF mContentRect;
    protected final Matrix mMatrixTouch;
    private float mMaxScaleX;
    private float mMaxScaleY;
    private float mMinScaleX;
    private float mMinScaleY;
    private float mScaleX;
    private float mScaleY;
    private float mTransOffsetX;
    private float mTransOffsetY;
    private float mTransX;
    private float mTransY;
    protected final float[] matrixBuffer;
    protected float[] valsBufferForFitScreen;

    public ViewPortHandler() {
        this.mMatrixTouch = new Matrix();
        this.mContentRect = new RectF();
        this.mChartWidth = 0.0f;
        this.mChartHeight = 0.0f;
        this.mMinScaleY = 1.0f;
        this.mMaxScaleY = Float.MAX_VALUE;
        this.mMinScaleX = 1.0f;
        this.mMaxScaleX = Float.MAX_VALUE;
        this.mScaleX = 1.0f;
        this.mScaleY = 1.0f;
        this.mTransX = 0.0f;
        this.mTransY = 0.0f;
        this.mTransOffsetX = 0.0f;
        this.mTransOffsetY = 0.0f;
        this.valsBufferForFitScreen = new float[9];
        this.mCenterViewPortMatrixBuffer = new Matrix();
        this.matrixBuffer = new float[9];
    }

    public void setChartDimens(float r5, float r6) {
        float r0 = offsetLeft();
        float r1 = offsetTop();
        float r2 = offsetRight();
        float r3 = offsetBottom();
        this.mChartHeight = r6;
        this.mChartWidth = r5;
        restrainViewPort(r0, r1, r2, r3);
    }

    public boolean hasChartDimens() {
        if (this.mChartHeight > 0.0f) goto L5;
        return false;
    L5:
        if (this.mChartWidth <= 0.0f) goto L10;
        return true;
    L10:
        return false;
    }

    public void restrainViewPort(float r3, float r4, float r5, float r6) {
        this.mContentRect.set(r3, r4, this.mChartWidth - r5, this.mChartHeight - r6);
    }

    public float offsetLeft() {
        return this.mContentRect.left;
    }

    public float offsetRight() {
        return this.mChartWidth - this.mContentRect.right;
    }

    public float offsetTop() {
        return this.mContentRect.top;
    }

    public float offsetBottom() {
        return this.mChartHeight - this.mContentRect.bottom;
    }

    public float contentTop() {
        return this.mContentRect.top;
    }

    public float contentLeft() {
        return this.mContentRect.left;
    }

    public float contentRight() {
        return this.mContentRect.right;
    }

    public float contentBottom() {
        return this.mContentRect.bottom;
    }

    public float contentWidth() {
        return this.mContentRect.width();
    }

    public float contentHeight() {
        return this.mContentRect.height();
    }

    public RectF getContentRect() {
        return this.mContentRect;
    }

    public MPPointF getContentCenter() {
        return MPPointF.getInstance(this.mContentRect.centerX(), this.mContentRect.centerY());
    }

    public float getChartHeight() {
        return this.mChartHeight;
    }

    public float getChartWidth() {
        return this.mChartWidth;
    }

    public float getSmallestContentExtension() {
        return Math.min(this.mContentRect.width(), this.mContentRect.height());
    }

    public Matrix zoomIn(float r2, float r3) {
        Matrix r0 = new Matrix();
        zoomIn(r2, r3, r0);
        return r0;
    }

    public void zoomIn(float r1, float r2, Matrix r3) {
        r3.reset();
        r3.set(this.mMatrixTouch);
        r3.postScale(1.4f, 1.4f, r1, r2);
    }

    public Matrix zoomOut(float r2, float r3) {
        Matrix r0 = new Matrix();
        zoomOut(r2, r3, r0);
        return r0;
    }

    public void zoomOut(float r1, float r2, Matrix r3) {
        r3.reset();
        r3.set(this.mMatrixTouch);
        r3.postScale(0.7f, 0.7f, r1, r2);
    }

    public void resetZoom(Matrix r2) {
        r2.reset();
        r2.set(this.mMatrixTouch);
        r2.postScale(1.0f, 1.0f, 0.0f, 0.0f);
    }

    public Matrix zoom(float r2, float r3) {
        Matrix r0 = new Matrix();
        zoom(r2, r3, r0);
        return r0;
    }

    public void zoom(float r1, float r2, Matrix r3) {
        r3.reset();
        r3.set(this.mMatrixTouch);
        r3.postScale(r1, r2);
    }

    public Matrix zoom(float r8, float r9, float r10, float r11) {
        Matrix r6 = new Matrix();
        zoom(r8, r9, r10, r11, r6);
        return r6;
    }

    public void zoom(float r1, float r2, float r3, float r4, Matrix r5) {
        r5.reset();
        r5.set(this.mMatrixTouch);
        r5.postScale(r1, r2, r3, r4);
    }

    public Matrix setZoom(float r2, float r3) {
        Matrix r0 = new Matrix();
        setZoom(r2, r3, r0);
        return r0;
    }

    public void setZoom(float r1, float r2, Matrix r3) {
        r3.reset();
        r3.set(this.mMatrixTouch);
        r3.setScale(r1, r2);
    }

    public Matrix setZoom(float r2, float r3, float r4, float r5) {
        Matrix r0 = new Matrix();
        r0.set(this.mMatrixTouch);
        r0.setScale(r2, r3, r4, r5);
        return r0;
    }

    public Matrix fitScreen() {
        Matrix r0 = new Matrix();
        fitScreen(r0);
        return r0;
    }

    public void fitScreen(Matrix r6) {
        this.mMinScaleX = 1.0f;
        this.mMinScaleY = 1.0f;
        r6.set(this.mMatrixTouch);
        float[] r5 = this.valsBufferForFitScreen;
        int r2 = 0;
    L4:
        if (r2 >= 9) goto L6;
        r5[r2] = 0.0f;
        r2 = r2 + 1;
        goto L4
    L6:
        r6.getValues(r5);
        r5[2] = 0.0f;
        r5[5] = 0.0f;
        r5[0] = 1.0f;
        r5[4] = 1.0f;
        r6.setValues(r5);
    }

    public Matrix translate(float[] r2) {
        Matrix r0 = new Matrix();
        translate(r2, r0);
        return r0;
    }

    public void translate(float[] r3, Matrix r4) {
        r4.reset();
        r4.set(this.mMatrixTouch);
        float r0 = r3[0] - offsetLeft();
        float r5 = r3[1] - offsetTop();
        r4.postTranslate(-r0, -r5);
    }

    public void centerViewPort(float[] r5, View r6) {
        Matrix r0 = this.mCenterViewPortMatrixBuffer;
        r0.reset();
        r0.set(this.mMatrixTouch);
        float r1 = r5[0] - offsetLeft();
        r0.postTranslate(-r1, -(r5[1] - offsetTop()));
        refresh(r0, r6, true);
    }

    public Matrix refresh(Matrix r3, View r4, boolean r5) {
        this.mMatrixTouch.set(r3);
        limitTransAndScale(this.mMatrixTouch, this.mContentRect);
        if (r5 == false) goto L5;
        r4.invalidate();
    L5:
        r3.set(this.mMatrixTouch);
        return r3;
    }

    public void limitTransAndScale(Matrix r10, RectF r11) {
        r10.getValues(this.matrixBuffer);
        float[] r0 = this.matrixBuffer;
        float r2 = r0[2];
        float r4 = r0[0];
        float r6 = r0[5];
        float r1 = r0[4];
        this.mScaleX = Math.min(Math.max(this.mMinScaleX, r4), this.mMaxScaleX);
        this.mScaleY = Math.min(Math.max(this.mMinScaleY, r1), this.mMaxScaleY);
        if (r11 == null) goto L5;
        float r3 = r11.width();
        float r12 = r11.height();
    L6:
        this.mTransX = Math.min(Math.max(r2, ((-r3) * (this.mScaleX - 1.0f)) - this.mTransOffsetX), this.mTransOffsetX);
        float r13 = Math.max(Math.min(r6, (r12 * (this.mScaleY - 1.0f)) + this.mTransOffsetY), -this.mTransOffsetY);
        this.mTransY = r13;
        float[] r5 = this.matrixBuffer;
        r5[2] = this.mTransX;
        r5[0] = this.mScaleX;
        r5[5] = r13;
        r5[4] = this.mScaleY;
        r10.setValues(r5);
        return;
    L5:
        r3 = 0.0f;
        r12 = 0.0f;
        goto L6
    }

    public void setMinimumScaleX(float r3) {
        if (r3 >= 1.0f) goto L5;
        r3 = 1.0f;
    L5:
        this.mMinScaleX = r3;
        limitTransAndScale(this.mMatrixTouch, this.mContentRect);
    }

    public void setMaximumScaleX(float r2) {
        if (r2 != 0.0f) goto L5;
        r2 = Float.MAX_VALUE;
    L5:
        this.mMaxScaleX = r2;
        limitTransAndScale(this.mMatrixTouch, this.mContentRect);
    }

    public void setMinMaxScaleX(float r3, float r4) {
        if (r3 >= 1.0f) goto L6;
        r3 = 1.0f;
    L6:
        if (r4 != 0.0f) goto L8;
        r4 = Float.MAX_VALUE;
    L8:
        this.mMinScaleX = r3;
        this.mMaxScaleX = r4;
        limitTransAndScale(this.mMatrixTouch, this.mContentRect);
    }

    public void setMinimumScaleY(float r3) {
        if (r3 >= 1.0f) goto L5;
        r3 = 1.0f;
    L5:
        this.mMinScaleY = r3;
        limitTransAndScale(this.mMatrixTouch, this.mContentRect);
    }

    public void setMaximumScaleY(float r2) {
        if (r2 != 0.0f) goto L5;
        r2 = Float.MAX_VALUE;
    L5:
        this.mMaxScaleY = r2;
        limitTransAndScale(this.mMatrixTouch, this.mContentRect);
    }

    public void setMinMaxScaleY(float r3, float r4) {
        if (r3 >= 1.0f) goto L6;
        r3 = 1.0f;
    L6:
        if (r4 != 0.0f) goto L8;
        r4 = Float.MAX_VALUE;
    L8:
        this.mMinScaleY = r3;
        this.mMaxScaleY = r4;
        limitTransAndScale(this.mMatrixTouch, this.mContentRect);
    }

    public Matrix getMatrixTouch() {
        return this.mMatrixTouch;
    }

    public boolean isInBoundsX(float r2) {
        if (isInBoundsLeft(r2) == true) goto L5;
    L7:
        return false;
    L5:
        if (isInBoundsRight(r2) == false) goto L7;
        return true;
    }

    public boolean isInBoundsY(float r2) {
        if (isInBoundsTop(r2) == true) goto L5;
    L7:
        return false;
    L5:
        if (isInBoundsBottom(r2) == false) goto L7;
        return true;
    }

    public boolean isInBounds(float r1, float r2) {
        if (isInBoundsX(r1) == true) goto L5;
    L7:
        return false;
    L5:
        if (isInBoundsY(r2) == false) goto L7;
        return true;
    }

    public boolean isInBoundsLeft(float r2) {
        if (this.mContentRect.left > (r2 + 1.0f)) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isInBoundsRight(float r2) {
        if (this.mContentRect.right < ((((int) (r2 * 100.0f)) / 100.0f) - 1.0f)) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isInBoundsTop(float r1) {
        if (this.mContentRect.top > r1) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isInBoundsBottom(float r2) {
        if (this.mContentRect.bottom < (((int) (r2 * 100.0f)) / 100.0f)) goto L5;
        return true;
    L5:
        return false;
    }

    public float getScaleX() {
        return this.mScaleX;
    }

    public float getScaleY() {
        return this.mScaleY;
    }

    public float getMinScaleX() {
        return this.mMinScaleX;
    }

    public float getMaxScaleX() {
        return this.mMaxScaleX;
    }

    public float getMinScaleY() {
        return this.mMinScaleY;
    }

    public float getMaxScaleY() {
        return this.mMaxScaleY;
    }

    public float getTransX() {
        return this.mTransX;
    }

    public float getTransY() {
        return this.mTransY;
    }

    public boolean isFullyZoomedOut() {
        if (isFullyZoomedOutX() == true) goto L5;
    L7:
        return false;
    L5:
        if (isFullyZoomedOutY() == false) goto L7;
        return true;
    }

    public boolean isFullyZoomedOutY() {
        float r0 = this.mScaleY;
        float r1 = this.mMinScaleY;
        if (r0 <= r1) goto L5;
    L7:
        return false;
    L5:
        if (r1 > 1.0f) goto L7;
        return true;
    }

    public boolean isFullyZoomedOutX() {
        float r0 = this.mScaleX;
        float r1 = this.mMinScaleX;
        if (r0 <= r1) goto L5;
    L7:
        return false;
    L5:
        if (r1 > 1.0f) goto L7;
        return true;
    }

    public void setDragOffsetX(float r1) {
        this.mTransOffsetX = Utils.convertDpToPixel(r1);
    }

    public void setDragOffsetY(float r1) {
        this.mTransOffsetY = Utils.convertDpToPixel(r1);
    }

    public boolean hasNoDragOffset() {
        if (this.mTransOffsetX <= 0.0f) goto L5;
    L7:
        return false;
    L5:
        if (this.mTransOffsetY > 0.0f) goto L7;
        return true;
    }

    public boolean canZoomOutMoreX() {
        if (this.mScaleX <= this.mMinScaleX) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean canZoomInMoreX() {
        if (this.mScaleX >= this.mMaxScaleX) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean canZoomOutMoreY() {
        if (this.mScaleY <= this.mMinScaleY) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean canZoomInMoreY() {
        if (this.mScaleY >= this.mMaxScaleY) goto L5;
        return true;
    L5:
        return false;
    }
}
