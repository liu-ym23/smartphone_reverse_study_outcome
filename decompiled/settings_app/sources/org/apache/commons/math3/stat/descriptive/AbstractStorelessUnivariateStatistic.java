package org.apache.commons.math3.stat.descriptive;

import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.util.MathUtils;
import org.apache.commons.math3.util.Precision;

/* JADX INFO: loaded from: classes6.dex */
public abstract class AbstractStorelessUnivariateStatistic extends AbstractUnivariateStatistic implements StorelessUnivariateStatistic {
    @Override // org.apache.commons.math3.stat.descriptive.StorelessUnivariateStatistic
    public abstract void clear();

    @Override // org.apache.commons.math3.stat.descriptive.AbstractUnivariateStatistic, org.apache.commons.math3.stat.descriptive.UnivariateStatistic, org.apache.commons.math3.stat.descriptive.StorelessUnivariateStatistic
    public abstract StorelessUnivariateStatistic copy();

    @Override // org.apache.commons.math3.stat.descriptive.StorelessUnivariateStatistic
    public abstract double getResult();

    @Override // org.apache.commons.math3.stat.descriptive.StorelessUnivariateStatistic
    public abstract void increment(double r1);

    public AbstractStorelessUnivariateStatistic() {
    }

    @Override // org.apache.commons.math3.stat.descriptive.AbstractUnivariateStatistic, org.apache.commons.math3.stat.descriptive.UnivariateStatistic, org.apache.commons.math3.stat.descriptive.StorelessUnivariateStatistic
    public /* bridge */ /* synthetic */ UnivariateStatistic copy() {
        return copy();
    }

    @Override // org.apache.commons.math3.stat.descriptive.AbstractUnivariateStatistic, org.apache.commons.math3.stat.descriptive.UnivariateStatistic, org.apache.commons.math3.util.MathArrays.Function
    public double evaluate(double[] r3) throws MathIllegalArgumentException {
        if (r3 == null) goto L7;
        return evaluate(r3, 0, r3.length);
    L7:
        throw new NullArgumentException(LocalizedFormats.INPUT_ARRAY, new Object[0]);
    }

    @Override // org.apache.commons.math3.stat.descriptive.AbstractUnivariateStatistic, org.apache.commons.math3.stat.descriptive.UnivariateStatistic, org.apache.commons.math3.util.MathArrays.Function
    public double evaluate(double[] r2, int r3, int r4) throws MathIllegalArgumentException {
        if (test(r2, r3, r4) == false) goto L6;
        clear();
        incrementAll(r2, r3, r4);
    L6:
        return getResult();
    }

    @Override // org.apache.commons.math3.stat.descriptive.StorelessUnivariateStatistic
    public void incrementAll(double[] r3) throws MathIllegalArgumentException {
        if (r3 == null) goto L7;
        incrementAll(r3, 0, r3.length);
        return;
    L7:
        throw new NullArgumentException(LocalizedFormats.INPUT_ARRAY, new Object[0]);
    }

    @Override // org.apache.commons.math3.stat.descriptive.StorelessUnivariateStatistic
    public void incrementAll(double[] r3, int r4, int r5) throws MathIllegalArgumentException {
        if (test(r3, r4, r5) == false) goto L7;
        int r6 = r5 + r4;
    L5:
        if (r4 >= r6) goto L9;
        increment(r3[r4]);
        r4 = r4 + 1;
        goto L5
    L9:
        return;
    }

    public boolean equals(Object r8) {
        if (r8 != this) goto L6;
        return true;
    L6:
        if ((r8 instanceof AbstractStorelessUnivariateStatistic) == true) goto L8;
        return false;
    L8:
        AbstractStorelessUnivariateStatistic r9 = (AbstractStorelessUnivariateStatistic) r8;
        if (Precision.equalsIncludingNaN(r9.getResult(), getResult()) == false) goto L14;
        if (Precision.equalsIncludingNaN(r9.getN(), getN()) == false) goto L14;
        return true;
    L14:
        return false;
    }

    public int hashCode() {
        return ((MathUtils.hash(getResult()) + 31) * 31) + MathUtils.hash(getN());
    }
}
