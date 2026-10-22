package com.github.mikephil.charting.data;

import android.graphics.Paint;
import com.github.mikephil.charting.interfaces.datasets.ICandleDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.github.mikephil.charting.utils.Utils;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class CandleDataSet extends LineScatterCandleRadarDataSet<CandleEntry> implements ICandleDataSet {
    private float mBarSpace;
    protected int mDecreasingColor;
    protected Paint.Style mDecreasingPaintStyle;
    protected int mIncreasingColor;
    protected Paint.Style mIncreasingPaintStyle;
    protected int mNeutralColor;
    protected int mShadowColor;
    private boolean mShadowColorSameAsCandle;
    private float mShadowWidth;
    private boolean mShowCandleBar;

    @Override // com.github.mikephil.charting.data.DataSet
    protected /* bridge */ /* synthetic */ void calcMinMax(Entry r1) {
        calcMinMax((CandleEntry) r1);
    }

    @Override // com.github.mikephil.charting.data.DataSet
    protected /* bridge */ /* synthetic */ void calcMinMaxY(Entry r1) {
        calcMinMaxY((CandleEntry) r1);
    }

    public CandleDataSet(List<CandleEntry> r1, String r2) {
        super(r1, r2);
        this.mShadowWidth = 3.0f;
        this.mShowCandleBar = true;
        this.mBarSpace = 0.1f;
        this.mShadowColorSameAsCandle = false;
        this.mIncreasingPaintStyle = Paint.Style.STROKE;
        this.mDecreasingPaintStyle = Paint.Style.FILL;
        this.mNeutralColor = ColorTemplate.COLOR_SKIP;
        this.mIncreasingColor = ColorTemplate.COLOR_SKIP;
        this.mDecreasingColor = ColorTemplate.COLOR_SKIP;
        this.mShadowColor = ColorTemplate.COLOR_SKIP;
    }

    @Override // com.github.mikephil.charting.data.DataSet
    public DataSet<CandleEntry> copy() {
        ArrayList r0 = new ArrayList();
        int r1 = 0;
    L4:
        if (r1 >= this.mValues.size()) goto L6;
        r0.add(((CandleEntry) this.mValues.get(r1)).copy());
        r1 = r1 + 1;
        goto L4
    L6:
        CandleDataSet r2 = new CandleDataSet(r0, getLabel());
        copy(r2);
        return r2;
    }

    protected void copy(CandleDataSet r2) {
        super.copy(r2);
        r2.mShadowWidth = this.mShadowWidth;
        r2.mShowCandleBar = this.mShowCandleBar;
        r2.mBarSpace = this.mBarSpace;
        r2.mShadowColorSameAsCandle = this.mShadowColorSameAsCandle;
        r2.mHighLightColor = this.mHighLightColor;
        r2.mIncreasingPaintStyle = this.mIncreasingPaintStyle;
        r2.mDecreasingPaintStyle = this.mDecreasingPaintStyle;
        r2.mNeutralColor = this.mNeutralColor;
        r2.mIncreasingColor = this.mIncreasingColor;
        r2.mDecreasingColor = this.mDecreasingColor;
        r2.mShadowColor = this.mShadowColor;
    }

    protected void calcMinMax(CandleEntry r3) {
        if (r3.getLow() >= this.mYMin) goto L6;
        this.mYMin = r3.getLow();
    L6:
        if (r3.getHigh() <= this.mYMax) goto L8;
        this.mYMax = r3.getHigh();
    L8:
        calcMinMaxX(r3);
    }

    protected void calcMinMaxY(CandleEntry r3) {
        if (r3.getHigh() >= this.mYMin) goto L6;
        this.mYMin = r3.getHigh();
    L6:
        if (r3.getHigh() <= this.mYMax) goto L9;
        this.mYMax = r3.getHigh();
    L9:
        if (r3.getLow() >= this.mYMin) goto L12;
        this.mYMin = r3.getLow();
    L12:
        if (r3.getLow() <= this.mYMax) goto L15;
        this.mYMax = r3.getLow();
        return;
    }

    public void setBarSpace(float r3) {
        if (r3 >= 0.0f) goto L6;
        r3 = 0.0f;
    L6:
        if (r3 <= 0.45f) goto L8;
        r3 = 0.45f;
    L8:
        this.mBarSpace = r3;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.ICandleDataSet
    public float getBarSpace() {
        return this.mBarSpace;
    }

    public void setShadowWidth(float r1) {
        this.mShadowWidth = Utils.convertDpToPixel(r1);
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.ICandleDataSet
    public float getShadowWidth() {
        return this.mShadowWidth;
    }

    public void setShowCandleBar(boolean r1) {
        this.mShowCandleBar = r1;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.ICandleDataSet
    public boolean getShowCandleBar() {
        return this.mShowCandleBar;
    }

    public void setNeutralColor(int r1) {
        this.mNeutralColor = r1;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.ICandleDataSet
    public int getNeutralColor() {
        return this.mNeutralColor;
    }

    public void setIncreasingColor(int r1) {
        this.mIncreasingColor = r1;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.ICandleDataSet
    public int getIncreasingColor() {
        return this.mIncreasingColor;
    }

    public void setDecreasingColor(int r1) {
        this.mDecreasingColor = r1;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.ICandleDataSet
    public int getDecreasingColor() {
        return this.mDecreasingColor;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.ICandleDataSet
    public Paint.Style getIncreasingPaintStyle() {
        return this.mIncreasingPaintStyle;
    }

    public void setIncreasingPaintStyle(Paint.Style r1) {
        this.mIncreasingPaintStyle = r1;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.ICandleDataSet
    public Paint.Style getDecreasingPaintStyle() {
        return this.mDecreasingPaintStyle;
    }

    public void setDecreasingPaintStyle(Paint.Style r1) {
        this.mDecreasingPaintStyle = r1;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.ICandleDataSet
    public int getShadowColor() {
        return this.mShadowColor;
    }

    public void setShadowColor(int r1) {
        this.mShadowColor = r1;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.ICandleDataSet
    public boolean getShadowColorSameAsCandle() {
        return this.mShadowColorSameAsCandle;
    }

    public void setShadowColorSameAsCandle(boolean r1) {
        this.mShadowColorSameAsCandle = r1;
    }
}
