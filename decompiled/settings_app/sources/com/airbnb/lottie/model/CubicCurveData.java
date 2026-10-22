package com.airbnb.lottie.model;

import android.graphics.PointF;

/* JADX INFO: loaded from: classes.dex */
public class CubicCurveData {
    private final PointF controlPoint1;
    private final PointF controlPoint2;
    private final PointF vertex;

    public CubicCurveData() {
        this.controlPoint1 = new PointF();
        this.controlPoint2 = new PointF();
        this.vertex = new PointF();
    }

    public CubicCurveData(PointF r1, PointF r2, PointF r3) {
        this.controlPoint1 = r1;
        this.controlPoint2 = r2;
        this.vertex = r3;
    }

    public void setControlPoint1(float r1, float r2) {
        this.controlPoint1.set(r1, r2);
    }

    public PointF getControlPoint1() {
        return this.controlPoint1;
    }

    public void setControlPoint2(float r1, float r2) {
        this.controlPoint2.set(r1, r2);
    }

    public PointF getControlPoint2() {
        return this.controlPoint2;
    }

    public void setVertex(float r1, float r2) {
        this.vertex.set(r1, r2);
    }

    public PointF getVertex() {
        return this.vertex;
    }
}
