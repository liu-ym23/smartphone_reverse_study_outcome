package com.github.mikephil.charting.charts;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarLineScatterCandleBubbleData;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.highlight.ChartHighlighter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.dataprovider.BarLineScatterCandleBubbleDataProvider;
import com.github.mikephil.charting.interfaces.datasets.IBarLineScatterCandleBubbleDataSet;
import com.github.mikephil.charting.jobs.AnimatedMoveViewJob;
import com.github.mikephil.charting.jobs.AnimatedZoomJob;
import com.github.mikephil.charting.jobs.MoveViewJob;
import com.github.mikephil.charting.jobs.ZoomJob;
import com.github.mikephil.charting.listener.BarLineChartTouchListener;
import com.github.mikephil.charting.listener.OnDrawListener;
import com.github.mikephil.charting.renderer.XAxisRenderer;
import com.github.mikephil.charting.renderer.YAxisRenderer;
import com.github.mikephil.charting.utils.MPPointD;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.Utils;

/* JADX INFO: loaded from: classes2.dex */
public abstract class BarLineChartBase<T extends BarLineScatterCandleBubbleData<? extends IBarLineScatterCandleBubbleDataSet<? extends Entry>>> extends Chart<T> implements BarLineScatterCandleBubbleDataProvider {
    private long drawCycles;
    protected boolean mAutoScaleMinMaxEnabled;
    protected YAxis mAxisLeft;
    protected YAxisRenderer mAxisRendererLeft;
    protected YAxisRenderer mAxisRendererRight;
    protected YAxis mAxisRight;
    protected Paint mBorderPaint;
    protected boolean mClipValuesToContent;
    private boolean mCustomViewPortEnabled;
    protected boolean mDoubleTapToZoomEnabled;
    private boolean mDragXEnabled;
    private boolean mDragYEnabled;
    protected boolean mDrawBorders;
    protected boolean mDrawGridBackground;
    protected OnDrawListener mDrawListener;
    protected Matrix mFitScreenMatrixBuffer;
    protected float[] mGetPositionBuffer;
    protected Paint mGridBackgroundPaint;
    protected boolean mHighlightPerDragEnabled;
    protected boolean mKeepPositionOnRotation;
    protected Transformer mLeftAxisTransformer;
    protected int mMaxVisibleCount;
    protected float mMinOffset;
    private RectF mOffsetsBuffer;
    protected float[] mOnSizeChangedBuffer;
    protected boolean mPinchZoomEnabled;
    protected Transformer mRightAxisTransformer;
    private boolean mScaleXEnabled;
    private boolean mScaleYEnabled;
    protected XAxisRenderer mXAxisRenderer;
    protected Matrix mZoomMatrixBuffer;
    protected MPPointD posForGetHighestVisibleX;
    protected MPPointD posForGetLowestVisibleX;
    private long totalTime;

    /* JADX INFO: renamed from: com.github.mikephil.charting.charts.BarLineChartBase$2, reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$github$mikephil$charting$components$Legend$LegendHorizontalAlignment = null;
        static final /* synthetic */ int[] $SwitchMap$com$github$mikephil$charting$components$Legend$LegendOrientation = null;
        static final /* synthetic */ int[] $SwitchMap$com$github$mikephil$charting$components$Legend$LegendVerticalAlignment = null;

        static {
            int[] r0 = new int[Legend.LegendOrientation.values().length];
            $SwitchMap$com$github$mikephil$charting$components$Legend$LegendOrientation = r0;
            r0[Legend.LegendOrientation.VERTICAL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L14
        L21:
            $SwitchMap$com$github$mikephil$charting$components$Legend$LegendOrientation[Legend.LegendOrientation.HORIZONTAL.ordinal()] = 2;     // Catch: NoSuchFieldError -> L15
        L6:
            int[] r2 = new int[Legend.LegendHorizontalAlignment.values().length];
            $SwitchMap$com$github$mikephil$charting$components$Legend$LegendHorizontalAlignment = r2;
            r2[Legend.LegendHorizontalAlignment.LEFT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L16
        L27:
            $SwitchMap$com$github$mikephil$charting$components$Legend$LegendHorizontalAlignment[Legend.LegendHorizontalAlignment.RIGHT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L17
        L33:
            $SwitchMap$com$github$mikephil$charting$components$Legend$LegendHorizontalAlignment[Legend.LegendHorizontalAlignment.CENTER.ordinal()] = 3;     // Catch: NoSuchFieldError -> L18
        L10:
            int[] r3 = new int[Legend.LegendVerticalAlignment.values().length];
            $SwitchMap$com$github$mikephil$charting$components$Legend$LegendVerticalAlignment = r3;
            r3[Legend.LegendVerticalAlignment.TOP.ordinal()] = 1;     // Catch: NoSuchFieldError -> L19
        L23:
            $SwitchMap$com$github$mikephil$charting$components$Legend$LegendVerticalAlignment[Legend.LegendVerticalAlignment.BOTTOM.ordinal()] = 2;     // Catch: NoSuchFieldError -> L20
            return;
        }
    }

    @Override // com.github.mikephil.charting.charts.Chart, com.github.mikephil.charting.interfaces.dataprovider.ChartInterface, com.github.mikephil.charting.interfaces.dataprovider.BarLineScatterCandleBubbleDataProvider
    public /* bridge */ /* synthetic */ BarLineScatterCandleBubbleData getData() {
        return (BarLineScatterCandleBubbleData) super.getData();
    }

    public BarLineChartBase(Context r2, AttributeSet r3, int r4) {
        super(r2, r3, r4);
        this.mMaxVisibleCount = 100;
        this.mAutoScaleMinMaxEnabled = false;
        this.mPinchZoomEnabled = false;
        this.mDoubleTapToZoomEnabled = true;
        this.mHighlightPerDragEnabled = true;
        this.mDragXEnabled = true;
        this.mDragYEnabled = true;
        this.mScaleXEnabled = true;
        this.mScaleYEnabled = true;
        this.mDrawGridBackground = false;
        this.mDrawBorders = false;
        this.mClipValuesToContent = false;
        this.mMinOffset = 15.0f;
        this.mKeepPositionOnRotation = false;
        this.totalTime = 0;
        this.drawCycles = 0;
        this.mOffsetsBuffer = new RectF();
        this.mZoomMatrixBuffer = new Matrix();
        this.mFitScreenMatrixBuffer = new Matrix();
        this.mCustomViewPortEnabled = false;
        this.mGetPositionBuffer = new float[2];
        this.posForGetLowestVisibleX = MPPointD.getInstance(0.0d, 0.0d);
        this.posForGetHighestVisibleX = MPPointD.getInstance(0.0d, 0.0d);
        this.mOnSizeChangedBuffer = new float[2];
    }

    public BarLineChartBase(Context r3, AttributeSet r4) {
        super(r3, r4);
        this.mMaxVisibleCount = 100;
        this.mAutoScaleMinMaxEnabled = false;
        this.mPinchZoomEnabled = false;
        this.mDoubleTapToZoomEnabled = true;
        this.mHighlightPerDragEnabled = true;
        this.mDragXEnabled = true;
        this.mDragYEnabled = true;
        this.mScaleXEnabled = true;
        this.mScaleYEnabled = true;
        this.mDrawGridBackground = false;
        this.mDrawBorders = false;
        this.mClipValuesToContent = false;
        this.mMinOffset = 15.0f;
        this.mKeepPositionOnRotation = false;
        this.totalTime = 0;
        this.drawCycles = 0;
        this.mOffsetsBuffer = new RectF();
        this.mZoomMatrixBuffer = new Matrix();
        this.mFitScreenMatrixBuffer = new Matrix();
        this.mCustomViewPortEnabled = false;
        this.mGetPositionBuffer = new float[2];
        this.posForGetLowestVisibleX = MPPointD.getInstance(0.0d, 0.0d);
        this.posForGetHighestVisibleX = MPPointD.getInstance(0.0d, 0.0d);
        this.mOnSizeChangedBuffer = new float[2];
    }

    public BarLineChartBase(Context r4) {
        super(r4);
        this.mMaxVisibleCount = 100;
        this.mAutoScaleMinMaxEnabled = false;
        this.mPinchZoomEnabled = false;
        this.mDoubleTapToZoomEnabled = true;
        this.mHighlightPerDragEnabled = true;
        this.mDragXEnabled = true;
        this.mDragYEnabled = true;
        this.mScaleXEnabled = true;
        this.mScaleYEnabled = true;
        this.mDrawGridBackground = false;
        this.mDrawBorders = false;
        this.mClipValuesToContent = false;
        this.mMinOffset = 15.0f;
        this.mKeepPositionOnRotation = false;
        this.totalTime = 0;
        this.drawCycles = 0;
        this.mOffsetsBuffer = new RectF();
        this.mZoomMatrixBuffer = new Matrix();
        this.mFitScreenMatrixBuffer = new Matrix();
        this.mCustomViewPortEnabled = false;
        this.mGetPositionBuffer = new float[2];
        this.posForGetLowestVisibleX = MPPointD.getInstance(0.0d, 0.0d);
        this.posForGetHighestVisibleX = MPPointD.getInstance(0.0d, 0.0d);
        this.mOnSizeChangedBuffer = new float[2];
    }

    @Override // com.github.mikephil.charting.charts.Chart
    protected void init() {
        super.init();
        this.mAxisLeft = new YAxis(YAxis.AxisDependency.LEFT);
        this.mAxisRight = new YAxis(YAxis.AxisDependency.RIGHT);
        this.mLeftAxisTransformer = new Transformer(this.mViewPortHandler);
        this.mRightAxisTransformer = new Transformer(this.mViewPortHandler);
        this.mAxisRendererLeft = new YAxisRenderer(this.mViewPortHandler, this.mAxisLeft, this.mLeftAxisTransformer);
        this.mAxisRendererRight = new YAxisRenderer(this.mViewPortHandler, this.mAxisRight, this.mRightAxisTransformer);
        this.mXAxisRenderer = new XAxisRenderer(this.mViewPortHandler, this.mXAxis, this.mLeftAxisTransformer);
        setHighlighter(new ChartHighlighter(this));
        this.mChartTouchListener = new BarLineChartTouchListener(this, this.mViewPortHandler.getMatrixTouch(), 3.0f);
        Paint r0 = new Paint();
        this.mGridBackgroundPaint = r0;
        r0.setStyle(Paint.Style.FILL);
        this.mGridBackgroundPaint.setColor(Color.rgb(240, 240, 240));
        Paint r1 = new Paint();
        this.mBorderPaint = r1;
        r1.setStyle(Paint.Style.STROKE);
        this.mBorderPaint.setColor(-16777216);
        this.mBorderPaint.setStrokeWidth(Utils.convertDpToPixel(1.0f));
    }

    @Override // com.github.mikephil.charting.charts.Chart, android.view.View
    protected void onDraw(Canvas r9) {
        super.onDraw(r9);
        if (this.mData != 0) goto L5;
        return;
    L5:
        long r0 = System.currentTimeMillis();
        drawGridBackground(r9);
        if (this.mAutoScaleMinMaxEnabled == false) goto L9;
        autoScale();
    L9:
        if (this.mAxisLeft.isEnabled() == false) goto L12;
        this.mAxisRendererLeft.computeAxis(this.mAxisLeft.mAxisMinimum, this.mAxisLeft.mAxisMaximum, this.mAxisLeft.isInverted());
    L12:
        if (this.mAxisRight.isEnabled() == false) goto L15;
        this.mAxisRendererRight.computeAxis(this.mAxisRight.mAxisMinimum, this.mAxisRight.mAxisMaximum, this.mAxisRight.isInverted());
    L15:
        if (this.mXAxis.isEnabled() == false) goto L17;
        this.mXAxisRenderer.computeAxis(this.mXAxis.mAxisMinimum, this.mXAxis.mAxisMaximum, false);
    L17:
        this.mXAxisRenderer.renderAxisLine(r9);
        this.mAxisRendererLeft.renderAxisLine(r9);
        this.mAxisRendererRight.renderAxisLine(r9);
        if (this.mXAxis.isDrawGridLinesBehindDataEnabled() == false) goto L21;
        this.mXAxisRenderer.renderGridLines(r9);
    L21:
        if (this.mAxisLeft.isDrawGridLinesBehindDataEnabled() == false) goto L24;
        this.mAxisRendererLeft.renderGridLines(r9);
    L24:
        if (this.mAxisRight.isDrawGridLinesBehindDataEnabled() == false) goto L27;
        this.mAxisRendererRight.renderGridLines(r9);
    L27:
        if (this.mXAxis.isEnabled() == false) goto L32;
        if (this.mXAxis.isDrawLimitLinesBehindDataEnabled() == false) goto L32;
        this.mXAxisRenderer.renderLimitLines(r9);
    L32:
        if (this.mAxisLeft.isEnabled() == false) goto L37;
        if (this.mAxisLeft.isDrawLimitLinesBehindDataEnabled() == false) goto L37;
        this.mAxisRendererLeft.renderLimitLines(r9);
    L37:
        if (this.mAxisRight.isEnabled() == true) goto L39;
    L41:
        int r2 = r9.save();
        r9.clipRect(this.mViewPortHandler.getContentRect());
        this.mRenderer.drawData(r9);
        if (this.mXAxis.isDrawGridLinesBehindDataEnabled() == true) goto L45;
        this.mXAxisRenderer.renderGridLines(r9);
    L45:
        if (this.mAxisLeft.isDrawGridLinesBehindDataEnabled() == true) goto L48;
        this.mAxisRendererLeft.renderGridLines(r9);
    L48:
        if (this.mAxisRight.isDrawGridLinesBehindDataEnabled() == true) goto L51;
        this.mAxisRendererRight.renderGridLines(r9);
    L51:
        if (valuesToHighlight() == false) goto L53;
        this.mRenderer.drawHighlighted(r9, this.mIndicesToHighlight);
    L53:
        r9.restoreToCount(r2);
        this.mRenderer.drawExtras(r9);
        if (this.mXAxis.isEnabled() == false) goto L59;
        if (this.mXAxis.isDrawLimitLinesBehindDataEnabled() == true) goto L59;
        this.mXAxisRenderer.renderLimitLines(r9);
    L59:
        if (this.mAxisLeft.isEnabled() == false) goto L64;
        if (this.mAxisLeft.isDrawLimitLinesBehindDataEnabled() == true) goto L64;
        this.mAxisRendererLeft.renderLimitLines(r9);
    L64:
        if (this.mAxisRight.isEnabled() == true) goto L66;
    L68:
        this.mXAxisRenderer.renderAxisLabels(r9);
        this.mAxisRendererLeft.renderAxisLabels(r9);
        this.mAxisRendererRight.renderAxisLabels(r9);
        if (isClipValuesToContentEnabled() == false) goto L71;
        int r3 = r9.save();
        r9.clipRect(this.mViewPortHandler.getContentRect());
        this.mRenderer.drawValues(r9);
        r9.restoreToCount(r3);
    L72:
        this.mLegendRenderer.renderLegend(r9);
        drawDescription(r9);
        drawMarkers(r9);
        if (this.mLogEnabled == false) goto L76;
        long r4 = System.currentTimeMillis() - r0;
        long r1 = this.totalTime + r4;
        this.totalTime = r1;
        long r5 = this.drawCycles + 1;
        this.drawCycles = r5;
        StringBuilder r10 = new StringBuilder("Drawtime: ").append(r4).append(" ms, average: ");
        Log.i(Chart.LOG_TAG, r10.append(r1 / r5).append(" ms, cycles: ").append(this.drawCycles).toString());
        return;
    L76:
        return;
    L71:
        this.mRenderer.drawValues(r9);
        goto L72
    L66:
        if (this.mAxisRight.isDrawLimitLinesBehindDataEnabled() == true) goto L68;
        this.mAxisRendererRight.renderLimitLines(r9);
        goto L68
    L39:
        if (this.mAxisRight.isDrawLimitLinesBehindDataEnabled() == false) goto L41;
        this.mAxisRendererRight.renderLimitLines(r9);
        goto L41
    }

    public void resetTracking() {
        this.totalTime = 0;
        this.drawCycles = 0;
    }

    protected void prepareValuePxMatrix() {
        if (this.mLogEnabled == false) goto L5;
        Log.i(Chart.LOG_TAG, "Preparing Value-Px Matrix, xmin: " + this.mXAxis.mAxisMinimum + ", xmax: " + this.mXAxis.mAxisMaximum + ", xdelta: " + this.mXAxis.mAxisRange);
    L5:
        this.mRightAxisTransformer.prepareMatrixValuePx(this.mXAxis.mAxisMinimum, this.mXAxis.mAxisRange, this.mAxisRight.mAxisRange, this.mAxisRight.mAxisMinimum);
        this.mLeftAxisTransformer.prepareMatrixValuePx(this.mXAxis.mAxisMinimum, this.mXAxis.mAxisRange, this.mAxisLeft.mAxisRange, this.mAxisLeft.mAxisMinimum);
    }

    protected void prepareOffsetMatrix() {
        this.mRightAxisTransformer.prepareMatrixOffset(this.mAxisRight.isInverted());
        this.mLeftAxisTransformer.prepareMatrixOffset(this.mAxisLeft.isInverted());
    }

    @Override // com.github.mikephil.charting.charts.Chart
    public void notifyDataSetChanged() {
        if (this.mData != 0) goto L9;
        if (this.mLogEnabled == false) goto L19;
        Log.i(Chart.LOG_TAG, "Preparing... DATA NOT SET.");
        return;
    L19:
        return;
    L9:
        if (this.mLogEnabled == false) goto L12;
        Log.i(Chart.LOG_TAG, "Preparing...");
    L12:
        if (this.mRenderer == null) goto L14;
        this.mRenderer.initBuffers();
    L14:
        calcMinMax();
        this.mAxisRendererLeft.computeAxis(this.mAxisLeft.mAxisMinimum, this.mAxisLeft.mAxisMaximum, this.mAxisLeft.isInverted());
        this.mAxisRendererRight.computeAxis(this.mAxisRight.mAxisMinimum, this.mAxisRight.mAxisMaximum, this.mAxisRight.isInverted());
        this.mXAxisRenderer.computeAxis(this.mXAxis.mAxisMinimum, this.mXAxis.mAxisMaximum, false);
        if (this.mLegend == null) goto L17;
        this.mLegendRenderer.computeLegend(this.mData);
    L17:
        calculateOffsets();
    }

    protected void autoScale() {
        float r0 = getLowestVisibleX();
        float r1 = getHighestVisibleX();
        ((BarLineScatterCandleBubbleData) this.mData).calcMinMaxY(r0, r1);
        this.mXAxis.calculate(((BarLineScatterCandleBubbleData) this.mData).getXMin(), ((BarLineScatterCandleBubbleData) this.mData).getXMax());
        if (this.mAxisLeft.isEnabled() == false) goto L6;
        this.mAxisLeft.calculate(((BarLineScatterCandleBubbleData) this.mData).getYMin(YAxis.AxisDependency.LEFT), ((BarLineScatterCandleBubbleData) this.mData).getYMax(YAxis.AxisDependency.LEFT));
    L6:
        if (this.mAxisRight.isEnabled() == false) goto L8;
        this.mAxisRight.calculate(((BarLineScatterCandleBubbleData) this.mData).getYMin(YAxis.AxisDependency.RIGHT), ((BarLineScatterCandleBubbleData) this.mData).getYMax(YAxis.AxisDependency.RIGHT));
    L8:
        calculateOffsets();
    }

    @Override // com.github.mikephil.charting.charts.Chart
    protected void calcMinMax() {
        this.mXAxis.calculate(((BarLineScatterCandleBubbleData) this.mData).getXMin(), ((BarLineScatterCandleBubbleData) this.mData).getXMax());
        this.mAxisLeft.calculate(((BarLineScatterCandleBubbleData) this.mData).getYMin(YAxis.AxisDependency.LEFT), ((BarLineScatterCandleBubbleData) this.mData).getYMax(YAxis.AxisDependency.LEFT));
        this.mAxisRight.calculate(((BarLineScatterCandleBubbleData) this.mData).getYMin(YAxis.AxisDependency.RIGHT), ((BarLineScatterCandleBubbleData) this.mData).getYMax(YAxis.AxisDependency.RIGHT));
    }

    protected void calculateLegendOffsets(RectF r5) {
        r5.left = 0.0f;
        r5.right = 0.0f;
        r5.top = 0.0f;
        r5.bottom = 0.0f;
        if (this.mLegend != null) goto L5;
        return;
    L5:
        if (this.mLegend.isEnabled() == true) goto L7;
        return;
    L7:
        if (this.mLegend.isDrawInsideEnabled() == true) goto L35;
        int r0 = AnonymousClass2.$SwitchMap$com$github$mikephil$charting$components$Legend$LegendOrientation[this.mLegend.getOrientation().ordinal()];
        if (r0 == 1) goto L18;
        if (r0 != 2) goto L41;
        int r1 = AnonymousClass2.$SwitchMap$com$github$mikephil$charting$components$Legend$LegendVerticalAlignment[this.mLegend.getVerticalAlignment().ordinal()];
        if (r1 == 1) goto L17;
        if (r1 != 2) goto L42;
        r5.bottom += Math.min(this.mLegend.mNeededHeight, this.mViewPortHandler.getChartHeight() * this.mLegend.getMaxSizePercent()) + this.mLegend.getYOffset();
        return;
    L42:
        return;
    L17:
        r5.top += Math.min(this.mLegend.mNeededHeight, this.mViewPortHandler.getChartHeight() * this.mLegend.getMaxSizePercent()) + this.mLegend.getYOffset();
        return;
    L41:
        return;
    L18:
        int r2 = AnonymousClass2.$SwitchMap$com$github$mikephil$charting$components$Legend$LegendHorizontalAlignment[this.mLegend.getHorizontalAlignment().ordinal()];
        if (r2 == 1) goto L31;
        if (r2 != 2) goto L22;
        r5.right += Math.min(this.mLegend.mNeededWidth, this.mViewPortHandler.getChartWidth() * this.mLegend.getMaxSizePercent()) + this.mLegend.getXOffset();
        return;
    L22:
        if (r2 != 3) goto L43;
        int r3 = AnonymousClass2.$SwitchMap$com$github$mikephil$charting$components$Legend$LegendVerticalAlignment[this.mLegend.getVerticalAlignment().ordinal()];
        if (r3 == 1) goto L29;
        if (r3 != 2) goto L44;
        r5.bottom += Math.min(this.mLegend.mNeededHeight, this.mViewPortHandler.getChartHeight() * this.mLegend.getMaxSizePercent()) + this.mLegend.getYOffset();
        return;
    L44:
        return;
    L29:
        r5.top += Math.min(this.mLegend.mNeededHeight, this.mViewPortHandler.getChartHeight() * this.mLegend.getMaxSizePercent()) + this.mLegend.getYOffset();
        return;
    L43:
        return;
    L31:
        r5.left += Math.min(this.mLegend.mNeededWidth, this.mViewPortHandler.getChartWidth() * this.mLegend.getMaxSizePercent()) + this.mLegend.getXOffset();
        return;
    }

    @Override // com.github.mikephil.charting.charts.Chart
    public void calculateOffsets() {
        if (this.mCustomViewPortEnabled == true) goto L26;
        calculateLegendOffsets(this.mOffsetsBuffer);
        float r0 = this.mOffsetsBuffer.left + 0.0f;
        float r2 = this.mOffsetsBuffer.top + 0.0f;
        float r3 = this.mOffsetsBuffer.right + 0.0f;
        float r4 = this.mOffsetsBuffer.bottom + 0.0f;
        if (this.mAxisLeft.needsOffset() == false) goto L8;
        r0 = r0 + this.mAxisLeft.getRequiredWidthSpace(this.mAxisRendererLeft.getPaintAxisLabels());
    L8:
        if (this.mAxisRight.needsOffset() == false) goto L11;
        r3 = r3 + this.mAxisRight.getRequiredWidthSpace(this.mAxisRendererRight.getPaintAxisLabels());
    L11:
        if (this.mXAxis.isEnabled() == true) goto L13;
    L23:
        float r5 = r2 + getExtraTopOffset();
        float r6 = r3 + getExtraRightOffset();
        float r7 = r4 + getExtraBottomOffset();
        float r1 = r0 + getExtraLeftOffset();
        float r8 = Utils.convertDpToPixel(this.mMinOffset);
        this.mViewPortHandler.restrainViewPort(Math.max(r8, r1), Math.max(r8, r5), Math.max(r8, r6), Math.max(r8, r7));
        if (this.mLogEnabled == false) goto L26;
        Log.i(Chart.LOG_TAG, "offsetLeft: " + r1 + ", offsetTop: " + r5 + ", offsetRight: " + r6 + ", offsetBottom: " + r7);
        Log.i(Chart.LOG_TAG, "Content: " + this.mViewPortHandler.getContentRect().toString());
        goto L26
    L13:
        if (this.mXAxis.isDrawLabelsEnabled() == false) goto L23;
        float r9 = this.mXAxis.mLabelRotatedHeight + this.mXAxis.getYOffset();
        if (this.mXAxis.getPosition() != XAxis.XAxisPosition.BOTTOM) goto L18;
        r4 = r4 + r9;
        goto L23
    L18:
        if (this.mXAxis.getPosition() != XAxis.XAxisPosition.TOP) goto L21;
    L19:
        r2 = r2 + r9;
        goto L23
    L21:
        if (this.mXAxis.getPosition() != XAxis.XAxisPosition.BOTH_SIDED) goto L23;
        r4 = r4 + r9;
    L26:
        prepareOffsetMatrix();
        prepareValuePxMatrix();
    }

    protected void drawGridBackground(Canvas r3) {
        if (this.mDrawGridBackground == false) goto L6;
        r3.drawRect(this.mViewPortHandler.getContentRect(), this.mGridBackgroundPaint);
    L6:
        if (this.mDrawBorders == false) goto L9;
        r3.drawRect(this.mViewPortHandler.getContentRect(), this.mBorderPaint);
        return;
    }

    @Override // com.github.mikephil.charting.interfaces.dataprovider.BarLineScatterCandleBubbleDataProvider
    public Transformer getTransformer(YAxis.AxisDependency r2) {
        if (r2 != YAxis.AxisDependency.LEFT) goto L7;
        return this.mLeftAxisTransformer;
    L7:
        return this.mRightAxisTransformer;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent r3) {
        super.onTouchEvent(r3);
        if (this.mChartTouchListener != null) goto L5;
    L12:
        return false;
    L5:
        if (this.mData == 0) goto L12;
        if (this.mTouchEnabled == true) goto L11;
        return false;
    L11:
        return this.mChartTouchListener.onTouch(this, r3);
    }

    @Override // android.view.View
    public void computeScroll() {
        if ((this.mChartTouchListener instanceof BarLineChartTouchListener) == false) goto L6;
        ((BarLineChartTouchListener) this.mChartTouchListener).computeScroll();
        return;
    }

    public void zoomIn() {
        MPPointF r0 = this.mViewPortHandler.getContentCenter();
        this.mViewPortHandler.zoomIn(r0.x, -r0.y, this.mZoomMatrixBuffer);
        this.mViewPortHandler.refresh(this.mZoomMatrixBuffer, this, false);
        MPPointF.recycleInstance(r0);
        calculateOffsets();
        postInvalidate();
    }

    public void zoomOut() {
        MPPointF r0 = this.mViewPortHandler.getContentCenter();
        this.mViewPortHandler.zoomOut(r0.x, -r0.y, this.mZoomMatrixBuffer);
        this.mViewPortHandler.refresh(this.mZoomMatrixBuffer, this, false);
        MPPointF.recycleInstance(r0);
        calculateOffsets();
        postInvalidate();
    }

    public void resetZoom() {
        this.mViewPortHandler.resetZoom(this.mZoomMatrixBuffer);
        this.mViewPortHandler.refresh(this.mZoomMatrixBuffer, this, false);
        calculateOffsets();
        postInvalidate();
    }

    public void zoom(float r7, float r8, float r9, float r10) {
        this.mViewPortHandler.zoom(r7, r8, r9, -r10, this.mZoomMatrixBuffer);
        this.mViewPortHandler.refresh(this.mZoomMatrixBuffer, this, false);
        calculateOffsets();
        postInvalidate();
    }

    public void zoom(float r9, float r10, float r11, float r12, YAxis.AxisDependency r13) {
        addViewportJob(ZoomJob.getInstance(this.mViewPortHandler, r9, r10, r11, r12, getTransformer(r13), r13, this));
    }

    public void zoomToCenter(float r9, float r10) {
        MPPointF r0 = getCenterOffsets();
        Matrix r7 = this.mZoomMatrixBuffer;
        this.mViewPortHandler.zoom(r9, r10, r0.x, -r0.y, r7);
        this.mViewPortHandler.refresh(r7, this, false);
    }

    public void zoomAndCenterAnimated(float r18, float r19, float r20, float r21, YAxis.AxisDependency r22, long r23) {
        MPPointD r13 = getValuesByTouchPoint(this.mViewPortHandler.contentLeft(), this.mViewPortHandler.contentTop(), r22);
        addViewportJob(AnimatedZoomJob.getInstance(this.mViewPortHandler, this, getTransformer(r22), getAxis(r22), this.mXAxis.mAxisRange, r18, r19, this.mViewPortHandler.getScaleX(), this.mViewPortHandler.getScaleY(), r20, r21, (float) r13.x, (float) r13.y, r23));
        MPPointD.recycleInstance(r13);
    }

    public void fitScreen() {
        Matrix r0 = this.mFitScreenMatrixBuffer;
        this.mViewPortHandler.fitScreen(r0);
        this.mViewPortHandler.refresh(r0, this, false);
        calculateOffsets();
        postInvalidate();
    }

    public void setScaleMinima(float r2, float r3) {
        this.mViewPortHandler.setMinimumScaleX(r2);
        this.mViewPortHandler.setMinimumScaleY(r3);
    }

    public void setVisibleXRangeMaximum(float r2) {
        float r0 = this.mXAxis.mAxisRange / r2;
        this.mViewPortHandler.setMinimumScaleX(r0);
    }

    public void setVisibleXRangeMinimum(float r2) {
        float r0 = this.mXAxis.mAxisRange / r2;
        this.mViewPortHandler.setMaximumScaleX(r0);
    }

    public void setVisibleXRange(float r2, float r3) {
        float r0 = this.mXAxis.mAxisRange / r2;
        float r4 = this.mXAxis.mAxisRange / r3;
        this.mViewPortHandler.setMinMaxScaleX(r0, r4);
    }

    public void setVisibleYRangeMaximum(float r1, YAxis.AxisDependency r2) {
        float r3 = getAxisRange(r2) / r1;
        this.mViewPortHandler.setMinimumScaleY(r3);
    }

    public void setVisibleYRangeMinimum(float r1, YAxis.AxisDependency r2) {
        float r3 = getAxisRange(r2) / r1;
        this.mViewPortHandler.setMaximumScaleY(r3);
    }

    public void setVisibleYRange(float r2, float r3, YAxis.AxisDependency r4) {
        float r0 = getAxisRange(r4) / r2;
        float r5 = getAxisRange(r4) / r3;
        this.mViewPortHandler.setMinMaxScaleY(r0, r5);
    }

    public void moveViewToX(float r4) {
        addViewportJob(MoveViewJob.getInstance(this.mViewPortHandler, r4, 0.0f, getTransformer(YAxis.AxisDependency.LEFT), this));
    }

    public void moveViewTo(float r4, float r5, YAxis.AxisDependency r6) {
        float r0 = getAxisRange(r6) / this.mViewPortHandler.getScaleY();
        addViewportJob(MoveViewJob.getInstance(this.mViewPortHandler, r4, r5 + (r0 / 2.0f), getTransformer(r6), this));
    }

    public void moveViewToAnimated(float r12, float r13, YAxis.AxisDependency r14, long r15) {
        MPPointD r10 = getValuesByTouchPoint(this.mViewPortHandler.contentLeft(), this.mViewPortHandler.contentTop(), r14);
        float r1 = getAxisRange(r14) / this.mViewPortHandler.getScaleY();
        addViewportJob(AnimatedMoveViewJob.getInstance(this.mViewPortHandler, r12, r13 + (r1 / 2.0f), getTransformer(r14), this, (float) r10.x, (float) r10.y, r15));
        MPPointD.recycleInstance(r10);
    }

    public void centerViewToY(float r4, YAxis.AxisDependency r5) {
        float r0 = getAxisRange(r5) / this.mViewPortHandler.getScaleY();
        addViewportJob(MoveViewJob.getInstance(this.mViewPortHandler, 0.0f, r4 + (r0 / 2.0f), getTransformer(r5), this));
    }

    public void centerViewTo(float r5, float r6, YAxis.AxisDependency r7) {
        float r0 = getAxisRange(r7) / this.mViewPortHandler.getScaleY();
        float r1 = getXAxis().mAxisRange / this.mViewPortHandler.getScaleX();
        addViewportJob(MoveViewJob.getInstance(this.mViewPortHandler, r5 - (r1 / 2.0f), r6 + (r0 / 2.0f), getTransformer(r7), this));
    }

    public void centerViewToAnimated(float r12, float r13, YAxis.AxisDependency r14, long r15) {
        MPPointD r10 = getValuesByTouchPoint(this.mViewPortHandler.contentLeft(), this.mViewPortHandler.contentTop(), r14);
        float r1 = getAxisRange(r14) / this.mViewPortHandler.getScaleY();
        float r2 = getXAxis().mAxisRange / this.mViewPortHandler.getScaleX();
        addViewportJob(AnimatedMoveViewJob.getInstance(this.mViewPortHandler, r12 - (r2 / 2.0f), r13 + (r1 / 2.0f), getTransformer(r14), this, (float) r10.x, (float) r10.y, r15));
        MPPointD.recycleInstance(r10);
    }

    public void setViewPortOffsets(final float r8, final float r9, final float r10, final float r11) {
        this.mCustomViewPortEnabled = true;
        post(new AnonymousClass1(this, r8, r9, r10, r11));
    }

    public void resetViewPortOffsets() {
        this.mCustomViewPortEnabled = false;
        calculateOffsets();
    }

    protected float getAxisRange(YAxis.AxisDependency r2) {
        if (r2 != YAxis.AxisDependency.LEFT) goto L7;
        return this.mAxisLeft.mAxisRange;
    L7:
        return this.mAxisRight.mAxisRange;
    }

    public void setOnDrawListener(OnDrawListener r1) {
        this.mDrawListener = r1;
    }

    public OnDrawListener getDrawListener() {
        return this.mDrawListener;
    }

    public MPPointF getPosition(Entry r4, YAxis.AxisDependency r5) {
        if (r4 != null) goto L5;
        return null;
    L5:
        this.mGetPositionBuffer[0] = r4.getX();
        this.mGetPositionBuffer[1] = r4.getY();
        getTransformer(r5).pointValuesToPixel(this.mGetPositionBuffer);
        float[] r3 = this.mGetPositionBuffer;
        return MPPointF.getInstance(r3[0], r3[1]);
    }

    public void setMaxVisibleValueCount(int r1) {
        this.mMaxVisibleCount = r1;
    }

    @Override // com.github.mikephil.charting.interfaces.dataprovider.ChartInterface
    public int getMaxVisibleCount() {
        return this.mMaxVisibleCount;
    }

    public void setHighlightPerDragEnabled(boolean r1) {
        this.mHighlightPerDragEnabled = r1;
    }

    public boolean isHighlightPerDragEnabled() {
        return this.mHighlightPerDragEnabled;
    }

    public void setGridBackgroundColor(int r1) {
        this.mGridBackgroundPaint.setColor(r1);
    }

    public void setDragEnabled(boolean r1) {
        this.mDragXEnabled = r1;
        this.mDragYEnabled = r1;
    }

    public boolean isDragEnabled() {
        if (this.mDragXEnabled == false) goto L5;
    L8:
        return true;
    L5:
        if (this.mDragYEnabled == true) goto L8;
        return false;
    }

    public void setDragXEnabled(boolean r1) {
        this.mDragXEnabled = r1;
    }

    public boolean isDragXEnabled() {
        return this.mDragXEnabled;
    }

    public void setDragYEnabled(boolean r1) {
        this.mDragYEnabled = r1;
    }

    public boolean isDragYEnabled() {
        return this.mDragYEnabled;
    }

    public void setScaleEnabled(boolean r1) {
        this.mScaleXEnabled = r1;
        this.mScaleYEnabled = r1;
    }

    public void setScaleXEnabled(boolean r1) {
        this.mScaleXEnabled = r1;
    }

    public void setScaleYEnabled(boolean r1) {
        this.mScaleYEnabled = r1;
    }

    public boolean isScaleXEnabled() {
        return this.mScaleXEnabled;
    }

    public boolean isScaleYEnabled() {
        return this.mScaleYEnabled;
    }

    public void setDoubleTapToZoomEnabled(boolean r1) {
        this.mDoubleTapToZoomEnabled = r1;
    }

    public boolean isDoubleTapToZoomEnabled() {
        return this.mDoubleTapToZoomEnabled;
    }

    public void setDrawGridBackground(boolean r1) {
        this.mDrawGridBackground = r1;
    }

    public void setDrawBorders(boolean r1) {
        this.mDrawBorders = r1;
    }

    public boolean isDrawBordersEnabled() {
        return this.mDrawBorders;
    }

    public void setClipValuesToContent(boolean r1) {
        this.mClipValuesToContent = r1;
    }

    public boolean isClipValuesToContentEnabled() {
        return this.mClipValuesToContent;
    }

    public void setBorderWidth(float r1) {
        this.mBorderPaint.setStrokeWidth(Utils.convertDpToPixel(r1));
    }

    public void setBorderColor(int r1) {
        this.mBorderPaint.setColor(r1);
    }

    public float getMinOffset() {
        return this.mMinOffset;
    }

    public void setMinOffset(float r1) {
        this.mMinOffset = r1;
    }

    public boolean isKeepPositionOnRotation() {
        return this.mKeepPositionOnRotation;
    }

    public void setKeepPositionOnRotation(boolean r1) {
        this.mKeepPositionOnRotation = r1;
    }

    public MPPointD getValuesByTouchPoint(float r3, float r4, YAxis.AxisDependency r5) {
        MPPointD r0 = MPPointD.getInstance(0.0d, 0.0d);
        getValuesByTouchPoint(r3, r4, r5, r0);
        return r0;
    }

    public void getValuesByTouchPoint(float r1, float r2, YAxis.AxisDependency r3, MPPointD r4) {
        getTransformer(r3).getValuesByTouchPoint(r1, r2, r4);
    }

    public MPPointD getPixelForValues(float r1, float r2, YAxis.AxisDependency r3) {
        return getTransformer(r3).getPixelForValues(r1, r2);
    }

    public Entry getEntryByTouchPoint(float r1, float r2) {
        Highlight r3 = getHighlightByTouchPoint(r1, r2);
        if (r3 != null) goto L5;
        return null;
    L5:
        return ((BarLineScatterCandleBubbleData) this.mData).getEntryForHighlight(r3);
    }

    public IBarLineScatterCandleBubbleDataSet getDataSetByTouchPoint(float r1, float r2) {
        Highlight r3 = getHighlightByTouchPoint(r1, r2);
        if (r3 != null) goto L5;
        return null;
    L5:
        return (IBarLineScatterCandleBubbleDataSet) ((BarLineScatterCandleBubbleData) this.mData).getDataSetByIndex(r3.getDataSetIndex());
    }

    @Override // com.github.mikephil.charting.interfaces.dataprovider.BarLineScatterCandleBubbleDataProvider
    public float getLowestVisibleX() {
        getTransformer(YAxis.AxisDependency.LEFT).getValuesByTouchPoint(this.mViewPortHandler.contentLeft(), this.mViewPortHandler.contentBottom(), this.posForGetLowestVisibleX);
        return (float) Math.max(this.mXAxis.mAxisMinimum, this.posForGetLowestVisibleX.x);
    }

    @Override // com.github.mikephil.charting.interfaces.dataprovider.BarLineScatterCandleBubbleDataProvider
    public float getHighestVisibleX() {
        getTransformer(YAxis.AxisDependency.LEFT).getValuesByTouchPoint(this.mViewPortHandler.contentRight(), this.mViewPortHandler.contentBottom(), this.posForGetHighestVisibleX);
        return (float) Math.min(this.mXAxis.mAxisMaximum, this.posForGetHighestVisibleX.x);
    }

    public float getVisibleXRange() {
        return Math.abs(getHighestVisibleX() - getLowestVisibleX());
    }

    @Override // android.view.View
    public float getScaleX() {
        if (this.mViewPortHandler != null) goto L7;
        return 1.0f;
    L7:
        return this.mViewPortHandler.getScaleX();
    }

    @Override // android.view.View
    public float getScaleY() {
        if (this.mViewPortHandler != null) goto L7;
        return 1.0f;
    L7:
        return this.mViewPortHandler.getScaleY();
    }

    public boolean isFullyZoomedOut() {
        return this.mViewPortHandler.isFullyZoomedOut();
    }

    public YAxis getAxisLeft() {
        return this.mAxisLeft;
    }

    public YAxis getAxisRight() {
        return this.mAxisRight;
    }

    public YAxis getAxis(YAxis.AxisDependency r2) {
        if (r2 != YAxis.AxisDependency.LEFT) goto L7;
        return this.mAxisLeft;
    L7:
        return this.mAxisRight;
    }

    @Override // com.github.mikephil.charting.interfaces.dataprovider.BarLineScatterCandleBubbleDataProvider
    public boolean isInverted(YAxis.AxisDependency r1) {
        return getAxis(r1).isInverted();
    }

    public void setPinchZoom(boolean r1) {
        this.mPinchZoomEnabled = r1;
    }

    public boolean isPinchZoomEnabled() {
        return this.mPinchZoomEnabled;
    }

    public void setDragOffsetX(float r1) {
        this.mViewPortHandler.setDragOffsetX(r1);
    }

    public void setDragOffsetY(float r1) {
        this.mViewPortHandler.setDragOffsetY(r1);
    }

    public boolean hasNoDragOffset() {
        return this.mViewPortHandler.hasNoDragOffset();
    }

    public XAxisRenderer getRendererXAxis() {
        return this.mXAxisRenderer;
    }

    public void setXAxisRenderer(XAxisRenderer r1) {
        this.mXAxisRenderer = r1;
    }

    public YAxisRenderer getRendererLeftYAxis() {
        return this.mAxisRendererLeft;
    }

    public void setRendererLeftYAxis(YAxisRenderer r1) {
        this.mAxisRendererLeft = r1;
    }

    public YAxisRenderer getRendererRightYAxis() {
        return this.mAxisRendererRight;
    }

    public void setRendererRightYAxis(YAxisRenderer r1) {
        this.mAxisRendererRight = r1;
    }

    @Override // com.github.mikephil.charting.interfaces.dataprovider.ChartInterface
    public float getYChartMax() {
        return Math.max(this.mAxisLeft.mAxisMaximum, this.mAxisRight.mAxisMaximum);
    }

    @Override // com.github.mikephil.charting.interfaces.dataprovider.ChartInterface
    public float getYChartMin() {
        return Math.min(this.mAxisLeft.mAxisMinimum, this.mAxisRight.mAxisMinimum);
    }

    public boolean isAnyAxisInverted() {
        if (this.mAxisLeft.isInverted() == false) goto L6;
        return true;
    L6:
        if (this.mAxisRight.isInverted() == false) goto L8;
        return true;
    L8:
        return false;
    }

    public void setAutoScaleMinMaxEnabled(boolean r1) {
        this.mAutoScaleMinMaxEnabled = r1;
    }

    public boolean isAutoScaleMinMaxEnabled() {
        return this.mAutoScaleMinMaxEnabled;
    }

    @Override // com.github.mikephil.charting.charts.Chart
    public void setPaint(Paint r2, int r3) {
        super.setPaint(r2, r3);
        if (r3 != 4) goto L7;
        this.mGridBackgroundPaint = r2;
        return;
    }

    @Override // com.github.mikephil.charting.charts.Chart
    public Paint getPaint(int r2) {
        Paint r0 = super.getPaint(r2);
        if (r0 == null) goto L6;
        return r0;
    L6:
        if (r2 == 4) goto L10;
        return null;
    L10:
        return this.mGridBackgroundPaint;
    }

    @Override // com.github.mikephil.charting.charts.Chart, android.view.View
    protected void onSizeChanged(int r5, int r6, int r7, int r8) {
        float[] r0 = this.mOnSizeChangedBuffer;
        r0[1] = 0.0f;
        r0[0] = 0.0f;
        if (this.mKeepPositionOnRotation == false) goto L5;
        r0[0] = this.mViewPortHandler.contentLeft();
        this.mOnSizeChangedBuffer[1] = this.mViewPortHandler.contentTop();
        getTransformer(YAxis.AxisDependency.LEFT).pixelsToValue(this.mOnSizeChangedBuffer);
    L5:
        super.onSizeChanged(r5, r6, r7, r8);
        if (this.mKeepPositionOnRotation == false) goto L8;
        getTransformer(YAxis.AxisDependency.LEFT).pointValuesToPixel(this.mOnSizeChangedBuffer);
        this.mViewPortHandler.centerViewPort(this.mOnSizeChangedBuffer, this);
        return;
    L8:
        this.mViewPortHandler.refresh(this.mViewPortHandler.getMatrixTouch(), this, true);
    }
}
