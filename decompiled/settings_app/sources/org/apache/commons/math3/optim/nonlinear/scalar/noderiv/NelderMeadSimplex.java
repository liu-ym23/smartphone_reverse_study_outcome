package org.apache.commons.math3.optim.nonlinear.scalar.noderiv;

import java.util.Comparator;
import org.apache.commons.math3.analysis.MultivariateFunction;
import org.apache.commons.math3.optim.PointValuePair;

/* JADX INFO: loaded from: classes6.dex */
public class NelderMeadSimplex extends AbstractSimplex {
    private static final double DEFAULT_GAMMA = 0.5d;
    private static final double DEFAULT_KHI = 2.0d;
    private static final double DEFAULT_RHO = 1.0d;
    private static final double DEFAULT_SIGMA = 0.5d;
    private final double gamma;
    private final double khi;
    private final double rho;
    private final double sigma;

    public NelderMeadSimplex(int r3) {
        this(r3, DEFAULT_RHO);
    }

    public NelderMeadSimplex(int r13, double r14) {
        this(r13, r14, DEFAULT_RHO, DEFAULT_KHI, 0.5d, 0.5d);
    }

    public NelderMeadSimplex(int r1, double r2, double r4, double r6, double r8, double r10) {
        super(r1, r2);
        this.rho = r4;
        this.khi = r6;
        this.gamma = r8;
        this.sigma = r10;
    }

    public NelderMeadSimplex(int r13, double r14, double r16, double r18, double r20) {
        this(r13, DEFAULT_RHO, r14, r16, r18, r20);
    }

    public NelderMeadSimplex(double[] r11) {
        this(r11, DEFAULT_RHO, DEFAULT_KHI, 0.5d, 0.5d);
    }

    public NelderMeadSimplex(double[] r1, double r2, double r4, double r6, double r8) {
        super(r1);
        this.rho = r2;
        this.khi = r4;
        this.gamma = r6;
        this.sigma = r8;
    }

    public NelderMeadSimplex(double[][] r11) {
        this(r11, DEFAULT_RHO, DEFAULT_KHI, 0.5d, 0.5d);
    }

    public NelderMeadSimplex(double[][] r1, double r2, double r4, double r6, double r8) {
        super(r1);
        this.rho = r2;
        this.khi = r4;
        this.gamma = r6;
        this.sigma = r8;
    }

    @Override // org.apache.commons.math3.optim.nonlinear.scalar.noderiv.AbstractSimplex
    public void iterate(MultivariateFunction r19, Comparator<PointValuePair> r20) {
        int r3 = getDimension();
        PointValuePair r5 = getPoint(0);
        PointValuePair r6 = getPoint(r3 - 1);
        PointValuePair r7 = getPoint(r3);
        double[] r8 = r7.getPointRef();
        double[] r9 = new double[r3];
        int r10 = 0;
    L3:
        if (r10 >= r3) goto L8;
        double[] r11 = getPoint(r10).getPointRef();
        int r12 = 0;
    L5:
        if (r12 >= r3) goto L7;
        r9[r12] = r9[r12] + r11[r12];
        r12 = r12 + 1;
        goto L5
    L7:
        r10 = r10 + 1;
        goto L3
    L8:
        double r13 = DEFAULT_RHO / ((double) r3);
        int r14 = 0;
    L9:
        if (r14 >= r3) goto L11;
        r9[r14] = r9[r14] * r13;
        r14 = r14 + 1;
        goto L9
    L11:
        double[] r15 = new double[r3];
        int r16 = 0;
    L12:
        if (r16 >= r3) goto L14;
        double r17 = r9[r16];
        r15[r16] = r17 + (this.rho * (r17 - r8[r16]));
        r16 = r16 + 1;
        goto L12
    L14:
        PointValuePair r18 = new PointValuePair(r15, r19.value(r15), false);
        if (r20.compare(r5, r18) > 0) goto L20;
        if (r20.compare(r18, r6) >= 0) goto L20;
        replaceWorstPoint(r18, r20);
        return;
    L20:
        if (r20.compare(r18, r5) >= 0) goto L29;
        double[] r21 = new double[r3];
        int r22 = 0;
    L22:
        if (r22 >= r3) goto L24;
        double r23 = r9[r22];
        r21[r22] = r23 + (this.khi * (r15[r22] - r23));
        r22 = r22 + 1;
        goto L22
    L24:
        PointValuePair r4 = new PointValuePair(r21, r19.value(r21), false);
        if (r20.compare(r4, r18) >= 0) goto L27;
        replaceWorstPoint(r4, r20);
        return;
    L27:
        replaceWorstPoint(r18, r20);
        return;
    L29:
        if (r20.compare(r18, r7) >= 0) goto L37;
        double[] r24 = new double[r3];
        int r25 = 0;
    L31:
        if (r25 >= r3) goto L33;
        double r26 = r9[r25];
        r24[r25] = r26 + (this.gamma * (r15[r25] - r26));
        r25 = r25 + 1;
        goto L31
    L33:
        PointValuePair r27 = new PointValuePair(r24, r19.value(r24), false);
        if (r20.compare(r27, r18) > 0) goto L44;
        replaceWorstPoint(r27, r20);
        return;
    L44:
        double[] r28 = getPoint(0).getPointRef();
        int r29 = 1;
    L45:
        if (r29 > r3) goto L50;
        double[] r30 = getPoint(r29).getPoint();
        int r31 = 0;
    L47:
        if (r31 >= r3) goto L49;
        double r32 = r28[r31];
        r30[r31] = r32 + (this.sigma * (r30[r31] - r32));
        r31 = r31 + 1;
        goto L47
    L49:
        setPoint(r29, new PointValuePair(r30, Double.NaN, false));
        r29 = r29 + 1;
        goto L45
    L50:
        evaluate(r19, r20);
        return;
    L37:
        double[] r33 = new double[r3];
        int r34 = 0;
    L38:
        if (r34 >= r3) goto L40;
        double r110 = r9[r34];
        r33[r34] = r110 - (this.gamma * (r110 - r8[r34]));
        r34 = r34 + 1;
        goto L38
    L40:
        PointValuePair r35 = new PointValuePair(r33, r19.value(r33), false);
        if (r20.compare(r35, r7) >= 0) goto L44;
        replaceWorstPoint(r35, r20);
    }
}
