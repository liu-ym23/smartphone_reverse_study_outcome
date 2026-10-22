package com.github.mikephil.charting.jobs;

import android.graphics.Matrix;
import android.view.View;
import com.github.mikephil.charting.charts.BarLineChartBase;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.utils.ObjectPool;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.ViewPortHandler;

/* JADX INFO: loaded from: classes2.dex */
public class ZoomJob extends ViewPortJob {
    private static ObjectPool<ZoomJob> pool;
    protected YAxis.AxisDependency axisDependency;
    protected Matrix mRunMatrixBuffer;
    protected float scaleX;
    protected float scaleY;

    static {
        ObjectPool<ZoomJob> r0 = ObjectPool.create(1, new ZoomJob(null, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null));
        pool = r0;
        r0.setReplenishPercentage(0.5f);
    }

    public static ZoomJob getInstance(ViewPortHandler r1, float r2, float r3, float r4, float r5, Transformer r6, YAxis.AxisDependency r7, View r8) {
        ZoomJob r0 = (ZoomJob) pool.get();
        r0.xValue = r4;
        r0.yValue = r5;
        r0.scaleX = r2;
        r0.scaleY = r3;
        r0.mViewPortHandler = r1;
        r0.mTrans = r6;
        r0.axisDependency = r7;
        r0.view = r8;
        return r0;
    }

    public static void recycleInstance(ZoomJob r1) {
        pool.recycle(r1);
    }

    public ZoomJob(ViewPortHandler r7, float r8, float r9, float r10, float r11, Transformer r12, YAxis.AxisDependency r13, View r14) {
        super(r7, r10, r11, r12, r14);
        this.mRunMatrixBuffer = new Matrix();
        this.scaleX = r8;
        this.scaleY = r9;
        this.axisDependency = r13;
    }

    @Override // java.lang.Runnable
    public void run() {
        Matrix r0 = this.mRunMatrixBuffer;
        this.mViewPortHandler.zoom(this.scaleX, this.scaleY, r0);
        this.mViewPortHandler.refresh(r0, this.view, false);
        float r1 = ((BarLineChartBase) this.view).getAxis(this.axisDependency).mAxisRange / this.mViewPortHandler.getScaleY();
        float r2 = ((BarLineChartBase) this.view).getXAxis().mAxisRange / this.mViewPortHandler.getScaleX();
        this.pts[0] = this.xValue - (r2 / 2.0f);
        this.pts[1] = this.yValue + (r1 / 2.0f);
        this.mTrans.pointValuesToPixel(this.pts);
        this.mViewPortHandler.translate(this.pts, r0);
        this.mViewPortHandler.refresh(r0, this.view, false);
        ((BarLineChartBase) this.view).calculateOffsets();
        this.view.postInvalidate();
        recycleInstance(this);
    }

    @Override // com.github.mikephil.charting.utils.ObjectPool.Poolable
    protected ObjectPool.Poolable instantiate() {
        return new ZoomJob(null, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null);
    }
}
