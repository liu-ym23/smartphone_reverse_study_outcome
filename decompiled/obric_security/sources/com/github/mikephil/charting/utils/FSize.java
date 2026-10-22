package com.github.mikephil.charting.utils;

import com.obric.oui.material.MaterialConfigFormatNames;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class FSize extends ObjectPool.Poolable {
    private static ObjectPool<FSize> pool;
    public float height;
    public float width;

    static {
        ObjectPool<FSize> r0 = ObjectPool.create(256, new FSize(0.0f, 0.0f));
        pool = r0;
        r0.setReplenishPercentage(0.5f);
    }

    @Override // com.github.mikephil.charting.utils.ObjectPool.Poolable
    protected ObjectPool.Poolable instantiate() {
        return new FSize(0.0f, 0.0f);
    }

    public static FSize getInstance(float r1, float r2) {
        FSize r0 = (FSize) pool.get();
        r0.width = r1;
        r0.height = r2;
        return r0;
    }

    public static void recycleInstance(FSize r1) {
        pool.recycle(r1);
    }

    public static void recycleInstances(List<FSize> r1) {
        pool.recycle(r1);
    }

    public FSize() {
    }

    public FSize(float r1, float r2) {
        this.width = r1;
        this.height = r2;
    }

    public boolean equals(Object r5) {
        if (r5 != null) goto L6;
        return false;
    L6:
        if (this != r5) goto L9;
        return true;
    L9:
        if ((r5 instanceof FSize) == false) goto L16;
        FSize r6 = (FSize) r5;
        if (this.width == r6.width) goto L13;
        return false;
    L13:
        if (this.height == r6.height) goto L15;
        return false;
    L15:
        return true;
    L16:
        return false;
    }

    public String toString() {
        return this.width + MaterialConfigFormatNames.X + this.height;
    }

    public int hashCode() {
        int r0 = Float.floatToIntBits(this.width);
        return Float.floatToIntBits(this.height) ^ r0;
    }
}
