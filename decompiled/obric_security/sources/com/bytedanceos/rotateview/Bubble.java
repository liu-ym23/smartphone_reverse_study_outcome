package com.bytedanceos.rotateview;

import android.graphics.PointF;

/* JADX INFO: loaded from: classes2.dex */
public class Bubble implements Cloneable {
    private int mAlpha;
    private final BezierData mBezierData;
    private int mColor;
    private int mRadius;
    private float mX;
    private float mY;

    /* JADX INFO: renamed from: clone, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m124clone() throws CloneNotSupportedException {
        return clone();
    }

    public Bubble() {
        this.mBezierData = new BezierData();
    }

    public Bubble clone() {
        Bubble r0 = new Bubble();
        r0.mX = this.mX;
        r0.mY = this.mY;
        r0.mRadius = this.mRadius;
        r0.mColor = this.mColor;
        r0.mAlpha = this.mAlpha;
        r0.mBezierData.setControlPoints(this.mBezierData);
        return r0;
    }

    public Bubble setX(float x) {
        this.mX = x;
        return this;
    }

    public float getX() {
        return this.mX;
    }

    public Bubble setY(float y) {
        this.mY = y;
        return this;
    }

    public float getY() {
        return this.mY;
    }

    public Bubble setXY(float x, float y) {
        this.mX = x;
        this.mY = y;
        return this;
    }

    public Bubble setXY(PointF point) {
        return setXY(point.x, point.y);
    }

    public Bubble setRadius(int radius) {
        this.mRadius = radius;
        return this;
    }

    public int getRadius() {
        return this.mRadius;
    }

    public Bubble setColor(int color) {
        this.mColor = color;
        return this;
    }

    public int getColor() {
        return this.mColor;
    }

    public Bubble setAlpha(int alpha) {
        this.mAlpha = alpha;
        return this;
    }

    public int getAlpha() {
        return this.mAlpha;
    }

    public Bubble setControlPoints(BezierData source, float range) {
        this.mBezierData.clearControlPoints();
        int r0 = source.getControlPointsCount();
        int r1 = 1;
        if (r0 >= 1) goto L5;
        return this;
    L5:
        this.mBezierData.addControlPoint(source.getControlPoint(0));
    L6:
        if (r1 >= r0) goto L8;
        PointF r2 = source.getControlPoint(r1);
        float r3 = range / r1;
        this.mBezierData.addControlPoint(new PointF(RandomUtils.getRandomValue(r2.x, r3), RandomUtils.getRandomValue(r2.y, r3)));
        r1 = r1 + 1;
        goto L6
    L8:
        return this;
    }

    public void setLocation(float t) {
        setXY(this.mBezierData.getLocation(t));
    }
}
