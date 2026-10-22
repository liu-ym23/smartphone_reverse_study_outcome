package org.apache.commons.math3.analysis.interpolation;

import org.apache.commons.math3.analysis.UnivariateFunction;
import org.apache.commons.math3.exception.NonMonotonicSequenceException;
import org.apache.commons.math3.exception.NumberIsTooSmallException;
import org.apache.commons.math3.util.MathArrays;
import org.apache.commons.math3.util.MathUtils;

/* JADX INFO: loaded from: classes6.dex */
public class UnivariatePeriodicInterpolator implements UnivariateInterpolator {
    public static final int DEFAULT_EXTEND = 5;
    private final int extend;
    private final UnivariateInterpolator interpolator;
    private final double period;

    static /* synthetic */ double access$000(UnivariatePeriodicInterpolator r2) {
        return r2.period;
    }

    public UnivariatePeriodicInterpolator(UnivariateInterpolator r1, double r2, int r4) {
        this.interpolator = r1;
        this.period = r2;
        this.extend = r4;
    }

    public UnivariatePeriodicInterpolator(UnivariateInterpolator r2, double r3) {
        this(r2, r3, 5);
    }

    @Override // org.apache.commons.math3.analysis.interpolation.UnivariateInterpolator
    public UnivariateFunction interpolate(double[] r18, double[] r19) throws NumberIsTooSmallException, NonMonotonicSequenceException {
        if (r18.length < this.extend) goto L15;
        MathArrays.checkOrder(r18);
        final double r11 = r18[0];
        int r3 = r18.length + (this.extend * 2);
        double[] r13 = new double[r3];
        double[] r14 = new double[r3];
        int r15 = 0;
    L6:
        if (r15 >= r18.length) goto L8;
        int r16 = r15 + this.extend;
        r13[r16] = MathUtils.reduce(r18[r15], this.period, r11);
        r14[r16] = r19[r15];
        r15 = r15 + 1;
        goto L6
    L8:
        int r17 = 0;
    L9:
        int r5 = this.extend;
        if (r17 >= r5) goto L12;
        int r110 = (r18.length - r5) + r17;
        double r6 = MathUtils.reduce(r18[r110], this.period, r11);
        double r7 = this.period;
        r13[r17] = r6 - r7;
        r14[r17] = r19[r110];
        int r111 = (r3 - this.extend) + r17;
        r13[r111] = MathUtils.reduce(r18[r17], r7, r11) + this.period;
        r14[r111] = r19[r17];
        r17 = r17 + 1;
        goto L9
    L12:
        MathArrays.sortInPlace(r13, new double[][]{r14});
        final UnivariateFunction r1 = this.interpolator.interpolate(r13, r14);
        return new AnonymousClass1(this, r1, r11);
    L15:
        throw new NumberIsTooSmallException(Integer.valueOf(r18.length), Integer.valueOf(this.extend), true);
    }
}
