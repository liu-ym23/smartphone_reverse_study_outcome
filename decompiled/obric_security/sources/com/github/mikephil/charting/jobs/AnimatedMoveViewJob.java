package com.github.mikephil.charting.jobs;

import android.animation.ValueAnimator;
import android.view.View;
import com.github.mikephil.charting.utils.ObjectPool;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.ViewPortHandler;

/* JADX INFO: loaded from: classes2.dex */
public class AnimatedMoveViewJob extends AnimatedViewPortJob {
    private static ObjectPool<AnimatedMoveViewJob> pool;

    static {
        ObjectPool<AnimatedMoveViewJob> r0 = ObjectPool.create(4, new AnimatedMoveViewJob(null, 0.0f, 0.0f, null, null, 0.0f, 0.0f, 0));
        pool = r0;
        r0.setReplenishPercentage(0.5f);
    }

    public static AnimatedMoveViewJob getInstance(ViewPortHandler r1, float r2, float r3, Transformer r4, View r5, float r6, float r7, long r8) {
        AnimatedMoveViewJob r0 = (AnimatedMoveViewJob) pool.get();
        r0.mViewPortHandler = r1;
        r0.xValue = r2;
        r0.yValue = r3;
        r0.mTrans = r4;
        r0.view = r5;
        r0.xOrigin = r6;
        r0.yOrigin = r7;
        r0.animator.setDuration(r8);
        return r0;
    }

    public static void recycleInstance(AnimatedMoveViewJob r1) {
        pool.recycle(r1);
    }

    public AnimatedMoveViewJob(ViewPortHandler r1, float r2, float r3, Transformer r4, View r5, float r6, float r7, long r8) {
        super(r1, r2, r3, r4, r5, r6, r7, r8);
    }

    @Override // com.github.mikephil.charting.jobs.AnimatedViewPortJob, android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator r4) {
        this.pts[0] = this.xOrigin + ((this.xValue - this.xOrigin) * this.phase);
        this.pts[1] = this.yOrigin + ((this.yValue - this.yOrigin) * this.phase);
        this.mTrans.pointValuesToPixel(this.pts);
        this.mViewPortHandler.centerViewPort(this.pts, this.view);
    }

    @Override // com.github.mikephil.charting.jobs.AnimatedViewPortJob
    public void recycleSelf() {
        recycleInstance(this);
    }

    @Override // com.github.mikephil.charting.utils.ObjectPool.Poolable
    protected ObjectPool.Poolable instantiate() {
        return new AnimatedMoveViewJob(null, 0.0f, 0.0f, null, null, 0.0f, 0.0f, 0);
    }
}
