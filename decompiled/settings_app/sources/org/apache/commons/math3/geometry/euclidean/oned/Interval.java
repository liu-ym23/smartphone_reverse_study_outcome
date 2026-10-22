package org.apache.commons.math3.geometry.euclidean.oned;

import org.apache.commons.math3.exception.NumberIsTooSmallException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.geometry.partitioning.Region;

/* JADX INFO: loaded from: classes6.dex */
public class Interval {
    private final double lower;
    private final double upper;

    public Interval(double r2, double r4) {
        if (r4 < r2) goto L7;
        this.lower = r2;
        this.upper = r4;
        return;
    L7:
        throw new NumberIsTooSmallException(LocalizedFormats.ENDPOINTS_NOT_AN_INTERVAL, Double.valueOf(r4), Double.valueOf(r2), true);
    }

    public double getInf() {
        return this.lower;
    }

    @Deprecated
    public double getLower() {
        return getInf();
    }

    public double getSup() {
        return this.upper;
    }

    @Deprecated
    public double getUpper() {
        return getSup();
    }

    public double getSize() {
        return this.upper - this.lower;
    }

    @Deprecated
    public double getLength() {
        return getSize();
    }

    public double getBarycenter() {
        return (this.lower + this.upper) * 0.5d;
    }

    @Deprecated
    public double getMidPoint() {
        return getBarycenter();
    }

    public Region.Location checkPoint(double r7, double r9) {
        double r0 = this.lower;
        if (r7 < (r0 - r9)) goto L16;
        double r2 = this.upper;
        if (r7 > (r2 + r9)) goto L16;
        if (r7 <= (r0 + r9)) goto L14;
        if (r7 >= (r2 - r9)) goto L14;
        return Region.Location.INSIDE;
    L14:
        return Region.Location.BOUNDARY;
    L16:
        return Region.Location.OUTSIDE;
    }
}
