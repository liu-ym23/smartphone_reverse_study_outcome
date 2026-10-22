package com.github.mikephil.charting.highlight;

import com.github.mikephil.charting.components.YAxis;

/* JADX INFO: loaded from: classes2.dex */
public class Highlight {
    private YAxis.AxisDependency axis;
    private int mDataIndex;
    private int mDataSetIndex;
    private float mDrawX;
    private float mDrawY;
    private int mStackIndex;
    private float mX;
    private float mXPx;
    private float mY;
    private float mYPx;

    public Highlight(float r2, float r3, int r4) {
        this.mDataIndex = -1;
        this.mStackIndex = -1;
        this.mX = r2;
        this.mY = r3;
        this.mDataSetIndex = r4;
    }

    public Highlight(float r2, int r3, int r4) {
        this(r2, Float.NaN, r3);
        this.mStackIndex = r4;
    }

    public Highlight(float r2, float r3, float r4, float r5, int r6, YAxis.AxisDependency r7) {
        this.mDataIndex = -1;
        this.mStackIndex = -1;
        this.mX = r2;
        this.mY = r3;
        this.mXPx = r4;
        this.mYPx = r5;
        this.mDataSetIndex = r6;
        this.axis = r7;
    }

    public Highlight(float r8, float r9, float r10, float r11, int r12, int r13, YAxis.AxisDependency r14) {
        this(r8, r9, r10, r11, r12, r14);
        this.mStackIndex = r13;
    }

    public float getX() {
        return this.mX;
    }

    public float getY() {
        return this.mY;
    }

    public float getXPx() {
        return this.mXPx;
    }

    public float getYPx() {
        return this.mYPx;
    }

    public int getDataIndex() {
        return this.mDataIndex;
    }

    public void setDataIndex(int r1) {
        this.mDataIndex = r1;
    }

    public int getDataSetIndex() {
        return this.mDataSetIndex;
    }

    public int getStackIndex() {
        return this.mStackIndex;
    }

    public boolean isStacked() {
        if (this.mStackIndex < 0) goto L5;
        return true;
    L5:
        return false;
    }

    public YAxis.AxisDependency getAxis() {
        return this.axis;
    }

    public void setDraw(float r1, float r2) {
        this.mDrawX = r1;
        this.mDrawY = r2;
    }

    public float getDrawX() {
        return this.mDrawX;
    }

    public float getDrawY() {
        return this.mDrawY;
    }

    public boolean equalTo(Highlight r4) {
        if (r4 != null) goto L6;
        return false;
    L6:
        if (this.mDataSetIndex == r4.mDataSetIndex) goto L8;
    L15:
        return false;
    L8:
        if (this.mX != r4.mX) goto L15;
        if (this.mStackIndex != r4.mStackIndex) goto L15;
        if (this.mDataIndex != r4.mDataIndex) goto L15;
        return true;
    }

    public String toString() {
        return "Highlight, x: " + this.mX + ", y: " + this.mY + ", dataSetIndex: " + this.mDataSetIndex + ", stackIndex (only stacked barentry): " + this.mStackIndex;
    }
}
