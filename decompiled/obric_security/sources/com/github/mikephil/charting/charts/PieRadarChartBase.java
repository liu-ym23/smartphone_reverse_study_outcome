package com.github.mikephil.charting.charts;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.ChartData;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.interfaces.datasets.IDataSet;
import com.github.mikephil.charting.listener.PieRadarChartTouchListener;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Utils;

/* JADX INFO: loaded from: classes2.dex */
public abstract class PieRadarChartBase<T extends ChartData<? extends IDataSet<? extends Entry>>> extends Chart<T> {
    protected float mMinOffset;
    private float mRawRotationAngle;
    protected boolean mRotateEnabled;
    private float mRotationAngle;

    /* JADX INFO: renamed from: com.github.mikephil.charting.charts.PieRadarChartBase$2, reason: invalid class name */
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

    @Override // com.github.mikephil.charting.charts.Chart
    protected void calcMinMax() {
    }

    public abstract int getIndexForAngle(float r1);

    public abstract float getRadius();

    protected abstract float getRequiredBaseOffset();

    protected abstract float getRequiredLegendOffset();

    @Override // com.github.mikephil.charting.interfaces.dataprovider.ChartInterface
    public float getYChartMax() {
        return 0.0f;
    }

    @Override // com.github.mikephil.charting.interfaces.dataprovider.ChartInterface
    public float getYChartMin() {
        return 0.0f;
    }

    public PieRadarChartBase(Context r1) {
        super(r1);
        this.mRotationAngle = 270.0f;
        this.mRawRotationAngle = 270.0f;
        this.mRotateEnabled = true;
        this.mMinOffset = 0.0f;
    }

    public PieRadarChartBase(Context r1, AttributeSet r2) {
        super(r1, r2);
        this.mRotationAngle = 270.0f;
        this.mRawRotationAngle = 270.0f;
        this.mRotateEnabled = true;
        this.mMinOffset = 0.0f;
    }

    public PieRadarChartBase(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        this.mRotationAngle = 270.0f;
        this.mRawRotationAngle = 270.0f;
        this.mRotateEnabled = true;
        this.mMinOffset = 0.0f;
    }

    @Override // com.github.mikephil.charting.charts.Chart
    protected void init() {
        super.init();
        this.mChartTouchListener = new PieRadarChartTouchListener(this);
    }

    @Override // com.github.mikephil.charting.interfaces.dataprovider.ChartInterface
    public int getMaxVisibleCount() {
        return this.mData.getEntryCount();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent r2) {
        if (this.mTouchEnabled == false) goto L9;
        if (this.mChartTouchListener == null) goto L9;
        return this.mChartTouchListener.onTouch(this, r2);
    L9:
        return super.onTouchEvent(r2);
    }

    @Override // android.view.View
    public void computeScroll() {
        if ((this.mChartTouchListener instanceof PieRadarChartTouchListener) == false) goto L6;
        ((PieRadarChartTouchListener) this.mChartTouchListener).computeScroll();
        return;
    }

    @Override // com.github.mikephil.charting.charts.Chart
    public void notifyDataSetChanged() {
        if (this.mData != null) goto L5;
        return;
    L5:
        calcMinMax();
        if (this.mLegend == null) goto L8;
        this.mLegendRenderer.computeLegend(this.mData);
    L8:
        calculateOffsets();
    }

    @Override // com.github.mikephil.charting.charts.Chart
    public void calculateOffsets() {
        float r1 = 0.0f;
        if (this.mLegend != null) goto L5;
    L61:
        float r0 = 0.0f;
        float r2 = 0.0f;
        float r3 = 0.0f;
    L62:
        float r4 = Utils.convertDpToPixel(this.mMinOffset);
        if ((this instanceof RadarChart) == false) goto L69;
        XAxis r5 = getXAxis();
        if (r5.isEnabled() == false) goto L69;
        if (r5.isDrawLabelsEnabled() == false) goto L69;
        r4 = Math.max(r4, r5.mLabelRotatedWidth);
    L69:
        float r6 = r3 + getExtraTopOffset();
        float r7 = r0 + getExtraRightOffset();
        float r8 = r2 + getExtraBottomOffset();
        float r9 = Math.max(r4, r1 + getExtraLeftOffset());
        float r10 = Math.max(r4, r6);
        float r11 = Math.max(r4, r7);
        float r12 = Math.max(r4, Math.max(getRequiredBaseOffset(), r8));
        this.mViewPortHandler.restrainViewPort(r9, r10, r11, r12);
        if (this.mLogEnabled == false) goto L73;
        Log.i(Chart.LOG_TAG, "offsetLeft: " + r9 + ", offsetTop: " + r10 + ", offsetRight: " + r11 + ", offsetBottom: " + r12);
        return;
    L73:
        return;
    L5:
        if (this.mLegend.isEnabled() == false) goto L61;
        if (this.mLegend.isDrawInsideEnabled() == true) goto L61;
        float r13 = Math.min(this.mLegend.mNeededWidth, this.mViewPortHandler.getChartWidth() * this.mLegend.getMaxSizePercent());
        int r14 = AnonymousClass2.$SwitchMap$com$github$mikephil$charting$components$Legend$LegendOrientation[this.mLegend.getOrientation().ordinal()];
        if (r14 == 1) goto L24;
        if (r14 == 2) goto L13;
    L19:
        float r15 = 0.0f;
        float r16 = 0.0f;
    L20:
        float r17 = r16;
    L60:
        r1 = r1 + getRequiredBaseOffset();
        r0 = r15 + getRequiredBaseOffset();
        r3 = r17 + getRequiredBaseOffset();
        r2 = r16 + getRequiredBaseOffset();
        goto L62
    L13:
        if (this.mLegend.getVerticalAlignment() != Legend.LegendVerticalAlignment.TOP) goto L15;
    L16:
        float r18 = Math.min(this.mLegend.mNeededHeight + getRequiredLegendOffset(), this.mViewPortHandler.getChartHeight() * this.mLegend.getMaxSizePercent());
        int r19 = AnonymousClass2.$SwitchMap$com$github$mikephil$charting$components$Legend$LegendVerticalAlignment[this.mLegend.getVerticalAlignment().ordinal()];
        if (r19 == 1) goto L22;
        if (r19 != 2) goto L19;
    L21:
        r16 = r18;
        r15 = 0.0f;
        r17 = 0.0f;
    L22:
        r17 = r18;
        r15 = 0.0f;
        r16 = 0.0f;
        goto L60
    L15:
        if (this.mLegend.getVerticalAlignment() != Legend.LegendVerticalAlignment.BOTTOM) goto L19;
    L24:
        if (this.mLegend.getHorizontalAlignment() == Legend.LegendHorizontalAlignment.LEFT) goto L30;
        if (this.mLegend.getHorizontalAlignment() == Legend.LegendHorizontalAlignment.RIGHT) goto L30;
        r15 = 0.0f;
    L46:
        int r20 = AnonymousClass2.$SwitchMap$com$github$mikephil$charting$components$Legend$LegendHorizontalAlignment[this.mLegend.getHorizontalAlignment().ordinal()];
        if (r20 == 1) goto L59;
        if (r20 != 2) goto L50;
        r16 = 0.0f;
        goto L20
    L50:
        if (r20 != 3) goto L19;
        int r21 = AnonymousClass2.$SwitchMap$com$github$mikephil$charting$components$Legend$LegendVerticalAlignment[this.mLegend.getVerticalAlignment().ordinal()];
        if (r21 == 1) goto L57;
        if (r21 != 2) goto L19;
        r18 = Math.min(this.mLegend.mNeededHeight, this.mViewPortHandler.getChartHeight() * this.mLegend.getMaxSizePercent());
        goto L21
    L57:
        r18 = Math.min(this.mLegend.mNeededHeight, this.mViewPortHandler.getChartHeight() * this.mLegend.getMaxSizePercent());
        goto L22
    L59:
        r16 = 0.0f;
        r17 = 0.0f;
        r1 = r15;
        r15 = 0.0f;
    L30:
        if (this.mLegend.getVerticalAlignment() != Legend.LegendVerticalAlignment.CENTER) goto L32;
        r15 = r13 + Utils.convertDpToPixel(13.0f);
        goto L46
    L32:
        r15 = r13 + Utils.convertDpToPixel(8.0f);
        float r22 = this.mLegend.mNeededHeight + this.mLegend.mTextHeightMax;
        MPPointF r23 = getCenter();
        if (this.mLegend.getHorizontalAlignment() != Legend.LegendHorizontalAlignment.RIGHT) goto L35;
        float r24 = (getWidth() - r15) + 15.0f;
    L36:
        float r25 = r22 + 15.0f;
        float r26 = distanceToCenter(r24, r25);
        MPPointF r27 = getPosition(r23, getRadius(), getAngleForPoint(r24, r25));
        float r28 = distanceToCenter(r27.x, r27.y);
        float r29 = Utils.convertDpToPixel(5.0f);
        if (r25 < r23.y) goto L42;
        if ((getHeight() - r15) <= getWidth()) goto L42;
    L45:
        MPPointF.recycleInstance(r23);
        MPPointF.recycleInstance(r27);
    L42:
        if (r26 >= r28) goto L44;
        r15 = r29 + (r28 - r26);
        goto L45
    L44:
        r15 = 0.0f;
        goto L45
    L35:
        r24 = r15 - 15.0f;
        goto L36
    }

    public float getAngleForPoint(float r7, float r8) {
        MPPointF r6 = getCenterOffsets();
        double r0 = r7 - r6.x;
        double r2 = r8 - r6.y;
        float r9 = (float) Math.toDegrees(Math.acos(r2 / Math.sqrt((r0 * r0) + (r2 * r2))));
        if (r7 <= r6.x) goto L5;
        r9 = 360.0f - r9;
    L5:
        float r10 = r9 + 90.0f;
        if (r10 <= 360.0f) goto L8;
        r10 = r10 - 360.0f;
    L8:
        MPPointF.recycleInstance(r6);
        return r10;
    }

    public MPPointF getPosition(MPPointF r2, float r3, float r4) {
        MPPointF r0 = MPPointF.getInstance(0.0f, 0.0f);
        getPosition(r2, r3, r4, r0);
        return r0;
    }

    public void getPosition(MPPointF r7, float r8, float r9, MPPointF r10) {
        double r2 = r8;
        double r11 = r9;
        r10.x = (float) (((double) r7.x) + (Math.cos(Math.toRadians(r11)) * r2));
        r10.y = (float) (((double) r7.y) + (r2 * Math.sin(Math.toRadians(r11))));
    }

    public float distanceToCenter(float r5, float r6) {
        MPPointF r4 = getCenterOffsets();
        if (r5 <= r4.x) goto L5;
        float r7 = r5 - r4.x;
    L7:
        if (r6 <= r4.y) goto L9;
        float r8 = r6 - r4.y;
    L10:
        float r9 = (float) Math.sqrt(Math.pow(r7, 2.0d) + Math.pow(r8, 2.0d));
        MPPointF.recycleInstance(r4);
        return r9;
    L9:
        r8 = r4.y - r6;
        goto L10
    L5:
        r7 = r4.x - r5;
        goto L7
    }

    public void setRotationAngle(float r1) {
        this.mRawRotationAngle = r1;
        this.mRotationAngle = Utils.getNormalizedAngle(r1);
    }

    public float getRawRotationAngle() {
        return this.mRawRotationAngle;
    }

    public float getRotationAngle() {
        return this.mRotationAngle;
    }

    public void setRotationEnabled(boolean r1) {
        this.mRotateEnabled = r1;
    }

    public boolean isRotationEnabled() {
        return this.mRotateEnabled;
    }

    public float getMinOffset() {
        return this.mMinOffset;
    }

    public void setMinOffset(float r1) {
        this.mMinOffset = r1;
    }

    public float getDiameter() {
        RectF r0 = this.mViewPortHandler.getContentRect();
        r0.left += getExtraLeftOffset();
        r0.top += getExtraTopOffset();
        r0.right -= getExtraRightOffset();
        r0.bottom -= getExtraBottomOffset();
        return Math.min(r0.width(), r0.height());
    }

    public void spin(int r3, float r4, float r5, Easing.EasingFunction r6) {
        setRotationAngle(r4);
        ObjectAnimator r7 = ObjectAnimator.ofFloat(this, "rotationAngle", new float[]{r4, r5});
        r7.setDuration(r3);
        r7.setInterpolator(r6);
        r7.addUpdateListener(new AnonymousClass1(this));
        r7.start();
    }
}
