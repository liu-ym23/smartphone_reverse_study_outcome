package org.apache.commons.math3.ml.clustering;

import java.io.Serializable;
import java.util.Arrays;

/* JADX INFO: loaded from: classes6.dex */
public class DoublePoint implements Clusterable, Serializable {
    private static final long serialVersionUID = 3946024775784901369L;
    private final double[] point;

    public DoublePoint(double[] r1) {
        this.point = r1;
    }

    public DoublePoint(int[] r5) {
        this.point = new double[r5.length];
        int r0 = 0;
    L4:
        if (r0 >= r5.length) goto L6;
        this.point[r0] = r5[r0];
        r0 = r0 + 1;
        goto L4
    }

    @Override // org.apache.commons.math3.ml.clustering.Clusterable
    public double[] getPoint() {
        return this.point;
    }

    public boolean equals(Object r2) {
        if ((r2 instanceof DoublePoint) == true) goto L7;
        return false;
    L7:
        return Arrays.equals(this.point, ((DoublePoint) r2).point);
    }

    public int hashCode() {
        return Arrays.hashCode(this.point);
    }

    public String toString() {
        return Arrays.toString(this.point);
    }
}
