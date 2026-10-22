package org.apache.commons.math3.analysis.solvers;

import org.apache.commons.math3.analysis.polynomials.PolynomialFunction;
import org.apache.commons.math3.complex.Complex;
import org.apache.commons.math3.complex.ComplexUtils;
import org.apache.commons.math3.exception.NoBracketingException;
import org.apache.commons.math3.exception.NoDataException;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.exception.NumberIsTooLargeException;
import org.apache.commons.math3.exception.TooManyEvaluationsException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.util.FastMath;

/* JADX INFO: loaded from: classes6.dex */
public class LaguerreSolver extends AbstractPolynomialSolver {
    private static final double DEFAULT_ABSOLUTE_ACCURACY = 1.0E-6d;
    private final ComplexSolver complexSolver;

    /* JADX INFO: renamed from: org.apache.commons.math3.analysis.solvers.LaguerreSolver$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private class ComplexSolver {
        final /* synthetic */ LaguerreSolver this$0;

        private ComplexSolver(LaguerreSolver r1) {
            this.this$0 = r1;
        }

        /* synthetic */ ComplexSolver(LaguerreSolver r1, AnonymousClass1 r2) {
            this(r1);
        }

        public boolean isRoot(double r8, double r10, Complex r12) {
            if (this.this$0.isSequence(r8, r12.getReal(), r10) == false) goto L10;
            double r11 = FastMath.max(this.this$0.getRelativeAccuracy() * r12.abs(), this.this$0.getAbsoluteAccuracy());
            if (FastMath.abs(r12.getImaginary()) > r11) goto L7;
        L8:
            return true;
        L7:
            if (r12.abs() <= this.this$0.getFunctionValueAccuracy()) goto L8;
            return false;
        L10:
            return false;
        }

        public Complex[] solveAll(Complex[] r9, Complex r10) throws NullArgumentException, NoDataException, TooManyEvaluationsException {
            if (r9 == null) goto L18;
            int r0 = r9.length - 1;
            if (r0 == 0) goto L16;
            Complex[] r1 = new Complex[r0 + 1];
            int r3 = 0;
        L6:
            if (r3 > r0) goto L8;
            r1[r3] = r9[r3];
            r3 = r3 + 1;
            goto L6
        L8:
            Complex[] r11 = new Complex[r0];
            int r4 = 0;
        L9:
            if (r4 >= r0) goto L14;
            int r5 = r0 - r4;
            int r6 = r5 + 1;
            Complex[] r7 = new Complex[r6];
            System.arraycopy(r1, 0, r7, 0, r6);
            r11[r4] = solve(r7, r10);
            Complex r8 = r1[r5];
            int r12 = r5 - 1;
        L11:
            if (r12 < 0) goto L13;
            Complex r13 = r1[r12];
            r1[r12] = r8;
            r8 = r13.add2(r8.multiply2(r11[r4]));
            r12 = r12 - 1;
            goto L11
        L13:
            r4 = r4 + 1;
            goto L9
        L14:
            return r11;
        L16:
            throw new NoDataException(LocalizedFormats.POLYNOMIAL);
        L18:
            throw new NullArgumentException();
        }

        public Complex solve(Complex[] r24, Complex r25) throws NullArgumentException, NoDataException, TooManyEvaluationsException {
            Complex[] r1 = r24;
            if (r1 == null) goto L28;
            int r2 = r1.length - 1;
            if (r2 == 0) goto L26;
            double r3 = this.this$0.getAbsoluteAccuracy();
            double r5 = this.this$0.getRelativeAccuracy();
            double r7 = this.this$0.getFunctionValueAccuracy();
            Complex r9 = new Complex(r2, 0.0d);
            int r11 = r2 - 1;
            Complex r10 = new Complex(r11, 0.0d);
            Complex r15 = new Complex(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY);
            Complex r14 = r25;
        L7:
            Complex r16 = r1[r2];
            Complex r12 = r16;
            Complex r13 = Complex.ZERO;
            int r17 = r2;
            int r19 = r11;
            Complex r4 = Complex.ZERO;
        L8:
            if (r19 < 0) goto L10;
            Complex r6 = r13.add2(r14.multiply2(r4));
            r13 = r12.add2(r14.multiply2(r13));
            r12 = r1[r19].add2(r14.multiply2(r12));
            r19 = r19 - 1;
            r4 = r6;
            goto L8
        L10:
            Complex r110 = r10;
            int r20 = r11;
            double r21 = r7;
            Complex r8 = r4.multiply2(new Complex(2.0d, 0.0d));
            if (r14.subtract2(r15).abs() <= FastMath.max(r14.abs() * r5, r3)) goto L12;
            if (r12.abs() <= r21) goto L15;
            Complex r18 = r13.divide2(r12);
            Complex r111 = r18.multiply2(r18);
            Complex r22 = r9.multiply2(r111.subtract2(r8.divide2(r12))).subtract2(r111);
            r10 = r110;
            Complex r23 = r10.multiply2(r22).sqrt();
            Complex r112 = r18.add2(r23);
            Complex r26 = r18.subtract2(r23);
            if (r112.abs() > r26.abs()) goto L21;
            r112 = r26;
        L21:
            if (r112.equals(new Complex(0.0d, 0.0d)) == false) goto L23;
            r14 = r14.add2(new Complex(r3, r3));
            r15 = new Complex(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY);
        L24:
            this.this$0.incrementEvaluationCount();
            r1 = r24;
            r2 = r17;
            r11 = r20;
            r7 = r21;
            goto L7
        L23:
            r15 = r14;
            r14 = r14.subtract2(r9.divide2(r112));
            goto L24
        L15:
            return r14;
        L12:
            return r14;
        L26:
            throw new NoDataException(LocalizedFormats.POLYNOMIAL);
        L28:
            throw new NullArgumentException();
        }
    }

    public LaguerreSolver() {
        this(1.0E-6d);
    }

    public LaguerreSolver(double r1) {
        super(r1);
        this.complexSolver = new ComplexSolver(this, null);
    }

    public LaguerreSolver(double r1, double r3) {
        super(r1, r3);
        this.complexSolver = new ComplexSolver(this, null);
    }

    public LaguerreSolver(double r1, double r3, double r5) {
        super(r1, r3, r5);
        this.complexSolver = new ComplexSolver(this, null);
    }

    @Override // org.apache.commons.math3.analysis.solvers.BaseAbstractUnivariateSolver
    public double doSolve() throws TooManyEvaluationsException, NumberIsTooLargeException, NoBracketingException {
        double r8 = getMin();
        double r10 = getMax();
        double r12 = getStartValue();
        double r14 = getFunctionValueAccuracy();
        verifySequence(r8, r12, r10);
        double r16 = computeObjectiveValue(r12);
        if (FastMath.abs(r16) > r14) goto L5;
        return r12;
    L5:
        double r5 = computeObjectiveValue(r8);
        if (FastMath.abs(r5) > r14) goto L9;
        return r8;
    L9:
        if ((r16 * r5) < 0.0d) goto L11;
        double r18 = computeObjectiveValue(r10);
        if (FastMath.abs(r18) > r14) goto L16;
        return r10;
    L16:
        if ((r16 * r18) >= 0.0d) goto L20;
        return laguerre(r12, r10, r16, r18);
    L20:
        throw new NoBracketingException(r8, r10, r5, r18);
    L11:
        return laguerre(r8, r12, r5, r16);
    }

    @Deprecated
    public double laguerre(double r7, double r9, double r11, double r13) {
        Complex[] r12 = ComplexUtils.convertToComplex(getCoefficients());
        Complex r14 = new Complex((r7 + r9) * 0.5d, 0.0d);
        Complex r15 = this.complexSolver.solve(r12, r14);
        if (this.complexSolver.isRoot(r7, r9, r15) == true) goto L5;
        Complex[] r16 = this.complexSolver.solveAll(r12, r14);
        int r17 = 0;
    L8:
        if (r17 >= r16.length) goto L13;
        if (this.complexSolver.isRoot(r7, r9, r16[r17]) == true) goto L17;
        r17 = r17 + 1;
        goto L8
    L17:
        return r16[r17].getReal();
    L13:
        return Double.NaN;
    L5:
        return r15.getReal();
    }

    public Complex[] solveAllComplex(double[] r2, double r3) throws NullArgumentException, NoDataException, TooManyEvaluationsException {
        return solveAllComplex(r2, r3, Integer.MAX_VALUE);
    }

    public Complex[] solveAllComplex(double[] r10, double r11, int r13) throws NullArgumentException, NoDataException, TooManyEvaluationsException {
        setup(r13, new PolynomialFunction(r10), Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY, r11);
        return this.complexSolver.solveAll(ComplexUtils.convertToComplex(r10), new Complex(r11, 0.0d));
    }

    public Complex solveComplex(double[] r2, double r3) throws NullArgumentException, NoDataException, TooManyEvaluationsException {
        return solveComplex(r2, r3, Integer.MAX_VALUE);
    }

    public Complex solveComplex(double[] r10, double r11, int r13) throws NullArgumentException, NoDataException, TooManyEvaluationsException {
        setup(r13, new PolynomialFunction(r10), Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY, r11);
        return this.complexSolver.solve(ComplexUtils.convertToComplex(r10), new Complex(r11, 0.0d));
    }
}
