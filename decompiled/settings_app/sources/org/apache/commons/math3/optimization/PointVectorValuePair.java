package org.apache.commons.math3.optimization;

import java.io.Serializable;
import org.apache.commons.math3.util.Pair;

/* JADX INFO: loaded from: classes6.dex */
@Deprecated
public class PointVectorValuePair extends Pair<double[], double[]> implements Serializable {
    private static final long serialVersionUID = 20120513;

    private static class DataTransferObject implements Serializable {
        private static final long serialVersionUID = 20120513;
        private final double[] point;
        private final double[] value;

        DataTransferObject(double[] r1, double[] r2) {
            this.point = (double[]) r1.clone();
            this.value = (double[]) r2.clone();
        }

        private Object readResolve() {
            return new PointVectorValuePair(this.point, this.value, false);
        }
    }

    @Override // org.apache.commons.math3.util.Pair
    public /* bridge */ /* synthetic */ double[] getValue() {
        return getValue2();
    }

    public PointVectorValuePair(double[] r2, double[] r3) {
        this(r2, r3, true);
    }

    public PointVectorValuePair(double[] r2, double[] r3, boolean r4) {
        if (r4 == false) goto L7;
        if (r2 != null) goto L6;
        r2 = null;
        goto L7
    L6:
        r2 = (double[]) r2.clone();
    L7:
        if (r4 == false) goto L11;
        if (r3 != null) goto L10;
        r3 = null;
        goto L11
    L10:
        r3 = (double[]) r3.clone();
    L11:
        super(r2, r3);
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

    @Override // org.apache.commons.math3.util.Pair
    /* JADX INFO: renamed from: getValue, reason: avoid collision after fix types in other method */
    public double[] getValue2() {
        double[] r0 = (double[]) super.getValue();
        if (r0 != null) goto L6;
        return null;
    L6:
        return (double[]) r0.clone();
    }

    public double[] getValueRef() {
        return (double[]) super.getValue();
    }

    private Object writeReplace() {
        return new DataTransferObject(getKey(), getValue2());
    }
}
