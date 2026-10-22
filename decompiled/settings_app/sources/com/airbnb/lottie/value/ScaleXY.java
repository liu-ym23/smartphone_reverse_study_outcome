package com.airbnb.lottie.value;

import com.obric.oui.material.MaterialConfigFormatNames;

/* JADX INFO: loaded from: classes.dex */
public class ScaleXY {
    private float scaleX;
    private float scaleY;

    public ScaleXY(float r1, float r2) {
        this.scaleX = r1;
        this.scaleY = r2;
    }

    public ScaleXY() {
        this(1.0f, 1.0f);
    }

    public float getScaleX() {
        return this.scaleX;
    }

    public float getScaleY() {
        return this.scaleY;
    }

    public void set(float r1, float r2) {
        this.scaleX = r1;
        this.scaleY = r2;
    }

    public boolean equals(float r2, float r3) {
        if (this.scaleX == r2) goto L5;
    L7:
        return false;
    L5:
        if (this.scaleY != r3) goto L7;
        return true;
    }

    public String toString() {
        return getScaleX() + MaterialConfigFormatNames.X + getScaleY();
    }
}
