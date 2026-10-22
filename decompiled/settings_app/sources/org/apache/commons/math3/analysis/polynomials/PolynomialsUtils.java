package org.apache.commons.math3.analysis.polynomials;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.math3.fraction.BigFraction;
import org.apache.commons.math3.util.CombinatoricsUtils;
import org.apache.commons.math3.util.FastMath;

/* JADX INFO: loaded from: classes6.dex */
public class PolynomialsUtils {
    private static final List<BigFraction> CHEBYSHEV_COEFFICIENTS = null;
    private static final List<BigFraction> HERMITE_COEFFICIENTS = null;
    private static final Map<JacobiKey, List<BigFraction>> JACOBI_COEFFICIENTS = null;
    private static final List<BigFraction> LAGUERRE_COEFFICIENTS = null;
    private static final List<BigFraction> LEGENDRE_COEFFICIENTS = null;

    private static class JacobiKey {
        private final int v;
        private final int w;

        JacobiKey(int r1, int r2) {
            this.v = r1;
            this.w = r2;
        }

        public int hashCode() {
            int r0 = this.v << 16;
            return this.w ^ r0;
        }

        public boolean equals(Object r4) {
            if (r4 != null) goto L5;
            return false;
        L5:
            if ((r4 instanceof JacobiKey) == false) goto L16;
            JacobiKey r5 = (JacobiKey) r4;
            if (this.v == r5.v) goto L10;
            return false;
        L10:
            if (this.w != r5.w) goto L15;
            return true;
        L15:
            return false;
        L16:
            return false;
        }
    }

    private interface RecurrenceCoefficientsGenerator {
        BigFraction[] generate(int r1);
    }

    static {
        ArrayList r0 = new ArrayList();
        CHEBYSHEV_COEFFICIENTS = r0;
        r0.add(BigFraction.ONE);
        r0.add(BigFraction.ZERO);
        r0.add(BigFraction.ONE);
        ArrayList r1 = new ArrayList();
        HERMITE_COEFFICIENTS = r1;
        r1.add(BigFraction.ONE);
        r1.add(BigFraction.ZERO);
        r1.add(BigFraction.TWO);
        ArrayList r2 = new ArrayList();
        LAGUERRE_COEFFICIENTS = r2;
        r2.add(BigFraction.ONE);
        r2.add(BigFraction.ONE);
        r2.add(BigFraction.MINUS_ONE);
        ArrayList r3 = new ArrayList();
        LEGENDRE_COEFFICIENTS = r3;
        r3.add(BigFraction.ONE);
        r3.add(BigFraction.ZERO);
        r3.add(BigFraction.ONE);
        JACOBI_COEFFICIENTS = new HashMap();
    }

    private PolynomialsUtils() {
    }

    public static PolynomialFunction createChebyshevPolynomial(int r2) {
        return buildPolynomial(r2, CHEBYSHEV_COEFFICIENTS, new AnonymousClass1());
    }

    public static PolynomialFunction createHermitePolynomial(int r2) {
        return buildPolynomial(r2, HERMITE_COEFFICIENTS, new AnonymousClass2());
    }

    public static PolynomialFunction createLaguerrePolynomial(int r2) {
        return buildPolynomial(r2, LAGUERRE_COEFFICIENTS, new AnonymousClass3());
    }

    public static PolynomialFunction createLegendrePolynomial(int r2) {
        return buildPolynomial(r2, LEGENDRE_COEFFICIENTS, new AnonymousClass4());
    }

    public static PolynomialFunction createJacobiPolynomial(int r6, final int r7, final int r8) {
        JacobiKey r0 = new JacobiKey(r7, r8);
        Map<JacobiKey, List<BigFraction>> r1 = JACOBI_COEFFICIENTS;
        if (r1.containsKey(r0) == true) goto L6;
        ArrayList r2 = new ArrayList();
        r1.put(r0, r2);
        r2.add(BigFraction.ONE);
        r2.add(new BigFraction(r7 - r8, 2));
        r2.add(new BigFraction((r7 + 2) + r8, 2));
    L6:
        return buildPolynomial(r6, r1.get(r0), new AnonymousClass5(r7, r8));
    }

    public static double[] shift(double[] r13, double r14) {
        int r0 = r13.length;
        double[] r1 = new double[r0];
        int r4 = 0;
        int[][] r2 = (int[][]) Array.newInstance(Integer.TYPE, new int[]{r0, r0});
        int r5 = 0;
    L3:
        if (r5 >= r0) goto L8;
        int r6 = 0;
    L5:
        if (r6 > r5) goto L7;
        r2[r5][r6] = (int) CombinatoricsUtils.binomialCoefficient(r5, r6);
        r6 = r6 + 1;
        goto L5
    L7:
        r5 = r5 + 1;
        goto L3
    L8:
        int r7 = 0;
    L9:
        if (r7 >= r0) goto L11;
        r1[0] = r1[0] + (r13[r7] * FastMath.pow(r14, r7));
        r7 = r7 + 1;
        goto L9
    L11:
        int r3 = r0 - 1;
    L12:
        if (r4 >= r3) goto L17;
        int r8 = r4;
    L14:
        if (r8 >= r3) goto L16;
        int r9 = r4 + 1;
        int r10 = r8 + 1;
        int r11 = r8 - r4;
        r1[r9] = r1[r9] + ((((double) r2[r10][r11]) * r13[r10]) * FastMath.pow(r14, r11));
        r8 = r10;
        goto L14
    L16:
        r4 = r4 + 1;
        goto L12
    L17:
        return r1;
    }

    private static PolynomialFunction buildPolynomial(int r4, List<BigFraction> r5, RecurrenceCoefficientsGenerator r6) {
        monitor-enter(r5);
        int r0 = ((int) FastMath.floor(FastMath.sqrt(r5.size() * 2))) - 1;     // Catch: Throwable -> L12
        if (r4 <= r0) goto L6;
        computeUpToDegree(r4, r0, r6, r5);     // Catch: Throwable -> L12
    L6:
        monitor-exit(r5);     // Catch: Throwable -> L12
        int r7 = r4 + 1;
        int r1 = (r4 * r7) / 2;
        double[] r8 = new double[r7];
        int r2 = 0;
    L8:
        if (r2 > r4) goto L11;
        r8[r2] = r5.get(r1 + r2).doubleValue();
        r2 = r2 + 1;
        goto L8
    L11:
        return new PolynomialFunction(r8);
    L12:
        th = move-exception;
        throw th;
    }

    private static void computeUpToDegree(int r12, int r13, RecurrenceCoefficientsGenerator r14, List<BigFraction> r15) {
        int r0 = ((r13 - 1) * r13) / 2;
    L3:
        if (r13 >= r12) goto L8;
        int r2 = r0 + r13;
        BigFraction[] r3 = r14.generate(r13);
        BigFraction r4 = r15.get(r2);
        r15.add(r4.multiply2(r3[0]).subtract2(r15.get(r0).multiply2(r3[2])));
        int r7 = 1;
    L5:
        if (r7 >= r13) goto L7;
        BigFraction r8 = r15.get(r2 + r7);
        r15.add(r8.multiply2(r3[0]).add2(r4.multiply2(r3[1])).subtract2(r15.get(r0 + r7).multiply2(r3[2])));
        r7 = r7 + 1;
        r4 = r8;
        goto L5
    L7:
        BigFraction r1 = r15.get(r2 + r13);
        r15.add(r1.multiply2(r3[0]).add2(r4.multiply2(r3[1])));
        r15.add(r1.multiply2(r3[1]));
        r13 = r13 + 1;
        r0 = r2;
        goto L3
    }
}
