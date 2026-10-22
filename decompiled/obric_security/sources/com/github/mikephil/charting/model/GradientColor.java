package com.github.mikephil.charting.model;

/* JADX INFO: loaded from: classes2.dex */
public class GradientColor {
    private int endColor;
    private int startColor;

    public GradientColor(int r1, int r2) {
        this.startColor = r1;
        this.endColor = r2;
    }

    public int getStartColor() {
        return this.startColor;
    }

    public void setStartColor(int r1) {
        this.startColor = r1;
    }

    public int getEndColor() {
        return this.endColor;
    }

    public void setEndColor(int r1) {
        this.endColor = r1;
    }
}
