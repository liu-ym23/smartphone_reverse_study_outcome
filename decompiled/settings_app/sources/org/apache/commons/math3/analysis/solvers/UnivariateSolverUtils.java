package org.apache.commons.math3.analysis.solvers;

import org.apache.commons.math3.analysis.UnivariateFunction;
import org.apache.commons.math3.exception.NoBracketingException;
import org.apache.commons.math3.exception.NotStrictlyPositiveException;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.exception.NumberIsTooLargeException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.util.FastMath;

/* JADX INFO: loaded from: classes6.dex */
public class UnivariateSolverUtils {
    public static boolean isSequence(double r0, double r2, double r4) {
        if (r0 < r2) goto L5;
    L7:
        return false;
    L5:
        if (r2 >= r4) goto L7;
        return true;
    }

    public static double midpoint(double r0, double r2) {
        return (r0 + r2) * 0.5d;
    }

    private UnivariateSolverUtils() {
    }

    public static double solve(UnivariateFunction r7, double r8, double r10) throws NullArgumentException, NoBracketingException {
        if (r7 == null) goto L6;
        return new BrentSolver().solve(Integer.MAX_VALUE, r7, r8, r10);
    L6:
        throw new NullArgumentException(LocalizedFormats.FUNCTION, new Object[0]);
    }

    public static double solve(UnivariateFunction r7, double r8, double r10, double r12) throws NullArgumentException, NoBracketingException {
        if (r7 == null) goto L6;
        return new BrentSolver(r12).solve(Integer.MAX_VALUE, r7, r8, r10);
    L6:
        throw new NullArgumentException(LocalizedFormats.FUNCTION, new Object[0]);
    }

    public static double forceSide(int r29, UnivariateFunction r30, BracketedUnivariateSolver<UnivariateFunction> r31, double r32, double r34, double r36, AllowedSolution r38) throws NoBracketingException {
        if (r38 != AllowedSolution.ANY_SIDE) goto L5;
        return r32;
    L5:
        double r5 = FastMath.max(r31.getAbsoluteAccuracy(), FastMath.abs(r31.getRelativeAccuracy() * r32));
        double r7 = FastMath.max(r34, r32 - r5);
        double r10 = r30.value(r7);
        double r12 = FastMath.min(r36, r32 + r5);
        int r16 = r29 - 2;
        double r19 = r7;
        double r23 = r10;
        double r21 = r12;
        double r25 = r30.value(r12);
    L6:
        boolean r8 = false;
        boolean r9 = true;
        if (r16 <= 0) goto L32;
        if (r23 < 0.0d) goto L13;
        if (r25 > 0.0d) goto L13;
    L17:
        return r31.solve(r16, r30, r19, r21, r32, r38);
    L13:
        if (r23 > 0.0d) goto L19;
        if (r25 >= 0.0d) goto L17;
    L19:
        if (r23 >= r25) goto L23;
        if (r23 < 0.0d) goto L27;
    L21:
        r9 = false;
        r8 = true;
    L27:
        if (r8 == false) goto L29;
        double r11 = FastMath.max(r34, r19 - r5);
        r16 = r16 - 1;
        r19 = r11;
        r23 = r30.value(r11);
    L29:
        if (r9 == false) goto L6;
        double r13 = FastMath.min(r36, r21 + r5);
        r16 = r16 - 1;
        r21 = r13;
        r25 = r30.value(r13);
        goto L6
    L23:
        if (r23 <= r25) goto L26;
        if (r23 > 0.0d) goto L27;
    L26:
        r8 = true;
        goto L27
    L32:
        throw new NoBracketingException(LocalizedFormats.FAILED_BRACKETING, r19, r21, r23, r25, new Object[]{Integer.valueOf(r29 - r16), Integer.valueOf(r29), Double.valueOf(r32), Double.valueOf(r34), Double.valueOf(r36)});
    }

    public static double[] bracket(UnivariateFunction r12, double r13, double r15, double r17) throws NullArgumentException, NotStrictlyPositiveException, NoBracketingException {
        return bracket(r12, r13, r15, r17, 1.0d, 1.0d, Integer.MAX_VALUE);
    }

    public static double[] bracket(UnivariateFunction r12, double r13, double r15, double r17, int r19) throws NullArgumentException, NotStrictlyPositiveException, NoBracketingException {
        return bracket(r12, r13, r15, r17, 1.0d, 1.0d, r19);
    }

    public static double[] bracket(UnivariateFunction r27, double r28, double r30, double r32, double r34, double r36, int r38) throws NoBracketingException {
        UnivariateFunction r0 = r27;
        if (r0 == null) goto L36;
        if (r34 <= 0.0d) goto L34;
        if (r38 <= 0) goto L32;
        double r3 = r28;
        verifySequence(r30, r3, r32);
        double r1 = Double.NaN;
        double r5 = r3;
        double r15 = Double.NaN;
        double r18 = 0.0d;
        int r12 = 0;
    L8:
        if (r12 >= r38) goto L30;
        if (r3 <= r30) goto L12;
    L13:
        r18 = (r18 * r36) + r34;
        double r13 = FastMath.max(r28 - r18, r30);
        double r7 = FastMath.min(r28 + r18, r32);
        double r22 = r0.value(r13);
        double r24 = r0.value(r7);
        if (r12 != 0) goto L20;
        long r20 = 0;
        if ((r22 * r24) <= 0.0d) goto L18;
    L28:
        r12 = r12 + 1;
        r0 = r27;
        r5 = r7;
        r3 = r13;
        r1 = r22;
        r15 = r24;
        goto L8
    L18:
        return new double[]{r13, r7};
    L20:
        r20 = 0;
        if ((r1 * r22) <= 0.0d) goto L23;
        if ((r15 * r24) > 0.0d) goto L28;
        return new double[]{r5, r7};
    L23:
        return new double[]{r13, r3};
    L12:
        if (r5 < r32) goto L13;
    L30:
        throw new NoBracketingException(r3, r5, r1, r15);
    L32:
        throw new NotStrictlyPositiveException(LocalizedFormats.INVALID_MAX_ITERATIONS, Integer.valueOf(r38));
    L34:
        throw new NotStrictlyPositiveException(Double.valueOf(r34));
    L36:
        throw new NullArgumentException(LocalizedFormats.FUNCTION, new Object[0]);
    }

    public static boolean isBracketing(UnivariateFunction r3, double r4, double r6) throws NullArgumentException {
        if (r3 == null) goto L15;
        double r5 = r3.value(r4);
        double r7 = r3.value(r6);
        if (r5 < 0.0d) goto L9;
        if (r7 > 0.0d) goto L9;
    L12:
        return true;
    L9:
        if (r5 <= 0.0d) goto L11;
        return false;
    L11:
        if (r7 >= 0.0d) goto L12;
        return false;
    L15:
        throw new NullArgumentException(LocalizedFormats.FUNCTION, new Object[0]);
    }

    public static void verifyInterval(double r2, double r4) throws NumberIsTooLargeException {
        if (r2 >= r4) goto L6;
        return;
    L6:
        throw new NumberIsTooLargeException(LocalizedFormats.ENDPOINTS_NOT_AN_INTERVAL, Double.valueOf(r2), Double.valueOf(r4), false);
    }

    public static void verifySequence(double r0, double r2, double r4) throws NumberIsTooLargeException {
        verifyInterval(r0, r2);
        verifyInterval(r2, r4);
    }

    public static void verifyBracketing(UnivariateFunction r10, double r11, double r13) throws NullArgumentException, NoBracketingException {
        if (r10 == null) goto L9;
        verifyInterval(r11, r13);
        if (isBracketing(r10, r11, r13) == false) goto L7;
        return;
    L7:
        throw new NoBracketingException(r11, r13, r10.value(r11), r10.value(r13));
    L9:
        throw new NullArgumentException(LocalizedFormats.FUNCTION, new Object[0]);
    }
}
