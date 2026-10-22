package org.apache.commons.math3.analysis.function;

import java.util.Arrays;
import org.apache.commons.math3.analysis.UnivariateFunction;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.NoDataException;
import org.apache.commons.math3.exception.NonMonotonicSequenceException;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.util.MathArrays;

/* JADX INFO: loaded from: classes6.dex */
public class StepFunction implements UnivariateFunction {
    private final double[] abscissa;
    private final double[] ordinate;

    public StepFunction(double[] r3, double[] r4) throws NullArgumentException, NoDataException, DimensionMismatchException, NonMonotonicSequenceException {
        if (r3 == null) goto L18;
        if (r4 == null) goto L18;
        if (r3.length == 0) goto L16;
        if (r4.length == 0) goto L16;
        if (r4.length != r3.length) goto L14;
        MathArrays.checkOrder(r3);
        this.abscissa = MathArrays.copyOf(r3);
        this.ordinate = MathArrays.copyOf(r4);
        return;
    L14:
        throw new DimensionMismatchException(r4.length, r3.length);
    L16:
        throw new NoDataException();
    L18:
        throw new NullArgumentException();
    }

    @Override // org.apache.commons.math3.analysis.UnivariateFunction
    public double value(double r2) {
        int r3 = Arrays.binarySearch(this.abscissa, r2);
        if (r3 < (-1)) goto L9;
        if (r3 < 0) goto L8;
        return this.ordinate[r3];
    L8:
        return this.ordinate[0];
    L9:
        return this.ordinate[(-r3) - 2];
    }
}
