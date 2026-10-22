package com.github.mikephil.charting.listener;

import android.graphics.Matrix;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.animation.AnimationUtils;
import com.github.mikephil.charting.charts.BarLineChartBase;
import com.github.mikephil.charting.charts.HorizontalBarChart;
import com.github.mikephil.charting.data.BarLineScatterCandleBubbleData;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.datasets.IBarLineScatterCandleBubbleDataSet;
import com.github.mikephil.charting.interfaces.datasets.IDataSet;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;

/* JADX INFO: loaded from: classes2.dex */
public class BarLineChartTouchListener extends ChartTouchListener<BarLineChartBase<? extends BarLineScatterCandleBubbleData<? extends IBarLineScatterCandleBubbleDataSet<? extends Entry>>>> {
    private IDataSet mClosestDataSetToTouch;
    private MPPointF mDecelerationCurrentPoint;
    private long mDecelerationLastTime;
    private MPPointF mDecelerationVelocity;
    private float mDragTriggerDist;
    private Matrix mMatrix;
    private float mMinScalePointerDistance;
    private float mSavedDist;
    private Matrix mSavedMatrix;
    private float mSavedXDist;
    private float mSavedYDist;
    private MPPointF mTouchPointCenter;
    private MPPointF mTouchStartPoint;
    private VelocityTracker mVelocityTracker;

    public BarLineChartTouchListener(BarLineChartBase<? extends BarLineScatterCandleBubbleData<? extends IBarLineScatterCandleBubbleDataSet<? extends Entry>>> r3, Matrix r4, float r5) {
        super(r3);
        this.mMatrix = new Matrix();
        this.mSavedMatrix = new Matrix();
        this.mTouchStartPoint = MPPointF.getInstance(0.0f, 0.0f);
        this.mTouchPointCenter = MPPointF.getInstance(0.0f, 0.0f);
        this.mSavedXDist = 1.0f;
        this.mSavedYDist = 1.0f;
        this.mSavedDist = 1.0f;
        this.mDecelerationLastTime = 0;
        this.mDecelerationCurrentPoint = MPPointF.getInstance(0.0f, 0.0f);
        this.mDecelerationVelocity = MPPointF.getInstance(0.0f, 0.0f);
        this.mMatrix = r4;
        this.mDragTriggerDist = Utils.convertDpToPixel(r5);
        this.mMinScalePointerDistance = Utils.convertDpToPixel(3.5f);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View r12, MotionEvent r13) {
        if (this.mVelocityTracker != null) goto L5;
        this.mVelocityTracker = VelocityTracker.obtain();
    L5:
        this.mVelocityTracker.addMovement(r13);
        int r1 = 3;
        if (r13.getActionMasked() != 3) goto L11;
        VelocityTracker r14 = this.mVelocityTracker;
        if (r14 == null) goto L11;
        r14.recycle();
        this.mVelocityTracker = null;
    L11:
        if (this.mTouchMode != 0) goto L14;
        this.mGestureDetector.onTouchEvent(r13);
    L14:
        if (((BarLineChartBase) this.mChart).isDragEnabled() == false) goto L16;
    L20:
        int r15 = r13.getAction() & 255;
        if (r15 == 0) goto L120;
        boolean r5 = false;
        if (r15 == 1) goto L98;
        if (r15 == 2) goto L51;
        if (r15 == 3) goto L49;
        if (r15 == 5) goto L32;
        if (r15 != 6) goto L121;
        Utils.velocityTrackerPointerUpCleanUpIfNecessary(r13, this.mVelocityTracker);
        this.mTouchMode = 5;
    L121:
        this.mMatrix = ((BarLineChartBase) this.mChart).getViewPortHandler().refresh(this.mMatrix, this.mChart, true);
        return true;
    L32:
        if (r13.getPointerCount() < 2) goto L121;
        ((BarLineChartBase) this.mChart).disableScroll();
        saveTouchStart(r13);
        this.mSavedXDist = getXDist(r13);
        this.mSavedYDist = getYDist(r13);
        float r16 = spacing(r13);
        this.mSavedDist = r16;
        if (r16 > 10.0f) goto L36;
    L48:
        midPoint(this.mTouchPointCenter, r13);
        goto L121
    L36:
        if (((BarLineChartBase) this.mChart).isPinchZoomEnabled() == false) goto L39;
        this.mTouchMode = 4;
        goto L48
    L39:
        if (((BarLineChartBase) this.mChart).isScaleXEnabled() == ((BarLineChartBase) this.mChart).isScaleYEnabled()) goto L45;
        if (((BarLineChartBase) this.mChart).isScaleXEnabled() == false) goto L43;
        r1 = 2;
    L43:
        this.mTouchMode = r1;
        goto L48
    L45:
        if (this.mSavedXDist <= this.mSavedYDist) goto L47;
        r1 = 2;
    L47:
        this.mTouchMode = r1;
        goto L48
    L49:
        this.mTouchMode = 0;
        endAction(r13);
        goto L121
    L51:
        if (this.mTouchMode != 1) goto L61;
        ((BarLineChartBase) this.mChart).disableScroll();
        float r0 = 0.0f;
        if (((BarLineChartBase) this.mChart).isDragXEnabled() == false) goto L55;
        float r17 = r13.getX() - this.mTouchStartPoint.x;
    L57:
        if (((BarLineChartBase) this.mChart).isDragYEnabled() == false) goto L59;
        r0 = r13.getY() - this.mTouchStartPoint.y;
    L59:
        performDrag(r13, r17, r0);
        goto L121
    L55:
        r17 = 0.0f;
        goto L57
    L61:
        if (this.mTouchMode != 2) goto L63;
    L93:
        ((BarLineChartBase) this.mChart).disableScroll();
        if (((BarLineChartBase) this.mChart).isScaleXEnabled() == false) goto L96;
    L97:
        performZoom(r13);
        goto L121
    L96:
        if (((BarLineChartBase) this.mChart).isScaleYEnabled() == false) goto L121;
    L63:
        if (this.mTouchMode == 3) goto L93;
        if (this.mTouchMode == 4) goto L93;
        if (this.mTouchMode != 0) goto L121;
        if (Math.abs(distance(r13.getX(), this.mTouchStartPoint.x, r13.getY(), this.mTouchStartPoint.y)) <= this.mDragTriggerDist) goto L121;
        if (((BarLineChartBase) this.mChart).isDragEnabled() == false) goto L121;
        if (((BarLineChartBase) this.mChart).isFullyZoomedOut() == true) goto L76;
    L77:
        r5 = true;
    L78:
        if (r5 == false) goto L89;
        float r18 = Math.abs(r13.getX() - this.mTouchStartPoint.x);
        float r19 = Math.abs(r13.getY() - this.mTouchStartPoint.y);
        if (((BarLineChartBase) this.mChart).isDragXEnabled() == true) goto L84;
        if (r19 < r18) goto L121;
    L84:
        if (((BarLineChartBase) this.mChart).isDragYEnabled() == false) goto L86;
    L87:
        this.mLastGesture = ChartTouchListener.ChartGesture.DRAG;
        this.mTouchMode = 1;
        goto L121
    L86:
        if (r19 > r18) goto L121;
    L89:
        if (((BarLineChartBase) this.mChart).isHighlightPerDragEnabled() == false) goto L121;
        this.mLastGesture = ChartTouchListener.ChartGesture.DRAG;
        if (((BarLineChartBase) this.mChart).isHighlightPerDragEnabled() == false) goto L121;
        performHighlightDrag(r13);
        goto L121
    L76:
        if (((BarLineChartBase) this.mChart).hasNoDragOffset() == true) goto L78;
    L98:
        VelocityTracker r110 = this.mVelocityTracker;
        int r7 = r13.getPointerId(0);
        r110.computeCurrentVelocity(1000, Utils.getMaximumFlingVelocity());
        float r8 = r110.getYVelocity(r7);
        float r111 = r110.getXVelocity(r7);
        if (Math.abs(r111) > Utils.getMinimumFlingVelocity()) goto L103;
        if (Math.abs(r8) > Utils.getMinimumFlingVelocity()) goto L103;
    L108:
        if (this.mTouchMode != 2) goto L110;
    L115:
        ((BarLineChartBase) this.mChart).calculateOffsets();
        ((BarLineChartBase) this.mChart).postInvalidate();
    L116:
        this.mTouchMode = 0;
        ((BarLineChartBase) this.mChart).enableScroll();
        VelocityTracker r112 = this.mVelocityTracker;
        if (r112 == null) goto L119;
        r112.recycle();
        this.mVelocityTracker = null;
    L119:
        endAction(r13);
        goto L121
    L110:
        if (this.mTouchMode == 3) goto L115;
        if (this.mTouchMode == 4) goto L115;
        if (this.mTouchMode != 5) goto L116;
    L103:
        if (this.mTouchMode != 1) goto L108;
        if (((BarLineChartBase) this.mChart).isDragDecelerationEnabled() == false) goto L108;
        stopDeceleration();
        this.mDecelerationLastTime = AnimationUtils.currentAnimationTimeMillis();
        this.mDecelerationCurrentPoint.x = r13.getX();
        this.mDecelerationCurrentPoint.y = r13.getY();
        this.mDecelerationVelocity.x = r111;
        this.mDecelerationVelocity.y = r8;
        Utils.postInvalidateOnAnimation(this.mChart);
        goto L108
    L120:
        startAction(r13);
        stopDeceleration();
        saveTouchStart(r13);
        goto L121
    L16:
        if (((BarLineChartBase) this.mChart).isScaleXEnabled() == true) goto L20;
        if (((BarLineChartBase) this.mChart).isScaleYEnabled() == true) goto L20;
        return true;
    }

    private void saveTouchStart(MotionEvent r3) {
        this.mSavedMatrix.set(this.mMatrix);
        MPPointF r0 = this.mTouchStartPoint;
        r0.x = r3.getX();
        MPPointF r1 = this.mTouchStartPoint;
        r1.y = r3.getY();
        this.mClosestDataSetToTouch = ((BarLineChartBase) this.mChart).getDataSetByTouchPoint(r3.getX(), r3.getY());
    }

    private void performDrag(MotionEvent r3, float r4, float r5) {
        this.mLastGesture = ChartTouchListener.ChartGesture.DRAG;
        this.mMatrix.set(this.mSavedMatrix);
        OnChartGestureListener r0 = ((BarLineChartBase) this.mChart).getOnChartGestureListener();
        if (inverted() == true) goto L5;
    L8:
        this.mMatrix.postTranslate(r4, r5);
        if (r0 == null) goto L12;
        r0.onChartTranslate(r3, r4, r5);
        return;
    L12:
        return;
    L5:
        if ((this.mChart instanceof HorizontalBarChart) == false) goto L7;
        r4 = -r4;
        goto L8
    L7:
        r5 = -r5;
        goto L8
    }

    private void performZoom(MotionEvent r11) {
        if (r11.getPointerCount() < 2) goto L62;
        OnChartGestureListener r0 = ((BarLineChartBase) this.mChart).getOnChartGestureListener();
        float r2 = spacing(r11);
        if (r2 <= this.mMinScalePointerDistance) goto L63;
        MPPointF r3 = getTrans(this.mTouchPointCenter.x, this.mTouchPointCenter.y);
        ViewPortHandler r4 = ((BarLineChartBase) this.mChart).getViewPortHandler();
        boolean r7 = true;
        float r9 = 1.0f;
        if (this.mTouchMode != 4) goto L31;
        this.mLastGesture = ChartTouchListener.ChartGesture.PINCH_ZOOM;
        float r5 = r2 / this.mSavedDist;
        if (r5 < 1.0f) goto L12;
        r7 = false;
    L12:
        if (r7 == false) goto L14;
        boolean r1 = r4.canZoomOutMoreX();
    L15:
        if (r7 == false) goto L17;
        boolean r6 = r4.canZoomOutMoreY();
    L19:
        if (((BarLineChartBase) this.mChart).isScaleXEnabled() == false) goto L21;
        float r8 = r5;
    L23:
        if (((BarLineChartBase) this.mChart).isScaleYEnabled() == false) goto L25;
        r9 = r5;
    L25:
        if (r6 == true) goto L27;
        if (r1 == true) goto L27;
    L60:
        MPPointF.recycleInstance(r3);
        return;
    L27:
        this.mMatrix.set(this.mSavedMatrix);
        this.mMatrix.postScale(r8, r9, r3.x, r3.y);
        if (r0 == null) goto L60;
        r0.onChartScale(r11, r8, r9);
        goto L60
    L21:
        r8 = 1.0f;
        goto L23
    L17:
        r6 = r4.canZoomInMoreY();
        goto L19
    L14:
        r1 = r4.canZoomInMoreX();
        goto L15
    L31:
        if (this.mTouchMode != 2) goto L46;
        if (((BarLineChartBase) this.mChart).isScaleXEnabled() == false) goto L46;
        this.mLastGesture = ChartTouchListener.ChartGesture.X_ZOOM;
        float r10 = getXDist(r11) / this.mSavedXDist;
        if (r10 < 1.0f) goto L38;
        r7 = false;
    L38:
        if (r7 == false) goto L40;
        boolean r12 = r4.canZoomOutMoreX();
    L41:
        if (r12 == false) goto L60;
        this.mMatrix.set(this.mSavedMatrix);
        this.mMatrix.postScale(r10, 1.0f, r3.x, r3.y);
        if (r0 == null) goto L60;
        r0.onChartScale(r11, r10, 1.0f);
        goto L60
    L40:
        r12 = r4.canZoomInMoreX();
    L46:
        if (this.mTouchMode != 3) goto L60;
        if (((BarLineChartBase) this.mChart).isScaleYEnabled() == false) goto L60;
        this.mLastGesture = ChartTouchListener.ChartGesture.Y_ZOOM;
        float r13 = getYDist(r11) / this.mSavedYDist;
        if (r13 < 1.0f) goto L53;
        r7 = false;
    L53:
        if (r7 == false) goto L55;
        boolean r14 = r4.canZoomOutMoreY();
    L56:
        if (r14 == false) goto L60;
        this.mMatrix.set(this.mSavedMatrix);
        this.mMatrix.postScale(1.0f, r13, r3.x, r3.y);
        if (r0 == null) goto L60;
        r0.onChartScale(r11, 1.0f, r13);
        goto L60
    L55:
        r14 = r4.canZoomInMoreY();
        goto L56
    L63:
        return;
    }

    private void performHighlightDrag(MotionEvent r3) {
        Highlight r4 = ((BarLineChartBase) this.mChart).getHighlightByTouchPoint(r3.getX(), r3.getY());
        if (r4 != null) goto L5;
        return;
    L5:
        if (r4.equalTo(this.mLastHighlighted) == true) goto L9;
        this.mLastHighlighted = r4;
        ((BarLineChartBase) this.mChart).highlightValue(r4, true);
        return;
    }

    private static void midPoint(MPPointF r4, MotionEvent r5) {
        float r1 = r5.getX(0) + r5.getX(1);
        float r0 = r5.getY(0) + r5.getY(1);
        r4.x = r1 / 2.0f;
        r4.y = r0 / 2.0f;
    }

    private static float spacing(MotionEvent r4) {
        float r1 = r4.getX(0) - r4.getX(1);
        float r0 = r4.getY(0) - r4.getY(1);
        return (float) Math.sqrt((r1 * r1) + (r0 * r0));
    }

    private static float getXDist(MotionEvent r2) {
        return Math.abs(r2.getX(0) - r2.getX(1));
    }

    private static float getYDist(MotionEvent r2) {
        return Math.abs(r2.getY(0) - r2.getY(1));
    }

    public MPPointF getTrans(float r3, float r4) {
        ViewPortHandler r0 = ((BarLineChartBase) this.mChart).getViewPortHandler();
        float r5 = r3 - r0.offsetLeft();
        if (inverted() == false) goto L5;
        float r2 = -(r4 - r0.offsetTop());
    L7:
        return MPPointF.getInstance(r5, r2);
    L5:
        r2 = -((((BarLineChartBase) this.mChart).getMeasuredHeight() - r4) - r0.offsetBottom());
        goto L7
    }

    private boolean inverted() {
        if (this.mClosestDataSetToTouch != null) goto L7;
        if (((BarLineChartBase) this.mChart).isAnyAxisInverted() == false) goto L7;
    L10:
        return true;
    L7:
        if (this.mClosestDataSetToTouch != null) goto L9;
    L11:
        return false;
    L9:
        if (((BarLineChartBase) this.mChart).isInverted(this.mClosestDataSetToTouch.getAxisDependency()) == false) goto L11;
        goto L10
    }

    public Matrix getMatrix() {
        return this.mMatrix;
    }

    public void setDragTriggerDist(float r1) {
        this.mDragTriggerDist = Utils.convertDpToPixel(r1);
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
    public boolean onDoubleTap(MotionEvent r7) {
        this.mLastGesture = ChartTouchListener.ChartGesture.DOUBLE_TAP;
        OnChartGestureListener r0 = ((BarLineChartBase) this.mChart).getOnChartGestureListener();
        if (r0 == null) goto L6;
        r0.onChartDoubleTapped(r7);
    L6:
        if (((BarLineChartBase) this.mChart).isDoubleTapToZoomEnabled() == false) goto L22;
        if (((BarLineScatterCandleBubbleData) ((BarLineChartBase) this.mChart).getData()).getEntryCount() <= 0) goto L22;
        MPPointF r1 = getTrans(r7.getX(), r7.getY());
        BarLineChartBase r2 = (BarLineChartBase) this.mChart;
        float r3 = 1.4f;
        if (((BarLineChartBase) this.mChart).isScaleXEnabled() == false) goto L12;
        float r4 = 1.4f;
    L14:
        if (((BarLineChartBase) this.mChart).isScaleYEnabled() == true) goto L17;
        r3 = 1.0f;
    L17:
        r2.zoom(r4, r3, r1.x, r1.y);
        if (((BarLineChartBase) this.mChart).isLogEnabled() == false) goto L20;
        Log.i("BarlineChartTouch", "Double-Tap, Zooming In, x: " + r1.x + ", y: " + r1.y);
    L20:
        MPPointF.recycleInstance(r1);
        goto L22
    L12:
        r4 = 1.0f;
    L22:
        return super.onDoubleTap(r7);
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent r2) {
        this.mLastGesture = ChartTouchListener.ChartGesture.LONG_PRESS;
        OnChartGestureListener r1 = ((BarLineChartBase) this.mChart).getOnChartGestureListener();
        if (r1 == null) goto L6;
        r1.onChartLongPressed(r2);
        return;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent r4) {
        this.mLastGesture = ChartTouchListener.ChartGesture.SINGLE_TAP;
        OnChartGestureListener r0 = ((BarLineChartBase) this.mChart).getOnChartGestureListener();
        if (r0 == null) goto L6;
        r0.onChartSingleTapped(r4);
    L6:
        if (((BarLineChartBase) this.mChart).isHighlightPerTapEnabled() == true) goto L9;
        return false;
    L9:
        performHighlight(((BarLineChartBase) this.mChart).getHighlightByTouchPoint(r4.getX(), r4.getY()), r4);
        return super.onSingleTapUp(r4);
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onFling(MotionEvent r2, MotionEvent r3, float r4, float r5) {
        this.mLastGesture = ChartTouchListener.ChartGesture.FLING;
        OnChartGestureListener r0 = ((BarLineChartBase) this.mChart).getOnChartGestureListener();
        if (r0 == null) goto L6;
        r0.onChartFling(r2, r3, r4, r5);
    L6:
        return super.onFling(r2, r3, r4, r5);
    }

    public void stopDeceleration() {
        this.mDecelerationVelocity.x = 0.0f;
        this.mDecelerationVelocity.y = 0.0f;
    }

    public void computeScroll() {
        float r1 = 0.0f;
        if (this.mDecelerationVelocity.x == 0.0f) goto L5;
    L7:
        long r10 = AnimationUtils.currentAnimationTimeMillis();
        this.mDecelerationVelocity.x *= ((BarLineChartBase) this.mChart).getDragDecelerationFrictionCoef();
        this.mDecelerationVelocity.y *= ((BarLineChartBase) this.mChart).getDragDecelerationFrictionCoef();
        float r0 = (r10 - this.mDecelerationLastTime) / 1000.0f;
        float r2 = this.mDecelerationVelocity.x * r0;
        float r3 = this.mDecelerationVelocity.y * r0;
        this.mDecelerationCurrentPoint.x += r2;
        this.mDecelerationCurrentPoint.y += r3;
        MotionEvent r4 = MotionEvent.obtain(r10, r10, 2, this.mDecelerationCurrentPoint.x, this.mDecelerationCurrentPoint.y, 0);
        if (((BarLineChartBase) this.mChart).isDragXEnabled() == false) goto L10;
        float r5 = this.mDecelerationCurrentPoint.x - this.mTouchStartPoint.x;
    L12:
        if (((BarLineChartBase) this.mChart).isDragYEnabled() == false) goto L14;
        r1 = this.mDecelerationCurrentPoint.y - this.mTouchStartPoint.y;
    L14:
        performDrag(r4, r5, r1);
        r4.recycle();
        this.mMatrix = ((BarLineChartBase) this.mChart).getViewPortHandler().refresh(this.mMatrix, this.mChart, false);
        this.mDecelerationLastTime = r10;
        if (Math.abs(this.mDecelerationVelocity.x) < 0.01d) goto L17;
    L20:
        Utils.postInvalidateOnAnimation(this.mChart);
        return;
    L17:
        if (Math.abs(this.mDecelerationVelocity.y) >= 0.01d) goto L20;
        ((BarLineChartBase) this.mChart).calculateOffsets();
        ((BarLineChartBase) this.mChart).postInvalidate();
        stopDeceleration();
        return;
    L10:
        r5 = 0.0f;
        goto L12
    L5:
        if (this.mDecelerationVelocity.y != 0.0f) goto L7;
    }
}
