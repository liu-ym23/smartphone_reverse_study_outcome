package com.obric.common.oea.foundation.graphics.smoothcorner;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes4.dex */
public class SmoothCornerHelperJ {
    private final SmoothCornerHelper impl;

    public SmoothCornerHelperJ() {
        this.impl = new SmoothCornerHelper();
    }

    public void setCurveType(SmoothCornerHelper.Companion.CurveType r1, float r2) {
        this.impl.setCurveType(r1, r2);
    }

    public void setRectWidth(float r1) {
        this.impl.setRectWidth(r1);
    }

    public void setRectHeight(float r1) {
        this.impl.setRectHeight(r1);
    }

    public void updateRectSize(float r1, float r2) {
        this.impl.updateRectSize(r1, r2);
    }

    public void drawRoundRect(Canvas r1, Paint r2) {
        this.impl.drawRoundRect(r1, r2);
    }

    public void drawRoundRect(Canvas r1, RectF r2, Float r3, Paint r4) {
        this.impl.drawRoundRect(r1, r2, r3.floatValue(), r4);
    }

    public void drawRoundRect(Canvas r9, Paint r10, Float r11, Float r12, Float r13, Float r14, Float r15) {
        this.impl.drawRoundRect(r9, r10, r11.floatValue(), r12.floatValue(), r13.floatValue(), r14.floatValue(), r15.floatValue());
    }

    public Path buildPath(Rect r1, Float r2) {
        return this.impl.buildPath(r1, r2.floatValue());
    }

    public Path buildPath(float r7, float r8, float r9, float r10, float r11) {
        return this.impl.buildPath(r7, r8, r9, r10, r11);
    }

    public static int getDrawableRes(int r0) {
        return SmoothCornerHelper.getDrawableRes(r0);
    }

    public static int getHorizontalCapsuleDrawableRes(int r0) {
        return SmoothCornerHelper.getHorizontalCapsuleDrawableRes(r0);
    }

    public static void fillWithColor(Drawable r0, int r1) {
        SmoothCornerHelper.fillWithColor(r0, r1);
    }
}
