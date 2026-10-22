package com.github.mikephil.charting.listener;

import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AnimationUtils;
import com.github.mikephil.charting.charts.PieRadarChartBase;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Utils;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class PieRadarChartTouchListener extends ChartTouchListener<PieRadarChartBase<?>> {
    private ArrayList<AngularVelocitySample> _velocitySamples;
    private float mDecelerationAngularVelocity;
    private long mDecelerationLastTime;
    private float mStartAngle;
    private MPPointF mTouchStartPoint;

    private class AngularVelocitySample {
        public float angle;
        final /* synthetic */ PieRadarChartTouchListener this$0;
        public long time;

        public AngularVelocitySample(PieRadarChartTouchListener r1, long r2, float r4) {
            this.this$0 = r1;
            this.time = r2;
            this.angle = r4;
        }
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
    public boolean onSingleTapConfirmed(MotionEvent r1) {
        return true;
    }

    public PieRadarChartTouchListener(PieRadarChartBase<?> r3) {
        super(r3);
        this.mTouchStartPoint = MPPointF.getInstance(0.0f, 0.0f);
        this.mStartAngle = 0.0f;
        this._velocitySamples = new ArrayList();
        this.mDecelerationLastTime = 0;
        this.mDecelerationAngularVelocity = 0.0f;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View r6, MotionEvent r7) {
        if (this.mGestureDetector.onTouchEvent(r7) == false) goto L6;
        return true;
    L6:
        if (((PieRadarChartBase) this.mChart).isRotationEnabled() == false) goto L35;
        float r8 = r7.getX();
        float r1 = r7.getY();
        int r2 = r7.getAction();
        if (r2 == 0) goto L31;
        if (r2 == 1) goto L26;
        if (r2 != 2) goto L35;
        if (((PieRadarChartBase) this.mChart).isDragDecelerationEnabled() == false) goto L17;
        sampleVelocity(r8, r1);
    L17:
        if (this.mTouchMode != 0) goto L22;
        if (distance(r8, this.mTouchStartPoint.x, r1, this.mTouchStartPoint.y) <= Utils.convertDpToPixel(8.0f)) goto L22;
        this.mLastGesture = ChartTouchListener.ChartGesture.ROTATE;
        this.mTouchMode = 6;
        ((PieRadarChartBase) this.mChart).disableScroll();
    L24:
        endAction(r7);
    L22:
        if (this.mTouchMode != 6) goto L24;
        updateGestureRotation(r8, r1);
        ((PieRadarChartBase) this.mChart).invalidate();
        goto L24
    L26:
        if (((PieRadarChartBase) this.mChart).isDragDecelerationEnabled() == false) goto L30;
        stopDeceleration();
        sampleVelocity(r8, r1);
        float r9 = calculateVelocity();
        this.mDecelerationAngularVelocity = r9;
        if (r9 == 0.0f) goto L30;
        this.mDecelerationLastTime = AnimationUtils.currentAnimationTimeMillis();
        Utils.postInvalidateOnAnimation(this.mChart);
    L30:
        ((PieRadarChartBase) this.mChart).enableScroll();
        this.mTouchMode = 0;
        endAction(r7);
        goto L35
    L31:
        startAction(r7);
        stopDeceleration();
        resetVelocity();
        if (((PieRadarChartBase) this.mChart).isDragDecelerationEnabled() == false) goto L34;
        sampleVelocity(r8, r1);
    L34:
        setGestureStartAngle(r8, r1);
        this.mTouchStartPoint.x = r8;
        this.mTouchStartPoint.y = r1;
    L35:
        return true;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent r2) {
        this.mLastGesture = ChartTouchListener.ChartGesture.LONG_PRESS;
        OnChartGestureListener r1 = ((PieRadarChartBase) this.mChart).getOnChartGestureListener();
        if (r1 == null) goto L6;
        r1.onChartLongPressed(r2);
        return;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent r4) {
        this.mLastGesture = ChartTouchListener.ChartGesture.SINGLE_TAP;
        OnChartGestureListener r0 = ((PieRadarChartBase) this.mChart).getOnChartGestureListener();
        if (r0 == null) goto L6;
        r0.onChartSingleTapped(r4);
    L6:
        if (((PieRadarChartBase) this.mChart).isHighlightPerTapEnabled() == true) goto L9;
        return false;
    L9:
        performHighlight(((PieRadarChartBase) this.mChart).getHighlightByTouchPoint(r4.getX(), r4.getY()), r4);
        return true;
    }

    private void resetVelocity() {
        this._velocitySamples.clear();
    }

    private void sampleVelocity(float r8, float r9) {
        long r0 = AnimationUtils.currentAnimationTimeMillis();
        this._velocitySamples.add(new AngularVelocitySample(this, r0, ((PieRadarChartBase) this.mChart).getAngleForPoint(r8, r9)));
        int r10 = this._velocitySamples.size();
    L4:
        if ((r10 - 2) <= 0) goto L8;
        if ((r0 - this._velocitySamples.get(0).time) <= 1000) goto L11;
        this._velocitySamples.remove(0);
        r10 = r10 - 1;
        goto L4
    L11:
        return;
    }

    private float calculateVelocity() {
        if (this._velocitySamples.isEmpty() == false) goto L5;
        return 0.0f;
    L5:
        boolean r2 = false;
        AngularVelocitySample r0 = this._velocitySamples.get(0);
        ArrayList<AngularVelocitySample> r3 = this._velocitySamples;
        AngularVelocitySample r4 = r3.get(r3.size() - 1);
        int r5 = this._velocitySamples.size() - 1;
        AngularVelocitySample r6 = r0;
    L6:
        if (r5 < 0) goto L11;
        r6 = this._velocitySamples.get(r5);
        if (r6.angle != r4.angle) goto L11;
        r5 = r5 - 1;
    L11:
        float r11 = (r4.time - r0.time) / 1000.0f;
        if (r11 != 0.0f) goto L15;
        r11 = 0.1f;
    L15:
        if (r4.angle < r6.angle) goto L18;
        r2 = true;
    L18:
        if (Math.abs(r4.angle - r6.angle) <= 270.0d) goto L21;
        r2 = !r2;
    L21:
        if ((r4.angle - r0.angle) <= 180.0d) goto L24;
        r0.angle = (float) (((double) r0.angle) + 360.0d);
    L26:
        float r12 = Math.abs((r4.angle - r0.angle) / r11);
        if (r2 == false) goto L29;
        return r12;
    L29:
        return -r12;
    L24:
        if ((r0.angle - r4.angle) <= 180.0d) goto L26;
        r4.angle = (float) (((double) r4.angle) + 360.0d);
        goto L26
    }

    public void setGestureStartAngle(float r2, float r3) {
        this.mStartAngle = ((PieRadarChartBase) this.mChart).getAngleForPoint(r2, r3) - ((PieRadarChartBase) this.mChart).getRawRotationAngle();
    }

    public void updateGestureRotation(float r3, float r4) {
        ((PieRadarChartBase) this.mChart).setRotationAngle(((PieRadarChartBase) this.mChart).getAngleForPoint(r3, r4) - this.mStartAngle);
    }

    public void stopDeceleration() {
        this.mDecelerationAngularVelocity = 0.0f;
    }

    public void computeScroll() {
        if (this.mDecelerationAngularVelocity != 0.0f) goto L5;
        return;
    L5:
        long r0 = AnimationUtils.currentAnimationTimeMillis();
        this.mDecelerationAngularVelocity *= ((PieRadarChartBase) this.mChart).getDragDecelerationFrictionCoef();
        ((PieRadarChartBase) this.mChart).setRotationAngle(((PieRadarChartBase) this.mChart).getRotationAngle() + (this.mDecelerationAngularVelocity * ((r0 - this.mDecelerationLastTime) / 1000.0f)));
        this.mDecelerationLastTime = r0;
        if (Math.abs(this.mDecelerationAngularVelocity) < 0.001d) goto L8;
        Utils.postInvalidateOnAnimation(this.mChart);
        return;
    L8:
        stopDeceleration();
    }
}
