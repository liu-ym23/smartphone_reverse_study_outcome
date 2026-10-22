package org.apache.commons.math3.optimization;

import java.io.Serializable;
import org.apache.commons.math3.util.Pair;

/* JADX INFO: loaded from: classes6.dex */
@Deprecated
public class PointValuePair extends Pair<double[], Double> implements Serializable {
    private static final long serialVersionUID = 20120513;

    private static class DataTransferObject implements Serializable {
        private static final long serialVersionUID = 20120513;
        private final double[] point;
        private final double value;

        DataTransferObject(double[] r1, double r2) {
            this.point = (double[]) r1.clone();
            this.value = r2;
        }

        private Object readResolve() {
            return new PointValuePair(this.point, this.value, false);
        }
    }

    public PointValuePair(double[] r2, double r3) {
        this(r2, r3, true);
    }

    public PointValuePair(double[] r1, double r2, boolean r4) {
        if (r4 == false) goto L6;
        if (r1 != null) goto L5;
        r1 = null;
        goto L6
    L5:
        r1 = (double[]) r1.clone();
    L6:
        super(r1, Double.valueOf(r2));
    }

    public double[] getPoint() {
        double[] r0 = getKey();
        if (r0 != null) goto L6;
        return null;
    L6:
        return (double[]) r0.clone();
    }

    public double[] getPointRef() {
        return getKey();
    }

    private Object writeReplace() {
        return new DataTransferObject(getKey(), getValue().doubleValue());
    }
}
