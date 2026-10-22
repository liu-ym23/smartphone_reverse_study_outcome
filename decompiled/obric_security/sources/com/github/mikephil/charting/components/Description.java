package com.github.mikephil.charting.components;

import android.graphics.Paint;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Utils;

/* JADX INFO: loaded from: classes2.dex */
public class Description extends ComponentBase {
    private MPPointF mPosition;
    private Paint.Align mTextAlign;
    private String text;

    public Description() {
        this.text = "Description Label";
        this.mTextAlign = Paint.Align.RIGHT;
        this.mTextSize = Utils.convertDpToPixel(8.0f);
    }

    public void setText(String r1) {
        this.text = r1;
    }

    public String getText() {
        return this.text;
    }

    public void setPosition(float r2, float r3) {
        MPPointF r0 = this.mPosition;
        if (r0 != null) goto L5;
        this.mPosition = MPPointF.getInstance(r2, r3);
        return;
    L5:
        r0.x = r2;
        this.mPosition.y = r3;
    }

    public MPPointF getPosition() {
        return this.mPosition;
    }

    public void setTextAlign(Paint.Align r1) {
        this.mTextAlign = r1;
    }

    public Paint.Align getTextAlign() {
        return this.mTextAlign;
    }
}
