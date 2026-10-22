package org.apache.commons.math3.ml.distance;

import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.MathArrays;

/* JADX INFO: loaded from: classes6.dex */
public class CanberraDistance implements DistanceMeasure {
    private static final long serialVersionUID = -6972277381587032228L;

    public CanberraDistance() {
    }

    @Override // org.apache.commons.math3.ml.distance.DistanceMeasure
    public double compute(double[] r11, double[] r12) throws DimensionMismatchException {
        MathArrays.checkEqualLength(r11, r12);
        int r10 = 0;
        double r2 = 0.0d;
    L4:
        if (r10 >= r11.length) goto L12;
        double r4 = FastMath.abs(r11[r10] - r12[r10]);
        double r6 = FastMath.abs(r11[r10]) + FastMath.abs(r12[r10]);
        if (r4 == 0.0d) goto L8;
    L10:
        double r5 = r4 / r6;
    L11:
        r2 = r2 + r5;
        r10 = r10 + 1;
        goto L4
    L8:
        if (r6 != 0.0d) goto L10;
        r5 = 0.0d;
        goto L11
    L12:
        return r2;
    }
}
