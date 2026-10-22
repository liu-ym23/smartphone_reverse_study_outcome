package com.obric.oui.blur;

/* JADX INFO: loaded from: classes4.dex */
public final class BlurConfigCore {
    private float alpha;
    private float blurRadius;
    private int curveType;
    private int direction;
    private float endPoint;

    public BlurConfigCore() {
        this(0.0f, 0, 1.0f, 0, 1.0f);
    }

    public BlurConfigCore(float r7) {
        this(r7, 0, 1.0f, 0, 1.0f);
    }

    public BlurConfigCore(float r7, int r8) {
        this(r7, r8, 1.0f, 0, 1.0f);
    }

    public BlurConfigCore(float r7, int r8, float r9) {
        this(r7, r8, r9, 0, 1.0f);
    }

    public BlurConfigCore(float r7, int r8, float r9, int r10) {
        this(r7, r8, r9, r10, 1.0f);
    }

    public BlurConfigCore(float r1, int r2, float r3, int r4, float r5) {
        this.blurRadius = r1;
        this.direction = r2;
        this.alpha = r3;
        this.curveType = r4;
        this.endPoint = r5;
    }

    public float getBlurRadius() {
        return this.blurRadius;
    }

    public void setBlurRadius(float r1) {
        this.blurRadius = r1;
    }

    public int getDirection() {
        return this.direction;
    }

    public void setDirection(int r1) {
        this.direction = r1;
    }

    public float getAlpha() {
        return this.alpha;
    }

    public void setAlpha(float r1) {
        this.alpha = r1;
    }

    public int getCurveType() {
        return this.curveType;
    }

    public void setCurveType(int r1) {
        this.curveType = r1;
    }

    public float getEndPoint() {
        return this.endPoint;
    }

    public void setEndPoint(float r1) {
        this.endPoint = r1;
    }

    public BlurConfigCore deepCopy() {
        return deepCopy(this);
    }

    public static BlurConfigCore deepCopy(BlurConfigCore r7) {
        if (r7 != null) goto L6;
        return null;
    L6:
        return new BlurConfigCore(r7.blurRadius, r7.direction, r7.alpha, r7.curveType, r7.endPoint);
    }
}
