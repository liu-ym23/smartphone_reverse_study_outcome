package org.apache.commons.math3.optimization.direct;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import org.apache.commons.math3.analysis.MultivariateFunction;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.apache.commons.math3.exception.NotStrictlyPositiveException;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.exception.OutOfRangeException;
import org.apache.commons.math3.exception.ZeroException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.optimization.OptimizationData;
import org.apache.commons.math3.optimization.PointValuePair;

/* JADX INFO: loaded from: classes6.dex */
@Deprecated
public abstract class AbstractSimplex implements OptimizationData {
    private final int dimension;
    private PointValuePair[] simplex;
    private double[][] startConfiguration;

    public abstract void iterate(MultivariateFunction r1, Comparator<PointValuePair> r2);

    protected AbstractSimplex(int r3) {
        this(r3, 1.0d);
    }

    protected AbstractSimplex(int r1, double r2) {
        this(createHypercubeSteps(r1, r2));
    }

    protected AbstractSimplex(double[] r9) {
        if (r9 == null) goto L22;
        if (r9.length == 0) goto L20;
        int r0 = r9.length;
        this.dimension = r0;
        this.startConfiguration = (double[][]) Array.newInstance(Double.TYPE, new int[]{r0, r0});
        int r1 = 0;
    L8:
        if (r1 >= this.dimension) goto L18;
        double[] r2 = this.startConfiguration[r1];
        int r3 = 0;
    L10:
        int r4 = r1 + 1;
        if (r3 >= r4) goto L17;
        if (r9[r3] == 0.0d) goto L16;
        r3 = r3 + 1;
        System.arraycopy(r9, 0, r2, 0, r3);
        goto L10
    L16:
        throw new ZeroException(LocalizedFormats.EQUAL_VERTICES_IN_SIMPLEX, new Object[0]);
    L17:
        r1 = r4;
        goto L8
    L18:
        return;
    L20:
        throw new ZeroException();
    L22:
        throw new NullArgumentException();
    }

    protected AbstractSimplex(double[][] r14) {
        if (r14.length <= 0) goto L33;
        int r0 = r14.length - 1;
        this.dimension = r0;
        this.startConfiguration = (double[][]) Array.newInstance(Double.TYPE, new int[]{r0, r0});
        double[] r1 = r14[0];
        int r3 = 0;
    L6:
        if (r3 >= r14.length) goto L31;
        double[] r5 = r14[r3];
        if (r5.length != this.dimension) goto L30;
        int r6 = 0;
    L10:
        if (r6 >= r3) goto L23;
        double[] r7 = r14[r6];
        int r8 = 0;
    L13:
        if (r8 >= this.dimension) goto L18;
        if (r5[r8] != r7[r8]) goto L16;
        r8 = r8 + 1;
        goto L13
    L16:
        boolean r9 = false;
    L19:
        if (r9 == true) goto L22;
        r6 = r6 + 1;
        goto L10
    L22:
        throw new MathIllegalArgumentException(LocalizedFormats.EQUAL_VERTICES_IN_SIMPLEX, new Object[]{Integer.valueOf(r3), Integer.valueOf(r6)});
    L18:
        r9 = true;
        goto L19
    L23:
        if (r3 <= 0) goto L28;
        double[] r10 = this.startConfiguration[r3 - 1];
        int r11 = 0;
    L26:
        if (r11 >= this.dimension) goto L28;
        r10[r11] = r5[r11] - r1[r11];
        r11 = r11 + 1;
    L28:
        r3 = r3 + 1;
        goto L6
    L30:
        throw new DimensionMismatchException(r5.length, this.dimension);
    L31:
        return;
    L33:
        throw new NotStrictlyPositiveException(LocalizedFormats.SIMPLEX_NEED_ONE_POINT, Integer.valueOf(r14.length));
    }

    public int getDimension() {
        return this.dimension;
    }

    public int getSize() {
        return this.simplex.length;
    }

    public void build(double[] r12) {
        int r0 = this.dimension;
        if (r0 != r12.length) goto L14;
        PointValuePair[] r1 = new PointValuePair[r0 + 1];
        this.simplex = r1;
        r1[0] = new PointValuePair(r12, Double.NaN);
        int r2 = 0;
    L5:
        int r3 = this.dimension;
        if (r2 >= r3) goto L12;
        double[] r5 = this.startConfiguration[r2];
        double[] r4 = new double[r3];
        int r6 = 0;
    L9:
        if (r6 >= this.dimension) goto L11;
        r4[r6] = r12[r6] + r5[r6];
        r6 = r6 + 1;
        goto L9
    L11:
        r2 = r2 + 1;
        this.simplex[r2] = new PointValuePair(r4, Double.NaN);
        goto L5
    L12:
        return;
    L14:
        throw new DimensionMismatchException(this.dimension, r12.length);
    }

    public void evaluate(MultivariateFunction r8, Comparator<PointValuePair> r9) {
        int r1 = 0;
    L3:
        PointValuePair[] r2 = this.simplex;
        if (r1 >= r2.length) goto L9;
        PointValuePair r3 = r2[r1];
        double[] r4 = r3.getPointRef();
        if (Double.isNaN(r3.getValue().doubleValue()) == false) goto L8;
        this.simplex[r1] = new PointValuePair(r4, r8.value(r4), false);
    L8:
        r1 = r1 + 1;
        goto L3
    L9:
        Arrays.sort(r2, r9);
    }

    protected void replaceWorstPoint(PointValuePair r4, Comparator<PointValuePair> r5) {
        int r0 = 0;
    L3:
        int r1 = this.dimension;
        if (r0 >= r1) goto L9;
        if (r5.compare(this.simplex[r0], r4) <= 0) goto L8;
        PointValuePair[] r2 = this.simplex;
        PointValuePair r3 = r2[r0];
        r2[r0] = r4;
        r4 = r3;
    L8:
        r0 = r0 + 1;
        goto L3
    L9:
        this.simplex[r1] = r4;
    }

    public PointValuePair[] getPoints() {
        PointValuePair[] r3 = this.simplex;
        PointValuePair[] r0 = new PointValuePair[r3.length];
        System.arraycopy(r3, 0, r0, 0, r3.length);
        return r0;
    }

    public PointValuePair getPoint(int r3) {
        if (r3 < 0) goto L8;
        PointValuePair[] r0 = this.simplex;
        if (r3 >= r0.length) goto L8;
        return r0[r3];
    L8:
        throw new OutOfRangeException(Integer.valueOf(r3), 0, Integer.valueOf(this.simplex.length - 1));
    }

    protected void setPoint(int r3, PointValuePair r4) {
        if (r3 < 0) goto L8;
        PointValuePair[] r0 = this.simplex;
        if (r3 >= r0.length) goto L8;
        r0[r3] = r4;
        return;
    L8:
        throw new OutOfRangeException(Integer.valueOf(r3), 0, Integer.valueOf(this.simplex.length - 1));
    }

    protected void setPoints(PointValuePair[] r3) {
        if (r3.length != this.simplex.length) goto L7;
        this.simplex = r3;
        return;
    L7:
        throw new DimensionMismatchException(r3.length, this.simplex.length);
    }

    private static double[] createHypercubeSteps(int r2, double r3) {
        double[] r0 = new double[r2];
        int r1 = 0;
    L3:
        if (r1 >= r2) goto L5;
        r0[r1] = r3;
        r1 = r1 + 1;
        goto L3
    L5:
        return r0;
    }
}
