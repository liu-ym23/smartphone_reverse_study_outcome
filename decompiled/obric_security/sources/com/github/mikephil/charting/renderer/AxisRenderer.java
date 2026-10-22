package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import android.graphics.Paint;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.utils.MPPointD;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;

/* JADX INFO: loaded from: classes2.dex */
public abstract class AxisRenderer extends Renderer {
    protected AxisBase mAxis;
    protected Paint mAxisLabelPaint;
    protected Paint mAxisLinePaint;
    protected Paint mGridPaint;
    protected Paint mLimitLinePaint;
    protected Transformer mTrans;

    public abstract void renderAxisLabels(Canvas r1);

    public abstract void renderAxisLine(Canvas r1);

    public abstract void renderGridLines(Canvas r1);

    public abstract void renderLimitLines(Canvas r1);

    public AxisRenderer(ViewPortHandler r2, Transformer r3, AxisBase r4) {
        super(r2);
        this.mTrans = r3;
        this.mAxis = r4;
        if (this.mViewPortHandler == null) goto L6;
        this.mAxisLabelPaint = new Paint(1);
        Paint r5 = new Paint();
        this.mGridPaint = r5;
        r5.setColor(-7829368);
        this.mGridPaint.setStrokeWidth(1.0f);
        this.mGridPaint.setStyle(Paint.Style.STROKE);
        this.mGridPaint.setAlpha(90);
        Paint r6 = new Paint();
        this.mAxisLinePaint = r6;
        r6.setColor(-16777216);
        this.mAxisLinePaint.setStrokeWidth(1.0f);
        this.mAxisLinePaint.setStyle(Paint.Style.STROKE);
        Paint r7 = new Paint(1);
        this.mLimitLinePaint = r7;
        r7.setStyle(Paint.Style.STROKE);
        return;
    }

    public Paint getPaintAxisLabels() {
        return this.mAxisLabelPaint;
    }

    public Paint getPaintGrid() {
        return this.mGridPaint;
    }

    public Paint getPaintAxisLine() {
        return this.mAxisLinePaint;
    }

    public Transformer getTransformer() {
        return this.mTrans;
    }

    public void computeAxis(float r3, float r4, boolean r5) {
        if (this.mViewPortHandler != null) goto L5;
    L13:
        computeAxisValues(r3, r4);
        return;
    L5:
        if (this.mViewPortHandler.contentWidth() <= 10.0f) goto L13;
        if (this.mViewPortHandler.isFullyZoomedOutY() == true) goto L13;
        MPPointD r6 = this.mTrans.getValuesByTouchPoint(this.mViewPortHandler.contentLeft(), this.mViewPortHandler.contentTop());
        MPPointD r7 = this.mTrans.getValuesByTouchPoint(this.mViewPortHandler.contentLeft(), this.mViewPortHandler.contentBottom());
        if (r5 == true) goto L11;
        float r8 = (float) r7.y;
        double r0 = r6.y;
    L12:
        MPPointD.recycleInstance(r6);
        MPPointD.recycleInstance(r7);
        r3 = r8;
        r4 = (float) r0;
        goto L13
    L11:
        r8 = (float) r6.y;
        r0 = r7.y;
        goto L12
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v3, types: [boolean] */
    /* JADX WARN: Type inference failed for: r6v5, types: [int] */
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
        int r6 = this.mAxis.isCenterAxisLabelsEnabled();
        if (this.mAxis.isForceLabelsEnabled() == false) goto L26;
        r9 = ((float) r4) / (r3 - 1);
        this.mAxis.mEntryCount = r3;
        if (this.mAxis.mEntries.length >= r3) goto L22;
        this.mAxis.mEntries = new float[r3];
    L22:
        int r2 = 0;
    L23:
        if (r2 >= r3) goto L51;
        this.mAxis.mEntries[r2] = r1;
        r1 = (float) (((double) r1) + r9);
        r2 = r2 + 1;
    L51:
        if (r9 >= 1.0d) goto L53;
        this.mAxis.mDecimals = (int) Math.ceil(-Math.log10(r9));
    L55:
        if (this.mAxis.isCenterAxisLabelsEnabled() == true) goto L57;
        return;
    L57:
        if (this.mAxis.mCenteredEntries.length >= r3) goto L59;
        this.mAxis.mCenteredEntries = new float[r3];
    L59:
        float r5 = ((float) r9) / 2.0f;
        int r7 = 0;
    L60:
        if (r7 >= r3) goto L71;
        this.mAxis.mCenteredEntries[r7] = this.mAxis.mEntries[r7] + r5;
        r7 = r7 + 1;
        goto L60
    L71:
        return;
    L53:
        this.mAxis.mDecimals = 0;
        goto L55
    L26:
        if (r9 != 0.0d) goto L28;
        double r8 = 0.0d;
    L30:
        if (this.mAxis.isCenterAxisLabelsEnabled() == false) goto L32;
        r8 = r8 - r9;
    L32:
        if (r9 != 0.0d) goto L34;
        double r10 = 0.0d;
    L35:
        if (r9 == 0.0d) goto L40;
        double r12 = r8;
        r6 = r6;
    L38:
        if (r12 > r10) goto L40;
        r12 = r12 + r9;
        r6 = r6 + 1;
    L40:
        this.mAxis.mEntryCount = r6;
        if (this.mAxis.mEntries.length >= r6) goto L43;
        this.mAxis.mEntries = new float[r6];
    L43:
        int r13 = 0;
    L44:
        if (r13 >= r6) goto L49;
        if (r8 != 0.0d) goto L48;
        r8 = 0.0d;
    L48:
        this.mAxis.mEntries[r13] = (float) r8;
        r8 = r8 + r9;
        r13 = r13 + 1;
        goto L44
    L49:
        r3 = r6;
        goto L51
    L34:
        r10 = Utils.nextUp(Math.floor(((double) r17) / r9) * r9);
        goto L35
    L28:
        r8 = Math.ceil(((double) r1) / r9) * r9;
        goto L30
    L12:
        if (r9 >= this.mAxis.getGranularity()) goto L14;
        r9 = this.mAxis.getGranularity();
        goto L14
    }
}
