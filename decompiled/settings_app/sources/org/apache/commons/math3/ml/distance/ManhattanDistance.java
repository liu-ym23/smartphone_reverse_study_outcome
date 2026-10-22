package org.apache.commons.math3.ml.distance;

import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.util.MathArrays;

/* JADX INFO: loaded from: classes6.dex */
public class ManhattanDistance implements DistanceMeasure {
    private static final long serialVersionUID = -9108154600539125566L;

    public ManhattanDistance() {
    }

    @Override // org.apache.commons.math3.ml.distance.DistanceMeasure
    public double compute(double[] r1, double[] r2) throws DimensionMismatchException {
        return MathArrays.distance1(r1, r2);
    }
}
