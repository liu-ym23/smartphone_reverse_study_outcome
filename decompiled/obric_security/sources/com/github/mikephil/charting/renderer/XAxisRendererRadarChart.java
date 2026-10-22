package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import com.github.mikephil.charting.charts.RadarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.RadarData;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;

/* JADX INFO: loaded from: classes2.dex */
public class XAxisRendererRadarChart extends XAxisRenderer {
    private RadarChart mChart;

    @Override // com.github.mikephil.charting.renderer.XAxisRenderer, com.github.mikephil.charting.renderer.AxisRenderer
    public void renderLimitLines(Canvas r1) {
    }

    public XAxisRendererRadarChart(ViewPortHandler r2, XAxis r3, RadarChart r4) {
        super(r2, r3, null);
        this.mChart = r4;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.github.mikephil.charting.renderer.XAxisRenderer, com.github.mikephil.charting.renderer.AxisRenderer
    public void renderAxisLabels(Canvas r15) {
        if (this.mXAxis.isEnabled() == true) goto L5;
        return;
    L5:
        if (this.mXAxis.isDrawLabelsEnabled() == false) goto L15;
        float r0 = this.mXAxis.getLabelRotationAngle();
        MPPointF r8 = MPPointF.getInstance(0.5f, 0.25f);
        this.mAxisLabelPaint.setTypeface(this.mXAxis.getTypeface());
        this.mAxisLabelPaint.setTextSize(this.mXAxis.getTextSize());
        this.mAxisLabelPaint.setColor(this.mXAxis.getTextColor());
        float r9 = this.mChart.getSliceAngle();
        float r10 = this.mChart.getFactor();
        MPPointF r11 = this.mChart.getCenterOffsets();
        MPPointF r12 = MPPointF.getInstance(0.0f, 0.0f);
        int r13 = 0;
    L9:
        if (r13 >= ((RadarData) this.mChart.getData()).getMaxEntryCountSet().getEntryCount()) goto L11;
        float r2 = r13;
        String r3 = this.mXAxis.getValueFormatter().getAxisLabel(r2, this.mXAxis);
        Utils.getPosition(r11, (this.mChart.getYRange() * r10) + (this.mXAxis.mLabelRotatedWidth / 2.0f), ((r2 * r9) + this.mChart.getRotationAngle()) % 360.0f, r12);
        drawLabel(r15, r3, r12.x, r12.y - (this.mXAxis.mLabelRotatedHeight / 2.0f), r8, r0);
        r13 = r13 + 1;
        goto L9
    L11:
        MPPointF.recycleInstance(r11);
        MPPointF.recycleInstance(r12);
        MPPointF.recycleInstance(r8);
        return;
    }
}
