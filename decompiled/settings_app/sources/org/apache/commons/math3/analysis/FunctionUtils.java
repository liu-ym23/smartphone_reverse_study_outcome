package org.apache.commons.math3.analysis;

import org.apache.commons.math3.analysis.differentiation.MultivariateDifferentiableFunction;
import org.apache.commons.math3.analysis.differentiation.MultivariateDifferentiableVectorFunction;
import org.apache.commons.math3.analysis.differentiation.UnivariateDifferentiableFunction;
import org.apache.commons.math3.analysis.function.Identity;
import org.apache.commons.math3.exception.NotStrictlyPositiveException;
import org.apache.commons.math3.exception.NumberIsTooLargeException;
import org.apache.commons.math3.exception.util.LocalizedFormats;

/* JADX INFO: loaded from: classes6.dex */
public class FunctionUtils {
    private FunctionUtils() {
    }

    public static UnivariateFunction compose(final UnivariateFunction... r1) {
        return new AnonymousClass1(r1);
    }

    public static UnivariateDifferentiableFunction compose(final UnivariateDifferentiableFunction... r1) {
        return new AnonymousClass2(r1);
    }

    @Deprecated
    public static DifferentiableUnivariateFunction compose(final DifferentiableUnivariateFunction... r1) {
        return new AnonymousClass3(r1);
    }

    public static UnivariateFunction add(final UnivariateFunction... r1) {
        return new AnonymousClass4(r1);
    }

    public static UnivariateDifferentiableFunction add(final UnivariateDifferentiableFunction... r1) {
        return new AnonymousClass5(r1);
    }

    @Deprecated
    public static DifferentiableUnivariateFunction add(final DifferentiableUnivariateFunction... r1) {
        return new AnonymousClass6(r1);
    }

    public static UnivariateFunction multiply(final UnivariateFunction... r1) {
        return new AnonymousClass7(r1);
    }

    public static UnivariateDifferentiableFunction multiply(final UnivariateDifferentiableFunction... r1) {
        return new AnonymousClass8(r1);
    }

    @Deprecated
    public static DifferentiableUnivariateFunction multiply(final DifferentiableUnivariateFunction... r1) {
        return new AnonymousClass9(r1);
    }

    public static UnivariateFunction combine(final BivariateFunction r1, final UnivariateFunction r2, final UnivariateFunction r3) {
        return new AnonymousClass10(r1, r2, r3);
    }

    public static MultivariateFunction collector(final BivariateFunction r1, final UnivariateFunction r2, final double r3) {
        return new AnonymousClass11(r1, r3, r2);
    }

    public static MultivariateFunction collector(BivariateFunction r1, double r2) {
        return collector(r1, new Identity(), r2);
    }

    public static UnivariateFunction fix1stArgument(final BivariateFunction r1, final double r2) {
        return new AnonymousClass12(r1, r2);
    }

    public static UnivariateFunction fix2ndArgument(final BivariateFunction r1, final double r2) {
        return new AnonymousClass13(r1, r2);
    }

    public static double[] sample(UnivariateFunction r4, double r5, double r7, int r9) throws NumberIsTooLargeException, NotStrictlyPositiveException {
        if (r9 <= 0) goto L12;
        int r1 = 0;
        if (r5 >= r7) goto L10;
        double[] r0 = new double[r9];
        double r8 = (r7 - r5) / ((double) r9);
    L6:
        if (r1 >= r9) goto L8;
        r0[r1] = r4.value((((double) r1) * r8) + r5);
        r1 = r1 + 1;
        goto L6
    L8:
        return r0;
    L10:
        throw new NumberIsTooLargeException(Double.valueOf(r5), Double.valueOf(r7), false);
    L12:
        throw new NotStrictlyPositiveException(LocalizedFormats.NOT_POSITIVE_NUMBER_OF_SAMPLES, Integer.valueOf(r9));
    }

    @Deprecated
    public static DifferentiableUnivariateFunction toDifferentiableUnivariateFunction(final UnivariateDifferentiableFunction r1) {
        return new AnonymousClass14(r1);
    }

    @Deprecated
    public static UnivariateDifferentiableFunction toUnivariateDifferential(final DifferentiableUnivariateFunction r1) {
        return new AnonymousClass15(r1);
    }

    @Deprecated
    public static DifferentiableMultivariateFunction toDifferentiableMultivariateFunction(final MultivariateDifferentiableFunction r1) {
        return new AnonymousClass16(r1);
    }

    @Deprecated
    public static MultivariateDifferentiableFunction toMultivariateDifferentiableFunction(final DifferentiableMultivariateFunction r1) {
        return new AnonymousClass17(r1);
    }

    @Deprecated
    public static DifferentiableMultivariateVectorFunction toDifferentiableMultivariateVectorFunction(final MultivariateDifferentiableVectorFunction r1) {
        return new AnonymousClass18(r1);
    }

    @Deprecated
    public static MultivariateDifferentiableVectorFunction toMultivariateDifferentiableVectorFunction(final DifferentiableMultivariateVectorFunction r1) {
        return new AnonymousClass19(r1);
    }
}
