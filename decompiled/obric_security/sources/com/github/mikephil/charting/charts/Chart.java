package com.github.mikephil.charting.charts;

import android.content.ContentValues;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Environment;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.bytedance.librarian.LibrarianImpl;
import com.github.mikephil.charting.animation.ChartAnimator;
import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.IMarker;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.ChartData;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.formatter.DefaultValueFormatter;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.highlight.ChartHighlighter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.highlight.IHighlighter;
import com.github.mikephil.charting.interfaces.dataprovider.ChartInterface;
import com.github.mikephil.charting.interfaces.datasets.IDataSet;
import com.github.mikephil.charting.listener.ChartTouchListener;
import com.github.mikephil.charting.listener.OnChartGestureListener;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.github.mikephil.charting.renderer.DataRenderer;
import com.github.mikephil.charting.renderer.LegendRenderer;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import com.obric.security.cleaner.bigfile.MimeType;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public abstract class Chart<T extends ChartData<? extends IDataSet<? extends Entry>>> extends ViewGroup implements ChartInterface {
    public static final String LOG_TAG = "MPAndroidChart";
    public static final int PAINT_CENTER_TEXT = 14;
    public static final int PAINT_DESCRIPTION = 11;
    public static final int PAINT_GRID_BACKGROUND = 4;
    public static final int PAINT_HOLE = 13;
    public static final int PAINT_INFO = 7;
    public static final int PAINT_LEGEND_LABEL = 18;
    protected ChartAnimator mAnimator;
    protected ChartTouchListener mChartTouchListener;
    protected T mData;
    protected DefaultValueFormatter mDefaultValueFormatter;
    protected Paint mDescPaint;
    protected Description mDescription;
    private boolean mDragDecelerationEnabled;
    private float mDragDecelerationFrictionCoef;
    protected boolean mDrawMarkers;
    private float mExtraBottomOffset;
    private float mExtraLeftOffset;
    private float mExtraRightOffset;
    private float mExtraTopOffset;
    private OnChartGestureListener mGestureListener;
    protected boolean mHighLightPerTapEnabled;
    protected IHighlighter mHighlighter;
    protected Highlight[] mIndicesToHighlight;
    protected Paint mInfoPaint;
    protected ArrayList<Runnable> mJobs;
    protected Legend mLegend;
    protected LegendRenderer mLegendRenderer;
    protected boolean mLogEnabled;
    protected IMarker mMarker;
    protected float mMaxHighlightDistance;
    private String mNoDataText;
    private boolean mOffsetsCalculated;
    protected DataRenderer mRenderer;
    protected OnChartValueSelectedListener mSelectionListener;
    protected boolean mTouchEnabled;
    private boolean mUnbind;
    protected ViewPortHandler mViewPortHandler;
    protected XAxis mXAxis;

    /* JADX INFO: renamed from: com.github.mikephil.charting.charts.Chart$2, reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$android$graphics$Bitmap$CompressFormat = null;

        static {
            int[] r0 = new int[Bitmap.CompressFormat.values().length];
            $SwitchMap$android$graphics$Bitmap$CompressFormat = r0;
            r0[Bitmap.CompressFormat.PNG.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            $SwitchMap$android$graphics$Bitmap$CompressFormat[Bitmap.CompressFormat.WEBP.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            $SwitchMap$android$graphics$Bitmap$CompressFormat[Bitmap.CompressFormat.JPEG.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    protected abstract void calcMinMax();

    protected abstract void calculateOffsets();

    public abstract void notifyDataSetChanged();

    public Chart(Context r3) {
        super(r3);
        this.mLogEnabled = false;
        this.mData = null;
        this.mHighLightPerTapEnabled = true;
        this.mDragDecelerationEnabled = true;
        this.mDragDecelerationFrictionCoef = 0.9f;
        this.mDefaultValueFormatter = new DefaultValueFormatter(0);
        this.mTouchEnabled = true;
        this.mNoDataText = "No chart data available.";
        this.mViewPortHandler = new ViewPortHandler();
        this.mExtraTopOffset = 0.0f;
        this.mExtraRightOffset = 0.0f;
        this.mExtraBottomOffset = 0.0f;
        this.mExtraLeftOffset = 0.0f;
        this.mOffsetsCalculated = false;
        this.mMaxHighlightDistance = 0.0f;
        this.mDrawMarkers = true;
        this.mJobs = new ArrayList();
        this.mUnbind = false;
        init();
    }

    public Chart(Context r2, AttributeSet r3) {
        super(r2, r3);
        this.mLogEnabled = false;
        this.mData = null;
        this.mHighLightPerTapEnabled = true;
        this.mDragDecelerationEnabled = true;
        this.mDragDecelerationFrictionCoef = 0.9f;
        this.mDefaultValueFormatter = new DefaultValueFormatter(0);
        this.mTouchEnabled = true;
        this.mNoDataText = "No chart data available.";
        this.mViewPortHandler = new ViewPortHandler();
        this.mExtraTopOffset = 0.0f;
        this.mExtraRightOffset = 0.0f;
        this.mExtraBottomOffset = 0.0f;
        this.mExtraLeftOffset = 0.0f;
        this.mOffsetsCalculated = false;
        this.mMaxHighlightDistance = 0.0f;
        this.mDrawMarkers = true;
        this.mJobs = new ArrayList();
        this.mUnbind = false;
        init();
    }

    public Chart(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        this.mLogEnabled = false;
        this.mData = null;
        this.mHighLightPerTapEnabled = true;
        this.mDragDecelerationEnabled = true;
        this.mDragDecelerationFrictionCoef = 0.9f;
        this.mDefaultValueFormatter = new DefaultValueFormatter(0);
        this.mTouchEnabled = true;
        this.mNoDataText = "No chart data available.";
        this.mViewPortHandler = new ViewPortHandler();
        this.mExtraTopOffset = 0.0f;
        this.mExtraRightOffset = 0.0f;
        this.mExtraBottomOffset = 0.0f;
        this.mExtraLeftOffset = 0.0f;
        this.mOffsetsCalculated = false;
        this.mMaxHighlightDistance = 0.0f;
        this.mDrawMarkers = true;
        this.mJobs = new ArrayList();
        this.mUnbind = false;
        init();
    }

    protected void init() {
        setWillNotDraw(false);
        this.mAnimator = new ChartAnimator(new AnonymousClass1(this));
        Utils.init(getContext());
        this.mMaxHighlightDistance = Utils.convertDpToPixel(500.0f);
        this.mDescription = new Description();
        this.mLegend = new Legend();
        this.mLegendRenderer = new LegendRenderer(this.mViewPortHandler, this.mLegend);
        this.mXAxis = new XAxis();
        this.mDescPaint = new Paint(1);
        Paint r0 = new Paint(1);
        this.mInfoPaint = r0;
        r0.setColor(Color.rgb(247, 189, 51));
        this.mInfoPaint.setTextAlign(Paint.Align.CENTER);
        this.mInfoPaint.setTextSize(Utils.convertDpToPixel(12.0f));
        if (this.mLogEnabled == false) goto L6;
        Log.i("", "Chart.init()");
        return;
    }

    public void setData(T r4) {
        this.mData = r4;
        this.mOffsetsCalculated = false;
        if (r4 != null) goto L5;
        return;
    L5:
        setupDefaultFormatter(r4.getYMin(), r4.getYMax());
        Iterator r5 = this.mData.getDataSets().iterator();
    L7:
        if (r5.hasNext() == false) goto L13;
        IDataSet r0 = (IDataSet) r5.next();
        if (r0.needsFormatter() == true) goto L12;
        if (r0.getValueFormatter() != this.mDefaultValueFormatter) goto L7;
    L12:
        r0.setValueFormatter(this.mDefaultValueFormatter);
        goto L7
    L13:
        notifyDataSetChanged();
        if (this.mLogEnabled == false) goto L23;
        Log.i(LOG_TAG, "Data is set.");
        return;
    }

    public void clear() {
        this.mData = null;
        this.mOffsetsCalculated = false;
        this.mIndicesToHighlight = null;
        this.mChartTouchListener.setLastHighlighted(null);
        invalidate();
    }

    public void clearValues() {
        this.mData.clearValues();
        invalidate();
    }

    public boolean isEmpty() {
        T r1 = this.mData;
        if (r1 != null) goto L6;
        return true;
    L6:
        if (r1.getEntryCount() > 0) goto L8;
        return true;
    L8:
        return false;
    }

    protected void setupDefaultFormatter(float r3, float r4) {
        T r0 = this.mData;
        if (r0 != null) goto L5;
    L8:
        float r5 = Math.max(Math.abs(r3), Math.abs(r4));
    L9:
        int r6 = Utils.getDecimals(r5);
        this.mDefaultValueFormatter.setup(r6);
        return;
    L5:
        if (r0.getEntryCount() < 2) goto L8;
        r5 = Math.abs(r4 - r3);
        goto L9
    }

    @Override // android.view.View
    protected void onDraw(Canvas r4) {
        if (this.mData != null) goto L9;
        if ((!TextUtils.isEmpty(this.mNoDataText)) == false) goto L12;
        MPPointF r0 = getCenter();
        r4.drawText(this.mNoDataText, r0.x, r0.y, this.mInfoPaint);
        return;
    L12:
        return;
    L9:
        if (this.mOffsetsCalculated == true) goto L13;
        calculateOffsets();
        this.mOffsetsCalculated = true;
        return;
    }

    protected void drawDescription(Canvas r5) {
        Description r0 = this.mDescription;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isEnabled() == false) goto L13;
        MPPointF r1 = this.mDescription.getPosition();
        this.mDescPaint.setTypeface(this.mDescription.getTypeface());
        this.mDescPaint.setTextSize(this.mDescription.getTextSize());
        this.mDescPaint.setColor(this.mDescription.getTextColor());
        this.mDescPaint.setTextAlign(this.mDescription.getTextAlign());
        if (r1 != null) goto L9;
        float r2 = (getWidth() - this.mViewPortHandler.offsetRight()) - this.mDescription.getXOffset();
        float r3 = (getHeight() - this.mViewPortHandler.offsetBottom()) - this.mDescription.getYOffset();
    L10:
        r5.drawText(this.mDescription.getText(), r2, r3, this.mDescPaint);
        return;
    L9:
        float r4 = r1.x;
        r3 = r1.y;
        r2 = r4;
        goto L10
    }

    @Override // com.github.mikephil.charting.interfaces.dataprovider.ChartInterface
    public float getMaxHighlightDistance() {
        return this.mMaxHighlightDistance;
    }

    public void setMaxHighlightDistance(float r1) {
        this.mMaxHighlightDistance = Utils.convertDpToPixel(r1);
    }

    public Highlight[] getHighlighted() {
        return this.mIndicesToHighlight;
    }

    public boolean isHighlightPerTapEnabled() {
        return this.mHighLightPerTapEnabled;
    }

    public void setHighlightPerTapEnabled(boolean r1) {
        this.mHighLightPerTapEnabled = r1;
    }

    public boolean valuesToHighlight() {
        Highlight[] r2 = this.mIndicesToHighlight;
        if (r2 != null) goto L5;
        return false;
    L5:
        if (r2.length > 0) goto L7;
        return false;
    L7:
        if (r2[0] == null) goto L13;
        return true;
    L13:
        return false;
    }

    protected void setLastHighlighted(Highlight[] r2) {
        if (r2 != null) goto L4;
    L9:
        this.mChartTouchListener.setLastHighlighted(null);
        return;
    L4:
        if (r2.length <= 0) goto L9;
        Highlight r3 = r2[0];
        if (r3 == null) goto L9;
        this.mChartTouchListener.setLastHighlighted(r3);
    }

    public void highlightValues(Highlight[] r1) {
        this.mIndicesToHighlight = r1;
        setLastHighlighted(r1);
        invalidate();
    }

    public void highlightValue(float r2, int r3) {
        highlightValue(r2, r3, true);
    }

    public void highlightValue(float r2, float r3, int r4) {
        highlightValue(r2, r3, r4, true);
    }

    public void highlightValue(float r2, int r3, boolean r4) {
        highlightValue(r2, Float.NaN, r3, r4);
    }

    public void highlightValue(float r2, float r3, int r4, boolean r5) {
        if (r4 >= 0) goto L4;
    L7:
        highlightValue(null, r5);
        return;
    L4:
        if (r4 >= this.mData.getDataSetCount()) goto L7;
        highlightValue(new Highlight(r2, r3, r4), r5);
    }

    public void highlightValue(Highlight r2) {
        highlightValue(r2, false);
    }

    public void highlightValue(Highlight r4, boolean r5) {
        Entry r0 = null;
        if (r4 != null) goto L6;
        this.mIndicesToHighlight = null;
    L13:
        setLastHighlighted(this.mIndicesToHighlight);
        if (r5 == true) goto L16;
    L21:
        invalidate();
        return;
    L16:
        if (this.mSelectionListener == null) goto L21;
        if (valuesToHighlight() == true) goto L20;
        this.mSelectionListener.onNothingSelected();
        goto L21
    L20:
        this.mSelectionListener.onValueSelected(r0, r4);
        goto L21
    L6:
        if (this.mLogEnabled == false) goto L8;
        Log.i(LOG_TAG, "Highlighted: " + r4.toString());
    L8:
        Entry r1 = this.mData.getEntryForHighlight(r4);
        if (r1 != null) goto L11;
        this.mIndicesToHighlight = null;
        r4 = null;
    L12:
        r0 = r1;
        goto L13
    L11:
        this.mIndicesToHighlight = new Highlight[]{r4};
        goto L12
    }

    public Highlight getHighlightByTouchPoint(float r2, float r3) {
        if (this.mData != null) goto L7;
        Log.e(LOG_TAG, "Can't select by touch. No data set.");
        return null;
    L7:
        return getHighlighter().getHighlight(r2, r3);
    }

    public void setOnTouchListener(ChartTouchListener r1) {
        this.mChartTouchListener = r1;
    }

    public ChartTouchListener getOnTouchListener() {
        return this.mChartTouchListener;
    }

    protected void drawMarkers(Canvas r10) {
        if (this.mMarker != null) goto L5;
        return;
    L5:
        if (isDrawMarkersEnabled() == true) goto L7;
        return;
    L7:
        if (valuesToHighlight() == false) goto L29;
        int r1 = 0;
    L10:
        Highlight[] r2 = this.mIndicesToHighlight;
        if (r1 >= r2.length) goto L30;
        Highlight r3 = r2[r1];
        IDataSet r4 = this.mData.getDataSetByIndex(r3.getDataSetIndex());
        Entry r5 = this.mData.getEntryForHighlight(this.mIndicesToHighlight[r1]);
        int r6 = r4.getEntryIndex(r5);
        if (r5 == null) goto L21;
        if (r6 > (r4.getEntryCount() * this.mAnimator.getPhaseX())) goto L21;
        float[] r7 = getMarkerPosition(r3);
        if (this.mViewPortHandler.isInBounds(r7[0], r7[1]) == false) goto L21;
        this.mMarker.refreshContent(r5, r3);
        this.mMarker.draw(r10, r7[0], r7[1]);
    L21:
        r1 = r1 + 1;
        goto L10
    L30:
        return;
    }

    protected float[] getMarkerPosition(Highlight r3) {
        return new float[]{r3.getDrawX(), r3.getDrawY()};
    }

    public ChartAnimator getAnimator() {
        return this.mAnimator;
    }

    public boolean isDragDecelerationEnabled() {
        return this.mDragDecelerationEnabled;
    }

    public void setDragDecelerationEnabled(boolean r1) {
        this.mDragDecelerationEnabled = r1;
    }

    public float getDragDecelerationFrictionCoef() {
        return this.mDragDecelerationFrictionCoef;
    }

    public void setDragDecelerationFrictionCoef(float r3) {
        if (r3 >= 0.0f) goto L6;
        r3 = 0.0f;
    L6:
        if (r3 < 1.0f) goto L8;
        r3 = 0.999f;
    L8:
        this.mDragDecelerationFrictionCoef = r3;
    }

    public void animateXY(int r1, int r2, Easing.EasingFunction r3, Easing.EasingFunction r4) {
        this.mAnimator.animateXY(r1, r2, r3, r4);
    }

    public void animateXY(int r1, int r2, Easing.EasingFunction r3) {
        this.mAnimator.animateXY(r1, r2, r3);
    }

    public void animateX(int r1, Easing.EasingFunction r2) {
        this.mAnimator.animateX(r1, r2);
    }

    public void animateY(int r1, Easing.EasingFunction r2) {
        this.mAnimator.animateY(r1, r2);
    }

    public void animateX(int r1) {
        this.mAnimator.animateX(r1);
    }

    public void animateY(int r1) {
        this.mAnimator.animateY(r1);
    }

    public void animateXY(int r1, int r2) {
        this.mAnimator.animateXY(r1, r2);
    }

    public XAxis getXAxis() {
        return this.mXAxis;
    }

    @Override // com.github.mikephil.charting.interfaces.dataprovider.ChartInterface
    public ValueFormatter getDefaultValueFormatter() {
        return this.mDefaultValueFormatter;
    }

    public void setOnChartValueSelectedListener(OnChartValueSelectedListener r1) {
        this.mSelectionListener = r1;
    }

    public void setOnChartGestureListener(OnChartGestureListener r1) {
        this.mGestureListener = r1;
    }

    public OnChartGestureListener getOnChartGestureListener() {
        return this.mGestureListener;
    }

    public float getYMax() {
        return this.mData.getYMax();
    }

    public float getYMin() {
        return this.mData.getYMin();
    }

    @Override // com.github.mikephil.charting.interfaces.dataprovider.ChartInterface
    public float getXChartMax() {
        return this.mXAxis.mAxisMaximum;
    }

    @Override // com.github.mikephil.charting.interfaces.dataprovider.ChartInterface
    public float getXChartMin() {
        return this.mXAxis.mAxisMinimum;
    }

    @Override // com.github.mikephil.charting.interfaces.dataprovider.ChartInterface
    public float getXRange() {
        return this.mXAxis.mAxisRange;
    }

    public MPPointF getCenter() {
        return MPPointF.getInstance(getWidth() / 2.0f, getHeight() / 2.0f);
    }

    @Override // com.github.mikephil.charting.interfaces.dataprovider.ChartInterface
    public MPPointF getCenterOffsets() {
        return this.mViewPortHandler.getContentCenter();
    }

    public void setExtraOffsets(float r1, float r2, float r3, float r4) {
        setExtraLeftOffset(r1);
        setExtraTopOffset(r2);
        setExtraRightOffset(r3);
        setExtraBottomOffset(r4);
    }

    public void setExtraTopOffset(float r1) {
        this.mExtraTopOffset = Utils.convertDpToPixel(r1);
    }

    public float getExtraTopOffset() {
        return this.mExtraTopOffset;
    }

    public void setExtraRightOffset(float r1) {
        this.mExtraRightOffset = Utils.convertDpToPixel(r1);
    }

    public float getExtraRightOffset() {
        return this.mExtraRightOffset;
    }

    public void setExtraBottomOffset(float r1) {
        this.mExtraBottomOffset = Utils.convertDpToPixel(r1);
    }

    public float getExtraBottomOffset() {
        return this.mExtraBottomOffset;
    }

    public void setExtraLeftOffset(float r1) {
        this.mExtraLeftOffset = Utils.convertDpToPixel(r1);
    }

    public float getExtraLeftOffset() {
        return this.mExtraLeftOffset;
    }

    public void setLogEnabled(boolean r1) {
        this.mLogEnabled = r1;
    }

    public boolean isLogEnabled() {
        return this.mLogEnabled;
    }

    public void setNoDataText(String r1) {
        this.mNoDataText = r1;
    }

    public void setNoDataTextColor(int r1) {
        this.mInfoPaint.setColor(r1);
    }

    public void setNoDataTextTypeface(Typeface r1) {
        this.mInfoPaint.setTypeface(r1);
    }

    public void setTouchEnabled(boolean r1) {
        this.mTouchEnabled = r1;
    }

    public void setMarker(IMarker r1) {
        this.mMarker = r1;
    }

    public IMarker getMarker() {
        return this.mMarker;
    }

    @Deprecated
    public void setMarkerView(IMarker r1) {
        setMarker(r1);
    }

    @Deprecated
    public IMarker getMarkerView() {
        return getMarker();
    }

    public void setDescription(Description r1) {
        this.mDescription = r1;
    }

    public Description getDescription() {
        return this.mDescription;
    }

    public Legend getLegend() {
        return this.mLegend;
    }

    public LegendRenderer getLegendRenderer() {
        return this.mLegendRenderer;
    }

    @Override // com.github.mikephil.charting.interfaces.dataprovider.ChartInterface
    public RectF getContentRect() {
        return this.mViewPortHandler.getContentRect();
    }

    public void disableScroll() {
        ViewParent r1 = getParent();
        if (r1 == null) goto L6;
        r1.requestDisallowInterceptTouchEvent(true);
        return;
    }

    public void enableScroll() {
        ViewParent r1 = getParent();
        if (r1 == null) goto L6;
        r1.requestDisallowInterceptTouchEvent(false);
        return;
    }

    public void setPaint(Paint r2, int r3) {
        if (r3 != 7) goto L5;
        this.mInfoPaint = r2;
        return;
    L5:
        if (r3 != 11) goto L11;
        this.mDescPaint = r2;
        return;
    }

    public Paint getPaint(int r2) {
        if (r2 == 7) goto L11;
        if (r2 == 11) goto L9;
        return null;
    L9:
        return this.mDescPaint;
    L11:
        return this.mInfoPaint;
    }

    @Deprecated
    public boolean isDrawMarkerViewsEnabled() {
        return isDrawMarkersEnabled();
    }

    @Deprecated
    public void setDrawMarkerViews(boolean r1) {
        setDrawMarkers(r1);
    }

    public boolean isDrawMarkersEnabled() {
        return this.mDrawMarkers;
    }

    public void setDrawMarkers(boolean r1) {
        this.mDrawMarkers = r1;
    }

    public T getData() {
        return this.mData;
    }

    public ViewPortHandler getViewPortHandler() {
        return this.mViewPortHandler;
    }

    public DataRenderer getRenderer() {
        return this.mRenderer;
    }

    public void setRenderer(DataRenderer r1) {
        if (r1 == null) goto L5;
        this.mRenderer = r1;
        return;
    }

    public IHighlighter getHighlighter() {
        return this.mHighlighter;
    }

    public void setHighlighter(ChartHighlighter r1) {
        this.mHighlighter = r1;
    }

    @Override // com.github.mikephil.charting.interfaces.dataprovider.ChartInterface
    public MPPointF getCenterOfView() {
        return getCenter();
    }

    public Bitmap getChartBitmap() {
        Bitmap r0 = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.RGB_565);
        Canvas r1 = new Canvas(r0);
        Drawable r2 = getBackground();
        if (r2 == null) goto L5;
        r2.draw(r1);
    L6:
        draw(r1);
        return r0;
    L5:
        r1.drawColor(-1);
        goto L6
    }

    public boolean saveToPath(String r4, String r5) {
        Bitmap r3 = getChartBitmap();
        FileOutputStream r0 = new FileOutputStream(Environment.getExternalStorageDirectory().getPath() + r5 + LibrarianImpl.Constants.SEPARATOR + r4 + ".png");     // Catch: Exception -> L6
        r3.compress(Bitmap.CompressFormat.PNG, 40, r0);     // Catch: Exception -> L6
        r0.close();     // Catch: Exception -> L6
        return true;
    L6:
        e = move-exception;
        e.printStackTrace();
        return false;
    }

    public boolean saveToGallery(String r8, String r9, String r10, Bitmap.CompressFormat r11, int r12) {
        if (r12 >= 0) goto L4;
    L5:
        r12 = 50;
    L6:
        long r0 = System.currentTimeMillis();
        File r3 = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/DCIM/" + r9);
        if (r3.exists() == false) goto L9;
    L11:
        int r13 = AnonymousClass2.$SwitchMap$android$graphics$Bitmap$CompressFormat[r11.ordinal()];
        if (r13 != 1) goto L14;
        boolean r5 = r8.endsWith(".png");
        String r6 = MimeType.PNG;
        if (r5 == true) goto L26;
        r8 = r8 + ".png";
    L26:
        String r14 = r3.getAbsolutePath() + LibrarianImpl.Constants.SEPARATOR + r8;
        FileOutputStream r4 = new FileOutputStream(r14);     // Catch: IOException -> L32
        getChartBitmap().compress(r11, r12, r4);     // Catch: IOException -> L32
        r4.flush();     // Catch: IOException -> L32
        r4.close();     // Catch: IOException -> L32
        long r15 = new File(r14).length();
        ContentValues r7 = new ContentValues(8);
        r7.put("title", r8);
        r7.put("_display_name", r8);
        r7.put("date_added", Long.valueOf(r0));
        r7.put("mime_type", r6);
        r7.put("description", r10);
        r7.put("orientation", 0);
        r7.put("_data", r14);
        r7.put("_size", Long.valueOf(r15));
        if (getContext().getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, r7) != null) goto L31;
        return false;
    L31:
        return true;
    L32:
        e = move-exception;
        e.printStackTrace();
        return false;
    L14:
        if (r13 == 2) goto L20;
        boolean r16 = r8.endsWith(".jpg");
        r6 = MimeType.JPEG;
        if (r16 == true) goto L26;
        if (r8.endsWith(".jpeg") == true) goto L26;
        r8 = r8 + ".jpg";
        goto L26
    L20:
        boolean r17 = r8.endsWith(".webp");
        r6 = MimeType.WEBP;
        if (r17 == true) goto L26;
        r8 = r8 + ".webp";
        goto L26
    L9:
        if (r3.mkdirs() == true) goto L11;
        return false;
    L4:
        if (r12 <= 100) goto L6;
        goto L5
    }

    public boolean saveToGallery(String r7, int r8) {
        return saveToGallery(r7, "", "MPAndroidChart-Library Save", Bitmap.CompressFormat.PNG, r8);
    }

    public boolean saveToGallery(String r7) {
        return saveToGallery(r7, "", "MPAndroidChart-Library Save", Bitmap.CompressFormat.PNG, 40);
    }

    public void removeViewportJob(Runnable r1) {
        this.mJobs.remove(r1);
    }

    public void clearAllViewportJobs() {
        this.mJobs.clear();
    }

    public void addViewportJob(Runnable r2) {
        if (this.mViewPortHandler.hasChartDimens() == false) goto L5;
        post(r2);
        return;
    L5:
        this.mJobs.add(r2);
    }

    public ArrayList<Runnable> getJobs() {
        return this.mJobs;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean r2, int r3, int r4, int r5, int r6) {
        int r7 = 0;
    L4:
        if (r7 >= getChildCount()) goto L6;
        getChildAt(r7).layout(r3, r4, r5, r6);
        r7 = r7 + 1;
        goto L4
    }

    @Override // android.view.View
    protected void onMeasure(int r3, int r4) {
        super.onMeasure(r3, r4);
        int r0 = (int) Utils.convertDpToPixel(50.0f);
        setMeasuredDimension(Math.max(getSuggestedMinimumWidth(), resolveSize(r0, r3)), Math.max(getSuggestedMinimumHeight(), resolveSize(r0, r4)));
    }

    @Override // android.view.View
    protected void onSizeChanged(int r5, int r6, int r7, int r8) {
        if (this.mLogEnabled == false) goto L6;
        Log.i(LOG_TAG, "OnSizeChanged()");
    L6:
        if (r5 <= 0) goto L16;
        if (r6 <= 0) goto L16;
        if (r5 >= 10000) goto L16;
        if (r6 >= 10000) goto L16;
        if (this.mLogEnabled == false) goto L14;
        Log.i(LOG_TAG, "Setting chart dimens, width: " + r5 + ", height: " + r6);
    L14:
        this.mViewPortHandler.setChartDimens(r5, r6);
    L18:
        notifyDataSetChanged();
        Iterator<Runnable> r0 = this.mJobs.iterator();
    L20:
        if (r0.hasNext() == false) goto L22;
        post(r0.next());
        goto L20
    L22:
        this.mJobs.clear();
        super.onSizeChanged(r5, r6, r7, r8);
        return;
    L16:
        if (this.mLogEnabled == false) goto L18;
        Log.w(LOG_TAG, "*Avoiding* setting chart dimens! width: " + r5 + ", height: " + r6);
        goto L18
    }

    public void setHardwareAccelerationEnabled(boolean r2) {
        if (r2 == false) goto L5;
        setLayerType(2, null);
        return;
    L5:
        setLayerType(1, null);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.mUnbind == false) goto L6;
        unbindDrawables(this);
        return;
    }

    private void unbindDrawables(View r4) {
        if (r4.getBackground() == null) goto L6;
        r4.getBackground().setCallback(null);
    L6:
        if ((r4 instanceof ViewGroup) == false) goto L14;
        int r0 = 0;
    L8:
        ViewGroup r1 = (ViewGroup) r4;
        if (r0 >= r1.getChildCount()) goto L11;
        unbindDrawables(r1.getChildAt(r0));
        r0 = r0 + 1;
        goto L8
    L11:
        r1.removeAllViews();
        return;
    }

    public void setUnbindEnabled(boolean r1) {
        this.mUnbind = r1;
    }
}
