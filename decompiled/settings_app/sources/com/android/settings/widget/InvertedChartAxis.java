package com.android.settings.widget;

import android.content.res.Resources;
import android.text.SpannableStringBuilder;

/* JADX INFO: loaded from: classes.dex */
public class InvertedChartAxis implements ChartAxis {
    private float mSize;
    private final ChartAxis mWrapped;

    public InvertedChartAxis(ChartAxis r1) {
        this.mWrapped = r1;
    }

    @Override // com.android.settings.widget.ChartAxis
    public boolean setBounds(long r1, long r3) {
        return this.mWrapped.setBounds(r1, r3);
    }

    @Override // com.android.settings.widget.ChartAxis
    public boolean setSize(float r1) {
        this.mSize = r1;
        return this.mWrapped.setSize(r1);
    }

    @Override // com.android.settings.widget.ChartAxis
    public float convertToPoint(long r2) {
        return this.mSize - this.mWrapped.convertToPoint(r2);
    }

    @Override // com.android.settings.widget.ChartAxis
    public long convertToValue(float r2) {
        return this.mWrapped.convertToValue(this.mSize - r2);
    }

    @Override // com.android.settings.widget.ChartAxis
    public long buildLabel(Resources r1, SpannableStringBuilder r2, long r3) {
        return this.mWrapped.buildLabel(r1, r2, r3);
    }

    @Override // com.android.settings.widget.ChartAxis
    public float[] getTickPoints() {
        float[] r0 = this.mWrapped.getTickPoints();
        int r1 = 0;
    L4:
        if (r1 >= r0.length) goto L6;
        r0[r1] = this.mSize - r0[r1];
        r1 = r1 + 1;
        goto L4
    L6:
        return r0;
    }

    @Override // com.android.settings.widget.ChartAxis
    public int shouldAdjustAxis(long r1) {
        return this.mWrapped.shouldAdjustAxis(r1);
    }
}
