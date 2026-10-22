package com.github.mikephil.charting.charts;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BubbleData;
import com.github.mikephil.charting.data.CandleData;
import com.github.mikephil.charting.data.ChartData;
import com.github.mikephil.charting.data.CombinedData;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.ScatterData;
import com.github.mikephil.charting.highlight.CombinedHighlighter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.dataprovider.CombinedDataProvider;
import com.github.mikephil.charting.interfaces.datasets.IBarLineScatterCandleBubbleDataSet;
import com.github.mikephil.charting.renderer.CombinedChartRenderer;

/* JADX INFO: loaded from: classes2.dex */
public class CombinedChart extends BarLineChartBase<CombinedData> implements CombinedDataProvider {
    private boolean mDrawBarShadow;
    protected DrawOrder[] mDrawOrder;
    private boolean mDrawValueAboveBar;
    protected boolean mHighlightFullBarEnabled;

    public static final enum DrawOrder extends Enum<DrawOrder> {
        private static final /* synthetic */ DrawOrder[] $VALUES = null;
        public static final DrawOrder BAR = null;
        public static final DrawOrder BUBBLE = null;
        public static final DrawOrder CANDLE = null;
        public static final DrawOrder LINE = null;
        public static final DrawOrder SCATTER = null;

        private DrawOrder(String r1, int r2) {
            super(r1, r2);
        }

        public static DrawOrder valueOf(String r1) {
            return (DrawOrder) Enum.valueOf(DrawOrder.class, r1);
        }

        public static DrawOrder[] values() {
            return (DrawOrder[]) $VALUES.clone();
        }

        static {
            DrawOrder r0 = new DrawOrder("BAR", 0);
            BAR = r0;
            DrawOrder r1 = new DrawOrder("BUBBLE", 1);
            BUBBLE = r1;
            DrawOrder r3 = new DrawOrder("LINE", 2);
            LINE = r3;
            DrawOrder r5 = new DrawOrder("CANDLE", 3);
            CANDLE = r5;
            DrawOrder r7 = new DrawOrder("SCATTER", 4);
            SCATTER = r7;
            $VALUES = new DrawOrder[]{r0, r1, r3, r5, r7};
        }
    }

    @Override // com.github.mikephil.charting.charts.Chart
    public /* bridge */ /* synthetic */ void setData(ChartData r1) {
        setData((CombinedData) r1);
    }

    public CombinedChart(Context r1) {
        super(r1);
        this.mDrawValueAboveBar = true;
        this.mHighlightFullBarEnabled = false;
        this.mDrawBarShadow = false;
    }

    public CombinedChart(Context r1, AttributeSet r2) {
        super(r1, r2);
        this.mDrawValueAboveBar = true;
        this.mHighlightFullBarEnabled = false;
        this.mDrawBarShadow = false;
    }

    public CombinedChart(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        this.mDrawValueAboveBar = true;
        this.mHighlightFullBarEnabled = false;
        this.mDrawBarShadow = false;
    }

    @Override // com.github.mikephil.charting.charts.BarLineChartBase, com.github.mikephil.charting.charts.Chart
    protected void init() {
        super.init();
        this.mDrawOrder = new DrawOrder[]{DrawOrder.BAR, DrawOrder.BUBBLE, DrawOrder.LINE, DrawOrder.CANDLE, DrawOrder.SCATTER};
        setHighlighter(new CombinedHighlighter(this, this));
        setHighlightFullBarEnabled(true);
        this.mRenderer = new CombinedChartRenderer(this, this.mAnimator, this.mViewPortHandler);
    }

    @Override // com.github.mikephil.charting.interfaces.dataprovider.CombinedDataProvider
    public CombinedData getCombinedData() {
        return (CombinedData) this.mData;
    }

    public void setData(CombinedData r1) {
        super.setData(r1);
        setHighlighter(new CombinedHighlighter(this, this));
        ((CombinedChartRenderer) this.mRenderer).createRenderers();
        this.mRenderer.initBuffers();
    }

    @Override // com.github.mikephil.charting.charts.Chart
    public Highlight getHighlightByTouchPoint(float r9, float r10) {
        if (this.mData != 0) goto L6;
        Log.e(Chart.LOG_TAG, "Can't select by touch. No data set.");
        return null;
    L6:
        Highlight r11 = getHighlighter().getHighlight(r9, r10);
        if (r11 != null) goto L9;
    L13:
        return r11;
    L9:
        if (isHighlightFullBarEnabled() == false) goto L13;
        return new Highlight(r11.getX(), r11.getY(), r11.getXPx(), r11.getYPx(), r11.getDataSetIndex(), -1, r11.getAxis());
    }

    @Override // com.github.mikephil.charting.interfaces.dataprovider.LineDataProvider
    public LineData getLineData() {
        if (this.mData != 0) goto L7;
        return null;
    L7:
        return ((CombinedData) this.mData).getLineData();
    }

    @Override // com.github.mikephil.charting.interfaces.dataprovider.BarDataProvider
    public BarData getBarData() {
        if (this.mData != 0) goto L7;
        return null;
    L7:
        return ((CombinedData) this.mData).getBarData();
    }

    @Override // com.github.mikephil.charting.interfaces.dataprovider.ScatterDataProvider
    public ScatterData getScatterData() {
        if (this.mData != 0) goto L7;
        return null;
    L7:
        return ((CombinedData) this.mData).getScatterData();
    }

    @Override // com.github.mikephil.charting.interfaces.dataprovider.CandleDataProvider
    public CandleData getCandleData() {
        if (this.mData != 0) goto L7;
        return null;
    L7:
        return ((CombinedData) this.mData).getCandleData();
    }

    @Override // com.github.mikephil.charting.interfaces.dataprovider.BubbleDataProvider
    public BubbleData getBubbleData() {
        if (this.mData != 0) goto L7;
        return null;
    L7:
        return ((CombinedData) this.mData).getBubbleData();
    }

    @Override // com.github.mikephil.charting.interfaces.dataprovider.BarDataProvider
    public boolean isDrawBarShadowEnabled() {
        return this.mDrawBarShadow;
    }

    @Override // com.github.mikephil.charting.interfaces.dataprovider.BarDataProvider
    public boolean isDrawValueAboveBarEnabled() {
        return this.mDrawValueAboveBar;
    }

    public void setDrawValueAboveBar(boolean r1) {
        this.mDrawValueAboveBar = r1;
    }

    public void setDrawBarShadow(boolean r1) {
        this.mDrawBarShadow = r1;
    }

    public void setHighlightFullBarEnabled(boolean r1) {
        this.mHighlightFullBarEnabled = r1;
    }

    @Override // com.github.mikephil.charting.interfaces.dataprovider.BarDataProvider
    public boolean isHighlightFullBarEnabled() {
        return this.mHighlightFullBarEnabled;
    }

    public DrawOrder[] getDrawOrder() {
        return this.mDrawOrder;
    }

    public void setDrawOrder(DrawOrder[] r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        if (r2.length <= 0) goto L9;
        this.mDrawOrder = r2;
        return;
    }

    @Override // com.github.mikephil.charting.charts.Chart
    protected void drawMarkers(Canvas r10) {
        if (this.mMarker != null) goto L5;
        return;
    L5:
        if (isDrawMarkersEnabled() == true) goto L7;
        return;
    L7:
        if (valuesToHighlight() == false) goto L30;
        int r1 = 0;
    L11:
        if (r1 >= this.mIndicesToHighlight.length) goto L31;
        Highlight r2 = this.mIndicesToHighlight[r1];
        IBarLineScatterCandleBubbleDataSet<? extends Entry> r3 = ((CombinedData) this.mData).getDataSetByHighlight(r2);
        Entry r4 = ((CombinedData) this.mData).getEntryForHighlight(r2);
        if (r4 == null) goto L22;
        if (r3.getEntryIndex(r4) > (r3.getEntryCount() * this.mAnimator.getPhaseX())) goto L22;
        float[] r5 = getMarkerPosition(r2);
        if (this.mViewPortHandler.isInBounds(r5[0], r5[1]) == false) goto L22;
        this.mMarker.refreshContent(r4, r2);
        this.mMarker.draw(r10, r5[0], r5[1]);
    L22:
        r1 = r1 + 1;
        goto L11
    L31:
        return;
    }
}
