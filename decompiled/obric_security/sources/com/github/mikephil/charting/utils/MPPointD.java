package com.github.mikephil.charting.utils;

import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class MPPointD extends ObjectPool.Poolable {
    private static ObjectPool<MPPointD> pool;
    public double x;
    public double y;

    static {
        ObjectPool<MPPointD> r0 = ObjectPool.create(64, new MPPointD(0.0d, 0.0d));
        pool = r0;
        r0.setReplenishPercentage(0.5f);
    }

    public static MPPointD getInstance(double r1, double r3) {
        MPPointD r0 = (MPPointD) pool.get();
        r0.x = r1;
        r0.y = r3;
        return r0;
    }

    public static void recycleInstance(MPPointD r1) {
        pool.recycle(r1);
    }

    public static void recycleInstances(List<MPPointD> r1) {
        pool.recycle(r1);
    }

    @Override // com.github.mikephil.charting.utils.ObjectPool.Poolable
    protected ObjectPool.Poolable instantiate() {
        return new MPPointD(0.0d, 0.0d);
    }

    private MPPointD(double r1, double r3) {
        this.x = r1;
        this.y = r3;
    }

    public String toString() {
        return "MPPointD, x: " + this.x + ", y: " + this.y;
    }
}
