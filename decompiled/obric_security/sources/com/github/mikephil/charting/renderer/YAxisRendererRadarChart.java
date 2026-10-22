package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import android.graphics.Path;
import com.github.mikephil.charting.charts.RadarChart;
import com.github.mikephil.charting.components.LimitLine;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.RadarData;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class YAxisRendererRadarChart extends YAxisRenderer {
    private RadarChart mChart;
    private Path mRenderLimitLinesPathBuffer;

    public YAxisRendererRadarChart(ViewPortHandler r2, YAxis r3, RadarChart r4) {
        super(r2, r3, null);
        this.mRenderLimitLinesPathBuffer = new Path();
        this.mChart = r4;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v18 */
    /* JADX WARN: Type inference failed for: r5v2, types: [int] */
    /* JADX WARN: Type inference failed for: r5v7 */
    /* JADX WARN: Type inference failed for: r5v8 */
    @Override // com.github.mikephil.charting.renderer.AxisRenderer
    protected void computeAxisValues(float r16, float r17) {
        float r1 = r16;
        int r3 = this.mAxis.getLabelCount();
        double r4 = Math.abs(r17 - r1);
        if (r3 != 0) goto L5;
    L63:
        this.mAxis.mEntries = new float[0];
        this.mAxis.mCenteredEntries = new float[0];
        this.mAxis.mEntryCount = 0;
        return;
    L5:
        if (r4 <= 0.0d) goto L63;
        if (Double.isInfinite(r4) == true) goto L63;
        double r9 = Utils.roundToNextSignificant(r4 / ((double) r3));
        if (this.mAxis.isGranularityEnabled() == true) goto L12;
    L14:
        double r11 = Utils.roundToNextSignificant(Math.pow(10.0d, (int) Math.log10(r9)));
        if (((int) (r9 / r11)) <= 5) goto L17;
        r9 = Math.floor(r11 * 10.0d);
    L17:
        boolean r6 = this.mAxis.isCenterAxisLabelsEnabled();
        if (this.mAxis.isForceLabelsEnabled() == false) goto L26;
        float r2 = ((float) r4) / (r3 - 1);
        this.mAxis.mEntryCount = r3;
        if (this.mAxis.mEntries.length >= r3) goto L22;
        this.mAxis.mEntries = new float[r3];
    L22:
        int r5 = 0;
    L23:
        if (r5 >= r3) goto L51;
        this.mAxis.mEntries[r5] = r1;
        r1 = r1 + r2;
        r5 = r5 + 1;
    L51:
        if (r9 >= 1.0d) goto L53;
        this.mAxis.mDecimals = (int) Math.ceil(-Math.log10(r9));
    L54:
        if (r6 == true) goto L56;
    L61:
        this.mAxis.mAxisMinimum = this.mAxis.mEntries[0];
        this.mAxis.mAxisMaximum = this.mAxis.mEntries[r3 - 1];
        this.mAxis.mAxisRange = Math.abs(this.mAxis.mAxisMaximum - this.mAxis.mAxisMinimum);
        return;
    L56:
        if (this.mAxis.mCenteredEntries.length >= r3) goto L58;
        this.mAxis.mCenteredEntries = new float[r3];
    L58:
        float r7 = (this.mAxis.mEntries[1] - this.mAxis.mEntries[0]) / 2.0f;
        int r8 = 0;
    L59:
        if (r8 >= r3) goto L61;
        this.mAxis.mCenteredEntries[r8] = this.mAxis.mEntries[r8] + r7;
        r8 = r8 + 1;
        goto L59
    L53:
        this.mAxis.mDecimals = 0;
        goto L54
    L26:
        if (r9 != 0.0d) goto L28;
        double r10 = 0.0d;
    L29:
        if (r6 == false) goto L31;
        r10 = r10 - r9;
    L31:
        if (r9 != 0.0d) goto L33;
        double r12 = 0.0d;
    L34:
        if (r9 == 0.0d) goto L39;
        double r13 = r10;
        ?? r14 = r6;
    L37:
        if (r13 > r12) goto L40;
        r13 = r13 + r9;
        r14 = (r14 == true ? 1 : 0) + 1;
    L40:
        int r15 = r14 + 1;
        this.mAxis.mEntryCount = r15;
        if (this.mAxis.mEntries.length >= r15) goto L43;
        this.mAxis.mEntries = new float[r15];
    L43:
        int r18 = 0;
    L44:
        if (r18 >= r15) goto L49;
        if (r10 != 0.0d) goto L48;
        r10 = 0.0d;
    L48:
        this.mAxis.mEntries[r18] = (float) r10;
        r10 = r10 + r9;
        r18 = r18 + 1;
        goto L44
    L49:
        r3 = r15;
        goto L51
    L39:
        r14 = r6;
        goto L40
    L33:
        r12 = Utils.nextUp(Math.floor(((double) r17) / r9) * r9);
        goto L34
    L28:
        r10 = Math.ceil(((double) r1) / r9) * r9;
        goto L29
    L12:
        if (r9 >= this.mAxis.getGranularity()) goto L14;
        r9 = this.mAxis.getGranularity();
        goto L14
    }

    @Override // com.github.mikephil.charting.renderer.YAxisRenderer, com.github.mikephil.charting.renderer.AxisRenderer
    public void renderAxisLabels(Canvas r10) {
        if (this.mYAxis.isEnabled() == true) goto L5;
        return;
    L5:
        if (this.mYAxis.isDrawLabelsEnabled() == false) goto L18;
        this.mAxisLabelPaint.setTypeface(this.mYAxis.getTypeface());
        this.mAxisLabelPaint.setTextSize(this.mYAxis.getTextSize());
        this.mAxisLabelPaint.setColor(this.mYAxis.getTextColor());
        MPPointF r0 = this.mChart.getCenterOffsets();
        MPPointF r1 = MPPointF.getInstance(0.0f, 0.0f);
        float r2 = this.mChart.getFactor();
        int r3 = !this.mYAxis.isDrawBottomYLabelEntryEnabled() ? 1 : 0;
        if (this.mYAxis.isDrawTopYLabelEntryEnabled() == false) goto L10;
        int r4 = this.mYAxis.mEntryCount;
    L11:
        if (r3 >= r4) goto L13;
        Utils.getPosition(r0, (this.mYAxis.mEntries[r3] - this.mYAxis.mAxisMinimum) * r2, this.mChart.getRotationAngle(), r1);
        r10.drawText(this.mYAxis.getFormattedLabel(r3), r1.x + 10.0f, r1.y, this.mAxisLabelPaint);
        r3 = r3 + 1;
        goto L11
    L13:
        MPPointF.recycleInstance(r0);
        MPPointF.recycleInstance(r1);
        return;
    L10:
        r4 = this.mYAxis.mEntryCount - 1;
        goto L11
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.github.mikephil.charting.renderer.YAxisRenderer, com.github.mikephil.charting.renderer.AxisRenderer
    public void renderLimitLines(Canvas r13) {
        List<LimitLine> r0 = this.mYAxis.getLimitLines();
        if (r0 != null) goto L5;
        return;
    L5:
        float r1 = this.mChart.getSliceAngle();
        float r2 = this.mChart.getFactor();
        MPPointF r3 = this.mChart.getCenterOffsets();
        MPPointF r4 = MPPointF.getInstance(0.0f, 0.0f);
        int r6 = 0;
    L7:
        if (r6 >= r0.size()) goto L21;
        LimitLine r7 = r0.get(r6);
        if (r7.isEnabled() == false) goto L20;
        this.mLimitLinePaint.setColor(r7.getLineColor());
        this.mLimitLinePaint.setPathEffect(r7.getDashPathEffect());
        this.mLimitLinePaint.setStrokeWidth(r7.getLineWidth());
        float r8 = (r7.getLimit() - this.mChart.getYChartMin()) * r2;
        Path r9 = this.mRenderLimitLinesPathBuffer;
        r9.reset();
        int r10 = 0;
    L13:
        if (r10 >= ((RadarData) this.mChart.getData()).getMaxEntryCountSet().getEntryCount()) goto L19;
        Utils.getPosition(r3, r8, (r10 * r1) + this.mChart.getRotationAngle(), r4);
        if (r10 != 0) goto L17;
        r9.moveTo(r4.x, r4.y);
    L18:
        r10 = r10 + 1;
        goto L13
    L17:
        r9.lineTo(r4.x, r4.y);
        goto L18
    L19:
        r9.close();
        r13.drawPath(r9, this.mLimitLinePaint);
    L20:
        r6 = r6 + 1;
        goto L7
    L21:
        MPPointF.recycleInstance(r3);
        MPPointF.recycleInstance(r4);
    }
}
