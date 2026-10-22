package com.github.mikephil.charting.jobs;

import android.view.View;
import com.github.mikephil.charting.utils.ObjectPool;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.ViewPortHandler;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ViewPortJob extends ObjectPool.Poolable implements Runnable {
    protected Transformer mTrans;
    protected ViewPortHandler mViewPortHandler;
    protected float[] pts;
    protected View view;
    protected float xValue;
    protected float yValue;

    public ViewPortJob(ViewPortHandler r2, float r3, float r4, Transformer r5, View r6) {
        this.pts = new float[2];
        this.mViewPortHandler = r2;
        this.xValue = r3;
        this.yValue = r4;
        this.mTrans = r5;
        this.view = r6;
    }

    public float getXValue() {
        return this.xValue;
    }

    public float getYValue() {
        return this.yValue;
    }
}
