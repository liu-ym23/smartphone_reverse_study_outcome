package com.github.mikephil.charting.jobs;

import android.view.View;
import com.github.mikephil.charting.utils.ObjectPool;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.ViewPortHandler;

/* JADX INFO: loaded from: classes2.dex */
public class MoveViewJob extends ViewPortJob {
    private static ObjectPool<MoveViewJob> pool;

    static {
        ObjectPool<MoveViewJob> r0 = ObjectPool.create(2, new MoveViewJob(null, 0.0f, 0.0f, null, null));
        pool = r0;
        r0.setReplenishPercentage(0.5f);
    }

    public static MoveViewJob getInstance(ViewPortHandler r1, float r2, float r3, Transformer r4, View r5) {
        MoveViewJob r0 = (MoveViewJob) pool.get();
        r0.mViewPortHandler = r1;
        r0.xValue = r2;
        r0.yValue = r3;
        r0.mTrans = r4;
        r0.view = r5;
        return r0;
    }

    public static void recycleInstance(MoveViewJob r1) {
        pool.recycle(r1);
    }

    public MoveViewJob(ViewPortHandler r1, float r2, float r3, Transformer r4, View r5) {
        super(r1, r2, r3, r4, r5);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.pts[0] = this.xValue;
        this.pts[1] = this.yValue;
        this.mTrans.pointValuesToPixel(this.pts);
        this.mViewPortHandler.centerViewPort(this.pts, this.view);
        recycleInstance(this);
    }

    @Override // com.github.mikephil.charting.utils.ObjectPool.Poolable
    protected ObjectPool.Poolable instantiate() {
        return new MoveViewJob(this.mViewPortHandler, this.xValue, this.yValue, this.mTrans, this.view);
    }
}
