package com.github.mikephil.charting.data;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.interfaces.datasets.ILineRadarDataSet;
import com.github.mikephil.charting.utils.Utils;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public abstract class LineRadarDataSet<T extends Entry> extends LineScatterCandleRadarDataSet<T> implements ILineRadarDataSet<T> {
    private boolean mDrawFilled;
    private int mFillAlpha;
    private int mFillColor;
    protected Drawable mFillDrawable;
    private float mLineWidth;

    public LineRadarDataSet(List<T> r2, String r3) {
        super(r2, r3);
        this.mFillColor = Color.rgb(140, 234, 255);
        this.mFillAlpha = 85;
        this.mLineWidth = 2.5f;
        this.mDrawFilled = false;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.ILineRadarDataSet
    public int getFillColor() {
        return this.mFillColor;
    }

    public void setFillColor(int r1) {
        this.mFillColor = r1;
        this.mFillDrawable = null;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.ILineRadarDataSet
    public Drawable getFillDrawable() {
        return this.mFillDrawable;
    }

    public void setFillDrawable(Drawable r1) {
        this.mFillDrawable = r1;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.ILineRadarDataSet
    public int getFillAlpha() {
        return this.mFillAlpha;
    }

    public void setFillAlpha(int r1) {
        this.mFillAlpha = r1;
    }

    public void setLineWidth(float r3) {
        if (r3 >= 0.0f) goto L6;
        r3 = 0.0f;
    L6:
        if (r3 <= 10.0f) goto L8;
        r3 = 10.0f;
    L8:
        this.mLineWidth = Utils.convertDpToPixel(r3);
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.ILineRadarDataSet
    public float getLineWidth() {
        return this.mLineWidth;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.ILineRadarDataSet
    public void setDrawFilled(boolean r1) {
        this.mDrawFilled = r1;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.ILineRadarDataSet
    public boolean isDrawFilledEnabled() {
        return this.mDrawFilled;
    }

    protected void copy(LineRadarDataSet r2) {
        super.copy(r2);
        r2.mDrawFilled = this.mDrawFilled;
        r2.mFillAlpha = this.mFillAlpha;
        r2.mFillColor = this.mFillColor;
        r2.mFillDrawable = this.mFillDrawable;
        r2.mLineWidth = this.mLineWidth;
    }
}
