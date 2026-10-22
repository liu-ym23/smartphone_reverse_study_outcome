package org.apache.commons.math3.stat.descriptive.moment;

import java.io.Serializable;
import java.util.Arrays;
import org.apache.commons.math3.exception.DimensionMismatchException;

/* JADX INFO: loaded from: classes6.dex */
public class VectorialMean implements Serializable {
    private static final long serialVersionUID = 8223009086481006892L;
    private final Mean[] means;

    public VectorialMean(int r4) {
        this.means = new Mean[r4];
        int r0 = 0;
    L3:
        if (r0 >= r4) goto L5;
        this.means[r0] = new Mean();
        r0 = r0 + 1;
        goto L3
    }

    public void increment(double[] r5) throws DimensionMismatchException {
        if (r5.length != this.means.length) goto L10;
        int r0 = 0;
    L6:
        if (r0 >= r5.length) goto L8;
        this.means[r0].increment(r5[r0]);
        r0 = r0 + 1;
        goto L6
    L8:
        return;
    L10:
        throw new DimensionMismatchException(r5.length, this.means.length);
    }

    public double[] getResult() {
        int r0 = this.means.length;
        double[] r1 = new double[r0];
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L5;
        r1[r2] = this.means[r2].getResult();
        r2 = r2 + 1;
        goto L3
    L5:
        return r1;
    }

    public long getN() {
        Mean[] r2 = this.means;
        if (r2.length != 0) goto L6;
        return 0;
    L6:
        return r2[0].getN();
    }

    public int hashCode() {
        return 31 + Arrays.hashCode(this.means);
    }

    public boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof VectorialMean) == true) goto L9;
        return false;
    L9:
        if (Arrays.equals(this.means, ((VectorialMean) r4).means) == true) goto L11;
        return false;
    L11:
        return true;
    }
}
