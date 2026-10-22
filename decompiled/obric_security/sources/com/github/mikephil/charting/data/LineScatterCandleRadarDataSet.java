package com.github.mikephil.charting.data;

import android.graphics.DashPathEffect;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.interfaces.datasets.ILineScatterCandleRadarDataSet;
import com.github.mikephil.charting.utils.Utils;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public abstract class LineScatterCandleRadarDataSet<T extends Entry> extends BarLineScatterCandleBubbleDataSet<T> implements ILineScatterCandleRadarDataSet<T> {
    protected boolean mDrawHorizontalHighlightIndicator;
    protected boolean mDrawVerticalHighlightIndicator;
    protected DashPathEffect mHighlightDashPathEffect;
    protected float mHighlightLineWidth;

    public LineScatterCandleRadarDataSet(List<T> r1, String r2) {
        super(r1, r2);
        this.mDrawVerticalHighlightIndicator = true;
        this.mDrawHorizontalHighlightIndicator = true;
        this.mHighlightLineWidth = 0.5f;
        this.mHighlightDashPathEffect = null;
        this.mHighlightLineWidth = Utils.convertDpToPixel(0.5f);
    }

    public void setDrawHorizontalHighlightIndicator(boolean r1) {
        this.mDrawHorizontalHighlightIndicator = r1;
    }

    public void setDrawVerticalHighlightIndicator(boolean r1) {
        this.mDrawVerticalHighlightIndicator = r1;
    }

    public void setDrawHighlightIndicators(boolean r1) {
        setDrawVerticalHighlightIndicator(r1);
        setDrawHorizontalHighlightIndicator(r1);
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.ILineScatterCandleRadarDataSet
    public boolean isVerticalHighlightIndicatorEnabled() {
        return this.mDrawVerticalHighlightIndicator;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.ILineScatterCandleRadarDataSet
    public boolean isHorizontalHighlightIndicatorEnabled() {
        return this.mDrawHorizontalHighlightIndicator;
    }

    public void setHighlightLineWidth(float r1) {
        this.mHighlightLineWidth = Utils.convertDpToPixel(r1);
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.ILineScatterCandleRadarDataSet
    public float getHighlightLineWidth() {
        return this.mHighlightLineWidth;
    }

    public void enableDashedHighlightLine(float r4, float r5, float r6) {
        this.mHighlightDashPathEffect = new DashPathEffect(new float[]{r4, r5}, r6);
    }

    public void disableDashedHighlightLine() {
        this.mHighlightDashPathEffect = null;
    }

    public boolean isDashedHighlightLineEnabled() {
        if (this.mHighlightDashPathEffect != null) goto L5;
        return false;
    L5:
        return true;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.ILineScatterCandleRadarDataSet
    public DashPathEffect getDashPathEffectHighlight() {
        return this.mHighlightDashPathEffect;
    }

    protected void copy(LineScatterCandleRadarDataSet r2) {
        super.copy(r2);
        r2.mDrawHorizontalHighlightIndicator = this.mDrawHorizontalHighlightIndicator;
        r2.mDrawVerticalHighlightIndicator = this.mDrawVerticalHighlightIndicator;
        r2.mHighlightLineWidth = this.mHighlightLineWidth;
        r2.mHighlightDashPathEffect = this.mHighlightDashPathEffect;
    }
}
