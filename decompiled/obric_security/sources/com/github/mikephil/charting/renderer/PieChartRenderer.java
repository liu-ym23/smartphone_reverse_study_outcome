package com.github.mikephil.charting.renderer;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import com.github.mikephil.charting.animation.ChartAnimator;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.datasets.IPieDataSet;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class PieChartRenderer extends DataRenderer {
    protected Canvas mBitmapCanvas;
    private RectF mCenterTextLastBounds;
    private CharSequence mCenterTextLastValue;
    private StaticLayout mCenterTextLayout;
    private TextPaint mCenterTextPaint;
    protected PieChart mChart;
    protected WeakReference<Bitmap> mDrawBitmap;
    protected Path mDrawCenterTextPathBuffer;
    protected RectF mDrawHighlightedRectF;
    private Paint mEntryLabelsPaint;
    private Path mHoleCirclePath;
    protected Paint mHolePaint;
    private RectF mInnerRectBuffer;
    private Path mPathBuffer;
    private RectF[] mRectBuffer;
    protected Paint mTransparentCirclePaint;
    protected Paint mValueLinePaint;

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void initBuffers() {
    }

    public PieChartRenderer(PieChart r3, ChartAnimator r4, ViewPortHandler r5) {
        super(r4, r5);
        this.mCenterTextLastBounds = new RectF();
        this.mRectBuffer = new RectF[]{new RectF(), new RectF(), new RectF()};
        this.mPathBuffer = new Path();
        this.mInnerRectBuffer = new RectF();
        this.mHoleCirclePath = new Path();
        this.mDrawCenterTextPathBuffer = new Path();
        this.mDrawHighlightedRectF = new RectF();
        this.mChart = r3;
        Paint r6 = new Paint(1);
        this.mHolePaint = r6;
        r6.setColor(-1);
        this.mHolePaint.setStyle(Paint.Style.FILL);
        Paint r7 = new Paint(1);
        this.mTransparentCirclePaint = r7;
        r7.setColor(-1);
        this.mTransparentCirclePaint.setStyle(Paint.Style.FILL);
        this.mTransparentCirclePaint.setAlpha(105);
        TextPaint r8 = new TextPaint(1);
        this.mCenterTextPaint = r8;
        r8.setColor(-16777216);
        this.mCenterTextPaint.setTextSize(Utils.convertDpToPixel(12.0f));
        this.mValuePaint.setTextSize(Utils.convertDpToPixel(13.0f));
        this.mValuePaint.setColor(-1);
        this.mValuePaint.setTextAlign(Paint.Align.CENTER);
        Paint r9 = new Paint(1);
        this.mEntryLabelsPaint = r9;
        r9.setColor(-1);
        this.mEntryLabelsPaint.setTextAlign(Paint.Align.CENTER);
        this.mEntryLabelsPaint.setTextSize(Utils.convertDpToPixel(13.0f));
        Paint r10 = new Paint(1);
        this.mValueLinePaint = r10;
        r10.setStyle(Paint.Style.STROKE);
    }

    public Paint getPaintHole() {
        return this.mHolePaint;
    }

    public Paint getPaintTransparentCircle() {
        return this.mTransparentCirclePaint;
    }

    public TextPaint getPaintCenterText() {
        return this.mCenterTextPaint;
    }

    public Paint getPaintEntryLabels() {
        return this.mEntryLabelsPaint;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void drawData(Canvas r5) {
        int r0 = (int) this.mViewPortHandler.getChartWidth();
        int r1 = (int) this.mViewPortHandler.getChartHeight();
        WeakReference<Bitmap> r2 = this.mDrawBitmap;
        if (r2 != null) goto L5;
        Bitmap r3 = null;
    L6:
        if (r3 != null) goto L8;
    L11:
        if (r0 <= 0) goto L22;
        if (r1 <= 0) goto L30;
        r3 = Bitmap.createBitmap(r0, r1, Bitmap.Config.ARGB_4444);
        this.mDrawBitmap = new WeakReference(r3);
        this.mBitmapCanvas = new Canvas(r3);
    L14:
        r3.eraseColor(0);
        Iterator<IPieDataSet> r4 = ((PieData) this.mChart.getData()).getDataSets().iterator();
    L16:
        if (r4.hasNext() == false) goto L31;
        IPieDataSet r6 = r4.next();
        if (r6.isVisible() == false) goto L16;
        if (r6.getEntryCount() <= 0) goto L16;
        drawDataSet(r5, r6);
        goto L16
    L31:
        return;
    L30:
        return;
    L22:
        return;
    L8:
        if (r3.getWidth() != r0) goto L11;
        if (r3.getHeight() == r1) goto L14;
    L5:
        r3 = r2.get();
        goto L6
    }

    protected float calculateMinimumRadiusForSpacedSlice(MPPointF r16, float r17, float r18, float r19, float r20, float r21, float r22) {
        double r6 = (r21 + r22) * 0.017453292f;
        float r3 = r16.x + (((float) Math.cos(r6)) * r17);
        float r4 = r16.y + (((float) Math.sin(r6)) * r17);
        double r7 = (r21 + (r22 / 2.0f)) * 0.017453292f;
        return (float) (((double) (r17 - ((float) ((Math.sqrt(Math.pow(r3 - r19, 2.0d) + Math.pow(r4 - r20, 2.0d)) / 2.0d) * Math.tan(((180.0d - ((double) r18)) / 2.0d) * 0.017453292519943295d))))) - Math.sqrt(Math.pow((r16.x + (((float) Math.cos(r7)) * r17)) - ((r3 + r19) / 2.0f), 2.0d) + Math.pow((r16.y + (((float) Math.sin(r7)) * r17)) - ((r4 + r20) / 2.0f), 2.0d)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected float getSliceSpace(IPieDataSet r3) {
        if (r3.isAutomaticallyDisableSliceSpacingEnabled() == true) goto L7;
        return r3.getSliceSpace();
    L7:
        if ((r3.getSliceSpace() / this.mViewPortHandler.getSmallestContentExtension()) <= ((r3.getYMin() / ((PieData) this.mChart.getData()).getYValueSum()) * 2.0f)) goto L10;
        return 0.0f;
    L10:
        return r3.getSliceSpace();
    }

    protected void drawDataSet(Canvas r36, IPieDataSet r37) {
        IPieDataSet r9 = r37;
        float r10 = this.mChart.getRotationAngle();
        float r11 = this.mAnimator.getPhaseX();
        float r12 = this.mAnimator.getPhaseY();
        RectF r29 = this.mChart.getCircleBox();
        int r14 = r37.getEntryCount();
        float[] r15 = this.mChart.getDrawAngles();
        MPPointF r7 = this.mChart.getCenterCircleBox();
        float r25 = this.mChart.getRadius();
        if (this.mChart.isDrawHoleEnabled() == true) goto L5;
    L7:
        boolean r17 = false;
    L9:
        if (r17 == false) goto L11;
        float r4 = (this.mChart.getHoleRadius() / 100.0f) * r25;
    L12:
        float r20 = (r25 - ((this.mChart.getHoleRadius() * r25) / 100.0f)) / 2.0f;
        RectF r3 = new RectF();
        if (r17 == true) goto L15;
    L17:
        boolean r21 = false;
    L18:
        int r0 = 0;
        int r16 = 0;
    L19:
        if (r0 >= r14) goto L24;
        if (Math.abs(r9.getEntryForIndex(r0).getY()) <= Utils.FLOAT_EPSILON) goto L23;
        r16 = r16 + 1;
    L23:
        r0 = r0 + 1;
        goto L19
    L24:
        if (r16 > 1) goto L26;
        float r22 = 0.0f;
    L27:
        int r1 = 0;
        float r23 = 0.0f;
    L28:
        if (r1 >= r14) goto L104;
        float r24 = r15[r1];
        if (Math.abs(r9.getEntryForIndex(r1).getY()) > Utils.FLOAT_EPSILON) goto L33;
    L31:
        r23 = r23 + (r24 * r11);
        r1 = r1;
        r25 = r25;
        r10 = r10;
        r11 = r11;
        r29 = r29;
        r15 = r15;
        r16 = r16;
        RectF r34 = r3;
        float r28 = r4;
        r7 = r7;
    L103:
        r1 = r1 + 1;
        r9 = r37;
        r4 = r28;
        r3 = r34;
        r7 = r7;
        r16 = r16;
        r25 = r25;
        r14 = r14;
        r29 = r29;
        r10 = r10;
        r11 = r11;
        r15 = r15;
        goto L28
    L33:
        if (this.mChart.needsHighlight(r1) == false) goto L37;
        if (r21 == false) goto L31;
    L37:
        if (r22 > 0.0f) goto L39;
    L41:
        boolean r2 = false;
    L42:
        this.mRenderPaint.setColor(r9.getColor(r1));
        if (r16 != 1) goto L45;
        float r27 = 0.0f;
    L46:
        float r18 = r10 + ((r23 + (r27 / 2.0f)) * r12);
        float r210 = (r24 - r27) * r12;
        if (r210 >= 0.0f) goto L49;
        float r13 = 0.0f;
    L50:
        this.mPathBuffer.reset();
        if (r21 == false) goto L54;
        float r211 = r25 - r20;
        double r5 = r18 * 0.017453292f;
        float r6 = r7.x + (((float) Math.cos(r5)) * r211);
        float r19 = r7.y + (r211 * ((float) Math.sin(r5)));
        r3.set(r6 - r20, r19 - r20, r6 + r20, r19 + r20);
    L54:
        double r110 = r18 * 0.017453292f;
        r28 = r4;
        float r8 = r7.x + (((float) Math.cos(r110)) * r25);
        float r26 = r7.y + (((float) Math.sin(r110)) * r25);
        if (r13 < 360.0f) goto L60;
        if ((r13 % 360.0f) > Utils.FLOAT_EPSILON) goto L60;
        this.mPathBuffer.addCircle(r7.x, r7.y, r25, Path.Direction.CW);
    L64:
        r34 = r3;
        this.mInnerRectBuffer.set(r7.x - r28, r7.y - r28, r7.x + r28, r7.y + r28);
        if (r17 == true) goto L67;
        float r30 = 360.0f;
    L98:
        if ((r13 % r30) <= Utils.FLOAT_EPSILON) goto L102;
        if (r2 == false) goto L101;
        float r31 = calculateMinimumRadiusForSpacedSlice(r7, r25, r24 * r12, r8, r26, r18, r13);
        double r32 = 0.017453292f * (r18 + (r13 / 2.0f));
        this.mPathBuffer.lineTo(r7.x + (((float) Math.cos(r32)) * r31), r7.y + (r31 * ((float) Math.sin(r32))));
        goto L102
    L101:
        this.mPathBuffer.lineTo(r7.x, r7.y);
    L102:
        this.mPathBuffer.close();
        this.mBitmapCanvas.drawPath(this.mPathBuffer, this.mRenderPaint);
        r23 = r23 + (r24 * r11);
        goto L103
    L67:
        if (r28 > 0.0f) goto L71;
        if (r2 == true) goto L71;
        r30 = 360.0f;
    L71:
        if (r2 == false) goto L76;
        r28 = r28;
        boolean r111 = true;
        float r33 = calculateMinimumRadiusForSpacedSlice(r7, r25, r24 * r12, r8, r26, r18, r13);
        if (r33 >= 0.0f) goto L75;
        r33 = -r33;
    L75:
        float r35 = Math.max(r28, r33);
    L77:
        if (r16 != r111) goto L79;
    L82:
        float r38 = 0.0f;
    L83:
        float r39 = r10 + ((r23 + (r38 / 2.0f)) * r12);
        float r40 = (r24 - r38) * r12;
        if (r40 >= 0.0f) goto L86;
        r40 = 0.0f;
    L86:
        float r41 = r39 + r40;
        if (r13 >= 360.0f) goto L89;
    L91:
        if (r21 == false) goto L93;
        float r42 = r25 - r20;
        double r43 = 0.017453292f * r41;
        MPPointF r44 = r7;
        float r45 = r7.x + (((float) Math.cos(r43)) * r42);
        float r46 = r44.y + (r42 * ((float) Math.sin(r43)));
        r34 = r34;
        r34.set(r45 - r20, r46 - r20, r45 + r20, r46 + r20);
        this.mPathBuffer.arcTo(r34, r41, 180.0f);
    L94:
        this.mPathBuffer.arcTo(this.mInnerRectBuffer, r41, -r40);
    L95:
        r7 = r44;
        goto L102
    L93:
        r44 = r7;
        r34 = r34;
        double r47 = r41 * 0.017453292f;
        this.mPathBuffer.lineTo(r44.x + (((float) Math.cos(r47)) * r35), r44.y + (r35 * ((float) Math.sin(r47))));
        goto L94
    L89:
        if ((r13 % 360.0f) > Utils.FLOAT_EPSILON) goto L91;
        this.mPathBuffer.addCircle(r7.x, r7.y, r35, Path.Direction.CCW);
        r44 = r7;
        r34 = r34;
        goto L95
    L79:
        if (r35 == 0.0f) goto L82;
        r38 = r22 / (r35 * 0.017453292f);
        goto L83
    L76:
        r28 = r28;
        r111 = true;
        r35 = r28;
    L60:
        if (r21 == false) goto L63;
        this.mPathBuffer.arcTo(r3, r18 + 180.0f, -180.0f);
    L63:
        this.mPathBuffer.arcTo(r29, r18, r13);
        goto L64
    L49:
        r13 = r210;
        goto L50
    L45:
        r27 = r22 / (r25 * 0.017453292f);
        goto L46
    L39:
        if (r24 > 180.0f) goto L41;
        r2 = true;
        goto L42
    L104:
        MPPointF.recycleInstance(r7);
        return;
    L26:
        r22 = getSliceSpace(r9);
        goto L27
    L15:
        if (this.mChart.isDrawRoundedSlicesEnabled() == false) goto L17;
        r21 = true;
        goto L18
    L11:
        r4 = 0.0f;
        goto L12
    L5:
        if (this.mChart.isDrawSlicesUnderHoleEnabled() == true) goto L7;
        r17 = true;
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void drawValues(Canvas r53) {
        Canvas r7 = r53;
        MPPointF r8 = this.mChart.getCenterCircleBox();
        float r9 = this.mChart.getRadius();
        float r0 = this.mChart.getRotationAngle();
        float[] r10 = this.mChart.getDrawAngles();
        float[] r11 = this.mChart.getAbsoluteAngles();
        float r12 = this.mAnimator.getPhaseX();
        float r13 = this.mAnimator.getPhaseY();
        float r1 = (r9 - ((this.mChart.getHoleRadius() * r9) / 100.0f)) / 2.0f;
        float r16 = this.mChart.getHoleRadius() / 100.0f;
        float r2 = (r9 / 10.0f) * 3.6f;
        if (this.mChart.isDrawHoleEnabled() == false) goto L9;
        r2 = (r9 - (r9 * r16)) / 2.0f;
        if (this.mChart.isDrawSlicesUnderHoleEnabled() == true) goto L9;
        if (this.mChart.isDrawRoundedSlicesEnabled() == false) goto L9;
        r0 = (float) (((double) r0) + (((double) (r1 * 360.0f)) / (((double) r9) * 6.283185307179586d)));
    L9:
        float r14 = r0;
        float r15 = r9 - r2;
        PieData r17 = (PieData) this.mChart.getData();
        List<IPieDataSet> r5 = r17.getDataSets();
        float r18 = r17.getYValueSum();
        boolean r21 = this.mChart.isDrawEntryLabelsEnabled();
        r53.save();
        float r22 = Utils.convertDpToPixel(5.0f);
        int r3 = 0;
        int r4 = 0;
    L11:
        if (r4 >= r5.size()) goto L126;
        IPieDataSet r6 = r5.get(r4);
        boolean r24 = r6.isDrawValuesEnabled();
        if (r24 == true) goto L16;
        if (r21 == true) goto L16;
        float r44 = r9;
        float[] r34 = r10;
        float[] r36 = r11;
        float r37 = r12;
        float r38 = r13;
        float r40 = r14;
        float r35 = r15;
        Canvas r19 = r7;
        MPPointF r110 = r8;
    L125:
        r4 = r4 + 1;
        r7 = r19;
        r8 = r110;
        r5 = r5;
        r10 = r34;
        r15 = r35;
        r11 = r36;
        r12 = r37;
        r13 = r38;
        r14 = r40;
        r9 = r44;
    L16:
        PieDataSet.ValuePosition r20 = r6.getXValuePosition();
        PieDataSet.ValuePosition r23 = r6.getYValuePosition();
        applyValueTextStyle(r6);
        int r25 = r3;
        float r27 = Utils.calcTextHeight(this.mValuePaint, "Q") + Utils.convertDpToPixel(4.0f);
        ValueFormatter r26 = r6.getValueFormatter();
        int r28 = r6.getEntryCount();
        this.mValueLinePaint.setColor(r6.getValueLineColor());
        this.mValueLinePaint.setStrokeWidth(Utils.convertDpToPixel(r6.getValueLineWidth()));
        float r29 = getSliceSpace(r6);
        MPPointF r30 = MPPointF.getInstance(r6.getIconsOffset());
        MPPointF r210 = r8;
        r30.x = Utils.convertDpToPixel(r30.x);
        r30.y = Utils.convertDpToPixel(r30.y);
        int r31 = 0;
    L17:
        if (r31 >= r28) goto L124;
        MPPointF r32 = r30;
        PieEntry r33 = r6.getEntryForIndex(r31);
        if (r25 != 0) goto L21;
        float r39 = 0.0f;
    L22:
        int r310 = r28;
        float r41 = r14 + ((r39 + ((r10[r25] - ((r29 / (r15 * 0.017453292f)) / 2.0f)) / 2.0f)) * r13);
        float r311 = r29;
        if (this.mChart.isUsePercentValuesEnabled() == false) goto L25;
        float r42 = (r33.getY() / r18) * 100.0f;
    L26:
        String r43 = r26.getPieLabel(r42, r33);
        float[] r312 = r10;
        String r111 = r33.getLabel();
        ValueFormatter r313 = r26;
        PieEntry r314 = r33;
        double r45 = r41 * 0.017453292f;
        float[] r315 = r11;
        float r316 = r12;
        float r112 = (float) Math.cos(r45);
        float r317 = r13;
        float r113 = (float) Math.sin(r45);
        if (r21 == true) goto L29;
    L31:
        boolean r114 = false;
    L32:
        float r46 = r14;
        if (r24 == true) goto L35;
    L37:
        boolean r115 = false;
    L39:
        if (r21 == true) goto L41;
    L43:
        boolean r116 = false;
    L44:
        PieDataSet.ValuePosition r47 = r20;
        if (r24 == true) goto L47;
    L49:
        boolean r318 = false;
    L50:
        if (r114 == true) goto L54;
        if (r115 == true) goto L54;
        PieDataSet.ValuePosition r48 = r23;
        float r49 = r9;
        boolean r410 = r116;
        float r411 = r112;
        MPPointF r50 = r210;
        r32 = r32;
        r314 = r314;
        r313 = r313;
        String r117 = r111;
        Canvas r51 = r53;
        float r211 = r113;
        r15 = r15;
        IPieDataSet r118 = r6;
    L97:
        if (r410 == true) goto L102;
        if (r318 == true) goto L102;
        MPPointF r119 = r50;
    L118:
        if (r314.getIcon() != null) goto L120;
    L122:
        MPPointF r52 = r32;
    L123:
        r25 = r25 + 1;
        r31 = r31 + 1;
        r30 = r52;
        r210 = r119;
        r6 = r118;
        r29 = r311;
        r28 = r310;
        r10 = r312;
        r15 = r15;
        r11 = r315;
        r12 = r316;
        r13 = r317;
        r14 = r46;
        r20 = r47;
        r9 = r49;
        r23 = r48;
        r26 = r313;
        goto L17
    L120:
        if (r118.isDrawIconsEnabled() == false) goto L122;
        Drawable r54 = r314.getIcon();
        r52 = r32;
        Utils.drawImage(r53, r54, (int) (((r15 + r52.y) * r411) + r119.x), (int) ((((r15 + r52.y) * r211) + r119.y) + r52.x), r54.getIntrinsicWidth(), r54.getIntrinsicHeight());
    L102:
        r119 = r50;
        float r120 = (r15 * r411) + r119.x;
        float r121 = (r15 * r211) + r119.y;
        this.mValuePaint.setTextAlign(Paint.Align.CENTER);
        if (r410 == false) goto L109;
        if (r318 == false) goto L109;
        drawValue(r53, r43, r120, r121, r118.getValueTextColor(r31));
        if (r31 >= r17.getEntryCount()) goto L118;
        if (r117 == null) goto L118;
        drawEntryLabel(r51, r117, r120, r121 + r27);
    L109:
        if (r410 == false) goto L115;
        if (r31 >= r17.getEntryCount()) goto L118;
        if (r117 == null) goto L118;
        drawEntryLabel(r51, r117, r120, r121 + (r27 / 2.0f));
        goto L118
    L115:
        if (r318 == false) goto L118;
        drawValue(r53, r43, r120, r121 + (r27 / 2.0f), r118.getValueTextColor(r31));
    L54:
        float r55 = r6.getValueLinePart1Length();
        float r412 = r6.getValueLinePart2Length();
        float r413 = r6.getValueLinePart1OffsetPercentage() / 100.0f;
        r48 = r23;
        if (this.mChart.isDrawHoleEnabled() == false) goto L57;
        float r56 = r9 * r16;
        float r414 = ((r9 - r56) * r413) + r56;
    L59:
        if (r6.isValueLineVariableLength() == false) goto L61;
        float r415 = (r412 * r15) * ((float) Math.abs(Math.sin(r45)));
    L62:
        r50 = r210;
        float r57 = (r414 * r112) + r50.x;
        float r58 = (r414 * r113) + r50.y;
        float r59 = (r55 + 1.0f) * r15;
        r49 = r9;
        float r60 = (r59 * r112) + r50.x;
        r211 = r113;
        float r122 = r50.y + (r59 * r113);
        r410 = r116;
        r411 = r112;
        double r123 = ((double) r41) % 360.0d;
        if (r123 >= 90.0d) goto L65;
    L70:
        float r416 = r60 + r415;
        this.mValuePaint.setTextAlign(Paint.Align.LEFT);
        if (r114 == false) goto L73;
        this.mEntryLabelsPaint.setTextAlign(Paint.Align.LEFT);
    L73:
        float r124 = r416 + r22;
    L75:
        if (r6.getValueLineColor() != 1122867) goto L77;
        r118 = r6;
    L81:
        if (r114 == false) goto L88;
        if (r115 == false) goto L88;
        drawValue(r53, r43, r124, r122, r118.getValueTextColor(r31));
        if (r31 >= r17.getEntryCount()) goto L87;
        if (r111 == null) goto L87;
        r51 = r53;
        r117 = r111;
        drawEntryLabel(r51, r117, r124, r122 + r27);
    L87:
        r51 = r53;
        r117 = r111;
    L88:
        r51 = r53;
        r117 = r111;
        if (r114 == false) goto L95;
        if (r31 >= r17.getEntryCount()) goto L97;
        if (r117 == null) goto L97;
        drawEntryLabel(r51, r117, r124, r122 + (r27 / 2.0f));
        goto L97
    L95:
        if (r115 == false) goto L97;
        drawValue(r53, r43, r124, r122 + (r27 / 2.0f), r118.getValueTextColor(r31));
        goto L97
    L77:
        if (r6.isUsingSliceColorAsValueLineColor() == false) goto L79;
        this.mValueLinePaint.setColor(r6.getColor(r31));
    L79:
        r118 = r6;
        r53.drawLine(r57, r58, r60, r122, this.mValueLinePaint);
        r53.drawLine(r60, r122, r416, r122, this.mValueLinePaint);
        goto L81
    L65:
        if (r123 > 270.0d) goto L70;
        float r61 = r60 - r415;
        this.mValuePaint.setTextAlign(Paint.Align.RIGHT);
        if (r114 == false) goto L69;
        this.mEntryLabelsPaint.setTextAlign(Paint.Align.RIGHT);
    L69:
        r416 = r61;
        r124 = r61 - r22;
        goto L75
    L61:
        r415 = r412 * r15;
        goto L62
    L57:
        r414 = r9 * r413;
        goto L59
    L47:
        if (r23 != PieDataSet.ValuePosition.INSIDE_SLICE) goto L49;
        r318 = true;
        goto L50
    L41:
        if (r20 != PieDataSet.ValuePosition.INSIDE_SLICE) goto L43;
        r116 = true;
        goto L44
    L35:
        if (r23 != PieDataSet.ValuePosition.OUTSIDE_SLICE) goto L37;
        r115 = true;
        goto L39
    L29:
        if (r20 != PieDataSet.ValuePosition.OUTSIDE_SLICE) goto L31;
        r114 = true;
        goto L32
    L25:
        r42 = r33.getY();
        goto L26
    L21:
        r39 = r11[r25 - 1] * r12;
        goto L22
    L124:
        r44 = r9;
        r34 = r10;
        r36 = r11;
        r37 = r12;
        r38 = r13;
        r40 = r14;
        r35 = r15;
        r110 = r210;
        r19 = r53;
        MPPointF.recycleInstance(r30);
        r3 = r25;
        goto L125
    L126:
        MPPointF.recycleInstance(r8);
        r53.restore();
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void drawValue(Canvas r2, String r3, float r4, float r5, int r6) {
        this.mValuePaint.setColor(r6);
        r2.drawText(r3, r4, r5, this.mValuePaint);
    }

    protected void drawEntryLabel(Canvas r1, String r2, float r3, float r4) {
        r1.drawText(r2, r3, r4, this.mEntryLabelsPaint);
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void drawExtras(Canvas r4) {
        drawHole(r4);
        r4.drawBitmap(this.mDrawBitmap.get(), 0.0f, 0.0f, null);
        drawCenterText(r4);
    }

    protected void drawHole(Canvas r8) {
        if (this.mChart.isDrawHoleEnabled() == true) goto L5;
        return;
    L5:
        if (this.mBitmapCanvas == null) goto L17;
        float r9 = this.mChart.getRadius();
        float r0 = (this.mChart.getHoleRadius() / 100.0f) * r9;
        MPPointF r2 = this.mChart.getCenterCircleBox();
        if (Color.alpha(this.mHolePaint.getColor()) <= 0) goto L10;
        this.mBitmapCanvas.drawCircle(r2.x, r2.y, r0, this.mHolePaint);
    L10:
        if (Color.alpha(this.mTransparentCirclePaint.getColor()) > 0) goto L12;
    L14:
        MPPointF.recycleInstance(r2);
        return;
    L12:
        if (this.mChart.getTransparentCircleRadius() <= this.mChart.getHoleRadius()) goto L14;
        int r3 = this.mTransparentCirclePaint.getAlpha();
        float r10 = r9 * (this.mChart.getTransparentCircleRadius() / 100.0f);
        this.mTransparentCirclePaint.setAlpha((int) ((r3 * this.mAnimator.getPhaseX()) * this.mAnimator.getPhaseY()));
        this.mHoleCirclePath.reset();
        this.mHoleCirclePath.addCircle(r2.x, r2.y, r10, Path.Direction.CW);
        this.mHoleCirclePath.addCircle(r2.x, r2.y, r0, Path.Direction.CCW);
        this.mBitmapCanvas.drawPath(this.mHoleCirclePath, this.mTransparentCirclePaint);
        this.mTransparentCirclePaint.setAlpha(r3);
        goto L14
    }

    protected void drawCenterText(Canvas r20) {
        CharSequence r4 = this.mChart.getCenterText();
        if (this.mChart.isDrawCenterTextEnabled() == false) goto L23;
        if (r4 == null) goto L24;
        MPPointF r2 = this.mChart.getCenterCircleBox();
        MPPointF r13 = this.mChart.getCenterTextOffset();
        float r3 = r2.x + r13.x;
        float r5 = r2.y + r13.y;
        if (this.mChart.isDrawHoleEnabled() == true) goto L8;
    L10:
        float r6 = this.mChart.getRadius();
    L11:
        RectF r14 = this.mRectBuffer[0];
        r14.left = r3 - r6;
        r14.top = r5 - r6;
        r14.right = r3 + r6;
        r14.bottom = r5 + r6;
        RectF r15 = this.mRectBuffer[1];
        r15.set(r14);
        float r7 = this.mChart.getCenterTextRadiusPercent() / 100.0f;
        if (r7 <= 0.0d) goto L15;
        r15.inset((r15.width() - (r15.width() * r7)) / 2.0f, (r15.height() - (r15.height() * r7)) / 2.0f);
    L15:
        if (r4.equals(this.mCenterTextLastValue) == true) goto L17;
    L20:
        this.mCenterTextLastBounds.set(r15);
        this.mCenterTextLastValue = r4;
        this.mCenterTextLayout = new StaticLayout(r4, 0, r4.length(), this.mCenterTextPaint, (int) Math.max(Math.ceil(this.mCenterTextLastBounds.width()), 1.0d), Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, false);
    L21:
        float r8 = this.mCenterTextLayout.getHeight();
        r20.save();
        Path r9 = this.mDrawCenterTextPathBuffer;
        r9.reset();
        r9.addOval(r14, Path.Direction.CW);
        r20.clipPath(r9);
        r20.translate(r15.left, r15.top + ((r15.height() - r8) / 2.0f));
        this.mCenterTextLayout.draw(r20);
        r20.restore();
        MPPointF.recycleInstance(r2);
        MPPointF.recycleInstance(r13);
        return;
    L17:
        if (r15.equals(this.mCenterTextLastBounds) == true) goto L21;
    L8:
        if (this.mChart.isDrawSlicesUnderHoleEnabled() == true) goto L10;
        r6 = this.mChart.getRadius() * (this.mChart.getHoleRadius() / 100.0f);
        goto L11
    L24:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void drawHighlighted(Canvas r35, Highlight[] r36) {
        if (this.mChart.isDrawHoleEnabled() == true) goto L5;
    L7:
        boolean r12 = false;
    L8:
        if (r12 == true) goto L10;
    L12:
        float r13 = this.mAnimator.getPhaseX();
        float r14 = this.mAnimator.getPhaseY();
        float r15 = this.mChart.getRotationAngle();
        float[] r7 = this.mChart.getDrawAngles();
        float[] r16 = this.mChart.getAbsoluteAngles();
        MPPointF r6 = this.mChart.getCenterCircleBox();
        float r17 = this.mChart.getRadius();
        if (r12 == false) goto L15;
        float r4 = (this.mChart.getHoleRadius() / 100.0f) * r17;
    L16:
        RectF r3 = this.mDrawHighlightedRectF;
        r3.set(0.0f, 0.0f, 0.0f, 0.0f);
        int r2 = 0;
    L18:
        if (r2 >= r36.length) goto L103;
        int r0 = (int) r36[r2].getX();
        if (r0 >= r7.length) goto L101;
        IPieDataSet r1 = ((PieData) this.mChart.getData()).getDataSetByIndex(r36[r2].getDataSetIndex());
        if (r1 == null) goto L101;
        if (r1.isHighlightEnabled() == false) goto L101;
        int r10 = r1.getEntryCount();
        int r5 = 0;
        int r11 = 0;
    L28:
        if (r5 >= r10) goto L33;
        if (Math.abs(r1.getEntryForIndex(r5).getY()) <= Utils.FLOAT_EPSILON) goto L32;
        r11 = r11 + 1;
    L32:
        r5 = r5 + 1;
        goto L28
    L33:
        if (r0 != 0) goto L35;
        int r8 = 1;
        float r18 = 0.0f;
    L36:
        if (r11 > r8) goto L38;
        float r19 = 0.0f;
    L39:
        float r20 = r7[r0];
        float r9 = r1.getSelectionShift();
        float r21 = r17 + r9;
        r3.set(this.mChart.getCircleBox());
        float r22 = -r9;
        r3.inset(r22, r22);
        if (r19 > 0.0f) goto L42;
    L44:
        boolean r23 = false;
    L45:
        this.mRenderPaint.setColor(r1.getColor(r0));
        if (r11 != 1) goto L48;
        float r24 = 0.0f;
    L49:
        if (r11 != 1) goto L51;
        float r25 = 0.0f;
    L52:
        float r26 = r15 + (((r24 / 2.0f) + r18) * r14);
        float r27 = (r20 - r24) * r14;
        if (r27 >= 0.0f) goto L55;
        float r110 = 0.0f;
    L56:
        float r28 = (((r25 / 2.0f) + r18) * r14) + r15;
        float r29 = (r20 - r25) * r14;
        if (r29 >= 0.0f) goto L59;
        r29 = 0.0f;
    L59:
        this.mPathBuffer.reset();
        if (r110 >= 360.0f) goto L62;
    L64:
        double r30 = r28 * 0.017453292f;
        this.mPathBuffer.moveTo(r6.x + (((float) Math.cos(r30)) * r21), r6.y + (r21 * ((float) Math.sin(r30))));
        this.mPathBuffer.arcTo(r3, r28, r29);
    L65:
        if (r23 == false) goto L67;
        double r31 = r26 * 0.017453292f;
        float r32 = (((float) Math.cos(r31)) * r17) + r6.x;
        float r33 = r6.y + (((float) Math.sin(r31)) * r17);
        MPPointF r111 = r6;
        float r34 = calculateMinimumRadiusForSpacedSlice(r6, r17, r20 * r14, r32, r33, r26, r110);
    L68:
        this.mInnerRectBuffer.set(r111.x - r22, r111.y - r22, r111.x + r22, r111.y + r22);
        if (r12 != 0) goto L71;
    L95:
        float r37 = r13;
        float r112 = r14;
        if ((r110 % 360.0f) <= Utils.FLOAT_EPSILON) goto L100;
        if (r23 == false) goto L99;
        double r38 = (r26 + (r110 / 2.0f)) * 0.017453292f;
        this.mPathBuffer.lineTo(r111.x + (((float) Math.cos(r38)) * r34), r111.y + (r34 * ((float) Math.sin(r38))));
        goto L100
    L99:
        this.mPathBuffer.lineTo(r111.x, r111.y);
    L100:
        this.mPathBuffer.close();
        this.mBitmapCanvas.drawPath(this.mPathBuffer, this.mRenderPaint);
    L102:
        r2 = r2 + 1;
        r13 = r37;
        r3 = r3;
        r4 = r4;
        r6 = r111;
        r14 = r112;
        r7 = r7;
        r12 = r12;
        goto L18
    L71:
        if (r22 > 0.0f) goto L73;
        if (r23 == false) goto L95;
    L73:
        if (r23 == true) goto L75;
        float r39 = r22;
    L80:
        if (r11 != 1) goto L82;
    L85:
        float r40 = 0.0f;
    L86:
        float r41 = ((r18 + (r40 / 2.0f)) * r14) + r15;
        float r42 = (r20 - r40) * r14;
        if (r42 >= 0.0f) goto L89;
        r42 = 0.0f;
    L89:
        float r43 = r41 + r42;
        if (r110 >= 360.0f) goto L92;
    L94:
        double r44 = r43 * 0.017453292f;
        r37 = r13;
        r112 = r14;
        this.mPathBuffer.lineTo(r111.x + (((float) Math.cos(r44)) * r39), r111.y + (r39 * ((float) Math.sin(r44))));
        this.mPathBuffer.arcTo(this.mInnerRectBuffer, r43, -r42);
        goto L100
    L92:
        if ((r110 % 360.0f) > Utils.FLOAT_EPSILON) goto L94;
        this.mPathBuffer.addCircle(r111.x, r111.y, r39, Path.Direction.CCW);
        r37 = r13;
        r112 = r14;
        goto L100
    L82:
        if (r39 == 0.0f) goto L85;
        r40 = r19 / (r39 * 0.017453292f);
        goto L86
    L75:
        if (r34 >= 0.0f) goto L77;
        r34 = -r34;
    L77:
        r39 = Math.max(r22, r34);
        goto L80
    L67:
        r111 = r6;
        r34 = 0.0f;
        goto L68
    L62:
        if ((r110 % 360.0f) > Utils.FLOAT_EPSILON) goto L64;
        this.mPathBuffer.addCircle(r6.x, r6.y, r21, Path.Direction.CW);
        goto L65
    L55:
        r110 = r27;
        goto L56
    L51:
        r25 = r19 / (r21 * 0.017453292f);
        goto L52
    L48:
        r24 = r19 / (r17 * 0.017453292f);
        goto L49
    L42:
        if (r20 > 180.0f) goto L44;
        r23 = true;
        goto L45
    L38:
        r19 = r1.getSliceSpace();
        goto L39
    L35:
        r18 = r16[r0 - 1] * r13;
        r8 = 1;
    L101:
        r3 = r3;
        r7 = r7;
        r12 = r12;
        r37 = r13;
        r112 = r14;
        r111 = r6;
        goto L102
    L103:
        MPPointF.recycleInstance(r6);
        return;
    L15:
        r4 = 0.0f;
        goto L16
    L10:
        if (this.mChart.isDrawRoundedSlicesEnabled() == false) goto L12;
        return;
    L5:
        if (this.mChart.isDrawSlicesUnderHoleEnabled() == true) goto L7;
        r12 = true;
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void drawRoundedSlices(Canvas r20) {
        if (this.mChart.isDrawRoundedSlicesEnabled() == true) goto L5;
        return;
    L5:
        IPieDataSet r1 = ((PieData) this.mChart.getData()).getDataSet();
        if (r1.isVisible() == true) goto L8;
        return;
    L8:
        float r2 = this.mAnimator.getPhaseX();
        float r3 = this.mAnimator.getPhaseY();
        MPPointF r4 = this.mChart.getCenterCircleBox();
        float r5 = this.mChart.getRadius();
        float r6 = (r5 - ((this.mChart.getHoleRadius() * r5) / 100.0f)) / 2.0f;
        float[] r7 = this.mChart.getDrawAngles();
        float r8 = this.mChart.getRotationAngle();
        int r9 = 0;
    L10:
        if (r9 >= r1.getEntryCount()) goto L16;
        float r10 = r7[r9];
        if (Math.abs(r1.getEntryForIndex(r9).getY()) <= Utils.FLOAT_EPSILON) goto L15;
        double r11 = r5 - r6;
        double r13 = (r8 + r10) * r3;
        float r12 = (float) (((double) r4.x) + (Math.cos(Math.toRadians(r13)) * r11));
        float r14 = (float) ((r11 * Math.sin(Math.toRadians(r13))) + ((double) r4.y));
        this.mRenderPaint.setColor(r1.getColor(r9));
        this.mBitmapCanvas.drawCircle(r12, r14, r6, this.mRenderPaint);
    L15:
        r8 = r8 + (r10 * r2);
        r9 = r9 + 1;
        r3 = r3;
        r7 = r7;
        goto L10
    L16:
        MPPointF.recycleInstance(r4);
    }

    public void releaseBitmap() {
        Canvas r0 = this.mBitmapCanvas;
        if (r0 == null) goto L5;
        r0.setBitmap(null);
        this.mBitmapCanvas = null;
    L5:
        WeakReference<Bitmap> r1 = this.mDrawBitmap;
        if (r1 == null) goto L12;
        Bitmap r2 = r1.get();
        if (r2 == null) goto L10;
        r2.recycle();
    L10:
        this.mDrawBitmap.clear();
        this.mDrawBitmap = null;
        return;
    }
}
