package org.apache.commons.math3.optimization.direct;

import java.util.Comparator;
import org.apache.commons.math3.analysis.MultivariateFunction;
import org.apache.commons.math3.optimization.PointValuePair;

/* JADX INFO: loaded from: classes6.dex */
@Deprecated
public class MultiDirectionalSimplex extends AbstractSimplex {
    private static final double DEFAULT_GAMMA = 0.5d;
    private static final double DEFAULT_KHI = 2.0d;
    private final double gamma;
    private final double khi;

    public MultiDirectionalSimplex(int r3) {
        this(r3, 1.0d);
    }

    public MultiDirectionalSimplex(int r9, double r10) {
        this(r9, r10, DEFAULT_KHI, 0.5d);
    }

    public MultiDirectionalSimplex(int r9, double r10, double r12) {
        this(r9, 1.0d, r10, r12);
    }

    public MultiDirectionalSimplex(int r1, double r2, double r4, double r6) {
        super(r1, r2);
        this.khi = r4;
        this.gamma = r6;
    }

    public MultiDirectionalSimplex(double[] r7) {
        this(r7, DEFAULT_KHI, 0.5d);
    }

    public MultiDirectionalSimplex(double[] r1, double r2, double r4) {
        super(r1);
        this.khi = r2;
        this.gamma = r4;
    }

    public MultiDirectionalSimplex(double[][] r7) {
        this(r7, DEFAULT_KHI, 0.5d);
    }

    public MultiDirectionalSimplex(double[][] r1, double r2, double r4) {
        super(r1);
        this.khi = r2;
        this.gamma = r4;
    }

    @Override // org.apache.commons.math3.optimization.direct.AbstractSimplex
    public void iterate(MultivariateFunction r10, Comparator<PointValuePair> r11) {
        PointValuePair[] r6 = getPoints();
        PointValuePair r7 = r6[0];
        PointValuePair r8 = evaluateNewSimplex(r10, r6, 1.0d, r11);
        if (r11.compare(r8, r7) >= 0) goto L8;
        PointValuePair[] r9 = getPoints();
        if (r11.compare(r8, evaluateNewSimplex(r10, r6, this.khi, r11)) > 0) goto L10;
        setPoints(r9);
        return;
    L10:
        return;
    L8:
        evaluateNewSimplex(r10, r6, this.gamma, r11);
    }

    private PointValuePair evaluateNewSimplex(MultivariateFunction r13, PointValuePair[] r14, double r15, Comparator<PointValuePair> r17) {
        double[] r2 = r14[0].getPointRef();
        setPoint(0, r14[0]);
        int r3 = getDimension();
        int r4 = 1;
    L4:
        if (r4 >= getSize()) goto L9;
        double[] r5 = r14[r4].getPointRef();
        double[] r6 = new double[r3];
        int r7 = 0;
    L6:
        if (r7 >= r3) goto L8;
        double r8 = r2[r7];
        r6[r7] = r8 + ((r8 - r5[r7]) * r15);
        r7 = r7 + 1;
        goto L6
    L8:
        setPoint(r4, new PointValuePair(r6, Double.NaN, false));
        r4 = r4 + 1;
        goto L4
    L9:
        evaluate(r13, r17);
        return getPoint(0);
    }
}
