package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.github.mikephil.charting.animation.ChartAnimator;
import com.github.mikephil.charting.buffer.BarBuffer;
import com.github.mikephil.charting.buffer.HorizontalBarBuffer;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.dataprovider.BarDataProvider;
import com.github.mikephil.charting.interfaces.dataprovider.ChartInterface;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class HorizontalBarChartRenderer extends BarChartRenderer {
    private RectF mBarShadowRectBuffer;

    public HorizontalBarChartRenderer(BarDataProvider r1, ChartAnimator r2, ViewPortHandler r3) {
        super(r1, r2, r3);
        this.mBarShadowRectBuffer = new RectF();
        this.mValuePaint.setTextAlign(Paint.Align.LEFT);
    }

    @Override // com.github.mikephil.charting.renderer.BarChartRenderer, com.github.mikephil.charting.renderer.DataRenderer
    public void initBuffers() {
        BarData r0 = this.mChart.getBarData();
        this.mBarBuffers = new HorizontalBarBuffer[r0.getDataSetCount()];
        int r1 = 0;
    L4:
        if (r1 >= this.mBarBuffers.length) goto L10;
        IBarDataSet r2 = (IBarDataSet) r0.getDataSetByIndex(r1);
        BarBuffer[] r3 = this.mBarBuffers;
        int r5 = r2.getEntryCount() * 4;
        if (r2.isStacked() == false) goto L8;
        int r6 = r2.getStackSize();
    L9:
        r3[r1] = new HorizontalBarBuffer(r5 * r6, r0.getDataSetCount(), r2.isStacked());
        r1 = r1 + 1;
        goto L4
    L8:
        r6 = 1;
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.github.mikephil.charting.renderer.BarChartRenderer
    protected void drawDataSet(Canvas r21, IBarDataSet r22, int r23) {
        Transformer r3 = this.mChart.getTransformer(r22.getAxisDependency());
        this.mBarBorderPaint.setColor(r22.getBarBorderColor());
        this.mBarBorderPaint.setStrokeWidth(Utils.convertDpToPixel(r22.getBarBorderWidth()));
        int r5 = 0;
        boolean r6 = true;
        if (r22.getBarBorderWidth() <= 0.0f) goto L5;
        boolean r4 = true;
    L6:
        float r7 = this.mAnimator.getPhaseX();
        float r8 = this.mAnimator.getPhaseY();
        if (this.mChart.isDrawBarShadowEnabled() == false) goto L18;
        this.mShadowPaint.setColor(r22.getBarShadowColor());
        float r9 = this.mChart.getBarData().getBarWidth() / 2.0f;
        int r10 = Math.min((int) Math.ceil(r22.getEntryCount() * r7), r22.getEntryCount());
        int r11 = 0;
    L9:
        if (r11 >= r10) goto L18;
        float r12 = ((BarEntry) r22.getEntryForIndex(r11)).getX();
        this.mBarShadowRectBuffer.top = r12 - r9;
        this.mBarShadowRectBuffer.bottom = r12 + r9;
        r3.rectValueToPixel(this.mBarShadowRectBuffer);
        if (this.mViewPortHandler.isInBoundsTop(this.mBarShadowRectBuffer.bottom) == true) goto L14;
    L17:
        r11 = r11 + 1;
        goto L9
    L14:
        if (this.mViewPortHandler.isInBoundsBottom(this.mBarShadowRectBuffer.top) == false) goto L18;
        this.mBarShadowRectBuffer.left = this.mViewPortHandler.contentLeft();
        this.mBarShadowRectBuffer.right = this.mViewPortHandler.contentRight();
        r21.drawRect(this.mBarShadowRectBuffer, this.mShadowPaint);
    L18:
        BarBuffer r13 = this.mBarBuffers[r23];
        r13.setPhases(r7, r8);
        r13.setDataSet(r23);
        r13.setInverted(this.mChart.isInverted(r22.getAxisDependency()));
        r13.setBarWidth(this.mChart.getBarData().getBarWidth());
        r13.feed2(r22);
        r3.pointValuesToPixel(r13.buffer);
        if (r22.getColors().size() == 1) goto L22;
        r6 = false;
    L22:
        if (r6 == false) goto L25;
        this.mRenderPaint.setColor(r22.getColor());
    L25:
        if (r5 >= r13.size()) goto L38;
        int r14 = r5 + 3;
        if (this.mViewPortHandler.isInBoundsTop(r13.buffer[r14]) == false) goto L49;
        int r15 = r5 + 1;
        if (this.mViewPortHandler.isInBoundsBottom(r13.buffer[r15]) == false) goto L37;
        if (r6 == true) goto L34;
        this.mRenderPaint.setColor(r22.getColor(r5 / 4));
    L34:
        int r16 = r5 + 2;
        r21.drawRect(r13.buffer[r5], r13.buffer[r15], r13.buffer[r16], r13.buffer[r14], this.mRenderPaint);
        if (r4 == false) goto L37;
        r21.drawRect(r13.buffer[r5], r13.buffer[r15], r13.buffer[r16], r13.buffer[r14], this.mBarBorderPaint);
    L37:
        r5 = r5 + 4;
        goto L25
    L49:
        return;
    L38:
        return;
    L5:
        r4 = false;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not found block with instruction: 0x00fd: MOVE (r3v14 ?? I:??[OBJECT, ARRAY]) A[DONT_GENERATE, REMOVE] */
    @Override // com.github.mikephil.charting.renderer.BarChartRenderer, com.github.mikephil.charting.renderer.DataRenderer
    public void drawValues(Canvas r41) {
        if (isDrawingValuesAllowed(this.mChart) == false) goto L157;
        List r7 = this.mChart.getBarData().getDataSets();
        float r8 = Utils.convertDpToPixel(5.0f);
        boolean r9 = this.mChart.isDrawValueAboveBarEnabled();
        int r11 = 0;
    L6:
        if (r11 >= this.mChart.getBarData().getDataSetCount()) goto L186;
        IBarDataSet r12 = (IBarDataSet) r7.get(r11);
        if (shouldDrawValues(r12) == true) goto L10;
        List r19 = r7;
        int r20 = r11;
    L156:
        r11 = r20 + 1;
        r7 = r19;
        goto L6
    L10:
        boolean r13 = this.mChart.isInverted(r12.getAxisDependency());
        applyValueTextStyle(r12);
        float r14 = 2.0f;
        float r15 = Utils.calcTextHeight(this.mValuePaint, "10") / 2.0f;
        ValueFormatter r5 = r12.getValueFormatter();
        BarBuffer r4 = this.mBarBuffers[r11];
        float r16 = this.mAnimator.getPhaseY();
        MPPointF r3 = MPPointF.getInstance(r12.getIconsOffset());
        r3.x = Utils.convertDpToPixel(r3.x);
        r3.y = Utils.convertDpToPixel(r3.y);
        if (r12.isStacked() == true) goto L53;
        int r2 = 0;
    L14:
        if (r2 >= (r4.buffer.length * this.mAnimator.getPhaseX())) goto L52;
        int r1 = r2 + 1;
        float r10 = (r4.buffer[r1] + r4.buffer[r2 + 3]) / r14;
        if (this.mViewPortHandler.isInBoundsTop(r4.buffer[r1]) == false) goto L52;
        if (this.mViewPortHandler.isInBoundsX(r4.buffer[r2]) == true) goto L22;
    L20:
        r2 = r2;
        r7 = r7;
        r11 = r11;
        r15 = r15;
        r4 = r4;
        r5 = r5;
    L51:
        r2 = r2 + 4;
        r3 = r3;
        r4 = r4;
        r5 = r5;
        r7 = r7;
        r11 = r11;
        r15 = r15;
        r14 = 2.0f;
        goto L14
    L22:
        if (this.mViewPortHandler.isInBoundsBottom(r4.buffer[r1]) == false) goto L20;
        BarEntry r17 = (BarEntry) r12.getEntryForIndex(r2 / 4);
        float r18 = r17.getY();
        String r6 = r5.getBarLabel(r17);
        float r0 = Utils.calcTextWidth(this.mValuePaint, r6);
        if (r9 == false) goto L27;
        float r21 = r8;
    L29:
        if (r9 == false) goto L31;
        float r22 = -(r0 + r8);
    L32:
        if (r13 == false) goto L34;
        r21 = (-r21) - r0;
        r22 = (-r22) - r0;
    L34:
        float r23 = r21;
        float r24 = r22;
        if (r12.isDrawValuesEnabled() == false) goto L43;
        float r25 = r4.buffer[r2 + 2];
        if (r18 < 0.0f) goto L39;
        float r26 = r23;
    L40:
        drawValue(r41, r6, r25 + r26, r10 + r15, r12.getValueTextColor(r2 / 2));
        goto L43
    L39:
        r26 = r24;
    L43:
        if (r17.getIcon() == null) goto L51;
        if (r12.isDrawIconsEnabled() == false) goto L51;
        Drawable r27 = r17.getIcon();
        float r28 = r4.buffer[r2 + 2];
        if (r18 >= 0.0f) goto L50;
        r23 = r24;
    L50:
        Utils.drawImage(r41, r27, (int) ((r28 + r23) + r20.x), (int) (r10 + r20.y), r27.getIntrinsicWidth(), r27.getIntrinsicHeight());
        goto L51
    L31:
        r22 = r8;
        goto L32
    L27:
        r21 = -(r0 + r8);
    L52:
        r19 = r7;
        r20 = r11;
        MPPointF r29 = r3;
    L155:
        MPPointF.recycleInstance(r29);
        goto L156
    L53:
        r19 = r7;
        r20 = r11;
        r29 = r3;
        Transformer r110 = this.mChart.getTransformer(r12.getAxisDependency());
        int r111 = 0;
        int r210 = 0;
    L55:
        if (r111 >= (r12.getEntryCount() * this.mAnimator.getPhaseX())) goto L155;
        BarEntry r30 = (BarEntry) r12.getEntryForIndex(r111);
        int r211 = r12.getValueTextColor(r111);
        float[] r31 = r30.getYVals();
        if (r31 != null) goto L93;
        int r212 = r210 + 1;
        if (this.mViewPortHandler.isInBoundsTop(r4.buffer[r212]) == false) goto L155;
        if (this.mViewPortHandler.isInBoundsX(r4.buffer[r210]) == false) goto L55;
        if (this.mViewPortHandler.isInBoundsBottom(r4.buffer[r212]) == false) goto L55;
        String r32 = r5.getBarLabel(r30);
        float r33 = Utils.calcTextWidth(this.mValuePaint, r32);
        if (r9 == false) goto L70;
        float r34 = r8;
    L71:
        if (r9 == false) goto L73;
        float r35 = -(r33 + r8);
    L74:
        if (r13 == false) goto L76;
        r34 = (-r34) - r33;
        r35 = (-r35) - r33;
    L76:
        float r213 = r34;
        float r214 = r35;
        if (r12.isDrawValuesEnabled() == false) goto L85;
        float r36 = r4.buffer[r210 + 2];
        if (r30.getY() < 0.0f) goto L81;
        float r37 = r213;
    L82:
        drawValue(r41, r32, r36 + r37, r4.buffer[r212] + r15, r211);
        goto L85
    L81:
        r37 = r214;
    L85:
        if (r30.getIcon() == null) goto L151;
        if (r12.isDrawIconsEnabled() == false) goto L151;
        Drawable r38 = r30.getIcon();
        float r39 = r4.buffer[r210 + 2];
        if (r30.getY() >= 0.0f) goto L92;
        r213 = r214;
    L92:
        float r40 = r4.buffer[r212];
        Utils.drawImage(r41, r38, (int) ((r39 + r213) + r29.x), (int) (r40 + r29.y), r38.getIntrinsicWidth(), r38.getIntrinsicHeight());
    L151:
        if (r31 != null) goto L153;
        r210 = r210 + 4;
    L154:
        r111 = r111 + 1;
        goto L55
    L153:
        r210 = r210 + (r31.length * 4);
        goto L154
    L73:
        r35 = r8;
        goto L74
    L70:
        r34 = -(r33 + r8);
        goto L71
    L93:
        r111 = r111;
        r31 = r31;
        int r42 = r31.length * 2;
        float[] r43 = new float[r42];
        float r215 = -r30.getNegativeSum();
        float r216 = 0.0f;
        int r44 = 0;
        int r45 = 0;
    L94:
        if (r44 >= r42) goto L106;
        float r46 = r31[r45];
        if (r46 == 0.0f) goto L98;
    L102:
        if (r46 < 0.0f) goto L104;
        r216 = r216 + r46;
        float r47 = r215;
        r215 = r216;
    L105:
        r43[r44] = r215 * r16;
        r44 = r44 + 2;
        r45 = r45 + 1;
        r215 = r47;
        goto L94
    L104:
        r47 = r215 - r46;
        goto L105
    L98:
        if (r216 != 0.0f) goto L100;
    L101:
        float r310 = r215;
        r215 = r46;
        r47 = r310;
        goto L105
    L100:
        if (r215 != 0.0f) goto L102;
    L106:
        r110.pointValuesToPixel(r43);
        int r48 = 0;
    L107:
        if (r48 >= r42) goto L151;
        float r49 = r31[r48 / 2];
        String r50 = r5.getBarStackedLabel(r49, r30);
        float r51 = Utils.calcTextWidth(this.mValuePaint, r50);
        if (r9 == false) goto L111;
        float r52 = r8;
    L112:
        int r217 = r42;
        if (r9 == false) goto L115;
        float r53 = -(r51 + r8);
    L116:
        if (r13 == false) goto L119;
        r52 = (-r52) - r51;
        r53 = (-r53) - r51;
    L119:
        if (r49 != 0.0f) goto L125;
        if (r215 != 0.0f) goto L125;
        if (r216 <= 0.0f) goto L125;
    L126:
        boolean r54 = true;
    L128:
        float r55 = r43[r48];
        if (r54 == false) goto L131;
        r52 = r53;
    L131:
        float r56 = r55 + r52;
        float r57 = (r4.buffer[r210 + 1] + r4.buffer[r210 + 3]) / 2.0f;
        if (this.mViewPortHandler.isInBoundsTop(r57) == false) goto L151;
        if (this.mViewPortHandler.isInBoundsX(r56) == true) goto L138;
    L136:
        r48 = r48;
        r43 = r43;
    L149:
        r48 = r48 + 2;
        r42 = r217;
        r43 = r43;
        goto L107
    L138:
        if (this.mViewPortHandler.isInBoundsBottom(r57) == false) goto L136;
        if (r12.isDrawValuesEnabled() == false) goto L145;
        drawValue(r41, r50, r56, r57 + r15, r211);
    L145:
        if (r30.getIcon() == null) goto L149;
        if (r12.isDrawIconsEnabled() == false) goto L149;
        Drawable r311 = r30.getIcon();
        Utils.drawImage(r41, r311, (int) (r56 + r29.x), (int) (r57 + r29.y), r311.getIntrinsicWidth(), r311.getIntrinsicHeight());
    L125:
        if (r49 < 0.0f) goto L126;
        r54 = false;
        goto L128
    L115:
        r53 = r8;
        goto L116
    L111:
        r52 = -(r51 + r8);
        goto L112
    L186:
        return;
    }

    @Override // com.github.mikephil.charting.renderer.BarChartRenderer, com.github.mikephil.charting.renderer.DataRenderer
    public void drawValue(Canvas r2, String r3, float r4, float r5, int r6) {
        this.mValuePaint.setColor(r6);
        r2.drawText(r3, r4, r5, this.mValuePaint);
    }

    @Override // com.github.mikephil.charting.renderer.BarChartRenderer
    protected void prepareBarHighlight(float r2, float r3, float r4, float r5, Transformer r6) {
        float r0 = r2 - r5;
        float r7 = r2 + r5;
        this.mBarRect.set(r3, r0, r4, r7);
        r6.rectToPixelPhaseHorizontal(this.mBarRect, this.mAnimator.getPhaseY());
    }

    @Override // com.github.mikephil.charting.renderer.BarChartRenderer
    protected void setHighlightDrawPos(Highlight r1, RectF r2) {
        r1.setDraw(r2.centerY(), r2.right);
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    protected boolean isDrawingValuesAllowed(ChartInterface r2) {
        if (r2.getData().getEntryCount() >= (r2.getMaxVisibleCount() * this.mViewPortHandler.getScaleY())) goto L5;
        return true;
    L5:
        return false;
    }
}
