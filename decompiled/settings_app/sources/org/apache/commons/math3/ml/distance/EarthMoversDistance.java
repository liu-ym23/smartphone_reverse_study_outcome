package org.apache.commons.math3.ml.distance;

import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.MathArrays;

/* JADX INFO: loaded from: classes6.dex */
public class EarthMoversDistance implements DistanceMeasure {
    private static final long serialVersionUID = -5406732779747414922L;

    public EarthMoversDistance() {
    }

    @Override // org.apache.commons.math3.ml.distance.DistanceMeasure
    public double compute(double[] r7, double[] r8) throws DimensionMismatchException {
        MathArrays.checkEqualLength(r7, r8);
        double r0 = 0.0d;
        int r6 = 0;
        double r2 = 0.0d;
    L4:
        if (r6 >= r7.length) goto L6;
        r2 = (r7[r6] + r2) - r8[r6];
        r0 = r0 + FastMath.abs(r2);
        r6 = r6 + 1;
        goto L4
    L6:
        return r0;
    }
}
