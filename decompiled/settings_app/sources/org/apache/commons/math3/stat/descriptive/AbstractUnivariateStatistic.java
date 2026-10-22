package org.apache.commons.math3.stat.descriptive;

import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.apache.commons.math3.exception.NotPositiveException;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.exception.NumberIsTooLargeException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.util.MathArrays;

/* JADX INFO: loaded from: classes6.dex */
public abstract class AbstractUnivariateStatistic implements UnivariateStatistic {
    private double[] storedData;

    @Override // org.apache.commons.math3.stat.descriptive.UnivariateStatistic, org.apache.commons.math3.stat.descriptive.StorelessUnivariateStatistic
    public abstract UnivariateStatistic copy();

    @Override // org.apache.commons.math3.stat.descriptive.UnivariateStatistic, org.apache.commons.math3.util.MathArrays.Function
    public abstract double evaluate(double[] r1, int r2, int r3) throws MathIllegalArgumentException;

    public AbstractUnivariateStatistic() {
    }

    public void setData(double[] r1) {
        if (r1 != null) goto L4;
        double[] r2 = null;
    L5:
        this.storedData = r2;
        return;
    L4:
        r2 = (double[]) r1.clone();
        goto L5
    }

    public double[] getData() {
        double[] r0 = this.storedData;
        if (r0 != null) goto L6;
        return null;
    L6:
        return (double[]) r0.clone();
    }

    protected double[] getDataRef() {
        return this.storedData;
    }

    public void setData(double[] r4, int r5, int r6) throws MathIllegalArgumentException {
        if (r4 == null) goto L17;
        if (r5 < 0) goto L15;
        if (r6 < 0) goto L13;
        int r1 = r5 + r6;
        if (r1 > r4.length) goto L11;
        double[] r2 = new double[r6];
        this.storedData = r2;
        System.arraycopy(r4, r5, r2, 0, r6);
        return;
    L11:
        throw new NumberIsTooLargeException(LocalizedFormats.SUBARRAY_ENDS_AFTER_ARRAY_END, Integer.valueOf(r1), Integer.valueOf(r4.length), true);
    L13:
        throw new NotPositiveException(LocalizedFormats.LENGTH, Integer.valueOf(r6));
    L15:
        throw new NotPositiveException(LocalizedFormats.START_POSITION, Integer.valueOf(r5));
    L17:
        throw new NullArgumentException(LocalizedFormats.INPUT_ARRAY, new Object[0]);
    }

    public double evaluate() throws MathIllegalArgumentException {
        return evaluate(this.storedData);
    }

    @Override // org.apache.commons.math3.stat.descriptive.UnivariateStatistic, org.apache.commons.math3.util.MathArrays.Function
    public double evaluate(double[] r3) throws MathIllegalArgumentException {
        test(r3, 0, 0);
        return evaluate(r3, 0, r3.length);
    }

    protected boolean test(double[] r1, int r2, int r3) throws MathIllegalArgumentException {
        return MathArrays.verifyValues(r1, r2, r3, false);
    }

    protected boolean test(double[] r1, int r2, int r3, boolean r4) throws MathIllegalArgumentException {
        return MathArrays.verifyValues(r1, r2, r3, r4);
    }

    protected boolean test(double[] r1, double[] r2, int r3, int r4) throws MathIllegalArgumentException {
        return MathArrays.verifyValues(r1, r2, r3, r4, false);
    }

    protected boolean test(double[] r1, double[] r2, int r3, int r4, boolean r5) throws MathIllegalArgumentException {
        return MathArrays.verifyValues(r1, r2, r3, r4, r5);
    }
}
