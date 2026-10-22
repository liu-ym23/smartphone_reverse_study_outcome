package com.github.mikephil.charting.jobs;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.graphics.Matrix;
import android.view.View;
import com.github.mikephil.charting.charts.BarLineChartBase;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.utils.ObjectPool;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.ViewPortHandler;

/* JADX INFO: loaded from: classes2.dex */
public class AnimatedZoomJob extends AnimatedViewPortJob implements Animator.AnimatorListener {
    private static ObjectPool<AnimatedZoomJob> pool;
    protected Matrix mOnAnimationUpdateMatrixBuffer;
    protected float xAxisRange;
    protected YAxis yAxis;
    protected float zoomCenterX;
    protected float zoomCenterY;
    protected float zoomOriginX;
    protected float zoomOriginY;

    @Override // com.github.mikephil.charting.jobs.AnimatedViewPortJob, android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator r1) {
    }

    @Override // com.github.mikephil.charting.jobs.AnimatedViewPortJob, android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator r1) {
    }

    @Override // com.github.mikephil.charting.jobs.AnimatedViewPortJob, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator r1) {
    }

    @Override // com.github.mikephil.charting.jobs.AnimatedViewPortJob
    public void recycleSelf() {
    }

    static {
        pool = ObjectPool.create(8, new AnimatedZoomJob(null, null, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0));
    }

    public static AnimatedZoomJob getInstance(ViewPortHandler r0, View r1, Transformer r2, YAxis r3, float r4, float r5, float r6, float r7, float r8, float r9, float r10, float r11, float r12, long r13) {
        AnimatedZoomJob r14 = (AnimatedZoomJob) pool.get();
        r14.mViewPortHandler = r0;
        r14.xValue = r5;
        r14.yValue = r6;
        r14.mTrans = r2;
        r14.view = r1;
        r14.xOrigin = r7;
        r14.yOrigin = r8;
        r14.yAxis = r3;
        r14.xAxisRange = r4;
        r14.resetAnimator();
        r14.animator.setDuration(r13);
        return r14;
    }

    public AnimatedZoomJob(ViewPortHandler r12, View r13, Transformer r14, YAxis r15, float r16, float r17, float r18, float r19, float r20, float r21, float r22, float r23, float r24, long r25) {
        super(r12, r17, r18, r14, r13, r19, r20, r25);
        this.mOnAnimationUpdateMatrixBuffer = new Matrix();
        this.zoomCenterX = r21;
        this.zoomCenterY = r22;
        this.zoomOriginX = r23;
        this.zoomOriginY = r24;
        this.animator.addListener(this);
        this.yAxis = r15;
        this.xAxisRange = r16;
    }

    @Override // com.github.mikephil.charting.jobs.AnimatedViewPortJob, android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator r8) {
        float r9 = this.xOrigin + ((this.xValue - this.xOrigin) * this.phase);
        float r0 = this.yOrigin + ((this.yValue - this.yOrigin) * this.phase);
        Matrix r1 = this.mOnAnimationUpdateMatrixBuffer;
        this.mViewPortHandler.setZoom(r9, r0, r1);
        this.mViewPortHandler.refresh(r1, this.view, false);
        float r10 = this.yAxis.mAxisRange / this.mViewPortHandler.getScaleY();
        float r2 = this.xAxisRange / this.mViewPortHandler.getScaleX();
        float[] r3 = this.pts;
        float r4 = this.zoomOriginX;
        r3[0] = r4 + (((this.zoomCenterX - (r2 / 2.0f)) - r4) * this.phase);
        float[] r5 = this.pts;
        float r6 = this.zoomOriginY;
        r5[1] = r6 + (((this.zoomCenterY + (r10 / 2.0f)) - r6) * this.phase);
        this.mTrans.pointValuesToPixel(this.pts);
        this.mViewPortHandler.translate(this.pts, r1);
        this.mViewPortHandler.refresh(r1, this.view, true);
    }

    @Override // com.github.mikephil.charting.jobs.AnimatedViewPortJob, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator r1) {
        ((BarLineChartBase) this.view).calculateOffsets();
        this.view.postInvalidate();
    }

    @Override // com.github.mikephil.charting.utils.ObjectPool.Poolable
    protected ObjectPool.Poolable instantiate() {
        return new AnimatedZoomJob(null, null, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0);
    }
}
