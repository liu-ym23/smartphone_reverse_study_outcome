package com.github.mikephil.charting.utils;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class MPPointF extends ObjectPool.Poolable {
    public static final Parcelable.Creator<MPPointF> CREATOR = null;
    private static ObjectPool<MPPointF> pool;
    public float x;
    public float y;

    static {
        ObjectPool<MPPointF> r0 = ObjectPool.create(32, new MPPointF(0.0f, 0.0f));
        pool = r0;
        r0.setReplenishPercentage(0.5f);
        CREATOR = new AnonymousClass1();
    }

    public MPPointF() {
    }

    public MPPointF(float r1, float r2) {
        this.x = r1;
        this.y = r2;
    }

    public static MPPointF getInstance(float r1, float r2) {
        MPPointF r0 = (MPPointF) pool.get();
        r0.x = r1;
        r0.y = r2;
        return r0;
    }

    public static MPPointF getInstance() {
        return (MPPointF) pool.get();
    }

    public static MPPointF getInstance(MPPointF r2) {
        MPPointF r0 = (MPPointF) pool.get();
        r0.x = r2.x;
        r0.y = r2.y;
        return r0;
    }

    public static void recycleInstance(MPPointF r1) {
        pool.recycle(r1);
    }

    public static void recycleInstances(List<MPPointF> r1) {
        pool.recycle(r1);
    }

    public void my_readFromParcel(Parcel r2) {
        this.x = r2.readFloat();
        this.y = r2.readFloat();
    }

    public float getX() {
        return this.x;
    }

    public float getY() {
        return this.y;
    }

    @Override // com.github.mikephil.charting.utils.ObjectPool.Poolable
    protected ObjectPool.Poolable instantiate() {
        return new MPPointF(0.0f, 0.0f);
    }
}
