package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import com.github.mikephil.charting.animation.ChartAnimator;
import com.github.mikephil.charting.buffer.BarBuffer;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.highlight.Range;
import com.github.mikephil.charting.interfaces.dataprovider.BarDataProvider;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.model.GradientColor;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class BarChartRenderer extends BarLineScatterCandleBubbleRenderer {
    protected Paint mBarBorderPaint;
    protected BarBuffer[] mBarBuffers;
    protected RectF mBarRect;
    private RectF mBarShadowRectBuffer;
    protected BarDataProvider mChart;
    protected Paint mShadowPaint;

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void drawExtras(Canvas r1) {
    }

    public BarChartRenderer(BarDataProvider r1, ChartAnimator r2, ViewPortHandler r3) {
        super(r2, r3);
        this.mBarRect = new RectF();
        this.mBarShadowRectBuffer = new RectF();
        this.mChart = r1;
        this.mHighlightPaint = new Paint(1);
        this.mHighlightPaint.setStyle(Paint.Style.FILL);
        this.mHighlightPaint.setColor(Color.rgb(0, 0, 0));
        this.mHighlightPaint.setAlpha(120);
        Paint r4 = new Paint(1);
        this.mShadowPaint = r4;
        r4.setStyle(Paint.Style.FILL);
        Paint r5 = new Paint(1);
        this.mBarBorderPaint = r5;
        r5.setStyle(Paint.Style.STROKE);
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void initBuffers() {
        BarData r0 = this.mChart.getBarData();
        this.mBarBuffers = new BarBuffer[r0.getDataSetCount()];
        int r1 = 0;
    L4:
        if (r1 >= this.mBarBuffers.length) goto L10;
        IBarDataSet r2 = (IBarDataSet) r0.getDataSetByIndex(r1);
        BarBuffer[] r3 = this.mBarBuffers;
        int r5 = r2.getEntryCount() * 4;
        if (r2.isStacked() == false) goto L8;
        int r6 = r2.getStackSize();
    L9:
        r3[r1] = new BarBuffer(r5 * r6, r0.getDataSetCount(), r2.isStacked());
        r1 = r1 + 1;
        goto L4
    L8:
        r6 = 1;
        goto L9
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void drawData(Canvas r5) {
        BarData r0 = this.mChart.getBarData();
        int r1 = 0;
    L4:
        if (r1 >= r0.getDataSetCount()) goto L9;
        IBarDataSet r2 = (IBarDataSet) r0.getDataSetByIndex(r1);
        if (r2.isVisible() == false) goto L8;
        drawDataSet(r5, r2, r1);
    L8:
        r1 = r1 + 1;
        goto L4
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void drawDataSet(Canvas r25, IBarDataSet r26, int r27) {
        Transformer r3 = this.mChart.getTransformer(r26.getAxisDependency());
        this.mBarBorderPaint.setColor(r26.getBarBorderColor());
        this.mBarBorderPaint.setStrokeWidth(Utils.convertDpToPixel(r26.getBarBorderWidth()));
        int r5 = 0;
        boolean r6 = true;
        if (r26.getBarBorderWidth() <= 0.0f) goto L5;
        boolean r4 = true;
    L6:
        float r7 = this.mAnimator.getPhaseX();
        float r8 = this.mAnimator.getPhaseY();
        if (this.mChart.isDrawBarShadowEnabled() == false) goto L18;
        this.mShadowPaint.setColor(r26.getBarShadowColor());
        float r9 = this.mChart.getBarData().getBarWidth() / 2.0f;
        int r10 = Math.min((int) Math.ceil(r26.getEntryCount() * r7), r26.getEntryCount());
        int r11 = 0;
    L9:
        if (r11 >= r10) goto L18;
        float r12 = ((BarEntry) r26.getEntryForIndex(r11)).getX();
        this.mBarShadowRectBuffer.left = r12 - r9;
        this.mBarShadowRectBuffer.right = r12 + r9;
        r3.rectValueToPixel(this.mBarShadowRectBuffer);
        if (this.mViewPortHandler.isInBoundsLeft(this.mBarShadowRectBuffer.right) == true) goto L14;
    L17:
        r11 = r11 + 1;
        goto L9
    L14:
        if (this.mViewPortHandler.isInBoundsRight(this.mBarShadowRectBuffer.left) == false) goto L18;
        this.mBarShadowRectBuffer.top = this.mViewPortHandler.contentTop();
        this.mBarShadowRectBuffer.bottom = this.mViewPortHandler.contentBottom();
        r25.drawRect(this.mBarShadowRectBuffer, this.mShadowPaint);
    L18:
        BarBuffer r13 = this.mBarBuffers[r27];
        r13.setPhases(r7, r8);
        r13.setDataSet(r27);
        r13.setInverted(this.mChart.isInverted(r26.getAxisDependency()));
        r13.setBarWidth(this.mChart.getBarData().getBarWidth());
        r13.feed2(r26);
        r3.pointValuesToPixel(r13.buffer);
        if (r26.getColors().size() == 1) goto L22;
        r6 = false;
    L22:
        if (r6 == false) goto L25;
        this.mRenderPaint.setColor(r26.getColor());
    L25:
        if (r5 >= r13.size()) goto L44;
        int r14 = r5 + 2;
        if (this.mViewPortHandler.isInBoundsLeft(r13.buffer[r14]) == false) goto L43;
        if (this.mViewPortHandler.isInBoundsRight(r13.buffer[r5]) == false) goto L55;
        if (r6 == true) goto L35;
        this.mRenderPaint.setColor(r26.getColor(r5 / 4));
    L35:
        if (r26.getGradientColor() == null) goto L38;
        GradientColor r2 = r26.getGradientColor();
        this.mRenderPaint.setShader(new LinearGradient(r13.buffer[r5], r13.buffer[r5 + 3], r13.buffer[r5], r13.buffer[r5 + 1], r2.getStartColor(), r2.getEndColor(), Shader.TileMode.MIRROR));
    L38:
        if (r26.getGradientColors() == null) goto L40;
        int r15 = r5 / 4;
        this.mRenderPaint.setShader(new LinearGradient(r13.buffer[r5], r13.buffer[r5 + 3], r13.buffer[r5], r13.buffer[r5 + 1], r26.getGradientColor(r15).getStartColor(), r26.getGradientColor(r15).getEndColor(), Shader.TileMode.MIRROR));
    L40:
        int r16 = r5 + 1;
        int r17 = r5 + 3;
        r25.drawRect(r13.buffer[r5], r13.buffer[r16], r13.buffer[r14], r13.buffer[r17], this.mRenderPaint);
        if (r4 == false) goto L43;
        r25.drawRect(r13.buffer[r5], r13.buffer[r16], r13.buffer[r14], r13.buffer[r17], this.mBarBorderPaint);
        goto L43
    L55:
        return;
    L43:
        r5 = r5 + 4;
        goto L25
    L44:
        return;
    L5:
        r4 = false;
        goto L6
    }

    protected void prepareBarHighlight(float r2, float r3, float r4, float r5, Transformer r6) {
        float r0 = r2 - r5;
        float r7 = r2 + r5;
        this.mBarRect.set(r0, r3, r7, r4);
        r6.rectToPixelPhase(this.mBarRect, this.mAnimator.getPhaseY());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void drawValues(Canvas r42) {
        if (isDrawingValuesAllowed(this.mChart) == false) goto L137;
        List r7 = this.mChart.getBarData().getDataSets();
        float r8 = Utils.convertDpToPixel(4.5f);
        boolean r9 = this.mChart.isDrawValueAboveBarEnabled();
        int r11 = 0;
    L6:
        if (r11 >= this.mChart.getBarData().getDataSetCount()) goto L166;
        IBarDataSet r12 = (IBarDataSet) r7.get(r11);
        if (shouldDrawValues(r12) == true) goto L10;
        List r25 = r7;
        float r27 = r8;
        boolean r24 = r9;
    L136:
        r11 = r11 + 1;
        r9 = r24;
        r7 = r25;
        r8 = r27;
        goto L6
    L10:
        applyValueTextStyle(r12);
        boolean r0 = this.mChart.isInverted(r12.getAxisDependency());
        float r1 = Utils.calcTextHeight(this.mValuePaint, "8");
        if (r9 == false) goto L13;
        float r2 = -r8;
    L14:
        if (r9 == false) goto L16;
        float r3 = r1 + r8;
    L17:
        if (r0 == false) goto L19;
        r2 = (-r2) - r1;
        r3 = (-r3) - r1;
    L19:
        float r13 = r2;
        float r14 = r3;
        BarBuffer r15 = this.mBarBuffers[r11];
        float r16 = this.mAnimator.getPhaseY();
        ValueFormatter r5 = r12.getValueFormatter();
        MPPointF r4 = MPPointF.getInstance(r12.getIconsOffset());
        r4.x = Utils.convertDpToPixel(r4.x);
        r4.y = Utils.convertDpToPixel(r4.y);
        if (r12.isStacked() == true) goto L52;
        int r6 = 0;
    L23:
        if (r6 >= (r15.buffer.length * this.mAnimator.getPhaseX())) goto L51;
        float r10 = (r15.buffer[r6] + r15.buffer[r6 + 2]) / 2.0f;
        if (this.mViewPortHandler.isInBoundsRight(r10) == false) goto L51;
        int r17 = r6 + 1;
        if (this.mViewPortHandler.isInBoundsY(r15.buffer[r17]) == true) goto L30;
    L49:
        r6 = r6;
        r5 = r5;
        r7 = r7;
        r4 = r4;
    L50:
        r6 = r6 + 4;
        r4 = r4;
        r5 = r5;
        r7 = r7;
        goto L23
    L30:
        if (this.mViewPortHandler.isInBoundsLeft(r10) == false) goto L49;
        int r18 = r6 / 4;
        BarEntry r19 = (BarEntry) r12.getEntryForIndex(r18);
        float r110 = r19.getY();
        if (r12.isDrawValuesEnabled() == false) goto L39;
        String r20 = r5.getBarLabel(r19);
        float[] r111 = r15.buffer;
        if (r110 < 0.0f) goto L37;
        float r112 = r111[r17] + r13;
    L38:
        float r26 = r10;
        drawValue(r42, r20, r26, r112, r12.getValueTextColor(r18));
    L41:
        if (r19.getIcon() == null) goto L50;
        if (r12.isDrawIconsEnabled() == false) goto L50;
        Drawable r28 = r19.getIcon();
        if (r110 < 0.0f) goto L47;
        float r21 = r15.buffer[r17] + r13;
    L48:
        Utils.drawImage(r42, r28, (int) (r26 + r4.x), (int) (r21 + r4.y), r28.getIntrinsicWidth(), r28.getIntrinsicHeight());
        goto L50
    L47:
        r21 = r15.buffer[r6 + 3] + r14;
        goto L48
    L37:
        r112 = r111[r6 + 3] + r14;
        goto L38
    L39:
        r26 = r10;
    L51:
        r25 = r7;
        MPPointF r22 = r4;
    L135:
        r27 = r8;
        r24 = r9;
        MPPointF.recycleInstance(r22);
        goto L136
    L52:
        r25 = r7;
        r22 = r4;
        Transformer r23 = this.mChart.getTransformer(r12.getAxisDependency());
        int r29 = 0;
        int r113 = 0;
    L54:
        if (r29 >= (r12.getEntryCount() * this.mAnimator.getPhaseX())) goto L135;
        BarEntry r30 = (BarEntry) r12.getEntryForIndex(r29);
        float[] r31 = r30.getYVals();
        float r32 = (r15.buffer[r113] + r15.buffer[r113 + 2]) / 2.0f;
        int r210 = r12.getValueTextColor(r29);
        if (r31 != null) goto L83;
        if (this.mViewPortHandler.isInBoundsRight(r32) == false) goto L135;
        float[] r33 = r31;
        int r211 = r113 + 1;
        if (this.mViewPortHandler.isInBoundsY(r15.buffer[r211]) == false) goto L82;
        if (this.mViewPortHandler.isInBoundsLeft(r32) == false) goto L82;
        if (r12.isDrawValuesEnabled() == false) goto L72;
        String r34 = r5.getBarLabel(r30);
        float r35 = r15.buffer[r211];
        if (r30.getY() < 0.0f) goto L70;
        float r212 = r13;
    L71:
        float r213 = r32;
        drawValue(r42, r34, r213, r35 + r212, r210);
    L74:
        if (r30.getIcon() != null) goto L76;
    L131:
        if (r33 != null) goto L133;
        r113 = r113 + 4;
    L134:
        r29 = r29 + 1;
        r23 = r23;
        r9 = r9;
        r8 = r8;
        goto L54
    L133:
        r113 = r113 + (r33.length * 4);
        goto L134
    L76:
        if (r12.isDrawIconsEnabled() == false) goto L131;
        Drawable r36 = r30.getIcon();
        float r37 = r15.buffer[r211];
        if (r30.getY() < 0.0f) goto L80;
        float r38 = r13;
    L81:
        float r39 = r37 + r38;
        Utils.drawImage(r42, r36, (int) (r22.x + r213), (int) (r39 + r22.y), r36.getIntrinsicWidth(), r36.getIntrinsicHeight());
        goto L131
    L80:
        r38 = r14;
        goto L81
    L70:
        r212 = r14;
        goto L71
    L72:
        r213 = r32;
    L82:
        r23 = r23;
        r9 = r9;
        r8 = r8;
        r29 = r29;
        goto L54
    L83:
        BarEntry r214 = r30;
        r29 = r29;
        r8 = r8;
        r9 = r9;
        r33 = r31;
        r23 = r23;
        float r40 = r32;
        int r41 = r33.length * 2;
        float[] r43 = new float[r41];
        float r215 = -r214.getNegativeSum();
        float r216 = 0.0f;
        int r44 = 0;
        int r45 = 0;
    L84:
        if (r44 >= r41) goto L96;
        float r46 = r33[r45];
        if (r46 == 0.0f) goto L88;
    L92:
        if (r46 < 0.0f) goto L94;
        r216 = r216 + r46;
        float r47 = r215;
        r215 = r216;
    L95:
        r43[r44 + 1] = r215 * r16;
        r44 = r44 + 2;
        r45 = r45 + 1;
        r215 = r47;
        goto L84
    L94:
        r47 = r215 - r46;
        goto L95
    L88:
        if (r216 != 0.0f) goto L90;
    L91:
        float r48 = r215;
        r215 = r46;
        r47 = r48;
        goto L95
    L90:
        if (r215 != 0.0f) goto L92;
    L96:
        r23.pointValuesToPixel(r43);
        int r49 = 0;
    L97:
        if (r49 >= r41) goto L131;
        float r50 = r33[r49 / 2];
        if (r50 != 0.0f) goto L105;
        if (r215 != 0.0f) goto L105;
        if (r216 <= 0.0f) goto L105;
    L106:
        boolean r51 = true;
    L108:
        float r217 = r43[r49 + 1];
        if (r51 == false) goto L111;
        float r52 = r14;
    L112:
        float r53 = r217 + r52;
        int r218 = r49;
        if (this.mViewPortHandler.isInBoundsRight(r40) == false) goto L131;
        if (this.mViewPortHandler.isInBoundsY(r53) == true) goto L118;
    L129:
        r41 = r41;
        r40 = r40;
        r218 = r218;
        BarEntry r219 = r214;
        r43 = r43;
    L130:
        r49 = r218 + 2;
        r43 = r43;
        r214 = r219;
        r41 = r41;
        r40 = r40;
        goto L97
    L118:
        if (this.mViewPortHandler.isInBoundsLeft(r40) == false) goto L129;
        if (r12.isDrawValuesEnabled() == false) goto L123;
        BarEntry r54 = r214;
        float r310 = r53;
        r219 = r54;
        drawValue(r42, r5.getBarStackedLabel(r50, r54), r40, r310, r210);
    L125:
        if (r219.getIcon() == null) goto L130;
        if (r12.isDrawIconsEnabled() == false) goto L130;
        Drawable r311 = r219.getIcon();
        Utils.drawImage(r42, r311, (int) (r40 + r22.x), (int) (r310 + r22.y), r311.getIntrinsicWidth(), r311.getIntrinsicHeight());
        goto L130
    L123:
        r310 = r53;
        r219 = r214;
        goto L125
    L111:
        r52 = r13;
    L105:
        if (r50 < 0.0f) goto L106;
        r51 = false;
        goto L108
    L16:
        r3 = -r8;
        goto L17
    L13:
        r2 = r1 + r8;
        goto L14
    L166:
        return;
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void drawValue(Canvas r2, String r3, float r4, float r5, int r6) {
        this.mValuePaint.setColor(r6);
        r2.drawText(r3, r4, r5, this.mValuePaint);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void drawHighlighted(Canvas r12, Highlight[] r13) {
        BarData r6 = this.mChart.getBarData();
        int r7 = r13.length;
        int r9 = 0;
    L3:
        if (r9 >= r7) goto L27;
        Highlight r10 = r13[r9];
        IBarDataSet r0 = (IBarDataSet) r6.getDataSetByIndex(r10.getDataSetIndex());
        if (r0 == null) goto L26;
        if (r0.isHighlightEnabled() == false) goto L26;
        BarEntry r1 = (BarEntry) r0.getEntryForXValue(r10.getX(), r10.getY());
        if (isInBoundsX(r1, r0) == false) goto L26;
        Transformer r5 = this.mChart.getTransformer(r0.getAxisDependency());
        this.mHighlightPaint.setColor(r0.getHighLightColor());
        this.mHighlightPaint.setAlpha(r0.getHighLightAlpha());
        if (r10.getStackIndex() >= 0) goto L15;
    L17:
        boolean r2 = false;
    L18:
        if (r2 == true) goto L20;
        float r3 = r1.getY();
        float r4 = 0.0f;
    L24:
        float r8 = r4;
        float r11 = r3;
    L25:
        prepareBarHighlight(r1.getX(), r11, r8, r6.getBarWidth() / 2.0f, r5);
        setHighlightDrawPos(r10, this.mBarRect);
        r12.drawRect(this.mBarRect, this.mHighlightPaint);
        goto L26
    L20:
        if (this.mChart.isHighlightFullBarEnabled() == false) goto L22;
        r3 = r1.getPositiveSum();
        r4 = -r1.getNegativeSum();
        goto L24
    L22:
        Range r14 = r1.getRanges()[r10.getStackIndex()];
        r11 = r14.from;
        r8 = r14.to;
        goto L25
    L15:
        if (r1.isStacked() == false) goto L17;
        r2 = true;
    L26:
        r9 = r9 + 1;
        goto L3
    }

    protected void setHighlightDrawPos(Highlight r1, RectF r2) {
        r1.setDraw(r2.centerX(), r2.top);
    }
}
