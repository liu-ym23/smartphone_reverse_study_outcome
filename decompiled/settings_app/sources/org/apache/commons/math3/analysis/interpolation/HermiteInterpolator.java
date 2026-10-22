package org.apache.commons.math3.analysis.interpolation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.apache.commons.math3.analysis.differentiation.DerivativeStructure;
import org.apache.commons.math3.analysis.differentiation.UnivariateDifferentiableVectorFunction;
import org.apache.commons.math3.analysis.polynomials.PolynomialFunction;
import org.apache.commons.math3.exception.MathArithmeticException;
import org.apache.commons.math3.exception.NoDataException;
import org.apache.commons.math3.exception.ZeroException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.util.CombinatoricsUtils;

/* JADX INFO: loaded from: classes6.dex */
public class HermiteInterpolator implements UnivariateDifferentiableVectorFunction {
    private final List<Double> abscissae;
    private final List<double[]> bottomDiagonal;
    private final List<double[]> topDiagonal;

    public HermiteInterpolator() {
        this.abscissae = new ArrayList();
        this.topDiagonal = new ArrayList();
        this.bottomDiagonal = new ArrayList();
    }

    public void addSamplePoint(double r20, double[]... r22) throws ZeroException, MathArithmeticException {
        int r3 = 0;
    L4:
        if (r3 >= r22.length) goto L23;
        double[] r4 = (double[]) r22[r3].clone();
        if (r3 <= 1) goto L11;
        double r8 = 1.0d / CombinatoricsUtils.factorial(r3);
        int r10 = 0;
    L9:
        if (r10 >= r4.length) goto L11;
        r4[r10] = r4[r10] * r8;
        r10 = r10 + 1;
    L11:
        int r9 = this.abscissae.size();
        this.bottomDiagonal.add(r9 - r3, r4);
        int r11 = r3;
        double[] r12 = r4;
    L12:
        if (r11 >= r9) goto L22;
        r11 = r11 + 1;
        int r13 = r9 - r11;
        double[] r14 = this.bottomDiagonal.get(r13);
        double r15 = 1.0d / (r20 - this.abscissae.get(r13).doubleValue());
        if (Double.isInfinite(r15) == true) goto L21;
        int r16 = 0;
    L17:
        if (r16 >= r4.length) goto L19;
        r14[r16] = (r12[r16] - r14[r16]) * r15;
        r16 = r16 + 1;
        goto L17
    L19:
        r12 = r14;
        goto L12
    L21:
        throw new ZeroException(LocalizedFormats.DUPLICATED_ABSCISSA_DIVISION_BY_ZERO, new Object[]{Double.valueOf(r20)});
    L22:
        this.topDiagonal.add((double[]) r12.clone());
        this.abscissae.add(Double.valueOf(r20));
        r3 = r3 + 1;
        goto L4
    }

    public PolynomialFunction[] getPolynomials() throws NoDataException {
        checkInterpolation();
        PolynomialFunction r1 = polynomial(new double[]{0.0d});
        int r2 = this.topDiagonal.get(0).length;
        PolynomialFunction[] r3 = new PolynomialFunction[r2];
        int r5 = 0;
    L3:
        if (r5 >= r2) goto L5;
        r3[r5] = r1;
        r5 = r5 + 1;
        goto L3
    L5:
        PolynomialFunction r4 = polynomial(new double[]{1.0d});
        int r7 = 0;
    L7:
        if (r7 >= this.topDiagonal.size()) goto L12;
        double[] r8 = this.topDiagonal.get(r7);
        int r9 = 0;
    L9:
        if (r9 >= r2) goto L11;
        r3[r9] = r3[r9].add(r4.multiply(polynomial(new double[]{r8[r9]})));
        r9 = r9 + 1;
        goto L9
    L11:
        r4 = r4.multiply(polynomial(new double[]{-this.abscissae.get(r7).doubleValue(), 1.0d}));
        r7 = r7 + 1;
        goto L7
    L12:
        return r3;
    }

    @Override // org.apache.commons.math3.analysis.UnivariateVectorFunction
    public double[] value(double r13) throws NoDataException {
        checkInterpolation();
        int r0 = this.topDiagonal.get(0).length;
        double[] r2 = new double[r0];
        double r3 = 1.0d;
        int r5 = 0;
    L4:
        if (r5 >= this.topDiagonal.size()) goto L9;
        double[] r6 = this.topDiagonal.get(r5);
        int r7 = 0;
    L6:
        if (r7 >= r0) goto L8;
        r2[r7] = r2[r7] + (r6[r7] * r3);
        r7 = r7 + 1;
        goto L6
    L8:
        r3 = r3 * (r13 - this.abscissae.get(r5).doubleValue());
        r5 = r5 + 1;
        goto L4
    L9:
        return r2;
    }

    @Override // org.apache.commons.math3.analysis.differentiation.UnivariateDifferentiableVectorFunction
    public DerivativeStructure[] value(DerivativeStructure r11) throws NoDataException {
        checkInterpolation();
        int r0 = this.topDiagonal.get(0).length;
        DerivativeStructure[] r2 = new DerivativeStructure[r0];
        Arrays.fill(r2, r11.getField().getZero());
        DerivativeStructure r3 = r11.getField().getOne();
        int r4 = 0;
    L4:
        if (r4 >= this.topDiagonal.size()) goto L9;
        double[] r5 = this.topDiagonal.get(r4);
        int r6 = 0;
    L6:
        if (r6 >= r0) goto L8;
        r2[r6] = r2[r6].add(r3.multiply2(r5[r6]));
        r6 = r6 + 1;
        goto L6
    L8:
        r3 = r3.multiply(r11.subtract2(this.abscissae.get(r4).doubleValue()));
        r4 = r4 + 1;
        goto L4
    L9:
        return r2;
    }

    private void checkInterpolation() throws NoDataException {
        if (this.abscissae.isEmpty() == true) goto L6;
        return;
    L6:
        throw new NoDataException(LocalizedFormats.EMPTY_INTERPOLATION_SAMPLE);
    }

    private PolynomialFunction polynomial(double... r1) {
        return new PolynomialFunction(r1);
    }
}
